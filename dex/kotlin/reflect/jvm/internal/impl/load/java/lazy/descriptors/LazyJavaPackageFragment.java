package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LazyJavaPackageFragment.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaPackageFragment.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};
    private final Annotations annotations;
    private final NotNullLazyValue binaryClasses$delegate;
    private final LazyJavaResolverContext c;
    private final JavaPackage jPackage;
    private final MetadataVersion metadataVersion;
    private final NotNullLazyValue partToFacade$delegate;
    private final JvmPackageScope scope;
    private final NotNullLazyValue<List<FqName>> subPackages;

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(LazyJavaResolverContext outerContext, JavaPackage jPackage) {
        super(outerContext.getModule(), jPackage.getFqName());
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        this.jPackage = jPackage;
        this.c = ContextKt.childForClassOrPackage$default(outerContext, this, null, 0, 6, null);
        this.metadataVersion = outerContext.getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration().getMetadataVersion();
        this.binaryClasses$delegate = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$0
            private final LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Map binaryClasses_delegate$lambda$0;
                binaryClasses_delegate$lambda$0 = LazyJavaPackageFragment.binaryClasses_delegate$lambda$0(this.arg$0);
                return binaryClasses_delegate$lambda$0;
            }
        });
        this.scope = new JvmPackageScope(this.c, this.jPackage, this);
        this.subPackages = this.c.getStorageManager().createRecursionTolerantLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$1
            private final LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List subPackages$lambda$0;
                subPackages$lambda$0 = LazyJavaPackageFragment.subPackages$lambda$0(this.arg$0);
                return subPackages$lambda$0;
            }
        }, CollectionsKt.emptyList());
        this.annotations = this.c.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? Annotations.Companion.getEMPTY() : LazyJavaAnnotationsKt.resolveAnnotations(this.c, this.jPackage);
        this.partToFacade$delegate = this.c.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$2
            private final LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                HashMap partToFacade_delegate$lambda$0;
                partToFacade_delegate$lambda$0 = LazyJavaPackageFragment.partToFacade_delegate$lambda$0(this.arg$0);
                return partToFacade_delegate$lambda$0;
            }
        });
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map binaryClasses_delegate$lambda$0(LazyJavaPackageFragment this$0) {
        Iterable $this$mapNotNull$iv = this$0.c.getComponents().getPackagePartProvider().findPackageParts(this$0.getFqName().asString());
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String partName = (String) element$iv$iv$iv;
            ClassId.Companion companion = ClassId.Companion;
            FqName fqNameForTopLevelClassMaybeWithDollars = JvmClassName.byInternalName(partName).getFqNameForTopLevelClassMaybeWithDollars();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            Intrinsics.checkNotNullExpressionValue(fqNameForTopLevelClassMaybeWithDollars, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            ClassId classId = companion.topLevel(fqNameForTopLevelClassMaybeWithDollars);
            KotlinJvmBinaryClass it = KotlinClassFinderKt.findKotlinClass(this$0.c.getComponents().getKotlinClassFinder(), classId, this$0.metadataVersion);
            Pair pair = it != null ? TuplesKt.to(partName, it) : null;
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        return MapsKt.toMap((List) destination$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List subPackages$lambda$0(LazyJavaPackageFragment this$0) {
        Iterable $this$map$iv = this$0.jPackage.getSubPackages();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JavaPackage p0 = (JavaPackage) item$iv$iv;
            destination$iv$iv.add(p0.getFqName());
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.subPackages.invoke();
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(jClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap partToFacade_delegate$lambda$0(LazyJavaPackageFragment this$0) {
        HashMap result = new HashMap();
        for (Map.Entry<String, KotlinJvmBinaryClass> entry : this$0.getBinaryClasses$descriptors_jvm().entrySet()) {
            String partInternalName = entry.getKey();
            KotlinJvmBinaryClass kotlinClass = entry.getValue();
            JvmClassName partName = JvmClassName.byInternalName(partInternalName);
            Intrinsics.checkNotNullExpressionValue(partName, "byInternalName(...)");
            KotlinClassHeader header = kotlinClass.getClassHeader();
            switch (WhenMappings.$EnumSwitchMapping$0[header.getKind().ordinal()]) {
                case 1:
                    HashMap hashMap = result;
                    String multifileClassName = header.getMultifileClassName();
                    if (multifileClassName == null) {
                        break;
                    } else {
                        hashMap.put(partName, JvmClassName.byInternalName(multifileClassName));
                        break;
                    }
                case 2:
                    result.put(partName, partName);
                    break;
            }
        }
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.c.getComponents().getModule();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }
}