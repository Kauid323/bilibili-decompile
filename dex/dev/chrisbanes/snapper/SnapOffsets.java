package dev.chrisbanes.snapper;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapperFlingBehavior.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Ldev/chrisbanes/snapper/SnapOffsets;", "", "()V", "Center", "Lkotlin/Function2;", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;", "", "getCenter", "()Lkotlin/jvm/functions/Function2;", "End", "getEnd", "Start", "getStart", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SnapOffsets {
    public static final int $stable = 0;
    public static final SnapOffsets INSTANCE = new SnapOffsets();
    private static final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> Start = new Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer>() { // from class: dev.chrisbanes.snapper.SnapOffsets$Start$1
        public final Integer invoke(SnapperLayoutInfo layout, SnapperLayoutItemInfo $noName_1) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            Intrinsics.checkNotNullParameter($noName_1, "$noName_1");
            return Integer.valueOf(layout.getStartScrollOffset());
        }
    };
    private static final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> Center = new Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer>() { // from class: dev.chrisbanes.snapper.SnapOffsets$Center$1
        public final Integer invoke(SnapperLayoutInfo layout, SnapperLayoutItemInfo item) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            Intrinsics.checkNotNullParameter(item, "item");
            return Integer.valueOf(layout.getStartScrollOffset() + (((layout.getEndScrollOffset() - layout.getStartScrollOffset()) - item.getSize()) / 2));
        }
    };
    private static final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> End = new Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer>() { // from class: dev.chrisbanes.snapper.SnapOffsets$End$1
        public final Integer invoke(SnapperLayoutInfo layout, SnapperLayoutItemInfo item) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            Intrinsics.checkNotNullParameter(item, "item");
            return Integer.valueOf(layout.getEndScrollOffset() - item.getSize());
        }
    };

    private SnapOffsets() {
    }

    public final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> getStart() {
        return Start;
    }

    public final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> getCenter() {
        return Center;
    }

    public final Function2<SnapperLayoutInfo, SnapperLayoutItemInfo, Integer> getEnd() {
        return End;
    }
}