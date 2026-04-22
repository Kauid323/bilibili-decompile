package tv.danmaku.bili.videopage.common.widget.span;

import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LottieTagSpan.kt */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/LottieTagSpan;", "Ltv/danmaku/bili/videopage/common/widget/span/ImageTagSpan;", "lottieUrl", "", "<init>", "(Ljava/lang/String;)V", "mUrl", "mImageResultListener", "tv/danmaku/bili/videopage/common/widget/span/LottieTagSpan$mImageResultListener$1", "Ltv/danmaku/bili/videopage/common/widget/span/LottieTagSpan$mImageResultListener$1;", "onDetach", "", "startAnim", "pauseAnim", "stopAnim", "clearAnim", "createLottieDrawable", "Landroid/graphics/drawable/Drawable;", "url", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LottieTagSpan extends ImageTagSpan {
    private final LottieTagSpan$mImageResultListener$1 mImageResultListener;
    private String mUrl;

    public LottieTagSpan(String lottieUrl) {
        super("", new ColorDrawable(0));
        this.mImageResultListener = new LottieTagSpan$mImageResultListener$1(this);
        this.mUrl = lottieUrl;
        setImageResultListener(this.mImageResultListener);
    }

    public void onDetach() {
        clearAnim();
        super.onDetach();
    }

    public final void startAnim() {
        Drawable drawable = getDrawable();
        LottieDrawable current = drawable != null ? drawable.getCurrent() : null;
        LottieDrawable current2 = current instanceof LottieDrawable ? current : null;
        if (current2 != null) {
            current2.playAnimation();
        }
    }

    public final void pauseAnim() {
        Drawable drawable = getDrawable();
        LottieDrawable current = drawable != null ? drawable.getCurrent() : null;
        LottieDrawable current2 = current instanceof LottieDrawable ? current : null;
        if (current2 != null) {
            current2.pauseAnimation();
        }
    }

    public final void stopAnim() {
        Drawable drawable = getDrawable();
        LottieDrawable current = drawable != null ? drawable.getCurrent() : null;
        LottieDrawable current2 = current instanceof LottieDrawable ? current : null;
        if (current2 != null) {
            current2.stop();
        }
    }

    private final void clearAnim() {
        Drawable drawable = getDrawable();
        LottieDrawable current = drawable != null ? drawable.getCurrent() : null;
        LottieDrawable current2 = current instanceof LottieDrawable ? current : null;
        if (current2 != null) {
            current2.clearComposition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable createLottieDrawable(String url) {
        Application context;
        if (url != null && (context = BiliContext.application()) != null) {
            LottieComposition lottieComposition = (LottieComposition) LottieCompositionFactory.fromUrlSync(context, url, String.valueOf(url.hashCode())).getValue();
            if (lottieComposition == null) {
                return new ColorDrawable(0);
            }
            Drawable lottieDrawable = new LottieDrawable();
            lottieDrawable.setComposition(lottieComposition);
            lottieDrawable.setRepeatCount(-1);
            return lottieDrawable;
        }
        return new ColorDrawable(0);
    }
}