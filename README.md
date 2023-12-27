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
The current version of [python-for-android](https://github.com/kivy/python-for-android) lacks support for incorporating bom dependencies, modifying the classpath, and copying the `google-service.json`. To address this limitation, a fork of python-for-android has been developed to include these functionalities. To implement these changes in your `buildozer.spec` file, make adjustments to the specified section using the provided values below:
```properties
android.gradle_dependencies = io.github.simplejnius:sjfirebase:1.0.0,
    com.google.firebase:firebase-auth,com.google.firebase:firebase-database,
    com.google.firebase:firebase-firestore,com.google.firebase:firebase-storage,
    com.google.firebase:firebase-analytics
p4a.fork = SimpleJnius
p4a.branch = firebase
```
**Important Note:** Upon creating an Android project within your [Firebase Console](https://firebase.google.com), ensure to transfer the `google-service.json` file to the same location as your `main.py` file.
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
Represents a user's profile information in your Firebase project's user database. 
It also contains helper methods to change or retrieve profile information, 
as well as to manage that user's authentication state.
(**NOTE** ignore `getCurrentUser` on firebase documentation and use `get_current_user`).

**methods**
- get_current_user
- profile_change_request_builder
##### Visit [FirebaseUser Documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseUser) for more API
