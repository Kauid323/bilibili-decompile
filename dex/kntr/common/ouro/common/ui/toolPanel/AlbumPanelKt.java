package kntr.common.ouro.common.ui.toolPanel;

import android.app.Activity;
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
import androidx.compose.ui.unit.IntRect;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelStateKt;
import kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroEntryPoint;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.core.AssetItemState;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAssetKt;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.BPermissionType;
import kntr.common.photonic.permission.PermissionState_androidKt;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.router.RouterKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AlbumPanel.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002²\u0006\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u008a\u008e\u0002"}, d2 = {"AlbumPanel", "", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "onAction", "Lkotlin/Function1;", "Lkntr/common/ouro/core/action/OuroAction;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onEvent", "Lkntr/common/ouro/common/ui/toolPanel/AlbumPanelEvent;", "expandablePanelState", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "(Lkntr/common/photonic/aphro/core/AphroSelectOption;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "handleOnAction", "handleOnDismiss", "albumState", "Lkntr/common/photonic/aphro/core/AphroState;", "progress", "", "selectResultMatchKey", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AlbumPanelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$12(AphroSelectOption aphroSelectOption, Function1 function1, Function0 function0, Modifier modifier, Function1 function12, ExpandablePanelState expandablePanelState, int i, int i2, Composer composer, int i3) {
        AlbumPanel(aphroSelectOption, function1, function0, modifier, function12, expandablePanelState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$0$0(AlbumPanelEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02cb, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03d0  */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AlbumPanel(final AphroSelectOption option, final Function1<? super OuroAction, Unit> function1, final Function0<Unit> function0, Modifier modifier, Function1<? super AlbumPanelEvent, Unit> function12, ExpandablePanelState expandablePanelState, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function13;
        ExpandablePanelState expandablePanelState2;
        Composer $composer2;
        Modifier modifier3;
        Function1 onEvent;
        String str;
        ExpandablePanelState expandablePanelState3;
        int $dirty;
        String str2;
        State handleOnDismiss$delegate;
        int $dirty2;
        String str3;
        int i2;
        Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(1062686597);
        ComposerKt.sourceInformation($composer3, "C(AlbumPanel)N(option,onAction,onDismiss,modifier,onEvent,expandablePanelState)66@2534L30,67@2592L31,68@2640L24,70@2698L240,77@2986L16,79@3111L20,79@3044L88,80@3174L18,82@3220L20,84@3271L7,104@3857L42,106@3942L519,106@3905L556,126@4595L2908,122@4467L3036:AlbumPanel.kt#wsnt7k");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= ($changed & 8) == 0 ? $composer3.changed(option) : $composer3.changedInstance(option) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
            function13 = function12;
        } else if (($changed & 24576) == 0) {
            function13 = function12;
            $dirty3 |= $composer3.changedInstance(function13) ? 16384 : 8192;
        } else {
            function13 = function12;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                expandablePanelState2 = expandablePanelState;
                if ($composer3.changed(expandablePanelState2)) {
                    i2 = 131072;
                    $dirty3 |= i2;
                }
            } else {
                expandablePanelState2 = expandablePanelState;
            }
            i2 = 65536;
            $dirty3 |= i2;
        } else {
            expandablePanelState2 = expandablePanelState;
        }
        int $dirty4 = $dirty3;
        if ($composer3.shouldExecute((74899 & $dirty4) != 74898, $dirty4 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "63@2419L2,64@2472L30");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -960390777, "CC(remember):AlbumPanel.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit AlbumPanel$lambda$0$0;
                                AlbumPanel$lambda$0$0 = AlbumPanelKt.AlbumPanel$lambda$0$0((AlbumPanelEvent) obj);
                                return AlbumPanel$lambda$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function1 onEvent2 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    onEvent = onEvent2;
                } else {
                    onEvent = function13;
                }
                if ((i & 32) != 0) {
                    str = "CC(remember):AlbumPanel.kt#9igjgp";
                    $dirty = $dirty4 & (-458753);
                    expandablePanelState3 = ExpandablePanelStateKt.rememberExpandablePanelState(null, false, null, null, $composer3, 0, 15);
                } else {
                    str = "CC(remember):AlbumPanel.kt#9igjgp";
                    expandablePanelState3 = expandablePanelState2;
                    $dirty = $dirty4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                modifier3 = modifier2;
                onEvent = function13;
                str = "CC(remember):AlbumPanel.kt#9igjgp";
                int i5 = $dirty4;
                expandablePanelState3 = expandablePanelState2;
                $dirty = i5;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1062686597, $dirty, -1, "kntr.common.ouro.common.ui.toolPanel.AlbumPanel (AlbumPanel.kt:65)");
            }
            State handleOnAction$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer3, ($dirty >> 3) & 14);
            State handleOnDismiss$delegate2 = SnapshotStateKt.rememberUpdatedState(function0, $composer3, ($dirty >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String str4 = str;
            ComposerKt.sourceInformationMarkerStart($composer3, -960381611, str4);
            Object value$iv2 = $composer3.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                str2 = str4;
                handleOnDismiss$delegate = handleOnDismiss$delegate2;
                value$iv2 = ((AphroEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AphroEntryPoint.class))).getAphroComponentFactory().build(scope, new AphroState.Init(null, option, 0, null, 13, null)).getViewModel();
                $composer3.updateRememberedValue(value$iv2);
            } else {
                str2 = str4;
                handleOnDismiss$delegate = handleOnDismiss$delegate2;
            }
            final AphroViewModel aphroViewModel = (AphroViewModel) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State albumState$delegate = SnapshotStateKt.collectAsState(aphroViewModel.getStateFlow(), (CoroutineContext) null, $composer3, 0, 1);
            final BPermissionState galleryPermissionState = PermissionState_androidKt.rememberBPermissionState(BPermissionType.GALLERY, PlatformContext_androidKt.getPlatformContext($composer3, 0), $composer3, 6);
            final State progress$delegate = ExpandablePanelStateKt.rememberProgress(expandablePanelState3, $composer3, ($dirty >> 15) & 14);
            final Activity platformContext = PlatformContext_androidKt.getPlatformContext($composer3, 0);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume;
            AphroState state = AlbumPanel$lambda$4(albumState$delegate);
            if (state instanceof AphroState.AphroContent) {
                $composer3.startReplaceGroup(293598178);
                ComposerKt.sourceInformation($composer3, "88@3400L387,88@3368L419");
                Boolean valueOf = Boolean.valueOf(((AphroState.AphroContent) state).getConfirmed());
                str3 = str2;
                ComposerKt.sourceInformationMarkerStart($composer3, -960359000, str3);
                boolean invalid$iv = $composer3.changed(state) | $composer3.changed(handleOnAction$delegate) | $composer3.changed(handleOnDismiss$delegate);
                $dirty2 = $dirty;
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = (Function2) new AlbumPanelKt$AlbumPanel$2$1(state, handleOnAction$delegate, handleOnDismiss$delegate, null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer3, 0);
                $composer3.endReplaceGroup();
            } else {
                $dirty2 = $dirty;
                str3 = str2;
                $composer3.startReplaceGroup(294041819);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -960344721, str3);
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            final MutableState selectResultMatchKey$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String AlbumPanel$lambda$8 = AlbumPanel$lambda$8(selectResultMatchKey$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -960341524, str3);
            boolean invalid$iv2 = $composer3.changedInstance(aphroViewModel);
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv2 && it$iv4 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(AlbumPanel$lambda$8, (Function2) it$iv4, $composer3, 0);
                final ExpandablePanelState expandablePanelState4 = expandablePanelState3;
                final Function1 function14 = onEvent;
                int $dirty5 = $dirty2;
                ExpandablePanelState expandablePanelState5 = expandablePanelState3;
                $composer2 = $composer3;
                ExpandablePanelKt.ExpandablePanel(modifier3, expandablePanelState5, function0, ComposableLambdaKt.rememberComposableLambda(-1300894681, true, new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AlbumPanel$lambda$11;
                        AlbumPanel$lambda$11 = AlbumPanelKt.AlbumPanel$lambda$11(BPermissionState.this, expandablePanelState4, function0, scope, aphroViewModel, function14, platformContext, albumState$delegate, router, option, progress$delegate, selectResultMatchKey$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return AlbumPanel$lambda$11;
                    }
                }, $composer2, 54), $composer2, (($dirty5 >> 9) & 14) | 3072 | (($dirty5 >> 12) & 112) | ($dirty5 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                expandablePanelState2 = expandablePanelState5;
            }
            Object value$iv5 = (Function2) new AlbumPanelKt$AlbumPanel$3$1(selectResultMatchKey$delegate, aphroViewModel, null);
            $composer3.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(AlbumPanel$lambda$8, (Function2) it$iv4, $composer3, 0);
            final ExpandablePanelState expandablePanelState42 = expandablePanelState3;
            final Function1 function142 = onEvent;
            int $dirty52 = $dirty2;
            ExpandablePanelState expandablePanelState52 = expandablePanelState3;
            $composer2 = $composer3;
            ExpandablePanelKt.ExpandablePanel(modifier3, expandablePanelState52, function0, ComposableLambdaKt.rememberComposableLambda(-1300894681, true, new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AlbumPanel$lambda$11;
                    AlbumPanel$lambda$11 = AlbumPanelKt.AlbumPanel$lambda$11(BPermissionState.this, expandablePanelState42, function0, scope, aphroViewModel, function142, platformContext, albumState$delegate, router, option, progress$delegate, selectResultMatchKey$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return AlbumPanel$lambda$11;
                }
            }, $composer2, 54), $composer2, (($dirty52 >> 9) & 14) | 3072 | (($dirty52 >> 12) & 112) | ($dirty52 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            expandablePanelState2 = expandablePanelState52;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onEvent = function13;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function1 function15 = onEvent;
            final ExpandablePanelState expandablePanelState6 = expandablePanelState2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AlbumPanel$lambda$12;
                    AlbumPanel$lambda$12 = AlbumPanelKt.AlbumPanel$lambda$12(AphroSelectOption.this, function1, function0, modifier4, function15, expandablePanelState6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AlbumPanel$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<OuroAction, Unit> AlbumPanel$lambda$1(State<? extends Function1<? super OuroAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> AlbumPanel$lambda$2(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    private static final AphroState AlbumPanel$lambda$4(State<? extends AphroState> state) {
        Object thisObj$iv = state.getValue();
        return (AphroState) thisObj$iv;
    }

    private static final float AlbumPanel$lambda$5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AlbumPanel$lambda$8(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$11(final BPermissionState $galleryPermissionState, ExpandablePanelState $expandablePanelState, Function0 $onDismiss, final CoroutineScope $scope, final AphroViewModel $aphroViewModel, final Function1 $onEvent, final Activity $platformContext, final State $albumState$delegate, final Router $router, final AphroSelectOption $option, State $progress$delegate, final MutableState $selectResultMatchKey$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C133@4855L2,162@5981L14,134@4882L655,156@5747L198,151@5578L135,164@6075L1411,127@4605L2892:AlbumPanel.kt#wsnt7k");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1300894681, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.AlbumPanel.<anonymous> (AlbumPanel.kt:127)");
            }
            AphroState AlbumPanel$lambda$4 = AlbumPanel$lambda$4($albumState$delegate);
            float AlbumPanel$lambda$5 = AlbumPanel$lambda$5($progress$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -324296983, "CC(remember):AlbumPanel.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit AlbumPanel$lambda$11$0$0;
                        AlbumPanel$lambda$11$0$0 = AlbumPanelKt.AlbumPanel$lambda$11$0$0((AphroSelection) obj);
                        return AlbumPanel$lambda$11$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -324260939, "CC(remember):AlbumPanel.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function0 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -324295466, "CC(remember):AlbumPanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($aphroViewModel) | $composer.changed($onEvent);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit AlbumPanel$lambda$11$2$0;
                        AlbumPanel$lambda$11$2$0 = AlbumPanelKt.AlbumPanel$lambda$11$2$0($scope, $aphroViewModel, $onEvent, (AphroAction) obj);
                        return AlbumPanel$lambda$11$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function1 function12 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -324268243, "CC(remember):AlbumPanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changed($galleryPermissionState) | $composer.changedInstance($aphroViewModel);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit AlbumPanel$lambda$11$3$0;
                        AlbumPanel$lambda$11$3$0 = AlbumPanelKt.AlbumPanel$lambda$11$3$0($scope, $galleryPermissionState, $aphroViewModel);
                        return AlbumPanel$lambda$11$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            Function0 function02 = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -324273714, "CC(remember):AlbumPanel.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($aphroViewModel);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit AlbumPanel$lambda$11$4$0;
                        AlbumPanel$lambda$11$4$0 = AlbumPanelKt.AlbumPanel$lambda$11$4$0($scope, $aphroViewModel);
                        return AlbumPanel$lambda$11$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            Function0 function03 = (Function0) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -324256534, "CC(remember):AlbumPanel.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed($albumState$delegate) | $composer.changedInstance($scope) | $composer.changedInstance($router) | $composer.changedInstance($option) | $composer.changedInstance($platformContext);
            Object value$iv6 = $composer.rememberedValue();
            if (invalid$iv4 || value$iv6 == Composer.Companion.getEmpty()) {
                value$iv6 = new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit AlbumPanel$lambda$11$5$0;
                        AlbumPanel$lambda$11$5$0 = AlbumPanelKt.AlbumPanel$lambda$11$5$0($scope, $albumState$delegate, $selectResultMatchKey$delegate, $router, $option, $platformContext, ((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                        return AlbumPanel$lambda$11$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            PictureSelectorKt.PictureSelector($galleryPermissionState, $expandablePanelState, AlbumPanel$lambda$4, AlbumPanel$lambda$5, $onDismiss, function1, function0, function12, function02, function03, $platformContext, false, (Function3) value$iv6, $composer, 1769472, 0, 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$11$0$0(AphroSelection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$11$2$0(CoroutineScope $scope, AphroViewModel $aphroViewModel, Function1 $onEvent, AphroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new AlbumPanelKt$AlbumPanel$4$3$1$1($aphroViewModel, action, $onEvent, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$11$4$0(CoroutineScope $scope, AphroViewModel $aphroViewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new AlbumPanelKt$AlbumPanel$4$5$1$1($aphroViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$11$3$0(CoroutineScope $scope, BPermissionState $galleryPermissionState, AphroViewModel $aphroViewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new AlbumPanelKt$AlbumPanel$4$4$1$1($galleryPermissionState, $aphroViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlbumPanel$lambda$11$5$0(CoroutineScope $scope, State $albumState$delegate, MutableState $selectResultMatchKey$delegate, Router $router, AphroSelectOption $option, Activity $platformContext, int index, AssetItemState state, List rects) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(rects, "rects");
        AphroState AlbumPanel$lambda$4 = AlbumPanel$lambda$4($albumState$delegate);
        AphroState.AphroContent album = AlbumPanel$lambda$4 instanceof AphroState.AphroContent ? (AphroState.AphroContent) AlbumPanel$lambda$4 : null;
        AphroAssetsState assetsState = album != null ? album.getAssetsState() : null;
        AphroAssetsState.AphroContent assetsState2 = assetsState instanceof AphroAssetsState.AphroContent ? assetsState : null;
        if (album != null && assetsState2 != null) {
            Iterable $this$mapIndexed$iv = assetsState2.getAssetList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Asset it = (Asset) item$iv$iv;
                destination$iv$iv.add(PreviewableAssetKt.asPreviewableAsset$default(it, null, (IntRect) rects.get(index$iv$iv), false, 5, null));
                index$iv$iv = index$iv$iv2;
            }
            List totalDataSource = (List) destination$iv$iv;
            String key = Uuid.Companion.random().toString();
            $selectResultMatchKey$delegate.setValue(key);
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new AlbumPanelKt$AlbumPanel$4$6$1$1($router, totalDataSource, index, album, $option, key, $platformContext, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }
}