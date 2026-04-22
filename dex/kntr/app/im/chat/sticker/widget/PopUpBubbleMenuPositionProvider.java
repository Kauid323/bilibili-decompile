package kntr.app.im.chat.sticker.widget;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.Iterator;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: PopupBubbleSticker.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bt\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012K\u0010\t\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bRV\u0010\t\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lkntr/app/im/chat/sticker/widget/PopUpBubbleMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "statusInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "navigationInsets", "onPopupPositionFound", "Lkotlin/Function3;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ParameterName;", "name", "pivotFractionX", RoomRecommendViewModel.EMPTY_CURSOR, "isFitTop", "Landroidx/compose/ui/unit/Dp;", "arrowOffsetX", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/Density;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;)V", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getStatusInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getNavigationInsets", "getOnPopupPositionFound", "()Lkotlin/jvm/functions/Function3;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopUpBubbleMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final PaddingValues contentPadding;
    private final Density density;
    private final WindowInsets navigationInsets;
    private final Function3<Float, Boolean, Dp, Unit> onPopupPositionFound;
    private final WindowInsets statusInsets;

    /* JADX WARN: Multi-variable type inference failed */
    public PopUpBubbleMenuPositionProvider(PaddingValues contentPadding, Density density, WindowInsets statusInsets, WindowInsets navigationInsets, Function3<? super Float, ? super Boolean, ? super Dp, Unit> function3) {
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(statusInsets, "statusInsets");
        Intrinsics.checkNotNullParameter(navigationInsets, "navigationInsets");
        Intrinsics.checkNotNullParameter(function3, "onPopupPositionFound");
        this.contentPadding = contentPadding;
        this.density = density;
        this.statusInsets = statusInsets;
        this.navigationInsets = navigationInsets;
        this.onPopupPositionFound = function3;
    }

    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final WindowInsets getStatusInsets() {
        return this.statusInsets;
    }

    public final WindowInsets getNavigationInsets() {
        return this.navigationInsets;
    }

    public final Function3<Float, Boolean, Dp, Unit> getOnPopupPositionFound() {
        return this.onPopupPositionFound;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x01bf, code lost:
        if (r45.getTop() <= ((int) (r46 & 4294967295L))) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x029e A[SYNTHETIC] */
    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m1705calculatePositionllwVHH4(IntRect anchorBounds, long j2, LayoutDirection layoutDirection, long j3) {
        int startPlacementOffset;
        int fullCenterPlacementOffset;
        boolean isFitTop;
        Iterator it;
        int rightPadding;
        Object element$iv;
        int arrowOffsetX;
        int horizontalOffset;
        int bottomPadding;
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Density $this$calculatePosition_llwVHH4_u24lambda_u240 = this.density;
        int leftPadding = $this$calculatePosition_llwVHH4_u24lambda_u240.roundToPx-0680j_4(this.contentPadding.calculateLeftPadding-u2uoSUM(layoutDirection));
        Density $this$calculatePosition_llwVHH4_u24lambda_u241 = this.density;
        int topPadding = $this$calculatePosition_llwVHH4_u24lambda_u241.roundToPx-0680j_4(this.contentPadding.calculateTopPadding-D9Ej5fM());
        Density $this$calculatePosition_llwVHH4_u24lambda_u242 = this.density;
        int rightPadding2 = $this$calculatePosition_llwVHH4_u24lambda_u242.roundToPx-0680j_4(this.contentPadding.calculateRightPadding-u2uoSUM(layoutDirection));
        Density $this$calculatePosition_llwVHH4_u24lambda_u243 = this.density;
        int bottomPadding2 = $this$calculatePosition_llwVHH4_u24lambda_u243.roundToPx-0680j_4(this.contentPadding.calculateBottomPadding-D9Ej5fM());
        int popupHalfWidth = ((((int) (j3 >> 32)) - leftPadding) - rightPadding2) / 2;
        int halfAnchor = (anchorBounds.getRight() - anchorBounds.getLeft()) / 2;
        boolean isFitStart = (anchorBounds.getLeft() + ((int) (j3 >> 32))) - leftPadding <= ((int) (j2 >> 32)) && anchorBounds.getLeft() - leftPadding >= 0;
        boolean isFitEnd = (anchorBounds.getRight() - ((int) (j3 >> 32))) + rightPadding2 >= 0 && anchorBounds.getRight() + rightPadding2 <= ((int) (j2 >> 32));
        boolean isFitCenter = ((anchorBounds.getLeft() + rightPadding2) + halfAnchor) + popupHalfWidth < ((int) (j2 >> 32)) && ((anchorBounds.getLeft() + halfAnchor) - popupHalfWidth) - leftPadding > 0;
        int centerPlacementOffset = ((anchorBounds.getLeft() + halfAnchor) - popupHalfWidth) - leftPadding;
        int startPlacementOffset2 = anchorBounds.getLeft() - leftPadding;
        int endPlacementOffset = anchorBounds.getRight() - (((int) (j3 >> 32)) - rightPadding2);
        if ((anchorBounds.getLeft() + anchorBounds.getRight()) / 2 < ((int) (j2 >> 32)) / 2) {
            startPlacementOffset = startPlacementOffset2;
            fullCenterPlacementOffset = 0;
        } else {
            startPlacementOffset = startPlacementOffset2;
            fullCenterPlacementOffset = ((int) (j2 >> 32)) - ((int) (j3 >> 32));
        }
        Density $this$calculatePosition_llwVHH4_u24lambda_u244 = this.density;
        int bottom = this.statusInsets.getBottom($this$calculatePosition_llwVHH4_u24lambda_u244) - this.statusInsets.getTop($this$calculatePosition_llwVHH4_u24lambda_u244);
        Density $this$calculatePosition_llwVHH4_u24lambda_u245 = this.density;
        int bottom2 = this.navigationInsets.getBottom($this$calculatePosition_llwVHH4_u24lambda_u245) - this.navigationInsets.getTop($this$calculatePosition_llwVHH4_u24lambda_u245);
        int bottomCoordinatesY = anchorBounds.getBottom() + ((int) (j3 & 4294967295L));
        boolean isFitBottom = bottomCoordinatesY <= ((int) (j2 & 4294967295L));
        int topCoordinatesY = anchorBounds.getTop() - ((int) (j3 & 4294967295L));
        if (topCoordinatesY > 0) {
        }
        if ((anchorBounds.getTop() + anchorBounds.getBottom()) / 2 > ((int) (j2 & 4294967295L)) / 2) {
            isFitTop = true;
            int alignToBottomOffset = anchorBounds.getBottom() + topPadding;
            int alignToTopOffset = (anchorBounds.getTop() - ((int) (j3 & 4294967295L))) - bottomPadding2;
            int alignToCenterOffset = anchorBounds.getTop() - (((int) (j3 & 4294967295L)) / 2);
            int toDisplayBottomOffset = ((int) (j2 & 4294967295L)) - ((int) (j3 & 4294967295L));
            Sequence $this$firstOrNull$iv = SequencesKt.sequenceOf(new Integer[]{Integer.valueOf(!isFitTop ? alignToTopOffset : alignToBottomOffset), Integer.valueOf(alignToCenterOffset), Integer.valueOf(toDisplayBottomOffset)});
            it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    element$iv = it.next();
                    int it2 = ((Number) element$iv).intValue();
                    rightPadding = rightPadding2;
                    bottomPadding = bottomPadding2;
                    if (it2 + ((int) (j3 & 4294967295L)) <= ((int) (j2 & 4294967295L))) {
                        break;
                    }
                    bottomPadding2 = bottomPadding;
                    rightPadding2 = rightPadding;
                } else {
                    rightPadding = rightPadding2;
                    element$iv = null;
                    break;
                }
            }
            Integer num = (Integer) element$iv;
            int yOffset = num == null ? num.intValue() : alignToTopOffset;
            if (isFitCenter) {
                if (!isFitStart) {
                    if (isFitEnd) {
                        arrowOffsetX = (((anchorBounds.getLeft() + anchorBounds.getRight()) / 2) - endPlacementOffset) - leftPadding;
                    } else {
                        arrowOffsetX = (anchorBounds.getLeft() + anchorBounds.getRight()) / 2 < ((int) (j2 >> 32)) / 2 ? (((anchorBounds.getLeft() + anchorBounds.getRight()) / 2) - fullCenterPlacementOffset) - leftPadding : (((anchorBounds.getLeft() + anchorBounds.getRight()) / 2) - fullCenterPlacementOffset) - rightPadding;
                    }
                } else {
                    arrowOffsetX = halfAnchor;
                }
            } else {
                arrowOffsetX = popupHalfWidth;
            }
            if (!isFitCenter) {
                horizontalOffset = centerPlacementOffset;
            } else if (isFitStart) {
                horizontalOffset = startPlacementOffset;
            } else if (isFitEnd) {
                horizontalOffset = endPlacementOffset;
            } else {
                horizontalOffset = fullCenterPlacementOffset;
            }
            float pivotFractionX = (((int) (j3 >> 32)) - leftPadding) - rightPadding == 0 ? (arrowOffsetX * 1.0f) / ((((int) (j3 >> 32)) - leftPadding) - rightPadding) : 0.0f;
            Function3<Float, Boolean, Dp, Unit> function3 = this.onPopupPositionFound;
            Float valueOf = Float.valueOf(pivotFractionX);
            Boolean valueOf2 = Boolean.valueOf(isFitTop);
            Density $this$calculatePosition_llwVHH4_u24lambda_u247 = this.density;
            function3.invoke(valueOf, valueOf2, Dp.box-impl($this$calculatePosition_llwVHH4_u24lambda_u247.toDp-u2uoSUM(arrowOffsetX)));
            int y$iv = yOffset;
            int x$iv = horizontalOffset;
            return IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L));
        }
        isFitTop = false;
        int alignToBottomOffset2 = anchorBounds.getBottom() + topPadding;
        int alignToTopOffset2 = (anchorBounds.getTop() - ((int) (j3 & 4294967295L))) - bottomPadding2;
        int alignToCenterOffset2 = anchorBounds.getTop() - (((int) (j3 & 4294967295L)) / 2);
        int toDisplayBottomOffset2 = ((int) (j2 & 4294967295L)) - ((int) (j3 & 4294967295L));
        Sequence $this$firstOrNull$iv2 = SequencesKt.sequenceOf(new Integer[]{Integer.valueOf(!isFitTop ? alignToTopOffset2 : alignToBottomOffset2), Integer.valueOf(alignToCenterOffset2), Integer.valueOf(toDisplayBottomOffset2)});
        it = $this$firstOrNull$iv2.iterator();
        while (true) {
            if (!it.hasNext()) {
            }
            bottomPadding2 = bottomPadding;
            rightPadding2 = rightPadding;
        }
        Integer num2 = (Integer) element$iv;
        if (num2 == null) {
        }
        if (isFitCenter) {
        }
        if (!isFitCenter) {
        }
        if ((((int) (j3 >> 32)) - leftPadding) - rightPadding == 0) {
        }
        Function3<Float, Boolean, Dp, Unit> function32 = this.onPopupPositionFound;
        Float valueOf3 = Float.valueOf(pivotFractionX);
        Boolean valueOf22 = Boolean.valueOf(isFitTop);
        Density $this$calculatePosition_llwVHH4_u24lambda_u2472 = this.density;
        function32.invoke(valueOf3, valueOf22, Dp.box-impl($this$calculatePosition_llwVHH4_u24lambda_u2472.toDp-u2uoSUM(arrowOffsetX)));
        int y$iv2 = yOffset;
        int x$iv2 = horizontalOffset;
        return IntOffset.constructor-impl((x$iv2 << 32) | (y$iv2 & 4294967295L));
    }
}