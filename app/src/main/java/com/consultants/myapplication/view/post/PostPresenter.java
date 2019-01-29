package com.consultants.myapplication.view.post;

import android.support.annotation.VisibleForTesting;

import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import java.util.List;

public class PostPresenter implements PostContract.Presenter{

    PostContract.View view;
    RemoteDataSource remoteDataSource;

    public PostPresenter(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getPosts() {

        remoteDataSource.getPostsRx(new RemoteDataSource.DataCallback() {
            @Override
            public void onSuccess(List<Post> posts) {
                view.onPostReceived(posts);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);
            }
        });

    }

    @Override
    public void attachView(PostContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
