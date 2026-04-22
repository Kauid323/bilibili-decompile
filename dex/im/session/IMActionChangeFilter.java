package im.session;

import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/session/IMActionChangeFilter;", "Lim/session/IMAction;", "filterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;)V", "getFilterType", "()Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionChangeFilter implements IMAction {
    private final KSessionFilterType filterType;

    public static /* synthetic */ IMActionChangeFilter copy$default(IMActionChangeFilter iMActionChangeFilter, KSessionFilterType kSessionFilterType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kSessionFilterType = iMActionChangeFilter.filterType;
        }
        return iMActionChangeFilter.copy(kSessionFilterType);
    }

    public final KSessionFilterType component1() {
        return this.filterType;
    }

    public final IMActionChangeFilter copy(KSessionFilterType kSessionFilterType) {
        Intrinsics.checkNotNullParameter(kSessionFilterType, "filterType");
        return new IMActionChangeFilter(kSessionFilterType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMActionChangeFilter) && Intrinsics.areEqual(this.filterType, ((IMActionChangeFilter) obj).filterType);
    }

    public int hashCode() {
        return this.filterType.hashCode();
    }

    public String toString() {
        return "IMActionChangeFilter(filterType=" + this.filterType + ")";
    }

    public IMActionChangeFilter(KSessionFilterType filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        this.filterType = filterType;
    }

    public final KSessionFilterType getFilterType() {
        return this.filterType;
    }
}