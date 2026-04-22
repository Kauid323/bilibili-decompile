package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    List<Disposable> resources;

    public ListCompositeDisposable() {
    }

    public ListCompositeDisposable(Disposable... resources) {
        Objects.requireNonNull(resources, "resources is null");
        this.resources = new LinkedList();
        for (Disposable d : resources) {
            Objects.requireNonNull(d, "Disposable item is null");
            this.resources.add(d);
        }
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> resources) {
        Objects.requireNonNull(resources, "resources is null");
        this.resources = new LinkedList();
        for (Disposable d : resources) {
            Objects.requireNonNull(d, "Disposable item is null");
            this.resources.add(d);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            List<Disposable> set = this.resources;
            this.resources = null;
            dispose(set);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean add(Disposable d) {
        Objects.requireNonNull(d, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    List<Disposable> set = this.resources;
                    if (set == null) {
                        set = new LinkedList();
                        this.resources = set;
                    }
                    set.add(d);
                    return true;
                }
            }
        }
        d.dispose();
        return false;
    }

    public boolean addAll(Disposable... ds) {
        Objects.requireNonNull(ds, "ds is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    List<Disposable> set = this.resources;
                    if (set == null) {
                        set = new LinkedList();
                        this.resources = set;
                    }
                    for (Disposable d : ds) {
                        Objects.requireNonNull(d, "d is null");
                        set.add(d);
                    }
                    return true;
                }
            }
        }
        for (Disposable d2 : ds) {
            d2.dispose();
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean remove(Disposable d) {
        if (delete(d)) {
            d.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean delete(Disposable d) {
        Objects.requireNonNull(d, "Disposable item is null");
        if (this.disposed) {
            return false;
        }
        synchronized (this) {
            if (this.disposed) {
                return false;
            }
            List<Disposable> set = this.resources;
            if (set != null && set.remove(d)) {
                return true;
            }
            return false;
        }
    }

    public void clear() {
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            List<Disposable> set = this.resources;
            this.resources = null;
            dispose(set);
        }
    }

    void dispose(List<Disposable> set) {
        if (set == null) {
            return;
        }
        List<Throwable> errors = null;
        for (Disposable o : set) {
            try {
                o.dispose();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                if (errors == null) {
                    errors = new ArrayList<>();
                }
                errors.add(ex);
            }
        }
        if (errors != null) {
            if (errors.size() == 1) {
                throw ExceptionHelper.wrapOrThrow(errors.get(0));
            }
            throw new CompositeException(errors);
        }
    }
}