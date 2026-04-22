package tv.danmaku.bili.activities.login;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AuthLoginRepoter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/activities/login/AuthLoginRepoter;", "", "<init>", "()V", "TAG", "", "report", "", "eventId", "appname", "Show", "Click", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthLoginRepoter {
    public static final int $stable = 0;
    public static final AuthLoginRepoter INSTANCE = new AuthLoginRepoter();
    private static final String TAG = "AuthLoginRepoter";

    private AuthLoginRepoter() {
    }

    /* compiled from: AuthLoginRepoter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/activities/login/AuthLoginRepoter$Show;", "", "<init>", "()V", "PVID_AUTHORIZE_LOGIN", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Show {
        public static final int $stable = 0;
        public static final Show INSTANCE = new Show();
        public static final String PVID_AUTHORIZE_LOGIN = "app.authorize-login.0.0.pv";

        private Show() {
        }
    }

    /* compiled from: AuthLoginRepoter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/activities/login/AuthLoginRepoter$Click;", "", "<init>", "()V", "APP_AUTHORIZE_LOGIN_CONFIRM_CLICK", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Click {
        public static final int $stable = 0;
        public static final String APP_AUTHORIZE_LOGIN_CONFIRM_CLICK = "app.authorize-login.loginconfirm.0.click";
        public static final Click INSTANCE = new Click();

        private Click() {
        }
    }

    @JvmStatic
    public static final void report(String eventId, String appname) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(appname, "appname");
        Map maps = new HashMap();
        maps.put("appname", appname);
        BLog.i(TAG + eventId + maps.values());
        Neurons.reportClick(false, eventId, maps);
    }
}