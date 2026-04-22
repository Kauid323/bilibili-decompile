package io.ktor.client.engine;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class UtilsKt$attachToUserJob$cleanupHandler$1 implements Function1<Throwable, Unit> {
    final /* synthetic */ Job $callJob;

    public UtilsKt$attachToUserJob$cleanupHandler$1(Job job) {
        this.$callJob = job;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Throwable) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable cause) {
        if (cause == null) {
            return;
        }
        this.$callJob.cancel(new CancellationException(cause.getMessage()));
    }
}