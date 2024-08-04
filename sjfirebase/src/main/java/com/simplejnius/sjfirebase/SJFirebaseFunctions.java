package com.simplejnius.sjfirebase;

import com.google.firebase.functions.FirebaseFunctions;

public class SJFirebaseFunctions {
    public static FirebaseFunctions get_instance() {
        return FirebaseFunctions.getInstance();
    }
}
