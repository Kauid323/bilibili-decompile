package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* compiled from: ClassDeserializer.kt */
public final class ClassDeserializer {
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;
    public static final Companion Companion = new Companion(null);
    private static final Set<ClassId> BLACK_LIST = SetsKt.setOf(ClassId.Companion.topLevel(StandardNames.FqNames.cloneable.toSafe()));

    public ClassDeserializer(DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
        this.classes = this.components.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$$Lambda$0
            private final ClassDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassDescriptor classes$lambda$0;
                classes$lambda$0 = ClassDeserializer.classes$lambda$0(this.arg$0, (ClassDeserializer.ClassKey) obj);
                return classes$lambda$0;
            }
        });
    }

    public static final ClassDescriptor classes$lambda$0(ClassDeserializer this$0, ClassKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this$0.createClass(key);
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classData));
    }

    private final ClassDescriptor createClass(ClassKey key) {
        Object element$iv;
        DeserializationContext outerContext;
        ClassId classId = key.getClassId();
        for (ClassDescriptorFactory factory : this.components.getFictitiousClassDescriptorFactories()) {
            ClassDescriptor it = factory.createClass(classId);
            if (it != null) {
                return it;
            }
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        ClassData classData = key.getClassData();
        if (classData == null && (classData = this.components.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        NameResolver nameResolver = classData.component1();
        ProtoBuf.Class classProto = classData.component2();
        BinaryVersion metadataVersion = classData.component3();
        SourceElement sourceElement = classData.component4();
        ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            ClassDescriptor deserializeClass$default = deserializeClass$default(this, outerClassId, null, 2, null);
            DeserializedClassDescriptor outerClass = deserializeClass$default instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) deserializeClass$default : null;
            if (outerClass == null || !outerClass.hasNestedClass$deserialization(classId.getShortClassName())) {
                return null;
            }
            outerContext = outerClass.getC();
        } else {
            Iterable fragments = PackageFragmentProviderKt.packageFragments(this.components.getPackageFragmentProvider(), classId.getPackageFqName());
            Iterable $this$firstOrNull$iv = fragments;
            Iterator<T> it2 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    element$iv = it2.next();
                    PackageFragmentDescriptor it3 = (PackageFragmentDescriptor) element$iv;
                    if (!(it3 instanceof DeserializedPackageFragment) || ((DeserializedPackageFragment) it3).hasTopLevelClass(classId.getShortClassName())) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            PackageFragmentDescriptor fragment = (PackageFragmentDescriptor) element$iv;
            if (fragment == null) {
                return null;
            }
            DeserializationComponents deserializationComponents = this.components;
            ProtoBuf.TypeTable typeTable = classProto.getTypeTable();
            Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
            TypeTable typeTable2 = new TypeTable(typeTable);
            VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
            ProtoBuf.VersionRequirementTable versionRequirementTable = classProto.getVersionRequirementTable();
            Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
            outerContext = deserializationComponents.createContext(fragment, nameResolver, typeTable2, companion.create(versionRequirementTable), metadataVersion, null);
        }
        return new DeserializedClassDescriptor(outerContext, classProto, nameResolver, metadataVersion, sourceElement);
    }

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId classId, ClassData classData) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.classData = classData;
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public boolean equals(Object other) {
            return (other instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) other).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }
    }
}