package tv.danmaku.bili.videopage.common.performance;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.lib.blrouter.BLRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IProfilerReporter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/IProfilerReporter;", "", "reportPage", "", "watchDog", "Ltv/danmaku/bili/videopage/common/performance/WatchDog;", "extras", "Lcom/alibaba/fastjson/JSONObject;", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IProfilerReporter {
    public static final Companion Companion = Companion.$$INSTANCE;

    void reportPage(WatchDog watchDog, JSONObject jSONObject);

    /* compiled from: IProfilerReporter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/IProfilerReporter$Companion;", "", "<init>", "()V", "instance", "Ltv/danmaku/bili/videopage/common/performance/IProfilerReporter;", "clientName", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final IProfilerReporter instance(String clientName) {
            Intrinsics.checkNotNullParameter(clientName, "clientName");
            return (IProfilerReporter) BLRouter.INSTANCE.get(IProfilerReporter.class, clientName);
        }
    }
}