// Generated by view binder compiler. Do not edit!
package com.example.android.camera2.basic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.android.camera.utils.AutoFitSurfaceView;
import com.example.android.camera2.basic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCameraBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RadioButton AWB;

  @NonNull
  public final RadioButton CLOUDYDAYLIGHT;

  @NonNull
  public final RadioButton DAYLIGHT;

  @NonNull
  public final RadioButton FLUORESCENT;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final CheckBox HDR;

  @NonNull
  public final RadioButton INCANDESCENT;

  @NonNull
  public final RadioButton TWILIGHT;

  @NonNull
  public final RadioButton WARMFLUORESCENT;

  @NonNull
  public final ImageButton captureButton;

  @NonNull
  public final TextView currentExposureTime;

  @NonNull
  public final Button dewarp;

  @NonNull
  public final SeekBar exposureGain;

  @NonNull
  public final SeekBar exposureTime;

  @NonNull
  public final Button hflip;

  @NonNull
  public final View overlay;

  @NonNull
  public final TextView textExposureGain;

  @NonNull
  public final TextView textExposureTime;

  @NonNull
  public final Button vflip;

  @NonNull
  public final AutoFitSurfaceView viewFinder;

  @NonNull
  public final RadioGroup wb;

  private FragmentCameraBinding(@NonNull ConstraintLayout rootView, @NonNull RadioButton AWB,
      @NonNull RadioButton CLOUDYDAYLIGHT, @NonNull RadioButton DAYLIGHT,
      @NonNull RadioButton FLUORESCENT, @Nullable CheckBox HDR, @NonNull RadioButton INCANDESCENT,
      @NonNull RadioButton TWILIGHT, @NonNull RadioButton WARMFLUORESCENT,
      @NonNull ImageButton captureButton, @NonNull TextView currentExposureTime,
      @NonNull Button dewarp, @NonNull SeekBar exposureGain, @NonNull SeekBar exposureTime,
      @NonNull Button hflip, @NonNull View overlay, @NonNull TextView textExposureGain,
      @NonNull TextView textExposureTime, @NonNull Button vflip,
      @NonNull AutoFitSurfaceView viewFinder, @NonNull RadioGroup wb) {
    this.rootView = rootView;
    this.AWB = AWB;
    this.CLOUDYDAYLIGHT = CLOUDYDAYLIGHT;
    this.DAYLIGHT = DAYLIGHT;
    this.FLUORESCENT = FLUORESCENT;
    this.HDR = HDR;
    this.INCANDESCENT = INCANDESCENT;
    this.TWILIGHT = TWILIGHT;
    this.WARMFLUORESCENT = WARMFLUORESCENT;
    this.captureButton = captureButton;
    this.currentExposureTime = currentExposureTime;
    this.dewarp = dewarp;
    this.exposureGain = exposureGain;
    this.exposureTime = exposureTime;
    this.hflip = hflip;
    this.overlay = overlay;
    this.textExposureGain = textExposureGain;
    this.textExposureTime = textExposureTime;
    this.vflip = vflip;
    this.viewFinder = viewFinder;
    this.wb = wb;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCameraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_camera, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCameraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AWB;
      RadioButton AWB = rootView.findViewById(id);
      if (AWB == null) {
        break missingId;
      }

      id = R.id.CLOUDY_DAYLIGHT;
      RadioButton CLOUDYDAYLIGHT = rootView.findViewById(id);
      if (CLOUDYDAYLIGHT == null) {
        break missingId;
      }

      id = R.id.DAYLIGHT;
      RadioButton DAYLIGHT = rootView.findViewById(id);
      if (DAYLIGHT == null) {
        break missingId;
      }

      id = R.id.FLUORESCENT;
      RadioButton FLUORESCENT = rootView.findViewById(id);
      if (FLUORESCENT == null) {
        break missingId;
      }

      CheckBox HDR = rootView.findViewById(R.id.HDR);

      id = R.id.INCANDESCENT;
      RadioButton INCANDESCENT = rootView.findViewById(id);
      if (INCANDESCENT == null) {
        break missingId;
      }

      id = R.id.TWILIGHT;
      RadioButton TWILIGHT = rootView.findViewById(id);
      if (TWILIGHT == null) {
        break missingId;
      }

      id = R.id.WARM_FLUORESCENT;
      RadioButton WARMFLUORESCENT = rootView.findViewById(id);
      if (WARMFLUORESCENT == null) {
        break missingId;
      }

      id = R.id.capture_button;
      ImageButton captureButton = rootView.findViewById(id);
      if (captureButton == null) {
        break missingId;
      }

      id = R.id.current_exposure_time;
      TextView currentExposureTime = rootView.findViewById(id);
      if (currentExposureTime == null) {
        break missingId;
      }

      id = R.id.dewarp;
      Button dewarp = rootView.findViewById(id);
      if (dewarp == null) {
        break missingId;
      }

      id = R.id.exposure_gain;
      SeekBar exposureGain = rootView.findViewById(id);
      if (exposureGain == null) {
        break missingId;
      }

      id = R.id.exposure_time;
      SeekBar exposureTime = rootView.findViewById(id);
      if (exposureTime == null) {
        break missingId;
      }

      id = R.id.hflip;
      Button hflip = rootView.findViewById(id);
      if (hflip == null) {
        break missingId;
      }

      id = R.id.overlay;
      View overlay = rootView.findViewById(id);
      if (overlay == null) {
        break missingId;
      }

      id = R.id.text_exposure_gain;
      TextView textExposureGain = rootView.findViewById(id);
      if (textExposureGain == null) {
        break missingId;
      }

      id = R.id.text_exposure_time;
      TextView textExposureTime = rootView.findViewById(id);
      if (textExposureTime == null) {
        break missingId;
      }

      id = R.id.vflip;
      Button vflip = rootView.findViewById(id);
      if (vflip == null) {
        break missingId;
      }

      id = R.id.view_finder;
      AutoFitSurfaceView viewFinder = rootView.findViewById(id);
      if (viewFinder == null) {
        break missingId;
      }

      id = R.id.wb;
      RadioGroup wb = rootView.findViewById(id);
      if (wb == null) {
        break missingId;
      }

      return new FragmentCameraBinding((ConstraintLayout) rootView, AWB, CLOUDYDAYLIGHT, DAYLIGHT,
          FLUORESCENT, HDR, INCANDESCENT, TWILIGHT, WARMFLUORESCENT, captureButton,
          currentExposureTime, dewarp, exposureGain, exposureTime, hflip, overlay, textExposureGain,
          textExposureTime, vflip, viewFinder, wb);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
