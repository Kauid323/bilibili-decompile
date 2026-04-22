package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;

/* compiled from: findClassInModule.kt */
public final class FindClassInModuleKt {
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor $this$findClassifierAcrossModuleDependencies, ClassId classId) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkNotNullParameter($this$findClassifierAcrossModuleDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor anchor$iv = ResolutionAnchorProviderKt.getResolutionAnchorIfAny($this$findClassifierAcrossModuleDependencies);
        if (anchor$iv == null) {
            PackageViewDescriptor packageViewDescriptor = $this$findClassifierAcrossModuleDependencies.getPackage(classId.getPackageFqName());
            List segments = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor topLevelClass = packageViewDescriptor.getMemberScope().mo1173getContributedClassifier((Name) CollectionsKt.first((List<? extends Object>) segments), NoLookupLocation.FROM_DESERIALIZATION);
            if (topLevelClass == null) {
                return null;
            }
            ClassifierDescriptor result = topLevelClass;
            for (Name name : segments.subList(1, segments.size())) {
                if (!(result instanceof ClassDescriptor)) {
                    return null;
                }
                ClassifierDescriptor contributedClassifier = ((ClassDescriptor) result).getUnsubstitutedInnerClassesScope().mo1173getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                ClassifierDescriptor classifierDescriptor2 = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
                if (classifierDescriptor2 == null) {
                    return null;
                }
                result = classifierDescriptor2;
            }
            return result;
        }
        PackageViewDescriptor packageViewDescriptor2 = anchor$iv.getPackage(classId.getPackageFqName());
        List segments2 = classId.getRelativeClassName().pathSegments();
        ClassifierDescriptor topLevelClass2 = packageViewDescriptor2.getMemberScope().mo1173getContributedClassifier((Name) CollectionsKt.first((List<? extends Object>) segments2), NoLookupLocation.FROM_DESERIALIZATION);
        if (topLevelClass2 != null) {
            ClassifierDescriptor result2 = topLevelClass2;
            Iterator<Name> it = segments2.subList(1, segments2.size()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    classifierDescriptor = result2;
                    break;
                }
                Name name2 = it.next();
                if (!(result2 instanceof ClassDescriptor)) {
                    classifierDescriptor = null;
                    break;
                }
                ClassifierDescriptor contributedClassifier2 = ((ClassDescriptor) result2).getUnsubstitutedInnerClassesScope().mo1173getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                ClassifierDescriptor classifierDescriptor3 = contributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier2 : null;
                if (classifierDescriptor3 == null) {
                    classifierDescriptor = null;
                    break;
                }
                result2 = classifierDescriptor3;
            }
        } else {
            classifierDescriptor = null;
        }
        if (classifierDescriptor == null) {
            PackageViewDescriptor packageViewDescriptor3 = $this$findClassifierAcrossModuleDependencies.getPackage(classId.getPackageFqName());
            List segments3 = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor topLevelClass3 = packageViewDescriptor3.getMemberScope().mo1173getContributedClassifier((Name) CollectionsKt.first((List<? extends Object>) segments3), NoLookupLocation.FROM_DESERIALIZATION);
            if (topLevelClass3 == null) {
                return null;
            }
            ClassifierDescriptor result3 = topLevelClass3;
            for (Name name3 : segments3.subList(1, segments3.size())) {
                if (!(result3 instanceof ClassDescriptor)) {
                    return null;
                }
                ClassifierDescriptor contributedClassifier3 = ((ClassDescriptor) result3).getUnsubstitutedInnerClassesScope().mo1173getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
                ClassifierDescriptor classifierDescriptor4 = contributedClassifier3 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier3 : null;
                if (classifierDescriptor4 == null) {
                    return null;
                }
                result3 = classifierDescriptor4;
            }
            return result3;
        }
        return classifierDescriptor;
    }

    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor $this$findClassAcrossModuleDependencies, ClassId classId) {
        Intrinsics.checkNotNullParameter($this$findClassAcrossModuleDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies($this$findClassAcrossModuleDependencies, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor $this$findNonGenericClassAcrossDependencies, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter($this$findNonGenericClassAcrossDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor existingClass = findClassAcrossModuleDependencies($this$findNonGenericClassAcrossDependencies, classId);
        if (existingClass != null) {
            return existingClass;
        }
        List typeParametersCount = SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return ((ClassId) receiver0).getOuterClassId();
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                int findNonGenericClassAcrossDependencies$lambda$0;
                findNonGenericClassAcrossDependencies$lambda$0 = FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$0((ClassId) obj);
                return Integer.valueOf(findNonGenericClassAcrossDependencies$lambda$0);
            }
        }));
        return notFoundClasses.getClass(classId, typeParametersCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNonGenericClassAcrossDependencies$lambda$0(ClassId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor $this$findTypeAliasAcrossModuleDependencies, ClassId classId) {
        Intrinsics.checkNotNullParameter($this$findTypeAliasAcrossModuleDependencies, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies($this$findTypeAliasAcrossModuleDependencies, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }
}