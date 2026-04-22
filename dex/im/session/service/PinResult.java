package im.session.service;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;

/* compiled from: IMSessionCardEventService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lim/session/service/PinResult;", "", "nowPinned", "", "newSequenceNumber", "", "<init>", "(ZJ)V", "getNowPinned", "()Z", "getNewSequenceNumber", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PinResult {
    private final long newSequenceNumber;
    private final boolean nowPinned;

    public static /* synthetic */ PinResult copy$default(PinResult pinResult, boolean z, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pinResult.nowPinned;
        }
        if ((i2 & 2) != 0) {
            j = pinResult.newSequenceNumber;
        }
        return pinResult.copy(z, j);
    }

    public final boolean component1() {
        return this.nowPinned;
    }

    public final long component2() {
        return this.newSequenceNumber;
    }

    public final PinResult copy(boolean z, long j) {
        return new PinResult(z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PinResult) {
            PinResult pinResult = (PinResult) obj;
            return this.nowPinned == pinResult.nowPinned && this.newSequenceNumber == pinResult.newSequenceNumber;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.nowPinned) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.newSequenceNumber);
    }

    public String toString() {
        boolean z = this.nowPinned;
        return "PinResult(nowPinned=" + z + ", newSequenceNumber=" + this.newSequenceNumber + ")";
    }

    public PinResult(boolean nowPinned, long newSequenceNumber) {
        this.nowPinned = nowPinned;
        this.newSequenceNumber = newSequenceNumber;
    }

    public final boolean getNowPinned() {
        return this.nowPinned;
    }

    public final long getNewSequenceNumber() {
        return this.newSequenceNumber;
    }
}