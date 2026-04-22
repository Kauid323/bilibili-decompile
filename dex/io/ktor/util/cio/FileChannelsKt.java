package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ChannelJob;
import io.ktor.utils.io.WriterScope;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: FileChannels.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014²\u0006\f\u0010\u0013\u001a\u00020\u00128\nX\u008a\u0084\u0002"}, d2 = {"Ljava/io/File;", "", "start", "endInclusive", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "(Ljava/io/File;JJLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/channels/SeekableByteChannel;", "Lio/ktor/utils/io/WriterScope;", "writerScope", "", "writeToScope", "(Ljava/nio/channels/SeekableByteChannel;Lio/ktor/utils/io/WriterScope;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "(Ljava/io/File;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/io/RandomAccessFile;", "randomAccessFile", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FileChannelsKt {
    public static final ByteReadChannel readChannel(final File $this$readChannel, long start, long endInclusive, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter($this$readChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        long fileLength = $this$readChannel.length();
        final Lazy randomAccessFile$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                RandomAccessFile readChannel$lambda$0;
                readChannel$lambda$0 = FileChannelsKt.readChannel$lambda$0($this$readChannel);
                return readChannel$lambda$0;
            }
        });
        ChannelJob writer = ByteWriteChannelOperationsKt.writer(CoroutineScopeKt.CoroutineScope(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, new FileChannelsKt$readChannel$writer$1(start, endInclusive, fileLength, randomAccessFile$delegate, null));
        ByteWriteChannelOperationsKt.invokeOnCompletion(writer, new Function0() { // from class: io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit readChannel$lambda$2;
                readChannel$lambda$2 = FileChannelsKt.readChannel$lambda$2(randomAccessFile$delegate);
                return readChannel$lambda$2;
            }
        });
        return writer.getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile readChannel$lambda$0(File $this_readChannel) {
        return new RandomAccessFile($this_readChannel, "r");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile readChannel$lambda$1(Lazy<? extends RandomAccessFile> lazy) {
        return (RandomAccessFile) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readChannel$lambda$2(Lazy $randomAccessFile$delegate) {
        readChannel$lambda$1($randomAccessFile$delegate).close();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0139 -> B:46:0x013f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x028b -> B:88:0x0292). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeToScope(SeekableByteChannel $this$writeToScope, WriterScope writerScope, long start, long endInclusive, Continuation<? super Unit> continuation) {
        FileChannelsKt$writeToScope$1 fileChannelsKt$writeToScope$1;
        SeekableByteChannel $this$writeToScope2;
        Ref.LongRef position;
        int $this$writeToScope3;
        ByteWriteChannel $this$writeWhile$iv;
        Ref.BooleanRef done$iv;
        long endInclusive2;
        SeekableByteChannel $this$writeToScope4;
        int $i$f$writeWhile;
        ByteWriteChannel $this$writeWhile$iv2;
        Ref.BooleanRef done$iv2;
        String str;
        String str2;
        int read;
        byte[] data$iv$iv;
        FileChannelsKt$writeToScope$1 fileChannelsKt$writeToScope$12;
        Continuation $completion;
        int $i$f$writeWhile2;
        Object obj;
        Object $result;
        Continuation $completion2 = continuation;
        if ($completion2 instanceof FileChannelsKt$writeToScope$1) {
            fileChannelsKt$writeToScope$1 = (FileChannelsKt$writeToScope$1) $completion2;
            if ((fileChannelsKt$writeToScope$1.label & Integer.MIN_VALUE) != 0) {
                fileChannelsKt$writeToScope$1.label -= Integer.MIN_VALUE;
                Object $result2 = fileChannelsKt$writeToScope$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                String str3 = ". Should be in 0..";
                String str4 = "Invalid number of bytes written: ";
                boolean z = false;
                switch (fileChannelsKt$writeToScope$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        if (start > 0) {
                            $this$writeToScope.position(start);
                        }
                        if (endInclusive == -1) {
                            ByteWriteChannel $this$writeWhile$iv3 = writerScope.getChannel();
                            $this$writeToScope4 = $this$writeToScope;
                            $i$f$writeWhile = 0;
                            $this$writeWhile$iv2 = $this$writeWhile$iv3;
                            done$iv2 = new Ref.BooleanRef();
                            if (!done$iv2.element) {
                                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                                Buffer buffer$iv$iv = $this$writeWhile$iv2.getWriteBuffer().getBuffer();
                                Segment tail$iv$iv = buffer$iv$iv.writableSegment(1);
                                byte[] data$iv$iv2 = tail$iv$iv.dataAsByteArray(z);
                                int start$iv = tail$iv$iv.getLimit();
                                Continuation $completion3 = $completion2;
                                int endExclusive$iv = data$iv$iv2.length;
                                Object $result4 = $result2;
                                ByteBuffer buffer$iv = ByteBuffer.wrap(data$iv$iv2, start$iv, endExclusive$iv - start$iv);
                                Intrinsics.checkNotNull(buffer$iv);
                                int rc = $this$writeToScope4.read(buffer$iv);
                                int $i$f$writeWhile3 = $i$f$writeWhile;
                                int rc2 = rc != -1 ? 1 : 0;
                                done$iv2.element = rc2 ^ 1;
                                int bytesWritten$iv$iv = buffer$iv.position() - start$iv;
                                if (bytesWritten$iv$iv == 1) {
                                    tail$iv$iv.writeBackData(data$iv$iv2, bytesWritten$iv$iv);
                                    tail$iv$iv.setLimit(tail$iv$iv.getLimit() + bytesWritten$iv$iv);
                                    buffer$iv$iv.setSizeMut(buffer$iv$iv.getSizeMut() + bytesWritten$iv$iv);
                                } else {
                                    if (!(bytesWritten$iv$iv >= 0 && bytesWritten$iv$iv <= tail$iv$iv.getRemainingCapacity())) {
                                        throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv$iv + ". Should be in 0.." + tail$iv$iv.getRemainingCapacity()).toString());
                                    }
                                    if (bytesWritten$iv$iv != 0) {
                                        tail$iv$iv.writeBackData(data$iv$iv2, bytesWritten$iv$iv);
                                        tail$iv$iv.setLimit(tail$iv$iv.getLimit() + bytesWritten$iv$iv);
                                        buffer$iv$iv.setSizeMut(buffer$iv$iv.getSizeMut() + bytesWritten$iv$iv);
                                    } else if (SegmentKt.isEmpty(tail$iv$iv)) {
                                        buffer$iv$iv.recycleTail();
                                    }
                                }
                                fileChannelsKt$writeToScope$1.L$0 = $this$writeToScope4;
                                fileChannelsKt$writeToScope$1.L$1 = $this$writeWhile$iv2;
                                fileChannelsKt$writeToScope$1.L$2 = done$iv2;
                                fileChannelsKt$writeToScope$1.label = 1;
                                if ($this$writeWhile$iv2.flush(fileChannelsKt$writeToScope$1) == $result3) {
                                    return $result3;
                                }
                                $completion2 = $completion3;
                                $i$f$writeWhile = $i$f$writeWhile3;
                                $result2 = $result4;
                                z = false;
                                if (!done$iv2.element) {
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            Ref.LongRef position2 = new Ref.LongRef();
                            position2.element = start;
                            ByteWriteChannel $this$writeWhile$iv4 = writerScope.getChannel();
                            $this$writeToScope2 = $this$writeToScope;
                            position = position2;
                            $this$writeToScope3 = 0;
                            $this$writeWhile$iv = $this$writeWhile$iv4;
                            done$iv = new Ref.BooleanRef();
                            endInclusive2 = endInclusive;
                            if (!done$iv.element) {
                                UnsafeBufferOperations unsafeBufferOperations2 = UnsafeBufferOperations.INSTANCE;
                                Buffer buffer$iv$iv2 = $this$writeWhile$iv.getWriteBuffer().getBuffer();
                                Continuation $completion4 = $completion2;
                                Segment tail$iv$iv2 = buffer$iv$iv2.writableSegment(1);
                                Object $result5 = $result2;
                                int $i$f$writeWhile4 = $this$writeToScope3;
                                byte[] data$iv$iv3 = tail$iv$iv2.dataAsByteArray(false);
                                int start$iv2 = tail$iv$iv2.getLimit();
                                int $i$f$writeToTail = data$iv$iv3.length;
                                str = str3;
                                ByteBuffer buffer$iv2 = ByteBuffer.wrap(data$iv$iv3, start$iv2, $i$f$writeToTail - start$iv2);
                                Intrinsics.checkNotNull(buffer$iv2);
                                str2 = str4;
                                long fileRemaining = (endInclusive2 - position.element) + 1;
                                Object obj2 = $result3;
                                FileChannelsKt$writeToScope$1 fileChannelsKt$writeToScope$13 = fileChannelsKt$writeToScope$1;
                                if (fileRemaining < buffer$iv2.remaining()) {
                                    int l = buffer$iv2.limit();
                                    buffer$iv2.limit(buffer$iv2.position() + ((int) fileRemaining));
                                    read = $this$writeToScope2.read(buffer$iv2);
                                    buffer$iv2.limit(l);
                                } else {
                                    read = $this$writeToScope2.read(buffer$iv2);
                                }
                                int rc3 = read;
                                if (rc3 > 0) {
                                    data$iv$iv = data$iv$iv3;
                                    position.element += rc3;
                                } else {
                                    data$iv$iv = data$iv$iv3;
                                }
                                done$iv.element = !(rc3 != -1 && position.element <= endInclusive2);
                                int bytesWritten$iv$iv2 = buffer$iv2.position() - start$iv2;
                                if (bytesWritten$iv$iv2 == 1) {
                                    tail$iv$iv2.writeBackData(data$iv$iv, bytesWritten$iv$iv2);
                                    tail$iv$iv2.setLimit(tail$iv$iv2.getLimit() + bytesWritten$iv$iv2);
                                    buffer$iv$iv2.setSizeMut(buffer$iv$iv2.getSizeMut() + bytesWritten$iv$iv2);
                                } else {
                                    byte[] data$iv$iv4 = data$iv$iv;
                                    if (!(bytesWritten$iv$iv2 >= 0 && bytesWritten$iv$iv2 <= tail$iv$iv2.getRemainingCapacity())) {
                                        throw new IllegalStateException((str2 + bytesWritten$iv$iv2 + str + tail$iv$iv2.getRemainingCapacity()).toString());
                                    }
                                    if (bytesWritten$iv$iv2 != 0) {
                                        tail$iv$iv2.writeBackData(data$iv$iv4, bytesWritten$iv$iv2);
                                        tail$iv$iv2.setLimit(tail$iv$iv2.getLimit() + bytesWritten$iv$iv2);
                                        buffer$iv$iv2.setSizeMut(buffer$iv$iv2.getSizeMut() + bytesWritten$iv$iv2);
                                    } else if (SegmentKt.isEmpty(tail$iv$iv2)) {
                                        buffer$iv$iv2.recycleTail();
                                    }
                                }
                                fileChannelsKt$writeToScope$12 = fileChannelsKt$writeToScope$13;
                                fileChannelsKt$writeToScope$12.L$0 = $this$writeToScope2;
                                fileChannelsKt$writeToScope$12.L$1 = position;
                                fileChannelsKt$writeToScope$12.L$2 = $this$writeWhile$iv;
                                fileChannelsKt$writeToScope$12.L$3 = done$iv;
                                fileChannelsKt$writeToScope$12.J$0 = endInclusive2;
                                fileChannelsKt$writeToScope$12.label = 2;
                                if ($this$writeWhile$iv.flush(fileChannelsKt$writeToScope$12) == obj2) {
                                    return obj2;
                                }
                                $completion = $completion4;
                                $i$f$writeWhile2 = $i$f$writeWhile4;
                                obj = obj2;
                                $result = $result5;
                                $completion2 = $completion;
                                $result2 = $result;
                                $result3 = obj;
                                $this$writeToScope3 = $i$f$writeWhile2;
                                fileChannelsKt$writeToScope$1 = fileChannelsKt$writeToScope$12;
                                str3 = str;
                                str4 = str2;
                                if (!done$iv.element) {
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        break;
                    case 1:
                        $i$f$writeWhile = 0;
                        done$iv2 = (Ref.BooleanRef) fileChannelsKt$writeToScope$1.L$2;
                        $this$writeWhile$iv2 = (ByteWriteChannel) fileChannelsKt$writeToScope$1.L$1;
                        $this$writeToScope4 = (SeekableByteChannel) fileChannelsKt$writeToScope$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        z = false;
                        if (!done$iv2.element) {
                        }
                        break;
                    case 2:
                        endInclusive2 = fileChannelsKt$writeToScope$1.J$0;
                        done$iv = (Ref.BooleanRef) fileChannelsKt$writeToScope$1.L$3;
                        $this$writeWhile$iv = (ByteWriteChannel) fileChannelsKt$writeToScope$1.L$2;
                        position = (Ref.LongRef) fileChannelsKt$writeToScope$1.L$1;
                        $this$writeToScope2 = (SeekableByteChannel) fileChannelsKt$writeToScope$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        str = ". Should be in 0..";
                        str2 = "Invalid number of bytes written: ";
                        fileChannelsKt$writeToScope$12 = fileChannelsKt$writeToScope$1;
                        $i$f$writeWhile2 = 0;
                        obj = $result3;
                        $result = $result2;
                        $completion = $completion2;
                        $completion2 = $completion;
                        $result2 = $result;
                        $result3 = obj;
                        $this$writeToScope3 = $i$f$writeWhile2;
                        fileChannelsKt$writeToScope$1 = fileChannelsKt$writeToScope$12;
                        str3 = str;
                        str4 = str2;
                        if (!done$iv.element) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileChannelsKt$writeToScope$1 = new FileChannelsKt$writeToScope$1($completion2);
        Object $result22 = fileChannelsKt$writeToScope$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str32 = ". Should be in 0..";
        String str42 = "Invalid number of bytes written: ";
        boolean z2 = false;
        switch (fileChannelsKt$writeToScope$1.label) {
        }
    }

    public static /* synthetic */ ByteWriteChannel writeChannel$default(File file, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getIO();
        }
        return writeChannel(file, coroutineContext);
    }

    public static final ByteWriteChannel writeChannel(File $this$writeChannel, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter($this$writeChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader(GlobalScope.INSTANCE, new CoroutineName("file-writer").plus(coroutineContext), true, new FileChannelsKt$writeChannel$1($this$writeChannel, null)).getChannel();
    }
}