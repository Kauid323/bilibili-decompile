package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: LoginReportService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003JI\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032,\b\u0002\u0010\u000f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\u0010\u0012JI\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032,\b\u0002\u0010\u000f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\u0010\u0012JI\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032,\b\u0002\u0010\u000f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\u0010\u0012JM\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u000b\u001a\u00020\u00032,\b\u0002\u0010\u000f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "", FavoritesConstsKt.SPMID, "", "<init>", "(Ljava/lang/String;)V", "getSpmid", "()Ljava/lang/String;", "getLoginSessionId", "getReportParams", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "loginType", "report", "", "eventId", "extraParams", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", "reportShow", "reportClick", "getReportParamMap", "", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/util/Map;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginReportService {
    public static final int $stable = 0;
    private final String spmid;

    @Inject
    public LoginReportService(@PageSpmid String spmid) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        this.spmid = spmid;
        LoginReportHelper.INSTANCE.setFromSpmid(this.spmid);
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final String getLoginSessionId() {
        String loginSessionId = LoginReportHelper.INSTANCE.getLoginSessionId();
        return loginSessionId == null ? "" : loginSessionId;
    }

    public final LoginReportParams getReportParams(String loginType) {
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        String loginSessionId = LoginReportHelper.INSTANCE.getLoginSessionId();
        String str = loginSessionId == null ? "" : loginSessionId;
        String str2 = this.spmid;
        String guideId = LoginReportHelper.INSTANCE.getGuideId();
        String str3 = guideId == null ? "" : guideId;
        String extend = LoginReportHelper.INSTANCE.getExtend();
        return new LoginReportParams("", "", str, str2, str3, extend == null ? "" : extend, loginType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void report$default(LoginReportService loginReportService, String str, String str2, Pair[] pairArr, int i, Object obj) {
        if ((i & 4) != 0) {
            pairArr = new Pair[0];
        }
        loginReportService.report(str, str2, pairArr);
    }

    public final void report(String eventId, String loginType, Pair<String, String>... pairArr) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(pairArr, "extraParams");
        if (StringsKt.endsWith$default(eventId, ReportEvent.EVENT_TYPE_SHOW, false, 2, (Object) null)) {
            reportShow(eventId, loginType, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        } else if (StringsKt.endsWith$default(eventId, "click", false, 2, (Object) null)) {
            reportClick(eventId, loginType, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        } else {
            BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Unrecognized eventId: " + eventId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportShow$default(LoginReportService loginReportService, String str, String str2, Pair[] pairArr, int i, Object obj) {
        if ((i & 4) != 0) {
            pairArr = new Pair[0];
        }
        loginReportService.reportShow(str, str2, pairArr);
    }

    public final void reportShow(String eventId, String loginType, Pair<String, String>... pairArr) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(pairArr, "extraParams");
        Map map = getReportParamMap(loginType, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Neurons.reportExposure$default(false, eventId, map, (List) null, 8, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportClick$default(LoginReportService loginReportService, String str, String str2, Pair[] pairArr, int i, Object obj) {
        if ((i & 4) != 0) {
            pairArr = new Pair[0];
        }
        loginReportService.reportClick(str, str2, pairArr);
    }

    public final void reportClick(String eventId, String loginType, Pair<String, String>... pairArr) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(pairArr, "extraParams");
        Map map = getReportParamMap(loginType, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Neurons.reportClick(false, eventId, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map getReportParamMap$default(LoginReportService loginReportService, String str, Pair[] pairArr, int i, Object obj) {
        if ((i & 2) != 0) {
            pairArr = new Pair[0];
        }
        return loginReportService.getReportParamMap(str, pairArr);
    }

    public final Map<String, String> getReportParamMap(String loginType, Pair<String, String>... pairArr) {
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(pairArr, "extraParams");
        Map $this$getReportParamMap_u24lambda_u240 = new LinkedHashMap();
        $this$getReportParamMap_u24lambda_u240.putAll(LoginReportHelper.getCommonParams().build());
        MapsKt.putAll($this$getReportParamMap_u24lambda_u240, pairArr);
        $this$getReportParamMap_u24lambda_u240.put("login_type", loginType);
        return $this$getReportParamMap_u24lambda_u240;
    }
}