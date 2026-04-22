package tv.danmaku.bili.auth;

import kotlin.Deprecated;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthConstants;", "", "<init>", "()V", "AUTH_FAILED_CODE", "", "AUTH_SUCCESS_CODE", "AUTH_ING_CODE", "AUTH_COMPLETED_CODE", "getAUTH_COMPLETED_CODE$annotations", "AUTH_CANCEL_CODE", "RESULT_KEY_V2", "", "AUTH_IDENTIFY_HOME", "AUTH_IDENTIFY_DEFAULT", "AUTH_IDENTIFY_REALNAME_DEFAULT", "BUNDLE_KEY_SOURCE_EVENT", "BUNDLE_KEY_AFTER_14", "BUNDLE_KEY_MID", "BUNDLE_KEY_TEMP_CODE", "AUTH_KEY_DEGRADE", "AUTH_KEY_JS_RESULT", "SOURCE_EVENT_MTC", "SOURCE_EVENT_PC", "SOURCE_EVENT_PC_MAIN", "SOURCE_EVENT_PC_GAME", "SOURCE_EVENT_PC_FACIAL_ONLY", "SOURCE_EVENT_PANGU", "BUNDLE_CUSTOM_TASK", "BUNDLE_TASK_NAME", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthConstants {
    public static final int AUTH_CANCEL_CODE = -1;
    public static final int AUTH_COMPLETED_CODE = 3;
    public static final int AUTH_FAILED_CODE = 0;
    public static final String AUTH_IDENTIFY_DEFAULT = "https://www.bilibili.com/h5/identify/submit";
    public static final String AUTH_IDENTIFY_HOME = "https://www.bilibili.com/h5/identify/home";
    public static final String AUTH_IDENTIFY_REALNAME_DEFAULT = "https://account.bilibili.com/h5/account-h5/realname/index";
    public static final int AUTH_ING_CODE = 2;
    public static final String AUTH_KEY_DEGRADE = "key_degrade";
    public static final String AUTH_KEY_JS_RESULT = "jsb_result";
    public static final int AUTH_SUCCESS_CODE = 1;
    public static final String BUNDLE_CUSTOM_TASK = "customTask";
    public static final String BUNDLE_KEY_AFTER_14 = "after14";
    public static final String BUNDLE_KEY_MID = "mid";
    public static final String BUNDLE_KEY_SOURCE_EVENT = "source_event";
    public static final String BUNDLE_KEY_TEMP_CODE = "key_temp_code";
    public static final String BUNDLE_TASK_NAME = "taskActivityName";
    public static final BiliAuthConstants INSTANCE = new BiliAuthConstants();
    public static final String RESULT_KEY_V2 = "auth_result_code";
    public static final String SOURCE_EVENT_MTC = "1";
    public static final String SOURCE_EVENT_PANGU = "16";
    public static final String SOURCE_EVENT_PC = "200";
    public static final String SOURCE_EVENT_PC_FACIAL_ONLY = "400";
    public static final String SOURCE_EVENT_PC_GAME = "13";
    public static final String SOURCE_EVENT_PC_MAIN = "12";

    @Deprecated(message = "use AUTH_SUCCESS_CODE")
    public static /* synthetic */ void getAUTH_COMPLETED_CODE$annotations() {
    }

    private BiliAuthConstants() {
    }
}