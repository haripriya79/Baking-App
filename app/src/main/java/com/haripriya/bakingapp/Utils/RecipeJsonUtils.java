package com.haripriya.bakingapp.Utils;



import android.util.Log;

import com.haripriya.bakingapp.models.IngredientsList;
import com.haripriya.bakingapp.models.RecipeList;
import com.haripriya.bakingapp.models.RecipeStepsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class  RecipeJsonUtils {
    private static final  String ID = "id";
    private static final String Name = "name";
    //declarations for ingredients list
    private static final String Ingredients = "ingredients";
    private  static final String Quantity = "quantity";
    private static final String Measure = "measure";
    private static final String Ingredient = "ingredient";
    //declarations for steps list
    private static final String Steps = "steps";
    private static final String ShortDescription = "shortDesciption";
    private static final String Description = "description";
    private static final String VideoUrl = "videoUrl";
    private static final String ThumnailUrl = "thumbnailUrl";

    public static List<RecipeList> parseMovieJson(String json) throws JSONException {
        List<RecipeList> mList = new ArrayList<>();
        List<IngredientsList> mIngredientList;
        List<RecipeStepsList> mStepsList;
        RecipeList mRecipe;
        IngredientsList mIngredients;
        RecipeStepsList mSteps;
        //Log.i("json", json);


        JSONArray ListObject = new JSONArray(json);
        for (int i = 0 ; i < ListObject.length(); i ++){

           JSONObject jRecipeList = ListObject.getJSONObject(i);
            mIngredientList = new ArrayList<>();
            mStepsList = new ArrayList<>();

           JSONArray jIngredients = jRecipeList.getJSONArray(Ingredients);
           Log.i("ingredientsList", String.valueOf(jIngredients.length()));
           //to get the list of ingredients from a recipe
            for( int j = 0 ; j<jIngredients.length();j++){
                JSONObject jIngredientObject = jIngredients.getJSONObject(j);
                mIngredients = new IngredientsList(jIngredientObject.optDouble(Quantity),
                        jIngredientObject.optString(Measure),
                        jIngredientObject.optString(Ingredient));
                Log.i("ingredients", mIngredients.getIngredient());

                mIngredientList.add(mIngredients);
            }

            JSONArray jStepList = jRecipeList.getJSONArray(Steps);
            //to get the steps list from recipe
            for (int k=0;k<jStepList.length();k++){
                JSONObject jSteps =  jStepList.getJSONObject(k);
                mSteps = new RecipeStepsList(jSteps.optInt(ID),
                        jSteps.optString(ShortDescription),
                        jSteps.optString(Description),
                        jSteps.optString(VideoUrl),jSteps.optString(ThumnailUrl));
                mStepsList.add(mSteps);

            }

            mRecipe = new RecipeList(jRecipeList.optInt(ID),
                    jRecipeList.optString(Name),
                    mIngredientList,
                    mStepsList);

            mList.add(mRecipe);



        }
     return  mList;
    }
}
