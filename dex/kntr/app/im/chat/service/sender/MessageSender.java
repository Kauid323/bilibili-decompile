package kntr.app.im.chat.service.sender;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.model.SessionId;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* compiled from: MessageSender.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH¦@¢\u0006\u0002\u0010\u0010J.\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/service/sender/MessageSender;", RoomRecommendViewModel.EMPTY_CURSOR, "send", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageTask;", "sessionId", "Lim/base/model/SessionId;", "content", "Lkntr/app/im/chat/core/model/InputContent;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "offsetProvider", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/model/InputContent;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resend", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageSender {
    Object resend(EntityMessage entityMessage, KUserPlaceholder kUserPlaceholder, Function0<Long> function0, Continuation<? super MessageTask> continuation);

    Object send(SessionId sessionId, InputContent inputContent, KEntityMsgType kEntityMsgType, KUserPlaceholder kUserPlaceholder, Function0<Long> function0, Continuation<? super List<? extends MessageTask>> continuation);
}