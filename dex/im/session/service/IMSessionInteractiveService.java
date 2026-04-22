package im.session.service;

import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReply;
import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.base.IMLog;
import im.session.log.LogTagKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: IMSessionInteractiveService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lim/session/service/IMSessionInteractiveService;", "", "<init>", "()V", "updateInteractiveUnread", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;", "updateInteractiveUnread-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionInteractiveService {
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* renamed from: updateInteractiveUnread-IoAF18A  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3360updateInteractiveUnreadIoAF18A(Continuation<? super Result<KGetQuickLinkUnreadReply>> continuation) {
        IMSessionInteractiveService$updateInteractiveUnread$1 iMSessionInteractiveService$updateInteractiveUnread$1;
        Object obj;
        Throwable it;
        Object quickLinkUnread;
        if (continuation instanceof IMSessionInteractiveService$updateInteractiveUnread$1) {
            iMSessionInteractiveService$updateInteractiveUnread$1 = (IMSessionInteractiveService$updateInteractiveUnread$1) continuation;
            if ((iMSessionInteractiveService$updateInteractiveUnread$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionInteractiveService$updateInteractiveUnread$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionInteractiveService$updateInteractiveUnread$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionInteractiveService$updateInteractiveUnread$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.getUnreadLogTag(), "开始更新金刚位未读数(GetQuickLinkUnread)");
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KGetQuickLinkUnreadReq kGetQuickLinkUnreadReq = new KGetQuickLinkUnreadReq();
                        iMSessionInteractiveService$updateInteractiveUnread$1.I$0 = 0;
                        iMSessionInteractiveService$updateInteractiveUnread$1.I$1 = 0;
                        iMSessionInteractiveService$updateInteractiveUnread$1.label = 1;
                        quickLinkUnread = kimMoss.getQuickLinkUnread(kGetQuickLinkUnreadReq, iMSessionInteractiveService$updateInteractiveUnread$1);
                        if (quickLinkUnread != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSessionInteractiveService$updateInteractiveUnread$1.I$1;
                        int i3 = iMSessionInteractiveService$updateInteractiveUnread$1.I$0;
                        ResultKt.throwOnFailure($result);
                        quickLinkUnread = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KGetQuickLinkUnreadReply) quickLinkUnread);
                JobKt.ensureActive(iMSessionInteractiveService$updateInteractiveUnread$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    KGetQuickLinkUnreadReply kGetQuickLinkUnreadReply = (KGetQuickLinkUnreadReply) obj;
                    IMLog.Companion.i(LogTagKt.getUnreadLogTag(), "更新金刚位未读数(GetQuickLinkUnread)成功");
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.getUnreadLogTag(), "更新金刚位未读数(GetQuickLinkUnread)失败", it);
                }
                return obj;
            }
        }
        iMSessionInteractiveService$updateInteractiveUnread$1 = new IMSessionInteractiveService$updateInteractiveUnread$1(this, continuation);
        Object $result2 = iMSessionInteractiveService$updateInteractiveUnread$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionInteractiveService$updateInteractiveUnread$1.label) {
        }
        obj = Result.constructor-impl((KGetQuickLinkUnreadReply) quickLinkUnread);
        JobKt.ensureActive(iMSessionInteractiveService$updateInteractiveUnread$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }
}