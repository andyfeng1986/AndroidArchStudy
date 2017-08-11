package com.fenglei.androidarchstudy.home;

/**
 * Created by fenglei on 17-8-11.
 */

public class HomePresenterImpl implements HomeContract.HomePresenter {

    private HomeContract.HomeView mHomeView;

    public HomePresenterImpl(HomeContract.HomeView homeView) {
        mHomeView = homeView;
    }

    @Override
    public void getData() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

}
