package kntr.app.im.chat.di.module.assistant;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KNotifyCosmoThreeDotItem;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KUpdateNotifyCosmoStateReply;
import com.bapis.bilibili.app.im.v1.KUpdateNotifyCosmoStateReq;
import kntr.app.im.chat.core.service.NotifyMessageService;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: AssistantNotifyModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class AssistantNotifyModule$provideNotifyMessageService$1 implements NotifyMessageService {
    final /* synthetic */ KSessionId $sessionId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssistantNotifyModule$provideNotifyMessageService$1(KSessionId kSessionId) {
        this.$sessionId = kSessionId;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // kntr.app.im.chat.core.service.NotifyMessageService
    /* renamed from: notifyMessageOp-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo1363notifyMessageOpgIAlus(KNotifyCosmoThreeDotItem it, Continuation<? super Result<String>> continuation) {
        AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1 assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1;
        int $i$f$runSuspendCatching;
        Object updateNotifyCosmoState;
        int $i$f$runSuspendCatching2;
        Throwable th;
        Object obj;
        if (continuation instanceof AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1) {
            assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1 = (AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1) continuation;
            if ((assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.label & Integer.MIN_VALUE) != 0) {
                assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.label -= Integer.MIN_VALUE;
                Object $result = assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KSessionId kSessionId = this.$sessionId;
                        $i$f$runSuspendCatching = 0;
                        try {
                            Result.Companion companion = Result.Companion;
                            KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            KUpdateNotifyCosmoStateReq kUpdateNotifyCosmoStateReq = new KUpdateNotifyCosmoStateReq(kSessionId, it);
                            assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                            assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.I$0 = 0;
                            assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.I$1 = 0;
                            assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.label = 1;
                            updateNotifyCosmoState = kChatMoss.updateNotifyCosmoState(kUpdateNotifyCosmoStateReq, assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1);
                        } catch (Throwable th2) {
                            th = th2;
                            $i$f$runSuspendCatching2 = $i$f$runSuspendCatching;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.getContext());
                            return obj;
                        }
                        if (updateNotifyCosmoState == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = Result.constructor-impl(((KUpdateNotifyCosmoStateReply) updateNotifyCosmoState).getText());
                        JobKt.ensureActive(assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.getContext());
                        return obj;
                    case 1:
                        int i = assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.I$1;
                        $i$f$runSuspendCatching2 = assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.I$0;
                        KNotifyCosmoThreeDotItem kNotifyCosmoThreeDotItem = (KNotifyCosmoThreeDotItem) assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$runSuspendCatching = $i$f$runSuspendCatching2;
                            updateNotifyCosmoState = $result;
                            obj = Result.constructor-impl(((KUpdateNotifyCosmoStateReply) updateNotifyCosmoState).getText());
                        } catch (Throwable th3) {
                            th = th3;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.getContext());
                            return obj;
                        }
                        JobKt.ensureActive(assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.getContext());
                        return obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1 = new AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1(this, continuation);
        Object $result2 = assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (assistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1.label) {
        }
    }
}