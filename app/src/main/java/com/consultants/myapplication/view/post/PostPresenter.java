package com.consultants.myapplication.view.post;

import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import java.util.List;

public class PostPresenter implements PostContract.Presenter{

    PostContract.View view;
    RemoteDataSource remoteDataSource;
    private static final String TAG = PostPresenter.class.getSimpleName() + "_TAG";
    

    public PostPresenter(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getPosts() {

        remoteDataSource.getPostsRx(new RemoteDataSource.DataCallback() {
            @Override
            public void onSuccess(List<Post> posts) {
                view.onPostReceived(posts);
                Log.d(TAG, "onSuccess: ");
            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: ");
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
