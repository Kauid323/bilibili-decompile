package kntr.app.upcomingEpisode.list.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.common.compose.res.TVPlaceHolderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingEpisodeListCommonVideoCard.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt {
    public static final ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt INSTANCE = new ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt();
    private static Function3<String, Composer, Integer, Unit> lambda$609461443 = ComposableLambdaKt.composableLambdaInstance(609461443, false, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_609461443$lambda$0;
            lambda_609461443$lambda$0 = ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.lambda_609461443$lambda$0((String) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_609461443$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1278967284 = ComposableLambdaKt.composableLambdaInstance(1278967284, false, new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1278967284$lambda$0;
            lambda_1278967284$lambda$0 = ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.lambda_1278967284$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1278967284$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$82068330 = ComposableLambdaKt.composableLambdaInstance(82068330, false, new Function4() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_82068330$lambda$0;
            lambda_82068330$lambda$0 = ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.lambda_82068330$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_82068330$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1278967284$main_debug() {
        return lambda$1278967284;
    }

    public final Function3<String, Composer, Integer, Unit> getLambda$609461443$main_debug() {
        return lambda$609461443;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$82068330$main_debug() {
        return lambda$82068330;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_609461443$lambda$0(String it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)264@10288L974:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(609461443, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.lambda$609461443.<anonymous> (UpcomingEpisodeListCommonVideoCard.kt:264)");
            }
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1167947277, "C273@10726L338,271@10633L527,282@11193L39:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            ImageKt.Image(PlayingIconPainterKt.m1239rememberPlayingIconm3LR9pM(DpKt.DpSize-YgX7TsA(Dp.constructor-impl(16), Dp.constructor-impl(16)), null, 0L, false, $composer, 6, 14), "", (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, 48, 124);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_82068330$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)442@16651L6,445@16825L6,437@16418L447:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(82068330, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.lambda$82068330.<anonymous> (UpcomingEpisodeListCommonVideoCard.kt:437)");
        }
        TVPlaceHolderKt.m1876TVPlaceholderiJQMabo(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1278967284$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C454@17177L6,457@17351L6,449@16944L447:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1278967284, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.lambda$1278967284.<anonymous> (UpcomingEpisodeListCommonVideoCard.kt:449)");
            }
            TVPlaceHolderKt.m1876TVPlaceholderiJQMabo(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}