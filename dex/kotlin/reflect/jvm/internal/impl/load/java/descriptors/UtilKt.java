package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
public final class UtilKt {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<? extends KotlinType> newValueParameterTypes, Collection<? extends ValueParameterDescriptor> oldValueParameters, CallableDescriptor newOwner) {
        Intrinsics.checkNotNullParameter(newValueParameterTypes, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(oldValueParameters, "oldValueParameters");
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        if (!(newValueParameterTypes.size() == oldValueParameters.size())) {
            throw new AssertionError("Different value parameters sizes: Enhanced = " + newValueParameterTypes.size() + ", Old = " + oldValueParameters.size());
        }
        Iterable $this$map$iv = CollectionsKt.zip(newValueParameterTypes, oldValueParameters);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair pair = (Pair) item$iv$iv;
            KotlinType newParameterType = (KotlinType) pair.component1();
            ValueParameterDescriptor oldParameter = (ValueParameterDescriptor) pair.component2();
            int index = oldParameter.getIndex();
            Annotations annotations = oldParameter.getAnnotations();
            Name name = oldParameter.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            boolean declaresDefaultValue = oldParameter.declaresDefaultValue();
            boolean isCrossinline = oldParameter.isCrossinline();
            boolean isNoinline = oldParameter.isNoinline();
            KotlinType arrayElementType = oldParameter.getVarargElementType() != null ? DescriptorUtilsKt.getModule(newOwner).getBuiltIns().getArrayElementType(newParameterType) : null;
            SourceElement source = oldParameter.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
            Collection destination$iv$iv2 = destination$iv$iv;
            destination$iv$iv2.add(new ValueParameterDescriptorImpl(newOwner, null, index, annotations, name, newParameterType, declaresDefaultValue, isCrossinline, isNoinline, arrayElementType, source));
            destination$iv$iv = destination$iv$iv2;
        }
        return (List) destination$iv$iv;
    }

    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(ClassDescriptor $this$getParentJavaStaticClassScope) {
        Intrinsics.checkNotNullParameter($this$getParentJavaStaticClassScope, "<this>");
        ClassDescriptor superClassDescriptor = DescriptorUtilsKt.getSuperClassNotAny($this$getParentJavaStaticClassScope);
        if (superClassDescriptor == null) {
            return null;
        }
        MemberScope staticScope = superClassDescriptor.getStaticScope();
        LazyJavaStaticClassScope lazyJavaStaticClassScope = staticScope instanceof LazyJavaStaticClassScope ? (LazyJavaStaticClassScope) staticScope : null;
        return lazyJavaStaticClassScope == null ? getParentJavaStaticClassScope(superClassDescriptor) : lazyJavaStaticClassScope;
    }
}