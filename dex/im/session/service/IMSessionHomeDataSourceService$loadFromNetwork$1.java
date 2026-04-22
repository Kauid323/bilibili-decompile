package im.session.service;

import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionPageData;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionHomeDataSourceService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionHomeDataSourceService$loadFromNetwork$1", f = "IMSessionHomeDataSourceService.kt", i = {0, 1, 1, 2, 2}, l = {86, 88, 94}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$channelFlow", "result", "$this$channelFlow", "t"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class IMSessionHomeDataSourceService$loadFromNetwork$1 extends SuspendLambda implements Function2<ProducerScope<? super Result<? extends IMSessionPageData>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionRequestParam $param;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMSessionHomeDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionHomeDataSourceService$loadFromNetwork$1(IMSessionRequestParam iMSessionRequestParam, IMSessionHomeDataSourceService iMSessionHomeDataSourceService, Continuation<? super IMSessionHomeDataSourceService$loadFromNetwork$1> continuation) {
        super(2, continuation);
        this.$param = iMSessionRequestParam;
        this.this$0 = iMSessionHomeDataSourceService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionHomeDataSourceService$loadFromNetwork$1 = new IMSessionHomeDataSourceService$loadFromNetwork$1(this.$param, this.this$0, continuation);
        iMSessionHomeDataSourceService$loadFromNetwork$1.L$0 = obj;
        return iMSessionHomeDataSourceService$loadFromNetwork$1;
    }

    public final Object invoke(ProducerScope<? super Result<IMSessionPageData>> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        IMSessionRequestServiceLike iMSessionRequestServiceLike;
        Object load;
        IMSessionPageData result;
        ProducerScope $this$channelFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception t) {
            if (t instanceof CancellationException) {
                IMLog.Companion.w(LogTagKt.getHomeLoadLogTag(), "此次请求首页已取消(CancellationException), " + this.$param);
            } else {
                IMLog.Companion.e(LogTagKt.getHomeLoadLogTag(), "请求首页网络接口失败 " + this.$param, t);
                Result.Companion companion = Result.Companion;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(t);
                this.label = 3;
                if ($this$channelFlow.send(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(t))), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "IMSessionHomeDataSourceService 仅从网络接口加载<首页>数据 " + this.$param);
                iMSessionRequestServiceLike = this.this$0.remoteService;
                this.L$0 = $this$channelFlow;
                this.label = 1;
                load = iMSessionRequestServiceLike.load(this.$param, (Continuation) this);
                if (load == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (IMSessionPageData) load;
                IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "请求首页网络接口成功 " + this.$param);
                Result.Companion companion2 = Result.Companion;
                this.L$0 = $this$channelFlow;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$channelFlow.send(Result.box-impl(Result.constructor-impl(result)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                load = $result;
                result = (IMSessionPageData) load;
                IMLog.Companion.i(LogTagKt.getHomeLoadLogTag(), "请求首页网络接口成功 " + this.$param);
                Result.Companion companion22 = Result.Companion;
                this.L$0 = $this$channelFlow;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$channelFlow.send(Result.box-impl(Result.constructor-impl(result)), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                IMSessionPageData iMSessionPageData = (IMSessionPageData) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}