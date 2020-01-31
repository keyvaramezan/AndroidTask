package com.java.androidtask;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtLastName = findViewById(R.id.edtLastName);
        final EditText edtEamil = findViewById(R.id.edtEmail);
        final EditText edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Attention!")
                        .setMessage("Are you sure?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = edtName.getText().toString();
                                String lastName = edtLastName.getText().toString();
                                String emailAddress = edtEamil.getText().toString();
                                String phoneNumber = edtPhoneNumber.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit()
                                        .putString("name", name).apply();
                                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit()
                                        .putString("lastName", lastName).apply();
                                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit()
                                        .putString("email", emailAddress).apply();
                                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit()
                                        .putString("phone", phoneNumber).apply();
                                Toast.makeText(MainActivity.this, "Your data was saved", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You Choose No", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Remind me later", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You Choose Remind me later", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                dialog.show();
            }
        });
    }
}
