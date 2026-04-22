package tv.danmaku.bili.ui.watchlater.viewmodel;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.ui.watchlater.api.WatchLaterApiMangerKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bilibili/okretro/GeneralResponse;", "Lcom/bilibili/okretro/BaseResponse;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$deleteVideos$2", f = "WatchLaterViewModel.kt", i = {}, l = {638, 638}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterViewModel$deleteVideos$2 extends SuspendLambda implements Function2<FlowCollector<? super GeneralResponse<BaseResponse>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resource;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$deleteVideos$2(String str, Continuation<? super WatchLaterViewModel$deleteVideos$2> continuation) {
        super(2, continuation);
        this.$resource = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> watchLaterViewModel$deleteVideos$2 = new WatchLaterViewModel$deleteVideos$2(this.$resource, continuation);
        watchLaterViewModel$deleteVideos$2.L$0 = obj;
        return watchLaterViewModel$deleteVideos$2;
    }

    public final Object invoke(FlowCollector<? super GeneralResponse<BaseResponse>> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$flow = (FlowCollector) this.L$0;
                this.L$0 = $this$flow;
                this.label = 1;
                Object deleteWatchLater = WatchLaterApiMangerKt.deleteWatchLater(this.$resource, (Continuation) this);
                if (deleteWatchLater == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = deleteWatchLater;
                flowCollector = $this$flow;
                this.L$0 = null;
                this.label = 2;
                return flowCollector.emit($result, (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                flowCollector = (FlowCollector) this.L$0;
                $result2 = $result;
                this.L$0 = null;
                this.label = 2;
                if (flowCollector.emit($result, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}