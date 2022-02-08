package com.siddydevelops.instastoryview;

import android.content.Context;
import android.content.Intent;

public class InstaStoryViewer {

    private final Context context;
    private final Class cls;

    private final String[] ImageURls;
    private final String usernames;
    private final String userProfile;
    private final String[] storyTimes;
    private final String[] likeCounts;
    private final String[] storyText;

    public InstaStoryViewer(Context context, Class cls, String[] imageURls, String usernames, String userProfile, String[] storyTimes, String[] likeCounts, String[] storyText) {
        this.context = context;
        this.cls = cls;
        ImageURls = imageURls;
        this.usernames = usernames;
        this.userProfile = userProfile;
        this.storyTimes = storyTimes;
        this.likeCounts = likeCounts;
        this.storyText = storyText;
    }

    public void showStory()
    {
        Intent intent = new Intent(context, StoryPlayerActivity.class);
        intent.putExtra("ClassName",cls);
        intent.putExtra("IMAGEURLS",ImageURls);
        intent.putExtra("USERNAME",usernames);
        intent.putExtra("USERPROFILE",userProfile);
        intent.putExtra("STORYTIMES",storyTimes);
        intent.putExtra("LIEKCOUNT",likeCounts);
        intent.putExtra("STORYTEXT",storyText);
        context.startActivity(intent);
    }

}
