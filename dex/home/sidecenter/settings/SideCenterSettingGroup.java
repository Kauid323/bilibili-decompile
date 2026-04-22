package home.sidecenter.settings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0002HÂ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingGroup;", "Lhome/sidecenter/settings/ISideCenterSettingGroup;", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "item", "items", "", "<init>", "(Lhome/sidecenter/settings/ISideCenterSettingItem;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setChecked", "isChecked", "", "setItemChecked", "isTypeChecked", "type", "Lhome/sidecenter/settings/SideCenterSettingType;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "()Z", "tab", "getTab", "()Lhome/sidecenter/settings/SideCenterSettingType;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSettingGroup implements ISideCenterSettingGroup, ISideCenterSettingItem {
    public static final int $stable = 8;
    private final ISideCenterSettingItem item;
    private final List<ISideCenterSettingItem> items;

    private final ISideCenterSettingItem component1() {
        return this.item;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SideCenterSettingGroup copy$default(SideCenterSettingGroup sideCenterSettingGroup, ISideCenterSettingItem iSideCenterSettingItem, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iSideCenterSettingItem = sideCenterSettingGroup.item;
        }
        if ((i2 & 2) != 0) {
            list = sideCenterSettingGroup.items;
        }
        return sideCenterSettingGroup.copy(iSideCenterSettingItem, list);
    }

    public final List<ISideCenterSettingItem> component2() {
        return this.items;
    }

    public final SideCenterSettingGroup copy(ISideCenterSettingItem iSideCenterSettingItem, List<? extends ISideCenterSettingItem> list) {
        Intrinsics.checkNotNullParameter(iSideCenterSettingItem, "item");
        Intrinsics.checkNotNullParameter(list, "items");
        return new SideCenterSettingGroup(iSideCenterSettingItem, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SideCenterSettingGroup) {
            SideCenterSettingGroup sideCenterSettingGroup = (SideCenterSettingGroup) obj;
            return Intrinsics.areEqual(this.item, sideCenterSettingGroup.item) && Intrinsics.areEqual(this.items, sideCenterSettingGroup.items);
        }
        return false;
    }

    @Override // home.sidecenter.settings.ISideCenterSettingItem
    public SideCenterSettingType getTab() {
        return this.item.getTab();
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.items.hashCode();
    }

    @Override // home.sidecenter.settings.ISideCenterSettingItem
    public boolean isChecked() {
        return this.item.isChecked();
    }

    public String toString() {
        ISideCenterSettingItem iSideCenterSettingItem = this.item;
        return "SideCenterSettingGroup(item=" + iSideCenterSettingItem + ", items=" + this.items + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SideCenterSettingGroup(ISideCenterSettingItem item, List<? extends ISideCenterSettingItem> list) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(list, "items");
        this.item = item;
        this.items = list;
    }

    public /* synthetic */ SideCenterSettingGroup(ISideCenterSettingItem iSideCenterSettingItem, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSideCenterSettingItem, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Override // home.sidecenter.settings.ISideCenterSettingGroup
    public List<ISideCenterSettingItem> getItems() {
        return this.items;
    }

    @Override // home.sidecenter.settings.ISideCenterSettingItem
    public ISideCenterSettingItem setChecked(boolean isChecked) {
        return copy$default(this, this.item.setChecked(isChecked), null, 2, null);
    }

    @Override // home.sidecenter.settings.ISideCenterSettingGroup
    public ISideCenterSettingGroup setItemChecked(ISideCenterSettingItem item, boolean isChecked) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getTab().isGroup()) {
            if (getTab() == item.getTab()) {
                ISideCenterSettingItem checked = item.setChecked(isChecked);
                Iterable $this$map$iv = getItems();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(((ISideCenterSettingItem) item$iv$iv).setChecked(false));
                }
                return copy(checked, (List) destination$iv$iv);
            }
        } else if (getItems().contains(item)) {
            Iterable $this$map$iv2 = getItems();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                ISideCenterSettingItem it = (ISideCenterSettingItem) item$iv$iv2;
                if (it.getTab() == item.getTab()) {
                    it = it.setChecked(isChecked);
                }
                destination$iv$iv2.add(it);
            }
            return copy$default(this, null, (List) destination$iv$iv2, 1, null);
        }
        return this;
    }

    @Override // home.sidecenter.settings.ISideCenterSettingGroup
    public boolean isTypeChecked(SideCenterSettingType type) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(type, "type");
        if (getTab() == type) {
            return this.item.isChecked();
        }
        Iterator<T> it = getItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISideCenterSettingItem it2 = (ISideCenterSettingItem) obj;
            if (it2.getTab() == type) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ISideCenterSettingItem iSideCenterSettingItem = (ISideCenterSettingItem) obj;
        if (iSideCenterSettingItem != null) {
            return iSideCenterSettingItem.isChecked();
        }
        return false;
    }
}