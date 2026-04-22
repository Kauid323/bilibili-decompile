package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import im.base.IMLog;
import im.session.IMState;
import im.session.log.LogTagKt;
import im.session.model.IMSessionPageData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: IMSessionSecondaryDataSourceService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lim/session/service/IMSessionSecondaryDataSourceService;", "Lim/session/service/IMSessionDataSourceServiceLike;", "remoteService", "Lim/session/service/IMSessionRequestServiceLike;", "<init>", "(Lim/session/service/IMSessionRequestServiceLike;)V", "load", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "state", "Lim/session/IMState;", "loadCache", "", "loadNext", "loadNext-0E7RQCE", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lim/session/IMState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "param", "Lim/session/service/IMSessionRequestParam;", "load-gIAlu-s", "(Lim/session/service/IMSessionRequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionSecondaryDataSourceService implements IMSessionDataSourceServiceLike {
    private final IMSessionRequestServiceLike remoteService;

    @Inject
    public IMSessionSecondaryDataSourceService(IMSessionRequestServiceLike remoteService) {
        Intrinsics.checkNotNullParameter(remoteService, "remoteService");
        this.remoteService = remoteService;
    }

    @Override // im.session.service.IMSessionDataSourceServiceLike
    public Flow<Result<IMSessionPageData>> load(KSessionPageType pageType, IMState state, boolean loadCache) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(state, "state");
        return FlowKt.channelFlow(new IMSessionSecondaryDataSourceService$load$1(this, pageType, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    @Override // im.session.service.IMSessionDataSourceServiceLike
    /* renamed from: loadNext-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo3356loadNext0E7RQCE(KSessionPageType pageType, IMState state, Continuation<? super Result<IMSessionPageData>> continuation) {
        IMSessionSecondaryDataSourceService$loadNext$1 iMSessionSecondaryDataSourceService$loadNext$1;
        if (continuation instanceof IMSessionSecondaryDataSourceService$loadNext$1) {
            iMSessionSecondaryDataSourceService$loadNext$1 = (IMSessionSecondaryDataSourceService$loadNext$1) continuation;
            if ((iMSessionSecondaryDataSourceService$loadNext$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionSecondaryDataSourceService$loadNext$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionSecondaryDataSourceService$loadNext$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionSecondaryDataSourceService$loadNext$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMSessionRequestParam iMSessionRequestParam = new IMSessionRequestParam(state.getData().getPaginationParams$session_debug(), pageType, null, 4, null);
                        iMSessionSecondaryDataSourceService$loadNext$1.L$0 = SpillingKt.nullOutSpilledVariable(pageType);
                        iMSessionSecondaryDataSourceService$loadNext$1.L$1 = SpillingKt.nullOutSpilledVariable(state);
                        iMSessionSecondaryDataSourceService$loadNext$1.label = 1;
                        Object m3362loadgIAlus = m3362loadgIAlus(iMSessionRequestParam, iMSessionSecondaryDataSourceService$loadNext$1);
                        if (m3362loadgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return m3362loadgIAlus;
                    case 1:
                        IMState iMState = (IMState) iMSessionSecondaryDataSourceService$loadNext$1.L$1;
                        KSessionPageType kSessionPageType = (KSessionPageType) iMSessionSecondaryDataSourceService$loadNext$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionSecondaryDataSourceService$loadNext$1 = new IMSessionSecondaryDataSourceService$loadNext$1(this, continuation);
        Object $result2 = iMSessionSecondaryDataSourceService$loadNext$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionSecondaryDataSourceService$loadNext$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9  */
    /* renamed from: load-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3362loadgIAlus(IMSessionRequestParam param, Continuation<? super Result<IMSessionPageData>> continuation) {
        IMSessionSecondaryDataSourceService$load$2 iMSessionSecondaryDataSourceService$load$2;
        Object obj;
        Throwable it;
        Object load;
        if (continuation instanceof IMSessionSecondaryDataSourceService$load$2) {
            iMSessionSecondaryDataSourceService$load$2 = (IMSessionSecondaryDataSourceService$load$2) continuation;
            if ((iMSessionSecondaryDataSourceService$load$2.label & Integer.MIN_VALUE) != 0) {
                iMSessionSecondaryDataSourceService$load$2.label -= Integer.MIN_VALUE;
                Object $result = iMSessionSecondaryDataSourceService$load$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionSecondaryDataSourceService$load$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.getSecondaryLoadLogTag(), param.getPageType() + ": 准备请求二级列表 " + param);
                        Result.Companion companion = Result.Companion;
                        IMSessionRequestServiceLike iMSessionRequestServiceLike = this.remoteService;
                        iMSessionSecondaryDataSourceService$load$2.L$0 = param;
                        iMSessionSecondaryDataSourceService$load$2.I$0 = 0;
                        iMSessionSecondaryDataSourceService$load$2.I$1 = 0;
                        iMSessionSecondaryDataSourceService$load$2.label = 1;
                        load = iMSessionRequestServiceLike.load(param, iMSessionSecondaryDataSourceService$load$2);
                        if (load != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSessionSecondaryDataSourceService$load$2.I$1;
                        int i3 = iMSessionSecondaryDataSourceService$load$2.I$0;
                        param = (IMSessionRequestParam) iMSessionSecondaryDataSourceService$load$2.L$0;
                        ResultKt.throwOnFailure($result);
                        load = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((IMSessionPageData) load);
                JobKt.ensureActive(iMSessionSecondaryDataSourceService$load$2.getContext());
                if (Result.isSuccess-impl(obj)) {
                    IMSessionPageData iMSessionPageData = (IMSessionPageData) obj;
                    IMLog.Companion.i(LogTagKt.getSecondaryLoadLogTag(), param.getPageType() + ": 二级列表请求成功 " + param);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.getSecondaryLoadLogTag(), param.getPageType() + ": 二级列表请求失败 " + param, it);
                }
                return obj;
            }
        }
        iMSessionSecondaryDataSourceService$load$2 = new IMSessionSecondaryDataSourceService$load$2(this, continuation);
        Object $result2 = iMSessionSecondaryDataSourceService$load$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionSecondaryDataSourceService$load$2.label) {
        }
        obj = Result.constructor-impl((IMSessionPageData) load);
        JobKt.ensureActive(iMSessionSecondaryDataSourceService$load$2.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }
}