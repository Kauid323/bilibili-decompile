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
import kntr.app.tribee.base.TribeeEditContent;
import kntr.app.tribee.publish.di.edit.TribeePublishEditComponent;
import kntr.app.tribee.publish.di.edit.TribeePublishEditComponentEntryPoint;
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

/* compiled from: TribeePublishEdit.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t\u001a7\u0010\n\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002"}, d2 = {"TribeePublishEdit", "", "id", "", "tribeeIdStr", "tribeeName", "modifier", "Landroidx/compose/ui/Modifier;", "fromSpmid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "PreviewTribeePublishEdit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "showConfirm", "", "initState", "Lkntr/app/tribee/base/TribeeEditContent;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishEditKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTribeePublishEdit$lambda$4(String str, String str2, String str3, String str4, int i, int i2, Composer composer, int i3) {
        PreviewTribeePublishEdit(str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishEdit$lambda$2(String str, String str2, String str3, Modifier modifier, String str4, int i, int i2, Composer composer, int i3) {
        TribeePublishEdit(str, str2, str3, modifier, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeePublishEdit(final String id, final String tribeeIdStr, final String tribeeName, Modifier modifier, String fromSpmid, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        final Modifier modifier3;
        String fromSpmid2;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tribeeIdStr, "tribeeIdStr");
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Composer $composer2 = $composer.startRestartGroup(1761961127);
        ComposerKt.sourceInformation($composer2, "C(TribeePublishEdit)N(id,tribeeIdStr,tribeeName,modifier,fromSpmid)40@1787L24,42@1840L437,54@2293L1140,54@2283L1150:TribeePublishEdit.kt#ufloxe");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(id) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(tribeeIdStr) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(tribeeName) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            str = fromSpmid;
        } else if (($changed & 24576) == 0) {
            str = fromSpmid;
            $dirty |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = fromSpmid;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            fromSpmid2 = i3 != 0 ? null : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1761961127, $dirty2, -1, "kntr.app.tribee.publish.TribeePublishEdit (TribeePublishEdit.kt:39)");
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1027539580, "CC(remember):TribeePublishEdit.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                TribeePublishEditComponent.Factory tribeeEditComponentFactory = ((TribeePublishEditComponentEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeePublishEditComponentEntryPoint.class))).tribeeEditComponentFactory();
                Long longOrNull = StringsKt.toLongOrNull(tribeeIdStr);
                Object value$iv = tribeeEditComponentFactory.build(new TribeeInfo(longOrNull != null ? longOrNull.longValue() : 0L, tribeeName), id, fromSpmid2 == null ? "" : fromSpmid2, scope).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeePublishViewModel viewModel = (TribeePublishViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1963336097, true, new Function2() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePublishEdit$lambda$1;
                    TribeePublishEdit$lambda$1 = TribeePublishEditKt.TribeePublishEdit$lambda$1(TribeePublishViewModel.this, modifier3, scope, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePublishEdit$lambda$1;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            fromSpmid2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str2 = fromSpmid2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePublishEdit$lambda$2;
                    TribeePublishEdit$lambda$2 = TribeePublishEditKt.TribeePublishEdit$lambda$2(id, tribeeIdStr, tribeeName, modifier4, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePublishEdit$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0215, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeePublishEdit$lambda$1(final TribeePublishViewModel $viewModel, Modifier $modifier, final CoroutineScope $scope, Composer $composer, int $changed) {
        final MutableState showConfirm$delegate;
        ComposerKt.sourceInformation($composer, "C55@2350L7,56@2377L28,57@2436L13,58@2458L94,61@2580L34,63@2652L16,75@3001L19,72@2940L36,66@2763L50,69@2839L59,64@2677L401:TribeePublishEdit.kt#ufloxe");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963336097, $changed, -1, "kntr.app.tribee.publish.TribeePublishEdit.<anonymous> (TribeePublishEdit.kt:55)");
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
                ComposerKt.sourceInformationMarkerStart($composer, 68352586, "C:TribeePublishEdit.kt#ufloxe");
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
            ComposerKt.sourceInformationMarkerStart($composer, -1275337055, "CC(remember):TribeePublishEdit.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState showConfirm$delegate2 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            State state = SnapshotStateKt.collectAsState($viewModel.getState(), (CoroutineContext) null, $composer, 0, 1);
            TribeePublishState tribeePublishState = (TribeePublishState) state.getValue();
            ComposerKt.sourceInformationMarkerStart($composer, -1275323598, "CC(remember):TribeePublishEdit.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (KFunction) new TribeePublishEditKt$TribeePublishEdit$1$2$1($viewModel);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function2 function2 = (KFunction) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1275325533, "CC(remember):TribeePublishEdit.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        boolean TribeePublishEdit$lambda$1$5$0;
                        TribeePublishEdit$lambda$1$5$0 = TribeePublishEditKt.TribeePublishEdit$lambda$1$5$0();
                        return Boolean.valueOf(TribeePublishEdit$lambda$1$5$0);
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function0 function0 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1275331183, "CC(remember):TribeePublishEdit.kt#9igjgp");
            Object value$iv4 = $composer.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit TribeePublishEdit$lambda$1$6$0;
                        TribeePublishEdit$lambda$1$6$0 = TribeePublishEditKt.TribeePublishEdit$lambda$1$6$0(showConfirm$delegate2);
                        return TribeePublishEdit$lambda$1$6$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
            }
            Function0 function02 = (Function0) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1275328742, "CC(remember):TribeePublishEdit.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(backHandler);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit TribeePublishEdit$lambda$1$7$0;
                    TribeePublishEdit$lambda$1$7$0 = TribeePublishEditKt.TribeePublishEdit$lambda$1$7$0(backHandler);
                    return TribeePublishEdit$lambda$1$7$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeePublishPageKt.TribeePublishPage(tribeePublishState, function0, function02, (Function0) it$iv4, function2, fillMaxSize$default, $composer, 432, 0);
            if (TribeePublishEdit$lambda$1$2(showConfirm$delegate2)) {
                $composer.startReplaceGroup(-880214272);
                ComposerKt.sourceInformation($composer, "80@3159L190,86@3379L23,79@3118L299");
                ComposerKt.sourceInformationMarkerStart($composer, -1275318371, "CC(remember):TribeePublishEdit.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($viewModel);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                    showConfirm$delegate = showConfirm$delegate2;
                    Object value$iv6 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit TribeePublishEdit$lambda$1$8$0;
                            TribeePublishEdit$lambda$1$8$0 = TribeePublishEditKt.TribeePublishEdit$lambda$1$8$0($scope, $viewModel, showConfirm$delegate);
                            return TribeePublishEdit$lambda$1$8$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                } else {
                    showConfirm$delegate = showConfirm$delegate2;
                }
                Function0 function03 = (Function0) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1275311498, "CC(remember):TribeePublishEdit.kt#9igjgp");
                Object it$iv6 = $composer.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit TribeePublishEdit$lambda$1$9$0;
                            TribeePublishEdit$lambda$1$9$0 = TribeePublishEditKt.TribeePublishEdit$lambda$1$9$0(showConfirm$delegate);
                            return TribeePublishEdit$lambda$1$9$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                    it$iv6 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                DialogsKt.EditExitDialog(function03, (Function0) it$iv6, null, $composer, 48, 4);
            } else {
                $composer.startReplaceGroup(-883304445);
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

    private static final boolean TribeePublishEdit$lambda$1$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeePublishEdit$lambda$1$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishEdit$lambda$1$6$0(MutableState $showConfirm$delegate) {
        TribeePublishEdit$lambda$1$3($showConfirm$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishEdit$lambda$1$7$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeePublishEdit$lambda$1$5$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishEdit$lambda$1$8$0(CoroutineScope $scope, TribeePublishViewModel $viewModel, MutableState $showConfirm$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishEditKt$TribeePublishEdit$1$6$1$1($viewModel, $showConfirm$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishEdit$lambda$1$9$0(MutableState $showConfirm$delegate) {
        TribeePublishEdit$lambda$1$3($showConfirm$delegate, false);
        return Unit.INSTANCE;
    }

    public static final void PreviewTribeePublishEdit(final String id, final String tribeeIdStr, final String tribeeName, String fromSpmid, Composer $composer, final int $changed, final int i) {
        String str;
        String fromSpmid2;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tribeeIdStr, "tribeeIdStr");
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Composer $composer2 = $composer.startRestartGroup(-1040110790);
        ComposerKt.sourceInformation($composer2, "C(PreviewTribeePublishEdit)N(id,tribeeIdStr,tribeeName,fromSpmid)101@3811L65,104@3928L7,105@3961L902,105@3940L923:TribeePublishEdit.kt#ufloxe");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(id) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(tribeeIdStr) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(tribeeName) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            str = fromSpmid;
        } else if (($changed & 3072) == 0) {
            str = fromSpmid;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = fromSpmid;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            fromSpmid2 = str;
        } else {
            if (i2 != 0) {
                fromSpmid2 = null;
            } else {
                fromSpmid2 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1040110790, $dirty2, -1, "kntr.app.tribee.publish.PreviewTribeePublishEdit (TribeePublishEdit.kt:100)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1180919131, "CC(remember):TribeePublishEdit.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState initState$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1180924768, "CC(remember):TribeePublishEdit.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changedInstance(backHandler);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeePublishEditKt$PreviewTribeePublishEdit$1$1(id, initState$delegate, backHandler, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            if (PreviewTribeePublishEdit$lambda$1(initState$delegate) != null) {
                $composer2.startReplaceGroup(-2045136808);
                ComposerKt.sourceInformation($composer2, "132@4902L160");
                TribeePublishEdit(id, tribeeIdStr, tribeeName, null, fromSpmid2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | (($dirty2 << 3) & 57344), 8);
            } else {
                $composer2.startReplaceGroup(-2049996120);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str2 = fromSpmid2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.TribeePublishEditKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewTribeePublishEdit$lambda$4;
                    PreviewTribeePublishEdit$lambda$4 = TribeePublishEditKt.PreviewTribeePublishEdit$lambda$4(id, tribeeIdStr, tribeeName, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewTribeePublishEdit$lambda$4;
                }
            });
        }
    }

    private static final TribeeEditContent PreviewTribeePublishEdit$lambda$1(MutableState<TribeeEditContent> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TribeeEditContent) $this$getValue$iv.getValue();
    }
}