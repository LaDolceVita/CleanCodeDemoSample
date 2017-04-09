package com.fornalik.cleancode.setup.entity;

import com.google.gson.annotations.SerializedName;

import java.lang.Override;

/**
 * Created by seweryn fornalik.
 */
public class SetupPostData {

    @SerializedName("data")
    private String mData;

    public SetupPostData(final String data) {
        mData = data;
    }

    public String getData() {
        return mData;
    }

    public void setData(String mData) {
        this.mData = mData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetupPostData that = (SetupPostData) o;

        if (!mData.equals(that.mData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mData.hashCode();
    }
}
