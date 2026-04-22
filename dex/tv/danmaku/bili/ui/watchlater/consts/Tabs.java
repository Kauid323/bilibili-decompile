package tv.danmaku.bili.ui.watchlater.consts;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterConsts.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/consts/Tabs;", "", "tabs", "", "", "<init>", "(Ljava/util/List;)V", "getTabs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Tabs {
    public static final int $stable = 0;
    private final List<String> tabs;

    public Tabs() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tabs copy$default(Tabs tabs, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tabs.tabs;
        }
        return tabs.copy(list);
    }

    public final List<String> component1() {
        return this.tabs;
    }

    public final Tabs copy(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        return new Tabs(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tabs) && Intrinsics.areEqual(this.tabs, ((Tabs) obj).tabs);
    }

    public int hashCode() {
        return this.tabs.hashCode();
    }

    public String toString() {
        return "Tabs(tabs=" + this.tabs + ")";
    }

    public Tabs(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.tabs = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Tabs(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
        String allTabName;
        String continueTabName;
        if ((i & 1) != 0) {
            allTabName = WatchLaterConstsKt.getAllTabName();
            continueTabName = WatchLaterConstsKt.getContinueTabName();
            list = CollectionsKt.listOf(new String[]{allTabName, continueTabName});
        }
    }

    public final List<String> getTabs() {
        return this.tabs;
    }
}