package io.ktor.client.call;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: SavedCall.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "save", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedCallKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object save(HttpClientCall $this$save, Continuation<? super HttpClientCall> continuation) {
        SavedCallKt$save$1 savedCallKt$save$1;
        Object readRemaining;
        if (continuation instanceof SavedCallKt$save$1) {
            savedCallKt$save$1 = (SavedCallKt$save$1) continuation;
            if ((savedCallKt$save$1.label & Integer.MIN_VALUE) != 0) {
                savedCallKt$save$1.label -= Integer.MIN_VALUE;
                Object $result = savedCallKt$save$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (savedCallKt$save$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ByteReadChannel rawContent = $this$save.getResponse().getRawContent();
                        savedCallKt$save$1.L$0 = $this$save;
                        savedCallKt$save$1.label = 1;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining(rawContent, savedCallKt$save$1);
                        if (readRemaining == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$save = (HttpClientCall) savedCallKt$save$1.L$0;
                        ResultKt.throwOnFailure($result);
                        readRemaining = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byte[] responseBody = SourcesKt.readByteArray((Source) readRemaining);
                return new SavedHttpCall($this$save.getClient(), $this$save.getRequest(), $this$save.getResponse(), responseBody);
            }
        }
        savedCallKt$save$1 = new SavedCallKt$save$1(continuation);
        Object $result2 = savedCallKt$save$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (savedCallKt$save$1.label) {
        }
        byte[] responseBody2 = SourcesKt.readByteArray((Source) readRemaining);
        return new SavedHttpCall($this$save.getClient(), $this$save.getRequest(), $this$save.getResponse(), responseBody2);
    }
}