package io.ktor.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.slf4j.LoggerFactory;

/* compiled from: Nonce.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011\" \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0002¨\u0006 "}, d2 = {"", "ensureNonceGeneratorRunning", "()V", "Ljava/security/SecureRandom;", "lookupSecureRandom", "()Ljava/security/SecureRandom;", "", "name", "getInstanceOrNull", "(Ljava/lang/String;)Ljava/security/SecureRandom;", NonceKt.SHA1PRNG, "Ljava/lang/String;", "", "SECURE_RANDOM_PROVIDERS", "Ljava/util/List;", "", "SECURE_RESEED_PERIOD", "I", "SECURE_NONCE_COUNT", "INSECURE_NONCE_COUNT_FACTOR", "Lkotlinx/coroutines/channels/Channel;", "seedChannel", "Lkotlinx/coroutines/channels/Channel;", "getSeedChannel", "()Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/CoroutineName;", "NonceGeneratorCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "Lkotlinx/coroutines/Job;", "nonceGeneratorJob", "Lkotlinx/coroutines/Job;", "getNonceGeneratorJob$annotations", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NonceKt {
    private static final int INSECURE_NONCE_COUNT_FACTOR = 4;
    private static final int SECURE_NONCE_COUNT = 8;
    private static final int SECURE_RESEED_PERIOD = 30000;
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final List<String> SECURE_RANDOM_PROVIDERS = kotlin.collections.CollectionsKt.listOf(new String[]{"NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG"});
    private static final Channel<String> seedChannel = ChannelKt.Channel$default(1024, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    private static final CoroutineName NonceGeneratorCoroutineName = new CoroutineName("nonce-generator");
    private static final Job nonceGeneratorJob = BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getIO().plus(NonCancellable.INSTANCE).plus(NonceGeneratorCoroutineName), CoroutineStart.LAZY, new NonceKt$nonceGeneratorJob$1(null));

    private static /* synthetic */ void getNonceGeneratorJob$annotations() {
    }

    public static final Channel<String> getSeedChannel() {
        return seedChannel;
    }

    public static final void ensureNonceGeneratorRunning() {
        nonceGeneratorJob.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecureRandom lookupSecureRandom() {
        SecureRandom it;
        String name = System.getProperty("io.ktor.random.secure.random.provider");
        if (name != null && (it = getInstanceOrNull(name)) != null) {
            return it;
        }
        for (String name2 : SECURE_RANDOM_PROVIDERS) {
            SecureRandom it2 = getInstanceOrNull(name2);
            if (it2 != null) {
                return it2;
            }
        }
        LoggerFactory.getLogger("io.ktor.util.random").warn("None of the " + kotlin.collections.CollectionsKt.joinToString$default(SECURE_RANDOM_PROVIDERS, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + " found, fallback to default");
        SecureRandom instanceOrNull$default = getInstanceOrNull$default(null, 1, null);
        if (instanceOrNull$default != null) {
            return instanceOrNull$default;
        }
        throw new IllegalStateException("No SecureRandom implementation found".toString());
    }

    private static final SecureRandom getInstanceOrNull(String name) {
        SecureRandom secureRandom;
        try {
            if (name != null) {
                secureRandom = SecureRandom.getInstance(name);
            } else {
                secureRandom = new SecureRandom();
            }
            return secureRandom;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    static /* synthetic */ SecureRandom getInstanceOrNull$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return getInstanceOrNull(str);
    }
}