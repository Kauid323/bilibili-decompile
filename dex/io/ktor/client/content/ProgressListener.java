package io.ktor.client.content;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ObservableContent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/content/ProgressListener;", "", "", "bytesSentTotal", "contentLength", "", "onProgress", "(JLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProgressListener {
    Object onProgress(long j, Long l, Continuation<? super Unit> continuation);
}