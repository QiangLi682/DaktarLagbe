package com.mhutshow.daktarlagbe.model.fireStoreApi;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.mhutshow.daktarlagbe.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserHelper {
    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    static CollectionReference UsersRef = db.collection("User");
    static User CurrentUser;
    public static void addUser(String name, String adresse, String tel,String type){
        User user = new User(name,adresse,tel,FirebaseAuth.getInstance().getCurrentUser().getEmail(),type);
        UsersRef.document(FirebaseAuth.getInstance().getCurrentUser().getEmail()).set(user);

    }
    public static void setCurrentUser(User user){
        CurrentUser = user;
    }
    public static User getCurrentUser(){
        return CurrentUser;
    }
}
