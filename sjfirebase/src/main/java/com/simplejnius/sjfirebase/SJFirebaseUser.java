package com.simplejnius.sjfirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SJFirebaseUser {
    private FirebaseUser current_user;

    public FirebaseUser get_current_user() {
        current_user = FirebaseAuth.getInstance().getCurrentUser();
        return current_user;
    }
}
