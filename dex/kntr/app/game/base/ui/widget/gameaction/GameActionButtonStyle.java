package kntr.app.game.base.ui.widget.gameaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;

/* compiled from: GameActionButtonStyle.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fR\u0014\u0010\u0002\u001a\u00020\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R*\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 À\u0006\u0003"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "normalColor", "Landroidx/compose/ui/graphics/Color;", "getNormalColor", "(Landroidx/compose/runtime/Composer;I)J", "border", RoomRecommendViewModel.EMPTY_CURSOR, "getBorder", "()Z", "normalTextColor", "getNormalTextColor", "disableColor", "getDisableColor", "disableTextColor", "getDisableTextColor", "processTextColor", "getProcessTextColor", "progressColor", RoomRecommendViewModel.EMPTY_CURSOR, "getProgressColor", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "discountColor", "getDiscountColor", "discountModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "getDiscountModifier", "()Lkotlin/jvm/functions/Function3;", "Companion", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GameActionButtonStyle {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean getBorder();

    long getDisableColor(Composer composer, int i);

    long getDisableTextColor(Composer composer, int i);

    long getDiscountColor(Composer composer, int i);

    Function3<Modifier, Composer, Integer, Modifier> getDiscountModifier();

    long getNormalColor(Composer composer, int i);

    long getNormalTextColor(Composer composer, int i);

    long getProcessTextColor(Composer composer, int i);

    List<Color> getProgressColor(Composer composer, int i);

    /* compiled from: GameActionButtonStyle.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Blue", "Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;", "getBlue$annotations", "getBlue", "()Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;", "Pink", "getPink$annotations", "getPink", "Blue_Border", "getBlue_Border$annotations", "getBlue_Border", "Pink_Border", "getPink_Border$annotations", "getPink_Border", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final GameActionButtonStyle Blue = new GameActionButtonStyle() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle$Companion$Blue$1
            private final boolean border;

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getNormalColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(-330107969);
                ComposerKt.sourceInformation($composer, "C(<get-normalColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-330107969, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-normalColor> (GameActionButtonStyle.kt:78)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getLb5-0d7_KjU();
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
                $composer.startReplaceGroup(869282917);
                ComposerKt.sourceInformation($composer, "C(<get-normalTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(869282917, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-normalTextColor> (GameActionButtonStyle.kt:81)");
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
                $composer.startReplaceGroup(674409491);
                ComposerKt.sourceInformation($composer, "C(<get-disableColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(674409491, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-disableColor> (GameActionButtonStyle.kt:83)");
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
                $composer.startReplaceGroup(-1044194829);
                ComposerKt.sourceInformation($composer, "C(<get-disableTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1044194829, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-disableTextColor> (GameActionButtonStyle.kt:85)");
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
                $composer.startReplaceGroup(-799397613);
                ComposerKt.sourceInformation($composer, "C(<get-processTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-799397613, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-processTextColor> (GameActionButtonStyle.kt:87)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getLb5-0d7_KjU();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j2;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public List<Color> getProgressColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(-2007193818);
                ComposerKt.sourceInformation($composer, "C(<get-progressColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2007193818, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-progressColor> (GameActionButtonStyle.kt:89)");
                }
                List<Color> listOf = CollectionsKt.listOf(new Color[]{Color.box-impl(BiliColorsSourceKt.getDayColors().getLb0-0d7_KjU()), Color.box-impl(BiliColorsSourceKt.getDayColors().getLb2-0d7_KjU())});
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return listOf;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getDiscountColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(24395275);
                ComposerKt.sourceInformation($composer, "C(<get-discountColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(24395275, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue.<no name provided>.<get-discountColor> (GameActionButtonStyle.kt:91)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j2;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public Function3<Modifier, Composer, Integer, Modifier> getDiscountModifier() {
                return null;
            }
        };
        private static final GameActionButtonStyle Pink = new GameActionButtonStyle$Companion$Pink$1();
        private static final GameActionButtonStyle Blue_Border = new GameActionButtonStyle() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle$Companion$Blue_Border$1
            private final boolean border = true;
            private final Function3<Modifier, Composer, Integer, Modifier> discountModifier;

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getNormalColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(1806693132);
                ComposerKt.sourceInformation($composer, "C(<get-normalColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1806693132, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-normalColor> (GameActionButtonStyle.kt:130)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getLb5-0d7_KjU();
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
                $composer.startReplaceGroup(-724710490);
                ComposerKt.sourceInformation($composer, "C(<get-normalTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-724710490, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-normalTextColor> (GameActionButtonStyle.kt:134)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getLb5-0d7_KjU();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j2;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getDisableColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(-720112584);
                ComposerKt.sourceInformation($composer, "C(<get-disableColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-720112584, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-disableColor> (GameActionButtonStyle.kt:137)");
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
                $composer.startReplaceGroup(-747738536);
                ComposerKt.sourceInformation($composer, "C(<get-disableTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-747738536, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-disableTextColor> (GameActionButtonStyle.kt:140)");
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
                $composer.startReplaceGroup(-168437960);
                ComposerKt.sourceInformation($composer, "C(<get-processTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-168437960, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-processTextColor> (GameActionButtonStyle.kt:143)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getLb5-0d7_KjU();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j2;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public List<Color> getProgressColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(562032069);
                ComposerKt.sourceInformation($composer, "C(<get-progressColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(562032069, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-progressColor> (GameActionButtonStyle.kt:146)");
                }
                List<Color> listOf = CollectionsKt.listOf(new Color[]{Color.box-impl(BiliColorsSourceKt.getDayColors().getLb0-0d7_KjU()), Color.box-impl(BiliColorsSourceKt.getDayColors().getLb2-0d7_KjU())});
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return listOf;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getDiscountColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(1832958784);
                ComposerKt.sourceInformation($composer, "C(<get-discountColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1832958784, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Blue_Border.<no name provided>.<get-discountColor> (GameActionButtonStyle.kt:148)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU();
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
        };
        private static final GameActionButtonStyle Pink_Border = new GameActionButtonStyle() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle$Companion$Pink_Border$1
            private final boolean border = true;
            private final Function3<Modifier, Composer, Integer, Modifier> discountModifier;

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getNormalColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(-1573234832);
                ComposerKt.sourceInformation($composer, "C(<get-normalColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1573234832, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-normalColor> (GameActionButtonStyle.kt:157)");
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
                $composer.startReplaceGroup(190328842);
                ComposerKt.sourceInformation($composer, "C(<get-normalTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(190328842, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-normalTextColor> (GameActionButtonStyle.kt:161)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getPi5-0d7_KjU();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return j2;
            }

            @Override // kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle
            public long getDisableColor(Composer $composer, int $changed) {
                $composer.startReplaceGroup(194926748);
                ComposerKt.sourceInformation($composer, "C(<get-disableColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(194926748, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-disableColor> (GameActionButtonStyle.kt:164)");
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
                $composer.startReplaceGroup(167300796);
                ComposerKt.sourceInformation($composer, "C(<get-disableTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(167300796, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-disableTextColor> (GameActionButtonStyle.kt:167)");
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
                $composer.startReplaceGroup(746601372);
                ComposerKt.sourceInformation($composer, "C(<get-processTextColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(746601372, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-processTextColor> (GameActionButtonStyle.kt:170)");
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
                $composer.startReplaceGroup(1477071401);
                ComposerKt.sourceInformation($composer, "C(<get-progressColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1477071401, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-progressColor> (GameActionButtonStyle.kt:173)");
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
                $composer.startReplaceGroup(-1546969180);
                ComposerKt.sourceInformation($composer, "C(<get-discountColor>):GameActionButtonStyle.kt#dj1drh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1546969180, $changed, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle.Companion.Pink_Border.<no name provided>.<get-discountColor> (GameActionButtonStyle.kt:175)");
                }
                long j2 = BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU();
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
        };

        public static /* synthetic */ void getBlue$annotations() {
        }

        public static /* synthetic */ void getBlue_Border$annotations() {
        }

        public static /* synthetic */ void getPink$annotations() {
        }

        public static /* synthetic */ void getPink_Border$annotations() {
        }

        private Companion() {
        }

        public final GameActionButtonStyle getBlue() {
            return Blue;
        }

        public final GameActionButtonStyle getPink() {
            return Pink;
        }

        public final GameActionButtonStyle getBlue_Border() {
            return Blue_Border;
        }

        public final GameActionButtonStyle getPink_Border() {
            return Pink_Border;
        }
    }
}