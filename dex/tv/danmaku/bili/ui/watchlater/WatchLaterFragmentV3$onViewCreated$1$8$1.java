package tv.danmaku.bili.ui.watchlater;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterFragmentV3.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "index", ""}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$onViewCreated$1$8$1", f = "WatchLaterFragmentV3.kt", i = {}, l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterFragmentV3$onViewCreated$1$8$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ WatchLaterFragmentV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterFragmentV3$onViewCreated$1$8$1(WatchLaterFragmentV3 watchLaterFragmentV3, Continuation<? super WatchLaterFragmentV3$onViewCreated$1$8$1> continuation) {
        super(2, continuation);
        this.this$0 = watchLaterFragmentV3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> watchLaterFragmentV3$onViewCreated$1$8$1 = new WatchLaterFragmentV3$onViewCreated$1$8$1(this.this$0, continuation);
        watchLaterFragmentV3$onViewCreated$1$8$1.I$0 = ((Number) obj).intValue();
        return watchLaterFragmentV3$onViewCreated$1$8$1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation) obj2);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int index = this.I$0;
                this.label = 1;
                if (this.this$0.getViewModel().onTabClick(index, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}