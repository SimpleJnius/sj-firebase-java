package com.simplejnius.sjfirebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;

public class SJFirebaseStorage {
    public static FirebaseStorage get_instance() {
        return FirebaseStorage.getInstance();
    }

    public static FirebaseStorage get_instance(String url) {
        return FirebaseStorage.getInstance(url);
    }

    public static FirebaseStorage get_instance(FirebaseApp app) {
        return FirebaseStorage.getInstance(app);
    }

    public static FirebaseStorage get_instance(FirebaseApp app, String url) {
        return FirebaseStorage.getInstance(app, url);
    }
}
