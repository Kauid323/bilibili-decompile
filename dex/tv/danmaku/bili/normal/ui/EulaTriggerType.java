package tv.danmaku.bili.normal.ui;

import bili.resource.account.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: LoginEulaDialogViewDelegate.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "", "reportTypeValue", "", "btnId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getReportTypeValue", "()Ljava/lang/String;", "getBtnId", "()I", "Submit", "GetSms", "Google", "Facebook", "NetCode", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum EulaTriggerType {
    Submit(LoginReporterV2.VALUE_SUBMIT, R.string.account_global_string_106),
    GetSms(LoginReporterV2.VALUE_GET_SMS, R.string.account_global_string_67),
    Google(ConstsKt.SP_GOOGLE, R.string.account_global_string_106),
    Facebook("facebook", R.string.account_global_string_106),
    NetCode("netcode", R.string.account_global_string_67);
    
    private final int btnId;
    private final String reportTypeValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<EulaTriggerType> getEntries() {
        return $ENTRIES;
    }

    EulaTriggerType(String reportTypeValue, int btnId) {
        this.reportTypeValue = reportTypeValue;
        this.btnId = btnId;
    }

    public final int getBtnId() {
        return this.btnId;
    }

    public final String getReportTypeValue() {
        return this.reportTypeValue;
    }
}