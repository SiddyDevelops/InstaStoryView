package com.siddydevelops.instastoryviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.siddydevelops.instastoryviewexample.RVAdapters.StoryViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView storyViewRV;
    String[] usernameList = {"Siddharth","Christina","Luis Villasmil","Michael Daze","Usman Yousaf"};
    String[] profileImageList = {"https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/me_photo.jpg",
            "https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/christina.jpg",
            "https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/luis_villasmil.jpg",
            "https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/michael_daze.jpg",
            "https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/usman_yousaf.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyViewRV = findViewById(R.id.storyViewRV);
        storyViewRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        storyViewRV.setAdapter(new StoryViewAdapter(usernameList,profileImageList));

    }
}