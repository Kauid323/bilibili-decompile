package kntr.base.reachability;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IReachability.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&R\u0012\u0010\t\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/reachability/IReachability;", "", "isReachable", "", "isReachableViaWiFi", "isReachableViaWWAN", "currentStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/reachability/NetWorkState;", "currentState", "getCurrentState", "()Lkntr/base/reachability/NetWorkState;", "reachability_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IReachability {
    Flow<NetWorkState> currentStateFlow();

    NetWorkState getCurrentState();

    boolean isReachable();

    boolean isReachableViaWWAN();

    boolean isReachableViaWiFi();

    /* compiled from: IReachability.kt */
    /* renamed from: kntr.base.reachability.IReachability$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$isReachable(IReachability _this) {
            return _this.getCurrentState() != NetWorkState.NotReachable;
        }

        public static boolean $default$isReachableViaWiFi(IReachability _this) {
            return _this.getCurrentState() == NetWorkState.ViaWiFi;
        }

        public static boolean $default$isReachableViaWWAN(IReachability _this) {
            return _this.getCurrentState() == NetWorkState.ViaWWAN;
        }
    }

    /* compiled from: IReachability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isReachable(IReachability $this) {
            return CC.$default$isReachable($this);
        }

        @Deprecated
        public static boolean isReachableViaWiFi(IReachability $this) {
            return CC.$default$isReachableViaWiFi($this);
        }

        @Deprecated
        public static boolean isReachableViaWWAN(IReachability $this) {
            return CC.$default$isReachableViaWWAN($this);
        }
    }
}