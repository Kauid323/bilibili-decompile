package tv.danmaku.bili.push.pushsetting.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: PushSettingOptionAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/ui/adapter/PushSettingOptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/view/View;", "isLarge", "", "<init>", "(Landroid/view/View;Z)V", "getContainer", "()Landroid/view/View;", "tvItemTitle", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "getTvItemTitle", "()Lcom/bilibili/magicasakura/widgets/TintTextView;", "setTvItemTitle", "(Lcom/bilibili/magicasakura/widgets/TintTextView;)V", "ivSelect", "Lcom/bilibili/lib/image2/view/BiliImageView;", "getIvSelect", "()Lcom/bilibili/lib/image2/view/BiliImageView;", "setIvSelect", "(Lcom/bilibili/lib/image2/view/BiliImageView;)V", AppConfig.HOST_TAG, "getTag", "setTag", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingOptionViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final View container;
    private BiliImageView ivSelect;
    private TintTextView tag;
    private TintTextView tvItemTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSettingOptionViewHolder(View container, boolean isLarge) {
        super(container);
        ViewGroup.LayoutParams $this$_init__u24lambda_u240;
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this.tvItemTitle = this.container.findViewById(R.id.tv_item_title);
        this.ivSelect = this.container.findViewById(R.id.iv_select);
        this.tag = this.container.findViewById(R.id.tag);
        TintTextView tintTextView = this.tvItemTitle;
        if (tintTextView != null) {
            tintTextView.setTextSize(isLarge ? 16.0f : 14.0f);
        }
        int iconSize = ListExtentionsKt.toPx(isLarge ? 26 : 20);
        BiliImageView biliImageView = this.ivSelect;
        if (biliImageView != null) {
            BiliImageView biliImageView2 = this.ivSelect;
            if (biliImageView2 == null || ($this$_init__u24lambda_u240 = biliImageView2.getLayoutParams()) == null) {
                $this$_init__u24lambda_u240 = null;
            } else {
                $this$_init__u24lambda_u240.width = iconSize;
                $this$_init__u24lambda_u240.height = iconSize;
            }
            biliImageView.setLayoutParams($this$_init__u24lambda_u240);
        }
    }

    public final View getContainer() {
        return this.container;
    }

    public final TintTextView getTvItemTitle() {
        return this.tvItemTitle;
    }

    public final void setTvItemTitle(TintTextView tintTextView) {
        this.tvItemTitle = tintTextView;
    }

    public final BiliImageView getIvSelect() {
        return this.ivSelect;
    }

    public final void setIvSelect(BiliImageView biliImageView) {
        this.ivSelect = biliImageView;
    }

    public final TintTextView getTag() {
        return this.tag;
    }

    public final void setTag(TintTextView tintTextView) {
        this.tag = tintTextView;
    }
}