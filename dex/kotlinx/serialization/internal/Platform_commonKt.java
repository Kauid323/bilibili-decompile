package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Platform.common.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n*\u00020\u0002H\u0000\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r*\u0006\u0012\u0002\b\u00030\fH\u0081\b\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\u000e\"\u0004\b\u0000\u0010\r*\u0006\u0012\u0002\b\u00030\u000eH\u0081\b\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f\"\u0004\b\u0000\u0010\r*\u0006\u0012\u0002\b\u00030\u000fH\u0081\b\u001a\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a6\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\r0\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00150\u0018H\u0080\bø\u0001\u0000\u001a\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001cH\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u001aH\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u001aH\u0000\"\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"EMPTY_DESCRIPTOR_ARRAY", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getEMPTY_DESCRIPTOR_ARRAY$annotations", "()V", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "notRegisteredMessage", "", "className", "cachedSerialNames", "", "cast", "Lkotlinx/serialization/DeserializationStrategy;", "T", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/SerializationStrategy;", "compactArray", "", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsHashCodeBy", "", "K", "", "selector", "Lkotlin/Function1;", "kclass", "Lkotlin/reflect/KClass;", "", "Lkotlin/reflect/KType;", "serializerNotRegistered", "", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Platform_commonKt {
    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];

    private static /* synthetic */ void getEMPTY_DESCRIPTOR_ARRAY$annotations() {
    }

    public static final Set<String> cachedSerialNames(SerialDescriptor $this$cachedSerialNames) {
        Intrinsics.checkNotNullParameter($this$cachedSerialNames, "<this>");
        if ($this$cachedSerialNames instanceof CachedNames) {
            return ((CachedNames) $this$cachedSerialNames).getSerialNames();
        }
        HashSet result = new HashSet($this$cachedSerialNames.getElementsCount());
        int elementsCount = $this$cachedSerialNames.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            result.add($this$cachedSerialNames.getElementName(i));
        }
        return result;
    }

    public static final SerialDescriptor[] compactArray(List<? extends SerialDescriptor> list) {
        List<? extends SerialDescriptor> list2 = list;
        Collection collection = !(list2 == null || list2.isEmpty()) ? list : null;
        if (collection != null) {
            Collection $this$toTypedArray$iv = collection;
            SerialDescriptor[] serialDescriptorArr = (SerialDescriptor[]) $this$toTypedArray$iv.toArray(new SerialDescriptor[0]);
            if (serialDescriptorArr != null) {
                return serialDescriptorArr;
            }
        }
        return EMPTY_DESCRIPTOR_ARRAY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> KSerializer<T> cast(KSerializer<?> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        return kSerializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> SerializationStrategy<T> cast(SerializationStrategy<?> serializationStrategy) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "<this>");
        return serializationStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> DeserializationStrategy<T> cast(DeserializationStrategy<?> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "<this>");
        return deserializationStrategy;
    }

    public static final Void serializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        throw new SerializationException(notRegisteredMessage(kClass));
    }

    public static final String notRegisteredMessage(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = "<local class name not available>";
        }
        return notRegisteredMessage(simpleName);
    }

    public static final String notRegisteredMessage(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final KClass<Object> kclass(KType $this$kclass) {
        Intrinsics.checkNotNullParameter($this$kclass, "<this>");
        KClassifier t = $this$kclass.getClassifier();
        if (t instanceof KClass) {
            return (KClass) t;
        }
        if (t instanceof KTypeParameter) {
            throw new IllegalStateException(("Captured type parameter " + t + " from generic non-reified function. Such functionality cannot be supported as " + t + " is erased, either specify serializer explicitly or make calling function inline with reified " + t).toString());
        }
        throw new IllegalStateException(("Only KClass supported as classifier, got " + t).toString());
    }

    public static final <T, K> int elementsHashCodeBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int accumulator$iv = 1;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (T) it.next();
            int hash = accumulator$iv;
            int i = hash * 31;
            K invoke = selector.invoke(element$iv);
            accumulator$iv = i + (invoke != null ? invoke.hashCode() : 0);
        }
        return accumulator$iv;
    }
}