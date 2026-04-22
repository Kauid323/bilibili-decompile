package im.keywordBlocking.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBAddItemStateMachine.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/keywordBlocking/stateMachine/KBAddItemStatusCancel;", "Lim/keywordBlocking/stateMachine/KBAddItemStatus;", "text", "", "throwable", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getText", "()Ljava/lang/String;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBAddItemStatusCancel implements KBAddItemStatus {
    private final String text;
    private final Throwable throwable;

    public static /* synthetic */ KBAddItemStatusCancel copy$default(KBAddItemStatusCancel kBAddItemStatusCancel, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kBAddItemStatusCancel.text;
        }
        if ((i2 & 2) != 0) {
            th = kBAddItemStatusCancel.throwable;
        }
        return kBAddItemStatusCancel.copy(str, th);
    }

    public final String component1() {
        return this.text;
    }

    public final Throwable component2() {
        return this.throwable;
    }

    public final KBAddItemStatusCancel copy(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(th, "throwable");
        return new KBAddItemStatusCancel(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBAddItemStatusCancel) {
            KBAddItemStatusCancel kBAddItemStatusCancel = (KBAddItemStatusCancel) obj;
            return Intrinsics.areEqual(this.text, kBAddItemStatusCancel.text) && Intrinsics.areEqual(this.throwable, kBAddItemStatusCancel.throwable);
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.throwable.hashCode();
    }

    public String toString() {
        String str = this.text;
        return "KBAddItemStatusCancel(text=" + str + ", throwable=" + this.throwable + ")";
    }

    public KBAddItemStatusCancel(String text, Throwable throwable) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.text = text;
        this.throwable = throwable;
    }

    @Override // im.keywordBlocking.stateMachine.KBAddItemStatus
    public String getText() {
        return this.text;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }
}