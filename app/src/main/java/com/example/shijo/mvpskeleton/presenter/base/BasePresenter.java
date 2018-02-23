package com.example.shijo.mvpskeleton.presenter.base;


import com.example.shijo.mvpskeleton.data.AppDataManager;
import com.example.shijo.mvpskeleton.data.DataManager;
import com.example.shijo.mvpskeleton.utils.rx.AppSchedulerProvider;
import com.example.shijo.mvpskeleton.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by shijo on 10/08/2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;
    private DataManager mDataManager;
    private SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter() {
        this.mDataManager = new AppDataManager();
        this.mSchedulerProvider = new AppSchedulerProvider();
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public boolean isAdded() {
        if (getMvpView() == null) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("serial")
    public static class MvpViewNotAttachedException
            extends RuntimeException {

        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter");
        }
    }
}
