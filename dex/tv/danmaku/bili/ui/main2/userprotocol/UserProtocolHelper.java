package tv.danmaku.bili.ui.main2.userprotocol;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import bili.resource.homepage.R;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.util.GlobalNetworkController;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.router.Router;
import com.bilibili.teenagersmode.TeenagersModeManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.utils.NetworkController;

public class UserProtocolHelper {
    private static final String PREF_KEY_HAS_SAVED_REPORT_DATA = "pref_key_use_privacy_has_saved_report_data";
    private static final String PREF_KEY_USE_PRIVACY_UPDATE_LOCAL = "pref_key_use_privacy_update_local";
    private static final String REPORT_DATA_FILE_NAME = "user_privacy_report.data";
    public static final int STEP_FIRST = 1;
    public static final int STEP_SECOND = 2;
    private static final int STYLE_DEFAULT = 0;
    private static final int STYLE_NEW = 1;
    private static final String TAG = "UserProtocolHelper";
    private static final String USER_PROTOCOL_AGREE_CLICK = "app.main-agreement-pop.yes.0.click";
    static final String USER_PROTOCOL_DISAGREE_CLICK = "app.main-agreement-pop.no.0.click";
    static final String USER_PROTOCOL_DISAGREE_EXIT_CLICK = "app.main-secondagreement-pop.quit.0.click";
    private static final String USER_PROTOCOL_FIRST_SHOW = "app.main-agreement-pop.firstpv.0.show";
    static final String USER_PROTOCOL_SECOND_SHOW = "app.main-secondagreement-pop.secpv.0.show";
    static final String USER_PROTOCOL_URL_CLICK = "app.main-agreement-pop.urlclick.0.click";
    private static final String USE_PRIVACY_CASE = "use_privacy_case";
    private static final String USE_PRIVACY_CONTENT_FIRST = "use_privacy_content_first";
    private static final String USE_PRIVACY_CONTENT_SECOND = "use_privacy_content_second";
    private static final String USE_PRIVACY_STYLE = "use_privacy_style";
    private static final String USE_PRIVACY_TITLE = "use_privacy_title";
    private static final String USE_PRIVACY_UPDATE = "use_privacy_update";
    static final int USE_PRIVACY_UPDATE_INVALID = -1;
    public static boolean isDialogShowing = false;
    private static List<ReportEvent> sDelayReport = new ArrayList();
    public static boolean showIntercept = false;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class H5Urls {
        private static final String DEFAULT_PRIVACY_POLICY_URL = "https://www.bilibili.com/blackboard/activity-yYWJeOsIDP.html";
        private static final String DEFAULT_USER_PROTOCOL_URL = "https://www.bilibili.com/blackboard/account-useragreement.html";

        public static String getUserProtocolUrl() {
            return "https://www.bilibili.com/blackboard/account-useragreement.html";
        }

        public static String getPrivacyPolicyUrl() {
            return DEFAULT_PRIVACY_POLICY_URL;
        }
    }

