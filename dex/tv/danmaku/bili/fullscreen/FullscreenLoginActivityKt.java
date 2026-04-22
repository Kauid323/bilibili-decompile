package tv.danmaku.bili.fullscreen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.BR;

/* compiled from: FullscreenLoginActivity.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\u001a(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0005*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "FullscreenLoginPageUrl", "KEY_PAGE_START_AT", "unified", "", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginActivityKt {
    public static final String FullscreenLoginPageUrl = "bilibili://login/fullscreen";
    public static final String KEY_PAGE_START_AT = "page_start_at";
    private static final String TAG = "FullscreenLoginActivity";

    public static final Map<String, String> unified(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Collection destination$iv$iv = new ArrayList(map.size());
        for (Map.Entry item$iv$iv : map.entrySet()) {
            String key = item$iv$iv.getKey();
            String str = "";
            if (key == null) {
                key = "";
            }
            String value = item$iv$iv.getValue();
            if (value != null) {
                str = value;
            }
            destination$iv$iv.add(new Pair(key, str));
        }
        Iterable $this$associate$iv = (List) destination$iv$iv;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Pair it = (Pair) element$iv$iv;
            destination$iv$iv2.put(it.getFirst(), it.getSecond());
        }
        return destination$iv$iv2;
    }
}