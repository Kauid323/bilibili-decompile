package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: PackagePartScopeCache.kt */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache;
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver resolver, ReflectKotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.resolver = resolver;
        this.kotlinClassFinder = kotlinClassFinder;
        this.cache = new ConcurrentHashMap<>();
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass fileClass) {
        Iterable parts;
        PackagePartScopeCache packagePartScopeCache = this;
        Intrinsics.checkNotNullParameter(fileClass, "fileClass");
        ConcurrentMap $this$getOrPut$iv = packagePartScopeCache.cache;
        ClassId classId = fileClass.getClassId();
        boolean z = false;
        Object obj = $this$getOrPut$iv.get(classId);
        if (obj == null) {
            boolean z2 = false;
            FqName fqName = fileClass.getClassId().getPackageFqName();
            if (fileClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                Iterable $this$mapNotNull$iv = fileClass.getClassHeader().getMultifilePartNames();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    String partName = (String) element$iv$iv$iv;
                    boolean z3 = z;
                    ClassId.Companion companion = ClassId.Companion;
                    boolean z4 = z2;
                    FqName fqNameForTopLevelClassMaybeWithDollars = JvmClassName.byInternalName(partName).getFqNameForTopLevelClassMaybeWithDollars();
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Intrinsics.checkNotNullExpressionValue(fqNameForTopLevelClassMaybeWithDollars, "getFqNameForTopLevelClassMaybeWithDollars(...)");
                    ClassId classId2 = companion.topLevel(fqNameForTopLevelClassMaybeWithDollars);
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(packagePartScopeCache.kotlinClassFinder, classId2, packagePartScopeCache.resolver.getComponents().getConfiguration().getMetadataVersion());
                    if (findKotlinClass != null) {
                        destination$iv$iv.add(findKotlinClass);
                    }
                    z = z3;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    z2 = z4;
                }
                parts = (List) destination$iv$iv;
            } else {
                parts = CollectionsKt.listOf(fileClass);
            }
            EmptyPackageFragmentDescriptor packageFragment = new EmptyPackageFragmentDescriptor(packagePartScopeCache.resolver.getComponents().getModuleDescriptor(), fqName);
            Iterable $this$mapNotNull$iv3 = parts;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv3) {
                List parts2 = parts;
                KotlinJvmBinaryClass part = (KotlinJvmBinaryClass) element$iv$iv$iv2;
                Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv3;
                MemberScope createKotlinPackagePartScope = packagePartScopeCache.resolver.createKotlinPackagePartScope(packageFragment, part);
                if (createKotlinPackagePartScope != null) {
                    destination$iv$iv2.add(createKotlinPackagePartScope);
                }
                packagePartScopeCache = this;
                parts = parts2;
                $this$mapNotNull$iv3 = $this$mapNotNull$iv4;
            }
            List scopes = CollectionsKt.toList((List) destination$iv$iv2);
            MemberScope create = ChainedMemberScope.Companion.create("package " + fqName + " (" + fileClass + ')', scopes);
            obj = $this$getOrPut$iv.putIfAbsent(classId, create);
            if (obj == null) {
                obj = create;
            }
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return (MemberScope) obj;
    }
}