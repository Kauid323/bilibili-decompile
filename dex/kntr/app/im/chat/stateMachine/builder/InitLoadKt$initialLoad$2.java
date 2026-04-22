package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "data", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$2", f = "InitLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InitLoadKt$initialLoad$2 extends SuspendLambda implements Function3<FetchMessagesData, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InitLoadKt$initialLoad$2(Continuation<? super InitLoadKt$initialLoad$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FetchMessagesData fetchMessagesData, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InitLoadKt$initialLoad$2 initLoadKt$initialLoad$2 = new InitLoadKt$initialLoad$2(continuation);
        initLoadKt$initialLoad$2.L$0 = fetchMessagesData;
        initLoadKt$initialLoad$2.L$1 = state;
        return initLoadKt$initialLoad$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final FetchMessagesData data = (FetchMessagesData) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = InitLoadKt$initialLoad$2.invokeSuspend$lambda$0(FetchMessagesData.this, (ChatPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0(FetchMessagesData $data, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : null, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : $data, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}