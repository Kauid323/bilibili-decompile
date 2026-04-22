package kntr.common.share.domain.http;

import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareHttpClient.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"HTTP_TIMEOUT", "", "httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient", "()Lio/ktor/client/HttpClient;", "domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareHttpClientKt {
    private static final long HTTP_TIMEOUT = 5000;
    private static final HttpClient httpClient = KtorClientKt.getKtorHttpClient().config(new Function1() { // from class: kntr.common.share.domain.http.ShareHttpClientKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            Unit httpClient$lambda$0;
            httpClient$lambda$0 = ShareHttpClientKt.httpClient$lambda$0((HttpClientConfig) obj);
            return httpClient$lambda$0;
        }
    });

    public static final HttpClient getHttpClient() {
        return httpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient$lambda$0(HttpClientConfig $this$config) {
        Intrinsics.checkNotNullParameter($this$config, "$this$config");
        $this$config.install(HttpTimeoutKt.getHttpTimeout(), new Function1() { // from class: kntr.common.share.domain.http.ShareHttpClientKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit httpClient$lambda$0$0;
                httpClient$lambda$0$0 = ShareHttpClientKt.httpClient$lambda$0$0((HttpTimeoutConfig) obj);
                return httpClient$lambda$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient$lambda$0$0(HttpTimeoutConfig $this$install) {
        Intrinsics.checkNotNullParameter($this$install, "$this$install");
        Long valueOf = Long.valueOf((long) HTTP_TIMEOUT);
        $this$install.setConnectTimeoutMillis(valueOf);
        $this$install.setRequestTimeoutMillis(valueOf);
        return Unit.INSTANCE;
    }
}