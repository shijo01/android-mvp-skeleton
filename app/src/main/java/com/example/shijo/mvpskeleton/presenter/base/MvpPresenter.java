package com.example.shijo.mvpskeleton.presenter.base;

/**
 * Created by shijo on 10/08/2017.
 */

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V extends MvpView> {

  void onAttach(V mvpView);

  void onDetach();

  void setUserAsLoggedOut();
}
