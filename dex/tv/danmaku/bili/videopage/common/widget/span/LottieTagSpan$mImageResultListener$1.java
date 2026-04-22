package tv.danmaku.bili.videopage.common.widget.span;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.image2.bean.utils.DrawableWrapper;
import com.bilibili.lib.ui.ImageResultListener;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LottieTagSpan.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"tv/danmaku/bili/videopage/common/widget/span/LottieTagSpan$mImageResultListener$1", "Lcom/bilibili/lib/ui/ImageResultListener;", "onImageLoaded", "", "onImageFailed", "t", "", "onRequestCancelled", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LottieTagSpan$mImageResultListener$1 implements ImageResultListener {
    final /* synthetic */ LottieTagSpan this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieTagSpan$mImageResultListener$1(LottieTagSpan $receiver) {
        this.this$0 = $receiver;
    }

    public void onImageLoaded() {
    }

    public void onImageFailed(Throwable t) {
        final LottieTagSpan lottieTagSpan = this.this$0;
        Task callInBackground = Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.videopage.common.widget.span.LottieTagSpan$mImageResultListener$1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Drawable onImageFailed$lambda$0;
                onImageFailed$lambda$0 = LottieTagSpan$mImageResultListener$1.onImageFailed$lambda$0(LottieTagSpan.this);
                return onImageFailed$lambda$0;
            }
        });
        final LottieTagSpan lottieTagSpan2 = this.this$0;
        callInBackground.continueWith(new Continuation() { // from class: tv.danmaku.bili.videopage.common.widget.span.LottieTagSpan$mImageResultListener$1$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Unit onImageFailed$lambda$1;
                onImageFailed$lambda$1 = LottieTagSpan$mImageResultListener$1.onImageFailed$lambda$1(LottieTagSpan.this, task);
                return onImageFailed$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable onImageFailed$lambda$0(LottieTagSpan this$0) {
        String str;
        Drawable createLottieDrawable;
        str = this$0.mUrl;
        createLottieDrawable = this$0.createLottieDrawable(str);
        return createLottieDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onImageFailed$lambda$1(LottieTagSpan this$0, Task it) {
        ColorDrawable lottieDrawable = (Drawable) it.getResult();
        if (lottieDrawable == null) {
            lottieDrawable = new ColorDrawable(0);
        }
        DrawableWrapper drawable = this$0.getDrawable();
        DrawableWrapper drawableWrapper = drawable instanceof DrawableWrapper ? drawable : null;
        if (drawableWrapper != null) {
            drawableWrapper.setCurrent(lottieDrawable);
        }
        this$0.startAnim();
        return Unit.INSTANCE;
    }

    public void onRequestCancelled() {
    }
}