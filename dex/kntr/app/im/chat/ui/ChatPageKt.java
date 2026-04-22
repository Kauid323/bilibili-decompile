package kntr.app.im.chat.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KNavButton;
import com.bapis.bilibili.app.im.v1.KSessionTag;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.emoticon.Emote;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.base.IMTopBarKt;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.core.model.NavigationBar;
import kntr.app.im.chat.sticker.di.StickerEntryPoint;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.viewModel.StickerManagerViewModel;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.navigationBar.TitleLiveTagKt;
import kntr.app.im.chat.ui.navigationBar.TitleTextTagKt;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.upgrade.UpgradeAnswerDialogDisplayer;
import kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle;
import kntr.app.im.chat.ui.widget.BehaviorAlertDialogKt;
import kntr.app.im.chat.ui.widget.ChatBottomSheetKt;
import kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetDefaults;
import kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt;
import kntr.app.im.chat.ui.widget.InputBoxKt;
import kntr.app.im.chat.ui.widget.InputBoxState;
import kntr.app.im.chat.ui.widget.sticky.StickyBarKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.model.UserInfo;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.router.Router;
import kntr.common.compose.list.LoadMoreListStateKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewImageData;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: ChatPage.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002"}, d2 = {"ChatPage", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "Lkntr/app/im/chat/core/model/ChatPageData;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "frameBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "pictureLifecycleKeyHandle", "Lkntr/app/im/chat/ui/utils/PictureLifecycleKeyHandle;", "modifier", "Landroidx/compose/ui/Modifier;", "upgradeAnswerDialogDisplayer", "Lkntr/app/im/chat/ui/upgrade/UpgradeAnswerDialogDisplayer;", "showInputBox", RoomRecommendViewModel.EMPTY_CURSOR, "defaultTitleName", RoomRecommendViewModel.EMPTY_CURSOR, "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "(Lkntr/app/im/chat/core/model/ChatPageData;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/foundation/lazy/LazyListState;Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;Lkntr/app/im/chat/ui/utils/PictureLifecycleKeyHandle;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/upgrade/UpgradeAnswerDialogDisplayer;ZLjava/lang/String;Lkntr/app/im/chat/ui/neuron/ChatReporter;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "stickerManagerState", "Lkntr/app/im/chat/sticker/model/StickerManagerData;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$10(ChatPageData chatPageData, ChatActionHandler chatActionHandler, LazyListState lazyListState, ChatMsgFrameBuilderProvider chatMsgFrameBuilderProvider, PictureLifecycleKeyHandle pictureLifecycleKeyHandle, Modifier modifier, UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer, boolean z, String str, ChatReporter chatReporter, int i, int i2, Composer composer, int i3) {
        ChatPage(chatPageData, chatActionHandler, lazyListState, chatMsgFrameBuilderProvider, pictureLifecycleKeyHandle, modifier, upgradeAnswerDialogDisplayer, z, str, chatReporter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x07d5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x09d0  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0a15  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0a38  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0aa9  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0ba4  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0d69  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0d8f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0d91  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0d9a  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0d9c  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0da9  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0dab  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0dc4  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0e1a  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0eee  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0f01  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0f13  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0f39  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ChatPage(final ChatPageData pageData, final ChatActionHandler actionHandler, final LazyListState listState, final ChatMsgFrameBuilderProvider frameBuilderProvider, final PictureLifecycleKeyHandle pictureLifecycleKeyHandle, Modifier modifier, UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer, boolean showInputBox, String defaultTitleName, ChatReporter reporter, Composer $composer, final int $changed, final int i) {
        boolean showInputBox2;
        Composer $composer2;
        Modifier modifier2;
        UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer2;
        String defaultTitleName2;
        ChatReporter reporter2;
        boolean showInputBox3;
        String defaultTitleName3;
        UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer3;
        ChatReporter reporter3;
        int $dirty;
        SoftwareKeyboardController softwareKeyboardController;
        String str;
        boolean invalid$iv;
        Object it$iv;
        String str2;
        Object obj;
        Object it$iv2;
        InputBoxState inputBoxState;
        boolean invalid$iv2;
        Object it$iv3;
        boolean invalid$iv3;
        Router router;
        PreviewImageData previewImageData;
        boolean invalid$iv4;
        Object value$iv;
        PreviewImageData previewImageData2;
        SoftwareKeyboardController softwareKeyboardController2;
        int $dirty2;
        InputBoxState inputBoxState2;
        Router router2;
        String str3;
        boolean invalid$iv5;
        Object it$iv4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        final ChatInfo chatInfo;
        String backgroundImg;
        Composer $composer$iv;
        final long bgColor;
        Modifier modifier$iv$iv;
        CoroutineScope scope;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer3;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv3;
        Composer $composer$iv$iv$iv3;
        Composer $composer$iv4;
        Composer $composer$iv5;
        float f;
        Composer $composer4;
        Composer $composer5;
        char c;
        boolean z;
        PaddingValues paddingValues;
        Composer $composer6;
        int i2;
        final StickerManagerViewModel stickerViewModel;
        SoftwareKeyboardController softwareKeyboardController3;
        Composer $composer7;
        final CoroutineScope scope2;
        boolean invalid$iv6;
        Object value$iv2;
        SoftwareKeyboardController softwareKeyboardController4;
        Composer $composer8;
        boolean z2;
        KBehaviorAlertToast alertDialog;
        UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer4;
        EntityMessage deletingMsg;
        int i3;
        float f2;
        Modifier stickyModuleModifier;
        UserInfo userInfo;
        int i4;
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(frameBuilderProvider, "frameBuilderProvider");
        Intrinsics.checkNotNullParameter(pictureLifecycleKeyHandle, "pictureLifecycleKeyHandle");
        Composer $composer9 = $composer.startRestartGroup(-1187120957);
        ComposerKt.sourceInformation($composer9, "C(ChatPage)N(pageData,actionHandler,listState,frameBuilderProvider,pictureLifecycleKeyHandle,modifier,upgradeAnswerDialogDisplayer,showInputBox,defaultTitleName,reporter)125@5626L24,127@5721L7,129@5764L221,137@6041L242,146@6316L7,147@6349L179,147@6328L200,155@6548L20,159@6632L61,157@6584L109,164@6727L48,167@6805L142,167@6780L167,172@6979L229,172@6953L255,179@7239L7,181@7294L3162,181@7252L3204,253@10479L28,254@10537L13,255@10580L70,255@10555L95,259@10656L13014:ChatPage.kt#f7dpja");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer9.changed(pageData) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer9.changed(actionHandler) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer9.changed(listState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer9.changed(frameBuilderProvider) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty3 |= $composer9.changed(pictureLifecycleKeyHandle) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty3 |= $composer9.changed(modifier) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer9.changed(upgradeAnswerDialogDisplayer) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                showInputBox2 = showInputBox;
                if ($composer9.changed(showInputBox2)) {
                    i4 = 8388608;
                    $dirty3 |= i4;
                }
            } else {
                showInputBox2 = showInputBox;
            }
            i4 = 4194304;
            $dirty3 |= i4;
        } else {
            showInputBox2 = showInputBox;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer9.changed(defaultTitleName) ? 67108864 : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer9.changed(reporter) ? 536870912 : 268435456;
        }
        if ($composer9.shouldExecute(($dirty3 & 306783379) != 306783378, $dirty3 & 1)) {
            $composer9.startDefaults();
            if (($changed & 1) == 0 || $composer9.getDefaultsInvalid()) {
                Modifier modifier3 = i5 != 0 ? (Modifier) Modifier.Companion : modifier;
                UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer5 = i6 != 0 ? null : upgradeAnswerDialogDisplayer;
                if ((i & 128) != 0) {
                    ChatInfo chatInfo2 = pageData.getChatInfo();
                    showInputBox2 = (chatInfo2 != null ? chatInfo2.getInputBoxConfig() : null) != null;
                    $dirty3 &= -29360129;
                }
                defaultTitleName3 = i7 != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : defaultTitleName;
                if (i8 != 0) {
                    modifier2 = modifier3;
                    upgradeAnswerDialogDisplayer3 = upgradeAnswerDialogDisplayer5;
                    showInputBox3 = showInputBox2;
                    reporter3 = null;
                    $dirty = $dirty3;
                } else {
                    modifier2 = modifier3;
                    upgradeAnswerDialogDisplayer3 = upgradeAnswerDialogDisplayer5;
                    showInputBox3 = showInputBox2;
                    reporter3 = reporter;
                    $dirty = $dirty3;
                }
            } else {
                $composer9.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                modifier2 = modifier;
                upgradeAnswerDialogDisplayer3 = upgradeAnswerDialogDisplayer;
                defaultTitleName3 = defaultTitleName;
                $dirty = $dirty3;
                showInputBox3 = showInputBox2;
                reporter3 = reporter;
            }
            $composer9.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1187120957, $dirty, -1, "kntr.app.im.chat.ui.ChatPage (ChatPage.kt:124)");
            }
            ComposerKt.sourceInformationMarkerStart($composer9, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer9, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer9.rememberedValue();
            final ChatReporter reporter4 = reporter3;
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer9);
                $composer9.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope3 = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            final String defaultTitleName4 = defaultTitleName3;
            ComposerKt.sourceInformationMarkerStart($composer9, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer9.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            SoftwareKeyboardController softwareKeyboardController5 = (SoftwareKeyboardController) consume;
            ComposerKt.sourceInformationMarkerStart($composer9, 1638082112, "CC(remember):ChatPage.kt#9igjgp");
            Object it$iv5 = $composer9.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                softwareKeyboardController = softwareKeyboardController5;
                Object value$iv3 = ((StickerEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(StickerEntryPoint.class))).getStickerEntryComponentFactory().build().stickerManagerViewModel();
                $composer9.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
            } else {
                softwareKeyboardController = softwareKeyboardController5;
            }
            StickerManagerViewModel stickerViewModel2 = (StickerManagerViewModel) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            Flow<StickerManagerData> state = stickerViewModel2.getState();
            Object value = stickerViewModel2.getAccountStore().getState().getValue();
            AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
            State stickerManagerState$delegate = SnapshotStateKt.collectAsState(state, new StickerManagerData((logged == null || (userInfo = logged.getUserInfo()) == null) ? 0L : userInfo.getMid(), null, null, null, false, null, false, false, 254, null), (CoroutineContext) null, $composer9, 0, 2);
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer6 = upgradeAnswerDialogDisplayer3;
            ComposerKt.sourceInformationMarkerStart($composer9, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer9.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            Toaster toaster = (Toaster) consume2;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer9, 1638100790, "CC(remember):ChatPage.kt#9igjgp");
            boolean invalid$iv7 = $composer9.changed(stickerManagerState$delegate) | $composer9.changedInstance(toaster);
            Object it$iv6 = $composer9.rememberedValue();
            if (invalid$iv7) {
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            } else {
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                if (it$iv6 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer9, 6);
                    Activity context = PlatformContext_androidKt.getPlatformContext($composer9, 0);
                    ComposerKt.sourceInformationMarkerStart($composer9, 1638109728, "CC(remember):ChatPage.kt#9igjgp");
                    invalid$iv = ($dirty & 112) != 32;
                    it$iv = $composer9.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        str2 = "CC(remember):ChatPage.kt#9igjgp";
                        obj = null;
                        Object value$iv4 = (Function1) new ChatPageKt$ChatPage$2$1(actionHandler, null);
                        $composer9.updateRememberedValue(value$iv4);
                        it$iv = value$iv4;
                    } else {
                        str2 = "CC(remember):ChatPage.kt#9igjgp";
                        obj = null;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    String str4 = str;
                    String str5 = str2;
                    int $dirty4 = $dirty;
                    SoftwareKeyboardController softwareKeyboardController6 = softwareKeyboardController;
                    LoadMoreListStateKt.applyLoadMoreEffects(listState, 5, (Function1) null, (Function1) it$iv, $composer9, (($dirty >> 6) & 14) | 48, 2);
                    ComposerKt.sourceInformationMarkerStart($composer9, 1638112755, str5);
                    it$iv2 = $composer9.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new InputBoxState();
                        $composer9.updateRememberedValue(value$iv5);
                        it$iv2 = value$iv5;
                    }
                    inputBoxState = (InputBoxState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    ComposerKt.sourceInformationMarkerStart($composer9, 1638115345, str5);
                    invalid$iv2 = ($dirty4 & 14) != 4;
                    it$iv3 = $composer9.rememberedValue();
                    if (!invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = (Function2) new ChatPageKt$ChatPage$3$1(inputBoxState, pageData, null);
                        $composer9.updateRememberedValue(value$iv6);
                        it$iv3 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    EffectsKt.LaunchedEffect(pageData, (Function2) it$iv3, $composer9, $dirty4 & 14);
                    ComposerKt.sourceInformationMarkerStart($composer9, 1638121000, str5);
                    invalid$iv3 = (($dirty4 & 896) != 256) | (($dirty4 & 112) != 32) | $composer9.changed(softwareKeyboardController6);
                    Object it$iv7 = $composer9.rememberedValue();
                    if (!invalid$iv3 && it$iv7 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        EffectsKt.LaunchedEffect(listState, (Function2) it$iv7, $composer9, ($dirty4 >> 6) & 14);
                        CompositionLocal this_$iv3 = RouterKt.getLocalRouter();
                        ComposerKt.sourceInformationMarkerStart($composer9, 2023513938, str4);
                        Object consume3 = $composer9.consume(this_$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        router = (Router) consume3;
                        previewImageData = pageData.getPreviewImageData();
                        ComposerKt.sourceInformationMarkerStart($composer9, 1638134013, str5);
                        invalid$iv4 = (($dirty4 & 14) != 4) | (($dirty4 & 112) != 32) | $composer9.changedInstance(router) | $composer9.changedInstance(context) | (($dirty4 & 57344) != 16384);
                        value$iv = $composer9.rememberedValue();
                        if (!invalid$iv4 || value$iv == Composer.Companion.getEmpty()) {
                            previewImageData2 = previewImageData;
                            softwareKeyboardController2 = softwareKeyboardController6;
                            $dirty2 = $dirty4;
                            inputBoxState2 = inputBoxState;
                            router2 = router;
                            str3 = str5;
                            value$iv = new ChatPageKt$ChatPage$5$1(pageData, router, context, pictureLifecycleKeyHandle, actionHandler, null);
                            $composer9.updateRememberedValue(value$iv);
                        } else {
                            previewImageData2 = previewImageData;
                            $dirty2 = $dirty4;
                            inputBoxState2 = inputBoxState;
                            router2 = router;
                            str3 = str5;
                            softwareKeyboardController2 = softwareKeyboardController6;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        EffectsKt.LaunchedEffect(previewImageData2, (Function2) value$iv, $composer9, PreviewImageData.$stable);
                        SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer9, 0);
                        Enum dayNightTheme = BiliTheme.INSTANCE.getDayNightTheme($composer9, BiliTheme.$stable);
                        ComposerKt.sourceInformationMarkerStart($composer9, 1638236073, str3);
                        invalid$iv5 = $composer9.changed(controller) | $composer9.changed(dayNightTheme.ordinal());
                        it$iv4 = $composer9.rememberedValue();
                        if (!invalid$iv5 || it$iv4 == Composer.Companion.getEmpty()) {
                            Object value$iv7 = (Function2) new ChatPageKt$ChatPage$6$1(controller, dayNightTheme, null);
                            $composer9.updateRememberedValue(value$iv7);
                            it$iv4 = value$iv7;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        EffectsKt.LaunchedEffect(dayNightTheme, (Function2) it$iv4, $composer9, 0);
                        int $changed$iv = ($dirty2 >> 15) & 14;
                        Modifier modifier$iv = modifier2;
                        ComposerKt.sourceInformationMarkerStart($composer9, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = ($changed$iv << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                        CompositionLocalMap localMap$iv$iv = $composer9.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer9, modifier$iv);
                        Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer9.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer9.startReusableNode();
                        if ($composer9.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer9.useNode();
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer9.createNode(factory$iv$iv$iv);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer9);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer9, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i10 = (($changed$iv >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer9, 1665081293, "C260@10753L6,260@10691L7773,496@21788L20,497@21898L898,497@21817L979:ChatPage.kt#f7dpja");
                        Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer9, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer9, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer9.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer9, modifier$iv2);
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer9.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer9.startReusableNode();
                        if ($composer9.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer9.useNode();
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer9.createNode(factory$iv$iv$iv2);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer9);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer9, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        int i12 = ((0 >> 6) & 112) | 6;
                        ColumnScope $this$ChatPage_u24lambda_u249_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer9, 976000874, "C270@11125L6,271@11177L6,275@11335L2480,272@11227L75,325@13849L1481,268@11039L4306,380@16449L363:ChatPage.kt#f7dpja");
                        chatInfo = pageData.getChatInfo();
                        backgroundImg = chatInfo == null ? chatInfo.getBackgroundImg() : null;
                        if (backgroundImg != null || backgroundImg.length() == 0) {
                            $composer$iv = $composer9;
                            $composer9.startReplaceGroup(975949351);
                            ComposerKt.sourceInformation($composer9, "266@10998L6");
                            bgColor = BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg1-0d7_KjU();
                            $composer9.endReplaceGroup();
                        } else {
                            $composer9.startReplaceGroup(975883879);
                            ComposerKt.sourceInformation($composer9, "264@10932L6");
                            $composer$iv = $composer9;
                            bgColor = BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg2-0d7_KjU();
                            $composer9.endReplaceGroup();
                        }
                        IMTopBarKt.IMTopBar--nWoaYo(ComposableLambdaKt.rememberComposableLambda(-585010130, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit ChatPage$lambda$9$0$0;
                                ChatPage$lambda$9$0$0 = ChatPageKt.ChatPage$lambda$9$0$0(ChatInfo.this, defaultTitleName4, scope3, actionHandler, (Composer) obj2, ((Integer) obj3).intValue());
                                return ChatPage$lambda$9$0$0;
                            }
                        }, $composer9, 54), (Modifier) null, BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText1-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText2-0d7_KjU(), false, false, (Function0) null, ComposableLambdaKt.rememberComposableLambda(1333176286, true, new Function3() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                Unit ChatPage$lambda$9$0$1;
                                ChatPage$lambda$9$0$1 = ChatPageKt.ChatPage$lambda$9$0$1(bgColor, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                return ChatPage$lambda$9$0$1;
                            }
                        }, $composer9, 54), ComposableLambdaKt.rememberComposableLambda(1859855414, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit ChatPage$lambda$9$0$2;
                                ChatPage$lambda$9$0$2 = ChatPageKt.ChatPage$lambda$9$0$2(ChatInfo.this, scope3, actionHandler, reporter4, (Composer) obj2, ((Integer) obj3).intValue());
                                return ChatPage$lambda$9$0$2;
                            }
                        }, $composer9, 54), $composer9, 113270790, 98);
                        if (chatInfo == null) {
                            $composer9.startReplaceGroup(980358915);
                            ComposerKt.sourceInformation($composer9, "373@16208L214");
                            ChatInfo chatInfo3 = pageData.getChatInfo();
                            String backgroundImg2 = chatInfo3 != null ? chatInfo3.getBackgroundImg() : null;
                            if (backgroundImg2 == null || backgroundImg2.length() == 0) {
                                $composer9.startReplaceGroup(980456844);
                                ComposerKt.sourceInformation($composer9, "362@15671L6,365@15867L6");
                                stickyModuleModifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(56)), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
                                $composer9.endReplaceGroup();
                            } else {
                                $composer9.startReplaceGroup(980862572);
                                ComposerKt.sourceInformation($composer9, "370@16084L6");
                                stickyModuleModifier = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(56)), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4));
                                $composer9.endReplaceGroup();
                            }
                            modifier$iv$iv = modifier$iv;
                            f = 0.0f;
                            $composer$iv$iv$iv3 = $composer9;
                            $composer4 = $composer9;
                            $composer$iv2 = $composer9;
                            $composer$iv3 = $composer9;
                            $composer$iv4 = $composer$iv;
                            $composer3 = $composer9;
                            scope = scope3;
                            $composer$iv5 = $composer9;
                            $composer$iv$iv$iv = $composer9;
                            $composer$iv$iv$iv2 = $composer9;
                            reporter2 = reporter4;
                            StickyBarKt.StickyBar(chatInfo, actionHandler, stickyModuleModifier, reporter4, $composer9, ($dirty2 & 112) | (($dirty2 >> 18) & 7168), 0);
                            $composer9.endReplaceGroup();
                            $composer5 = $composer9;
                        } else {
                            modifier$iv$iv = modifier$iv;
                            scope = scope3;
                            $composer$iv2 = $composer9;
                            $composer$iv$iv$iv = $composer9;
                            $composer3 = $composer9;
                            $composer$iv$iv$iv2 = $composer9;
                            $composer$iv3 = $composer9;
                            $composer$iv$iv$iv3 = $composer9;
                            $composer$iv4 = $composer$iv;
                            $composer$iv5 = $composer9;
                            f = 0.0f;
                            reporter2 = reporter4;
                            $composer4 = $composer9;
                            $composer5 = $composer9;
                            $composer5.startReplaceGroup(965068227);
                            $composer5.endReplaceGroup();
                        }
                        if (showInputBox3) {
                            $composer5.startReplaceGroup(2109876208);
                            ComposerKt.sourceInformation($composer5, "384@16702L14,384@16717L17");
                            c = 6;
                            z = false;
                            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer5, 6), $composer5, 0);
                            $composer5.endReplaceGroup();
                            paddingValues = asPaddingValues;
                        } else {
                            $composer5.startReplaceGroup(2109874204);
                            $composer5.endReplaceGroup();
                            paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null);
                            z = false;
                            c = 6;
                        }
                        $composer6 = $composer5;
                        float f3 = f;
                        defaultTitleName2 = defaultTitleName4;
                        ChatMessageListKt.ChatMessageList(pageData, listState, frameBuilderProvider, paddingValues, ColumnScope.-CC.weight$default($this$ChatPage_u24lambda_u249_u240, SizeKt.fillMaxWidth$default(Modifier.Companion, f, 1, (Object) null), 1.0f, false, 2, (Object) null), $composer5, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                        if (showInputBox3 || inputBoxState2.getInputBoxContent() == null) {
                            i2 = 6;
                            $composer6.startReplaceGroup(965068227);
                        } else {
                            $composer6.startReplaceGroup(981867778);
                            ComposerKt.sourceInformation($composer6, "393@17079L6,389@16903L552,406@17592L6,403@17473L967");
                            i2 = 6;
                            InputBoxKt.InputBox(inputBoxState2, !pageData.getInputContent().getSelectedAssets().isEmpty(), pageData.getInputBoxSelectState(), actionHandler, BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, f3, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), $composer6, (($dirty2 << 6) & 7168) | 6, 0);
                            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                            if (pageData.isBottomSheetVisible()) {
                                $composer6.startReplaceGroup(982697059);
                                ComposerKt.sourceInformation($composer6, "411@17899L14,412@17959L17");
                                i3 = 0;
                                f2 = Dp.constructor-impl(ChatMediaSelectBottomSheetDefaults.INSTANCE.m1919getPeekHeightD9Ej5fM() + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer6, 6), $composer6, 0).calculateBottomPadding-D9Ej5fM());
                                $composer6.endReplaceGroup();
                            } else {
                                i3 = 0;
                                $composer6.startReplaceGroup(983019490);
                                ComposerKt.sourceInformation($composer6, "415@18137L3,416@18201L14,417@18258L17");
                                f2 = WindowInsetsKt.asPaddingValues(WindowInsetsKt.union(WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer6, 6), WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer6, 6)), $composer6, 0).calculateBottomPadding-D9Ej5fM();
                                $composer6.endReplaceGroup();
                            }
                            BoxKt.Box(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(modifier4, f2), 0.0f, 1, (Object) null), $composer6, i3);
                        }
                        $composer6.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        $composer$iv$iv$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        if (showInputBox3) {
                            $composer2 = $composer9;
                            stickerViewModel = stickerViewModel2;
                            softwareKeyboardController3 = softwareKeyboardController2;
                            $composer7 = $composer3;
                            scope2 = scope;
                            $composer7.startReplaceGroup(1654072665);
                        } else {
                            $composer7 = $composer3;
                            $composer7.startReplaceGroup(1672518192);
                            ComposerKt.sourceInformation($composer7, RoomRecommendViewModel.EMPTY_CURSOR);
                            if (pageData.isBottomSheetVisible()) {
                                $composer7.startReplaceGroup(1672564971);
                                ComposerKt.sourceInformation($composer7, "426@18579L74,426@18558L95,438@19064L254,452@19648L1589,481@21283L169,445@19367L237,486@21499L222,430@18671L3069");
                                Unit unit2 = Unit.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer7, -1747163501, str3);
                                softwareKeyboardController3 = softwareKeyboardController2;
                                boolean invalid$iv8 = $composer7.changed(softwareKeyboardController3);
                                Object it$iv8 = $composer7.rememberedValue();
                                if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                                    Object value$iv8 = (Function2) new ChatPageKt$ChatPage$7$2$1(softwareKeyboardController3, null);
                                    $composer7.updateRememberedValue(value$iv8);
                                    it$iv8 = value$iv8;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                EffectsKt.LaunchedEffect(unit2, (Function2) it$iv8, $composer7, i2);
                                SessionId sessionId = pageData.getSessionId();
                                InputBoxSelectState inputBoxSelectState = pageData.getInputBoxSelectState();
                                Modifier navigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null));
                                ComposerKt.sourceInformationMarkerStart($composer7, -1747147801, str3);
                                scope2 = scope;
                                boolean invalid$iv9 = $composer9.changedInstance(scope2) | (($dirty2 & 112) == 32);
                                Object it$iv9 = $composer7.rememberedValue();
                                if (invalid$iv9 || it$iv9 == Composer.Companion.getEmpty()) {
                                    Object value$iv9 = new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda8
                                        public final Object invoke() {
                                            Unit ChatPage$lambda$9$2$0;
                                            ChatPage$lambda$9$2$0 = ChatPageKt.ChatPage$lambda$9$2$0(scope2, actionHandler);
                                            return ChatPage$lambda$9$2$0;
                                        }
                                    };
                                    $composer7.updateRememberedValue(value$iv9);
                                    it$iv9 = value$iv9;
                                }
                                Function0 function0 = (Function0) it$iv9;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                ComposerKt.sourceInformationMarkerStart($composer7, -1747127778, str3);
                                boolean invalid$iv10 = $composer9.changedInstance(scope2) | (($dirty2 & 112) == 32);
                                Object it$iv10 = $composer7.rememberedValue();
                                if (invalid$iv10 || it$iv10 == Composer.Companion.getEmpty()) {
                                    Object value$iv10 = new Function1() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda9
                                        public final Object invoke(Object obj2) {
                                            Unit ChatPage$lambda$9$3$0;
                                            ChatPage$lambda$9$3$0 = ChatPageKt.ChatPage$lambda$9$3$0(scope2, actionHandler, (Emote) obj2);
                                            return ChatPage$lambda$9$3$0;
                                        }
                                    };
                                    $composer7.updateRememberedValue(value$iv10);
                                    it$iv10 = value$iv10;
                                }
                                Function1 function1 = (Function1) it$iv10;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                ComposerKt.sourceInformationMarkerStart($composer7, -1747076878, str3);
                                boolean invalid$iv11 = $composer9.changedInstance(scope2) | (($dirty2 & 112) == 32);
                                Object it$iv11 = $composer7.rememberedValue();
                                if (invalid$iv11 || it$iv11 == Composer.Companion.getEmpty()) {
                                    Object value$iv11 = new Function1() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda10
                                        public final Object invoke(Object obj2) {
                                            Unit ChatPage$lambda$9$4$0;
                                            ChatPage$lambda$9$4$0 = ChatPageKt.ChatPage$lambda$9$4$0(scope2, actionHandler, (StickerAsset) obj2);
                                            return ChatPage$lambda$9$4$0;
                                        }
                                    };
                                    $composer7.updateRememberedValue(value$iv11);
                                    it$iv11 = value$iv11;
                                }
                                Function1 function12 = (Function1) it$iv11;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                ComposerKt.sourceInformationMarkerStart($composer7, -1747138122, str3);
                                boolean invalid$iv12 = $composer9.changedInstance(scope2) | (($dirty2 & 112) == 32);
                                Object it$iv12 = $composer7.rememberedValue();
                                if (invalid$iv12 || it$iv12 == Composer.Companion.getEmpty()) {
                                    Object value$iv12 = new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda11
                                        public final Object invoke() {
                                            Unit ChatPage$lambda$9$5$0;
                                            ChatPage$lambda$9$5$0 = ChatPageKt.ChatPage$lambda$9$5$0(scope2, actionHandler);
                                            return ChatPage$lambda$9$5$0;
                                        }
                                    };
                                    $composer7.updateRememberedValue(value$iv12);
                                    it$iv12 = value$iv12;
                                }
                                Function0 function02 = (Function0) it$iv12;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                ComposerKt.sourceInformationMarkerStart($composer7, -1747069913, str3);
                                stickerViewModel = stickerViewModel2;
                                boolean invalid$iv13 = $composer7.changedInstance(scope2) | $composer7.changedInstance(stickerViewModel);
                                Object it$iv13 = $composer7.rememberedValue();
                                if (invalid$iv13 || it$iv13 == Composer.Companion.getEmpty()) {
                                    Object value$iv13 = new Function1() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj2) {
                                            Unit ChatPage$lambda$9$6$0;
                                            ChatPage$lambda$9$6$0 = ChatPageKt.ChatPage$lambda$9$6$0(scope2, stickerViewModel, (StickerAction) obj2);
                                            return ChatPage$lambda$9$6$0;
                                        }
                                    };
                                    $composer7.updateRememberedValue(value$iv13);
                                    it$iv13 = value$iv13;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                $composer2 = $composer9;
                                ChatBottomSheetKt.ChatBottomSheet(sessionId, inputBoxSelectState, actionHandler, function0, navigationBarsPadding, false, function1, function12, function02, (Function1) it$iv13, null, null, $composer7, ($dirty2 << 3) & 896, 0, 3104);
                                $composer7.endReplaceGroup();
                            } else {
                                $composer2 = $composer9;
                                stickerViewModel = stickerViewModel2;
                                softwareKeyboardController3 = softwareKeyboardController2;
                                scope2 = scope;
                                $composer7.startReplaceGroup(1654072665);
                                $composer7.endReplaceGroup();
                            }
                        }
                        $composer7.endReplaceGroup();
                        Activity context2 = PlatformContext_androidKt.getPlatformContext($composer7, 0);
                        ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus = pageData.getUpgradeAnswerDialogStatus();
                        ComposerKt.sourceInformationMarkerStart($composer7, -1747056469, str3);
                        invalid$iv6 = (($dirty2 & 14) != 4) | (($dirty2 & 3670016) != 1048576) | $composer2.changed(softwareKeyboardController3) | (($dirty2 & 112) != 32) | $composer2.changedInstance(context2) | $composer2.changedInstance(scope2);
                        Composer $this$cache$iv = $composer7;
                        value$iv2 = $this$cache$iv.rememberedValue();
                        if (!invalid$iv6 || value$iv2 == Composer.Companion.getEmpty()) {
                            softwareKeyboardController4 = softwareKeyboardController3;
                            $composer8 = $composer7;
                            z2 = false;
                            value$iv2 = new ChatPageKt$ChatPage$7$8$1(pageData, upgradeAnswerDialogDisplayer6, softwareKeyboardController3, actionHandler, context2, scope2, null);
                            $this$cache$iv.updateRememberedValue(value$iv2);
                        } else {
                            softwareKeyboardController4 = softwareKeyboardController3;
                            $composer8 = $composer7;
                            z2 = false;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer8);
                        Composer $composer10 = $composer8;
                        EffectsKt.LaunchedEffect(upgradeAnswerDialogDisplayer6, upgradeAnswerDialogStatus, (Function2) value$iv2, $composer10, ($dirty2 >> 18) & 14);
                        alertDialog = pageData.getDisplayingBehaviorAlert();
                        if (alertDialog == null) {
                            $composer10.startReplaceGroup(1676796378);
                            ComposerKt.sourceInformation($composer10, "520@22924L66,520@22903L87,525@23081L147,523@23003L240,531@23277L145,531@23256L166");
                            Unit unit3 = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer10, -1747024469, str3);
                            SoftwareKeyboardController softwareKeyboardController7 = softwareKeyboardController4;
                            boolean invalid$iv14 = $composer10.changed(softwareKeyboardController7);
                            Object it$iv14 = $composer10.rememberedValue();
                            if (invalid$iv14 || it$iv14 == Composer.Companion.getEmpty()) {
                                upgradeAnswerDialogDisplayer4 = upgradeAnswerDialogDisplayer6;
                                Object value$iv14 = (Function2) new ChatPageKt$ChatPage$7$9$1(softwareKeyboardController7, null);
                                $composer10.updateRememberedValue(value$iv14);
                                it$iv14 = value$iv14;
                            } else {
                                upgradeAnswerDialogDisplayer4 = upgradeAnswerDialogDisplayer6;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer10);
                            EffectsKt.LaunchedEffect(unit3, (Function2) it$iv14, $composer10, 6);
                            ComposerKt.sourceInformationMarkerStart($composer10, -1747019364, str3);
                            boolean invalid$iv15 = $composer2.changedInstance(scope2) | (($dirty2 & 112) == 32 ? true : z2);
                            Object it$iv15 = $composer10.rememberedValue();
                            if (invalid$iv15 || it$iv15 == Composer.Companion.getEmpty()) {
                                Object value$iv15 = new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda3
                                    public final Object invoke() {
                                        Unit ChatPage$lambda$9$9$0;
                                        ChatPage$lambda$9$9$0 = ChatPageKt.ChatPage$lambda$9$9$0(scope2, actionHandler);
                                        return ChatPage$lambda$9$9$0;
                                    }
                                };
                                $composer10.updateRememberedValue(value$iv15);
                                it$iv15 = value$iv15;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer10);
                            BehaviorAlertDialogKt.BehaviorAlertDialog(alertDialog, (Function0) it$iv15, null, $composer10, 0, 4);
                            Unit unit4 = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer10, -1747013094, str3);
                            boolean invalid$iv16 = ($dirty2 & 112) == 32 ? true : z2;
                            Object it$iv16 = $composer10.rememberedValue();
                            if (invalid$iv16 || it$iv16 == Composer.Companion.getEmpty()) {
                                Object value$iv16 = (Function2) new ChatPageKt$ChatPage$7$11$1(actionHandler, null);
                                $composer10.updateRememberedValue(value$iv16);
                                it$iv16 = value$iv16;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer10);
                            EffectsKt.LaunchedEffect(unit4, (Function2) it$iv16, $composer10, 6);
                        } else {
                            upgradeAnswerDialogDisplayer4 = upgradeAnswerDialogDisplayer6;
                            $composer10.startReplaceGroup(1654072665);
                        }
                        $composer10.endReplaceGroup();
                        deletingMsg = pageData.getDeletingMsg();
                        if (deletingMsg == null) {
                            $composer10.startReplaceGroup(1677403234);
                            ComposerKt.sourceInformation($composer10, "539@23527L127");
                            DeleteMessageConfirmDialogKt.DeleteMessageConfirmDialog(deletingMsg, actionHandler, $composer10, $dirty2 & 112);
                        } else {
                            $composer10.startReplaceGroup(1654072665);
                        }
                        $composer10.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer10);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        upgradeAnswerDialogDisplayer2 = upgradeAnswerDialogDisplayer4;
                    }
                    Object value$iv17 = (Function2) new ChatPageKt$ChatPage$4$1(listState, actionHandler, softwareKeyboardController6, null);
                    $composer9.updateRememberedValue(value$iv17);
                    it$iv7 = value$iv17;
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    EffectsKt.LaunchedEffect(listState, (Function2) it$iv7, $composer9, ($dirty4 >> 6) & 14);
                    CompositionLocal this_$iv32 = RouterKt.getLocalRouter();
                    ComposerKt.sourceInformationMarkerStart($composer9, 2023513938, str4);
                    Object consume32 = $composer9.consume(this_$iv32);
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    router = (Router) consume32;
                    previewImageData = pageData.getPreviewImageData();
                    ComposerKt.sourceInformationMarkerStart($composer9, 1638134013, str5);
                    invalid$iv4 = (($dirty4 & 14) != 4) | (($dirty4 & 112) != 32) | $composer9.changedInstance(router) | $composer9.changedInstance(context) | (($dirty4 & 57344) != 16384);
                    value$iv = $composer9.rememberedValue();
                    if (invalid$iv4) {
                    }
                    previewImageData2 = previewImageData;
                    softwareKeyboardController2 = softwareKeyboardController6;
                    $dirty2 = $dirty4;
                    inputBoxState2 = inputBoxState;
                    router2 = router;
                    str3 = str5;
                    value$iv = new ChatPageKt$ChatPage$5$1(pageData, router, context, pictureLifecycleKeyHandle, actionHandler, null);
                    $composer9.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    EffectsKt.LaunchedEffect(previewImageData2, (Function2) value$iv, $composer9, PreviewImageData.$stable);
                    SystemUiController controller2 = SystemUI_androidKt.rememberSystemUiController($composer9, 0);
                    Enum dayNightTheme2 = BiliTheme.INSTANCE.getDayNightTheme($composer9, BiliTheme.$stable);
                    ComposerKt.sourceInformationMarkerStart($composer9, 1638236073, str3);
                    invalid$iv5 = $composer9.changed(controller2) | $composer9.changed(dayNightTheme2.ordinal());
                    it$iv4 = $composer9.rememberedValue();
                    if (!invalid$iv5) {
                    }
                    Object value$iv72 = (Function2) new ChatPageKt$ChatPage$6$1(controller2, dayNightTheme2, null);
                    $composer9.updateRememberedValue(value$iv72);
                    it$iv4 = value$iv72;
                    ComposerKt.sourceInformationMarkerEnd($composer9);
                    EffectsKt.LaunchedEffect(dayNightTheme2, (Function2) it$iv4, $composer9, 0);
                    int $changed$iv2 = ($dirty2 >> 15) & 14;
                    Modifier modifier$iv3 = modifier2;
                    ComposerKt.sourceInformationMarkerStart($composer9, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = ($changed$iv2 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer9.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer9, modifier$iv3);
                    Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer9.getApplier() instanceof Applier)) {
                    }
                    $composer9.startReusableNode();
                    if ($composer9.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer9);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i92 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer9, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i102 = (($changed$iv2 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer9, 1665081293, "C260@10753L6,260@10691L7773,496@21788L20,497@21898L898,497@21817L979:ChatPage.kt#f7dpja");
                    Modifier modifier$iv22 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer9, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer9, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv22 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer9.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer9, modifier$iv22);
                    Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer9.getApplier() instanceof Applier)) {
                    }
                    $composer9.startReusableNode();
                    if ($composer9.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer9);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i112 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer9, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    int i122 = ((0 >> 6) & 112) | 6;
                    ColumnScope $this$ChatPage_u24lambda_u249_u2402 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer9, 976000874, "C270@11125L6,271@11177L6,275@11335L2480,272@11227L75,325@13849L1481,268@11039L4306,380@16449L363:ChatPage.kt#f7dpja");
                    chatInfo = pageData.getChatInfo();
                    backgroundImg = chatInfo == null ? chatInfo.getBackgroundImg() : null;
                    if (backgroundImg != null || backgroundImg.length() == 0) {
                    }
                    IMTopBarKt.IMTopBar--nWoaYo(ComposableLambdaKt.rememberComposableLambda(-585010130, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit ChatPage$lambda$9$0$0;
                            ChatPage$lambda$9$0$0 = ChatPageKt.ChatPage$lambda$9$0$0(ChatInfo.this, defaultTitleName4, scope3, actionHandler, (Composer) obj2, ((Integer) obj3).intValue());
                            return ChatPage$lambda$9$0$0;
                        }
                    }, $composer9, 54), (Modifier) null, BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText1-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText2-0d7_KjU(), false, false, (Function0) null, ComposableLambdaKt.rememberComposableLambda(1333176286, true, new Function3() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            Unit ChatPage$lambda$9$0$1;
                            ChatPage$lambda$9$0$1 = ChatPageKt.ChatPage$lambda$9$0$1(bgColor, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            return ChatPage$lambda$9$0$1;
                        }
                    }, $composer9, 54), ComposableLambdaKt.rememberComposableLambda(1859855414, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit ChatPage$lambda$9$0$2;
                            ChatPage$lambda$9$0$2 = ChatPageKt.ChatPage$lambda$9$0$2(ChatInfo.this, scope3, actionHandler, reporter4, (Composer) obj2, ((Integer) obj3).intValue());
                            return ChatPage$lambda$9$0$2;
                        }
                    }, $composer9, 54), $composer9, 113270790, 98);
                    if (chatInfo == null) {
                    }
                    if (showInputBox3) {
                    }
                    $composer6 = $composer5;
                    float f32 = f;
                    defaultTitleName2 = defaultTitleName4;
                    ChatMessageListKt.ChatMessageList(pageData, listState, frameBuilderProvider, paddingValues, ColumnScope.-CC.weight$default($this$ChatPage_u24lambda_u249_u2402, SizeKt.fillMaxWidth$default(Modifier.Companion, f, 1, (Object) null), 1.0f, false, 2, (Object) null), $composer5, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                    if (showInputBox3) {
                    }
                    i2 = 6;
                    $composer6.startReplaceGroup(965068227);
                    $composer6.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv$iv$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    if (showInputBox3) {
                    }
                    $composer7.endReplaceGroup();
                    Activity context22 = PlatformContext_androidKt.getPlatformContext($composer7, 0);
                    ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus2 = pageData.getUpgradeAnswerDialogStatus();
                    ComposerKt.sourceInformationMarkerStart($composer7, -1747056469, str3);
                    invalid$iv6 = (($dirty2 & 14) != 4) | (($dirty2 & 3670016) != 1048576) | $composer2.changed(softwareKeyboardController3) | (($dirty2 & 112) != 32) | $composer2.changedInstance(context22) | $composer2.changedInstance(scope2);
                    Composer $this$cache$iv2 = $composer7;
                    value$iv2 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv6) {
                    }
                    softwareKeyboardController4 = softwareKeyboardController3;
                    $composer8 = $composer7;
                    z2 = false;
                    value$iv2 = new ChatPageKt$ChatPage$7$8$1(pageData, upgradeAnswerDialogDisplayer6, softwareKeyboardController3, actionHandler, context22, scope2, null);
                    $this$cache$iv2.updateRememberedValue(value$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    Composer $composer102 = $composer8;
                    EffectsKt.LaunchedEffect(upgradeAnswerDialogDisplayer6, upgradeAnswerDialogStatus2, (Function2) value$iv2, $composer102, ($dirty2 >> 18) & 14);
                    alertDialog = pageData.getDisplayingBehaviorAlert();
                    if (alertDialog == null) {
                    }
                    $composer102.endReplaceGroup();
                    deletingMsg = pageData.getDeletingMsg();
                    if (deletingMsg == null) {
                    }
                    $composer102.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer102);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    upgradeAnswerDialogDisplayer2 = upgradeAnswerDialogDisplayer4;
                }
            }
            Object value$iv18 = (Function2) new ChatPageKt$ChatPage$1$1(stickerManagerState$delegate, toaster, null);
            $composer9.updateRememberedValue(value$iv18);
            it$iv6 = value$iv18;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer9, 6);
            Activity context3 = PlatformContext_androidKt.getPlatformContext($composer9, 0);
            ComposerKt.sourceInformationMarkerStart($composer9, 1638109728, "CC(remember):ChatPage.kt#9igjgp");
            if (($dirty & 112) != 32) {
            }
            it$iv = $composer9.rememberedValue();
            if (invalid$iv) {
            }
            str2 = "CC(remember):ChatPage.kt#9igjgp";
            obj = null;
            Object value$iv42 = (Function1) new ChatPageKt$ChatPage$2$1(actionHandler, null);
            $composer9.updateRememberedValue(value$iv42);
            it$iv = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            String str42 = str;
            String str52 = str2;
            int $dirty42 = $dirty;
            SoftwareKeyboardController softwareKeyboardController62 = softwareKeyboardController;
            LoadMoreListStateKt.applyLoadMoreEffects(listState, 5, (Function1) null, (Function1) it$iv, $composer9, (($dirty >> 6) & 14) | 48, 2);
            ComposerKt.sourceInformationMarkerStart($composer9, 1638112755, str52);
            it$iv2 = $composer9.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            inputBoxState = (InputBoxState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerStart($composer9, 1638115345, str52);
            if (($dirty42 & 14) != 4) {
            }
            it$iv3 = $composer9.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv62 = (Function2) new ChatPageKt$ChatPage$3$1(inputBoxState, pageData, null);
            $composer9.updateRememberedValue(value$iv62);
            it$iv3 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            EffectsKt.LaunchedEffect(pageData, (Function2) it$iv3, $composer9, $dirty42 & 14);
            ComposerKt.sourceInformationMarkerStart($composer9, 1638121000, str52);
            invalid$iv3 = (($dirty42 & 896) != 256) | (($dirty42 & 112) != 32) | $composer9.changed(softwareKeyboardController62);
            Object it$iv72 = $composer9.rememberedValue();
            if (!invalid$iv3) {
                ComposerKt.sourceInformationMarkerEnd($composer9);
                EffectsKt.LaunchedEffect(listState, (Function2) it$iv72, $composer9, ($dirty42 >> 6) & 14);
                CompositionLocal this_$iv322 = RouterKt.getLocalRouter();
                ComposerKt.sourceInformationMarkerStart($composer9, 2023513938, str42);
                Object consume322 = $composer9.consume(this_$iv322);
                ComposerKt.sourceInformationMarkerEnd($composer9);
                router = (Router) consume322;
                previewImageData = pageData.getPreviewImageData();
                ComposerKt.sourceInformationMarkerStart($composer9, 1638134013, str52);
                invalid$iv4 = (($dirty42 & 14) != 4) | (($dirty42 & 112) != 32) | $composer9.changedInstance(router) | $composer9.changedInstance(context3) | (($dirty42 & 57344) != 16384);
                value$iv = $composer9.rememberedValue();
                if (invalid$iv4) {
                }
                previewImageData2 = previewImageData;
                softwareKeyboardController2 = softwareKeyboardController62;
                $dirty2 = $dirty42;
                inputBoxState2 = inputBoxState;
                router2 = router;
                str3 = str52;
                value$iv = new ChatPageKt$ChatPage$5$1(pageData, router, context3, pictureLifecycleKeyHandle, actionHandler, null);
                $composer9.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer9);
                EffectsKt.LaunchedEffect(previewImageData2, (Function2) value$iv, $composer9, PreviewImageData.$stable);
                SystemUiController controller22 = SystemUI_androidKt.rememberSystemUiController($composer9, 0);
                Enum dayNightTheme22 = BiliTheme.INSTANCE.getDayNightTheme($composer9, BiliTheme.$stable);
                ComposerKt.sourceInformationMarkerStart($composer9, 1638236073, str3);
                invalid$iv5 = $composer9.changed(controller22) | $composer9.changed(dayNightTheme22.ordinal());
                it$iv4 = $composer9.rememberedValue();
                if (!invalid$iv5) {
                }
                Object value$iv722 = (Function2) new ChatPageKt$ChatPage$6$1(controller22, dayNightTheme22, null);
                $composer9.updateRememberedValue(value$iv722);
                it$iv4 = value$iv722;
                ComposerKt.sourceInformationMarkerEnd($composer9);
                EffectsKt.LaunchedEffect(dayNightTheme22, (Function2) it$iv4, $composer9, 0);
                int $changed$iv22 = ($dirty2 >> 15) & 14;
                Modifier modifier$iv32 = modifier2;
                ComposerKt.sourceInformationMarkerStart($composer9, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv22 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                int $changed$iv$iv32 = ($changed$iv22 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                CompositionLocalMap localMap$iv$iv32 = $composer9.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer9, modifier$iv32);
                Function0 factory$iv$iv$iv322 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer9.getApplier() instanceof Applier)) {
                }
                $composer9.startReusableNode();
                if ($composer9.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer9);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                int i922 = ($changed$iv$iv$iv32 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer9, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                int i1022 = (($changed$iv22 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer9, 1665081293, "C260@10753L6,260@10691L7773,496@21788L20,497@21898L898,497@21817L979:ChatPage.kt#f7dpja");
                Modifier modifier$iv222 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer9, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer9, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv222 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                CompositionLocalMap localMap$iv$iv222 = $composer9.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer9, modifier$iv222);
                Function0 factory$iv$iv$iv422 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer9.getApplier() instanceof Applier)) {
                }
                $composer9.startReusableNode();
                if ($composer9.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer9);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                int i1122 = ($changed$iv$iv$iv222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer9, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i1222 = ((0 >> 6) & 112) | 6;
                ColumnScope $this$ChatPage_u24lambda_u249_u24022 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer9, 976000874, "C270@11125L6,271@11177L6,275@11335L2480,272@11227L75,325@13849L1481,268@11039L4306,380@16449L363:ChatPage.kt#f7dpja");
                chatInfo = pageData.getChatInfo();
                backgroundImg = chatInfo == null ? chatInfo.getBackgroundImg() : null;
                if (backgroundImg != null || backgroundImg.length() == 0) {
                }
                IMTopBarKt.IMTopBar--nWoaYo(ComposableLambdaKt.rememberComposableLambda(-585010130, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ChatPage$lambda$9$0$0;
                        ChatPage$lambda$9$0$0 = ChatPageKt.ChatPage$lambda$9$0$0(ChatInfo.this, defaultTitleName4, scope3, actionHandler, (Composer) obj2, ((Integer) obj3).intValue());
                        return ChatPage$lambda$9$0$0;
                    }
                }, $composer9, 54), (Modifier) null, BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText1-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText2-0d7_KjU(), false, false, (Function0) null, ComposableLambdaKt.rememberComposableLambda(1333176286, true, new Function3() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit ChatPage$lambda$9$0$1;
                        ChatPage$lambda$9$0$1 = ChatPageKt.ChatPage$lambda$9$0$1(bgColor, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return ChatPage$lambda$9$0$1;
                    }
                }, $composer9, 54), ComposableLambdaKt.rememberComposableLambda(1859855414, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ChatPage$lambda$9$0$2;
                        ChatPage$lambda$9$0$2 = ChatPageKt.ChatPage$lambda$9$0$2(ChatInfo.this, scope3, actionHandler, reporter4, (Composer) obj2, ((Integer) obj3).intValue());
                        return ChatPage$lambda$9$0$2;
                    }
                }, $composer9, 54), $composer9, 113270790, 98);
                if (chatInfo == null) {
                }
                if (showInputBox3) {
                }
                $composer6 = $composer5;
                float f322 = f;
                defaultTitleName2 = defaultTitleName4;
                ChatMessageListKt.ChatMessageList(pageData, listState, frameBuilderProvider, paddingValues, ColumnScope.-CC.weight$default($this$ChatPage_u24lambda_u249_u24022, SizeKt.fillMaxWidth$default(Modifier.Companion, f, 1, (Object) null), 1.0f, false, 2, (Object) null), $composer5, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
                if (showInputBox3) {
                }
                i2 = 6;
                $composer6.startReplaceGroup(965068227);
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv$iv$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                if (showInputBox3) {
                }
                $composer7.endReplaceGroup();
                Activity context222 = PlatformContext_androidKt.getPlatformContext($composer7, 0);
                ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus22 = pageData.getUpgradeAnswerDialogStatus();
                ComposerKt.sourceInformationMarkerStart($composer7, -1747056469, str3);
                invalid$iv6 = (($dirty2 & 14) != 4) | (($dirty2 & 3670016) != 1048576) | $composer2.changed(softwareKeyboardController3) | (($dirty2 & 112) != 32) | $composer2.changedInstance(context222) | $composer2.changedInstance(scope2);
                Composer $this$cache$iv22 = $composer7;
                value$iv2 = $this$cache$iv22.rememberedValue();
                if (invalid$iv6) {
                }
                softwareKeyboardController4 = softwareKeyboardController3;
                $composer8 = $composer7;
                z2 = false;
                value$iv2 = new ChatPageKt$ChatPage$7$8$1(pageData, upgradeAnswerDialogDisplayer6, softwareKeyboardController3, actionHandler, context222, scope2, null);
                $this$cache$iv22.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                Composer $composer1022 = $composer8;
                EffectsKt.LaunchedEffect(upgradeAnswerDialogDisplayer6, upgradeAnswerDialogStatus22, (Function2) value$iv2, $composer1022, ($dirty2 >> 18) & 14);
                alertDialog = pageData.getDisplayingBehaviorAlert();
                if (alertDialog == null) {
                }
                $composer1022.endReplaceGroup();
                deletingMsg = pageData.getDeletingMsg();
                if (deletingMsg == null) {
                }
                $composer1022.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer1022);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                if (ComposerKt.isTraceInProgress()) {
                }
                upgradeAnswerDialogDisplayer2 = upgradeAnswerDialogDisplayer4;
            }
            Object value$iv172 = (Function2) new ChatPageKt$ChatPage$4$1(listState, actionHandler, softwareKeyboardController62, null);
            $composer9.updateRememberedValue(value$iv172);
            it$iv72 = value$iv172;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            EffectsKt.LaunchedEffect(listState, (Function2) it$iv72, $composer9, ($dirty42 >> 6) & 14);
            CompositionLocal this_$iv3222 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer9, 2023513938, str42);
            Object consume3222 = $composer9.consume(this_$iv3222);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            router = (Router) consume3222;
            previewImageData = pageData.getPreviewImageData();
            ComposerKt.sourceInformationMarkerStart($composer9, 1638134013, str52);
            invalid$iv4 = (($dirty42 & 14) != 4) | (($dirty42 & 112) != 32) | $composer9.changedInstance(router) | $composer9.changedInstance(context3) | (($dirty42 & 57344) != 16384);
            value$iv = $composer9.rememberedValue();
            if (invalid$iv4) {
            }
            previewImageData2 = previewImageData;
            softwareKeyboardController2 = softwareKeyboardController62;
            $dirty2 = $dirty42;
            inputBoxState2 = inputBoxState;
            router2 = router;
            str3 = str52;
            value$iv = new ChatPageKt$ChatPage$5$1(pageData, router, context3, pictureLifecycleKeyHandle, actionHandler, null);
            $composer9.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            EffectsKt.LaunchedEffect(previewImageData2, (Function2) value$iv, $composer9, PreviewImageData.$stable);
            SystemUiController controller222 = SystemUI_androidKt.rememberSystemUiController($composer9, 0);
            Enum dayNightTheme222 = BiliTheme.INSTANCE.getDayNightTheme($composer9, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer9, 1638236073, str3);
            invalid$iv5 = $composer9.changed(controller222) | $composer9.changed(dayNightTheme222.ordinal());
            it$iv4 = $composer9.rememberedValue();
            if (!invalid$iv5) {
            }
            Object value$iv7222 = (Function2) new ChatPageKt$ChatPage$6$1(controller222, dayNightTheme222, null);
            $composer9.updateRememberedValue(value$iv7222);
            it$iv4 = value$iv7222;
            ComposerKt.sourceInformationMarkerEnd($composer9);
            EffectsKt.LaunchedEffect(dayNightTheme222, (Function2) it$iv4, $composer9, 0);
            int $changed$iv222 = ($dirty2 >> 15) & 14;
            Modifier modifier$iv322 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer9, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv222 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv322 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv222, false);
            int $changed$iv$iv322 = ($changed$iv222 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv322 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
            CompositionLocalMap localMap$iv$iv322 = $composer9.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv322 = ComposedModifierKt.materializeModifier($composer9, modifier$iv322);
            Function0 factory$iv$iv$iv3222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv322 = (($changed$iv$iv322 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer9.getApplier() instanceof Applier)) {
            }
            $composer9.startReusableNode();
            if ($composer9.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv322 = Updater.constructor-impl($composer9);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, measurePolicy$iv322, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, localMap$iv$iv322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv322, Integer.valueOf(compositeKeyHash$iv$iv322), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv322, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, materialized$iv$iv322, ComposeUiNode.Companion.getSetModifier());
            int i9222 = ($changed$iv$iv$iv322 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer9, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
            int i10222 = (($changed$iv222 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer9, 1665081293, "C260@10753L6,260@10691L7773,496@21788L20,497@21898L898,497@21817L979:ChatPage.kt#f7dpja");
            Modifier modifier$iv2222 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer9, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv222 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer9, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2222 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
            CompositionLocalMap localMap$iv$iv2222 = $composer9.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer9, modifier$iv2222);
            Function0 factory$iv$iv$iv4222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer9, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer9.getApplier() instanceof Applier)) {
            }
            $composer9.startReusableNode();
            if ($composer9.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer9);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
            int i11222 = ($changed$iv$iv$iv2222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer9, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i12222 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$ChatPage_u24lambda_u249_u240222 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer9, 976000874, "C270@11125L6,271@11177L6,275@11335L2480,272@11227L75,325@13849L1481,268@11039L4306,380@16449L363:ChatPage.kt#f7dpja");
            chatInfo = pageData.getChatInfo();
            backgroundImg = chatInfo == null ? chatInfo.getBackgroundImg() : null;
            if (backgroundImg != null || backgroundImg.length() == 0) {
            }
            IMTopBarKt.IMTopBar--nWoaYo(ComposableLambdaKt.rememberComposableLambda(-585010130, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ChatPage$lambda$9$0$0;
                    ChatPage$lambda$9$0$0 = ChatPageKt.ChatPage$lambda$9$0$0(ChatInfo.this, defaultTitleName4, scope3, actionHandler, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatPage$lambda$9$0$0;
                }
            }, $composer9, 54), (Modifier) null, BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText1-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText2-0d7_KjU(), false, false, (Function0) null, ComposableLambdaKt.rememberComposableLambda(1333176286, true, new Function3() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit ChatPage$lambda$9$0$1;
                    ChatPage$lambda$9$0$1 = ChatPageKt.ChatPage$lambda$9$0$1(bgColor, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return ChatPage$lambda$9$0$1;
                }
            }, $composer9, 54), ComposableLambdaKt.rememberComposableLambda(1859855414, true, new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ChatPage$lambda$9$0$2;
                    ChatPage$lambda$9$0$2 = ChatPageKt.ChatPage$lambda$9$0$2(ChatInfo.this, scope3, actionHandler, reporter4, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatPage$lambda$9$0$2;
                }
            }, $composer9, 54), $composer9, 113270790, 98);
            if (chatInfo == null) {
            }
            if (showInputBox3) {
            }
            $composer6 = $composer5;
            float f3222 = f;
            defaultTitleName2 = defaultTitleName4;
            ChatMessageListKt.ChatMessageList(pageData, listState, frameBuilderProvider, paddingValues, ColumnScope.-CC.weight$default($this$ChatPage_u24lambda_u249_u240222, SizeKt.fillMaxWidth$default(Modifier.Companion, f, 1, (Object) null), 1.0f, false, 2, (Object) null), $composer5, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
            if (showInputBox3) {
            }
            i2 = 6;
            $composer6.startReplaceGroup(965068227);
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (showInputBox3) {
            }
            $composer7.endReplaceGroup();
            Activity context2222 = PlatformContext_androidKt.getPlatformContext($composer7, 0);
            ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus222 = pageData.getUpgradeAnswerDialogStatus();
            ComposerKt.sourceInformationMarkerStart($composer7, -1747056469, str3);
            invalid$iv6 = (($dirty2 & 14) != 4) | (($dirty2 & 3670016) != 1048576) | $composer2.changed(softwareKeyboardController3) | (($dirty2 & 112) != 32) | $composer2.changedInstance(context2222) | $composer2.changedInstance(scope2);
            Composer $this$cache$iv222 = $composer7;
            value$iv2 = $this$cache$iv222.rememberedValue();
            if (invalid$iv6) {
            }
            softwareKeyboardController4 = softwareKeyboardController3;
            $composer8 = $composer7;
            z2 = false;
            value$iv2 = new ChatPageKt$ChatPage$7$8$1(pageData, upgradeAnswerDialogDisplayer6, softwareKeyboardController3, actionHandler, context2222, scope2, null);
            $this$cache$iv222.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            Composer $composer10222 = $composer8;
            EffectsKt.LaunchedEffect(upgradeAnswerDialogDisplayer6, upgradeAnswerDialogStatus222, (Function2) value$iv2, $composer10222, ($dirty2 >> 18) & 14);
            alertDialog = pageData.getDisplayingBehaviorAlert();
            if (alertDialog == null) {
            }
            $composer10222.endReplaceGroup();
            deletingMsg = pageData.getDeletingMsg();
            if (deletingMsg == null) {
            }
            $composer10222.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer10222);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            if (ComposerKt.isTraceInProgress()) {
            }
            upgradeAnswerDialogDisplayer2 = upgradeAnswerDialogDisplayer4;
        } else {
            $composer2 = $composer9;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            upgradeAnswerDialogDisplayer2 = upgradeAnswerDialogDisplayer;
            defaultTitleName2 = defaultTitleName;
            reporter2 = reporter;
            showInputBox3 = showInputBox2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer7 = upgradeAnswerDialogDisplayer2;
            final boolean z3 = showInputBox3;
            final String str6 = defaultTitleName2;
            final ChatReporter chatReporter = reporter2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ChatPage$lambda$10;
                    ChatPage$lambda$10 = ChatPageKt.ChatPage$lambda$10(ChatPageData.this, actionHandler, listState, frameBuilderProvider, pictureLifecycleKeyHandle, modifier5, upgradeAnswerDialogDisplayer7, z3, str6, chatReporter, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatPage$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerManagerData ChatPage$lambda$1(State<StickerManagerData> state) {
        Object thisObj$iv = state.getValue();
        return (StickerManagerData) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$0$1(long $bgColor, Modifier it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)273@11249L35:ChatPage.kt#f7dpja");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1333176286, $dirty, -1, "kntr.app.im.chat.ui.ChatPage.<anonymous>.<anonymous>.<anonymous> (ChatPage.kt:273)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(it, $bgColor, (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x027d, code lost:
        if (r8 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x02e6, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0415  */
    /* JADX WARN: Type inference failed for: r3v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ChatPage$lambda$9$0$0(ChatInfo $chatInfo, String $defaultTitleName, final CoroutineScope $scope, final ChatActionHandler $actionHandler, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String it;
        boolean z;
        String it2;
        NavigationBar navigationBar;
        String it3;
        NavigationBar navigationBar2;
        KSessionTag sessionTag;
        NavigationBar navigationBar3;
        ComposerKt.sourceInformation($composer, "C276@11357L2440:ChatPage.kt#f7dpja");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-585010130, $changed, -1, "kntr.app.im.chat.ui.ChatPage.<anonymous>.<anonymous>.<anonymous> (ChatPage.kt:276)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
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
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i2 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1118387119, "C281@11615L1687:ChatPage.kt#f7dpja");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((432 >> 6) & 112) | 6;
            RowScope $this$ChatPage_u24lambda_u249_u240_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -381829993, "C285@11832L356:ChatPage.kt#f7dpja");
            if ($chatInfo != null && (navigationBar3 = $chatInfo.getNavigationBar()) != null && (it = navigationBar3.getSessionName()) != null) {
                if (!(it.length() > 0)) {
                    it = null;
                }
            }
            it = $defaultTitleName;
            IMTopBarKt.TextTitle(it, $this$ChatPage_u24lambda_u249_u240_u240_u240_u240.weight(Modifier.Companion, 1.0f, false), $composer, 0, 0);
            final KSessionTag.ITag tag = ($chatInfo == null || (navigationBar2 = $chatInfo.getNavigationBar()) == null || (sessionTag = navigationBar2.getSessionTag()) == null) ? null : sessionTag.getTag();
            if (tag instanceof KSessionTag.KLiveTag) {
                $composer.startReplaceGroup(680438484);
                ComposerKt.sourceInformation($composer, "297@12583L261,295@12455L428");
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, 680442413, "CC(remember):ChatPage.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($actionHandler) | $composer.changedInstance(tag);
                Object value$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit ChatPage$lambda$9$0$0$0$0$1$0;
                        ChatPage$lambda$9$0$0$0$0$1$0 = ChatPageKt.ChatPage$lambda$9$0$0$0$0$1$0($scope, $actionHandler, tag);
                        return ChatPage$lambda$9$0$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                TitleLiveTagKt.TitleLiveTag(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null), $composer, 0, 0);
                $composer.endReplaceGroup();
                z = false;
            } else if (!(tag instanceof KSessionTag.KBetaTage)) {
                z = false;
                $composer.startReplaceGroup(680463244);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(680455107);
                ComposerKt.sourceInformation($composer, "306@13042L47,307@13149L6,305@12981L219");
                z = false;
                TitleTextTagKt.m1881TitleTextTagRPmYEkk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_884(Res.string.INSTANCE), $composer, 0), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, 0);
                $composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if ($chatInfo != null && (navigationBar = $chatInfo.getNavigationBar()) != null && (it3 = navigationBar.getSessionHandle()) != null) {
                if (it3.length() > 0 ? true : z) {
                    it2 = it3;
                    if (it2 != null) {
                        $composer.startReplaceGroup(1120098658);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(1120098659);
                        ComposerKt.sourceInformation($composer, "*317@13529L9,318@13594L6,315@13430L319");
                        TextKt.Text-Nvy7gAk(it2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10(), $composer, 0, 24960, 110586);
                        Unit unit = Unit.INSTANCE;
                        $composer.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            it2 = null;
            if (it2 != null) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$0$0$0$0$1$0(CoroutineScope $scope, ChatActionHandler $actionHandler, KSessionTag.ITag $tag) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$1$1$1$1$2$1$1($actionHandler, $tag, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$0$2(ChatInfo $chatInfo, final CoroutineScope $scope, final ChatActionHandler $actionHandler, final ChatReporter $reporter, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        NavigationBar navigationBar;
        ComposerKt.sourceInformation($composer, "C:ChatPage.kt#f7dpja");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1859855414, $changed, -1, "kntr.app.im.chat.ui.ChatPage.<anonymous>.<anonymous>.<anonymous> (ChatPage.kt:326)");
            }
            final KNavButton navButton = ($chatInfo == null || (navigationBar = $chatInfo.getNavigationBar()) == null) ? null : navigationBar.getNavButton();
            if (navButton != null) {
                $composer.startReplaceGroup(1874676905);
                ComposerKt.sourceInformation($composer, "332@14176L630,328@13991L1299");
                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 614668812, "CC(remember):ChatPage.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($actionHandler) | $composer.changedInstance(navButton) | $composer.changed($reporter);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit ChatPage$lambda$9$0$2$0$0;
                            ChatPage$lambda$9$0$2$0$0 = ChatPageKt.ChatPage$lambda$9$0$2$0$0($scope, $actionHandler, navButton, $reporter);
                            return ChatPage$lambda$9$0$2$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(fillMaxHeight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -987084438, "C345@14910L354:ChatPage.kt#f7dpja");
                $composer.startReplaceGroup(-1555858959);
                ComposerKt.sourceInformation($composer, "*348@15121L7");
                String $this$asRequest$iv = navButton.getIcon();
                ImageRequest $this$ChatPage_u24lambda_u249_u240_u242_u241_u240 = new ImageRequest($this$asRequest$iv);
                ColorFilter.Companion companion = ColorFilter.Companion;
                CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $this$ChatPage_u24lambda_u249_u240_u242_u241_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(companion, ((Color) consume).unbox-impl(), 0, 2, (Object) null));
                ImmutableImageRequest build = $this$ChatPage_u24lambda_u249_u240_u242_u241_u240.build();
                $composer.endReplaceGroup();
                BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer, 48, 508);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                $composer.startReplaceGroup(1860780876);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$0$2$0$0(CoroutineScope $scope, ChatActionHandler $actionHandler, KNavButton $navButton, ChatReporter $reporter) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$1$3$1$1$1($actionHandler, $navButton, $reporter, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$2$0(CoroutineScope $scope, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$3$1$1($actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$5$0(CoroutineScope $scope, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$6$1$1($actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$3$0(CoroutineScope $scope, ChatActionHandler $actionHandler, Emote emoticon) {
        Intrinsics.checkNotNullParameter(emoticon, "emoticon");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$4$1$1(emoticon, $actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$4$0(CoroutineScope $scope, ChatActionHandler $actionHandler, StickerAsset it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$5$1$1($actionHandler, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$6$0(CoroutineScope $scope, StickerManagerViewModel $stickerViewModel, StickerAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$7$1$1(it, $stickerViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatPage$lambda$9$9$0(CoroutineScope $scope, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$10$1$1($actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}