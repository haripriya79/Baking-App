package com.haripriya.bakingapp.models;

import android.os.Parcel;
import android.os.Parcelable;


public class RecipeStepsList implements Parcelable {
    private int id;
    private String shortdescription;
    private String description;
    private  String videoUrl ;
    private  String thumbnailUrl;

    public RecipeStepsList(int id, String shortdescription, String description, String videoUrl, String thumbnailUrl) {
        this.id = id;
        this.shortdescription = shortdescription;
        this.description = description;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    protected RecipeStepsList(Parcel in) {
        id = in.readInt();
        shortdescription = in.readString();
        description = in.readString();
        videoUrl = in.readString();
        thumbnailUrl = in.readString();
    }

    public static final Creator<RecipeStepsList> CREATOR = new Creator<RecipeStepsList>() {
        @Override
        public RecipeStepsList createFromParcel(Parcel in) {
            return new RecipeStepsList(in);
        }

        @Override
        public RecipeStepsList[] newArray(int size) {
            return new RecipeStepsList[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(shortdescription);
        dest.writeString(description);
        dest.writeString(videoUrl);
        dest.writeString(thumbnailUrl);
    }
}
