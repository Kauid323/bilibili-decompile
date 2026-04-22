package im.session.home;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMSessionHomePage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lim/session/home/IMHomeTabData;", "", "tabHasNewPointFlow", "Lkotlinx/coroutines/flow/Flow;", "", "tabSelectedFlow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "getTabHasNewPointFlow", "()Lkotlinx/coroutines/flow/Flow;", "getTabSelectedFlow", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMHomeTabData {
    public static final int $stable = 8;
    private final Flow<Boolean> tabHasNewPointFlow;
    private final Flow<Boolean> tabSelectedFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMHomeTabData copy$default(IMHomeTabData iMHomeTabData, Flow flow, Flow flow2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            flow = iMHomeTabData.tabHasNewPointFlow;
        }
        if ((i2 & 2) != 0) {
            flow2 = iMHomeTabData.tabSelectedFlow;
        }
        return iMHomeTabData.copy(flow, flow2);
    }

    public final Flow<Boolean> component1() {
        return this.tabHasNewPointFlow;
    }

    public final Flow<Boolean> component2() {
        return this.tabSelectedFlow;
    }

    public final IMHomeTabData copy(Flow<Boolean> flow, Flow<Boolean> flow2) {
        Intrinsics.checkNotNullParameter(flow, "tabHasNewPointFlow");
        Intrinsics.checkNotNullParameter(flow2, "tabSelectedFlow");
        return new IMHomeTabData(flow, flow2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMHomeTabData) {
            IMHomeTabData iMHomeTabData = (IMHomeTabData) obj;
            return Intrinsics.areEqual(this.tabHasNewPointFlow, iMHomeTabData.tabHasNewPointFlow) && Intrinsics.areEqual(this.tabSelectedFlow, iMHomeTabData.tabSelectedFlow);
        }
        return false;
    }

    public int hashCode() {
        return (this.tabHasNewPointFlow.hashCode() * 31) + this.tabSelectedFlow.hashCode();
    }

    public String toString() {
        Flow<Boolean> flow = this.tabHasNewPointFlow;
        return "IMHomeTabData(tabHasNewPointFlow=" + flow + ", tabSelectedFlow=" + this.tabSelectedFlow + ")";
    }

    public IMHomeTabData(Flow<Boolean> flow, Flow<Boolean> flow2) {
        Intrinsics.checkNotNullParameter(flow, "tabHasNewPointFlow");
        Intrinsics.checkNotNullParameter(flow2, "tabSelectedFlow");
        this.tabHasNewPointFlow = flow;
        this.tabSelectedFlow = flow2;
    }

    public final Flow<Boolean> getTabHasNewPointFlow() {
        return this.tabHasNewPointFlow;
    }

    public final Flow<Boolean> getTabSelectedFlow() {
        return this.tabSelectedFlow;
    }
}