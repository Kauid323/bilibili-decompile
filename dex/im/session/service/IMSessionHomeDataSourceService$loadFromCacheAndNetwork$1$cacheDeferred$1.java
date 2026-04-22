package im.session.service;

import com.tencent.open.log.TraceLevel;
import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionFilterKt;
import im.session.model.IMSessionPageData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: IMSessionHomeDataSourceService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1", f = "IMSessionHomeDataSourceService.kt", i = {0, 0, 1, 1}, l = {56, TraceLevel.ABOVE_DEBUG}, m = "invokeSuspend", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1$1", "it", "$i$a$-onSuccess-IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1$2"}, s = {"I$0", "I$1", "L$1", "I$0"}, v = 1)
final class IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends IMSessionPageData>>, Object> {
    final /* synthetic */ ProducerScope<Result<IMSessionPageData>> $$this$channelFlow;
    final /* synthetic */ IMSessionRequestParam $param;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMSessionHomeDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1(IMSessionHomeDataSourceService iMSessionHomeDataSourceService, IMSessionRequestParam iMSessionRequestParam, ProducerScope<? super Result<IMSessionPageData>> producerScope, Continuation<? super IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionHomeDataSourceService;
        this.$param = iMSessionRequestParam;
        this.$$this$channelFlow = producerScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionHomeDataSourceService$loadFromCacheAndNetwork$1$cacheDeferred$1(this.this$0, this.$param, this.$$this$channelFlow, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<IMSessionPageData>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object obj2;
        Throwable it;
        IMSessionListCacheService iMSessionListCacheService;
        Object load;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMSessionHomeDataSourceService iMSessionHomeDataSourceService = this.this$0;
                Result.Companion companion2 = Result.Companion;
                iMSessionListCacheService = iMSessionHomeDataSourceService.cacheService;
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                load = iMSessionListCacheService.load(this);
                if (load == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int i2 = this.I$1;
                int i3 = this.I$0;
                ResultKt.throwOnFailure($result);
                load = $result;
                break;
            case 2:
                int i4 = this.I$0;
                IMSessionPageData iMSessionPageData = (IMSessionPageData) this.L$1;
                obj2 = this.L$0;
                ResultKt.throwOnFailure($result);
                obj = obj2;
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(LogTagKt.getHomeLoadLogTag(), "加载磁盘缓存失败", it);
                }
                return Result.box-impl(obj);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj = Result.constructor-impl((IMSessionPageData) load);
        JobKt.ensureActive(getContext());
        IMSessionRequestParam iMSessionRequestParam = this.$param;
        ProducerScope<Result<IMSessionPageData>> producerScope = this.$$this$channelFlow;
        if (Result.isSuccess-impl(obj)) {
            IMSessionPageData it2 = (IMSessionPageData) obj;
            IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "加载磁盘缓存成功, 是否有数据: " + (it2 != null));
            if (it2 != null && Intrinsics.areEqual(IMSessionFilterKt.currentFilterType(it2.getFilters()), iMSessionRequestParam.getFilterType())) {
                Result.Companion companion3 = Result.Companion;
                Result result = Result.box-impl(Result.constructor-impl(it2));
                this.L$0 = obj;
                this.L$1 = SpillingKt.nullOutSpilledVariable(it2);
                this.I$0 = 0;
                this.label = 2;
                if (producerScope.send(result, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = obj;
                obj = obj2;
            }
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return Result.box-impl(obj);
    }
}