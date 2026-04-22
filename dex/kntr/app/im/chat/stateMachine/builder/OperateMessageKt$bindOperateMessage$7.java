package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMRouteHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperateMessage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$ReportMessage;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$7", f = "OperateMessage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OperateMessageKt$bindOperateMessage$7 extends SuspendLambda implements Function3<ChatAction.ReportMessage, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OperateMessageKt$bindOperateMessage$7(Continuation<? super OperateMessageKt$bindOperateMessage$7> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ChatAction.ReportMessage reportMessage, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        OperateMessageKt$bindOperateMessage$7 operateMessageKt$bindOperateMessage$7 = new OperateMessageKt$bindOperateMessage$7(continuation);
        operateMessageKt$bindOperateMessage$7.L$0 = reportMessage;
        operateMessageKt$bindOperateMessage$7.L$1 = state;
        return operateMessageKt$bindOperateMessage$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        KChatInfoReply reply;
        ChatAction.ReportMessage action = (ChatAction.ReportMessage) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable<MessageGroup> $this$flatMap$iv = ((ChatPageData) state.getSnapshot()).getMessageGroups();
                Collection destination$iv$iv = new ArrayList();
                for (MessageGroup it : $this$flatMap$iv) {
                    Iterable list$iv$iv = it.getMessages();
                    CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                }
                Iterable $this$filter$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    EntityMessage it2 = (EntityMessage) element$iv$iv;
                    if (!it2.getMsgId().isLocalMessage()) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                List allMsgs = (List) destination$iv$iv2;
                int index$iv = 0;
                Iterator it3 = allMsgs.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object item$iv = it3.next();
                        EntityMessage it4 = (EntityMessage) item$iv;
                        if (!Intrinsics.areEqual(it4.getMsgId(), action.getOfMessage())) {
                            index$iv++;
                        }
                    } else {
                        index$iv = -1;
                    }
                }
                int reportIndex = index$iv;
                if (reportIndex >= 0) {
                    List msgNearBy = allMsgs.subList(Math.max(0, reportIndex - 5), Math.min(allMsgs.size(), reportIndex + 5));
                    String reportParam = CollectionsKt.joinToString$default(msgNearBy, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$7$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            CharSequence invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = OperateMessageKt$bindOperateMessage$7.invokeSuspend$lambda$3((EntityMessage) obj);
                            return invokeSuspend$lambda$3;
                        }
                    }, 30, (Object) null);
                    Builder baseUrl = Uri.Companion.parse(new Regex("#/?").replace(action.getBaseUrl(), RoomRecommendViewModel.EMPTY_CURSOR)).buildUpon();
                    Builder appendQueryParameter = baseUrl.appendQueryParameter("msg", reportParam);
                    ChatInfo chatInfo = ((ChatPageData) state.getSnapshot()).getChatInfo();
                    if (chatInfo == null || (reply = chatInfo.getReply()) == null) {
                        str = null;
                    } else {
                        str = reply.getSessionName();
                    }
                    String appendedUrl = appendQueryParameter.appendQueryParameter("name", str).fragment((String) null).build().toString();
                    final String reportUrl = StringsKt.replace$default(appendedUrl, "?", "/#/?", false, 4, (Object) null);
                    IMLog.Companion.i("OperateMessage", "举报消息，跳转到 " + reportUrl);
                    return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$7$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            ChatPageData invokeSuspend$lambda$4;
                            invokeSuspend$lambda$4 = OperateMessageKt$bindOperateMessage$7.invokeSuspend$lambda$4(reportUrl, (ChatPageData) obj);
                            return invokeSuspend$lambda$4;
                        }
                    });
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$3(EntityMessage it) {
        return String.valueOf(it.getMsgId().getMsgKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$4(String $reportUrl, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : null, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : IMRouteHolder.Companion.create($reportUrl), (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}