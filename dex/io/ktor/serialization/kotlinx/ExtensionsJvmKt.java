package io.ktor.serialization.kotlinx;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: ExtensionsJvm.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\"&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtensionProvider;", "providers", "Ljava/util/List;", "getProviders", "()Ljava/util/List;", "getProviders$annotations", "()V", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExtensionsJvmKt {
    private static final List<KotlinxSerializationExtensionProvider> providers;

    public static /* synthetic */ void getProviders$annotations() {
    }

    public static final List<KotlinxSerializationExtensionProvider> getProviders() {
        return providers;
    }

    static {
        Iterator it = ServiceLoader.load(KotlinxSerializationExtensionProvider.class, KotlinxSerializationExtensionProvider.class.getClassLoader()).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        providers = SequencesKt.toList(SequencesKt.asSequence(it));
    }
}