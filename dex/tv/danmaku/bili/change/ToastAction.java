package tv.danmaku.bili.change;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Actions.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/change/ToastAction;", "Ltv/danmaku/bili/change/IEventAction;", "toast", "", "toastRes", "", "<init>", "(Ljava/lang/String;I)V", "getToast", "()Ljava/lang/String;", "getToastRes", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ToastAction implements IEventAction {
    public static final int $stable = 0;
    private final String toast;
    private final int toastRes;

    public static /* synthetic */ ToastAction copy$default(ToastAction toastAction, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = toastAction.toast;
        }
        if ((i2 & 2) != 0) {
            i = toastAction.toastRes;
        }
        return toastAction.copy(str, i);
    }

    public final String component1() {
        return this.toast;
    }

    public final int component2() {
        return this.toastRes;
    }

    public final ToastAction copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "toast");
        return new ToastAction(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastAction) {
            ToastAction toastAction = (ToastAction) obj;
            return Intrinsics.areEqual(this.toast, toastAction.toast) && this.toastRes == toastAction.toastRes;
        }
        return false;
    }

    public int hashCode() {
        return (this.toast.hashCode() * 31) + this.toastRes;
    }

    public String toString() {
        String str = this.toast;
        return "ToastAction(toast=" + str + ", toastRes=" + this.toastRes + ")";
    }

    public ToastAction(String toast, int toastRes) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.toast = toast;
        this.toastRes = toastRes;
    }

    public /* synthetic */ ToastAction(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getToast() {
        return this.toast;
    }

    public final int getToastRes() {
        return this.toastRes;
    }
}