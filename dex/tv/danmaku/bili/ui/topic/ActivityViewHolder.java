package tv.danmaku.bili.ui.topic;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/topic/ActivityViewHolder;", "Ltv/danmaku/bili/ui/topic/BaseViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "Landroid/widget/TextView;", "getTitle$topic_debug", "()Landroid/widget/TextView;", "setTitle$topic_debug", "(Landroid/widget/TextView;)V", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "Lcom/bilibili/lib/image2/view/legacy/ScalableImageView2;", "getCover$topic_debug", "()Lcom/bilibili/lib/image2/view/legacy/ScalableImageView2;", "setCover$topic_debug", "(Lcom/bilibili/lib/image2/view/legacy/ScalableImageView2;)V", "badge", "Landroid/widget/ImageView;", "getBadge$topic_debug", "()Landroid/widget/ImageView;", "setBadge$topic_debug", "(Landroid/widget/ImageView;)V", "topic", "Ltv/danmaku/bili/ui/topic/api/BiliTopic;", "getTopic$topic_debug", "()Ltv/danmaku/bili/ui/topic/api/BiliTopic;", "setTopic$topic_debug", "(Ltv/danmaku/bili/ui/topic/api/BiliTopic;)V", "onClick", "", "v", "bind", "data", "", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ActivityViewHolder extends BaseViewHolder implements View.OnClickListener {
    private ImageView badge;
    private ScalableImageView2 cover;
    private TextView title;
    private BiliTopic topic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.title = (TextView) findViewById;
        ScalableImageView2 findViewById2 = itemView.findViewById(R.id.cover);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.bilibili.lib.image2.view.legacy.ScalableImageView2");
        this.cover = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.badge);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.badge = (ImageView) findViewById3;
        itemView.setOnClickListener(this);
    }

    public final TextView getTitle$topic_debug() {
        return this.title;
    }

    public final void setTitle$topic_debug(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.title = textView;
    }

    public final ScalableImageView2 getCover$topic_debug() {
        return this.cover;
    }

    public final void setCover$topic_debug(ScalableImageView2 scalableImageView2) {
        Intrinsics.checkNotNullParameter(scalableImageView2, "<set-?>");
        this.cover = scalableImageView2;
    }

    public final ImageView getBadge$topic_debug() {
        return this.badge;
    }

    public final void setBadge$topic_debug(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.badge = imageView;
    }

    public final BiliTopic getTopic$topic_debug() {
        return this.topic;
    }

    public final void setTopic$topic_debug(BiliTopic biliTopic) {
        this.topic = biliTopic;
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
                Uri build = Uri.parse($this$onClick_u24lambda_u241.link).buildUpon().appendQueryParameter("from_spmid", "activity.activity-center.0.0").build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                Context context = v.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                RouteKt.openRoute$default(build, context, false, 2, null);
                this.badge.setVisibility(0);
            }
        }
    }

    @Override // tv.danmaku.bili.ui.topic.BaseViewHolder
    public void bind(Object data) {
        int i;
        BiliTopic $this$bind_u24lambda_u240 = null;
        BiliTopic biliTopic = data instanceof BiliTopic ? (BiliTopic) data : null;
        if (biliTopic != null) {
            BiliTopic $this$bind_u24lambda_u2402 = biliTopic;
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            biliImageLoader.with(context).url($this$bind_u24lambda_u2402.cover).into(this.cover);
            this.title.setText($this$bind_u24lambda_u2402.title);
            this.badge.setVisibility(0);
            ImageView imageView = this.badge;
            switch ($this$bind_u24lambda_u2402.state) {
                case -1:
                    i = R.drawable.ic_badge_preparing;
                    break;
                case 0:
                    i = R.drawable.ic_badge_going;
                    break;
                default:
                    i = R.drawable.ic_badge_end;
                    break;
            }
            imageView.setBackgroundResource(i);
            $this$bind_u24lambda_u240 = biliTopic;
        }
        this.topic = $this$bind_u24lambda_u240;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActivityViewHolder(ViewGroup parent) {
        this(r0);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_activity_promo, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
    }
}