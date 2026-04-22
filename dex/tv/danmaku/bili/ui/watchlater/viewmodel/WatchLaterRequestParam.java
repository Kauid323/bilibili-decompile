package tv.danmaku.bili.ui.watchlater.viewmodel;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterRequestParam;", "", "startKey", "", "", "sortField", "", "", "splitKey", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getStartKey", "()Ljava/util/List;", "getSortField", "getSplitKey", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterRequestParam {
    public static final int $stable = 8;
    private final List<Integer> sortField;
    private final String splitKey;
    private final List<String> startKey;

    public WatchLaterRequestParam() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WatchLaterRequestParam copy$default(WatchLaterRequestParam watchLaterRequestParam, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = watchLaterRequestParam.startKey;
        }
        if ((i & 2) != 0) {
            list2 = watchLaterRequestParam.sortField;
        }
        if ((i & 4) != 0) {
            str = watchLaterRequestParam.splitKey;
        }
        return watchLaterRequestParam.copy(list, list2, str);
    }

    public final List<String> component1() {
        return this.startKey;
    }

    public final List<Integer> component2() {
        return this.sortField;
    }

    public final String component3() {
        return this.splitKey;
    }

    public final WatchLaterRequestParam copy(List<String> list, List<Integer> list2, String str) {
        Intrinsics.checkNotNullParameter(list, "startKey");
        Intrinsics.checkNotNullParameter(list2, "sortField");
        Intrinsics.checkNotNullParameter(str, "splitKey");
        return new WatchLaterRequestParam(list, list2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterRequestParam) {
            WatchLaterRequestParam watchLaterRequestParam = (WatchLaterRequestParam) obj;
            return Intrinsics.areEqual(this.startKey, watchLaterRequestParam.startKey) && Intrinsics.areEqual(this.sortField, watchLaterRequestParam.sortField) && Intrinsics.areEqual(this.splitKey, watchLaterRequestParam.splitKey);
        }
        return false;
    }

    public int hashCode() {
        return (((this.startKey.hashCode() * 31) + this.sortField.hashCode()) * 31) + this.splitKey.hashCode();
    }

    public String toString() {
        List<String> list = this.startKey;
        List<Integer> list2 = this.sortField;
        return "WatchLaterRequestParam(startKey=" + list + ", sortField=" + list2 + ", splitKey=" + this.splitKey + ")";
    }

    public WatchLaterRequestParam(List<String> list, List<Integer> list2, String splitKey) {
        Intrinsics.checkNotNullParameter(list, "startKey");
        Intrinsics.checkNotNullParameter(list2, "sortField");
        Intrinsics.checkNotNullParameter(splitKey, "splitKey");
        this.startKey = list;
        this.sortField = list2;
        this.splitKey = splitKey;
    }

    public /* synthetic */ WatchLaterRequestParam(List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.mutableListOf(new String[]{"", ""}) : list, (i & 2) != 0 ? CollectionsKt.listOf(new Integer[]{1, 10}) : list2, (i & 4) != 0 ? "" : str);
    }

    public final List<String> getStartKey() {
        return this.startKey;
    }

    public final List<Integer> getSortField() {
        return this.sortField;
    }

    public final String getSplitKey() {
        return this.splitKey;
    }
}