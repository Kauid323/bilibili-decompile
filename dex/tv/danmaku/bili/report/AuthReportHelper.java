package tv.danmaku.bili.report;

import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.app.auth.BuildConfig;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

public class AuthReportHelper {
    private static final String TAG = "AuthReportHelper";
    public static final String TASK_ID_GENERAL_EVENT = "000394";

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class EventID {
        public static final String REALNAME_FAILURE_CLICKRETRY = "realname_failure_clickretry";
        public static final String REALNAME_FAILURE_ERRTYPE = "realname_failure_errtype";
        public static final String REALNAME_FAILURE_SHOW = "realname_failure_show";
        public static final String REALNAME_MAYIBACK_SHOW = "realname_mayiback_show";
        public static final String REALNAME_MAYIFORMPAGE_CAPTCHA_SHOW = "realname_mayiformpage_captcha_show";
        public static final String REALNAME_MAYIFORMPAGE_CLICKSMS = "realname_mayiformpage_clicksms";
        public static final String REALNAME_MAYIFORMPAGE_CLICKSUBMIT = "realname_mayiformpage_clicksubmit";
        public static final String REALNAME_MAYIFORMPAGE_SHOW = "realname_mayiformpage_show";
        public static final String REALNAME_SELECTPAGE_CLICKMAYI = "realname_selectpage_clickmayi";
        public static final String REALNAME_SELECTPAGE_CLICKOLD = "realname_selectpage_clickold";
        public static final String REALNAME_SELECTPAGE_NOALIPAY = "realname_selectpage_noalipay";
        public static final String REALNAME_SELECTPAGE_SHOW = "realname_selectpage_show";
        public static final String REALNAME_SUCCESS_SHOW = "realname_success_show";
    }

    public static void report(Event event) {
        if (event == null || TextUtils.isEmpty(event.taskId)) {
            return;
        }
        InfoEyesManager.getInstance().report2(false, event.taskId, event.asParams());
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
            return obtainEvent(eventId, ReportEvent.EVENT_TYPE_SHOW, null, null, null, null, null, "000394");
        }

        public static Event obtainShow(String eventId, String arg1) {
            return obtainEvent(eventId, ReportEvent.EVENT_TYPE_SHOW, arg1, null, null, null, null, "000394");
        }

        public static Event obtainClick(String eventId) {
            return obtainEvent(eventId, "click", null, null, null, null, null, "000394");
        }

        public static Event obtainClick(String eventId, String arg1) {
            return obtainEvent(eventId, "click", arg1, null, null, null, null, "000394");
        }

        public static Event obtainTime(String eventId) {
            return obtainEvent(eventId, "times", null, null, null, null, null, "000394");
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