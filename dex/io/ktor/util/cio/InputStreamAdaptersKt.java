package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: InputStreamAdapters.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljava/io/InputStream;", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/Job;", "parent", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/io/InputStream;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/Job;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InputStreamAdaptersKt {
    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, ObjectPool objectPool, CoroutineContext coroutineContext, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 2) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getUnconfined();
        }
        if ((i & 4) != 0) {
            job = (Job) JobKt.Job$default((Job) null, 1, (Object) null);
        }
        return toByteReadChannel(inputStream, objectPool, coroutineContext, job);
    }

    @Deprecated(message = "Use variant from 'ktor-io' module instead", replaceWith = @ReplaceWith(expression = "this.toByteReadChannel(context + parent, pool)", imports = {"io.ktor.utils.io.jvm.javaio.toByteReadChannel"}))
    public static final ByteReadChannel toByteReadChannel(InputStream $this$toByteReadChannel, ObjectPool<ByteBuffer> objectPool, CoroutineContext context, Job parent) {
        Intrinsics.checkNotNullParameter($this$toByteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return ReadingKt.toByteReadChannel($this$toByteReadChannel, context.plus((CoroutineContext) parent), objectPool);
    }
}