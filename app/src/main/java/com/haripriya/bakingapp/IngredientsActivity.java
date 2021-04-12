package com.haripriya.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haripriya.bakingapp.models.RecipeList;

import com.haripriya.bakingapp.R;
import com.haripriya.bakingapp.databinding.ActivityIngredientsBinding;

public class IngredientsActivity extends AppCompatActivity {
    RecipeList mRecipe;
    RecyclerView mRecycler;
    IngredientAdapter mAdapter;
    private ActivityIngredientsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_ingredients);
        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        mRecipe = intent.getParcelableExtra("recipe");
        Log.i("got intent",mRecipe.getmIngredients().get(1).getIngredient());

        binding.recyleIngredientsList.setHasFixedSize(true);
        LinearLayoutManager mLinear = new LinearLayoutManager(this);
        binding.recyleIngredientsList.setLayoutManager(mLinear);
        mAdapter = new IngredientAdapter();
        binding.recyleIngredientsList.setAdapter(mAdapter);
        mAdapter.setIngredientData(mRecipe);

    }

    private void closeOnError() {

        Log.i("intent get","empty intent");
    }
}