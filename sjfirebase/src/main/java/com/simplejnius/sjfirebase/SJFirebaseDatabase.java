package com.simplejnius.sjfirebase;

import com.google.firebase.database.FirebaseDatabase;

public class SJFirebaseDatabase {
    public FirebaseDatabase get_db() {
        return FirebaseDatabase.getInstance();
    }
}
