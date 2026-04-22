package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

public final class DescriptorResolverUtils {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 18:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 18:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
            case additional_type_content_video_VALUE:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case additional_type_content_comment_VALUE:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case additional_type_content_opus_VALUE:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        switch (i) {
            case 18:
                objArr[1] = "resolveOverrides";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 18:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name name, Collection<D> membersFromSupertypes, Collection<D> membersFromCurrent, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            $$$reportNull$$$0(0);
        }
        if (membersFromSupertypes == null) {
            $$$reportNull$$$0(1);
        }
        if (membersFromCurrent == null) {
            $$$reportNull$$$0(2);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (errorReporter == null) {
            $$$reportNull$$$0(4);
        }
        if (overridingUtil == null) {
            $$$reportNull$$$0(5);
        }
        return resolveOverrides(name, membersFromSupertypes, membersFromCurrent, classDescriptor, errorReporter, overridingUtil, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name name, Collection<D> membersFromSupertypes, Collection<D> membersFromCurrent, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            $$$reportNull$$$0(6);
        }
        if (membersFromSupertypes == null) {
            $$$reportNull$$$0(7);
        }
        if (membersFromCurrent == null) {
            $$$reportNull$$$0(8);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        if (errorReporter == null) {
            $$$reportNull$$$0(10);
        }
        if (overridingUtil == null) {
            $$$reportNull$$$0(11);
        }
        return resolveOverrides(name, membersFromSupertypes, membersFromCurrent, classDescriptor, errorReporter, overridingUtil, true);
    }

    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(Name name, Collection<D> membersFromSupertypes, Collection<D> membersFromCurrent, ClassDescriptor classDescriptor, final ErrorReporter errorReporter, OverridingUtil overridingUtil, final boolean isStaticContext) {
        if (name == null) {
            $$$reportNull$$$0(12);
        }
        if (membersFromSupertypes == null) {
            $$$reportNull$$$0(13);
        }
        if (membersFromCurrent == null) {
            $$$reportNull$$$0(14);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        if (errorReporter == null) {
            $$$reportNull$$$0(16);
        }
        if (overridingUtil == null) {
            $$$reportNull$$$0(17);
        }
        final Set<D> result = new LinkedHashSet<>();
        overridingUtil.generateOverridesInFunctionGroup(name, membersFromSupertypes, membersFromCurrent, classDescriptor, new NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.1
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                switch (i) {
                    case 1:
                        objArr[0] = "fromSuper";
                        break;
                    case 2:
                        objArr[0] = "fromCurrent";
                        break;
                    case 3:
                        objArr[0] = "member";
                        break;
                    case 4:
                        objArr[0] = "overridden";
                        break;
                    default:
                        objArr[0] = "fakeOverride";
                        break;
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
                switch (i) {
                    case 1:
                    case 2:
                        objArr[2] = "conflict";
                        break;
                    case 3:
                    case 4:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    default:
                        objArr[2] = "addFakeOverride";
                        break;
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
            public void addFakeOverride(CallableMemberDescriptor fakeOverride) {
                if (fakeOverride == null) {
                    $$$reportNull$$$0(0);
                }
                OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, new Function1<CallableMemberDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.1.1
                    private static /* synthetic */ void $$$reportNull$$$0(int i) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(CallableMemberDescriptor descriptor) {
                        if (descriptor == null) {
                            $$$reportNull$$$0(0);
                        }
                        ErrorReporter.this.reportCannotInferVisibility(descriptor);
                        return Unit.INSTANCE;
                    }
                });
                result.add(fakeOverride);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
            public void conflict(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
                if (fromSuper == null) {
                    $$$reportNull$$$0(1);
                }
                if (fromCurrent == null) {
                    $$$reportNull$$$0(2);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
            public void setOverriddenDescriptors(CallableMemberDescriptor member, Collection<? extends CallableMemberDescriptor> overridden) {
                if (member == null) {
                    $$$reportNull$$$0(3);
                }
                if (overridden == null) {
                    $$$reportNull$$$0(4);
                }
                if (isStaticContext && member.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    return;
                }
                super.setOverriddenDescriptors(member, overridden);
            }
        });
        return result;
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name name, ClassDescriptor annotationClass) {
        if (name == null) {
            $$$reportNull$$$0(19);
        }
        if (annotationClass == null) {
            $$$reportNull$$$0(20);
        }
        Collection<ClassConstructorDescriptor> constructors = annotationClass.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (ValueParameterDescriptor parameter : constructors.iterator().next().getValueParameters()) {
            if (parameter.getName().equals(name)) {
                return parameter;
            }
        }
        return null;
    }
}