package kntr.app.mall.mallDynamicPage;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.parser.ComponentBuilderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MallDynamicPageView.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aÜ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032D\u0010\u0006\u001a@\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00072o\u0010\u000e\u001ak\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0018\u001a\u00020\u0015H\u0001¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00152\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010\u001f\"\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"MallDynamicPage", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "uiString", "jsString", "valueBridge", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "data", "bridgeCall", "Lkotlin/Function3;", "Lkotlin/Function1;", "callback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "LocalPageViewModel", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkntr/app/mall/mallDynamicPage/MallDynamicPageViewModel;", "getLocalPageViewModel$annotations", "()V", "currentPageViewModel", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/mall/mallDynamicPage/MallDynamicPageViewModel;", "ProvidePageViewModel", "viewModel", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkntr/app/mall/mallDynamicPage/MallDynamicPageViewModel;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MallDynamicPageViewKt {
    private static final ProvidableCompositionLocal<MallDynamicPageViewModel> LocalPageViewModel = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            MallDynamicPageViewModel LocalPageViewModel$lambda$0;
            LocalPageViewModel$lambda$0 = MallDynamicPageViewKt.LocalPageViewModel$lambda$0();
            return LocalPageViewModel$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MallDynamicPage$lambda$1(String str, String str2, String str3, Function2 function2, Function3 function3, int i, Composer composer, int i2) {
        MallDynamicPage(str, str2, str3, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvidePageViewModel$lambda$0(MallDynamicPageViewModel mallDynamicPageViewModel, Function2 function2, int i, Composer composer, int i2) {
        ProvidePageViewModel(mallDynamicPageViewModel, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void getLocalPageViewModel$annotations() {
    }

    public static final void MallDynamicPage(final String url, final String uiString, final String jsString, final Function2<? super String, ? super Map<String, ? extends Object>, ? extends Object> function2, final Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3, Composer $composer, final int $changed) {
        float f;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uiString, "uiString");
        Intrinsics.checkNotNullParameter(jsString, "jsString");
        Intrinsics.checkNotNullParameter(function2, "valueBridge");
        Intrinsics.checkNotNullParameter(function3, "bridgeCall");
        Composer $composer2 = $composer.startRestartGroup(-1297239449);
        ComposerKt.sourceInformation($composer2, "C(MallDynamicPage)N(url,uiString,jsString,valueBridge,bridgeCall)38@1363L12,40@1433L17,42@1503L315,42@1493L325:MallDynamicPageView.kt#uv1xve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(uiString) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(jsString) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1297239449, $dirty2, -1, "kntr.app.mall.mallDynamicPage.MallDynamicPage (MallDynamicPageView.kt:24)");
            }
            final MallDynamicPageViewModel vm = new MallDynamicPageViewModel(url, uiString, jsString, function2, function3);
            Object invoke = function2.invoke("statusBarHeight", MapsKt.emptyMap());
            String str = invoke instanceof String ? (String) invoke : null;
            if (str != null) {
                int $this$dp$iv = Integer.parseInt(str);
                f = Dp.constructor-impl($this$dp$iv);
            } else {
                f = Dp.constructor-impl(0);
            }
            final float topPadding = f;
            final float bottomPadding = WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer2, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer2, 0).calculateBottomPadding-D9Ej5fM();
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(276784671, true, new Function2() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit MallDynamicPage$lambda$0;
                    MallDynamicPage$lambda$0 = MallDynamicPageViewKt.MallDynamicPage$lambda$0(MallDynamicPageViewModel.this, topPadding, bottomPadding, (Composer) obj, ((Integer) obj2).intValue());
                    return MallDynamicPage$lambda$0;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit MallDynamicPage$lambda$1;
                    MallDynamicPage$lambda$1 = MallDynamicPageViewKt.MallDynamicPage$lambda$1(url, uiString, jsString, function2, function3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return MallDynamicPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MallDynamicPage$lambda$0(final MallDynamicPageViewModel $vm, final float $topPadding, final float $bottomPadding, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C43@1550L262,43@1513L299:MallDynamicPageView.kt#uv1xve");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(276784671, $changed, -1, "kntr.app.mall.mallDynamicPage.MallDynamicPage.<anonymous> (MallDynamicPageView.kt:43)");
            }
            ProvidePageViewModel($vm, ComposableLambdaKt.rememberComposableLambda(174620157, true, new Function2() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit MallDynamicPage$lambda$0$0;
                    MallDynamicPage$lambda$0$0 = MallDynamicPageViewKt.MallDynamicPage$lambda$0$0($topPadding, $bottomPadding, $vm, (Composer) obj, ((Integer) obj2).intValue());
                    return MallDynamicPage$lambda$0$0;
                }
            }, $composer, 54), $composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MallDynamicPage$lambda$0$0(float $topPadding, float $bottomPadding, MallDynamicPageViewModel $vm, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C44@1564L238:MallDynamicPageView.kt#uv1xve");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(174620157, $changed, -1, "kntr.app.mall.mallDynamicPage.MallDynamicPage.<anonymous>.<anonymous> (MallDynamicPageView.kt:44)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, $topPadding, 0.0f, $bottomPadding, 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1249788203, "C49@1733L55:MallDynamicPageView.kt#uv1xve");
            ComponentBuilderKt.BuildComponentTree($vm.getUi(), (Map) $vm.getDataState().getValue(), Modifier.Companion, $composer, 384, 0);
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
    public static final MallDynamicPageViewModel LocalPageViewModel$lambda$0() {
        throw new IllegalStateException("PageViewModel not provided".toString());
    }

    public static final MallDynamicPageViewModel currentPageViewModel(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1943512199, "C(currentPageViewModel)62@2097L7:MallDynamicPageView.kt#uv1xve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1943512199, $changed, -1, "kntr.app.mall.mallDynamicPage.currentPageViewModel (MallDynamicPageView.kt:62)");
        }
        CompositionLocal this_$iv = LocalPageViewModel;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        MallDynamicPageViewModel mallDynamicPageViewModel = (MallDynamicPageViewModel) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return mallDynamicPageViewModel;
    }

    public static final void ProvidePageViewModel(final MallDynamicPageViewModel viewModel, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(1594941282);
        ComposerKt.sourceInformation($composer2, "C(ProvidePageViewModel)N(viewModel,content)69@2239L82:MallDynamicPageView.kt#uv1xve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1594941282, $dirty, -1, "kntr.app.mall.mallDynamicPage.ProvidePageViewModel (MallDynamicPageView.kt:68)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPageViewModel.provides(viewModel), function2, $composer2, ProvidedValue.$stable | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProvidePageViewModel$lambda$0;
                    ProvidePageViewModel$lambda$0 = MallDynamicPageViewKt.ProvidePageViewModel$lambda$0(MallDynamicPageViewModel.this, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ProvidePageViewModel$lambda$0;
                }
            });
        }
    }
}