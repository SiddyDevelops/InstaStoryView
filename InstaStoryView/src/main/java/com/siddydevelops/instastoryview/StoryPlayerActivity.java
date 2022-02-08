package com.siddydevelops.instastoryview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.shts.android.storiesprogressview.StoriesProgressView;

public class StoryPlayerActivity extends AppCompatActivity implements StoriesProgressView.StoriesListener {

    private  String[] ImageURls;
    private String username;
    private String userProfile;
    private String[] storyTimes;
    private String[] likeCounts;
    private String[] storyText;

    long pressTime = 0L;
    long limit = 500L;

    Class cls;

    private StoriesProgressView storiesProgressView;
    private ImageView image;

    private CircleImageView profileImage;
    private TextView usernameTV;
    private TextView storyTimeTV;
    private TextView likeCountTV;
    private TextView storyTTV;

    private int counter = 0;

    private final View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    // on action down when we press our screen
                    // the story will pause for specific time.
                    pressTime = System.currentTimeMillis();

                    // on below line we are pausing our indicator.
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:

                    // in action up case when user do not touches
                    // screen this method will skip to next image.
                    long now = System.currentTimeMillis();

                    // on below line we are resuming our progress bar for status.
                    storiesProgressView.resume();

                    // on below line we are returning if the limit < now - presstime
                    return limit < now - pressTime;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story_player);
        // inside in create method below line is use to make a full screen.

        //Initializing Variables through intent
        Initializing();

        // on below line we are initializing our variables.
        storiesProgressView = (StoriesProgressView) findViewById(R.id.stories);

        // on below line we are setting the total count for our stories.
        storiesProgressView.setStoriesCount(ImageURls.length);

        // on below line we are setting story duration for each story.
        storiesProgressView.setStoryDuration(3000L);

        // on below line we are calling a method for set
        // on story listener and passing context to it.
        storiesProgressView.setStoriesListener(this);

        // below line is use to start stories progress bar.
        storiesProgressView.startStories(counter);

        // initializing our image view.
        image = (ImageView) findViewById(R.id.image);

        profileImage = findViewById(R.id.profile_image);
        usernameTV = findViewById(R.id.usernameTV);
        storyTimeTV = findViewById(R.id.storyTimeTV);
        likeCountTV = findViewById(R.id.likeCountTV);
        storyTTV = findViewById(R.id.storyTTV);

        // on below line we are setting image to our image view.
        glideImage(ImageURls[counter],username,storyTimes[counter],likeCounts[counter],storyText[counter]);

        // below is the view for going to the previous story.
        // initializing our previous view.
        View reverse = findViewById(R.id.reverse);

        // adding on click listener for our reverse view.
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inside on click we are
                // reversing our progress view.
                storiesProgressView.reverse();
            }
        });

        // on below line we are calling a set on touch
        // listener method to move towards previous image.
        reverse.setOnTouchListener(onTouchListener);

        // on below line we are initializing
        // view to skip a specific story.
        View skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inside on click we are
                // skipping the story progress view.
                storiesProgressView.skip();
            }
        });
        // on below line we are calling a set on touch
        // listener method to move to next story.
        skip.setOnTouchListener(onTouchListener);
    }

    @Override
    public void onNext() {
        // this method is called when we move
        // to next progress view of story.
        glideImage(ImageURls[++counter],username,storyTimes[counter],likeCounts[counter],storyText[counter]);
    }

    @Override
    public void onPrev() {

        // this method id called when we move to previous story.
        // on below line we are decreasing our counter
        if ((counter - 1) < 0) return;
        glideImage(ImageURls[--counter],username,storyTimes[counter],likeCounts[counter],storyText[counter]);

        // on below line we are setting image to image view
    }

    @Override
    public void onComplete() {
        // when the stories are completed this method is called.
        // in this method we are moving back to initial main activity.
        Intent i = new Intent(StoryPlayerActivity.this, cls);
        startActivity(i);
        finish();
    }

    @Override
    protected void onDestroy() {
        // in on destroy method we are destroying
        // our stories progress view.
        storiesProgressView.destroy();
        super.onDestroy();
    }

    private void glideImage(String URL,String username, String time, String like, String storyText)
    {
        Glide.with(this).load(userProfile).into(profileImage);

        Glide.with(this)
                .load(URL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Toast.makeText(StoryPlayerActivity.this, "Failed to load image.", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(image);

        usernameTV.setText(username);
        storyTimeTV.setText(time);
        likeCountTV.setText(like);
        storyTTV.setText(storyText);

    }

    public void Initializing()
    {
        cls = (Class) getIntent().getSerializableExtra("ClassName");
        ImageURls = getIntent().getStringArrayExtra("IMAGEURLS");
        username = getIntent().getStringExtra("USERNAME");
        userProfile = getIntent().getStringExtra("USERPROFILE");
        storyTimes = getIntent().getStringArrayExtra("STORYTIMES");
        likeCounts = getIntent().getStringArrayExtra("LIEKCOUNT");
        storyText = getIntent().getStringArrayExtra("STORYTEXT");
    }
}