package im.session;

import im.session.model.IMSessionCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lim/session/IMActionClearAllSessionsSucceed;", "Lim/session/IMAction;", "list", "", "Lim/session/model/IMSessionCard;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionClearAllSessionsSucceed implements IMAction {
    private final List<IMSessionCard> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMActionClearAllSessionsSucceed copy$default(IMActionClearAllSessionsSucceed iMActionClearAllSessionsSucceed, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = iMActionClearAllSessionsSucceed.list;
        }
        return iMActionClearAllSessionsSucceed.copy(list);
    }

    public final List<IMSessionCard> component1() {
        return this.list;
    }

    public final IMActionClearAllSessionsSucceed copy(List<IMSessionCard> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new IMActionClearAllSessionsSucceed(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMActionClearAllSessionsSucceed) && Intrinsics.areEqual(this.list, ((IMActionClearAllSessionsSucceed) obj).list);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "IMActionClearAllSessionsSucceed(list=" + this.list + ")";
    }

    public IMActionClearAllSessionsSucceed(List<IMSessionCard> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public final List<IMSessionCard> getList() {
        return this.list;
    }
}