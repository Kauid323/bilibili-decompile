package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class JavaDescriptorVisibilities {
    public static final DescriptorVisibility PACKAGE_VISIBILITY = new DelegatedDescriptorVisibility(JavaVisibilities.PackageVisibility.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.1
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "fromPackage";
                    break;
                case 3:
                    objArr[0] = "myPackage";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            switch (i) {
                case 2:
                case 3:
                    objArr[2] = "visibleFromPackage";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
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
            return JavaDescriptorVisibilities.areInSamePackage(what, from);
        }
    };
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY = new DelegatedDescriptorVisibility(JavaVisibilities.ProtectedStaticVisibility.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.2
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
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
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
            return JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiver, what, from);
        }
    };
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE = new DelegatedDescriptorVisibility(JavaVisibilities.ProtectedAndPackage.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.3
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
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
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
            return JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiver, what, from);
        }
    };
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = new HashMap();

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 6:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 6:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        switch (i) {
            case 5:
            case 6:
                objArr[1] = "toDescriptorVisibility";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
        }
        switch (i) {
            case 2:
            case 3:
                objArr[2] = "areInSamePackage";
                break;
            case 4:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 5:
            case 6:
                break;
            default:
                objArr[2] = "isVisibleForProtectedAndPackage";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 5:
            case 6:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    static {
        recordVisibilityMapping(PACKAGE_VISIBILITY);
        recordVisibilityMapping(PROTECTED_STATIC_VISIBILITY);
        recordVisibilityMapping(PROTECTED_AND_PACKAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVisibleForProtectedAndPackage(ReceiverValue receiver, DeclarationDescriptorWithVisibility what, DeclarationDescriptor from) {
        if (what == null) {
            $$$reportNull$$$0(0);
        }
        if (from == null) {
            $$$reportNull$$$0(1);
        }
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(what), from)) {
            return true;
        }
        return DescriptorVisibilities.PROTECTED.isVisible(receiver, what, from, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areInSamePackage(DeclarationDescriptor first, DeclarationDescriptor second) {
        if (first == null) {
            $$$reportNull$$$0(2);
        }
        if (second == null) {
            $$$reportNull$$$0(3);
        }
        PackageFragmentDescriptor whatPackage = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(first, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor fromPackage = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(second, PackageFragmentDescriptor.class, false);
        return (fromPackage == null || whatPackage == null || !whatPackage.getFqName().equals(fromPackage.getFqName())) ? false : true;
    }

    private static void recordVisibilityMapping(DescriptorVisibility visibility) {
        visibilitiesMapping.put(visibility.getDelegate(), visibility);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(4);
        }
        DescriptorVisibility correspondingVisibility = visibilitiesMapping.get(visibility);
        if (correspondingVisibility == null) {
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(visibility);
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(5);
            }
            return descriptorVisibility;
        }
        if (correspondingVisibility == null) {
            $$$reportNull$$$0(6);
        }
        return correspondingVisibility;
    }
}