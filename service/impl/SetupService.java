package com.fornalik.cleancode.setup.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Map;

import rx.Subscriber;
import rx.Subscription;

import com.fornalik.cleancode.setup.api.SetupServiceApiType;
import com.fornalik.cleancode.setup.entity.SetupPostData;
import com.fornalik.cleancode.setup.service.SetupServiceType;
import com.fornalik.cleancode.framework.rx.SchedulerProviderType;

/**
 * Created by seweryn fornalik.
 */
@Singleton
public class SetupService implements SetupServiceType {

    private final SetupServiceApiType mServiceApiType;

    private final SchedulerProviderType mSchedulerProviderType;

    @Inject
    public SetupService(final SchedulerProviderType schedulerProviderType, final SetupServiceApiType setupServiceApiType) {
        mSchedulerProviderType = schedulerProviderType;
        mSetupServiceApiType = setupServiceApiType;
    }

    @Override
    public Subscription saveSetup(final String data, final Subscriber<Void> subscriber) {
        SetupPostData setupData = new SetupPostData(data);
        return mSetupServiceApiType.setup(data).subscribeOn(mSchedulerProviderType.getSubscribeOnScheduler())
                .observeOn(mSchedulerProviderType.getObserveOnScheduler()).subscribe(subscriber);
    }
}