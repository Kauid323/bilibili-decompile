package kntr.base.primer;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GPrimer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/base/primer/PrimerParam;", "", "common", "Lkntr/base/primer/PrimerCommonParams;", "biz", "", "Lkntr/base/primer/PrimerBizParams;", "<init>", "(Lkntr/base/primer/PrimerCommonParams;Ljava/util/List;)V", "getCommon", "()Lkntr/base/primer/PrimerCommonParams;", "getBiz", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PrimerParam {
    private final List<PrimerBizParams> biz;
    private final PrimerCommonParams common;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrimerParam copy$default(PrimerParam primerParam, PrimerCommonParams primerCommonParams, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            primerCommonParams = primerParam.common;
        }
        if ((i & 2) != 0) {
            list = primerParam.biz;
        }
        return primerParam.copy(primerCommonParams, list);
    }

    public final PrimerCommonParams component1() {
        return this.common;
    }

    public final List<PrimerBizParams> component2() {
        return this.biz;
    }

    public final PrimerParam copy(PrimerCommonParams primerCommonParams, List<PrimerBizParams> list) {
        Intrinsics.checkNotNullParameter(primerCommonParams, "common");
        Intrinsics.checkNotNullParameter(list, "biz");
        return new PrimerParam(primerCommonParams, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrimerParam) {
            PrimerParam primerParam = (PrimerParam) obj;
            return Intrinsics.areEqual(this.common, primerParam.common) && Intrinsics.areEqual(this.biz, primerParam.biz);
        }
        return false;
    }

    public int hashCode() {
        return (this.common.hashCode() * 31) + this.biz.hashCode();
    }

    public String toString() {
        PrimerCommonParams primerCommonParams = this.common;
        return "PrimerParam(common=" + primerCommonParams + ", biz=" + this.biz + ")";
    }

    public PrimerParam(PrimerCommonParams common, List<PrimerBizParams> list) {
        Intrinsics.checkNotNullParameter(common, "common");
        Intrinsics.checkNotNullParameter(list, "biz");
        this.common = common;
        this.biz = list;
    }

    public final PrimerCommonParams getCommon() {
        return this.common;
    }

    public final List<PrimerBizParams> getBiz() {
        return this.biz;
    }
}