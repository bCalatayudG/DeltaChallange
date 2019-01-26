package com.consultants.myapplication.view.post;

import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subscribers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PostPresenterTest {

    @Mock
    RemoteDataSource remoteDataSource;

    @Mock
    PostContract.View view;

    //@Mock
    PostPresenter presenter;

    @Mock
    RemoteDataSource.DataCallback dataCallback;
    private Post expectedPost;

    @Before
    public void setUp() throws Exception {

        expectedPost = new Post(1, 2, "a", "b");
        MockitoAnnotations.initMocks(this);

        presenter = new PostPresenter(remoteDataSource);

    }

    @Test
    public void testObservable() {

        //when(remoteDataSource.getPostsRx());
//        when(presenter.getPosts());
        //when(remoteDataSource.getPosts(dataCallback));
        //doNothing().when(presenter.getPosts()).thenReturn();

        //doNothing().when(remoteDataSource).getPostsRx(dataCallback);
//        doReturn(expectedPost).when(remoteDataSource).getPostsRx(dataCallback);
        doThrow(new Exception()).when(remoteDataSource).getPostitsRx(dataCallback);

        doReturn(expectedPost).when(presenter).getPosts();
//        when(presenter.getPosts()).thenReturn();

        TestSubscriber<List<Post>> listTestSubscriber = TestSubscriber.create();
        //listTestSubscriber.onComplete();
        listTestSubscriber.hasSubscription();
        listTestSubscriber.assertNotSubscribed();

//        remoteDataSource.getPostsRx;
    }

    //amantat@gmail.com




    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPosts() {
    }

    @Test
    public void attachView() {
    }

    @Test
    public void voidView() {
    }
}