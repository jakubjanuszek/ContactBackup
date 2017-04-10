package com.example.janco.contactbackup;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactProvider contactProvider=new ContactProvider();
        ArrayList<Contact> contacts = contactProvider.getListContacts(this);

        if (contacts == null){
            System.out.println(path);
        }
    }
}
