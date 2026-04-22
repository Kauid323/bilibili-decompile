package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName packageFqName, Name name) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        String string = name.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        return (StringsKt.startsWith$default(string, "Function", false, 2, (Object) null) || StringsKt.startsWith$default(string, "KFunction", false, 2, (Object) null) || StringsKt.startsWith$default(string, "SuspendFunction", false, 2, (Object) null) || StringsKt.startsWith$default(string, "KSuspendFunction", false, 2, (Object) null)) && FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(packageFqName, string) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        FqName packageFqName;
        FunctionTypeKindExtractor.KindWithArity functionalClassKindWithArity;
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String className = classId.getRelativeClassName().asString();
        if (StringsKt.contains$default((CharSequence) className, (CharSequence) "Function", false, 2, (Object) null) && (functionalClassKindWithArity = FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity((packageFqName = classId.getPackageFqName()), className)) != null) {
            FunctionTypeKind kind = functionalClassKindWithArity.component1();
            int arity = functionalClassKindWithArity.component2();
            Iterable $this$filterIsInstance$iv = this.module.getPackage(packageFqName).getFragments();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof BuiltInsPackageFragment) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List builtInsFragments = (List) destination$iv$iv;
            List $this$filterIsInstance$iv2 = builtInsFragments;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv2) {
                if (element$iv$iv2 instanceof FunctionInterfacePackageFragment) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            Object obj = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull((List<? extends Object>) destination$iv$iv2);
            if (obj == null) {
                obj = CollectionsKt.first((List<? extends Object>) builtInsFragments);
            }
            BuiltInsPackageFragment containingPackageFragment = (BuiltInsPackageFragment) obj;
            return new FunctionClassDescriptor(this.storageManager, containingPackageFragment, kind, arity);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return SetsKt.emptySet();
    }
}