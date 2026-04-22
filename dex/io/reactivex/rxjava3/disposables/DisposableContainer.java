package io.reactivex.rxjava3.disposables;

public interface DisposableContainer {
    boolean add(Disposable d);

    boolean delete(Disposable d);

    boolean remove(Disposable d);
}