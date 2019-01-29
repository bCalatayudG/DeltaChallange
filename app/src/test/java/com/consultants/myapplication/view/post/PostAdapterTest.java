package com.consultants.myapplication.view.post;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultants.myapplication.R;
import com.consultants.myapplication.model.Post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class PostAdapterTest {


    @Mock
    Post post;

    @Mock
    ViewGroup viewGroup;

    private PostAdapter postAdapter;

    private PostAdapter.ViewHolder viewHolder;

    @Mock
    View mockView;

    @Before
    public void setUp() {
        //PostActivity postActivity = Robolectric.setupActivity(PostActivity.class);
        MockitoAnnotations.initMocks(this);
        postAdapter = new PostAdapter();
        //TextView tvTitle = postActivity.findViewById(R.id.tvTitle);
        postAdapter.setPostList(Arrays.asList(post, post, post));
    }
    
    @Test
    public void onBindViewHolder() {

        LayoutInflater inflater = (LayoutInflater) RuntimeEnvironment.application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView = inflater.inflate(R.layout.post_item, null, false);
        viewHolder = new PostAdapter.ViewHolder(listItemView);
        postAdapter.onBindViewHolder(viewHolder, 0);

        //assertNotNull(viewHolder.tvTitle);
    }

    @Test
    public void getItemCount() {
        assertEquals(3, postAdapter.getItemCount());
    }

    @Test
    public void test_getItemAtPosition(){
        Post post1 = new Post(1,1,"title","body");
        Post post2 = new Post(2,2,"title2","body2");

        postAdapter.setPostList(Arrays.asList(post1,post2));

        assertEquals(post1,postAdapter.getItemAtPosition(0));
        assertEquals(post2,postAdapter.getItemAtPosition(1));
    }


    @Test
    public void test_onCreateViewHolder(){
        TestablePostAdapter testablePostAdapter = new TestablePostAdapter();
        testablePostAdapter.setMockView(mockView);
        viewHolder = testablePostAdapter.onCreateViewHolder(new LinearLayout(RuntimeEnvironment.application),0);
        assertEquals(mockView,viewHolder.itemView);

    }

    static class TestablePostAdapter extends PostAdapter {
        public View mockView;

        public void setMockView(View mockView) {
            this.mockView = mockView;
        }

        @Override
        public View getLayout(ViewGroup parent) {
            return mockView;
        }
    }
}