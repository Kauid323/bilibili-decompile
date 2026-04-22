package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.core.ILoginOnePass;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;

/* compiled from: PhoneService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IspCode;", "", "ispName", "", "reportName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getIspName", "()Ljava/lang/String;", "getReportName", "Unknown", "ChinaMobile", "ChinaUnicom", "ChinaTelecom", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum IspCode {
    Unknown("unknown", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR),
    ChinaMobile(NetworkUtilsKt.NETWORK_TYPE_MOBILE, "1"),
    ChinaUnicom(AppConfig.HOST_UNICOM, "2"),
    ChinaTelecom("telecom", "3");
    
    private final String ispName;
    private final String reportName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<IspCode> getEntries() {
        return $ENTRIES;
    }

    IspCode(String ispName, String reportName) {
        this.ispName = ispName;
        this.reportName = reportName;
    }

    public final String getIspName() {
        return this.ispName;
    }

    public final String getReportName() {
        return this.reportName;
    }

    /* compiled from: PhoneService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IspCode$Companion;", "", "<init>", "()V", "fromFlag", "Ltv/danmaku/bili/fullscreen/service/IspCode;", "flag", "Lcom/bilibili/lib/accountsui/quick/core/ILoginOnePass$IspFlag;", "getIspCode", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IspCode fromFlag(ILoginOnePass.IspFlag flag) {
            String ispName = flag != null ? flag.getIspName() : null;
            if (ispName != null) {
                switch (ispName.hashCode()) {
                    case -1429363305:
                        if (ispName.equals("telecom")) {
                            return IspCode.ChinaTelecom;
                        }
                        break;
                    case -1068855134:
                        if (ispName.equals(NetworkUtilsKt.NETWORK_TYPE_MOBILE)) {
                            return IspCode.ChinaMobile;
                        }
                        break;
                    case -840542575:
                        if (ispName.equals(AppConfig.HOST_UNICOM)) {
                            return IspCode.ChinaUnicom;
                        }
                        break;
                }
            }
            return IspCode.Unknown;
        }

        public final IspCode getIspCode() {
            return fromFlag(LoginQuickManager.INSTANCE.ispFlag());
        }
    }
}