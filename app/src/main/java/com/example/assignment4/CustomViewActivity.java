package com.example.assignment4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomViewActivity extends AppCompatActivity {
    private ListView Clistview;
    private  String[] SName;
    Integer[] imgid= {R.drawable.instagram, R.drawable.linkedin, R.drawable.messenger, R.drawable.snapchat,
            R.drawable.telegram, R.drawable.threads, R.drawable.twitter, R.drawable.whatsapp, R.drawable.youtube};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_view);

      SName = getResources().getStringArray(R.array.Social_Media_array);
        Clistview = findViewById(R.id.CustomlistView);

        SocialMediaAdapter adapter = new SocialMediaAdapter(this, SName, imgid);

        Clistview.setAdapter(adapter);

      Clistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
              String value = SName[position];
              Toast.makeText(CustomViewActivity.this, value, Toast.LENGTH_SHORT).show();
          }
      });
    }
}