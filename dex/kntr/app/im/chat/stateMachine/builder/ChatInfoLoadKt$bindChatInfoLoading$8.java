package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KAlertToastType;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KClearAlertReply;
import com.bapis.bilibili.app.im.v1.KClearAlertReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.base.IMLog;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatInfoLoad.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction$DismissBehaviorAlert;", "stateSnapshot", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$8", f = "ChatInfoLoad.kt", i = {0, 0, 0}, l = {87}, m = "invokeSuspend", n = {"stateSnapshot", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ChatInfoLoadKt$bindChatInfoLoading$8$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class ChatInfoLoadKt$bindChatInfoLoading$8 extends SuspendLambda implements Function3<ChatAction.DismissBehaviorAlert, ChatPageData, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatInfoLoadKt$bindChatInfoLoading$8(Continuation<? super ChatInfoLoadKt$bindChatInfoLoading$8> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ChatAction.DismissBehaviorAlert dismissBehaviorAlert, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        ChatInfoLoadKt$bindChatInfoLoading$8 chatInfoLoadKt$bindChatInfoLoading$8 = new ChatInfoLoadKt$bindChatInfoLoading$8(continuation);
        chatInfoLoadKt$bindChatInfoLoading$8.L$0 = chatPageData;
        return chatInfoLoadKt$bindChatInfoLoading$8.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        KAlertToastType kAlertToastType;
        Object clearAlert;
        ChatPageData stateSnapshot = (ChatPageData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Result.Companion companion = Result.Companion;
                    KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    KBehaviorAlertToast displayingBehaviorAlert = stateSnapshot.getDisplayingBehaviorAlert();
                    if (displayingBehaviorAlert == null || (kAlertToastType = displayingBehaviorAlert.getType()) == null) {
                        kAlertToastType = KAlertToastType.ALERT_TOAST_TYPE_UNSPECIFIED.INSTANCE;
                    }
                    KClearAlertReq kClearAlertReq = new KClearAlertReq(kAlertToastType);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stateSnapshot);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    clearAlert = kimMoss.clearAlert(kClearAlertReq, this);
                    if (clearAlert != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    int i = this.I$1;
                    int i2 = this.I$0;
                    ResultKt.throwOnFailure($result);
                    clearAlert = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = Result.constructor-impl((KClearAlertReply) clearAlert);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        JobKt.ensureActive(getContext());
        if (Result.isSuccess-impl(obj)) {
            KClearAlertReply kClearAlertReply = (KClearAlertReply) obj;
            IMLog.Companion.i("Chat", "行为警告弹窗消除成功");
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            IMLog.Companion.e("Chat", "行为警告弹窗消除失败", it);
        }
        return Unit.INSTANCE;
    }
}