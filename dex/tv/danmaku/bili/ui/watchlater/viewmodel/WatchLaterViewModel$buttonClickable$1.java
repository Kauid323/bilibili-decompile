package tv.danmaku.bili.ui.watchlater.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "index", "", "pageState", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$buttonClickable$1", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class WatchLaterViewModel$buttonClickable$1 extends SuspendLambda implements Function3<Integer, WatchLaterState, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchLaterViewModel$buttonClickable$1(Continuation<? super WatchLaterViewModel$buttonClickable$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(int i, WatchLaterState watchLaterState, Continuation<? super Boolean> continuation) {
        WatchLaterViewModel$buttonClickable$1 watchLaterViewModel$buttonClickable$1 = new WatchLaterViewModel$buttonClickable$1(continuation);
        watchLaterViewModel$buttonClickable$1.I$0 = i;
        watchLaterViewModel$buttonClickable$1.L$0 = watchLaterState;
        return watchLaterViewModel$buttonClickable$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), (WatchLaterState) obj2, (Continuation) obj3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r0 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                int index = this.I$0;
                WatchLaterState pageState = (WatchLaterState) this.L$0;
                boolean z2 = true;
                if (index != 0 || pageState.getTabAll().getData().getList().isEmpty()) {
                    if (index == 1) {
                        if (!pageState.getTabToView().getData().getList().isEmpty()) {
                            z = true;
                            break;
                        } else {
                            z = false;
                            break;
                        }
                    }
                    z2 = false;
                }
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}