package tv.danmaku.bili.quick;

import android.text.TextUtils;
import android.util.Log;
import com.bilibili.commons.StringUtils;
import com.bilibili.lib.neuron.api.Neurons;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.bili.BR;

/* compiled from: LoginQualityMonitor.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010&\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005H\u0007J\u0006\u0010,\u001a\u00020'J\u0006\u0010-\u001a\u00020\u0005J\u0012\u0010.\u001a\u00020/2\b\b\u0001\u0010(\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00064"}, d2 = {"Ltv/danmaku/bili/quick/LoginQualityMonitor;", "", "<init>", "()V", "TAG", "", "OTHER_RESULT_CODE_MOBILE_API_ERROR", "CHECK_CODE_NET_CMOBILE_NO", "CHECK_CODE_NET_CMOBILE_OK", "CHECK_CODE_NET_TELECOM_NO", "CHECK_CODE_NET_TELECOM_OK", "CHECK_CODE_NET_UNICOM_NO", "CHECK_CODE_NET_UNICOM_OK", "CHECK_CODE_NET_ALL_NO", "GET_RULE_GO_ONEPASS", "GET_RULE_NO_ONEASSS", "GET_RULE_EXCEPTION", "INIT_THRESHOLD_TIME_REPORT", "", "STEP_INIT_SDK_UNI", "STEP_INIT_SDK_TEL", "STEP_INIT_SDK_CMO", "STEP_GET_RULE", "STEP_CHECK", "STEP_GET_PHONE", "STEP_GET_TOKEN", "STEP_LOGIN", "mSectionId", "getMSectionId", "()Ljava/lang/String;", "setMSectionId", "(Ljava/lang/String;)V", "timeTmp", "", "getTimeTmp", "()J", "setTimeTmp", "(J)V", "report", "", "step", "resultCode", "time", "phone", "startMarkSpendTime", "endMarkSpendTime", "isInitStep", "", "generateSectionId", "makeMD5", "content", "STEP", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginQualityMonitor {
    public static final String CHECK_CODE_NET_ALL_NO = "400";
    public static final String CHECK_CODE_NET_CMOBILE_NO = "100";
    public static final String CHECK_CODE_NET_CMOBILE_OK = "101";
    public static final String CHECK_CODE_NET_TELECOM_NO = "200";
    public static final String CHECK_CODE_NET_TELECOM_OK = "201";
    public static final String CHECK_CODE_NET_UNICOM_NO = "300";
    public static final String CHECK_CODE_NET_UNICOM_OK = "301";
    public static final String GET_RULE_EXCEPTION = "3";
    public static final String GET_RULE_GO_ONEPASS = "1";
    public static final String GET_RULE_NO_ONEASSS = "2";
    private static final int INIT_THRESHOLD_TIME_REPORT = 200;
    public static final String OTHER_RESULT_CODE_MOBILE_API_ERROR = "-1";
    public static final String STEP_CHECK = "2";
    public static final String STEP_GET_PHONE = "3";
    public static final String STEP_GET_RULE = "1";
    public static final String STEP_GET_TOKEN = "4";
    public static final String STEP_INIT_SDK_CMO = "init_sdk_cmo";
    public static final String STEP_INIT_SDK_TEL = "init_sdk_tel";
    public static final String STEP_INIT_SDK_UNI = "init_sdk_uni";
    public static final String STEP_LOGIN = "5";
    public static final String TAG = "LoginQualityMonitor";
    private static String mSectionId;
    private static long timeTmp;
    public static final LoginQualityMonitor INSTANCE = new LoginQualityMonitor();
    public static final int $stable = 8;

    /* compiled from: LoginQualityMonitor.kt */
    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ltv/danmaku/bili/quick/LoginQualityMonitor$STEP;", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface STEP {
    }

    public final void report(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "step");
        report$default(this, str, str2, null, null, 12, null);
    }

    public final void report(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "step");
        Intrinsics.checkNotNullParameter(str3, "time");
        report$default(this, str, str2, str3, null, 8, null);
    }

    private LoginQualityMonitor() {
    }

    public final String getMSectionId() {
        return mSectionId;
    }

    public final void setMSectionId(String str) {
        mSectionId = str;
    }

    public final long getTimeTmp() {
        return timeTmp;
    }

    public final void setTimeTmp(long j) {
        timeTmp = j;
    }

    public static /* synthetic */ void report$default(LoginQualityMonitor loginQualityMonitor, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        loginQualityMonitor.report(str, str2, str3, str4);
    }

    public final void report(String step, String resultCode, String time, String phone) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(time, "time");
        HashMap map = new HashMap();
        if (isInitStep(step)) {
            long tl = Long.parseLong(time);
            Log.i(TAG, "step : " + step + " time :" + time);
            if (tl < 200) {
                return;
            }
        } else {
            if (Intrinsics.areEqual(step, "1") || TextUtils.isEmpty(mSectionId)) {
                mSectionId = generateSectionId();
            }
            String str = mSectionId;
            Intrinsics.checkNotNull(str);
            map.put("sectionid", str);
        }
        map.put("step", step);
        String str2 = "";
        map.put("result_code", resultCode == null ? "" : resultCode);
        map.put("time", time);
        HashMap hashMap = map;
        if (!TextUtils.isEmpty(phone)) {
            Intrinsics.checkNotNull(phone);
            str2 = makeMD5(phone);
        }
        hashMap.put("phone", str2);
        Log.i(TAG, map.toString());
        Neurons.trackT$default(false, "ops.misaka.app-login-quickmode", map, 0, new Function0() { // from class: tv.danmaku.bili.quick.LoginQualityMonitor$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean report$lambda$0;
                report$lambda$0 = LoginQualityMonitor.report$lambda$0();
                return Boolean.valueOf(report$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0() {
        return true;
    }

    public final void startMarkSpendTime() {
        timeTmp = System.currentTimeMillis();
    }

    public final String endMarkSpendTime() {
        long spendTime = System.currentTimeMillis() - timeTmp;
        return String.valueOf(spendTime);
    }

    private final boolean isInitStep(String step) {
        return Intrinsics.areEqual(step, STEP_INIT_SDK_UNI) || Intrinsics.areEqual(step, STEP_INIT_SDK_TEL) || Intrinsics.areEqual(step, STEP_INIT_SDK_CMO);
    }

    private final String generateSectionId() {
        return String.valueOf(System.currentTimeMillis());
    }

    private final String makeMD5(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            digest.update(bytes);
            String hexString = StringUtils.toHexString(digest.digest());
            Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}