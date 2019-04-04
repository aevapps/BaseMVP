package ru.aev.basemvp.ui.fragment.blank;

import ru.aev.basemvp.base.BaseContract;

public interface BlankContract {

    interface View extends BaseContract.View {
        void setResult();
        void showProgress();
    }

    interface Presenter extends BaseContract.Presenter<BlankContract.View> {
        // Empty for currently Presenter
    }
}
