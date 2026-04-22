package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Constant.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0013\u0010\u0012\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/Constant;", "", "<init>", "()V", "NormalHeight", "Landroidx/compose/ui/unit/Dp;", "getNormalHeight-D9Ej5fM", "()F", "F", "ExpandTopPadding", "getExpandTopPadding-D9Ej5fM", "ScrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor-0d7_KjU", "()J", "ScrimColorAlpha", "", "getScrimColorAlpha", "CornerRadius", "getCornerRadius-D9Ej5fM", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Constant {
    public static final int $stable = 0;
    public static final Constant INSTANCE = new Constant();
    private static final float NormalHeight = Dp.constructor-impl(338);
    private static final float ExpandTopPadding = Dp.constructor-impl(151);
    private static final float CornerRadius = Dp.constructor-impl(12);

    private Constant() {
    }

    /* renamed from: getNormalHeight-D9Ej5fM  reason: not valid java name */
    public final float m1904getNormalHeightD9Ej5fM() {
        return NormalHeight;
    }

    /* renamed from: getExpandTopPadding-D9Ej5fM  reason: not valid java name */
    public final float m1903getExpandTopPaddingD9Ej5fM() {
        return ExpandTopPadding;
    }

    /* renamed from: getScrimColor-0d7_KjU  reason: not valid java name */
    public final long m1905getScrimColor0d7_KjU() {
        return Color.Companion.getBlack-0d7_KjU();
    }

    public final float getScrimColorAlpha() {
        return 0.8f;
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m1902getCornerRadiusD9Ej5fM() {
        return CornerRadius;
    }
}