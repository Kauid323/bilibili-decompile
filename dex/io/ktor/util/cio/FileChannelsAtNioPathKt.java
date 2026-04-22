package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.nio.file.Files;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: FileChannelsAtNioPath.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/file/Path;", "", "start", "endInclusive", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "(Ljava/nio/file/Path;JJLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FileChannelsAtNioPathKt {
    public static final ByteReadChannel readChannel(Path $this$readChannel, long start, long endInclusive, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter($this$readChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        long fileLength = Files.size($this$readChannel);
        return ByteWriteChannelOperationsKt.writer(CoroutineScopeKt.CoroutineScope(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, new FileChannelsAtNioPathKt$readChannel$1(start, endInclusive, fileLength, $this$readChannel, null)).getChannel();
    }
}