package tv.danmaku.bili.ui.garb.view;

import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.player.AutoPlayScrollListener;
import com.bili.digital.common.player.ScrollDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FrontRecycleView.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"tv/danmaku/bili/ui/garb/view/FrontRecycleView$mListener$1", "Lcom/bili/digital/common/player/AutoPlayScrollListener;", "onScroll", "", "nextPosition", "", "direction", "Lcom/bili/digital/common/player/ScrollDirection;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FrontRecycleView$mListener$1 implements AutoPlayScrollListener {
    final /* synthetic */ FrontRecycleView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrontRecycleView$mListener$1(FrontRecycleView $receiver) {
        this.this$0 = $receiver;
    }

    public void onScroll(final int nextPosition, ScrollDirection direction) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(direction, "direction");
        recyclerView = this.this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        final FrontRecycleView frontRecycleView = this.this$0;
        recyclerView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.view.FrontRecycleView$mListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FrontRecycleView$mListener$1.onScroll$lambda$0(FrontRecycleView.this, nextPosition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScroll$lambda$0(FrontRecycleView this$0, int $nextPosition) {
        RecyclerView recyclerView;
        recyclerView = this$0.mInnerRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerRecycleView");
            recyclerView = null;
        }
        recyclerView.smoothScrollToPosition($nextPosition);
    }
}