package com.fornalik.cleancode.setup.workflow;

import com.fornalik.cleancode.setup.workflow.impl.SetupState;
import com.fornalik.cleancode.base.CallableWorkflowType;
import com.fornalik.cleancode.base.WorkflowCallback;

/**
 * Created by seweryn fornalik.
 */
public interface SetupWorkflowType extends CallableWorkflowType<Boolean, WorkflowCallback<Boolean>> {

    void showNextView();

    void navigateBack();

    SetupState getState();
}
