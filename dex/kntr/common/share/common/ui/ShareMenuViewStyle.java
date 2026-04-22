package kntr.common.share.common.ui;

import BottomSheetItemData$;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuViewStyle.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewStyle;", "", "itemSize", "Landroidx/compose/ui/unit/DpSize;", "getItemSize-MYxV2XQ", "()J", "itemMinSpacing", "Landroidx/compose/ui/unit/Dp;", "getItemMinSpacing-D9Ej5fM", "()F", "Horizontal", "Vertical", "Lkntr/common/share/common/ui/ShareMenuViewStyle$Horizontal;", "Lkntr/common/share/common/ui/ShareMenuViewStyle$Vertical;", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ShareMenuViewStyle {
    /* renamed from: getItemMinSpacing-D9Ej5fM  reason: not valid java name */
    float mo2369getItemMinSpacingD9Ej5fM();

    /* renamed from: getItemSize-MYxV2XQ  reason: not valid java name */
    long mo2370getItemSizeMYxV2XQ();

    /* compiled from: ShareMenuViewStyle.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BD\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0013\b\u0002\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0012J\u0019\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b \u0010\u0018J\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u0012JM\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0013\b\u0002\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewStyle$Horizontal;", "Lkntr/common/share/common/ui/ShareMenuViewStyle;", "multiLine", "", "lineSpacing", "Landroidx/compose/ui/unit/Dp;", "separator", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "itemSize", "Landroidx/compose/ui/unit/DpSize;", "itemMinSpacing", "<init>", "(ZFLkotlin/jvm/functions/Function2;JFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMultiLine", "()Z", "getLineSpacing-D9Ej5fM", "()F", "F", "getSeparator", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getItemSize-MYxV2XQ", "()J", "J", "getItemMinSpacing-D9Ej5fM", "component1", "component2", "component2-D9Ej5fM", "component3", "component4", "component4-MYxV2XQ", "component5", "component5-D9Ej5fM", "copy", "copy-zZbA6Wc", "(ZFLkotlin/jvm/functions/Function2;JF)Lkntr/common/share/common/ui/ShareMenuViewStyle$Horizontal;", "equals", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Horizontal implements ShareMenuViewStyle {
        public static final int $stable = 0;
        private final float itemMinSpacing;
        private final long itemSize;
        private final float lineSpacing;
        private final boolean multiLine;
        private final Function2<Composer, Integer, Unit> separator;

        public /* synthetic */ Horizontal(boolean z, float f, Function2 function2, long j, float f2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, f, function2, j, f2);
        }

        /* renamed from: copy-zZbA6Wc$default  reason: not valid java name */
        public static /* synthetic */ Horizontal m2371copyzZbA6Wc$default(Horizontal horizontal, boolean z, float f, Function2 function2, long j, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = horizontal.multiLine;
            }
            if ((i & 2) != 0) {
                f = horizontal.lineSpacing;
            }
            float f3 = f;
            Function2<Composer, Integer, Unit> function22 = function2;
            if ((i & 4) != 0) {
                function22 = horizontal.separator;
            }
            Function2 function23 = function22;
            if ((i & 8) != 0) {
                j = horizontal.itemSize;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                f2 = horizontal.itemMinSpacing;
            }
            return horizontal.m2375copyzZbA6Wc(z, f3, function23, j2, f2);
        }

        public final boolean component1() {
            return this.multiLine;
        }

        /* renamed from: component2-D9Ej5fM  reason: not valid java name */
        public final float m2372component2D9Ej5fM() {
            return this.lineSpacing;
        }

        public final Function2<Composer, Integer, Unit> component3() {
            return this.separator;
        }

        /* renamed from: component4-MYxV2XQ  reason: not valid java name */
        public final long m2373component4MYxV2XQ() {
            return this.itemSize;
        }

        /* renamed from: component5-D9Ej5fM  reason: not valid java name */
        public final float m2374component5D9Ej5fM() {
            return this.itemMinSpacing;
        }

        /* renamed from: copy-zZbA6Wc  reason: not valid java name */
        public final Horizontal m2375copyzZbA6Wc(boolean z, float f, Function2<? super Composer, ? super Integer, Unit> function2, long j, float f2) {
            Intrinsics.checkNotNullParameter(function2, "separator");
            return new Horizontal(z, f, function2, j, f2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Horizontal) {
                Horizontal horizontal = (Horizontal) obj;
                return this.multiLine == horizontal.multiLine && Dp.equals-impl0(this.lineSpacing, horizontal.lineSpacing) && Intrinsics.areEqual(this.separator, horizontal.separator) && DpSize.equals-impl0(this.itemSize, horizontal.itemSize) && Dp.equals-impl0(this.itemMinSpacing, horizontal.itemMinSpacing);
            }
            return false;
        }

        public int hashCode() {
            return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.multiLine) * 31) + Dp.hashCode-impl(this.lineSpacing)) * 31) + this.separator.hashCode()) * 31) + DpSize.hashCode-impl(this.itemSize)) * 31) + Dp.hashCode-impl(this.itemMinSpacing);
        }

        public String toString() {
            boolean z = this.multiLine;
            String str = Dp.toString-impl(this.lineSpacing);
            Function2<Composer, Integer, Unit> function2 = this.separator;
            String str2 = DpSize.toString-impl(this.itemSize);
            return "Horizontal(multiLine=" + z + ", lineSpacing=" + str + ", separator=" + function2 + ", itemSize=" + str2 + ", itemMinSpacing=" + Dp.toString-impl(this.itemMinSpacing) + ")";
        }

        private Horizontal(boolean multiLine, float lineSpacing, Function2<? super Composer, ? super Integer, Unit> function2, long itemSize, float itemMinSpacing) {
            Intrinsics.checkNotNullParameter(function2, "separator");
            this.multiLine = multiLine;
            this.lineSpacing = lineSpacing;
            this.separator = function2;
            this.itemSize = itemSize;
            this.itemMinSpacing = itemMinSpacing;
        }

        public /* synthetic */ Horizontal(boolean z, float f, Function2 function2, long j, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? Dp.constructor-impl(32) : f, (i & 4) != 0 ? ComposableSingletons$ShareMenuViewStyleKt.INSTANCE.m2364getLambda$1256405005$common_ui_debug() : function2, (i & 8) != 0 ? DpKt.DpSize-YgX7TsA(Dp.constructor-impl(66), Dp.constructor-impl(72)) : j, (i & 16) != 0 ? Dp.constructor-impl(0) : f2, null);
        }

        public final boolean getMultiLine() {
            return this.multiLine;
        }

        /* renamed from: getLineSpacing-D9Ej5fM  reason: not valid java name */
        public final float m2376getLineSpacingD9Ej5fM() {
            return this.lineSpacing;
        }

        public final Function2<Composer, Integer, Unit> getSeparator() {
            return this.separator;
        }

        @Override // kntr.common.share.common.ui.ShareMenuViewStyle
        /* renamed from: getItemSize-MYxV2XQ */
        public long mo2370getItemSizeMYxV2XQ() {
            return this.itemSize;
        }

        @Override // kntr.common.share.common.ui.ShareMenuViewStyle
        /* renamed from: getItemMinSpacing-D9Ej5fM */
        public float mo2369getItemMinSpacingD9Ej5fM() {
            return this.itemMinSpacing;
        }
    }

    /* compiled from: ShareMenuViewStyle.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0012J\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015JB\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006)"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewStyle$Vertical;", "Lkntr/common/share/common/ui/ShareMenuViewStyle;", "maxRows", "", "scrollable", "", "itemSize", "Landroidx/compose/ui/unit/DpSize;", "itemMinSpacing", "Landroidx/compose/ui/unit/Dp;", "lineSpacing", "<init>", "(IZJFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxRows", "()I", "getScrollable", "()Z", "getItemSize-MYxV2XQ", "()J", "J", "getItemMinSpacing-D9Ej5fM", "()F", "F", "getLineSpacing-D9Ej5fM", "component1", "component2", "component3", "component3-MYxV2XQ", "component4", "component4-D9Ej5fM", "component5", "component5-D9Ej5fM", "copy", "copy-xY_ui2w", "(IZJFF)Lkntr/common/share/common/ui/ShareMenuViewStyle$Vertical;", "equals", "other", "", "hashCode", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Vertical implements ShareMenuViewStyle {
        public static final int $stable = 0;
        private final float itemMinSpacing;
        private final long itemSize;
        private final float lineSpacing;
        private final int maxRows;
        private final boolean scrollable;

        public /* synthetic */ Vertical(int i, boolean z, long j, float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z, j, f, f2);
        }

        /* renamed from: copy-xY_ui2w$default  reason: not valid java name */
        public static /* synthetic */ Vertical m2377copyxY_ui2w$default(Vertical vertical, int i, boolean z, long j, float f, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = vertical.maxRows;
            }
            if ((i2 & 2) != 0) {
                z = vertical.scrollable;
            }
            boolean z2 = z;
            if ((i2 & 4) != 0) {
                j = vertical.itemSize;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                f = vertical.itemMinSpacing;
            }
            float f3 = f;
            if ((i2 & 16) != 0) {
                f2 = vertical.lineSpacing;
            }
            return vertical.m2381copyxY_ui2w(i, z2, j2, f3, f2);
        }

        public final int component1() {
            return this.maxRows;
        }

        public final boolean component2() {
            return this.scrollable;
        }

        /* renamed from: component3-MYxV2XQ  reason: not valid java name */
        public final long m2378component3MYxV2XQ() {
            return this.itemSize;
        }

        /* renamed from: component4-D9Ej5fM  reason: not valid java name */
        public final float m2379component4D9Ej5fM() {
            return this.itemMinSpacing;
        }

        /* renamed from: component5-D9Ej5fM  reason: not valid java name */
        public final float m2380component5D9Ej5fM() {
            return this.lineSpacing;
        }

        /* renamed from: copy-xY_ui2w  reason: not valid java name */
        public final Vertical m2381copyxY_ui2w(int i, boolean z, long j, float f, float f2) {
            return new Vertical(i, z, j, f, f2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Vertical) {
                Vertical vertical = (Vertical) obj;
                return this.maxRows == vertical.maxRows && this.scrollable == vertical.scrollable && DpSize.equals-impl0(this.itemSize, vertical.itemSize) && Dp.equals-impl0(this.itemMinSpacing, vertical.itemMinSpacing) && Dp.equals-impl0(this.lineSpacing, vertical.lineSpacing);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.maxRows * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.scrollable)) * 31) + DpSize.hashCode-impl(this.itemSize)) * 31) + Dp.hashCode-impl(this.itemMinSpacing)) * 31) + Dp.hashCode-impl(this.lineSpacing);
        }

        public String toString() {
            int i = this.maxRows;
            boolean z = this.scrollable;
            String str = DpSize.toString-impl(this.itemSize);
            String str2 = Dp.toString-impl(this.itemMinSpacing);
            return "Vertical(maxRows=" + i + ", scrollable=" + z + ", itemSize=" + str + ", itemMinSpacing=" + str2 + ", lineSpacing=" + Dp.toString-impl(this.lineSpacing) + ")";
        }

        private Vertical(int maxRows, boolean scrollable, long itemSize, float itemMinSpacing, float lineSpacing) {
            this.maxRows = maxRows;
            this.scrollable = scrollable;
            this.itemSize = itemSize;
            this.itemMinSpacing = itemMinSpacing;
            this.lineSpacing = lineSpacing;
        }

        public /* synthetic */ Vertical(int i, boolean z, long j, float f, float f2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? DpKt.DpSize-YgX7TsA(Dp.constructor-impl(68), Dp.constructor-impl(68)) : j, (i2 & 8) != 0 ? Dp.constructor-impl(0) : f, (i2 & 16) != 0 ? Dp.constructor-impl(12) : f2, null);
        }

        public final int getMaxRows() {
            return this.maxRows;
        }

        public final boolean getScrollable() {
            return this.scrollable;
        }

        @Override // kntr.common.share.common.ui.ShareMenuViewStyle
        /* renamed from: getItemSize-MYxV2XQ */
        public long mo2370getItemSizeMYxV2XQ() {
            return this.itemSize;
        }

        @Override // kntr.common.share.common.ui.ShareMenuViewStyle
        /* renamed from: getItemMinSpacing-D9Ej5fM */
        public float mo2369getItemMinSpacingD9Ej5fM() {
            return this.itemMinSpacing;
        }

        /* renamed from: getLineSpacing-D9Ej5fM  reason: not valid java name */
        public final float m2382getLineSpacingD9Ej5fM() {
            return this.lineSpacing;
        }
    }
}