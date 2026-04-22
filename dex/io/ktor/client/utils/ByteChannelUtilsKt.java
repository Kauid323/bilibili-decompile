package io.ktor.client.utils;

import io.ktor.client.content.ProgressListener;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannelUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "contentLength", "Lio/ktor/client/content/ProgressListener;", "listener", "observable", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Long;Lio/ktor/client/content/ProgressListener;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ByteChannelUtilsKt {
    public static final ByteReadChannel observable(ByteReadChannel $this$observable, CoroutineContext context, Long contentLength, ProgressListener listener) {
        Intrinsics.checkNotNullParameter($this$observable, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return ByteWriteChannelOperationsKt.writer(GlobalScope.INSTANCE, context, true, new ByteChannelUtilsKt$observable$1($this$observable, listener, contentLength, null)).getChannel();
    }
}