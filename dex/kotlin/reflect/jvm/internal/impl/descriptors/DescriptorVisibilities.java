package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER;
    public static final DescriptorVisibility DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED;
    private static final ReceiverValue IRRELEVANT_RECEIVER;
    private static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
    private static final Map<DescriptorVisibility, Integer> ORDERED_VISIBILITIES;
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping;
    public static final DescriptorVisibility PRIVATE = new DelegatedDescriptorVisibility(Visibilities.Private.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.1
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "what";
                    break;
                case 2:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "isVisible";
                    break;
                default:
                    objArr[2] = "hasContainingSourceFile";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean hasContainingSourceFile(DeclarationDescriptor descriptor) {
            if (descriptor == null) {
                $$$reportNull$$$0(0);
            }
            return DescriptorUtils.getContainingSourceFile(descriptor) != SourceFile.NO_SOURCE_FILE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(1);
            }
            if (from == null) {
                $$$reportNull$$$0(2);
            }
            if (DescriptorUtils.isTopLevelDeclaration(what) && hasContainingSourceFile(from)) {
                return DescriptorVisibilities.inSameFile(what, from);
            }
            if (what instanceof ConstructorDescriptor) {
                ClassifierDescriptorWithTypeParameters classDescriptor = ((ConstructorDescriptor) what).getContainingDeclaration();
                if (useSpecialRulesForPrivateSealedConstructors && DescriptorUtils.isSealedClass(classDescriptor) && DescriptorUtils.isTopLevelDeclaration(classDescriptor) && (from instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(from.getContainingDeclaration()) && DescriptorVisibilities.inSameFile(what, from)) {
                    return true;
                }
            }
            DeclarationDescriptor parent = what;
            while (parent != null) {
                parent = parent.getContainingDeclaration();
                if (parent instanceof ClassDescriptor) {
                    if (!DescriptorUtils.isCompanionObject(parent)) {
                        break;
                    }
                }
                if (parent instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            if (parent == null) {
                return false;
            }
            for (DeclarationDescriptor fromParent = from; fromParent != null; fromParent = fromParent.getContainingDeclaration()) {
                if (parent == fromParent) {
                    return true;
                }
                if (fromParent instanceof PackageFragmentDescriptor) {
                    return (parent instanceof PackageFragmentDescriptor) && ((PackageFragmentDescriptor) parent).getFqName().equals(((PackageFragmentDescriptor) fromParent).getFqName()) && DescriptorUtils.areInSameModule(fromParent, parent);
                }
            }
            return false;
        }
    };
    public static final DescriptorVisibility PRIVATE_TO_THIS = new DelegatedDescriptorVisibility(Visibilities.PrivateToThis.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.2
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue thisObject, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            DeclarationDescriptor classDescriptor;
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            if (DescriptorVisibilities.PRIVATE.isVisible(thisObject, what, from, useSpecialRulesForPrivateSealedConstructors)) {
                if (thisObject == DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (thisObject != DescriptorVisibilities.IRRELEVANT_RECEIVER && (classDescriptor = DescriptorUtils.getParentOfType(what, ClassDescriptor.class)) != null && (thisObject instanceof ThisClassReceiver)) {
                    return ((ThisClassReceiver) thisObject).getClassDescriptor().getOriginal().equals(classDescriptor.getOriginal());
                }
            }
            return false;
        }
    };
    public static final DescriptorVisibility PROTECTED = new DelegatedDescriptorVisibility(Visibilities.Protected.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.3
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "whatDeclaration";
                    break;
                case 3:
                    objArr[0] = "fromClass";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            switch (i) {
                case 2:
                case 3:
                    objArr[2] = "doesReceiverFitForProtectedVisibility";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            ClassDescriptor companionOwner;
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            ClassDescriptor givenDescriptorContainingClass = (ClassDescriptor) DescriptorUtils.getParentOfType(what, ClassDescriptor.class);
            ClassDescriptor fromClass = (ClassDescriptor) DescriptorUtils.getParentOfType(from, ClassDescriptor.class, false);
            if (fromClass == null) {
                return false;
            }
            if (givenDescriptorContainingClass == null || !DescriptorUtils.isCompanionObject(givenDescriptorContainingClass) || (companionOwner = (ClassDescriptor) DescriptorUtils.getParentOfType(givenDescriptorContainingClass, ClassDescriptor.class)) == null || !DescriptorUtils.isSubclass(fromClass, companionOwner)) {
                DeclarationDescriptorWithVisibility whatDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(what);
                ClassDescriptor classDescriptor = (ClassDescriptor) DescriptorUtils.getParentOfType(whatDeclaration, ClassDescriptor.class);
                if (classDescriptor == null) {
                    return false;
                }
                if (DescriptorUtils.isSubclass(fromClass, classDescriptor) && doesReceiverFitForProtectedVisibility(receiver, whatDeclaration, fromClass)) {
                    return true;
                }
                return isVisible(receiver, what, fromClass.getContainingDeclaration(), useSpecialRulesForPrivateSealedConstructors);
            }
            return true;
        }

        private boolean doesReceiverFitForProtectedVisibility(ReceiverValue receiver, DeclarationDescriptorWithVisibility whatDeclaration, ClassDescriptor fromClass) {
            KotlinType actualReceiverType;
            if (whatDeclaration == null) {
                $$$reportNull$$$0(2);
            }
            if (fromClass == null) {
                $$$reportNull$$$0(3);
            }
            if (receiver == DescriptorVisibilities.FALSE_IF_PROTECTED) {
                return false;
            }
            if (!(whatDeclaration instanceof CallableMemberDescriptor) || (whatDeclaration instanceof ConstructorDescriptor) || receiver == DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                return true;
            }
            if (receiver == DescriptorVisibilities.IRRELEVANT_RECEIVER || receiver == null) {
                return false;
            }
            if (receiver instanceof SuperCallReceiverValue) {
                actualReceiverType = ((SuperCallReceiverValue) receiver).getThisType();
            } else {
                actualReceiverType = receiver.getType();
            }
            return DescriptorUtils.isSubtypeOfClass(actualReceiverType, fromClass) || DynamicTypesKt.isDynamic(actualReceiverType);
        }
    };
    public static final DescriptorVisibility INTERNAL = new DelegatedDescriptorVisibility(Visibilities.Internal.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.4
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            ModuleDescriptor whatModule = DescriptorUtils.getContainingModule(what);
            ModuleDescriptor fromModule = DescriptorUtils.getContainingModule(from);
            if (fromModule.shouldSeeInternalsOf(whatModule)) {
                return DescriptorVisibilities.MODULE_VISIBILITY_HELPER.isInFriendModule(what, from);
            }
            return false;
        }
    };
    public static final DescriptorVisibility PUBLIC = new DelegatedDescriptorVisibility(Visibilities.Public.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.5
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            return true;
        }
    };
    public static final DescriptorVisibility LOCAL = new DelegatedDescriptorVisibility(Visibilities.Local.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.6
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    };
    public static final DescriptorVisibility INHERITED = new DelegatedDescriptorVisibility(Visibilities.Inherited.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.7
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    };
    public static final DescriptorVisibility INVISIBLE_FAKE = new DelegatedDescriptorVisibility(Visibilities.InvisibleFake.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.8
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            return false;
        }
    };
    public static final DescriptorVisibility UNKNOWN = new DelegatedDescriptorVisibility(Visibilities.Unknown.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.9
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                $$$reportNull$$$0(0);
            }
            if (from == null) {
                $$$reportNull$$$0(1);
            }
            return false;
        }
    };
    public static final Set<DescriptorVisibility> INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf((Object[]) new DescriptorVisibility[]{PRIVATE, PRIVATE_TO_THIS, INTERNAL, LOCAL}));

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 16:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 16:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                objArr[0] = "from";
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            default:
                objArr[0] = "what";
                break;
            case 10:
            case additional_type_content_opus_VALUE:
                objArr[0] = "first";
                break;
            case 11:
            case additional_type_content_video_VALUE:
                objArr[0] = "second";
                break;
            case additional_type_content_comment_VALUE:
            case 15:
                objArr[0] = "visibility";
                break;
            case 16:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                break;
        }
        switch (i) {
            case 16:
                objArr[1] = "toDescriptorVisibility";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                break;
        }
        switch (i) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
                objArr[2] = "compare";
                break;
            case additional_type_content_comment_VALUE:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 16:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    static {
        Map<DescriptorVisibility, Integer> visibilities = CollectionsKt.newHashMapWithExpectedSize(4);
        visibilities.put(PRIVATE_TO_THIS, 0);
        visibilities.put(PRIVATE, 0);
        visibilities.put(INTERNAL, 1);
        visibilities.put(PROTECTED, 1);
        visibilities.put(PUBLIC, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(visibilities);
        DEFAULT_VISIBILITY = PUBLIC;
        IRRELEVANT_RECEIVER = new ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.10
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        ALWAYS_SUITABLE_RECEIVER = new ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.11
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        FALSE_IF_PROTECTED = new ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.12
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        Iterator<ModuleVisibilityHelper> iterator = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        MODULE_VISIBILITY_HELPER = iterator.hasNext() ? iterator.next() : ModuleVisibilityHelper.EMPTY.INSTANCE;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(PRIVATE);
        recordVisibilityMapping(PRIVATE_TO_THIS);
        recordVisibilityMapping(PROTECTED);
        recordVisibilityMapping(INTERNAL);
        recordVisibilityMapping(PUBLIC);
        recordVisibilityMapping(LOCAL);
        recordVisibilityMapping(INHERITED);
        recordVisibilityMapping(INVISIBLE_FAKE);
        recordVisibilityMapping(UNKNOWN);
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
        if (what == null) {
            $$$reportNull$$$0(2);
        }
        if (from == null) {
            $$$reportNull$$$0(3);
        }
        return findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, what, from, useSpecialRulesForPrivateSealedConstructors) == null;
    }

    public static boolean inSameFile(DeclarationDescriptor what, DeclarationDescriptor from) {
        if (what == null) {
            $$$reportNull$$$0(6);
        }
        if (from == null) {
            $$$reportNull$$$0(7);
        }
        SourceFile fromContainingFile = DescriptorUtils.getContainingSourceFile(from);
        if (fromContainingFile != SourceFile.NO_SOURCE_FILE) {
            return fromContainingFile.equals(DescriptorUtils.getContainingSourceFile(what));
        }
        return false;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
        DeclarationDescriptorWithVisibility invisibleUnderlying;
        if (what == null) {
            $$$reportNull$$$0(8);
        }
        if (from == null) {
            $$$reportNull$$$0(9);
        }
        for (DeclarationDescriptorWithVisibility parent = (DeclarationDescriptorWithVisibility) what.getOriginal(); parent != null && parent.getVisibility() != LOCAL; parent = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(parent, DeclarationDescriptorWithVisibility.class)) {
            if (!parent.getVisibility().isVisible(receiver, parent, from, useSpecialRulesForPrivateSealedConstructors)) {
                return parent;
            }
        }
        if (!(what instanceof TypeAliasConstructorDescriptor) || (invisibleUnderlying = findInvisibleMember(receiver, ((TypeAliasConstructorDescriptor) what).getUnderlyingConstructorDescriptor(), from, useSpecialRulesForPrivateSealedConstructors)) == null) {
            return null;
        }
        return invisibleUnderlying;
    }

    public static Integer compare(DescriptorVisibility first, DescriptorVisibility second) {
        if (first == null) {
            $$$reportNull$$$0(12);
        }
        if (second == null) {
            $$$reportNull$$$0(13);
        }
        Integer result = first.compareTo(second);
        if (result != null) {
            return result;
        }
        Integer oppositeResult = second.compareTo(first);
        if (oppositeResult != null) {
            return Integer.valueOf(-oppositeResult.intValue());
        }
        return null;
    }

    public static boolean isPrivate(DescriptorVisibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(14);
        }
        return visibility == PRIVATE || visibility == PRIVATE_TO_THIS;
    }

    private static void recordVisibilityMapping(DescriptorVisibility visibility) {
        visibilitiesMapping.put(visibility.getDelegate(), visibility);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(15);
        }
        DescriptorVisibility correspondingVisibility = visibilitiesMapping.get(visibility);
        if (correspondingVisibility == null) {
            throw new IllegalArgumentException("Inapplicable visibility: " + visibility);
        }
        if (correspondingVisibility == null) {
            $$$reportNull$$$0(16);
        }
        return correspondingVisibility;
    }
}