package com.appers.myretrofitapicall.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appers.myretrofitapicall.databinding.RandomItemLayoutBinding;
import com.appers.myretrofitapicall.model.RandomResponse;
import com.appers.myretrofitapicall.model.Users;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.RandomViewHolder>{
private List<Users> users;

    public RandomAdapter(List<Users> users) {
        this.users = users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RandomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RandomItemLayoutBinding binding=RandomItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
return new RandomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomViewHolder holder, int position) {
Users user =users.get(position);
holder.binding.userNameTextview.setText(user.getName().toString().trim());
Glide.with(holder.binding.getRoot())
        .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
        .load(user.getPicture())
        .into(holder.binding.posterImageview);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class RandomViewHolder extends RecyclerView.ViewHolder{
RandomItemLayoutBinding binding;
        public RandomViewHolder(RandomItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
