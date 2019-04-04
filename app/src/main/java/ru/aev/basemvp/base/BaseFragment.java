package ru.aev.basemvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends Fragment implements BaseContract.View {

    private P presenter;
    private V v;
    private View view;
    private Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews();
        setPresenter();
        get();
        prepareUi();
        if (presenter != null) {
            presenter.onAttachView(v);
        }
        start();
    }

    @Override
    public void onDestroy() {
        unBindViews();
        if (presenter != null) {
            presenter.onDetachView();
        }
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    private void bindViews() {
        unbinder = ButterKnife.bind(this, view);
    }

    private void unBindViews() {
        unbinder.unbind();
    }

    private void get() {
        presenter = getPresenter();
        v = getV();
    }

    protected abstract void prepareUi();
    protected abstract void setPresenter();
    protected abstract void start();

    protected abstract P getPresenter();
    protected abstract V getV();

    @Override
    public void runOnUiThread(Runnable action) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(action);
        }
    }
}
