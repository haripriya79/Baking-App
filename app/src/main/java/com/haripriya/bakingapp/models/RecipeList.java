package com.haripriya.bakingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RecipeList implements Parcelable {
    private int id ;
    private String recipeName;
    private List<IngredientsList> mIngredients;
    private List<RecipeStepsList> mSteps;
    public RecipeList(){}

    public RecipeList(int id, String recipeName, List<IngredientsList> mIngredients, List<RecipeStepsList> mSteps) {
        this.id = id;
        this.recipeName = recipeName;
        this.mIngredients = mIngredients;
        this.mSteps = mSteps;
    }

    protected RecipeList(Parcel in) {
        id = in.readInt();
        recipeName = in.readString();
        mIngredients = in.createTypedArrayList( IngredientsList.CREATOR);
        mSteps = in.createTypedArrayList(RecipeStepsList.CREATOR);

    }

    public static final Creator<RecipeList> CREATOR = new Creator<RecipeList>() {
        @Override
        public RecipeList createFromParcel(Parcel in) {
            return new RecipeList(in);
        }

        @Override
        public RecipeList[] newArray(int size) {
            return new RecipeList[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<IngredientsList> getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(List<IngredientsList> mIngredients) {
        this.mIngredients = mIngredients;
    }

    public List<RecipeStepsList> getmSteps() {
        return mSteps;
    }

    public void setmSteps(List<RecipeStepsList> mSteps) {
        this.mSteps = mSteps;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(recipeName);
        dest.writeTypedList(mIngredients);
        dest.writeTypedList(mSteps);
    }
}
