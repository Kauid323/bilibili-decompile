package tv.danmaku.bili.report;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

/* compiled from: ReporterParams.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000b\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0005\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/report/IReporterParams;", "T", "", "<init>", "()V", "extension", "getExtension", "()Ljava/lang/Object;", "setExtension", "(Ljava/lang/Object;)V", InnerPushReceiverKt.KEY_EXTRA, "key", "", "value", "fromSpmid", LoginReportHelper.KEY_EXTEND, "build", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class IReporterParams<T> {
    public static final int $stable = 0;

    public abstract IReporterParams<T> extra(String str, String str2);

    public abstract T getExtension();

    public abstract void setExtension(T t);

    public final IReporterParams<T> fromSpmid(String value) {
        extra("spm_id", value);
        return this;
    }

    public final IReporterParams<T> extend(String value) {
        extra(LoginReportHelper.KEY_EXTEND, value);
        return this;
    }

    public final T build() {
        return getExtension();
    }
}