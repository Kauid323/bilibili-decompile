package tv.danmaku.bili.widget.ratingbar;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class RatingView extends FrameLayout {
    private ImageView mEmptyView;
    private ImageView mFilledView;

    public RatingView(Context context) {
        this(context, null);
    }

    public RatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mFilledView = new TintImageView(getContext());
        this.mFilledView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mEmptyView = new TintImageView(getContext());
        this.mEmptyView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.mFilledView);
        addView(this.mEmptyView);
    }

    public void setFilledDrawable(Drawable drawable, int tintColor) {
        if (tintColor != 0) {
            drawable = ThemeUtils.tintDrawableByColorId(getContext(), drawable, tintColor);
        }
        Drawable newDrawable = drawable.getConstantState() == null ? null : drawable.getConstantState().newDrawable();
        ClipDrawable clipDrawable = new ClipDrawable(newDrawable == null ? drawable : newDrawable, 8388611, 1);
        this.mFilledView.setImageDrawable(clipDrawable);
    }

    public void setEmptyDrawable(Drawable drawable, int tintColor) {
        if (tintColor != 0) {
            drawable = ThemeUtils.tintDrawableByColorId(getContext(), drawable, tintColor);
        }
        Drawable newDrawable = drawable.getConstantState() == null ? null : drawable.getConstantState().newDrawable();
        ClipDrawable clipDrawable = new ClipDrawable(newDrawable == null ? drawable : newDrawable, 8388613, 1);
        this.mEmptyView.setImageDrawable(clipDrawable);
    }

    public void setSize(int pixel) {
        FrameLayout.LayoutParams mEmptyViewLayoutParams = (FrameLayout.LayoutParams) this.mEmptyView.getLayoutParams();
        mEmptyViewLayoutParams.height = pixel;
        mEmptyViewLayoutParams.width = pixel;
        this.mEmptyView.setLayoutParams(mEmptyViewLayoutParams);
        FrameLayout.LayoutParams mFilledViewLayoutParams = (FrameLayout.LayoutParams) this.mFilledView.getLayoutParams();
        mFilledViewLayoutParams.height = pixel;
        mFilledViewLayoutParams.width = pixel;
        this.mEmptyView.setLayoutParams(mFilledViewLayoutParams);
    }

    public void setFilled() {
        setPartialFilled(1.0f);
    }

    public void setPartialFilled(float percentage) {
        int level = (int) (10000.0f * percentage);
        this.mFilledView.getDrawable().setLevel(level);
        this.mEmptyView.getDrawable().setLevel(10000 - level);
    }

    public void setEmpty() {
        setPartialFilled(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }
}