package tv.danmaku.bili.utils;

import android.text.TextUtils;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;

public class PersonInfoReport {
    public static final String ACCOUNT_INVITATION_CLICK = "main.account-information.invite-code.create.click";
    private static final String ACCOUNT_INVITATION_SCHOOL_CLICK = "main.account-information.school.0.click";
    private static final String MODIFY_NICKNAME_DEFAULT_FROM_SPMID = "main.account-information.0.0";
    public static final String PERSON_INFO_AVATAR_CLICK = "main.account-information.touxiang.0.click";
    public static final String PERSON_INFO_BIRTHDATE_CLICK = "main.account-information.birthdate.0.click";
    public static final String PERSON_INFO_MODIFY_NICKNAME_CODE_SHOW = "main.set-nickname.nickname-code.0.show";
    private static final String PERSON_INFO_MODIFY_NICKNAME_SPMID = "main.set-nickname.0.0";
    public static final String PERSON_INFO_MODIFY_NICKNAME_SUBMIT_CLICK = "main.set-nickname.setnickname.submit.click";
    public static final String PERSON_INFO_NIKCNAME_CLICK = "main.account-information.nickname.0.click";
    public static final String PERSON_INFO_QRCODE_CLICK = "main.account-information.qrcode.0.click";
    public static final String PERSON_INFO_SEX_CLICK = "main.account-information.sexuality.0.click";
    public static final String PERSON_INFO_SIGN_CLICK = "main.account-information.autograph.0.click";
    public static final String PERSON_INFO_UID_CLICK = "main.account-information.uid-num.0.click";

    public static void reportClick(String key) {
        Neurons.reportClick(false, key);
        BLog.d("PersonInfoReport", key);
    }

    public static void reportModifyNickNameSumitClick(String mode) {
        Map<String, String> map = new HashMap<>();
        map.put("mode", mode);
        Neurons.reportClick(false, PERSON_INFO_MODIFY_NICKNAME_SUBMIT_CLICK, map);
    }

    public static void reportModifyNickNameCodeShow(String code, String mode, String from, String scene) {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("mode", mode);
        map.put("spmid", PERSON_INFO_MODIFY_NICKNAME_SPMID);
        String fromSpmid = TextUtils.isEmpty(from) ? MODIFY_NICKNAME_DEFAULT_FROM_SPMID : from;
        map.put("from_spmid", fromSpmid);
        String sceneParam = TextUtils.isEmpty(scene) ? "4" : scene;
        map.put(LoginSceneProcessor.SCENE_KEY, sceneParam);
        Neurons.reportExposure(false, PERSON_INFO_MODIFY_NICKNAME_CODE_SHOW, map);
    }

    public static void reportModifyNickNameCodeShow2(String code, String mode, boolean isSuccess, String from, String scene) {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("mode", mode);
        String success = isSuccess ? "1" : "0";
        map.put("set_result", success);
        map.put("spmid", PERSON_INFO_MODIFY_NICKNAME_SPMID);
        String fromSpmid = TextUtils.isEmpty(from) ? MODIFY_NICKNAME_DEFAULT_FROM_SPMID : from;
        map.put("from_spmid", fromSpmid);
        String sceneParam = TextUtils.isEmpty(scene) ? "4" : scene;
        map.put(LoginSceneProcessor.SCENE_KEY, sceneParam);
        Neurons.reportExposure(false, PERSON_INFO_MODIFY_NICKNAME_CODE_SHOW, map);
    }

    public static void reportSchoolClick() {
        Neurons.reportClick(false, ACCOUNT_INVITATION_SCHOOL_CLICK);
    }
}