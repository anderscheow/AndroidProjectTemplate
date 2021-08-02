// Generated by view binder compiler. Do not edit!
package com.example.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.common.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ViewNetworkStateBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton buttonRetry;

  @NonNull
  public final AppCompatImageView imageViewLoading;

  @NonNull
  public final MaterialTextView textViewMessage;

  private ViewNetworkStateBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton buttonRetry, @NonNull AppCompatImageView imageViewLoading,
      @NonNull MaterialTextView textViewMessage) {
    this.rootView = rootView;
    this.buttonRetry = buttonRetry;
    this.imageViewLoading = imageViewLoading;
    this.textViewMessage = textViewMessage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewNetworkStateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewNetworkStateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.view_network_state, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewNetworkStateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_retry;
      MaterialButton buttonRetry = ViewBindings.findChildViewById(rootView, id);
      if (buttonRetry == null) {
        break missingId;
      }

      id = R.id.image_view_loading;
      AppCompatImageView imageViewLoading = ViewBindings.findChildViewById(rootView, id);
      if (imageViewLoading == null) {
        break missingId;
      }

      id = R.id.text_view_message;
      MaterialTextView textViewMessage = ViewBindings.findChildViewById(rootView, id);
      if (textViewMessage == null) {
        break missingId;
      }

      return new ViewNetworkStateBinding((ConstraintLayout) rootView, buttonRetry, imageViewLoading,
          textViewMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
