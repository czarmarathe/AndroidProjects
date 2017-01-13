package com.sarthak_marathe.intents_clicklisteners;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent_display;
        intent_display = getIntent();

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(intent_display.getIntExtra("position",0));
        final String website = intent_display.getStringExtra("site");
        setContentView(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse = new Intent();
                browse.setAction(Intent.ACTION_VIEW);

                browse.setData(Uri.parse(website));
                startActivity(browse);
            }
        });


    }
}