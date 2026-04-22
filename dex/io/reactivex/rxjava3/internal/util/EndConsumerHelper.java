package io.reactivex.rxjava3.internal.util;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean validate(Disposable upstream, Disposable next, Class<?> observer) {
        Objects.requireNonNull(next, "next is null");
        if (upstream != null) {
            next.dispose();
            if (upstream != DisposableHelper.DISPOSED) {
                reportDoubleSubscription(observer);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> upstream, Disposable next, Class<?> observer) {
        Objects.requireNonNull(next, "next is null");
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(upstream, (Object) null, next)) {
            next.dispose();
            if (upstream.get() != DisposableHelper.DISPOSED) {
                reportDoubleSubscription(observer);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean validate(Subscription upstream, Subscription next, Class<?> subscriber) {
        Objects.requireNonNull(next, "next is null");
        if (upstream != null) {
            next.cancel();
            if (upstream != SubscriptionHelper.CANCELLED) {
                reportDoubleSubscription(subscriber);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> upstream, Subscription next, Class<?> subscriber) {
        Objects.requireNonNull(next, "next is null");
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(upstream, (Object) null, next)) {
            next.cancel();
            if (upstream.get() != SubscriptionHelper.CANCELLED) {
                reportDoubleSubscription(subscriber);
                return false;
            }
            return false;
        }
        return true;
    }

    public static String composeMessage(String consumer) {
        return "It is not allowed to subscribe with a(n) " + consumer + " multiple times. Please create a fresh instance of " + consumer + " and subscribe that to the target source instead.";
    }

    public static void reportDoubleSubscription(Class<?> consumer) {
        RxJavaPlugins.onError(new ProtocolViolationException(composeMessage(consumer.getName())));
    }
}