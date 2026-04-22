package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ReflectKotlinClassFinder.kt */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String access$toRuntimeFqName(ClassId $receiver) {
        return toRuntimeFqName($receiver);
    }

    public static final String toRuntimeFqName(ClassId $this$toRuntimeFqName) {
        String className = StringsKt.replace$default($this$toRuntimeFqName.getRelativeClassName().asString(), (char) FilenameUtils.EXTENSION_SEPARATOR, (char) Typography.dollar, false, 4, (Object) null);
        return $this$toRuntimeFqName.getPackageFqName().isRoot() ? className : $this$toRuntimeFqName.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + className;
    }
}