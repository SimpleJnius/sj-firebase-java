package com.simplejnius.sjfirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import java.util.concurrent.Executor;

public class SJFirebaseAuthEmail {
    private static final String TAG = "EmailPassword";
    private FirebaseAuth m_auth;

    public FirebaseAuth get_instance() {
        m_auth = FirebaseAuth.getInstance();
        return m_auth;
    }

    public String get_uid() {
        return m_auth.getUid();
    }

    public boolean check_user_signed_in() {
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser current_user = m_auth.getCurrentUser();
        if(current_user != null){
            current_user.reload();
            return true;
        }
        return false;
    }

    public void create_user_with_email_and_password(
            String email, String password, Object callback) {
        m_auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, (OnCompleteListener<AuthResult>) callback);
    }

    public void sign_in_with_email_and_password(String email, String password, Object callback) {
        m_auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, (OnCompleteListener<AuthResult>) callback);
    }
}
