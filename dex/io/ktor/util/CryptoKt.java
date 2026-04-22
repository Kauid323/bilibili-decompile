package io.ktor.util;

import io.ktor.utils.io.InternalAPI;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"io/ktor/util/CryptoKt__CryptoJvmKt", "io/ktor/util/CryptoKt__CryptoKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class CryptoKt {
    public static final int NONCE_SIZE_IN_BYTES = 16;

    public static final Digest Digest(String name) {
        return CryptoKt__CryptoJvmKt.Digest(name);
    }

    @InternalAPI
    public static final Object build(Digest $this$build, String string, Charset charset, Continuation<? super byte[]> continuation) {
        return CryptoKt__CryptoKt.build($this$build, string, charset, continuation);
    }

    @InternalAPI
    public static final Object build(Digest $this$build, byte[] bytes, Continuation<? super byte[]> continuation) {
        return CryptoKt__CryptoKt.build($this$build, bytes, continuation);
    }

    public static final String generateNonce() {
        return CryptoKt__CryptoJvmKt.generateNonce();
    }

    public static final byte[] generateNonce(int size) {
        return CryptoKt__CryptoKt.generateNonce(size);
    }

    public static final Function1<String, byte[]> getDigestFunction(String algorithm, Function1<? super String, String> function1) {
        return CryptoKt__CryptoJvmKt.getDigestFunction(algorithm, function1);
    }

    public static final String hex(byte[] bytes) {
        return CryptoKt__CryptoKt.hex(bytes);
    }

    public static final byte[] hex(String s) {
        return CryptoKt__CryptoKt.hex(s);
    }

    public static final byte[] sha1(byte[] bytes) {
        return CryptoKt__CryptoJvmKt.sha1(bytes);
    }
}