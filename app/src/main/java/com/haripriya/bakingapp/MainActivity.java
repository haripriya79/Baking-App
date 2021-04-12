package com.haripriya.bakingapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haripriya.bakingapp.Utils.NetworkUtils;
import com.haripriya.bakingapp.Utils.RecipeJsonUtils;
import com.haripriya.bakingapp.models.RecipeList;

import java.net.URL;
import java.util.List;


import com.haripriya.bakingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecycler;
    RecipeListAdapter mAdapter;
    private ActivityMainBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        context = this;

        binding.recyleRecipeList.setHasFixedSize(true);
        GridLayoutManager mGrid = new GridLayoutManager(this, 1);
        binding.recyleRecipeList.setLayoutManager(mGrid);


        //fetching the json data
      /*  mAdapter = new RecipeListAdapter();
        mRecycler.setAdapter(mAdapter);*/


        new FetchRecipeTask().execute();




    }
    public class FetchRecipeTask extends AsyncTask<Void, Void, List<RecipeList>> {




        @Override
        protected List<RecipeList> doInBackground(Void... voids) {
            URL RecipeRequestUrl = NetworkUtils.buildUrl();
            try {
                String jsonResponse = NetworkUtils
                        .getResponseFromHttpUrl(RecipeRequestUrl);

                List<RecipeList> JsonData = RecipeJsonUtils.parseMovieJson(jsonResponse);
                return JsonData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(List<RecipeList> recipeLists) {
            mAdapter = new RecipeListAdapter(recipeLists);
            binding.recyleRecipeList.setAdapter(mAdapter);
        }
    }
    }


