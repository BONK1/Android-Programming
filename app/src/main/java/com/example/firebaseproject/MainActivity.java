package com.example.firebaseproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore fstore;
    private final String fullName = "ADVAITH";
    private final String email = "advaith.n.aithal1998@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        fstore = FirebaseFirestore.getInstance();
        int rand_int1 = rand.nextInt(100000);
        Map<String, Object> user = new HashMap<>();
        user.put("fName", fullName);
        user.put("femail", email);
        user.put("fphoneno", rand_int1);
        fstore.collection("users").document(rand_int1 + "").set(user).addOnSuccessListener(aVoid -> Log.d("Success!", "onSuccess: user Profile is created!"));
    }
}