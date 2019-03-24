package com.lifediary.mvp.contract;

public interface RegisterContract {
    interface Presenter extends BaseContract.Presenter {
        void requestMobilePhone(String phone);

        void register(String UserName, String password, String verification);
    }

    interface View extends BaseContract.View {

        void showVerificationCode();


        void registerSuccess();
    }
}