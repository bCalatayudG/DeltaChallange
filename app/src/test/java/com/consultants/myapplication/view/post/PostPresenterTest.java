package com.consultants.myapplication.view.post;

import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.verify;

public class PostPresenterTest {

    @Mock
    RemoteDataSource remoteDataSource;

    @Mock
    PostContract.View view;

    @Mock
    RemoteDataSource.DataCallback dataCallback;

    PostPresenter presenter;

    private Post expectedPost;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        expectedPost = new Post(1, 2, "a", "b");
        presenter = new PostPresenter(remoteDataSource);
        presenter.attachView(view);
    }

    @Test
    public void verify_getPosts() {

        remoteDataSource.getPostsRx(dataCallback);

        presenter.view.onPostReceived(Collections.singletonList(expectedPost));
        verify(view, Mockito.only()).onPostReceived(Collections.singletonList(expectedPost));

    }

    @Test
    public void attachView() {
        assertNotNull(presenter.view);
    }

    @Test
    public void voidView() {
        presenter.detachView();
        assertNull(presenter.view);
    }

    @After
    public void tearDown() {
        presenter.detachView();
    }
}