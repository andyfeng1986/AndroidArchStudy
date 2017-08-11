package com.fenglei.androidarchstudy.home;

import android.app.Activity;
import android.os.Bundle;

import com.fenglei.androidarchstudy.R;

public class MainActivity extends Activity implements HomeContract.HomeView {

    private HomeContract.HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mHomePresenter = new HomePresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHomePresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHomePresenter.unsubscribe();
    }

    @Override
    public void showData() {

    }

    @Override
    public void showError(String reason) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void setPresenter(HomeContract.HomePresenter presenter) {
        mHomePresenter = presenter;
    }

}
