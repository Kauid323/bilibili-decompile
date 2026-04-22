package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* compiled from: TypeSubstitution.kt */
public final class TypeSubstitutionKt {
    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> newArguments, Annotations newAnnotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        return replace$default(kotlinType, newArguments, newAnnotations, null, 4, null);
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List list, Annotations annotations, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations, list2);
    }

    public static final KotlinType replace(KotlinType $this$replace, List<? extends TypeProjection> newArguments, Annotations newAnnotations, List<? extends TypeProjection> newArgumentsForUpperBound) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        Intrinsics.checkNotNullParameter(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == $this$replace.getArguments()) && newAnnotations == $this$replace.getAnnotations()) {
            return $this$replace;
        }
        TypeAttributes newAttributes = TypeAttributesKt.replaceAnnotations($this$replace.getAttributes(), ((newAnnotations instanceof FilteredAnnotations) && ((FilteredAnnotations) newAnnotations).isEmpty()) ? Annotations.Companion.getEMPTY() : newAnnotations);
        UnwrappedType unwrapped = $this$replace.unwrap();
        if (unwrapped instanceof FlexibleType) {
            return KotlinTypeFactory.flexibleType(replace(((FlexibleType) unwrapped).getLowerBound(), newArguments, newAttributes), replace(((FlexibleType) unwrapped).getUpperBound(), newArgumentsForUpperBound, newAttributes));
        }
        if (unwrapped instanceof SimpleType) {
            return replace((SimpleType) unwrapped, newArguments, newAttributes);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List list, TypeAttributes typeAttributes, int i, Object obj) {
        if ((i & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        return replace(simpleType, list, typeAttributes);
    }

    public static final SimpleType replace(SimpleType $this$replace, List<? extends TypeProjection> newArguments, TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == $this$replace.getAttributes()) {
            return $this$replace;
        }
        if (newArguments.isEmpty()) {
            return $this$replace.replaceAttributes(newAttributes);
        }
        if ($this$replace instanceof ErrorType) {
            return ((ErrorType) $this$replace).replaceArguments(newArguments);
        }
        return KotlinTypeFactory.simpleType$default(newAttributes, $this$replace.getConstructor(), newArguments, $this$replace.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }

    public static final SimpleType asSimpleType(KotlinType $this$asSimpleType) {
        Intrinsics.checkNotNullParameter($this$asSimpleType, "<this>");
        UnwrappedType unwrap = $this$asSimpleType.unwrap();
        SimpleType simpleType = unwrap instanceof SimpleType ? (SimpleType) unwrap : null;
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(("This is should be simple type: " + $this$asSimpleType).toString());
    }
}