package kntr.app.im.chat.service.sender;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.model.SessionId;
import java.util.List;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;

/* compiled from: TextMessageSender.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0096@¢\u0006\u0002\u0010\u0016J.\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/service/sender/TextMessageSender;", "Lkntr/app/im/chat/service/sender/MessageSender;", "transformer", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "networkSendMessageService", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "<init>", "(Lkntr/app/im/chat/network/MsgModuleTransformers;Lkntr/app/im/chat/core/service/NetworkSendMessageService;)V", "send", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageTask;", "sessionId", "Lim/base/model/SessionId;", "content", "Lkntr/app/im/chat/core/model/InputContent;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "offsetProvider", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/model/InputContent;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resend", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextMessageSender implements MessageSender {
    public static final String TAG = "TextMessageSender";
    private final NetworkSendMessageService networkSendMessageService;
    private final MsgModuleTransformers transformer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public TextMessageSender(MsgModuleTransformers transformer, NetworkSendMessageService networkSendMessageService) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
        this.transformer = transformer;
        this.networkSendMessageService = networkSendMessageService;
    }

    /* compiled from: TextMessageSender.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/service/sender/TextMessageSender$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.im.chat.service.sender.MessageSender
    public Object send(SessionId sessionId, InputContent content, KEntityMsgType msgType, KUserPlaceholder userPlaceholder, Function0<Long> function0, Continuation<? super List<? extends MessageTask>> continuation) {
        InputBoxContent attributedString = content.getInputBoxContent();
        if (!attributedString.isBlank()) {
            return CollectionsKt.listOf(new TextMessageTask(this.networkSendMessageService, attributedString, userPlaceholder, this.transformer, Uuid.Companion.random().toString(), ((Number) function0.invoke()).longValue()));
        }
        return CollectionsKt.emptyList();
    }

    @Override // kntr.app.im.chat.service.sender.MessageSender
    public Object resend(EntityMessage message, KUserPlaceholder userPlaceholder, Function0<Long> function0, Continuation<? super MessageTask> continuation) {
        NetworkSendMessageService networkSendMessageService = this.networkSendMessageService;
        String token = message.getToken();
        if (token == null) {
            token = Uuid.Companion.random().toString();
        }
        return new TextMessageTask(networkSendMessageService, token, message.getMsgFrame(), ((Number) function0.invoke()).longValue());
    }
}