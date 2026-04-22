package kntr.app.im.chat.core.service;

import androidx.compose.runtime.State;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.model.SessionId;
import java.util.LinkedHashMap;
import java.util.Set;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: MessageSendService.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ.\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH¦@¢\u0006\u0002\u0010 R:\u0010\u0002\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006!À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendService;", RoomRecommendViewModel.EMPTY_CURSOR, "tasks", "Landroidx/compose/runtime/State;", "Ljava/util/LinkedHashMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageTask;", "Lkotlin/collections/LinkedHashMap;", "getTasks$annotations", "()V", "getTasks", "()Landroidx/compose/runtime/State;", "start", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "sessionId", "Lim/base/model/SessionId;", "content", "Lkntr/app/im/chat/core/model/InputContent;", "imageType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/model/InputContent;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resend", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeResult", "successToken", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageSendService {

    /* compiled from: MessageSendService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getTasks$annotations() {
        }
    }

    Object consumeResult(Set<String> set, Continuation<? super Unit> continuation);

    State<LinkedHashMap<String, MessageTask>> getTasks();

    Object resend(EntityMessage entityMessage, KUserPlaceholder kUserPlaceholder, Continuation<? super Unit> continuation);

    Object send(SessionId sessionId, InputContent inputContent, KEntityMsgType kEntityMsgType, KUserPlaceholder kUserPlaceholder, Continuation<? super Unit> continuation);

    Object start(Continuation<? super Unit> continuation);
}