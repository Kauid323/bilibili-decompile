package kntr.common.share.domain;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.GShare;
import kntr.common.share.domain.http.ShareDefaultApiService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Domain.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"defaultDomain", "Lkntr/common/share/domain/ShareDomainApi;", "Lkntr/common/share/common/GShare;", "domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DomainKt {
    public static final ShareDomainApi defaultDomain(GShare $this$defaultDomain) {
        Intrinsics.checkNotNullParameter($this$defaultDomain, "<this>");
        return new ShareDefaultApiService();
    }
}