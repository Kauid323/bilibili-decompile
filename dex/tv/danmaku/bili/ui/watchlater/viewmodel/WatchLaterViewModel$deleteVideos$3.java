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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bilibili/okretro/GeneralResponse;", "Lcom/bilibili/okretro/BaseResponse;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$deleteVideos$3", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterViewModel$deleteVideos$3 extends SuspendLambda implements Function3<FlowCollector<? super GeneralResponse<BaseResponse>>, Throwable, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$deleteVideos$3(WatchLaterViewModel watchLaterViewModel, Continuation<? super WatchLaterViewModel$deleteVideos$3> continuation) {
        super(3, continuation);
        this.this$0 = watchLaterViewModel;
    }

    public final Object invoke(FlowCollector<? super GeneralResponse<BaseResponse>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new WatchLaterViewModel$deleteVideos$3(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                str = this.this$0.TAG;
                BLog.i(str, "watch later delete failed");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}