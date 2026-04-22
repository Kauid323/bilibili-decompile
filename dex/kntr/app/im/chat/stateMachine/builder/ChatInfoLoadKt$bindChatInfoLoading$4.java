package kntr.app.im.chat.stateMachine.builder;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMToast;
import kntr.app.im.chat.core.RequestStatus;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.PageStatusLensKt;
import kntr.app.im.chat.core.model.track.ChatPageTechTrackLensKt;
import kntr.app.im.chat.core.service.LoadType;
import kntr.app.im.chat.utils.ChatPageDataExtKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatInfoLoad.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "result", "Lkotlin/Pair;", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/ChatInfo;", "Lkntr/app/im/chat/core/service/LoadType;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$4", f = "ChatInfoLoad.kt", i = {0, 0, 0, 0}, l = {53}, m = "invokeSuspend", n = {"result", "state", "data", "error"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class ChatInfoLoadKt$bindChatInfoLoading$4 extends SuspendLambda implements Function3<Pair<? extends Result<? extends ChatInfo>, ? extends LoadType>, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatInfoLoadKt$bindChatInfoLoading$4(Continuation<? super ChatInfoLoadKt$bindChatInfoLoading$4> continuation) {
        super(3, continuation);
    }

    public final Object invoke(Pair<Result<ChatInfo>, ? extends LoadType> pair, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        ChatInfoLoadKt$bindChatInfoLoading$4 chatInfoLoadKt$bindChatInfoLoading$4 = new ChatInfoLoadKt$bindChatInfoLoading$4(continuation);
        chatInfoLoadKt$bindChatInfoLoading$4.L$0 = pair;
        chatInfoLoadKt$bindChatInfoLoading$4.L$1 = state;
        return chatInfoLoadKt$bindChatInfoLoading$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final ChatInfo data;
        Object create$default;
        final Throwable error;
        final Pair result = (Pair) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object obj = ((Result) result.getFirst()).unbox-impl();
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                data = (ChatInfo) obj;
                IMLog.Companion.i("Chat", "chatInfoService dataFlow update " + data);
                Exception error2 = Result.exceptionOrNull-impl(((Result) result.getFirst()).unbox-impl());
                if (error2 == null) {
                    error2 = new Exception("Unknown error");
                }
                this.L$0 = result;
                this.L$1 = state;
                this.L$2 = data;
                this.L$3 = error2;
                this.label = 1;
                create$default = IMToast.Companion.create$default(IMToast.Companion, error2, (String) null, (Instant) null, (Function2) null, (Continuation) this, 14, (Object) null);
                if (create$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                error = error2;
                break;
            case 1:
                error = (Throwable) this.L$3;
                data = (ChatInfo) this.L$2;
                ResultKt.throwOnFailure($result);
                create$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final IMToast toast = (IMToast) create$default;
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$4$$ExternalSyntheticLambda1
            public final Object invoke(Object obj2) {
                ChatPageData invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = ChatInfoLoadKt$bindChatInfoLoading$4.invokeSuspend$lambda$0(ChatInfo.this, error, toast, result, (ChatPageData) obj2);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0(final ChatInfo $data, final Throwable $error, final IMToast $toast, final Pair $result, ChatPageData $this$mutate) {
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$4$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = ChatInfoLoadKt$bindChatInfoLoading$4.invokeSuspend$lambda$0$0(ChatInfo.this, $error, $toast, $result, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(ChatInfo $data, Throwable $error, IMToast $toast, Pair $result, CopyScope $this$copy) {
        if ($data != null) {
            $this$copy.set(ChatPageDataLensKt.getLens(ChatPageData.Companion), ChatPageDataExtKt.plus((ChatPageData) $this$copy.get(ChatPageDataLensKt.getLens(ChatPageData.Companion)), $data));
            $this$copy.set(PageStatusLensKt.getChatInfo(ChatPageDataLensKt.getPageStatus(ChatPageData.Companion)), RequestStatus.Idle.INSTANCE);
            $this$copy.set(ChatPageDataLensKt.getDisplayingBehaviorAlert(ChatPageData.Companion), $data.getReply().getBehaviorAlertToast());
        } else {
            $this$copy.set(PageStatusLensKt.getChatInfo(ChatPageDataLensKt.getPageStatus(ChatPageData.Companion)), new RequestStatus.Error($error));
            $this$copy.set(ChatPageDataLensKt.getToast(ChatPageData.Companion), $toast);
        }
        if ($result.getSecond() == LoadType.FromNetwork && Intrinsics.areEqual($this$copy.get(ChatPageTechTrackLensKt.getChatInfoLoadEnd(ChatPageDataLensKt.getTrack(ChatPageData.Companion))), Instant.Companion.getDISTANT_PAST())) {
            $this$copy.set(ChatPageTechTrackLensKt.getChatInfoLoadEnd(ChatPageDataLensKt.getTrack(ChatPageData.Companion)), Clock.System.INSTANCE.now());
            $this$copy.set(ChatPageTechTrackLensKt.getChatInfoError(ChatPageDataLensKt.getTrack(ChatPageData.Companion)), Result.exceptionOrNull-impl(((Result) $result.getFirst()).unbox-impl()));
        }
        return Unit.INSTANCE;
    }
}