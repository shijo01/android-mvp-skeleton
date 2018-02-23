package com.example.shijo.mvpskeleton.presenter.landing;

import com.example.shijo.mvpskeleton.presenter.base.MvpPresenter;

/**
 * Created by Shijo on 23/02/18.
 */

public interface LandingFragmentMvpPresenter<V extends LandingFragmentMvpView> extends MvpPresenter<V> {
    void calculateSum(int a, int b);
}
