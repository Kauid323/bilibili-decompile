package leakcanary.internal.friendly;

import android.os.Handler;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.ObjectsKt;

/* compiled from: Friendly.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\t\u0010\u0004\u001a\u00020\u0005H\u0080\b\u001a\u001a\u0010\u0006\u001a\u0002H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\bH\u0080\b¢\u0006\u0002\u0010\t\"\u0015\u0010\u0000\u001a\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "checkMainThread", "", "noOpDelegate", "T", "", "()Ljava/lang/Object;", "leakcanary-object-watcher-android-core_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: leakcanary.internal.friendly.leakcanary-object-watcher-android_Friendly  reason: invalid class name */
public final class leakcanaryobjectwatcherandroid_Friendly {
    public static final Handler getMainHandler() {
        return HandlersKt.getMainHandler();
    }

    public static final void checkMainThread() {
        HandlersKt.checkMainThread();
    }

    public static final /* synthetic */ <T> T noOpDelegate() {
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) Proxy.newProxyInstance(Object.class.getClassLoader(), new Class[]{Object.class}, ObjectsKt.NO_OP_HANDLER);
        Intrinsics.reifiedOperationMarker(1, "T");
        return t;
    }
}