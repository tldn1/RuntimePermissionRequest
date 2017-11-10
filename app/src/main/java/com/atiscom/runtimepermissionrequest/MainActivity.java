package com.atiscom.runtimepermissionrequest;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_PERM_REQ = 100;
    public static final int STORAGE_PERM_REQ = 999;
    public static final int CONTACTS_PERM_REQ = 777;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestAll(View view) {

    }

    public void requestCamera(View view) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Camera...");
                builder.setMessage("Camera permission");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CAMERA}, CAMERA_PERM_REQ);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, CAMERA_PERM_REQ);
            }

        }
    }

    public void requestStorage(View view) {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Storage...");
                builder.setMessage("Storage permission");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERM_REQ);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERM_REQ);
            }

        }
    }

    public void requestContacts(View view) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Read contacts...");
                builder.setMessage("Read contacts permission");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_CONTACTS}, CONTACTS_PERM_REQ);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS}, CONTACTS_PERM_REQ);
            }
        }
    }


}
