package kntr.common.upper.trace.service;

import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: TraceTimingService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/common/upper/trace/service/TraceTimingService;", "", "<init>", "()V", "client", "Lio/ktor/client/HttpClient;", "job", "Lkotlinx/coroutines/Job;", "requestOffsetTime", "cancel", "", "clockOffset", "", "ct1", "ct2", "st1", "st2", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceTimingService {
    public static final TraceTimingService INSTANCE = new TraceTimingService();
    private static final HttpClient client = KtorClientKt.getKtorHttpClient();
    private static Job job;

    private TraceTimingService() {
    }

    public final Job requestOffsetTime() {
        Job it = BuildersKt.launch$default(ioScope(), (CoroutineExceptionHandler) new TraceTimingService$requestOffsetTime$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key), (CoroutineStart) null, new TraceTimingService$requestOffsetTime$2(null), 2, (Object) null);
        job = it;
        return it;
    }

    public final void cancel() {
        Job job2 = job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        job = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long clockOffset(long ct1, long ct2, long st1, long st2) {
        return ((st1 - ct1) + (st2 - ct2)) / 2;
    }

    private final CoroutineScope ioScope() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }
}