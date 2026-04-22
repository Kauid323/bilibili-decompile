package tv.danmaku.bili.ui.splash.ad.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashData.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"unExposeKeepIds", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "getUnExposeKeepIds", "(Ltv/danmaku/bili/ui/splash/ad/model/SplashData;)Ljava/lang/String;", "DEFAULT_INTERVAL_FOR_PULL", "", "DEFAULT_INTERVAL_FOR_SHOW", "DEFAULT_MAX_SHOW_COUNT", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashDataKt {
    public static final int DEFAULT_INTERVAL_FOR_PULL = 900;
    public static final int DEFAULT_INTERVAL_FOR_SHOW = 900;
    private static final int DEFAULT_MAX_SHOW_COUNT = 6;

    public static final String getUnExposeKeepIds(SplashData $this$unExposeKeepIds) {
        Iterable ids;
        Iterable splashList;
        if ($this$unExposeKeepIds == null || (ids = $this$unExposeKeepIds.getKeepIds()) == null || (splashList = $this$unExposeKeepIds.getSplashList()) == null) {
            return "";
        }
        Iterable $this$filter$iv = splashList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Splash it = (Splash) element$iv$iv;
            if (!it.isLocalExposed) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$associateBy$iv = (List) destination$iv$iv;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv2 : $this$associateBy$iv) {
            Splash it2 = (Splash) element$iv$iv2;
            destination$iv$iv2.put(Long.valueOf(it2.id), element$iv$iv2);
        }
        Iterable $this$filter$iv2 = ids;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv2) {
            long it3 = ((Number) element$iv$iv3).longValue();
            if (destination$iv$iv2.containsKey(Long.valueOf(it3))) {
                destination$iv$iv3.add(element$iv$iv3);
            }
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv3, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}