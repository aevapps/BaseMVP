package ru.aev.basemvp.base;

public abstract class BasePresenter<V extends BaseContract.View>
        implements BaseContract.Presenter<V> {

    protected V view;

    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    @Override
    public abstract void start();
}
