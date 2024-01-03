# sj-firebase-java

![Build](https://github.com/SimpleJnius/sj-firebase-java/workflows/Pre%20Merge%20Checks/badge.svg)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.simplejnius/sjfirebase.svg)](https://central.sonatype.com/artifact/io.github.simplejnius/sjfirebase)
[![MIT](https://img.shields.io/badge/license-MIT-green)](https://mit-license.org/)
[![Publish Release](https://github.com/SimpleJnius/sj-firebase-java/actions/workflows/publish-release.yaml/badge.svg)](https://github.com/SimpleJnius/sj-firebase-java/actions/workflows/publish-release.yaml)
[![Publish Snapshot](https://github.com/SimpleJnius/sj-firebase-java/actions/workflows/publish-snapshot.yaml/badge.svg)](https://github.com/SimpleJnius/sj-firebase-java/actions/workflows/publish-snapshot.yaml)

Port Firebase Java SDK to Python

## Usage
### Android gradle project
```groovy
implementation 'io.github.simplejnius:sjfirebase:1.0.0'
implementation 'com.google.firebase:firebase-auth'
implementation 'com.google.firebase:firebase-database'
implementation 'com.google.firebase:firebase-firestore'
implementation 'com.google.firebase:firebase-storage'
implementation 'com.google.firebase:firebase-analytics'
```
### Buildozer Android project
```properties
android.gradle_dependencies = io.github.simplejnius:sjfirebase:1.0.0,
    com.google.firebase:firebase-auth,com.google.firebase:firebase-database,
    com.google.firebase:firebase-firestore,com.google.firebase:firebase-storage,
    com.google.firebase:firebase-analytics
```
#### Python(Buildozer) installation
```shell
# pip
pip install sjfirebase

# buildozer.spec
requirements = sjfirebase
```
### Java API
#### SJFirebaseAuthEmail
```java
public class com.simplejnius.sjfirebase.SJFirebaseAuthEmail
```
The entry point of the Firebase Authentication SDK.
First, obtain an instance of this class by calling `get_instance`
(**NOTE** ignore `getInstance` on firebase documentation).

**methods**
- check_user_signed_in
- get_instance
##### Visit [FirebaseAuth Documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth) for more API

#### SJFirebaseDatabase
```java
public class com.simplejnius.sjfirebase.SJFirebaseDatabase
```
The entry point for accessing a Firebase Database. 
You can get an instance by calling getInstance. 
To access a location in the database and read or write data, use `get_ref`
(**NOTE** ignore `getReference` on firebase documentation).

**methods**
- get_db
- get_ref
##### Visit [FirebaseDatabase Documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/database/FirebaseDatabase) for more API

#### SJFirebaseFirestore
```java
public class com.simplejnius.sjfirebase.SJFirebaseFirestore
```

**methods**
- get_db
##### Visit [FirebaseFirestore Documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/firestore/FirebaseFirestore) for more API

#### SJFirebaseUser
```java
public class com.simplejnius.sjfirebase.SJFirebaseUser
```
Represents a user's profile information in your Firebase project's user database. 
It also contains helper methods to change or retrieve profile information, 
as well as to manage that user's authentication state.
(**NOTE** ignore `getCurrentUser` on firebase documentation and use `get_current_user`).

**methods**
- get_current_user
- profile_change_request_builder
##### Visit [FirebaseUser Documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseUser) for more API

#### SJFirebaseStorage
```java
public class com.simplejnius.sjfirebase.SJFirebaseStorage
```
FirebaseStorage is a service that supports uploading and downloading large objects to Google Cloud 
Storage. Pass a custom instance of [FirebaseApp]
(https://firebase.google.com/docs/reference/android/com/google/firebase/FirebaseApp?authuser=0) 
to get_instance which will initialize it with a 
storage location (bucket) specified via [setStorageBucket]
(https://firebase.google.com/docs/reference/android/com/google/firebase/FirebaseOptions.Builder?authuser=0#setStorageBucket(java.lang.String)).

Otherwise, if you call getReference without a FirebaseApp, the FirebaseStorage instance will 
initialize with the default FirebaseApp obtainable from getInstance. 
The storage location in this case will come the JSON configuration file downloaded from the web.
(**NOTE** ignore `getInstance` on firebase documentation and use `get_instance`).

**methods**
- get_instance
##### Visit [FirebaseStorage Documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/storage/FirebaseStorage?authuser=0) for more API