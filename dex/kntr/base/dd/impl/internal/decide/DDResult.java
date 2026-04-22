package kntr.base.dd.impl.internal.decide;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: DDResult.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DDResult;", "Lkntr/base/dd/impl/internal/decide/IDDResult;", "hit", "", "value", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getHit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getValue", "()Ljava/lang/String;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDResult implements IDDResult {
    private final Boolean hit;
    private final String value;

    public DDResult(Boolean hit, String value) {
        this.hit = hit;
        this.value = value;
    }

    @Override // kntr.base.dd.impl.internal.decide.IDDResult
    public Boolean getHit() {
        return this.hit;
    }

    @Override // kntr.base.dd.impl.internal.decide.IDDResult
    public String getValue() {
        return this.value;
    }
}