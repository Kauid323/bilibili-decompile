package kntr.base.net.comm.muiltidomain;

import java.util.HashSet;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.GMultiDomain;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiDomainProducer.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"producerMultiDomain", "Lkntr/base/net/comm/GMultiDomain;", "multi_domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MultiDomainProducerKt {
    public static final GMultiDomain producerMultiDomain() {
        return new GMultiDomain() { // from class: kntr.base.net.comm.muiltidomain.MultiDomainProducerKt$producerMultiDomain$1
            private final HashSet<String> retryHostDomains = new HashSet<>();

            @Override // kntr.base.net.comm.GMultiDomain
            public boolean enabled(String host) {
                Intrinsics.checkNotNullParameter(host, "host");
                return MultiDomain.INSTANCE.isEnabled(host);
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public List<String> domains(String host) {
                Intrinsics.checkNotNullParameter(host, "host");
                return MultiDomain.INSTANCE.domains(host);
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public String alternative(String host) {
                Intrinsics.checkNotNullParameter(host, "host");
                return MultiDomain.INSTANCE.alternative(host);
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public void setAlternative(String host, String alternativeHost) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(alternativeHost, "alternativeHost");
                MultiDomain.INSTANCE.setAlternative(host, alternativeHost);
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public void updateRules(List<RuleConfig> list) {
                Intrinsics.checkNotNullParameter(list, RedirectImpKt.REDIRECT_KV_CONFIG);
                MultiDomain.INSTANCE.updateRules(list);
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public boolean retriable(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return (e instanceof Exception) && UtilsKt.isRetryable((Exception) e);
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public boolean retriableResponse(String host, int httpCode) {
                Intrinsics.checkNotNullParameter(host, "host");
                if (isRetryableHttpCode(httpCode)) {
                    return isRetryableHost(host);
                }
                return false;
            }

            @Override // kntr.base.net.comm.GMultiDomain
            public void setRetryHost(List<String> list) {
                Intrinsics.checkNotNullParameter(list, "domains");
                this.retryHostDomains.addAll(list);
            }

            private final boolean isRetryableHost(String host) {
                return this.retryHostDomains.contains(host);
            }

            private final boolean isRetryableHttpCode(int code) {
                return code == 502 || code == 504 || code == 500;
            }
        };
    }
}