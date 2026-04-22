package io.ktor.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CryptoJvm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceBlocking$1", f = "CryptoJvm.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class CryptoKt__CryptoJvmKt$generateNonceBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CryptoKt__CryptoJvmKt$generateNonceBlocking$1(Continuation<? super CryptoKt__CryptoJvmKt$generateNonceBlocking$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CryptoKt__CryptoJvmKt$generateNonceBlocking$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object receive = NonceKt.getSeedChannel().receive((Continuation) this);
                if (receive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return receive;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}