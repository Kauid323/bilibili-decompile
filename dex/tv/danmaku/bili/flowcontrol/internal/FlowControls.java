package tv.danmaku.bili.flowcontrol.internal;

import com.bilibili.lib.rpc.flowcontrol.FlowControl;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.flowcontrol.internal.model.Policies;
import tv.danmaku.bili.flowcontrol.internal.model.TimePolicies;
import tv.danmaku.bili.flowcontrol.internal.protocol.FlowControlModel;
import tv.danmaku.bili.flowcontrol.internal.protocol.TriggerKt;
import tv.danmaku.bili.flowcontrol.internal.report.EventReporter;
import tv.danmaku.bili.flowcontrol.internal.tracker.EventListener;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: FlowControls.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0017J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0007H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/FlowControls;", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "<init>", "()V", "TAG", "", "enabled", "", "tracker", "Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;", "getTracker", "()Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;", "tracker$delegate", "Lkotlin/Lazy;", "policies", "Ltv/danmaku/bili/flowcontrol/internal/model/Policies;", "getPolicies", "()Ltv/danmaku/bili/flowcontrol/internal/model/Policies;", "policies$delegate", "timePolicies", "Ltv/danmaku/bili/flowcontrol/internal/model/TimePolicies;", "getTimePolicies", "()Ltv/danmaku/bili/flowcontrol/internal/model/TimePolicies;", "timePolicies$delegate", "onRequest", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "onResponse", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "httpCode", "", "after", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "isFlowControlEnabled", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FlowControls implements FlowControl {
    public static final FlowControls INSTANCE = new FlowControls();
    private static final String TAG = "net.flowcontrol";
    private static final boolean enabled = INSTANCE.isFlowControlEnabled();
    private static final Lazy tracker$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.flowcontrol.internal.FlowControls$$ExternalSyntheticLambda0
        public final Object invoke() {
            EventListener tracker_delegate$lambda$0;
            tracker_delegate$lambda$0 = FlowControls.tracker_delegate$lambda$0();
            return tracker_delegate$lambda$0;
        }
    });
    private static final Lazy policies$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.flowcontrol.internal.FlowControls$$ExternalSyntheticLambda1
        public final Object invoke() {
            Policies policies_delegate$lambda$0;
            policies_delegate$lambda$0 = FlowControls.policies_delegate$lambda$0();
            return policies_delegate$lambda$0;
        }
    });
    private static final Lazy timePolicies$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.flowcontrol.internal.FlowControls$$ExternalSyntheticLambda2
        public final Object invoke() {
            TimePolicies timePolicies_delegate$lambda$0;
            timePolicies_delegate$lambda$0 = FlowControls.timePolicies_delegate$lambda$0();
            return timePolicies_delegate$lambda$0;
        }
    });

    private FlowControls() {
    }

    private final EventListener getTracker() {
        return (EventListener) tracker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener tracker_delegate$lambda$0() {
        return new EventListener(new EventReporter());
    }

    private final Policies getPolicies() {
        return (Policies) policies$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Policies policies_delegate$lambda$0() {
        return new Policies(INSTANCE.getTracker());
    }

    private final TimePolicies getTimePolicies() {
        return (TimePolicies) timePolicies$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePolicies timePolicies_delegate$lambda$0() {
        return new TimePolicies(INSTANCE.getTracker());
    }

    public boolean onRequest(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (enabled) {
            if (getTimePolicies().isBlocked(host, path)) {
                return true;
            }
            return getPolicies().isBlocked(host, path);
        }
        return false;
    }

    public void onResponse(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (enabled) {
            FlowControlModel flowControl = TriggerKt.isFlowControl(event);
            if (flowControl.isEnabled()) {
                Policies policies = getPolicies();
                String realHost = event.getRealHost();
                Intrinsics.checkNotNullExpressionValue(realHost, "getRealHost(...)");
                String realPath = event.getRealPath();
                Intrinsics.checkNotNullExpressionValue(realPath, "getRealPath(...)");
                policies.block(realHost, realPath, flowControl.getRetryAfter());
            } else if (TriggerKt.hasResponse(event)) {
                Policies policies2 = getPolicies();
                String realHost2 = event.getRealHost();
                Intrinsics.checkNotNullExpressionValue(realHost2, "getRealHost(...)");
                String realPath2 = event.getRealPath();
                Intrinsics.checkNotNullExpressionValue(realPath2, "getRealPath(...)");
                policies2.unblock(realHost2, realPath2);
            }
        }
    }

    public final void onResponse(String host, String path, int httpCode, Integer after) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (TriggerKt.isHttpFlowControl(httpCode) && TriggerKt.bizEnabled(host, path)) {
            getPolicies().block(host, path, after != null ? after.intValue() : 0);
        } else if (httpCode != -1) {
            getPolicies().unblock(host, path);
        }
    }

    private final boolean isFlowControlEnabled() {
        Boolean enabled2 = FlowControlConfig.INSTANCE.getEnabled();
        boolean result = enabled2 != null ? enabled2.booleanValue() : true;
        if (result) {
            BLog.i(TAG, "Flow control enabled.");
        } else {
            BLog.w(TAG, "Flow control disabled.");
        }
        return result;
    }
}