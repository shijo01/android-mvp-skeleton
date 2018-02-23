package com.example.shijo.mvpskeleton.ui.base;

import android.annotation.TargetApi;
import android.app.Fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shijo.mvpskeleton.R;
import com.example.shijo.mvpskeleton.presenter.base.MvpView;
import com.example.shijo.mvpskeleton.utils.NetworkUtils;

import butterknife.Unbinder;

/**
 * Created by shijo on 10/08/2017.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.FragmentCallback {

    private Unbinder mUnBinder;


    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
    }


    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermissions(String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(this, permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showSnackBar(String message) {
        final Snackbar snackbar =
                Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.white));

        View sbView = snackbar.getView();

        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_red));
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showKeyBoard(EditText editText) {
        if (null != editText) {
            (new Handler()).postDelayed(() -> {

                editText.dispatchTouchEvent(
                        MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                                MotionEvent.ACTION_DOWN, 0, 0, 0));
                editText.dispatchTouchEvent(
                        MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                                MotionEvent.ACTION_UP, 0, 0, 0));
            }, 100);
        }
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp();

    protected abstract void addFragmentToBackStack(Fragment fragment, String fragmentTag,
                                                   @IdRes int layoutResourceId);
}