    public static boolean shouldShowDialog(Activity activity) {
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity);
        int privacyUpdateLocal = sharedPreferences.getInt(PREF_KEY_USE_PRIVACY_UPDATE_LOCAL, 0);
        if (privacyUpdateLocal == 0) {
            return true;
        }
        int privacyUpdateRemote = getCurrentVersionFromConfig();
        if (privacyUpdateLocal != -1) {
            return OnlineParamsHelper.enableUserProtocol() && privacyUpdateLocal != privacyUpdateRemote;
        }
        if (privacyUpdateRemote > 0) {
            setUserAgreeVersion(activity, privacyUpdateRemote);
        }
        return false;
    }

    public static void showDialog(Activity activity, UserProtocolDialogListener listener, String from) {
        if (activity.isFinishing()) {
            return;
        }
        UserProtocolDialog dialog = new UserProtocolDialog(activity);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UserProtocolHelper.lambda$showDialog$0(dialogInterface);
            }
        });
        dialog.setOnProtocolListener(listener);
        isDialogShowing = true;
        TeenagersModeManager.getInstance().setUserProtocolShowing(true);
        GarbManagerDelegate.setOtherDialogShowing(true);
        try {
            dialog.show();
        } catch (Exception e) {
            BLog.e(TAG, e);
        }
        reportUserProtocolDialogShow(USER_PROTOCOL_FIRST_SHOW, true ^ GlobalNetworkController.isNetworkAllowed());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showDialog$0(DialogInterface dialog12) {
        isDialogShowing = false;
        TeenagersModeManager.getInstance().setUserProtocolShowing(false);
    }

    public static void showBlockDialog(Activity activity, UserProtocolDialogListener listener, String from) {
        showBlockDialog(activity, listener, from, false);
    }

    public static void showBlockDialog(Activity activity, UserProtocolDialogListener listener, final String from, boolean showBackground) {
        if (activity.isFinishing()) {
            return;
        }
        NetworkController.setNetworkAllow(true);
        UserProtocolBlockDialogEntrepot.INSTANCE.setFrom(from);
        UserProtocolBlockDialogEntrepot.INSTANCE.addUserProtocolDialogListener(listener);
        UserProtocolBlockDialogEntrepot.INSTANCE.setShowBackground(showBackground);
        UserProtocolBlockDialog dialog = new UserProtocolBlockDialog(activity);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UserProtocolHelper.lambda$showBlockDialog$1(from, dialogInterface);
            }
        });
        try {
            dialog.show();
        } catch (Exception e) {
            BLog.e(TAG, e);
        }
        isDialogShowing = true;
        reportUserProtocolDialogShow(USER_PROTOCOL_FIRST_SHOW, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showBlockDialog$1(String from, DialogInterface dialog1) {
        isDialogShowing = false;
        UserDialogDismissWatcher.onDismissNotify(from);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUserAgreeVersion(Context context, int agreeCurrentVersion) {
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putInt(PREF_KEY_USE_PRIVACY_UPDATE_LOCAL, agreeCurrentVersion).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getCurrentVersionFromConfig() {
        return OnlineParamsHelper.getConfigInt(USE_PRIVACY_UPDATE, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDialogTitle(Context context) {
        String content = OnlineParamsHelper.getConfigString(USE_PRIVACY_TITLE, null);
        if (TextUtils.isEmpty(content)) {
            return context.getString(R.string.homepage_global_string_28);
        }
        return content;
    }

    private static String getContentFirst(Context context) {
        String content = OnlineParamsHelper.getConfigString(USE_PRIVACY_CONTENT_FIRST, null);
        if (TextUtils.isEmpty(content)) {
            return context.getString(R.string.homepage_global_string_48);
        }
        return content;
    }

    private static String getContentSecond(Context context) {
        String content = OnlineParamsHelper.getConfigString(USE_PRIVACY_CONTENT_SECOND, null);
        if (TextUtils.isEmpty(content)) {
            return context.getString(R.string.homepage_global_string_65);
        }
        return content;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getContent(Context context, boolean isFirst) {
        if (isFirst) {
            return getContentFirst(context);
        }
        return getContentSecond(context);
    }

    public static SpannableStringBuilder getPrivacyInfo(Context context, boolean isFirst) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        PrivacyInfo privacyInfo = null;
        try {
            String objectJson = OnlineParamsHelper.getConfigString(USE_PRIVACY_CASE, null);
            if (!TextUtils.isEmpty(objectJson)) {
                privacyInfo = (PrivacyInfo) JSONObject.parseObject(objectJson, PrivacyInfo.class);
            }
            if (privacyInfo != null && privacyInfo.isValid()) {
                String begin = privacyInfo.begin;
                builder.append((CharSequence) begin);
                String end = privacyInfo.end;
                List<PrivacyInfo.PrivacyLinkInfo> linkInfos = privacyInfo.link;
                int size = linkInfos.size();
                for (int i = 0; i < size; i++) {
                    PrivacyInfo.PrivacyLinkInfo info = linkInfos.get(i);
                    if (i == size - 1) {
                        builder.append((CharSequence) getLinkString(context, info.name, info.url, i, isFirst));
                    } else {
                        builder.append((CharSequence) getLinkString(context, info.name, info.url, i, isFirst));
                        builder.append((CharSequence) context.getString(R.string.homepage_global_string_70));
                    }
                }
                builder.append((CharSequence) end);
                return builder;
            }
            builder.append((CharSequence) getDefaultLinkString(context, isFirst));
            return builder;
        } catch (JSONException e) {
            BLog.d(TAG, e.getMessage());
            builder.append((CharSequence) getDefaultLinkString(context, isFirst));
            return builder;
        }
    }

    private static SpannableStringBuilder getDefaultLinkString(final Context context, final boolean isFirst) {
        String defaultContent = context.getString(R.string.homepage_global_string_45);
        String defaultPolicy = context.getString(R.string.homepage_global_string_62);
        String defaultUser = context.getString(R.string.homepage_global_string_17);
        SpannableStringBuilder ss = new SpannableStringBuilder(defaultContent);
        int linkColor = ContextCompat.getColor(context, com.bilibili.lib.ui.R.color.text_blue_kit);
        int userStartIndex = defaultContent.indexOf(defaultUser);
        final boolean isNetworkAllow = GlobalNetworkController.isNetworkAllowed();
        if (userStartIndex != -1) {
            ss.setSpan(new ForegroundColorSpan(linkColor), userStartIndex, defaultUser.length() + userStartIndex, 33);
            ss.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    if (isNetworkAllow) {
                        Router.global().with(context).with(Uri.parse(H5Urls.getUserProtocolUrl())).open("activity://main/web");
                    } else {
                        UserProtocolHelper.openLocalBrowser(context, H5Urls.getUserProtocolUrl());
                    }
                    UserProtocolHelper.reportUserProtocolDialogUrlClick(UserProtocolHelper.USER_PROTOCOL_URL_CLICK, "1", isFirst ? 1 : 2, true ^ isNetworkAllow);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    ds.setUnderlineText(false);
                    ds.bgColor = 0;
                }
            }, userStartIndex, defaultUser.length() + userStartIndex, 33);
        }
        int policyStartIndex = defaultContent.indexOf(defaultPolicy);
        if (policyStartIndex != -1) {
            ss.setSpan(new ForegroundColorSpan(linkColor), policyStartIndex, defaultPolicy.length() + policyStartIndex, 33);
            ss.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    if (isNetworkAllow) {
                        Router.global().with(context).with(Uri.parse(H5Urls.getPrivacyPolicyUrl())).open("activity://main/web");
                    } else {
                        UserProtocolHelper.openLocalBrowser(context, H5Urls.getPrivacyPolicyUrl());
                    }
                    UserProtocolHelper.reportUserProtocolDialogUrlClick(UserProtocolHelper.USER_PROTOCOL_URL_CLICK, "2", isFirst ? 1 : 2, true ^ isNetworkAllow);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    ds.setUnderlineText(false);
                    ds.bgColor = 0;
                }
            }, policyStartIndex, defaultPolicy.length() + policyStartIndex, 33);
        }
        return ss;
    }

    private static SpannableString getLinkString(final Context context, String name, final String link, final int i, final boolean isFirst) {
        SpannableString ss = new SpannableString(name);
        int end = name.length();
        ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, com.bilibili.lib.ui.R.color.text_blue_kit)), 0, end, 33);
        ss.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                boolean isNetworkAllow = GlobalNetworkController.isNetworkAllowed();
                if (isNetworkAllow) {
                    Router.global().with(context).with(Uri.parse(link)).open("activity://main/web");
                } else {
                    UserProtocolHelper.openLocalBrowser(context, link);
                }
                UserProtocolHelper.reportUserProtocolDialogUrlClick(UserProtocolHelper.USER_PROTOCOL_URL_CLICK, String.valueOf(i + 1), isFirst ? 1 : 2, !isNetworkAllow);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(false);
                ds.bgColor = 0;
            }
        }, 0, end, 33);
        return ss;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportConfirmClick(int step, int reason) {
        Map<String, String> extra = new HashMap<>(6);
        extra.put("step", String.valueOf(step));
        extra.put("seed", UserProtocolExperiment.getSeed());
        extra.put("page_type", UserProtocolExperiment.getGroupReportPageType());
        extra.put("reason", String.valueOf(reason));
        Map<String, String> reportData = UserProtocolExperiment.INSTANCE.getBizReportData();
        if (reportData != null) {
            if (reportData.containsKey("click_pos")) {
                extra.put("click_pos", reportData.get("click_pos"));
            }
            if (reportData.containsKey("avid")) {
                extra.put("avid", reportData.get("avid"));
            }
            if (reportData.containsKey("card_pos")) {
                extra.put("card_pos", reportData.get("card_pos"));
            }
        }
        Neurons.reportClick(false, USER_PROTOCOL_AGREE_CLICK, extra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportUserProtocolDialogClick(String eventId, boolean delay) {
        if (delay) {
            delayReport(eventId, "click", null);
            return;
        }
        BLog.d(TAG, "report click: " + eventId);
        Neurons.reportClick(false, eventId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportUserProtocolDialogShow(String eventId, boolean delay) {
        if (delay) {
            delayReport(eventId, ReportEvent.EVENT_TYPE_SHOW, null);
            return;
        }
        BLog.d(TAG, "report show: " + eventId);
        Neurons.reportExposure(false, eventId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportUserProtocolDialogUrlClick(String eventId, String index, int step, boolean delay) {
        Map<String, String> param = new HashMap<>();
        param.put("index", index);
        param.put("step", String.valueOf(step));
        if (delay) {
            delayReport(eventId, "click", param);
            return;
        }
        BLog.d(TAG, "report click: " + eventId);
        Neurons.reportClick(false, eventId, param);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNewStyle() {
        return OnlineParamsHelper.getConfigInt(USE_PRIVACY_STYLE, 0) == 1;
    }

    public static void openLocalBrowser(Context context, String url) {
        Uri uri = Uri.parse(url).buildUpon().appendQueryParameter("navhide", "1").build();
        BLRouter.routeTo(new RouteRequest.Builder(uri).build(), context);
    }

    public static void onInterceptDialogDismiss() {
        showIntercept = false;
        ClipboardChecker.notifyCheck();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class PrivacyInfo {
        @JSONField(name = "begin")
        public String begin;
        @JSONField(name = "end")
        public String end;
        @JSONField(name = "link")
        public List<PrivacyLinkInfo> link;

        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static class PrivacyLinkInfo {
            @JSONField(name = ChannelRoutes.CHANNEL_NAME)
            public String name;
            @JSONField(name = "url")
            public String url;
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.begin) || TextUtils.isEmpty(this.end) || !isValid(this.link)) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean isValid(List<PrivacyLinkInfo> link) {
            if (link == null) {
                return false;
            }
            for (PrivacyLinkInfo linkInfo : link) {
                if (TextUtils.isEmpty(linkInfo.name) || TextUtils.isEmpty(linkInfo.url)) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            return true;
        }
    }

    static void delayReport(String eventId, String eventType, Map<String, String> extra) {
        sDelayReport.add(new ReportEvent(eventId, eventType, extra));
    }

    public static void syncReportDataToDisk(Context context) {
        List<ReportEvent> localData;
        boolean needReadLocal = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_HAS_SAVED_REPORT_DATA, false);
        if (needReadLocal && (localData = readLocalData(context)) != null && !localData.isEmpty()) {
            sDelayReport.addAll(localData);
        }
        if (sDelayReport.isEmpty()) {
            return;
        }
        saveLocalData(context, sDelayReport);
        sDelayReport.clear();
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_HAS_SAVED_REPORT_DATA, true).apply();
    }

    public static boolean hasDelayReport() {
        return !sDelayReport.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void delayReportIfNeed(Context context) {
        char c;
        List<ReportEvent> localData;
        boolean needReadLocal = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_HAS_SAVED_REPORT_DATA, false);
        if (needReadLocal && (localData = readLocalData(context)) != null && !localData.isEmpty()) {
            sDelayReport.addAll(localData);
        }
        if (sDelayReport.isEmpty()) {
            return;
        }
        for (ReportEvent reportEvent : sDelayReport) {
            String str = reportEvent.eventType;
            switch (str.hashCode()) {
                case 3529469:
                    if (str.equals(ReportEvent.EVENT_TYPE_SHOW)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c = 0;
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
                    BLog.d(TAG, "delay report click: " + reportEvent.eventId);
                    Neurons.reportClick(false, reportEvent.eventId, reportEvent.extra);
                    break;
                case 1:
                    BLog.d(TAG, "delay report show: " + reportEvent.eventId);
                    Neurons.reportExposure(false, reportEvent.eventId, reportEvent.extra);
                    break;
            }
        }
        deleteLocalData(context);
        sDelayReport.clear();
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().remove(PREF_KEY_HAS_SAVED_REPORT_DATA).apply();
    }

    private static List<ReportEvent> readLocalData(Context context) {
        File file = new File(context.getFilesDir(), REPORT_DATA_FILE_NAME);
        if (file.exists()) {
            try {
                return JSONObject.parseArray(FileUtils.readFileToString(file), ReportEvent.class);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static void saveLocalData(Context context, List<ReportEvent> reportData) {
        File file = new File(context.getFilesDir(), REPORT_DATA_FILE_NAME);
        try {
            FileUtils.writeStringToFile(file, JSONObject.toJSONString(reportData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteLocalData(Context context) {
        FileUtils.deleteQuietly(new File(context.getFilesDir(), REPORT_DATA_FILE_NAME));
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class UserDialogDismissWatcher {
        public static final String FROM_INTERCEPT = "intercept";
        public static final String FROM_SPLASH = "splash";
        private static List<UserProtocolDismissObserver> observers = new CopyOnWriteArrayList();

        public static void subscribe(UserProtocolDismissObserver observer) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }

        public static void unSubscribe(UserProtocolDismissObserver observer) {
            observers.remove(observer);
        }

        public static void onDismissNotify(String from) {
            for (UserProtocolDismissObserver observer : observers) {
                observer.onUserProtocolDismiss(from);
            }
        }
    }
}