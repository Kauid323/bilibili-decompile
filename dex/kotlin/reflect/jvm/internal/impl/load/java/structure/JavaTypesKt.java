package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* compiled from: javaTypes.kt */
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(JavaType $this$isSuperWildcard) {
        JavaWildcardType it = $this$isSuperWildcard instanceof JavaWildcardType ? (JavaWildcardType) $this$isSuperWildcard : null;
        return (it == null || it.getBound() == null || it.isExtends()) ? false : true;
    }
}