package com.fornalik.cleancode.setup.presentation.impl;

import javax.inject.Inject;

import com.fornalik.cleancode.setup.presentation.SuccessPresenterType;
import com.fornalik.cleancode.setup.presentation.SuccessViewType;
import com.fornalik.cleancode.setup.workflow.SetupWorkflowType;

/**
 * Created by seweryn fornalik.
 */
public class SetupSuccessPresenter implements SetupSuccessPresenterType {

    private SetupSuccessViewType mView;

    private final SetupWorkflowType mSetupWorkflowType;

    @Inject
    public SuccessPresenter(SetupWorkflowType mSetupWorkflowType) {
        this.mSetupWorkflowType = mSetupWorkflowType;
    }

    @Override
    public void setView(SetupSuccessViewType view) {
        mView = view;
    }

    @Override
    public void create() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onButtonClicked() {
        mSetupWorkflowType.showNextView();
    }
}
