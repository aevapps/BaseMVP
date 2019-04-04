package ru.aev.basemvp.base;

public interface BaseContract {

    interface View {
        void runOnUiThread(Runnable action);
    }

    interface Presenter<V extends View> {
        void start();
        void onAttachView(V view);
        void onDetachView();
    }
}
