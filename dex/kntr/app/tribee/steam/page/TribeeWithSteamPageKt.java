package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
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
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.TribeeDetailComposeKt;
import kntr.app.tribee.consume.page.TribeeDialogKt;
import kntr.app.tribee.consume.page.TribeePageStatusComposeKt;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheetKt;
import kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt;
import kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt;
import kntr.app.tribee.steam.page.share.TribeeSteamShareKt;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.tribee.steam.viewmodel.TribeeSteamEntryPoint;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeWithSteamPage.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u008a\u008e\u0002²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u008a\u008e\u0002²\u0006\f\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u008a\u008e\u0002"}, d2 = {"TribeeWithSteamPage", "", "fromSpmid", "", "hostId", "tribeeId", "selectedGameId", "signature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "handleStateAction", "action", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "viewModel", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamViewModel;", "isEnableShowShare", "", "consume_debug", "pageState", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "toasterDialog", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "showGameListBottomSheet", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameListBottomSheet;", "showGameAchievementBottomSheet", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "threeDot", "Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeWithSteamPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$19(String str, String str2, String str3, String str4, String str5, int i, int i2, Composer composer, int i3) {
        TribeeWithSteamPage(str, str2, str3, str4, str5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x035c, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03a1, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x044a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeWithSteamPage(String fromSpmid, String hostId, String tribeeId, String selectedGameId, String signature, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        String tribeeId2;
        String selectedGameId2;
        String signature2;
        int $dirty;
        String fromSpmid2;
        String hostId2;
        String tribeeId3;
        Long longOrNull;
        Composer $composer2 = $composer.startRestartGroup(-66188951);
        ComposerKt.sourceInformation($composer2, "C(TribeeWithSteamPage)N(fromSpmid,hostId,tribeeId,selectedGameId,signature)75@3387L24,76@3442L24,78@3517L538,92@4087L7,93@4124L7,95@4153L37,96@4216L97,96@4195L118,102@4352L16,103@4394L48,104@4478L79,105@4600L67,106@4688L45,108@4787L1058,142@5913L501,157@6441L103,157@6420L124,163@6560L6027,163@6550L6037:TribeeWithSteamPage.kt#k3l5ii");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            str = fromSpmid;
        } else if (($changed & 6) == 0) {
            str = fromSpmid;
            $dirty2 |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = fromSpmid;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            str2 = hostId;
        } else if (($changed & 48) == 0) {
            str2 = hostId;
            $dirty2 |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = hostId;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            tribeeId2 = tribeeId;
        } else if (($changed & 384) == 0) {
            tribeeId2 = tribeeId;
            $dirty2 |= $composer2.changed(tribeeId2) ? 256 : 128;
        } else {
            tribeeId2 = tribeeId;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            selectedGameId2 = selectedGameId;
        } else if (($changed & 3072) == 0) {
            selectedGameId2 = selectedGameId;
            $dirty2 |= $composer2.changed(selectedGameId2) ? 2048 : 1024;
        } else {
            selectedGameId2 = selectedGameId;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            signature2 = signature;
        } else if (($changed & 24576) == 0) {
            signature2 = signature;
            $dirty2 |= $composer2.changed(signature2) ? 16384 : 8192;
        } else {
            signature2 = signature;
        }
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            String fromSpmid3 = i2 != 0 ? null : str;
            String hostId3 = i3 != 0 ? null : str2;
            if (i4 != 0) {
                tribeeId2 = null;
            }
            if (i5 != 0) {
                selectedGameId2 = null;
            }
            if (i6 != 0) {
                signature2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-66188951, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeWithSteamPage (TribeeWithSteamPage.kt:74)");
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
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv$iv2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv2);
                it$iv$iv2 = value$iv$iv2;
            }
            CoroutineScope shareCoroutineScope = (CoroutineScope) it$iv$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 816947395, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((TribeeSteamEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeeSteamEntryPoint.class))).getTribeeSteamComponentFactory().build(scope, shareCoroutineScope, (hostId3 == null || (longOrNull = StringsKt.toLongOrNull(hostId3)) == null) ? 0L : longOrNull.longValue(), selectedGameId2, fromSpmid3, tribeeId2, signature2).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeeSteamViewModel viewModel = (TribeeSteamViewModel) it$iv;
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
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger(SteamTrackerKt.STEAM_PAGE_PV, $composer2, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 816969322, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            $dirty = $dirty2;
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changedInstance(pvTrigger);
            hostId2 = hostId3;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeeWithSteamPageKt$TribeeWithSteamPage$1$1(pvTrigger, fromSpmid3, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            final State pageState$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, 816974969, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            fromSpmid2 = fromSpmid3;
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState toasterDialog$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 816977688, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState showGameListBottomSheet$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 816981580, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final MutableState showGameAchievementBottomSheet$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 816984374, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                tribeeId3 = tribeeId2;
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            } else {
                tribeeId3 = tribeeId2;
            }
            final MutableState threeDot$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 816988555, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(toaster) | $composer2.changedInstance(router);
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv7 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit TribeeWithSteamPage$lambda$15$0;
                    TribeeWithSteamPage$lambda$15$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$15$0(Toaster.this, router, toasterDialog$delegate, threeDot$delegate, showGameListBottomSheet$delegate, showGameAchievementBottomSheet$delegate, (TribeeSteamUIAction) obj);
                    return TribeeWithSteamPage$lambda$15$0;
                }
            };
            $composer2.updateRememberedValue(value$iv7);
            it$iv7 = value$iv7;
            final Function1 onUIAction = (Function1) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 817024030, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(viewModel);
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv8 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit TribeeWithSteamPage$lambda$16$0;
                    TribeeWithSteamPage$lambda$16$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$16$0(onUIAction, viewModel, toasterDialog$delegate, threeDot$delegate, showGameListBottomSheet$delegate, showGameAchievementBottomSheet$delegate, (TribeeSteamStateAction) obj);
                    return TribeeWithSteamPage$lambda$16$0;
                }
            };
            $composer2.updateRememberedValue(value$iv8);
            it$iv8 = value$iv8;
            final Function1 onStateAction = (Function1) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 817040528, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changedInstance(viewModel) | $composer2.changed(onUIAction);
            Object it$iv9 = $composer2.rememberedValue();
            if (!invalid$iv4 && it$iv9 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit2, (Function2) it$iv9, $composer2, 6);
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1493638479, true, new Function2() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TribeeWithSteamPage$lambda$18;
                        TribeeWithSteamPage$lambda$18 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18(onStateAction, onUIAction, pageState$delegate, toasterDialog$delegate, threeDot$delegate, showGameListBottomSheet$delegate, showGameAchievementBottomSheet$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return TribeeWithSteamPage$lambda$18;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                tribeeId2 = tribeeId3;
            }
            Object value$iv9 = (Function2) new TribeeWithSteamPageKt$TribeeWithSteamPage$2$1(viewModel, onUIAction, null);
            $composer2.updateRememberedValue(value$iv9);
            it$iv9 = value$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv9, $composer2, 6);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1493638479, true, new Function2() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeWithSteamPage$lambda$18;
                    TribeeWithSteamPage$lambda$18 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18(onStateAction, onUIAction, pageState$delegate, toasterDialog$delegate, threeDot$delegate, showGameListBottomSheet$delegate, showGameAchievementBottomSheet$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeWithSteamPage$lambda$18;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
            }
            tribeeId2 = tribeeId3;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            fromSpmid2 = str;
            hostId2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str3 = fromSpmid2;
            final String str4 = hostId2;
            final String str5 = tribeeId2;
            final String str6 = selectedGameId2;
            final String str7 = signature2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeWithSteamPage$lambda$19;
                    TribeeWithSteamPage$lambda$19 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$19(str3, str4, str5, str6, str7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeWithSteamPage$lambda$19;
                }
            });
        }
    }

    private static final TribeeSteamState TribeeWithSteamPage$lambda$2(State<? extends TribeeSteamState> state) {
        Object thisObj$iv = state.getValue();
        return (TribeeSteamState) thisObj$iv;
    }

    private static final KToastDialog TribeeWithSteamPage$lambda$4(MutableState<KToastDialog> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KToastDialog) $this$getValue$iv.getValue();
    }

    private static final TribeeSteamUIAction.ShowGameListBottomSheet TribeeWithSteamPage$lambda$7(MutableState<TribeeSteamUIAction.ShowGameListBottomSheet> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TribeeSteamUIAction.ShowGameListBottomSheet) $this$getValue$iv.getValue();
    }

    private static final KTribeeSteamHomeAchievementItem TribeeWithSteamPage$lambda$10(MutableState<KTribeeSteamHomeAchievementItem> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KTribeeSteamHomeAchievementItem) $this$getValue$iv.getValue();
    }

    private static final KThreeDot TribeeWithSteamPage$lambda$13(MutableState<KThreeDot> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KThreeDot) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$15$0(Toaster $toaster, Router $router, MutableState $toasterDialog$delegate, MutableState $threeDot$delegate, MutableState $showGameListBottomSheet$delegate, MutableState $showGameAchievementBottomSheet$delegate, TribeeSteamUIAction uiAction) {
        String it;
        Intrinsics.checkNotNullParameter(uiAction, "uiAction");
        if (uiAction instanceof TribeeSteamUIAction.ToastTips) {
            TribeeToast tribeeToast = ((TribeeSteamUIAction.ToastTips) uiAction).getTribeeToast();
            if (tribeeToast != null && (it = tribeeToast.getContent()) != null) {
                Toaster.CC.showToast$default($toaster, it, null, 2, null);
            }
            String it2 = ((TribeeSteamUIAction.ToastTips) uiAction).getToastType();
            if (it2 != null) {
                SteamTrackerKt.toastDialogExposure(it2);
            }
        } else if (uiAction instanceof TribeeSteamUIAction.RouterTo) {
            Uri it3 = TribeeExtensionsKt.toUriOrNull(((TribeeSteamUIAction.RouterTo) uiAction).getUrl());
            if (it3 != null) {
                $router.launch(it3);
            }
        } else if (uiAction instanceof TribeeSteamUIAction.ToastDialog) {
            if (TribeeWithSteamPage$lambda$4($toasterDialog$delegate) != null) {
                $toasterDialog$delegate.setValue(null);
            }
            $toasterDialog$delegate.setValue(((TribeeSteamUIAction.ToastDialog) uiAction).getDialog());
        } else if (uiAction instanceof TribeeSteamUIAction.ClickMenu) {
            SteamTrackerKt.reportSteamPageClick("more");
            $threeDot$delegate.setValue(((TribeeSteamUIAction.ClickMenu) uiAction).getThreeDot());
        } else if (!(uiAction instanceof TribeeSteamUIAction.ShowGameListBottomSheet)) {
            if (!(uiAction instanceof TribeeSteamUIAction.ShowGameAchievementBottomSheet)) {
                throw new NoWhenBranchMatchedException();
            }
            $showGameAchievementBottomSheet$delegate.setValue(((TribeeSteamUIAction.ShowGameAchievementBottomSheet) uiAction).getAchievement());
        } else {
            $showGameListBottomSheet$delegate.setValue((TribeeSteamUIAction.ShowGameListBottomSheet) uiAction);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$16$0(Function1 $onUIAction, TribeeSteamViewModel $viewModel, MutableState $toasterDialog$delegate, MutableState $threeDot$delegate, MutableState $showGameListBottomSheet$delegate, MutableState $showGameAchievementBottomSheet$delegate, TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        handleStateAction(it, $onUIAction, $viewModel, TribeeWithSteamPage$lambda$4($toasterDialog$delegate) == null && TribeeWithSteamPage$lambda$13($threeDot$delegate) == null && TribeeWithSteamPage$lambda$7($showGameListBottomSheet$delegate) == null && TribeeWithSteamPage$lambda$10($showGameAchievementBottomSheet$delegate) == null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0351, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v39 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeWithSteamPage$lambda$18(final Function1 $onStateAction, Function1 $onUIAction, State $pageState$delegate, final MutableState $toasterDialog$delegate, final MutableState $threeDot$delegate, final MutableState $showGameListBottomSheet$delegate, final MutableState $showGameAchievementBottomSheet$delegate, Composer $composer, int $changed) {
        Composer composer;
        String str;
        String str2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C164@6589L28,165@6650L13,166@6719L64,166@6695L88,320@12398L183:TribeeWithSteamPage.kt#k3l5ii");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493638479, $changed, -1, "kntr.app.tribee.steam.page.TribeeWithSteamPage.<anonymous> (TribeeWithSteamPage.kt:164)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -867496303, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(uiController) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeWithSteamPageKt$TribeeWithSteamPage$3$1$1(uiController, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            TribeeSteamState page = TribeeWithSteamPage$lambda$2($pageState$delegate);
            if (page instanceof TribeeSteamState.InitialState) {
                $composer.startReplaceGroup(-1122418710);
                ComposerKt.sourceInformation($composer, "177@7088L6,173@6918L394");
                Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
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
                int i2 = ((0 >> 6) & 112) | 6;
                BoxScope $this$TribeeWithSteamPage_u24lambda_u2418_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1026503120, "C180@7194L21,181@7236L58:TribeeWithSteamPage.kt#k3l5ii");
                TribeeDetailComposeKt.SimpleNavigationRow(null, $composer, 0, 1);
                TribeePageStatusComposeKt.TribeeLoading($this$TribeeWithSteamPage_u24lambda_u2418_u241.align(Modifier.Companion, Alignment.Companion.getCenter()), $composer, 0, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                str = "CC(remember):TribeeWithSteamPage.kt#9igjgp";
                composer = $composer;
                str2 = "";
            } else if (page instanceof TribeeSteamState.InitialErrorState) {
                $composer.startReplaceGroup(-1121909907);
                ComposerKt.sourceInformation($composer, "191@7598L6,187@7428L487");
                Modifier modifier$iv2 = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i4 = ((0 >> 6) & 112) | 6;
                BoxScope $this$TribeeWithSteamPage_u24lambda_u2418_u242 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -1553341174, "C194@7704L21,195@7803L94,195@7746L151:TribeeWithSteamPage.kt#k3l5ii");
                TribeeDetailComposeKt.SimpleNavigationRow(null, $composer, 0, 1);
                Modifier align = $this$TribeeWithSteamPage_u24lambda_u2418_u242.align(Modifier.Companion, Alignment.Companion.getCenter());
                ComposerKt.sourceInformationMarkerStart($composer, 919726614, "CC(remember):TribeeWithSteamPage.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($onStateAction);
                Object value$iv2 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit TribeeWithSteamPage$lambda$18$2$0$0;
                        TribeeWithSteamPage$lambda$18$2$0$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$2$0$0($onStateAction);
                        return TribeeWithSteamPage$lambda$18$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeePageStatusComposeKt.TribeeError(align, false, value$iv2, $composer, 0, 2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                str = "CC(remember):TribeeWithSteamPage.kt#9igjgp";
                composer = $composer;
                str2 = "";
            } else if (page instanceof TribeeSteamState.UnbindSteamState) {
                $composer.startReplaceGroup(-1121322364);
                ComposerKt.sourceInformation($composer, "203@8030L176");
                TribeeSteamUnboundKt.TribeeSteamUnboundPage(null, TribeeWithSteamPage$lambda$2($pageState$delegate), $onStateAction, $onUIAction, $composer, 0, 1);
                $composer.endReplaceGroup();
                str = "CC(remember):TribeeWithSteamPage.kt#9igjgp";
                composer = $composer;
                str2 = "";
            } else if (page instanceof TribeeSteamState.HasBoundAndSyncingState) {
                $composer.startReplaceGroup(-1120996337);
                ComposerKt.sourceInformation($composer, "211@8299L642");
                KTribeeSteamHomeUserInfo userInfo = ((TribeeSteamState.HasBoundAndSyncingState) page).getData().getUserInfo();
                KThreeDot threeDot = ((TribeeSteamState.HasBoundAndSyncingState) page).getData().getThreeDot();
                KTribeeSteamHomeAchievement steamAchievement = ((TribeeSteamState.HasBoundAndSyncingState) page).getData().getSteamAchievement();
                String titlePicUrl = steamAchievement != null ? steamAchievement.getTitlePicUrl() : null;
                String str3 = titlePicUrl == null ? "" : titlePicUrl;
                KTribeeSteamHomeAchievement steamAchievement2 = ((TribeeSteamState.HasBoundAndSyncingState) page).getData().getSteamAchievement();
                String title = steamAchievement2 != null ? steamAchievement2.getTitle() : null;
                TribeeSteamEmptyDataContentKt.TribeeSteamEmptyDataContent(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ((TribeeSteamState.HasBoundAndSyncingState) page).getData().getSyncTips(), userInfo, threeDot, str3, title == null ? "" : title, $onUIAction, $composer, 6, 0);
                $composer.endReplaceGroup();
                composer = $composer;
                str = "CC(remember):TribeeWithSteamPage.kt#9igjgp";
                str2 = "";
            } else if (page instanceof TribeeSteamState.HasBoundButPrivacyState) {
                $composer.startReplaceGroup(-1120280578);
                ComposerKt.sourceInformation($composer, "229@9034L211");
                composer = $composer;
                str = "CC(remember):TribeeWithSteamPage.kt#9igjgp";
                str2 = "";
                TribeeSteamPrivacyPageKt.TribeeSteamPrivacyPage((TribeeSteamState.HasBoundButPrivacyState) page, Modifier.Companion, $onStateAction, $onUIAction, $composer, 48, 0);
                $composer.endReplaceGroup();
            } else {
                composer = $composer;
                str = "CC(remember):TribeeWithSteamPage.kt#9igjgp";
                str2 = "";
                if (page instanceof TribeeSteamState.HasBoundButDataFetchFailedState) {
                    composer.startReplaceGroup(-1119987690);
                    ComposerKt.sourceInformation(composer, "238@9346L219");
                    TribeeSteamSyncFailedKt.TribeeSteamSyncFailedPage(Modifier.Companion, ((TribeeSteamState.HasBoundButDataFetchFailedState) page).getData(), $onUIAction, $onStateAction, $composer, 6, 0);
                    $composer.endReplaceGroup();
                } else if (!(page instanceof TribeeSteamState.SteamInfoState)) {
                    composer.startReplaceGroup(-867490866);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                } else {
                    composer.startReplaceGroup(-1119686060);
                    ComposerKt.sourceInformation(composer, "248@9679L223");
                    TribeeSteamHasBoundKt.TribeeSteamInfoPage((TribeeSteamState.SteamInfoState) page, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $onUIAction, $onStateAction, $composer, 48, 0);
                    $composer.endReplaceGroup();
                }
            }
            if (TribeeWithSteamPage$lambda$4($toasterDialog$delegate) != null) {
                composer.startReplaceGroup(-1119305287);
                ComposerKt.sourceInformation(composer, "274@10780L588,260@10072L668,287@11398L60,258@9977L1496");
                KToastDialog TribeeWithSteamPage$lambda$4 = TribeeWithSteamPage$lambda$4($toasterDialog$delegate);
                Intrinsics.checkNotNull(TribeeWithSteamPage$lambda$4);
                ComposerKt.sourceInformationMarkerStart(composer, -867365827, str);
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit TribeeWithSteamPage$lambda$18$3$0;
                            TribeeWithSteamPage$lambda$18$3$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$3$0((KToastDialog.KToastDialogType) obj);
                            return TribeeWithSteamPage$lambda$18$3$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                }
                Function1 function1 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart(composer, -867388403, str);
                boolean invalid$iv3 = composer.changed($onStateAction);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function2() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeWithSteamPage$lambda$18$4$0;
                            TribeeWithSteamPage$lambda$18$4$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$4$0($onStateAction, (KToastDialog.KToastDialogType) obj, (String) obj2);
                            return TribeeWithSteamPage$lambda$18$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                }
                Function2 function2 = (Function2) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart(composer, -867346579, str);
                Object it$iv4 = $composer.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit TribeeWithSteamPage$lambda$18$5$0;
                            TribeeWithSteamPage$lambda$18$5$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$5$0($toasterDialog$delegate);
                            return TribeeWithSteamPage$lambda$18$5$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeDialogKt.TribeeDialog(TribeeWithSteamPage$lambda$4, function1, function2, (Function0) it$iv4, $composer, 3120, 0);
            } else {
                composer.startReplaceGroup(-1129249839);
            }
            $composer.endReplaceGroup();
            if (TribeeWithSteamPage$lambda$13($threeDot$delegate) != null) {
                composer.startReplaceGroup(-867341832);
                ComposerKt.sourceInformation(composer, str2);
                KThreeDot threeDotList = TribeeWithSteamPage$lambda$13($threeDot$delegate);
                if (threeDotList == null) {
                    composer.startReplaceGroup(-1117793015);
                    $composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1117793014);
                    ComposerKt.sourceInformation(composer, "*298@11738L63,295@11577L243");
                    ComposerKt.sourceInformationMarkerStart(composer, 1797945491, str);
                    Object it$iv5 = $composer.rememberedValue();
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit TribeeWithSteamPage$lambda$18$6$0$0;
                                TribeeWithSteamPage$lambda$18$6$0$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$6$0$0($threeDot$delegate);
                                return TribeeWithSteamPage$lambda$18$6$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv6);
                        it$iv5 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeeSteamThreeDotBottomSheetKt.TribeeSteamThreeDotBottomSheet((Function0) it$iv5, threeDotList, $onUIAction, null, $composer, 6, 8);
                    Unit unit = Unit.INSTANCE;
                    $composer.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
            } else {
                composer.startReplaceGroup(-1129249839);
            }
            $composer.endReplaceGroup();
            if (TribeeWithSteamPage$lambda$7($showGameListBottomSheet$delegate) != null) {
                composer.startReplaceGroup(-1117445783);
                ComposerKt.sourceInformation(composer, "308@12017L34,306@11905L208");
                TribeeSteamUIAction.ShowGameListBottomSheet TribeeWithSteamPage$lambda$7 = TribeeWithSteamPage$lambda$7($showGameListBottomSheet$delegate);
                Intrinsics.checkNotNull(TribeeWithSteamPage$lambda$7);
                ComposerKt.sourceInformationMarkerStart(composer, -867326797, str);
                Object it$iv6 = $composer.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit TribeeWithSteamPage$lambda$18$7$0;
                            TribeeWithSteamPage$lambda$18$7$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$7$0($showGameListBottomSheet$delegate);
                            return TribeeWithSteamPage$lambda$18$7$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                    it$iv6 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet(TribeeWithSteamPage$lambda$7, null, (Function0) it$iv6, $onStateAction, $composer, 384, 2);
            } else {
                composer.startReplaceGroup(-1129249839);
            }
            $composer.endReplaceGroup();
            if (TribeeWithSteamPage$lambda$10($showGameAchievementBottomSheet$delegate) != null) {
                composer.startReplaceGroup(-1117162722);
                ComposerKt.sourceInformation(composer, "316@12322L41,314@12191L187");
                KTribeeSteamHomeAchievementItem TribeeWithSteamPage$lambda$10 = TribeeWithSteamPage$lambda$10($showGameAchievementBottomSheet$delegate);
                Intrinsics.checkNotNull(TribeeWithSteamPage$lambda$10);
                ComposerKt.sourceInformationMarkerStart(composer, -867317030, str);
                Object it$iv7 = $composer.rememberedValue();
                if (it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeWithSteamPageKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit TribeeWithSteamPage$lambda$18$8$0;
                            TribeeWithSteamPage$lambda$18$8$0 = TribeeWithSteamPageKt.TribeeWithSteamPage$lambda$18$8$0($showGameAchievementBottomSheet$delegate);
                            return TribeeWithSteamPage$lambda$18$8$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                    it$iv7 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeSteamGameAchievementBottomSheetKt.TribeeSteamGameAchievementBottomSheet(TribeeWithSteamPage$lambda$10, null, (Function0) it$iv7, $composer, 384, 2);
            } else {
                composer.startReplaceGroup(-1129249839);
            }
            $composer.endReplaceGroup();
            TribeeSteamState TribeeWithSteamPage$lambda$2 = TribeeWithSteamPage$lambda$2($pageState$delegate);
            TribeeSteamShareKt.TribeeSteamShare(TribeeWithSteamPage$lambda$2 instanceof TribeeSteamState.SteamInfoState ? (TribeeSteamState.SteamInfoState) TribeeWithSteamPage$lambda$2 : null, null, $onUIAction, $onStateAction, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$2$0$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeSteamStateAction.Initiate.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$4$0(Function1 $onStateAction, KToastDialog.KToastDialogType type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type instanceof KToastDialog.KToastDialogType.STEAM_ACCOUNT_RELEASE) {
            SteamTrackerKt.reportSteamPagePopupClick("unbound", "sure");
            $onStateAction.invoke(TribeeSteamStateAction.UnbindSteamAccount.INSTANCE);
        } else if (type instanceof KToastDialog.KToastDialogType.GAME_STATS_NO_TRIBEE) {
            SteamTrackerKt.reportSteamPagePopupClick("not_join", "sure");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$3$0(KToastDialog.KToastDialogType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type instanceof KToastDialog.KToastDialogType.STEAM_ACCOUNT_RELEASE) {
            SteamTrackerKt.reportSteamPagePopupClick("unbound", "cancel");
        } else if (type instanceof KToastDialog.KToastDialogType.GAME_STATS_NO_TRIBEE) {
            SteamTrackerKt.reportSteamPagePopupClick("not_join", "cancel");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$5$0(MutableState $toasterDialog$delegate) {
        $toasterDialog$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$6$0$0(MutableState $threeDot$delegate) {
        $threeDot$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$7$0(MutableState $showGameListBottomSheet$delegate) {
        $showGameListBottomSheet$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeWithSteamPage$lambda$18$8$0(MutableState $showGameAchievementBottomSheet$delegate) {
        $showGameAchievementBottomSheet$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void handleStateAction$default(TribeeSteamStateAction tribeeSteamStateAction, Function1 function1, TribeeSteamViewModel tribeeSteamViewModel, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        handleStateAction(tribeeSteamStateAction, function1, tribeeSteamViewModel, z);
    }

    private static final void handleStateAction(TribeeSteamStateAction action, Function1<? super TribeeSteamUIAction, Unit> function1, TribeeSteamViewModel viewModel, boolean isEnableShowShare) {
        if (action instanceof TribeeSteamStateAction.GoToSteamBind) {
            if (((TribeeSteamStateAction.GoToSteamBind) action).getBindTribeeDialog() != null) {
                function1.invoke(new TribeeSteamUIAction.ToastDialog(((TribeeSteamStateAction.GoToSteamBind) action).getBindTribeeDialog()));
                return;
            }
            String url = ((TribeeSteamStateAction.GoToSteamBind) action).getSteamBindUrl();
            if (StringsKt.isBlank(url)) {
                url = null;
            }
            if (url != null) {
                function1.invoke(new TribeeSteamUIAction.RouterTo(url));
                viewModel.dispatch(TribeeSteamStateAction.AwaitSteamBindResult.INSTANCE);
            }
        } else if (action instanceof TribeeSteamStateAction.StartShare) {
            if (isEnableShowShare) {
                SteamTrackerKt.reportSteamPageClick("share");
                viewModel.dispatch(action);
            }
        } else {
            viewModel.dispatch(action);
        }
    }
}