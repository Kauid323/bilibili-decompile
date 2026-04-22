package kntr.base.net.comm;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.muiltidomain.RuleConfig;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;

/* compiled from: GMultiDomain.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0016\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0016\u0010\u0015\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/base/net/comm/GMultiDomain;", "", "enabled", "", "host", "", "domains", "", "alternative", "setAlternative", "", "alternativeHost", "updateRules", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/net/comm/muiltidomain/RuleConfig;", "retriable", "e", "", "retriableResponse", "httpCode", "", "setRetryHost", "multi_domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GMultiDomain {
    String alternative(String str);

    List<String> domains(String str);

    boolean enabled(String str);

    boolean retriable(Throwable th);

    boolean retriableResponse(String str, int i);

    void setAlternative(String str, String str2);

    void setRetryHost(List<String> list);

    void updateRules(List<RuleConfig> list);
}