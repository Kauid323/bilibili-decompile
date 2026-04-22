package tv.danmaku.android.log.pipeline;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.internal.BLogThreadFactory;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: MultiCoreCompressor.kt */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\r\b\u0000\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006H\u0007R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/android/log/pipeline/MultiCoreCompressor;", "", "core", "", "onCompressComplete", "Lkotlin/Function1;", "Ltv/danmaku/android/log/pipeline/LogBlockJob;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "Job", "", "(ILkotlin/jvm/functions/Function1;)V", "deflaters", "tv/danmaku/android/log/pipeline/MultiCoreCompressor$deflaters$1", "Ltv/danmaku/android/log/pipeline/MultiCoreCompressor$deflaters$1;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "s", "Ljava/util/concurrent/atomic/AtomicLong;", LoginReporterV2.VALUE_SUBMIT, "job", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class MultiCoreCompressor {
    private final MultiCoreCompressor$deflaters$1 deflaters;
    private final ExecutorService executor;
    private final Function1<LogBlockJob, Unit> onCompressComplete;
    private final AtomicLong s;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [tv.danmaku.android.log.pipeline.MultiCoreCompressor$deflaters$1] */
    public MultiCoreCompressor(int core, Function1<? super LogBlockJob, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onCompressComplete");
        this.onCompressComplete = function1;
        this.executor = Executors.newFixedThreadPool(core, new BLogThreadFactory("compressor"));
        this.deflaters = new ThreadLocal<Deflater>() { // from class: tv.danmaku.android.log.pipeline.MultiCoreCompressor$deflaters$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Deflater initialValue() {
                return new Deflater(-1, true);
            }
        };
        this.s = new AtomicLong();
        new Thread(new Runnable() { // from class: tv.danmaku.android.log.pipeline.MultiCoreCompressor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MultiCoreCompressor._init_$lambda$0(MultiCoreCompressor.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MultiCoreCompressor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Thread.sleep(8000L);
        System.out.println((Object) ("deflate: " + (this$0.s.get() / 1000000.0d)));
    }

    public final void submit(final LogBlockJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        this.executor.execute(new Runnable() { // from class: tv.danmaku.android.log.pipeline.MultiCoreCompressor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MultiCoreCompressor.submit$lambda$2(LogBlockJob.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submit$lambda$2(LogBlockJob $job, MultiCoreCompressor this$0) {
        Intrinsics.checkNotNullParameter($job, "$job");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ($job.getSize() == 0) {
            this$0.onCompressComplete.invoke($job);
            return;
        }
        Deflater deflater = this$0.deflaters.get();
        Intrinsics.checkNotNull(deflater);
        Deflater deflater2 = deflater;
        byte[] it = $job.getPreLog();
        if (it != null) {
            deflater2.setDictionary(it);
        }
        deflater2.setInput($job.getCurLog(), 0, $job.getSize());
        int offset = 0;
        byte[] output = new byte[$job.getSize() + 32];
        while (true) {
            long s2 = System.nanoTime();
            offset += deflater2.deflate(output, offset, output.length - offset, 2);
            this$0.s.addAndGet(System.nanoTime() - s2);
            if (output.length == offset) {
                output = DefaltedConstants.INSTANCE.getCOMPRESS_ERROR_HINT();
                offset = DefaltedConstants.INSTANCE.getCOMPRESS_ERROR_HINT().length;
                break;
            } else if (deflater2.needsInput()) {
                break;
            }
        }
        $job.setCurLog(output);
        $job.setSize(offset);
        this$0.onCompressComplete.invoke($job);
        deflater2.reset();
    }
}