package com.simplejnius.sjfirebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SJFirebaseDatabase {
    public static FirebaseDatabase get_db() {
        return FirebaseDatabase.getInstance();
    }

    public static DatabaseReference get_ref() {
        return get_db().getReference();
    }
}
