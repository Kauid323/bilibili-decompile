package tv.danmaku.android.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: InstalledAppsUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/android/util/AppInfo;", "", "_flags", "", "_packageName", "", "<init>", "(ILjava/lang/String;)V", "flags", "packageName", "base_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppInfo {
    public int flags;
    public String packageName;

    public AppInfo(int _flags, String _packageName) {
        Intrinsics.checkNotNullParameter(_packageName, "_packageName");
        this.flags = _flags;
        this.packageName = _packageName;
    }
}