package kntr.common.photonic.aphro.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroEntryPoint;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.core.ToastData;
import kntr.common.photonic.aphro.ui.component.AlbumListKt;
import kntr.common.photonic.aphro.ui.component.MediaListKt;
import kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: MediaSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000e\u001a`\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"MediaSelectBottomSheet", "", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "onSelectFinish", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroSelection;", "modifier", "Landroidx/compose/ui/Modifier;", "preSelected", "showSelectIndex", "", "onMediaSelect", "Lkntr/common/photonic/aphro/core/AphroAction;", "(Lkntr/common/photonic/aphro/core/AphroSelectOption;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkntr/common/photonic/aphro/core/AphroSelection;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "state", "Lkntr/common/photonic/aphro/core/AphroState;", "onDismiss", "Lkotlin/ParameterName;", "name", "confirmed", "onAction", "(Lkntr/common/photonic/aphro/core/AphroState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "Toaster", "toast", "Lkntr/common/photonic/aphro/core/ToastData;", "(Lkntr/common/photonic/aphro/core/ToastData;Landroidx/compose/runtime/Composer;I)V", "ui_debug", "albumExpanded"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaSelectBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$11(AphroState aphroState, Function1 function1, Function1 function12, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        MediaSelectBottomSheet(aphroState, function1, function12, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$4(AphroSelectOption aphroSelectOption, Function1 function1, Modifier modifier, AphroSelection aphroSelection, boolean z, Function1 function12, int i, int i2, Composer composer, int i3) {
        MediaSelectBottomSheet(aphroSelectOption, function1, modifier, aphroSelection, z, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toaster$lambda$0(ToastData toastData, int i, Composer composer, int i2) {
        Toaster(toastData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toaster$lambda$2(ToastData toastData, int i, Composer composer, int i2) {
        Toaster(toastData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$0$0(AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6 */
    public static final void MediaSelectBottomSheet(final AphroSelectOption option, final Function1<? super AphroSelection, Unit> function1, Modifier modifier, AphroSelection preSelected, boolean showSelectIndex, Function1<? super AphroAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Function1 onMediaSelect;
        Modifier modifier2;
        boolean showSelectIndex2;
        AphroSelection preSelected2;
        int $dirty;
        Modifier modifier3;
        final Function1 onMediaSelect2;
        final AphroSelection preSelected3;
        String str;
        Modifier modifier4;
        int i2;
        int i3;
        AphroSelection preSelected4 = preSelected;
        Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
        Intrinsics.checkNotNullParameter(function1, "onSelectFinish");
        Composer $composer2 = $composer.startRestartGroup(-158499764);
        ComposerKt.sourceInformation($composer2, "C(MediaSelectBottomSheet)N(option,onSelectFinish,modifier,preSelected,showSelectIndex,onMediaSelect)59@2697L24,61@2750L280,68@3080L16,72@3176L600,87@3797L139,70@3108L907:MediaSelectBottomSheet.kt#3c04ha");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(option) : $composer2.changedInstance(option) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                if (($changed & 4096) == 0 ? $composer2.changed(preSelected4) : $composer2.changedInstance(preSelected4)) {
                    i3 = 2048;
                    $dirty2 |= i3;
                }
            }
            i3 = 1024;
            $dirty2 |= i3;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(showSelectIndex) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
            onMediaSelect = function12;
        } else if (($changed & 196608) == 0) {
            onMediaSelect = function12;
            $dirty2 |= $composer2.changedInstance(onMediaSelect) ? 131072 : 65536;
        } else {
            onMediaSelect = function12;
        }
        if ($composer2.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "57@2673L2");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier5 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                if ((i & 8) != 0) {
                    preSelected4 = new AphroSelection(null, false, 3, null);
                    $dirty2 &= -7169;
                }
                boolean showSelectIndex3 = i5 != 0 ? true : showSelectIndex;
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1994409138, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit MediaSelectBottomSheet$lambda$0$0;
                                MediaSelectBottomSheet$lambda$0$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$0$0((AphroAction) obj);
                                return MediaSelectBottomSheet$lambda$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function1 onMediaSelect3 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    preSelected3 = preSelected4;
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    showSelectIndex2 = showSelectIndex3;
                    onMediaSelect2 = onMediaSelect3;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    showSelectIndex2 = showSelectIndex3;
                    onMediaSelect2 = onMediaSelect;
                    preSelected3 = preSelected4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier3 = modifier;
                showSelectIndex2 = showSelectIndex;
                $dirty = $dirty2;
                onMediaSelect2 = onMediaSelect;
                preSelected3 = preSelected4;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-158499764, $dirty, -1, "kntr.common.photonic.aphro.ui.MediaSelectBottomSheet (MediaSelectBottomSheet.kt:58)");
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
            ComposerKt.sourceInformationMarkerStart($composer2, -1994406396, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
            boolean invalid$iv = ((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(preSelected3)) || ($dirty & 3072) == 2048;
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                str = "CC(remember):MediaSelectBottomSheet.kt#9igjgp";
                modifier4 = modifier3;
                i2 = 0;
                value$iv2 = ((AphroEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AphroEntryPoint.class))).getAphroComponentFactory().build(scope, new AphroState.Init(preSelected3, option, 0, null, 12, null)).getViewModel();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                str = "CC(remember):MediaSelectBottomSheet.kt#9igjgp";
                modifier4 = modifier3;
                i2 = 0;
            }
            final AphroViewModel viewModel = (AphroViewModel) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final AphroState albums = (AphroState) SnapshotStateKt.collectAsState(viewModel.getStateFlow(), (CoroutineContext) null, $composer2, i2, 1).getValue();
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer2, -1994392444, str2);
            int i7 = ($composer2.changed(albums) ? 1 : 0) | ((($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(option))) ? 1 : i2) | ((((($dirty & 7168) ^ 3072) <= 2048 || !$composer2.changedInstance(preSelected3)) && ($dirty & 3072) != 2048) ? i2 : 1) | (($dirty & 112) == 32 ? 1 : i2);
            Object it$iv2 = $composer2.rememberedValue();
            if (i7 != 0 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit MediaSelectBottomSheet$lambda$2$0;
                        MediaSelectBottomSheet$lambda$2$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$2$0(AphroState.this, option, preSelected3, function1, ((Boolean) obj).booleanValue());
                        return MediaSelectBottomSheet$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            Function1 function13 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1994373033, str2);
            boolean invalid$iv2 = $composer2.changedInstance(scope) | ((458752 & $dirty) == 131072) | $composer2.changedInstance(viewModel);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit MediaSelectBottomSheet$lambda$3$0;
                        MediaSelectBottomSheet$lambda$3$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$3$0(onMediaSelect2, scope, viewModel, (AphroAction) obj);
                        return MediaSelectBottomSheet$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function1 onMediaSelect4 = onMediaSelect2;
            AphroSelection preSelected5 = preSelected3;
            MediaSelectBottomSheet(albums, function13, (Function1) it$iv3, modifier4, showSelectIndex2, $composer2, (($dirty << 3) & 7168) | (57344 & $dirty), 0);
            if (albums instanceof AphroState.AphroContent) {
                $composer2.startReplaceGroup(-1695764143);
                ComposerKt.sourceInformation($composer2, "98@4070L21");
                Toaster(((AphroState.AphroContent) albums).getToast(), $composer2, ToastData.$stable);
            } else {
                $composer2.startReplaceGroup(-1699793802);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            preSelected2 = preSelected5;
            onMediaSelect = onMediaSelect4;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            showSelectIndex2 = showSelectIndex;
            preSelected2 = preSelected4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final AphroSelection aphroSelection = preSelected2;
            final boolean z = showSelectIndex2;
            final Function1 function14 = onMediaSelect;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectBottomSheet$lambda$4;
                    MediaSelectBottomSheet$lambda$4 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$4(AphroSelectOption.this, function1, modifier6, aphroSelection, z, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectBottomSheet$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$2$0(AphroState $albums, AphroSelectOption $option, AphroSelection $preSelected, Function1 $onSelectFinish, boolean confirmed) {
        List currentSelected;
        AphroSelection result;
        AphroState.AphroContent aphroContent = $albums instanceof AphroState.AphroContent ? (AphroState.AphroContent) $albums : null;
        if (aphroContent == null || (currentSelected = aphroContent.getCurrentSelected()) == null) {
            currentSelected = CollectionsKt.emptyList();
        }
        AphroState.AphroContent aphroContent2 = $albums instanceof AphroState.AphroContent ? (AphroState.AphroContent) $albums : null;
        boolean useOrigin = aphroContent2 != null ? aphroContent2.getUseOriginImage() : false;
        if (confirmed || $option.getConfirmedOnDismissed()) {
            result = new AphroSelection(currentSelected, useOrigin);
        } else {
            result = $preSelected;
        }
        $onSelectFinish.invoke(result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$3$0(Function1 $onMediaSelect, CoroutineScope $scope, AphroViewModel $viewModel, AphroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        $onMediaSelect.invoke(action);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new MediaSelectBottomSheetKt$MediaSelectBottomSheet$3$1$1($viewModel, action, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void MediaSelectBottomSheet(final AphroState state, final Function1<? super Boolean, Unit> function1, final Function1<? super AphroAction, Unit> function12, Modifier modifier, boolean showSelectIndex, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean showSelectIndex2;
        Modifier modifier3;
        boolean showSelectIndex3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onDismiss");
        Intrinsics.checkNotNullParameter(function12, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1564435878);
        ComposerKt.sourceInformation($composer2, "C(MediaSelectBottomSheet)N(state,onDismiss,onAction,modifier,showSelectIndex)111@4421L46,115@4493L31,117@4553L59,135@5152L30,136@5190L3796,129@4866L4120:MediaSelectBottomSheet.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
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
            showSelectIndex2 = showSelectIndex;
        } else if (($changed & 24576) == 0) {
            showSelectIndex2 = showSelectIndex;
            $dirty |= $composer2.changed(showSelectIndex2) ? 16384 : 8192;
        } else {
            showSelectIndex2 = showSelectIndex;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                showSelectIndex3 = showSelectIndex2;
            } else {
                showSelectIndex3 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564435878, $dirty2, -1, "kntr.common.photonic.aphro.ui.MediaSelectBottomSheet (MediaSelectBottomSheet.kt:110)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -184317624, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState albumExpanded$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State dismissEffect = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty2 >> 3) & 14);
            SheetState bottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, (Function1) null, $composer2, 6, 2);
            final SheetValue currentValue = bottomSheetState.getCurrentValue();
            if (state instanceof AphroState.AphroContent) {
                $composer2.startReplaceGroup(-1418589134);
                ComposerKt.sourceInformation($composer2, "122@4752L102,122@4720L134");
                Boolean valueOf = Boolean.valueOf(((AphroState.AphroContent) state).getConfirmed());
                ComposerKt.sourceInformationMarkerStart($composer2, -184306976, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changed(dismissEffect);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = (Function2) new MediaSelectBottomSheetKt$MediaSelectBottomSheet$5$1(state, dismissEffect, null);
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-1423267096);
            }
            $composer2.endReplaceGroup();
            Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, Dp.constructor-impl(50), 0.0f, 0.0f, 13, (Object) null);
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            ModalBottomSheetProperties modalBottomSheetProperties = new ModalBottomSheetProperties(true, false, 2, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -184294248, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(dismissEffect);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit MediaSelectBottomSheet$lambda$9$0;
                        MediaSelectBottomSheet$lambda$9$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$9$0(dismissEffect);
                        return MediaSelectBottomSheet$lambda$9$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final boolean z = showSelectIndex3;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv3, modifier4, bottomSheetState, 0.0f, false, shape, 0L, 0L, 0.0f, 0L, (Function2) null, (Function2) null, modalBottomSheetProperties, ComposableLambdaKt.rememberComposableLambda(-546918852, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MediaSelectBottomSheet$lambda$10;
                    MediaSelectBottomSheet$lambda$10 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$10(currentValue, state, dismissEffect, albumExpanded$delegate, function12, z, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MediaSelectBottomSheet$lambda$10;
                }
            }, $composer2, 54), $composer2, 0, 3462, 3032);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            showSelectIndex2 = showSelectIndex3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = showSelectIndex2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectBottomSheet$lambda$11;
                    MediaSelectBottomSheet$lambda$11 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$11(AphroState.this, function1, function12, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectBottomSheet$lambda$11;
                }
            });
        }
    }

    private static final boolean MediaSelectBottomSheet$lambda$6(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void MediaSelectBottomSheet$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$9$0(State $dismissEffect) {
        ((Function1) $dismissEffect.getValue()).invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$10(SheetValue $currentValue, final AphroState $state, final State $dismissEffect, final MutableState $albumExpanded$delegate, final Function1 $onAction, boolean $showSelectIndex, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        int $dirty;
        float f;
        Object obj;
        int i;
        int i2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C138@5255L6,138@5283L6,162@6028L22,158@5897L58,153@5734L327:MediaSelectBottomSheet.kt#3c04ha");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer.changed($this$ModalBottomSheet) ? 4 : 2;
        }
        int $dirty3 = $dirty2;
        if ($composer.shouldExecute(($dirty3 & 19) != 18, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-546918852, $dirty3, -1, "kntr.common.photonic.aphro.ui.MediaSelectBottomSheet.<anonymous> (MediaSelectBottomSheet.kt:137)");
            }
            final long bgColor = ColorKt.lerp-jxsXWHM(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), 1.0f);
            if (1.0f == 0.0f) {
                $composer.startReplaceGroup(1846550762);
                ComposerKt.sourceInformation($composer, "145@5542L6,140@5347L228");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 0.5d)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_light-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
            } else {
                $composer.startReplaceGroup(1841251622);
            }
            $composer.endReplaceGroup();
            if ($currentValue == SheetValue.Expanded) {
                $composer.startReplaceGroup(1846845324);
                ComposerKt.sourceInformation($composer, "149@5649L66");
                $dirty = $dirty3;
                MediaSelectFloatKt.m2243MediaSelectPullBarKTwxG1Y(bgColor, null, null, $composer, 0, 6);
            } else {
                $dirty = $dirty3;
                $composer.startReplaceGroup(1841251622);
            }
            $composer.endReplaceGroup();
            boolean MediaSelectBottomSheet$lambda$6 = MediaSelectBottomSheet$lambda$6($albumExpanded$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1602979822, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2) {
                        Unit MediaSelectBottomSheet$lambda$10$0$0;
                        MediaSelectBottomSheet$lambda$10$0$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$10$0$0($albumExpanded$delegate, ((Boolean) obj2).booleanValue());
                        return MediaSelectBottomSheet$lambda$10$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1602983978, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changed($dismissEffect);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit MediaSelectBottomSheet$lambda$10$1$0;
                        MediaSelectBottomSheet$lambda$10$1$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$10$1$0($dismissEffect);
                        return MediaSelectBottomSheet$lambda$10$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            int $dirty4 = $dirty;
            MediaSelectFloatKt.m2241MediaFloatTopBarpzZJ40c(bgColor, 1.0f, $state, null, MediaSelectBottomSheet$lambda$6, function1, (Function0) it$iv2, null, $composer, 199728, 128);
            if (1.0f == 1.0f) {
                $composer.startReplaceGroup(1847302760);
                ComposerKt.sourceInformation($composer, "171@6300L6,166@6105L230");
                f = 0.0f;
                obj = null;
                i2 = 1;
                i = 0;
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 0.5d)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
            } else {
                f = 0.0f;
                obj = null;
                i = 0;
                i2 = 1;
                $composer.startReplaceGroup(1841251622);
            }
            $composer.endReplaceGroup();
            if ($state instanceof AphroState.AphroContent) {
                $composer.startReplaceGroup(1847673706);
                ComposerKt.sourceInformation($composer, "175@6406L2564");
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, f, i2, obj), bgColor, (Shape) null, 2, (Object) null);
                int $changed$iv = i;
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, i));
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
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1941949233, "C181@6592L1390,220@8334L622,214@8022L934:MediaSelectBottomSheet.kt#3c04ha");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int $changed2 = ((6 >> 6) & 112) | 6;
                ColumnScope $this$MediaSelectBottomSheet_u24lambda_u2410_u242_u240 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 720349599, "C187@6788L397,203@7588L376,198@7241L723:MediaSelectBottomSheet.kt#3c04ha");
                MediaListKt.m2264MediaListau3_HiA((AphroState.AphroContent) $state, $onAction, $this$MediaSelectBottomSheet_u24lambda_u2410_u242_u240.weight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, true), 1.0f == 1.0f, $showSelectIndex, null, 0.0f, $composer, 3072, 96);
                AnimatedVisibilityKt.AnimatedVisibility($this$MediaSelectBottomSheet_u24lambda_u2410_u242_u240, ((1.0f > 1.0f ? 1 : (1.0f == 1.0f ? 0 : -1)) == 0) && !((AphroState.AphroContent) $state).getCurrentSelected().isEmpty(), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1755500700, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MediaSelectBottomSheet$lambda$10$2$0$0;
                        MediaSelectBottomSheet$lambda$10$2$0$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$10$2$0$0(AphroState.this, $onAction, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MediaSelectBottomSheet$lambda$10$2$0$0;
                    }
                }, $composer, 54), $composer, ($changed2 & 14) | 1600896, 16);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                AnimatedVisibilityKt.AnimatedVisibility($this$ModalBottomSheet, MediaSelectBottomSheet$lambda$6($albumExpanded$delegate), ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(1429095918, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MediaSelectBottomSheet$lambda$10$2$1;
                        MediaSelectBottomSheet$lambda$10$2$1 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$10$2$1(bgColor, $state, $onAction, $albumExpanded$delegate, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MediaSelectBottomSheet$lambda$10$2$1;
                    }
                }, $composer, 54), $composer, ($dirty4 & 14) | 1600896, 16);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                $composer.startReplaceGroup(1841251622);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$10$1$0(State $dismissEffect) {
        ((Function1) $dismissEffect.getValue()).invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$10$0$0(MutableState $albumExpanded$delegate, boolean it) {
        MediaSelectBottomSheet$lambda$7($albumExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$10$2$0$0(AphroState $state, Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C207@7806L6,204@7614L328:MediaSelectBottomSheet.kt#3c04ha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1755500700, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaSelectBottomSheet.kt:204)");
        }
        SelectedBottomRowKt.SelectedBottom((AphroState.AphroContent) $state, true, false, $onAction, BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$10$2$1(long $bgColor, AphroState $state, final Function1 $onAction, final MutableState $albumExpanded$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C222@8426L302,230@8749L189:MediaSelectBottomSheet.kt#3c04ha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1429095918, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectBottomSheet.<anonymous>.<anonymous>.<anonymous> (MediaSelectBottomSheet.kt:221)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1028354276, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit MediaSelectBottomSheet$lambda$10$2$1$0$0;
                    MediaSelectBottomSheet$lambda$10$2$1$0$0 = MediaSelectBottomSheetKt.MediaSelectBottomSheet$lambda$10$2$1$0$0($onAction, $albumExpanded$delegate, (AphroAction) obj);
                    return MediaSelectBottomSheet$lambda$10$2$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Function1 actionDispatcher = (Function1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        AlbumListKt.m2251AlbumListpHQ97Tc($bgColor, ((AphroState.AphroContent) $state).getAlbumList(), actionDispatcher, null, 0.0f, $composer, 384, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectBottomSheet$lambda$10$2$1$0$0(Function1 $onAction, MutableState $albumExpanded$delegate, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof AphroAction.SwitchAlbum) {
            MediaSelectBottomSheet$lambda$7($albumExpanded$delegate, false);
        }
        $onAction.invoke(it);
        return Unit.INSTANCE;
    }

    public static final void Toaster(final ToastData toast, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1177639931);
        ComposerKt.sourceInformation($composer2, "C(Toaster)N(toast)245@9087L7,246@9121L125,246@9099L147:MediaSelectBottomSheet.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(toast) : $composer2.changedInstance(toast) ? 4 : 2;
        }
        boolean z = false;
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177639931, $dirty, -1, "kntr.common.photonic.aphro.ui.Toaster (MediaSelectBottomSheet.kt:242)");
            }
            if (toast != null) {
                CompositionLocal this_$iv = ToasterKt.getLocalToaster();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Toaster toaster = (Toaster) consume;
                ComposerKt.sourceInformationMarkerStart($composer2, -2135570910, "CC(remember):MediaSelectBottomSheet.kt#9igjgp");
                boolean changedInstance = $composer2.changedInstance(toaster);
                if (($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(toast))) {
                    z = true;
                }
                boolean invalid$iv = changedInstance | z;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function2) new MediaSelectBottomSheetKt$Toaster$2$1(toaster, toast, null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(toast, (Function2) it$iv, $composer2, ToastData.$stable | ($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Toaster$lambda$0;
                            Toaster$lambda$0 = MediaSelectBottomSheetKt.Toaster$lambda$0(ToastData.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return Toaster$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit Toaster$lambda$2;
                    Toaster$lambda$2 = MediaSelectBottomSheetKt.Toaster$lambda$2(ToastData.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Toaster$lambda$2;
                }
            });
        }
    }
}