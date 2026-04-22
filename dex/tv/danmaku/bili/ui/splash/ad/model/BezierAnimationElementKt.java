package tv.danmaku.bili.ui.splash.ad.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.util.SplashStateStorageHelperKt;
import tv.danmaku.bili.ui.splash.event.EventSplashStorageKt;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierAnimationElement.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toElement", "Lcom/bilibili/commonanim/elementanim/model/BezierAnimationElement;", "Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationElement;", "getToElement", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierAnimationElement;)Lcom/bilibili/commonanim/elementanim/model/BezierAnimationElement;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierAnimationElementKt {
    public static final com.bilibili.commonanim.elementanim.model.BezierAnimationElement getToElement(BezierAnimationElement $this$toElement) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter($this$toElement, "<this>");
        int type = $this$toElement.getType();
        long guideShowTime = $this$toElement.getGuideShowTime();
        long guideShowDuration = $this$toElement.getGuideShowDuration();
        long duration = $this$toElement.getDuration();
        int width = $this$toElement.getWidth();
        int height = $this$toElement.getHeight();
        BezierPoint position = $this$toElement.getPosition();
        com.bilibili.commonanim.elementanim.model.BezierPoint toPoint = position != null ? BezierPointKt.getToPoint(position) : null;
        String fetchResourceLocalPathByHash = SplashStateStorageHelperKt.getClickGuideShowCountOfElementAnimation() >= SplashConfigKt.getClickGuideShowMaxCount() ? null : EventSplashStorageKt.fetchResourceLocalPathByHash($this$toElement.getGuideImageMd5());
        String fetchResourceLocalPathByHash2 = EventSplashStorageKt.fetchResourceLocalPathByHash($this$toElement.getImageMd5());
        String fetchResourceLocalPathByHash3 = EventSplashStorageKt.fetchResourceLocalPathByHash($this$toElement.getTopImageMd5());
        int topImageWidth = $this$toElement.getTopImageWidth();
        int topImageHeight = $this$toElement.getTopImageHeight();
        int imageWidth = $this$toElement.getImageWidth();
        int imageHeight = $this$toElement.getImageHeight();
        String lineColor = $this$toElement.getLineColor();
        Iterable list = $this$toElement.getList();
        if (list != null) {
            Iterable $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                BezierAnimationItem it = (BezierAnimationItem) item$iv$iv;
                destination$iv$iv.add(BezierAnimationItemKt.getToItem(it));
                $this$map$iv = $this$map$iv;
            }
            arrayList = (List) destination$iv$iv;
        } else {
            arrayList = null;
        }
        return new com.bilibili.commonanim.elementanim.model.BezierAnimationElement(type, guideShowTime, guideShowDuration, duration, width, height, toPoint, arrayList, fetchResourceLocalPathByHash, fetchResourceLocalPathByHash2, imageWidth, imageHeight, fetchResourceLocalPathByHash3, topImageWidth, topImageHeight, lineColor);
    }
}