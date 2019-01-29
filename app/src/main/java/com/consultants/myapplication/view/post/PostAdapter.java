package com.consultants.myapplication.view.post;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.consultants.myapplication.R;
import com.consultants.myapplication.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> postList;

    PostAdapter(){
        postList =  new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = getLayout(viewGroup);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Post post = postList.get(i);
        viewHolder.tvTitle.setText("Title: "+ post.getTitle());
    }

    public void setPostList(List<Post> posts){
        postList = posts;
    }

    public View getLayout(ViewGroup parent){
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void notifyItemChanged(){
        notifyDataSetChanged();
    }

    public Post getItemAtPosition(int i) {
        return postList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
