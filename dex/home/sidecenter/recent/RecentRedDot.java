package home.sidecenter.recent;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.home.v1.KRedDot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentPageState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lhome/sidecenter/recent/RecentRedDot;", "", "show", "", "num", "", "<init>", "(ZJ)V", "builder", "Lcom/bapis/bilibili/app/home/v1/KRedDot;", "(Lcom/bapis/bilibili/app/home/v1/KRedDot;)V", "getShow", "()Z", "getNum", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentRedDot {
    public static final int $stable = 0;
    private final long num;
    private final boolean show;

    public static /* synthetic */ RecentRedDot copy$default(RecentRedDot recentRedDot, boolean z, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = recentRedDot.show;
        }
        if ((i2 & 2) != 0) {
            j = recentRedDot.num;
        }
        return recentRedDot.copy(z, j);
    }

    public final boolean component1() {
        return this.show;
    }

    public final long component2() {
        return this.num;
    }

    public final RecentRedDot copy(boolean z, long j) {
        return new RecentRedDot(z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentRedDot) {
            RecentRedDot recentRedDot = (RecentRedDot) obj;
            return this.show == recentRedDot.show && this.num == recentRedDot.num;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.show) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.num);
    }

    public String toString() {
        boolean z = this.show;
        return "RecentRedDot(show=" + z + ", num=" + this.num + ")";
    }

    public RecentRedDot(boolean show, long num) {
        this.show = show;
        this.num = num;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final long getNum() {
        return this.num;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentRedDot(KRedDot builder) {
        this(builder.getShow(), builder.getNum());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }
}