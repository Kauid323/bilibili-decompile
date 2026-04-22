package tv.danmaku.bili.report;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

/* compiled from: ReporterParams.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/report/ReporterBundle;", "Ltv/danmaku/bili/report/IReporterParams;", "Landroid/os/Bundle;", "<init>", "()V", "extension", "getExtension", "()Landroid/os/Bundle;", "setExtension", "(Landroid/os/Bundle;)V", InnerPushReceiverKt.KEY_EXTRA, "key", "", "value", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReporterBundle extends IReporterParams<Bundle> {
    public static final int $stable = 8;
    private Bundle extension = new Bundle();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.bili.report.IReporterParams
    public Bundle getExtension() {
        return this.extension;
    }

    @Override // tv.danmaku.bili.report.IReporterParams
    public void setExtension(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.extension = bundle;
    }

    @Override // tv.danmaku.bili.report.IReporterParams
    public IReporterParams<Bundle> extra(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getExtension().putString(key, value == null ? "" : value);
        return this;
    }
}