package com.fornalik.cleancode.setup.workflow.impl;

import android.os.Bundle;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.lang.ref.WeakReference;

import com.fornalik.cleancode.setup.presentation.impl.SetupSuccessFragment;
import com.fornalik.cleancode.setup.presentation.impl.SetupActivity;
import com.fornalik.cleancode.setup.service.SetupServiceType;
import com.fornalik.cleancode.setup.workflow.SetupWorkflowType;
import com.fornalik.cleancode.setup.base.WorkflowCallback;
import com.fornalik.cleancode.setup.util.fragment.StackManagerType;

/**
 * Created by seweryn fornalik.
 */
@Singleton
public class SetupWorkflow implements SetupWorkflowType {

    private final StackManagerType mStackManagerType;

    private final SetupType mSetupType;

    private SetupState mSetupState = SetupState.NONE;

    private WeakReference<WorkflowCallback<Boolean>> mCallback;

    @Inject
    public SetupWorkflow(final StackManagerType stackManagerType, final SetupServiceType setupServiceType) {
        mStackManagerType = stackManagerType;
        mSetupServiceType = setupServiceType;
    }

    @Override
    public void startWorkflow() {
        mStackManagerType.startActivity(SetupActivity.class);
        mSetupState = SetupState.NONE;
    }

    @Override
    public void startWorkflow(final Bundle parametersBundle) {
        startWorkflow();
        mCallback = null;
        processBundleParameters(parametersBundle);
    }

    @Override
    public void startWorkflow(final WeakReference<WorkflowCallback<Boolean>> callback) {
        startWorkflow();
        mCallback = callback;
    }

    @Override
    public void startWorkflow(final Bundle parametersBundle, final WeakReference<WorkflowCallback<Boolean>> callback) {
        startWorkflow();
        mCallback = callback;
        processBundleParameters(parametersBundle);
    }

    @Override
    public void showNextView() {
        switch (mSetupState) {
            case NONE:
                mSetupState = SetupState.SUCCESS;
                mStackManagerType.setFragment(new SetupSuccessFragment());
                break;
            case SUCCESS:
                endWorkflow(true);
                break;
        }
    }

    @Override
    public void navigateBack() {
        switch (mSetupState) {
            case NONE:
                endWorkflow(false);
                break;
            case SUCCESS:
                mStackManagerType.removeTopFragment();
                mSetupState = SetupState.NONE;
                break;
        }
    }

    @Override
    public SetupState getState() {
        return mSetupState;
    }

    @Override
    public void endWorkflow(final Boolean result) {
        resetState();
        mStackManagerType.finishCurrentActivity();

        if (mCallback != null && mCallback.get() != null) {
            mCallback.get().onResult(result);
        }
    }

    private void resetState() {
        mSetupState = SetupState.NONE;
        mSetupServiceType.clearTemporaryData();
    }

    private void processBundleParameters(Bundle parametersBundle) {
        if (parametersBundle != null) {
            final String variant = parametersBundle.getString(WORKFLOW_VARIANT_BUNDLE_KEY);
        }
    }
}
