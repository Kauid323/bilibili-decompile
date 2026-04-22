package kntr.common.compose.chart.model;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.ui.graphics.Color;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PieData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lkntr/common/compose/chart/model/PieDataItem;", "", "name", "", "color", "Landroidx/compose/ui/graphics/Color;", "count", "", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/Color;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getCount", "()J", "component1", "component2", "component2-QN2ZGVo", "component3", "copy", "copy-bi-UJ9A", "equals", "", "other", "hashCode", "", "toString", "compose-chart_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PieDataItem {
    public static final int $stable = 0;
    private final Color color;
    private final long count;
    private final String name;

    public /* synthetic */ PieDataItem(String str, Color color, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, j);
    }

    /* renamed from: copy-bi-UJ9A$default  reason: not valid java name */
    public static /* synthetic */ PieDataItem m1835copybiUJ9A$default(PieDataItem pieDataItem, String str, Color color, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pieDataItem.name;
        }
        if ((i & 2) != 0) {
            color = pieDataItem.color;
        }
        if ((i & 4) != 0) {
            j = pieDataItem.count;
        }
        return pieDataItem.m1837copybiUJ9A(str, color, j);
    }

    public final String component1() {
        return this.name;
    }

    /* renamed from: component2-QN2ZGVo  reason: not valid java name */
    public final Color m1836component2QN2ZGVo() {
        return this.color;
    }

    public final long component3() {
        return this.count;
    }

    /* renamed from: copy-bi-UJ9A  reason: not valid java name */
    public final PieDataItem m1837copybiUJ9A(String str, Color color, long j) {
        return new PieDataItem(str, color, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PieDataItem) {
            PieDataItem pieDataItem = (PieDataItem) obj;
            return Intrinsics.areEqual(this.name, pieDataItem.name) && Intrinsics.areEqual(this.color, pieDataItem.color) && this.count == pieDataItem.count;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.color != null ? Color.hashCode-impl(this.color.unbox-impl()) : 0)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.count);
    }

    public String toString() {
        String str = this.name;
        Color color = this.color;
        return "PieDataItem(name=" + str + ", color=" + color + ", count=" + this.count + ")";
    }

    private PieDataItem(String name, Color color, long count) {
        this.name = name;
        this.color = color;
        this.count = count;
    }

    public /* synthetic */ PieDataItem(String str, Color color, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : color, (i & 4) != 0 ? 0L : j, null);
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: getColor-QN2ZGVo  reason: not valid java name */
    public final Color m1838getColorQN2ZGVo() {
        return this.color;
    }

    public final long getCount() {
        return this.count;
    }
}