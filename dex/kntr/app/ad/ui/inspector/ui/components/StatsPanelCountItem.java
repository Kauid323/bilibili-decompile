package kntr.app.ad.ui.inspector.ui.components;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatsPanel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/components/StatsPanelCountItem;", RoomRecommendViewModel.EMPTY_CURSOR, "count", RoomRecommendViewModel.EMPTY_CURSOR, "label", RoomRecommendViewModel.EMPTY_CURSOR, "selected", RoomRecommendViewModel.EMPTY_CURSOR, "onClick", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getCount", "()I", "getLabel", "()Ljava/lang/String;", "getSelected", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StatsPanelCountItem {
    public static final int $stable = 0;
    private final int count;
    private final String label;
    private final Function0<Unit> onClick;
    private final boolean selected;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StatsPanelCountItem copy$default(StatsPanelCountItem statsPanelCountItem, int i, String str, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = statsPanelCountItem.count;
        }
        if ((i2 & 2) != 0) {
            str = statsPanelCountItem.label;
        }
        if ((i2 & 4) != 0) {
            z = statsPanelCountItem.selected;
        }
        if ((i2 & 8) != 0) {
            function0 = statsPanelCountItem.onClick;
        }
        return statsPanelCountItem.copy(i, str, z, function0);
    }

    public final int component1() {
        return this.count;
    }

    public final String component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.selected;
    }

    public final Function0<Unit> component4() {
        return this.onClick;
    }

    public final StatsPanelCountItem copy(int i, String str, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return new StatsPanelCountItem(i, str, z, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StatsPanelCountItem) {
            StatsPanelCountItem statsPanelCountItem = (StatsPanelCountItem) obj;
            return this.count == statsPanelCountItem.count && Intrinsics.areEqual(this.label, statsPanelCountItem.label) && this.selected == statsPanelCountItem.selected && Intrinsics.areEqual(this.onClick, statsPanelCountItem.onClick);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.count * 31) + this.label.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.selected)) * 31) + this.onClick.hashCode();
    }

    public String toString() {
        int i = this.count;
        String str = this.label;
        boolean z = this.selected;
        return "StatsPanelCountItem(count=" + i + ", label=" + str + ", selected=" + z + ", onClick=" + this.onClick + ")";
    }

    public StatsPanelCountItem(int count, String label, boolean selected, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.count = count;
        this.label = label;
        this.selected = selected;
        this.onClick = function0;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }
}