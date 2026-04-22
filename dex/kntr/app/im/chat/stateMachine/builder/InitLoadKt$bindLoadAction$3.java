package kntr.app.im.chat.stateMachine.builder;

import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.FetchMessageDirection;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.core.service.FetchEventType;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "event", "Lkntr/app/im/chat/core/service/FetchEventType;", "state", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.InitLoadKt$bindLoadAction$3", f = "InitLoad.kt", i = {0, 0}, l = {185}, m = "invokeSuspend", n = {"event", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class InitLoadKt$bindLoadAction$3 extends SuspendLambda implements Function3<FetchEventType, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ FusionFetchMessageService $fetchMessagesService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitLoadKt$bindLoadAction$3(FusionFetchMessageService fusionFetchMessageService, Continuation<? super InitLoadKt$bindLoadAction$3> continuation) {
        super(3, continuation);
        this.$fetchMessagesService = fusionFetchMessageService;
    }

    public final Object invoke(FetchEventType fetchEventType, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        InitLoadKt$bindLoadAction$3 initLoadKt$bindLoadAction$3 = new InitLoadKt$bindLoadAction$3(this.$fetchMessagesService, continuation);
        initLoadKt$bindLoadAction$3.L$0 = fetchEventType;
        initLoadKt$bindLoadAction$3.L$1 = chatPageData;
        return initLoadKt$bindLoadAction$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        if (r9 != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        EntityMessage it;
        FetchEventType event = (FetchEventType) this.L$0;
        ChatPageData state = (ChatPageData) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("ChatFetchEventBroadcast", "broadcastService fetchMessageFlow update, type " + event);
                if (event != FetchEventType.Fetch) {
                    if (event == FetchEventType.Update) {
                        Iterable $this$flatMap$iv = state.getMessageGroups();
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$flatMap$iv) {
                            MessageGroup it2 = (MessageGroup) element$iv$iv;
                            Iterable list$iv$iv = it2.getMessages();
                            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                        }
                        Iterable $this$any$iv = (List) destination$iv$iv;
                        boolean z = false;
                        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                            Iterator it3 = $this$any$iv.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    Object element$iv = it3.next();
                                    EntityMessage it4 = (EntityMessage) element$iv;
                                    if (it4.getSendStatus() == SendStatus.Sending) {
                                        it = 1;
                                        continue;
                                    } else {
                                        it = null;
                                        continue;
                                    }
                                    if (it != null) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                IMLog.Companion.i("ChatFetchEventBroadcast", "Request fetch");
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                if (this.$fetchMessagesService.load(FetchMessageDirection.DOWN, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}