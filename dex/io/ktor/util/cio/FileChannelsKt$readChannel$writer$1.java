package io.ktor.util.cio;

import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileChannels.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$writer$1", f = "FileChannels.kt", i = {0, 0}, l = {42}, m = "invokeSuspend", n = {"$this$use$iv", "closed$iv"}, s = {"L$0", "I$0"})
public final class FileChannelsKt$readChannel$writer$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ Lazy<RandomAccessFile> $randomAccessFile$delegate;
    final /* synthetic */ long $start;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileChannelsKt$readChannel$writer$1(long j, long j2, long j3, Lazy<? extends RandomAccessFile> lazy, Continuation<? super FileChannelsKt$readChannel$writer$1> continuation) {
        super(2, continuation);
        this.$start = j;
        this.$endInclusive = j2;
        this.$fileLength = j3;
        this.$randomAccessFile$delegate = lazy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileChannelsKt$readChannel$writer$1 = new FileChannelsKt$readChannel$writer$1(this.$start, this.$endInclusive, this.$fileLength, this.$randomAccessFile$delegate, continuation);
        fileChannelsKt$readChannel$writer$1.L$0 = obj;
        return fileChannelsKt$readChannel$writer$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Closeable readChannel$lambda$1;
        Closeable $this$use$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WriterScope $this$writer = (WriterScope) this.L$0;
                boolean z = this.$start >= 0;
                long j = this.$start;
                if (!z) {
                    throw new IllegalArgumentException(("start position shouldn't be negative but it is " + j).toString());
                }
                boolean z2 = this.$endInclusive <= this.$fileLength - 1;
                long j2 = this.$fileLength;
                long j3 = this.$endInclusive;
                if (z2) {
                    readChannel$lambda$1 = FileChannelsKt.readChannel$lambda$1(this.$randomAccessFile$delegate);
                    Closeable $this$use$iv2 = readChannel$lambda$1;
                    long j4 = this.$start;
                    long j5 = this.$endInclusive;
                    try {
                        RandomAccessFile file = (RandomAccessFile) $this$use$iv2;
                        FileChannel fileChannel = file.getChannel();
                        Intrinsics.checkNotNullExpressionValue(fileChannel, "getChannel(...)");
                        this.L$0 = $this$use$iv2;
                        this.I$0 = 0;
                        this.label = 1;
                        if (FileChannelsKt.writeToScope(fileChannel, $this$writer, j4, j5, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$use$iv = $this$use$iv2;
                        Unit unit = Unit.INSTANCE;
                        if ($this$use$iv != null) {
                            $this$use$iv.close();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        cause$iv = th;
                        $this$use$iv = $this$use$iv2;
                        if ($this$use$iv != null) {
                        }
                        throw cause$iv;
                    }
                }
                throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + j2 + ", endInclusive = " + j3).toString());
            case 1:
                int i = this.I$0;
                $this$use$iv = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$use$iv = $this$use$iv;
                    Unit unit2 = Unit.INSTANCE;
                    if ($this$use$iv != null) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    cause$iv = th2;
                    if ($this$use$iv != null) {
                        try {
                            $this$use$iv.close();
                        }
                    }
                    throw cause$iv;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}