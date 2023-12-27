package com.simplejnius.sjfirebase;

import com.google.firebase.firestore.FirebaseFirestore;

public class SJFirebaseFirestore {
    public static FirebaseFirestore get_db() {
        return FirebaseFirestore.getInstance();
    }
}
