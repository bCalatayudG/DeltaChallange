package com.consultants.myapplication.view.post;

import android.support.v7.widget.RecyclerView;

import com.consultants.myapplication.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class PostActivityTest {

    @Mock
    PostAdapter mockPostAdapter;

    private PostActivity postActivity;

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
        recyclerView.setAdapter(mockPostAdapter);
        assertNotNull(recyclerView);

    }

}