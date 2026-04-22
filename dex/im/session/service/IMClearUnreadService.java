package im.session.service;

import com.bapis.bilibili.app.im.v1.KClearUnreadReply;
import com.bapis.bilibili.app.im.v1.KClearUnreadReq;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionCard;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: IMClearUnreadService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0004\b\t\u0010\nJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lim/session/service/IMClearUnreadService;", "", "<init>", "()V", "clearUnread", "Lkotlin/Result;", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "clearUnread-gIAlu-s", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSessionUnread", "session", "Lim/session/model/IMSessionCard;", "clearSessionUnread-0E7RQCE", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lim/session/model/IMSessionCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMClearUnreadService {
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(1:24)|25|26))|35|6|7|8|15|16|(0)|19|(0)|22|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* renamed from: clearUnread-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3343clearUnreadgIAlus(KSessionPageType pageType, Continuation<? super Result<Unit>> continuation) {
        IMClearUnreadService$clearUnread$1 iMClearUnreadService$clearUnread$1;
        Object obj;
        Throwable it;
        Object clearUnread;
        if (continuation instanceof IMClearUnreadService$clearUnread$1) {
            iMClearUnreadService$clearUnread$1 = (IMClearUnreadService$clearUnread$1) continuation;
            if ((iMClearUnreadService$clearUnread$1.label & Integer.MIN_VALUE) != 0) {
                iMClearUnreadService$clearUnread$1.label -= Integer.MIN_VALUE;
                Object $result = iMClearUnreadService$clearUnread$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMClearUnreadService$clearUnread$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "开始请求一键已读(ClearUnread): " + pageType);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KClearUnreadReq kClearUnreadReq = new KClearUnreadReq(pageType, (KSessionId) null, 2, (DefaultConstructorMarker) null);
                        iMClearUnreadService$clearUnread$1.L$0 = pageType;
                        iMClearUnreadService$clearUnread$1.I$0 = 0;
                        iMClearUnreadService$clearUnread$1.I$1 = 0;
                        iMClearUnreadService$clearUnread$1.label = 1;
                        clearUnread = kimMoss.clearUnread(kClearUnreadReq, iMClearUnreadService$clearUnread$1);
                        if (clearUnread != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMClearUnreadService$clearUnread$1.I$1;
                        int i3 = iMClearUnreadService$clearUnread$1.I$0;
                        pageType = (KSessionPageType) iMClearUnreadService$clearUnread$1.L$0;
                        ResultKt.throwOnFailure($result);
                        clearUnread = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KClearUnreadReply) clearUnread);
                JobKt.ensureActive(iMClearUnreadService$clearUnread$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    KClearUnreadReply kClearUnreadReply = (KClearUnreadReply) obj;
                    IMLog.Companion.i(LogTagKt.SessionLogTag, "一键已读(ClearUnread)成功: " + pageType);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.SessionLogTag, "一键已读(ClearUnread)失败: " + pageType, it);
                }
                if (Result.isSuccess-impl(obj)) {
                    Result.Companion companion2 = Result.Companion;
                    KClearUnreadReply kClearUnreadReply2 = (KClearUnreadReply) obj;
                    obj = Unit.INSTANCE;
                }
                return Result.constructor-impl(obj);
            }
        }
        iMClearUnreadService$clearUnread$1 = new IMClearUnreadService$clearUnread$1(this, continuation);
        Object $result2 = iMClearUnreadService$clearUnread$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMClearUnreadService$clearUnread$1.label) {
        }
        obj = Result.constructor-impl((KClearUnreadReply) clearUnread);
        JobKt.ensureActive(iMClearUnreadService$clearUnread$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        if (Result.isSuccess-impl(obj)) {
        }
        return Result.constructor-impl(obj);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(1:24)|25|26))|35|6|7|8|15|16|(0)|19|(0)|22|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
        r6 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* renamed from: clearSessionUnread-0E7RQCE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3342clearSessionUnread0E7RQCE(KSessionPageType pageType, IMSessionCard session, Continuation<? super Result<Unit>> continuation) {
        IMClearUnreadService$clearSessionUnread$1 iMClearUnreadService$clearSessionUnread$1;
        Object obj;
        Throwable it;
        Object clearUnread;
        if (continuation instanceof IMClearUnreadService$clearSessionUnread$1) {
            iMClearUnreadService$clearSessionUnread$1 = (IMClearUnreadService$clearSessionUnread$1) continuation;
            if ((iMClearUnreadService$clearSessionUnread$1.label & Integer.MIN_VALUE) != 0) {
                iMClearUnreadService$clearSessionUnread$1.label -= Integer.MIN_VALUE;
                Object $result = iMClearUnreadService$clearSessionUnread$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMClearUnreadService$clearSessionUnread$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "开始清除单个会话未读数(ClearUnread): " + pageType + ", " + session);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KClearUnreadReq kClearUnreadReq = new KClearUnreadReq(pageType, session.getId());
                        iMClearUnreadService$clearSessionUnread$1.L$0 = pageType;
                        iMClearUnreadService$clearSessionUnread$1.L$1 = session;
                        iMClearUnreadService$clearSessionUnread$1.I$0 = 0;
                        iMClearUnreadService$clearSessionUnread$1.I$1 = 0;
                        iMClearUnreadService$clearSessionUnread$1.label = 1;
                        clearUnread = kimMoss.clearUnread(kClearUnreadReq, iMClearUnreadService$clearSessionUnread$1);
                        if (clearUnread != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMClearUnreadService$clearSessionUnread$1.I$1;
                        int i3 = iMClearUnreadService$clearSessionUnread$1.I$0;
                        session = (IMSessionCard) iMClearUnreadService$clearSessionUnread$1.L$1;
                        pageType = (KSessionPageType) iMClearUnreadService$clearSessionUnread$1.L$0;
                        ResultKt.throwOnFailure($result);
                        clearUnread = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KClearUnreadReply) clearUnread);
                JobKt.ensureActive(iMClearUnreadService$clearSessionUnread$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    KClearUnreadReply kClearUnreadReply = (KClearUnreadReply) obj;
                    IMLog.Companion.i(LogTagKt.SessionLogTag, "清除单个会话未读数(ClearUnread)成功: " + pageType + ", " + session);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.SessionLogTag, "清除单个会话未读数(ClearUnread)失败: " + pageType + ", " + session, it);
                }
                if (Result.isSuccess-impl(obj)) {
                    Result.Companion companion2 = Result.Companion;
                    KClearUnreadReply kClearUnreadReply2 = (KClearUnreadReply) obj;
                    obj = Unit.INSTANCE;
                }
                return Result.constructor-impl(obj);
            }
        }
        iMClearUnreadService$clearSessionUnread$1 = new IMClearUnreadService$clearSessionUnread$1(this, continuation);
        Object $result2 = iMClearUnreadService$clearSessionUnread$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMClearUnreadService$clearSessionUnread$1.label) {
        }
        obj = Result.constructor-impl((KClearUnreadReply) clearUnread);
        JobKt.ensureActive(iMClearUnreadService$clearSessionUnread$1.getContext());
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