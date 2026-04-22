package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lim/direct/notification/interactive/INActionChangeFilter;", "Lim/direct/notification/interactive/INAction;", "filter", "Lim/direct/notification/interactive/INFilter;", "<init>", "(Lim/direct/notification/interactive/INFilter;)V", "getFilter$annotations", "()V", "getFilter", "()Lim/direct/notification/interactive/INFilter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INActionChangeFilter implements INAction {
    private final INFilter filter;

    public static /* synthetic */ INActionChangeFilter copy$default(INActionChangeFilter iNActionChangeFilter, INFilter iNFilter, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iNFilter = iNActionChangeFilter.filter;
        }
        return iNActionChangeFilter.copy(iNFilter);
    }

    public static /* synthetic */ void getFilter$annotations() {
    }

    public final INFilter component1() {
        return this.filter;
    }

    public final INActionChangeFilter copy(INFilter iNFilter) {
        Intrinsics.checkNotNullParameter(iNFilter, "filter");
        return new INActionChangeFilter(iNFilter);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof INActionChangeFilter) && Intrinsics.areEqual(this.filter, ((INActionChangeFilter) obj).filter);
    }

    public int hashCode() {
        return this.filter.hashCode();
    }

    public String toString() {
        return "INActionChangeFilter(filter=" + this.filter + ")";
    }

    public INActionChangeFilter(INFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.filter = filter;
    }

    public final INFilter getFilter() {
        return this.filter;
    }
}