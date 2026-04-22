package tv.danmaku.biliplayerimpl.toast.left.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.R;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalMessageVH.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/NormalMessageVH;", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "bindPlayerToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "adapter", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalMessageVH extends AbsToastViewHolder {
    public static final Companion Companion = new Companion(null);
    private final TextView contentTv;

    public /* synthetic */ NormalMessageVH(View view2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2);
    }

    private NormalMessageVH(View itemView) {
        super(itemView);
        Intrinsics.checkNotNull(itemView, "null cannot be cast to non-null type android.widget.TextView");
        this.contentTv = (TextView) itemView;
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder
    public void bindPlayerToast(PlayerToast toast, AbsToastListAdapter adapter) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.contentTv.setText(PlayerToastConfig.getTitle(toast));
        toast.setToastView(this.itemView);
    }

    /* compiled from: NormalMessageVH.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/NormalMessageVH$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerimpl/toast/left/viewholder/NormalMessageVH;", "parent", "Landroid/view/ViewGroup;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NormalMessageVH create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_player_toast_message_normal, parent, false);
            Intrinsics.checkNotNull(view2);
            return new NormalMessageVH(view2, null);
        }
    }
}