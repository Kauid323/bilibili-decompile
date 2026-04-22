package kntr.app.im.chat.core.service;

import androidx.compose.runtime.SnapshotStateKt;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: MessageSendService.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"send", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageSendService;", "sessionId", "Lim/base/model/SessionId;", "asset", "Lkntr/common/photonic/Asset;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "(Lkntr/app/im/chat/core/service/MessageSendService;Lim/base/model/SessionId;Lkntr/common/photonic/Asset;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progressFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "Lkntr/app/im/chat/core/service/MessageTask;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MessageSendServiceKt {
    public static final Object send(MessageSendService $this$send, SessionId sessionId, Asset asset, KEntityMsgType msgType, KUserPlaceholder userPlaceholder, Continuation<? super Unit> continuation) {
        Object send = $this$send.send(sessionId, new InputContent(new InputBoxContent(null, 0, 0, null, 15, null), CollectionsKt.listOf(asset), false, 0, 12, null), msgType, userPlaceholder, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    public static final Flow<MessageSendProgress> progressFlow(final MessageTask $this$progressFlow) {
        Intrinsics.checkNotNullParameter($this$progressFlow, "<this>");
        return FlowKt.transformWhile(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.core.service.MessageSendServiceKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                MessageSendProgress progressFlow$lambda$0;
                progressFlow$lambda$0 = MessageSendServiceKt.progressFlow$lambda$0(MessageTask.this);
                return progressFlow$lambda$0;
            }
        }), new MessageSendServiceKt$progressFlow$2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageSendProgress progressFlow$lambda$0(MessageTask $this_progressFlow) {
        return (MessageSendProgress) $this_progressFlow.getProgress().getValue();
    }
}