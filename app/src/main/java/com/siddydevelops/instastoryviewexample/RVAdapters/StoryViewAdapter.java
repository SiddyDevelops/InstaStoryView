package com.siddydevelops.instastoryviewexample.RVAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.siddydevelops.instastoryview.InstaStoryViewer;
import com.siddydevelops.instastoryviewexample.MainActivity;
import com.siddydevelops.instastoryviewexample.R;

public class StoryViewAdapter extends RecyclerView.Adapter<StoryViewAdapter.StoryViewHolder> {

    String[] usernameList;
    String[] profileImageList;
    public StoryViewAdapter(String[] usernameList, String[] profileImageList) {
        this.usernameList = usernameList;
        this.profileImageList = profileImageList;
    }

    //STORY ITEMS
    private final String[] ImageURls0 = {"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/11.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/41.png",
            "https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg"};
    private final String username0 = "Siddharth Singh";
    private final String userProfile0 = "https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/me_photo.jpg";
    private final String[] storyTimes0 = {"15hr Ago", "8hr Ago", "9hr Ago"};
    private final String[] likeCounts0 = {"22K", "257", "6.8K"};
    private final String[] storyText0 = {"New Pokemon now live!", "Gather tonight for the latest event by AC/DC", "People around the world are crazy!"};

    private final String[] ImageURls1 = {"https://www.kolpaper.com/wp-content/uploads/2020/11/Aesthetic-Mobile-Wallpaper-2.jpg",
            "https://www.enjpg.com/img/2020/4k-mobile-7.jpg"};
    private final String username1 = "Christina";
    private final String userProfile1 = "https://raw.githubusercontent.com/SiddyDevelops/Blogaro/main/Assets/Profile-Images/christina.jpg";
    private final String[] storyTimes1 = {"2hr Ago", "15hr Ago"};
    private final String[] likeCounts1 = {"59.6K", "2.7K"};
    private final String[] storyText1 = {"Crypto Reaching Heights!", "RED Moon appeared in Northern America."};


    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.story_item_layout,parent,false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        holder.username.setText(usernameList[position]);
        Glide.with(holder.itemView.getContext()).load(profileImageList[position]).into(holder.profileImageStory);
        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.getAdapterPosition() == 0)
                {
                    InstaStoryViewer instaStoryViewer = new InstaStoryViewer(view.getContext(), MainActivity.class,ImageURls0,username0,userProfile0,storyTimes0,likeCounts0,storyText0);
                    instaStoryViewer.showStory();
                }
                if(holder.getAdapterPosition() == 1)
                {
                    InstaStoryViewer instaStoryViewer = new InstaStoryViewer(view.getContext(), MainActivity.class,ImageURls1,username1,userProfile1,storyTimes1,likeCounts1,storyText1);
                    instaStoryViewer.showStory();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return usernameList.length;
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView username;
        FrameLayout frameLayout;
        ImageView profileImageStory;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            frameLayout = itemView.findViewById(R.id.frameLayout);
            profileImageStory = itemView.findViewById(R.id.profileImageStory);
        }
    }

}

