package leakcanary.internal;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Applications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isDebuggableBuild", "", "Landroid/app/Application;", "(Landroid/app/Application;)Z", "leakcanary-object-watcher-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class ApplicationsKt {
    public static final boolean isDebuggableBuild(Application isDebuggableBuild) {
        Intrinsics.checkParameterIsNotNull(isDebuggableBuild, "$this$isDebuggableBuild");
        return (isDebuggableBuild.getApplicationInfo().flags & 2) != 0;
    }
}