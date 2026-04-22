package tv.danmaku.bili.quick.core;

import com.bilibili.lib.gripper.api.PreTrigger;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseStatus;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;

/* compiled from: OnePassLoginReportManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b \u001a\b\u0010\u0007\u001a\u00020\bH\u0007\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"EVENT_KEY_SPM_ID", "", "EVENT_KEY_IS_SUCCESS", "EVENT_KEY_FAIL_REASON", "EVENT_KEY_NET_TYPE", "EVENT_KEY_IS_CARD", "EVENT_KEY_IS_PAD", "initOnePassLoginReporter", "", "getNetworkOperatorNameFromType", "SPM_ID_INTEREST_SELECT", "SPM_ID_HOME_BOTTOM_DYNAMIC_BUTTON", "SPM_ID_MY_HISTORY", "SPM_ID_HOME_BOTTOM_PUBLISH", "SPM_ID_HOME_PAGE_AVATAR_NO_LOGIN", "SPM_ID_MINE_PAGE_NO_LOGIN", "SPM_ID_ENTER_HOME_PAGE", "SPM_ID_CHANGE_ACCOUNT", "INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO", "INTERRUPTED_FOR_THE_LOGIN_WAY_IS_NOT_QUICK_WAY", "INTERRUPTED_FOR_HIT_LOGIN_EXPERIMENT", "INTERRUPTED_FOR_GET_PHONE_INFO_WITH_ERROR", "INTERRUPTED_FOR_OPERATOR_DISALLOW", "INTERRUPTED_FOR_NOT_IN_HOME_PAGE", "INTERRUPTED_FOR_ALREADY_LOGIN", "INTERRUPTED_FOR_HIT_CONFIG", "INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE", "INTERRUPTED_FOR_HAS_NOT_BEEN_TO_VIDEO_PAGE", "INTERRUPTED_FOR_IN_TEENAGER_MODE", "INTERRUPTED_FOR_IN_COURSE_MODE", "INTERRUPTED_FOR_TEENAGER_MODE_LOGIN_INTERCEPTED", "INTERRUPTED_FOR_COURSE_MODE_LOGIN_INTERCEPTED", "INTERRUPTED_FOR_TIME_INTERVAL", "INTERRUPTED_FOR_EXCEEDED_THE_DISPLAY_TIMES", "INTERRUPTED_FOR_TRY_FAST_LOGIN", "INTERRUPTED_FOR_THE_REQUEST_TIME_OUT", "INTERRUPTED_FOR_ALREADY_TRIED_SHOW_IN_HOME_PAGE", "INTERRUPTED_FOR_ALREADY_SHOWN_FULLSCREEN_LOGIN", "INTERRUPTED_FOR_ALREADY_SHOWN_FULLSCREEN_LOGIN_DIALOG", "INTERRUPTED_FOR_SHOWING_FULLSCREEN_LOGIN_DIALOG", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginReportManagerKt {
    public static final String EVENT_KEY_FAIL_REASON = "fail_reason";
    public static final String EVENT_KEY_IS_CARD = "is_card";
    public static final String EVENT_KEY_IS_PAD = "is_pad";
    public static final String EVENT_KEY_IS_SUCCESS = "is_success";
    public static final String EVENT_KEY_NET_TYPE = "net_type";
    public static final String EVENT_KEY_SPM_ID = "spm_id";
    public static final String INTERRUPTED_FOR_ALREADY_LOGIN = "already login";
    public static final String INTERRUPTED_FOR_ALREADY_SHOWN_FULLSCREEN_LOGIN = "already shown fullscreen login page";
    public static final String INTERRUPTED_FOR_ALREADY_SHOWN_FULLSCREEN_LOGIN_DIALOG = "already shown fullscreen experiment login dialog";
    public static final String INTERRUPTED_FOR_ALREADY_TRIED_SHOW_IN_HOME_PAGE = "already tried show in home page";
    public static final String INTERRUPTED_FOR_COURSE_MODE_LOGIN_INTERCEPTED = "course mode login check failed";
    public static final String INTERRUPTED_FOR_EXCEEDED_THE_DISPLAY_TIMES = "exceeded the display times";
    public static final String INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO = "failed to get login info";
    public static final String INTERRUPTED_FOR_GET_PHONE_INFO_WITH_ERROR = "get phone info with error";
    public static final String INTERRUPTED_FOR_HAS_NOT_BEEN_TO_VIDEO_PAGE = "from start up but hasn't been to video page";
    public static final String INTERRUPTED_FOR_HIT_CONFIG = "hit config";
    public static final String INTERRUPTED_FOR_HIT_LOGIN_EXPERIMENT = "hit the login experiment";
    public static final String INTERRUPTED_FOR_IN_COURSE_MODE = "in course mode";
    public static final String INTERRUPTED_FOR_IN_TEENAGER_MODE = "in teenager mode";
    public static final String INTERRUPTED_FOR_NOT_IN_HOME_PAGE = "not in the home page";
    public static final String INTERRUPTED_FOR_OPERATOR_DISALLOW = "network operator disallow to quick login";
    public static final String INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE = "out of lifecycle scope";
    public static final String INTERRUPTED_FOR_SHOWING_FULLSCREEN_LOGIN_DIALOG = "stop for showing fullscreen experiment login dialog";
    public static final String INTERRUPTED_FOR_TEENAGER_MODE_LOGIN_INTERCEPTED = "teenager mode login check failed";
    public static final String INTERRUPTED_FOR_THE_LOGIN_WAY_IS_NOT_QUICK_WAY = "the login way is not a quick way";
    public static final String INTERRUPTED_FOR_THE_REQUEST_TIME_OUT = "the request time out";
    public static final String INTERRUPTED_FOR_TIME_INTERVAL = "last show time is too close to current time";
    public static final String INTERRUPTED_FOR_TRY_FAST_LOGIN = "try to login with last account fastly";
    public static final String SPM_ID_CHANGE_ACCOUNT = "main.setting.change-account.0";
    public static final String SPM_ID_ENTER_HOME_PAGE = "enter_homepage";
    public static final String SPM_ID_HOME_BOTTOM_DYNAMIC_BUTTON = "main.homepage.bottombar.dt";
    public static final String SPM_ID_HOME_BOTTOM_PUBLISH = "main.homepage.bottombar.publish";
    public static final String SPM_ID_HOME_PAGE_AVATAR_NO_LOGIN = "main.homepage.avatar-nologin.all.click";
    public static final String SPM_ID_INTEREST_SELECT = "main.interest-select.0.0";
    public static final String SPM_ID_MINE_PAGE_NO_LOGIN = "main.my-information.my-login.0.click";
    public static final String SPM_ID_MY_HISTORY = "main.my-information.history-entrance.0";

    @PreTrigger(trigger = "OnCreate")
    public static final void initOnePassLoginReporter() {
        OnePassLoginPathLinkManager.INSTANCE.registerPhaseStatusListener(new OnePassLoginPhaseStatusListener() { // from class: tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt$initOnePassLoginReporter$1
            @Override // tv.danmaku.bili.quick.core.OnePassLoginPhaseStatusListener
            public void onChange(String key, OnePassLoginPhaseStatus phaseStatus, OnePassLoginPhoneData data) {
                NetType netType;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(phaseStatus, "phaseStatus");
                String spmId = !Intrinsics.areEqual(key, OnePassLoginPathLinkManagerKt.NAMELESS) ? key : null;
                if (spmId == null) {
                    spmId = "";
                }
                OnePassLoginPhaseType phaseType = phaseStatus.getPhaseType();
                boolean z = true;
                if (Intrinsics.areEqual(phaseType, OnePassLoginPhaseType.Trigger.INSTANCE)) {
                    if (phaseStatus instanceof OnePassLoginPhaseStatus.Going) {
                        Neurons.reportClick(false, "app.onepass-login.request.0.click", MapsKt.mapOf(TuplesKt.to("spm_id", spmId)));
                    } else if (phaseStatus instanceof OnePassLoginPhaseStatus.Failed) {
                        Neurons.reportClick(false, "app.onepass-login.filter-result.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "0"), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_FAIL_REASON, ((OnePassLoginPhaseStatus.Failed) phaseStatus).getReason())}));
                    } else if (!(phaseStatus instanceof OnePassLoginPhaseStatus.Passed)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Neurons.reportClick(false, "app.onepass-login.filter-result.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "1")}));
                    }
                } else if (Intrinsics.areEqual(phaseType, OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE)) {
                    if (phaseStatus instanceof OnePassLoginPhaseStatus.Failed) {
                        Neurons.reportClick(false, "app.onepass-login.client-result.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "0"), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_FAIL_REASON, ((OnePassLoginPhaseStatus.Failed) phaseStatus).getReason())}));
                    } else if (phaseStatus instanceof OnePassLoginPhaseStatus.Passed) {
                        Neurons.reportClick(false, "app.onepass-login.client-result.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "1")}));
                    }
                } else if (Intrinsics.areEqual(phaseType, OnePassLoginPhaseType.CheckConditions.INSTANCE)) {
                    if (phaseStatus instanceof OnePassLoginPhaseStatus.Going) {
                        Neurons.reportClick(false, "app.onepass-login.sdk-request.0.click", MapsKt.mapOf(TuplesKt.to("spm_id", spmId)));
                    } else if (phaseStatus instanceof OnePassLoginPhaseStatus.Failed) {
                        Neurons.reportClick(false, "app.onepass-login.sdk-result.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "0"), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_FAIL_REASON, ((OnePassLoginPhaseStatus.Failed) phaseStatus).getReason())}));
                    } else if (!(phaseStatus instanceof OnePassLoginPhaseStatus.Passed)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Pair[] pairArr = new Pair[5];
                        pairArr[0] = TuplesKt.to("spm_id", spmId);
                        pairArr[1] = TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "1");
                        pairArr[2] = TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_PAD, data != null && data.isPad() ? "1" : "0");
                        if (data == null || !data.getHasSim()) {
                            z = false;
                        }
                        pairArr[3] = TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_CARD, z ? "1" : "0");
                        if (data == null || (netType = data.getNetType()) == null) {
                            netType = NetType.None;
                        }
                        pairArr[4] = TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_NET_TYPE, netType.getValue());
                        Neurons.reportClick(false, "app.onepass-login.sdk-result.0.click", MapsKt.mapOf(pairArr));
                    }
                } else if (Intrinsics.areEqual(phaseType, OnePassLoginPhaseType.GetNumberSuc.INSTANCE)) {
                    if (phaseStatus instanceof OnePassLoginPhaseStatus.Failed) {
                        Neurons.reportClick(false, "app.onepass-login.get-number-suc.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "0"), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_FAIL_REASON, ((OnePassLoginPhaseStatus.Failed) phaseStatus).getReason())}));
                    } else if (phaseStatus instanceof OnePassLoginPhaseStatus.Passed) {
                        Neurons.reportClick(false, "app.onepass-login.get-number-suc.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("spm_id", spmId), TuplesKt.to(OnePassLoginReportManagerKt.EVENT_KEY_IS_SUCCESS, "1")}));
                    }
                } else if (phaseType instanceof OnePassLoginPhaseType.DisplayLoginDialog) {
                    Pair[] pairArr2 = new Pair[2];
                    pairArr2[0] = TuplesKt.to("spm_id", spmId);
                    String loginSessionId = ((OnePassLoginPhaseType.DisplayLoginDialog) phaseStatus.getPhaseType()).getLoginSessionId();
                    pairArr2[1] = TuplesKt.to("login_session_id", loginSessionId != null ? loginSessionId : "");
                    Neurons.reportExposure$default(false, "app.onepass-login.0.0.show", MapsKt.mapOf(pairArr2), (List) null, 8, (Object) null);
                }
            }
        });
    }

    public static final String getNetworkOperatorNameFromType(String $this$getNetworkOperatorNameFromType) {
        Intrinsics.checkNotNullParameter($this$getNetworkOperatorNameFromType, "<this>");
        switch ($this$getNetworkOperatorNameFromType.hashCode()) {
            case BR.banner /* 49 */:
                if ($this$getNetworkOperatorNameFromType.equals("1")) {
                    return "MOBILE";
                }
                break;
            case BR.bannerControl /* 50 */:
                if ($this$getNetworkOperatorNameFromType.equals("2")) {
                    return "UNICOM";
                }
                break;
            case BR.bannerItemDataList /* 51 */:
                if ($this$getNetworkOperatorNameFromType.equals("3")) {
                    return "TELECOM";
                }
                break;
        }
        return "unknown";
    }
}