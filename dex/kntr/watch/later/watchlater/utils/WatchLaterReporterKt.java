package kntr.watch.later.watchlater.utils;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchLaterReporter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"EVENT_TAB_CLICK", "", "EVENT_PLAY_ALL_CLICK", "EVENT_SORT_CLICK", "EVENT_CARD_CLICK", "EVENT_MANAGE_CLICK", "EVENT_MANAGE_OPTION_CLICK", "EVENT_DELETE_CLICK", "EVENT_BATCH_DELETE_CLICK", "EVENT_BATCH_COPY_CLICK", "EVENT_BATCH_MOVE_CLICK", "KEY_TAB_NAME", "KEY_ORDER_TYPE", "KEY_AVID", "KEY_ACTION_TYPE", "KEY_OPTION", "KEY_CLICK_TYPE", "KEY_NUM", "ORDER_ASCENT", "ORDER_DESCENT", "CANCEL", "MANAGE_VIDEO", "CLEAN_WATCHED", "CLEAN_INVALID", "TYPE_MANAGE_BUTTON", "TYPE_LONG_PRESS", "reportWatchLaterClick", "", "eventId", "params", "", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterReporterKt {
    public static final String CANCEL = "0";
    public static final String CLEAN_INVALID = "3";
    public static final String CLEAN_WATCHED = "2";
    public static final String EVENT_BATCH_COPY_CLICK = "main.later-watch.editor.copy.click";
    public static final String EVENT_BATCH_DELETE_CLICK = "main.later-watch.editor.delete.click";
    public static final String EVENT_BATCH_MOVE_CLICK = "main.later-watch.editor.move.click";
    public static final String EVENT_CARD_CLICK = "main.later-watch.video-card.0.click";
    public static final String EVENT_DELETE_CLICK = "main.later-watch.video-card.delete.click";
    public static final String EVENT_MANAGE_CLICK = "main.later-watch.more-option.0.click";
    public static final String EVENT_MANAGE_OPTION_CLICK = "main.later-watch.more-option.all.click";
    public static final String EVENT_PLAY_ALL_CLICK = "main.later-watch.playall-button.0.click";
    public static final String EVENT_SORT_CLICK = "main.later-watch.order.0.click";
    public static final String EVENT_TAB_CLICK = "main.later-watch.tab.0.click";
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_AVID = "avid";
    public static final String KEY_CLICK_TYPE = "click_type";
    public static final String KEY_NUM = "num";
    public static final String KEY_OPTION = "option";
    public static final String KEY_ORDER_TYPE = "order_type";
    public static final String KEY_TAB_NAME = "tab_name";
    public static final String MANAGE_VIDEO = "1";
    public static final String ORDER_ASCENT = "1";
    public static final String ORDER_DESCENT = "2";
    public static final String TYPE_LONG_PRESS = "1";
    public static final String TYPE_MANAGE_BUTTON = "0";

    public static /* synthetic */ void reportWatchLaterClick$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        reportWatchLaterClick(str, map);
    }

    public static final void reportWatchLaterClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "params");
        KNeuron.INSTANCE.reportClick(false, eventId, map);
    }
}