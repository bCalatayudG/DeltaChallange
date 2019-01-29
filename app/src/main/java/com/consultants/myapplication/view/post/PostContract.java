package com.consultants.myapplication.view.post;

import com.consultants.myapplication.model.Post;
import com.consultants.myapplication.view.base.BasePresenter;
import com.consultants.myapplication.view.base.BaseView;

import java.util.List;

public class PostContract  {


    interface View extends BaseView {

        void onPostReceived(List<Post> posts);
    }

    interface Presenter extends BasePresenter<View> {

        void getPosts();

    }


}
