package com.simplejnius.sjfirebase;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

import java.util.concurrent.TimeUnit;

public class SJFirebaseAuthPhone {
    private static final String TAG = "AuthPhone";
    private static FirebaseAuth m_auth;

    public static FirebaseAuth get_instance() {
        m_auth = FirebaseAuth.getInstance();
        return m_auth;
    }
    public static void startPhoneNumberVerification(
            String phone_number,
            Long timeout,
            @NonNull Activity activity,
            OnVerificationStateChangedCallbacks callbacks
    ) {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(get_instance())
                .setPhoneNumber(phone_number)
                .setTimeout(timeout, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(callbacks)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    public static void resendVerificationCode(
            String phone_number,
            Long timeout,
            @NonNull Activity activity,
            OnVerificationStateChangedCallbacks callbacks,
            PhoneAuthProvider.ForceResendingToken token
    ) {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(get_instance())
                .setPhoneNumber(phone_number)
                .setTimeout(timeout, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(callbacks)
                .setForceResendingToken(token)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    public static PhoneAuthCredential verifyPhoneNumberWithCode(String verificationId, String code) {
        return PhoneAuthProvider.getCredential(verificationId, code);
    }
}
