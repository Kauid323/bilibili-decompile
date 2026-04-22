package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KIconItem;
import com.bapis.bilibili.app.home.v1.KModuleInfo;
import com.bapis.bilibili.app.home.v1.KRecentUsed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lhome/sidecenter/recent/RecentUsed;", "", "info", "Lhome/sidecenter/recent/RecentModuleInfo;", "items", "", "Lhome/sidecenter/recent/RecentIconItem;", "<init>", "(Lhome/sidecenter/recent/RecentModuleInfo;Ljava/util/List;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/KRecentUsed;", "(Lcom/bapis/bilibili/app/home/v1/KRecentUsed;)V", "getInfo", "()Lhome/sidecenter/recent/RecentModuleInfo;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentUsed {
    public static final int $stable = 8;
    private final RecentModuleInfo info;
    private final List<RecentIconItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentUsed copy$default(RecentUsed recentUsed, RecentModuleInfo recentModuleInfo, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            recentModuleInfo = recentUsed.info;
        }
        if ((i2 & 2) != 0) {
            list = recentUsed.items;
        }
        return recentUsed.copy(recentModuleInfo, list);
    }

    public final RecentModuleInfo component1() {
        return this.info;
    }

    public final List<RecentIconItem> component2() {
        return this.items;
    }

    public final RecentUsed copy(RecentModuleInfo recentModuleInfo, List<RecentIconItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new RecentUsed(recentModuleInfo, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentUsed) {
            RecentUsed recentUsed = (RecentUsed) obj;
            return Intrinsics.areEqual(this.info, recentUsed.info) && Intrinsics.areEqual(this.items, recentUsed.items);
        }
        return false;
    }

    public int hashCode() {
        return ((this.info == null ? 0 : this.info.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        RecentModuleInfo recentModuleInfo = this.info;
        return "RecentUsed(info=" + recentModuleInfo + ", items=" + this.items + ")";
    }

    public RecentUsed(RecentModuleInfo info, List<RecentIconItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.info = info;
        this.items = list;
    }

    public final RecentModuleInfo getInfo() {
        return this.info;
    }

    public final List<RecentIconItem> getItems() {
        return this.items;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentUsed(KRecentUsed builder) {
        this(r2, (List) destination$iv$iv);
        Intrinsics.checkNotNullParameter(builder, "builder");
        KModuleInfo it = builder.getModuleInfo();
        RecentModuleInfo recentModuleInfo = it != null ? new RecentModuleInfo(it) : null;
        Iterable $this$map$iv = builder.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(new RecentIconItem((KIconItem) item$iv$iv));
        }
    }
}