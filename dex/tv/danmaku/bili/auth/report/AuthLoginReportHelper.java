package tv.danmaku.bili.auth.report;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AuthLoginReportHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J.\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/auth/report/AuthLoginReportHelper;", "", "<init>", "()V", "TAG", "", "PV_EVENT_ID_AUTHORIZE", "SYS_EVENT_ID_GROWTH", "CLICK_EVENT_ID_AUTHORIZE", "CLICK_EVENT_ID_AGREEMENT", "reportAuthGrowth", "", "clientId", "sessionId", "packageName", "reportAuthLoginClick", "authMap", "reportAuthAgreementClick", "agreement", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthLoginReportHelper {
    public static final int $stable = 0;
    private static final String CLICK_EVENT_ID_AGREEMENT = "app.authorize.authorize.agreement.click";
    private static final String CLICK_EVENT_ID_AUTHORIZE = "app.authorize.authorize.authorize.click";
    public static final AuthLoginReportHelper INSTANCE = new AuthLoginReportHelper();
    public static final String PV_EVENT_ID_AUTHORIZE = "app.authorize.0.0.pv";
    private static final String SYS_EVENT_ID_GROWTH = "app.active.growth.sys";
    private static final String TAG = "AuthLoginHelper";

    private AuthLoginReportHelper() {
    }

    public final void reportAuthGrowth(String clientId, String sessionId, String packageName) {
        HashMap map = new HashMap();
        map.put("authorize_client_id", clientId == null ? "" : clientId);
        map.put("authorize_id", sessionId == null ? "" : sessionId);
        map.put("package", packageName != null ? packageName : "");
        map.put("open_app_from_type", "auth");
        Neurons.report$default(true, 4, "app.active.growth.sys", map, (String) null, 0, 48, (Object) null);
    }

    public final void reportAuthLoginClick(String clientId, String sessionId, String packageName, String authMap) {
        HashMap map = new HashMap();
        map.put("authorize_client_id", clientId == null ? "" : clientId);
        map.put("authorize_id", sessionId == null ? "" : sessionId);
        map.put("package", packageName == null ? "" : packageName);
        map.put("authorize_map", authMap != null ? authMap : "");
        BLog.d(TAG, "reportAuthLoginClick authMap = " + authMap);
        Neurons.reportClick(false, CLICK_EVENT_ID_AUTHORIZE, map);
    }

    public final void reportAuthAgreementClick(String agreement) {
        HashMap map = new HashMap();
        map.put("agreement", agreement == null ? "" : agreement);
        BLog.d(TAG, "reportAuthAgreementClick agreement = " + agreement);
        Neurons.reportClick(false, CLICK_EVENT_ID_AGREEMENT, map);
    }
}