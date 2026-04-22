package tv.danmaku.bili.report.biz.api.produce;

import com.bilibili.lib.rpc.report.BizReporter;
import com.bilibili.okretro.tracker.ApiTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BilowBizTrackers.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "factory", "Lcom/bilibili/okretro/tracker/ApiTracker$Factory;", "consumer", "Lcom/bilibili/lib/rpc/report/BizReporter;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BilowBizTrackersKt {
    private static final String TAG = "okhttp.bilow.biz.tracker";

    public static final ApiTracker.Factory factory(final BizReporter consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        return new ApiTracker.Factory() { // from class: tv.danmaku.bili.report.biz.api.produce.BilowBizTrackersKt$$ExternalSyntheticLambda0
            public final ApiTracker getTracker() {
                ApiTracker factory$lambda$0;
                factory$lambda$0 = BilowBizTrackersKt.factory$lambda$0(consumer);
                return factory$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApiTracker factory$lambda$0(BizReporter $consumer) {
        return new BilowBizTracker($consumer);
    }
}