package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FilenameUtils;

/* compiled from: SignatureBuildingComponents.kt */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    public final String javaLang(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/lang/" + name;
    }

    public final String javaUtil(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/" + name;
    }

    public final String javaFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/function/" + name;
    }

    public final String javaUtilConcurrentAtomic(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/concurrent/atomic/" + name;
    }

    public final String[] constructors(String... signatures) {
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        Collection destination$iv$iv = new ArrayList(signatures.length);
        int length = signatures.length;
        for (int i = 0; i < length; i++) {
            String it = "<init>(" + signatures[i] + ")V";
            destination$iv$iv.add(it);
        }
        Collection thisCollection$iv = (List) destination$iv$iv;
        return (String[]) thisCollection$iv.toArray(new String[0]);
    }

    public final Set<String> inJavaLang(String name, String... signatures) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        return inClass(javaLang(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set<String> inJavaUtil(String name, String... signatures) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        return inClass(javaUtil(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set<String> inClass(String internalName, String... signatures) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        Collection destination$iv = new LinkedHashSet();
        int length = signatures.length;
        for (int i = 0; i < length; i++) {
            String it = internalName + FilenameUtils.EXTENSION_SEPARATOR + signatures[i];
            destination$iv.add(it);
        }
        return (Set) destination$iv;
    }

    public final String signature(String internalName, String jvmDescriptor) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        Intrinsics.checkNotNullParameter(jvmDescriptor, "jvmDescriptor");
        return internalName + FilenameUtils.EXTENSION_SEPARATOR + jvmDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence jvmDescriptor$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.escapeClassName(it);
    }

    public final String jvmDescriptor(String name, List<String> parameters, String ret) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(ret, "ret");
        return name + '(' + CollectionsKt.joinToString$default(parameters, "", null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence jvmDescriptor$lambda$0;
                jvmDescriptor$lambda$0 = SignatureBuildingComponents.jvmDescriptor$lambda$0((String) obj);
                return jvmDescriptor$lambda$0;
            }
        }, 30, null) + ')' + escapeClassName(ret);
    }

    private final String escapeClassName(String internalName) {
        return internalName.length() > 1 ? 'L' + internalName + ';' : internalName;
    }
}