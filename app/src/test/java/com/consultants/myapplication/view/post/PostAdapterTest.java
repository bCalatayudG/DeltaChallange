package com.consultants.myapplication.view.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.consultants.myapplication.R;
import com.consultants.myapplication.model.Post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class PostAdapterTest {


    @Mock
    private
    Post post;

    @Mock
    private
    View mockView;

    private PostAdapter postAdapter;

    private PostAdapter.ViewHolder viewHolder;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        postAdapter = new PostAdapter();
        postAdapter.setPostList(Arrays.asList(post, post, post));

    }

    @Test
    public void onBindViewHolder() {

        LayoutInflater inflater = (LayoutInflater) RuntimeEnvironment.application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView = inflater.inflate(R.layout.post_item, null, false);
        viewHolder = new PostAdapter.ViewHolder(listItemView);
        postAdapter.onBindViewHolder(viewHolder, 0);

    }

    @Test
    public void getItemCount() {

        assertEquals(3, postAdapter.getItemCount());

    }

    @Test
    public void test_getItemAtPosition() {

        Post post1 = new Post(1, 1, "title", "body");
        Post post2 = new Post(2, 2, "title2", "body2");

        postAdapter.setPostList(Arrays.asList(post1, post2));

        assertEquals(post1, postAdapter.getItemAtPosition(0));
        assertEquals(post2, postAdapter.getItemAtPosition(1));

    }


    @Test
    public void test_onCreateViewHolder() {

        TestablePostAdapter testablePostAdapter = new TestablePostAdapter();
        testablePostAdapter.setMockView(mockView);
        viewHolder = testablePostAdapter.onCreateViewHolder(new LinearLayout(RuntimeEnvironment.application), 0);
        assertEquals(mockView, viewHolder.itemView);

    }

    static class TestablePostAdapter extends PostAdapter {

        View mockView;

        void setMockView(View mockView) {

            this.mockView = mockView;

        }

        @Override
        public View getLayout(ViewGroup parent) {

            return mockView;

        }
    }
}