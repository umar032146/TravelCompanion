// Generated by view binder compiler. Do not edit!
package com.example.travelcompanion.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.travelcompanion.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ForgetpasswordBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button resetbtn;

  @NonNull
  public final EditText resetemail;

  private ForgetpasswordBinding(@NonNull LinearLayout rootView, @NonNull Button resetbtn,
      @NonNull EditText resetemail) {
    this.rootView = rootView;
    this.resetbtn = resetbtn;
    this.resetemail = resetemail;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ForgetpasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ForgetpasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.forgetpassword, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ForgetpasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.resetbtn;
      Button resetbtn = ViewBindings.findChildViewById(rootView, id);
      if (resetbtn == null) {
        break missingId;
      }

      id = R.id.resetemail;
      EditText resetemail = ViewBindings.findChildViewById(rootView, id);
      if (resetemail == null) {
        break missingId;
      }

      return new ForgetpasswordBinding((LinearLayout) rootView, resetbtn, resetemail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
