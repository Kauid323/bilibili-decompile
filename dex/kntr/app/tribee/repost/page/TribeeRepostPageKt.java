package kntr.app.tribee.repost.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.consume.page.TribeePageStatusComposeKt;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.action.TribeeRepostUIAction;
import kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetKt;
import kntr.app.tribee.repost.page.editTextBottomSheet.EditTextBottomSheetState;
import kntr.app.tribee.repost.page.introBottomSheet.IntroBottomSheetKt;
import kntr.app.tribee.repost.page.introBottomSheet.IntroBottomSheetState;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetKt;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetStateAction;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetViewModel;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.tribee.repost.viewmodel.TribeeRepostEntryPoint;
import kntr.app.tribee.repost.viewmodel.TribeeRepostViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeRepostPage.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"TribeeRepostPage", "", "originDynamicId", "", "fromSpmid", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "TribeeRepostPageContent", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "pageState", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;Lkntr/app/tribee/repost/state/TribeeRepostState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "repost_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeRepostPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPage$lambda$8(String str, String str2, int i, int i2, Composer composer, int i3) {
        TribeeRepostPage(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$1(Function1 function1, TribeeRepostState tribeeRepostState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeRepostPageContent(function1, tribeeRepostState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02bc, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x023b, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x027d, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeRepostPage(String originDynamicId, String fromSpmid, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        final String originDynamicId2;
        final String fromSpmid2;
        Long longOrNull;
        Composer $composer2 = $composer.startRestartGroup(508740893);
        ComposerKt.sourceInformation($composer2, "C(TribeeRepostPage)N(originDynamicId,fromSpmid)61@3034L24,63@3110L273,71@3405L38,72@3469L150,72@3448L171,78@3645L94,78@3624L115,84@3772L7,85@3809L7,87@3869L7,89@3902L92,96@4063L63,100@4181L389,115@4597L103,115@4576L124,121@4716L414,121@4706L424:TribeeRepostPage.kt#qxdvwz");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = originDynamicId;
        } else if (($changed & 6) == 0) {
            str = originDynamicId;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = originDynamicId;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = fromSpmid;
        } else if (($changed & 48) == 0) {
            str2 = fromSpmid;
            $dirty |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = fromSpmid;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            originDynamicId2 = i2 != 0 ? null : str;
            fromSpmid2 = i3 != 0 ? null : str2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(508740893, $dirty2, -1, "kntr.app.tribee.repost.page.TribeeRepostPage (TribeeRepostPage.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -726265394, "CC(remember):TribeeRepostPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((TribeeRepostEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeeRepostEntryPoint.class))).getTribeeRepostComponentFactory().build(scope, (originDynamicId2 == null || (longOrNull = StringsKt.toLongOrNull(originDynamicId2)) == null) ? 0L : longOrNull.longValue(), fromSpmid2 == null ? "" : fromSpmid2).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeeRepostViewModel viewModel = (TribeeRepostViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger(TribeeRepostTrackKt.REPOST_PAGE_PV, $composer2, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -726254029, "CC(remember):TribeeRepostPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(pvTrigger) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeeRepostPageKt$TribeeRepostPage$1$1(pvTrigger, originDynamicId2, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -726248453, "CC(remember):TribeeRepostPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeRepostPageKt$TribeeRepostPage$2$1(originDynamicId2, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv3, $composer2, 6);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume;
            CompositionLocal this_$iv2 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume2;
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, -726240231, "CC(remember):TribeeRepostPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit TribeeRepostPage$lambda$3$0;
                        TribeeRepostPage$lambda$3$0 = TribeeRepostPageKt.TribeeRepostPage$lambda$3$0(backHandler);
                        return TribeeRepostPage$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final Function0 onBack = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -726235108, "CC(remember):TribeeRepostPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(viewModel);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5 = (KFunction) new TribeeRepostPageKt$TribeeRepostPage$onStateAction$1$1(viewModel);
            $composer2.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function1 onStateAction = (KFunction) it$iv5;
            ComposerKt.sourceInformationMarkerStart($composer2, -726231006, "CC(remember):TribeeRepostPage.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changedInstance(toaster) | $composer2.changedInstance(router);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj) {
                    Unit TribeeRepostPage$lambda$5$0;
                    TribeeRepostPage$lambda$5$0 = TribeeRepostPageKt.TribeeRepostPage$lambda$5$0(onBack, toaster, router, (TribeeRepostUIAction) obj);
                    return TribeeRepostPage$lambda$5$0;
                }
            };
            $composer2.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            Function1 onUIAction = (Function1) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -726217980, "CC(remember):TribeeRepostPage.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changedInstance(viewModel) | $composer2.changed(onUIAction);
            TribeeRepostPageKt$TribeeRepostPage$3$1 value$iv7 = $composer2.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv7 = new TribeeRepostPageKt$TribeeRepostPage$3$1(viewModel, onUIAction, null);
            $composer2.updateRememberedValue(value$iv7);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit3, (Function2) value$iv7, $composer2, 6);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1772705691, true, new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeRepostPage$lambda$7;
                    TribeeRepostPage$lambda$7 = TribeeRepostPageKt.TribeeRepostPage$lambda$7(TribeeRepostViewModel.this, onStateAction, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeRepostPage$lambda$7;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            originDynamicId2 = str;
            fromSpmid2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeRepostPage$lambda$8;
                    TribeeRepostPage$lambda$8 = TribeeRepostPageKt.TribeeRepostPage$lambda$8(originDynamicId2, fromSpmid2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeRepostPage$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPage$lambda$3$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPage$lambda$5$0(Function0 $onBack, Toaster $toaster, Router $router, TribeeRepostUIAction uiAction) {
        String it;
        Intrinsics.checkNotNullParameter(uiAction, "uiAction");
        if (uiAction instanceof TribeeRepostUIAction.ToastTips) {
            TribeeToast tribeeToast = ((TribeeRepostUIAction.ToastTips) uiAction).getTribeeToast();
            if (tribeeToast != null && (it = tribeeToast.getContent()) != null) {
                Toaster.CC.showToast$default($toaster, it, null, 2, null);
            }
        } else if (uiAction instanceof TribeeRepostUIAction.CloseAndRouterTo) {
            $onBack.invoke();
            Uri it2 = TribeeExtensionsKt.toUriOrNull(((TribeeRepostUIAction.CloseAndRouterTo) uiAction).getUrl());
            if (it2 != null) {
                $router.launch(it2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPage$lambda$7(TribeeRepostViewModel $viewModel, Function1 $onStateAction, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C122@4745L28,123@4806L13,124@4875L64,124@4851L88,128@4981L16,129@5006L118:TribeeRepostPage.kt#qxdvwz");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1772705691, $changed, -1, "kntr.app.tribee.repost.page.TribeeRepostPage.<anonymous> (TribeeRepostPage.kt:122)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, 1531852613, "CC(remember):TribeeRepostPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(uiController) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeRepostPageKt$TribeeRepostPage$4$1$1(uiController, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            State pageState = SnapshotStateKt.collectAsState($viewModel.getState(), (CoroutineContext) null, $composer, 0, 1);
            TribeeRepostPageContent($onStateAction, (TribeeRepostState) pageState.getValue(), null, $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void TribeeRepostPageContent(final Function1<? super TribeeRepostStateAction, Unit> function1, final TribeeRepostState pageState, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(function1, "onStateAction");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer2 = $composer.startRestartGroup(1291981783);
        ComposerKt.sourceInformation($composer2, "C(TribeeRepostPageContent)N(onStateAction,pageState,modifier)146@5404L7624,142@5306L7722:TribeeRepostPage.kt#qxdvwz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(pageState) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if ((i & 4) != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1291981783, $dirty2, -1, "kntr.app.tribee.repost.page.TribeeRepostPageContent (TribeeRepostPage.kt:141)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1073594945, true, new Function3() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeRepostPageContent$lambda$0;
                    TribeeRepostPageContent$lambda$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0(TribeeRepostState.this, function1, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeRepostPageContent$lambda$0;
                }
            }, $composer2, 54), $composer2, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeRepostPageContent$lambda$1;
                    TribeeRepostPageContent$lambda$1 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$1(function1, pageState, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeRepostPageContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0426, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeRepostPageContent$lambda$0(TribeeRepostState $pageState, final Function1 $onStateAction, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C152@5585L6,148@5452L7570:TribeeRepostPage.kt#qxdvwz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1073594945, $dirty, -1, "kntr.app.tribee.repost.page.TribeeRepostPageContent.<anonymous> (TribeeRepostPage.kt:147)");
            }
            float contentHeight = $this$BoxWithConstraints.getMaxHeight-D9Ej5fM();
            Modifier modifier$iv = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -98671421, "C158@5799L56,155@5663L207:TribeeRepostPage.kt#qxdvwz");
            TribeeRepostNavigationRowKt.TribeeRepostNavigationRow(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_59(TribeeRes.INSTANCE.getString()), $composer, 0), $composer, 6, 0);
            if ($pageState instanceof TribeeRepostState.TribeeRepostLoadingState) {
                $composer.startReplaceGroup(-98588931);
                ComposerKt.sourceInformation($composer, "163@5990L210");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                $composer$iv2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer$iv$iv = $composer;
                $composer$iv$iv$iv = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                $composer$iv = $composer;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -907400025, "C167@6163L15:TribeeRepostPage.kt#qxdvwz");
                TribeePageStatusComposeKt.TribeeLoading(null, $composer, 0, 1);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer$iv = $composer;
                $composer$iv$iv = $composer;
                $composer$iv2 = $composer;
                $composer$iv$iv$iv = $composer;
                if ($pageState instanceof TribeeRepostState.TribeeRepostErrorState) {
                    $composer.startReplaceGroup(-98271026);
                    ComposerKt.sourceInformation($composer, "172@6305L385");
                    Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i6 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -515578431, "C177@6531L110,176@6478L190:TribeeRepostPage.kt#qxdvwz");
                    ComposerKt.sourceInformationMarkerStart($composer, 399012050, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($onStateAction);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit TribeeRepostPageContent$lambda$0$0$1$0$0;
                            TribeeRepostPageContent$lambda$0$0$1$0$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$1$0$0($onStateAction);
                            return TribeeRepostPageContent$lambda$0$0$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeePageStatusComposeKt.TribeeError(null, false, (Function0) it$iv, $composer, 0, 3);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                } else if (!($pageState instanceof TribeeRepostState.TribeeRepostContentState)) {
                    $composer.startReplaceGroup(1243749891);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                } else {
                    $composer.startReplaceGroup(-97603224);
                    ComposerKt.sourceInformation($composer, "187@6907L122,190@7070L115,193@7225L122,196@7401L139,199@7593L138,202@7773L106,185@6797L1164,222@8779L1512");
                    TribeeRepostState.TribeeRepostContentState tribeeRepostContentState = (TribeeRepostState.TribeeRepostContentState) $pageState;
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1243775621, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changed($onStateAction);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit TribeeRepostPageContent$lambda$0$0$2$0;
                                TribeeRepostPageContent$lambda$0$0$2$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$2$0($onStateAction);
                                return TribeeRepostPageContent$lambda$0$0$2$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    Function0 function0 = (Function0) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1243780830, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv3 = $composer.changed($onStateAction);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit TribeeRepostPageContent$lambda$0$0$3$0;
                                TribeeRepostPageContent$lambda$0$0$3$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$3$0($onStateAction);
                                return TribeeRepostPageContent$lambda$0$0$3$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    Function0 function02 = (Function0) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1243785797, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv4 = $composer.changed($onStateAction);
                    Object it$iv4 = $composer.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit TribeeRepostPageContent$lambda$0$0$4$0;
                                TribeeRepostPageContent$lambda$0$0$4$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$4$0($onStateAction);
                                return TribeeRepostPageContent$lambda$0$0$4$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    Function0 function03 = (Function0) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1243791446, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv5 = $composer.changed($onStateAction);
                    Object it$iv5 = $composer.rememberedValue();
                    if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj) {
                                Unit TribeeRepostPageContent$lambda$0$0$5$0;
                                TribeeRepostPageContent$lambda$0$0$5$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$5$0($onStateAction, ((Boolean) obj).booleanValue());
                                return TribeeRepostPageContent$lambda$0$0$5$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    Function1 function1 = (Function1) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1243797589, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv6 = $composer.changed($onStateAction);
                    Object it$iv6 = $composer.rememberedValue();
                    if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj) {
                                Unit TribeeRepostPageContent$lambda$0$0$6$0;
                                TribeeRepostPageContent$lambda$0$0$6$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$6$0($onStateAction, ((Boolean) obj).booleanValue());
                                return TribeeRepostPageContent$lambda$0$0$6$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    Function1 function12 = (Function1) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1243803317, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    boolean invalid$iv7 = $composer.changed($onStateAction);
                    Object it$iv7 = $composer.rememberedValue();
                    if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                Unit TribeeRepostPageContent$lambda$0$0$7$0;
                                TribeeRepostPageContent$lambda$0$0$7$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$7$0($onStateAction);
                                return TribeeRepostPageContent$lambda$0$0$7$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv7);
                        it$iv7 = value$iv7;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeeRepostContentKt.TribeeRepostContent(tribeeRepostContentState, fillMaxSize$default, function0, function02, function03, function1, function12, (Function0) it$iv7, $composer, 48, 0);
                    if (((TribeeRepostState.TribeeRepostContentState) $pageState).getIntroBottomSheetState() != null) {
                        $composer.startReplaceGroup(-96533445);
                        ComposerKt.sourceInformation($composer, "210@8179L126,213@8347L131,216@8520L126,208@8053L620");
                        IntroBottomSheetState introBottomSheetState = ((TribeeRepostState.TribeeRepostContentState) $pageState).getIntroBottomSheetState();
                        ComposerKt.sourceInformationMarkerStart($composer, 1243816329, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv8 = $composer.changed($onStateAction);
                        Object it$iv8 = $composer.rememberedValue();
                        if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                            Object value$iv8 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda10
                                public final Object invoke() {
                                    Unit TribeeRepostPageContent$lambda$0$0$8$0;
                                    TribeeRepostPageContent$lambda$0$0$8$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$8$0($onStateAction);
                                    return TribeeRepostPageContent$lambda$0$0$8$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv8);
                            it$iv8 = value$iv8;
                        }
                        Function0 function04 = (Function0) it$iv8;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243821710, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv9 = $composer.changed($onStateAction);
                        Object it$iv9 = $composer.rememberedValue();
                        if (invalid$iv9 || it$iv9 == Composer.Companion.getEmpty()) {
                            Object value$iv9 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda20
                                public final Object invoke() {
                                    Unit TribeeRepostPageContent$lambda$0$0$9$0;
                                    TribeeRepostPageContent$lambda$0$0$9$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$9$0($onStateAction);
                                    return TribeeRepostPageContent$lambda$0$0$9$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv9);
                            it$iv9 = value$iv9;
                        }
                        Function0 function05 = (Function0) it$iv9;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243827241, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv10 = $composer.changed($onStateAction);
                        Object it$iv10 = $composer.rememberedValue();
                        if (invalid$iv10 || it$iv10 == Composer.Companion.getEmpty()) {
                            Object value$iv10 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda21
                                public final Object invoke() {
                                    Unit TribeeRepostPageContent$lambda$0$0$10$0;
                                    TribeeRepostPageContent$lambda$0$0$10$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$10$0($onStateAction);
                                    return TribeeRepostPageContent$lambda$0$0$10$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv10);
                            it$iv10 = value$iv10;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        IntroBottomSheetKt.IntroBottomSheet(introBottomSheetState, null, function04, function05, (Function0) it$iv10, $composer, 0, 2);
                    } else {
                        $composer.startReplaceGroup(-104517929);
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart($composer, 1243836915, "CC(remember):TribeeRepostPage.kt#9igjgp");
                    Object it$iv11 = $composer.rememberedValue();
                    if (it$iv11 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new SelectTribeeBottomSheetViewModel(new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda22
                            public final Object invoke() {
                                long TribeeRepostPageContent$lambda$0$0$11$0;
                                TribeeRepostPageContent$lambda$0$0$11$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$11$0();
                                return Long.valueOf(TribeeRepostPageContent$lambda$0$0$11$0);
                            }
                        }, new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda23
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TribeeRepostPageContent$lambda$0$0$11$1;
                                TribeeRepostPageContent$lambda$0$0$11$1 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$11$1($onStateAction, ((Long) obj).longValue(), (String) obj2);
                                return TribeeRepostPageContent$lambda$0$0$11$1;
                            }
                        }, new Function3() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda24
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit TribeeRepostPageContent$lambda$0$0$11$2;
                                TribeeRepostPageContent$lambda$0$0$11$2 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$11$2($onStateAction, (Pair) obj, (Pair) obj2, ((Boolean) obj3).booleanValue());
                                return TribeeRepostPageContent$lambda$0$0$11$2;
                            }
                        }, new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda25
                            public final Object invoke() {
                                Unit TribeeRepostPageContent$lambda$0$0$11$3;
                                TribeeRepostPageContent$lambda$0$0$11$3 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$11$3($onStateAction);
                                return TribeeRepostPageContent$lambda$0$0$11$3;
                            }
                        });
                        $composer.updateRememberedValue(value$iv11);
                        it$iv11 = value$iv11;
                    }
                    SelectTribeeBottomSheetViewModel selectTribeeBottomSheetViewModel = (SelectTribeeBottomSheetViewModel) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (((TribeeRepostState.TribeeRepostContentState) $pageState).getShowSelectTribeeBottomSheet()) {
                        $composer.startReplaceGroup(-94223790);
                        ComposerKt.sourceInformation($composer, "257@10835L175");
                        if (!((TribeeRepostState.TribeeRepostContentState) $pageState).getHasLoadedSelectTribeeBottomSheet()) {
                            selectTribeeBottomSheetViewModel.dispatch(SelectTribeeBottomSheetStateAction.Loading.INSTANCE);
                            $onStateAction.invoke(TribeeRepostStateAction.SelectTribeeBottomSheetHasLoaded.INSTANCE);
                        }
                        Dp dp = Dp.box-impl(Dp.constructor-impl(560));
                        float other$iv = Dp.constructor-impl(contentHeight * 0.7f);
                        float maxHeight = ComparisonsKt.minOf(dp, Dp.box-impl(other$iv)).unbox-impl();
                        SelectTribeeBottomSheetKt.m1019SelectTribeeBottomSheetuFdPcIQ(selectTribeeBottomSheetViewModel, maxHeight, null, $composer, 0, 4);
                    } else {
                        $composer.startReplaceGroup(-104517929);
                    }
                    $composer.endReplaceGroup();
                    if (((TribeeRepostState.TribeeRepostContentState) $pageState).getEditRepostMainTextBottomSheetState() != null) {
                        $composer.startReplaceGroup(-93442869);
                        ComposerKt.sourceInformation($composer, "265@11279L133,268@11457L132,274@11811L143,271@11631L138,263@11137L844");
                        EditTextBottomSheetState editRepostMainTextBottomSheetState = ((TribeeRepostState.TribeeRepostContentState) $pageState).getEditRepostMainTextBottomSheetState();
                        ComposerKt.sourceInformationMarkerStart($composer, 1243915536, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv11 = $composer.changed($onStateAction);
                        Object it$iv12 = $composer.rememberedValue();
                        if (invalid$iv11 || it$iv12 == Composer.Companion.getEmpty()) {
                            Object value$iv12 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda26
                                public final Object invoke() {
                                    Unit TribeeRepostPageContent$lambda$0$0$12$0;
                                    TribeeRepostPageContent$lambda$0$0$12$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$12$0($onStateAction);
                                    return TribeeRepostPageContent$lambda$0$0$12$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv12);
                            it$iv12 = value$iv12;
                        }
                        Function0 function06 = (Function0) it$iv12;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243921231, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv12 = $composer.changed($onStateAction);
                        Object it$iv13 = $composer.rememberedValue();
                        if (invalid$iv12 || it$iv13 == Composer.Companion.getEmpty()) {
                            Object value$iv13 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda27
                                public final Object invoke(Object obj) {
                                    Unit TribeeRepostPageContent$lambda$0$0$13$0;
                                    TribeeRepostPageContent$lambda$0$0$13$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$13$0($onStateAction, (String) obj);
                                    return TribeeRepostPageContent$lambda$0$0$13$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv13);
                            it$iv13 = value$iv13;
                        }
                        Function1 function13 = (Function1) it$iv13;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243932570, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv13 = $composer.changed($onStateAction);
                        Object it$iv14 = $composer.rememberedValue();
                        if (invalid$iv13 || it$iv14 == Composer.Companion.getEmpty()) {
                            Object value$iv14 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    Unit TribeeRepostPageContent$lambda$0$0$14$0;
                                    TribeeRepostPageContent$lambda$0$0$14$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$14$0($onStateAction, (String) obj);
                                    return TribeeRepostPageContent$lambda$0$0$14$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv14);
                            it$iv14 = value$iv14;
                        }
                        Function1 function14 = (Function1) it$iv14;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243926805, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv14 = $composer.changed($onStateAction);
                        Object it$iv15 = $composer.rememberedValue();
                        if (invalid$iv14 || it$iv15 == Composer.Companion.getEmpty()) {
                            Object value$iv15 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    Unit TribeeRepostPageContent$lambda$0$0$15$0;
                                    TribeeRepostPageContent$lambda$0$0$15$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$15$0($onStateAction, (String) obj);
                                    return TribeeRepostPageContent$lambda$0$0$15$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv15);
                            it$iv15 = value$iv15;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        EditTextBottomSheetKt.EditTextBottomSheet(editRepostMainTextBottomSheetState, null, function06, function13, function14, (Function1) it$iv15, $composer, 0, 2);
                    } else {
                        $composer.startReplaceGroup(-104517929);
                    }
                    $composer.endReplaceGroup();
                    if (((TribeeRepostState.TribeeRepostContentState) $pageState).getEditRepostTitleTextBottomSheetState() != null) {
                        $composer.startReplaceGroup(-92478490);
                        ComposerKt.sourceInformation($composer, "282@12252L134,285@12431L133,291@12787L144,288@12606L139,280@12109L849");
                        EditTextBottomSheetState editRepostTitleTextBottomSheetState = ((TribeeRepostState.TribeeRepostContentState) $pageState).getEditRepostTitleTextBottomSheetState();
                        ComposerKt.sourceInformationMarkerStart($composer, 1243946673, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv15 = $composer.changed($onStateAction);
                        Object it$iv16 = $composer.rememberedValue();
                        if (invalid$iv15 || it$iv16 == Composer.Companion.getEmpty()) {
                            Object value$iv16 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit TribeeRepostPageContent$lambda$0$0$16$0;
                                    TribeeRepostPageContent$lambda$0$0$16$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$16$0($onStateAction);
                                    return TribeeRepostPageContent$lambda$0$0$16$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv16);
                            it$iv16 = value$iv16;
                        }
                        Function0 function07 = (Function0) it$iv16;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243952400, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv16 = $composer.changed($onStateAction);
                        Object it$iv17 = $composer.rememberedValue();
                        if (invalid$iv16 || it$iv17 == Composer.Companion.getEmpty()) {
                            Object value$iv17 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    Unit TribeeRepostPageContent$lambda$0$0$17$0;
                                    TribeeRepostPageContent$lambda$0$0$17$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$17$0($onStateAction, (String) obj);
                                    return TribeeRepostPageContent$lambda$0$0$17$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv17);
                            it$iv17 = value$iv17;
                        }
                        Function1 function15 = (Function1) it$iv17;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243963803, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv17 = $composer.changed($onStateAction);
                        Object it$iv18 = $composer.rememberedValue();
                        if (invalid$iv17 || it$iv18 == Composer.Companion.getEmpty()) {
                            Object value$iv18 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    Unit TribeeRepostPageContent$lambda$0$0$18$0;
                                    TribeeRepostPageContent$lambda$0$0$18$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$18$0($onStateAction, (String) obj);
                                    return TribeeRepostPageContent$lambda$0$0$18$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv18);
                            it$iv18 = value$iv18;
                        }
                        Function1 function16 = (Function1) it$iv18;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1243958006, "CC(remember):TribeeRepostPage.kt#9igjgp");
                        boolean invalid$iv18 = $composer.changed($onStateAction);
                        Object it$iv19 = $composer.rememberedValue();
                        if (invalid$iv18 || it$iv19 == Composer.Companion.getEmpty()) {
                            Object value$iv19 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostPageKt$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    Unit TribeeRepostPageContent$lambda$0$0$19$0;
                                    TribeeRepostPageContent$lambda$0$0$19$0 = TribeeRepostPageKt.TribeeRepostPageContent$lambda$0$0$19$0($onStateAction, (String) obj);
                                    return TribeeRepostPageContent$lambda$0$0$19$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv19);
                            it$iv19 = value$iv19;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        EditTextBottomSheetKt.EditTextBottomSheet(editRepostTitleTextBottomSheetState, null, function07, function15, function16, (Function1) it$iv19, $composer, 0, 2);
                    } else {
                        $composer.startReplaceGroup(-104517929);
                    }
                    $composer.endReplaceGroup();
                    $composer.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$1$0$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.Loading.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$2$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.ShowSelectTribeeBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$3$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.ShowIntroBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$4$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.ShowEditMainTextBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$5$0(Function1 $onStateAction, boolean checked) {
        $onStateAction.invoke(new TribeeRepostStateAction.RepostToFollowingChanged(checked));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$6$0(Function1 $onStateAction, boolean checked) {
        $onStateAction.invoke(new TribeeRepostStateAction.RepostWithSourceChanged(checked));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$7$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.RepostClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$8$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.IntroBottomSheetExposed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$9$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.IntroBottomSheetConfirmClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$10$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.DismissIntroBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long TribeeRepostPageContent$lambda$0$0$11$0() {
        return TribeePreference.INSTANCE.getDefaultRepostTribeeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$11$1(Function1 $onStateAction, long tribeeId, String tribeeName) {
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        $onStateAction.invoke(new TribeeRepostStateAction.SelectTribeeBottomSheetTribeeItemExposed(tribeeId, tribeeName));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$11$2(Function1 $onStateAction, Pair tribeePair, Pair partitionPair, boolean byUserClick) {
        Intrinsics.checkNotNullParameter(tribeePair, "tribeePair");
        Intrinsics.checkNotNullParameter(partitionPair, "partitionPair");
        $onStateAction.invoke(new TribeeRepostStateAction.SelectedTribeeOrPartitionChanged(tribeePair, partitionPair, byUserClick));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$11$3(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.DismissSelectTribeeBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$12$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.EditMainTextBottomSheetExposed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$13$0(Function1 $onStateAction, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        $onStateAction.invoke(new TribeeRepostStateAction.MainTextChanged(text));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$15$0(Function1 $onStateAction, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        $onStateAction.invoke(TribeeRepostStateAction.DismissEditMainTextBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$14$0(Function1 $onStateAction, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        $onStateAction.invoke(TribeeRepostStateAction.EditMainTextBottomSheetConfirmClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$16$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeRepostStateAction.EditTitleTextBottomSheetExposed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$17$0(Function1 $onStateAction, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        $onStateAction.invoke(new TribeeRepostStateAction.TitleTextChanged(text));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$19$0(Function1 $onStateAction, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        $onStateAction.invoke(TribeeRepostStateAction.DismissEditTitleTextBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostPageContent$lambda$0$0$18$0(Function1 $onStateAction, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        $onStateAction.invoke(TribeeRepostStateAction.EditTitleTextBottomSheetConfirmClick.INSTANCE);
        return Unit.INSTANCE;
    }
}