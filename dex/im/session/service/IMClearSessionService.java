package im.session.service;

import com.bapis.bilibili.app.im.v1.KDeleteSessionListReply;
import com.bapis.bilibili.app.im.v1.KDeleteSessionListReq;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.base.IMLog;
import im.session.log.LogTagKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: IMClearSessionService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lim/session/service/IMClearSessionService;", "", "<init>", "()V", "clearSession", "Lkotlin/Result;", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "clearSession-gIAlu-s$session_debug", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMClearSessionService {
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(1:24)|25|26))|35|6|7|8|15|16|(0)|19|(0)|22|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* renamed from: clearSession-gIAlu-s$session_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3340clearSessiongIAlus$session_debug(KSessionPageType pageType, Continuation<? super Result<Unit>> continuation) {
        IMClearSessionService$clearSession$1 iMClearSessionService$clearSession$1;
        Object obj;
        Throwable it;
        Object deleteSessionList;
        if (continuation instanceof IMClearSessionService$clearSession$1) {
            iMClearSessionService$clearSession$1 = (IMClearSessionService$clearSession$1) continuation;
            if ((iMClearSessionService$clearSession$1.label & Integer.MIN_VALUE) != 0) {
                iMClearSessionService$clearSession$1.label -= Integer.MIN_VALUE;
                Object $result = iMClearSessionService$clearSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMClearSessionService$clearSession$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "即将清空会话列表(IMClearSessionService): " + pageType);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KDeleteSessionListReq kDeleteSessionListReq = new KDeleteSessionListReq(pageType);
                        iMClearSessionService$clearSession$1.L$0 = pageType;
                        iMClearSessionService$clearSession$1.I$0 = 0;
                        iMClearSessionService$clearSession$1.I$1 = 0;
                        iMClearSessionService$clearSession$1.label = 1;
                        deleteSessionList = kimMoss.deleteSessionList(kDeleteSessionListReq, iMClearSessionService$clearSession$1);
                        if (deleteSessionList != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMClearSessionService$clearSession$1.I$1;
                        int i3 = iMClearSessionService$clearSession$1.I$0;
                        pageType = (KSessionPageType) iMClearSessionService$clearSession$1.L$0;
                        ResultKt.throwOnFailure($result);
                        deleteSessionList = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KDeleteSessionListReply) deleteSessionList);
                JobKt.ensureActive(iMClearSessionService$clearSession$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    KDeleteSessionListReply kDeleteSessionListReply = (KDeleteSessionListReply) obj;
                    IMLog.Companion.i(LogTagKt.SessionLogTag, "清空会话列表成功(IMClearSessionService): " + pageType);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.SessionLogTag, "清空会话列表失败(IMClearSessionService): " + pageType, it);
                }
                if (Result.isSuccess-impl(obj)) {
                    Result.Companion companion2 = Result.Companion;
                    KDeleteSessionListReply kDeleteSessionListReply2 = (KDeleteSessionListReply) obj;
                    obj = Unit.INSTANCE;
                }
                return Result.constructor-impl(obj);
            }
        }
        iMClearSessionService$clearSession$1 = new IMClearSessionService$clearSession$1(this, continuation);
        Object $result2 = iMClearSessionService$clearSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMClearSessionService$clearSession$1.label) {
        }
        obj = Result.constructor-impl((KDeleteSessionListReply) deleteSessionList);
        JobKt.ensureActive(iMClearSessionService$clearSession$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        if (Result.isSuccess-impl(obj)) {
        }
        return Result.constructor-impl(obj);
    }
}