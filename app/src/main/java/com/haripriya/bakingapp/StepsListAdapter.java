package com.haripriya.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haripriya.bakingapp.models.RecipeStepsList;

import java.util.List;

import com.haripriya.bakingapp.R;

public class StepsListAdapter extends RecyclerView.Adapter<StepsListAdapter.StepsViewHolder> {
    private Context context;
    private List<RecipeStepsList> mStepsList;
    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForListItem = R.layout.recipe_list;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        StepsViewHolder viewHolder = new StepsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder holder, int position) {
        holder.bind(position);/*
        mStepsList = mLIst.get(position).getmSteps();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StepsListActivity.class);
                intent.putExtra("recipe", (Parcelable) mStepsList);
                context.startActivity(intent);

            }
        });*/

    }

    @Override
    public int getItemCount() {
        if (mStepsList == null || mStepsList.size() == 0) {
            return -1;
        }

        return mStepsList.size();
    }

    public class StepsViewHolder extends RecyclerView.ViewHolder {
        TextView mTextStepsView;
        public StepsViewHolder(@NonNull View itemView) {
            super(itemView);
           // mTextStepsView = itemView.findViewById(R.id.tv_steps_list);
        }

        public void bind(int position) {
            mTextStepsView.setText(mStepsList.get(position).getShortdescription());
        }
    }
    public void setStepsData(List<RecipeStepsList> recipeList) {
        mStepsList = recipeList;
        notifyDataSetChanged();
    }
}



