package tv.danmaku.bili.report;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

/* compiled from: ReporterParams.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/report/ReporterMap;", "Ltv/danmaku/bili/report/IReporterParams;", "", "", "<init>", "()V", "extension", "getExtension", "()Ljava/util/Map;", "setExtension", "(Ljava/util/Map;)V", InnerPushReceiverKt.KEY_EXTRA, "key", "value", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReporterMap extends IReporterParams<Map<String, String>> {
    public static final int $stable = 8;
    private Map<String, String> extension = new HashMap();

    @Override // tv.danmaku.bili.report.IReporterParams
    public Map<String, String> getExtension() {
        return this.extension;
    }

    @Override // tv.danmaku.bili.report.IReporterParams
    public void setExtension(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extension = map;
    }

    @Override // tv.danmaku.bili.report.IReporterParams
    public IReporterParams<Map<String, String>> extra(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getExtension().put(key, value == null ? "" : value);
        return this;
    }
}