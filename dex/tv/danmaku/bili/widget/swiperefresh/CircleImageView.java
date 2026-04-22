package tv.danmaku.bili.widget.swiperefresh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.view.BiliImageView;

public class CircleImageView extends BiliImageView {
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private int[] mColorSchemeColors;
    private Animation.AnimationListener mListener;
    AbsProgressDrawable mProgress;
    private int mProgressAlpha;
    int mShadowRadius;
    private int mStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public CircleImageView(Context context) {
        super(context);
        ShapeDrawable circle;
        this.mStyle = 0;
        this.mProgressAlpha = 255;
        float density = getContext().getResources().getDisplayMetrics().density;
        int shadowYOffset = (int) (Y_OFFSET * density);
        int shadowXOffset = (int) (0.0f * density);
        this.mShadowRadius = (int) (SHADOW_RADIUS * density);
        if (elevationSupported()) {
            circle = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, 4.0f * density);
        } else {
            OvalShape oval = new OvalShadow(this.mShadowRadius);
            ShapeDrawable circle2 = new ShapeDrawable(oval);
            setLayerType(1, circle2.getPaint());
            circle2.getPaint().setShadowLayer(this.mShadowRadius, shadowXOffset, shadowYOffset, KEY_SHADOW_COLOR);
            int padding = this.mShadowRadius;
            setPadding(padding, padding, padding, padding);
            circle = circle2;
        }
        circle.getPaint().setColor(CIRCLE_BG_LIGHT);
        ViewCompat.setBackground(this, circle);
        setDefaultStyleInner();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDefaultStyle() {
        if (this.mStyle != 0) {
            setDefaultStyleInner();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void setDefaultStyleInner() {
        if (this.mProgress != null) {
            this.mProgress.stop();
        }
        this.mStyle = 0;
        this.mProgress = new MaterialProgressDrawable(getContext(), this);
        this.mProgress.setBackgroundColor(CIRCLE_BG_LIGHT);
        syncProgressData();
        setImageDrawable((Drawable) this.mProgress);
        requestLayout();
        adjustPadding();
    }

    private void syncProgressData() {
        if (this.mColorSchemeColors != null) {
            this.mProgress.setColorSchemeColors(this.mColorSchemeColors);
        }
        this.mProgress.setProgressAlpha(this.mProgressAlpha);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomImageStyle(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (this.mProgress != null) {
                this.mProgress.stop();
            }
            this.mStyle = 1;
            syncProgressData();
            requestLayout();
            adjustPadding();
            this.mProgress = new CustomProgressDrawable();
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setRoundAsCircle(true);
            BiliImageLoader.INSTANCE.with(getContext()).roundingParams(roundingParams).url(url).enableAutoPlayAnimation(true).placeholderImageDrawable(new ColorDrawable(-1)).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.widget.swiperefresh.CircleImageView.1
                public /* synthetic */ void onImageLoading(Uri uri) {
                    ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                }

                public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                }

                public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                }

                public void onImageLoadFailed(Throwable err) {
                    CircleImageView.this.setDefaultStyle();
                }

                public void onImageSet(ImageInfo imageInfo) {
                    if (imageInfo != null && (CircleImageView.this.mProgress instanceof CustomProgressDrawable)) {
                        ((CustomProgressDrawable) CircleImageView.this.mProgress).setImageInfo(imageInfo);
                    } else {
                        CircleImageView.this.setDefaultStyle();
                    }
                }
            }).into(this);
        }
    }

    private void adjustPadding() {
        if (!elevationSupported()) {
            if (this.mStyle == 0) {
                setPadding(this.mShadowRadius, this.mShadowRadius, this.mShadowRadius, this.mShadowRadius);
            } else {
                setPadding(0, 0, 0, 0);
            }
        }
    }

    public int getStyle() {
        return this.mStyle;
    }

    private boolean elevationSupported() {
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = (int) ((getStyle() == 0 ? 40 : 56) * getResources().getDisplayMetrics().density);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        if (!elevationSupported() && this.mStyle == 0) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener listener) {
        this.mListener = listener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.mListener != null) {
            this.mListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.mListener != null) {
            this.mListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColorRes(int colorRes) {
        setBackgroundColor(ContextCompat.getColor(getContext(), colorRes));
    }

    public void onSpinnerMove() {
        this.mProgress.onSpinnerMove();
    }

    public void onFinishSpinner() {
        this.mProgress.onFinishSpinner();
    }

    public void onDragPercentChange(float adjustedPercent, float tensionPercent) {
        this.mProgress.onDragPercentChange(adjustedPercent, tensionPercent);
    }

    public void onAnimateToCorrectPosition(float interpolatedTime) {
        this.mProgress.onAnimateToCorrectPosition(interpolatedTime);
    }

    public void onRefreshCancel() {
        this.mProgress.onRefreshCancel();
    }

    public void setBackgroundColor(int color) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(color);
        }
    }

    public void setColorSchemeColors(int... colors) {
        this.mColorSchemeColors = colors;
        this.mProgress.setColorSchemeColors(colors);
    }

    public void setProgressAlpha(int alpha) {
        this.mProgressAlpha = alpha;
        this.mProgress.setProgressAlpha(alpha);
    }

    public int getProgressAlpha() {
        return this.mProgress.getProgressAlpha();
    }

    public void start() {
        this.mProgress.start();
    }

    public void stop() {
        this.mProgress.stop();
    }

    public boolean isRunning() {
        return this.mProgress.isRunning();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();

        OvalShadow(int shadowRadius) {
            CircleImageView.this.mShadowRadius = shadowRadius;
            updateRadialGradient((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float width, float height) {
            super.onResize(width, height);
            updateRadialGradient((int) width);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int viewWidth = CircleImageView.this.getWidth();
            int viewHeight = CircleImageView.this.getHeight();
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, viewWidth / 2, this.mShadowPaint);
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, (viewWidth / 2) - CircleImageView.this.mShadowRadius, paint);
        }

        private void updateRadialGradient(int diameter) {
            this.mRadialGradient = new RadialGradient(diameter / 2, diameter / 2, CircleImageView.this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }
    }
}