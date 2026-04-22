package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlin/Pair;", "split", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/Pair;", "Lio/ktor/utils/io/ByteWriteChannel;", "first", "second", "", "copyToBoth", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteWriteChannel;)V", "", "CHUNK_BUFFER_SIZE", "J", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    public static final Pair<ByteReadChannel, ByteReadChannel> split(ByteReadChannel $this$split, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        final ByteChannel first = new ByteChannel(true);
        final ByteChannel second = new ByteChannel(true);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ByteChannelsKt$split$1($this$split, first, second, null), 3, (Object) null).invokeOnCompletion(new Function1() { // from class: io.ktor.util.ByteChannelsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit split$lambda$0;
                split$lambda$0 = ByteChannelsKt.split$lambda$0(first, second, (Throwable) obj);
                return split$lambda$0;
            }
        });
        return TuplesKt.to(first, second);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit split$lambda$0(ByteChannel $first, ByteChannel $second, Throwable it) {
        if (it == null) {
            return Unit.INSTANCE;
        }
        $first.cancel(it);
        $second.cancel(it);
        return Unit.INSTANCE;
    }

    public static final void copyToBoth(ByteReadChannel $this$copyToBoth, final ByteWriteChannel first, final ByteWriteChannel second) {
        Intrinsics.checkNotNullParameter($this$copyToBoth, "<this>");
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new ByteChannelsKt$copyToBoth$1($this$copyToBoth, first, second, null), 2, (Object) null).invokeOnCompletion(new Function1() { // from class: io.ktor.util.ByteChannelsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit copyToBoth$lambda$1;
                copyToBoth$lambda$1 = ByteChannelsKt.copyToBoth$lambda$1(first, second, (Throwable) obj);
                return copyToBoth$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyToBoth$lambda$1(ByteWriteChannel $first, ByteWriteChannel $second, Throwable it) {
        if (it == null) {
            return Unit.INSTANCE;
        }
        ByteWriteChannelOperationsKt.close($first, it);
        ByteWriteChannelOperationsKt.close($second, it);
        return Unit.INSTANCE;
    }
}