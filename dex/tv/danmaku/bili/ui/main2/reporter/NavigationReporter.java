package tv.danmaku.bili.ui.main2.reporter;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.app.comm.list.common.api.IDefaultKeywordResult;
import com.bilibili.lib.homepage.startdust.secondary.BasePrimaryMultiPageFragment;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.pageview.model.PageViewsEvent;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class NavigationReporter {
    private static final String EVENT_ID_HOME_AVATAR_GUIDE_SHOW = "main.homepage.avatar.guide.show";
    private static final String EVENT_ID_HOME_BOTTOM_TAB_SHOW = "main.homepage.bottombar.0.show";
    public static final String EVENT_ID_HOME_SEARCH_CLICK = "main.homepage.top-tabbar.search.click";
    public static final String EVENT_ID_HOME_SEARCH_SHOW = "main.homepage.top-tabbar.search.show";
    private static final String EVENT_ID_HOME_SUB_TAB_CLICK = "main.homepage.bottombar.subtab.click";
    private static final String EVENT_ID_HOME_SUB_TAB_SHOW = "main.homepage.bottombar.subtab.show";
    private static final String EVENT_ID_HOME_TAB_CLICK = "main.homepage.top-tabbar.0.click";
    private static final String EVENT_ID_HOME_TOP_TAB_SHOW = "main.homepage.top-tabbar.0.show";
    private static final String EVENT_ID_NAVIGATION_LOGIN_CLICK = "main.my-information.my-login.0.click";
    private static final String EVENT_SEARCH_DEFAULT_WORD_SHOW = "main.homepage.search-defaultword.0.show";
    private static final String NAVIGATION_FANS_INCREASE_BUBBLE_SHOW = "main.my-information.follow-fans-click.fans-toast.show";
    private static final String NAVIGATION_THEME_STORE_CLICK = "main.my-information.theme.0.click";
    private static final String TAG = "NavigationReporter";

    public static void reportLoginClick() {
        Neurons.reportClick(false, "main.my-information.my-login.0.click");
    }

    public static void reportThemeClick() {
        Neurons.reportClick(false, NAVIGATION_THEME_STORE_CLICK);
    }

    public static void reportNightModeClick() {
    }

    public static void reportNightModeClickV2(Context context) {
        HashMap<String, String> options = new HashMap<>();
        Garb garb = GarbManager.getGarbWithNightMode(context);
        String mode = MultipleThemeUtils.isNightTheme(context) ? "1" : "2";
        options.put(LoginReporterV2.Click.SIGNUP_KEY_MODE, mode);
        options.put("theme", Long.toString(garb.getId()));
        Neurons.reportClick(false, "main.my-information.dark-theme.0.click", options);
    }

    public static void reportNoticeClick() {
    }

    public static void reportNoticeCloseClick() {
    }

    public static void reportFansIncreaseBubbleShow() {
        Neurons.reportExposure(false, NAVIGATION_FANS_INCREASE_BUBBLE_SHOW);
    }

    public static void reportHomeTabShow(BasePrimaryMultiPageFragment.PageInfo pageInfo) {
        if (pageInfo == null) {
            return;
        }
        reportHomeTabShow(pageInfo.name);
    }

    public static void reportHomeTabShow(String tabName) {
        Map<String, String> extra = new HashMap<>(1);
        extra.put(BaseFavoritesFragment.TAB, tabName);
        Neurons.reportExposure(false, EVENT_ID_HOME_TOP_TAB_SHOW, extra);
    }

    public static void reportMainTabShow(String tabName, long bubbleId) {
        Map<String, String> extra = new HashMap<>(1);
        extra.put(BaseFavoritesFragment.TAB, tabName);
        if (bubbleId > 0) {
            extra.put("bubble_id", String.valueOf(bubbleId));
        }
        Neurons.reportExposure(false, EVENT_ID_HOME_BOTTOM_TAB_SHOW, extra);
    }

    public static void reportHomeTabClick(String tabName, String interactive) {
        reportHomeTabClick(tabName, interactive, null);
    }

    public static void reportHomeTabClick(String tabName, String interactive, String isAnimation) {
        Map<String, String> extra = new HashMap<>(1);
        extra.put(BaseFavoritesFragment.TAB, tabName);
        extra.put("interactive", interactive);
        extra.put("is_animation", isAnimation);
        Neurons.reportClick(false, EVENT_ID_HOME_TAB_CLICK, extra);
    }

    public static void reportSearchWordClick(IDefaultKeywordResult word) {
        if (word == null) {
            return;
        }
        HashMap<String, String> params = new HashMap<>(6);
        params.put("query", word.getShow());
        params.put("trackid", word.getTrackId());
        params.put("searchpage", "homepage-defaultword");
        params.put("moduletype", "default-word");
        params.put("moduleid", word.getValue());
        params.put("abtestid", word.getExpStr());
        params.put("goto", word.getDefaultWordGoto());
        params.put("click_query", word.getWord());
        params.put("tab_name", word.getTabName());
        params.put("default_word_type", word.getDefaultWordType() + "");
        if (word.getRefreshTimes() > 0) {
            params.put("refresh_cnt", String.valueOf(word.getRefreshTimes()));
        }
        if (word.getFromTM()) {
            params.put("is_tm_refresh", "1");
        } else {
            params.put("is_tm_refresh", "0");
        }
        params.put("flash_screen_query_id", String.valueOf(word.getFlashScreenQueryId()));
        addPageViewIdParam(params);
        Neurons.reportClick(true, "main.homepage.default-word.0.click", params);
    }

    public static void reportSearchWordShow(IDefaultKeywordResult word) {
        BLog.i(TAG, "reportSearchWordShow");
        if (word == null) {
            return;
        }
        HashMap<String, String> params = new HashMap<>(6);
        params.put("query", word.getShow());
        params.put("trackid", word.getTrackId());
        params.put("searchpage", "homepage-defaultword");
        params.put("moduletype", "default-word");
        params.put("moduleid", word.getValue());
        params.put("abtestid", word.getExpStr());
        params.put("goto", word.getDefaultWordGoto());
        params.put("click_query", word.getWord());
        Neurons.reportExposure(false, "main.homepage.default-word.0.show", params);
    }

    public static void reportSearchWordShow2(IDefaultKeywordResult word) {
        if (word == null) {
            return;
        }
        HashMap<String, String> params = new HashMap<>(6);
        params.put("query", word.getShow());
        params.put("trackid", word.getTrackId());
        params.put("searchpage", "homepage-defaultword");
        params.put("moduletype", "default-word");
        params.put("moduleid", word.getValue());
        params.put("abtestid", word.getExpStr());
        params.put("goto", word.getDefaultWordGoto());
        params.put("click_query", word.getWord());
        params.put("tab_name", word.getTabName());
        params.put("default_word_type", word.getDefaultWordType() + "");
        if (word.getRefreshTimes() > 0) {
            params.put("refresh_cnt", String.valueOf(word.getRefreshTimes()));
        }
        if (word.getFromTM()) {
            params.put("is_tm_refresh", "1");
        } else {
            params.put("is_tm_refresh", "0");
        }
        params.put("flash_screen_query_id", String.valueOf(word.getFlashScreenQueryId()));
        addPageViewIdParam(params);
        Neurons.reportExposure(false, EVENT_SEARCH_DEFAULT_WORD_SHOW, params);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void addPageViewIdParam(Map<String, String> params) {
        char c;
        if (PageViewTracker.getInstance().getLastEndPv() != null) {
            PageViewsEvent lastEndPv = PageViewTracker.getInstance().getLastEndPv();
            params.put("event_id_from", lastEndPv.eventId);
            if (lastEndPv.extra != null) {
                String paramFrom = null;
                Map<String, String> extra = lastEndPv.extra;
                String str = lastEndPv.eventId;
                switch (str.hashCode()) {
                    case -2065364055:
                        if (str.equals("live.live-search.0.0.pv")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1441892460:
                        if (str.equals("search.search-result.0.0.pv")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1437453599:
                        if (str.equals("main.ugc-video-detail-vertical.0.0.pv")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1121131000:
                        if (str.equals("search.search-discover.0.0.pv")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -556996183:
                        if (str.equals("read.column-search.0.0.pv")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 51105020:
                        if (str.equals("main.ugc-video-detail.0.0.pv")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 677565454:
                        if (str.equals("pgc.cinema-search.0.0.pv")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1250594316:
                        if (str.equals("search.user-search.0.0.pv")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1553896498:
                        if (str.equals("pgc.bangumi-search.0.0.pv")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                        String paramFrom2 = extra.get("avid");
                        paramFrom = paramFrom2;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                        String paramFrom3 = extra.get("query");
                        paramFrom = paramFrom3;
                        break;
                }
                if (paramFrom != null) {
                    params.put("param_from", paramFrom);
                }
            }
        }
    }

    public static void reportHomeSubTabShow(String tabName, String iconId, String operateIconId) {
        Map<String, String> extra = new HashMap<>();
        extra.put(BaseFavoritesFragment.TAB, tabName);
        extra.put("icon_id", iconId);
        extra.put("operate_icon_id", TextUtils.isEmpty(operateIconId) ? "" : operateIconId);
        Neurons.reportExposure(false, EVENT_ID_HOME_SUB_TAB_SHOW, extra);
    }

    public static void reportHomeSubTabClick(String tabName, String iconId, String operateIconId) {
        Map<String, String> extra = new HashMap<>();
        extra.put(BaseFavoritesFragment.TAB, tabName);
        extra.put("icon_id", iconId);
        extra.put("operate_icon_id", TextUtils.isEmpty(operateIconId) ? "" : operateIconId);
        Neurons.reportClick(false, EVENT_ID_HOME_SUB_TAB_CLICK, extra);
    }

    public static void reportHomeAvatarGuideShow(MainResourceManager.TopLeftBubble bubble) {
        Map<String, String> extra = new HashMap<>();
        extra.put("type", String.valueOf(bubble.type));
        extra.put("id", String.valueOf(bubble.id));
        Neurons.reportExposure(false, EVENT_ID_HOME_AVATAR_GUIDE_SHOW, extra);
    }
}