package io.ktor.client.request.forms;

import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlinx.io.Source;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a \u0010\b\u001a\u00020\u0007*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "generateBoundary", "()Ljava/lang/String;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "copyTo", "(Lkotlinx/io/Source;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "RN_BYTES", "[B", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FormDataContentKt {
    private static final byte[] RN_BYTES = StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, (Charset) null, 1, (Object) null);

    public static final /* synthetic */ Object access$copyTo(Source $receiver, ByteWriteChannel channel, Continuation $completion) {
        return copyTo($receiver, channel, $completion);
    }

    public static final /* synthetic */ String access$generateBoundary() {
        return generateBoundary();
    }

    public static final /* synthetic */ byte[] access$getRN_BYTES$p() {
        return RN_BYTES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateBoundary() {
        StringBuilder $this$generateBoundary_u24lambda_u241 = new StringBuilder();
        for (int i2 = 0; i2 < 32; i2++) {
            String num = Integer.toString(Random.Default.nextInt(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
            $this$generateBoundary_u24lambda_u241.append(num);
        }
        String sb = $this$generateBoundary_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return kotlin.text.StringsKt.take(sb, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object copyTo(Source $this$copyTo, ByteWriteChannel channel, Continuation<? super Unit> continuation) {
        Object writePacket = ByteWriteChannelOperationsKt.writePacket(channel, $this$copyTo, continuation);
        return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
    }
}