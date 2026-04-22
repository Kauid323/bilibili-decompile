package tv.danmaku.bili.ui.main2.userprotocol;

import java.util.HashMap;
import java.util.Map;

public class ReportEvent {
    public static final String EVENT_TYPE_CLICK = "click";
    public static final String EVENT_TYPE_SHOW = "show";
    public String eventId;
    public String eventType;
    public Map<String, String> extra;

    public ReportEvent() {
    }

    public ReportEvent(String eventId, String eventType, Map<String, String> extra) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.extra = extra == null ? new HashMap<>() : extra;
    }
}