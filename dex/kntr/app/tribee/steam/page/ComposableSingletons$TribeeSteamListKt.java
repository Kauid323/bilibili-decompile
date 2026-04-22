package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.common.compose.res.LoadingAnimateImageKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeSteamList.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TribeeSteamListKt {
    public static final ComposableSingletons$TribeeSteamListKt INSTANCE = new ComposableSingletons$TribeeSteamListKt();

    /* renamed from: lambda$-688143295  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f29lambda$688143295 = ComposableLambdaKt.composableLambdaInstance(-688143295, false, new Function2() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__688143295$lambda$0;
            lambda__688143295$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda__688143295$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__688143295$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$2140584247 = ComposableLambdaKt.composableLambdaInstance(2140584247, false, new Function4() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_2140584247$lambda$0;
            lambda_2140584247$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda_2140584247$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_2140584247$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$195441837 = ComposableLambdaKt.composableLambdaInstance(195441837, false, new Function2() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_195441837$lambda$0;
            lambda_195441837$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda_195441837$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_195441837$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1057412387 = ComposableLambdaKt.composableLambdaInstance(1057412387, false, new Function4() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1057412387$lambda$0;
            lambda_1057412387$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda_1057412387$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1057412387$lambda$0;
        }
    });

    /* renamed from: lambda$-1378224214  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f24lambda$1378224214 = ComposableLambdaKt.composableLambdaInstance(-1378224214, false, new Function4() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda5
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1378224214$lambda$0;
            lambda__1378224214$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda__1378224214$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1378224214$lambda$0;
        }
    });

    /* renamed from: lambda$-438183405  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f28lambda$438183405 = ComposableLambdaKt.composableLambdaInstance(-438183405, false, new Function4() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda6
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__438183405$lambda$0;
            lambda__438183405$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda__438183405$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__438183405$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$899740248 = ComposableLambdaKt.composableLambdaInstance(899740248, false, new Function2() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda7
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_899740248$lambda$0;
            lambda_899740248$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda_899740248$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_899740248$lambda$0;
        }
    });

    /* renamed from: lambda$-176637790  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f25lambda$176637790 = ComposableLambdaKt.composableLambdaInstance(-176637790, false, new Function4() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda8
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__176637790$lambda$0;
            lambda__176637790$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda__176637790$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__176637790$lambda$0;
        }
    });

    /* renamed from: lambda$-1892238796  reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f27lambda$1892238796 = ComposableLambdaKt.composableLambdaInstance(-1892238796, false, new Function3() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda9
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1892238796$lambda$0;
            lambda__1892238796$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda__1892238796$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1892238796$lambda$0;
        }
    });

    /* renamed from: lambda$-1808844882  reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f26lambda$1808844882 = ComposableLambdaKt.composableLambdaInstance(-1808844882, false, new Function3() { // from class: kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1808844882$lambda$0;
            lambda__1808844882$lambda$0 = ComposableSingletons$TribeeSteamListKt.lambda__1808844882$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1808844882$lambda$0;
        }
    });

    /* renamed from: getLambda$-1378224214$consume_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1111getLambda$1378224214$consume_debug() {
        return f24lambda$1378224214;
    }

    /* renamed from: getLambda$-176637790$consume_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1112getLambda$176637790$consume_debug() {
        return f25lambda$176637790;
    }

    /* renamed from: getLambda$-1808844882$consume_debug  reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1113getLambda$1808844882$consume_debug() {
        return f26lambda$1808844882;
    }

    /* renamed from: getLambda$-1892238796$consume_debug  reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1114getLambda$1892238796$consume_debug() {
        return f27lambda$1892238796;
    }

    /* renamed from: getLambda$-438183405$consume_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1115getLambda$438183405$consume_debug() {
        return f28lambda$438183405;
    }

    /* renamed from: getLambda$-688143295$consume_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1116getLambda$688143295$consume_debug() {
        return f29lambda$688143295;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1057412387$consume_debug() {
        return lambda$1057412387;
    }

    public final Function2<Composer, Integer, Unit> getLambda$195441837$consume_debug() {
        return lambda$195441837;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$2140584247$consume_debug() {
        return lambda$2140584247;
    }

    public final Function2<Composer, Integer, Unit> getLambda$899740248$consume_debug() {
        return lambda$899740248;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__688143295$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C150@6784L6,146@6565L272:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-688143295, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$-688143295.<anonymous> (TribeeSteamList.kt:146)");
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2140584247$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)158@7156L6,154@6937L272:TribeeSteamList.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2140584247, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$2140584247.<anonymous> (TribeeSteamList.kt:154)");
        }
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1057412387$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)254@10845L6,249@10599L287:TribeeSteamList.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1057412387, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$1057412387.<anonymous> (TribeeSteamList.kt:249)");
        }
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(90), Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_195441837$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C263@11199L6,258@10953L287:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(195441837, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$195441837.<anonymous> (TribeeSteamList.kt:258)");
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(90), Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1378224214$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)317@13208L6,313@12973L292:TribeeSteamList.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1378224214, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$-1378224214.<anonymous> (TribeeSteamList.kt:313)");
        }
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__438183405$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)348@14560L6,344@14325L292:TribeeSteamList.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-438183405, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$-438183405.<anonymous> (TribeeSteamList.kt:344)");
        }
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_899740248$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C428@17519L33:TribeeSteamList.kt#k3l5ii");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(899740248, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$899740248.<anonymous> (TribeeSteamList.kt:428)");
            }
            TribeeSteamListKt.AchievementItemImagePlaceholder(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__176637790$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)431@17628L33:TribeeSteamList.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-176637790, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$-176637790.<anonymous> (TribeeSteamList.kt:431)");
        }
        TribeeSteamListKt.AchievementItemImagePlaceholder(null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1892238796$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C525@21189L1009:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1892238796, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$-1892238796.<anonymous> (TribeeSteamList.kt:525)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 450284787, "C534@21575L27,532@21502L428,543@21988L56,544@22088L6,545@22144L9,542@21951L229:TribeeSteamList.kt#k3l5ii");
            $composer.startReplaceGroup(430169998);
            ComposerKt.sourceInformation($composer, "*535@21686L6");
            String $this$asRequest$iv = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer, 0);
            ImageRequest $this$lambda__1892238796_u24lambda_u240_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$lambda__1892238796_u24lambda_u240_u240_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$lambda__1892238796_u24lambda_u240_u240_u240.build();
            $composer.endReplaceGroup();
            BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(80), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(24)), null, null, null, null, null, null, null, $composer, 48, 508);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_28(TribeeRes.INSTANCE.getString()), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
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
    public static final Unit lambda__1808844882$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C682@28776L41,689@29082L6,681@28747L408:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1808844882, $changed, -1, "kntr.app.tribee.steam.page.ComposableSingletons$TribeeSteamListKt.lambda$-1808844882.<anonymous> (TribeeSteamList.kt:681)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(srcs.app.tribee.consume.generated.resources.String0_commonMainKt.getTribee_no_more(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}