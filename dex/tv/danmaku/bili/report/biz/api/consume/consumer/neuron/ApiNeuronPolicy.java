package tv.danmaku.bili.report.biz.api.consume.consumer.neuron;

import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.OnlineParamsHelper;
import tv.danmaku.bili.report.biz.api.produce.model.EventsKt;

/* compiled from: ApiNeuronPolicy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/neuron/ApiNeuronPolicy;", "", "<init>", "()V", "MAX_SAMPLE_RATE", "", "mSampleRate", "mRandom", "Ljava/util/Random;", "shouldReport", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ApiNeuronPolicy {
    public static final ApiNeuronPolicy INSTANCE = new ApiNeuronPolicy();
    public static final int MAX_SAMPLE_RATE = 1000;
    private static final Random mRandom;
    private static final int mSampleRate;

    private ApiNeuronPolicy() {
    }

    static {
        int config = OnlineParamsHelper.getApiErrorNeuronSampleRate();
        mSampleRate = config <= 1000 ? config : 1000;
        mRandom = new Random();
    }

    public final boolean shouldReport(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (EventsKt.isValid(event)) {
            boolean error = HttpUtilsKt.httpError(event.getHttpCode());
            return error && mRandom.nextInt(1000) < mSampleRate;
        }
        BLog.dfmt("API", "drop no used event for url %s:", event.getUrl());
        return false;
    }
}