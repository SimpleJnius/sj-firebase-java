package com.simplejnius.sjfirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SJFirebaseAuthEmail {
    private static final String TAG = "EmailPassword";
    private static FirebaseAuth m_auth;

    public static FirebaseAuth get_instance() {
        m_auth = FirebaseAuth.getInstance();
        return m_auth;
    }

    public static boolean check_user_signed_in() {
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser current_user = m_auth.getCurrentUser();
        if(current_user != null){
            current_user.reload();
            return true;
        }
        return false;
    }
}
