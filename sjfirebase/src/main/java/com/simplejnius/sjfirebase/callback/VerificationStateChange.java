package com.simplejnius.sjfirebase.callback;

import com.google.firebase.auth.PhoneAuthProvider;
import androidx.annotation.NonNull;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.FirebaseException;


public class VerificationStateChange extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    public static VerificationStateChangeCallback callback = null;

    public void setCallback(VerificationStateChangeCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
        // This callback will be invoked in two situations:
        // 1 - Instant verification. In some cases the phone number can be instantly
        //     verified without needing to send or enter a verification code.
        // 2 - Auto-retrieval. On some devices Google Play services can automatically
        //     detect the incoming verification SMS and perform verification without
        //     user action.

        callback.onVerificationCompleted(credential);
    }

    @Override
    public void onVerificationFailed(@NonNull FirebaseException e) {
        // This callback is invoked in an invalid request for verification is made,
        // for instance if the the phone number format is not valid.

        callback.onVerificationFailed(e);

        // Show a message and update the UI
    }

    @Override
    public void onCodeSent(@NonNull String verificationId,
                           @NonNull PhoneAuthProvider.ForceResendingToken token) {
        // The SMS verification code has been sent to the provided phone number, we
        // now need to ask the user to enter the code and then construct a credential
        // by combining the code with a verification ID.

        callback.onCodeSent(verificationId, token);
    }
}
