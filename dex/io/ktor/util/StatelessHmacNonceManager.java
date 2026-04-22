package io.ktor.util;

import com.light.play.sdk.ParamsKey;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: StatelessHmacNonceManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000bB5\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lio/ktor/util/StatelessHmacNonceManager;", "Lio/ktor/util/NonceManager;", "Ljavax/crypto/spec/SecretKeySpec;", "keySpec", "", "algorithm", "", "timeoutMillis", "Lkotlin/Function0;", "nonceGenerator", "<init>", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLkotlin/jvm/functions/Function0;)V", "", "key", "([BLjava/lang/String;JLkotlin/jvm/functions/Function0;)V", "newNonce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ParamsKey.NONCE, "", "verifyNonce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljavax/crypto/spec/SecretKeySpec;", "getKeySpec", "()Ljavax/crypto/spec/SecretKeySpec;", "Ljava/lang/String;", "getAlgorithm", "()Ljava/lang/String;", "J", "getTimeoutMillis", "()J", "Lkotlin/jvm/functions/Function0;", "getNonceGenerator", "()Lkotlin/jvm/functions/Function0;", "", "macLength", "I", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StatelessHmacNonceManager implements NonceManager {
    private final String algorithm;
    private final SecretKeySpec keySpec;
    private final int macLength;
    private final Function0<String> nonceGenerator;
    private final long timeoutMillis;

    public StatelessHmacNonceManager(SecretKeySpec keySpec, String algorithm, long timeoutMillis, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(keySpec, "keySpec");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(function0, "nonceGenerator");
        this.keySpec = keySpec;
        this.algorithm = algorithm;
        this.timeoutMillis = timeoutMillis;
        this.nonceGenerator = function0;
        Mac mac = Mac.getInstance(this.algorithm);
        mac.init(this.keySpec);
        this.macLength = mac.getMacLength();
    }

    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretKeySpec, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (i & 8) != 0 ? new Function0() { // from class: io.ktor.util.StatelessHmacNonceManager$$ExternalSyntheticLambda1
            public final Object invoke() {
                String _init_$lambda$0;
                _init_$lambda$0 = StatelessHmacNonceManager._init_$lambda$0();
                return _init_$lambda$0;
            }
        } : function0);
    }

    public final SecretKeySpec getKeySpec() {
        return this.keySpec;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0() {
        return CryptoKt.generateNonce();
    }

    public final Function0<String> getNonceGenerator() {
        return this.nonceGenerator;
    }

    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (i & 8) != 0 ? new Function0() { // from class: io.ktor.util.StatelessHmacNonceManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                String _init_$lambda$1;
                _init_$lambda$1 = StatelessHmacNonceManager._init_$lambda$1();
                return _init_$lambda$1;
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1() {
        return CryptoKt.generateNonce();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager(byte[] key, String algorithm, long timeoutMillis, Function0<String> function0) {
        this(new SecretKeySpec(key, algorithm), algorithm, timeoutMillis, function0);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(function0, "nonceGenerator");
    }

    @Override // io.ktor.util.NonceManager
    public Object newNonce(Continuation<? super String> continuation) {
        String random = (String) this.nonceGenerator.invoke();
        String l = Long.toString(System.nanoTime(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        String time = StringsKt.padStart(l, 16, '0');
        Mac $this$newNonce_u24lambda_u243 = Mac.getInstance(this.algorithm);
        $this$newNonce_u24lambda_u243.init(this.keySpec);
        byte[] bytes = (random + ':' + time).getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        $this$newNonce_u24lambda_u243.update(bytes);
        byte[] doFinal = $this$newNonce_u24lambda_u243.doFinal();
        Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
        String mac = CryptoKt.hex(doFinal);
        return random + '+' + time + '+' + mac;
    }

    @Override // io.ktor.util.NonceManager
    public Object verifyNonce(String nonce, Continuation<? super Boolean> continuation) {
        List parts = StringsKt.split$default(nonce, new char[]{'+'}, false, 0, 6, (Object) null);
        if (parts.size() != 3) {
            return Boxing.boxBoolean(false);
        }
        String random = (String) parts.get(0);
        String time = (String) parts.get(1);
        String mac = (String) parts.get(2);
        if (random.length() >= 8 && mac.length() == this.macLength * 2 && time.length() == 16) {
            long nanoTime = Long.parseLong(time, CharsKt.checkRadix(16));
            if (TimeUnit.MILLISECONDS.toNanos(this.timeoutMillis) + nanoTime < System.nanoTime()) {
                return Boxing.boxBoolean(false);
            }
            Mac $this$verifyNonce_u24lambda_u244 = Mac.getInstance(this.algorithm);
            $this$verifyNonce_u24lambda_u244.init(this.keySpec);
            byte[] bytes = (random + ':' + time).getBytes(Charsets.ISO_8859_1);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            $this$verifyNonce_u24lambda_u244.update(bytes);
            byte[] doFinal = $this$verifyNonce_u24lambda_u244.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
            String computedMac = CryptoKt.hex(doFinal);
            int validCount = 0;
            int min = Math.min(computedMac.length(), mac.length());
            for (int i = 0; i < min; i++) {
                if (computedMac.charAt(i) == mac.charAt(i)) {
                    validCount++;
                }
            }
            int i2 = this.macLength;
            return Boxing.boxBoolean(validCount == i2 * 2);
        }
        return Boxing.boxBoolean(false);
    }
}