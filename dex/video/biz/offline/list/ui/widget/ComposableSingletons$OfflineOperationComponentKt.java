package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String0_commonMainKt;
import bili.resource.playerbaseres.String2_commonMainKt;
import bili.resource.playerbaseres.String3_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.ui.utils.ColorUtilsKt;

/* compiled from: OfflineOperationComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineOperationComponentKt {
    public static final ComposableSingletons$OfflineOperationComponentKt INSTANCE = new ComposableSingletons$OfflineOperationComponentKt();

    /* renamed from: lambda$-1536010278  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f20lambda$1536010278 = ComposableLambdaKt.composableLambdaInstance(-1536010278, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1536010278$lambda$0;
            lambda__1536010278$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda__1536010278$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1536010278$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1647529681 = ComposableLambdaKt.composableLambdaInstance(1647529681, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1647529681$lambda$0;
            lambda_1647529681$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda_1647529681$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1647529681$lambda$0;
        }
    });

    /* renamed from: lambda$-175657582  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f21lambda$175657582 = ComposableLambdaKt.composableLambdaInstance(-175657582, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__175657582$lambda$0;
            lambda__175657582$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda__175657582$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__175657582$lambda$0;
        }
    });

    /* renamed from: lambda$-1998844845  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f22lambda$1998844845 = ComposableLambdaKt.composableLambdaInstance(-1998844845, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1998844845$lambda$0;
            lambda__1998844845$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda__1998844845$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1998844845$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$472935188 = ComposableLambdaKt.composableLambdaInstance(472935188, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_472935188$lambda$0;
            lambda_472935188$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda_472935188$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_472935188$lambda$0;
        }
    });

    /* renamed from: lambda$-1350252075  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f18lambda$1350252075 = ComposableLambdaKt.composableLambdaInstance(-1350252075, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda5
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1350252075$lambda$0;
            lambda__1350252075$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda__1350252075$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1350252075$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1121527958 = ComposableLambdaKt.composableLambdaInstance(1121527958, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda6
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1121527958$lambda$0;
            lambda_1121527958$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda_1121527958$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1121527958$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$929363851 = ComposableLambdaKt.composableLambdaInstance(929363851, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda7
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_929363851$lambda$0;
            lambda_929363851$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda_929363851$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_929363851$lambda$0;
        }
    });

    /* renamed from: lambda$-1387029758  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f19lambda$1387029758 = ComposableLambdaKt.composableLambdaInstance(-1387029758, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt$$ExternalSyntheticLambda8
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1387029758$lambda$0;
            lambda__1387029758$lambda$0 = ComposableSingletons$OfflineOperationComponentKt.lambda__1387029758$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1387029758$lambda$0;
        }
    });

    /* renamed from: getLambda$-1350252075$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2907getLambda$1350252075$ui_debug() {
        return f18lambda$1350252075;
    }

    /* renamed from: getLambda$-1387029758$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2908getLambda$1387029758$ui_debug() {
        return f19lambda$1387029758;
    }

    /* renamed from: getLambda$-1536010278$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2909getLambda$1536010278$ui_debug() {
        return f20lambda$1536010278;
    }

    /* renamed from: getLambda$-175657582$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2910getLambda$175657582$ui_debug() {
        return f21lambda$175657582;
    }

    /* renamed from: getLambda$-1998844845$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2911getLambda$1998844845$ui_debug() {
        return f22lambda$1998844845;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1121527958$ui_debug() {
        return lambda$1121527958;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1647529681$ui_debug() {
        return lambda$1647529681;
    }

    public final Function2<Composer, Integer, Unit> getLambda$472935188$ui_debug() {
        return lambda$472935188;
    }

    public final Function2<Composer, Integer, Unit> getLambda$929363851$ui_debug() {
        return lambda$929363851;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1536010278$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C72@2853L25,73@2903L19,71@2808L221:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1536010278, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$-1536010278.<anonymous> (OfflineOperationComponent.kt:71)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorUtilsKt.getHeaderTintIconColor($composer, 0), $composer, Painter.$stable | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1647529681$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C89@3324L20,90@3369L19,88@3279L216:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1647529681, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$1647529681.<anonymous> (OfflineOperationComponent.kt:88)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getNut_setting_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorUtilsKt.getHeaderTintIconColor($composer, 0), $composer, Painter.$stable | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__175657582$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C106@3806L20,107@3851L19,105@3761L216:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-175657582, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$-175657582.<anonymous> (OfflineOperationComponent.kt:105)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getList_select_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorUtilsKt.getHeaderTintIconColor($composer, 0), $composer, Painter.$stable | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1998844845$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C124@4392L9,125@4431L19,122@4243L302:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998844845, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$-1998844845.<anonymous> (OfflineOperationComponent.kt:122)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2169(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, ColorUtilsKt.getHeaderTintTextColor($composer, 0), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 24960, 110586);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_472935188$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C142@4943L9,143@4982L19,140@4795L301:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(472935188, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$472935188.<anonymous> (OfflineOperationComponent.kt:140)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String3_commonMainKt.getPlayerbaseres_global_string_863(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, ColorUtilsKt.getHeaderTintTextColor($composer, 0), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 24960, 110586);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1350252075$lambda$0(Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C158@5366L728:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1350252075, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$-1350252075.<anonymous> (OfflineOperationComponent.kt:158)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -240957650, "C160@5485L21,161@5545L6,159@5436L245,165@5698L39,168@5911L9,169@5954L19,166@5754L326:OfflineOperationComponent.kt#uys4uf");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getVideo_circle_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer, 6);
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2201(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, ColorUtilsKt.getHeaderTintTextColor($composer, 0), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 24960, 110586);
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
    public static final Unit lambda_1121527958$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C187@6510L9,188@6549L19,185@6362L301:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121527958, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$1121527958.<anonymous> (OfflineOperationComponent.kt:185)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String3_commonMainKt.getPlayerbaseres_global_string_833(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, ColorUtilsKt.getHeaderTintTextColor($composer, 0), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 24960, 110586);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_929363851$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C215@7314L9,216@7363L6,213@7165L225:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(929363851, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$929363851.<anonymous> (OfflineOperationComponent.kt:213)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1369(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1387029758$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C236@8085L9,237@8134L6,234@7936L225:OfflineOperationComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1387029758, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineOperationComponentKt.lambda$-1387029758.<anonymous> (OfflineOperationComponent.kt:234)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2171(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}