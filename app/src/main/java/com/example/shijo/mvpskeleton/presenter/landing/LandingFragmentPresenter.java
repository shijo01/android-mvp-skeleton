package com.example.shijo.mvpskeleton.presenter.landing;

import com.example.shijo.mvpskeleton.presenter.base.BasePresenter;

/**
 * Created by Shijo on 23/02/18.
 */

public class LandingFragmentPresenter<V extends LandingFragmentMvpView> extends BasePresenter<V> implements LandingFragmentMvpPresenter<V> {
    @Override
    public void calculateSum(int a, int b) {
        int sum = a + b;
        getMvpView().showSum(sum);
    }
}
