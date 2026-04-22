package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a=\u0010\u000b\u001a\u00020\b*\u00020\u00062\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "limit", "", "toByteArray", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "use", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;)V", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ReadersKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toByteArray(ByteReadChannel $this$toByteArray, int limit, Continuation<? super byte[]> continuation) {
        ReadersKt$toByteArray$1 readersKt$toByteArray$1;
        Object readRemaining;
        if (continuation instanceof ReadersKt$toByteArray$1) {
            readersKt$toByteArray$1 = (ReadersKt$toByteArray$1) continuation;
            if ((readersKt$toByteArray$1.label & Integer.MIN_VALUE) != 0) {
                readersKt$toByteArray$1.label -= Integer.MIN_VALUE;
                Object $result = readersKt$toByteArray$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (readersKt$toByteArray$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        readersKt$toByteArray$1.label = 1;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining($this$toByteArray, limit, readersKt$toByteArray$1);
                        if (readRemaining == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readRemaining = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return SourcesKt.readByteArray((Source) readRemaining);
            }
        }
        readersKt$toByteArray$1 = new ReadersKt$toByteArray$1(continuation);
        Object $result2 = readersKt$toByteArray$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (readersKt$toByteArray$1.label) {
        }
        return SourcesKt.readByteArray((Source) readRemaining);
    }

    public static /* synthetic */ Object toByteArray$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return toByteArray(byteReadChannel, i, continuation);
    }

    public static final void use(ByteWriteChannel $this$use, Function1<? super ByteWriteChannel, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$use, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            function1.invoke($this$use);
        } finally {
        }
    }
}