package com.consultants.myapplication.model.data;

import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.consultants.myapplication.model.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RemoteDataSource {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String TAG = RemoteDataSource.class.getSimpleName() + "_TAG";


    private Retrofit createRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private Retrofit createRetrofitRx() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Call<List<Post>> getPostCall() {

        return createRetrofit().create(RemoteService.class).getPosts();
    }

    private Observable<List<Post>> getPostCallRx() {
        return createRetrofitRx().create(RemoteService.class).getPostsRx();
    }

    public void getPosts(final DataCallback dataCallback) {

        getPostCall().enqueue(new Callback<List<Post>>() {
            @Override
            @VisibleForTesting
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                dataCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                dataCallback.onFailure(t.getMessage());

            }
        });
    }

    public void getPostsRx(final DataCallback dataCallback) {

        getPostCallRx()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        dataCallback.onSuccess(posts);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dataCallback.onFailure(e.toString());

                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    //can be in a separate class as well if added more verbs
    private interface RemoteService{

        @GET("posts")
        Call<List<Post>> getPosts();

        @GET("posts")
        Observable<List<Post>> getPostsRx();
    }

    public interface DataCallback{

        void onSuccess(List<Post> posts);

        void onFailure(String error);
    }
}
