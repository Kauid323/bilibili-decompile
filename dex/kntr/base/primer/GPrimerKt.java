package kntr.base.primer;

import com.bilibili.lib.gripper.api.SuspendProducer;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kntr.base.net.GNetPublicHeader;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.GNetPublicParamList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GPrimer.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001at\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"providesGPrimer", "Lkntr/base/primer/GPrimer;", "suspendGetPublicParam", "", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/GNetPublicParam;", "suspendGetPublicParamList", "Lkntr/base/net/GNetPublicParamList;", "suspendGetCommonHeader", "Lkntr/base/net/GNetPublicHeader;", "suspendGetBizParams", "Lkntr/base/primer/GPrimerBizParams;", "suspendGetBizParamsList", "Lkntr/base/primer/GPrimerBizParamsList;", "accountStore", "Lkntr/base/account/KAccountStore;", "primer_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GPrimerKt {
    public static final GPrimer providesGPrimer(Set<? extends SuspendProducer<GNetPublicParam>> set, Set<? extends SuspendProducer<GNetPublicParamList>> set2, Set<? extends SuspendProducer<GNetPublicHeader>> set3, Set<? extends SuspendProducer<GPrimerBizParams>> set4, Set<? extends SuspendProducer<GPrimerBizParamsList>> set5, KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(set, "suspendGetPublicParam");
        Intrinsics.checkNotNullParameter(set2, "suspendGetPublicParamList");
        Intrinsics.checkNotNullParameter(set3, "suspendGetCommonHeader");
        Intrinsics.checkNotNullParameter(set4, "suspendGetBizParams");
        Intrinsics.checkNotNullParameter(set5, "suspendGetBizParamsList");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        return new GPrimerServer(set, set2, set3, set4, set5, accountStore);
    }
}