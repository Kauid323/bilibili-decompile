package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.emoticon.Emote;
import com.bilibili.emoticon.EmoticonPanelKt;
import com.bilibili.emoticon.EmoticonPanelParams;
import im.base.IMLog;
import im.base.model.SessionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.im.chat.stateMachine.builder.DispatchAphroAction;
import kntr.app.im.chat.sticker.StickerState;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kntr.common.komponent.UiComposableLike;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AssetItemState;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.aphro.ui.MediaSelectFloatKt;
import kntr.common.photonic.aphro.ui.component.AlbumListKt;
import kntr.common.photonic.aphro.ui.component.MediaListKt;
import kntr.common.photonic.aphro.ui.component.MediaSelectContentKt;
import kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAssetKt;
import kntr.common.photonic.camera.CameraCaptureLauncher;
import kntr.common.photonic.camera.CameraCaptureResultStatus;
import kntr.common.photonic.camera.RequestCamera_androidKt;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.BPermissionType;
import kntr.common.photonic.permission.PermissionState_androidKt;
import kntr.common.photonic.permission.PermissionStatus;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH\u0001¢\u0006\u0002\u0010\u001a\u001a\u007f\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u000f2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010 \u001aO\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\f\u001a\u00020\r2\n\u0010$\u001a\u00060%j\u0002`&H\u0003¢\u0006\u0002\u0010'\u001a¿\u0001\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u00010\t2&\b\u0002\u00103\u001a \u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020807\u0012\u0004\u0012\u00020\u0001042\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010:\u001a\u0017\u0010;\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010<¨\u0006=²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\u0016\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u000fX\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"ChatBottomSheet", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "inputBoxSelectState", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "showSelectIndex", RoomRecommendViewModel.EMPTY_CURSOR, "onEmoticonItemClick", "Lkotlin/Function1;", "Lcom/bilibili/emoticon/Emote;", "onCollectStickerClick", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "onEmoticonBackSpaceClick", "onStickerManagerAction", "Lkntr/app/im/chat/sticker/model/StickerAction;", "state", "Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;", "peekHeight", "Landroidx/compose/ui/unit/Dp;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/model/InputBoxSelectState;Lkntr/app/im/chat/ui/ChatActionHandler;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "EmoticonContent", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "progress", RoomRecommendViewModel.EMPTY_CURSOR, "(JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PictureContent", "aphroState", "Lkntr/common/photonic/aphro/core/AphroState;", "platformContext", "Landroid/app/Activity;", "Lkntr/common/photonic/permission/PlatformContext;", "(Lkntr/common/photonic/aphro/core/AphroState;Lkntr/app/im/chat/ui/ChatActionHandler;Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;FLkotlin/jvm/functions/Function0;ZLandroid/app/Activity;Landroidx/compose/runtime/Composer;I)V", "PictureSelectContent", "albums", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "permissionState", "Lkntr/common/photonic/permission/BPermissionState;", "albumExpanded", "onAlbumExpandChange", "onAction", "Lkntr/common/photonic/aphro/core/AphroAction;", "onBackButtonClick", "onClickSelectMore", "onAssetItemClick", "Lkotlin/Function3;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/common/photonic/aphro/core/AssetItemState;", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/unit/IntRect;", "onShootPictureClick", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;FLkntr/common/photonic/permission/BPermissionState;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "MediaSelectShootPictureContent", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "onStickerManagerActionEffect"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBottomSheet$lambda$9(SessionId sessionId, InputBoxSelectState inputBoxSelectState, ChatActionHandler chatActionHandler, Function0 function0, Modifier modifier, boolean z, Function1 function1, Function1 function12, Function0 function02, Function1 function13, ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState, Function0 function03, int i, int i2, int i3, Composer composer, int i4) {
        ChatBottomSheet(sessionId, inputBoxSelectState, chatActionHandler, function0, modifier, z, function1, function12, function02, function13, chatMediaSelectBottomSheetState, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmoticonContent$lambda$11(long j2, Function0 function0, Modifier modifier, Function1 function1, Function0 function02, Function1 function12, Function1 function13, int i, int i2, Composer composer, int i3) {
        EmoticonContent(j2, function0, modifier, function1, function02, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectShootPictureContent$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        MediaSelectShootPictureContent(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$11(AphroState aphroState, ChatActionHandler chatActionHandler, ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState, float f, Function0 function0, boolean z, Activity activity, int i, Composer composer, int i2) {
        PictureContent(aphroState, chatActionHandler, chatMediaSelectBottomSheetState, f, function0, z, activity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$5(AphroState.AphroContent aphroContent, float f, BPermissionState bPermissionState, boolean z, Function1 function1, Function1 function12, boolean z2, Modifier modifier, Function0 function0, Function0 function02, Function3 function3, Function0 function03, int i, int i2, int i3, Composer composer, int i4) {
        PictureSelectContent(aphroContent, f, bPermissionState, z, function1, function12, z2, modifier, function0, function02, function3, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBottomSheet$lambda$0$0(Emote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBottomSheet$lambda$1$0(StickerAsset it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBottomSheet$lambda$3$0(StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp ChatBottomSheet$lambda$4$0() {
        return Dp.box-impl(ChatMediaSelectBottomSheetDefaults.INSTANCE.m1919getPeekHeightD9Ej5fM());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v9 */
    public static final void ChatBottomSheet(final SessionId sessionId, final InputBoxSelectState inputBoxSelectState, final ChatActionHandler actionHandler, final Function0<Unit> function0, Modifier modifier, boolean showSelectIndex, Function1<? super Emote, Unit> function1, Function1<? super StickerAsset, Unit> function12, Function0<Unit> function02, Function1<? super StickerAction, Unit> function13, ChatMediaSelectBottomSheetState state, Function0<Dp> function03, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        boolean showSelectIndex2;
        Function1 onEmoticonItemClick;
        Function1 onCollectStickerClick;
        Function0 onEmoticonBackSpaceClick;
        Function1 onStickerManagerAction;
        ChatMediaSelectBottomSheetState state2;
        Function0 peekHeight;
        boolean showSelectIndex3;
        Function1 onEmoticonItemClick2;
        Function1 onEmoticonItemClick3;
        Function1 onCollectStickerClick2;
        Function0 onEmoticonBackSpaceClick2;
        Function0 onEmoticonBackSpaceClick3;
        Function1 onStickerManagerAction2;
        ChatMediaSelectBottomSheetState state3;
        boolean showSelectIndex4;
        int $dirty1;
        final ChatMediaSelectBottomSheetState state4;
        Object it$iv;
        int i2;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(inputBoxSelectState, "inputBoxSelectState");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(1969111380);
        ComposerKt.sourceInformation($composer3, "C(ChatBottomSheet)N(sessionId,inputBoxSelectState,actionHandler,onDismissRequest,modifier,showSelectIndex,onEmoticonItemClick,onCollectStickerClick,onEmoticonBackSpaceClick,onStickerManagerAction,state,peekHeight)94@4478L24,96@4524L339,109@4891L20,116@5100L30,119@5138L2527,111@4917L2748:ChatBottomSheet.kt#92mklk");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(sessionId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(inputBoxSelectState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(actionHandler) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(modifier) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changed(showSelectIndex) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 67108864 : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function13) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            if ((i & 1024) == 0 && $composer3.changed(state)) {
                i2 = 4;
                $dirty12 |= i2;
            }
            i2 = 2;
            $dirty12 |= i2;
        }
        int i9 = i & 2048;
        if (i9 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty12 |= $composer3.changedInstance(function03) ? 32 : 16;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty12 & 19) == 18) ? false : true, $dirty & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "87@4126L2,88@4182L2,89@4229L2,90@4287L3,91@4337L41,92@4407L49");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier;
                boolean showSelectIndex5 = i4 != 0 ? true : showSelectIndex;
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -1764532394, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    modifier2 = modifier3;
                    Object it$iv2 = $composer3.rememberedValue();
                    showSelectIndex3 = showSelectIndex5;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj) {
                                Unit ChatBottomSheet$lambda$0$0;
                                ChatBottomSheet$lambda$0$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$0$0((Emote) obj);
                                return ChatBottomSheet$lambda$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    } else {
                        it$iv = it$iv2;
                    }
                    onEmoticonItemClick2 = (Function1) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    modifier2 = modifier3;
                    showSelectIndex3 = showSelectIndex5;
                    onEmoticonItemClick2 = function1;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -1764530602, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    onEmoticonItemClick3 = onEmoticonItemClick2;
                    Object it$iv3 = $composer3.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                Unit ChatBottomSheet$lambda$1$0;
                                ChatBottomSheet$lambda$1$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$1$0((StickerAsset) obj);
                                return ChatBottomSheet$lambda$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv3 = value$iv2;
                    }
                    onCollectStickerClick2 = (Function1) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onEmoticonItemClick3 = onEmoticonItemClick2;
                    onCollectStickerClick2 = function12;
                }
                if (i7 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -1764529098, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    Object it$iv4 = $composer3.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv4 = value$iv3;
                    }
                    onEmoticonBackSpaceClick2 = it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onEmoticonBackSpaceClick2 = function02;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -1764527241, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    Object it$iv5 = $composer3.rememberedValue();
                    onEmoticonBackSpaceClick3 = onEmoticonBackSpaceClick2;
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                Unit ChatBottomSheet$lambda$3$0;
                                ChatBottomSheet$lambda$3$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$3$0((StickerAction) obj);
                                return ChatBottomSheet$lambda$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv5 = value$iv4;
                    }
                    onStickerManagerAction2 = it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onEmoticonBackSpaceClick3 = onEmoticonBackSpaceClick2;
                    onStickerManagerAction2 = function13;
                }
                if ((i & 1024) != 0) {
                    state3 = ChatMediaSelectBottomSheetKt.rememberChatMediaSelectBottomSheetState(null, false, $composer3, 0, 3);
                    $dirty12 &= -15;
                } else {
                    state3 = state;
                }
                if (i9 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -1764523355, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    Object it$iv6 = $composer3.rememberedValue();
                    Function1 onStickerManagerAction3 = onStickerManagerAction2;
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Dp ChatBottomSheet$lambda$4$0;
                                ChatBottomSheet$lambda$4$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$4$0();
                                return ChatBottomSheet$lambda$4$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv6 = value$iv5;
                    }
                    Function0 peekHeight2 = it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    onEmoticonItemClick = onEmoticonItemClick3;
                    showSelectIndex4 = showSelectIndex3;
                    onEmoticonBackSpaceClick = onEmoticonBackSpaceClick3;
                    onStickerManagerAction = onStickerManagerAction3;
                    peekHeight = peekHeight2;
                    $dirty1 = $dirty12;
                    onCollectStickerClick = onCollectStickerClick2;
                    state4 = state3;
                } else {
                    onEmoticonItemClick = onEmoticonItemClick3;
                    showSelectIndex4 = showSelectIndex3;
                    onEmoticonBackSpaceClick = onEmoticonBackSpaceClick3;
                    onStickerManagerAction = onStickerManagerAction2;
                    peekHeight = function03;
                    $dirty1 = $dirty12;
                    onCollectStickerClick = onCollectStickerClick2;
                    state4 = state3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                }
                modifier2 = modifier;
                showSelectIndex4 = showSelectIndex;
                onEmoticonItemClick = function1;
                onCollectStickerClick = function12;
                onEmoticonBackSpaceClick = function02;
                onStickerManagerAction = function13;
                state4 = state;
                peekHeight = function03;
                $dirty1 = $dirty12;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1969111380, $dirty, $dirty1, "kntr.app.im.chat.ui.widget.ChatBottomSheet (ChatBottomSheet.kt:93)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            int $dirty2 = $dirty;
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1764519321, "CC(remember):ChatBottomSheet.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        float ChatBottomSheet$lambda$5$0;
                        ChatBottomSheet$lambda$5$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$5$0(ChatMediaSelectBottomSheetState.this);
                        return Float.valueOf(ChatBottomSheet$lambda$5$0);
                    }
                });
                $composer3.updateRememberedValue(value$iv6);
                it$iv7 = value$iv6;
            }
            final State progress$delegate = (State) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Activity platformContext = PlatformContext_androidKt.getPlatformContext($composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1764501198, "CC(remember):ChatBottomSheet.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Dp ChatBottomSheet$lambda$7$0;
                        ChatBottomSheet$lambda$7$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$7$0();
                        return ChatBottomSheet$lambda$7$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv7);
                it$iv8 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState = state4;
            int $dirty13 = $dirty1;
            final boolean z = showSelectIndex4;
            state2 = state4;
            showSelectIndex2 = showSelectIndex4;
            $composer2 = $composer3;
            final Function1 function14 = onEmoticonItemClick;
            final Function0 function04 = onEmoticonBackSpaceClick;
            final Function1 function15 = onCollectStickerClick;
            final Function1 function16 = onStickerManagerAction;
            ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet(modifier2, state2, function0, peekHeight, (Function0) it$iv8, ComposableLambdaKt.rememberComposableLambda(88151094, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatBottomSheet$lambda$8;
                    ChatBottomSheet$lambda$8 = ChatBottomSheetKt.ChatBottomSheet$lambda$8(scope, chatMediaSelectBottomSheetState, inputBoxSelectState, actionHandler, function0, z, platformContext, sessionId, function14, function04, function15, function16, progress$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatBottomSheet$lambda$8;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 12) & 14) | 221184 | (($dirty13 << 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty13 << 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            showSelectIndex2 = showSelectIndex;
            onEmoticonItemClick = function1;
            onCollectStickerClick = function12;
            onEmoticonBackSpaceClick = function02;
            onStickerManagerAction = function13;
            state2 = state;
            peekHeight = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z2 = showSelectIndex2;
            final Function1 function17 = onEmoticonItemClick;
            final Function1 function18 = onCollectStickerClick;
            final Function0 function05 = onEmoticonBackSpaceClick;
            final Function1 function19 = onStickerManagerAction;
            final ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState2 = state2;
            final Function0 function06 = peekHeight;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatBottomSheet$lambda$9;
                    ChatBottomSheet$lambda$9 = ChatBottomSheetKt.ChatBottomSheet$lambda$9(sessionId, inputBoxSelectState, actionHandler, function0, modifier4, z2, function17, function18, function05, function19, chatMediaSelectBottomSheetState2, function06, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatBottomSheet$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ChatBottomSheet$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ChatBottomSheet$lambda$5$0(ChatMediaSelectBottomSheetState $state) {
        if ($state.isEnableExpand()) {
            return $state.getAnchoredDraggableState$ui_debug().progress(ChatMediaSelectSheetState.PartiallyExpanded, ChatMediaSelectSheetState.Expanded);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp ChatBottomSheet$lambda$7$0() {
        return Dp.box-impl(Dp.constructor-impl(151));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01ac, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ChatBottomSheet$lambda$8(final CoroutineScope $scope, final ChatMediaSelectBottomSheetState $state, InputBoxSelectState $inputBoxSelectState, ChatActionHandler $actionHandler, Function0 $onDismissRequest, boolean $showSelectIndex, Activity $platformContext, SessionId $sessionId, Function1 $onEmoticonItemClick, Function0 $onEmoticonBackSpaceClick, Function1 $onCollectStickerClick, Function1 $onStickerManagerAction, final State $progress$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        Composer $composer2;
        ComposerKt.sourceInformation($composer, "C120@5148L2511:ChatBottomSheet.kt#92mklk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(88151094, $changed, -1, "kntr.app.im.chat.ui.widget.ChatBottomSheet.<anonymous> (ChatBottomSheet.kt:120)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 10918797, "C132@5516L763,148@6325L6,130@5426L924:ChatBottomSheet.kt#92mklk");
            if (ChatBottomSheet$lambda$6($progress$delegate) == 0.0f) {
                $composer.startReplaceGroup(10885533);
                ComposerKt.sourceInformation($composer, "125@5322L6,124@5265L133");
                $composer$iv = $composer;
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_light-0d7_KjU(), $composer, 48, 1);
            } else {
                $composer$iv = $composer;
                $composer.startReplaceGroup(5657538);
            }
            $composer.endReplaceGroup();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1246566181, "CC(remember):ChatBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($state);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda31
                public final Object invoke() {
                    Unit ChatBottomSheet$lambda$8$0$0$0;
                    ChatBottomSheet$lambda$8$0$0$0 = ChatBottomSheetKt.ChatBottomSheet$lambda$8$0$0$0($scope, $state);
                    return ChatBottomSheet$lambda$8$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ChatMediaSelectBottomSheetKt.m1925ChatMediaSelectPullBarRIQooxk(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), 0L, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg3-0d7_KjU(), $composer, 0, 2);
            if ($inputBoxSelectState instanceof InputBoxSelectState.Gallery) {
                $composer.startReplaceGroup(12084954);
                ComposerKt.sourceInformation($composer, "153@6465L424");
                $composer$iv$iv$iv = $composer;
                $composer$iv2 = $composer$iv;
                $composer$iv$iv = $composer;
                PictureContent(((InputBoxSelectState.Gallery) $inputBoxSelectState).getAphroState(), $actionHandler, $state, ChatBottomSheet$lambda$6($progress$delegate), $onDismissRequest, $showSelectIndex, $platformContext, $composer, 0);
                $composer.endReplaceGroup();
                $composer2 = $composer;
            } else {
                $composer$iv$iv = $composer;
                $composer$iv$iv$iv = $composer;
                $composer$iv2 = $composer$iv;
                if (Intrinsics.areEqual($inputBoxSelectState, InputBoxSelectState.EMOJI.INSTANCE)) {
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(12576614);
                    ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                    if ($sessionId instanceof PersonalChat) {
                        $composer2.startReplaceGroup(12651293);
                        ComposerKt.sourceInformation($composer2, "172@7434L12,166@7033L517");
                        long talkerUid = ((PersonalChat) $sessionId).getTalkerUid();
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer2, -1246505556, "CC(remember):ChatBottomSheet.kt#9igjgp");
                        Object it$iv2 = $composer2.rememberedValue();
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda33
                                public final Object invoke() {
                                    float ChatBottomSheet$lambda$6;
                                    ChatBottomSheet$lambda$6 = ChatBottomSheetKt.ChatBottomSheet$lambda$6($progress$delegate);
                                    return Float.valueOf(ChatBottomSheet$lambda$6);
                                }
                            };
                            $composer2.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EmoticonContent(talkerUid, (Function0) it$iv2, fillMaxSize$default, $onEmoticonItemClick, $onEmoticonBackSpaceClick, $onCollectStickerClick, $onStickerManagerAction, $composer2, 432, 0);
                    } else {
                        $composer2.startReplaceGroup(5657538);
                    }
                    $composer2.endReplaceGroup();
                    $composer2.endReplaceGroup();
                } else {
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(13214191);
                    $composer2.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBottomSheet$lambda$8$0$0$0(CoroutineScope $scope, ChatMediaSelectBottomSheetState $state) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBottomSheetKt$ChatBottomSheet$7$1$1$1$1($state, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmoticonContent$lambda$0$0(Emote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmoticonContent$lambda$2$0(StickerAsset it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmoticonContent$lambda$3$0(StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0472  */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void EmoticonContent(final long mid, final Function0<Float> function0, Modifier modifier, Function1<? super Emote, Unit> function1, Function0<Unit> function02, Function1<? super StickerAsset, Unit> function12, Function1<? super StickerAction, Unit> function13, Composer $composer, final int $changed, final int i) {
        Function1 onEmoticonItemClick;
        Function0 onEmoticonBackSpaceClick;
        Function1<? super StickerAsset, Unit> function14;
        int $dirty;
        Modifier modifier2;
        Function1 onStickerManagerAction;
        Function1 onEmoticonItemClick2;
        Function0 onEmoticonBackSpaceClick2;
        Function1<? super StickerAsset, Unit> function15;
        Modifier modifier3;
        Function1 onStickerManagerAction2;
        Object value$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        Object it$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(332332067);
        ComposerKt.sourceInformation($composer2, "C(EmoticonContent)N(mid,progress,modifier,onEmoticonItemClick,onEmoticonBackSpaceClick,onCollectStickerClick,onStickerManagerAction)190@7830L2,191@7877L2,192@7933L2,193@7991L3,195@8023L43,196@8092L30,198@8171L44,200@8240L47,204@8314L113,204@8293L134,210@8455L90,210@8433L112,215@8572L118,215@8550L140,221@8716L380,231@9101L238:ChatBottomSheet.kt#92mklk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(mid) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            onEmoticonItemClick = function1;
        } else if (($changed & 3072) == 0) {
            onEmoticonItemClick = function1;
            $dirty2 |= $composer2.changedInstance(onEmoticonItemClick) ? 2048 : 1024;
        } else {
            onEmoticonItemClick = function1;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            onEmoticonBackSpaceClick = function02;
        } else if (($changed & 24576) == 0) {
            onEmoticonBackSpaceClick = function02;
            $dirty2 |= $composer2.changedInstance(onEmoticonBackSpaceClick) ? 16384 : 8192;
        } else {
            onEmoticonBackSpaceClick = function02;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
            function14 = function12;
        } else if ((196608 & $changed) == 0) {
            function14 = function12;
            $dirty2 |= $composer2.changedInstance(function14) ? 131072 : 65536;
        } else {
            function14 = function12;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function13) ? 1048576 : 524288;
        }
        if (!$composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onStickerManagerAction = function13;
            onEmoticonItemClick2 = onEmoticonItemClick;
            onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
            function15 = function14;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1543540997, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda25
                        public final Object invoke(Object obj) {
                            Unit EmoticonContent$lambda$0$0;
                            EmoticonContent$lambda$0$0 = ChatBottomSheetKt.EmoticonContent$lambda$0$0((Emote) obj);
                            return EmoticonContent$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onEmoticonItemClick3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onEmoticonItemClick = onEmoticonItemClick3;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1543542501, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda26
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function0 onEmoticonBackSpaceClick3 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onEmoticonBackSpaceClick = onEmoticonBackSpaceClick3;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1543544293, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda27
                        public final Object invoke(Object obj) {
                            Unit EmoticonContent$lambda$2$0;
                            EmoticonContent$lambda$2$0 = ChatBottomSheetKt.EmoticonContent$lambda$2$0((StickerAsset) obj);
                            return EmoticonContent$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                function14 = it$iv4;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1543546150, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda28
                        public final Object invoke(Object obj) {
                            Unit EmoticonContent$lambda$3$0;
                            EmoticonContent$lambda$3$0 = ChatBottomSheetKt.EmoticonContent$lambda$3$0((StickerAction) obj);
                            return EmoticonContent$lambda$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                onStickerManagerAction2 = it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStickerManagerAction2 = function13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332332067, $dirty2, -1, "kntr.app.im.chat.ui.widget.EmoticonContent (ChatBottomSheet.kt:194)");
            }
            State stickerClick = SnapshotStateKt.rememberUpdatedState(function14, $composer2, ($dirty2 >> 15) & 14);
            State progressUpdate = SnapshotStateKt.rememberUpdatedState(function0, $composer2, ($dirty2 >> 3) & 14);
            State onStickerManagerActionEffect$delegate = SnapshotStateKt.rememberUpdatedState(onStickerManagerAction2, $composer2, ($dirty2 >> 18) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1543554162, "CC(remember):ChatBottomSheet.kt#9igjgp");
            onStickerManagerAction = onStickerManagerAction2;
            Object value$iv6 = $composer2.rememberedValue();
            Function1<? super StickerAsset, Unit> function16 = function14;
            if (value$iv6 == Composer.Companion.getEmpty()) {
                value$iv6 = new StickerState(null, 1, null);
                $composer2.updateRememberedValue(value$iv6);
            }
            StickerState state = (StickerState) value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1543556596, "CC(remember):ChatBottomSheet.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(progressUpdate);
            Object it$iv6 = $composer2.rememberedValue();
            if (!invalid$iv4 && it$iv6 != Composer.Companion.getEmpty()) {
                value$iv = it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 1543561085, "CC(remember):ChatBottomSheet.kt#9igjgp");
                invalid$iv = $composer2.changed(stickerClick);
                Object it$iv7 = $composer2.rememberedValue();
                if (!invalid$iv && it$iv7 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(state, (Function2) it$iv7, $composer2, 6);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1543564857, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    invalid$iv2 = $composer2.changed(onStickerManagerActionEffect$delegate);
                    Object it$iv8 = $composer2.rememberedValue();
                    if (!invalid$iv2 && it$iv8 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(state, (Function2) it$iv8, $composer2, 6);
                        ComposerKt.sourceInformationMarkerStart($composer2, 1543569727, "CC(remember):ChatBottomSheet.kt#9igjgp");
                        invalid$iv3 = ($dirty2 & 14) != 4;
                        it$iv = $composer2.rememberedValue();
                        if (!invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv7 = new EmoticonPanelParams("im", Long.valueOf(mid), (Long) null, onEmoticonBackSpaceClick, onEmoticonItemClick, new ChatStickerCollection(state));
                            $composer2.updateRememberedValue(value$iv7);
                            it$iv = value$iv7;
                        }
                        EmoticonPanelParams params = (EmoticonPanelParams) it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        int $changed$iv = ($dirty2 >> 6) & 14;
                        Modifier modifier$iv = modifier3;
                        $dirty = $dirty2;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = ($changed$iv << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                        onEmoticonItemClick2 = onEmoticonItemClick;
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if (!$composer2.getInserting()) {
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
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i8 = (($changed$iv >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 558520196, "C235@9187L62,238@9258L75:ChatBottomSheet.kt#92mklk");
                        UiComposableLike emoticonComponent = EmoticonPanelKt.rememberEmoticonPanelUi(params, $composer2, EmoticonPanelParams.$stable);
                        emoticonComponent.invoke(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), $composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function15 = function16;
                        modifier2 = modifier3;
                    }
                    Object value$iv8 = (Function2) new ChatBottomSheetKt$EmoticonContent$7$1(state, onStickerManagerActionEffect$delegate, null);
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(state, (Function2) it$iv8, $composer2, 6);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1543569727, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    if (($dirty2 & 14) != 4) {
                    }
                    it$iv = $composer2.rememberedValue();
                    if (!invalid$iv3) {
                    }
                    Object value$iv72 = new EmoticonPanelParams("im", Long.valueOf(mid), (Long) null, onEmoticonBackSpaceClick, onEmoticonItemClick, new ChatStickerCollection(state));
                    $composer2.updateRememberedValue(value$iv72);
                    it$iv = value$iv72;
                    EmoticonPanelParams params2 = (EmoticonPanelParams) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv2 = ($dirty2 >> 6) & 14;
                    Modifier modifier$iv2 = modifier3;
                    $dirty = $dirty2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv2 = ($changed$iv2 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                    onEmoticonItemClick2 = onEmoticonItemClick;
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                    }
                    $composer2.startReusableNode();
                    if (!$composer2.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i72 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i82 = (($changed$iv2 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 558520196, "C235@9187L62,238@9258L75:ChatBottomSheet.kt#92mklk");
                    UiComposableLike emoticonComponent2 = EmoticonPanelKt.rememberEmoticonPanelUi(params2, $composer2, EmoticonPanelParams.$stable);
                    emoticonComponent2.invoke(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), $composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function15 = function16;
                    modifier2 = modifier3;
                }
                Object value$iv9 = (Function2) new ChatBottomSheetKt$EmoticonContent$6$1(state, stickerClick, null);
                $composer2.updateRememberedValue(value$iv9);
                it$iv7 = value$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(state, (Function2) it$iv7, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 1543564857, "CC(remember):ChatBottomSheet.kt#9igjgp");
                invalid$iv2 = $composer2.changed(onStickerManagerActionEffect$delegate);
                Object it$iv82 = $composer2.rememberedValue();
                if (!invalid$iv2) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(state, (Function2) it$iv82, $composer2, 6);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1543569727, "CC(remember):ChatBottomSheet.kt#9igjgp");
                    if (($dirty2 & 14) != 4) {
                    }
                    it$iv = $composer2.rememberedValue();
                    if (!invalid$iv3) {
                    }
                    Object value$iv722 = new EmoticonPanelParams("im", Long.valueOf(mid), (Long) null, onEmoticonBackSpaceClick, onEmoticonItemClick, new ChatStickerCollection(state));
                    $composer2.updateRememberedValue(value$iv722);
                    it$iv = value$iv722;
                    EmoticonPanelParams params22 = (EmoticonPanelParams) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv22 = ($dirty2 >> 6) & 14;
                    Modifier modifier$iv22 = modifier3;
                    $dirty = $dirty2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv22 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                    int $changed$iv$iv22 = ($changed$iv22 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer2.getCurrentCompositionLocalMap();
                    onEmoticonItemClick2 = onEmoticonItemClick;
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer2, modifier$iv22);
                    Function0 factory$iv$iv$iv222 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                    }
                    $composer2.startReusableNode();
                    if (!$composer2.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i722 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                    int i822 = (($changed$iv22 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 558520196, "C235@9187L62,238@9258L75:ChatBottomSheet.kt#92mklk");
                    UiComposableLike emoticonComponent22 = EmoticonPanelKt.rememberEmoticonPanelUi(params22, $composer2, EmoticonPanelParams.$stable);
                    emoticonComponent22.invoke(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), $composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function15 = function16;
                    modifier2 = modifier3;
                }
                Object value$iv82 = (Function2) new ChatBottomSheetKt$EmoticonContent$7$1(state, onStickerManagerActionEffect$delegate, null);
                $composer2.updateRememberedValue(value$iv82);
                it$iv82 = value$iv82;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(state, (Function2) it$iv82, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 1543569727, "CC(remember):ChatBottomSheet.kt#9igjgp");
                if (($dirty2 & 14) != 4) {
                }
                it$iv = $composer2.rememberedValue();
                if (!invalid$iv3) {
                }
                Object value$iv7222 = new EmoticonPanelParams("im", Long.valueOf(mid), (Long) null, onEmoticonBackSpaceClick, onEmoticonItemClick, new ChatStickerCollection(state));
                $composer2.updateRememberedValue(value$iv7222);
                it$iv = value$iv7222;
                EmoticonPanelParams params222 = (EmoticonPanelParams) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                int $changed$iv222 = ($dirty2 >> 6) & 14;
                Modifier modifier$iv222 = modifier3;
                $dirty = $dirty2;
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv222 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv222, false);
                int $changed$iv$iv222 = ($changed$iv222 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv222 = $composer2.getCurrentCompositionLocalMap();
                onEmoticonItemClick2 = onEmoticonItemClick;
                Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer2, modifier$iv222);
                Function0 factory$iv$iv$iv2222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if (!$composer2.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                int i7222 = ($changed$iv$iv$iv222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
                int i8222 = (($changed$iv222 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 558520196, "C235@9187L62,238@9258L75:ChatBottomSheet.kt#92mklk");
                UiComposableLike emoticonComponent222 = EmoticonPanelKt.rememberEmoticonPanelUi(params222, $composer2, EmoticonPanelParams.$stable);
                emoticonComponent222.invoke(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), $composer2, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                function15 = function16;
                modifier2 = modifier3;
            }
            Object obj = (Function2) new ChatBottomSheetKt$EmoticonContent$5$1(progressUpdate, state, null);
            $composer2.updateRememberedValue(obj);
            value$iv = obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1543561085, "CC(remember):ChatBottomSheet.kt#9igjgp");
            invalid$iv = $composer2.changed(stickerClick);
            Object it$iv72 = $composer2.rememberedValue();
            if (!invalid$iv) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(state, (Function2) it$iv72, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 1543564857, "CC(remember):ChatBottomSheet.kt#9igjgp");
                invalid$iv2 = $composer2.changed(onStickerManagerActionEffect$delegate);
                Object it$iv822 = $composer2.rememberedValue();
                if (!invalid$iv2) {
                }
                Object value$iv822 = (Function2) new ChatBottomSheetKt$EmoticonContent$7$1(state, onStickerManagerActionEffect$delegate, null);
                $composer2.updateRememberedValue(value$iv822);
                it$iv822 = value$iv822;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(state, (Function2) it$iv822, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 1543569727, "CC(remember):ChatBottomSheet.kt#9igjgp");
                if (($dirty2 & 14) != 4) {
                }
                it$iv = $composer2.rememberedValue();
                if (!invalid$iv3) {
                }
                Object value$iv72222 = new EmoticonPanelParams("im", Long.valueOf(mid), (Long) null, onEmoticonBackSpaceClick, onEmoticonItemClick, new ChatStickerCollection(state));
                $composer2.updateRememberedValue(value$iv72222);
                it$iv = value$iv72222;
                EmoticonPanelParams params2222 = (EmoticonPanelParams) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                int $changed$iv2222 = ($dirty2 >> 6) & 14;
                Modifier modifier$iv2222 = modifier3;
                $dirty = $dirty2;
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2222 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2222, false);
                int $changed$iv$iv2222 = ($changed$iv2222 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2222 = $composer2.getCurrentCompositionLocalMap();
                onEmoticonItemClick2 = onEmoticonItemClick;
                Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2222);
                Function0 factory$iv$iv$iv22222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
                onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if (!$composer2.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
                int i72222 = ($changed$iv$iv$iv2222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2222 = BoxScopeInstance.INSTANCE;
                int i82222 = (($changed$iv2222 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 558520196, "C235@9187L62,238@9258L75:ChatBottomSheet.kt#92mklk");
                UiComposableLike emoticonComponent2222 = EmoticonPanelKt.rememberEmoticonPanelUi(params2222, $composer2, EmoticonPanelParams.$stable);
                emoticonComponent2222.invoke(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), $composer2, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                function15 = function16;
                modifier2 = modifier3;
            }
            Object value$iv92 = (Function2) new ChatBottomSheetKt$EmoticonContent$6$1(state, stickerClick, null);
            $composer2.updateRememberedValue(value$iv92);
            it$iv72 = value$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(state, (Function2) it$iv72, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1543564857, "CC(remember):ChatBottomSheet.kt#9igjgp");
            invalid$iv2 = $composer2.changed(onStickerManagerActionEffect$delegate);
            Object it$iv8222 = $composer2.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv8222 = (Function2) new ChatBottomSheetKt$EmoticonContent$7$1(state, onStickerManagerActionEffect$delegate, null);
            $composer2.updateRememberedValue(value$iv8222);
            it$iv8222 = value$iv8222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(state, (Function2) it$iv8222, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1543569727, "CC(remember):ChatBottomSheet.kt#9igjgp");
            if (($dirty2 & 14) != 4) {
            }
            it$iv = $composer2.rememberedValue();
            if (!invalid$iv3) {
            }
            Object value$iv722222 = new EmoticonPanelParams("im", Long.valueOf(mid), (Long) null, onEmoticonBackSpaceClick, onEmoticonItemClick, new ChatStickerCollection(state));
            $composer2.updateRememberedValue(value$iv722222);
            it$iv = value$iv722222;
            EmoticonPanelParams params22222 = (EmoticonPanelParams) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv22222 = ($dirty2 >> 6) & 14;
            Modifier modifier$iv22222 = modifier3;
            $dirty = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv22222 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv22222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22222, false);
            int $changed$iv$iv22222 = ($changed$iv22222 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv22222 = $composer2.getCurrentCompositionLocalMap();
            onEmoticonItemClick2 = onEmoticonItemClick;
            Modifier materialized$iv$iv22222 = ComposedModifierKt.materializeModifier($composer2, modifier$iv22222);
            Function0 factory$iv$iv$iv222222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22222 = (($changed$iv$iv22222 << 6) & 896) | 6;
            onEmoticonBackSpaceClick2 = onEmoticonBackSpaceClick;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if (!$composer2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22222 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, measurePolicy$iv22222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, localMap$iv$iv22222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22222, Integer.valueOf(compositeKeyHash$iv$iv22222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, materialized$iv$iv22222, ComposeUiNode.Companion.getSetModifier());
            int i722222 = ($changed$iv$iv$iv22222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22222 = BoxScopeInstance.INSTANCE;
            int i822222 = (($changed$iv22222 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 558520196, "C235@9187L62,238@9258L75:ChatBottomSheet.kt#92mklk");
            UiComposableLike emoticonComponent22222 = EmoticonPanelKt.rememberEmoticonPanelUi(params22222, $composer2, EmoticonPanelParams.$stable);
            emoticonComponent22222.invoke(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            function15 = function16;
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function1 function17 = onEmoticonItemClick2;
            final Function0 function03 = onEmoticonBackSpaceClick2;
            final Function1<? super StickerAsset, Unit> function18 = function15;
            final Function1 function19 = onStickerManagerAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj2, Object obj3) {
                    Unit EmoticonContent$lambda$11;
                    EmoticonContent$lambda$11 = ChatBottomSheetKt.EmoticonContent$lambda$11(mid, function0, modifier4, function17, function03, function18, function19, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return EmoticonContent$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<StickerAction, Unit> EmoticonContent$lambda$4(State<? extends Function1<? super StickerAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x04f5, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x059b, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0628, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0672, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01f1, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x038f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x062c  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x094f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0977  */
    /* JADX WARN: Type inference failed for: r0v141 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void PictureContent(final AphroState aphroState, final ChatActionHandler actionHandler, final ChatMediaSelectBottomSheetState state, final float progress, final Function0<Unit> function0, final boolean showSelectIndex, final Activity platformContext, Composer $composer, final int $changed) {
        CameraCaptureLauncher cameraCaptureLauncher;
        int $dirty;
        int $dirty2;
        int i;
        final BPermissionState permissionState;
        String str;
        boolean invalid$iv;
        Object it$iv;
        MutableState savedPermissionStatus;
        boolean invalid$iv2;
        Object it$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer2;
        Composer $composer$iv$iv;
        MutableState savedPermissionStatus2;
        boolean invalid$iv5;
        boolean invalid$iv6;
        boolean invalid$iv7;
        int $dirty3;
        int $dirty4;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(-1465800456);
        ComposerKt.sourceInformation($composer4, "C(PictureContent)N(aphroState,actionHandler,state,progress,onDismissRequest,showSelectIndex,platformContext)254@9645L46,257@9708L24,258@9765L31,259@9830L38,262@9915L54,266@10071L20,266@10004L88,268@10199L20,268@10133L87,285@10727L277,285@10675L329,299@11145L101,303@11293L113,306@11443L204,306@11411L236,313@11690L222,313@11652L260,320@11917L7631:ChatBottomSheet.kt#92mklk");
        int $dirty5 = $changed;
        if (($changed & 6) == 0) {
            $dirty5 |= $composer4.changed(aphroState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty5 |= $composer4.changed(actionHandler) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty5 |= $composer4.changed(state) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty5 |= $composer4.changed(progress) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty5 |= $composer4.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty5 |= $composer4.changed(showSelectIndex) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty5 |= $composer4.changedInstance(platformContext) ? 1048576 : 524288;
        }
        if ($composer4.shouldExecute(($dirty5 & 599187) != 599186, $dirty5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1465800456, $dirty5, -1, "kntr.app.im.chat.ui.widget.PictureContent (ChatBottomSheet.kt:253)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, 115043942, "CC(remember):ChatBottomSheet.kt#9igjgp");
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv);
                it$iv3 = value$iv;
            }
            final MutableState albumExpanded$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer4.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            CameraCaptureLauncher cameraCaptureLauncher2 = RequestCamera_androidKt.rememberCameraCaptureLauncher($composer4, 0);
            State onDismissRequestEffect = SnapshotStateKt.rememberUpdatedState(function0, $composer4, ($dirty5 >> 12) & 14);
            ComposerKt.sourceInformationMarkerStart($composer4, 115052590, "CC(remember):ChatBottomSheet.kt#9igjgp");
            Object value$iv2 = $composer4.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv2);
            }
            final MutableState showCameraPermissionDialog = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            BPermissionState permissionState2 = PermissionState_androidKt.rememberBPermissionState(BPermissionType.GALLERY, PlatformContext_androidKt.getPlatformContext($composer4, 0), $composer4, 6);
            final BPermissionState cameraPermissionState = PermissionState_androidKt.rememberBPermissionState(BPermissionType.CAMERA, PlatformContext_androidKt.getPlatformContext($composer4, 0), $composer4, 6);
            if (aphroState instanceof AphroState.AphroContent) {
                $composer4.startReplaceGroup(-727946807);
                ComposerKt.sourceInformation($composer4, "272@10347L268,272@10310L305");
                Boolean valueOf = Boolean.valueOf(((AphroState.AphroContent) aphroState).getConfirmed());
                ComposerKt.sourceInformationMarkerStart($composer4, 115066628, "CC(remember):ChatBottomSheet.kt#9igjgp");
                cameraCaptureLauncher = cameraCaptureLauncher2;
                boolean invalid$iv8 = (($dirty5 & 14) == 4) | $composer4.changed(onDismissRequestEffect) | (($dirty5 & 112) == 32);
                Object it$iv4 = $composer4.rememberedValue();
                if (invalid$iv8) {
                }
                Object value$iv3 = (Function2) new ChatBottomSheetKt$PictureContent$1$1(aphroState, onDismissRequestEffect, actionHandler, null);
                $composer4.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv4, $composer4, 0);
            } else {
                cameraCaptureLauncher = cameraCaptureLauncher2;
                $composer4.startReplaceGroup(-738175350);
            }
            $composer4.endReplaceGroup();
            Object value = permissionState2.getCurrentStatus().getValue();
            ComposerKt.sourceInformationMarkerStart($composer4, 115078797, "CC(remember):ChatBottomSheet.kt#9igjgp");
            boolean invalid$iv9 = $composer4.changed(permissionState2) | (($dirty5 & 14) == 4) | $composer4.changedInstance(scope) | (($dirty5 & 112) == 32);
            Object value$iv4 = $composer4.rememberedValue();
            if (invalid$iv9) {
                $dirty = $dirty5;
            } else {
                $dirty = $dirty5;
                if (value$iv4 != Composer.Companion.getEmpty()) {
                    str = "CC(remember):ChatBottomSheet.kt#9igjgp";
                    $dirty2 = $dirty;
                    i = 6;
                    permissionState = permissionState2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.LaunchedEffect(value, (Function2) value$iv4, $composer4, 0);
                    ComposerKt.sourceInformationMarkerStart($composer4, 115091997, str);
                    invalid$iv = $composer4.changed(permissionState);
                    it$iv = $composer4.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(permissionState.getCurrentStatus().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer4.updateRememberedValue(mutableStateOf$default);
                        it$iv = mutableStateOf$default;
                    }
                    savedPermissionStatus = (MutableState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, 115096745, str);
                    invalid$iv2 = $composer4.changed(cameraPermissionState);
                    it$iv2 = $composer4.rememberedValue();
                    if (!invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = SnapshotStateKt.mutableStateOf$default(cameraPermissionState.getCurrentStatus().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer4.updateRememberedValue(value$iv5);
                        it$iv2 = value$iv5;
                    }
                    final MutableState savedCameraPermissionStatus = (MutableState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, 115101636, str);
                    invalid$iv3 = $composer4.changed(permissionState) | $composer4.changed(savedPermissionStatus);
                    Object it$iv5 = $composer4.rememberedValue();
                    if (!invalid$iv3 && it$iv5 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        EffectsKt.LaunchedEffect(permissionState, (Function2) it$iv5, $composer4, 0);
                        ComposerKt.sourceInformationMarkerStart($composer4, 115109558, str);
                        invalid$iv4 = $composer4.changed(cameraPermissionState) | $composer4.changed(savedCameraPermissionStatus);
                        Object it$iv6 = $composer4.rememberedValue();
                        if (!invalid$iv4 && it$iv6 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            EffectsKt.LaunchedEffect(cameraPermissionState, (Function2) it$iv6, $composer4, 0);
                            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            int $changed$iv = i;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv = ($changed$iv << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | i;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv2;
                                $composer4.useNode();
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv2;
                                $composer4.createNode(factory$iv$iv$iv);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i3 = (($changed$iv >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 117918976, "C:ChatBottomSheet.kt#92mklk");
                            if (((PermissionStatus) savedPermissionStatus.getValue()).isGranted()) {
                                $composer$iv = $composer4;
                                $composer$iv2 = $composer4;
                                $composer$iv$iv$iv = $composer4;
                                int $dirty6 = $dirty2;
                                $composer2 = $composer4;
                                $composer$iv$iv = $composer4;
                                if (savedPermissionStatus.getValue() == PermissionStatus.Undetermined) {
                                    $composer2.startReplaceGroup(123897170);
                                    ComposerKt.sourceInformation($composer2, "448@18294L550,448@18262L582");
                                    ComposerKt.sourceInformationMarkerStart($composer2, 1250924088, str);
                                    boolean invalid$iv10 = $composer4.changed(permissionState) | $composer4.changedInstance(scope) | (($dirty6 & 112) == 32) | $composer4.changed(savedPermissionStatus);
                                    Object value$iv6 = $composer2.rememberedValue();
                                    if (invalid$iv10 || value$iv6 == Composer.Companion.getEmpty()) {
                                        value$iv6 = new ChatBottomSheetKt$PictureContent$5$8$1(permissionState, scope, savedPermissionStatus, actionHandler, null);
                                        $composer2.updateRememberedValue(value$iv6);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    EffectsKt.LaunchedEffect(permissionState, (Function2) value$iv6, $composer2, 0);
                                    $composer2.endReplaceGroup();
                                } else {
                                    $composer2.startReplaceGroup(124501484);
                                    ComposerKt.sourceInformation($composer2, "463@18911L126,463@18874L163,471@19205L146,468@19050L316");
                                    Boolean valueOf2 = Boolean.valueOf(state.isEnableExpand());
                                    ComposerKt.sourceInformationMarkerStart($composer2, 1250943408, str);
                                    boolean invalid$iv11 = ($dirty6 & 896) == 256;
                                    Object it$iv7 = $composer2.rememberedValue();
                                    if (invalid$iv11 || it$iv7 == Composer.Companion.getEmpty()) {
                                        Object value$iv7 = (Function2) new ChatBottomSheetKt$PictureContent$5$9$1(state, null);
                                        $composer2.updateRememberedValue(value$iv7);
                                        it$iv7 = value$iv7;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv7, $composer2, 0);
                                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                    ComposerKt.sourceInformationMarkerStart($composer2, 1250952836, str);
                                    boolean invalid$iv12 = $composer4.changedInstance(scope) | $composer4.changedInstance(platformContext);
                                    Object it$iv8 = $composer2.rememberedValue();
                                    if (invalid$iv12 || it$iv8 == Composer.Companion.getEmpty()) {
                                        Object value$iv8 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda20
                                            public final Object invoke() {
                                                Unit PictureContent$lambda$10$9$0;
                                                PictureContent$lambda$10$9$0 = ChatBottomSheetKt.PictureContent$lambda$10$9$0(scope, platformContext);
                                                return PictureContent$lambda$10$9$0;
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv8);
                                        it$iv8 = value$iv8;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    MediaSelectContentKt.PictureSelectNotAuthorized(fillMaxSize$default, progress, (Function0) it$iv8, $composer2, (($dirty6 >> 6) & 112) | 6, 0);
                                    $composer2.endReplaceGroup();
                                }
                            } else {
                                $composer4.startReplaceGroup(117917952);
                                ComposerKt.sourceInformation($composer4, "325@12099L126,325@12062L163");
                                Boolean valueOf3 = Boolean.valueOf(state.isEnableExpand());
                                ComposerKt.sourceInformationMarkerStart($composer4, 1250725424, str);
                                int $dirty7 = $dirty2;
                                boolean invalid$iv13 = ($dirty7 & 896) == 256;
                                Object it$iv9 = $composer4.rememberedValue();
                                if (invalid$iv13) {
                                }
                                Object value$iv9 = (Function2) new ChatBottomSheetKt$PictureContent$5$1$1(state, null);
                                $composer4.updateRememberedValue(value$iv9);
                                it$iv9 = value$iv9;
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv9, $composer4, 0);
                                if (aphroState instanceof AphroState.AphroContent) {
                                    $composer4.startReplaceGroup(118158419);
                                    ComposerKt.sourceInformation($composer4, "359@13758L22,360@13813L1198,336@12549L66,386@15053L305,339@12656L1058,395@15457L2676,331@12299L5853");
                                    AphroState.AphroContent aphroContent = (AphroState.AphroContent) aphroState;
                                    boolean PictureContent$lambda$1 = PictureContent$lambda$1(albumExpanded$delegate);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1250778408, str);
                                    Object it$iv10 = $composer4.rememberedValue();
                                    if (it$iv10 == Composer.Companion.getEmpty()) {
                                        Object value$iv10 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda14
                                            public final Object invoke(Object obj) {
                                                Unit PictureContent$lambda$10$1$0;
                                                PictureContent$lambda$10$1$0 = ChatBottomSheetKt.PictureContent$lambda$10$1$0(albumExpanded$delegate, ((Boolean) obj).booleanValue());
                                                return PictureContent$lambda$10$1$0;
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv10);
                                        it$iv10 = value$iv10;
                                    }
                                    Function1 function1 = (Function1) it$iv10;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1250781344, str);
                                    boolean invalid$iv14 = $composer4.changedInstance(scope) | (($dirty7 & 14) == 4) | (($dirty7 & 896) == 256) | (($dirty7 & 112) == 32);
                                    Object it$iv11 = $composer4.rememberedValue();
                                    if (invalid$iv14) {
                                    }
                                    Object value$iv11 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda15
                                        public final Object invoke(Object obj) {
                                            Unit PictureContent$lambda$10$2$0;
                                            PictureContent$lambda$10$2$0 = ChatBottomSheetKt.PictureContent$lambda$10$2$0(scope, aphroState, state, actionHandler, (AphroAction) obj);
                                            return PictureContent$lambda$10$2$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv11);
                                    it$iv11 = value$iv11;
                                    Function1 function12 = (Function1) it$iv11;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1250739764, str);
                                    boolean invalid$iv15 = (57344 & $dirty7) == 16384;
                                    Object it$iv12 = $composer4.rememberedValue();
                                    if (!invalid$iv15 && it$iv12 != Composer.Companion.getEmpty()) {
                                        Function0 function02 = (Function0) it$iv12;
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1250820131, str);
                                        invalid$iv5 = $composer4.changedInstance(scope) | $composer4.changed(permissionState) | (($dirty7 & 112) != 32);
                                        Object it$iv13 = $composer4.rememberedValue();
                                        if (invalid$iv5) {
                                        }
                                        Object value$iv12 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda17
                                            public final Object invoke() {
                                                Unit PictureContent$lambda$10$4$0;
                                                PictureContent$lambda$10$4$0 = ChatBottomSheetKt.PictureContent$lambda$10$4$0(scope, permissionState, actionHandler);
                                                return PictureContent$lambda$10$4$0;
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv12);
                                        it$iv13 = value$iv12;
                                        Function0 function03 = (Function0) it$iv13;
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1250744180, str);
                                        invalid$iv6 = (($dirty7 & 14) != 4) | $composer4.changedInstance(scope) | (($dirty7 & 112) != 32);
                                        Object it$iv14 = $composer4.rememberedValue();
                                        if (invalid$iv6) {
                                        }
                                        Object value$iv13 = new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda18
                                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                                Unit PictureContent$lambda$10$5$0;
                                                PictureContent$lambda$10$5$0 = ChatBottomSheetKt.PictureContent$lambda$10$5$0(aphroState, scope, actionHandler, ((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                                                return PictureContent$lambda$10$5$0;
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv13);
                                        it$iv14 = value$iv13;
                                        Function3 function3 = (Function3) it$iv14;
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1250835430, str);
                                        final CameraCaptureLauncher cameraCaptureLauncher3 = cameraCaptureLauncher;
                                        invalid$iv7 = $composer4.changed(cameraCaptureLauncher3) | (($dirty7 & 112) != 32) | $composer4.changedInstance(scope) | $composer4.changed(savedCameraPermissionStatus) | $composer4.changed(cameraPermissionState);
                                        Object value$iv14 = $composer4.rememberedValue();
                                        if (invalid$iv7) {
                                            $dirty3 = $dirty7;
                                            if (value$iv14 != Composer.Companion.getEmpty()) {
                                                $composer$iv = $composer4;
                                                $composer3 = $composer4;
                                                $dirty4 = $dirty3;
                                                $composer$iv$iv = $composer4;
                                                $composer$iv$iv$iv = $composer4;
                                                $composer$iv2 = $composer4;
                                                savedPermissionStatus2 = savedPermissionStatus;
                                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                                PictureSelectContent(aphroContent, progress, permissionState, PictureContent$lambda$1, function1, function12, showSelectIndex, null, function02, function03, function3, value$iv14, $composer3, ($dirty4 & 14) | 24576 | (($dirty4 >> 6) & 112) | (3670016 & ($dirty4 << 3)), 0, 128);
                                                $composer3.endReplaceGroup();
                                                $composer2 = $composer3;
                                            }
                                        } else {
                                            $dirty3 = $dirty7;
                                        }
                                        $composer$iv$iv = $composer4;
                                        $composer$iv$iv$iv = $composer4;
                                        $dirty4 = $dirty3;
                                        $composer3 = $composer4;
                                        $composer$iv2 = $composer4;
                                        $composer$iv = $composer4;
                                        savedPermissionStatus2 = savedPermissionStatus;
                                        value$iv14 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda19
                                            public final Object invoke() {
                                                Unit PictureContent$lambda$10$6$0;
                                                PictureContent$lambda$10$6$0 = ChatBottomSheetKt.PictureContent$lambda$10$6$0(scope, savedCameraPermissionStatus, cameraPermissionState, showCameraPermissionDialog, cameraCaptureLauncher3, actionHandler);
                                                return PictureContent$lambda$10$6$0;
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv14);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        PictureSelectContent(aphroContent, progress, permissionState, PictureContent$lambda$1, function1, function12, showSelectIndex, null, function02, function03, function3, value$iv14, $composer3, ($dirty4 & 14) | 24576 | (($dirty4 >> 6) & 112) | (3670016 & ($dirty4 << 3)), 0, 128);
                                        $composer3.endReplaceGroup();
                                        $composer2 = $composer3;
                                    }
                                    Object value$iv15 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda16
                                        public final Object invoke() {
                                            Unit PictureContent$lambda$10$3$0;
                                            PictureContent$lambda$10$3$0 = ChatBottomSheetKt.PictureContent$lambda$10$3$0(function0);
                                            return PictureContent$lambda$10$3$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv15);
                                    it$iv12 = value$iv15;
                                    Function0 function022 = (Function0) it$iv12;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1250820131, str);
                                    invalid$iv5 = $composer4.changedInstance(scope) | $composer4.changed(permissionState) | (($dirty7 & 112) != 32);
                                    Object it$iv132 = $composer4.rememberedValue();
                                    if (invalid$iv5) {
                                    }
                                    Object value$iv122 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda17
                                        public final Object invoke() {
                                            Unit PictureContent$lambda$10$4$0;
                                            PictureContent$lambda$10$4$0 = ChatBottomSheetKt.PictureContent$lambda$10$4$0(scope, permissionState, actionHandler);
                                            return PictureContent$lambda$10$4$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv122);
                                    it$iv132 = value$iv122;
                                    Function0 function032 = (Function0) it$iv132;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1250744180, str);
                                    invalid$iv6 = (($dirty7 & 14) != 4) | $composer4.changedInstance(scope) | (($dirty7 & 112) != 32);
                                    Object it$iv142 = $composer4.rememberedValue();
                                    if (invalid$iv6) {
                                    }
                                    Object value$iv132 = new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda18
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            Unit PictureContent$lambda$10$5$0;
                                            PictureContent$lambda$10$5$0 = ChatBottomSheetKt.PictureContent$lambda$10$5$0(aphroState, scope, actionHandler, ((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                                            return PictureContent$lambda$10$5$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv132);
                                    it$iv142 = value$iv132;
                                    Function3 function32 = (Function3) it$iv142;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1250835430, str);
                                    final CameraCaptureLauncher cameraCaptureLauncher32 = cameraCaptureLauncher;
                                    invalid$iv7 = $composer4.changed(cameraCaptureLauncher32) | (($dirty7 & 112) != 32) | $composer4.changedInstance(scope) | $composer4.changed(savedCameraPermissionStatus) | $composer4.changed(cameraPermissionState);
                                    Object value$iv142 = $composer4.rememberedValue();
                                    if (invalid$iv7) {
                                    }
                                    $composer$iv$iv = $composer4;
                                    $composer$iv$iv$iv = $composer4;
                                    $dirty4 = $dirty3;
                                    $composer3 = $composer4;
                                    $composer$iv2 = $composer4;
                                    $composer$iv = $composer4;
                                    savedPermissionStatus2 = savedPermissionStatus;
                                    value$iv142 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda19
                                        public final Object invoke() {
                                            Unit PictureContent$lambda$10$6$0;
                                            PictureContent$lambda$10$6$0 = ChatBottomSheetKt.PictureContent$lambda$10$6$0(scope, savedCameraPermissionStatus, cameraPermissionState, showCameraPermissionDialog, cameraCaptureLauncher32, actionHandler);
                                            return PictureContent$lambda$10$6$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv142);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    PictureSelectContent(aphroContent, progress, permissionState, PictureContent$lambda$1, function1, function12, showSelectIndex, null, function022, function032, function32, value$iv142, $composer3, ($dirty4 & 14) | 24576 | (($dirty4 >> 6) & 112) | (3670016 & ($dirty4 << 3)), 0, 128);
                                    $composer3.endReplaceGroup();
                                    $composer2 = $composer3;
                                } else {
                                    $composer$iv = $composer4;
                                    $composer$iv$iv$iv = $composer4;
                                    $composer$iv2 = $composer4;
                                    savedPermissionStatus2 = savedPermissionStatus;
                                    $composer$iv$iv = $composer4;
                                    $composer2 = $composer4;
                                    $composer2.startReplaceGroup(105775376);
                                    $composer2.endReplaceGroup();
                                }
                                $composer2.endReplaceGroup();
                            }
                            if (((Boolean) showCameraPermissionDialog.getValue()).booleanValue()) {
                                $composer2.startReplaceGroup(105775376);
                            } else {
                                $composer2.startReplaceGroup(125047673);
                                ComposerKt.sourceInformation($composer2, "479@19460L72,479@19437L95");
                                ComposerKt.sourceInformationMarkerStart($composer2, 1250960922, str);
                                Composer $this$cache$iv = $composer2;
                                Object it$iv15 = $this$cache$iv.rememberedValue();
                                if (it$iv15 == Composer.Companion.getEmpty()) {
                                    Object value$iv16 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda22
                                        public final Object invoke() {
                                            Unit PictureContent$lambda$10$10$0;
                                            PictureContent$lambda$10$10$0 = ChatBottomSheetKt.PictureContent$lambda$10$10$0(showCameraPermissionDialog);
                                            return PictureContent$lambda$10$10$0;
                                        }
                                    };
                                    $this$cache$iv.updateRememberedValue(value$iv16);
                                    it$iv15 = value$iv16;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                CameraPermissionDialogKt.CameraPermissionDialog((Function0) it$iv15, $composer2, 6);
                            }
                            $composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            $composer$iv$iv$iv.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        Object value$iv17 = (Function2) new ChatBottomSheetKt$PictureContent$4$1(cameraPermissionState, savedCameraPermissionStatus, null);
                        $composer4.updateRememberedValue(value$iv17);
                        it$iv6 = value$iv17;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        EffectsKt.LaunchedEffect(cameraPermissionState, (Function2) it$iv6, $composer4, 0);
                        Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        int $changed$iv2 = i;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv2 = ($changed$iv2 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | i;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i22 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i32 = (($changed$iv2 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 117918976, "C:ChatBottomSheet.kt#92mklk");
                        if (((PermissionStatus) savedPermissionStatus.getValue()).isGranted()) {
                        }
                        if (((Boolean) showCameraPermissionDialog.getValue()).booleanValue()) {
                        }
                        $composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    Object value$iv18 = (Function2) new ChatBottomSheetKt$PictureContent$3$1(permissionState, savedPermissionStatus, null);
                    $composer4.updateRememberedValue(value$iv18);
                    it$iv5 = value$iv18;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.LaunchedEffect(permissionState, (Function2) it$iv5, $composer4, 0);
                    ComposerKt.sourceInformationMarkerStart($composer4, 115109558, str);
                    invalid$iv4 = $composer4.changed(cameraPermissionState) | $composer4.changed(savedCameraPermissionStatus);
                    Object it$iv62 = $composer4.rememberedValue();
                    if (!invalid$iv4) {
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        EffectsKt.LaunchedEffect(cameraPermissionState, (Function2) it$iv62, $composer4, 0);
                        Modifier modifier$iv22 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        int $changed$iv22 = i;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv22 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                        int $changed$iv$iv22 = ($changed$iv22 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv22 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer4, modifier$iv22);
                        Function0 factory$iv$iv$iv222 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | i;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                        int i222 = ($changed$iv$iv$iv22 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                        int i322 = (($changed$iv22 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 117918976, "C:ChatBottomSheet.kt#92mklk");
                        if (((PermissionStatus) savedPermissionStatus.getValue()).isGranted()) {
                        }
                        if (((Boolean) showCameraPermissionDialog.getValue()).booleanValue()) {
                        }
                        $composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    Object value$iv172 = (Function2) new ChatBottomSheetKt$PictureContent$4$1(cameraPermissionState, savedCameraPermissionStatus, null);
                    $composer4.updateRememberedValue(value$iv172);
                    it$iv62 = value$iv172;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.LaunchedEffect(cameraPermissionState, (Function2) it$iv62, $composer4, 0);
                    Modifier modifier$iv222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    int $changed$iv222 = i;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv222 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv222, false);
                    int $changed$iv$iv222 = ($changed$iv222 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv222 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv222);
                    Function0 factory$iv$iv$iv2222 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | i;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                    int i2222 = ($changed$iv$iv$iv222 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
                    int i3222 = (($changed$iv222 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 117918976, "C:ChatBottomSheet.kt#92mklk");
                    if (((PermissionStatus) savedPermissionStatus.getValue()).isGranted()) {
                    }
                    if (((Boolean) showCameraPermissionDialog.getValue()).booleanValue()) {
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
            $dirty2 = $dirty;
            i = 6;
            permissionState = permissionState2;
            str = "CC(remember):ChatBottomSheet.kt#9igjgp";
            value$iv4 = new ChatBottomSheetKt$PictureContent$2$1(permissionState2, aphroState, scope, actionHandler, null);
            $composer4.updateRememberedValue(value$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(value, (Function2) value$iv4, $composer4, 0);
            ComposerKt.sourceInformationMarkerStart($composer4, 115091997, str);
            invalid$iv = $composer4.changed(permissionState);
            it$iv = $composer4.rememberedValue();
            if (!invalid$iv) {
            }
            MutableState mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(permissionState.getCurrentStatus().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer4.updateRememberedValue(mutableStateOf$default2);
            it$iv = mutableStateOf$default2;
            savedPermissionStatus = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 115096745, str);
            invalid$iv2 = $composer4.changed(cameraPermissionState);
            it$iv2 = $composer4.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv52 = SnapshotStateKt.mutableStateOf$default(cameraPermissionState.getCurrentStatus().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer4.updateRememberedValue(value$iv52);
            it$iv2 = value$iv52;
            final MutableState savedCameraPermissionStatus2 = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 115101636, str);
            invalid$iv3 = $composer4.changed(permissionState) | $composer4.changed(savedPermissionStatus);
            Object it$iv52 = $composer4.rememberedValue();
            if (!invalid$iv3) {
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(permissionState, (Function2) it$iv52, $composer4, 0);
                ComposerKt.sourceInformationMarkerStart($composer4, 115109558, str);
                invalid$iv4 = $composer4.changed(cameraPermissionState) | $composer4.changed(savedCameraPermissionStatus2);
                Object it$iv622 = $composer4.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv1722 = (Function2) new ChatBottomSheetKt$PictureContent$4$1(cameraPermissionState, savedCameraPermissionStatus2, null);
                $composer4.updateRememberedValue(value$iv1722);
                it$iv622 = value$iv1722;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(cameraPermissionState, (Function2) it$iv622, $composer4, 0);
                Modifier modifier$iv2222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                int $changed$iv2222 = i;
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2222 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2222, false);
                int $changed$iv$iv2222 = ($changed$iv2222 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2222 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2222);
                Function0 factory$iv$iv$iv22222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | i;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
                int i22222 = ($changed$iv$iv$iv2222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2222 = BoxScopeInstance.INSTANCE;
                int i32222 = (($changed$iv2222 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 117918976, "C:ChatBottomSheet.kt#92mklk");
                if (((PermissionStatus) savedPermissionStatus.getValue()).isGranted()) {
                }
                if (((Boolean) showCameraPermissionDialog.getValue()).booleanValue()) {
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv182 = (Function2) new ChatBottomSheetKt$PictureContent$3$1(permissionState, savedPermissionStatus, null);
            $composer4.updateRememberedValue(value$iv182);
            it$iv52 = value$iv182;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(permissionState, (Function2) it$iv52, $composer4, 0);
            ComposerKt.sourceInformationMarkerStart($composer4, 115109558, str);
            invalid$iv4 = $composer4.changed(cameraPermissionState) | $composer4.changed(savedCameraPermissionStatus2);
            Object it$iv6222 = $composer4.rememberedValue();
            if (!invalid$iv4) {
            }
            Object value$iv17222 = (Function2) new ChatBottomSheetKt$PictureContent$4$1(cameraPermissionState, savedCameraPermissionStatus2, null);
            $composer4.updateRememberedValue(value$iv17222);
            it$iv6222 = value$iv17222;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(cameraPermissionState, (Function2) it$iv6222, $composer4, 0);
            Modifier modifier$iv22222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            int $changed$iv22222 = i;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv22222 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv22222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22222, false);
            int $changed$iv$iv22222 = ($changed$iv22222 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv22222 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv22222);
            Function0 factory$iv$iv$iv222222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22222 = (($changed$iv$iv22222 << 6) & 896) | i;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22222 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, measurePolicy$iv22222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, localMap$iv$iv22222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22222, Integer.valueOf(compositeKeyHash$iv$iv22222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, materialized$iv$iv22222, ComposeUiNode.Companion.getSetModifier());
            int i222222 = ($changed$iv$iv$iv22222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22222 = BoxScopeInstance.INSTANCE;
            int i322222 = (($changed$iv22222 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 117918976, "C:ChatBottomSheet.kt#92mklk");
            if (((PermissionStatus) savedPermissionStatus.getValue()).isGranted()) {
            }
            if (((Boolean) showCameraPermissionDialog.getValue()).booleanValue()) {
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer4.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit PictureContent$lambda$11;
                    PictureContent$lambda$11 = ChatBottomSheetKt.PictureContent$lambda$11(aphroState, actionHandler, state, progress, function0, showSelectIndex, platformContext, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PictureContent$lambda$11;
                }
            });
        }
    }

    private static final boolean PictureContent$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void PictureContent$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$3$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$5$0(AphroState $aphroState, CoroutineScope $scope, ChatActionHandler $actionHandler, int index, AssetItemState assetItemState, List itemPositionList) {
        Intrinsics.checkNotNullParameter(assetItemState, "assetItemState");
        Intrinsics.checkNotNullParameter(itemPositionList, "itemPositionList");
        AphroAssetsState.AphroContent assetsState = ((AphroState.AphroContent) $aphroState).getAssetsState();
        AphroAssetsState.AphroContent assetsState2 = assetsState instanceof AphroAssetsState.AphroContent ? assetsState : null;
        if (assetsState2 != null) {
            Iterable $this$mapIndexed$iv = assetsState2.getAssetList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Asset it = (Asset) item$iv$iv;
                destination$iv$iv.add(PreviewableAssetKt.asPreviewableAsset$default(it, (ImageSource) null, (IntRect) itemPositionList.get(index$iv$iv), false, 5, (Object) null));
                index$iv$iv = index$iv$iv2;
            }
            List totalDataSource = (List) destination$iv$iv;
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBottomSheetKt$PictureContent$5$6$1$1($actionHandler, totalDataSource, index, assetsState2, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$1$0(MutableState $albumExpanded$delegate, boolean it) {
        PictureContent$lambda$2($albumExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$2$0(CoroutineScope $scope, AphroState $aphroState, ChatMediaSelectBottomSheetState $state, ChatActionHandler $actionHandler, AphroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBottomSheetKt$PictureContent$5$3$1$1(action, $aphroState, $state, $actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$4$0(CoroutineScope $scope, BPermissionState $permissionState, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBottomSheetKt$PictureContent$5$5$1$1($permissionState, $actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object PictureContent$lambda$10$6$0$doLaunchCamera(CameraCaptureLauncher cameraCaptureLauncher, ChatActionHandler $actionHandler, Continuation<? super Unit> continuation) {
        ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1 chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1;
        Object launch;
        CameraCaptureResultStatus.ConfirmedAsset confirmedAsset;
        if (continuation instanceof ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1) {
            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1 = (ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1) continuation;
            if ((chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label & Integer.MIN_VALUE) != 0) {
                chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label -= Integer.MIN_VALUE;
                Object $result = chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0 = SpillingKt.nullOutSpilledVariable(cameraCaptureLauncher);
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1 = $actionHandler;
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label = 1;
                        launch = cameraCaptureLauncher.launch(chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1);
                        if (launch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        confirmedAsset = (CameraCaptureResultStatus) launch;
                        if (!Intrinsics.areEqual(confirmedAsset, CameraCaptureResultStatus.Canceled.INSTANCE)) {
                            IMLog.Companion.w("ChatBottomSheet", "CameraCaptureResultStatus.Canceled");
                            return Unit.INSTANCE;
                        } else if (confirmedAsset instanceof CameraCaptureResultStatus.ConfirmedAsset) {
                            IMLog.Companion.i("ChatBottomSheet", "拍照成功，发送图片 " + confirmedAsset.getAsset().getIdentifier());
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0 = SpillingKt.nullOutSpilledVariable(cameraCaptureLauncher);
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1 = $actionHandler;
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$2 = SpillingKt.nullOutSpilledVariable(confirmedAsset);
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label = 2;
                            if ($actionHandler.invoke(new ChatAction.SendSingleAsset(confirmedAsset.getAsset(), true), chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0 = SpillingKt.nullOutSpilledVariable(cameraCaptureLauncher);
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1 = SpillingKt.nullOutSpilledVariable($actionHandler);
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$2 = SpillingKt.nullOutSpilledVariable(confirmedAsset);
                            chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label = 3;
                            return $actionHandler.invoke(new DispatchAphroAction(AphroAction.RefreshAlbums.INSTANCE), chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    case 1:
                        $actionHandler = (ChatActionHandler) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1;
                        cameraCaptureLauncher = (CameraCaptureLauncher) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0;
                        ResultKt.throwOnFailure($result);
                        launch = $result;
                        confirmedAsset = (CameraCaptureResultStatus) launch;
                        if (!Intrinsics.areEqual(confirmedAsset, CameraCaptureResultStatus.Canceled.INSTANCE)) {
                        }
                        break;
                    case 2:
                        confirmedAsset = (CameraCaptureResultStatus) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$2;
                        $actionHandler = (ChatActionHandler) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1;
                        cameraCaptureLauncher = (CameraCaptureLauncher) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0;
                        ResultKt.throwOnFailure($result);
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0 = SpillingKt.nullOutSpilledVariable(cameraCaptureLauncher);
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1 = SpillingKt.nullOutSpilledVariable($actionHandler);
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$2 = SpillingKt.nullOutSpilledVariable(confirmedAsset);
                        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label = 3;
                        if ($actionHandler.invoke(new DispatchAphroAction(AphroAction.RefreshAlbums.INSTANCE), chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        CameraCaptureResultStatus cameraCaptureResultStatus = (CameraCaptureResultStatus) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$2;
                        ChatActionHandler chatActionHandler = (ChatActionHandler) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$1;
                        CameraCaptureLauncher cameraCaptureLauncher2 = (CameraCaptureLauncher) chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1 = new ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1(continuation);
        Object $result2 = chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$6$0(CoroutineScope $scope, MutableState $savedCameraPermissionStatus, BPermissionState $cameraPermissionState, MutableState $showCameraPermissionDialog, CameraCaptureLauncher $cameraCaptureLauncher, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBottomSheetKt$PictureContent$5$7$1$1($savedCameraPermissionStatus, $cameraPermissionState, $showCameraPermissionDialog, $cameraCaptureLauncher, $actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$9$0(CoroutineScope $scope, Activity $platformContext) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBottomSheetKt$PictureContent$5$10$1$1($platformContext, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureContent$lambda$10$10$0(MutableState $showCameraPermissionDialog) {
        $showCameraPermissionDialog.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$2$0(int i, AssetItemState assetItemState, List list) {
        Intrinsics.checkNotNullParameter(assetItemState, "<unused var>");
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x07a1  */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v72, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void PictureSelectContent(final AphroState.AphroContent albums, final float progress, final BPermissionState permissionState, final boolean albumExpanded, final Function1<? super Boolean, Unit> function1, final Function1<? super AphroAction, Unit> function12, final boolean showSelectIndex, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function3<? super Integer, ? super AssetItemState, ? super List<IntRect>, Unit> function3, Function0<Unit> function03, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function0<Unit> function04;
        Function0 onClickSelectMore;
        Function3 onAssetItemClick;
        Function0 onShootPictureClick;
        Function0 onClickSelectMore2;
        Function0 onShootPictureClick2;
        Function0 factory$iv$iv$iv;
        Function0 onShootPictureClick3;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        String str;
        Composer $composer$iv$iv;
        ColumnScope $this$PictureSelectContent_u24lambda_u244;
        ?? r13;
        int $dirty;
        Composer $composer3;
        Modifier materialized$iv$iv;
        boolean z;
        boolean z2;
        ?? r0;
        Composer $composer4 = $composer.startRestartGroup(-1389379202);
        ComposerKt.sourceInformation($composer4, "C(PictureSelectContent)N(albums,progress,permissionState,albumExpanded,onAlbumExpandChange,onAction,showSelectIndex,modifier,onBackButtonClick,onClickSelectMore,onAssetItemClick,onShootPictureClick)496@19905L2,497@19945L2,498@20018L14,499@20072L2,501@20084L4145:ChatBottomSheet.kt#92mklk");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(albums) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(progress) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(permissionState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(albumExpanded) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function12) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer4.changed(showSelectIndex) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer4.changed(modifier) ? 8388608 : 4194304;
        }
        int i3 = i & 256;
        if (i3 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 67108864 : 33554432;
        }
        int i4 = i & 512;
        if (i4 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer4.changedInstance(function02) ? 536870912 : 268435456;
        }
        int i5 = i & 1024;
        if (i5 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer4.changedInstance(function3) ? 4 : 2;
        }
        int i6 = i & 2048;
        if (i6 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer4.changedInstance(function03) ? 32 : 16;
        }
        if ($composer4.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 19) == 18) ? false : true, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 541426592, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                function04 = it$iv;
            } else {
                function04 = function0;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 541427872, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda35
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onClickSelectMore3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onClickSelectMore2 = onClickSelectMore3;
            } else {
                onClickSelectMore2 = function02;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 541430220, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv3 = $composer4.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda36
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit PictureSelectContent$lambda$2$0;
                            PictureSelectContent$lambda$2$0 = ChatBottomSheetKt.PictureSelectContent$lambda$2$0(((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                            return PictureSelectContent$lambda$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function3 onAssetItemClick2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onAssetItemClick = onAssetItemClick2;
            } else {
                onAssetItemClick = function3;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 541431936, "CC(remember):ChatBottomSheet.kt#9igjgp");
                Object it$iv4 = $composer4.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda37
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function0 onShootPictureClick4 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onShootPictureClick2 = onShootPictureClick4;
            } else {
                onShootPictureClick2 = function03;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1389379202, $dirty2, $dirty1, "kntr.app.im.chat.ui.widget.PictureSelectContent (ChatBottomSheet.kt:500)");
            }
            int $changed$iv = ($dirty2 >> 21) & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            int $dirty12 = $dirty1;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Function0 onShootPictureClick5 = onShootPictureClick2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int $changed2 = (($changed$iv >> 6) & 112) | 6;
            ColumnScope $this$PictureSelectContent_u24lambda_u2442 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1552627434, "C525@20904L2569,599@23791L432,594@23483L740:ChatBottomSheet.kt#92mklk");
            if (progress == 0.0f) {
                onShootPictureClick3 = onShootPictureClick5;
                $composer$iv$iv$iv = $composer4;
                $composer$iv = $composer4;
                $composer$iv2 = $composer4;
                $composer2 = $composer4;
                str = "CC(remember):ChatBottomSheet.kt#9igjgp";
                $composer$iv$iv = $composer4;
                $this$PictureSelectContent_u24lambda_u244 = $this$PictureSelectContent_u24lambda_u2442;
                r13 = 1;
                $dirty = $dirty2;
                $composer3 = $composer4;
                $composer3.startReplaceGroup(1532538286);
                $composer3.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(1552545841);
                ComposerKt.sourceInformation($composer4, "504@20208L6,503@20156L381");
                $composer$iv$iv = $composer4;
                $dirty = $dirty2;
                $this$PictureSelectContent_u24lambda_u244 = $this$PictureSelectContent_u24lambda_u2442;
                $composer$iv$iv$iv = $composer4;
                $composer$iv = $composer4;
                $composer$iv2 = $composer4;
                $composer2 = $composer4;
                str = "CC(remember):ChatBottomSheet.kt#9igjgp";
                onShootPictureClick3 = onShootPictureClick5;
                r13 = 1;
                MediaSelectFloatKt.MediaFloatTopBar-pzZJ40c(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), progress, (AphroState) albums, (AnchoredDraggableState) null, albumExpanded, function1, function04, ClipKt.clipToBounds(Modifier.Companion), $composer4, ($dirty2 & 112) | 12585984 | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 57344) | (($dirty2 << 3) & 458752) | (($dirty2 >> 6) & 3670016), 0);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            }
            if (permissionState.getCurrentStatus().getValue() == PermissionStatus.Limited) {
                $composer3.startReplaceGroup(1553110444);
                ComposerKt.sourceInformation($composer3, "519@20746L138");
                MediaSelectContentKt.PartialSelectBar(onClickSelectMore2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, (int) r13, (Object) null), $composer3, (($dirty >> 27) & 14) | 48, 0);
            } else {
                $composer3.startReplaceGroup(1532538286);
            }
            $composer3.endReplaceGroup();
            ColumnScope $this$PictureSelectContent_u24lambda_u2443 = $this$PictureSelectContent_u24lambda_u244;
            Modifier modifier$iv2 = $this$PictureSelectContent_u24lambda_u2443.weight(Modifier.Companion, 1.0f, (boolean) r13);
            Composer $composer$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
            Function0 onClickSelectMore4 = onClickSelectMore2;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                $composer$iv3.createNode(factory$iv$iv$iv3);
            } else {
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i9 = ((0 >> 6) & 112) | 6;
            BoxScope $this$PictureSelectContent_u24lambda_u244_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -50545536, "C531@21115L66,536@21318L489,528@20990L832,555@22115L587,550@21848L854,579@23054L409,572@22728L735:ChatBottomSheet.kt#92mklk");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 275465756, str);
            boolean invalid$iv = ($dirty & 458752) == 131072;
            Object it$iv5 = $composer$iv3.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.Companion.getEmpty()) {
                materialized$iv$iv = materialized$iv$iv3;
                Object value$iv5 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda38
                    public final Object invoke(Object obj) {
                        Unit PictureSelectContent$lambda$4$0$0$0;
                        PictureSelectContent$lambda$4$0$0$0 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$0$0(function12, (AphroAction) obj);
                        return PictureSelectContent$lambda$4$0$0$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            } else {
                materialized$iv$iv = materialized$iv$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            final Function0 onShootPictureClick6 = onShootPictureClick3;
            onShootPictureClick = onShootPictureClick6;
            Composer $composer5 = $composer3;
            onClickSelectMore = onClickSelectMore4;
            MediaListKt.GridMediaList-aqv2aB4(albums, (Function1) it$iv5, fillMaxSize$default, ComposableLambdaKt.rememberComposableLambda(-974356081, true, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda39
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PictureSelectContent$lambda$4$0$1;
                    PictureSelectContent$lambda$4$0$1 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$1(onShootPictureClick6, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PictureSelectContent$lambda$4$0$1;
                }
            }, $composer$iv3, 54), (Function3) null, false, onAssetItemClick, showSelectIndex, (NestedScrollConnection) null, 0.0f, $composer$iv3, ($dirty & 14) | 3456 | (($dirty12 << 18) & 3670016) | (($dirty << 3) & 29360128), 816);
            AnimatedVisibilityKt.AnimatedVisibility($this$PictureSelectContent_u24lambda_u2443, albumExpanded, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(1466627538, true, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PictureSelectContent$lambda$4$0$2;
                    PictureSelectContent$lambda$4$0$2 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$2(albums, function1, function12, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PictureSelectContent$lambda$4$0$2;
                }
            }, $composer$iv3, 54), $composer$iv3, ($changed2 & 14) | 1600896 | (($dirty >> 6) & 112), 16);
            if (!(progress == 0.0f) || albums.getCurrentSelected().isEmpty()) {
                z = true;
            } else {
                boolean z3 = true;
                z = z3;
                if (!albumExpanded) {
                    z2 = true;
                    r0 = z3;
                    AnimatedVisibilityKt.AnimatedVisibility($this$PictureSelectContent_u24lambda_u2443, z2, PaddingKt.padding-qDBjuR0$default($this$PictureSelectContent_u24lambda_u244_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(40), 3, (Object) null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1768745655, (boolean) r0, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit PictureSelectContent$lambda$4$0$3;
                            PictureSelectContent$lambda$4$0$3 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$3(albums, function12, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return PictureSelectContent$lambda$4$0$3;
                        }
                    }, $composer$iv3, 54), $composer$iv3, ($changed2 & 14) | 1572864, 28);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    AnimatedVisibilityKt.AnimatedVisibility($this$PictureSelectContent_u24lambda_u2443, (((progress > 1.0f ? 1 : (progress == 1.0f ? 0 : -1)) != 0 ? r0 : false) || albums.getCurrentSelected().isEmpty() || albumExpanded) ? false : r0, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, (int) r0, (Object) null), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-344878900, (boolean) r0, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda32
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit PictureSelectContent$lambda$4$1;
                            PictureSelectContent$lambda$4$1 = ChatBottomSheetKt.PictureSelectContent$lambda$4$1(albums, function12, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return PictureSelectContent$lambda$4$1;
                        }
                    }, $composer5, 54), $composer5, ($changed2 & 14) | 1600896, 16);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            z2 = false;
            r0 = z;
            AnimatedVisibilityKt.AnimatedVisibility($this$PictureSelectContent_u24lambda_u2443, z2, PaddingKt.padding-qDBjuR0$default($this$PictureSelectContent_u24lambda_u244_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(40), 3, (Object) null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1768745655, (boolean) r0, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PictureSelectContent$lambda$4$0$3;
                    PictureSelectContent$lambda$4$0$3 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$3(albums, function12, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PictureSelectContent$lambda$4$0$3;
                }
            }, $composer$iv3, 54), $composer$iv3, ($changed2 & 14) | 1572864, 28);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if ((progress > 1.0f ? 1 : (progress == 1.0f ? 0 : -1)) != 0 ? r0 : false) {
            }
            AnimatedVisibilityKt.AnimatedVisibility($this$PictureSelectContent_u24lambda_u2443, (((progress > 1.0f ? 1 : (progress == 1.0f ? 0 : -1)) != 0 ? r0 : false) || albums.getCurrentSelected().isEmpty() || albumExpanded) ? false : r0, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, (int) r0, (Object) null), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-344878900, (boolean) r0, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PictureSelectContent$lambda$4$1;
                    PictureSelectContent$lambda$4$1 = ChatBottomSheetKt.PictureSelectContent$lambda$4$1(albums, function12, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PictureSelectContent$lambda$4$1;
                }
            }, $composer5, 54), $composer5, ($changed2 & 14) | 1600896, 16);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            function04 = function0;
            onClickSelectMore = function02;
            onAssetItemClick = function3;
            onShootPictureClick = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Function0<Unit> function05 = function04;
            final Function0 function06 = onClickSelectMore;
            final Function3 function32 = onAssetItemClick;
            final Function0 function07 = onShootPictureClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj, Object obj2) {
                    Unit PictureSelectContent$lambda$5;
                    PictureSelectContent$lambda$5 = ChatBottomSheetKt.PictureSelectContent$lambda$5(albums, progress, permissionState, albumExpanded, function1, function12, showSelectIndex, modifier3, function05, function06, function32, function07, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PictureSelectContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$0$0(Function1 $onAction, AphroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        $onAction.invoke(action);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$1(final Function0 $onShootPictureClick, LazyGridItemScope $this$GridMediaList, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$GridMediaList, "$this$GridMediaList");
        ComposerKt.sourceInformation($composer, "C542@21602L6,543@21673L93,537@21340L449:ChatBottomSheet.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-974356081, $changed, -1, "kntr.app.im.chat.ui.widget.PictureSelectContent.<anonymous>.<anonymous>.<anonymous> (ChatBottomSheet.kt:537)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thin_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -53311860, "CC(remember):ChatBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onShootPictureClick);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit PictureSelectContent$lambda$4$0$1$0$0;
                        PictureSelectContent$lambda$4$0$1$0$0 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$1$0$0($onShootPictureClick);
                        return PictureSelectContent$lambda$4$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            MediaSelectShootPictureContent(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$1$0$0(Function0 $onShootPictureClick) {
        $onShootPictureClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$2(AphroState.AphroContent $albums, final Function1 $onAlbumExpandChange, final Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C557@22199L279,566@22554L6,565@22495L193:ChatBottomSheet.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1466627538, $changed, -1, "kntr.app.im.chat.ui.widget.PictureSelectContent.<anonymous>.<anonymous>.<anonymous> (ChatBottomSheet.kt:556)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 679793897, "CC(remember):ChatBottomSheet.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit PictureSelectContent$lambda$4$0$2$0$0;
                    PictureSelectContent$lambda$4$0$2$0$0 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$2$0$0($onAlbumExpandChange, $onAction, (AphroAction) obj);
                    return PictureSelectContent$lambda$4$0$2$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Function1 actionDispatcher = (Function1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        AlbumListKt.AlbumList-pHQ97Tc(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), $albums.getAlbumList(), actionDispatcher, (Modifier) null, 0.0f, $composer, 384, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$2$0$0(Function1 $onAlbumExpandChange, Function1 $onAction, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof AphroAction.SwitchAlbum) {
            $onAlbumExpandChange.invoke(false);
        }
        $onAction.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$3(final AphroState.AphroContent $albums, final Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C583@23194L236,580@23072L377:ChatBottomSheet.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1768745655, $changed, -1, "kntr.app.im.chat.ui.widget.PictureSelectContent.<anonymous>.<anonymous>.<anonymous> (ChatBottomSheet.kt:580)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1042479477, "CC(remember):ChatBottomSheet.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onAction) | $composer.changed($albums);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda30
                public final Object invoke() {
                    Unit PictureSelectContent$lambda$4$0$3$0$0;
                    PictureSelectContent$lambda$4$0$3$0$0 = ChatBottomSheetKt.PictureSelectContent$lambda$4$0$3$0$0($onAction, $albums);
                    return PictureSelectContent$lambda$4$0$3$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        MediaSelectFloatKt.OriginCheckBox($albums, 1.0f, (Function0) it$iv, (Modifier) null, $composer, 48, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$0$3$0$0(Function1 $onAction, AphroState.AphroContent $albums) {
        $onAction.invoke(new AphroAction.CheckUseOriginImage(!$albums.getUseOriginImage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$1(AphroState.AphroContent $albums, final Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C603@23931L6,606@24058L66,600@23805L408:ChatBottomSheet.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-344878900, $changed, -1, "kntr.app.im.chat.ui.widget.PictureSelectContent.<anonymous>.<anonymous> (ChatBottomSheet.kt:600)");
        }
        Modifier navigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null));
        ComposerKt.sourceInformationMarkerStart($composer, -716132498, "CC(remember):ChatBottomSheet.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onAction);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj) {
                    Unit PictureSelectContent$lambda$4$1$0$0;
                    PictureSelectContent$lambda$4$1$0$0 = ChatBottomSheetKt.PictureSelectContent$lambda$4$1$0$0($onAction, (AphroAction) obj);
                    return PictureSelectContent$lambda$4$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SelectedBottomRowKt.SelectedBottom($albums, true, true, (Function1) it$iv, navigationBarsPadding, $composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectContent$lambda$4$1$0$0(Function1 $onAction, AphroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        $onAction.invoke(action);
        return Unit.INSTANCE;
    }

    public static final void MediaSelectShootPictureContent(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1203614481);
        ComposerKt.sourceInformation($composer3, "C(MediaSelectShootPictureContent)N(modifier)618@24317L641:ChatBottomSheet.kt#92mklk");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1203614481, $dirty, -1, "kntr.app.im.chat.ui.widget.MediaSelectShootPictureContent (ChatBottomSheet.kt:617)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = ($dirty & 14) | 48;
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
            ComposerKt.sourceInformationMarkerStart($composer3, -1213354086, "C623@24420L532:ChatBottomSheet.kt#92mklk");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1927991822, "C627@24561L20,626@24516L172,631@24701L40,633@24783L47,634@24866L9,635@24915L6,632@24754L188:ChatBottomSheet.kt#92mklk");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCamera_shot_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), 0L, $composer3, Painter.$stable | 432, 8);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_797(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 131066);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectShootPictureContent$lambda$1;
                    MediaSelectShootPictureContent$lambda$1 = ChatBottomSheetKt.MediaSelectShootPictureContent$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectShootPictureContent$lambda$1;
                }
            });
        }
    }
}