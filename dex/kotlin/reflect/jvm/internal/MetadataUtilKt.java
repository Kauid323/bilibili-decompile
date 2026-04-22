package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: MetadataUtil.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0002*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006*\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0000¨\u0006\t"}, d2 = {"toClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "", "Lkotlin/reflect/jvm/internal/impl/km/ClassName;", "toNonLocalSimpleName", "loadKClass", "Lkotlin/reflect/KClass;", "Ljava/lang/ClassLoader;", "name", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MetadataUtilKt {
    public static final ClassId toClassId(String $this$toClassId) {
        String fullName;
        Intrinsics.checkNotNullParameter($this$toClassId, "<this>");
        boolean isLocal = StringsKt.startsWith$default($this$toClassId, ".", false, 2, (Object) null);
        if (isLocal) {
            fullName = $this$toClassId.substring(1);
            Intrinsics.checkNotNullExpressionValue(fullName, "substring(...)");
        } else {
            fullName = $this$toClassId;
        }
        return new ClassId(new FqName(StringsKt.replace$default(StringsKt.substringBeforeLast(fullName, '/', ""), '/', (char) FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null)), new FqName(StringsKt.substringAfterLast$default(fullName, '/', (String) null, 2, (Object) null)), isLocal);
    }

    public static final String toNonLocalSimpleName(String $this$toNonLocalSimpleName) {
        Intrinsics.checkNotNullParameter($this$toNonLocalSimpleName, "<this>");
        if (StringsKt.startsWith$default($this$toNonLocalSimpleName, ".", false, 2, (Object) null)) {
            throw new IllegalArgumentException(("Local class is not supported: " + $this$toNonLocalSimpleName).toString());
        }
        return StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default($this$toNonLocalSimpleName, '/', (String) null, 2, (Object) null), (char) FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
    }

    public static final KClass<?> loadKClass(ClassLoader $this$loadKClass, String name) {
        Intrinsics.checkNotNullParameter($this$loadKClass, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Class loadClass$default = UtilKt.loadClass$default($this$loadKClass, toClassId(name), 0, 2, null);
        if (loadClass$default != null) {
            return JvmClassMappingKt.getKotlinClass(loadClass$default);
        }
        return null;
    }
}