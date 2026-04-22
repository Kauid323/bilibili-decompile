package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import im.base.IMLog;
import im.session.IMState;
import im.session.log.LogTagKt;
import im.session.model.IMSessionFilterKt;
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

/* compiled from: IMSessionHomeDataSourceService.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lim/session/service/IMSessionHomeDataSourceService;", "Lim/session/service/IMSessionDataSourceServiceLike;", "cacheService", "Lim/session/service/IMSessionListCacheService;", "remoteService", "Lim/session/service/IMSessionRequestServiceLike;", "<init>", "(Lim/session/service/IMSessionListCacheService;Lim/session/service/IMSessionRequestServiceLike;)V", "load", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "state", "Lim/session/IMState;", "loadCache", "", "loadNext", "loadNext-0E7RQCE", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lim/session/IMState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFromCacheAndNetwork", "param", "Lim/session/service/IMSessionRequestParam;", "loadFromNetwork", "loadNext-gIAlu-s", "(Lim/session/service/IMSessionRequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionHomeDataSourceService implements IMSessionDataSourceServiceLike {
    private final IMSessionListCacheService cacheService;
    private final IMSessionRequestServiceLike remoteService;

    @Inject
    public IMSessionHomeDataSourceService(IMSessionListCacheService cacheService, IMSessionRequestServiceLike remoteService) {
        Intrinsics.checkNotNullParameter(cacheService, "cacheService");
        Intrinsics.checkNotNullParameter(remoteService, "remoteService");
        this.cacheService = cacheService;
        this.remoteService = remoteService;
    }

    @Override // im.session.service.IMSessionDataSourceServiceLike
    public Flow<Result<IMSessionPageData>> load(KSessionPageType pageType, IMState state, boolean loadCache) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(state, "state");
        IMSessionRequestParam params = new IMSessionRequestParam(null, null, IMSessionFilterKt.currentFilterType(state.getData().getFilters()), 3, null);
        if (loadCache) {
            return loadFromCacheAndNetwork(params);
        }
        return loadFromNetwork(params);
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
        IMSessionHomeDataSourceService$loadNext$1 iMSessionHomeDataSourceService$loadNext$1;
        if (continuation instanceof IMSessionHomeDataSourceService$loadNext$1) {
            iMSessionHomeDataSourceService$loadNext$1 = (IMSessionHomeDataSourceService$loadNext$1) continuation;
            if ((iMSessionHomeDataSourceService$loadNext$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionHomeDataSourceService$loadNext$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionHomeDataSourceService$loadNext$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionHomeDataSourceService$loadNext$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMSessionRequestParam iMSessionRequestParam = new IMSessionRequestParam(state.getData().getPaginationParams$session_debug(), null, IMSessionFilterKt.currentFilterType(state.getData().getFilters()), 2, null);
                        iMSessionHomeDataSourceService$loadNext$1.L$0 = SpillingKt.nullOutSpilledVariable(pageType);
                        iMSessionHomeDataSourceService$loadNext$1.L$1 = SpillingKt.nullOutSpilledVariable(state);
                        iMSessionHomeDataSourceService$loadNext$1.label = 1;
                        Object m3358loadNextgIAlus = m3358loadNextgIAlus(iMSessionRequestParam, iMSessionHomeDataSourceService$loadNext$1);
                        if (m3358loadNextgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return m3358loadNextgIAlus;
                    case 1:
                        IMState iMState = (IMState) iMSessionHomeDataSourceService$loadNext$1.L$1;
                        KSessionPageType kSessionPageType = (KSessionPageType) iMSessionHomeDataSourceService$loadNext$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionHomeDataSourceService$loadNext$1 = new IMSessionHomeDataSourceService$loadNext$1(this, continuation);
        Object $result2 = iMSessionHomeDataSourceService$loadNext$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionHomeDataSourceService$loadNext$1.label) {
        }
    }

    private final Flow<Result<IMSessionPageData>> loadFromCacheAndNetwork(IMSessionRequestParam param) {
        return FlowKt.channelFlow(new IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1(param, this, null));
    }

    private final Flow<Result<IMSessionPageData>> loadFromNetwork(IMSessionRequestParam param) {
        return FlowKt.channelFlow(new IMSessionHomeDataSourceService$loadFromNetwork$1(param, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* renamed from: loadNext-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3358loadNextgIAlus(IMSessionRequestParam param, Continuation<? super Result<IMSessionPageData>> continuation) {
        IMSessionHomeDataSourceService$loadNext$2 iMSessionHomeDataSourceService$loadNext$2;
        Object obj;
        Throwable it;
        Object load;
        if (continuation instanceof IMSessionHomeDataSourceService$loadNext$2) {
            iMSessionHomeDataSourceService$loadNext$2 = (IMSessionHomeDataSourceService$loadNext$2) continuation;
            if ((iMSessionHomeDataSourceService$loadNext$2.label & Integer.MIN_VALUE) != 0) {
                iMSessionHomeDataSourceService$loadNext$2.label -= Integer.MIN_VALUE;
                Object $result = iMSessionHomeDataSourceService$loadNext$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionHomeDataSourceService$loadNext$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "IMSessionHomeDataSourceService 加载分页数据 " + param);
                        Result.Companion companion = Result.Companion;
                        IMSessionRequestServiceLike iMSessionRequestServiceLike = this.remoteService;
                        iMSessionHomeDataSourceService$loadNext$2.L$0 = param;
                        iMSessionHomeDataSourceService$loadNext$2.I$0 = 0;
                        iMSessionHomeDataSourceService$loadNext$2.I$1 = 0;
                        iMSessionHomeDataSourceService$loadNext$2.label = 1;
                        load = iMSessionRequestServiceLike.load(param, iMSessionHomeDataSourceService$loadNext$2);
                        if (load != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSessionHomeDataSourceService$loadNext$2.I$1;
                        int i3 = iMSessionHomeDataSourceService$loadNext$2.I$0;
                        param = (IMSessionRequestParam) iMSessionHomeDataSourceService$loadNext$2.L$0;
                        ResultKt.throwOnFailure($result);
                        load = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((IMSessionPageData) load);
                JobKt.ensureActive(iMSessionHomeDataSourceService$loadNext$2.getContext());
                if (Result.isSuccess-impl(obj)) {
                    IMSessionPageData iMSessionPageData = (IMSessionPageData) obj;
                    IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "加载分页数据成功 " + param);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.getHomeLoadLogTag(), "加载分页数据失败 " + param, it);
                }
                return obj;
            }
        }
        iMSessionHomeDataSourceService$loadNext$2 = new IMSessionHomeDataSourceService$loadNext$2(this, continuation);
        Object $result2 = iMSessionHomeDataSourceService$loadNext$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionHomeDataSourceService$loadNext$2.label) {
        }
        obj = Result.constructor-impl((IMSessionPageData) load);
        JobKt.ensureActive(iMSessionHomeDataSourceService$loadNext$2.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }
}