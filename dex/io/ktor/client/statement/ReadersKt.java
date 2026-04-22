package io.ktor.client.statement;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "count", "", "readBytes", "(Lio/ktor/client/statement/HttpResponse;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRawBytes", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "discardRemaining", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ReadersKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBytes(HttpResponse $this$readBytes, int count, Continuation<? super byte[]> continuation) {
        ReadersKt$readBytes$1 readersKt$readBytes$1;
        if (continuation instanceof ReadersKt$readBytes$1) {
            readersKt$readBytes$1 = (ReadersKt$readBytes$1) continuation;
            if ((readersKt$readBytes$1.label & Integer.MIN_VALUE) != 0) {
                readersKt$readBytes$1.label -= Integer.MIN_VALUE;
                Object $result = readersKt$readBytes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (readersKt$readBytes$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        byte[] it = new byte[count];
                        ByteReadChannel rawContent = $this$readBytes.getRawContent();
                        readersKt$readBytes$1.L$0 = it;
                        readersKt$readBytes$1.label = 1;
                        return ByteReadChannelOperationsKt.readFully$default(rawContent, it, 0, 0, readersKt$readBytes$1, 6, (Object) null) == coroutine_suspended ? coroutine_suspended : it;
                    case 1:
                        byte[] bArr = (byte[]) readersKt$readBytes$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return bArr;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        readersKt$readBytes$1 = new ReadersKt$readBytes$1(continuation);
        Object $result2 = readersKt$readBytes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (readersKt$readBytes$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readRawBytes(HttpResponse $this$readRawBytes, Continuation<? super byte[]> continuation) {
        ReadersKt$readRawBytes$1 readersKt$readRawBytes$1;
        Object readRemaining;
        if (continuation instanceof ReadersKt$readRawBytes$1) {
            readersKt$readRawBytes$1 = (ReadersKt$readRawBytes$1) continuation;
            if ((readersKt$readRawBytes$1.label & Integer.MIN_VALUE) != 0) {
                readersKt$readRawBytes$1.label -= Integer.MIN_VALUE;
                Object $result = readersKt$readRawBytes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (readersKt$readRawBytes$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ByteReadChannel rawContent = $this$readRawBytes.getRawContent();
                        readersKt$readRawBytes$1.label = 1;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining(rawContent, readersKt$readRawBytes$1);
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
        readersKt$readRawBytes$1 = new ReadersKt$readRawBytes$1(continuation);
        Object $result2 = readersKt$readRawBytes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (readersKt$readRawBytes$1.label) {
        }
        return SourcesKt.readByteArray((Source) readRemaining);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Deprecated(message = "This method was renamed to readRawBytes() to reflect what it does.", replaceWith = @ReplaceWith(expression = "readRawBytes()", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBytes(HttpResponse $this$readBytes, Continuation<? super byte[]> continuation) {
        ReadersKt$readBytes$3 readersKt$readBytes$3;
        Object readRemaining;
        if (continuation instanceof ReadersKt$readBytes$3) {
            readersKt$readBytes$3 = (ReadersKt$readBytes$3) continuation;
            if ((readersKt$readBytes$3.label & Integer.MIN_VALUE) != 0) {
                readersKt$readBytes$3.label -= Integer.MIN_VALUE;
                Object $result = readersKt$readBytes$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (readersKt$readBytes$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ByteReadChannel rawContent = $this$readBytes.getRawContent();
                        readersKt$readBytes$3.label = 1;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining(rawContent, readersKt$readBytes$3);
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
        readersKt$readBytes$3 = new ReadersKt$readBytes$3(continuation);
        Object $result2 = readersKt$readBytes$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (readersKt$readBytes$3.label) {
        }
        return SourcesKt.readByteArray((Source) readRemaining);
    }

    public static final Object discardRemaining(HttpResponse $this$discardRemaining, Continuation<? super Unit> continuation) {
        Object discard$default = ByteReadChannelOperationsKt.discard$default($this$discardRemaining.getRawContent(), 0L, continuation, 1, (Object) null);
        return discard$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? discard$default : Unit.INSTANCE;
    }
}