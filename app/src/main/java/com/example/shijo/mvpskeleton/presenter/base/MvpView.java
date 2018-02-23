package com.example.shijo.mvpskeleton.presenter.base;

import android.support.annotation.StringRes;
import android.widget.EditText;

/**
 * Created by shijo on 10/08/2017.
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

  void openActivityOnTokenExpire();

  void onError(@StringRes int resId);

  void onError(String message);

  void showMessage(String message);

  void showMessage(@StringRes int resId);

  boolean isNetworkConnected();

  void hideKeyboard();

  void showKeyBoard(EditText editText);
}
