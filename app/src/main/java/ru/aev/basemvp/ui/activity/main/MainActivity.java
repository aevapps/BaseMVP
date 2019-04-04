package ru.aev.basemvp.ui.activity.main;

import android.content.Intent;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

import ru.aev.basemvp.R;
import ru.aev.basemvp.ui.activity.second.SecondActivity;
import ru.aev.basemvp.base.BaseActivity;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    // Views
    @BindView(R.id.text)
    TextView text;

    // Presenter for ths Activity
    private MainPresenter presenter;

    // Method only for this Activity
    @Override
    public void showHelloMessage(String message) {
        text.setText(message);
    }

    // Method only for this Activity
    @Override
    public void openSecondActivity() {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    // Return layout id
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void prepareUi() {
        // Any manipulation with UI elements
    }

    // Create presenter
    @Override
    protected void setPresenter() {
        presenter = new MainPresenter();
    }

    //
    @Override
    protected void start() {
        presenter.start();
    }

    // Return presenter
    @Override
    protected MainContract.Presenter getPresenter() {
        return presenter;
    }

    // Return view
    @Override
    protected MainContract.View getView() {
        return this;
    }

    // Tap on button
    @OnClick(R.id.button)
    void buttonClick() {
        presenter.buttonClick();
    }
}
