package com.haripriya.bakingapp;

import com.haripriya.bakingapp.Utils.NetworkUtils;
import com.haripriya.bakingapp.models.RecipeList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestaInterface {

    @GET(NetworkUtils.JSON_LOC)
    Call<List<RecipeList>> getJSON();
}
