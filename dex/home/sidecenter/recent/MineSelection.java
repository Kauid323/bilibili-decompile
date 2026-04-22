package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KIconItem;
import com.bapis.bilibili.app.home.v1.KMineSelection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentPageState.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lhome/sidecenter/recent/MineSelection;", "", "items", "", "Lhome/sidecenter/recent/RecentIconItem;", "<init>", "(Ljava/util/List;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/KMineSelection;", "(Lcom/bapis/bilibili/app/home/v1/KMineSelection;)V", "getItems$annotations", "()V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MineSelection {
    private final List<RecentIconItem> items;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MineSelection copy$default(MineSelection mineSelection, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = mineSelection.items;
        }
        return mineSelection.copy(list);
    }

    public static /* synthetic */ void getItems$annotations() {
    }

    public final List<RecentIconItem> component1() {
        return this.items;
    }

    public final MineSelection copy(List<RecentIconItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new MineSelection(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MineSelection) && Intrinsics.areEqual(this.items, ((MineSelection) obj).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "MineSelection(items=" + this.items + ")";
    }

    public MineSelection(List<RecentIconItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
    }

    public final List<RecentIconItem> getItems() {
        return this.items;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MineSelection(KMineSelection builder) {
        this((List) destination$iv$iv);
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterable $this$map$iv = builder.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KIconItem it = (KIconItem) item$iv$iv;
            destination$iv$iv.add(new RecentIconItem(it));
        }
    }

    /* compiled from: RecentPageState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lhome/sidecenter/recent/MineSelection$Companion;", "", "<init>", "()V", "getLocalItems", "Lhome/sidecenter/recent/MineSelection;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MineSelection getLocalItems() {
            return new MineSelection(CollectionsKt.listOf(new RecentIconItem[]{new RecentIconItem("9000", "", "bilibili://main/drawer/offline", "离线缓存", null, true, false, 64, null), new RecentIconItem("9001", "", "bilibili://main/drawer/history", "历史记录", null, true, false, 64, null), new RecentIconItem("9002", "", "bilibili://main/drawer/favorites", "我的收藏", null, true, false, 64, null), new RecentIconItem("9003", "", "bilibili://user_center/watch_later_v2", "稍后再看", null, true, false, 64, null)}));
        }
    }
}