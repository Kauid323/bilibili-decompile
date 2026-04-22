package im.session;

import BottomSheetItemData$;
import kotlin.Metadata;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lim/session/IMActionPageReady;", "Lim/session/IMAction;", "isCacheData", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionPageReady implements IMAction {
    private final boolean isCacheData;

    public static /* synthetic */ IMActionPageReady copy$default(IMActionPageReady iMActionPageReady, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = iMActionPageReady.isCacheData;
        }
        return iMActionPageReady.copy(z);
    }

    public final boolean component1() {
        return this.isCacheData;
    }

    public final IMActionPageReady copy(boolean z) {
        return new IMActionPageReady(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMActionPageReady) && this.isCacheData == ((IMActionPageReady) obj).isCacheData;
    }

    public int hashCode() {
        return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCacheData);
    }

    public String toString() {
        return "IMActionPageReady(isCacheData=" + this.isCacheData + ")";
    }

    public IMActionPageReady(boolean isCacheData) {
        this.isCacheData = isCacheData;
    }

    public final boolean isCacheData() {
        return this.isCacheData;
    }
}