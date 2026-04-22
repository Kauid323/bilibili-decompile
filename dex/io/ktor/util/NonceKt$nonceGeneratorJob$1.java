package io.ktor.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Nonce.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"seedChannel", "previousRoundNonceList", "secureInstance", "weakRandom", "secureBytes", "weakBytes", "randomNonceList", "lastReseed", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0"})
final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NonceKt$nonceGeneratorJob$1(Continuation<? super NonceKt$nonceGeneratorJob$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonceKt$nonceGeneratorJob$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae A[Catch: all -> 0x014c, TryCatch #5 {all -> 0x014c, blocks: (B:24:0x00a1, B:26:0x00b3, B:25:0x00ae), top: B:66:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011f A[Catch: all -> 0x0147, TryCatch #2 {all -> 0x0147, blocks: (B:35:0x0114, B:31:0x0109, B:38:0x011f, B:40:0x0130), top: B:60:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00db -> B:28:0x00e9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0112 -> B:60:0x0114). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        SecureRandom secureInstance;
        SendChannel sendChannel;
        Throwable t;
        NonceKt$nonceGeneratorJob$1 nonceKt$nonceGeneratorJob$1;
        byte[] weakBytes;
        SecureRandom weakRandom;
        List randomNonceList;
        NonceKt$nonceGeneratorJob$1 nonceKt$nonceGeneratorJob$12;
        int index;
        int index2;
        byte[] secureBytes;
        SecureRandom secureInstance2;
        ArrayList previousRoundNonceList;
        long lastReseed;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                SendChannel seedChannel = NonceKt.getSeedChannel();
                long lastReseed2 = 0;
                ArrayList previousRoundNonceList2 = new ArrayList();
                secureInstance = NonceKt.lookupSecureRandom();
                SecureRandom weakRandom2 = SecureRandom.getInstance("SHA1PRNG");
                byte[] secureBytes2 = new byte[128];
                byte[] weakBytes2 = new byte[secureBytes2.length * 4];
                weakRandom2.setSeed(secureInstance.generateSeed(secureBytes2.length));
                sendChannel = seedChannel;
                NonceKt$nonceGeneratorJob$1 nonceKt$nonceGeneratorJob$13 = this;
                try {
                    secureInstance.nextBytes(secureBytes2);
                    weakRandom2.nextBytes(weakBytes2);
                    int length = secureBytes2.length;
                    for (int i = 0; i < length; i++) {
                        try {
                            weakBytes2[i * 4] = secureBytes2[i];
                        } catch (Throwable th) {
                            t = th;
                            break;
                        }
                    }
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastReseed2 <= 30000) {
                        nonceKt$nonceGeneratorJob$1 = nonceKt$nonceGeneratorJob$13;
                        try {
                            weakRandom2.setSeed(lastReseed2 - currentTime);
                            weakRandom2.setSeed(secureInstance.generateSeed(secureBytes2.length));
                            lastReseed2 = currentTime;
                        } catch (Throwable th2) {
                            t = th2;
                            break;
                        }
                    } else {
                        nonceKt$nonceGeneratorJob$1 = nonceKt$nonceGeneratorJob$13;
                        weakRandom2.setSeed(secureBytes2);
                    }
                    Intrinsics.checkNotNull(weakRandom2);
                    List randomNonceList2 = kotlin.collections.CollectionsKt.shuffled(kotlin.collections.CollectionsKt.plus(StringsKt.chunked(CryptoKt.hex(weakBytes2), 16), previousRoundNonceList2), weakRandom2);
                    int size = randomNonceList2.size() / 2;
                    weakBytes = weakBytes2;
                    weakRandom = weakRandom2;
                    randomNonceList = randomNonceList2;
                    nonceKt$nonceGeneratorJob$12 = nonceKt$nonceGeneratorJob$1;
                    long j = lastReseed2;
                    index = 0;
                    index2 = size;
                    secureBytes = secureBytes2;
                    secureInstance2 = secureInstance;
                    previousRoundNonceList = previousRoundNonceList2;
                    lastReseed = j;
                    if (index >= index2) {
                        try {
                            Object obj = randomNonceList.get(index);
                            Continuation continuation = (Continuation) nonceKt$nonceGeneratorJob$12;
                            nonceKt$nonceGeneratorJob$12.L$0 = sendChannel;
                            nonceKt$nonceGeneratorJob$12.L$1 = previousRoundNonceList;
                            nonceKt$nonceGeneratorJob$12.L$2 = secureInstance2;
                            nonceKt$nonceGeneratorJob$12.L$3 = weakRandom;
                            nonceKt$nonceGeneratorJob$12.L$4 = secureBytes;
                            nonceKt$nonceGeneratorJob$12.L$5 = weakBytes;
                            nonceKt$nonceGeneratorJob$12.L$6 = randomNonceList;
                            nonceKt$nonceGeneratorJob$12.J$0 = lastReseed;
                            nonceKt$nonceGeneratorJob$12.I$0 = index;
                            nonceKt$nonceGeneratorJob$12.I$1 = index2;
                            $result = $result2;
                            nonceKt$nonceGeneratorJob$12.label = 1;
                            if (sendChannel.send(obj, continuation) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result3 = $result;
                            try {
                                index++;
                                $result2 = $result3;
                                if (index >= index2) {
                                    Object $result4 = $result2;
                                    previousRoundNonceList.clear();
                                    int size2 = randomNonceList.size();
                                    for (int index3 = randomNonceList.size() / 2; index3 < size2; index3++) {
                                        previousRoundNonceList.add(randomNonceList.get(index3));
                                    }
                                    $result2 = $result4;
                                    nonceKt$nonceGeneratorJob$13 = nonceKt$nonceGeneratorJob$12;
                                    lastReseed2 = lastReseed;
                                    previousRoundNonceList2 = previousRoundNonceList;
                                    secureInstance = secureInstance2;
                                    weakRandom2 = weakRandom;
                                    secureBytes2 = secureBytes;
                                    weakBytes2 = weakBytes;
                                    secureInstance.nextBytes(secureBytes2);
                                    weakRandom2.nextBytes(weakBytes2);
                                    int length2 = secureBytes2.length;
                                    while (i < length2) {
                                    }
                                    long currentTime2 = System.currentTimeMillis();
                                    if (currentTime2 - lastReseed2 <= 30000) {
                                    }
                                    Intrinsics.checkNotNull(weakRandom2);
                                    List randomNonceList22 = kotlin.collections.CollectionsKt.shuffled(kotlin.collections.CollectionsKt.plus(StringsKt.chunked(CryptoKt.hex(weakBytes2), 16), previousRoundNonceList2), weakRandom2);
                                    int size3 = randomNonceList22.size() / 2;
                                    weakBytes = weakBytes2;
                                    weakRandom = weakRandom2;
                                    randomNonceList = randomNonceList22;
                                    nonceKt$nonceGeneratorJob$12 = nonceKt$nonceGeneratorJob$1;
                                    long j2 = lastReseed2;
                                    index = 0;
                                    index2 = size3;
                                    secureBytes = secureBytes2;
                                    secureInstance2 = secureInstance;
                                    previousRoundNonceList = previousRoundNonceList2;
                                    lastReseed = j2;
                                    if (index >= index2) {
                                    }
                                }
                            } catch (Throwable th3) {
                                t = th3;
                                break;
                            }
                        } catch (Throwable th4) {
                            t = th4;
                            break;
                        }
                    }
                } catch (Throwable th5) {
                    t = th5;
                    break;
                }
            case 1:
                index2 = this.I$1;
                index = this.I$0;
                lastReseed = this.J$0;
                List randomNonceList3 = (List) this.L$6;
                byte[] weakBytes3 = (byte[]) this.L$5;
                byte[] secureBytes3 = (byte[]) this.L$4;
                weakRandom = (SecureRandom) this.L$3;
                SecureRandom secureInstance3 = (SecureRandom) this.L$2;
                ArrayList previousRoundNonceList3 = (ArrayList) this.L$1;
                sendChannel = (Channel) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    nonceKt$nonceGeneratorJob$12 = this;
                    $result3 = $result;
                    randomNonceList = randomNonceList3;
                    previousRoundNonceList = previousRoundNonceList3;
                    weakBytes = weakBytes3;
                    secureBytes = secureBytes3;
                    secureInstance2 = secureInstance3;
                    index++;
                    $result2 = $result3;
                    if (index >= index2) {
                    }
                } catch (Throwable th6) {
                    t = th6;
                    break;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            sendChannel.close(t);
            SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th7) {
            SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
            throw th7;
        }
    }
}