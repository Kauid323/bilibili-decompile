package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import android.graphics.drawable.Drawable;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.moduleservice.upper.UpperCenterPlusBubbleService;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.basic.TabHostGarbProviderKt;

/* compiled from: PublishBubbleDialog.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"tv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubbleDialog$onShow$1", "Lcom/bilibili/lib/image2/bean/ImageDataSubscriber;", "Lcom/bilibili/lib/image2/bean/DrawableHolder;", "onResult", "", "source", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "onFailure", "onCancellation", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PublishBubbleDialog$onShow$1 implements ImageDataSubscriber<DrawableHolder> {
    final /* synthetic */ TabHost $anchor;
    final /* synthetic */ UpperCenterPlusBubbleService.BubbleInfo $item;
    final /* synthetic */ PublishBubbleDialog this$0;

    public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
        ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublishBubbleDialog$onShow$1(PublishBubbleDialog $receiver, UpperCenterPlusBubbleService.BubbleInfo $item, TabHost $anchor) {
        this.this$0 = $receiver;
        this.$item = $item;
        this.$anchor = $anchor;
    }

    public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
        long delayShowTime;
        long coerceAtLeast;
        DrawableHolder drawableHolder;
        final Drawable drawable = (imageDataSource == null || (drawableHolder = (DrawableHolder) imageDataSource.getResult()) == null) ? null : drawableHolder.get();
        if (drawable == null || drawable.getIntrinsicWidth() < 1 || drawable.getIntrinsicHeight() < 1) {
            BLog.i(TabHostGarbProviderKt.TAG, "drawable is null");
            PublishBubbleDialogKt.showNextDialog();
            return;
        }
        final PublishBubbleDialog publishBubbleDialog = this.this$0;
        final UpperCenterPlusBubbleService.BubbleInfo bubbleInfo = this.$item;
        final TabHost tabHost = this.$anchor;
        Runnable runnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialog$onShow$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PublishBubbleDialog$onShow$1.onResult$lambda$0(PublishBubbleDialog.this, bubbleInfo, tabHost, drawable);
            }
        };
        if (PublishBubbleDialogKt.getSplashExitTime() == 0) {
            coerceAtLeast = PublishBubbleDialogKt.getDelayShowTime();
        } else {
            long splashExitTime = PublishBubbleDialogKt.getSplashExitTime();
            delayShowTime = PublishBubbleDialogKt.getDelayShowTime();
            coerceAtLeast = RangesKt.coerceAtLeast((splashExitTime + delayShowTime) - System.currentTimeMillis(), 0L);
        }
        HandlerThreads.postDelayed(0, runnable, coerceAtLeast);
        BLog.i(TabHostGarbProviderKt.TAG, "download drawable success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResult$lambda$0(PublishBubbleDialog this$0, UpperCenterPlusBubbleService.BubbleInfo $item, TabHost $anchor, Drawable $drawable) {
        this$0.showPopupWindow($item, $anchor, this$0.getOriginTabUrl(), $drawable);
    }

    public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
        PublishBubbleDialogKt.showNextDialog();
        BLog.i(TabHostGarbProviderKt.TAG, "download drawable onFailure", imageDataSource != null ? imageDataSource.getFailureCause() : null);
    }

    public void onCancellation(ImageDataSource<DrawableHolder> imageDataSource) {
        PublishBubbleDialogKt.showNextDialog();
        BLog.i(TabHostGarbProviderKt.TAG, "download drawable onCancellation", imageDataSource != null ? imageDataSource.getFailureCause() : null);
    }
}