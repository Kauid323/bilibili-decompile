package home.sidecenter.selection;

import com.bapis.bilibili.app.home.v1.KMineSelection;
import com.bapis.bilibili.app.home.v1.KMineSelectionContentRes;
import com.bapis.bilibili.app.home.v1.KMineSelectionOptionItemsRes;
import com.bapis.bilibili.app.home.v1.KSimpleMineSection;
import home.sidecenter.recent.MineSelection;
import home.sidecenter.recent.RecentIconItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSelection.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\nJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003JI\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0001J\u0013\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001b¨\u00061"}, d2 = {"Lhome/sidecenter/selection/SideCenterSelectionState;", "", "pageStatus", "Lhome/sidecenter/selection/SideCenterSelectionPageStatus;", "toast", "", "initSelection", "Lhome/sidecenter/recent/MineSelection;", "selected", "", "Lhome/sidecenter/recent/RecentIconItem;", "initSections", "Lhome/sidecenter/selection/SimpleMineSection;", "<init>", "(Lhome/sidecenter/selection/SideCenterSelectionPageStatus;Ljava/lang/String;Lhome/sidecenter/recent/MineSelection;Ljava/util/List;Ljava/util/List;)V", "selectedRes", "Lcom/bapis/bilibili/app/home/v1/KMineSelectionContentRes;", "optionsRes", "Lcom/bapis/bilibili/app/home/v1/KMineSelectionOptionItemsRes;", "(Lcom/bapis/bilibili/app/home/v1/KMineSelectionContentRes;Lcom/bapis/bilibili/app/home/v1/KMineSelectionOptionItemsRes;)V", "getPageStatus", "()Lhome/sidecenter/selection/SideCenterSelectionPageStatus;", "getToast", "()Ljava/lang/String;", "getInitSelection", "()Lhome/sidecenter/recent/MineSelection;", "getSelected", "()Ljava/util/List;", "getInitSections", "showSave", "", "getShowSave", "()Z", "sections", "getSections", "addItem", "item", "removeItem", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSelectionState {
    public static final int $stable = 8;
    private final List<SimpleMineSection> initSections;
    private final MineSelection initSelection;
    private final SideCenterSelectionPageStatus pageStatus;
    private final List<SimpleMineSection> sections;
    private final List<RecentIconItem> selected;
    private final boolean showSave;
    private final String toast;

    public SideCenterSelectionState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SideCenterSelectionState copy$default(SideCenterSelectionState sideCenterSelectionState, SideCenterSelectionPageStatus sideCenterSelectionPageStatus, String str, MineSelection mineSelection, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sideCenterSelectionPageStatus = sideCenterSelectionState.pageStatus;
        }
        if ((i2 & 2) != 0) {
            str = sideCenterSelectionState.toast;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            mineSelection = sideCenterSelectionState.initSelection;
        }
        MineSelection mineSelection2 = mineSelection;
        List<RecentIconItem> list3 = list;
        if ((i2 & 8) != 0) {
            list3 = sideCenterSelectionState.selected;
        }
        List list4 = list3;
        List<SimpleMineSection> list5 = list2;
        if ((i2 & 16) != 0) {
            list5 = sideCenterSelectionState.initSections;
        }
        return sideCenterSelectionState.copy(sideCenterSelectionPageStatus, str2, mineSelection2, list4, list5);
    }

    public final SideCenterSelectionPageStatus component1() {
        return this.pageStatus;
    }

    public final String component2() {
        return this.toast;
    }

    public final MineSelection component3() {
        return this.initSelection;
    }

    public final List<RecentIconItem> component4() {
        return this.selected;
    }

    public final List<SimpleMineSection> component5() {
        return this.initSections;
    }

    public final SideCenterSelectionState copy(SideCenterSelectionPageStatus sideCenterSelectionPageStatus, String str, MineSelection mineSelection, List<RecentIconItem> list, List<SimpleMineSection> list2) {
        Intrinsics.checkNotNullParameter(sideCenterSelectionPageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(str, "toast");
        Intrinsics.checkNotNullParameter(list, "selected");
        Intrinsics.checkNotNullParameter(list2, "initSections");
        return new SideCenterSelectionState(sideCenterSelectionPageStatus, str, mineSelection, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SideCenterSelectionState) {
            SideCenterSelectionState sideCenterSelectionState = (SideCenterSelectionState) obj;
            return this.pageStatus == sideCenterSelectionState.pageStatus && Intrinsics.areEqual(this.toast, sideCenterSelectionState.toast) && Intrinsics.areEqual(this.initSelection, sideCenterSelectionState.initSelection) && Intrinsics.areEqual(this.selected, sideCenterSelectionState.selected) && Intrinsics.areEqual(this.initSections, sideCenterSelectionState.initSections);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.pageStatus.hashCode() * 31) + this.toast.hashCode()) * 31) + (this.initSelection == null ? 0 : this.initSelection.hashCode())) * 31) + this.selected.hashCode()) * 31) + this.initSections.hashCode();
    }

    public String toString() {
        SideCenterSelectionPageStatus sideCenterSelectionPageStatus = this.pageStatus;
        String str = this.toast;
        MineSelection mineSelection = this.initSelection;
        List<RecentIconItem> list = this.selected;
        return "SideCenterSelectionState(pageStatus=" + sideCenterSelectionPageStatus + ", toast=" + str + ", initSelection=" + mineSelection + ", selected=" + list + ", initSections=" + this.initSections + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SideCenterSelectionState(SideCenterSelectionPageStatus pageStatus, String toast, MineSelection initSelection, List<RecentIconItem> list, List<SimpleMineSection> list2) {
        List<RecentIconItem> emptyList;
        boolean z;
        Iterable $this$mapTo$iv$iv;
        Object obj;
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(list, "selected");
        Intrinsics.checkNotNullParameter(list2, "initSections");
        this.pageStatus = pageStatus;
        this.toast = toast;
        this.initSelection = initSelection;
        this.selected = list;
        this.initSections = list2;
        if (this.pageStatus == SideCenterSelectionPageStatus.Success || this.pageStatus == SideCenterSelectionPageStatus.UpdateSuccess) {
            List<RecentIconItem> list3 = this.selected;
            MineSelection mineSelection = this.initSelection;
            if (!Intrinsics.areEqual(list3, (mineSelection == null || (emptyList = mineSelection.getItems()) == null) ? CollectionsKt.emptyList() : emptyList)) {
                z = true;
                this.showSave = z;
                Iterable $this$map$iv = this.initSections;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    SimpleMineSection section = (SimpleMineSection) item$iv$iv;
                    String id = section.getId();
                    String name = section.getName();
                    Iterable items = section.getItems();
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                    Iterable $this$mapTo$iv$iv2 = items;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                        RecentIconItem initItem = (RecentIconItem) item$iv$iv2;
                        Iterator it = this.selected.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            RecentIconItem it2 = (RecentIconItem) obj;
                            Iterator it3 = it;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                            if (Intrinsics.areEqual(initItem.getId(), it2.getId())) {
                                break;
                            }
                            it = it3;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                        }
                        destination$iv$iv2.add(RecentIconItem.copy$default(initItem, null, null, null, null, null, false, obj != null, 63, null));
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    }
                    destination$iv$iv.add(new SimpleMineSection(id, name, (List) destination$iv$iv2));
                }
                this.sections = (List) destination$iv$iv;
            }
        }
        z = false;
        this.showSave = z;
        Iterable $this$map$iv2 = this.initSections;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r14.hasNext()) {
        }
        this.sections = (List) destination$iv$iv3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SideCenterSelectionState(SideCenterSelectionPageStatus sideCenterSelectionPageStatus, String str, MineSelection mineSelection, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sideCenterSelectionPageStatus, r10, r0, r1, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list2);
        List list3;
        List<RecentIconItem> emptyList;
        sideCenterSelectionPageStatus = (i2 & 1) != 0 ? SideCenterSelectionPageStatus.Idle : sideCenterSelectionPageStatus;
        String str2 = (i2 & 2) != 0 ? "" : str;
        MineSelection mineSelection2 = (i2 & 4) != 0 ? null : mineSelection;
        if ((i2 & 8) != 0) {
            list3 = (mineSelection2 == null || (emptyList = mineSelection2.getItems()) == null) ? CollectionsKt.emptyList() : emptyList;
        } else {
            list3 = list;
        }
    }

    public final SideCenterSelectionPageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final String getToast() {
        return this.toast;
    }

    public final MineSelection getInitSelection() {
        return this.initSelection;
    }

    public final List<RecentIconItem> getSelected() {
        return this.selected;
    }

    public final List<SimpleMineSection> getInitSections() {
        return this.initSections;
    }

    public final boolean getShowSave() {
        return this.showSave;
    }

    public final List<SimpleMineSection> getSections() {
        return this.sections;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SideCenterSelectionState(KMineSelectionContentRes selectedRes, KMineSelectionOptionItemsRes optionsRes) {
        this(r2, null, r4, null, (List) destination$iv$iv, 10, null);
        Intrinsics.checkNotNullParameter(selectedRes, "selectedRes");
        Intrinsics.checkNotNullParameter(optionsRes, "optionsRes");
        SideCenterSelectionPageStatus sideCenterSelectionPageStatus = SideCenterSelectionPageStatus.Success;
        KMineSelection it = selectedRes.getMineSelection();
        MineSelection mineSelection = it != null ? new MineSelection(it) : null;
        Iterable $this$map$iv = optionsRes.getSections();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(new SimpleMineSection((KSimpleMineSection) item$iv$iv));
        }
    }

    public final SideCenterSelectionState addItem(RecentIconItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return copy$default(this, null, null, null, CollectionsKt.plus(this.selected, RecentIconItem.copy$default(item, null, null, null, null, null, false, true, 63, null)), null, 23, null);
    }

    public final SideCenterSelectionState removeItem(RecentIconItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Iterable $this$filter$iv = this.selected;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            RecentIconItem it = (RecentIconItem) element$iv$iv;
            if (!Intrinsics.areEqual(it.getId(), item.getId())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return copy$default(this, null, null, null, (List) destination$iv$iv, null, 23, null);
    }
}