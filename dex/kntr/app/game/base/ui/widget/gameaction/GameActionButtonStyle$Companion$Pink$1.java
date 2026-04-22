package kntr.app.game.base.ui.widget.gameaction;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameActionButtonStyle.kt */
@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R,\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001cX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"kntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle$Companion$Pink$1", "Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;", "normalColor", "Landroidx/compose/ui/graphics/Color;", "getNormalColor", "(Landroidx/compose/runtime/Composer;I)J", "border", RoomRecommendViewModel.EMPTY_CURSOR, "getBorder", "()Z", "normalTextColor", "getNormalTextColor", "disableColor", "getDisableColor", "disableTextColor", "getDisableTextColor", "processTextColor", "getProcessTextColor", "progressColor", RoomRecommendViewModel.EMPTY_CURSOR, "getProgressColor", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "discountColor", "getDiscountColor", "discountModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "getDiscountModifier", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameActionButtonStyle$Companion$Pink$1 implements GameActionButtonStyle {
    private final boolean border;
    private final Function3<Modifier, Composer, Integer, Modifier> discountModifier = new Function3() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle$Companion$Pink$1$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Modifier discountModifier$lambda$0;
            discountModifier$lambda$0 = GameActionButtonStyle$Companion$Pink$1.discountModifier$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return discountModifier$lambda$0;
        }
    };

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public long getNormalColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1742534619);
        ComposerKt.sourceInformation($composer, "C(<get-normalColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1742534619, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-normalColor> (GameActionButtonStyle.kt:100)");
        }
        long j2 = BiliColorsSourceKt.getDayColors().getPi5-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j2;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public boolean getBorder() {
        return this.border;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public long getNormalTextColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1353041791);
        ComposerKt.sourceInformation($composer, "C(<get-normalTextColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353041791, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-normalTextColor> (GameActionButtonStyle.kt:104)");
        }
        long j2 = BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j2;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public long getDisableColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1547915217);
        ComposerKt.sourceInformation($composer, "C(<get-disableColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1547915217, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-disableColor> (GameActionButtonStyle.kt:107)");
        }
        long j2 = BiliColorsSourceKt.getDayColors().getGa1-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j2;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public long getDisableTextColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1028447759);
        ComposerKt.sourceInformation($composer, "C(<get-disableTextColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1028447759, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-disableTextColor> (GameActionButtonStyle.kt:110)");
        }
        long j2 = BiliColorsSourceKt.getDayColors().getGa5-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j2;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public long getProcessTextColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1273244975);
        ComposerKt.sourceInformation($composer, "C(<get-processTextColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1273244975, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-processTextColor> (GameActionButtonStyle.kt:113)");
        }
        long j2 = BiliColorsSourceKt.getDayColors().getPi5-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j2;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public List<Color> getProgressColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(65448770);
        ComposerKt.sourceInformation($composer, "C(<get-progressColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(65448770, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-progressColor> (GameActionButtonStyle.kt:116)");
        }
        List<Color> listOf = CollectionsKt.listOf(new Color[]{Color.box-impl(BiliColorsSourceKt.getDayColors().getPi0-0d7_KjU()), Color.box-impl(BiliColorsSourceKt.getDayColors().getPi2-0d7_KjU())});
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return listOf;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public long getDiscountColor(Composer $composer, int $changed) {
        $composer.startReplaceGroup(2097037863);
        ComposerKt.sourceInformation($composer, "C(<get-discountColor>):GameActionButtonStyle.kt#dj1drh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2097037863, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.<get-discountColor> (GameActionButtonStyle.kt:118)");
        }
        long j2 = BiliColorsSourceKt.getDayColors().getOr5-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j2;
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
    public Function3<Modifier, Composer, Integer, Modifier> getDiscountModifier() {
        return this.discountModifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier discountModifier$lambda$0(Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        $composer.startReplaceGroup(1549637871);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1549637871, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink.<no name provided>.discountModifier.<anonymous> (GameActionButtonStyle.kt:120)");
        }
        Modifier modifier2 = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(modifier, BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.constructor-impl((float) 0.5d), BiliColorsSourceKt.getDayColors().getOr5-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return modifier2;
    }
}