package kntr.app.ad.domain.report.internal;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: ReportUtil.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient", "()Lio/ktor/client/HttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "reportConfig", "Lkntr/app/ad/domain/report/internal/ReportConfig;", "getReportConfig", "()Lkntr/app/ad/domain/report/internal/ReportConfig;", "reportScope", "Lkotlinx/coroutines/CoroutineScope;", "getReportScope", "()Lkotlinx/coroutines/CoroutineScope;", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportUtilKt {
    private static final Lazy httpClient$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.report.internal.ReportUtilKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            HttpClient httpClient_delegate$lambda$0;
            httpClient_delegate$lambda$0 = ReportUtilKt.httpClient_delegate$lambda$0();
            return httpClient_delegate$lambda$0;
        }
    });
    private static final ReportConfig reportConfig = new ReportConfig(0, 0, 0, 0, 0, null, 63, null);
    private static final CoroutineScope reportScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(CoroutineExJvmKt.getIoContext()));

    public static final HttpClient getHttpClient() {
        return (HttpClient) httpClient$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClient httpClient_delegate$lambda$0() {
        return HttpClientKt.HttpClient(ReportUtil_androidKt.httpEngine(), new Function1() { // from class: kntr.app.ad.domain.report.internal.ReportUtilKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$0$0;
                httpClient_delegate$lambda$0$0 = ReportUtilKt.httpClient_delegate$lambda$0$0((HttpClientConfig) obj);
                return httpClient_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0(HttpClientConfig $this$HttpClient) {
        Intrinsics.checkNotNullParameter($this$HttpClient, "$this$HttpClient");
        return Unit.INSTANCE;
    }

    public static final ReportConfig getReportConfig() {
        return reportConfig;
    }

    public static final CoroutineScope getReportScope() {
        return reportScope;
    }
}