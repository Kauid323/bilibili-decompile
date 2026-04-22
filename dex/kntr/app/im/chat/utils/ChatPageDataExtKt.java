package kntr.app.im.chat.utils;

import com.bapis.bilibili.app.im.v1.KChatBubbleFrameLensKt;
import com.bapis.bilibili.app.im.v1.KTalkerInfo;
import com.bapis.bilibili.app.im.v1.KTalkerInfoLensKt;
import com.bapis.bilibili.app.im.v1.KUserTalkerInfo;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.TypeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.EntityMessageLensKt;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrame;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrameLensKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ChatPageDataExt.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0002\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0007"}, d2 = {"plus", "Lkntr/app/im/chat/core/model/ChatPageData;", "chatInfo", "Lkntr/app/im/chat/core/model/ChatInfo;", "fill", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageDataExtKt {
    public static final ChatPageData plus(ChatPageData $this$plus, ChatInfo chatInfo) {
        ChatPageData copy;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(chatInfo, "chatInfo");
        ChatInfo copy$default = ChatInfo.copy$default(chatInfo, null, null, chatInfo.getInputBoxConfig(), null, null, null, 59, null);
        Iterable $this$map$iv = $this$plus.getMessageGroups();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MessageGroup group = (MessageGroup) item$iv$iv;
            destination$iv$iv.add(MessageGroup.copy$default(group, null, null, fill(group.getMessages(), chatInfo), 3, null));
        }
        copy = $this$plus.copy((r36 & 1) != 0 ? $this$plus.sessionId : null, (r36 & 2) != 0 ? $this$plus.hostMid : 0L, (r36 & 4) != 0 ? $this$plus.pageStatus : null, (r36 & 8) != 0 ? $this$plus.chatInfo : copy$default, (r36 & 16) != 0 ? $this$plus.messageGroups : (List) destination$iv$iv, (r36 & 32) != 0 ? $this$plus.toast : null, (r36 & 64) != 0 ? $this$plus.previewImageData : null, (r36 & 128) != 0 ? $this$plus.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$plus.route : null, (r36 & 512) != 0 ? $this$plus.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$plus.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$plus.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$plus.deletingMsg : null, (r36 & 8192) != 0 ? $this$plus.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$plus.currentFetchResult : null, (r36 & 32768) != 0 ? $this$plus.inputContent : null, (r36 & 65536) != 0 ? $this$plus.track : null);
        return copy;
    }

    public static final List<EntityMessage> fill(List<EntityMessage> list, ChatInfo chatInfo) {
        Object element$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (chatInfo == null) {
            return list;
        }
        BSimpleLens senderInfoLens = KChatBubbleFrameLensKt.getSenderInfo(ChatBubbleFrameLensKt.getValue(TypeKt.cast(EntityMessageLensKt.getMsgFrame(EntityMessage.Companion), Reflection.getOrCreateKotlinClass(ChatBubbleFrame.class))));
        BSimpleLens placeholderLens = TypeKt.castNullable(KTalkerInfoLensKt.infoNullable(senderInfoLens), Reflection.getOrCreateKotlinClass(KTalkerInfo.KUserPlaceholder.class));
        List<EntityMessage> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            EntityMessage message = (EntityMessage) item$iv$iv;
            EntityMessage result = message;
            KTalkerInfo.KUserPlaceholder placeholder = (KTalkerInfo.KUserPlaceholder) placeholderLens.get(message);
            if (placeholder != null) {
                Iterable $this$firstOrNull$iv = chatInfo.getUserTalkerInfos();
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        KUserTalkerInfo it2 = (KUserTalkerInfo) element$iv;
                        if (it2.getMid() == placeholder.getValue().getMid()) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                KUserTalkerInfo userTalkerInfo = (KUserTalkerInfo) element$iv;
                if (userTalkerInfo != null) {
                    result = (EntityMessage) senderInfoLens.set(message, new KTalkerInfo(new KTalkerInfo.KUserTalkerInfo(userTalkerInfo)));
                }
            }
            destination$iv$iv.add(result);
        }
        return (List) destination$iv$iv;
    }
}