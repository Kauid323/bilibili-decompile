package kntr.base.net.comm.muiltidomain;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkntr/base/net/comm/muiltidomain/Rule;", "", "sample", "", "domains", "", "", "alt", "<init>", "(FLjava/util/List;Ljava/lang/String;)V", "getSample", "()F", "getDomains", "()Ljava/util/List;", "getAlt", "()Ljava/lang/String;", "setAlt", "(Ljava/lang/String;)V", "multi_domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class Rule {
    private String alt;
    private final List<String> domains;
    private final float sample;

    public Rule(float sample, List<String> list, String alt) {
        Intrinsics.checkNotNullParameter(list, "domains");
        this.sample = sample;
        this.domains = list;
        this.alt = alt;
    }

    public /* synthetic */ Rule(float f, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, list, (i & 4) != 0 ? null : str);
    }

    public final float getSample() {
        return this.sample;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final String getAlt() {
        return this.alt;
    }

    public final void setAlt(String str) {
        this.alt = str;
    }
}