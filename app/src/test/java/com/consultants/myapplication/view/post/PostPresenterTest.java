package com.consultants.myapplication.view.post;

import android.os.Looper;

import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.model.data.RemoteDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subscribers.TestSubscriber;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.notNull;
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

    //@Mock
    //AndroidSchedulers androidSchedulers;

    @Before
    public void setUp() throws Exception {

        expectedPost = new Post(1, 2, "a", "b");
        MockitoAnnotations.initMocks(this);

        presenter = new PostPresenter(remoteDataSource);

        presenter.attachView(view);

    }

    @Test
    public void testObservable() {

//        when(remoteDataSource.getPostsRx());
//        when(presenter.getPosts());
//        when(remoteDataSource.getPosts(dataCallback));
//        doNothing().when(presenter.getPosts()).thenReturn();
//
//        doNothing().when(remoteDataSource).getPostsRx(dataCallback);
//        doReturn(expectedPost).when(remoteDataSource).getPostsRx(dataCallback);
//        doThrow().when(remoteDataSource).getPostsRx(dataCallback);
//
//        doReturn(expectedPost).when(presenter).getPosts();
//        when(presenter.getPosts()).thenReturn();
//
//        TestSubscriber<List<Post>> listTestSubscriber = TestSubscriber.create();
//        listTestSubscriber.onComplete();
//        listTestSubscriber.hasSubscription();
//        listTestSubscriber.assertNotSubscribed();
//
//        remoteDataSource.getPostsRx;
//
//
//
//        TestSubscriber<List<String>> listTestSubscriber = new TestSubscriber<>();
//        Observable observable = remoteDataSource.getPostCallRx();
//        observable.subscribe(listTestSubscriber);
//
//        observable.subscribeOn(AndroidSchedulers.from())
//                .subscribeOn(Schedulers.io())
//                .subscribe((Observer) listTestSubscriber);
//
//        listTestSubscriber.assertComplete();
//        listTestSubscriber.assertNoErrors();
//


//        when(remoteDataSource.getPostCallRx()).thenReturn(expectedPost);
//        presenter.getPosts();
//        Mockito.verify(view,Mockito.only()).onPostReceived(Collections.singletonList(expectedPost));

        //presenter.getPosts();
        remoteDataSource.getPostsRx(dataCallback);
        presenter.view.onPostReceived(Collections.singletonList(expectedPost));
        verify(view,Mockito.only()).onPostReceived(Collections.singletonList(expectedPost));
    }

    //amantat@gmail.com

    @After
    public void tearDown() throws Exception {
        presenter.detachView();
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