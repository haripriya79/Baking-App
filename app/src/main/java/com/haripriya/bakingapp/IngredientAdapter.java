package com.haripriya.bakingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haripriya.bakingapp.models.RecipeList;

import com.haripriya.bakingapp.R;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {
    Context context;
    RecipeList recipeList;
    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForListItem = R.layout.ingredients_list;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);


        return new IngredientViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        if(recipeList.getmIngredients().size()==0||recipeList==null ){
            return -1;
                    }

        Log.i("size of ingredient", String.valueOf(recipeList.getmIngredients().size()));
        return recipeList.getmIngredients().size();
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder{
        TextView mingredient;
        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            mingredient = itemView.findViewById(R.id.tv_ingredients);
        }

        public void bind(int position) {
            mingredient.setText(recipeList.getmIngredients().get(position).getIngredient());

        }
    }
    public  void setIngredientData(RecipeList mrecipe){
        recipeList = mrecipe;
        notifyDataSetChanged();
    }
}
