package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME;

    static {
        Name identifier = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        RETENTION_PARAMETER_NAME = identifier;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor $this$fqNameUnsafe) {
        Intrinsics.checkNotNullParameter($this$fqNameUnsafe, "<this>");
        FqNameUnsafe fqName = DescriptorUtils.getFqName($this$fqNameUnsafe);
        Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(...)");
        return fqName;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor $this$fqNameSafe) {
        Intrinsics.checkNotNullParameter($this$fqNameSafe, "<this>");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe($this$fqNameSafe);
        Intrinsics.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(...)");
        return fqNameSafe;
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor $this$module) {
        Intrinsics.checkNotNullParameter($this$module, "<this>");
        ModuleDescriptor containingModule = DescriptorUtils.getContainingModule($this$module);
        Intrinsics.checkNotNullExpressionValue(containingModule, "getContainingModule(...)");
        return containingModule;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor $this$resolveTopLevelClass, FqName topLevelClassFqName, LookupLocation location2) {
        Intrinsics.checkNotNullParameter($this$resolveTopLevelClass, "<this>");
        Intrinsics.checkNotNullParameter(topLevelClassFqName, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(location2, "location");
        if (topLevelClassFqName.isRoot()) {
            throw new AssertionError("Assertion failed");
        }
        ClassifierDescriptor contributedClassifier = $this$resolveTopLevelClass.getPackage(topLevelClassFqName.parent()).getMemberScope().mo1173getContributedClassifier(topLevelClassFqName.shortName(), location2);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    public static final ClassId getClassId(ClassifierDescriptor $this$classId) {
        DeclarationDescriptor owner;
        ClassId classId;
        if ($this$classId == null || (owner = $this$classId.getContainingDeclaration()) == null) {
            return null;
        }
        if (owner instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) owner).getFqName();
            Name name = $this$classId.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return new ClassId(fqName, name);
        } else if (!(owner instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) owner)) == null) {
            return null;
        } else {
            Name name2 = $this$classId.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            return classId.createNestedClassId(name2);
        }
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor $this$getSuperClassNotAny) {
        Intrinsics.checkNotNullParameter($this$getSuperClassNotAny, "<this>");
        for (KotlinType supertype : $this$getSuperClassNotAny.getDefaultType().getConstructor().mo1172getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(supertype)) {
                ClassifierDescriptor superClassifier = supertype.getConstructor().mo1171getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(superClassifier)) {
                    Intrinsics.checkNotNull(superClassifier, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) superClassifier;
                }
            }
        }
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor $this$builtIns) {
        Intrinsics.checkNotNullParameter($this$builtIns, "<this>");
        return getModule($this$builtIns).getBuiltIns();
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor $this$declaresOrInheritsDefaultValue) {
        Intrinsics.checkNotNullParameter($this$declaresOrInheritsDefaultValue, "<this>");
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf($this$declaresOrInheritsDefaultValue), new DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$0
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable declaresOrInheritsDefaultValue$lambda$0;
                declaresOrInheritsDefaultValue$lambda$0 = DescriptorUtilsKt.declaresOrInheritsDefaultValue$lambda$0((ValueParameterDescriptor) obj);
                return declaresOrInheritsDefaultValue$lambda$0;
            }
        }, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(ifAny, "ifAny(...)");
        return ifAny.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable declaresOrInheritsDefaultValue$lambda$0(ValueParameterDescriptor current) {
        Iterable $this$map$iv = current.getOverriddenDescriptors();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ValueParameterDescriptor p0 = (ValueParameterDescriptor) item$iv$iv;
            destination$iv$iv.add(p0.getOriginal());
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeclarationDescriptor _get_parentsWithSelf_$lambda$0(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContainingDeclaration();
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor $this$parentsWithSelf) {
        Intrinsics.checkNotNullParameter($this$parentsWithSelf, "<this>");
        return SequencesKt.generateSequence($this$parentsWithSelf, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                DeclarationDescriptor _get_parentsWithSelf_$lambda$0;
                _get_parentsWithSelf_$lambda$0 = DescriptorUtilsKt._get_parentsWithSelf_$lambda$0((DeclarationDescriptor) obj);
                return _get_parentsWithSelf_$lambda$0;
            }
        });
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor $this$parents) {
        Intrinsics.checkNotNullParameter($this$parents, "<this>");
        return SequencesKt.drop(getParentsWithSelf($this$parents), 1);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor $this$propertyIfAccessor) {
        Intrinsics.checkNotNullParameter($this$propertyIfAccessor, "<this>");
        if ($this$propertyIfAccessor instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) $this$propertyIfAccessor).getCorrespondingProperty();
            Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
            return correspondingProperty;
        }
        return $this$propertyIfAccessor;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor $this$fqNameOrNull) {
        Intrinsics.checkNotNullParameter($this$fqNameOrNull, "<this>");
        FqNameUnsafe it = getFqNameUnsafe($this$fqNameOrNull);
        if (!it.isSafe()) {
            it = null;
        }
        if (it != null) {
            return it.toSafe();
        }
        return null;
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return firstOverridden(callableMemberDescriptor, z, function1);
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor $this$firstOverridden, final boolean useOriginal, final Function1<? super CallableMemberDescriptor, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$firstOverridden, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final Ref.ObjectRef result = new Ref.ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf($this$firstOverridden), new DFS.Neighbors(useOriginal) { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$2
            private final boolean arg$0;

            {
                this.arg$0 = useOriginal;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable firstOverridden$lambda$0;
                firstOverridden$lambda$0 = DescriptorUtilsKt.firstOverridden$lambda$0(this.arg$0, (CallableMemberDescriptor) obj);
                return firstOverridden$lambda$0;
            }
        }, new DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$firstOverridden$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(CallableMemberDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                return result.element == null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public void afterChildren(CallableMemberDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (result.element == null && predicate.invoke(current).booleanValue()) {
                    result.element = current;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public CallableMemberDescriptor result() {
                return result.element;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable firstOverridden$lambda$0(boolean $useOriginal, CallableMemberDescriptor current) {
        Collection<? extends CallableMemberDescriptor> emptyList;
        CallableMemberDescriptor descriptor = $useOriginal ? current != null ? current.getOriginal() : null : current;
        if (descriptor == null || (emptyList = descriptor.getOverriddenDescriptors()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public static final Sequence<CallableMemberDescriptor> overriddenTreeAsSequence(CallableMemberDescriptor $this$overriddenTreeAsSequence, final boolean useOriginal) {
        Intrinsics.checkNotNullParameter($this$overriddenTreeAsSequence, "<this>");
        CallableMemberDescriptor $this$overriddenTreeAsSequence_u24lambda_u240 = useOriginal ? $this$overriddenTreeAsSequence.getOriginal() : $this$overriddenTreeAsSequence;
        Sequence sequenceOf = SequencesKt.sequenceOf((Object[]) new CallableMemberDescriptor[]{$this$overriddenTreeAsSequence_u24lambda_u240});
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = $this$overriddenTreeAsSequence_u24lambda_u240.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        return SequencesKt.plus(sequenceOf, SequencesKt.flatMap(CollectionsKt.asSequence(overriddenDescriptors), new Function1(useOriginal) { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$3
            private final boolean arg$0;

            {
                this.arg$0 = useOriginal;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Sequence overriddenTreeAsSequence$lambda$0$0;
                overriddenTreeAsSequence$lambda$0$0 = DescriptorUtilsKt.overriddenTreeAsSequence$lambda$0$0(this.arg$0, (CallableMemberDescriptor) obj);
                return overriddenTreeAsSequence$lambda$0$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence overriddenTreeAsSequence$lambda$0$0(boolean $useOriginal, CallableMemberDescriptor it) {
        Intrinsics.checkNotNull(it);
        return overriddenTreeAsSequence(it, $useOriginal);
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor $this$annotationClass) {
        Intrinsics.checkNotNullParameter($this$annotationClass, "<this>");
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$annotationClass.getType().getConstructor().mo1171getDeclarationDescriptor();
        if (mo1171getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo1171getDeclarationDescriptor;
        }
        return null;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor $this$getKotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter($this$getKotlinTypeRefiner, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) $this$getKotlinTypeRefiner.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        TypeRefinementSupport refinerCapability = ref != null ? (TypeRefinementSupport) ref.getValue() : null;
        return refinerCapability instanceof TypeRefinementSupport.Enabled ? ((TypeRefinementSupport.Enabled) refinerCapability).getTypeRefiner() : KotlinTypeRefiner.Default.INSTANCE;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor $this$isTypeRefinementEnabled) {
        TypeRefinementSupport typeRefinementSupport;
        Intrinsics.checkNotNullParameter($this$isTypeRefinementEnabled, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) $this$isTypeRefinementEnabled.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        return (ref == null || (typeRefinementSupport = (TypeRefinementSupport) ref.getValue()) == null || !typeRefinementSupport.isEnabled()) ? false : true;
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor $this$inlineClassRepresentation) {
        ValueClassRepresentation<SimpleType> valueClassRepresentation = $this$inlineClassRepresentation != null ? $this$inlineClassRepresentation.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof InlineClassRepresentation) {
            return (InlineClassRepresentation) valueClassRepresentation;
        }
        return null;
    }

    public static final MultiFieldValueClassRepresentation<SimpleType> getMultiFieldValueClassRepresentation(ClassDescriptor $this$multiFieldValueClassRepresentation) {
        ValueClassRepresentation<SimpleType> valueClassRepresentation = $this$multiFieldValueClassRepresentation != null ? $this$multiFieldValueClassRepresentation.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof MultiFieldValueClassRepresentation) {
            return (MultiFieldValueClassRepresentation) valueClassRepresentation;
        }
        return null;
    }
}