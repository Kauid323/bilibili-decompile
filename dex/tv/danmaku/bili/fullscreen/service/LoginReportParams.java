package tv.danmaku.bili.fullscreen.service;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.LoginReportHelper;

/* compiled from: LoginReportService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006$"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "", "pagePv", "", "pageRoute", "loginSessionId", "fromSpmId", "touristId", LoginReportHelper.KEY_EXTEND, "loginType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPagePv", "()Ljava/lang/String;", "getPageRoute", "getLoginSessionId", "getFromSpmId", "getTouristId", "getExtend", "getLoginType", "getCommonParams", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginReportParams {
    public static final int $stable = 0;
    private final String extend;
    private final String fromSpmId;
    private final String loginSessionId;
    private final String loginType;
    private final String pagePv;
    private final String pageRoute;
    private final String touristId;

    public static /* synthetic */ LoginReportParams copy$default(LoginReportParams loginReportParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginReportParams.pagePv;
        }
        if ((i & 2) != 0) {
            str2 = loginReportParams.pageRoute;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = loginReportParams.loginSessionId;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = loginReportParams.fromSpmId;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = loginReportParams.touristId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = loginReportParams.extend;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = loginReportParams.loginType;
        }
        return loginReportParams.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.pagePv;
    }

    public final String component2() {
        return this.pageRoute;
    }

    public final String component3() {
        return this.loginSessionId;
    }

    public final String component4() {
        return this.fromSpmId;
    }

    public final String component5() {
        return this.touristId;
    }

    public final String component6() {
        return this.extend;
    }

    public final String component7() {
        return this.loginType;
    }

    public final LoginReportParams copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "pagePv");
        Intrinsics.checkNotNullParameter(str2, "pageRoute");
        Intrinsics.checkNotNullParameter(str3, "loginSessionId");
        Intrinsics.checkNotNullParameter(str4, "fromSpmId");
        Intrinsics.checkNotNullParameter(str5, "touristId");
        Intrinsics.checkNotNullParameter(str6, LoginReportHelper.KEY_EXTEND);
        Intrinsics.checkNotNullParameter(str7, "loginType");
        return new LoginReportParams(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginReportParams) {
            LoginReportParams loginReportParams = (LoginReportParams) obj;
            return Intrinsics.areEqual(this.pagePv, loginReportParams.pagePv) && Intrinsics.areEqual(this.pageRoute, loginReportParams.pageRoute) && Intrinsics.areEqual(this.loginSessionId, loginReportParams.loginSessionId) && Intrinsics.areEqual(this.fromSpmId, loginReportParams.fromSpmId) && Intrinsics.areEqual(this.touristId, loginReportParams.touristId) && Intrinsics.areEqual(this.extend, loginReportParams.extend) && Intrinsics.areEqual(this.loginType, loginReportParams.loginType);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.pagePv.hashCode() * 31) + this.pageRoute.hashCode()) * 31) + this.loginSessionId.hashCode()) * 31) + this.fromSpmId.hashCode()) * 31) + this.touristId.hashCode()) * 31) + this.extend.hashCode()) * 31) + this.loginType.hashCode();
    }

    public String toString() {
        String str = this.pagePv;
        String str2 = this.pageRoute;
        String str3 = this.loginSessionId;
        String str4 = this.fromSpmId;
        String str5 = this.touristId;
        String str6 = this.extend;
        return "LoginReportParams(pagePv=" + str + ", pageRoute=" + str2 + ", loginSessionId=" + str3 + ", fromSpmId=" + str4 + ", touristId=" + str5 + ", extend=" + str6 + ", loginType=" + this.loginType + ")";
    }

    public LoginReportParams(String pagePv, String pageRoute, String loginSessionId, String fromSpmId, String touristId, String extend, String loginType) {
        Intrinsics.checkNotNullParameter(pagePv, "pagePv");
        Intrinsics.checkNotNullParameter(pageRoute, "pageRoute");
        Intrinsics.checkNotNullParameter(loginSessionId, "loginSessionId");
        Intrinsics.checkNotNullParameter(fromSpmId, "fromSpmId");
        Intrinsics.checkNotNullParameter(touristId, "touristId");
        Intrinsics.checkNotNullParameter(extend, LoginReportHelper.KEY_EXTEND);
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        this.pagePv = pagePv;
        this.pageRoute = pageRoute;
        this.loginSessionId = loginSessionId;
        this.fromSpmId = fromSpmId;
        this.touristId = touristId;
        this.extend = extend;
        this.loginType = loginType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LoginReportParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, r8);
        String str8;
        if ((i & 64) == 0) {
            str8 = str7;
        } else {
            str8 = "";
        }
    }

    public final String getPagePv() {
        return this.pagePv;
    }

    public final String getPageRoute() {
        return this.pageRoute;
    }

    public final String getLoginSessionId() {
        return this.loginSessionId;
    }

    public final String getFromSpmId() {
        return this.fromSpmId;
    }

    public final String getTouristId() {
        return this.touristId;
    }

    public final String getExtend() {
        return this.extend;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final Map<String, String> getCommonParams() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("login_session_id", this.loginSessionId), TuplesKt.to("spm_id", this.fromSpmId), TuplesKt.to("login_type", this.loginType)});
    }
}