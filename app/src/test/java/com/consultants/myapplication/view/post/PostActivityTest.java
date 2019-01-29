package com.consultants.myapplication.view.post;

import android.support.v7.widget.RecyclerView;

import com.consultants.myapplication.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;

import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class PostActivityTest {

    private PostActivity postActivity;

    @Mock
    RecyclerView.LayoutManager mockLayoutManager;

    @Mock
    PostAdapter mockPostAdapter;

    @Before
    public void setUp(){

        postActivity = Robolectric.setupActivity(PostActivity.class);

    }

    @Test
    public void activityExists(){
        assertNotNull(postActivity);
    }

    @Test
    public void defaultDisplay(){

        RecyclerView recyclerView = postActivity.findViewById(R.id.rvMain);
        //RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        //assertThat(layoutManager,mockLayoutManager).isEqualTo(mockLayoutManager);
        recyclerView.setAdapter(mockPostAdapter);
        assertNotNull(recyclerView);

    }

    @Test
    public void onPostReceived() {
    }

    @Test
    public void showError() {
    }
}