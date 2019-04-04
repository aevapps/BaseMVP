package ru.aev.basemvp.ui.activity.main;

import ru.aev.basemvp.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter {

    MainPresenter() {}

    @Override
    public void buttonClick() {
        if (view != null) {
            view.openSecondActivity();
        }
    }

    // Implementation for public abstract void start();
    @Override
    public void start() {
        if (view != null) {
            view.showHelloMessage("Hello World!");
        }
    }
}
