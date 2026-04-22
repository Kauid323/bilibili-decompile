package tv.danmaku.bili.ui.main;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.bean.AnimationInfo;
import com.bilibili.lib.image2.bean.AnimationListener;
import com.bilibili.lib.image2.bean.BiliAnimatable;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: MineGuideActivity.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"tv/danmaku/bili/ui/main/MineGuideActivity$setupBottomImage$1", "Lcom/bilibili/lib/image2/bean/ImageLoadingListener;", "onImageSet", "", "imageInfo", "Lcom/bilibili/lib/image2/bean/ImageInfo;", "onImageLoadFailed", "err", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGuideActivity$setupBottomImage$1 implements ImageLoadingListener {
    final /* synthetic */ MineGuideActivity this$0;

    public /* synthetic */ void onImageLoading(Uri uri) {
        ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
    }

    public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
        ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
    }

    public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
        ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MineGuideActivity$setupBottomImage$1(MineGuideActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onImageSet(ImageInfo imageInfo) {
        BiliAnimatable biliAnimatable;
        BiliAnimatable $this$onImageSet_u24lambda_u240;
        BiliAnimatable biliAnimatable2;
        AnimationInfo animateInfo;
        this.this$0.mBottomAnimatable = (imageInfo == null || (animateInfo = imageInfo.getAnimateInfo()) == null) ? null : animateInfo.getAnimatable();
        biliAnimatable = this.this$0.mBottomAnimatable;
        if (biliAnimatable != null) {
            final MineGuideActivity mineGuideActivity = this.this$0;
            biliAnimatable.setAnimationListener(new AnimationListener() { // from class: tv.danmaku.bili.ui.main.MineGuideActivity$setupBottomImage$1$onImageSet$1
                public /* synthetic */ void onAnimationLastFrame(BiliAnimatable biliAnimatable3) {
                    AnimationListener.-CC.$default$onAnimationLastFrame(this, biliAnimatable3);
                }

                public void onAnimationStart(BiliAnimatable animatable) {
                }

                public void onAnimationStop(BiliAnimatable animatable) {
                    MineGuideActivity.this.finish();
                }
            });
        }
        $this$onImageSet_u24lambda_u240 = this.this$0.mTopAnimatable;
        if ($this$onImageSet_u24lambda_u240 != null) {
            biliAnimatable2 = this.this$0.mBottomAnimatable;
            if (biliAnimatable2 != null) {
                biliAnimatable2.start();
            }
            $this$onImageSet_u24lambda_u240.start();
        }
        final MineGuideActivity mineGuideActivity2 = this.this$0;
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.main.MineGuideActivity$setupBottomImage$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MineGuideActivity.this.finish();
            }
        }, 6500L);
    }

    public void onImageLoadFailed(Throwable err) {
        this.this$0.finish();
    }
}