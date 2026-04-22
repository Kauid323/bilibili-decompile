package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable;

/* compiled from: Writers.kt */
public class WriteContext {
    private final List<MetadataExtensions> extensions;
    private final StringTable strings;
    private final MutableVersionRequirementTable versionRequirements;

    public final StringTable getStrings() {
        return this.strings;
    }

    public final MutableVersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    public final List<MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int get(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return this.strings.getStringIndex(string);
    }

    public final int getClassName$kotlin_metadata(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return WriteUtilsKt.getClassNameIndex(this.strings, name);
    }
}