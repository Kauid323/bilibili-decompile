package kntr.base.net.comm.flowcontrol.internal.protocol;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Trigger.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/protocol/FlowControlModel;", "", "isEnabled", "", "retryAfter", "", "<init>", "(ZI)V", "()Z", "getRetryAfter", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowControlModel {
    private final boolean isEnabled;
    private final int retryAfter;

    public static /* synthetic */ FlowControlModel copy$default(FlowControlModel flowControlModel, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = flowControlModel.isEnabled;
        }
        if ((i2 & 2) != 0) {
            i = flowControlModel.retryAfter;
        }
        return flowControlModel.copy(z, i);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    public final int component2() {
        return this.retryAfter;
    }

    public final FlowControlModel copy(boolean z, int i) {
        return new FlowControlModel(z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FlowControlModel) {
            FlowControlModel flowControlModel = (FlowControlModel) obj;
            return this.isEnabled == flowControlModel.isEnabled && this.retryAfter == flowControlModel.retryAfter;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isEnabled) * 31) + this.retryAfter;
    }

    public String toString() {
        boolean z = this.isEnabled;
        return "FlowControlModel(isEnabled=" + z + ", retryAfter=" + this.retryAfter + ")";
    }

    public FlowControlModel(boolean isEnabled, int retryAfter) {
        this.isEnabled = isEnabled;
        this.retryAfter = retryAfter;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final int getRetryAfter() {
        return this.retryAfter;
    }
}