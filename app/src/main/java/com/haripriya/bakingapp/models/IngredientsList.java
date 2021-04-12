package com.haripriya.bakingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class IngredientsList implements Parcelable {
    private double quantity;
    private String measure;
    private String ingredient;

    public IngredientsList(double quantity, String measure, String ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    protected IngredientsList(Parcel in) {
        quantity = in.readDouble();
        measure = in.readString();
        ingredient = in.readString();
    }

    public static final Creator<IngredientsList> CREATOR = new Creator<IngredientsList>() {
        @Override
        public IngredientsList createFromParcel(Parcel in) {
            return new IngredientsList(in);
        }

        @Override
        public IngredientsList[] newArray(int size) {
            return new IngredientsList[size];
        }
    };

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(quantity);
        dest.writeString(measure);
        dest.writeString(ingredient);
    }
}
