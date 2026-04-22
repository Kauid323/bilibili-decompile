package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;

/* compiled from: Enums.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\b\u001ao\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\f\u001a_\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u0007H\u0001¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"createAnnotatedEnumSerializer", "Lkotlinx/serialization/KSerializer;", "T", "", "serialName", "", "values", "", "names", "entryAnnotations", "", "classAnnotations", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "createMarkedEnumSerializer", "annotations", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "createSimpleEnumSerializer", "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EnumsKt {
    @InternalSerializationApi
    public static final <T extends Enum<T>> KSerializer<T> createSimpleEnumSerializer(String serialName, T[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        return new EnumSerializer(serialName, values);
    }

    @InternalSerializationApi
    public static final <T extends Enum<T>> KSerializer<T> createMarkedEnumSerializer(String serialName, T[] values, String[] names, Annotation[][] annotations) {
        String[] names2 = names;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(names2, "names");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        EnumDescriptor descriptor = new EnumDescriptor(serialName, values.length);
        Object[] objArr = values;
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            T t = objArr[i];
            int index$iv2 = index$iv + 1;
            String elementName = (String) ArraysKt.getOrNull(names2, index$iv);
            if (elementName == null) {
                elementName = t.name();
            }
            T[] tArr = objArr;
            int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
            int $i$f$forEachIndexed3 = 0;
            PluginGeneratedSerialDescriptor.addElement$default(descriptor, elementName, false, 2, null);
            Object[] objArr2 = (Annotation[]) ArraysKt.getOrNull(annotations, index$iv);
            if (objArr2 != null) {
                int length2 = objArr2.length;
                while ($i$f$forEachIndexed3 < length2) {
                    descriptor.pushAnnotation(objArr2[$i$f$forEachIndexed3]);
                    $i$f$forEachIndexed3++;
                    objArr2 = objArr2;
                }
            }
            i++;
            names2 = names;
            index$iv = index$iv2;
            objArr = tArr;
            $i$f$forEachIndexed = $i$f$forEachIndexed2;
        }
        return new EnumSerializer(serialName, values, descriptor);
    }

    @InternalSerializationApi
    public static final <T extends Enum<T>> KSerializer<T> createAnnotatedEnumSerializer(String serialName, T[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] classAnnotations) {
        String[] names2 = names;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(names2, "names");
        Intrinsics.checkNotNullParameter(entryAnnotations, "entryAnnotations");
        EnumDescriptor descriptor = new EnumDescriptor(serialName, values.length);
        if (classAnnotations != null) {
            for (Annotation annotation : classAnnotations) {
                descriptor.pushClassAnnotation(annotation);
            }
        }
        T[] tArr = values;
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int length = tArr.length;
        int i = 0;
        while (i < length) {
            T t = tArr[i];
            int index$iv2 = index$iv + 1;
            String elementName = (String) ArraysKt.getOrNull(names2, index$iv);
            if (elementName == null) {
                elementName = t.name();
            }
            T[] tArr2 = tArr;
            int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
            int $i$f$forEachIndexed3 = 0;
            PluginGeneratedSerialDescriptor.addElement$default(descriptor, elementName, false, 2, null);
            Object[] objArr = (Annotation[]) ArraysKt.getOrNull(entryAnnotations, index$iv);
            if (objArr != null) {
                int length2 = objArr.length;
                while ($i$f$forEachIndexed3 < length2) {
                    descriptor.pushAnnotation(objArr[$i$f$forEachIndexed3]);
                    $i$f$forEachIndexed3++;
                    objArr = objArr;
                }
            }
            i++;
            names2 = names;
            index$iv = index$iv2;
            tArr = tArr2;
            $i$f$forEachIndexed = $i$f$forEachIndexed2;
        }
        return new EnumSerializer(serialName, values, descriptor);
    }
}