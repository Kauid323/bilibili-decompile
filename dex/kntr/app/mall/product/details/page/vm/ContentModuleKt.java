package kntr.app.mall.product.details.page.vm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentModule.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, d2 = {"buildKeyToIndexMap", "", "", "", "groupedContent", "", "", "includeHeader", "", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ContentModuleKt {
    public static /* synthetic */ Map buildKeyToIndexMap$default(List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return buildKeyToIndexMap(list, z);
    }

    public static final Map<String, Integer> buildKeyToIndexMap(List<? extends Object> list, boolean includeHeader) {
        String key;
        Intrinsics.checkNotNullParameter(list, "groupedContent");
        LinkedHashMap map = new LinkedHashMap();
        int currentIndex = 0;
        if (includeHeader) {
            map.put("HeaderBanner", 0);
            currentIndex = 0 + 1;
        }
        List<? extends Object> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            if (element$iv instanceof ModuleGroup) {
                key = ((ModuleGroup) element$iv).getId();
            } else {
                key = element$iv instanceof ContentModule ? ((ContentModule) element$iv).getFloorType().getKey() : String.valueOf(element$iv.hashCode());
            }
            map.put(key, Integer.valueOf(currentIndex));
            currentIndex++;
        }
        return map;
    }
}