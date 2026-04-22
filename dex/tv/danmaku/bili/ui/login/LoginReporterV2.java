package tv.danmaku.bili.ui.login;

import android.text.TextUtils;
import com.bilibili.droid.AppsFlyerWrapper;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.report.LoginReportHelper;

public class LoginReporterV2 {
    public static final String ANSWER_FROM = "re_src re_src";
    public static final String APP_ONEPASS_GUIDE_KEY = "arg";
    public static final String APP_ONEPASS_KEY_OPERATOR = "operator";
    public static final String APP_ONEPASS_VALUE_OPERATOR_MOBILE = "1";
    public static final String APP_ONEPASS_VALUE_OPERATOR_TELECOM = "3";
    public static final String APP_ONEPASS_VALUE_OPERATOR_UNICOM = "2";
    public static final String CLICK_IS_AGREE_KEY = "is_agree";
    public static final String CLICK_IS_AGREE_VALUE_AGREE = "1";
    public static final String CLICK_IS_AGREE_VALUE_NOT_AGREE = "0";
    public static final String KEY_LOGIN_EXERIMENT_SCENE = "scene";
    public static final String MID_KEY = "mid";
    public static final String PAGE_FROM_KEY = "page";
    public static final String PAGE_FROM_VALUE_GENERAL = "1";
    public static final String PAGE_FROM_VALUE_PLAYER = "2";
    public static final String PAGE_TYPE_ONEPASS = "onepass-login";
    public static final String PAGE_TYPE_PWD = "pwd-login";
    public static final String PAGE_TYPE_SMS = "sms-login";
    public static final String PAGE_TYPE_SMS2 = "sms-login2";
    public static final String PROVISIOM_CLICK = "app.%s.provision-popup.0.click";
    public static final String PROVISIOM_SHOW = "app.%s.provision-popup.0.show";
    public static final String PROVISION_AGREE_KEY = "is_agree";
    public static final String SHOW_PROVISION_KEY = "show_provision";
    public static final String SHOW_PROVISION_VALUE_HIDE = "0";
    public static final String SHOW_PROVISION_VALUE_SHOW = "1";
    private static final String TAG = "LoginReporterV2:";
    public static final String TRIGGER_TYPE_KEY = "trigger_type";
    public static final String VALUE_GET_SMS = "getsms";
    public static final String VALUE_SUBMIT = "submit";

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class PV {
        public static final String APP_ONEPASS_LOGIN = "app.onepass-login.0.0";
        public static final String APP_ONEPASS_LOGIN_PV = "app.onepass-login.0.0.pv";
        public static final String APP_ONEPASS_LOGIN_PV_V2 = "app.onepass-login2.0.0.pv";
        public static final String APP_ONEPASS_LOGIN_V2 = "app.onepass-login2.0.0";
        public static final String APP_PWD_LOGIN_0_0_PV = "app.pwd-login.0.0.pv";
        public static final String APP_SIGNUPNA_0_0_PV = "app.signupna.0.0.pv";
        public static final String APP_SMS_LOGIN_0_0_PV = "app.sms-login.0.0.pv";
        public static final String SIGNUP_KEY_STEP = "step";
        public static final String SIGNUP_VALUT_STEP_PASSWORD_INPUT = "3";
        public static final String SIGNUP_VALUT_STEP_PHONE_INPUT = "1";
        public static final String SIGNUP_VALUT_STEP_SMS_INPUT = "2";

        public static void report(String eventId, Map<String, String> extension) {
            Neurons.reportPageView(true, eventId, "", 0, 0L, extension, 0L, 0L);
        }

        public static void report(String eventId) {
            Neurons.reportPageView(true, eventId, "", 0, 0L, new HashMap(), 0L, 0L);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Click {
        public static final String APP_FAST_RE_LOGIN_BTN_CLICK = "app.fast-login.option-btn.0.click";
        public static final String APP_LOGIN_ANSWER_ANSWER_IN_0_CLICK = "app.login-answer.answer-in.0.click";
        public static final String APP_LOGIN_ANSWER_SKIP_ANSWER_0_CLICK = "app.login-answer.skip-answer.0.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_AGREEMENT_CLICK = "app.onepass-login.onepass.agreement.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_AGREEMENT_CLICK_V2 = "app.onepass-login2.onepass2.agreement.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_AUTHORIZE_CLICK = "app.onepass-login.onepass.authorize.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_AUTHORIZE_CLICK_V2 = "app.onepass-login2.onepass2.authorize.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_CHANGE_CLICK = "app.onepass-login.onepass.change.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_CHANGE_CLICK_V2 = "app.onepass-login2.onepass2.change.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_CLOSE_CLICK = "app.onepass-login.onepass.close.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_CLOSE_CLICK_V2 = "app.onepass-login2.onepass2.close.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_OPERATOR_CLICK = "app.onepass-login.onepass.operator.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_OPERATOR_CLICK_V2 = "app.onepass-login2.onepass2.operator.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_PRIVACY_CLICK = "app.onepass-login.onepass.privacy.click";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_PRIVACY_CLICK_V2 = "app.onepass-login2.onepass2.privacy.click";
        public static final String APP_ONE_PASS_LOGIN_GUIDE_CLICK = "main.homepage.onepass-popup.all.click";
        public static final String APP_PWD_LOGIN_FORGOT_0_CLICK = "app.pwd-login.forgot.0.click";
        public static final String APP_PWD_LOGIN_FORGOT_MAIL_CLICK = "app.pwd-login.forgot.mail.click";
        public static final String APP_PWD_LOGIN_FORGOT_PHONE_CLICK = "app.pwd-login.forgot.phone.click";
        public static final String APP_PWD_LOGIN_HELP_0_CLICK = "app.pwd-login.help.0.click";
        public static final String APP_PWD_LOGIN_LOGIN_0_CLICK = "app.pwd-login.login.0.click";
        public static final String APP_PWD_LOGIN_ONEPASSLOGIN_0_CLICK = "app.pwd-login.onepasslogin.0.click";
        public static final String APP_PWD_LOGIN_PACT_AGREEMENT_CLICK = "app.pwd-login.pact.agreement.click";
        public static final String APP_PWD_LOGIN_PACT_PRIVACY_CLICK = "app.pwd-login.pact.privacy.click";
        public static final String APP_PWD_LOGIN_SIGNUP_0_CLICK = "app.pwd-login.signup.0.click";
        public static final String APP_PWD_LOGIN_SMS_0_CLICK = "app.pwd-login.sms.0.click";
        public static final String APP_SMS_LOGIN_COUNTY_0_CLICK = "app.sms-login.country.0.click";
        public static final String APP_SMS_LOGIN_COUNTY_CODE_CLICK = "app.sms-login.country.code.click";
        public static final String APP_SMS_LOGIN_GETHELP_0_CLICK = "app.sms-login.gethelp.0.click";
        public static final String APP_SMS_LOGIN_GETSMS_0_CLICK = "app.sms-login.getsms.0.click";
        public static final String APP_SMS_LOGIN_PWD_0_CLICK = "app.sms-login.pwd.0.click";
        public static final String APP_SMS_LOGIN_SUBMIT_0_CLICK = "app.sms-login.submit.0.click";
        public static final String APP_SMS_LOGIN_TERMS_AGREEMENT_CLICK = "app.sms-login.terms.agreement.click";
        public static final String APP_SMS_LOGIN_TERMS_PRIVACY_CLICK = "app.sms-login.terms.privacy.click";
        public static final String APP_SMS_LOGIN_VERIFICATION_CLOSE_CLICK = "app.sms-login.verification.close.click";
        public static final String APP_SMS_LOGIN_VERIFICATION_SUCCESS_CLICK = "app.sms-login.verification.success.click";
        public static final String CLICK_HOMEPAGE_FROM_VIDEO = "main.homepage.return-from-video.0.click";
        public static final String CLICK_HOMEPAGE_TMCARD = "main.homepage.slide-tmcard.0.click";
        public static final String CLICK_PROVISION_ONEPASS_LOGIN = "app.onepass-login.provision.0.click";
        public static final String CLICK_PROVISION_ONEPASS_LOGIN2 = "app.onepass-login2.provision.0.click";
        public static final String CLICK_PROVISION_PWD_LOGIN = "app.pwd-login.provision.0.click";
        public static final String CLICK_PROVISION_SMS_LOGIN = "app.sms-login.provision.0.click";
        public static final String CLICK_PROVISION_SMS_LOGIN2 = "app.sms-login2.provision.0.click";
        public static final String CLICK_SMS_LOGIN_DIALOG_CHOOSE_COUNTRY_BUTTON = "app.sms-login2.country2.0.click";
        public static final String CLICK_SMS_LOGIN_DIALOG_GET_CODE_BUTTON = "app.sms-login2.getsms2.0.click";
        public static final String CLICK_SMS_LOGIN_DIALOG_TO_PWD_LOGIN_BUTTON = "app.sms-login2.pwd2.0.click";
        public static final String EXIT_C_KEY_STEP = "step";
        public static final String MAIN_SETTING_EXIT_0_CLICK = "main.setting.exit.0.click";
        public static final String MAIN_SETTING_EXIT_CLOSE_CLICK = "main.setting.exit.close.click";
        public static final String MAIN_SETTING_EXIT_CONFIRM_POPUP_CLICK = "main.setting.exit.confirm-popup.click";
        public static final String MAIN_SETTING_EXIT_QUIT_1ST_CLICK = "main.setting.exit.quit-1st.click";
        public static final String MAIN_SETTING_EXIT_QUIT_2ND_CLICK = "main.setting.exit.quit-2nd.click";
        public static final String MAIN_SETTING_EXIT_SUBMIT_CLICK = "main.setting.exit.submit.click";
        public static final String SIGNUP_KEY_COUNTRY = "country";
        public static final String SIGNUP_KEY_MODE = "mode";
        public static final String SIGNUP_VALUE_MODE_H5 = "1";
        public static final String SIGNUP_VALUE_MODE_NA = "2";
        public static final String SIGNUP_VALUE_MODE_SMS = "3";
        public static final String SMS_LOGIN_DIALOG_CLICK_CLOSE = "app.sms-login2.close2.0.click";
        public static final String SMS_LOGIN_DIALOG_CLICK_LOGIN_BUTTON = "app.sms-login2.submit2.0.click";
        public static final String SMS_LOGIN_DIALOG_CLICK_PRIVACY = "app.sms-login2.terms2.privacy.click";
        public static final String SMS_LOGIN_DIALOG_CLICK_USER_AGREEMENT = "app.sms-login2.terms2.agreement.click";
        public static final String SMS_LOGIN_DIALOG_SET_COUNTRY_CODE = "app.sms-login2.country2.code.click";
        public static final String SMS_LOGIN_DIALOG_VERIFICATION_CLOSE = "app.sms-login2.verification2.close.click";
        public static final String SMS_LOGIN_DIALOG_VERIFICATION_SUCCESS = "app.sms-login2.verification2.success.click";
        public static final String STEP_EXIT_NO_READY_EXIT = "1";
        public static final String STEP_EXIT_READY_EXIT = "2";

        public static void report(String eventId, Map<String, String> extension) {
            BLog.i(LoginReporterV2.TAG + eventId + extension.values());
            HashMap<String, String> map = new HashMap<>(extension);
            map.putAll(LoginReportHelper.buildCommonParams());
            Neurons.reportClick(true, eventId, map);
        }

        public static void report(String eventId) {
            BLog.i(LoginReporterV2.TAG + eventId);
            Neurons.reportClick(true, eventId, LoginReportHelper.buildCommonParams());
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Show {
        public static final String APP_LOGIN_ANSWER_ANSWER_IN_0_SHOW = "app.login-answer.answer-in.0.show";
        public static final String APP_LOGIN_SUCCEED_0_SHOW = "app.login.succeed.0.show";
        public static final String APP_ONEPASS_LOGIN_ONEPASS_GETSTATUS_SHOW = "app.onepass-login.onepass.getstatus.show";
        public static final String APP_PWD_LOGIN_FORGOT_0_SHOW = "app.pwd-login.forgot.0.show";
        public static final String APP_PWD_LOGIN_STATUS_0_SHOW = "app.pwd-login.status.0.show";
        public static final String APP_QUICK_LOGIN_TOAST_SHOW = "app.onepass-login.refer-toast.0.show";
        public static final String APP_REGISTER_PASSED_0_SHOW = "app.register.passed.0.show";
        public static final String APP_SMS_LOGIN_GETSTATUS_0_SHOW = "app.sms-login.getstatus.0.show";
        public static final String APP_SMS_LOGIN_GETSTATUS_2_SHOW = "app.sms-login2.getstatus2.0.show";
        public static final String APP_SMS_LOGIN_VERIFICATION_0_SHOW = "app.sms-login.verification.0.show";
        public static final String EXIT_KEY_METHOD = "method";
        public static final String HOMEPAGE_LOGIN_POPUP_SHOW = "main.homepage.login-popup.1.show";
        public static final String LOGIN_SUCCEED_AGAIN_THIRD_THIRD = "39";
        public static final String LOGIN_SUCCEED_FAST_RE_LOGIN = "34";
        public static final String LOGIN_SUCCEED_FIRST_THIRD_PHONE = "38";
        public static final String LOGIN_SUCCEED_GEE_VERIFY = "2";
        public static final String LOGIN_SUCCEED_IMAGE_VERIFY = "3";
        public static final String LOGIN_SUCCEED_NA_FIND_PASSWORD = "9";
        public static final String LOGIN_SUCCEED_NA_PHONE_REGISTER = "7";
        public static final String LOGIN_SUCCEED_NO_ACCOUNT = "14";
        public static final String LOGIN_SUCCEED_NO_ACCOUNT_FROM_SMS_LOGIN_DIALOG = "28";
        public static final String LOGIN_SUCCEED_QUICK_AFTER_REGISTER = "24";
        public static final String LOGIN_SUCCEED_QUICK_AFTER_REGISTER_V2 = "26";
        public static final String LOGIN_SUCCEED_QUICK_DIRECTLY = "19";
        public static final String LOGIN_SUCCEED_QUICK_DIRECTLY_V2 = "25";
        public static final String LOGIN_SUCCEED_SMS_NO_IDENTITY = "10";
        public static final String LOGIN_SUCCEED_SMS_NO_IDENTITY_FROM_SMS_LOGIN_DIALOG = "27";
        public static final String LOGIN_SUCCEED_USER_ACCOUNT = "1";
        public static final String MAIN_SETTING_EXIT_CONFIRM_POPUP_SHOW = "main.setting.exit.confirm-popup.show";
        public static final String MAIN_SETTING_EXIT_POPUP_SHOW = "main.setting.exit.popup.show";
        public static final String MAIN_SETTING_EXIT_SUCCESS_SHOW = "main.setting.exit.success.show";
        public static final String PVID_SMS_LOGIN_DIALOG = "app.sms-login2.0.0.pv";
        public static final String SIGNUP_BOTTOM_THIRD_UNREG = "11";
        public static final String SIGNUP_KEY_CODE = "code";
        public static final String SIGNUP_KEY_METHOD = "method";
        public static final String SIGNUP_VALUE_METHOD_NA = "2";
        public static final String SIGNUP_VALUE_METHOD_QUICK = "5";
        public static final String SIGNUP_VALUE_METHOD_QUICK_V2 = "8";
        public static final String SIGNUP_VALUE_METHOD_SMS = "3";
        public static final String SIGNUP_VALUE_METHOD_SMS_DIALOG = "9";
        public static final String SMS_LOGIN_DIALOG_FROM_HOME = "tm.recommend.0.0";
        public static final String SMS_LOGIN_DIALOG_FROM_USER_CENTER = "main.my-information.0.0";
        public static final String SMS_LOGIN_DIALOG_VERIFICATION_SHOW = "app.sms-login2.verification2.0.show";
        public static final String STEP_EXIT_NORMAL = "1";
        public static final String STEP_EXIT_POP_SETPD_NO_SET = "2";
        public static final String STEP_EXIT_POP_SETPD_SET = "3";

        public static void report(String eventId, Map<String, String> extension) {
            BLog.i(LoginReporterV2.TAG + eventId + extension.values());
            HashMap<String, String> map = new HashMap<>(extension);
            map.putAll(LoginReportHelper.buildCommonParams());
            Neurons.reportExposure(true, eventId, map);
            if (APP_LOGIN_SUCCEED_0_SHOW.equals(eventId)) {
                AppsFlyerWrapper.logEvent("af_login");
            } else if (APP_REGISTER_PASSED_0_SHOW.equals(eventId)) {
                AppsFlyerWrapper.logEvent("af_register");
            }
        }

        public static void report(String eventId) {
            BLog.i(LoginReporterV2.TAG + eventId);
            Neurons.reportExposure(true, eventId, LoginReportHelper.buildCommonParams());
        }

        public static void report(String eventId, String code, String message, String data_status, String data_url, String data_message) {
            report(eventId, code, message, data_status, data_url, data_message, null);
        }

        public static void report(String eventId, String code, String message, String data_status, String data_url, String data_message, String refer_click) {
            Map<String, String> maps = LoginReportHelper.buildCommonParams();
            maps.put(SIGNUP_KEY_CODE, code);
            maps.put("message", message);
            maps.put("data_status", data_status);
            maps.put("data_url", data_url);
            maps.put("data_message", data_message);
            if (!TextUtils.isEmpty(refer_click)) {
                maps.put("refer_click", refer_click);
            }
            BLog.i(LoginReporterV2.TAG + eventId + maps.values());
            Neurons.reportExposure(true, eventId, maps);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Error {
        public static final String APP_ONE_PASS_LOGIN_FAIL = "app.onepass-login.fail.0.sys";
        public static final String APP_SMS_LOGIN2_FAIL = "app.sms-login2.fail.0.sys";
        public static final String ERROR_GET_PHONE_INFO = "2";
        public static final String ERROR_INTERRUPT = "3";
        public static final String ERROR_NO_NETWORK = "1";
        public static final String SP_MID_ENTER_HOMEPAGE = "enter_homepage";
        public static final String SP_MID_ENTER_MY_INFO = "enter_my-information";

        public static void report(String eventId, String fromSpmid, String failReason) {
            HashMap<String, String> extension = new HashMap<>();
            extension.put("from_spmid", fromSpmid);
            extension.put(OnePassLoginReportManagerKt.EVENT_KEY_FAIL_REASON, failReason);
            Neurons.report(false, 4, eventId, extension);
        }

        public static void report(String eventId, Map<String, String> extension) {
            BLog.i(LoginReporterV2.TAG + eventId + extension.values());
            Neurons.report(false, 4, eventId, extension);
        }
    }

    public static HashMap<String, String> generateSingleParamMaps(String key, String value) {
        HashMap<String, String> maps = new HashMap<>();
        maps.put(key, value);
        return maps;
    }
}