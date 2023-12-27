package com.simplejnius.sjfirebase;

import android.net.Uri;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SJFirebaseUser {

    public static FirebaseUser get_current_user() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public static void update_profile(String name, String photo_url, OnCompleteListener<Void> callback) {
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
                .addOnCompleteListener(callback);
        // [END update_profile]
    }

    public static void update_email(String email, OnCompleteListener<Void> callback) {
        get_current_user().updateEmail(email)
                .addOnCompleteListener(callback);
    }

    public static void send_email_verification(OnCompleteListener<Void> callback) {
        // [START send_email_verification]
        get_current_user().sendEmailVerification()
                .addOnCompleteListener(callback);
        // [END send_email_verification]
    }

    public static void send_email_verification_with_continue_url(
            String app_package_name, String url, OnCompleteListener<Void> callback) {
        // [START send_email_verification_with_continue_url]
        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl(url)
                .setIOSBundleId(app_package_name)
                // The default for this is populated with the current android package name.
                .setAndroidPackageName(app_package_name, false, null)
                .build();

        get_current_user().sendEmailVerification(actionCodeSettings)
                .addOnCompleteListener(callback);
    }

    public static void send_password_reset_email(String email, OnCompleteListener<Void> callback) {
        // [START send_password_reset]
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(callback);
        // [END send_password_reset]
    }

    public static void deleteUser(OnCompleteListener<Void> callback) {
        // [START delete_user]

        get_current_user().delete()
                .addOnCompleteListener(callback);
        // [END delete_user]
    }

    public static void reauthenticate(String email, String password, OnCompleteListener<Void> callback) {
        // [START reauthenticate]

        // Get auth credentials from the user for re-authentication. The example below shows
        // email and password credentials but there are multiple possible providers,
        // such as GoogleAuthProvider or FacebookAuthProvider.
        AuthCredential credential = EmailAuthProvider
                .getCredential(email, password);

        // Prompt the user to re-provide their sign-in credentials
        get_current_user().reauthenticate(credential)
                .addOnCompleteListener(callback);
        // [END reauthenticate]
    }
}
