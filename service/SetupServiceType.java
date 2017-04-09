package com.fornalik.cleancode.setup.service;

import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import com.fornalik.cleancode.base.ServiceType;

/**
 * Created by seweryn fornalik.
 */
public interface SetupServiceType extends ServiceType {

    Subscription saveSetup(final String data, final Subscriber<Void> subscriber);
}
