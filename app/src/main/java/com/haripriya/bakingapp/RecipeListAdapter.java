package com.haripriya.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.haripriya.bakingapp.models.RecipeList;

import java.util.List;

import com.haripriya.bakingapp.R;
import com.haripriya.bakingapp.databinding.RecipeListBinding;


public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{

    private List<RecipeList> mLIst;
    Context context;

    public RecipeListAdapter(List<RecipeList> mRecipeList){
        mLIst = mRecipeList;

    }
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecipeListBinding binding = DataBindingUtil.inflate(inflater, R.layout.recipe_list, parent, false);
        return new RecipeViewHolder(binding.getRoot());


    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, final int position) {
        holder.bind(position);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IngredientsActivity.class);
                intent.putExtra("recipe", mLIst.get(position));
                context.startActivity(intent);


            }
        });



    }

    @Override
    public int getItemCount() {
        if (mLIst == null || mLIst.size() == 0) {
            return -1;
        }

        return mLIst.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{
        RecipeListBinding binding ;
        TextView mRecipeName;
        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }

        public void bind(int position) {
            binding.tvRecipe.setText(mLIst.get(position).getRecipeName());

        }
    }

}
