package io.ktor.client.plugins.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import faceverify.q;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterJob;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: ByteChannelReplay.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/plugins/internal/ByteChannelReplay;", "", "Lio/ktor/utils/io/ByteReadChannel;", "origin", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "replay", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "CopyFromSourceTask", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteChannelReplay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater content$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannelReplay.class, Object.class, q.KEY_RES_9_CONTENT);
    private volatile /* synthetic */ Object content;
    private final ByteReadChannel origin;

    public ByteChannelReplay(ByteReadChannel origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
        this.content = null;
    }

    public final ByteReadChannel replay() {
        if (this.origin.getClosedCause() != null) {
            Throwable closedCause = this.origin.getClosedCause();
            Intrinsics.checkNotNull(closedCause);
            throw closedCause;
        }
        Ref.ObjectRef copyTask = new Ref.ObjectRef();
        copyTask.element = this.content;
        if (copyTask.element == null) {
            copyTask.element = new CopyFromSourceTask(this, null, 1, null);
            if (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(content$FU, this, (Object) null, copyTask.element)) {
                copyTask.element = this.content;
            } else {
                return ((CopyFromSourceTask) copyTask.element).start();
            }
        }
        return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, (CoroutineContext) null, false, new ByteChannelReplay$replay$1(copyTask, null), 3, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteChannelReplay.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/internal/ByteChannelReplay$CopyFromSourceTask;", "", "Lkotlinx/coroutines/CompletableDeferred;", "", "savedResponse", "<init>", "(Lio/ktor/client/plugins/internal/ByteChannelReplay;Lkotlinx/coroutines/CompletableDeferred;)V", "Lio/ktor/utils/io/ByteReadChannel;", "start", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/WriterJob;", "receiveBody", "()Lio/ktor/utils/io/WriterJob;", "awaitImpatiently", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableDeferred;", "getSavedResponse", "()Lkotlinx/coroutines/CompletableDeferred;", "writerJob", "Lio/ktor/utils/io/WriterJob;", "getWriterJob", "setWriterJob", "(Lio/ktor/utils/io/WriterJob;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class CopyFromSourceTask {
        private final CompletableDeferred<byte[]> savedResponse;
        final /* synthetic */ ByteChannelReplay this$0;
        public WriterJob writerJob;

        public CopyFromSourceTask(ByteChannelReplay this$0, CompletableDeferred<byte[]> completableDeferred) {
            Intrinsics.checkNotNullParameter(completableDeferred, "savedResponse");
            this.this$0 = this$0;
            this.savedResponse = completableDeferred;
        }

        public /* synthetic */ CopyFromSourceTask(ByteChannelReplay byteChannelReplay, CompletableDeferred completableDeferred, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(byteChannelReplay, (i2 & 1) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
        }

        public final CompletableDeferred<byte[]> getSavedResponse() {
            return this.savedResponse;
        }

        public final WriterJob getWriterJob() {
            WriterJob writerJob = this.writerJob;
            if (writerJob != null) {
                return writerJob;
            }
            Intrinsics.throwUninitializedPropertyAccessException("writerJob");
            return null;
        }

        public final void setWriterJob(WriterJob writerJob) {
            Intrinsics.checkNotNullParameter(writerJob, "<set-?>");
            this.writerJob = writerJob;
        }

        public final ByteReadChannel start() {
            setWriterJob(receiveBody());
            return getWriterJob().getChannel();
        }

        public final WriterJob receiveBody() {
            return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), false, new ByteChannelReplay$CopyFromSourceTask$receiveBody$1(this.this$0, this, null), 2, (Object) null);
        }

        public final Object awaitImpatiently(Continuation<? super byte[]> continuation) {
            if (!ByteWriteChannelOperationsKt.isCompleted(getWriterJob())) {
                getWriterJob().getChannel().cancel(new SaveBodyAbandonedReadException());
            }
            return this.savedResponse.await(continuation);
        }
    }
}