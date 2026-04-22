package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.theme.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SeasonCoverView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0014J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\rH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/SeasonCoverView;", "Lcom/bilibili/lib/image2/view/BiliImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSelected", "", "mSelectedForeground", "Landroid/graphics/drawable/GradientDrawable;", "onLayout", "", "changed", "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setSelected", "s", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SeasonCoverView extends BiliImageView {
    private boolean mSelected;
    private final GradientDrawable mSelectedForeground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeasonCoverView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelectedForeground = new GradientDrawable();
        GradientDrawable gradientDrawable = this.mSelectedForeground;
        int dp2Px = DisplayUtils.dp2Px(1.5f);
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        gradientDrawable.setStroke(dp2Px, context2.getResources().getColor(R.color.Pi5_u));
        this.mSelectedForeground.setCornerRadius(DisplayUtils.dp2Px(1.0f));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SeasonCoverView(Context context, AttributeSet attrs) {
        this(context, attrs, com.bilibili.lib.image.R.attr.scalableImageView);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeasonCoverView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mSelectedForeground = new GradientDrawable();
        GradientDrawable gradientDrawable = this.mSelectedForeground;
        int dp2Px = DisplayUtils.dp2Px(1.5f);
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        gradientDrawable.setStroke(dp2Px, context2.getResources().getColor(R.color.Pi5_u));
        this.mSelectedForeground.setCornerRadius(DisplayUtils.dp2Px(1.0f));
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mSelectedForeground.setBounds(0, 0, getWidth(), getHeight());
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mSelected) {
            this.mSelectedForeground.draw(canvas);
        }
    }

    public void setSelected(boolean s) {
        super.setSelected(s);
        this.mSelected = s;
        invalidate();
    }
}