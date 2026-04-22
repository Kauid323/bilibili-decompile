package kntr.app.tribee.invite.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeShareConfig;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.TribeePageStatusComposeKt;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.invite.page.InviteItem;
import kntr.app.tribee.invite.state.TribeeInviteState;
import kntr.app.tribee.invite.track.InviteTrackerKt;
import kntr.app.tribee.invite.viewmodel.TribeeInviteEntryPoint;
import kntr.app.tribee.invite.viewmodel.TribeeInviteStateAction;
import kntr.app.tribee.invite.viewmodel.TribeeInviteUIAction;
import kntr.app.tribee.invite.viewmodel.TribeeInviteViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.share.common.ShareParams;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeInvitePage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001aO\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002"}, d2 = {"TribeeInvitePage", "", "fromTribeeId", "", "fromSpmid", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "TribeeInvitePageContent", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction;", "onUIAction", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "", "pageState", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;JLkntr/app/tribee/invite/state/TribeeInviteState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug", "shareCode", "Lkntr/app/tribee/invite/page/InviteItem$CodeItem;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInvitePageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePage$lambda$9(String str, String str2, int i, int i2, Composer composer, int i3) {
        TribeeInvitePage(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePageContent$lambda$3(Function1 function1, Function1 function12, long j, TribeeInviteState tribeeInviteState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeInvitePageContent(function1, function12, j, tribeeInviteState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x01f5, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0236, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0274, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeInvitePage(String fromTribeeId, String fromSpmid, Composer $composer, final int $changed, final int i) {
        String str;
        final String fromSpmid2;
        final String fromTribeeId2;
        Long longOrNull;
        Composer $composer2 = $composer.startRestartGroup(1671309203);
        ComposerKt.sourceInformation($composer2, "C(TribeeInvitePage)N(fromTribeeId,fromSpmid)57@2574L24,59@2650L253,66@2935L7,67@2972L7,69@3001L38,70@3065L153,70@3044L174,77@3241L67,82@3377L63,86@3495L464,104@3986L103,104@3965L124,110@4105L1762,110@4095L1772:TribeeInvitePage.kt#8mvn07");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = fromTribeeId;
        } else if (($changed & 6) == 0) {
            str = fromTribeeId;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = fromTribeeId;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            fromSpmid2 = fromSpmid;
        } else if (($changed & 48) == 0) {
            fromSpmid2 = fromSpmid;
            $dirty |= $composer2.changed(fromSpmid2) ? 32 : 16;
        } else {
            fromSpmid2 = fromSpmid;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            fromTribeeId2 = i2 != 0 ? null : str;
            if (i3 != 0) {
                fromSpmid2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1671309203, $dirty2, -1, "kntr.app.tribee.invite.page.TribeeInvitePage (TribeeInvitePage.kt:56)");
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
            ComposerKt.sourceInformationMarkerStart($composer2, -189616656, "CC(remember):TribeeInvitePage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((TribeeInviteEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeeInviteEntryPoint.class))).getTribeeInviteComponentFactory().build(scope, (fromTribeeId2 == null || (longOrNull = StringsKt.toLongOrNull(fromTribeeId2)) == null) ? 0L : longOrNull.longValue()).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeeInviteViewModel viewModel = (TribeeInviteViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger(InviteTrackerKt.INVITE_PAGE_PV, $composer2, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -189603476, "CC(remember):TribeeInvitePage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changedInstance(pvTrigger) | (($dirty2 & 112) == 32);
            TribeeInvitePageKt$TribeeInvitePage$1$1 value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new TribeeInvitePageKt$TribeeInvitePage$1$1(pvTrigger, fromTribeeId2, fromSpmid2, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -189597930, "CC(remember):TribeeInvitePage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            final MutableState shareCode$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -189593582, "CC(remember):TribeeInvitePage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(viewModel);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4 = (KFunction) new TribeeInvitePageKt$TribeeInvitePage$onStateAction$1$1(viewModel);
            $composer2.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function1 onStateAction = (KFunction) it$iv3;
            ComposerKt.sourceInformationMarkerStart($composer2, -189589405, "CC(remember):TribeeInvitePage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(toaster) | $composer2.changedInstance(router);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5 = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit TribeeInvitePage$lambda$6$0;
                    TribeeInvitePage$lambda$6$0 = TribeeInvitePageKt.TribeeInvitePage$lambda$6$0(Toaster.this, router, shareCode$delegate, (TribeeInviteUIAction) obj);
                    return TribeeInvitePage$lambda$6$0;
                }
            };
            $composer2.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            final Function1 onUIAction = (Function1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -189574054, "CC(remember):TribeeInvitePage.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changedInstance(viewModel) | $composer2.changed(onUIAction);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6 = (Function2) new TribeeInvitePageKt$TribeeInvitePage$2$1(viewModel, onUIAction, null);
            $composer2.updateRememberedValue(value$iv6);
            it$iv5 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv5, $composer2, 6);
            final String str2 = fromTribeeId2;
            final String str3 = fromSpmid2;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-610137381, true, new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInvitePage$lambda$8;
                    TribeeInvitePage$lambda$8 = TribeeInvitePageKt.TribeeInvitePage$lambda$8(TribeeInviteViewModel.this, str2, onStateAction, onUIAction, str3, shareCode$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInvitePage$lambda$8;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            fromTribeeId2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInvitePage$lambda$9;
                    TribeeInvitePage$lambda$9 = TribeeInvitePageKt.TribeeInvitePage$lambda$9(fromTribeeId2, fromSpmid2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInvitePage$lambda$9;
                }
            });
        }
    }

    private static final InviteItem.CodeItem TribeeInvitePage$lambda$3(MutableState<InviteItem.CodeItem> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (InviteItem.CodeItem) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePage$lambda$6$0(Toaster $toaster, Router $router, MutableState $shareCode$delegate, TribeeInviteUIAction uiAction) {
        String it;
        Intrinsics.checkNotNullParameter(uiAction, "uiAction");
        if (uiAction instanceof TribeeInviteUIAction.ToastTips) {
            TribeeToast tribeeToast = ((TribeeInviteUIAction.ToastTips) uiAction).getTribeeToast();
            if (tribeeToast != null && (it = tribeeToast.getContent()) != null) {
                Toaster.CC.showToast$default($toaster, it, null, 2, null);
            }
        } else if (uiAction instanceof TribeeInviteUIAction.RouterTo) {
            Uri it2 = TribeeExtensionsKt.toUriOrNull(((TribeeInviteUIAction.RouterTo) uiAction).getUrl());
            if (it2 != null) {
                $router.launch(it2);
            }
        } else if (uiAction instanceof TribeeInviteUIAction.ShareCode) {
            $shareCode$delegate.setValue(((TribeeInviteUIAction.ShareCode) uiAction).getCode());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePage$lambda$8(TribeeInviteViewModel $viewModel, String $fromTribeeId, Function1 $onStateAction, Function1 $onUIAction, String $fromSpmid, final MutableState $shareCode$delegate, Composer $composer, int $changed) {
        Long longOrNull;
        ComposerKt.sourceInformation($composer, "C111@4134L28,112@4195L13,113@4264L64,113@4240L88,117@4370L16,118@4395L218:TribeeInvitePage.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-610137381, $changed, -1, "kntr.app.tribee.invite.page.TribeeInvitePage.<anonymous> (TribeeInvitePage.kt:111)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, 2068501563, "CC(remember):TribeeInvitePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(uiController) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeInvitePageKt$TribeeInvitePage$3$1$1(uiController, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            State pageState = SnapshotStateKt.collectAsState($viewModel.getState(), (CoroutineContext) null, $composer, 0, 1);
            TribeeInvitePageContent($onStateAction, $onUIAction, ($fromTribeeId == null || (longOrNull = StringsKt.toLongOrNull($fromTribeeId)) == null) ? 0L : longOrNull.longValue(), (TribeeInviteState) pageState.getValue(), null, $composer, 0, 16);
            if (TribeeInvitePage$lambda$3($shareCode$delegate) != null) {
                $composer.startReplaceGroup(-300546360);
                ComposerKt.sourceInformation($composer, "");
                InviteItem.CodeItem TribeeInvitePage$lambda$3 = TribeeInvitePage$lambda$3($shareCode$delegate);
                Intrinsics.checkNotNull(TribeeInvitePage$lambda$3);
                KTribeeInviteCodeShareConfig shareConfig = TribeeInvitePage$lambda$3.getCode().getShareConfig();
                if (shareConfig != null) {
                    $composer.startReplaceGroup(-300437302);
                    ComposerKt.sourceInformation($composer, "146@5727L56,128@4762L1021");
                    InviteItem.CodeItem TribeeInvitePage$lambda$32 = TribeeInvitePage$lambda$3($shareCode$delegate);
                    Intrinsics.checkNotNull(TribeeInvitePage$lambda$32);
                    String inviteCode = TribeeInvitePage$lambda$32.getCode().getInviteCode();
                    InviteItem.CodeItem TribeeInvitePage$lambda$33 = TribeeInvitePage$lambda$3($shareCode$delegate);
                    Intrinsics.checkNotNull(TribeeInvitePage$lambda$33);
                    ShareParams shareParams = new ShareParams("tribee.invite-code.share.0.click", inviteCode, "tribee", String.valueOf(TribeeInvitePage$lambda$33.getTribeeId()), new ShareParams.PageInfo("tribee.invite-code.0.0", null, $fromSpmid == null ? "" : $fromSpmid, MapsKt.mapOf(TuplesKt.to("handler", "tribee_code")), null, 18, null), null, 32, null);
                    InviteItem.CodeItem TribeeInvitePage$lambda$34 = TribeeInvitePage$lambda$3($shareCode$delegate);
                    Intrinsics.checkNotNull(TribeeInvitePage$lambda$34);
                    String tribeeTitle = TribeeInvitePage$lambda$34.getTribeeTitle();
                    InviteItem.CodeItem TribeeInvitePage$lambda$35 = TribeeInvitePage$lambda$3($shareCode$delegate);
                    Intrinsics.checkNotNull(TribeeInvitePage$lambda$35);
                    String tribeeFaceUrl = TribeeInvitePage$lambda$35.getTribeeFaceUrl();
                    InviteItem.CodeItem TribeeInvitePage$lambda$36 = TribeeInvitePage$lambda$3($shareCode$delegate);
                    Intrinsics.checkNotNull(TribeeInvitePage$lambda$36);
                    long tribeeId = TribeeInvitePage$lambda$36.getTribeeId();
                    ComposerKt.sourceInformationMarkerStart($composer, 2068548371, "CC(remember):TribeeInvitePage.kt#9igjgp");
                    Object it$iv2 = $composer.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit TribeeInvitePage$lambda$8$1$0;
                                TribeeInvitePage$lambda$8$1$0 = TribeeInvitePageKt.TribeeInvitePage$lambda$8$1$0($shareCode$delegate);
                                return TribeeInvitePage$lambda$8$1$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeeInviteShareKt.TribeeInviteShare(shareParams, shareConfig, tribeeTitle, tribeeFaceUrl, tribeeId, (Function0) it$iv2, $composer, ShareParams.$stable | 196608, 0);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-299434793);
                    $composer.endReplaceGroup();
                    $shareCode$delegate.setValue(null);
                }
            } else {
                $composer.startReplaceGroup(-305193849);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePage$lambda$8$1$0(MutableState $shareCode$delegate) {
        $shareCode$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0384, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02c1, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeInvitePageContent(final Function1<? super TribeeInviteStateAction, Unit> function1, final Function1<? super TribeeInviteUIAction, Unit> function12, final long fromTribeeId, final TribeeInviteState pageState, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        String str;
        boolean invalid$iv;
        Composer $composer$iv$iv;
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Intrinsics.checkNotNullParameter(function1, "onStateAction");
        Intrinsics.checkNotNullParameter(function12, "onUIAction");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer3 = $composer.startRestartGroup(-1977381886);
        ComposerKt.sourceInformation($composer3, "C(TribeeInvitePageContent)N(onStateAction,onUIAction,fromTribeeId,pageState,modifier)164@6152L7,165@6202L23,167@6264L201,178@6588L6,174@6471L1448:TribeeInvitePage.kt#8mvn07");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(fromTribeeId) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(pageState) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1977381886, $dirty2, -1, "kntr.app.tribee.invite.page.TribeeInvitePageContent (TribeeInvitePage.kt:163)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$TribeeInvitePageContent_u24lambda_u240 = (Density) consume;
            final float headerHeight = $this$TribeeInvitePageContent_u24lambda_u240.toPx-0680j_4(Dp.constructor-impl(65));
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1888435221, "CC(remember):TribeeInvitePage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean TribeeInvitePageContent$lambda$1$0;
                        TribeeInvitePageContent$lambda$1$0 = TribeeInvitePageKt.TribeeInvitePageContent$lambda$1$0(lazyListState, headerHeight);
                        return Boolean.valueOf(TribeeInvitePageContent$lambda$1$0);
                    }
                });
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            State showNavigationTitle = (State) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1300683328, "C187@7043L85,182@6738L401:TribeeInvitePage.kt#8mvn07");
            TribeeInviteState.TribeeInviteContentState tribeeInviteContentState = pageState instanceof TribeeInviteState.TribeeInviteContentState ? (TribeeInviteState.TribeeInviteContentState) pageState : null;
            KTribeeInviteCodeAllResp data = tribeeInviteContentState != null ? tribeeInviteContentState.getData() : null;
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            if (((Boolean) showNavigationTitle.getValue()).booleanValue()) {
                String title = data != null ? data.getTitle() : null;
                if (title != null) {
                    str = title;
                    String ruleText = data == null ? data.getRuleText() : null;
                    String str2 = ruleText != null ? "" : ruleText;
                    String ruleJumpUrl = data == null ? data.getRuleJumpUrl() : null;
                    String str3 = ruleJumpUrl != null ? "" : ruleJumpUrl;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1897716397, "CC(remember):TribeeInvitePage.kt#9igjgp");
                    invalid$iv = ($dirty2 & 112) != 32;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeInvitePageContent$lambda$2$0$0;
                            TribeeInvitePageContent$lambda$2$0$0 = TribeeInvitePageKt.TribeeInvitePageContent$lambda$2$0$0(function12, (String) obj);
                            return TribeeInvitePageContent$lambda$2$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TribeeInviteNavigationRowKt.NavigationRow(modifier5, str, str2, str3, (Function1) it$iv2, $composer3, 6, 0);
                    if (pageState instanceof TribeeInviteState.TribeeInviteInitiateState) {
                        if (pageState instanceof TribeeInviteState.TribeeInviteErrorState) {
                            $composer3.startReplaceGroup(-1299997888);
                            ComposerKt.sourceInformation($composer3, "198@7450L116,198@7396L170");
                            Modifier modifier6 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(48), 0.0f, 0.0f, 13, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1897729452, "CC(remember):TribeeInvitePage.kt#9igjgp");
                            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & 896) == 256);
                            Object it$iv3 = $composer3.rememberedValue();
                            if (invalid$iv2) {
                            }
                            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit TribeeInvitePageContent$lambda$2$1$0;
                                    TribeeInvitePageContent$lambda$2$1$0 = TribeeInvitePageKt.TribeeInvitePageContent$lambda$2$1$0(function1, fromTribeeId);
                                    return TribeeInvitePageContent$lambda$2$1$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                            it$iv3 = value$iv3;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            TribeePageStatusComposeKt.TribeeError(modifier6, false, (Function0) it$iv3, $composer3, 6, 2);
                            $composer3.endReplaceGroup();
                            $composer2 = $composer3;
                            $composer$iv = $composer3;
                            $composer$iv$iv = $composer3;
                            $composer$iv2 = $composer3;
                        } else if (!(pageState instanceof TribeeInviteState.TribeeInviteContentState)) {
                            $composer3.startReplaceGroup(1897720468);
                            $composer3.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        } else {
                            $composer3.startReplaceGroup(-1299716346);
                            ComposerKt.sourceInformation($composer3, "204@7661L228");
                            $composer$iv$iv = $composer3;
                            $composer2 = $composer3;
                            $composer$iv = $composer3;
                            $composer$iv2 = $composer3;
                            TribeeInviteListKt.InviteCodeList(lazyListState, ((TribeeInviteState.TribeeInviteContentState) pageState).getData(), function12, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, (($dirty2 << 3) & 896) | 3072, 0);
                            $composer2.endReplaceGroup();
                        }
                    } else {
                        $composer3.startReplaceGroup(-1300148269);
                        ComposerKt.sourceInformation($composer3, "194@7248L55");
                        TribeePageStatusComposeKt.TribeeLoading(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(48), 0.0f, 0.0f, 13, (Object) null), $composer3, 6, 0);
                        $composer3.endReplaceGroup();
                        $composer2 = $composer3;
                        $composer$iv = $composer3;
                        $composer$iv$iv = $composer3;
                        $composer$iv2 = $composer3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            str = "";
            if (data == null) {
            }
            if (ruleText != null) {
            }
            if (data == null) {
            }
            if (ruleJumpUrl != null) {
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1897716397, "CC(remember):TribeeInvitePage.kt#9igjgp");
            if (($dirty2 & 112) != 32) {
            }
            Object it$iv22 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv22 = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit TribeeInvitePageContent$lambda$2$0$0;
                    TribeeInvitePageContent$lambda$2$0$0 = TribeeInvitePageKt.TribeeInvitePageContent$lambda$2$0$0(function12, (String) obj);
                    return TribeeInvitePageContent$lambda$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv22);
            it$iv22 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TribeeInviteNavigationRowKt.NavigationRow(modifier5, str, str2, str3, (Function1) it$iv22, $composer3, 6, 0);
            if (pageState instanceof TribeeInviteState.TribeeInviteInitiateState) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInvitePageContent$lambda$3;
                    TribeeInvitePageContent$lambda$3 = TribeeInvitePageKt.TribeeInvitePageContent$lambda$3(function1, function12, fromTribeeId, pageState, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInvitePageContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeInvitePageContent$lambda$1$0(LazyListState $lazyListState, float $headerHeight) {
        return $lazyListState.getFirstVisibleItemIndex() > 0 || ((float) $lazyListState.getFirstVisibleItemScrollOffset()) >= $headerHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePageContent$lambda$2$0$0(Function1 $onUIAction, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        $onUIAction.invoke(new TribeeInviteUIAction.RouterTo(url));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitePageContent$lambda$2$1$0(Function1 $onStateAction, long $fromTribeeId) {
        $onStateAction.invoke(new TribeeInviteStateAction.Initiate($fromTribeeId));
        return Unit.INSTANCE;
    }
}