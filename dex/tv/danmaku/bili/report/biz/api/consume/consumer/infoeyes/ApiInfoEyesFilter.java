package tv.danmaku.bili.report.biz.api.consume.consumer.infoeyes;

import com.bilibili.commons.StringUtils;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.biz.api.consume.filter.HostFilters;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent2;

public class ApiInfoEyesFilter {
    public static boolean filter(RequestEvent event) {
        if (event instanceof RequestEvent2) {
            if (!event.isValid()) {
                BLog.dfmt("API", "drop no used event for url %s:", event.url);
                return true;
            } else if (event.httpcode == 304) {
                BLog.vfmt("API", "drops not-modified api request event %s:", event.url);
                return false;
            } else if (isSuppressed(event)) {
                return true;
            } else {
                modifyEvent(event);
                return false;
            }
        }
        return true;
    }

    private static boolean isSuppressed(RequestEvent event) {
        if (HostFilters.isReportSelf(event) || dropLive(event)) {
            return true;
        }
        if ("app.bilibili.com".equals(event.host)) {
            if ("/x/v2/view/video/shot".equals(event.api) && 10008 == event.respcode) {
                return true;
            }
            if ("/x/v2/splash".equals(event.api) && -304 == event.respcode) {
                return true;
            }
        }
        if ("api.bilibili.com".equals(event.host)) {
            if ("/x/feedback/reply".equals(event.api) && event.respcode == 18001) {
                return true;
            }
            return ("/x/dm/filter/global".equals(event.api) && event.respcode == -304) || "/x/report/heartbeat".equals(event.api);
        }
        return false;
    }

    private static boolean dropLive(RequestEvent event) {
        if ("live.bilibili.com".equals(event.host) || "live-trace.bilibili.com".equals(event.host)) {
            return true;
        }
        return "api.live.bilibili.com".equals(event.host) && "/mobile/userOnlineHeart".equals(event.api);
    }

    private static void modifyEvent(RequestEvent event) {
        if ("app.bilibili.com".equals(event.host) && StringUtils.endsWith(event.api, "android3.upgrade/android3.upgrade.ver")) {
            event.api = "/mdata/android3/#ver/android3.upgrade/android3.upgrade.ver";
        }
        if ("bangumi.bilibili.com".equals(event.host) && StringUtils.startsWith(event.api, "/api/season/recommend/rnd")) {
            event.api = "/api/season/recommend/rnd/#season_id.json";
        }
        if ("api.live.bilibili.com".equals(event.host) && StringUtils.startsWith(event.api, "/SpecialGift/room")) {
            event.api = "/SpecialGift/room/#room_id.json";
        }
    }
}