package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaConstructor.kt */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> member) {
        Intrinsics.checkNotNullParameter(member, "member");
        this.member = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Annotation[][] realAnnotations;
        Type[] types = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNull(types);
        if (types.length == 0) {
            return CollectionsKt.emptyList();
        }
        Class klass = getMember().getDeclaringClass();
        Type[] realTypes = (klass.getDeclaringClass() == null || Modifier.isStatic(klass.getModifiers())) ? types : (Type[]) ArraysKt.copyOfRange(types, 1, types.length);
        Annotation[][] annotations = getMember().getParameterAnnotations();
        if (annotations.length < realTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + getMember());
        }
        if (annotations.length > realTypes.length) {
            Intrinsics.checkNotNull(annotations);
            realAnnotations = (Annotation[][]) ArraysKt.copyOfRange(annotations, annotations.length - realTypes.length, annotations.length);
        } else {
            realAnnotations = annotations;
        }
        Intrinsics.checkNotNull(realTypes);
        Intrinsics.checkNotNull(realAnnotations);
        return getValueParameters(realTypes, realAnnotations, getMember().isVarArgs());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        Object[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        Object[] $this$map$iv = typeParameters;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        for (Object item$iv$iv : $this$map$iv) {
            TypeVariable p0 = (TypeVariable) item$iv$iv;
            destination$iv$iv.add(new ReflectJavaTypeParameter(p0));
        }
        return (List) destination$iv$iv;
    }
}