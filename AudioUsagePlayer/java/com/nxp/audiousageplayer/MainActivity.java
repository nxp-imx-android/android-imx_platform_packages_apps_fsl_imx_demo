/*
 * Copyright 2019 NXP
 */
package com.nxp.audiousageplayer;

import android.content.pm.PackageManager;
import android.widget.Toast;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.os.AsyncTask;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver;

import java.util.HashMap;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import android.os.Environment;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends Activity {
    private static final String TAG="AudioUsagePlayer";
    FileInputStream inputStream = null;
    private static final int WAV_HEAD_SIZE = 44;
    AudioTrack mTrack = null;
    private static final int rate_offset = 24;
    private static final int chn_offset = 22;
    private static final int bits_offset = 34;
    int rate = 48000;
    byte bits = 16;
    byte chans = 2;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        byte[] head = new byte[WAV_HEAD_SIZE];
        int read = 0;

         // get parameters
        Bundle extras = this.getIntent ( ).getExtras ( );
        String strFile = "music.wav";

        if((extras != null) && extras.containsKey("file")) {
            strFile = extras.getString("file");
        }

        try {
          inputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), strFile));
        } catch(Exception ex) {
          ex.printStackTrace();
        }

        try {
          read = inputStream.read(head);
        } catch(Exception ex) {
          ex.printStackTrace();
        }

        if(!((head[0] == 'R') && (head[1] == 'I') && (head[2] == 'F') && (head[3] == 'F'))) {
          Log.e(TAG, "error RIFF");
          return;
        }

        if(!((head[8] == 'W') && (head[9] == 'A') && (head[10] == 'V') && (head[11] == 'E'))) {
          Log.e(TAG, "error WAVE");
          return;
        }

        rate = (int)(head[rate_offset] & 0x0FF) +
              ((int)(head[rate_offset+1] & 0x0FF) << 8) +
              ((int)(head[rate_offset+2] & 0x0FF) << 16) +
              ((int)(head[rate_offset+3] & 0x0FF) << 24);

        bits = head[bits_offset];
        chans = head[chn_offset];

        int usage = 1; // AudioAttributes.USAGE_MEDIA;
        String strUsage = "1";
        if((extras != null) && extras.containsKey("usage")) {
            strUsage = extras.getString("usage");
            usage = Integer.valueOf(strUsage).intValue();
        }

        boolean bLoop = false;
        if((extras != null) && extras.containsKey("loop"))
          bLoop = true;

        Log.i(TAG, "rate " + rate + ", bits " + bits + ", chans " + chans + ", usage " + usage + ", bLoop " + bLoop);

        if(!((head[0] == 'R') && (head[1] == 'I') && (head[2] == 'F') && (head[3] == 'F'))) {
          Log.e(TAG, "error RIFF");
          return;
        }

        if(!((head[8] == 'W') && (head[9] == 'A') && (head[10] == 'V') && (head[11] == 'E'))) {
          Log.e(TAG, "error WAVE");
          return;
        }

        int AudioFmtChn;
        int AudioFmtBits;
        if(chans == 1)
          AudioFmtChn = AudioFormat.CHANNEL_IN_MONO;
        else if(chans == 2)
           AudioFmtChn = AudioFormat.CHANNEL_IN_STEREO;
        else if(chans == 6)
            AudioFmtChn = AudioFormat.CHANNEL_OUT_5POINT1;
        else if(chans == 8)
            AudioFmtChn = AudioFormat.CHANNEL_OUT_7POINT1;
        else {
            Log.e(TAG, "unsupported channel num " + chans + ", treat as stereo");
            AudioFmtChn = AudioFormat.CHANNEL_IN_STEREO;
        }

        if(bits == 8)
          AudioFmtBits = AudioFormat.ENCODING_PCM_8BIT;
        else if(bits == 16)
          AudioFmtBits = AudioFormat.ENCODING_PCM_16BIT;
        else if(bits == 32)
          AudioFmtBits = AudioFormat. ENCODING_PCM_FLOAT;
        else {
            Log.e(TAG, "unsupported bits " + bits + ", treat as 16 bits");
            AudioFmtBits = AudioFormat.ENCODING_PCM_16BIT;
        }

        int minBufSize = AudioTrack.getMinBufferSize(rate, AudioFmtChn, AudioFmtBits);
        byte[] mediaBuffer = new byte[minBufSize];


        mTrack = new AudioTrack(
                        new AudioAttributes.Builder()
                                .setUsage(usage)
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build(),
                        new AudioFormat.Builder()
                                .setSampleRate(rate)
                                .setEncoding(AudioFmtBits)
                                .setChannelMask(AudioFmtChn).build(),

                        minBufSize,
                        AudioTrack.MODE_STREAM,
                        AudioManager.AUDIO_SESSION_ID_GENERATE);

        Log.i(TAG, "Start playback " + strFile);

        int written = 0;
        mTrack.play();

        while (true) {
            try {
                read = inputStream.read(mediaBuffer);
            } catch(Exception ex) {
                ex.printStackTrace();
            }

            if (read <= 0) {
                Log.i(TAG, "meet EOF");
                if(bLoop) {
                    Log.i(TAG, "loop again");
                    try {
                        inputStream.getChannel().position(WAV_HEAD_SIZE);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    continue;
                }

                break;
            }

            written = mTrack.write(mediaBuffer, 0, read);
            if (written <= 0) {
                Log.i(TAG, "mTrack.write " + read + " bytes failed, written " + written);
                break;
            }

        }

        Log.i(TAG, "Done playing");

        try {
            inputStream.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        mTrack.stop();
        mTrack.release();
    }
}
