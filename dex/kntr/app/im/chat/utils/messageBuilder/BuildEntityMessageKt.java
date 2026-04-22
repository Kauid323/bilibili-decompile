package kntr.app.im.chat.utils.messageBuilder;

import com.bapis.bilibili.app.im.v1.KBubbleStyle;
import com.bapis.bilibili.app.im.v1.KChatBubbleFrame;
import com.bapis.bilibili.app.im.v1.KChatBubbleWidget;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KMsgMenuItem;
import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KTalkerInfo;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.model.SessionId;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrame;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.im.chat.utils.UUIDKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: BuildEntityMessage.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ar\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r0\u0016H\u0080\bø\u0001\u0000\u001aH\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r0\u0016H\u0080\bø\u0001\u0000\u001a@\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\r0\u0016H\u0080\bø\u0001\u0000\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r0\u00162\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\r0\u0016H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"buildChatBubbleEntityMessage", "Lkntr/app/im/chat/core/model/EntityMessage;", "msgKey", RoomRecommendViewModel.EMPTY_CURSOR, "sequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "sessionID", "Lim/base/model/SessionId;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "menu", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;", "transformers", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "style", "Lcom/bapis/bilibili/app/im/v1/KBubbleStyle;", "buildModules", "Lkotlin/Function0;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule;", "buildBubbleFrame", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrame;", "buildMsgModules", "Lkntr/app/im/chat/core/model/MsgModule;", "buildKModules", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BuildEntityMessageKt {
    public static /* synthetic */ EntityMessage buildChatBubbleEntityMessage$default(long msgKey, MessageSequence sequence, KUserPlaceholder userPlaceholder, SessionId sessionID, KEntityMsgType msgType, List menu, MsgModuleTransformers transformers, String token, KBubbleStyle style, Function0 buildModules, int i, Object obj) {
        String token2;
        KBubbleStyle style2;
        if ((i & 128) == 0) {
            token2 = token;
        } else {
            token2 = UUIDKt.generateUUID();
        }
        if ((i & 256) == 0) {
            style2 = style;
        } else {
            style2 = (KBubbleStyle) KBubbleStyle.BUBBLE_STYLE_SHARP_CORNER.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(buildModules, "buildModules");
        MessageId messageId = new MessageId(sessionID, msgKey, sequence);
        KBubbleStyle style$iv = style2;
        List modules$iv = (List) buildModules.invoke();
        return new EntityMessage(0L, messageId, msgType, new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, menu, modules$iv, style$iv, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), transformers.transformToMsgModules(modules$iv)), Clock.System.INSTANCE.now(), token2, false, SendStatus.Sending, null, null, false, false, null, 7937, null);
    }

    public static final EntityMessage buildChatBubbleEntityMessage(long msgKey, MessageSequence sequence, KUserPlaceholder userPlaceholder, SessionId sessionID, KEntityMsgType msgType, List<KMsgMenuItem> list, MsgModuleTransformers transformers, String token, KBubbleStyle style, Function0<? extends List<KMsgModule>> function0) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(list, "menu");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(function0, "buildModules");
        MessageId messageId = new MessageId(sessionID, msgKey, sequence);
        List modules$iv = (List) function0.invoke();
        return new EntityMessage(0L, messageId, msgType, new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, list, modules$iv, style, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), transformers.transformToMsgModules(modules$iv)), Clock.System.INSTANCE.now(), token, false, SendStatus.Sending, null, null, false, false, null, 7937, null);
    }

    public static /* synthetic */ ChatBubbleFrame buildBubbleFrame$default(KUserPlaceholder userPlaceholder, List menu, MsgModuleTransformers transformers, KBubbleStyle style, Function0 buildModules, int i, Object obj) {
        KBubbleStyle style2;
        if ((i & 8) == 0) {
            style2 = style;
        } else {
            style2 = (KBubbleStyle) KBubbleStyle.BUBBLE_STYLE_SHARP_CORNER.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(buildModules, "buildModules");
        List modules = (List) buildModules.invoke();
        return new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, menu, modules, style2, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), transformers.transformToMsgModules(modules));
    }

    public static final ChatBubbleFrame buildBubbleFrame(KUserPlaceholder userPlaceholder, List<KMsgMenuItem> list, MsgModuleTransformers transformers, KBubbleStyle style, Function0<? extends List<KMsgModule>> function0) {
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(list, "menu");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(function0, "buildModules");
        List modules = (List) function0.invoke();
        return new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, list, modules, style, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), transformers.transformToMsgModules(modules));
    }

    public static /* synthetic */ ChatBubbleFrame buildBubbleFrame$default(KUserPlaceholder userPlaceholder, List menu, KBubbleStyle style, Function0 buildMsgModules, int i, Object obj) {
        KBubbleStyle style2;
        if ((i & 4) == 0) {
            style2 = style;
        } else {
            style2 = (KBubbleStyle) KBubbleStyle.BUBBLE_STYLE_SHARP_CORNER.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(buildMsgModules, "buildMsgModules");
        List modules = (List) buildMsgModules.invoke();
        return new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, menu, CollectionsKt.emptyList(), style2, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), modules);
    }

    public static final ChatBubbleFrame buildBubbleFrame(KUserPlaceholder userPlaceholder, List<KMsgMenuItem> list, KBubbleStyle style, Function0<? extends List<? extends MsgModule>> function0) {
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(list, "menu");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(function0, "buildMsgModules");
        List modules = (List) function0.invoke();
        return new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, list, CollectionsKt.emptyList(), style, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), modules);
    }

    public static /* synthetic */ EntityMessage buildChatBubbleEntityMessage$default(MessageSequence sequence, KUserPlaceholder userPlaceholder, SessionId sessionID, KEntityMsgType msgType, List menu, String token, KBubbleStyle style, Function0 buildKModules, Function0 buildModules, int i, Object obj) {
        String token2;
        KBubbleStyle style2;
        if ((i & 32) == 0) {
            token2 = token;
        } else {
            token2 = UUIDKt.generateUUID();
        }
        if ((i & 64) == 0) {
            style2 = style;
        } else {
            style2 = (KBubbleStyle) KBubbleStyle.BUBBLE_STYLE_ROUND_CORNER.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(buildKModules, "buildKModules");
        Intrinsics.checkNotNullParameter(buildModules, "buildModules");
        return new EntityMessage(0L, new MessageId(sessionID, 0L, sequence), msgType, new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, menu, (List) buildKModules.invoke(), style2, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), (List) buildModules.invoke()), Clock.System.INSTANCE.now(), token2, false, SendStatus.Sending, null, null, false, false, null, 7937, null);
    }

    public static final EntityMessage buildChatBubbleEntityMessage(MessageSequence sequence, KUserPlaceholder userPlaceholder, SessionId sessionID, KEntityMsgType msgType, List<KMsgMenuItem> list, String token, KBubbleStyle style, Function0<? extends List<KMsgModule>> function0, Function0<? extends List<? extends MsgModule>> function02) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(list, "menu");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(function0, "buildKModules");
        Intrinsics.checkNotNullParameter(function02, "buildModules");
        return new EntityMessage(0L, new MessageId(sessionID, 0L, sequence), msgType, new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, list, (List) function0.invoke(), style, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), (List) function02.invoke()), Clock.System.INSTANCE.now(), token, false, SendStatus.Sending, null, null, false, false, null, 7937, null);
    }
}