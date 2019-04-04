package ru.aev.basemvp.ui.fragment.blank;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;

import ru.aev.basemvp.R;
import ru.aev.basemvp.base.BaseFragment;

public class BlankFragment extends BaseFragment<BlankContract.View, BlankContract.Presenter>
        implements BlankContract.View {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.progress)
    ProgressBar progress;

    private BlankPresenter presenter;

    public BlankFragment() {}

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void prepareUi() {
        // Any manipulation with UI elements
    }

    @Override
    protected void setPresenter() {
        presenter = new BlankPresenter();
    }

    @Override
    protected void start() {
        presenter.start();
    }

    @Override
    protected BlankContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected BlankContract.View getV() {
        return this;
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        text.setText(getString(R.string.background_job_start_text));
    }

    @Override
    public void setResult() {
        progress.setVisibility(View.GONE);
        text.setText(getString(R.string.background_job_end_text));
    }
}
