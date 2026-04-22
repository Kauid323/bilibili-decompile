package tv.danmaku.bili.appwidget.hotlist.moss;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotListMoss.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.moss.HotListMossKt", f = "HotListMoss.kt", i = {0}, l = {36}, m = "getOppoHostListData", n = {"context"}, s = {"L$0"}, v = 1)
public final class HotListMossKt$getOppoHostListData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotListMossKt$getOppoHostListData$1(Continuation<? super HotListMossKt$getOppoHostListData$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HotListMossKt.getOppoHostListData(null, (Continuation) this);
    }
}