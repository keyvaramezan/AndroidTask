package com.java.androidtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /*TextView txtCall = findViewById(R.id.txtCall);
        txtCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+9821818313755"));
                startActivity(intent);
            }
        });
        TextView txtProfile = findViewById(R.id.txtProfile);
        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/
        ArrayList<String> listItems = new ArrayList<>();
        listItems.add("Dial Phone");
        listItems.add("Edite Profile");
        RecyclerView recycler = findViewById(R.id.recycleView);
        TestAdapter adapter = new TestAdapter(listItems);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(MenuActivity.this,
                RecyclerView.VERTICAL,false));

        TextView txtName = findViewById(R.id.txtName);
        TextView txtLastName = findViewById(R.id.txtLastName);
        TextView txtEmail = findViewById(R.id.txtEmail);
        TextView txtPhone = findViewById(R.id.txtPhone);
        String name = PreferenceManager.getDefaultSharedPreferences(MenuActivity.this)
                .getString("name", "Unknown name");
        String lastName = PreferenceManager.getDefaultSharedPreferences(MenuActivity.this)
                .getString("lastName", "Unknown last name");
        String email = PreferenceManager.getDefaultSharedPreferences(MenuActivity.this)
                .getString("email", "Unknown emale address");
        String phone = PreferenceManager.getDefaultSharedPreferences(MenuActivity.this)
                .getString("phone", "Unknown phone number");
        txtName.setText(name);
        txtLastName.setText(lastName);
        txtEmail.setText(email);
        txtPhone.setText(phone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.firstItem:
                DrawerLayout drawerLayout = findViewById(R.id.drawerMenu);
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
