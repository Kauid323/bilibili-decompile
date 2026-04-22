package tv.danmaku.bili.ui.watchlater.compose;

import androidx.compose.foundation.pager.PagerState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterPageCompose.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$WatchLaterContentPage$1$1$1$1", f = "WatchLaterPageCompose.kt", i = {}, l = {243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterPageComposeKt$WatchLaterContentPage$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onTabClick;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WatchLaterPageComposeKt$WatchLaterContentPage$1$1$1$1(PagerState pagerState, int i, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super WatchLaterPageComposeKt$WatchLaterContentPage$1$1$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$index = i;
        this.$onTabClick = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterPageComposeKt$WatchLaterContentPage$1$1$1$1(this.$pagerState, this.$index, this.$onTabClick, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Function2<Integer, Continuation<? super Unit>, Object> function2;
        Integer boxInt;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (PagerState.scrollToPage$default(this.$pagerState, this.$index, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function2 = this.$onTabClick;
                boxInt = Boxing.boxInt(this.$index);
                this.label = 2;
                if (function2.invoke(boxInt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                function2 = this.$onTabClick;
                boxInt = Boxing.boxInt(this.$index);
                this.label = 2;
                if (function2.invoke(boxInt, this) == coroutine_suspended) {
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