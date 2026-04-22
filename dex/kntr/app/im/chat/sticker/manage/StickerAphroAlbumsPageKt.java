package kntr.app.im.chat.sticker.manage;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.base.IMToast;
import java.util.List;
import kntr.app.im.chat.sticker.di.StickerEntryPoint;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.viewModel.StickerManagerViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.model.UserInfo;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroEntryPoint;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.core.AspectRadioLimit;
import kntr.common.photonic.aphro.core.ContentSizeLimit;
import kntr.common.photonic.aphro.ui.MediaPageKt;
import kntr.common.photonic.aphro.ui.component.AlbumListKt;
import kntr.common.photonic.aphro.ui.component.MediaListKt;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: StickerAphroAlbumsPage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a3\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a/\u0010\f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\u0016\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"StickerAlbumsSelectPage", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StickerAphroAlbumsPage", "state", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "onStickerAction", "Lkotlin/Function1;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ConfirmButtonBar", "onConfirmClick", "Lkotlin/Function0;", "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "sticker_debug", "stickerManagerState", "aphroState", "Lkntr/common/photonic/aphro/core/AphroState;", "onStickerActionEffect", "albumExpanded", RoomRecommendViewModel.EMPTY_CURSOR}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerAphroAlbumsPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmButtonBar$lambda$2(StickerManagerData stickerManagerData, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        ConfirmButtonBar(stickerManagerData, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAlbumsSelectPage$lambda$3(Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerAlbumsSelectPage(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$8(StickerManagerData stickerManagerData, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerAphroAlbumsPage(stickerManagerData, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void StickerAlbumsSelectPage(Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        UserInfo userInfo;
        Composer $composer2 = $composer.startRestartGroup(367017425);
        ComposerKt.sourceInformation($composer2, "C(StickerAlbumsSelectPage)N(modifier)65@3000L221,73@3277L242,81@3536L24,82@3575L179,82@3565L189:StickerAphroAlbumsPage.kt#is795o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(367017425, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerAlbumsSelectPage (StickerAphroAlbumsPage.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 516430446, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((StickerEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(StickerEntryPoint.class))).getStickerEntryComponentFactory().build().stickerManagerViewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final StickerManagerViewModel stickerViewModel = (StickerManagerViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Flow<StickerManagerData> state = stickerViewModel.getState();
            Object value = stickerViewModel.getAccountStore().getState().getValue();
            AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
            final State stickerManagerState$delegate = SnapshotStateKt.collectAsState(state, new StickerManagerData((logged == null || (userInfo = logged.getUserInfo()) == null) ? 0L : userInfo.getMid(), null, null, null, false, null, false, false, 254, null), (CoroutineContext) null, $composer2, 0, 2);
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
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-452889319, true, new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerAlbumsSelectPage$lambda$2;
                    StickerAlbumsSelectPage$lambda$2 = StickerAphroAlbumsPageKt.StickerAlbumsSelectPage$lambda$2(scope, stickerViewModel, modifier3, stickerManagerState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerAlbumsSelectPage$lambda$2;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerAlbumsSelectPage$lambda$3;
                    StickerAlbumsSelectPage$lambda$3 = StickerAphroAlbumsPageKt.StickerAlbumsSelectPage$lambda$3(modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerAlbumsSelectPage$lambda$3;
                }
            });
        }
    }

    private static final StickerManagerData StickerAlbumsSelectPage$lambda$1(State<StickerManagerData> state) {
        Object thisObj$iv = state.getValue();
        return (StickerManagerData) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAlbumsSelectPage$lambda$2(final CoroutineScope $scope, final StickerManagerViewModel $stickerViewModel, Modifier $modifier, State $stickerManagerState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C85@3654L50,83@3585L163:StickerAphroAlbumsPage.kt#is795o");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-452889319, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerAlbumsSelectPage.<anonymous> (StickerAphroAlbumsPage.kt:83)");
            }
            StickerManagerData StickerAlbumsSelectPage$lambda$1 = StickerAlbumsSelectPage$lambda$1($stickerManagerState$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1434936085, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($stickerViewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit StickerAlbumsSelectPage$lambda$2$0$0;
                        StickerAlbumsSelectPage$lambda$2$0$0 = StickerAphroAlbumsPageKt.StickerAlbumsSelectPage$lambda$2$0$0($scope, $stickerViewModel, (StickerAction) obj);
                        return StickerAlbumsSelectPage$lambda$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StickerAphroAlbumsPage(StickerAlbumsSelectPage$lambda$1, (Function1) it$iv, $modifier, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAlbumsSelectPage$lambda$2$0$0(CoroutineScope $scope, StickerManagerViewModel $stickerViewModel, StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerAphroAlbumsPageKt$StickerAlbumsSelectPage$1$1$1$1($stickerViewModel, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x055f, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0598, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x061d, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x021e, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0270, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0724  */
    /* JADX WARN: Type inference failed for: r3v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StickerAphroAlbumsPage(final StickerManagerData state, final Function1<? super StickerAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean invalid$iv;
        boolean invalid$iv2;
        final AphroViewModel aphroViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onStickerAction");
        Composer $composer3 = $composer.startRestartGroup(316943038);
        ComposerKt.sourceInformation($composer3, "C(StickerAphroAlbumsPage)N(state,onStickerAction,modifier)97@3945L7,98@3985L103,98@3957L131,103@4105L24,106@4156L107,113@4298L329,125@4676L16,131@4842L37,132@4931L7,136@4990L136,134@4944L182,142@5160L84,142@5132L112,152@5364L6,148@5250L2610:StickerAphroAlbumsPage.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316943038, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPage (StickerAphroAlbumsPage.kt:96)");
            }
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Toaster toaster = (Toaster) consume;
            IMToast toast = state.getToast();
            ComposerKt.sourceInformationMarkerStart($composer3, -360411515, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & 14) == 4) | $composer3.changedInstance(toaster);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$1$1(state, toaster, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(toast, (Function2) it$iv, $composer3, 0);
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
            ComposerKt.sourceInformationMarkerStart($composer3, -360406039, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new AphroSelectOption(9, 0, false, (GalleryLoadConfig) null, (List) null, false, false, false, (ContentSizeLimit) null, (AspectRadioLimit) null, 1022, (DefaultConstructorMarker) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            AphroSelectOption option = (AphroSelectOption) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -360401273, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv3 = ((AphroEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AphroEntryPoint.class))).getAphroComponentFactory().build(scope, new AphroState.Init((AphroSelection) null, option, 0, (String) null, 13, (DefaultConstructorMarker) null)).getViewModel();
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            AphroViewModel aphroViewModel2 = (AphroViewModel) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State aphroState$delegate = SnapshotStateKt.collectAsState(aphroViewModel2.getStateFlow(), (CoroutineContext) null, $composer3, 0, 1);
            AphroState.AphroContent StickerAphroAlbumsPage$lambda$3 = StickerAphroAlbumsPage$lambda$3(aphroState$delegate);
            final AphroState.AphroContent albumState = StickerAphroAlbumsPage$lambda$3 instanceof AphroState.AphroContent ? StickerAphroAlbumsPage$lambda$3 : null;
            List selectedAssets = albumState != null ? albumState.getCurrentSelected() : null;
            State onStickerActionEffect$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer3, ($dirty2 >> 3) & 14);
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer3, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer3, -360379322, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changed(onStickerActionEffect$delegate) | $composer3.changedInstance(selectedAssets);
            StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1 value$iv4 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            value$iv4 = new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1(selectedAssets, onStickerActionEffect$delegate, null);
            $composer3.updateRememberedValue(value$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(selectedAssets, (Function2) value$iv4, $composer3, 0);
            Boolean valueOf = Boolean.valueOf(state.getSaved());
            ComposerKt.sourceInformationMarkerStart($composer3, -360373934, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv5 = (($dirty2 & 14) == 4) | $composer3.changedInstance(backHandler);
            StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1 value$iv5 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv5 = new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1(state, backHandler, null);
            $composer3.updateRememberedValue(value$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv5, $composer3, 0);
            Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null)));
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 666053468, "C156@5492L111,159@5612L1580,210@7446L408,205@7202L652:StickerAphroAlbumsPage.kt#is795o");
            AphroState.AphroContent StickerAphroAlbumsPage$lambda$32 = StickerAphroAlbumsPage$lambda$3(aphroState$delegate);
            AphroState.AphroContent aphroContent = StickerAphroAlbumsPage$lambda$32 instanceof AphroState.AphroContent ? StickerAphroAlbumsPage$lambda$32 : null;
            AlbumInfo selectedAlbum = aphroContent != null ? aphroContent.getSelectedAlbum() : null;
            ComposerKt.sourceInformationMarkerStart($composer3, -671252665, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv6 = $composer3.changed(selectedAlbum);
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv6 && it$iv4 != Composer.Companion.getEmpty()) {
                final MutableState albumExpanded$delegate = (MutableState) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                int $changed$iv = ((6 >> 3) & 14) | ((6 >> 3) & 112);
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $changed$iv);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.useNode();
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.createNode(factory$iv$iv$iv2);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int $changed2 = ((6 >> 6) & 112) | 6;
                ColumnScope $this$StickerAphroAlbumsPage_u24lambda_u247_u243 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1679404978, "C165@5826L22,166@5882L67,162@5691L273,189@6683L499,186@6555L627:StickerAphroAlbumsPage.kt#is795o");
                AphroState StickerAphroAlbumsPage$lambda$33 = StickerAphroAlbumsPage$lambda$3(aphroState$delegate);
                boolean StickerAphroAlbumsPage$lambda$7$1 = StickerAphroAlbumsPage$lambda$7$1(albumExpanded$delegate);
                ComposerKt.sourceInformationMarkerStart($composer3, -885455496, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
                invalid$iv = $composer3.changed(albumExpanded$delegate);
                Object value$iv6 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv6 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit StickerAphroAlbumsPage$lambda$7$3$0$0;
                        StickerAphroAlbumsPage$lambda$7$3$0$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$0$0(albumExpanded$delegate, ((Boolean) obj).booleanValue());
                        return StickerAphroAlbumsPage$lambda$7$3$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
                Function1 function12 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -885453659, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
                invalid$iv2 = $composer3.changedInstance(backHandler);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv7 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit StickerAphroAlbumsPage$lambda$7$3$1$0;
                        StickerAphroAlbumsPage$lambda$7$3$1$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$1$0(backHandler);
                        return StickerAphroAlbumsPage$lambda$7$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv7);
                it$iv5 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                MediaPageKt.MediaPageTopNavbar(StickerAphroAlbumsPage$lambda$33, StickerAphroAlbumsPage$lambda$7$1, function12, (Modifier) null, (Function0) it$iv5, $composer3, 0, 8);
                boolean showConfirmBar = (albumState != null || albumState.getSelectedAlbum() == null || state.getSelectedStickersToSave().isEmpty()) ? false : true;
                if (albumState == null) {
                    $composer3.startReplaceGroup(-1678964934);
                    ComposerKt.sourceInformation($composer3, "179@6356L153,175@6170L358");
                    Modifier weight = $this$StickerAphroAlbumsPage_u24lambda_u247_u243.weight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, true);
                    ComposerKt.sourceInformationMarkerStart($composer3, -885438405, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
                    boolean changedInstance = $composer3.changedInstance(scope);
                    aphroViewModel = aphroViewModel2;
                    boolean invalid$iv7 = changedInstance | $composer3.changedInstance(aphroViewModel);
                    Object it$iv6 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    Object value$iv8 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit StickerAphroAlbumsPage$lambda$7$3$2$0;
                            StickerAphroAlbumsPage$lambda$7$3$2$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$2$0(scope, aphroViewModel, (AphroAction) obj);
                            return StickerAphroAlbumsPage$lambda$7$3$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                    it$iv6 = value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    MediaListKt.MediaList-au3_HiA(albumState, (Function1) it$iv6, weight, false, false, (NestedScrollConnection) null, 0.0f, $composer3, 0, 120);
                } else {
                    aphroViewModel = aphroViewModel2;
                    $composer3.startReplaceGroup(-1685097664);
                }
                $composer3.endReplaceGroup();
                AnimatedVisibilityKt.AnimatedVisibility($this$StickerAphroAlbumsPage_u24lambda_u247_u243, showConfirmBar, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1232447850, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit StickerAphroAlbumsPage$lambda$7$3$3;
                        StickerAphroAlbumsPage$lambda$7$3$3 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$3(albumState, state, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return StickerAphroAlbumsPage$lambda$7$3$3;
                    }
                }, $composer3, 54), $composer3, ($changed2 & 14) | 1573248, 28);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                AnimatedVisibilityKt.AnimatedVisibility(StickerAphroAlbumsPage$lambda$7$1(albumExpanded$delegate), ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(691276576, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit StickerAphroAlbumsPage$lambda$7$4;
                        StickerAphroAlbumsPage$lambda$7$4 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$4(albumState, scope, aphroViewModel, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return StickerAphroAlbumsPage$lambda$7$4;
                    }
                }, $composer3, 54), $composer3, 200112, 16);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv9 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer3.updateRememberedValue(value$iv9);
            it$iv4 = value$iv9;
            final MutableState albumExpanded$delegate2 = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv22 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            int $changed$iv2 = ((6 >> 3) & 14) | ((6 >> 3) & 112);
            MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, $changed$iv2);
            int $changed$iv$iv22 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
            Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int $changed22 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$StickerAphroAlbumsPage_u24lambda_u247_u2432 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1679404978, "C165@5826L22,166@5882L67,162@5691L273,189@6683L499,186@6555L627:StickerAphroAlbumsPage.kt#is795o");
            AphroState StickerAphroAlbumsPage$lambda$332 = StickerAphroAlbumsPage$lambda$3(aphroState$delegate);
            boolean StickerAphroAlbumsPage$lambda$7$12 = StickerAphroAlbumsPage$lambda$7$1(albumExpanded$delegate2);
            ComposerKt.sourceInformationMarkerStart($composer3, -885455496, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            invalid$iv = $composer3.changed(albumExpanded$delegate2);
            Object value$iv62 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv62 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj) {
                    Unit StickerAphroAlbumsPage$lambda$7$3$0$0;
                    StickerAphroAlbumsPage$lambda$7$3$0$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$0$0(albumExpanded$delegate2, ((Boolean) obj).booleanValue());
                    return StickerAphroAlbumsPage$lambda$7$3$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv62);
            Function1 function122 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -885453659, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(backHandler);
            Object it$iv52 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv72 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit StickerAphroAlbumsPage$lambda$7$3$1$0;
                    StickerAphroAlbumsPage$lambda$7$3$1$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$1$0(backHandler);
                    return StickerAphroAlbumsPage$lambda$7$3$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv72);
            it$iv52 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            MediaPageKt.MediaPageTopNavbar(StickerAphroAlbumsPage$lambda$332, StickerAphroAlbumsPage$lambda$7$12, function122, (Modifier) null, (Function0) it$iv52, $composer3, 0, 8);
            if (albumState != null) {
            }
            if (albumState == null) {
            }
            $composer3.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility($this$StickerAphroAlbumsPage_u24lambda_u247_u2432, showConfirmBar, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1232447850, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StickerAphroAlbumsPage$lambda$7$3$3;
                    StickerAphroAlbumsPage$lambda$7$3$3 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$3(albumState, state, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StickerAphroAlbumsPage$lambda$7$3$3;
                }
            }, $composer3, 54), $composer3, ($changed22 & 14) | 1573248, 28);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AnimatedVisibilityKt.AnimatedVisibility(StickerAphroAlbumsPage$lambda$7$1(albumExpanded$delegate2), ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(691276576, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StickerAphroAlbumsPage$lambda$7$4;
                    StickerAphroAlbumsPage$lambda$7$4 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$4(albumState, scope, aphroViewModel, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StickerAphroAlbumsPage$lambda$7$4;
                }
            }, $composer3, 54), $composer3, 200112, 16);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerAphroAlbumsPage$lambda$8;
                    StickerAphroAlbumsPage$lambda$8 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$8(StickerManagerData.this, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerAphroAlbumsPage$lambda$8;
                }
            });
        }
    }

    private static final AphroState StickerAphroAlbumsPage$lambda$3(State<? extends AphroState> state) {
        Object thisObj$iv = state.getValue();
        return (AphroState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<StickerAction, Unit> StickerAphroAlbumsPage$lambda$4(State<? extends Function1<? super StickerAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    private static final boolean StickerAphroAlbumsPage$lambda$7$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void StickerAphroAlbumsPage$lambda$7$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$3$0$0(MutableState $albumExpanded$delegate, boolean it) {
        StickerAphroAlbumsPage$lambda$7$2($albumExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$3$1$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$3$2$0(CoroutineScope $scope, AphroViewModel $aphroViewModel, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$4$1$3$1$1($aphroViewModel, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$3$3(AphroState.AphroContent $albumState, StickerManagerData $state, final Function1 $onStickerAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C:StickerAphroAlbumsPage.kt#is795o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1232447850, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPage.<anonymous>.<anonymous>.<anonymous> (StickerAphroAlbumsPage.kt:190)");
        }
        if ($albumState != null) {
            $composer.startReplaceGroup(-1821438171);
            ComposerKt.sourceInformation($composer, "195@6957L170,191@6747L403");
            Modifier navigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer, -1028580908, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onStickerAction);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit StickerAphroAlbumsPage$lambda$7$3$3$0$0;
                        StickerAphroAlbumsPage$lambda$7$3$3$0$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$3$3$0$0($onStickerAction);
                        return StickerAphroAlbumsPage$lambda$7$3$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ConfirmButtonBar($state, navigationBarsPadding, (Function0) it$iv, $composer, 0, 0);
        } else {
            $composer.startReplaceGroup(-1828144680);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$3$3$0$0(Function1 $onStickerAction) {
        $onStickerAction.invoke(StickerAction.SaveSelectedStickers.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$4(AphroState.AphroContent $albumState, final CoroutineScope $scope, final AphroViewModel $aphroViewModel, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C:StickerAphroAlbumsPage.kt#is795o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(691276576, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPage.<anonymous>.<anonymous> (StickerAphroAlbumsPage.kt:211)");
        }
        if ($albumState != null) {
            $composer.startReplaceGroup(-547659846);
            ComposerKt.sourceInformation($composer, "213@7561L6,215@7658L153,212@7502L328");
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU();
            List albumList = $albumState.getAlbumList();
            ComposerKt.sourceInformationMarkerStart($composer, -1403134407, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($aphroViewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit StickerAphroAlbumsPage$lambda$7$4$0$0;
                        StickerAphroAlbumsPage$lambda$7$4$0$0 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$7$4$0$0($scope, $aphroViewModel, (AphroAction) obj);
                        return StickerAphroAlbumsPage$lambda$7$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AlbumListKt.AlbumList-pHQ97Tc(j2, albumList, (Function1) it$iv, (Modifier) null, 0.0f, $composer, 0, 24);
        } else {
            $composer.startReplaceGroup(-555096126);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerAphroAlbumsPage$lambda$7$4$0$0(CoroutineScope $scope, AphroViewModel $aphroViewModel, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$4$2$1$1$1($aphroViewModel, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x028d, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConfirmButtonBar(final StickerManagerData state, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function0 onConfirmClick;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-1055262068);
        ComposerKt.sourceInformation($composer2, "C(ConfirmButtonBar)N(state,modifier,onConfirmClick)230@7997L3,235@8101L6,232@8010L1579:StickerAphroAlbumsPage.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            onConfirmClick = function0;
        } else if (($changed & 384) == 0) {
            onConfirmClick = function0;
            $dirty |= $composer2.changedInstance(onConfirmClick) ? 256 : 128;
        } else {
            onConfirmClick = function0;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -494561617, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onConfirmClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirmClick = onConfirmClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1055262068, $dirty2, -1, "kntr.app.im.chat.sticker.manage.ConfirmButtonBar (StickerAphroAlbumsPage.kt:231)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null)), 0.0f, 1, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$ConfirmButtonBar_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 996551227, "C242@8335L38,252@8719L6,251@8658L97,245@8459L48,254@8767L816,243@8382L1201:StickerAphroAlbumsPage.kt#is795o");
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$ConfirmButtonBar_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            Modifier modifier5 = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30));
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15));
            PaddingValues paddingValues = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, 0L, 0L, $composer2, ButtonDefaults.$stable << 12, 14);
            ComposerKt.sourceInformationMarkerStart($composer2, -1768965736, "CC(remember):StickerAphroAlbumsPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit ConfirmButtonBar$lambda$1$0$0;
                    ConfirmButtonBar$lambda$1$0$0 = StickerAphroAlbumsPageKt.ConfirmButtonBar$lambda$1$0$0(onConfirmClick);
                    return ConfirmButtonBar$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ButtonKt.Button((Function0) it$iv2, modifier5, false, shape, buttonColors, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1277510472, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ConfirmButtonBar$lambda$1$1;
                    ConfirmButtonBar$lambda$1$1 = StickerAphroAlbumsPageKt.ConfirmButtonBar$lambda$1$1(StickerManagerData.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ConfirmButtonBar$lambda$1$1;
                }
            }, $composer2, 54), $composer2, 817889328, 356);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function02 = onConfirmClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConfirmButtonBar$lambda$2;
                    ConfirmButtonBar$lambda$2 = StickerAphroAlbumsPageKt.ConfirmButtonBar$lambda$2(StickerManagerData.this, modifier6, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ConfirmButtonBar$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmButtonBar$lambda$1$0$0(Function0 $onConfirmClick) {
        $onConfirmClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmButtonBar$lambda$1$1(StickerManagerData $state, RowScope $this$Button, Composer $composer, int $changed) {
        String str;
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C266@9300L6,255@8781L792:StickerAphroAlbumsPage.kt#is795o");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1277510472, $changed, -1, "kntr.app.im.chat.sticker.manage.ConfirmButtonBar.<anonymous>.<anonymous> (StickerAphroAlbumsPage.kt:255)");
            }
            if (!$state.getSelectedStickersToSave().isEmpty()) {
                $composer.startReplaceGroup(-609145647);
                ComposerKt.sourceInformation($composer, "258@8903L169");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_436(Res.string.INSTANCE), new Object[]{Integer.valueOf($state.getSelectedStickersToSave().size())}, $composer, 0);
                $composer.endReplaceGroup();
                str = stringResource;
            } else {
                $composer.startReplaceGroup(-608928089);
                ComposerKt.sourceInformation($composer, "263@9126L51");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_202(Res.string.INSTANCE), $composer, 0);
                $composer.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 1, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646141, (DefaultConstructorMarker) null), $composer, 48, 12607488, 113656);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}