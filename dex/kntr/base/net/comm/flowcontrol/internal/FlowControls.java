package kntr.base.net.comm.flowcontrol.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kntr.base.net.comm.flowcontrol.internal.model.Policies;
import kntr.base.net.comm.flowcontrol.internal.model.TimePolicies;
import kntr.base.net.comm.flowcontrol.internal.protocol.TriggerKt;
import kntr.base.net.comm.flowcontrol.internal.tracker.EventListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowControls.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/FlowControls;", "", "<init>", "()V", "TAG", "", "enabled", "", "tracker", "Lkntr/base/net/comm/flowcontrol/internal/tracker/EventListener;", "getTracker", "()Lkntr/base/net/comm/flowcontrol/internal/tracker/EventListener;", "tracker$delegate", "Lkotlin/Lazy;", "policies", "Lkntr/base/net/comm/flowcontrol/internal/model/Policies;", "getPolicies", "()Lkntr/base/net/comm/flowcontrol/internal/model/Policies;", "policies$delegate", "timePolicies", "Lkntr/base/net/comm/flowcontrol/internal/model/TimePolicies;", "getTimePolicies", "()Lkntr/base/net/comm/flowcontrol/internal/model/TimePolicies;", "timePolicies$delegate", "onRequest", "host", "path", "onResponse", "", "httpCode", "", "after", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "isFlowControlEnabled", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowControls {
    public static final FlowControls INSTANCE = new FlowControls();
    private static final String TAG = "net.flowcontrol";
    private static final boolean enabled = INSTANCE.isFlowControlEnabled();
    private static final Lazy tracker$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.net.comm.flowcontrol.internal.FlowControls$$ExternalSyntheticLambda0
        public final Object invoke() {
            EventListener tracker_delegate$lambda$0;
            tracker_delegate$lambda$0 = FlowControls.tracker_delegate$lambda$0();
            return tracker_delegate$lambda$0;
        }
    });
    private static final Lazy policies$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.net.comm.flowcontrol.internal.FlowControls$$ExternalSyntheticLambda1
        public final Object invoke() {
            Policies policies_delegate$lambda$0;
            policies_delegate$lambda$0 = FlowControls.policies_delegate$lambda$0();
            return policies_delegate$lambda$0;
        }
    });
    private static final Lazy timePolicies$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.net.comm.flowcontrol.internal.FlowControls$$ExternalSyntheticLambda2
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
        return new EventListener();
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

    public final boolean onRequest(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        if (enabled) {
            if (getTimePolicies().isBlocked(host, path)) {
                return true;
            }
            return getPolicies().isBlocked(host, path);
        }
        return false;
    }

    public final void onResponse(String host, String path, int httpCode, Integer after) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        if (TriggerKt.isHttpFlowControl(httpCode) && TriggerKt.bizEnabled(host, path)) {
            getPolicies().block(host, path, after != null ? after.intValue() : 0);
        } else if (httpCode != -1) {
            getPolicies().unblock(host, path);
        }
    }

    private final boolean isFlowControlEnabled() {
        boolean result = FlowControlConfig.INSTANCE.getEnabled();
        if (result) {
            KLog_androidKt.getKLog().i(TAG, "Flow control enabled.");
        } else {
            KLog_androidKt.getKLog().w(TAG, "Flow control disabled.");
        }
        return result;
    }
}