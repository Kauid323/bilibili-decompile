package tv.danmaku.biliplayerimpl.report.heartbeat;

import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceKt;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportMetaInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ReportContext.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0000¨\u0006\u0005"}, d2 = {"getExtraParams", "", "", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "commExtra", "biliplayerimpl_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReportContextKt {
    public static /* synthetic */ Map getExtraParams$default(ReportMetaInfo reportMetaInfo, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        return getExtraParams(reportMetaInfo, map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0074, code lost:
        if (r2 == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, String> getExtraParams(ReportMetaInfo $this$getExtraParams, Map<String, String> map) {
        Map extraMap;
        Map commExtra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter($this$getExtraParams, "<this>");
        if (IHeartbeatServiceKt.getHitPlayExtraMerge()) {
            Map<String, String> legacyExtra = $this$getExtraParams.getLegacyExtra();
            boolean z = true;
            if (!(legacyExtra != null && (legacyExtra.isEmpty() ^ true))) {
                Map<String, String> extraParams = $this$getExtraParams.getExtraParams();
                if (!(extraParams != null && (extraParams.isEmpty() ^ true))) {
                    if (commExtra == null || commExtra.isEmpty()) {
                        extraMap = null;
                    }
                }
            }
            extraMap = new LinkedHashMap();
            Map it = $this$getExtraParams.getLegacyExtra();
            if (it != null) {
                extraMap.putAll(it);
            }
            Map it2 = $this$getExtraParams.getExtraParams();
            if (!(it2 != null && (it2.isEmpty() ^ true))) {
                if (commExtra != null && !commExtra.isEmpty()) {
                    z = false;
                }
            }
            try {
                Map extraJsonMap = new LinkedHashMap();
                Map it3 = $this$getExtraParams.getExtraParams();
                if (it3 != null) {
                    extraJsonMap.putAll(it3);
                }
                if (commExtra != null) {
                    extraJsonMap.putAll(commExtra);
                }
                extraMap.put("extra", GsonKt.toJsonString(extraJsonMap));
            } catch (Exception e) {
                if (BuildConfig.DEBUG) {
                    HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.ReportContextKt$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReportContextKt.getExtraParams$lambda$3();
                        }
                    });
                }
                BLog.e("HeartbeatService", "requestReportClickApi toJsonString error: " + e.getMessage());
            }
        } else {
            extraMap = $this$getExtraParams.getLegacyExtra();
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(extraMap);
    }

    public static final void getExtraParams$lambda$3() {
        ToastHelper.showToast(BiliContext.application(), "extra to json error", 1);
    }
}