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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BN\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u0019\u0010'\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fHÆ\u0003¢\u0006\u0002\u0010\u001eJU\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR'\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lkntr/app/upcomingEpisode/list/utils/DefaultDragHandleProperties;", "", "paddingTop", "", "paddingBottom", "width", "height", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "color", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/runtime/Composable;", "<init>", "(IIIILandroidx/compose/foundation/shape/RoundedCornerShape;Lkotlin/jvm/functions/Function2;)V", "getPaddingTop", "()I", "setPaddingTop", "(I)V", "getPaddingBottom", "setPaddingBottom", "getWidth", "setWidth", "getHeight", "setHeight", "getShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "setShape", "(Landroidx/compose/foundation/shape/RoundedCornerShape;)V", "getColor", "()Lkotlin/jvm/functions/Function2;", "setColor", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIIILandroidx/compose/foundation/shape/RoundedCornerShape;Lkotlin/jvm/functions/Function2;)Lkntr/app/upcomingEpisode/list/utils/DefaultDragHandleProperties;", "equals", "", "other", "hashCode", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultDragHandleProperties {
    public static final int $stable = 8;
    private Function2<? super Composer, ? super Integer, Color> color;
    private int height;
    private int paddingBottom;
    private int paddingTop;
    private RoundedCornerShape shape;
    private int width;

    public DefaultDragHandleProperties() {
        this(0, 0, 0, 0, null, null, 63, null);
    }

    public static /* synthetic */ DefaultDragHandleProperties copy$default(DefaultDragHandleProperties defaultDragHandleProperties, int i, int i2, int i3, int i4, RoundedCornerShape roundedCornerShape, Function2 function2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = defaultDragHandleProperties.paddingTop;
        }
        if ((i5 & 2) != 0) {
            i2 = defaultDragHandleProperties.paddingBottom;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = defaultDragHandleProperties.width;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = defaultDragHandleProperties.height;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            roundedCornerShape = defaultDragHandleProperties.shape;
        }
        RoundedCornerShape roundedCornerShape2 = roundedCornerShape;
        Function2<? super Composer, ? super Integer, Color> function22 = function2;
        if ((i5 & 32) != 0) {
            function22 = defaultDragHandleProperties.color;
        }
        return defaultDragHandleProperties.copy(i, i6, i7, i8, roundedCornerShape2, function22);
    }

    public final int component1() {
        return this.paddingTop;
    }

    public final int component2() {
        return this.paddingBottom;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final RoundedCornerShape component5() {
        return this.shape;
    }

    public final Function2<Composer, Integer, Color> component6() {
        return this.color;
    }

    public final DefaultDragHandleProperties copy(int i, int i2, int i3, int i4, RoundedCornerShape roundedCornerShape, Function2<? super Composer, ? super Integer, Color> function2) {
        Intrinsics.checkNotNullParameter(roundedCornerShape, "shape");
        Intrinsics.checkNotNullParameter(function2, "color");
        return new DefaultDragHandleProperties(i, i2, i3, i4, roundedCornerShape, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultDragHandleProperties) {
            DefaultDragHandleProperties defaultDragHandleProperties = (DefaultDragHandleProperties) obj;
            return this.paddingTop == defaultDragHandleProperties.paddingTop && this.paddingBottom == defaultDragHandleProperties.paddingBottom && this.width == defaultDragHandleProperties.width && this.height == defaultDragHandleProperties.height && Intrinsics.areEqual(this.shape, defaultDragHandleProperties.shape) && Intrinsics.areEqual(this.color, defaultDragHandleProperties.color);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.paddingTop * 31) + this.paddingBottom) * 31) + this.width) * 31) + this.height) * 31) + this.shape.hashCode()) * 31) + this.color.hashCode();
    }

    public String toString() {
        int i = this.paddingTop;
        int i2 = this.paddingBottom;
        int i3 = this.width;
        int i4 = this.height;
        RoundedCornerShape roundedCornerShape = this.shape;
        return "DefaultDragHandleProperties(paddingTop=" + i + ", paddingBottom=" + i2 + ", width=" + i3 + ", height=" + i4 + ", shape=" + roundedCornerShape + ", color=" + this.color + ")";
    }

    public DefaultDragHandleProperties(int paddingTop, int paddingBottom, int width, int height, RoundedCornerShape shape, Function2<? super Composer, ? super Integer, Color> function2) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(function2, "color");
        this.paddingTop = paddingTop;
        this.paddingBottom = paddingBottom;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.color = function2;
    }

    public /* synthetic */ DefaultDragHandleProperties(int i, int i2, int i3, int i4, RoundedCornerShape roundedCornerShape, Function2 function2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 8 : i, (i5 & 2) == 0 ? i2 : 8, (i5 & 4) != 0 ? 30 : i3, (i5 & 8) != 0 ? 3 : i4, (i5 & 16) != 0 ? RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)) : roundedCornerShape, (i5 & 32) != 0 ? new Function2<Composer, Integer, Color>() { // from class: kntr.app.upcomingEpisode.list.utils.DefaultDragHandleProperties.1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                return Color.box-impl(m1306invokeWaAFU9c((Composer) p1, ((Number) p2).intValue()));
            }

            /* renamed from: invoke-WaAFU9c  reason: not valid java name */
            public final long m1306invokeWaAFU9c(Composer $composer, int $changed) {
                $composer.startReplaceGroup(1968262112);
                ComposerKt.sourceInformation($composer, "C19@900L6:DefaultBottomSheetProperties.kt#u60jee");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1968262112, $changed, -1, "kntr.app.upcomingEpisode.list.utils.DefaultDragHandleProperties.<init>.<anonymous> (DefaultBottomSheetProperties.kt:19)");
                }
                long j = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBa0_s-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j;
            }
        } : function2);
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final void setPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final RoundedCornerShape getShape() {
        return this.shape;
    }

    public final void setShape(RoundedCornerShape roundedCornerShape) {
        Intrinsics.checkNotNullParameter(roundedCornerShape, "<set-?>");
        this.shape = roundedCornerShape;
    }

    public final Function2<Composer, Integer, Color> getColor() {
        return this.color;
    }

    public final void setColor(Function2<? super Composer, ? super Integer, Color> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.color = function2;
    }
}