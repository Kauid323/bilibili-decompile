package tv.danmaku.bili.widget.swiperefresh;

import com.bilibili.lib.image2.bean.AnimationInfo;
import com.bilibili.lib.image2.bean.BiliAnimatable;
import com.bilibili.lib.image2.bean.ImageInfo;

class CustomProgressDrawable implements AbsProgressDrawable {
    private ImageInfo mImageInfo;

    public void setImageInfo(ImageInfo imageInfo) {
        this.mImageInfo = imageInfo;
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void onSpinnerMove() {
        start();
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void onFinishSpinner() {
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void onDragPercentChange(float adjustedPercent, float tensionPercent) {
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void onAnimateToCorrectPosition(float interpolatedTime) {
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void onRefreshCancel() {
        AnimationInfo animateInfo = getAnimationInfo();
        if (animateInfo != null) {
            animateInfo.getAnimatable().stop();
        }
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void setBackgroundColor(int color) {
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void setColorSchemeColors(int... colors) {
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public void setProgressAlpha(int alpha) {
    }

    @Override // tv.danmaku.bili.widget.swiperefresh.AbsProgressDrawable
    public int getProgressAlpha() {
        return 255;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationInfo info = getAnimationInfo();
        BiliAnimatable animateInfo = info == null ? null : info.getAnimatable();
        if (animateInfo != null && !animateInfo.isRunning()) {
            animateInfo.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        AnimationInfo animateInfo = getAnimationInfo();
        if (animateInfo != null) {
            animateInfo.getAnimatable().stop();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        AnimationInfo animateInfo = getAnimationInfo();
        if (animateInfo != null) {
            return animateInfo.getAnimatable().isRunning();
        }
        return false;
    }

    private AnimationInfo getAnimationInfo() {
        if (this.mImageInfo != null) {
            return this.mImageInfo.getAnimateInfo();
        }
        return null;
    }
}