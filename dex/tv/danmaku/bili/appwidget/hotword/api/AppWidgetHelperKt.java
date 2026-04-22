package tv.danmaku.bili.appwidget.hotword.api;

import android.content.Context;
import android.content.SharedPreferences;
import bili.resource.homepage.R;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotword.data.ButtonData;
import tv.danmaku.bili.appwidget.hotword.data.HotWordLocalWidgetData;
import tv.danmaku.bili.appwidget.hotword.data.HotWordWidgetData;
import tv.danmaku.bili.appwidget.hotword.data.WidgetButtonData;

/* compiled from: AppWidgetHelper.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0002\u001a\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0001\u001a\u001a\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0001\u001a\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"TAG", "", "DEFAULT_WORK_INTERVAL_SECONDS", "", "CONFIG_KEY_INTERVAL", "KEY_HOT_WORD_WIDGET_CONFIG", AppWidgetHelperKt.KEY_HOT_WORD_WIDGET_API, "PARAM_POSITION", "getWidgetRefreshIntervalSecond", "getHotWordWidgetApiData", "Ltv/danmaku/bili/appwidget/hotword/data/HotWordWidgetData;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHorWordWidgetLocalData", "saveHotWordCache", "", "data", "constructDefaultHotWordWidgetData", "getLocalDefaultHotWordWidgetData", "Ltv/danmaku/bili/appwidget/hotword/data/HotWordLocalWidgetData;", "getHotWordWidgetApiDataCache", "onHotWordUpdate", "", "appWidgetIds", "", "onHotWordDelete", "getHotWordConfig", "Ltv/danmaku/bili/appwidget/hotword/api/HotWorldConfigHolder;", "putHotWordConfig", "holder", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppWidgetHelperKt {
    private static final String CONFIG_KEY_INTERVAL = "app_widget.hot_word_refresh_interval_second";
    private static final long DEFAULT_WORK_INTERVAL_SECONDS = 1800;
    private static final String KEY_HOT_WORD_WIDGET_API = "KEY_HOT_WORD_WIDGET_API";
    private static final String KEY_HOT_WORD_WIDGET_CONFIG = "HOT_WORD_WIDGET_CONFIG";
    private static final String PARAM_POSITION = "&position=";
    private static final String TAG = "AppWidgetHelper";

    public static final long getWidgetRefreshIntervalSecond() {
        Long longOrNull;
        String value = (String) ConfigManager.Companion.config().get(CONFIG_KEY_INTERVAL, (Object) null);
        return (value == null || (longOrNull = StringsKt.toLongOrNull(value)) == null) ? DEFAULT_WORK_INTERVAL_SECONDS : longOrNull.longValue();
    }

    public static final Object getHotWordWidgetApiData(Context context, Continuation<? super HotWordWidgetData> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AppWidgetHelperKt$getHotWordWidgetApiData$2(context, null), continuation);
    }

    public static final HotWordWidgetData getHorWordWidgetLocalData(Context context) {
        List<WidgetButtonData> list;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        String jsonString = sharedPreferences.getString(KEY_HOT_WORD_WIDGET_API, null);
        String str = jsonString;
        boolean z = false;
        if (str == null || str.length() == 0) {
            return constructDefaultHotWordWidgetData(context);
        }
        try {
            HotWordWidgetData data = (HotWordWidgetData) JSONObject.parseObject(jsonString, HotWordWidgetData.class);
            if (data != null && (list = data.buttons) != null && (!list.isEmpty())) {
                z = true;
            }
            if (z) {
                return data;
            }
            return constructDefaultHotWordWidgetData(context);
        } catch (Exception e) {
            BLog.e(TAG, "getHotWordCache parse error: " + e);
            return constructDefaultHotWordWidgetData(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveHotWordCache(Context context, HotWordWidgetData data) {
        List<WidgetButtonData> list = data.buttons;
        if (list == null || list.isEmpty()) {
            BLog.i(TAG, "saveHotWordCache error data");
            return;
        }
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        String jsonString = JSONObject.toJSONString(data);
        BLog.i(TAG, "saveHotWordCache " + jsonString);
        sharedPreferences.edit().putString(KEY_HOT_WORD_WIDGET_API, jsonString).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HotWordWidgetData constructDefaultHotWordWidgetData(Context context) {
        HotWordWidgetData $this$constructDefaultHotWordWidgetData_u24lambda_u240 = new HotWordWidgetData();
        $this$constructDefaultHotWordWidgetData_u24lambda_u240.hotWord = context.getString(R.string.homepage_global_string_57);
        $this$constructDefaultHotWordWidgetData_u24lambda_u240.buttons = CollectionsKt.listOf(new WidgetButtonData[]{new WidgetButtonData("动态", "https://i0.hdslb.com/bfs/archive/226368baf32daa0341f9dde9162422c57b5998e5.png", "bilibili://root?bottom_tab_id=dynamic&dynamic_tab_anchor=all&position=dynamic"), new WidgetButtonData("历史记录", "https://i0.hdslb.com/bfs/archive/65c129cdc1a914997d7f77ad5c007807a312b0cc.png", "bilibili://history?blockInTeen=1&position=history"), new WidgetButtonData("我的收藏", "https://i0.hdslb.com/bfs/archive/974ae1d1a058189d519a567c8571ce42d8292e74.png", "bilibili://main/favorite?blockInTeen=1&position=fav"), new WidgetButtonData("稍后再看", "https://i0.hdslb.com/bfs/archive/9f4d8f83ff3fe58a63e4ab4411eb2b0526768790.png", "bilibili://user_center/watch_later_v2?blockInTeen=1&position=watchlater")});
        return $this$constructDefaultHotWordWidgetData_u24lambda_u240;
    }

    public static final HotWordLocalWidgetData getLocalDefaultHotWordWidgetData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.homepage_global_string_57);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new HotWordLocalWidgetData(string, CollectionsKt.listOf(new ButtonData[]{new ButtonData("动态", tv.danmaku.bili.R.drawable.ic_widget_dynamic, "bilibili://root?bottom_tab_id=dynamic&dynamic_tab_anchor=all&position=dynamic"), new ButtonData("历史记录", tv.danmaku.bili.R.drawable.ic_widget_history, "bilibili://history?blockInTeen=1&position=history"), new ButtonData("我的收藏", tv.danmaku.bili.R.drawable.ic_widget_favorites, "bilibili://main/favorite?blockInTeen=1&position=fav"), new ButtonData("稍后再看", tv.danmaku.bili.R.drawable.ic_widget_watch_later, "bilibili://user_center/watch_later_v2?blockInTeen=1&position=watchlater")}), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HotWordWidgetData getHotWordWidgetApiDataCache(Context context) {
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        String cache = sharedPreferences.getString(KEY_HOT_WORD_WIDGET_API, null);
        if (cache == null) {
            return null;
        }
        try {
            return (HotWordWidgetData) JSONObject.parseObject(cache, HotWordWidgetData.class);
        } catch (Exception e) {
            BLog.e(TAG, "getHotWordWidgetApiDataCache exp", e);
            return null;
        }
    }

    public static final boolean onHotWordUpdate(Context context, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (appWidgetIds == null) {
            return false;
        }
        HotWorldConfigHolder hotWordConfig = getHotWordConfig(context);
        HashSet ids = hotWordConfig.getIds();
        if (ids == null) {
            ids = new HashSet();
        }
        hotWordConfig.setIds(ids);
        boolean hasNew = false;
        for (int element$iv : appWidgetIds) {
            if (!ids.contains(Integer.valueOf(element$iv))) {
                ids.add(Integer.valueOf(element$iv));
                hasNew = true;
            }
        }
        putHotWordConfig(context, hotWordConfig);
        return hasNew;
    }

    public static final void onHotWordDelete(Context context, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (appWidgetIds == null) {
            return;
        }
        HotWorldConfigHolder hotWordConfig = getHotWordConfig(context);
        HashSet ids = hotWordConfig.getIds();
        if (ids == null) {
            ids = new HashSet();
        }
        hotWordConfig.setIds(ids);
        for (int element$iv : appWidgetIds) {
            ids.remove(Integer.valueOf(element$iv));
        }
        putHotWordConfig(context, hotWordConfig);
    }

    private static final HotWorldConfigHolder getHotWordConfig(Context context) {
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        HotWorldConfigHolder ret = null;
        String config = sharedPreferences.getString(KEY_HOT_WORD_WIDGET_CONFIG, null);
        if (config == null) {
            return new HotWorldConfigHolder();
        }
        try {
            ret = (HotWorldConfigHolder) JSONObject.parseObject(config, HotWorldConfigHolder.class);
        } catch (Exception e) {
        }
        return ret == null ? new HotWorldConfigHolder() : ret;
    }

    private static final void putHotWordConfig(Context context, HotWorldConfigHolder holder) {
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        String jsonString = JSONObject.toJSONString(holder);
        BLog.i(TAG, "putHotWordConfig " + jsonString);
        sharedPreferences.edit().putString(KEY_HOT_WORD_WIDGET_CONFIG, jsonString).apply();
    }
}