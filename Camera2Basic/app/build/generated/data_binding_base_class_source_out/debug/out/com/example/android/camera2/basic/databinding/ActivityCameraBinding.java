// Generated by view binder compiler. Do not edit!
package com.example.android.camera2.basic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

import com.example.android.camera2.basic.R;

public final class ActivityCameraBinding implements ViewBinding {
    @NonNull private final FragmentContainerView rootView;

    @NonNull public final FragmentContainerView fragmentContainer;

    private ActivityCameraBinding(
            @NonNull FragmentContainerView rootView,
            @NonNull FragmentContainerView fragmentContainer) {
        this.rootView = rootView;
        this.fragmentContainer = fragmentContainer;
    }

    @Override
    @NonNull
    public FragmentContainerView getRoot() {
        return rootView;
    }

    @NonNull
    public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    @NonNull
    public static ActivityCameraBinding inflate(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_camera, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    @NonNull
    public static ActivityCameraBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }

        FragmentContainerView fragmentContainer = (FragmentContainerView) rootView;

        return new ActivityCameraBinding((FragmentContainerView) rootView, fragmentContainer);
    }
}
