package com.example.shijo.mvpskeleton.ui.landing;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shijo.mvpskeleton.R;
import com.example.shijo.mvpskeleton.presenter.landing.LandingFragmentMvpPresenter;
import com.example.shijo.mvpskeleton.presenter.landing.LandingFragmentMvpView;
import com.example.shijo.mvpskeleton.presenter.landing.LandingFragmentPresenter;
import com.example.shijo.mvpskeleton.ui.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements LandingFragmentMvpView {
    private LandingFragmentMvpPresenter<LandingFragmentMvpView> mvpPresenter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setUp(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mvpPresenter = new LandingFragmentPresenter<>();
    }

    @Override
    public void showSum(int sum) {

    }

    @Override
    protected void setUp(View view) {
        setUnBinder(ButterKnife.bind(this, view));

    }
}
