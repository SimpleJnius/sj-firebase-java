package com.simplejnius.sjfirebase.callback;

import androidx.annotation.NonNull;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.FirebaseException;
import androidx.annotation.NonNull;


interface VerificationStateChangeCallback {
    public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token);
    public void onVerificationCompleted(@NonNull PhoneAuthCredential credential);
    public void onVerificationFailed(@NonNull FirebaseException e);
}
