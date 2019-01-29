package com.consultants.myapplication.view.post;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.consultants.myapplication.R;
import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import java.util.List;

public class PostActivity extends AppCompatActivity implements PostContract.View{

    private PostPresenter presenter;
    private RemoteDataSource remoteDataSource;
    private static final String TAG = PostActivity.class.getSimpleName() + "_TAG";
    private PostAdapter postAdapter;
    private RecyclerView rvMain;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        postAdapter = new PostAdapter();

        layoutManager = new LinearLayoutManager(this);

        rvMain.setAdapter(postAdapter);
        rvMain.setLayoutManager(layoutManager);
        remoteDataSource = new RemoteDataSource();
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
