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

## License
```
MIT License

Copyright (c) 2019 AEV

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Contributing to BaseMVP
All pull requests are welcome!

## P.s.
If you have any questions, comments or suggestions, please, feel free to contact me!
