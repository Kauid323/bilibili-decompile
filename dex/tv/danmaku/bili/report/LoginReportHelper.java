package tv.danmaku.bili.report;

import android.content.Intent;
import android.os.Bundle;
import com.bilibili.lib.accountsui.IBasePresenter;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginReportHelper.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020\u001eH\u0007J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050&H\u0007J\b\u0010'\u001a\u00020(H\u0007J\u001a\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050+0*H\u0007J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020(0*H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Ltv/danmaku/bili/report/LoginReportHelper;", "", "<init>", "()V", "TAG", "", "KEY_EXTEND", "KEY_FROM_SPMID", "reportCountDownLatch", "", "getReportCountDownLatch", "()I", "setReportCountDownLatch", "(I)V", "loginSessionId", "getLoginSessionId", "()Ljava/lang/String;", "setLoginSessionId", "(Ljava/lang/String;)V", LoginReportHelper.KEY_EXTEND, "getExtend", "setExtend", "fromSpmid", "getFromSpmid", "setFromSpmid", "guideId", "getGuideId", "guideId$delegate", "Lkotlin/Lazy;", "setTrackParams", "", "presenter", "Lcom/bilibili/lib/accountsui/IBasePresenter;", "generateValueFromIntent", "intent", "Landroid/content/Intent;", "endCurrentLogin", "buildCommonParams", "", "buildCommonBundle", "Landroid/os/Bundle;", "getCommonParams", "Ltv/danmaku/bili/report/IReporterParams;", "", "getCommonBundle", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginReportHelper {
    public static final String KEY_EXTEND = "extend";
    public static final String KEY_FROM_SPMID = "from_spmid";
    private static final String TAG = "LoginReportHelper";
    private static String extend;
    private static String fromSpmid;
    private static String loginSessionId;
    private static int reportCountDownLatch;
    public static final LoginReportHelper INSTANCE = new LoginReportHelper();
    private static final Lazy guideId$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.report.LoginReportHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            String guideId_delegate$lambda$0;
            guideId_delegate$lambda$0 = LoginReportHelper.guideId_delegate$lambda$0();
            return guideId_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private LoginReportHelper() {
    }

    public final int getReportCountDownLatch() {
        return reportCountDownLatch;
    }

    public final void setReportCountDownLatch(int i) {
        reportCountDownLatch = i;
    }

    public final String getLoginSessionId() {
        return loginSessionId;
    }

    public final void setLoginSessionId(String str) {
        loginSessionId = str;
    }

    public final String getExtend() {
        return extend;
    }

    public final void setExtend(String str) {
        extend = str;
    }

    public final String getFromSpmid() {
        return fromSpmid;
    }

    public final void setFromSpmid(String str) {
        fromSpmid = str;
    }

    public final String getGuideId() {
        return (String) guideId$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String guideId_delegate$lambda$0() {
        return EnvironmentManager.getInstance().getValue("guestId");
    }

    @JvmStatic
    public static final void setTrackParams(IBasePresenter presenter) {
        if (presenter != null) {
            presenter.setTrackParams(loginSessionId, fromSpmid, INSTANCE.getGuideId(), extend);
        }
    }

    @JvmStatic
    public static final void generateValueFromIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (extend == null) {
            extend = intent.getStringExtra(KEY_EXTEND);
        }
        if (fromSpmid == null) {
            fromSpmid = intent.getStringExtra("from_spmid");
        }
    }

    @JvmStatic
    public static final void endCurrentLogin() {
        extend = null;
        fromSpmid = null;
        loginSessionId = null;
    }

    @JvmStatic
    public static final Map<String, String> buildCommonParams() {
        return getCommonParams().build();
    }

    @JvmStatic
    public static final Bundle buildCommonBundle() {
        return getCommonBundle().build();
    }

    @JvmStatic
    public static final IReporterParams<Map<String, String>> getCommonParams() {
        return new ReporterMap().extra("login_session_id", loginSessionId).extend(extend).fromSpmid(fromSpmid);
    }

    @JvmStatic
    public static final IReporterParams<Bundle> getCommonBundle() {
        return new ReporterBundle().extra("login_session_id", loginSessionId).extend(extend).fromSpmid(fromSpmid);
    }
}