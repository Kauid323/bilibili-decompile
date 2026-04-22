package io.ktor.util;

import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Crypto.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087@¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\f\b\u0002\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0087@¢\u0006\u0004\b\f\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "bytes", "", "hex", "([B)Ljava/lang/String;", "s", "(Ljava/lang/String;)[B", "", "size", "generateNonce", "(I)[B", "Lio/ktor/util/Digest;", "build", "(Lio/ktor/util/Digest;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "string", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "(Lio/ktor/util/Digest;Ljava/lang/String;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "digits", "[C", "NONCE_SIZE_IN_BYTES", "I", "ktor-utils"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
public final /* synthetic */ class CryptoKt__CryptoKt {
    private static final char[] digits = CharsetKt.toCharArray("0123456789abcdef");

    public static final String hex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] result = new char[bytes.length * 2];
        int resultIndex = 0;
        char[] digits2 = digits;
        for (byte element : bytes) {
            int b = element & 255;
            int resultIndex2 = resultIndex + 1;
            result[resultIndex] = digits2[b >> 4];
            resultIndex = resultIndex2 + 1;
            result[resultIndex2] = digits2[b & 15];
        }
        return StringsKt.concatToString(result);
    }

    public static final byte[] hex(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        byte[] result = new byte[s.length() / 2];
        int length = result.length;
        for (int idx = 0; idx < length; idx++) {
            int srcIdx = idx * 2;
            int high = Integer.parseInt(String.valueOf(s.charAt(srcIdx)), CharsKt.checkRadix(16)) << 4;
            int low = Integer.parseInt(String.valueOf(s.charAt(srcIdx + 1)), CharsKt.checkRadix(16));
            result[idx] = (byte) (high | low);
        }
        return result;
    }

    public static final byte[] generateNonce(int size) {
        Source buffer = new Buffer();
        Sink $this$generateNonce_u24lambda_u240 = (Sink) buffer;
        while (BytePacketBuilderKt.getSize($this$generateNonce_u24lambda_u240) < size) {
            io.ktor.utils.io.core.StringsKt.writeText$default($this$generateNonce_u24lambda_u240, CryptoKt.generateNonce(), 0, 0, (Charset) null, 14, (Object) null);
        }
        return SourcesKt.readByteArray(buffer, size);
    }

    @InternalAPI
    public static final Object build(Digest $this$build, byte[] bytes, Continuation<? super byte[]> continuation) {
        $this$build.plusAssign(bytes);
        return $this$build.build(continuation);
    }

    public static /* synthetic */ Object build$default(Digest digest, String str, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return CryptoKt.build(digest, str, charset, continuation);
    }

    @InternalAPI
    public static final Object build(Digest $this$build, String string, Charset charset, Continuation<? super byte[]> continuation) {
        $this$build.plusAssign(io.ktor.utils.io.core.StringsKt.toByteArray(string, charset));
        return $this$build.build(continuation);
    }
}