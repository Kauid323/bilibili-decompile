package tv.danmaku.bili.ui.rank.utils;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NeuronsEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"RANK_VIDEO_CARD_CLICK", "", "RANK_FOLLOWING_CLICK", "RANK_UP_HEAD_CLICK", "RANK_TAB_CLICK", "reportNeuronClick", "", "eventId", "extra", "", "rank_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NeuronsEventKt {
    public static final String RANK_FOLLOWING_CLICK = "creation.hot-ranking.ranking-follow.0.click";
    public static final String RANK_TAB_CLICK = "creation.hot-ranking.ranking-tab.0.click";
    public static final String RANK_UP_HEAD_CLICK = "creation.hot-ranking.ranking-up.0.click";
    public static final String RANK_VIDEO_CARD_CLICK = "creation.hot-ranking.ranking-video.0.click";

    public static /* synthetic */ void reportNeuronClick$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        reportNeuronClick(str, map);
    }

    public static final void reportNeuronClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Neurons.reportClick(false, eventId, map == null ? MapsKt.emptyMap() : map);
    }
}