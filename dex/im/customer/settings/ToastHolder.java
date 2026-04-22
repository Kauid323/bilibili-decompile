package im.customer.settings;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: CustomerSettingState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lim/customer/settings/ToastHolder;", "", "message", "", "timeStamp", "", "<init>", "(Ljava/lang/String;J)V", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "getTimeStamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ToastHolder {
    private final String message;
    private final long timeStamp;

    public ToastHolder() {
        this(null, 0L, 3, null);
    }

    public static /* synthetic */ ToastHolder copy$default(ToastHolder toastHolder, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = toastHolder.message;
        }
        if ((i2 & 2) != 0) {
            j = toastHolder.timeStamp;
        }
        return toastHolder.copy(str, j);
    }

    public static /* synthetic */ void getMessage$annotations() {
    }

    public final String component1() {
        return this.message;
    }

    public final long component2() {
        return this.timeStamp;
    }

    public final ToastHolder copy(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new ToastHolder(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastHolder) {
            ToastHolder toastHolder = (ToastHolder) obj;
            return Intrinsics.areEqual(this.message, toastHolder.message) && this.timeStamp == toastHolder.timeStamp;
        }
        return false;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timeStamp);
    }

    public String toString() {
        String str = this.message;
        return "ToastHolder(message=" + str + ", timeStamp=" + this.timeStamp + ")";
    }

    public ToastHolder(String message, long timeStamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public /* synthetic */ ToastHolder(String str, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? Clock.System.INSTANCE.now().toEpochMilliseconds() : j);
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }
}