package com.example.janco.contactbackup;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by janco on 24.04.2017.
 */
public class FileMenager {



    public void writeExternalStorage(ArrayList contacts){
        String con;
        String state;
        state= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File dir = new File(root.getPath()+"/contacts");
            if(!dir.exists()){
                dir.mkdir();
            }
            System.out.println(root.getPath());
            File file = new File(dir,"contacts.txt");

            try{
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                for (Object contact:contacts){
                    con=contact.toString()+"\n";
                    fileOutputStream.write(con.getBytes() );
                    System.out.println(contact.toString()+"\n");
                }
                fileOutputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
