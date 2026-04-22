package tv.danmaku.bili.appwidget.hotlist.model;

import com.bapis.bilibili.app.show.mixture.v1.WidgetItem;
import com.bapis.bilibili.app.show.mixture.v1.WidgetReply;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;

/* compiled from: HotListWidgetModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "", CommonMenuBottomSheetKt.KEY_ITEMS, "", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetItemModel;", "<init>", "(Ljava/util/List;)V", "reply", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetReply;", "(Lcom/bapis/bilibili/app/show/mixture/v1/WidgetReply;)V", "getItems", "()Ljava/util/List;", "setItems", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListWidgetModel {
    public static final int $stable = 8;
    private List<HotListWidgetItemModel> items;

    public HotListWidgetModel() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotListWidgetModel copy$default(HotListWidgetModel hotListWidgetModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = hotListWidgetModel.items;
        }
        return hotListWidgetModel.copy(list);
    }

    public final List<HotListWidgetItemModel> component1() {
        return this.items;
    }

    public final HotListWidgetModel copy(List<HotListWidgetItemModel> list) {
        return new HotListWidgetModel(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HotListWidgetModel) && Intrinsics.areEqual(this.items, ((HotListWidgetModel) obj).items);
    }

    public int hashCode() {
        if (this.items == null) {
            return 0;
        }
        return this.items.hashCode();
    }

    public String toString() {
        return "HotListWidgetModel(items=" + this.items + ")";
    }

    public HotListWidgetModel(List<HotListWidgetItemModel> list) {
        this.items = list;
    }

    public /* synthetic */ HotListWidgetModel(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<HotListWidgetItemModel> getItems() {
        return this.items;
    }

    public final void setItems(List<HotListWidgetItemModel> list) {
        this.items = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HotListWidgetModel(WidgetReply reply) {
        this(r2);
        ArrayList arrayList;
        Iterable itemList;
        if (reply == null || (itemList = reply.getItemList()) == null) {
            arrayList = null;
        } else {
            Iterable $this$map$iv = itemList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                WidgetItem p0 = (WidgetItem) item$iv$iv;
                destination$iv$iv.add(new HotListWidgetItemModel(p0));
            }
            arrayList = (List) destination$iv$iv;
        }
    }
}