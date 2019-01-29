package com.consultants.myapplication.view.post;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.consultants.myapplication.R;
import com.consultants.myapplication.model.Post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

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

    @Mock
    PostAdapter.ViewHolder viewHolder;

    @Before
    public void setUp() {
        PostActivity postActivity = Robolectric.setupActivity(PostActivity.class);
        postAdapter = new PostAdapter();
        TextView tvTitle = postActivity.findViewById(R.id.tvTitle);

    }


    @Test
    public void onBindViewHolder() {
        assertNotNull(viewHolder.tvTitle);
    }

    @Test
    public void getItemCount() {
        postAdapter.setPostList(Arrays.asList(post, post, post));
        assertEquals(3, postAdapter.getItemCount());

    }
}