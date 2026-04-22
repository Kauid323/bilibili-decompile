package tv.danmaku.biliplayerimpl.toast.left.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.R;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: CustomMessageVH.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/CustomMessageVH;", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bindPlayerToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "adapter", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "onViewRecycled", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CustomMessageVH extends AbsToastViewHolder {
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomMessageVH(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder
    public void bindPlayerToast(PlayerToast toast, AbsToastListAdapter adapter) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (toast.getCustomView() == null) {
            PlayerLog.e(PlayerContainerKt.TAG, "customView is null");
            return;
        }
        View view2 = this.itemView;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view2).removeAllViews();
        View customView = toast.getCustomView();
        Intrinsics.checkNotNull(customView);
        ViewParent parent = customView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(toast.getCustomView());
        }
        View customView2 = toast.getCustomView();
        Intrinsics.checkNotNull(customView2);
        customView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view3 = this.itemView;
        Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view3).addView(toast.getCustomView());
        toast.setToastView(this.itemView);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder
    public void onViewRecycled() {
        View view2 = this.itemView;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view2).removeAllViews();
    }

    /* compiled from: CustomMessageVH.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/CustomMessageVH$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "parent", "Landroid/view/ViewGroup;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AbsToastViewHolder create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_player_new_message_custom, parent, false);
            Intrinsics.checkNotNull(view2);
            return new CustomMessageVH(view2);
        }
    }
}