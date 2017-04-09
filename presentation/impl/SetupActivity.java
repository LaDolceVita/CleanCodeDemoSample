package com.fornalik.cleancode.setup.presentation.impl;

import com.google.inject.Inject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.fornalik.cleancode.R;
import com.fornalik.cleancode.setup.workflow.SetupWorkflowType;
import com.fornalik.cleancode.framework.base.BaseViewFragment;
import com.fornalik.cleancode.framework.base.BaseActivity;

/**
 * Created by seweryn fornalik.
 */
public class SetupActivity extends BaseActivity {

    @Inject
    @SuppressWarnings("unused")
    private SetupWorkflowType mSetupWorkflowType;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        if (savedInstanceState == null) {
            mSetupWorkflowType.showNextView();
        }
    }
}
