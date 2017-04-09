package com.fornalik.cleancode.setup.api.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.fornalik.cleancode.util.RetrofitUtility;

/**
 * Created by seweryn fornalik.
 */

public class RetrofitSetupServiceApiProvider implements Provider<SetupServiceApiType> {

    @Override
    public SetupServiceApiType get() {
        return RetrofitUtility.provideRetrofit()
                .create(SetupServiceApiType.class);
    }
}

