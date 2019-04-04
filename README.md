# BaseMVP
There is one more implementation of Android MVP pattern.

## What is it?
Here is an example of a project demonstrated the implementation of MVP pattern using base classes.
* .basemvp.base.BaseActvity
* .basemvp.base.BaseFragment
* .basemvp.base.BasePresenter
* .basemvp.base.BaseContract

Use base classes to implement repetitive methods for your Activity/Fragment and Presenter.

For example:

```java
// bind your views
private void bindViews() {
    unbinder = ButterKnife.bind(this);
}

// attach view to presenter
@Override
public void onAttachView(V view) {
    this.view = view;
}

// detach view from presenter
@Override
public void onDetachView() {
    view = null;
}
```

Use abstract methods for different implementations.

```java
protected abstract void start();
```

## How it use?
* Add files to your project from .basemvp.base
* Create the interface YourContract (extends BaseContract.View and BaseContract.Presenter)
* Add this code in YourActivity

```java
public class YourActivity extends BaseActivity<YourContract.View, YourContract.Presenter>
        implements YourContract.View {
}
```

* Implements necessary methods
* Do the same for YourPresenter

```java
public class YourPresenter extends BasePresenter<YourContract.View>
        implements YourContract.Presenter {
}
```

## Contributing to BaseMVP
All pull requests are welcome!

## P.s.
If you have any questions, comments or suggestions, please, feel free to contact me!
