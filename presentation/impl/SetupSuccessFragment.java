package com.fornalik.cleancode.setup.presentation.impl;

import com.google.inject.Inject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fornalik.cleancode.setup.presentation.SuccessPresenterType;
import com.fornalik.cleancode.setup.presentation.SuccessViewType;
import com.fornalik.cleancode.base.BaseViewFragment;

/**
 * Created by seweryn fornalik.
 */
public class SetupSuccessFragment extends BaseViewFragment<SetupSuccessViewType, SetuSuccessPresenterType> implements SetupSuccessViewType {

    private ProgressBar mProgressBar;

    @SuppressWarnings("unused")
    @Inject
    private SetupSuccessPresenterType mSetupSuccessPresenterType;

    @Override
    public SetupSuccessPresenterType getPresenter() {
        return mSetupSuccessPresenterType;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_success_celebration, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(final View rootView) {
        mProgressBar = (ProgressBar) rootView.findViewById(R.id.celebration_fragment_progress);
    }
}
