package tv.danmaku.bili.ui;

import android.net.Uri;
import com.bilibili.app.accountui.BuildConfig;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

public class AccountReportHelper {
    private static final String TAG = "SpaceReportHelper";
    public static final String TASK_ID_GENERAL_EVENT = "000225";
    public static final String TASK_ID_VISIT_EVENT = "000377";

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class EventID {
        public static String LOGIN_CAPTCHA = "login_captcha";
        public static String LOGIN_SUBMIT_CLICK = "login_submit_click";
        public static String LOGIN_REGISTER_CLICK = "login_register_click";
        public static String LOGIN_FORGETPWD_CLICK = "login_forgetpwd_click";
        public static String LOGIN_FORGETPWD_PHONE_CLICK = "login_forgetpwd_phone_click";
        public static String LOGIN_FORGETPWD_PHONE_CAPTCHA = "login_forgetpwd_phone_captcha";
        public static String LOGIN_FORGETPWD_SMSCAPTCHA_RETRY = "login_forgetpwd_smscaptcha_retry";
        public static String LOGIN_FORGETPWD_SMSCAPTCHA_CHECK = "login_forgetpwd_smscaptcha_check";
        public static String LOGIN_FORGETPWD_RESETPWD_CLICK = "login_forgetpwd_resetpwd_click";
        public static String LOGIN_FORGETPWD_RESETPWD_SUCCESS = "login_forgetpwd_resetpwd_success";
        public static String REGISTER_AGREEMENT_CLICK = "register_agreement_click";
        public static String REGISTER_PHONE_CLICK = "register_phone_click";
        public static String REGISTER_PHONE_CAPTCHA = "register_phone_captcha";
        public static String REGISTER_COUNTRY_CLICK = "register_country_click";
        public static String REGISTER_COUNTRY_SELECT = "register_country_select";
        public static String REGISTER_SMSCAPTCHA_RETRY = "register_smscaptcha_retry";
        public static String REGISTER_SMSCAPTCHA_CHECK = "register_smscaptcha_check";
        public static String REGISTER_USERINFO_CHECK = "register_userinfo_check";
        public static String REGISTER_USERINFO_SUCCESS = "register_userinfo_success";
        public static String QUICKREGISTER_SHOW = "quickregister_show";
        public static String QUICKREGISTER_SUCCESS = "quickregister_success";
        public static String QUICKREGISTER_FAIL = "quickregister_fail";
        public static String LOGIN_SHOW = "login_show";
        public static String LOGIN_FORGETPWD_PHONE_SHOW = "login_forgetpwd_phone_show";
        public static String LOGIN_FORGETPWD_SMSCAPTCHA_SHOW = "login_forgetpwd_smscaptcha_show";
        public static String LOGIN_FORGETPWD_RESETPWD_SHOW = "login_forgetpwd_resetpwd_show";
        public static String REGISTER_PHONE_SHOW = "register_phone_show";
        public static String REGISTER_SMSCAPTCHA_SHOW = "register_smscaptcha_show";
        public static String REGISTER_USERINFO_SHOW = "register_userinfo_show";
    }

    public static void report(Event event) {
        InfoEyesManager.getInstance().report2(false, event.taskId, event.asParams());
        if (BuildConfig.DEBUG) {
            BLog.d(TAG, event.toString());
        }
    }

    public static void report(Event event, boolean forceReport) {
        InfoEyesManager.getInstance().report2(forceReport, event.taskId, event.asParams());
        if (BuildConfig.DEBUG) {
            BLog.d(TAG, event.toString());
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Event {
        public String arg1;
        public String arg2;
        public String arg3;
        public String arg4;
        public String arg5;
        public String eventId;
        public String eventType;
        public String taskId;

        public static Event obtainShow(String eventId) {
            return obtainEvent(eventId, ReportEvent.EVENT_TYPE_SHOW, null, null, null, null, null, "000377");
        }

        public static Event obtainClick(String eventId, String arg1, String arg2) {
            return obtainEvent(eventId, "click", arg1, arg2, null, null, null, "000225");
        }

        public static Event obtainTime(String eventId, String arg1, String arg2) {
            return obtainEvent(eventId, "times", arg1, arg2, null, null, null, "000225");
        }

        public static Event obtainEvent(String eventId, String eventType, String arg1, String arg2, String arg3, String arg4, String arg5, String taskId) {
            Event event = new Event();
            event.eventId = eventId;
            event.eventType = eventType;
            event.arg1 = arg1;
            event.arg2 = arg2;
            event.arg3 = arg3;
            event.arg4 = arg4;
            event.arg5 = arg5;
            event.taskId = taskId;
            return event;
        }

        public String[] asParams() {
            return new String[]{Uri.encode(this.eventId), Uri.encode(this.eventType), Uri.encode(this.arg1), Uri.encode(this.arg2), Uri.encode(this.arg3), Uri.encode(this.arg4), Uri.encode(this.arg5)};
        }

        public String toString() {
            return "Event{eventId='" + this.eventId + "', eventType='" + this.eventType + "', taskId='" + this.taskId + "', arg1='" + this.arg1 + "', arg2='" + this.arg2 + "', arg3='" + this.arg3 + "', arg4='" + this.arg4 + "', arg5='" + this.arg5 + "'}";
        }
    }
}