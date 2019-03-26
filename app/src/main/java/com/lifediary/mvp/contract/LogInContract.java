package com.lifediary.mvp.contract;

public interface LogInContract {
    interface Presenter extends BaseContract.Presenter {
        /**
         * 登录
         *
         * @param account
         * @param password
         */
        void loginByAccount(String account, String password);
    }

    interface View extends BaseContract.View {

        void loginSuccess();
    }
}