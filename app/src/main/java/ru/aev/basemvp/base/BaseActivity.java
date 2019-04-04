package ru.aev.basemvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends AppCompatActivity implements BaseContract.View {

    private P presenter;
    private V view;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bindViews();
        setPresenter();
        get();
        prepareUi();
        if (presenter != null) {
            presenter.onAttachView(view);
        }
        start();
    }

    @Override
    protected void onDestroy() {
        unBindViews();
        if (presenter != null) {
            presenter.onDetachView();
        }
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    private void bindViews() {
        unbinder = ButterKnife.bind(this);
    }

    private void unBindViews() {
        unbinder.unbind();
    }

    private void get() {
        presenter = getPresenter();
        view = getView();
    }

    protected abstract void prepareUi();
    protected abstract void setPresenter();
    protected abstract void start();

    protected abstract P getPresenter();
    protected abstract V getView();
}
