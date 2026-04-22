package im.session.service.request;

import com.bapis.bilibili.app.im.v1.KRestrictedMode;
import com.bapis.bilibili.app.im.v1.KSessionSecondaryReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.session.IMSessionStateMachineKt;
import im.session.model.IMSessionPageData;
import im.session.model.IMSessionPageDataKt;
import im.session.model.serializer.IMSessionSecondaryPageDataSerializer;
import im.session.service.IMMessageSummaryServiceKt;
import im.session.service.IMSessionRequestParam;
import im.session.service.IMSessionRequestServiceLike;
import im.session.service.IMSummaryCacheService;
import javax.inject.Inject;
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
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: IMSessionSecondaryMossRequestService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lim/session/service/request/IMSessionSecondaryMossRequestService;", "Lim/session/service/IMSessionRequestServiceLike;", "summaryService", "Lim/session/service/IMSummaryCacheService;", "<init>", "(Lim/session/service/IMSummaryCacheService;)V", "load", "Lim/session/model/IMSessionPageData;", "param", "Lim/session/service/IMSessionRequestParam;", "(Lim/session/service/IMSessionRequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionSecondaryMossRequestService implements IMSessionRequestServiceLike {
    private final IMSummaryCacheService summaryService;

    @Inject
    public IMSessionSecondaryMossRequestService(IMSummaryCacheService summaryService) {
        Intrinsics.checkNotNullParameter(summaryService, "summaryService");
        this.summaryService = summaryService;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x015e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015f  */
    @Override // im.session.service.IMSessionRequestServiceLike
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(IMSessionRequestParam param, Continuation<? super IMSessionPageData> continuation) {
        Continuation $continuation;
        Object result;
        KSessionSecondaryReq req;
        IMSessionRequestParam param2;
        if (continuation instanceof IMSessionSecondaryMossRequestService$load$1) {
            $continuation = (IMSessionSecondaryMossRequestService$load$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KSessionSecondaryReq req2 = new KSessionSecondaryReq(IMSessionStateMachineKt.imMode(KRestrictedMode.Companion), param.getPaginationParams(), param.getPageType());
                        KimMoss $this$iv = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        DeserializationStrategy respSerializer$iv = IMSessionSecondaryPageDataSerializer.INSTANCE;
                        SerializationStrategy reqSerializer$iv = KSessionSecondaryReq.Companion.serializer();
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(param);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(req2);
                        $continuation.L$2 = $this$iv;
                        $continuation.L$3 = req2;
                        $continuation.L$4 = reqSerializer$iv;
                        $continuation.L$5 = respSerializer$iv;
                        $continuation.I$0 = 0;
                        $continuation.I$1 = 0;
                        $continuation.I$2 = 0;
                        $continuation.label = 1;
                        Continuation uCont$iv$iv$iv = $continuation;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        final CancellableContinuation it$iv$iv = cancellableContinuationImpl;
                        KMossResponseHandler p3$iv = new KMossResponseHandler<IMSessionPageData>() { // from class: im.session.service.request.IMSessionSecondaryMossRequestService$load$$inlined$sessionSecondary$default$1
                            private IMSessionPageData resp;

                            public void onNext(IMSessionPageData iMSessionPageData) {
                                this.resp = iMSessionPageData;
                            }

                            public void onCompleted() {
                                if (it$iv$iv.isActive()) {
                                    Object result2 = this.resp;
                                    if (result2 != null) {
                                        Result.Companion companion = Result.Companion;
                                        it$iv$iv.resumeWith(Result.constructor-impl(result2));
                                        return;
                                    }
                                    Result.Companion companion2 = Result.Companion;
                                    it$iv$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(new KMossException("Unlikely null response without exception", (Throwable) null))));
                                }
                            }

                            public void onError(KMossException t) {
                                KMossException kMossException;
                                if (it$iv$iv.isActive()) {
                                    Continuation continuation2 = it$iv$iv;
                                    Result.Companion companion = Result.Companion;
                                    if (t != null) {
                                        kMossException = t;
                                    } else {
                                        kMossException = new KMossException("Unknown exception in kmoss coroutine", (Throwable) null);
                                    }
                                    continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable) kMossException)));
                                }
                            }
                        };
                        $this$iv.sessionSecondary(req2, reqSerializer$iv, respSerializer$iv, p3$iv);
                        result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        req = req2;
                        param2 = param;
                        break;
                    case 1:
                        int i2 = $continuation.I$2;
                        int i3 = $continuation.I$1;
                        int i4 = $continuation.I$0;
                        DeserializationStrategy deserializationStrategy = (DeserializationStrategy) $continuation.L$5;
                        SerializationStrategy serializationStrategy = (SerializationStrategy) $continuation.L$4;
                        KSessionSecondaryReq kSessionSecondaryReq = (KSessionSecondaryReq) $continuation.L$3;
                        KimMoss kimMoss = (KimMoss) $continuation.L$2;
                        req = (KSessionSecondaryReq) $continuation.L$1;
                        param2 = (IMSessionRequestParam) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        result = $result;
                        break;
                    case 2:
                        IMSessionPageData iMSessionPageData = (IMSessionPageData) $continuation.L$2;
                        KSessionSecondaryReq kSessionSecondaryReq2 = (KSessionSecondaryReq) $continuation.L$1;
                        IMSessionRequestParam iMSessionRequestParam = (IMSessionRequestParam) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                IMSessionPageData resp = (IMSessionPageData) result;
                IMSummaryCacheService iMSummaryCacheService = this.summaryService;
                IMSessionPageData copy$default = IMSessionPageData.copy$default(resp, null, null, null, null, IMSessionPageDataKt.uniqueAndSort(resp.getSessions()), null, null, null, null, null, false, 2031, null);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(param2);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable(req);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(resp);
                $continuation.L$3 = null;
                $continuation.L$4 = null;
                $continuation.L$5 = null;
                $continuation.label = 2;
                Object collectFirstSummary = IMMessageSummaryServiceKt.collectFirstSummary(iMSummaryCacheService, copy$default, $continuation);
                return collectFirstSummary != coroutine_suspended ? coroutine_suspended : collectFirstSummary;
            }
        }
        $continuation = new IMSessionSecondaryMossRequestService$load$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        IMSessionPageData resp2 = (IMSessionPageData) result;
        IMSummaryCacheService iMSummaryCacheService2 = this.summaryService;
        IMSessionPageData copy$default2 = IMSessionPageData.copy$default(resp2, null, null, null, null, IMSessionPageDataKt.uniqueAndSort(resp2.getSessions()), null, null, null, null, null, false, 2031, null);
        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(param2);
        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(req);
        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
        $continuation.L$3 = null;
        $continuation.L$4 = null;
        $continuation.L$5 = null;
        $continuation.label = 2;
        Object collectFirstSummary2 = IMMessageSummaryServiceKt.collectFirstSummary(iMSummaryCacheService2, copy$default2, $continuation);
        if (collectFirstSummary2 != coroutine_suspended2) {
        }
    }
}