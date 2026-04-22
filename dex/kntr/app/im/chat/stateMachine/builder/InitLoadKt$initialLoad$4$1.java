package kntr.app.im.chat.stateMachine.builder;

import com.bilibili.blens.BSetter;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMToast;
import java.util.List;
import kntr.app.im.chat.core.RequestStatus;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataKt;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.PageStatusLensKt;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.im.chat.stateMachine.builder.send.ChatUserUpgradeException;
import kntr.app.im.chat.utils.ChatPageDataExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$4$1", f = "InitLoad.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {70, 73}, m = "invokeSuspend", n = {"state", "data", "messages", "state", "data", "messages", "messageGroup", "error", "errorTime", "it", "$i$a$-let-InitLoadKt$initialLoad$4$1$toast$1"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
public final class InitLoadKt$initialLoad$4$1 extends SuspendLambda implements Function2<State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ MessageGroupingService $groupingService;
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitLoadKt$initialLoad$4$1(MessageGroupingService messageGroupingService, Continuation<? super InitLoadKt$initialLoad$4$1> continuation) {
        super(2, continuation);
        this.$groupingService = messageGroupingService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> initLoadKt$initialLoad$4$1 = new InitLoadKt$initialLoad$4$1(this.$groupingService, continuation);
        initLoadKt$initialLoad$4$1.L$0 = obj;
        return initLoadKt$initialLoad$4$1;
    }

    public final Object invoke(State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object groupMessages;
        FetchMessagesData data;
        List<EntityMessage> list;
        List messageGroup;
        Throwable error;
        Instant errorTime;
        final IMToast toast;
        List<EntityMessage> list2;
        FetchMessagesData data2;
        List messageGroup2;
        Throwable error2;
        Object obj;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FetchMessagesData data3 = ((ChatPageData) state.getSnapshot()).getCurrentFetchResult();
                if (data3 != null) {
                    List<EntityMessage> fill = ChatPageDataExtKt.fill(data3.getMessages().getMessagesForDisplay(), ((ChatPageData) state.getSnapshot()).getChatInfo());
                    this.L$0 = state;
                    this.L$1 = data3;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(fill);
                    this.label = 1;
                    groupMessages = InitLoadKt.groupMessages(this.$groupingService, fill, (Continuation) this);
                    if (groupMessages != coroutine_suspended) {
                        data = data3;
                        list = fill;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    return state.noChange();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                groupMessages = $result;
                list = (List) this.L$2;
                data = (FetchMessagesData) this.L$1;
                break;
            case 2:
                int i = this.I$0;
                Throwable th = (Throwable) this.L$6;
                error2 = (Throwable) this.L$4;
                messageGroup2 = (List) this.L$3;
                list2 = (List) this.L$2;
                data2 = (FetchMessagesData) this.L$1;
                ResultKt.throwOnFailure($result);
                errorTime = (Instant) this.L$5;
                obj = $result;
                toast = (IMToast) obj;
                error = error2;
                messageGroup = messageGroup2;
                data = data2;
                IMLog.Companion.e("Chat", "Fetch messages error", error);
                final FetchMessagesData fetchMessagesData = data;
                final List list3 = messageGroup;
                final Throwable th2 = error;
                final Instant instant = errorTime;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        ChatPageData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = InitLoadKt$initialLoad$4$1.invokeSuspend$lambda$1(FetchMessagesData.this, list3, th2, instant, toast, (ChatPageData) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        messageGroup = (List) groupMessages;
        error = data.getError();
        Instant errorTime2 = data.getErrorTime();
        if (errorTime2 == null) {
            errorTime2 = Clock.System.INSTANCE.now();
        }
        errorTime = errorTime2;
        Throwable it = data.getError();
        if (it == null) {
            toast = null;
            IMLog.Companion.e("Chat", "Fetch messages error", error);
            final FetchMessagesData fetchMessagesData2 = data;
            final List list32 = messageGroup;
            final Throwable th22 = error;
            final Instant instant2 = errorTime;
            return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$4$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    ChatPageData invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = InitLoadKt$initialLoad$4$1.invokeSuspend$lambda$1(FetchMessagesData.this, list32, th22, instant2, toast, (ChatPageData) obj2);
                    return invokeSuspend$lambda$1;
                }
            });
        }
        IMToast.Companion companion = IMToast.Companion;
        this.L$0 = state;
        this.L$1 = data;
        this.L$2 = SpillingKt.nullOutSpilledVariable(list);
        this.L$3 = messageGroup;
        this.L$4 = error;
        this.L$5 = errorTime;
        this.L$6 = SpillingKt.nullOutSpilledVariable(it);
        this.I$0 = 0;
        this.label = 2;
        Object create$default = IMToast.Companion.create$default(companion, it, (String) null, errorTime, (Function2) null, this, 10, (Object) null);
        if (create$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        list2 = list;
        data2 = data;
        messageGroup2 = messageGroup;
        error2 = error;
        obj = create$default;
        toast = (IMToast) obj;
        error = error2;
        messageGroup = messageGroup2;
        data = data2;
        IMLog.Companion.e("Chat", "Fetch messages error", error);
        final FetchMessagesData fetchMessagesData22 = data;
        final List list322 = messageGroup;
        final Throwable th222 = error;
        final Instant instant22 = errorTime;
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                ChatPageData invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = InitLoadKt$initialLoad$4$1.invokeSuspend$lambda$1(FetchMessagesData.this, list322, th222, instant22, toast, (ChatPageData) obj2);
                return invokeSuspend$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$1(final FetchMessagesData $data, final List $messageGroup, final Throwable $error, final Instant $errorTime, final IMToast $toast, ChatPageData $this$mutate) {
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$initialLoad$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = InitLoadKt$initialLoad$4$1.invokeSuspend$lambda$1$0(FetchMessagesData.this, $messageGroup, $error, $errorTime, $toast, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(FetchMessagesData $data, List $messageGroup, Throwable $error, Instant $errorTime, IMToast $toast, CopyScope $this$copy) {
        $this$copy.set(PageStatusLensKt.getLaterMessages(ChatPageDataLensKt.getPageStatus(ChatPageData.Companion)), $data.getLoadingLater() ? RequestStatus.Loading.INSTANCE : RequestStatus.Idle.INSTANCE);
        $this$copy.set(PageStatusLensKt.getEarlierMessages(ChatPageDataLensKt.getPageStatus(ChatPageData.Companion)), $data.getLoadingEarlier() ? RequestStatus.Loading.INSTANCE : RequestStatus.Idle.INSTANCE);
        $this$copy.set(ChatPageDataLensKt.getMessageGroups(ChatPageData.Companion), $messageGroup);
        if (($error instanceof ChatUserUpgradeException) && ChatPageDataKt.checkNeedUpdate((ChatUpgradeAnswerDialogStatus) $this$copy.get(ChatPageDataLensKt.getUpgradeAnswerDialogStatus(ChatPageData.Companion)), $errorTime)) {
            BSetter upgradeAnswerDialogStatus = ChatPageDataLensKt.getUpgradeAnswerDialogStatus(ChatPageData.Companion);
            Instant errorTime = $data.getErrorTime();
            if (errorTime == null) {
                errorTime = Clock.System.INSTANCE.now();
            }
            $this$copy.set(upgradeAnswerDialogStatus, new ChatUpgradeAnswerDialogStatus.SHOW(errorTime));
        } else {
            InitLoadKt.updateToast($this$copy, $toast);
        }
        return Unit.INSTANCE;
    }
}