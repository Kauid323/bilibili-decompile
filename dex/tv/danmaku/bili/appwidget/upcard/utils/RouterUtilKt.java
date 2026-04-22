package tv.danmaku.bili.appwidget.upcard.utils;

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
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TAG", "", "UP_CARD_REPORT_PARAMS", "UP_CARD_SINGLE_LIST_REPORT_PARAMS", "URL_OPEN_MAIN", "UP_CARD_REPORT_BUSINESS", "UP_CARD_SINGLE", "UP_CARD_SINGLE_V2", "UP_CARD_REPORT_OTHER_BUSINESS", "UP_CARD_REPORT_ALL_BUSINESS", "UP_CARD_CLICK_BLOCK_PICTURE", "UP_CARD_REPORT_CARD_BUSINESS", "UP_CARD_REPORT_MORE_BUSINESS", "UP_CARD_REPORT_PARAM_AVID", "UP_CARD_REPORT_PARAM_INDEX", "UP_CARD_REPORT_PARAM_POSITION", "UP_CARD_REPORT_PARAM_TYPE", "UP_CARD_WIDGET_SPMID", "IVK_FROM_KEY", "IVK_FORM_WIDGET_UP_SINGLE", "IVK_FROM_WIDGET_UP_SINGLE_V2", "IVK_FORM_WIDGET_UP_DOUBLE", "IVK_FORM_WIDGET_UP_NO_LOGIN", "IVK_FORM_WIDGET_UP_NO_UPDATE", "IVK_FORM_WIDGET_UP_TEEN_MODE", "IVK_FORM_WIDGET_UP_LESSON_MODE", "openMain", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "ivkFrom", "Ltv/danmaku/bili/appwidget/upcard/utils/IVKFrom;", "appendIvkFromIfNotExist", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouterUtilKt {
    public static final String IVK_FORM_WIDGET_UP_DOUBLE = "widget-follow-double";
    public static final String IVK_FORM_WIDGET_UP_LESSON_MODE = "widget-follow-lessonmode";
    public static final String IVK_FORM_WIDGET_UP_NO_LOGIN = "widget-follow-nologin";
    public static final String IVK_FORM_WIDGET_UP_NO_UPDATE = "widget-follow-noupdate";
    public static final String IVK_FORM_WIDGET_UP_SINGLE = "widget-follow-single";
    public static final String IVK_FORM_WIDGET_UP_TEEN_MODE = "widget-follow-teenmode";
    public static final String IVK_FROM_KEY = "ivk_from";
    public static final String IVK_FROM_WIDGET_UP_SINGLE_V2 = "widget-follow-single2";
    private static final String TAG = "UpCardAppWidgetRouter";
    public static final String UP_CARD_CLICK_BLOCK_PICTURE = "up_card_click_block_picture";
    public static final String UP_CARD_REPORT_ALL_BUSINESS = "up_card_report_all_business";
    public static final String UP_CARD_REPORT_BUSINESS = "up_card_report_business";
    public static final String UP_CARD_REPORT_CARD_BUSINESS = "up_card_report_card_business";
    public static final String UP_CARD_REPORT_MORE_BUSINESS = "up_card_report_more_business";
    public static final String UP_CARD_REPORT_OTHER_BUSINESS = "up_card_report_other_business";
    public static final String UP_CARD_REPORT_PARAMS = "up_card_report_params";
    public static final String UP_CARD_REPORT_PARAM_AVID = "up_card_report_param_avid";
    public static final String UP_CARD_REPORT_PARAM_INDEX = "up_card_report_param_index";
    public static final String UP_CARD_REPORT_PARAM_POSITION = "up_card_report_param_position";
    public static final String UP_CARD_REPORT_PARAM_TYPE = "up_card_report_param_type";
    public static final String UP_CARD_SINGLE = "up_card_single";
    public static final String UP_CARD_SINGLE_LIST_REPORT_PARAMS = "up_card_single_list_report_params";
    public static final String UP_CARD_SINGLE_V2 = "up_card_single_v2";
    public static final String UP_CARD_WIDGET_SPMID = "main.widgets-page.0.0";
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