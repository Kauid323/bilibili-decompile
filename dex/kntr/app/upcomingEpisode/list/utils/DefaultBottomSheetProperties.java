package kntr.app.upcomingEpisode.list.utils;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultBottomSheetProperties.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0015J9\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR'\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lkntr/app/upcomingEpisode/list/utils/DefaultBottomSheetProperties;", "", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "bgColor", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/runtime/Composable;", "scrimColor", "<init>", "(Landroidx/compose/foundation/shape/RoundedCornerShape;Lkotlin/jvm/functions/Function2;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "setShape", "(Landroidx/compose/foundation/shape/RoundedCornerShape;)V", "getBgColor", "()Lkotlin/jvm/functions/Function2;", "setBgColor", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getScrimColor-0d7_KjU", "()J", "setScrimColor-8_81llA", "(J)V", "J", "component1", "component2", "component3", "component3-0d7_KjU", "copy", "copy-mxwnekA", "(Landroidx/compose/foundation/shape/RoundedCornerShape;Lkotlin/jvm/functions/Function2;J)Lkntr/app/upcomingEpisode/list/utils/DefaultBottomSheetProperties;", "equals", "", "other", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultBottomSheetProperties {
    public static final int $stable = 8;
    private Function2<? super Composer, ? super Integer, Color> bgColor;
    private long scrimColor;
    private RoundedCornerShape shape;

    public /* synthetic */ DefaultBottomSheetProperties(RoundedCornerShape roundedCornerShape, Function2 function2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(roundedCornerShape, function2, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-mxwnekA$default  reason: not valid java name */
    public static /* synthetic */ DefaultBottomSheetProperties m1300copymxwnekA$default(DefaultBottomSheetProperties defaultBottomSheetProperties, RoundedCornerShape roundedCornerShape, Function2 function2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            roundedCornerShape = defaultBottomSheetProperties.shape;
        }
        if ((i & 2) != 0) {
            function2 = defaultBottomSheetProperties.bgColor;
        }
        if ((i & 4) != 0) {
            j = defaultBottomSheetProperties.scrimColor;
        }
        return defaultBottomSheetProperties.m1302copymxwnekA(roundedCornerShape, function2, j);
    }

    public final RoundedCornerShape component1() {
        return this.shape;
    }

    public final Function2<Composer, Integer, Color> component2() {
        return this.bgColor;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m1301component30d7_KjU() {
        return this.scrimColor;
    }

    /* renamed from: copy-mxwnekA  reason: not valid java name */
    public final DefaultBottomSheetProperties m1302copymxwnekA(RoundedCornerShape roundedCornerShape, Function2<? super Composer, ? super Integer, Color> function2, long j) {
        Intrinsics.checkNotNullParameter(roundedCornerShape, "shape");
        Intrinsics.checkNotNullParameter(function2, "bgColor");
        return new DefaultBottomSheetProperties(roundedCornerShape, function2, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultBottomSheetProperties) {
            DefaultBottomSheetProperties defaultBottomSheetProperties = (DefaultBottomSheetProperties) obj;
            return Intrinsics.areEqual(this.shape, defaultBottomSheetProperties.shape) && Intrinsics.areEqual(this.bgColor, defaultBottomSheetProperties.bgColor) && Color.equals-impl0(this.scrimColor, defaultBottomSheetProperties.scrimColor);
        }
        return false;
    }

    public int hashCode() {
        return (((this.shape.hashCode() * 31) + this.bgColor.hashCode()) * 31) + Color.hashCode-impl(this.scrimColor);
    }

    public String toString() {
        RoundedCornerShape roundedCornerShape = this.shape;
        Function2<? super Composer, ? super Integer, Color> function2 = this.bgColor;
        return "DefaultBottomSheetProperties(shape=" + roundedCornerShape + ", bgColor=" + function2 + ", scrimColor=" + Color.toString-impl(this.scrimColor) + ")";
    }

    private DefaultBottomSheetProperties(RoundedCornerShape shape, Function2<? super Composer, ? super Integer, Color> function2, long scrimColor) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(function2, "bgColor");
        this.shape = shape;
        this.bgColor = function2;
        this.scrimColor = scrimColor;
    }

    public /* synthetic */ DefaultBottomSheetProperties(RoundedCornerShape roundedCornerShape, Function2 function2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null) : roundedCornerShape, (i & 2) != 0 ? new Function2<Composer, Integer, Color>() { // from class: kntr.app.upcomingEpisode.list.utils.DefaultBottomSheetProperties.1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                return Color.box-impl(m1305invokeWaAFU9c((Composer) p1, ((Number) p2).intValue()));
            }

            /* renamed from: invoke-WaAFU9c  reason: not valid java name */
            public final long m1305invokeWaAFU9c(Composer $composer, int $changed) {
                $composer.startReplaceGroup(2119798639);
                ComposerKt.sourceInformation($composer, "C24@1171L6:DefaultBottomSheetProperties.kt#u60jee");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2119798639, $changed, -1, "kntr.app.upcomingEpisode.list.utils.DefaultBottomSheetProperties.<init>.<anonymous> (DefaultBottomSheetProperties.kt:24)");
                }
                long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j2;
            }
        } : function2, (i & 4) != 0 ? Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j, null);
    }

    public final RoundedCornerShape getShape() {
        return this.shape;
    }

    public final void setShape(RoundedCornerShape roundedCornerShape) {
        Intrinsics.checkNotNullParameter(roundedCornerShape, "<set-?>");
        this.shape = roundedCornerShape;
    }

    public final Function2<Composer, Integer, Color> getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(Function2<? super Composer, ? super Integer, Color> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.bgColor = function2;
    }

    /* renamed from: getScrimColor-0d7_KjU  reason: not valid java name */
    public final long m1303getScrimColor0d7_KjU() {
        return this.scrimColor;
    }

    /* renamed from: setScrimColor-8_81llA  reason: not valid java name */
    public final void m1304setScrimColor8_81llA(long j) {
        this.scrimColor = j;
    }
}