package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: ByteWriteChannelOperations.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ChannelJob;", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/Job;)V", "Lio/ktor/utils/io/ByteReadChannel;", "getChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class WriterJob implements ChannelJob {
    private final ByteReadChannel channel;
    private final Job job;

    public WriterJob(ByteReadChannel channel, Job job) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(job, "job");
        this.channel = channel;
        this.job = job;
    }

    public final ByteReadChannel getChannel() {
        return this.channel;
    }

    @Override // io.ktor.utils.io.ChannelJob
    public Job getJob() {
        return this.job;
    }
}