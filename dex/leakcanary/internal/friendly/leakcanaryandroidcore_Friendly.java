package leakcanary.internal.friendly;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.ObjectsKt;

/* compiled from: Friendly.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\t\u0010\u0004\u001a\u00020\u0005H\u0080\b\u001a\t\u0010\u0006\u001a\u00020\u0005H\u0080\b\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a\u001a\u0010\u000b\u001a\u0002H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\rH\u0080\b¢\u0006\u0002\u0010\u000e\"\u0015\u0010\u0000\u001a\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000f"}, d2 = {"mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "checkMainThread", "", "checkNotMainThread", "measureDurationMillis", "", "block", "Lkotlin/Function0;", "noOpDelegate", "T", "", "()Ljava/lang/Object;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: leakcanary.internal.friendly.leakcanary-android-core_Friendly  reason: invalid class name */
public final class leakcanaryandroidcore_Friendly {
    public static final Handler getMainHandler() {
        return HandlersKt.getMainHandler();
    }

    public static final void checkMainThread() {
        HandlersKt.checkMainThread();
    }

    public static final void checkNotMainThread() {
        HandlersKt.checkNotMainThread();
    }

    public static final /* synthetic */ <T> T noOpDelegate() {
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) Proxy.newProxyInstance(Object.class.getClassLoader(), new Class[]{Object.class}, ObjectsKt.NO_OP_HANDLER);
        Intrinsics.reifiedOperationMarker(1, "T");
        return t;
    }

    public static final long measureDurationMillis(Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        long start$iv = SystemClock.uptimeMillis();
        block.invoke();
        return SystemClock.uptimeMillis() - start$iv;
    }
}