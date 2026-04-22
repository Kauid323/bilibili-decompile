package kntr.app.deepsearch.ui.input;

import BottomSheetItemData$;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Input.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0010J\u0019\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006("}, d2 = {"Lkntr/app/deepsearch/ui/input/SenderStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "width", "Landroidx/compose/ui/unit/Dp;", "background", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/runtime/Composable;", "alpha", RoomRecommendViewModel.EMPTY_CURSOR, "stopIcon", RoomRecommendViewModel.EMPTY_CURSOR, "loadingIcon", "<init>", "(FLkotlin/jvm/functions/Function2;FZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-D9Ej5fM", "()F", "F", "getBackground", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getAlpha", "getStopIcon", "()Z", "getLoadingIcon", "component1", "component1-D9Ej5fM", "component2", "component3", "component4", "component5", "copy", "copy--orJrPs", "(FLkotlin/jvm/functions/Function2;FZZ)Lkntr/app/deepsearch/ui/input/SenderStyle;", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SenderStyle {
    private final float alpha;
    private final Function2<Composer, Integer, Color> background;
    private final boolean loadingIcon;
    private final boolean stopIcon;
    private final float width;

    public /* synthetic */ SenderStyle(float f, Function2 function2, float f2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, function2, f2, z, z2);
    }

    /* renamed from: copy--orJrPs$default  reason: not valid java name */
    public static /* synthetic */ SenderStyle m750copyorJrPs$default(SenderStyle senderStyle, float f, Function2 function2, float f2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = senderStyle.width;
        }
        Function2<Composer, Integer, Color> function22 = function2;
        if ((i & 2) != 0) {
            function22 = senderStyle.background;
        }
        Function2 function23 = function22;
        if ((i & 4) != 0) {
            f2 = senderStyle.alpha;
        }
        float f3 = f2;
        if ((i & 8) != 0) {
            z = senderStyle.stopIcon;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = senderStyle.loadingIcon;
        }
        return senderStyle.m752copyorJrPs(f, function23, f3, z3, z2);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m751component1D9Ej5fM() {
        return this.width;
    }

    public final Function2<Composer, Integer, Color> component2() {
        return this.background;
    }

    public final float component3() {
        return this.alpha;
    }

    public final boolean component4() {
        return this.stopIcon;
    }

    public final boolean component5() {
        return this.loadingIcon;
    }

    /* renamed from: copy--orJrPs  reason: not valid java name */
    public final SenderStyle m752copyorJrPs(float f, Function2<? super Composer, ? super Integer, Color> function2, float f2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(function2, "background");
        return new SenderStyle(f, function2, f2, z, z2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SenderStyle) {
            SenderStyle senderStyle = (SenderStyle) obj;
            return Dp.equals-impl0(this.width, senderStyle.width) && Intrinsics.areEqual(this.background, senderStyle.background) && Float.compare(this.alpha, senderStyle.alpha) == 0 && this.stopIcon == senderStyle.stopIcon && this.loadingIcon == senderStyle.loadingIcon;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Dp.hashCode-impl(this.width) * 31) + this.background.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.stopIcon)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loadingIcon);
    }

    public String toString() {
        String str = Dp.toString-impl(this.width);
        Function2<Composer, Integer, Color> function2 = this.background;
        float f = this.alpha;
        boolean z = this.stopIcon;
        return "SenderStyle(width=" + str + ", background=" + function2 + ", alpha=" + f + ", stopIcon=" + z + ", loadingIcon=" + this.loadingIcon + ")";
    }

    private SenderStyle(float width, Function2<? super Composer, ? super Integer, Color> function2, float alpha, boolean stopIcon, boolean loadingIcon) {
        Intrinsics.checkNotNullParameter(function2, "background");
        this.width = width;
        this.background = function2;
        this.alpha = alpha;
        this.stopIcon = stopIcon;
        this.loadingIcon = loadingIcon;
    }

    public /* synthetic */ SenderStyle(float f, Function2 function2, float f2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, function2, (i & 4) != 0 ? 1.0f : f2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, null);
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m753getWidthD9Ej5fM() {
        return this.width;
    }

    public final Function2<Composer, Integer, Color> getBackground() {
        return this.background;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final boolean getStopIcon() {
        return this.stopIcon;
    }

    public final boolean getLoadingIcon() {
        return this.loadingIcon;
    }
}