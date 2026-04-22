package tv.danmaku.bili.appwidget.hotlist.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: RouterUtil.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"TAG", "", "HOT_LIST_REPORT_PARAMS", "OPPO_HOT_LIST_REPORT_PARAMS", "URL_OPEN_MAIN", "HOT_LIST_REPORT_BUSINESS", "HOT_LIST_REPORT_OTHER_BUSINESS", "HOT_LIST_CLICK_BLOCK_PICTURE", "HOT_LIST_REPORT_SEARCH_BUSINESS", "HOT_LIST_REPORT_CARD_BUSINESS", "HOT_LIST_REPORT_BILI_BUSINESS", "HOT_LIST_REPORT_PARAM_AVID", "HOT_LIST_REPORT_PARAM_INDEX", "HOT_LIST_WIDGET_SPMID", "OPPO_HOT_LIST_WIDGET_SPMID", "IVK_FROM_KEY", "IVK_FORM_OPPO_PLUGIN", "IVK_FORM_WIDGET", "IVK_FORM_WIDGET_CARD", "openMain", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "ivkFrom", "Ltv/danmaku/bili/appwidget/hotlist/utils/IVKFrom;", "appendIvkFromIfNotExist", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouterUtilKt {
    public static final String HOT_LIST_CLICK_BLOCK_PICTURE = "hot_list_click_block_picture";
    public static final String HOT_LIST_REPORT_BILI_BUSINESS = "hot_list_report_bili_business";
    public static final String HOT_LIST_REPORT_BUSINESS = "hot_list_report_business";
    public static final String HOT_LIST_REPORT_CARD_BUSINESS = "hot_list_report_card_business";
    public static final String HOT_LIST_REPORT_OTHER_BUSINESS = "hot_list_report_other_business";
    public static final String HOT_LIST_REPORT_PARAMS = "hot_list_report_params";
    public static final String HOT_LIST_REPORT_PARAM_AVID = "hot_list_report_param_avid";
    public static final String HOT_LIST_REPORT_PARAM_INDEX = "hot_list_report_param_index";
    public static final String HOT_LIST_REPORT_SEARCH_BUSINESS = "hot_list_report_search_business";
    public static final String HOT_LIST_WIDGET_SPMID = "main.widgets-page.0.0";
    public static final String IVK_FORM_OPPO_PLUGIN = "plug_in_card";
    public static final String IVK_FORM_WIDGET = "widget";
    public static final String IVK_FORM_WIDGET_CARD = "widget-card";
    public static final String IVK_FROM_KEY = "ivk_from";
    public static final String OPPO_HOT_LIST_REPORT_PARAMS = "oppo_hot_list_report_params";
    public static final String OPPO_HOT_LIST_WIDGET_SPMID = "main.plug-in-card.0.0";
    private static final String TAG = "HotListAppWidgetRouter";
    public static final String URL_OPEN_MAIN = "bilibili://root";

    public static final void openMain(Activity activity, IVKFrom ivkFrom) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(ivkFrom, "ivkFrom");
        try {
            BLog.i(TAG, "open main by startActivity.");
            PackageManager packageManager = activity.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            Intent intent = packageManager.getLaunchIntentForPackage(activity.getPackageName());
            if (intent != null) {
                intent.putExtra("blrouter.pureurl", appendIvkFromIfNotExist("bilibili://root", ivkFrom));
            }
            activity.startActivity(intent);
        } catch (Exception e) {
            BLog.e(TAG, "open main by startActivity exception", e);
        }
    }

    public static final String appendIvkFromIfNotExist(String $this$appendIvkFromIfNotExist, IVKFrom ivkFrom) {
        Intrinsics.checkNotNullParameter($this$appendIvkFromIfNotExist, "<this>");
        Intrinsics.checkNotNullParameter(ivkFrom, "ivkFrom");
        Uri uri = Uri.parse($this$appendIvkFromIfNotExist);
        Uri.Builder uriBuilder = uri.buildUpon();
        String queryParameter = uri.getQueryParameter("ivk_from");
        if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
            uriBuilder.appendQueryParameter("ivk_from", ivkFrom.getValue());
        }
        String uri2 = uriBuilder.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        return uri2;
    }
}