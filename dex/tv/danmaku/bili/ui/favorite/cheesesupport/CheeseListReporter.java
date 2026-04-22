package tv.danmaku.bili.ui.favorite.cheesesupport;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CheeseListReporter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bJ\"\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListReporter;", "", "<init>", "()V", "EVENT_ID_FAV_CHEESE_TAB_PAGE_VIEW", "", "EVENT_ID_FAV_CHEESE_ITEM_CLICK", "reportClick", "", "eventId", "paramMap", "", "reportExposure", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CheeseListReporter {
    public static final int $stable = 0;
    public static final String EVENT_ID_FAV_CHEESE_ITEM_CLICK = "main.my-favorite-pugv.packagecard.0.click";
    public static final String EVENT_ID_FAV_CHEESE_TAB_PAGE_VIEW = "main.my-favorite-pugv.0.0.pv";
    public static final CheeseListReporter INSTANCE = new CheeseListReporter();

    private CheeseListReporter() {
    }

    public final void reportClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "paramMap");
        Neurons.reportClick(false, eventId, map);
    }

    public final void reportExposure(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "paramMap");
        Neurons.reportExposure$default(false, eventId, map, (List) null, 8, (Object) null);
    }
}