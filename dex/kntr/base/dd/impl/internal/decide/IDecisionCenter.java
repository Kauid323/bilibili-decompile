package kntr.base.dd.impl.internal.decide;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IDecisionCenter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/internal/decide/IDecisionCenter;", "", "keys", "Lkotlinx/coroutines/flow/Flow;", "", "getKeys", "()Lkotlinx/coroutines/flow/Flow;", "decide", "Lkntr/base/dd/impl/internal/decide/IDDResult;", "key", "context", "Lkntr/base/dd/IDeviceDecision$Context;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDecisionCenter {
    IDDResult decide(String str, IDeviceDecision.Context context);

    Flow<String> getKeys();

    /* compiled from: IDecisionCenter.kt */
    /* renamed from: kntr.base.dd.impl.internal.decide.IDecisionCenter$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ IDDResult decide$default(IDecisionCenter iDecisionCenter, String str, IDeviceDecision.Context context, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    context = null;
                }
                return iDecisionCenter.decide(str, context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decide");
        }
    }

    /* compiled from: IDecisionCenter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}