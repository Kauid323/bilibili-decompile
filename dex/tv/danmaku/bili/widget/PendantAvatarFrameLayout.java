package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.DefaultTransformStrategy;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.bean.StylingTransformStrategy;
import com.bilibili.lib.image2.bean.ThumbUrlTransformStrategyUtils;
import com.bilibili.lib.image2.common.thumbnail.size.OriginThumbnailSizeController;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.Tintable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class PendantAvatarFrameLayout extends TintFrameLayout implements Tintable {
    public static final int MODE_BIG_AVATAR = 1;
    public static final int MODE_LIVING = 3;
    public static final int MODE_PENDANT_AVATAR = 2;
    protected BiliImageView mAvatarImg;
    protected int mAvatarSquareSide;
    protected BiliImageView mBadgeImg;
    protected int mBadgeMargin;
    protected int mBadgeSquareSide;
    protected BiliImageView mBorderImg;
    protected int mLivingTextMarginTop;
    protected View mLivingView;
    protected int mLivingViewAnimationSize;
    protected View mLivingViewContainer;
    protected int mLivingViewHeight;
    protected int mLivingViewMarginTop;
    protected int mLivingViewTextSize;
    protected int mLivingViewWhiteStrokeWidth;
    protected int mLivingViewWidth;
    protected int mLivingWaveBeginRadius;
    protected int mLivingWaveEndRadius;
    protected int mLivingWaveStrokeWidth;
    protected int mPendantAvatarSquareSide;
    protected int mPendantBadgeMargin;
    protected int mPendantBadgeSquareSide;
    protected int mPendantSquareSide;
    protected BiliImageView mPendantView;
    protected ShowParams mShowParams;
    protected int mViewContainerSquareSide;
    protected LivingAvatarAnimationView mWaveFirstAnimationView;
    protected LivingAvatarAnimationView mWaveSecondAnimationView;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DynamicAvatarSize {
        public int avatarSquareSide;
        public int badgeMargin;
        public int badgeSquareSide;
        public int frameSquareSide;
        public int pAvatarSquareSide;
        public int pBadgeMargin;
        public int pBadgeSquareSide;
        public int pendantSquareSide;
    }

    public PendantAvatarFrameLayout(Context context) {
        this(context, null);
    }

    public ShowParams getShowParam() {
        return this.mShowParams;
    }

    public PendantAvatarFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PendantAvatarFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        setMeasuredDimension(widthMode == 1073741824 ? View.MeasureSpec.getSize(widthMeasureSpec) : this.mViewContainerSquareSide, heightMode == 1073741824 ? View.MeasureSpec.getSize(heightMeasureSpec) : this.mViewContainerSquareSide);
    }

    public void show(ShowParams showParams) {
        if (showParams != null) {
            this.mShowParams = showParams;
            DynamicAvatarSize avatarSize = showParams.mDynamicAvatarSize;
            if (avatarSize != null) {
                this.mViewContainerSquareSide = avatarSize.frameSquareSide;
                this.mAvatarSquareSide = avatarSize.avatarSquareSide;
                this.mBadgeSquareSide = avatarSize.badgeSquareSide;
                this.mBadgeMargin = avatarSize.badgeMargin;
                this.mPendantAvatarSquareSide = avatarSize.pAvatarSquareSide;
                this.mBadgeSquareSide = avatarSize.pBadgeSquareSide;
                this.mPendantBadgeMargin = avatarSize.pBadgeMargin;
                this.mPendantSquareSide = avatarSize.pendantSquareSide;
            }
            updateAvatarImg();
            updateBadgeImg();
            updatePendantImg();
            updateLiving();
            updateWaveAnimation();
        }
    }

    public float getAvatarImgCenterX() {
        if (this.mAvatarImg == null) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        return this.mAvatarImg.getX() + (this.mAvatarImg.getWidth() / 2.0f);
    }

    private void updateWaveAnimation() {
        if (this.mShowParams.mMode == 3 && this.mShowParams.mLivingWaveAnimationEnable.booleanValue()) {
            addLivingAnimationView();
        } else {
            resetWaveView();
        }
    }

    private void updateLiving() {
        if (this.mShowParams.mMode != 3) {
            resetLivingStyle();
        } else {
            this.mLivingView.setVisibility(0);
        }
    }

    private void initLivingView() {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mLivingView.getLayoutParams();
        lp.width = this.mLivingViewWidth;
        lp.height = this.mLivingViewHeight;
        lp.topMargin = this.mLivingViewMarginTop;
        lp.gravity = 1;
        TextView textView = (TextView) this.mLivingView.findViewById(com.bilibili.lib.widget.R.id.text);
        textView.setTextSize(0, this.mLivingViewTextSize);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = this.mLivingTextMarginTop;
        textView.setLayoutParams(marginLayoutParams);
        View animationView = this.mLivingView.findViewById(com.bilibili.lib.widget.R.id.animation);
        ViewGroup.LayoutParams animationViewLayoutParams = animationView.getLayoutParams();
        animationViewLayoutParams.width = this.mLivingViewAnimationSize;
        animationViewLayoutParams.height = this.mLivingViewAnimationSize;
        animationView.requestLayout();
        Drawable drawable = ContextCompat.getDrawable(getContext(), com.bilibili.lib.widget.R.drawable.bili_shape_avatar_bg_text_living);
        if (drawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setStroke(this.mLivingViewWhiteStrokeWidth, getResources().getColor(com.bilibili.lib.theme.R.color.Wh0_u));
            this.mLivingViewContainer.setBackground(gradientDrawable);
        }
    }

    private void addLivingAnimationView() {
        this.mWaveSecondAnimationView.update(this.mLivingWaveStrokeWidth, this.mLivingWaveBeginRadius, this.mLivingWaveEndRadius);
        this.mWaveFirstAnimationView.update(this.mLivingWaveStrokeWidth, this.mLivingWaveBeginRadius, this.mLivingWaveEndRadius);
        this.mWaveFirstAnimationView.setRepeat(true);
        this.mWaveFirstAnimationView.setOnAnimationStartListener(new LivingAvatarAnimationView.OnAnimationStartListener() { // from class: tv.danmaku.bili.widget.PendantAvatarFrameLayout$$ExternalSyntheticLambda0
            @Override // tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.OnAnimationStartListener
            public final void onStart() {
                PendantAvatarFrameLayout.this.m2022lambda$addLivingAnimationView$0$tvdanmakubiliwidgetPendantAvatarFrameLayout();
            }
        });
        this.mWaveFirstAnimationView.startAnimation();
        this.mWaveFirstAnimationView.setVisibility(0);
        this.mWaveSecondAnimationView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$addLivingAnimationView$0$tv-danmaku-bili-widget-PendantAvatarFrameLayout  reason: not valid java name */
    public /* synthetic */ void m2022lambda$addLivingAnimationView$0$tvdanmakubiliwidgetPendantAvatarFrameLayout() {
        this.mWaveSecondAnimationView.startAnimation(500L);
    }

    private void resetLivingStyle() {
        if (this.mLivingView != null) {
            this.mLivingView.setVisibility(8);
        }
        resetWaveView();
    }

    private void resetWaveView() {
        this.mWaveFirstAnimationView.setVisibility(8);
        this.mWaveSecondAnimationView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), com.bilibili.lib.widget.R.layout.bili_app_layout_avatar, this);
        this.mAvatarImg = findViewById(com.bilibili.lib.widget.R.id.avatar_image);
        this.mBorderImg = findViewById(com.bilibili.lib.widget.R.id.border_image);
        this.mPendantView = findViewById(com.bilibili.lib.widget.R.id.pendant_image);
        this.mBadgeImg = findViewById(com.bilibili.lib.widget.R.id.badge_image);
        this.mLivingView = findViewById(com.bilibili.lib.widget.R.id.living_view);
        this.mWaveFirstAnimationView = (LivingAvatarAnimationView) findViewById(com.bilibili.lib.widget.R.id.first_animation);
        this.mWaveSecondAnimationView = (LivingAvatarAnimationView) findViewById(com.bilibili.lib.widget.R.id.second_animation);
        this.mLivingViewContainer = findViewById(com.bilibili.lib.widget.R.id.living_view_container);
        setClipChildren(false);
        extractAvatarSpecBundle(context, attrs);
        initLivingView();
    }

    private void extractAvatarSpecBundle(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout, 0, com.bilibili.lib.widget.R.style.PendantAvatarStyleSpec_DEFAULT);
        this.mViewContainerSquareSide = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_frameSquareSide, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mAvatarSquareSide = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_avatarSquareSide, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mBadgeMargin = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_badgeMargin, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mBadgeSquareSide = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_badgeSquareSide, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mPendantAvatarSquareSide = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_pAvatarSquareSide, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mPendantBadgeMargin = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_pBadgeMargin, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mPendantBadgeSquareSide = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_pBadgeSquareSide, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mPendantSquareSide = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_pendantSquareSide, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mLivingViewAnimationSize = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingViewAnimationSize, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mLivingViewTextSize = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingViewTextSize, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mLivingViewHeight = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingViewHeight, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mLivingViewWidth = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingViewWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mLivingViewMarginTop = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingViewMarginTop, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mLivingWaveBeginRadius = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingWaveBeginRadius, this.mAvatarSquareSide);
        this.mLivingWaveEndRadius = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingWaveEndRadius, this.mAvatarSquareSide * 1.3f);
        this.mLivingWaveStrokeWidth = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingWaveStrokeWidth, dp2px(getContext(), 2.0f));
        this.mLivingViewWhiteStrokeWidth = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingViewWhiteStrokeSize, dp2px(getContext(), 2.0f));
        this.mLivingTextMarginTop = (int) ta.getDimension(com.bilibili.lib.widget.R.styleable.PendantAvatarFrameLayout_livingTextMarginTop, dp2px(getContext(), 1.0f));
        ta.recycle();
    }

    private int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dpValue * scale) + 0.5f);
    }

    protected void updateAvatarImg() {
        FrameLayout.LayoutParams avatarLp;
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(true);
        ImageRequestBuilder avatarRequestBuilder = BiliImageLoader.INSTANCE.with(getContext()).roundingParams(roundingParams);
        switch (this.mShowParams.mMode) {
            case 1:
                avatarLp = new FrameLayout.LayoutParams(this.mAvatarSquareSide, this.mAvatarSquareSide);
                if (this.mShowParams.mBorderWidth != null) {
                    int width = dp2px(getContext(), this.mShowParams.mBorderWidth.floatValue() * 2.0f);
                    FrameLayout.LayoutParams borderLp = new FrameLayout.LayoutParams(this.mAvatarSquareSide + width, this.mAvatarSquareSide + width);
                    borderLp.gravity = 17;
                    this.mBorderImg.setLayoutParams(borderLp);
                    this.mBorderImg.setBackground(getBigAvatarBorderDrawable());
                    this.mBorderImg.setVisibility(0);
                    break;
                } else {
                    hideBorderView();
                    break;
                }
            case 2:
            default:
                avatarLp = new FrameLayout.LayoutParams(this.mPendantAvatarSquareSide, this.mPendantAvatarSquareSide);
                hideBorderView();
                break;
            case 3:
                avatarLp = new FrameLayout.LayoutParams(this.mAvatarSquareSide, this.mAvatarSquareSide);
                if (this.mShowParams.mBorderWidth != null) {
                    int width2 = dp2px(getContext(), this.mShowParams.mBorderWidth.floatValue() * 4.0f);
                    FrameLayout.LayoutParams borderLp2 = new FrameLayout.LayoutParams(this.mAvatarSquareSide + width2, this.mAvatarSquareSide + width2);
                    borderLp2.gravity = 17;
                    this.mBorderImg.setLayoutParams(borderLp2);
                    this.mBorderImg.setBackground(getLivingAvatarBorderDrawable());
                    this.mBorderImg.setVisibility(0);
                    break;
                } else {
                    hideBorderView();
                    break;
                }
        }
        avatarLp.gravity = 17;
        this.mAvatarImg.setLayoutParams(avatarLp);
        if (Boolean.TRUE == ConfigManager.ab().get("avatar_style_enable", false)) {
            StylingTransformStrategy stylingTransformStrategy = ThumbUrlTransformStrategyUtils.stylingStrategy("widget-android-avatar");
            if (this.mShowParams.mAvatarForceFirstFrame.booleanValue()) {
                stylingTransformStrategy.forceFirstFrame();
            }
            avatarRequestBuilder.thumbnailUrlTransformStrategy(stylingTransformStrategy);
        } else {
            DefaultTransformStrategy defaultTransformStrategy = ThumbUrlTransformStrategyUtils.defaultStrategy();
            defaultTransformStrategy.setThumbnailSizeController(new OriginThumbnailSizeController(getContext().getClass().getName() + "-avatar-img"));
            if (this.mShowParams.mAvatarForceFirstFrame.booleanValue()) {
                defaultTransformStrategy.forceFirstFrame();
            }
            avatarRequestBuilder.thumbnailUrlTransformStrategy(defaultTransformStrategy);
        }
        avatarRequestBuilder.enableAutoPlayAnimation(this.mShowParams.mAutoPlayAvatarAnimation.booleanValue());
        roundingParams.setRoundAsCircle(true);
        int defaultAvatarRes = 0;
        if (this.mShowParams.mDefaultAvatarRes != null) {
            defaultAvatarRes = this.mShowParams.mDefaultAvatarRes.intValue();
            avatarRequestBuilder.placeholderImageResId(defaultAvatarRes);
        }
        if (!TextUtils.isEmpty(this.mShowParams.mAvatarImgUrl)) {
            avatarRequestBuilder.placeholderImageResId(defaultAvatarRes);
            avatarRequestBuilder.url(this.mShowParams.mAvatarImgUrl).into(this.mAvatarImg);
        } else if (this.mShowParams.mAvatarRes != null) {
            avatarRequestBuilder.placeholderImageResId(this.mShowParams.mAvatarRes.intValue());
            avatarRequestBuilder.into(this.mAvatarImg);
        } else {
            avatarRequestBuilder.placeholderImageResId(defaultAvatarRes);
            avatarRequestBuilder.into(this.mAvatarImg);
        }
    }

    private void hideBorderView() {
        if (this.mBorderImg != null) {
            this.mBorderImg.setVisibility(8);
        }
    }

    private Drawable getBigAvatarBorderDrawable() {
        if (this.mShowParams != null && this.mShowParams.mBorderWidth != null) {
            int width = dp2px(getContext(), this.mShowParams.mBorderWidth.floatValue());
            int color = ThemeUtils.getColorById(getContext(), this.mShowParams.mBorderColor.intValue(), getViewThemeId());
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(1);
            drawable.setStroke(width, color);
            return drawable;
        }
        return null;
    }

    private Drawable getLivingAvatarBorderDrawable() {
        if (this.mShowParams != null && this.mShowParams.mBorderWidth != null) {
            int width = dp2px(getContext(), this.mShowParams.mBorderWidth.floatValue());
            int colorInner = ThemeUtils.getColorById(getContext(), com.bilibili.lib.theme.R.color.Wh0_u);
            int colorOutter = ThemeUtils.getColorById(getContext(), com.bilibili.lib.theme.R.color.main_Pi5, getViewThemeId());
            LayerDrawable drawable = (LayerDrawable) ContextCompat.getDrawable(getContext(), com.bilibili.lib.widget.R.drawable.shape_avatar_bg_living_gif);
            if (drawable != null) {
                LayerDrawable drawable2 = (LayerDrawable) drawable.mutate();
                GradientDrawable out = (GradientDrawable) drawable2.findDrawableByLayerId(com.bilibili.lib.widget.R.id.outer_drawable).mutate();
                GradientDrawable in = (GradientDrawable) drawable2.findDrawableByLayerId(com.bilibili.lib.widget.R.id.inner_drawable).mutate();
                out.setStroke(width, colorOutter);
                in.setStroke(width, colorInner);
                try {
                    drawable2.setLayerInset(1, width, width, width, width);
                } catch (Exception e) {
                }
                return drawable2;
            }
            return drawable;
        }
        return null;
    }

    protected void updatePendantImg() {
        switch (this.mShowParams.mMode) {
            case 1:
            case 3:
                if (this.mPendantView != null) {
                    this.mPendantView.setVisibility(8);
                    return;
                }
                return;
            case 2:
                FrameLayout.LayoutParams pendantLp = new FrameLayout.LayoutParams(this.mPendantSquareSide, this.mPendantSquareSide);
                pendantLp.gravity = 17;
                this.mPendantView.setLayoutParams(pendantLp);
                DefaultTransformStrategy defaultTransformStrategy = ThumbUrlTransformStrategyUtils.defaultStrategy();
                defaultTransformStrategy.setThumbnailSizeController(new OriginThumbnailSizeController(getContext().getClass().getName() + "-avatar-pendant"));
                BiliImageLoader.INSTANCE.with(this.mPendantView.getContext()).url(this.mShowParams.mPendantImgUrl).thumbnailUrlTransformStrategy(defaultTransformStrategy).enableAutoPlayAnimation(this.mShowParams.mAutoPlayPendantAnimation.booleanValue()).into(this.mPendantView);
                if (this.mShowParams.mPendantRes != null) {
                    this.mPendantView.setImageResource(this.mShowParams.mPendantRes.intValue());
                }
                this.mPendantView.setVisibility(0);
                return;
            default:
                return;
        }
    }

    private void updateBadgeImg() {
        FrameLayout.LayoutParams badgeLp;
        int badgeMargin;
        if (this.mShowParams.mMode == 3) {
            if (this.mBadgeImg != null) {
                this.mBadgeImg.setVisibility(8);
            }
        } else if (this.mShowParams.mIsBadgeShow != null && this.mShowParams.mIsBadgeShow.booleanValue() && (this.mShowParams.mBadgeImgRes != null || !TextUtils.isEmpty(this.mShowParams.mBadgeImgUrl))) {
            switch (this.mShowParams.mMode) {
                case 1:
                    badgeLp = new FrameLayout.LayoutParams(this.mBadgeSquareSide, this.mBadgeSquareSide);
                    badgeMargin = this.mBadgeMargin;
                    break;
                default:
                    badgeLp = new FrameLayout.LayoutParams(this.mPendantBadgeSquareSide, this.mPendantBadgeSquareSide);
                    badgeMargin = this.mPendantBadgeMargin;
                    break;
            }
            badgeLp.gravity = 8388693;
            badgeLp.rightMargin = badgeMargin;
            badgeLp.bottomMargin = badgeMargin;
            this.mBadgeImg.setLayoutParams(badgeLp);
            if (!TextUtils.isEmpty(this.mShowParams.mBadgeImgUrl)) {
                BiliImageLoader.INSTANCE.with(this.mBadgeImg.getContext()).url(this.mShowParams.mBadgeImgUrl).into(this.mBadgeImg);
            } else {
                this.mBadgeImg.setImageResource(this.mShowParams.mBadgeImgRes.intValue());
            }
            this.mBadgeImg.setVisibility(0);
        } else if (this.mBadgeImg != null) {
            this.mBadgeImg.setVisibility(8);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mShowParams != null && this.mShowParams.mMode == 3 && this.mShowParams.mLivingWaveAnimationEnable.booleanValue()) {
            addLivingAnimationView();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mWaveFirstAnimationView.stopAnimation();
        this.mWaveSecondAnimationView.stopAnimation();
        this.mWaveFirstAnimationView.setVisibility(8);
        this.mWaveSecondAnimationView.setVisibility(8);
    }

    public void tint() {
        show(this.mShowParams);
        if (this.mPendantView != null) {
            this.mPendantView.setColorFilter(getResources().getColor(com.bilibili.lib.widget.R.color.auto_night_shade));
        }
    }

    public ShowParams getShowParams() {
        return this.mShowParams;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class ShowParams {
        public String mAvatarImgUrl;
        public Integer mAvatarRes;
        public Integer mBadgeImgRes;
        public String mBadgeImgUrl;
        public Integer mBorderColor;
        public Float mBorderWidth;
        public Integer mDefaultAvatarRes;
        public Boolean mIsBadgeShow;
        public String mPendantImgUrl;
        public Integer mPendantRes;
        public Boolean mAutoPlayPendantAnimation = true;
        private Boolean mAutoPlayAvatarAnimation = false;
        private Boolean mAvatarForceFirstFrame = false;
        private Boolean mLivingWaveAnimationEnable = false;
        private DynamicAvatarSize mDynamicAvatarSize = null;
        private int mMode = 1;

        @Target({ElementType.PARAMETER})
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public @interface SHOW_MODE {
        }

        public ShowParams avatarImgUrl(String avatarImgUrl) {
            this.mAvatarImgUrl = avatarImgUrl;
            return this;
        }

        public ShowParams pendantImgUrl(String pendantImgUrl) {
            if (!TextUtils.isEmpty(pendantImgUrl)) {
                this.mMode = 2;
                this.mPendantImgUrl = pendantImgUrl;
            }
            return this;
        }

        public ShowParams setAvatarForceFirstFrame(Boolean avatarForceFirstFrame) {
            this.mAvatarForceFirstFrame = avatarForceFirstFrame;
            return this;
        }

        public ShowParams setAutoPlayAvatarAnimation(Boolean autoPlayAvatarAnimation) {
            this.mAutoPlayAvatarAnimation = autoPlayAvatarAnimation;
            return this;
        }

        public ShowParams setLivingWaveAnimationEnable(Boolean livingWaveAnimationEnable) {
            this.mLivingWaveAnimationEnable = livingWaveAnimationEnable;
            return this;
        }

        public ShowParams avatarRes(int avatarRes) {
            if (avatarRes != 0) {
                this.mAvatarRes = Integer.valueOf(avatarRes);
            }
            return this;
        }

        public ShowParams pendantRes(Integer pendantRes) {
            if (pendantRes != null) {
                this.mMode = 2;
                this.mPendantRes = pendantRes;
            }
            return this;
        }

        public ShowParams badgeImgRes(int badgeImgRes) {
            if (badgeImgRes != 0) {
                this.mBadgeImgRes = Integer.valueOf(badgeImgRes);
                this.mIsBadgeShow = true;
            }
            return this;
        }

        public ShowParams badgeImgUrl(String badgeUrl) {
            if (!TextUtils.isEmpty(badgeUrl)) {
                this.mBadgeImgUrl = badgeUrl;
                this.mIsBadgeShow = true;
            }
            return this;
        }

        public ShowParams badgeShow(boolean badgeShow) {
            this.mIsBadgeShow = Boolean.valueOf(badgeShow);
            return this;
        }

        public ShowParams mode(int mode) {
            if (mode == 1 || mode == 2 || mode == 3) {
                this.mMode = mode;
            }
            return this;
        }

        public ShowParams borderColor(int borderColor) {
            this.mBorderColor = Integer.valueOf(borderColor);
            return this;
        }

        public ShowParams borderWidth(float borderWidth) {
            this.mBorderWidth = Float.valueOf(borderWidth);
            return this;
        }

        public ShowParams antoPlayPendantAnimation(boolean auto) {
            this.mAutoPlayPendantAnimation = Boolean.valueOf(auto);
            return this;
        }

        public ShowParams defaultAvatar(int defaultAvatarRes) {
            this.mDefaultAvatarRes = Integer.valueOf(defaultAvatarRes);
            return this;
        }

        public ShowParams dynamicAvatarSize(DynamicAvatarSize dynamicAvatarSize) {
            this.mDynamicAvatarSize = dynamicAvatarSize;
            return this;
        }
    }
}