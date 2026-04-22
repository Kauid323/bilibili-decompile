package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
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
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: IMSessionSecondaryDataSourceService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionSecondaryDataSourceService$load$1", f = "IMSessionSecondaryDataSourceService.kt", i = {0, 1}, l = {26, 25}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$channelFlow"}, s = {"L$0", "L$0"}, v = 1)
final class IMSessionSecondaryDataSourceService$load$1 extends SuspendLambda implements Function2<ProducerScope<? super Result<? extends IMSessionPageData>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ KSessionPageType $pageType;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMSessionSecondaryDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionSecondaryDataSourceService$load$1(IMSessionSecondaryDataSourceService iMSessionSecondaryDataSourceService, KSessionPageType kSessionPageType, Continuation<? super IMSessionSecondaryDataSourceService$load$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionSecondaryDataSourceService;
        this.$pageType = kSessionPageType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionSecondaryDataSourceService$load$1 = new IMSessionSecondaryDataSourceService$load$1(this.this$0, this.$pageType, continuation);
        iMSessionSecondaryDataSourceService$load$1.L$0 = obj;
        return iMSessionSecondaryDataSourceService$load$1;
    }

    public final Object invoke(ProducerScope<? super Result<IMSessionPageData>> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object m3362loadgIAlus;
        ProducerScope producerScope;
        ProducerScope $this$channelFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                this.L$1 = $this$channelFlow;
                this.label = 1;
                m3362loadgIAlus = this.this$0.m3362loadgIAlus(new IMSessionRequestParam(null, this.$pageType, null, 5, null), (Continuation) this);
                if (m3362loadgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                producerScope = $this$channelFlow;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                this.L$1 = null;
                this.label = 2;
                if (producerScope.send(Result.box-impl(m3362loadgIAlus), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                producerScope = (ProducerScope) this.L$1;
                ResultKt.throwOnFailure($result);
                m3362loadgIAlus = ((Result) $result).unbox-impl();
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                this.L$1 = null;
                this.label = 2;
                if (producerScope.send(Result.box-impl(m3362loadgIAlus), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}