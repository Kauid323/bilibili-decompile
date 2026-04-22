package io.ktor.util.cio;

import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileChannelsAtNioPath.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsAtNioPathKt$readChannel$1", f = "FileChannelsAtNioPath.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
final class FileChannelsAtNioPathKt$readChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ long $start;
    final /* synthetic */ Path $this_readChannel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChannelsAtNioPathKt$readChannel$1(long j, long j2, long j3, Path path, Continuation<? super FileChannelsAtNioPathKt$readChannel$1> continuation) {
        super(2, continuation);
        this.$start = j;
        this.$endInclusive = j2;
        this.$fileLength = j3;
        this.$this_readChannel = path;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileChannelsAtNioPathKt$readChannel$1 = new FileChannelsAtNioPathKt$readChannel$1(this.$start, this.$endInclusive, this.$fileLength, this.$this_readChannel, continuation);
        fileChannelsAtNioPathKt$readChannel$1.L$0 = obj;
        return fileChannelsAtNioPathKt$readChannel$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v20 */
    public final Object invokeSuspend(Object $result) {
        SeekableByteChannel seekableByteChannel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WriterScope $this$writer = (WriterScope) this.L$0;
                boolean z = this.$start >= 0;
                long j = this.$start;
                if (z) {
                    boolean z2 = this.$endInclusive <= this.$fileLength - 1;
                    long j2 = this.$fileLength;
                    long j3 = this.$endInclusive;
                    if (z2) {
                        SeekableByteChannel newByteChannel = Files.newByteChannel(this.$this_readChannel, new OpenOption[0]);
                        long j4 = this.$start;
                        long j5 = this.$endInclusive;
                        try {
                            SeekableByteChannel fileChannel = newByteChannel;
                            Intrinsics.checkNotNull(fileChannel);
                            this.L$0 = newByteChannel;
                            this.label = 1;
                            if (FileChannelsKt.writeToScope(fileChannel, $this$writer, j4, j5, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            seekableByteChannel = newByteChannel;
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally((Closeable) seekableByteChannel, (Throwable) null);
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            seekableByteChannel = newByteChannel;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally((Closeable) seekableByteChannel, th);
                                throw th2;
                            }
                        }
                    }
                    throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + j2 + ", endInclusive = " + j3).toString());
                }
                throw new IllegalArgumentException(("start position shouldn't be negative but it is " + j).toString());
            case 1:
                seekableByteChannel = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    seekableByteChannel = seekableByteChannel;
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally((Closeable) seekableByteChannel, (Throwable) null);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}