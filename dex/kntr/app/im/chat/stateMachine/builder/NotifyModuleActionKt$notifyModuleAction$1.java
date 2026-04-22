package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMToast;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.NotifyMessageService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyModuleAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$NotifyCosmosOp;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.NotifyModuleActionKt$notifyModuleAction$1", f = "NotifyModuleAction.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {AdditionVote2.URI_FIELD_NUMBER, AdditionVote2.IS_VOTED_FIELD_NUMBER, AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER}, m = "invokeSuspend", n = {"action", "state", "action", "state", "result", "action", "state", "result", "toast", "it", "$i$a$-fold-NotifyModuleActionKt$notifyModuleAction$1$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class NotifyModuleActionKt$notifyModuleAction$1 extends SuspendLambda implements Function3<ChatAction.NotifyCosmosOp, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ NotifyMessageService $notifyModuleService;
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyModuleActionKt$notifyModuleAction$1(NotifyMessageService notifyMessageService, Continuation<? super NotifyModuleActionKt$notifyModuleAction$1> continuation) {
        super(3, continuation);
        this.$notifyModuleService = notifyMessageService;
    }

    public final Object invoke(ChatAction.NotifyCosmosOp notifyCosmosOp, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        NotifyModuleActionKt$notifyModuleAction$1 notifyModuleActionKt$notifyModuleAction$1 = new NotifyModuleActionKt$notifyModuleAction$1(this.$notifyModuleService, continuation);
        notifyModuleActionKt$notifyModuleAction$1.L$0 = notifyCosmosOp;
        notifyModuleActionKt$notifyModuleAction$1.L$1 = state;
        return notifyModuleActionKt$notifyModuleAction$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object result;
        Object create$default;
        Object result2;
        Throwable it;
        final String it2;
        final ChatAction.NotifyCosmosOp action = (ChatAction.NotifyCosmosOp) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = action;
                this.L$1 = state;
                this.label = 1;
                result = this.$notifyModuleService.mo1363notifyMessageOpgIAlus(action.getItem(), (Continuation) this);
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = result;
                this.label = 2;
                create$default = IMToast.Companion.create$default(IMToast.Companion, Result.exceptionOrNull-impl(result), (String) null, (Instant) null, (Function2) null, (Continuation) this, 14, (Object) null);
                if (create$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                result2 = result;
                final IMToast toast = (IMToast) create$default;
                it = Result.exceptionOrNull-impl(result2);
                if (it == null) {
                    IMLog.Companion.e("NotifyModuleAction", "Failed to update notify module state", it);
                    return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.NotifyModuleActionKt$notifyModuleAction$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            ChatPageData invokeSuspend$lambda$1$0;
                            invokeSuspend$lambda$1$0 = NotifyModuleActionKt$notifyModuleAction$1.invokeSuspend$lambda$1$0(toast, (ChatPageData) obj);
                            return invokeSuspend$lambda$1$0;
                        }
                    });
                }
                it2 = (String) result2;
                Duration.Companion companion = Duration.Companion;
                long duration = DurationKt.toDuration(500, DurationUnit.MILLISECONDS);
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(toast);
                this.L$4 = it2;
                this.I$0 = 0;
                this.label = 3;
                return DelayKt.delay-VtjQ1oo(duration, this) == coroutine_suspended ? coroutine_suspended : state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.NotifyModuleActionKt$notifyModuleAction$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = NotifyModuleActionKt$notifyModuleAction$1.invokeSuspend$lambda$0$0(it2, action, (ChatPageData) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).unbox-impl();
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = result;
                this.label = 2;
                create$default = IMToast.Companion.create$default(IMToast.Companion, Result.exceptionOrNull-impl(result), (String) null, (Instant) null, (Function2) null, (Continuation) this, 14, (Object) null);
                if (create$default != coroutine_suspended) {
                }
                break;
            case 2:
                Object result3 = this.L$2;
                ResultKt.throwOnFailure($result);
                create$default = $result;
                result2 = result3;
                final IMToast toast2 = (IMToast) create$default;
                it = Result.exceptionOrNull-impl(result2);
                if (it == null) {
                }
                break;
            case 3:
                int i = this.I$0;
                it2 = (String) this.L$4;
                IMToast iMToast = (IMToast) this.L$3;
                Object obj = this.L$2;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0$0(String $it, ChatAction.NotifyCosmosOp $action, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : IMToast.Companion.create$default(IMToast.Companion, $it, (Instant) null, 2, (Object) null), (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : CollectionsKt.plus($this$mutate.getPendingMsgForUpdate(), $action.getMessage().getMsgId()), (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$1$0(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}