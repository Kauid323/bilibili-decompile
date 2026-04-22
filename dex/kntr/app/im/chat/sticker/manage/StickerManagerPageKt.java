package kntr.app.im.chat.sticker.manage;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AlertDialogKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.window.DialogProperties;
import bili.resource.common.Res;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import bili.resource.im.String1_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.base.IMToast;
import java.util.List;
import kntr.app.im.chat.sticker.StickerKt;
import kntr.app.im.chat.sticker.di.StickerEntryPoint;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.viewModel.StickerManagerViewModel;
import kntr.app.im.chat.sticker.widget.PermissionDialogKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.model.UserInfo;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.dialog.DialogContent_androidKt;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.BPermissionType;
import kntr.common.photonic.permission.PermissionState_androidKt;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.photonic.shower.AssetShower;
import kntr.common.photonic.shower.AssetShowerHolder;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: StickerManagerPage.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\f\u001a?\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a5\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u001a\u001aK\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0016H\u0003¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"StickerManagerPage", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "state", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "onAction", "Lkotlin/Function2;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ConfirmDeleteDialog", "onDismissRequest", "Lkotlin/Function0;", "onConfirmDelete", "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BottomDeleteBar", "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StickerManagerTopBar", "onStickerAction", "Lkotlin/Function1;", "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "StickerEditContent", "gotoEditPage", "(Lkntr/app/im/chat/sticker/model/StickerManagerData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "StickerManagerGridListItem", "stickerAsset", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "showCheckBox", RoomRecommendViewModel.EMPTY_CURSOR, "selectedIndex", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/sticker/model/StickerAsset;Landroidx/compose/ui/Modifier;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "sticker_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDeleteBar$lambda$1(StickerManagerData stickerManagerData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomDeleteBar(stickerManagerData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmDeleteDialog$lambda$4(StickerManagerData stickerManagerData, Modifier modifier, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        ConfirmDeleteDialog(stickerManagerData, modifier, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerEditContent$lambda$2(StickerManagerData stickerManagerData, Modifier modifier, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        StickerEditContent(stickerManagerData, modifier, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerGridListItem$lambda$2(StickerAsset stickerAsset, Modifier modifier, boolean z, Integer num, Function1 function1, int i, int i2, Composer composer, int i3) {
        StickerManagerGridListItem(stickerAsset, modifier, z, num, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$2(Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerManagerPage(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$7(StickerManagerData stickerManagerData, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerManagerPage(stickerManagerData, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerTopBar$lambda$2(StickerManagerData stickerManagerData, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        StickerManagerTopBar(stickerManagerData, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void StickerManagerPage(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(258099791);
        ComposerKt.sourceInformation($composer2, "C(StickerManagerPage)N(modifier)105@4906L221,112@5142L828,112@5132L838:StickerManagerPage.kt#is795o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258099791, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerManagerPage (StickerManagerPage.kt:103)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1074200884, "CC(remember):StickerManagerPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((StickerEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(StickerEntryPoint.class))).getStickerEntryComponentFactory().build().stickerManagerViewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final StickerManagerViewModel stickerViewModel = (StickerManagerViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1540375047, true, new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerManagerPage$lambda$1;
                    StickerManagerPage$lambda$1 = StickerManagerPageKt.StickerManagerPage$lambda$1(StickerManagerViewModel.this, modifier, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerManagerPage$lambda$1;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda31
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerManagerPage$lambda$2;
                    StickerManagerPage$lambda$2 = StickerManagerPageKt.StickerManagerPage$lambda$2(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerManagerPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$1(StickerManagerViewModel $stickerViewModel, Modifier $modifier, Composer $composer, int $changed) {
        UserInfo userInfo;
        ComposerKt.sourceInformation($composer, "C113@5169L28,114@5231L13,115@5278L78,115@5253L103,120@5429L326,130@5840L33,131@5942L6,128@5770L194:StickerManagerPage.kt#is795o");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1540375047, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerManagerPage.<anonymous> (StickerManagerPage.kt:113)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            Enum dayNightTheme = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer, -1463292523, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(controller) | $composer.changed(dayNightTheme.ordinal());
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new StickerManagerPageKt$StickerManagerPage$1$1$1(controller, dayNightTheme, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(dayNightTheme, (Function2) it$iv, $composer, 0);
            Flow<StickerManagerData> state = $stickerViewModel.getState();
            Object value = $stickerViewModel.getAccountStore().getState().getValue();
            AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
            StickerManagerData state2 = (StickerManagerData) SnapshotStateKt.collectAsState(state, new StickerManagerData((logged == null || (userInfo = logged.getUserInfo()) == null) ? 0L : userInfo.getMid(), null, null, null, false, null, false, false, 254, null), (CoroutineContext) null, $composer, 0, 2).getValue();
            ComposerKt.sourceInformationMarkerStart($composer, -1463274584, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($stickerViewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new StickerManagerPageKt$StickerManagerPage$1$2$1($stickerViewModel, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StickerManagerPage(state2, (Function2) it$iv2, BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0539, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0581, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x04be, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x079a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x04c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StickerManagerPage(final StickerManagerData state, final Function2<? super StickerAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object value$iv;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        Object it$iv;
        Object it$iv2;
        boolean invalid$iv4;
        Object it$iv3;
        boolean invalid$iv5;
        Object it$iv4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Composer $composer3 = $composer.startRestartGroup(-657799956);
        ComposerKt.sourceInformation($composer3, "C(StickerManagerPage)N(state,onAction,modifier)143@6183L24,144@6233L30,147@6304L54,150@6390L7,151@6430L103,151@6402L131,161@6651L6,162@6691L19,157@6539L5426:StickerManagerPage.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
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
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-657799956, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerManagerPage (StickerManagerPage.kt:142)");
            }
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
            final State dispatchAction = SnapshotStateKt.rememberUpdatedState(function2, $composer3, ($dirty2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, -785556254, "CC(remember):StickerManagerPage.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv5 = value$iv2;
            }
            final MutableState showPermissionDialog = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Toaster toaster = (Toaster) consume;
            IMToast toast = state.getToast();
            ComposerKt.sourceInformationMarkerStart($composer3, -785552173, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv6 = (($dirty2 & 14) == 4) | $composer3.changedInstance(toaster);
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                value$iv = (Function2) new StickerManagerPageKt$StickerManagerPage$3$1(state, toaster, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(toast, (Function2) value$iv, $composer3, 0);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(modifier3, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -785543905, "CC(remember):StickerManagerPage.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv7 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv7, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv2);
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1106619266, "C165@6728L4183,279@11197L6,281@11274L198,288@11504L324,272@10921L918:StickerManagerPage.kt#is795o");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int $changed2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$StickerManagerPage_u24lambda_u246_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 892381469, "C173@6991L206,168@6807L405,182@7248L20,184@7321L142,189@7520L121,192@7688L167,192@7654L201,198@7893L7,202@8046L206,209@8285L1127,199@7913L1514,239@9648L6,244@9826L6,246@9875L1026,234@9441L1460:StickerManagerPage.kt#is795o");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -941042826, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv7 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
            Object it$iv8 = $composer3.rememberedValue();
            if (invalid$iv7 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit StickerManagerPage$lambda$6$0$0$0;
                        StickerManagerPage$lambda$6$0$0$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$0$0(scope, dispatchAction, (StickerAction) obj);
                        return StickerManagerPage$lambda$6$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv8 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StickerManagerTopBar(state, fillMaxWidth$default, (Function1) it$iv8, $composer3, ($dirty2 & 14) | 48, 0);
            Activity platformContext = PlatformContext_androidKt.getPlatformContext($composer3, 0);
            final BPermissionState galleryPermission = PermissionState_androidKt.rememberBPermissionState(BPermissionType.GALLERY, platformContext, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, -941025983, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv8 = $composer3.changed(galleryPermission);
            Object it$iv9 = $composer3.rememberedValue();
            if (!invalid$iv8 && it$iv9 != Composer.Companion.getEmpty()) {
                final MutableState savedPermissionStatus = (MutableState) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -941020561, "CC(remember):StickerManagerPage.kt#9igjgp");
                invalid$iv = $composer3.changed(galleryPermission) | $composer3.changed(savedPermissionStatus);
                Object it$iv10 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv5 = (Function2) new StickerManagerPageKt$StickerManagerPage$5$1$2$1(galleryPermission, savedPermissionStatus, null);
                $composer3.updateRememberedValue(value$iv5);
                it$iv10 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(galleryPermission, (Function2) it$iv10, $composer3, 0);
                CompositionLocal this_$iv2 = RouterKt.getLocalRouter();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Router route = (Router) consume2;
                Modifier weight$default = ColumnScope.-CC.weight$default($this$StickerManagerPage_u24lambda_u246_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -941009066, "CC(remember):StickerManagerPage.kt#9igjgp");
                invalid$iv2 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
                Object it$iv11 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv6 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        Unit StickerManagerPage$lambda$6$0$3$0;
                        StickerManagerPage$lambda$6$0$3$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$3$0(scope, dispatchAction, (StickerAction) obj);
                        return StickerManagerPage$lambda$6$0$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
                it$iv11 = value$iv6;
                Function1 function1 = (Function1) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -941000497, "CC(remember):StickerManagerPage.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(scope) | $composer3.changed(savedPermissionStatus) | $composer3.changedInstance(route) | $composer3.changed(galleryPermission);
                Object it$iv12 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv7 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        Unit StickerManagerPage$lambda$6$0$4$0;
                        StickerManagerPage$lambda$6$0$4$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$4$0(scope, savedPermissionStatus, route, showPermissionDialog, galleryPermission);
                        return StickerManagerPage$lambda$6$0$4$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv7);
                it$iv12 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                StickerEditContent(state, weight$default, function1, (Function0) it$iv12, $composer3, $dirty2 & 14, 0);
                boolean isEditMode = state.isEditMode();
                EnterTransition fadeIn$default = EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -940958002, "CC(remember):StickerManagerPage.kt#9igjgp");
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj) {
                            int StickerManagerPage$lambda$6$0$5$0;
                            StickerManagerPage$lambda$6$0$5$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$5$0(((Integer) obj).intValue());
                            return Integer.valueOf(StickerManagerPage$lambda$6$0$5$0);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                    it$iv = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EnterTransition plus = fadeIn$default.plus(EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, (Function1) it$iv, 1, (Object) null));
                ExitTransition fadeOut$default = EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -940952306, "CC(remember):StickerManagerPage.kt#9igjgp");
                it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj) {
                            int StickerManagerPage$lambda$6$0$6$0;
                            StickerManagerPage$lambda$6$0$6$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$6$0(((Integer) obj).intValue());
                            return Integer.valueOf(StickerManagerPage$lambda$6$0$6$0);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                    it$iv2 = value$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                AnimatedVisibilityKt.AnimatedVisibility($this$StickerManagerPage_u24lambda_u246_u240, isEditMode, (Modifier) null, plus, fadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, (Function1) it$iv2, 1, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-2013740864, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit StickerManagerPage$lambda$6$0$7;
                        StickerManagerPage$lambda$6$0$7 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$7(StickerManagerData.this, scope, dispatchAction, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return StickerManagerPage$lambda$6$0$7;
                    }
                }, $composer3, 54), $composer3, ($changed2 & 14) | 1600512, 18);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(280)), Dp.constructor-impl(114)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1559858488, "CC(remember):StickerManagerPage.kt#9igjgp");
                invalid$iv4 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
                it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv4 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv10 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda20
                        public final Object invoke() {
                            Unit StickerManagerPage$lambda$6$1$0;
                            StickerManagerPage$lambda$6$1$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$1$0(scope, dispatchAction);
                            return StickerManagerPage$lambda$6$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv10);
                    it$iv3 = value$iv10;
                }
                Function0 function0 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1559865974, "CC(remember):StickerManagerPage.kt#9igjgp");
                invalid$iv5 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
                it$iv4 = $composer3.rememberedValue();
                if (!invalid$iv5 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv11 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit StickerManagerPage$lambda$6$2$0;
                            StickerManagerPage$lambda$6$2$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$2$0(scope, dispatchAction);
                            return StickerManagerPage$lambda$6$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv11);
                    it$iv4 = value$iv11;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ConfirmDeleteDialog(state, modifier5, function0, (Function0) it$iv4, $composer3, $dirty2 & 14, 0);
                if (((Boolean) showPermissionDialog.getValue()).booleanValue()) {
                    $composer3.startReplaceGroup(1099781936);
                } else {
                    $composer3.startReplaceGroup(1111570337);
                    ComposerKt.sourceInformation($composer3, "300@11911L38,300@11894L55");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1559878712, "CC(remember):StickerManagerPage.kt#9igjgp");
                    Object it$iv13 = $composer3.rememberedValue();
                    if (it$iv13 == Composer.Companion.getEmpty()) {
                        Object value$iv12 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda12
                            public final Object invoke() {
                                Unit StickerManagerPage$lambda$6$3$0;
                                StickerManagerPage$lambda$6$3$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$3$0(showPermissionDialog);
                                return StickerManagerPage$lambda$6$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv12);
                        it$iv13 = value$iv12;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    PermissionDialogKt.PermissionDialog((Function0) it$iv13, $composer3, 6);
                }
                $composer3.endReplaceGroup();
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
            Object value$iv13 = SnapshotStateKt.mutableStateOf$default(galleryPermission.getCurrentStatus().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer3.updateRememberedValue(value$iv13);
            it$iv9 = value$iv13;
            final MutableState savedPermissionStatus2 = (MutableState) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -941020561, "CC(remember):StickerManagerPage.kt#9igjgp");
            invalid$iv = $composer3.changed(galleryPermission) | $composer3.changed(savedPermissionStatus2);
            Object it$iv102 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv52 = (Function2) new StickerManagerPageKt$StickerManagerPage$5$1$2$1(galleryPermission, savedPermissionStatus2, null);
            $composer3.updateRememberedValue(value$iv52);
            it$iv102 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(galleryPermission, (Function2) it$iv102, $composer3, 0);
            CompositionLocal this_$iv22 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume22 = $composer3.consume(this_$iv22);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router route2 = (Router) consume22;
            Modifier weight$default2 = ColumnScope.-CC.weight$default($this$StickerManagerPage_u24lambda_u246_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -941009066, "CC(remember):StickerManagerPage.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
            Object it$iv112 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv62 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj) {
                    Unit StickerManagerPage$lambda$6$0$3$0;
                    StickerManagerPage$lambda$6$0$3$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$3$0(scope, dispatchAction, (StickerAction) obj);
                    return StickerManagerPage$lambda$6$0$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv62);
            it$iv112 = value$iv62;
            Function1 function12 = (Function1) it$iv112;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -941000497, "CC(remember):StickerManagerPage.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(scope) | $composer3.changed(savedPermissionStatus2) | $composer3.changedInstance(route2) | $composer3.changed(galleryPermission);
            Object it$iv122 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv72 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda16
                public final Object invoke() {
                    Unit StickerManagerPage$lambda$6$0$4$0;
                    StickerManagerPage$lambda$6$0$4$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$4$0(scope, savedPermissionStatus2, route2, showPermissionDialog, galleryPermission);
                    return StickerManagerPage$lambda$6$0$4$0;
                }
            };
            $composer3.updateRememberedValue(value$iv72);
            it$iv122 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            StickerEditContent(state, weight$default2, function12, (Function0) it$iv122, $composer3, $dirty2 & 14, 0);
            boolean isEditMode2 = state.isEditMode();
            EnterTransition fadeIn$default2 = EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -940958002, "CC(remember):StickerManagerPage.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EnterTransition plus2 = fadeIn$default2.plus(EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, (Function1) it$iv, 1, (Object) null));
            ExitTransition fadeOut$default2 = EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -940952306, "CC(remember):StickerManagerPage.kt#9igjgp");
            it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AnimatedVisibilityKt.AnimatedVisibility($this$StickerManagerPage_u24lambda_u246_u240, isEditMode2, (Modifier) null, plus2, fadeOut$default2.plus(EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, (Function1) it$iv2, 1, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-2013740864, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StickerManagerPage$lambda$6$0$7;
                    StickerManagerPage$lambda$6$0$7 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$7(StickerManagerData.this, scope, dispatchAction, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StickerManagerPage$lambda$6$0$7;
                }
            }, $composer3, 54), $composer3, ($changed2 & 14) | 1600512, 18);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier52 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(280)), Dp.constructor-impl(114)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1559858488, "CC(remember):StickerManagerPage.kt#9igjgp");
            invalid$iv4 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
            it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv4) {
            }
            Object value$iv102 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda20
                public final Object invoke() {
                    Unit StickerManagerPage$lambda$6$1$0;
                    StickerManagerPage$lambda$6$1$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$1$0(scope, dispatchAction);
                    return StickerManagerPage$lambda$6$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv102);
            it$iv3 = value$iv102;
            Function0 function02 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1559865974, "CC(remember):StickerManagerPage.kt#9igjgp");
            invalid$iv5 = $composer3.changedInstance(scope) | $composer3.changed(dispatchAction);
            it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv5) {
            }
            Object value$iv112 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit StickerManagerPage$lambda$6$2$0;
                    StickerManagerPage$lambda$6$2$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$2$0(scope, dispatchAction);
                    return StickerManagerPage$lambda$6$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv112);
            it$iv4 = value$iv112;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ConfirmDeleteDialog(state, modifier52, function02, (Function0) it$iv4, $composer3, $dirty2 & 14, 0);
            if (((Boolean) showPermissionDialog.getValue()).booleanValue()) {
            }
            $composer3.endReplaceGroup();
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
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerManagerPage$lambda$7;
                    StickerManagerPage$lambda$7 = StickerManagerPageKt.StickerManagerPage$lambda$7(StickerManagerData.this, function2, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerManagerPage$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$0$0$0(CoroutineScope $scope, State $dispatchAction, StickerAction stickerEvent) {
        Intrinsics.checkNotNullParameter(stickerEvent, "stickerEvent");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerPageKt$StickerManagerPage$5$1$1$1$1($dispatchAction, stickerEvent, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$0$3$0(CoroutineScope $scope, State $dispatchAction, StickerAction stickerEvent) {
        Intrinsics.checkNotNullParameter(stickerEvent, "stickerEvent");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerPageKt$StickerManagerPage$5$1$3$1$1($dispatchAction, stickerEvent, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$0$4$0(CoroutineScope $scope, MutableState $savedPermissionStatus, Router $route, MutableState $showPermissionDialog, BPermissionState $galleryPermission) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerPageKt$StickerManagerPage$5$1$4$1$1($savedPermissionStatus, $route, $showPermissionDialog, $galleryPermission, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int StickerManagerPage$lambda$6$0$5$0(int it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int StickerManagerPage$lambda$6$0$6$0(int it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x019d, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit StickerManagerPage$lambda$6$0$7(StickerManagerData $state, final CoroutineScope $scope, final State $dispatchAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C247@9893L994:StickerManagerPage.kt#is795o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013740864, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerManagerPage.<anonymous>.<anonymous>.<anonymous> (StickerManagerPage.kt:247)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Modifier modifier$iv = Modifier.Companion;
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        int i2 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -434362630, "C248@9922L19,253@10150L6,259@10490L317,249@9962L907:StickerManagerPage.kt#is795o");
        DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
        Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null)), 0.0f, 1, (Object) null), Dp.constructor-impl(60));
        boolean z = !$state.getSelectedStickersToDelete().isEmpty();
        ComposerKt.sourceInformationMarkerStart($composer, -1260920141, "CC(remember):StickerManagerPage.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($dispatchAction);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda22
            public final Object invoke() {
                Unit StickerManagerPage$lambda$6$0$7$0$0$0;
                StickerManagerPage$lambda$6$0$7$0$0$0 = StickerManagerPageKt.StickerManagerPage$lambda$6$0$7$0$0$0($scope, $dispatchAction);
                return StickerManagerPage$lambda$6$0$7$0$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv);
        it$iv = value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        BottomDeleteBar($state, ClickableKt.clickable-oSLSa3U$default(modifier, z, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), $composer, 0, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$0$7$0$0$0(CoroutineScope $scope, State $dispatchAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerPageKt$StickerManagerPage$5$1$7$1$1$1$1($dispatchAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$1$0(CoroutineScope $scope, State $dispatchAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerPageKt$StickerManagerPage$5$2$1$1($dispatchAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$2$0(CoroutineScope $scope, State $dispatchAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerManagerPageKt$StickerManagerPage$5$3$1$1($dispatchAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerPage$lambda$6$3$0(MutableState $showPermissionDialog) {
        $showPermissionDialog.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r13v8 */
    private static final void ConfirmDeleteDialog(final StickerManagerData state, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function03;
        Function0 onConfirmDelete;
        Function0 onDismissRequest;
        Modifier modifier3;
        final Function0 onDismissRequest2;
        final Function0 onConfirmDelete2;
        Function0 onConfirmDelete3;
        Composer $composer2 = $composer.startRestartGroup(-1424713317);
        ComposerKt.sourceInformation($composer2, "C(ConfirmDeleteDialog)N(state,modifier,onDismissRequest,onConfirmDelete)310@12155L3,311@12194L3:StickerManagerPage.kt#is795o");
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
            function03 = function0;
        } else if (($changed & 384) == 0) {
            function03 = function0;
            $dirty |= $composer2.changedInstance(function03) ? 256 : 128;
        } else {
            function03 = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onConfirmDelete = function02;
        } else if (($changed & 3072) == 0) {
            onConfirmDelete = function02;
            $dirty |= $composer2.changedInstance(onConfirmDelete) ? 2048 : 1024;
        } else {
            onConfirmDelete = function02;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 945073822, "CC(remember):StickerManagerPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onDismissRequest2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onDismissRequest2 = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 945075070, "CC(remember):StickerManagerPage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onConfirmDelete4 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirmDelete2 = onConfirmDelete4;
            } else {
                onConfirmDelete2 = onConfirmDelete;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1424713317, $dirty, -1, "kntr.app.im.chat.sticker.manage.ConfirmDeleteDialog (StickerManagerPage.kt:312)");
            }
            if (state.isShowConfirmDeleteDialog()) {
                $composer2.startReplaceGroup(-767372600);
                ComposerKt.sourceInformation($composer2, "315@12303L50,319@12398L543,314@12254L687");
                ComposerKt.sourceInformationMarkerStart($composer2, 945078605, "CC(remember):StickerManagerPage.kt#9igjgp");
                boolean invalid$iv = ($dirty & 896) == 256;
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit ConfirmDeleteDialog$lambda$2$0;
                            ConfirmDeleteDialog$lambda$2$0 = StickerManagerPageKt.ConfirmDeleteDialog$lambda$2$0(onDismissRequest2);
                            return ConfirmDeleteDialog$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirmDelete3 = onConfirmDelete2;
                AlertDialogKt.BasicAlertDialog((Function0) it$iv3, modifier4, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-1333436612, true, new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ConfirmDeleteDialog$lambda$3;
                        ConfirmDeleteDialog$lambda$3 = StickerManagerPageKt.ConfirmDeleteDialog$lambda$3(onDismissRequest2, onConfirmDelete2, (Composer) obj, ((Integer) obj2).intValue());
                        return ConfirmDeleteDialog$lambda$3;
                    }
                }, $composer2, 54), $composer2, ($dirty & 112) | 3072, 4);
            } else {
                onConfirmDelete3 = onConfirmDelete2;
                $composer2.startReplaceGroup(-779541433);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onConfirmDelete = onConfirmDelete3;
            onDismissRequest = onDismissRequest2;
        } else {
            $composer2.skipToGroupEnd();
            onDismissRequest = function03;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function04 = onDismissRequest;
            final Function0 function05 = onConfirmDelete;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConfirmDeleteDialog$lambda$4;
                    ConfirmDeleteDialog$lambda$4 = StickerManagerPageKt.ConfirmDeleteDialog$lambda$4(StickerManagerData.this, modifier5, function04, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ConfirmDeleteDialog$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmDeleteDialog$lambda$2$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmDeleteDialog$lambda$3(final Function0 $onDismissRequest, final Function0 $onConfirmDelete, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C321@12457L47,323@12575L47,324@12657L72,320@12412L519:StickerManagerPage.kt#is795o");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1333436612, $changed, -1, "kntr.app.im.chat.sticker.manage.ConfirmDeleteDialog.<anonymous> (StickerManagerPage.kt:320)");
            }
            final String titleString$iv = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_789(Res.string.INSTANCE), $composer, 0);
            final String negativeString$iv = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_414(Res.string.INSTANCE), $composer, 0);
            final String positiveString$iv = StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_202(Res.string.INSTANCE), $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -1894279827, "CC(DialogContent)N(titleString,contentString,onNegativeClick,onPositiveClick,modifier,negativeString,positiveString)150@4902L39,151@4973L40,154@5059L1495,194@6591L873,153@5023L2441:DialogContent.kt#j1m0ki");
            Modifier modifier$iv = Modifier.Companion;
            DialogContent_androidKt.DialogContent(ComposableLambdaKt.rememberComposableLambda(93781831, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$ConfirmDeleteDialog$lambda$3$$inlined$DialogContent$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Composer $composer$iv$iv$iv;
                    String str;
                    String str2;
                    String str3;
                    Composer $composer$iv;
                    Composer $composer$iv$iv;
                    Modifier materialized$iv$iv;
                    Function0 factory$iv$iv$iv2;
                    Function0 factory$iv$iv$iv3;
                    ComposerKt.sourceInformation($composer2, "C155@5073L1471:DialogContent.kt#j1m0ki");
                    if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(93781831, $changed2, -1, "kntr.common.dialog.DialogContent.<anonymous> (DialogContent.kt:155)");
                    }
                    Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
                    String str4 = negativeString$iv;
                    String str5 = positiveString$iv;
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i2 = ((438 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 145669907, "C:DialogContent.kt#j1m0ki");
                    if (str4 != null) {
                        $composer2.startReplaceGroup(145677532);
                        ComposerKt.sourceInformation($composer2, "161@5359L531");
                        Modifier weight$default = RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                        final Function0 function0 = $onDismissRequest;
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(weight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$ConfirmDeleteDialog$lambda$3$$inlined$DialogContent$1.1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1686invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1686invoke() {
                                function0.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer2.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                        $composer$iv$iv$iv = $composer2;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i4 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1099396812, "C170@5768L6,171@5828L9,168@5665L203:DialogContent.kt#j1m0ki");
                        materialized$iv$iv = materialized$iv$iv2;
                        $composer$iv = $composer2;
                        $composer$iv$iv = $composer2;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str3 = str5;
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        TextKt.Text-Nvy7gAk(str4, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        $composer$iv$iv$iv = $composer2;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str3 = str5;
                        $composer$iv = $composer2;
                        $composer$iv$iv = $composer2;
                        materialized$iv$iv = materialized$iv$iv2;
                        $composer2.startReplaceGroup(140364535);
                    }
                    $composer2.endReplaceGroup();
                    if (str3 != null) {
                        $composer2.startReplaceGroup(146289751);
                        ComposerKt.sourceInformation($composer2, "177@5976L536");
                        Modifier weight$default2 = RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                        final Function0 function02 = $onConfirmDelete;
                        Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(weight$default2, false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$ConfirmDeleteDialog$lambda$3$$inlined$DialogContent$1.2
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1687invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1687invoke() {
                                function02.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, str);
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str2);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv6;
                            $composer2.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv6;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i6 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1196457072, "C186@6385L6,187@6450L9,184@6282L208:DialogContent.kt#j1m0ki");
                        TextKt.Text-Nvy7gAk(str3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        $composer2.startReplaceGroup(140364535);
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), modifier$iv, ComposableLambdaKt.rememberComposableLambda(1990761289, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$ConfirmDeleteDialog$lambda$3$$inlined$DialogContent$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    Composer $composer3;
                    ComposerKt.sourceInformation($composer2, "C195@6601L857:DialogContent.kt#j1m0ki");
                    if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1990761289, $changed2, -1, "kntr.common.dialog.DialogContent.<anonymous> (DialogContent.kt:195)");
                    }
                    Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(18), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    String str = titleString$iv;
                    String str2 = r2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i2 = ((438 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -81923373, "C206@7027L6,207@7075L9,204@6951L199:DialogContent.kt#j1m0ki");
                    TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16b(), $composer2, 0, 0, 130042);
                    if (StringsKt.isBlank(str2)) {
                        $composer3 = $composer2;
                        $composer3.startReplaceGroup(-88835165);
                    } else {
                        $composer2.startReplaceGroup(-81671065);
                        ComposerKt.sourceInformation($composer2, "214@7300L6,215@7352L9,212@7214L220");
                        $composer3 = $composer2;
                        TextKt.Text-Nvy7gAk(str2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer3, 0, 0, 130042);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), $composer, ((48 >> 9) & 112) | 390, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x019d, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BottomDeleteBar(final StickerManagerData state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer3 = $composer.startRestartGroup(948864589);
        ComposerKt.sourceInformation($composer3, "C(BottomDeleteBar)N(state,modifier)344@13075L1208:StickerManagerPage.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(948864589, $dirty, -1, "kntr.app.im.chat.sticker.manage.BottomDeleteBar (StickerManagerPage.kt:343)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty >> 3) & 14) | 48;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1476005917, "C351@13287L106,348@13170L1107:StickerManagerPage.kt#is795o");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 47615837, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit BottomDeleteBar$lambda$0$0$0;
                    BottomDeleteBar$lambda$0$0$0 = StickerManagerPageKt.BottomDeleteBar$lambda$0$0$0(StickerManagerData.this, (GraphicsLayerScope) obj);
                    return BottomDeleteBar$lambda$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
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
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -153572964, "C357@13528L21,360@13680L6,356@13483L229,372@14186L9,373@14235L6,362@13725L542:StickerManagerPage.kt#is795o");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getTrash_delete_line_500($composer3, 6), "delete", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getStress_red-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            if (!state.getSelectedStickersToDelete().isEmpty()) {
                $composer3.startReplaceGroup(-153252983);
                ComposerKt.sourceInformation($composer3, "365@13849L178");
                String stringResource = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_902(Res.string.INSTANCE), new Object[]{String.valueOf(state.getSelectedStickersToDelete().size())}, $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource;
            } else {
                $composer3.startReplaceGroup(-153026900);
                ComposerKt.sourceInformation($composer3, "370@14081L47");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_420(Res.string.INSTANCE), $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getStress_red-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomDeleteBar$lambda$1;
                    BottomDeleteBar$lambda$1 = StickerManagerPageKt.BottomDeleteBar$lambda$1(StickerManagerData.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomDeleteBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDeleteBar$lambda$0$0$0(StickerManagerData $state, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($state.getSelectedStickersToDelete().isEmpty() ? 0.4f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerTopBar$lambda$0$0(StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x020b, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0346, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void StickerManagerTopBar(final StickerManagerData state, Modifier modifier, Function1<? super StickerAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Function1 function12;
        Modifier modifier2;
        Function1 onStickerAction;
        Modifier modifier3;
        final Function1 onStickerAction2;
        Function0 factory$iv$iv$iv;
        boolean z;
        String str;
        Composer $composer2 = $composer.startRestartGroup(1788831239);
        ComposerKt.sourceInformation($composer2, "C(StickerManagerTopBar)N(state,modifier,onStickerAction)383@14446L2,385@14505L7,386@14517L1606:StickerManagerPage.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            function12 = function1;
        } else if (($changed & 384) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 131) != 130, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onStickerAction = function12;
        } else {
            if ((i & 2) != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1079906729, "CC(remember):StickerManagerPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda32
                        public final Object invoke(Object obj) {
                            Unit StickerManagerTopBar$lambda$0$0;
                            StickerManagerTopBar$lambda$0$0 = StickerManagerPageKt.StickerManagerTopBar$lambda$0$0((StickerAction) obj);
                            return StickerManagerTopBar$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onStickerAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStickerAction2 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1788831239, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerManagerTopBar (StickerManagerPage.kt:384)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.Companion), Dp.constructor-impl(48)), 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$StickerManagerTopBar_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 662594577, "C395@14765L24,402@15020L75,405@15126L6,394@14724L425,410@15200L141,414@15373L9,415@15419L6,408@15159L340,427@15830L9,428@15874L6,430@15973L133,418@15508L609:StickerManagerPage.kt#is795o");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            Modifier align = $this$StickerManagerTopBar_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Alignment.Companion.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, -532807156, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(backHandler);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda33
                public final Object invoke() {
                    Unit StickerManagerTopBar$lambda$1$0$0;
                    StickerManagerTopBar$lambda$1$0$0 = StickerManagerPageKt.StickerManagerTopBar$lambda$1$0$0(backHandler);
                    return StickerManagerTopBar$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, "back", ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_903(Res.string.INSTANCE), new Object[]{String.valueOf(state.getStickerList().size())}, $composer2, 0), $this$StickerManagerTopBar_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17b(), $composer2, 0, 0, 131064);
            if (state.isEditMode()) {
                $composer2.startReplaceGroup(663394314);
                ComposerKt.sourceInformation($composer2, "421@15593L47");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_515(Res.string.INSTANCE), $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource;
                z = false;
            } else {
                $composer2.startReplaceGroup(663488027);
                ComposerKt.sourceInformation($composer2, "423@15686L94");
                z = false;
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_110(Res.string.INSTANCE), $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource2;
            }
            TextStyle h3 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getH3();
            long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier align2 = $this$StickerManagerTopBar_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterEnd());
            ComposerKt.sourceInformationMarkerStart($composer2, -532776602, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256 ? true : z;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda34
                public final Object invoke() {
                    Unit StickerManagerTopBar$lambda$1$1$0;
                    StickerManagerTopBar$lambda$1$1$0 = StickerManagerPageKt.StickerManagerTopBar$lambda$1$1$0(onStickerAction2);
                    return StickerManagerTopBar$lambda$1$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextKt.Text-Nvy7gAk(str, ClickableKt.clickable-oSLSa3U$default(align2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, h3, $composer2, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onStickerAction = onStickerAction2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function1 function13 = onStickerAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerManagerTopBar$lambda$2;
                    StickerManagerTopBar$lambda$2 = StickerManagerPageKt.StickerManagerTopBar$lambda$2(StickerManagerData.this, modifier4, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerManagerTopBar$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerTopBar$lambda$1$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerTopBar$lambda$1$1$0(Function1 $onStickerAction) {
        $onStickerAction.invoke(StickerAction.ReverseEditMode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerEditContent$lambda$0$0(StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0161, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void StickerEditContent(final StickerManagerData state, Modifier modifier, Function1<? super StickerAction, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 onStickerAction;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        final Function1 onStickerAction2;
        Composer $composer2 = $composer.startRestartGroup(153230551);
        ComposerKt.sourceInformation($composer2, "C(StickerEditContent)N(state,modifier,onStickerAction,gotoEditPage)443@16284L2,446@16339L34,455@16661L14,455@16676L17,459@16859L1168,447@16378L1649:StickerManagerPage.kt#is795o");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            onStickerAction = function1;
        } else if (($changed & 384) == 0) {
            onStickerAction = function1;
            $dirty2 |= $composer2.changedInstance(onStickerAction) ? 256 : 128;
        } else {
            onStickerAction = function1;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1225675833, "CC(remember):StickerManagerPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda25
                        public final Object invoke(Object obj) {
                            Unit StickerEditContent$lambda$0$0;
                            StickerEditContent$lambda$0$0 = StickerManagerPageKt.StickerEditContent$lambda$0$0((StickerAction) obj);
                            return StickerEditContent$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onStickerAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStickerAction2 = onStickerAction;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(153230551, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerEditContent (StickerManagerPage.kt:445)");
            }
            final State goEdit = SnapshotStateKt.rememberUpdatedState(function0, $composer2, ($dirty2 >> 9) & 14);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            GridCells fixed = new GridCells.Fixed(4);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(3), Dp.constructor-impl(4), Dp.constructor-impl(3), WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer2, 6), $composer2, 0).calculateBottomPadding-D9Ej5fM());
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
            Modifier modifier5 = modifier4;
            GridCells gridCells = fixed;
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
            Arrangement.Horizontal horizontal2 = horizontal;
            ComposerKt.sourceInformationMarkerStart($composer2, 1225695399, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changed(goEdit) | (($dirty2 & 896) == 256);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
            }
            Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj) {
                    Unit StickerEditContent$lambda$1$0;
                    StickerEditContent$lambda$1$0 = StickerManagerPageKt.StickerEditContent$lambda$1$0(StickerManagerData.this, goEdit, onStickerAction2, (LazyGridScope) obj);
                    return StickerEditContent$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyGridDslKt.LazyVerticalGrid(gridCells, fillMaxSize$default, (LazyGridState) null, paddingValues, false, vertical, horizontal2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer2, 1769472, 0, 916);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            onStickerAction = onStickerAction2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function12 = onStickerAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerEditContent$lambda$2;
                    StickerEditContent$lambda$2 = StickerManagerPageKt.StickerEditContent$lambda$2(StickerManagerData.this, modifier6, function12, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerEditContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerEditContent$lambda$1$0(final StickerManagerData $state, final State $goEdit, final Function1 $onStickerAction, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, (Function1) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1264170123, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda23
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StickerEditContent$lambda$1$0$0;
                StickerEditContent$lambda$1$0$0 = StickerManagerPageKt.StickerEditContent$lambda$1$0$0(StickerManagerData.this, $goEdit, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StickerEditContent$lambda$1$0$0;
            }
        }), 7, (Object) null);
        final List items$iv = $state.getStickerList();
        final Function1 key$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda24
            public final Object invoke(Object obj) {
                Object StickerEditContent$lambda$1$0$1;
                StickerEditContent$lambda$1$0$1 = StickerManagerPageKt.StickerEditContent$lambda$1$0$1((StickerAsset) obj);
                return StickerEditContent$lambda$1$0$1;
            }
        };
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerEditContent$lambda$1$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1688invoke((StickerAsset) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1688invoke(StickerAsset stickerAsset) {
                return null;
            }
        };
        $this$LazyVerticalGrid.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerEditContent$lambda$1$0$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(items$iv.get(index));
            }
        }, (Function2) null, new Function1<Integer, Object>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerEditContent$lambda$1$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerEditContent$lambda$1$0$$inlined$items$default$5
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyGridItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117249557, $dirty, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                int $changed2 = $dirty & 14;
                StickerAsset sticker = (StickerAsset) items$iv.get(it);
                $composer.startReplaceGroup(-2110302682);
                ComposerKt.sourceInformation($composer, "CN(sticker)*482@17592L419:StickerManagerPage.kt#is795o");
                Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                boolean isEditMode = $state.isEditMode();
                Integer valueOf = Integer.valueOf(CollectionsKt.indexOf($state.getSelectedStickersToDelete(), sticker));
                StickerManagerPageKt.StickerManagerGridListItem(sticker, aspectRatio$default, isEditMode, valueOf.intValue() >= 0 ? valueOf : null, $onStickerAction, $composer, (($changed2 >> 3) & 14) | 48, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerEditContent$lambda$1$0$0(StickerManagerData $state, final State $goEdit, LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C472@17369L70,461@16888L566:StickerManagerPage.kt#is795o");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1264170123, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerEditContent.<anonymous>.<anonymous>.<anonymous> (StickerManagerPage.kt:461)");
            }
            Modifier modifier = GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), 0.0f, 0.0f, $state.isEditMode() ? 0.4f : 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524283, (Object) null);
            boolean z = !$state.isEditMode();
            ComposerKt.sourceInformationMarkerStart($composer, -608240655, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($goEdit);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit StickerEditContent$lambda$1$0$0$0$0;
                        StickerEditContent$lambda$1$0$0$0$0 = StickerManagerPageKt.StickerEditContent$lambda$1$0$0$0$0($goEdit);
                        return StickerEditContent$lambda$1$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StickerKt.m1638AddStickerButtoniJQMabo(ClickableKt.clickable-oSLSa3U$default(modifier, z, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), 0L, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerEditContent$lambda$1$0$0$0$0(State $goEdit) {
        ((Function0) $goEdit.getValue()).invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StickerEditContent$lambda$1$0$1(StickerAsset it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getIdentifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerGridListItem$lambda$0$0(StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x021e, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StickerManagerGridListItem(final StickerAsset stickerAsset, Modifier modifier, boolean showCheckBox, Integer selectedIndex, Function1<? super StickerAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Integer selectedIndex2;
        final Function1 onStickerAction;
        Modifier modifier3;
        boolean showCheckBox2;
        Function1 onStickerAction2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        final Integer selectedIndex3;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-84126682);
        ComposerKt.sourceInformation($composer2, "C(StickerManagerGridListItem)N(stickerAsset,modifier,showCheckBox,selectedIndex,onStickerAction)502@18263L3,504@18276L2466:StickerManagerPage.kt#is795o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(stickerAsset) ? 4 : 2;
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
            z = showCheckBox;
        } else if (($changed & 384) == 0) {
            z = showCheckBox;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = showCheckBox;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            selectedIndex2 = selectedIndex;
        } else if (($changed & 3072) == 0) {
            selectedIndex2 = selectedIndex;
            $dirty |= $composer2.changed(selectedIndex2) ? 2048 : 1024;
        } else {
            selectedIndex2 = selectedIndex;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            onStickerAction = function1;
        } else if (($changed & 24576) == 0) {
            onStickerAction = function1;
            $dirty |= $composer2.changedInstance(onStickerAction) ? 16384 : 8192;
        } else {
            onStickerAction = function1;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            boolean showCheckBox3 = i3 != 0 ? true : z;
            if (i4 != 0) {
                selectedIndex2 = null;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 758644009, "CC(remember):StickerManagerPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            Unit StickerManagerGridListItem$lambda$0$0;
                            StickerManagerGridListItem$lambda$0$0 = StickerManagerPageKt.StickerManagerGridListItem$lambda$0$0((StickerAction) obj);
                            return StickerManagerGridListItem$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStickerAction3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onStickerAction = onStickerAction3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-84126682, $dirty2, -1, "kntr.app.im.chat.sticker.manage.StickerManagerGridListItem (StickerManagerPage.kt:503)");
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Integer selectedIndex4 = selectedIndex2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$StickerManagerGridListItem_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1006538358, "C506@18336L117,551@20257L479:StickerManagerPage.kt#is795o");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(stickerAsset.getClass());
            ComposerKt.sourceInformationMarkerStart($composer2, 383171509, "CC(remember):StickerManagerPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(orCreateKotlinClass);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            AssetShowerHolder this_$iv = AssetEntry.INSTANCE.getShower();
            Object value$iv2 = this_$iv.getShowerForAssetType(Reflection.getOrCreateKotlinClass(StickerAsset.class));
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            AssetShower shower = (AssetShower) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (shower == null) {
                $composer2.startReplaceGroup(-1006453513);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(383175754);
                ComposerKt.sourceInformation($composer2, "509@18470L74");
                shower.Content(stickerAsset, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), false, $composer2, ($dirty2 & 14) | 432);
                $composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            if (showCheckBox3) {
                $composer2.startReplaceGroup(-1006278672);
                ComposerKt.sourceInformation($composer2, "523@19133L195,513@18611L1626");
                showCheckBox2 = showCheckBox3;
                $composer$iv$iv$iv = $composer2;
                Modifier modifier5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(BorderKt.border-xT4_qwU(PaddingKt.padding-qDBjuR0(ZIndexModifierKt.zIndex($this$StickerManagerGridListItem_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), Alignment.Companion.getTopEnd()), 3.0f), Dp.constructor-impl(13), Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(13)), Dp.constructor-impl(1), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape()), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.26f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 383197091, "CC(remember):StickerManagerPage.kt#9igjgp");
                boolean invalid$iv2 = ((57344 & $dirty2) == 16384) | $composer2.changedInstance(stickerAsset);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            Unit StickerManagerGridListItem$lambda$1$1$0;
                            StickerManagerGridListItem$lambda$1$1$0 = StickerManagerPageKt.StickerManagerGridListItem$lambda$1$1$0(onStickerAction, stickerAsset);
                            return StickerManagerGridListItem$lambda$1$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                onStickerAction2 = onStickerAction;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i9 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -291664185, "C533@19583L640,529@19362L861:StickerManagerPage.kt#is795o");
                selectedIndex3 = selectedIndex4;
                AnimatedVisibilityKt.AnimatedVisibility(selectedIndex4 != null, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(1521294087, true, new Function3() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda28
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit StickerManagerGridListItem$lambda$1$2$0;
                        StickerManagerGridListItem$lambda$1$2$0 = StickerManagerPageKt.StickerManagerGridListItem$lambda$1$2$0(selectedIndex3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return StickerManagerGridListItem$lambda$1$2$0;
                    }
                }, $composer2, 54), $composer2, 200064, 18);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                showCheckBox2 = showCheckBox3;
                $composer$iv$iv$iv = $composer2;
                onStickerAction2 = onStickerAction;
                selectedIndex3 = selectedIndex4;
                $composer2.startReplaceGroup(-1024779038);
            }
            $composer2.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(selectedIndex3 != null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableSingletons$StickerManagerPageKt.INSTANCE.m1660getLambda$1912151288$sticker_debug(), $composer2, 200112, 16);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selectedIndex2 = selectedIndex3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showCheckBox2 = z;
            onStickerAction2 = onStickerAction;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = showCheckBox2;
            final Integer num = selectedIndex2;
            final Function1 function12 = onStickerAction2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerManagerGridListItem$lambda$2;
                    StickerManagerGridListItem$lambda$2 = StickerManagerPageKt.StickerManagerGridListItem$lambda$2(StickerAsset.this, modifier6, z2, num, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerManagerGridListItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerGridListItem$lambda$1$1$0(Function1 $onStickerAction, StickerAsset $stickerAsset) {
        $onStickerAction.invoke(new StickerAction.SelectStickerOrUnSelectToDelete($stickerAsset));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerManagerGridListItem$lambda$1$2$0(Integer $selectedIndex, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C538@19783L6,534@19605L600:StickerManagerPage.kt#is795o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1521294087, $changed, -1, "kntr.app.im.chat.sticker.manage.StickerManagerGridListItem.<anonymous>.<anonymous>.<anonymous> (StickerManagerPage.kt:534)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & 112;
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
        int i2 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 766115507, "C543@20038L9,544@20139L6,541@19912L271:StickerManagerPage.kt#is795o");
        TextKt.Text-Nvy7gAk(String.valueOf(($selectedIndex != null ? $selectedIndex.intValue() : 0) + 1), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnit.Companion.getUnspecified-XSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646143, (Object) null), $composer, 0, 0, 131066);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}