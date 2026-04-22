package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.ReaderScope;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", i = {0, 0, 0}, l = {104}, m = "invokeSuspend", n = {"$this$use$iv", "file", "closed$iv"}, s = {"L$0", "L$1", "I$0"})
public final class FileChannelsKt$writeChannel$1 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $this_writeChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$writeChannel$1(File file, Continuation<? super FileChannelsKt$writeChannel$1> continuation) {
        super(2, continuation);
        this.$this_writeChannel = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileChannelsKt$writeChannel$1 = new FileChannelsKt$writeChannel$1(this.$this_writeChannel, continuation);
        fileChannelsKt$writeChannel$1.L$0 = obj;
        return fileChannelsKt$writeChannel$1;
    }

    public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
        return create(readerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        RandomAccessFile $this$use$iv;
        boolean closed$iv;
        int i;
        RandomAccessFile file;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ReaderScope $this$reader = (ReaderScope) this.L$0;
                $this$use$iv = new RandomAccessFile(this.$this_writeChannel, "rw");
                closed$iv = false;
                i = 0;
                try {
                    file = $this$use$iv;
                    ByteReadChannel channel = $this$reader.getChannel();
                    FileChannel channel2 = file.getChannel();
                    Intrinsics.checkNotNullExpressionValue(channel2, "getChannel(...)");
                    this.L$0 = $this$use$iv;
                    this.L$1 = file;
                    this.I$0 = 0;
                    this.label = 1;
                    Object copyTo$default = ByteReadChannelOperations_jvmKt.copyTo$default(channel, channel2, 0L, this, 2, (Object) null);
                    if (copyTo$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = copyTo$default;
                    try {
                        long copied = ((Number) $result).longValue();
                        file.setLength(copied);
                        Unit unit = Unit.INSTANCE;
                        if ($this$use$iv != null) {
                            $this$use$iv.close();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        cause$iv = th;
                        if ($this$use$iv != null) {
                            try {
                                $this$use$iv.close();
                            }
                        }
                        throw cause$iv;
                    }
                } catch (Throwable th2) {
                    cause$iv = th2;
                    if ($this$use$iv != null) {
                    }
                    throw cause$iv;
                }
            case 1:
                int i2 = this.I$0;
                RandomAccessFile file2 = (RandomAccessFile) this.L$1;
                $this$use$iv = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    file = file2;
                    i = i2;
                    closed$iv = false;
                    $result2 = $result;
                    long copied2 = ((Number) $result).longValue();
                    file.setLength(copied2);
                    Unit unit2 = Unit.INSTANCE;
                    if ($this$use$iv != null) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    cause$iv = th3;
                    if ($this$use$iv != null) {
                    }
                    throw cause$iv;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}