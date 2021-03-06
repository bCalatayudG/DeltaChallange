package com.consultants.myapplication.view.post;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.consultants.myapplication.R;
import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import java.util.List;

public class PostActivity extends AppCompatActivity implements PostContract.View{

    private PostPresenter presenter;
    private PostAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMain = findViewById(R.id.rvMain);
        postAdapter = new PostAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvMain.setAdapter(postAdapter);
        rvMain.setLayoutManager(layoutManager);
        RemoteDataSource remoteDataSource = new RemoteDataSource();
        presenter = new PostPresenter(remoteDataSource);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.getPosts();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void onPostReceived(List<Post> posts) {
        postAdapter.setPostList(posts);
        postAdapter.notifyItemChanged();
    }

    @Override
    public void showError(String error) {

    }
}
