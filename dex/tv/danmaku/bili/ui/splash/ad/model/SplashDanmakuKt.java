package tv.danmaku.bili.ui.splash.ad.model;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.bili.splash.ad.anim.DanmakuData;
import tv.danmaku.bili.splash.ad.anim.DanmakuItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashDanmaku.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\u0007"}, d2 = {"toDanmakuData", "Ltv/danmaku/bili/splash/ad/anim/DanmakuData;", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashDanmaku;", "containerWidth", "", "containerHeight", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashDanmakuKt {
    public static final DanmakuData toDanmakuData(List<SplashDanmaku> list, int containerWidth, int containerHeight) {
        List $this$toDanmakuData;
        List $this$toDanmakuData2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        if ($this$toDanmakuData2 != null) {
            List $this$mapIndexed$iv = $this$toDanmakuData2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SplashDanmaku item = (SplashDanmaku) item$iv$iv;
                String message = item.getMessage();
                if (message == null) {
                    message = "";
                }
                destination$iv$iv.add(new DanmakuItem(message, 16, -1, index$iv$iv, 4000));
                $this$toDanmakuData2 = $this$toDanmakuData2;
                index$iv$iv = index$iv$iv2;
            }
            $this$toDanmakuData = (List) destination$iv$iv;
        } else {
            $this$toDanmakuData = CollectionsKt.emptyList();
        }
        return new DanmakuData($this$toDanmakuData, 6, containerHeight, containerWidth);
    }
}