package tv.danmaku.bili.appwidget.hotlist.utils;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;

/* compiled from: SpUtil.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b\u001a\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b\u001a\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b\u001a\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e\u001a\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010 \u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001b\u001a\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001b\u001a\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010%\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'\u001a\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'\u001a\u0010\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010\f\u001a\u00020\r\u001a\u0010\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010\f\u001a\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"HOT_LIST_PAGE_NO_SP", "", "OPPO_HOT_LIST_PAGE_NO_SP", "HOT_LIST_PAGE_DATA_SP", "OPPO_HOT_LIST_PAGE_DATA_SP", "HOT_LIST_RESTRICTED_TEENAGER_SP", "HOT_LIST_RESTRICTED_LESSONS_SP", "OPPO_HOT_LIST_REFRESH_TIME_SP", "OPPO_HOT_LIST_WIDGET_COUNT_SP", "TAG", "getHotListPageNo", "", "context", "Landroid/content/Context;", "setHotListPageNo", "", "newPageNo", "incrementHotListPageNo", "resetHotListPageNo", "getOppoHotListPageNo", "setOppoHotListPageNo", "incrementOppoHotListPageNo", "resetOppoHotListPageNo", "setOpHotListCount", "widgetCount", "getOpHotListCount", "isOpHotListExists", "", "setOpHotListRefreshTime", "time", "", "getOpHotListRefreshTime", "recodeRestrictedTeenagerMode", "isEnable", "isRestrictedTeenagerMode", "recodeRestrictedLessonsMode", "isRestrictedLessonMode", "saveWidgetData", "data", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "saveOppoWidgetData", "getLocalWidgetData", "getOppoLocalWidgetData", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SpUtilKt {
    private static final String HOT_LIST_PAGE_DATA_SP = "hot_list_page_data_sp";
    private static final String HOT_LIST_PAGE_NO_SP = "hot_list_page_no_sp";
    private static final String HOT_LIST_RESTRICTED_LESSONS_SP = "hot_list_restricted_lessons_sp";
    private static final String HOT_LIST_RESTRICTED_TEENAGER_SP = "hot_list_restricted_teenager_sp";
    private static final String OPPO_HOT_LIST_PAGE_DATA_SP = "oppo_hot_list_page_data_sp";
    private static final String OPPO_HOT_LIST_PAGE_NO_SP = "oppo_hot_list_page_no_sp";
    private static final String OPPO_HOT_LIST_REFRESH_TIME_SP = "oppo_hot_list_refresh_time_sp";
    private static final String OPPO_HOT_LIST_WIDGET_COUNT_SP = "oppo_hot_list_widget_count_sp";
    private static final String TAG = "HotListSp";

    public static final int getHotListPageNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getInt(HOT_LIST_PAGE_NO_SP, 0);
    }

    public static final void setHotListPageNo(Context context, int newPageNo) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (newPageNo >= 0) {
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(HOT_LIST_PAGE_NO_SP, newPageNo).apply();
        }
    }

    public static final void incrementHotListPageNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setHotListPageNo(context, getHotListPageNo(context) + 1);
    }

    public static final void resetHotListPageNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setHotListPageNo(context, 0);
    }

    public static final int getOppoHotListPageNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getInt(OPPO_HOT_LIST_PAGE_NO_SP, 0);
    }

    public static final void setOppoHotListPageNo(Context context, int newPageNo) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (newPageNo >= 0) {
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(OPPO_HOT_LIST_PAGE_NO_SP, newPageNo).apply();
        }
    }

    public static final void incrementOppoHotListPageNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setOppoHotListPageNo(context, getOppoHotListPageNo(context) + 1);
    }

    public static final void resetOppoHotListPageNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setOppoHotListPageNo(context, 0);
    }

    public static final void setOpHotListCount(Context context, int widgetCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(OPPO_HOT_LIST_WIDGET_COUNT_SP, widgetCount).apply();
    }

    public static final int getOpHotListCount(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getInt(OPPO_HOT_LIST_WIDGET_COUNT_SP, 0);
    }

    public static final boolean isOpHotListExists(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getOpHotListCount(context) > 0;
    }

    public static final void setOpHotListRefreshTime(Context context, long time) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putLong(OPPO_HOT_LIST_REFRESH_TIME_SP, time).apply();
    }

    public static final long getOpHotListRefreshTime(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getLong(OPPO_HOT_LIST_REFRESH_TIME_SP, 0L);
    }

    public static final void recodeRestrictedTeenagerMode(Context context, boolean isEnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(HOT_LIST_RESTRICTED_TEENAGER_SP, isEnable).apply();
    }

    public static final boolean isRestrictedTeenagerMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(HOT_LIST_RESTRICTED_TEENAGER_SP, false);
    }

    public static final void recodeRestrictedLessonsMode(Context context, boolean isEnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(HOT_LIST_RESTRICTED_LESSONS_SP, isEnable).apply();
    }

    public static final boolean isRestrictedLessonMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(HOT_LIST_RESTRICTED_LESSONS_SP, false);
    }

    public static final void saveWidgetData(Context context, HotListWidgetModel data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(HOT_LIST_PAGE_DATA_SP, JSONObject.toJSONString(data)).apply();
    }

    public static final void saveOppoWidgetData(Context context, HotListWidgetModel data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(OPPO_HOT_LIST_PAGE_DATA_SP, JSONObject.toJSONString(data)).apply();
    }

    public static final HotListWidgetModel getLocalWidgetData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String json = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(HOT_LIST_PAGE_DATA_SP, "");
        String str = json;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            HotListWidgetModel model = (HotListWidgetModel) JSONObject.parseObject(json, HotListWidgetModel.class);
            List<HotListWidgetItemModel> items = model.getItems();
            if (items == null || items.isEmpty()) {
                z = true;
            }
            if (z) {
                BLog.i(TAG, "page items is null");
                return null;
            }
            return model;
        } catch (Exception e) {
            BLog.e(TAG, "parse json error:", e);
            return null;
        }
    }

    public static final HotListWidgetModel getOppoLocalWidgetData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String json = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(OPPO_HOT_LIST_PAGE_DATA_SP, "");
        String str = json;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            HotListWidgetModel model = (HotListWidgetModel) JSONObject.parseObject(json, HotListWidgetModel.class);
            List<HotListWidgetItemModel> items = model.getItems();
            if (items == null || items.isEmpty()) {
                z = true;
            }
            if (z) {
                BLog.i(TAG, "page items is null");
                return null;
            }
            return model;
        } catch (Exception e) {
            BLog.e(TAG, "parse json error:", e);
            return null;
        }
    }
}