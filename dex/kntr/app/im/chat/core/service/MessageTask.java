package kntr.app.im.chat.core.service;

import androidx.compose.runtime.State;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: MessageSendService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0017\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aH&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH¦@¢\u0006\u0004\b\u001e\u0010\u0018R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/MessageTask;", RoomRecommendViewModel.EMPTY_CURSOR, "content", "Lkntr/app/im/chat/core/model/MsgFrame;", "getContent", "()Lkntr/app/im/chat/core/model/MsgFrame;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "getToken", "()Ljava/lang/String;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "getMsgType", "()Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "sequenceOffset", RoomRecommendViewModel.EMPTY_CURSOR, "getSequenceOffset", "()J", "progress", "Landroidx/compose/runtime/State;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "getProgress", "()Landroidx/compose/runtime/State;", "init", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUpload", "Lkotlinx/coroutines/flow/Flow;", "send", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/EntityMessage;", "send-IoAF18A", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageTask {
    MsgFrame getContent();

    KEntityMsgType getMsgType();

    State<MessageSendProgress> getProgress();

    long getSequenceOffset();

    String getToken();

    Object init(Continuation<? super MsgFrame> continuation);

    /* renamed from: send-IoAF18A  reason: not valid java name */
    Object mo1358sendIoAF18A(Continuation<? super Result<EntityMessage>> continuation);

    Flow<MessageSendProgress> startUpload();
}