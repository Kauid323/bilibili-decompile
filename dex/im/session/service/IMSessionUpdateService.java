package im.session.service;

import com.bapis.bilibili.app.im.v1.KRestrictedMode;
import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionListUpdateReq;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bapis.bilibili.app.im.v1.KSessionUpdateReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.base.IMLog;
import im.session.IMSessionStateMachineKt;
import im.session.log.LogTagKt;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionPartialPage;
import javax.inject.Inject;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
import kntr.base.moss.api.KMossResponseHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: IMSessionUpdateService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lim/session/service/IMSessionUpdateService;", "", "summaryService", "Lim/session/service/IMSummaryCacheService;", "<init>", "(Lim/session/service/IMSummaryCacheService;)V", "update", "Lkotlin/Result;", "Lim/session/model/IMSessionPartialPage;", "param", "Lim/session/service/IMSessionUpdateParam;", "update-gIAlu-s", "(Lim/session/service/IMSessionUpdateParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lim/session/model/IMSessionCard;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "filterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "update-BWLJW6A", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionUpdateService {
    private final IMSummaryCacheService summaryService;

    @Inject
    public IMSessionUpdateService(IMSummaryCacheService summaryService) {
        Intrinsics.checkNotNullParameter(summaryService, "summaryService");
        this.summaryService = summaryService;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|34|35|(1:37)(8:38|15|16|17|(0)|20|(0)|23)))|68|6|7|34|35|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x019f, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f7  */
    /* renamed from: update-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3367updategIAlus(IMSessionUpdateParam param, Continuation<? super Result<IMSessionPartialPage>> continuation) {
        IMSessionUpdateService$update$1 iMSessionUpdateService$update$1;
        IMSessionUpdateService$update$1 iMSessionUpdateService$update$12;
        Object coroutine_suspended;
        IMSessionUpdateParam param2;
        Object result;
        int $i$f$sessionListUpdate;
        int $i$f$runSuspendCatching;
        KSessionListUpdateReq req;
        Object collectFirstSummary;
        Object obj;
        Throwable t;
        if (continuation instanceof IMSessionUpdateService$update$1) {
            iMSessionUpdateService$update$1 = (IMSessionUpdateService$update$1) continuation;
            if ((iMSessionUpdateService$update$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionUpdateService$update$1.label -= Integer.MIN_VALUE;
                iMSessionUpdateService$update$12 = iMSessionUpdateService$update$1;
                Object $result = iMSessionUpdateService$update$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionUpdateService$update$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.getUpdateLogTag(), "开始更新会话列表(SessionListUpdate) " + param);
                        try {
                            Result.Companion companion = Result.Companion;
                            KSessionListUpdateReq req2 = new KSessionListUpdateReq(IMSessionStateMachineKt.imMode(KRestrictedMode.Companion), param.getUpdateSessionParams(), param.getPageType(), param.getFilterType());
                            KimMoss $this$iv = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            SerializationStrategy reqSerializer$iv = KSessionListUpdateReq.Companion.serializer();
                            DeserializationStrategy respSerializer$iv = IMSessionPartialPage.Companion.serializer();
                            iMSessionUpdateService$update$12.L$0 = param;
                            iMSessionUpdateService$update$12.L$1 = SpillingKt.nullOutSpilledVariable(req2);
                            iMSessionUpdateService$update$12.L$2 = $this$iv;
                            iMSessionUpdateService$update$12.L$3 = req2;
                            iMSessionUpdateService$update$12.L$4 = iMSessionUpdateService$update$12;
                            iMSessionUpdateService$update$12.L$5 = reqSerializer$iv;
                            iMSessionUpdateService$update$12.L$6 = respSerializer$iv;
                            iMSessionUpdateService$update$12.I$0 = 0;
                            iMSessionUpdateService$update$12.I$1 = 0;
                            iMSessionUpdateService$update$12.I$2 = 0;
                            iMSessionUpdateService$update$12.I$3 = 0;
                            iMSessionUpdateService$update$12.I$4 = 0;
                            iMSessionUpdateService$update$12.label = 1;
                            Continuation uCont$iv$iv$iv = (Continuation) iMSessionUpdateService$update$12;
                            try {
                                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv$iv), 1);
                                cancellableContinuationImpl.initCancellability();
                                final CancellableContinuation it$iv$iv = cancellableContinuationImpl;
                                KMossResponseHandler p3$iv = new KMossResponseHandler<IMSessionPartialPage>() { // from class: im.session.service.IMSessionUpdateService$update_gIAlu_s$lambda$0$$inlined$sessionListUpdate$default$1
                                    private IMSessionPartialPage resp;

                                    public void onNext(IMSessionPartialPage iMSessionPartialPage) {
                                        this.resp = iMSessionPartialPage;
                                    }

                                    public void onCompleted() {
                                        if (it$iv$iv.isActive()) {
                                            Object result2 = this.resp;
                                            if (result2 != null) {
                                                Result.Companion companion2 = Result.Companion;
                                                it$iv$iv.resumeWith(Result.constructor-impl(result2));
                                                return;
                                            }
                                            Result.Companion companion3 = Result.Companion;
                                            it$iv$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(new KMossException("Unlikely null response without exception", (Throwable) null))));
                                        }
                                    }

                                    public void onError(KMossException t2) {
                                        KMossException kMossException;
                                        if (it$iv$iv.isActive()) {
                                            Continuation continuation2 = it$iv$iv;
                                            Result.Companion companion2 = Result.Companion;
                                            if (t2 != null) {
                                                kMossException = t2;
                                            } else {
                                                kMossException = new KMossException("Unknown exception in kmoss coroutine", (Throwable) null);
                                            }
                                            continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable) kMossException)));
                                        }
                                    }
                                };
                                try {
                                    $this$iv.sessionListUpdate(req2, reqSerializer$iv, respSerializer$iv, p3$iv);
                                    result = cancellableContinuationImpl.getResult();
                                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        DebugProbesKt.probeCoroutineSuspended((Continuation) iMSessionUpdateService$update$12);
                                    }
                                    if (result != coroutine_suspended) {
                                        param2 = param;
                                        $i$f$sessionListUpdate = 0;
                                        $i$f$runSuspendCatching = 0;
                                        req = req2;
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    param2 = param;
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    JobKt.ensureActive(iMSessionUpdateService$update$12.getContext());
                                    if (Result.isSuccess-impl(obj)) {
                                    }
                                    t = Result.exceptionOrNull-impl(obj);
                                    if (t != null) {
                                    }
                                    return obj;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                param2 = param;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            param2 = param;
                        }
                        break;
                    case 1:
                        int $i$f$runSuspendCatching2 = iMSessionUpdateService$update$12.I$4;
                        int i2 = iMSessionUpdateService$update$12.I$3;
                        int i3 = iMSessionUpdateService$update$12.I$2;
                        $i$f$sessionListUpdate = iMSessionUpdateService$update$12.I$1;
                        $i$f$runSuspendCatching = iMSessionUpdateService$update$12.I$0;
                        DeserializationStrategy deserializationStrategy = (DeserializationStrategy) iMSessionUpdateService$update$12.L$6;
                        SerializationStrategy serializationStrategy = (SerializationStrategy) iMSessionUpdateService$update$12.L$5;
                        IMSessionUpdateService$update$1 iMSessionUpdateService$update$13 = (IMSessionUpdateService$update$1) iMSessionUpdateService$update$12.L$4;
                        KSessionListUpdateReq kSessionListUpdateReq = (KSessionListUpdateReq) iMSessionUpdateService$update$12.L$3;
                        KimMoss kimMoss = (KimMoss) iMSessionUpdateService$update$12.L$2;
                        req = (KSessionListUpdateReq) iMSessionUpdateService$update$12.L$1;
                        param2 = (IMSessionUpdateParam) iMSessionUpdateService$update$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            result = $result;
                            break;
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(iMSessionUpdateService$update$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            t = Result.exceptionOrNull-impl(obj);
                            if (t != null) {
                            }
                            return obj;
                        }
                        break;
                    case 2:
                        int i4 = iMSessionUpdateService$update$12.I$1;
                        int i5 = iMSessionUpdateService$update$12.I$0;
                        IMSessionPartialPage iMSessionPartialPage = (IMSessionPartialPage) iMSessionUpdateService$update$12.L$2;
                        KSessionListUpdateReq kSessionListUpdateReq2 = (KSessionListUpdateReq) iMSessionUpdateService$update$12.L$1;
                        param2 = (IMSessionUpdateParam) iMSessionUpdateService$update$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            collectFirstSummary = $result;
                        } catch (Throwable th5) {
                            th = th5;
                            Result.Companion companion222 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(iMSessionUpdateService$update$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            t = Result.exceptionOrNull-impl(obj);
                            if (t != null) {
                            }
                            return obj;
                        }
                        try {
                            obj = Result.constructor-impl((IMSessionPartialPage) collectFirstSummary);
                        } catch (Throwable th6) {
                            th = th6;
                            Result.Companion companion2222 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(iMSessionUpdateService$update$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            t = Result.exceptionOrNull-impl(obj);
                            if (t != null) {
                            }
                            return obj;
                        }
                        JobKt.ensureActive(iMSessionUpdateService$update$12.getContext());
                        if (Result.isSuccess-impl(obj)) {
                            IMSessionPartialPage iMSessionPartialPage2 = (IMSessionPartialPage) obj;
                            IMLog.Companion.i(LogTagKt.getUpdateLogTag(), "更新会话列表(SessionListUpdate)成功 " + param2);
                        }
                        t = Result.exceptionOrNull-impl(obj);
                        if (t != null) {
                            IMLog.Companion.e(LogTagKt.getUpdateLogTag(), "更新会话列表(SessionListUpdate)失败 " + param2, t);
                        }
                        return obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                IMSessionPartialPage resp = (IMSessionPartialPage) result;
                IMSummaryCacheService iMSummaryCacheService = this.summaryService;
                iMSessionUpdateService$update$12.L$0 = param2;
                iMSessionUpdateService$update$12.L$1 = SpillingKt.nullOutSpilledVariable(req);
                iMSessionUpdateService$update$12.L$2 = SpillingKt.nullOutSpilledVariable(resp);
                iMSessionUpdateService$update$12.L$3 = null;
                iMSessionUpdateService$update$12.L$4 = null;
                iMSessionUpdateService$update$12.L$5 = null;
                iMSessionUpdateService$update$12.L$6 = null;
                iMSessionUpdateService$update$12.I$0 = $i$f$runSuspendCatching;
                iMSessionUpdateService$update$12.I$1 = $i$f$sessionListUpdate;
                iMSessionUpdateService$update$12.label = 2;
                collectFirstSummary = IMMessageSummaryServiceKt.collectFirstSummary(iMSummaryCacheService, resp, (Continuation<? super IMSessionPartialPage>) iMSessionUpdateService$update$12);
                if (collectFirstSummary != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = Result.constructor-impl((IMSessionPartialPage) collectFirstSummary);
                JobKt.ensureActive(iMSessionUpdateService$update$12.getContext());
                if (Result.isSuccess-impl(obj)) {
                }
                t = Result.exceptionOrNull-impl(obj);
                if (t != null) {
                }
                return obj;
            }
        }
        iMSessionUpdateService$update$1 = new IMSessionUpdateService$update$1(this, continuation);
        iMSessionUpdateService$update$12 = iMSessionUpdateService$update$1;
        Object $result2 = iMSessionUpdateService$update$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionUpdateService$update$12.label) {
        }
        IMSessionPartialPage resp2 = (IMSessionPartialPage) result;
        IMSummaryCacheService iMSummaryCacheService2 = this.summaryService;
        iMSessionUpdateService$update$12.L$0 = param2;
        iMSessionUpdateService$update$12.L$1 = SpillingKt.nullOutSpilledVariable(req);
        iMSessionUpdateService$update$12.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
        iMSessionUpdateService$update$12.L$3 = null;
        iMSessionUpdateService$update$12.L$4 = null;
        iMSessionUpdateService$update$12.L$5 = null;
        iMSessionUpdateService$update$12.L$6 = null;
        iMSessionUpdateService$update$12.I$0 = $i$f$runSuspendCatching;
        iMSessionUpdateService$update$12.I$1 = $i$f$sessionListUpdate;
        iMSessionUpdateService$update$12.label = 2;
        collectFirstSummary = IMMessageSummaryServiceKt.collectFirstSummary(iMSummaryCacheService2, resp2, (Continuation<? super IMSessionPartialPage>) iMSessionUpdateService$update$12);
        if (collectFirstSummary != coroutine_suspended) {
        }
    }

    /* renamed from: update-BWLJW6A$default  reason: not valid java name */
    public static /* synthetic */ Object m3365updateBWLJW6A$default(IMSessionUpdateService iMSessionUpdateService, KSessionId kSessionId, KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            kSessionFilterType = (KSessionFilterType) KSessionFilterType.FILTER_DEFAULT.INSTANCE;
        }
        return iMSessionUpdateService.m3366updateBWLJW6A(kSessionId, kSessionPageType, kSessionFilterType, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: update-BWLJW6A  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3366updateBWLJW6A(KSessionId sessionId, KSessionPageType pageType, KSessionFilterType filterType, Continuation<? super Result<IMSessionCard>> continuation) {
        IMSessionUpdateService$update$5 iMSessionUpdateService$update$5;
        IMSessionUpdateService$update$5 iMSessionUpdateService$update$52;
        KSessionId sessionId2;
        KSessionPageType pageType2;
        Object result;
        IMSessionCard iMSessionCard;
        KBusinessException kBusinessException;
        Throwable t;
        if (continuation instanceof IMSessionUpdateService$update$5) {
            iMSessionUpdateService$update$5 = (IMSessionUpdateService$update$5) continuation;
            if ((iMSessionUpdateService$update$5.label & Integer.MIN_VALUE) != 0) {
                iMSessionUpdateService$update$5.label -= Integer.MIN_VALUE;
                iMSessionUpdateService$update$52 = iMSessionUpdateService$update$5;
                Object $result = iMSessionUpdateService$update$52.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionUpdateService$update$52.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.getUpdateLogTag(), "开始更新单个会话(SessionUpdate): " + sessionId + ", pageType: " + pageType);
                        try {
                            Result.Companion companion = Result.Companion;
                            KimMoss $this$iv = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            try {
                                Object request$iv = new KSessionUpdateReq(sessionId, pageType, filterType);
                                SerializationStrategy reqSerializer$iv = KSessionUpdateReq.Companion.serializer();
                                DeserializationStrategy respSerializer$iv = IMSessionUpdateResult.Companion.serializer();
                                iMSessionUpdateService$update$52.L$0 = sessionId;
                                iMSessionUpdateService$update$52.L$1 = pageType;
                                iMSessionUpdateService$update$52.L$2 = SpillingKt.nullOutSpilledVariable(filterType);
                                iMSessionUpdateService$update$52.L$3 = $this$iv;
                                iMSessionUpdateService$update$52.L$4 = request$iv;
                                iMSessionUpdateService$update$52.L$5 = iMSessionUpdateService$update$52;
                                iMSessionUpdateService$update$52.L$6 = reqSerializer$iv;
                                iMSessionUpdateService$update$52.L$7 = respSerializer$iv;
                                iMSessionUpdateService$update$52.I$0 = 0;
                                iMSessionUpdateService$update$52.I$1 = 0;
                                iMSessionUpdateService$update$52.I$2 = 0;
                                iMSessionUpdateService$update$52.I$3 = 0;
                                iMSessionUpdateService$update$52.I$4 = 0;
                                iMSessionUpdateService$update$52.label = 1;
                                Continuation uCont$iv$iv$iv = (Continuation) iMSessionUpdateService$update$52;
                                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv$iv), 1);
                                cancellableContinuationImpl.initCancellability();
                                final CancellableContinuation it$iv$iv = cancellableContinuationImpl;
                                KMossResponseHandler p3$iv = new KMossResponseHandler<IMSessionUpdateResult>() { // from class: im.session.service.IMSessionUpdateService$update_BWLJW6A$lambda$0$$inlined$sessionUpdate$default$1
                                    private IMSessionUpdateResult resp;

                                    public void onNext(IMSessionUpdateResult iMSessionUpdateResult) {
                                        this.resp = iMSessionUpdateResult;
                                    }

                                    public void onCompleted() {
                                        if (it$iv$iv.isActive()) {
                                            Object result2 = this.resp;
                                            if (result2 != null) {
                                                Result.Companion companion2 = Result.Companion;
                                                it$iv$iv.resumeWith(Result.constructor-impl(result2));
                                                return;
                                            }
                                            Result.Companion companion3 = Result.Companion;
                                            it$iv$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(new KMossException("Unlikely null response without exception", (Throwable) null))));
                                        }
                                    }

                                    public void onError(KMossException t2) {
                                        KMossException kMossException;
                                        if (it$iv$iv.isActive()) {
                                            Continuation continuation2 = it$iv$iv;
                                            Result.Companion companion2 = Result.Companion;
                                            if (t2 != null) {
                                                kMossException = t2;
                                            } else {
                                                kMossException = new KMossException("Unknown exception in kmoss coroutine", (Throwable) null);
                                            }
                                            continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable) kMossException)));
                                        }
                                    }
                                };
                                try {
                                    $this$iv.sessionUpdate(request$iv, reqSerializer$iv, respSerializer$iv, p3$iv);
                                    result = cancellableContinuationImpl.getResult();
                                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        DebugProbesKt.probeCoroutineSuspended((Continuation) iMSessionUpdateService$update$52);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    sessionId2 = sessionId;
                                    pageType2 = pageType;
                                    Result.Companion companion2 = Result.Companion;
                                    iMSessionCard = Result.constructor-impl(ResultKt.createFailure(th));
                                    JobKt.ensureActive(iMSessionUpdateService$update$52.getContext());
                                    kBusinessException = Result.exceptionOrNull-impl(iMSessionCard);
                                    if (kBusinessException != null) {
                                    }
                                    if (Result.isSuccess-impl(iMSessionCard)) {
                                    }
                                    t = Result.exceptionOrNull-impl(iMSessionCard);
                                    if (t != null) {
                                    }
                                    if (Result.isSuccess-impl(iMSessionCard)) {
                                    }
                                    return Result.constructor-impl(iMSessionCard);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                sessionId2 = sessionId;
                                pageType2 = pageType;
                                Result.Companion companion22 = Result.Companion;
                                iMSessionCard = Result.constructor-impl(ResultKt.createFailure(th));
                                JobKt.ensureActive(iMSessionUpdateService$update$52.getContext());
                                kBusinessException = Result.exceptionOrNull-impl(iMSessionCard);
                                if (kBusinessException != null) {
                                }
                                if (Result.isSuccess-impl(iMSessionCard)) {
                                }
                                t = Result.exceptionOrNull-impl(iMSessionCard);
                                if (t != null) {
                                }
                                if (Result.isSuccess-impl(iMSessionCard)) {
                                }
                                return Result.constructor-impl(iMSessionCard);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pageType2 = pageType;
                        $result = result;
                        sessionId2 = sessionId;
                        try {
                            iMSessionCard = Result.constructor-impl((IMSessionUpdateResult) $result);
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion222 = Result.Companion;
                            iMSessionCard = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(iMSessionUpdateService$update$52.getContext());
                            kBusinessException = Result.exceptionOrNull-impl(iMSessionCard);
                            if (kBusinessException != null) {
                            }
                            if (Result.isSuccess-impl(iMSessionCard)) {
                            }
                            t = Result.exceptionOrNull-impl(iMSessionCard);
                            if (t != null) {
                            }
                            if (Result.isSuccess-impl(iMSessionCard)) {
                            }
                            return Result.constructor-impl(iMSessionCard);
                        }
                        JobKt.ensureActive(iMSessionUpdateService$update$52.getContext());
                        kBusinessException = Result.exceptionOrNull-impl(iMSessionCard);
                        if (kBusinessException != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                if ((kBusinessException instanceof KBusinessException) && kBusinessException.getCode() == 1217) {
                                    throw new SessionRemovedFromTypeException(sessionId2, pageType2, (Exception) kBusinessException);
                                }
                                throw kBusinessException;
                            } catch (Throwable it) {
                                Result.Companion companion4 = Result.Companion;
                                iMSessionCard = Result.constructor-impl(ResultKt.createFailure(it));
                            }
                        }
                        if (Result.isSuccess-impl(iMSessionCard)) {
                            IMSessionUpdateResult iMSessionUpdateResult = (IMSessionUpdateResult) iMSessionCard;
                            IMLog.Companion.i(LogTagKt.getUpdateLogTag(), "更新单个会话(SessionUpdate)成功: " + sessionId2 + ", pageType: " + pageType2);
                        }
                        t = Result.exceptionOrNull-impl(iMSessionCard);
                        if (t != null) {
                            IMLog.Companion.e(LogTagKt.getUpdateLogTag(), "更新单个会话(SessionUpdate)失败: " + sessionId2 + ", pageType: " + pageType2, t);
                        }
                        if (Result.isSuccess-impl(iMSessionCard)) {
                            Result.Companion companion5 = Result.Companion;
                            IMSessionUpdateResult it2 = (IMSessionUpdateResult) iMSessionCard;
                            iMSessionCard = it2.getCard();
                        }
                        return Result.constructor-impl(iMSessionCard);
                    case 1:
                        int i2 = iMSessionUpdateService$update$52.I$4;
                        int i3 = iMSessionUpdateService$update$52.I$3;
                        int i4 = iMSessionUpdateService$update$52.I$2;
                        int i5 = iMSessionUpdateService$update$52.I$1;
                        int i6 = iMSessionUpdateService$update$52.I$0;
                        DeserializationStrategy deserializationStrategy = (DeserializationStrategy) iMSessionUpdateService$update$52.L$7;
                        SerializationStrategy serializationStrategy = (SerializationStrategy) iMSessionUpdateService$update$52.L$6;
                        IMSessionUpdateService$update$5 iMSessionUpdateService$update$53 = (IMSessionUpdateService$update$5) iMSessionUpdateService$update$52.L$5;
                        KSessionUpdateReq kSessionUpdateReq = (KSessionUpdateReq) iMSessionUpdateService$update$52.L$4;
                        KimMoss kimMoss = (KimMoss) iMSessionUpdateService$update$52.L$3;
                        KSessionFilterType kSessionFilterType = (KSessionFilterType) iMSessionUpdateService$update$52.L$2;
                        pageType2 = (KSessionPageType) iMSessionUpdateService$update$52.L$1;
                        sessionId2 = (KSessionId) iMSessionUpdateService$update$52.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            iMSessionCard = Result.constructor-impl((IMSessionUpdateResult) $result);
                        } catch (Throwable th5) {
                            th = th5;
                            Result.Companion companion2222 = Result.Companion;
                            iMSessionCard = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(iMSessionUpdateService$update$52.getContext());
                            kBusinessException = Result.exceptionOrNull-impl(iMSessionCard);
                            if (kBusinessException != null) {
                            }
                            if (Result.isSuccess-impl(iMSessionCard)) {
                            }
                            t = Result.exceptionOrNull-impl(iMSessionCard);
                            if (t != null) {
                            }
                            if (Result.isSuccess-impl(iMSessionCard)) {
                            }
                            return Result.constructor-impl(iMSessionCard);
                        }
                        JobKt.ensureActive(iMSessionUpdateService$update$52.getContext());
                        kBusinessException = Result.exceptionOrNull-impl(iMSessionCard);
                        if (kBusinessException != null) {
                        }
                        if (Result.isSuccess-impl(iMSessionCard)) {
                        }
                        t = Result.exceptionOrNull-impl(iMSessionCard);
                        if (t != null) {
                        }
                        if (Result.isSuccess-impl(iMSessionCard)) {
                        }
                        return Result.constructor-impl(iMSessionCard);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionUpdateService$update$5 = new IMSessionUpdateService$update$5(this, continuation);
        iMSessionUpdateService$update$52 = iMSessionUpdateService$update$5;
        Object $result2 = iMSessionUpdateService$update$52.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionUpdateService$update$52.label) {
        }
    }
}