package io.ktor.util;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: CryptoJvm.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aD\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0001\u001a\u00020\u00002!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00000\u0002¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u000f\u0010\u0017\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0018"}, d2 = {"", "algorithm", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "salt", "", "getDigestFunction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "text", "getDigest$CryptoKt__CryptoJvmKt", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)[B", "getDigest", "bytes", "sha1", "([B)[B", "Lio/ktor/util/Digest;", "Digest", "(Ljava/lang/String;)Lio/ktor/util/Digest;", "generateNonce", "()Ljava/lang/String;", "generateNonceBlocking$CryptoKt__CryptoJvmKt", "generateNonceBlocking", "ktor-utils"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
final /* synthetic */ class CryptoKt__CryptoJvmKt {
    public static final Function1<String, byte[]> getDigestFunction(final String algorithm, final Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(function1, "salt");
        return new Function1() { // from class: io.ktor.util.CryptoKt__CryptoJvmKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                byte[] digestFunction$lambda$0$CryptoKt__CryptoJvmKt;
                digestFunction$lambda$0$CryptoKt__CryptoJvmKt = CryptoKt__CryptoJvmKt.getDigestFunction$lambda$0$CryptoKt__CryptoJvmKt(algorithm, function1, (String) obj);
                return digestFunction$lambda$0$CryptoKt__CryptoJvmKt;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDigestFunction$lambda$0$CryptoKt__CryptoJvmKt(String $algorithm, Function1 $salt, String e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return getDigest$CryptoKt__CryptoJvmKt(e, $algorithm, $salt);
    }

    private static final byte[] getDigest$CryptoKt__CryptoJvmKt(String text, String algorithm, Function1<? super String, String> function1) {
        MessageDigest $this$getDigest_u24lambda_u241 = MessageDigest.getInstance(algorithm);
        byte[] bytes = ((String) function1.invoke(text)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        $this$getDigest_u24lambda_u241.update(bytes);
        byte[] bytes2 = text.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] digest = $this$getDigest_u24lambda_u241.digest(bytes2);
        Intrinsics.checkNotNullExpressionValue(digest, "with(...)");
        return digest;
    }

    public static final byte[] sha1(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] digest = MessageDigest.getInstance("SHA1").digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return digest;
    }

    public static final Digest Digest(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MessageDigest messageDigest = MessageDigest.getInstance(name);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        return DigestImpl.m1448boximpl(DigestImpl.m1450constructorimpl(messageDigest));
    }

    public static final String generateNonce() {
        String nonce = (String) ChannelResult.getOrNull-impl(NonceKt.getSeedChannel().tryReceive-PtdJZtk());
        return nonce != null ? nonce : generateNonceBlocking$CryptoKt__CryptoJvmKt();
    }

    private static final String generateNonceBlocking$CryptoKt__CryptoJvmKt() {
        NonceKt.ensureNonceGeneratorRunning();
        return (String) BuildersKt.runBlocking$default((CoroutineContext) null, new CryptoKt__CryptoJvmKt$generateNonceBlocking$1(null), 1, (Object) null);
    }
}