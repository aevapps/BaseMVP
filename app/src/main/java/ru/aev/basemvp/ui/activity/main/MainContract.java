package ru.aev.basemvp.ui.activity.main;

import ru.aev.basemvp.base.BaseContract;

public interface MainContract {

    interface View extends BaseContract.View {
        // Any customs method for currently Activity
        void showHelloMessage(String message);
        void openSecondActivity();
    }

    interface Presenter extends BaseContract.Presenter<MainContract.View> {
        // Any customs method for currently Presenter
        void buttonClick();
    }
}
