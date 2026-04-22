package rx.internal.operators;

import java.util.Arrays;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class SingleOnSubscribeUsing<T, Resource> implements Single.OnSubscribe<T> {
    final Action1<? super Resource> disposeAction;
    final boolean disposeEagerly;
    final Func0<Resource> resourceFactory;
    final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleOnSubscribeUsing(Func0<Resource> resourceFactory, Func1<? super Resource, ? extends Single<? extends T>> observableFactory, Action1<? super Resource> disposeAction, boolean disposeEagerly) {
        this.resourceFactory = resourceFactory;
        this.singleFactory = observableFactory;
        this.disposeAction = disposeAction;
        this.disposeEagerly = disposeEagerly;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void call(final SingleSubscriber<? super T> child) {
        try {
            final Object call = this.resourceFactory.call();
            try {
                Single<? extends T> single = (Single) this.singleFactory.call(call);
                if (single == null) {
                    handleSubscriptionTimeError(child, call, new NullPointerException("The single"));
                    return;
                }
                SingleSubscriber<T> parent = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOnSubscribeUsing.1
                    public void onSuccess(T value) {
                        if (SingleOnSubscribeUsing.this.disposeEagerly) {
                            try {
                                SingleOnSubscribeUsing.this.disposeAction.call(call);
                            } catch (Throwable ex) {
                                Exceptions.throwIfFatal(ex);
                                child.onError(ex);
                                return;
                            }
                        }
                        child.onSuccess(value);
                        if (!SingleOnSubscribeUsing.this.disposeEagerly) {
                            try {
                                SingleOnSubscribeUsing.this.disposeAction.call(call);
                            } catch (Throwable ex2) {
                                Exceptions.throwIfFatal(ex2);
                                RxJavaHooks.onError(ex2);
                            }
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public void onError(Throwable error) {
                        SingleOnSubscribeUsing.this.handleSubscriptionTimeError(child, call, error);
                    }
                };
                child.add(parent);
                single.subscribe(parent);
            } catch (Throwable ex) {
                handleSubscriptionTimeError(child, call, ex);
            }
        } catch (Throwable ex2) {
            Exceptions.throwIfFatal(ex2);
            child.onError(ex2);
        }
    }

    void handleSubscriptionTimeError(SingleSubscriber<? super T> t, Resource resource, Throwable ex) {
        Exceptions.throwIfFatal(ex);
        if (this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable ex2) {
                Exceptions.throwIfFatal(ex2);
                ex = new CompositeException(Arrays.asList(ex, ex2));
            }
        }
        t.onError(ex);
        if (!this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable ex22) {
                Exceptions.throwIfFatal(ex22);
                RxJavaHooks.onError(ex22);
            }
        }
    }
}