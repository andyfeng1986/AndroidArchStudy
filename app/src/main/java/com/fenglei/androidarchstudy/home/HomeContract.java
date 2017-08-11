package com.fenglei.androidarchstudy.home;

import com.fenglei.commonsdk.BasePresenter;
import com.fenglei.commonsdk.BaseView;

/**
 * Created by fenglei on 17-8-11.
 */

public interface HomeContract {

    interface HomeView extends BaseView<HomePresenter> {

        void showData();

        void showError(String reason);

        void showLoading();

    }

    interface HomePresenter extends BasePresenter {

        void getData();

    }

}
