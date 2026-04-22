package im.direct.notification.interactive;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lim/direct/notification/interactive/ToastMessage;", "", "text", "", "timestamp", "", "<init>", "(Ljava/lang/String;J)V", "getText$annotations", "()V", "getText", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ToastMessage {
    private final String text;
    private final long timestamp;

    public static /* synthetic */ ToastMessage copy$default(ToastMessage toastMessage, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = toastMessage.text;
        }
        if ((i2 & 2) != 0) {
            j = toastMessage.timestamp;
        }
        return toastMessage.copy(str, j);
    }

    public static /* synthetic */ void getText$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final ToastMessage copy(String str, long j) {
        return new ToastMessage(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastMessage) {
            ToastMessage toastMessage = (ToastMessage) obj;
            return Intrinsics.areEqual(this.text, toastMessage.text) && this.timestamp == toastMessage.timestamp;
        }
        return false;
    }

    public int hashCode() {
        return ((this.text == null ? 0 : this.text.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        String str = this.text;
        return "ToastMessage(text=" + str + ", timestamp=" + this.timestamp + ")";
    }

    public ToastMessage(String text, long timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public /* synthetic */ ToastMessage(String str, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? Clock.System.INSTANCE.now().toEpochMilliseconds() : j);
    }

    public final String getText() {
        return this.text;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}