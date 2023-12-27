package com.simplejnius.sjfirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SJFirebaseUser {

    public static FirebaseUser get_current_user() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public static UserProfileChangeRequest.Builder profile_change_request_builder() {
        return new UserProfileChangeRequest.Builder();
    }
}
