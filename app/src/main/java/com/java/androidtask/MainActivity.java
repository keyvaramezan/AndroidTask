package com.java.androidtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            }
        });
    }
}
