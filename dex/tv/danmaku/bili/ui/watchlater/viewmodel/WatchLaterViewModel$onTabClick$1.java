package tv.danmaku.bili.ui.watchlater.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel", f = "WatchLaterViewModel.kt", i = {0}, l = {523}, m = "onTabClick", n = {"pageIndex"}, s = {"I$0"}, v = 1)
public final class WatchLaterViewModel$onTabClick$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$onTabClick$1(WatchLaterViewModel watchLaterViewModel, Continuation<? super WatchLaterViewModel$onTabClick$1> continuation) {
        super(continuation);
        this.this$0 = watchLaterViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTabClick(0, (Continuation) this);
    }
}