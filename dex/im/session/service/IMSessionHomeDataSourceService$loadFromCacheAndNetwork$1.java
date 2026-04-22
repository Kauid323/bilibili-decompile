package im.session.service;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionPageData;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionHomeDataSourceService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1", f = "IMSessionHomeDataSourceService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {WXMediaMessage.IMediaObject.TYPE_OPENSDK_LITEAPP, 74, WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO}, m = "invokeSuspend", n = {"$this$channelFlow", "cacheDeferred", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$1", "$this$channelFlow", "cacheDeferred", "it", "$i$a$-onFailure-IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$3", "$this$channelFlow", "cacheDeferred", "it", "$i$a$-also-IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$4"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$3", "I$0", "L$0", "L$1", "L$3", "I$0"}, v = 1)
public final class IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1 extends SuspendLambda implements Function2<ProducerScope<? super Result<? extends IMSessionPageData>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionRequestParam $param;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ IMSessionHomeDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1(IMSessionRequestParam iMSessionRequestParam, IMSessionHomeDataSourceService iMSessionHomeDataSourceService, Continuation<? super IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1> continuation) {
        super(2, continuation);
        this.$param = iMSessionRequestParam;
        this.this$0 = iMSessionHomeDataSourceService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionHomeDataSourceService$loadFromCacheAndNetwork$1 = new IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1(this.$param, this.this$0, continuation);
        iMSessionHomeDataSourceService$loadFromCacheAndNetwork$1.L$0 = obj;
        return iMSessionHomeDataSourceService$loadFromCacheAndNetwork$1;
    }

    public final Object invoke(ProducerScope<? super Result<IMSessionPageData>> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0164 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Job cacheDeferred;
        IMSessionRequestServiceLike iMSessionRequestServiceLike;
        Object load;
        Object obj;
        Throwable it;
        Deferred cacheDeferred2;
        Object obj2;
        Deferred cacheDeferred3;
        Result result;
        CoroutineScope coroutineScope = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "IMSessionHomeDataSourceService 从本地缓存和网络接口同时加载<首页>数据 " + this.$param);
                cacheDeferred = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1(this.this$0, this.$param, coroutineScope, null), 3, (Object) null);
                IMSessionHomeDataSourceService iMSessionHomeDataSourceService = this.this$0;
                IMSessionRequestParam iMSessionRequestParam = this.$param;
                try {
                    Result.Companion companion = Result.Companion;
                    iMSessionRequestServiceLike = iMSessionHomeDataSourceService.remoteService;
                    this.L$0 = coroutineScope;
                    this.L$1 = cacheDeferred;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    load = iMSessionRequestServiceLike.load(iMSessionRequestParam, this);
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    JobKt.ensureActive(getContext());
                    IMSessionRequestParam iMSessionRequestParam2 = this.$param;
                    if (Result.isSuccess-impl(obj)) {
                    }
                    IMSessionRequestParam iMSessionRequestParam3 = this.$param;
                    it = Result.exceptionOrNull-impl(obj);
                    if (it == null) {
                    }
                }
                if (load == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = Result.constructor-impl((IMSessionPageData) load);
                JobKt.ensureActive(getContext());
                IMSessionRequestParam iMSessionRequestParam22 = this.$param;
                if (Result.isSuccess-impl(obj)) {
                    IMSessionPageData iMSessionPageData = (IMSessionPageData) obj;
                    Job.DefaultImpls.cancel$default(cacheDeferred, (CancellationException) null, 1, (Object) null);
                    IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "请求列表首页网络接口成功 " + iMSessionRequestParam22);
                }
                IMSessionRequestParam iMSessionRequestParam32 = this.$param;
                it = Result.exceptionOrNull-impl(obj);
                if (it == null) {
                    IMLog.Companion.e(LogTagKt.getHomeLoadLogTag(), "请求列表首页网络接口失败 " + iMSessionRequestParam32, it);
                    this.L$0 = coroutineScope;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(cacheDeferred);
                    this.L$2 = obj;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 2;
                    if (cacheDeferred.await(this) != coroutine_suspended) {
                        obj2 = obj;
                        cacheDeferred3 = cacheDeferred;
                        obj = obj2;
                        cacheDeferred2 = cacheDeferred3;
                        Result result2 = Result.box-impl(obj);
                        Object it2 = result2.unbox-impl();
                        result = Result.box-impl(it2);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(cacheDeferred2);
                        this.L$2 = result2;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                        this.I$0 = 0;
                        this.label = 3;
                        if (coroutineScope.send(result, this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    cacheDeferred2 = cacheDeferred;
                    Result result22 = Result.box-impl(obj);
                    Object it22 = result22.unbox-impl();
                    result = Result.box-impl(it22);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(cacheDeferred2);
                    this.L$2 = result22;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(it22);
                    this.I$0 = 0;
                    this.label = 3;
                    if (coroutineScope.send(result, this) != coroutine_suspended) {
                    }
                }
            case 1:
                int i2 = this.I$1;
                int i3 = this.I$0;
                cacheDeferred = (Deferred) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    load = $result;
                    obj = Result.constructor-impl((IMSessionPageData) load);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    JobKt.ensureActive(getContext());
                    IMSessionRequestParam iMSessionRequestParam222 = this.$param;
                    if (Result.isSuccess-impl(obj)) {
                    }
                    IMSessionRequestParam iMSessionRequestParam322 = this.$param;
                    it = Result.exceptionOrNull-impl(obj);
                    if (it == null) {
                    }
                }
                JobKt.ensureActive(getContext());
                IMSessionRequestParam iMSessionRequestParam2222 = this.$param;
                if (Result.isSuccess-impl(obj)) {
                }
                IMSessionRequestParam iMSessionRequestParam3222 = this.$param;
                it = Result.exceptionOrNull-impl(obj);
                if (it == null) {
                }
                break;
            case 2:
                int i4 = this.I$0;
                Throwable th3 = (Throwable) this.L$3;
                obj2 = this.L$2;
                cacheDeferred3 = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                obj = obj2;
                cacheDeferred2 = cacheDeferred3;
                Result result222 = Result.box-impl(obj);
                Object it222 = result222.unbox-impl();
                result = Result.box-impl(it222);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(cacheDeferred2);
                this.L$2 = result222;
                this.L$3 = SpillingKt.nullOutSpilledVariable(it222);
                this.I$0 = 0;
                this.label = 3;
                if (coroutineScope.send(result, this) != coroutine_suspended) {
                }
                break;
            case 3:
                int i5 = this.I$0;
                Object obj3 = this.L$3;
                Result result3 = (Result) this.L$2;
                Deferred deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}