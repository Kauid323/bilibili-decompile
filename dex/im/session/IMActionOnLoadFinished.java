package im.session;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lim/session/IMActionOnLoadFinished;", "Lim/session/IMAction;", "isCacheData", "", "error", "", "<init>", "(ZLjava/lang/Throwable;)V", "()Z", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionOnLoadFinished implements IMAction {
    private final Throwable error;
    private final boolean isCacheData;

    public static /* synthetic */ IMActionOnLoadFinished copy$default(IMActionOnLoadFinished iMActionOnLoadFinished, boolean z, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = iMActionOnLoadFinished.isCacheData;
        }
        if ((i2 & 2) != 0) {
            th = iMActionOnLoadFinished.error;
        }
        return iMActionOnLoadFinished.copy(z, th);
    }

    public final boolean component1() {
        return this.isCacheData;
    }

    public final Throwable component2() {
        return this.error;
    }

    public final IMActionOnLoadFinished copy(boolean z, Throwable th) {
        return new IMActionOnLoadFinished(z, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMActionOnLoadFinished) {
            IMActionOnLoadFinished iMActionOnLoadFinished = (IMActionOnLoadFinished) obj;
            return this.isCacheData == iMActionOnLoadFinished.isCacheData && Intrinsics.areEqual(this.error, iMActionOnLoadFinished.error);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCacheData) * 31) + (this.error == null ? 0 : this.error.hashCode());
    }

    public String toString() {
        boolean z = this.isCacheData;
        return "IMActionOnLoadFinished(isCacheData=" + z + ", error=" + this.error + ")";
    }

    public IMActionOnLoadFinished(boolean isCacheData, Throwable error) {
        this.isCacheData = isCacheData;
        this.error = error;
    }

    public final boolean isCacheData() {
        return this.isCacheData;
    }

    public final Throwable getError() {
        return this.error;
    }
}