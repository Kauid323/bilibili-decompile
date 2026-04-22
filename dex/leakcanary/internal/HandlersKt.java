package leakcanary.internal;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Handlers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\t\u001a\u00020\nH\u0000\u001a\b\u0010\u000b\u001a\u00020\nH\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0002\"\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"isMainThread", "", "()Z", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "checkMainThread", "", "checkNotMainThread", "leakcanary-android-utils_release"}, k = 2, mv = {1, 4, 1})
public final class HandlersKt {
    private static final Lazy mainHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: leakcanary.internal.HandlersKt$mainHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    public static final Handler getMainHandler() {
        return (Handler) mainHandler$delegate.getValue();
    }

    public static final boolean isMainThread() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        return mainLooper.getThread() == Thread.currentThread();
    }

    public static final void checkMainThread() {
        if (!isMainThread()) {
            throw new IllegalStateException(("Should be called from the main thread, not " + Thread.currentThread()).toString());
        }
    }

    public static final void checkNotMainThread() {
        if (isMainThread()) {
            throw new IllegalStateException("Should not be called from the main thread".toString());
        }
    }
}