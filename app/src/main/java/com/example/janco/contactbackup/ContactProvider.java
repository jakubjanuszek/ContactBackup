package com.example.janco.contactbackup;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janco on 10.04.2017.
 */

public class ContactProvider {

    public ArrayList<Contact> getListContacts(Context context){
        ArrayList<Contact> contacts = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            int nameIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int phoneNumberIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            cursor.moveToFirst();
            do {
                String name = cursor.getString(nameIdx);
                String phoneNumber = cursor.getString(phoneNumberIdx);
                System.out.println(name+" "+phoneNumber);
                Contact contact = new Contact(name,phoneNumber);
                contacts.add(contact);
            } while (cursor.moveToNext());

            return contacts;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

}
