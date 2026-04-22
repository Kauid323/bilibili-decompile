package tv.danmaku.bili.ui.topic;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.app.topic.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.topic.api.BiliTopic;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicFragments.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicViewHolder;", "Ltv/danmaku/bili/ui/topic/BaseViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "Landroid/widget/TextView;", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "Lcom/bilibili/lib/image2/view/legacy/ScalableImageView2;", "topic", "Ltv/danmaku/bili/ui/topic/api/BiliTopic;", "onClick", "", "v", "bind", "data", "", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicViewHolder extends BaseViewHolder implements View.OnClickListener {
    private ScalableImageView2 cover;
    private TextView title;
    private BiliTopic topic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.title = (TextView) findViewById;
        ScalableImageView2 findViewById2 = itemView.findViewById(R.id.cover);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.cover = findViewById2;
        itemView.setOnClickListener(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TopicViewHolder(ViewGroup parent) {
        this(r0);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_activity_promo, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        BiliTopic $this$onClick_u24lambda_u241 = this.topic;
        if ($this$onClick_u24lambda_u241 != null) {
            if (TextUtils.isEmpty($this$onClick_u24lambda_u241.link)) {
                $this$onClick_u24lambda_u241 = null;
            }
            if ($this$onClick_u24lambda_u241 != null) {
                Uri build = Uri.parse($this$onClick_u24lambda_u241.link).buildUpon().appendQueryParameter("from_spmid", "activity.topic-center.0.0").build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                Context context = v.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                RouteKt.openRoute$default(build, context, false, 2, null);
            }
        }
    }

    @Override // tv.danmaku.bili.ui.topic.BaseViewHolder
    public void bind(Object data) {
        BiliTopic $this$bind_u24lambda_u240 = null;
        BiliTopic biliTopic = data instanceof BiliTopic ? (BiliTopic) data : null;
        if (biliTopic != null) {
            $this$bind_u24lambda_u240 = biliTopic;
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            biliImageLoader.with(context).url($this$bind_u24lambda_u240.cover).into(this.cover);
            this.title.setText($this$bind_u24lambda_u240.title);
        }
        this.topic = $this$bind_u24lambda_u240;
    }
}