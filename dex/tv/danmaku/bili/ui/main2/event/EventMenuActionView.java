package tv.danmaku.bili.ui.main2.event;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.homepage.widget.MenuActionView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.magicasakura.utils.ThemeUtils;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.DisplayUtils;

public class EventMenuActionView extends MenuActionView {
    private boolean mHasInitAnim;
    private MenuActionView.UpdateAnim updateAnim;
    public static final int SIZE = DisplayUtils.dp2Px(30);
    private static final int MARGIN = DisplayUtils.dp2Px(7);
    public static final int TOTAL_SIZE = SIZE + (MARGIN * 2);

    public EventMenuActionView(Context context) {
        super(context);
        this.mHasInitAnim = false;
        this.updateAnim = null;
    }

    public EventMenuActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHasInitAnim = false;
        this.updateAnim = null;
    }

    public EventMenuActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mHasInitAnim = false;
        this.updateAnim = null;
    }

    protected void setupViewParams() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mIcon.getLayoutParams();
        layoutParams.height = SIZE;
        layoutParams.width = SIZE;
        layoutParams.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
        this.mIcon.setLayoutParams(layoutParams);
        this.mAnimatorIcon.setLayoutParams(layoutParams);
        this.mLottieAnimationView.setLayoutParams(layoutParams);
    }

    public void cancelAnimators() {
        if (this.mLottieAnimationView != null) {
            this.mLottieAnimationView.cancelAnimation();
        }
        if (this.mImageViewAnimator != null) {
            this.mImageViewAnimator.removeAllUpdateListeners();
            this.mImageViewAnimator.removeAllListeners();
        }
        if (this.mScaleAnimator != null) {
            this.mScaleAnimator.removeAllUpdateListeners();
            this.mScaleAnimator.removeAllListeners();
        }
        if (this.mSvgaImageView != null && this.updateAnim != null && this.updateAnim.loop > 0) {
            this.mSvgaImageView.stopAnimation();
        }
    }

    public void startUpdateAnim(MenuActionView.UpdateAnim anim) {
        if (anim.anim == null && TextUtils.isEmpty(anim.svga)) {
            return;
        }
        if (!TextUtils.isEmpty(anim.svga)) {
            playSvgaAnimation(anim);
        } else if (anim.anim != null) {
            playLottieAnimation(anim);
        }
    }

    private void playLottieAnimation(MenuActionView.UpdateAnim anim) {
        this.updateAnim = anim;
        this.mIcon.setVisibility(8);
        this.mAnimatorIcon.setVisibility(8);
        this.mLottieAnimationView.setVisibility(0);
        if (!this.mHasInitAnim) {
            initAnim(anim);
            this.mHasInitAnim = true;
        }
        this.mLottieAnimationView.playAnimation();
    }

    private void initAnim(final MenuActionView.UpdateAnim anim) {
        this.mLottieAnimationView.setComposition(anim.anim);
        if (anim.loop == 0) {
            this.mLottieAnimationView.setRepeatCount((int) FlowControlConfig.RETRY_MAX_TIMES);
        }
        this.mLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuActionView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (!TextUtils.isEmpty(anim.iconLocalPath)) {
                    EventMenuActionView.this.mAnimatorIcon.setVisibility(0);
                    BLog.i("gxd", "onAnimationEnd from cache");
                    BiliImageLoader.INSTANCE.with(EventMenuActionView.this.mAnimatorIcon.getContext()).url(BusinessSplashDefine.FILE_URI_PREFIX + anim.iconLocalPath).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuActionView.1.1
                        public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                            ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                        }

                        public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                            ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                        }

                        public void onImageLoading(Uri imageUri) {
                        }

                        public void onImageSet(ImageInfo imageInfo) {
                            EventMenuActionView.this.mSvgaImageView.setVisibility(8);
                            EventMenuActionView.this.mAnimatorIcon.setVisibility(0);
                        }

                        public void onImageLoadFailed(Throwable err) {
                            EventMenuActionView.this.mIcon.setVisibility(0);
                            EventMenuActionView.this.mSvgaImageView.setVisibility(8);
                            EventMenuActionView.this.mAnimatorIcon.setVisibility(8);
                        }
                    }).into(EventMenuActionView.this.mAnimatorIcon);
                } else if (!TextUtils.isEmpty(anim.animIcon)) {
                    EventMenuActionView.this.mAnimatorIcon.setVisibility(0);
                    BiliImageLoader.INSTANCE.with(EventMenuActionView.this.mAnimatorIcon.getContext()).url(anim.animIcon).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuActionView.1.2
                        public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                            ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                        }

                        public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                            ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                        }

                        public void onImageLoading(Uri imageUri) {
                        }

                        public void onImageSet(ImageInfo imageInfo) {
                            EventMenuActionView.this.mLottieAnimationView.setVisibility(8);
                            EventMenuActionView.this.mAnimatorIcon.setVisibility(0);
                        }

                        public void onImageLoadFailed(Throwable err) {
                            EventMenuActionView.this.mIcon.setVisibility(0);
                            EventMenuActionView.this.mLottieAnimationView.setVisibility(8);
                            EventMenuActionView.this.mAnimatorIcon.setVisibility(8);
                        }
                    }).into(EventMenuActionView.this.mAnimatorIcon);
                } else {
                    EventMenuActionView.this.mLottieAnimationView.setVisibility(8);
                    EventMenuActionView.this.mAnimatorIcon.setVisibility(8);
                    EventMenuActionView.this.mIcon.setVisibility(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    public void loadIcon(String icon) {
        BiliImageLoader.INSTANCE.with(this.mContext).url(icon).thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(false)).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuActionView.2
            public /* synthetic */ void onImageLoading(Uri uri) {
                ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
            }

            public /* synthetic */ void onImageSet(ImageInfo imageInfo) {
                ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
            }

            public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
            }

            public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
            }

            public void onImageLoadFailed(Throwable err) {
                Drawable defaultDrawable = VectorDrawableCompat.create(EventMenuActionView.this.getResources(), R.drawable.ic_vector_action_menu_default, (Resources.Theme) null);
                Drawable tint = EventMenuActionView.this.tintIcon(defaultDrawable, ThemeUtils.getColorById(EventMenuActionView.this.getContext(), R.color.theme_color_primary_tr_icon));
                EventMenuActionView.this.mIcon.setImageDrawable(tint);
            }
        }).into(this.mIcon);
    }

    protected void onWindowFocusChangedInternal(boolean hasWindowFocus) {
    }

    public void setIconTintColorWithGarb(int iconTintColor) {
    }

    public void tint() {
    }
}