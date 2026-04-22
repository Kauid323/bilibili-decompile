package tv.danmaku.bili.ui.rank.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.R;
import tv.danmaku.bili.ui.rank.RankVideoListFragment;
import tv.danmaku.bili.ui.rank.model.RankModel;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TipTitleHolder.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/rank/view/TipTitleHolder;", "Ltv/danmaku/bili/ui/rank/view/ViewHolderBase;", "parent", "Landroid/view/ViewGroup;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "<init>", "(Landroid/view/ViewGroup;Ljava/lang/String;)V", "onClick", "", "v", "Landroid/view/View;", "bind", "video", "Ltv/danmaku/bili/ui/rank/model/RankModel;", "fragment", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/bili/ui/rank/RankVideoListFragment;", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TipTitleHolder extends ViewHolderBase {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipTitleHolder(ViewGroup parent, String title) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_list_item_rank_tip_title, parent, false), title);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // tv.danmaku.bili.ui.rank.view.ViewHolderBase
    public void bind(RankModel video2, WeakReference<RankVideoListFragment> weakReference) {
        Intrinsics.checkNotNullParameter(video2, "video");
        View view2 = this.itemView;
        TextView textView = view2 instanceof TextView ? (TextView) view2 : null;
        if (textView != null) {
            textView.setText(video2.getTitle());
        }
    }
}