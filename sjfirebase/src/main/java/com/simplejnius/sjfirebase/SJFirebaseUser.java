package com.simplejnius.sjfirebase;

import android.net.Uri;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

public class SJFirebaseUser {

    public FirebaseUser get_current_user() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public void update_profile(String name, String photo_url, Object callback) {
        // [START update_profile]
        UserProfileChangeRequest.Builder profile_updates = new UserProfileChangeRequest.Builder();
        UserProfileChangeRequest user_profile_change_request;

        if (photo_url == null) {
            user_profile_change_request = profile_updates.setDisplayName(name).build();
        } else if (name == null) {
            user_profile_change_request = profile_updates.setPhotoUri(Uri.parse(photo_url)).build();
        } else {
            user_profile_change_request = profile_updates.setDisplayName(name)
                    .setPhotoUri(Uri.parse(photo_url))
                    .build();
        }

        get_current_user().updateProfile(user_profile_change_request)
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
        // [END update_profile]
    }

    public void update_email(String email, Object callback) {
        get_current_user().updateEmail(email)
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
    }

    public void send_email_verification(Object callback) {
        // [START send_email_verification]
        get_current_user().sendEmailVerification()
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
        // [END send_email_verification]
    }

    public void send_email_verification_with_continue_url(
            String app_package_name, String url, Object callback) {
        // [START send_email_verification_with_continue_url]
        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl(url)
                .setIOSBundleId(app_package_name)
                // The default for this is populated with the current android package name.
                .setAndroidPackageName(app_package_name, false, null)
                .build();

        get_current_user().sendEmailVerification(actionCodeSettings)
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
    }

    public void send_password_reset_email(String email, Object callback) {
        // [START send_password_reset]
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
        // [END send_password_reset]
    }

    public void deleteUser(Object callback) {
        // [START delete_user]

        get_current_user().delete()
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
        // [END delete_user]
    }

    public void reauthenticate(String email, String password, Object callback) {
        // [START reauthenticate]

        // Get auth credentials from the user for re-authentication. The example below shows
        // email and password credentials but there are multiple possible providers,
        // such as GoogleAuthProvider or FacebookAuthProvider.
        AuthCredential credential = EmailAuthProvider
                .getCredential(email, password);

        // Prompt the user to re-provide their sign-in credentials
        get_current_user().reauthenticate(credential)
                .addOnCompleteListener((OnCompleteListener<Void>) callback);
        // [END reauthenticate]
    }
}
