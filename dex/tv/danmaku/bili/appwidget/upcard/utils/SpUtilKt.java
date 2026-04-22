package tv.danmaku.bili.appwidget.upcard.utils;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;

/* compiled from: SpUtil.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r\u001a\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"UP_CARD_PAGE_DATA_SP", "", "HOT_LIST_RESTRICTED_TEENAGER_SP", "HOT_LIST_RESTRICTED_LESSONS_SP", "TAG", "isRestrictedTeenagerMode", "", "context", "Landroid/content/Context;", "isRestrictedLessonMode", "saveWidgetData", "", "data", "Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "getLocalWidgetData", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SpUtilKt {
    private static final String HOT_LIST_RESTRICTED_LESSONS_SP = "hot_list_restricted_lessons_sp";
    private static final String HOT_LIST_RESTRICTED_TEENAGER_SP = "hot_list_restricted_teenager_sp";
    private static final String TAG = "UpCardSp";
    private static final String UP_CARD_PAGE_DATA_SP = "up_card_page_data_sp";

    public static final boolean isRestrictedTeenagerMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(HOT_LIST_RESTRICTED_TEENAGER_SP, false);
    }

    public static final boolean isRestrictedLessonMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(HOT_LIST_RESTRICTED_LESSONS_SP, false);
    }

    public static final void saveWidgetData(Context context, UpCardWidgetData data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(UP_CARD_PAGE_DATA_SP, JSONObject.toJSONString(data)).apply();
    }

    public static final UpCardWidgetData getLocalWidgetData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String json = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(UP_CARD_PAGE_DATA_SP, "");
        String str = json;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            return (UpCardWidgetData) JSONObject.parseObject(json, UpCardWidgetData.class);
        } catch (Exception e) {
            BLog.e(TAG, "parse json error:", e);
            return null;
        }
    }
}