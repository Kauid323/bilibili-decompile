package im.session.service;

import com.bapis.bilibili.app.im.v1.KCancelInterceptInDustbinReply;
import com.bapis.bilibili.app.im.v1.KCancelInterceptInDustbinReq;
import com.bapis.bilibili.app.im.v1.KDeleteSessionReply;
import com.bapis.bilibili.app.im.v1.KDeleteSessionReq;
import com.bapis.bilibili.app.im.v1.KPinSessionReply;
import com.bapis.bilibili.app.im.v1.KPinSessionReq;
import com.bapis.bilibili.app.im.v1.KUnPinSessionReply;
import com.bapis.bilibili.app.im.v1.KUnPinSessionReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.base.IMLog;
import im.base.IMMossBusinessException;
import im.session.log.LogTagKt;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: IMSessionCardEventService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0004\b\r\u0010\nJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u000f\u0010\nJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u0011\u0010\nJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lim/session/service/IMSessionCardEventService;", "", "<init>", "()V", "delete", "Lkotlin/Result;", "", "session", "Lim/session/model/IMSessionCard;", "delete-gIAlu-s", "(Lim/session/model/IMSessionCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pinOrNot", "Lim/session/service/PinResult;", "pinOrNot-gIAlu-s", "pin", "pin-gIAlu-s", "unpin", "unpin-gIAlu-s", "unblock", "unblock-gIAlu-s", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionCardEventService {
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(1:24)|25|26))|35|6|7|8|15|16|(0)|19|(0)|22|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fc  */
    /* renamed from: delete-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3352deletegIAlus(IMSessionCard session, Continuation<? super Result<Unit>> continuation) {
        IMSessionCardEventService$delete$1 iMSessionCardEventService$delete$1;
        Object obj;
        Throwable it;
        Object deleteSession;
        if (continuation instanceof IMSessionCardEventService$delete$1) {
            iMSessionCardEventService$delete$1 = (IMSessionCardEventService$delete$1) continuation;
            if ((iMSessionCardEventService$delete$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionCardEventService$delete$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionCardEventService$delete$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionCardEventService$delete$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "开始删除单个会话(DeleteSession) " + IMSessionCardKt.getStringId(session.getId()));
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KDeleteSessionReq kDeleteSessionReq = new KDeleteSessionReq(session.getId());
                        iMSessionCardEventService$delete$1.L$0 = session;
                        iMSessionCardEventService$delete$1.I$0 = 0;
                        iMSessionCardEventService$delete$1.I$1 = 0;
                        iMSessionCardEventService$delete$1.label = 1;
                        deleteSession = kimMoss.deleteSession(kDeleteSessionReq, iMSessionCardEventService$delete$1);
                        if (deleteSession != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSessionCardEventService$delete$1.I$1;
                        int i3 = iMSessionCardEventService$delete$1.I$0;
                        session = (IMSessionCard) iMSessionCardEventService$delete$1.L$0;
                        ResultKt.throwOnFailure($result);
                        deleteSession = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KDeleteSessionReply) deleteSession);
                JobKt.ensureActive(iMSessionCardEventService$delete$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    KDeleteSessionReply kDeleteSessionReply = (KDeleteSessionReply) obj;
                    IMLog.Companion.i(LogTagKt.SessionLogTag, "删除单个会话(DeleteSession)成功 " + IMSessionCardKt.getStringId(session.getId()));
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.SessionLogTag, "删除单个会话(DeleteSession)失败 " + IMSessionCardKt.getStringId(session.getId()), it);
                }
                if (Result.isSuccess-impl(obj)) {
                    Result.Companion companion2 = Result.Companion;
                    KDeleteSessionReply kDeleteSessionReply2 = (KDeleteSessionReply) obj;
                    obj = Unit.INSTANCE;
                }
                return Result.constructor-impl(obj);
            }
        }
        iMSessionCardEventService$delete$1 = new IMSessionCardEventService$delete$1(this, continuation);
        Object $result2 = iMSessionCardEventService$delete$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionCardEventService$delete$1.label) {
        }
        obj = Result.constructor-impl((KDeleteSessionReply) deleteSession);
        JobKt.ensureActive(iMSessionCardEventService$delete$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        if (Result.isSuccess-impl(obj)) {
        }
        return Result.constructor-impl(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* renamed from: pinOrNot-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3353pinOrNotgIAlus(IMSessionCard session, Continuation<? super Result<PinResult>> continuation) {
        IMSessionCardEventService$pinOrNot$1 iMSessionCardEventService$pinOrNot$1;
        if (continuation instanceof IMSessionCardEventService$pinOrNot$1) {
            iMSessionCardEventService$pinOrNot$1 = (IMSessionCardEventService$pinOrNot$1) continuation;
            if ((iMSessionCardEventService$pinOrNot$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionCardEventService$pinOrNot$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionCardEventService$pinOrNot$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionCardEventService$pinOrNot$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (session.isPinned()) {
                            iMSessionCardEventService$pinOrNot$1.L$0 = SpillingKt.nullOutSpilledVariable(session);
                            iMSessionCardEventService$pinOrNot$1.label = 1;
                            Object m3351unpingIAlus = m3351unpingIAlus(session, iMSessionCardEventService$pinOrNot$1);
                            if (m3351unpingIAlus == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return m3351unpingIAlus;
                        }
                        iMSessionCardEventService$pinOrNot$1.L$0 = SpillingKt.nullOutSpilledVariable(session);
                        iMSessionCardEventService$pinOrNot$1.label = 2;
                        Object m3350pingIAlus = m3350pingIAlus(session, iMSessionCardEventService$pinOrNot$1);
                        if (m3350pingIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return m3350pingIAlus;
                    case 1:
                        IMSessionCard iMSessionCard = (IMSessionCard) iMSessionCardEventService$pinOrNot$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    case 2:
                        IMSessionCard iMSessionCard2 = (IMSessionCard) iMSessionCardEventService$pinOrNot$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionCardEventService$pinOrNot$1 = new IMSessionCardEventService$pinOrNot$1(this, continuation);
        Object $result2 = iMSessionCardEventService$pinOrNot$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionCardEventService$pinOrNot$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:13:0x0044, B:24:0x00a4, B:26:0x00b0, B:27:0x00bf, B:28:0x00cc), top: B:41:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:13:0x0044, B:24:0x00a4, B:26:0x00b0, B:27:0x00bf, B:28:0x00cc), top: B:41:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* renamed from: pin-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3350pingIAlus(IMSessionCard session, Continuation<? super Result<PinResult>> continuation) {
        IMSessionCardEventService$pin$1 iMSessionCardEventService$pin$1;
        IMSessionCardEventService$pin$1 iMSessionCardEventService$pin$12;
        IMSessionCard session2;
        Object pinSession;
        IMSessionCard session3;
        Object obj;
        Throwable it;
        KPinSessionReply response;
        if (continuation instanceof IMSessionCardEventService$pin$1) {
            iMSessionCardEventService$pin$1 = (IMSessionCardEventService$pin$1) continuation;
            if ((iMSessionCardEventService$pin$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionCardEventService$pin$1.label -= Integer.MIN_VALUE;
                iMSessionCardEventService$pin$12 = iMSessionCardEventService$pin$1;
                Object $result = iMSessionCardEventService$pin$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionCardEventService$pin$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "开始置顶会话(PinSession) " + IMSessionCardKt.getStringId(session.getId()));
                        try {
                            Result.Companion companion = Result.Companion;
                            KPinSessionReq req = new KPinSessionReq(session.getId(), 0L, 2, (DefaultConstructorMarker) null);
                            KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            session2 = session;
                            try {
                                iMSessionCardEventService$pin$12.L$0 = session2;
                                iMSessionCardEventService$pin$12.L$1 = SpillingKt.nullOutSpilledVariable(req);
                                iMSessionCardEventService$pin$12.I$0 = 0;
                                iMSessionCardEventService$pin$12.I$1 = 0;
                                iMSessionCardEventService$pin$12.label = 1;
                                pinSession = kimMoss.pinSession(req, iMSessionCardEventService$pin$12);
                                if (pinSession != coroutine_suspended) {
                                    session3 = session2;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                session3 = session2;
                                JobKt.ensureActive(iMSessionCardEventService$pin$12.getContext());
                                if (Result.isSuccess-impl(obj)) {
                                }
                                it = Result.exceptionOrNull-impl(obj);
                                if (it != null) {
                                }
                                return obj;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            session2 = session;
                        }
                        break;
                    case 1:
                        int i2 = iMSessionCardEventService$pin$12.I$1;
                        int i3 = iMSessionCardEventService$pin$12.I$0;
                        KPinSessionReq kPinSessionReq = (KPinSessionReq) iMSessionCardEventService$pin$12.L$1;
                        session3 = (IMSessionCard) iMSessionCardEventService$pin$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            pinSession = $result;
                            break;
                        } catch (Throwable th3) {
                            th = th3;
                            session2 = session3;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            session3 = session2;
                            JobKt.ensureActive(iMSessionCardEventService$pin$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                response = (KPinSessionReply) pinSession;
                if (response.getCode() != 0) {
                    obj = Result.constructor-impl(new PinResult(true, response.getSequenceNumber()));
                    JobKt.ensureActive(iMSessionCardEventService$pin$12.getContext());
                    if (Result.isSuccess-impl(obj)) {
                        PinResult pinResult = (PinResult) obj;
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "置顶会话(PinSession)成功: " + IMSessionCardKt.getStringId(session3.getId()));
                    }
                    it = Result.exceptionOrNull-impl(obj);
                    if (it != null) {
                        IMLog.Companion.e(LogTagKt.SessionLogTag, "置顶会话(PinSession)失败: " + IMSessionCardKt.getStringId(session3.getId()), it);
                    }
                    return obj;
                }
                throw new IMMossBusinessException(response.getCode(), response.getMessage());
            }
        }
        iMSessionCardEventService$pin$1 = new IMSessionCardEventService$pin$1(this, continuation);
        iMSessionCardEventService$pin$12 = iMSessionCardEventService$pin$1;
        Object $result2 = iMSessionCardEventService$pin$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionCardEventService$pin$12.label) {
        }
        response = (KPinSessionReply) pinSession;
        if (response.getCode() != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e8  */
    /* renamed from: unpin-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3351unpingIAlus(IMSessionCard session, Continuation<? super Result<PinResult>> continuation) {
        IMSessionCardEventService$unpin$1 iMSessionCardEventService$unpin$1;
        Object obj;
        Throwable it;
        Object unpinSession;
        if (continuation instanceof IMSessionCardEventService$unpin$1) {
            iMSessionCardEventService$unpin$1 = (IMSessionCardEventService$unpin$1) continuation;
            if ((iMSessionCardEventService$unpin$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionCardEventService$unpin$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionCardEventService$unpin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionCardEventService$unpin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "开始取消置顶会话(UnpinSession) " + IMSessionCardKt.getStringId(session.getId()));
                        Result.Companion companion = Result.Companion;
                        KUnPinSessionReq req = new KUnPinSessionReq(session.getId());
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        iMSessionCardEventService$unpin$1.L$0 = session;
                        iMSessionCardEventService$unpin$1.L$1 = SpillingKt.nullOutSpilledVariable(req);
                        iMSessionCardEventService$unpin$1.I$0 = 0;
                        iMSessionCardEventService$unpin$1.I$1 = 0;
                        iMSessionCardEventService$unpin$1.label = 1;
                        unpinSession = kimMoss.unpinSession(req, iMSessionCardEventService$unpin$1);
                        if (unpinSession != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSessionCardEventService$unpin$1.I$1;
                        int i3 = iMSessionCardEventService$unpin$1.I$0;
                        KUnPinSessionReq kUnPinSessionReq = (KUnPinSessionReq) iMSessionCardEventService$unpin$1.L$1;
                        session = (IMSessionCard) iMSessionCardEventService$unpin$1.L$0;
                        ResultKt.throwOnFailure($result);
                        unpinSession = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                KUnPinSessionReply response = (KUnPinSessionReply) unpinSession;
                obj = Result.constructor-impl(new PinResult(false, response.getSequenceNumber()));
                JobKt.ensureActive(iMSessionCardEventService$unpin$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    PinResult pinResult = (PinResult) obj;
                    IMLog.Companion.i(LogTagKt.SessionLogTag, "取消置顶会话(UnpinSession)成功: " + IMSessionCardKt.getStringId(session.getId()));
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.SessionLogTag, "取消置顶会话(UnpinSession)失败: " + IMSessionCardKt.getStringId(session.getId()), it);
                }
                return obj;
            }
        }
        iMSessionCardEventService$unpin$1 = new IMSessionCardEventService$unpin$1(this, continuation);
        Object $result2 = iMSessionCardEventService$unpin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionCardEventService$unpin$1.label) {
        }
        KUnPinSessionReply response2 = (KUnPinSessionReply) unpinSession;
        obj = Result.constructor-impl(new PinResult(false, response2.getSequenceNumber()));
        JobKt.ensureActive(iMSessionCardEventService$unpin$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(1:24)|25|26))|35|6|7|8|15|16|(0)|19|(0)|22|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fc  */
    /* renamed from: unblock-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3354unblockgIAlus(IMSessionCard session, Continuation<? super Result<Unit>> continuation) {
        IMSessionCardEventService$unblock$1 iMSessionCardEventService$unblock$1;
        Object obj;
        Throwable it;
        Object cancelInterceptInDustbin;
        if (continuation instanceof IMSessionCardEventService$unblock$1) {
            iMSessionCardEventService$unblock$1 = (IMSessionCardEventService$unblock$1) continuation;
            if ((iMSessionCardEventService$unblock$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionCardEventService$unblock$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionCardEventService$unblock$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionCardEventService$unblock$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.SessionLogTag, "开始取消拦截会话(CancelInterceptInDustbin) " + IMSessionCardKt.getStringId(session.getId()));
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KCancelInterceptInDustbinReq kCancelInterceptInDustbinReq = new KCancelInterceptInDustbinReq(session.getId());
                        iMSessionCardEventService$unblock$1.L$0 = session;
                        iMSessionCardEventService$unblock$1.I$0 = 0;
                        iMSessionCardEventService$unblock$1.I$1 = 0;
                        iMSessionCardEventService$unblock$1.label = 1;
                        cancelInterceptInDustbin = kimMoss.cancelInterceptInDustbin(kCancelInterceptInDustbinReq, iMSessionCardEventService$unblock$1);
                        if (cancelInterceptInDustbin != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSessionCardEventService$unblock$1.I$1;
                        int i3 = iMSessionCardEventService$unblock$1.I$0;
                        session = (IMSessionCard) iMSessionCardEventService$unblock$1.L$0;
                        ResultKt.throwOnFailure($result);
                        cancelInterceptInDustbin = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KCancelInterceptInDustbinReply) cancelInterceptInDustbin);
                JobKt.ensureActive(iMSessionCardEventService$unblock$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    KCancelInterceptInDustbinReply kCancelInterceptInDustbinReply = (KCancelInterceptInDustbinReply) obj;
                    IMLog.Companion.i(LogTagKt.SessionLogTag, "取消拦截会话(CancelInterceptInDustbin)成功: " + IMSessionCardKt.getStringId(session.getId()));
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.SessionLogTag, "取消拦截会话(CancelInterceptInDustbin)失败: " + IMSessionCardKt.getStringId(session.getId()), it);
                }
                if (Result.isSuccess-impl(obj)) {
                    Result.Companion companion2 = Result.Companion;
                    KCancelInterceptInDustbinReply kCancelInterceptInDustbinReply2 = (KCancelInterceptInDustbinReply) obj;
                    obj = Unit.INSTANCE;
                }
                return Result.constructor-impl(obj);
            }
        }
        iMSessionCardEventService$unblock$1 = new IMSessionCardEventService$unblock$1(this, continuation);
        Object $result2 = iMSessionCardEventService$unblock$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionCardEventService$unblock$1.label) {
        }
        obj = Result.constructor-impl((KCancelInterceptInDustbinReply) cancelInterceptInDustbin);
        JobKt.ensureActive(iMSessionCardEventService$unblock$1.getContext());
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