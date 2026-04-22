package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: PopupBubbleMenu.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001eH\u0007¢\u0006\u0004\b!\u0010\"R\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0015\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007¨\u0006#"}, d2 = {"Lkntr/app/im/chat/ui/widget/PopupBubbleMenuDefaults;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "PopUpBubbleArrowHeight", "Landroidx/compose/ui/unit/Dp;", "getPopUpBubbleArrowHeight-D9Ej5fM$ui_debug", "()F", "F", "PopUpBubbleArrowWidth", "getPopUpBubbleArrowWidth-D9Ej5fM$ui_debug", "PopUpBubbleMenuCornerRadius", "getPopUpBubbleMenuCornerRadius-D9Ej5fM$ui_debug", "PopUpBubbleMenuDefaultHeight", "getPopUpBubbleMenuDefaultHeight-D9Ej5fM$ui_debug", "PopUpBubbleMenuHorizontalPadding", "getPopUpBubbleMenuHorizontalPadding-D9Ej5fM$ui_debug", "PopUpBubbleMenuArrowOffsetY", "getPopUpBubbleMenuArrowOffsetY-D9Ej5fM$ui_debug", "PopUpBubbleMenuItemMinWidth", "getPopUpBubbleMenuItemMinWidth-D9Ej5fM$ui_debug", "PopupBubbleMenuArrowButtonWidth", "getPopupBubbleMenuArrowButtonWidth-D9Ej5fM$ui_debug", "PopupBubbleMenuArrowButtonHeight", "getPopupBubbleMenuArrowButtonHeight-D9Ej5fM$ui_debug", "PopupBubbleMenuShadowElevation", "getPopupBubbleMenuShadowElevation-D9Ej5fM$ui_debug", "popupBubbleMenuColor", "Lkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "arrowLeftButtonContainerColor", "arrowRightButtonContainerColor", "popupBubbleMenuColor-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Lkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopupBubbleMenuDefaults {
    public static final int $stable = 0;
    public static final PopupBubbleMenuDefaults INSTANCE = new PopupBubbleMenuDefaults();
    private static final float PopUpBubbleArrowHeight = Dp.constructor-impl(7);
    private static final float PopUpBubbleArrowWidth = Dp.constructor-impl(14);
    private static final float PopUpBubbleMenuCornerRadius = Dp.constructor-impl(8);
    private static final float PopUpBubbleMenuDefaultHeight = Dp.constructor-impl(45);
    private static final float PopUpBubbleMenuHorizontalPadding = Dp.constructor-impl(20);
    private static final float PopUpBubbleMenuArrowOffsetY = Dp.constructor-impl(4);
    private static final float PopUpBubbleMenuItemMinWidth = Dp.constructor-impl(69);
    private static final float PopupBubbleMenuArrowButtonWidth = Dp.constructor-impl(32);
    private static final float PopupBubbleMenuArrowButtonHeight = Dp.constructor-impl(38);
    private static final float PopupBubbleMenuShadowElevation = Dp.constructor-impl(2);

    private PopupBubbleMenuDefaults() {
    }

    /* renamed from: getPopUpBubbleArrowHeight-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1961getPopUpBubbleArrowHeightD9Ej5fM$ui_debug() {
        return PopUpBubbleArrowHeight;
    }

    /* renamed from: getPopUpBubbleArrowWidth-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1962getPopUpBubbleArrowWidthD9Ej5fM$ui_debug() {
        return PopUpBubbleArrowWidth;
    }

    /* renamed from: getPopUpBubbleMenuCornerRadius-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1964getPopUpBubbleMenuCornerRadiusD9Ej5fM$ui_debug() {
        return PopUpBubbleMenuCornerRadius;
    }

    /* renamed from: getPopUpBubbleMenuDefaultHeight-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1965getPopUpBubbleMenuDefaultHeightD9Ej5fM$ui_debug() {
        return PopUpBubbleMenuDefaultHeight;
    }

    /* renamed from: getPopUpBubbleMenuHorizontalPadding-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1966getPopUpBubbleMenuHorizontalPaddingD9Ej5fM$ui_debug() {
        return PopUpBubbleMenuHorizontalPadding;
    }

    /* renamed from: getPopUpBubbleMenuArrowOffsetY-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1963getPopUpBubbleMenuArrowOffsetYD9Ej5fM$ui_debug() {
        return PopUpBubbleMenuArrowOffsetY;
    }

    /* renamed from: getPopUpBubbleMenuItemMinWidth-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1967getPopUpBubbleMenuItemMinWidthD9Ej5fM$ui_debug() {
        return PopUpBubbleMenuItemMinWidth;
    }

    /* renamed from: getPopupBubbleMenuArrowButtonWidth-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1969getPopupBubbleMenuArrowButtonWidthD9Ej5fM$ui_debug() {
        return PopupBubbleMenuArrowButtonWidth;
    }

    /* renamed from: getPopupBubbleMenuArrowButtonHeight-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1968getPopupBubbleMenuArrowButtonHeightD9Ej5fM$ui_debug() {
        return PopupBubbleMenuArrowButtonHeight;
    }

    /* renamed from: getPopupBubbleMenuShadowElevation-D9Ej5fM$ui_debug  reason: not valid java name */
    public final float m1970getPopupBubbleMenuShadowElevationD9Ej5fM$ui_debug() {
        return PopupBubbleMenuShadowElevation;
    }

    /* renamed from: popupBubbleMenuColor-RGew2ao  reason: not valid java name */
    public final PopupBubbleMenuColors m1971popupBubbleMenuColorRGew2ao(long j2, long j3, long j4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1544870396, "C(popupBubbleMenuColor)N(containerColor:c#ui.graphics.Color,arrowLeftButtonContainerColor:c#ui.graphics.Color,arrowRightButtonContainerColor:c#ui.graphics.Color)107@4224L6,108@4294L6,109@4365L6:PopupBubbleMenu.kt#92mklk");
        long j5 = (i & 1) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa11-0d7_KjU() : j2;
        long j6 = (i & 2) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa11-0d7_KjU() : j3;
        long j7 = (i & 4) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa11-0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1544870396, $changed, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuDefaults.popupBubbleMenuColor (PopupBubbleMenu.kt:111)");
        }
        PopupBubbleMenuColors popupBubbleMenuColors = new PopupBubbleMenuColors(j5, j6, j7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return popupBubbleMenuColors;
    }
}