package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MinePagePendingTaskUtil.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePagePendingTaskUtil", f = "MinePagePendingTaskUtil.kt", i = {0, 1}, l = {BR.backgroundColor, BR.backgroundDrawable, BR.backgroundTitleText}, m = "executes", n = {"task", "task"}, s = {"L$1", "L$1"}, v = 1)
public final class MinePagePendingTaskUtil$executes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MinePagePendingTaskUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinePagePendingTaskUtil$executes$1(MinePagePendingTaskUtil minePagePendingTaskUtil, Continuation<? super MinePagePendingTaskUtil$executes$1> continuation) {
        super(continuation);
        this.this$0 = minePagePendingTaskUtil;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executes((Continuation) this);
    }
}