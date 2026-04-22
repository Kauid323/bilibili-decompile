package tv.danmaku.bili.appwidget.guide;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bapis.bilibili.app.show.mixture.v1.GuideCard;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: SwipeImageWithTitleAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/ImageWithTitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "imageView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "getImageView", "()Lcom/bilibili/lib/image2/view/BiliImageView;", ReportUtilKt.POS_TITLE, "Lcom/bilibili/magicasakura/widgets/TintTextView;", "getTitle", "()Lcom/bilibili/magicasakura/widgets/TintTextView;", "bind", "", "item", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideCard;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageWithTitleHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final BiliImageView imageView;
    private final View itemView;
    private final TintTextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithTitleHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.itemView = itemView;
        BiliImageView findViewById = this.itemView.findViewById(R.id.iv_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.imageView = findViewById;
        TintTextView findViewById2 = this.itemView.findViewById(R.id.describe);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.title = findViewById2;
    }

    public final View getItemView() {
        return this.itemView;
    }

    public final BiliImageView getImageView() {
        return this.imageView;
    }

    public final TintTextView getTitle() {
        return this.title;
    }

    public final void bind(GuideCard item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder with = biliImageLoader.with(context);
        ScaleType scaleType = ScaleType.CENTER_CROP;
        Intrinsics.checkNotNullExpressionValue(scaleType, "CENTER_CROP");
        ImageRequestBuilder url = with.actualImageScaleType(scaleType).url(item.getImage());
        ScaleType scaleType2 = ScaleType.CENTER_CROP;
        Intrinsics.checkNotNullExpressionValue(scaleType2, "CENTER_CROP");
        url.actualImageScaleType(scaleType2).into(this.imageView);
        String subtitle = item.getSubtitle();
        if (!(subtitle == null || StringsKt.isBlank(subtitle))) {
            this.title.setVisibility(0);
            this.title.setText(item.getSubtitle());
        }
    }
}