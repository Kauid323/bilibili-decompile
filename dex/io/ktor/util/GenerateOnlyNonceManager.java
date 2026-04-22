package io.ktor.util;

import com.light.play.sdk.ParamsKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: NonceManager.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/util/GenerateOnlyNonceManager;", "Lio/ktor/util/NonceManager;", "<init>", "()V", "", "newNonce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ParamsKey.NONCE, "", "verifyNonce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerateOnlyNonceManager implements NonceManager {
    public static final GenerateOnlyNonceManager INSTANCE = new GenerateOnlyNonceManager();

    private GenerateOnlyNonceManager() {
    }

    @Override // io.ktor.util.NonceManager
    public Object newNonce(Continuation<? super String> continuation) {
        return CryptoKt.generateNonce();
    }

    @Override // io.ktor.util.NonceManager
    public Object verifyNonce(String nonce, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }
}