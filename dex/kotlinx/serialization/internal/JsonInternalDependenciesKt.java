package kotlinx.serialization.internal;

import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: JsonInternalDependencies.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"jsonCachedSerialNames", "", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonInternalDependenciesKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Should not be used")
    @InternalSerializationApi
    public static final Set<String> jsonCachedSerialNames(SerialDescriptor $this$jsonCachedSerialNames) {
        Intrinsics.checkNotNullParameter($this$jsonCachedSerialNames, "<this>");
        return Platform_commonKt.cachedSerialNames($this$jsonCachedSerialNames);
    }
}