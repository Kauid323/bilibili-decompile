package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;

/* compiled from: Readers.kt */
public final class ReadContext {
    private final List<Object> contextExtensions;
    private final List<MetadataExtensions> extensions;
    private final boolean ignoreUnknownVersionRequirements;
    private final ReadContext parent;
    private final NameResolver strings;
    private final Map<Integer, Integer> typeParameterNameToId;
    private final TypeTable types;
    private final VersionRequirementTable versionRequirements;

    public ReadContext(NameResolver strings, TypeTable types, VersionRequirementTable versionRequirements, boolean ignoreUnknownVersionRequirements, ReadContext parent, List<? extends Object> contextExtensions) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(versionRequirements, "versionRequirements");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        this.strings = strings;
        this.types = types;
        this.versionRequirements = versionRequirements;
        this.ignoreUnknownVersionRequirements = ignoreUnknownVersionRequirements;
        this.parent = parent;
        this.contextExtensions = contextExtensions;
        this.typeParameterNameToId = new LinkedHashMap();
        this.extensions = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ReadContext(NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, boolean z, ReadContext readContext, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, versionRequirementTable, z, r5, r6);
        ReadContext readContext2;
        List list2;
        if ((i & 16) == 0) {
            readContext2 = readContext;
        } else {
            readContext2 = null;
        }
        if ((i & 32) == 0) {
            list2 = list;
        } else {
            list2 = CollectionsKt.emptyList();
        }
    }

    public final NameResolver getStrings() {
        return this.strings;
    }

    public final TypeTable getTypes() {
        return this.types;
    }

    public final VersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    public final boolean getIgnoreUnknownVersionRequirements$kotlin_metadata() {
        return this.ignoreUnknownVersionRequirements;
    }

    public final List<MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final String get(int index) {
        return this.strings.getString(index);
    }

    public final String className$kotlin_metadata(int index) {
        return ReadUtilsKt.getClassName(this.strings, index);
    }

    public final Integer getTypeParameterId$kotlin_metadata(int name) {
        Integer num = this.typeParameterNameToId.get(Integer.valueOf(name));
        if (num == null) {
            ReadContext readContext = this.parent;
            if (readContext != null) {
                return readContext.getTypeParameterId$kotlin_metadata(name);
            }
            return null;
        }
        return num;
    }

    public final ReadContext withTypeParameters$kotlin_metadata(List<ProtoBuf.TypeParameter> typeParameters) {
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        ReadContext $this$withTypeParameters_u24lambda_u240 = new ReadContext(this.strings, this.types, this.versionRequirements, this.ignoreUnknownVersionRequirements, this, this.contextExtensions);
        for (ProtoBuf.TypeParameter typeParameter : typeParameters) {
            $this$withTypeParameters_u24lambda_u240.typeParameterNameToId.put(Integer.valueOf(typeParameter.getName()), Integer.valueOf(typeParameter.getId()));
        }
        return $this$withTypeParameters_u24lambda_u240;
    }
}