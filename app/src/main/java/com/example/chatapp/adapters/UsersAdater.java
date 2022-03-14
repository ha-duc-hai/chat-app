package com.example.chatapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.databinding.ItemContainerUserBinding;
import com.example.chatapp.models.User;

import java.util.List;

public class UsersAdater extends RecyclerView.Adapter<UsersAdater.UserViewHolder> {
    private final List<User> users;

    public UsersAdater(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerUserBinding itemContainerUserBinding =ItemContainerUserBinding.inflate(
                LayoutInflater.from(parent,getItemCount()),
                parent,
                false
        );
        return new UserViewHolder(itemContainerUserBinding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserdata(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        UserViewHolder(com.example.chatapp.databinding.ItemContainerUserBinding){
            super();
        }
        void setUserdata(User user)

    }
    private Bitmap getUserImage(String encodeImage){
        byte[] bytes = Base64.decode(encodeImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
