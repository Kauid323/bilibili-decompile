package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: javaLoading.kt */
public final class JavaLoadingKt {
    public static final boolean isObjectMethodInInterface(JavaMember $this$isObjectMethodInInterface) {
        Intrinsics.checkNotNullParameter($this$isObjectMethodInInterface, "<this>");
        return $this$isObjectMethodInInterface.getContainingClass().isInterface() && ($this$isObjectMethodInInterface instanceof JavaMethod) && isObjectMethod((JavaMethod) $this$isObjectMethodInInterface);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0.equals("toString") != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        return r2.getValueParameters().isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r0.equals("hashCode") == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isObjectMethod(JavaMethod method) {
        String asString = method.getName().asString();
        switch (asString.hashCode()) {
            case -1776922004:
                break;
            case -1295482945:
                if (asString.equals("equals")) {
                    return isMethodWithOneObjectParameter(method);
                }
                return false;
            case 147696667:
                break;
            default:
                return false;
        }
    }

    private static final boolean isMethodWithOneObjectParameter(JavaMethod method) {
        FqName classFqName;
        List parameters = method.getValueParameters();
        JavaValueParameter javaValueParameter = (JavaValueParameter) CollectionsKt.singleOrNull((List<? extends Object>) parameters);
        JavaType type = javaValueParameter != null ? javaValueParameter.getType() : null;
        JavaClassifierType type2 = type instanceof JavaClassifierType ? (JavaClassifierType) type : null;
        if (type2 == null) {
            return false;
        }
        JavaClassifier classifier = type2.getClassifier();
        return (classifier instanceof JavaClass) && (classFqName = ((JavaClass) classifier).getFqName()) != null && Intrinsics.areEqual(classFqName.asString(), "java.lang.Object");
    }
}