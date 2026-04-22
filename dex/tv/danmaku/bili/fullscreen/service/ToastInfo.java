package tv.danmaku.bili.fullscreen.service;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "", "toast", "", "version", "", "<init>", "(Ljava/lang/String;J)V", "getToast", "()Ljava/lang/String;", "getVersion", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ToastInfo {
    public static final int $stable = 0;
    private final String toast;
    private final long version;

    public ToastInfo() {
        this(null, 0L, 3, null);
    }

    public static /* synthetic */ ToastInfo copy$default(ToastInfo toastInfo, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toastInfo.toast;
        }
        if ((i & 2) != 0) {
            j = toastInfo.version;
        }
        return toastInfo.copy(str, j);
    }

    public final String component1() {
        return this.toast;
    }

    public final long component2() {
        return this.version;
    }

    public final ToastInfo copy(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "toast");
        return new ToastInfo(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastInfo) {
            ToastInfo toastInfo = (ToastInfo) obj;
            return Intrinsics.areEqual(this.toast, toastInfo.toast) && this.version == toastInfo.version;
        }
        return false;
    }

    public int hashCode() {
        return (this.toast.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version);
    }

    public String toString() {
        String str = this.toast;
        return "ToastInfo(toast=" + str + ", version=" + this.version + ")";
    }

    public ToastInfo(String toast, long version) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.toast = toast;
        this.version = version;
    }

    public /* synthetic */ ToastInfo(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? System.currentTimeMillis() : j);
    }

    public final String getToast() {
        return this.toast;
    }

    public final long getVersion() {
        return this.version;
    }
}