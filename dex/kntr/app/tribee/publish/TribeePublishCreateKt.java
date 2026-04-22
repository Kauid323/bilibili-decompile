package kntr.app.tribee.publish;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.tribee.publish.di.create.TribeePublishCreateComponent;
import kntr.app.tribee.publish.di.create.TribeePublishCreateComponentEntryPoint;
import kntr.app.tribee.publish.internal.DialogsKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeePublishCreate.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"TribeePublishCreate", "", "tribeeIdStr", "", "tribeeName", "modifier", "Landroidx/compose/ui/Modifier;", "resultKey", "fromSpmid", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "showDraftDialog", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishCreateKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishCreate$lambda$2(String str, String str2, Modifier modifier, String str3, String str4, int i, int i2, Composer composer, int i3) {
        TribeePublishCreate(str, str2, modifier, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeePublishCreate(final String tribeeIdStr, final String tribeeName, Modifier modifier, String resultKey, String fromSpmid, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String fromSpmid2;
        final Modifier modifier3;
        String resultKey2;
        String fromSpmid3;
        Intrinsics.checkNotNullParameter(tribeeIdStr, "tribeeIdStr");
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Composer $composer2 = $composer.startRestartGroup(-1481289125);
        ComposerKt.sourceInformation($composer2, "C(TribeePublishCreate)N(tribeeIdStr,tribeeName,modifier,resultKey,fromSpmid)33@1413L24,35@1466L459,47@1941L1788,47@1931L1798:TribeePublishCreate.kt#ufloxe");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(tribeeIdStr) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(tribeeName) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            str = resultKey;
        } else if (($changed & 3072) == 0) {
            str = resultKey;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = resultKey;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            fromSpmid2 = fromSpmid;
        } else if (($changed & 24576) == 0) {
            fromSpmid2 = fromSpmid;
            $dirty |= $composer2.changed(fromSpmid2) ? 16384 : 8192;
        } else {
            fromSpmid2 = fromSpmid;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            resultKey2 = i3 != 0 ? "" : str;
            if (i4 != 0) {
                fromSpmid2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1481289125, $dirty2, -1, "kntr.app.tribee.publish.TribeePublishCreate (TribeePublishCreate.kt:32)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1884662490, "CC(remember):TribeePublishCreate.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                TribeePublishCreateComponent.Factory tribeePublishComponentFactory = ((TribeePublishCreateComponentEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeePublishCreateComponentEntryPoint.class))).tribeePublishComponentFactory();
                Long longOrNull = StringsKt.toLongOrNull(tribeeIdStr);
                Object value$iv = tribeePublishComponentFactory.build(new TribeeInfo(longOrNull != null ? longOrNull.longValue() : 0L, tribeeName), resultKey2 == null ? "" : resultKey2, fromSpmid2 != null ? fromSpmid2 : "", scope).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeePublishViewModel viewModel = (TribeePublishViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1659252755, true, new Function2() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePublishCreate$lambda$1;
                    TribeePublishCreate$lambda$1 = TribeePublishCreateKt.TribeePublishCreate$lambda$1(TribeePublishViewModel.this, modifier3, scope, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePublishCreate$lambda$1;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            fromSpmid3 = fromSpmid2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            resultKey2 = str;
            fromSpmid3 = fromSpmid2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str2 = resultKey2;
            final String str3 = fromSpmid3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePublishCreate$lambda$2;
                    TribeePublishCreate$lambda$2 = TribeePublishCreateKt.TribeePublishCreate$lambda$2(tribeeIdStr, tribeeName, modifier4, str2, str3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePublishCreate$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a7, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01eb, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0223, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x025d, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeePublishCreate$lambda$1(final TribeePublishViewModel $viewModel, Modifier $modifier, final CoroutineScope $scope, Composer $composer, int $changed) {
        final MutableState showDraftDialog$delegate;
        ComposerKt.sourceInformation($composer, "C48@1998L7,49@2025L28,50@2084L13,51@2106L94,55@2233L54,58@2324L16,60@2384L216,78@2969L19,75@2860L84,69@2689L44,72@2759L59,67@2609L437:TribeePublishCreate.kt#ufloxe");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1659252755, $changed, -1, "kntr.app.tribee.publish.TribeePublishCreate.<anonymous> (TribeePublishCreate.kt:48)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, LocalOnBackPressedDispatcher.$stable);
            SystemUiController trio = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            ThemeDayNight theme = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer, -824530859, "CC(ConfigWindow)N(block)27@1008L7:ImeHelper.android.kt#ufloxe");
            CompositionLocal this_$iv$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Activity activity$iv = ContextUtilKt.findActivityOrNull((Context) consume);
            if (Build.VERSION.SDK_INT >= 30 || activity$iv == null) {
                $composer.startReplaceGroup(-680320234);
                ComposerKt.sourceInformation($composer, "36@1474L7");
                boolean z = false & true;
                ComposerKt.sourceInformationMarkerStart($composer, 1761858710, "C:TribeePublishCreate.kt#ufloxe");
                trio.setStatusBar(theme == ThemeDayNight.Day);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-680672859);
                ComposerKt.sourceInformation($composer, "29@1132L13,30@1201L251,30@1177L275");
                boolean isNight$iv = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
                Boolean valueOf = Boolean.valueOf(isNight$iv);
                ComposerKt.sourceInformationMarkerStart($composer, -2100163984, "CC(remember):ImeHelper.android.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changedInstance(activity$iv) | $composer.changed(isNight$iv);
                Object it$iv$iv = $composer.rememberedValue();
                if (!invalid$iv$iv && it$iv$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv$iv, $composer, 0);
                    $composer.endReplaceGroup();
                }
                Object value$iv$iv = (Function2) new ImeHelper_androidKt$ConfigWindow$1$1(activity$iv, isNight$iv, null);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv$iv, $composer, 0);
                $composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1109040137, "CC(remember):TribeePublishCreate.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState showDraftDialog$delegate2 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            final TribeePublishState state = (TribeePublishState) SnapshotStateKt.collectAsState($viewModel.getState(), (CoroutineContext) null, $composer, 0, 1).getValue();
            ComposerKt.sourceInformationMarkerStart($composer, 1109045131, "CC(remember):TribeePublishCreate.kt#9igjgp");
            boolean invalid$iv = $composer.changed(state);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TribeePublishCreate$lambda$1$4$0;
                        TribeePublishCreate$lambda$1$4$0 = TribeePublishCreateKt.TribeePublishCreate$lambda$1$4$0(TribeePublishState.this, showDraftDialog$delegate2);
                        return TribeePublishCreate$lambda$1$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Function0 checkDraft = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1109063654, "CC(remember):TribeePublishCreate.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($viewModel);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = (KFunction) new TribeePublishCreateKt$TribeePublishCreate$1$2$1($viewModel);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function2 function2 = (KFunction) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1109060231, "CC(remember):TribeePublishCreate.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(state);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean TribeePublishCreate$lambda$1$6$0;
                    TribeePublishCreate$lambda$1$6$0 = TribeePublishCreateKt.TribeePublishCreate$lambda$1$6$0(TribeePublishState.this);
                    return Boolean.valueOf(TribeePublishCreate$lambda$1$6$0);
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            Function0 function0 = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1109054719, "CC(remember):TribeePublishCreate.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed(checkDraft);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit TribeePublishCreate$lambda$1$7$0;
                    TribeePublishCreate$lambda$1$7$0 = TribeePublishCreateKt.TribeePublishCreate$lambda$1$7$0(checkDraft);
                    return TribeePublishCreate$lambda$1$7$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            Function0 function02 = (Function0) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1109056974, "CC(remember):TribeePublishCreate.kt#9igjgp");
            boolean invalid$iv5 = $composer.changedInstance(backHandler);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv6 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit TribeePublishCreate$lambda$1$8$0;
                    TribeePublishCreate$lambda$1$8$0 = TribeePublishCreateKt.TribeePublishCreate$lambda$1$8$0(backHandler);
                    return TribeePublishCreate$lambda$1$8$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeePublishPageKt.TribeePublishPage(state, function0, function02, (Function0) it$iv6, function2, fillMaxSize$default, $composer, 0, 0);
            if (TribeePublishCreate$lambda$1$2(showDraftDialog$delegate2)) {
                $composer.startReplaceGroup(21361481);
                ComposerKt.sourceInformation($composer, "84@3132L268,91@3429L269,83@3091L622");
                ComposerKt.sourceInformationMarkerStart($composer, 1109069119, "CC(remember):TribeePublishCreate.kt#9igjgp");
                boolean invalid$iv6 = $composer.changedInstance($scope) | $composer.changedInstance($viewModel);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                    showDraftDialog$delegate = showDraftDialog$delegate2;
                    Object value$iv7 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit TribeePublishCreate$lambda$1$9$0;
                            TribeePublishCreate$lambda$1$9$0 = TribeePublishCreateKt.TribeePublishCreate$lambda$1$9$0($scope, $viewModel, showDraftDialog$delegate);
                            return TribeePublishCreate$lambda$1$9$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                } else {
                    showDraftDialog$delegate = showDraftDialog$delegate2;
                }
                Function0 function03 = (Function0) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1109078624, "CC(remember):TribeePublishCreate.kt#9igjgp");
                boolean invalid$iv7 = $composer.changedInstance($scope) | $composer.changedInstance($viewModel);
                Object it$iv8 = $composer.rememberedValue();
                if (invalid$iv7 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishCreateKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit TribeePublishCreate$lambda$1$10$0;
                            TribeePublishCreate$lambda$1$10$0 = TribeePublishCreateKt.TribeePublishCreate$lambda$1$10$0($scope, $viewModel, showDraftDialog$delegate);
                            return TribeePublishCreate$lambda$1$10$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                DialogsKt.DraftDialog(function03, (Function0) it$iv8, null, $composer, 0, 4);
            } else {
                $composer.startReplaceGroup(18288079);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean TribeePublishCreate$lambda$1$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeePublishCreate$lambda$1$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishCreate$lambda$1$4$0(TribeePublishState $state, MutableState $showDraftDialog$delegate) {
        TribeePublishContent publishContent = $state.getPublishContent();
        boolean z = false;
        if (publishContent != null && publishContent.getReadyForSaveDraft()) {
            z = true;
        }
        if (z) {
            TribeePublishCreate$lambda$1$3($showDraftDialog$delegate, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishCreate$lambda$1$7$0(Function0 $checkDraft) {
        $checkDraft.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishCreate$lambda$1$8$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeePublishCreate$lambda$1$6$0(TribeePublishState $state) {
        TribeePublishContent publishContent = $state.getPublishContent();
        return publishContent != null && publishContent.getReadyForSaveDraft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishCreate$lambda$1$9$0(CoroutineScope $scope, TribeePublishViewModel $viewModel, MutableState $showDraftDialog$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishCreateKt$TribeePublishCreate$1$6$1$1($viewModel, $showDraftDialog$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishCreate$lambda$1$10$0(CoroutineScope $scope, TribeePublishViewModel $viewModel, MutableState $showDraftDialog$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishCreateKt$TribeePublishCreate$1$7$1$1($viewModel, $showDraftDialog$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}