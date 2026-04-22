package tv.danmaku.biliplayerimpl.toast.left;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsToastViewHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bindPlayerToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "adapter", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "onViewRecycled", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsToastViewHolder extends RecyclerView.ViewHolder {
    public abstract void bindPlayerToast(PlayerToast playerToast, AbsToastListAdapter absToastListAdapter);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsToastViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public void onViewRecycled() {
    }
}