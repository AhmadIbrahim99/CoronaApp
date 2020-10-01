package com.example.coronaapp.MainCorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.coronaapp.Profile.LogIn;
import com.example.coronaapp.Profile.Profile;
import com.example.coronaapp.Profile.Register;
import com.example.coronaapp.R;

public class VideoAboutCorona extends AppCompatActivity {


    String url;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_about_corona);


        getSupportActionBar().setTitle("فيديو حول كورونا");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        MediaController mediaController = new MediaController(this);

        videoView = findViewById(R.id.vid);

        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        url = "https://firebasestorage.googleapis.com/v0/b/coronaapp-3d600.appspot.com/o/%D9%81%D9%8A%D8%B1%D9%88%D8%B3%20%D9%83%D9%88%D8%B1%D9%88%D9%86%D8%A7%20%D8%A7%D9%84%D9%85%D8%B3%D8%AA%D8%AC%D8%AF%20%D9%88%D8%A7%D9%84%D9%88%D8%A8%D8%A7%D8%A1%20%D8%A7%D9%84%D8%B9%D8%A7%D9%84%D9%85%D9%8A%20%D9%81%D9%8A%D8%AF%D9%8A%D9%88%20%D8%AA%D9%88%D8%B9%D9%88%D9%8A%20%D9%84%D9%84%D9%85%D8%AC%D8%AA%D9%85%D8%B9.mp4?alt=media&token=34a61f2e-c418-4ed4-a16d-4b72422c0938";
        Uri uri = Uri.parse(url); //from Storage we get the video
        videoView.setVideoURI(uri);
        videoView.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tracker:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return true;
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                return true;
            case R.id.regiser:
                startActivity(new Intent(getApplicationContext(), Register.class));
                return true;
            case R.id.advice:
                startActivity(new Intent(getApplicationContext(), AdviceCorona.class));
                return true;
            case R.id.login:
                startActivity(new Intent(getApplicationContext(), LogIn.class));
                return true;
            case R.id.videoCorona:
                startActivity(new Intent(getApplicationContext(), VideoAboutCorona.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
