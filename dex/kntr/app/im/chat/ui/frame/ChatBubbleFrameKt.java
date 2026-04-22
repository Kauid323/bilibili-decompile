package kntr.app.im.chat.ui.frame;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeType;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KTextParagraph;
import com.bapis.bilibili.app.im.v1.KBubbleStyle;
import com.bapis.bilibili.app.im.v1.KChatBubbleWidget;
import com.bapis.bilibili.app.im.v1.KMsgMenuContent;
import com.bapis.bilibili.app.im.v1.KMsgMenuItem;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphBuilderKt;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.bilibili.framework.exposure.core.transformer.ExposureAreaVisibilityTransformerKt;
import com.bilibili.framework.exposure.core.transformer.ExposureVisibleDurationTransformerKt;
import com.bilibili.lib.brouter.uri.Uri;
import im.base.IMLog;
import im.base.loading.LoadingPainterKt;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrame;
import kntr.app.im.chat.frame.bubble.UserInfoHolder;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderKt;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.utils.MenuItemHandlerKt;
import kntr.app.im.chat.ui.utils.MenuItemTextMapperKt;
import kntr.app.im.chat.ui.widget.PopupBubbleMenuKt;
import kntr.app.im.chat.ui.widget.PopupState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.compose.avatar.AvatarKt;
import kntr.compose.avatar.AvatarScope;
import kntr.compose.avatar.AvatarSizeConfig;
import kntr.compose.avatar.AvatarState;
import kntr.compose.avatar.internal.AvatarContentKt;
import kntr.compose.avatar.model.AvatarItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: ChatBubbleFrame.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001aM\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001eH\u0003¢\u0006\u0002\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0019\u0010+\u001a\u00020,*\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0003¢\u0006\u0002\u0010-\u001a\u001c\u0010.\u001a\u0004\u0018\u00010/*\u0002002\u0006\u00101\u001a\u00020/H\u0082@¢\u0006\u0002\u00102\"\u001e\u0010$\u001a\u00020%*\u00020&8BX\u0082\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u00063"}, d2 = {"ChatBubbleFrame", RoomRecommendViewModel.EMPTY_CURSOR, "chatBubble", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "chatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "(Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/ChatActionHandler;Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/neuron/ChatReporter;Landroidx/compose/runtime/Composer;II)V", "ChatAvatar", "avatar", "Lkntr/compose/avatar/model/AvatarItem;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "ChatAvatar-6a0pyJM", "(Lkntr/compose/avatar/model/AvatarItem;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "ChatBubble", "maxWidth", "ChatBubble-iHT-50w", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;Lkntr/app/im/chat/ui/ChatActionHandler;Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;FLandroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/neuron/ChatReporter;Landroidx/compose/runtime/Composer;II)V", "SendStatusIcon", "sendStatus", "Lkntr/app/im/chat/core/model/SendStatus;", "onClickFailureIcon", "Lkotlin/Function0;", "(Lkntr/app/im/chat/core/model/SendStatus;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "isOwner", RoomRecommendViewModel.EMPTY_CURSOR, "reportName", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;", "getReportName$annotations", "(Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;)V", "getReportName", "(Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;)Ljava/lang/String;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "(Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;ZLandroidx/compose/runtime/Composer;I)J", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatBubbleFrameKt {

    /* compiled from: ChatBubbleFrame.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SendStatus.values().length];
            try {
                iArr[SendStatus.Sending.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SendStatus.Failure.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatAvatar_6a0pyJM$lambda$0(AvatarItem avatarItem, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1743ChatAvatar6a0pyJM(avatarItem, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$1(ChatBubbleFrame chatBubbleFrame, EntityMessage entityMessage, ChatActionHandler chatActionHandler, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, Modifier modifier, ChatReporter chatReporter, int i, int i2, Composer composer, int i3) {
        ChatBubbleFrame(chatBubbleFrame, entityMessage, chatActionHandler, chatMsgModuleBuilderProvider, modifier, chatReporter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubble_iHT_50w$lambda$2(EntityMessage entityMessage, ChatBubbleFrame chatBubbleFrame, ChatActionHandler chatActionHandler, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, float f, Modifier modifier, ChatReporter chatReporter, int i, int i2, Composer composer, int i3) {
        m1744ChatBubbleiHT50w(entityMessage, chatBubbleFrame, chatActionHandler, chatMsgModuleBuilderProvider, f, modifier, chatReporter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SendStatusIcon$lambda$1(SendStatus sendStatus, Function0 function0, int i, Composer composer, int i2) {
        SendStatusIcon(sendStatus, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void getReportName$annotations(KMsgMenuItem kMsgMenuItem) {
    }

    public static final void ChatBubbleFrame(final ChatBubbleFrame chatBubble, final EntityMessage message, final ChatActionHandler actionHandler, final ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, Modifier modifier, ChatReporter reporter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ChatReporter chatReporter;
        Modifier modifier3;
        ChatReporter reporter2;
        Function0 factory$iv$iv$iv;
        final ChatReporter reporter3;
        KModuleParagraph[] kModuleParagraphArr;
        KTextParagraph value;
        Intrinsics.checkNotNullParameter(chatBubble, "chatBubble");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(chatMsgModuleBuilderProvider, "chatMsgModuleBuilderProvider");
        Composer $composer2 = $composer.startRestartGroup(1552618149);
        ComposerKt.sourceInformation($composer2, "C(ChatBubbleFrame)N(chatBubble,message,actionHandler,chatMsgModuleBuilderProvider,modifier,reporter)163@7110L24,164@7139L6186:ChatBubbleFrame.kt#wmjton");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(chatBubble) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(message) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(actionHandler) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(chatMsgModuleBuilderProvider) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            chatReporter = reporter;
        } else if ((196608 & $changed) == 0) {
            chatReporter = reporter;
            $dirty |= $composer2.changed(chatReporter) ? 131072 : 65536;
        } else {
            chatReporter = reporter;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            ChatReporter reporter4 = i3 != 0 ? null : chatReporter;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552618149, $dirty2, -1, "kntr.app.im.chat.ui.frame.ChatBubbleFrame (ChatBubbleFrame.kt:160)");
            }
            boolean isOwner = chatBubble.getValue().isOwner();
            LayoutDirection direction = isOwner ? LayoutDirection.Rtl : LayoutDirection.Ltr;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            int $changed$iv = (($dirty2 >> 12) & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier4;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1334091312, "C165@7345L2324,165@7279L2390:ChatBubbleFrame.kt#wmjton");
            final ChatReporter reporter5 = reporter4;
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLayoutDirection().provides(direction), ComposableLambdaKt.rememberComposableLambda(-1667678501, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatBubbleFrame$lambda$0$0;
                    ChatBubbleFrame$lambda$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$0(EntityMessage.this, chatBubble, actionHandler, chatMsgModuleBuilderProvider, reporter5, scope, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatBubbleFrame$lambda$0$0;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            KChatBubbleWidget widget = chatBubble.getValue().getWidget();
            String str = null;
            KChatBubbleWidget.IContent widget2 = widget != null ? widget.getContent() : null;
            if (widget2 instanceof KChatBubbleWidget.KHintTextWidget) {
                $composer2.startReplaceGroup(1336495733);
                ComposerKt.sourceInformation($composer2, "224@10149L9,224@10164L1854,224@10055L1963,258@12110L6,259@12138L1171,257@12031L1278");
                KParagraph paragraph = ((KChatBubbleWidget.KHintTextWidget) widget2).getValue().getParagraph();
                KParagraph.IContent content = paragraph != null ? paragraph.getContent() : null;
                KParagraph.KText kText = content instanceof KParagraph.KText ? (KParagraph.KText) content : null;
                List nodes = (kText == null || (value = kText.getValue()) == null) ? null : value.getNodes();
                if (nodes == null) {
                    $composer2.startReplaceGroup(1336503792);
                } else {
                    $composer2.startReplaceGroup(-511076303);
                    ComposerKt.sourceInformation($composer2, "220@9964L50");
                    List list = nodes;
                    ComposerKt.sourceInformationMarkerStart($composer2, -511074195, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                CharSequence ChatBubbleFrame$lambda$0$1$0;
                                ChatBubbleFrame$lambda$0$1$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$1$0((KTextNode) obj);
                                return ChatBubbleFrame$lambda$0$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    str = CollectionsKt.joinToString$default(list, r52, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) it$iv, 30, (Object) null);
                }
                $composer2.endReplaceGroup();
                final String hintText = str;
                KModuleParagraph[] kModuleParagraphArr2 = {new KModuleParagraph(((KChatBubbleWidget.KHintTextWidget) widget2).getValue().getParagraph(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)};
                TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
                ComposerKt.sourceInformationMarkerStart($composer2, -511065991, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 896) == 256) | ((458752 & $dirty2) == 131072) | (($dirty2 & 112) == 32) | $composer2.changed(hintText);
                Object value$iv2 = $composer2.rememberedValue();
                if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                    kModuleParagraphArr = kModuleParagraphArr2;
                    value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit ChatBubbleFrame$lambda$0$2$0;
                            ChatBubbleFrame$lambda$0$2$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$2$0(scope, reporter5, message, hintText, actionHandler, (ParagraphStateBuilderScope) obj);
                            return ChatBubbleFrame$lambda$0$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    kModuleParagraphArr = kModuleParagraphArr2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final ParagraphState state = ParagraphStateKt.rememberParagraphState(kModuleParagraphArr, t12, (ParagraphBuilderProvider) null, (Function1) value$iv2, $composer2, 0, 4);
                reporter3 = reporter5;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-387164874, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ChatBubbleFrame$lambda$0$3;
                        ChatBubbleFrame$lambda$0$3 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$3(state, reporter3, message, hintText, (Composer) obj, ((Integer) obj2).intValue());
                        return ChatBubbleFrame$lambda$0$3;
                    }
                }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            } else {
                reporter3 = reporter5;
                $composer2.startReplaceGroup(1326682311);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier$iv$iv;
            reporter2 = reporter3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            reporter2 = chatReporter;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ChatReporter chatReporter2 = reporter2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatBubbleFrame$lambda$1;
                    ChatBubbleFrame$lambda$1 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$1(ChatBubbleFrame.this, message, actionHandler, chatMsgModuleBuilderProvider, modifier5, chatReporter2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatBubbleFrame$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x02dd, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ChatBubbleFrame$lambda$0$0(final EntityMessage $message, final ChatBubbleFrame $chatBubble, final ChatActionHandler $actionHandler, final ChatMsgModuleBuilderProvider $chatMsgModuleBuilderProvider, final ChatReporter $reporter, final CoroutineScope $scope, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C166@7359L2300:ChatBubbleFrame.kt#wmjton");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1667678501, $changed, -1, "kntr.app.im.chat.ui.frame.ChatBubbleFrame.<anonymous>.<anonymous> (ChatBubbleFrame.kt:166)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((6 >> 6) & 112) | 6;
            final RowScope $this$ChatBubbleFrame_u24lambda_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -74618128, "C167@7493L1626,167@7417L1702,201@9137L508:ChatBubbleFrame.kt#wmjton");
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr), ComposableLambdaKt.rememberComposableLambda(1555702015, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatBubbleFrame$lambda$0$0$0$0;
                    ChatBubbleFrame$lambda$0$0$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$0$0$0($this$ChatBubbleFrame_u24lambda_u240_u240_u240, $message, $chatBubble, $actionHandler, $chatMsgModuleBuilderProvider, $reporter, $scope, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatBubbleFrame$lambda$0$0$0$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            Modifier modifier$iv2 = $this$ChatBubbleFrame_u24lambda_u240_u240_u240.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(63)), Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(20)), Alignment.Companion.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1225857273, "C209@9513L113,209@9444L183:ChatBubbleFrame.kt#wmjton");
            SendStatus sendStatus = $message.getSendStatus();
            ComposerKt.sourceInformationMarkerStart($composer, -1009372970, "CC(remember):ChatBubbleFrame.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($actionHandler) | $composer.changed($message);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit ChatBubbleFrame$lambda$0$0$0$1$0$0;
                    ChatBubbleFrame$lambda$0$0$0$1$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$0$0$1$0$0($scope, $actionHandler, $message);
                    return ChatBubbleFrame$lambda$0$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SendStatusIcon(sendStatus, (Function0) it$iv, $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ChatBubbleFrame$lambda$0$0$0$0(RowScope $this_Row, final EntityMessage $message, final ChatBubbleFrame $chatBubble, final ChatActionHandler $actionHandler, ChatMsgModuleBuilderProvider $chatMsgModuleBuilderProvider, final ChatReporter $reporter, final CoroutineScope $scope, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Object value$iv;
        ComposerKt.sourceInformation($composer, "C168@7515L39,169@7575L810,184@8406L39,185@8466L635:ChatBubbleFrame.kt#wmjton");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1555702015, $changed, -1, "kntr.app.im.chat.ui.frame.ChatBubbleFrame.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatBubbleFrame.kt:168)");
            }
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            Modifier modifier$iv = $this_Row.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(55)), Alignment.Companion.getTop());
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box = $changed$iv$iv << 6;
            int $changed$iv$iv$iv = ($i$f$Box & 896) | 6;
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
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ChatBubbleFrame_u24lambda_u240_u240_u240_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -367768482, "C172@7785L481,170@7659L704:ChatBubbleFrame.kt#wmjton");
            Modifier align = $this$ChatBubbleFrame_u24lambda_u240_u240_u240_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenter());
            ComposerKt.sourceInformationMarkerStart($composer, 542329638, "CC(remember):ChatBubbleFrame.kt#9igjgp");
            boolean invalid$iv = $composer.changed($chatBubble) | $composer.changedInstance($scope) | $composer.changed($actionHandler) | $composer.changed($reporter) | $composer.changed($message);
            Object it$iv = $composer.rememberedValue();
            if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
                UserInfoHolder userInfo = $chatBubble.getUserInfo();
                m1743ChatAvatar6a0pyJM(userInfo == null ? userInfo.getAvatarItem() : null, modifier, 0.0f, $composer, 0, 4);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
                m1744ChatBubbleiHT50w($message, $chatBubble, $actionHandler, $chatMsgModuleBuilderProvider, Dp.constructor-impl(300), $this_Row.weight(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(0), Dp.constructor-impl(8)), 1.0f, false), $reporter, $composer, 24576, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv = new Function0() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit ChatBubbleFrame$lambda$0$0$0$0$0$0$0;
                    ChatBubbleFrame$lambda$0$0$0$0$0$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$0$0$0$0$0$0(ChatBubbleFrame.this, $scope, $actionHandler, $reporter, $message);
                    return ChatBubbleFrame$lambda$0$0$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
            UserInfoHolder userInfo2 = $chatBubble.getUserInfo();
            m1743ChatAvatar6a0pyJM(userInfo2 == null ? userInfo2.getAvatarItem() : null, modifier2, 0.0f, $composer, 0, 4);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            m1744ChatBubbleiHT50w($message, $chatBubble, $actionHandler, $chatMsgModuleBuilderProvider, Dp.constructor-impl(300), $this_Row.weight(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(0), Dp.constructor-impl(8)), 1.0f, false), $reporter, $composer, 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$0$0$0$0$0$0$0(ChatBubbleFrame $chatBubble, CoroutineScope $scope, ChatActionHandler $actionHandler, ChatReporter $reporter, EntityMessage $message) {
        UserInfoHolder userInfo = $chatBubble.getUserInfo();
        String url = userInfo != null ? userInfo.getAvatarUrl() : null;
        if (url != null) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBubbleFrameKt$ChatBubbleFrame$1$1$1$1$1$1$1$1($actionHandler, url, $reporter, $message, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$0$0$0$1$0$0(CoroutineScope $scope, ChatActionHandler $actionHandler, EntityMessage $message) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBubbleFrameKt$ChatBubbleFrame$1$1$1$2$1$1$1($actionHandler, $message, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence ChatBubbleFrame$lambda$0$1$0(KTextNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRawText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$0$2$0(final CoroutineScope $scope, final ChatReporter $reporter, final EntityMessage $message, final String $hintText, final ChatActionHandler $actionHandler, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit ChatBubbleFrame$lambda$0$2$0$0;
                ChatBubbleFrame$lambda$0$2$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$2$0$0($scope, $reporter, $message, $hintText, $actionHandler, (TextParagraphBuilderScope) obj);
                return ChatBubbleFrame$lambda$0$2$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$0$2$0$0(final CoroutineScope $scope, final ChatReporter $reporter, final EntityMessage $message, final String $hintText, final ChatActionHandler $actionHandler, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        TextNodeClickListener clickListener$iv = new TextNodeClickListener() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda10
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean ChatBubbleFrame$lambda$0$2$0$0$0;
                ChatBubbleFrame$lambda$0$2$0$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$2$0$0$0($scope, $reporter, $message, $hintText, $actionHandler, (KTextNode.KLink) iText, textNodeClickInfo);
                return ChatBubbleFrame$lambda$0$2$0$0$0;
            }
        };
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), clickListener$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChatBubbleFrame$lambda$0$2$0$0$0(CoroutineScope $scope, ChatReporter $reporter, EntityMessage $message, String $hintText, ChatActionHandler $actionHandler, KTextNode.KLink node, TextNodeClickInfo clickInfo) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
        if (Intrinsics.areEqual(node.getValue().getLinkTypeEnum(), KLinkNodeType.RECALL_MESSAGE.INSTANCE)) {
            Uri actionUrl = Uri.Companion.parse(node.getValue().getLink());
            String queryParameter = actionUrl.getQueryParameter("key");
            Long msgKey = queryParameter != null ? StringsKt.toLongOrNull(queryParameter) : null;
            String queryParameter2 = actionUrl.getQueryParameter("seq");
            Long sequenceNum = queryParameter2 != null ? StringsKt.toLongOrNull(queryParameter2) : null;
            if (msgKey != null && sequenceNum != null) {
                BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$1($actionHandler, msgKey, sequenceNum, null), 3, (Object) null);
            } else {
                IMLog.Companion.w("HintTextModule", "invalid recall link: " + node.getValue().getLink());
            }
        } else if (!StringsKt.isBlank(node.getValue().getLink())) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$2($actionHandler, node, null), 3, (Object) null);
        }
        if ($reporter != null) {
            $reporter.reportMsgClick("sys-msg", MapsKt.plus($message.getTraceParams(), MapsKt.mapOf(TuplesKt.to("text", $hintText))));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$0$3(ParagraphState $state, final ChatReporter $reporter, final EntityMessage $message, final String $hintText, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C*263@12285L19,266@12531L333,272@12904L319,261@12204L1073:ChatBubbleFrame.kt#wmjton");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-387164874, $changed, -1, "kntr.app.im.chat.ui.frame.ChatBubbleFrame.<anonymous>.<anonymous> (ChatBubbleFrame.kt:260)");
            }
            Iterable $this$forEach$iv = $state.getContents();
            for (Object element$iv : $this$forEach$iv) {
                ParagraphContent it = (ParagraphContent) element$iv;
                Modifier modifier = PaddingKt.padding-qDBjuR0$default(ParagraphBuilderKt.padding(Modifier.Companion, it.getSpacing(), $composer, 6), Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(32), Dp.constructor-impl(8), 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1665628589, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Flow ChatBubbleFrame$lambda$0$3$0$0$0;
                            ChatBubbleFrame$lambda$0$3$0$0$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$3$0$0$0((Flow) obj);
                            return ChatBubbleFrame$lambda$0$3$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 function1 = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1665640511, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                boolean invalid$iv = $composer.changed($reporter) | $composer.changed($message) | $composer.changed($hintText);
                Object it$iv2 = $composer.rememberedValue();
                if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    it.Content(ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(modifier, new ExposureEntry(function1, (Function0) it$iv2)), $composer, 0);
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit ChatBubbleFrame$lambda$0$3$0$1$0;
                        ChatBubbleFrame$lambda$0$3$0$1$0 = ChatBubbleFrameKt.ChatBubbleFrame$lambda$0$3$0$1$0(ChatReporter.this, $message, $hintText);
                        return ChatBubbleFrame$lambda$0$3$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                it.Content(ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(modifier, new ExposureEntry(function1, (Function0) it$iv2)), $composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow ChatBubbleFrame$lambda$0$3$0$0$0(Flow v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Flow distinctUntilChanged = FlowKt.distinctUntilChanged(ExposureAreaVisibilityTransformerKt.noticeableWhenAreaPixelIsAtLeast(v, 1));
        Duration.Companion companion = Duration.Companion;
        return ExposureVisibleDurationTransformerKt.exposeIfNoticeableFor-HG0u8IE(distinctUntilChanged, DurationKt.toDuration(1, DurationUnit.SECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubbleFrame$lambda$0$3$0$1$0(ChatReporter $reporter, EntityMessage $message, String $hintText) {
        if ($reporter != null) {
            $reporter.reportMsgShow("sys-msg", MapsKt.plus($message.getTraceParams(), MapsKt.mapOf(TuplesKt.to("text", $hintText))));
        }
        return Unit.INSTANCE;
    }

    /* renamed from: ChatAvatar-6a0pyJM  reason: not valid java name */
    private static final void m1743ChatAvatar6a0pyJM(final AvatarItem avatar, Modifier modifier, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        Modifier modifier3;
        float f3;
        Modifier modifier4;
        float f4;
        Function0 factory$iv$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1441599516);
        ComposerKt.sourceInformation($composer2, "C(ChatAvatar)N(avatar,modifier,normalSize:c#ui.unit.Dp):ChatBubbleFrame.kt#wmjton");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(avatar) ? 4 : 2;
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
            f2 = f;
        } else if (($changed & 384) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(40);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1441599516, $dirty2, -1, "kntr.app.im.chat.ui.frame.ChatAvatar (ChatBubbleFrame.kt:294)");
            }
            if (avatar != null) {
                $composer2.startReplaceGroup(1313334340);
                ComposerKt.sourceInformation($composer2, "298@13566L39,296@13505L162");
                AvatarState state$iv = AvatarKt.rememberAvatarState-ziNgDLE(avatar, f4, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 112));
                AvatarSizeConfig sizeConfig$iv = AvatarSizeConfig.Largest;
                int $changed$iv = ($dirty2 & 112) | 384;
                Modifier modifier$iv = modifier4;
                ComposerKt.sourceInformationMarkerStart($composer2, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
                Modifier modifier$iv$iv = modifier$iv.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig$iv.constraintSize-u2uoSUM(state$iv)));
                Alignment contentAlignment$iv$iv = Alignment.Companion.getTopStart();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
                int $changed$iv$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
                Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv$iv);
                } else {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -60560984, "C24@868L21:Avatar.kt#v7x95u");
                $composer2.startReplaceGroup(-833237573);
                ComposerKt.sourceInformation($composer2, "*25@905L20");
                AvatarScope $this$Avatar_u24lambda_u240_u240$iv = AvatarKt.rememberAvatarScope($composer2, 0);
                AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240$iv, state$iv, $composer2, ($changed$iv << 3) & 112);
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1313505677);
                ComposerKt.sourceInformation($composer2, "302@13689L105");
                BoxKt.Box(SizeKt.size-3ABfNKs(modifier4, AvatarSizeConfig.Largest.constraintSize-5rwHm24(f4)), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = f4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatAvatar_6a0pyJM$lambda$0;
                    ChatAvatar_6a0pyJM$lambda$0 = ChatBubbleFrameKt.ChatAvatar_6a0pyJM$lambda$0(avatar, modifier5, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatAvatar_6a0pyJM$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04e1  */
    /* renamed from: ChatBubble-iHT-50w  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1744ChatBubbleiHT50w(final EntityMessage message, final ChatBubbleFrame chatBubble, final ChatActionHandler actionHandler, final ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, final float f, Modifier modifier, ChatReporter reporter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ChatReporter chatReporter;
        Modifier modifier3;
        ChatReporter reporter2;
        int $dirty;
        Object obj;
        PopupState popupState;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 value$iv;
        boolean invalid$iv;
        Object value$iv2;
        Composer $composer2;
        boolean z;
        final PopupState popupState2;
        Composer $composer$iv;
        Composer $composer$iv2;
        boolean invalid$iv2;
        Object it$iv;
        Composer $composer3 = $composer.startRestartGroup(-1428496076);
        ComposerKt.sourceInformation($composer3, "C(ChatBubble)N(message,chatBubble,actionHandler,chatMsgModuleBuilderProvider,maxWidth:c#ui.unit.Dp,modifier,reporter)322@14173L24,323@14219L37,324@14297L7,330@14446L24,333@14591L852,326@14310L4030:ChatBubbleFrame.kt#wmjton");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(message) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(chatBubble) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(actionHandler) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(chatMsgModuleBuilderProvider) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(f) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty2 |= 1572864;
            chatReporter = reporter;
        } else if (($changed & 1572864) == 0) {
            chatReporter = reporter;
            $dirty2 |= $composer3.changed(chatReporter) ? 1048576 : 524288;
        } else {
            chatReporter = reporter;
        }
        if ($composer3.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            Modifier modifier5 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            reporter2 = i3 != 0 ? null : chatReporter;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1428496076, $dirty2, -1, "kntr.app.im.chat.ui.frame.ChatBubble (ChatBubbleFrame.kt:320)");
            }
            boolean isOwner = chatBubble.getValue().isOwner();
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PopupState popupState3 = PopupBubbleMenuKt.rememberPopupState(false, $composer3, 6, 0);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LifecycleOwner lifecycle = (LifecycleOwner) consume;
            Modifier layoutId = LayoutIdKt.layoutId(IntrinsicKt.width(BackgroundKt.background-bw27NRU$default(ClipKt.clip(modifier5, shape(chatBubble, isOwner)), backgroundColor(chatBubble, isOwner, $composer3, ($dirty2 >> 3) & 14), (Shape) null, 2, (Object) null), IntrinsicSize.Min), "chat_bubble");
            Object it$iv2 = Unit.INSTANCE;
            Modifier modifier6 = modifier5;
            ComposerKt.sourceInformationMarkerStart($composer3, 1604830504, "CC(remember):ChatBubbleFrame.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & 112) == 32) | $composer3.changedInstance(lifecycle) | $composer3.changed(popupState3) | $composer3.changedInstance(scope) | (($dirty2 & 896) == 256) | (($dirty2 & 3670016) == 1048576) | (($dirty2 & 14) == 4);
            Object value$iv3 = $composer3.rememberedValue();
            if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                obj = it$iv2;
                popupState = popupState3;
                modifier4 = layoutId;
                value$iv3 = new ChatBubbleFrameKt$ChatBubble$1$1(chatBubble, lifecycle, popupState, scope, actionHandler, reporter2, message);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                $dirty = $dirty2;
                modifier4 = layoutId;
                obj = it$iv2;
                popupState = popupState3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(modifier4, obj, (PointerInputEventHandler) value$iv3);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1723714246, "C356@15604L32,357@15648L1662,354@15519L1791,402@17348L264:ChatBubbleFrame.kt#wmjton");
            ComposerKt.sourceInformationMarkerStart($composer3, -1718171734, "CC(remember):ChatBubbleFrame.kt#9igjgp");
            final PopupState popupState4 = popupState;
            boolean invalid$iv4 = $composer3.changed(popupState4);
            Object it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv4 && it$iv3 != Composer.Companion.getEmpty()) {
                value$iv = it$iv3;
                Function0 function0 = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -1718168696, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                invalid$iv = (($dirty & 112) != 32) | $composer3.changedInstance(scope) | (($dirty & 14) != 4) | (($dirty & 896) != 256) | (($dirty & 3670016) != 1048576) | $composer3.changed(popupState4);
                value$iv2 = $composer3.rememberedValue();
                if (!invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                    $composer2 = $composer3;
                    z = false;
                    popupState2 = popupState4;
                    $composer$iv = $composer3;
                    final ChatReporter chatReporter2 = reporter2;
                    $composer$iv2 = $composer3;
                    value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj2) {
                            Unit ChatBubble_iHT_50w$lambda$1$1$0;
                            ChatBubble_iHT_50w$lambda$1$1$0 = ChatBubbleFrameKt.ChatBubble_iHT_50w$lambda$1$1$0(ChatBubbleFrame.this, scope, message, actionHandler, chatReporter2, popupState2, (LazyListScope) obj2);
                            return ChatBubble_iHT_50w$lambda$1$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    $composer2 = $composer3;
                    popupState2 = popupState4;
                    $composer$iv2 = $composer3;
                    $composer$iv = $composer3;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState2, function0, null, null, 0.0f, null, null, null, (Function1) value$iv2, $composer2, 0, 252);
                Composer $composer4 = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer4, -1718115694, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                invalid$iv2 = ((57344 & $dirty) != 16384 ? true : z) | (($dirty & 14) != 4 ? true : z);
                it$iv = $composer4.rememberedValue();
                if (!invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv4 = ChatMsgFrameBuilderKt.m1725ChatMsgFrameScopekHDZbjc(f, "msg", message, reporter2);
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv = value$iv4;
                }
                final ChatMsgFrameScope frameScope = (ChatMsgFrameScope) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.startReplaceGroup(-1718106509);
                ComposerKt.sourceInformation($composer4, "*412@17728L9,413@17757L567,411@17652L672");
                CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13()), ComposableLambdaKt.rememberComposableLambda(-1498999648, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ChatBubble_iHT_50w$lambda$1$3$0;
                        ChatBubble_iHT_50w$lambda$1$3$0 = ChatBubbleFrameKt.ChatBubble_iHT_50w$lambda$1$3$0(ChatBubbleFrame.this, chatMsgModuleBuilderProvider, message, f, frameScope, (Composer) obj2, ((Integer) obj3).intValue());
                        return ChatBubble_iHT_50w$lambda$1$3$0;
                    }
                }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                Unit unit = Unit.INSTANCE;
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
            }
            value$iv = new Function0() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit ChatBubble_iHT_50w$lambda$1$0$0;
                    ChatBubble_iHT_50w$lambda$1$0$0 = ChatBubbleFrameKt.ChatBubble_iHT_50w$lambda$1$0$0(PopupState.this);
                    return ChatBubble_iHT_50w$lambda$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            Function0 function02 = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1718168696, "CC(remember):ChatBubbleFrame.kt#9igjgp");
            invalid$iv = (($dirty & 112) != 32) | $composer3.changedInstance(scope) | (($dirty & 14) != 4) | (($dirty & 896) != 256) | (($dirty & 3670016) != 1048576) | $composer3.changed(popupState4);
            value$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            $composer2 = $composer3;
            z = false;
            popupState2 = popupState4;
            $composer$iv = $composer3;
            final ChatReporter chatReporter22 = reporter2;
            $composer$iv2 = $composer3;
            value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2) {
                    Unit ChatBubble_iHT_50w$lambda$1$1$0;
                    ChatBubble_iHT_50w$lambda$1$1$0 = ChatBubbleFrameKt.ChatBubble_iHT_50w$lambda$1$1$0(ChatBubbleFrame.this, scope, message, actionHandler, chatReporter22, popupState2, (LazyListScope) obj2);
                    return ChatBubble_iHT_50w$lambda$1$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState2, function02, null, null, 0.0f, null, null, null, (Function1) value$iv2, $composer2, 0, 252);
            Composer $composer42 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer42, -1718115694, "CC(remember):ChatBubbleFrame.kt#9igjgp");
            invalid$iv2 = ((57344 & $dirty) != 16384 ? true : z) | (($dirty & 14) != 4 ? true : z);
            it$iv = $composer42.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv42 = ChatMsgFrameBuilderKt.m1725ChatMsgFrameScopekHDZbjc(f, "msg", message, reporter2);
            $composer42.updateRememberedValue(value$iv42);
            it$iv = value$iv42;
            final ChatMsgFrameScope frameScope2 = (ChatMsgFrameScope) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer42);
            $composer42.startReplaceGroup(-1718106509);
            ComposerKt.sourceInformation($composer42, "*412@17728L9,413@17757L567,411@17652L672");
            CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(BiliTheme.INSTANCE.getTextStyle($composer42, BiliTheme.$stable).getT13()), ComposableLambdaKt.rememberComposableLambda(-1498999648, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ChatBubble_iHT_50w$lambda$1$3$0;
                    ChatBubble_iHT_50w$lambda$1$3$0 = ChatBubbleFrameKt.ChatBubble_iHT_50w$lambda$1$3$0(ChatBubbleFrame.this, chatMsgModuleBuilderProvider, message, f, frameScope2, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatBubble_iHT_50w$lambda$1$3$0;
                }
            }, $composer42, 54), $composer42, ProvidedValue.$stable | 48);
            Unit unit2 = Unit.INSTANCE;
            $composer42.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer42);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier6;
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            reporter2 = chatReporter;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final ChatReporter chatReporter3 = reporter2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ChatBubble_iHT_50w$lambda$2;
                    ChatBubble_iHT_50w$lambda$2 = ChatBubbleFrameKt.ChatBubble_iHT_50w$lambda$2(EntityMessage.this, chatBubble, actionHandler, chatMsgModuleBuilderProvider, f, modifier7, chatReporter3, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatBubble_iHT_50w$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubble_iHT_50w$lambda$1$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubble_iHT_50w$lambda$1$1$0(final ChatBubbleFrame $chatBubble, final CoroutineScope $scope, final EntityMessage $message, final ChatActionHandler $actionHandler, final ChatReporter $reporter, final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        final List items$iv = $chatBubble.getValue().getMenuItems();
        $this$PopupBubbleMenu.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble_iHT_50w$lambda$1$1$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble_iHT_50w$lambda$1$1$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Composer $composer2;
                int index;
                String name;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
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
                    ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i = ($dirty & 14) | ($dirty & 112);
                final KMsgMenuItem item = (KMsgMenuItem) items$iv.get(it);
                $composer.startReplaceGroup(1017239069);
                ComposerKt.sourceInformation($composer, "CN(index,item)*371@16170L470,382@16669L322,370@16119L1042:ChatBubbleFrame.kt#wmjton");
                $composer.startReplaceGroup(-1491206372);
                ComposerKt.sourceInformation($composer, "*363@15874L18");
                String name2 = item.getName();
                if (name2.length() == 0) {
                    StringResource res = MenuItemTextMapperKt.defaultStringRes(item.getContent(), $composer, 0);
                    if (res != null) {
                        $composer.startReplaceGroup(140451597);
                        ComposerKt.sourceInformation($composer, "365@15964L19");
                        name = StringResourcesKt.stringResource(res, $composer, 0);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(140531639);
                        $composer.endReplaceGroup();
                        name = item.getName();
                    }
                    name2 = name;
                }
                final String title = name2;
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart($composer, -1491194891, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance(item) | $composer.changed($message) | $composer.changed($actionHandler) | $composer.changed($reporter) | $composer.changed($popupState);
                Object value$iv = $composer.rememberedValue();
                if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    final CoroutineScope coroutineScope = $scope;
                    final PopupState popupState = $popupState;
                    final EntityMessage entityMessage = $message;
                    final ChatActionHandler chatActionHandler = $actionHandler;
                    final ChatReporter chatReporter = $reporter;
                    $composer2 = $composer;
                    index = it;
                    value$iv = new Function0<Unit>() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble$2$2$1$1$1$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: ChatBubbleFrame.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble$2$2$1$1$1$1$1", f = "ChatBubbleFrame.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble$2$2$1$1$1$1$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ChatActionHandler $actionHandler;
                            final /* synthetic */ KMsgMenuItem $item;
                            final /* synthetic */ EntityMessage $message;
                            final /* synthetic */ ChatReporter $reporter;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(KMsgMenuItem kMsgMenuItem, EntityMessage entityMessage, ChatActionHandler chatActionHandler, ChatReporter chatReporter, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$item = kMsgMenuItem;
                                this.$message = entityMessage;
                                this.$actionHandler = chatActionHandler;
                                this.$reporter = chatReporter;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$item, this.$message, this.$actionHandler, this.$reporter, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                String reportName;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.label = 1;
                                        if (MenuItemHandlerKt.menuItemClicked(this.$item, this.$message, this.$actionHandler, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ChatReporter chatReporter = this.$reporter;
                                if (chatReporter != null) {
                                    reportName = ChatBubbleFrameKt.getReportName(this.$item);
                                    chatReporter.reportMsgPopupMenu(reportName, this.$message.getTraceParams());
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1745invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1745invoke() {
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(item, entityMessage, chatActionHandler, chatReporter, null), 3, (Object) null);
                            popupState.setVisible(false);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    $composer2 = $composer;
                    index = it;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubble$2$2$1$1$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C386@16821L9,387@16895L6,383@16695L274:ChatBubbleFrame.kt#wmjton");
                        if (!$composer3.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(504588577, $changed2, -1, "kntr.app.im.chat.ui.frame.ChatBubble.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatBubbleFrame.kt:383)");
                        }
                        TextKt.Text-Nvy7gAk(title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                Composer $composer3 = $composer2;
                PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) value$iv, ComposableLambdaKt.rememberComposableLambda(504588577, true, function2, $composer3, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(16), 0.0f, 2, (Object) null), null, null, $composer3, 24624, 108);
                if (index != CollectionsKt.getLastIndex($chatBubble.getValue().getMenuItems())) {
                    $composer3.startReplaceGroup(1018636362);
                    ComposerKt.sourceInformation($composer3, "397@17251L17");
                    DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer3, 0, 7);
                } else {
                    $composer3.startReplaceGroup(1001542435);
                }
                $composer3.endReplaceGroup();
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatBubble_iHT_50w$lambda$1$3$0(ChatBubbleFrame $chatBubble, ChatMsgModuleBuilderProvider $chatMsgModuleBuilderProvider, EntityMessage $message, float f, ChatMsgFrameScope $this_with, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C*417@17904L169,420@18106L186:ChatBubbleFrame.kt#wmjton");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498999648, $changed, -1, "kntr.app.im.chat.ui.frame.ChatBubble.<anonymous>.<anonymous>.<anonymous> (ChatBubbleFrame.kt:415)");
            }
            for (MsgModule msgModule : $chatBubble.getModules()) {
                ComposerKt.sourceInformationMarkerStart($composer, -1724612695, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                boolean invalid$iv = $composer.changed($chatMsgModuleBuilderProvider) | $composer.changed(msgModule);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = $chatMsgModuleBuilderProvider.get(Reflection.getOrCreateKotlinClass(msgModule.getClass())).buildMsgModule();
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ChatMsgModuleContent buildModule = (ChatMsgModuleContent) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChatMsgModuleContent.ComposeDefaultImpls.Content$default(msgModule, $message, SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, f, 1, (Object) null), buildModule, $this_with, $composer, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void SendStatusIcon(final SendStatus sendStatus, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-447471015);
        ComposerKt.sourceInformation($composer2, "C(SendStatusIcon)N(sendStatus,onClickFailureIcon):ChatBubbleFrame.kt#wmjton");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sendStatus.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-447471015, $dirty2, -1, "kntr.app.im.chat.ui.frame.SendStatusIcon (ChatBubbleFrame.kt:438)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[sendStatus.ordinal()]) {
                case 1:
                    $composer2.startReplaceGroup(969624590);
                    ComposerKt.sourceInformation($composer2, "441@18540L67");
                    LoadingPainterKt.TinyLoadingAnimation(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Dp.constructor-impl(1)), $composer2, 6, 0);
                    $composer2.endReplaceGroup();
                    break;
                case 2:
                    $composer2.startReplaceGroup(969767996);
                    ComposerKt.sourceInformation($composer2, "446@18708L30,448@18816L6,450@18913L68,445@18663L333");
                    Painter warning_report_circle_fill_500 = BiliIconfont.INSTANCE.getWarning_report_circle_fill_500($composer2, 6);
                    long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU();
                    Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                    ComposerKt.sourceInformationMarkerStart($composer2, -522898755, "CC(remember):ChatBubbleFrame.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda16
                            public final Object invoke() {
                                Unit SendStatusIcon$lambda$0$0;
                                SendStatusIcon$lambda$0$0 = ChatBubbleFrameKt.SendStatusIcon$lambda$0$0(function0);
                                return SendStatusIcon$lambda$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    IconKt.Icon-ww6aTOc(warning_report_circle_fill_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j2, $composer2, Painter.$stable | 48, 0);
                    $composer2.endReplaceGroup();
                    break;
                default:
                    $composer2.startReplaceGroup(970115847);
                    $composer2.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit SendStatusIcon$lambda$1;
                    SendStatusIcon$lambda$1 = ChatBubbleFrameKt.SendStatusIcon$lambda$1(SendStatus.this, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SendStatusIcon$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SendStatusIcon$lambda$0$0(Function0 $onClickFailureIcon) {
        $onClickFailureIcon.invoke();
        return Unit.INSTANCE;
    }

    private static final Shape shape(ChatBubbleFrame $this$shape, boolean isOwner) {
        KBubbleStyle bubbleStyle = $this$shape.getValue().getBubbleStyle();
        if (bubbleStyle instanceof KBubbleStyle.BUBBLE_STYLE_SHARP_CORNER) {
            return RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(isOwner ? Dp.constructor-impl(12) : Dp.constructor-impl(2), isOwner ? Dp.constructor-impl(2) : Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12));
        } else if (bubbleStyle instanceof KBubbleStyle.BUBBLE_STYLE_ROUND_CORNER) {
            return RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl(12)));
        } else {
            if (bubbleStyle instanceof KBubbleStyle.BUBBLE_STYLE_BACKGROUND_CLEAR) {
                return RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl(8)));
            }
            return RectangleShapeKt.getRectangleShape();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getReportName(KMsgMenuItem $this$reportName) {
        KMsgMenuContent content = $this$reportName.getContent();
        KMsgMenuContent.IItem item = content != null ? content.getItem() : null;
        return item instanceof KMsgMenuContent.KCopy ? "Copy" : item instanceof KMsgMenuContent.KDelete ? "Delete" : item instanceof KMsgMenuContent.KRecall ? "Recall" : item instanceof KMsgMenuContent.KReport ? "Report" : item instanceof KMsgMenuContent.KSaveSticker ? "SaveSticker" : item == null ? RoomRecommendViewModel.EMPTY_CURSOR : $this$reportName.getName();
    }

    private static final long backgroundColor(ChatBubbleFrame $this$backgroundColor, boolean isOwner, Composer $composer, int $changed) {
        long j2;
        ComposerKt.sourceInformationMarkerStart($composer, -23139979, "C(backgroundColor)N(isOwner):ChatBubbleFrame.kt#wmjton");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-23139979, $changed, -1, "kntr.app.im.chat.ui.frame.backgroundColor (ChatBubbleFrame.kt:490)");
        }
        KBubbleStyle bubbleStyle = $this$backgroundColor.getValue().getBubbleStyle();
        if (bubbleStyle instanceof KBubbleStyle.BUBBLE_STYLE_SHARP_CORNER) {
            $composer.startReplaceGroup(2126773812);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            if (isOwner) {
                $composer.startReplaceGroup(-762677064);
                ComposerKt.sourceInformation($composer, "492@20320L6");
                j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLb2-0d7_KjU();
            } else {
                $composer.startReplaceGroup(-762676226);
                ComposerKt.sourceInformation($composer, "492@20346L6");
                j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU();
            }
            $composer.endReplaceGroup();
            $composer.endReplaceGroup();
        } else if (bubbleStyle instanceof KBubbleStyle.BUBBLE_STYLE_ROUND_CORNER) {
            $composer.startReplaceGroup(2126915451);
            ComposerKt.sourceInformation($composer, "496@20451L6");
            j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU();
            $composer.endReplaceGroup();
        } else if (bubbleStyle instanceof KBubbleStyle.BUBBLE_STYLE_BACKGROUND_CLEAR) {
            $composer.startReplaceGroup(2127023300);
            $composer.endReplaceGroup();
            j2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            $composer.startReplaceGroup(2127082107);
            ComposerKt.sourceInformation($composer, "504@20619L6");
            j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> continuation) {
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), new ChatBubbleFrameKt$awaitSecondDown$2(firstUp, null), continuation);
    }
}