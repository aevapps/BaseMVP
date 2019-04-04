package ru.aev.basemvp.ui.fragment.blank;

import ru.aev.basemvp.base.BasePresenter;

public class BlankPresenter extends BasePresenter<BlankContract.View>
        implements BlankContract.Presenter {

    BlankPresenter() {}

    @Override
    public void start() {
        if (view != null) {
            view.showProgress();
        }
        // Background job
        new Thread (() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (view != null) {
                // Change UI from UiThread
                view.runOnUiThread(() -> view.setResult());
            }
        }).start();
    }
}
