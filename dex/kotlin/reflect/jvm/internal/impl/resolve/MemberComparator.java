package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class MemberComparator implements Comparator<DeclarationDescriptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final MemberComparator INSTANCE = new MemberComparator();
    private static final DescriptorRenderer RENDERER = DescriptorRenderer.Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.1
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions options) {
            options.setWithDefinedIn(false);
            options.setVerbose(true);
            options.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            options.setModifiers(DescriptorRendererModifier.ALL);
            return Unit.INSTANCE;
        }
    });

    private MemberComparator() {
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class NameAndTypeMemberComparator implements Comparator<DeclarationDescriptor> {
        public static final NameAndTypeMemberComparator INSTANCE = new NameAndTypeMemberComparator();

        private NameAndTypeMemberComparator() {
        }

        private static int getDeclarationPriority(DeclarationDescriptor descriptor) {
            if (DescriptorUtils.isEnumEntry(descriptor)) {
                return 8;
            }
            if (descriptor instanceof ConstructorDescriptor) {
                return 7;
            }
            if (descriptor instanceof PropertyDescriptor) {
                if (((PropertyDescriptor) descriptor).getExtensionReceiverParameter() == null) {
                    return 6;
                }
                return 5;
            } else if (descriptor instanceof FunctionDescriptor) {
                if (((FunctionDescriptor) descriptor).getExtensionReceiverParameter() == null) {
                    return 4;
                }
                return 3;
            } else if (descriptor instanceof ClassDescriptor) {
                return 2;
            } else {
                if (descriptor instanceof TypeAliasDescriptor) {
                    return 1;
                }
                return 0;
            }
        }

        @Override // java.util.Comparator
        public int compare(DeclarationDescriptor o1, DeclarationDescriptor o2) {
            Integer compareInternal = compareInternal(o1, o2);
            if (compareInternal != null) {
                return compareInternal.intValue();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Integer compareInternal(DeclarationDescriptor o1, DeclarationDescriptor o2) {
            int prioritiesCompareTo = getDeclarationPriority(o2) - getDeclarationPriority(o1);
            if (prioritiesCompareTo != 0) {
                return Integer.valueOf(prioritiesCompareTo);
            }
            if (DescriptorUtils.isEnumEntry(o1) && DescriptorUtils.isEnumEntry(o2)) {
                return 0;
            }
            int namesCompareTo = o1.getName().compareTo(o2.getName());
            if (namesCompareTo != 0) {
                return Integer.valueOf(namesCompareTo);
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x013e, code lost:
        r12 = r12 + 1;
        r4 = r16;
        r2 = r17;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compare(DeclarationDescriptor o1, DeclarationDescriptor o2) {
        Integer typeAndNameCompareResult = NameAndTypeMemberComparator.compareInternal(o1, o2);
        if (typeAndNameCompareResult != null) {
            return typeAndNameCompareResult.intValue();
        }
        if ((o1 instanceof TypeAliasDescriptor) && (o2 instanceof TypeAliasDescriptor)) {
            TypeAliasDescriptor ta1 = (TypeAliasDescriptor) o1;
            TypeAliasDescriptor ta2 = (TypeAliasDescriptor) o2;
            String r1 = RENDERER.renderType(ta1.getUnderlyingType());
            String r2 = RENDERER.renderType(ta2.getUnderlyingType());
            int underlyingTypesCompareTo = r1.compareTo(r2);
            if (underlyingTypesCompareTo != 0) {
                return underlyingTypesCompareTo;
            }
        } else if ((o1 instanceof CallableDescriptor) && (o2 instanceof CallableDescriptor)) {
            CallableDescriptor c1 = (CallableDescriptor) o1;
            CallableDescriptor c2 = (CallableDescriptor) o2;
            ReceiverParameterDescriptor c1ReceiverParameter = c1.getExtensionReceiverParameter();
            ReceiverParameterDescriptor c2ReceiverParameter = c2.getExtensionReceiverParameter();
            if ((c1ReceiverParameter != null) != (c2ReceiverParameter != null)) {
                throw new AssertionError();
            }
            if (c1ReceiverParameter != null) {
                String r12 = RENDERER.renderType(c1ReceiverParameter.getType());
                String r22 = RENDERER.renderType(c2ReceiverParameter.getType());
                int receiversCompareTo = r12.compareTo(r22);
                if (receiversCompareTo != 0) {
                    return receiversCompareTo;
                }
            }
            List<ValueParameterDescriptor> c1ValueParameters = c1.getValueParameters();
            List<ValueParameterDescriptor> c2ValueParameters = c2.getValueParameters();
            for (int i = 0; i < Math.min(c1ValueParameters.size(), c2ValueParameters.size()); i++) {
                String p1 = RENDERER.renderType(c1ValueParameters.get(i).getType());
                String p2 = RENDERER.renderType(c2ValueParameters.get(i).getType());
                int parametersCompareTo = p1.compareTo(p2);
                if (parametersCompareTo != 0) {
                    return parametersCompareTo;
                }
            }
            int i2 = c1ValueParameters.size();
            int valueParametersNumberCompareTo = i2 - c2ValueParameters.size();
            if (valueParametersNumberCompareTo != 0) {
                return valueParametersNumberCompareTo;
            }
            List<TypeParameterDescriptor> c1TypeParameters = c1.getTypeParameters();
            List<TypeParameterDescriptor> c2TypeParameters = c2.getTypeParameters();
            int i3 = 0;
            while (i3 < Math.min(c1TypeParameters.size(), c2TypeParameters.size())) {
                List<KotlinType> c1Bounds = c1TypeParameters.get(i3).getUpperBounds();
                List<KotlinType> c2Bounds = c2TypeParameters.get(i3).getUpperBounds();
                int boundsCountCompareTo = c1Bounds.size() - c2Bounds.size();
                if (boundsCountCompareTo != 0) {
                    return boundsCountCompareTo;
                }
                Integer typeAndNameCompareResult2 = typeAndNameCompareResult;
                int j = 0;
                while (true) {
                    List<ValueParameterDescriptor> c1ValueParameters2 = c1ValueParameters;
                    if (j < c1Bounds.size()) {
                        List<ValueParameterDescriptor> c2ValueParameters2 = c2ValueParameters;
                        String b1 = RENDERER.renderType(c1Bounds.get(j));
                        ReceiverParameterDescriptor c1ReceiverParameter2 = c1ReceiverParameter;
                        String b2 = RENDERER.renderType(c2Bounds.get(j));
                        int boundCompareTo = b1.compareTo(b2);
                        if (boundCompareTo == 0) {
                            j++;
                            c1ValueParameters = c1ValueParameters2;
                            c2ValueParameters = c2ValueParameters2;
                            c1ReceiverParameter = c1ReceiverParameter2;
                        } else {
                            return boundCompareTo;
                        }
                    }
                }
            }
            int typeParametersCompareTo = c1TypeParameters.size() - c2TypeParameters.size();
            if (typeParametersCompareTo != 0) {
                return typeParametersCompareTo;
            }
            if ((c1 instanceof CallableMemberDescriptor) && (c2 instanceof CallableMemberDescriptor)) {
                CallableMemberDescriptor.Kind c1Kind = ((CallableMemberDescriptor) c1).getKind();
                CallableMemberDescriptor.Kind c2Kind = ((CallableMemberDescriptor) c2).getKind();
                int kindsCompareTo = c1Kind.ordinal() - c2Kind.ordinal();
                if (kindsCompareTo != 0) {
                    return kindsCompareTo;
                }
            }
        } else if ((o1 instanceof ClassDescriptor) && (o2 instanceof ClassDescriptor)) {
            ClassDescriptor class1 = (ClassDescriptor) o1;
            ClassDescriptor class2 = (ClassDescriptor) o2;
            if (class1.getKind().ordinal() != class2.getKind().ordinal()) {
                return class1.getKind().ordinal() - class2.getKind().ordinal();
            }
            if (class1.isCompanionObject() != class2.isCompanionObject()) {
                return class1.isCompanionObject() ? 1 : -1;
            }
        } else {
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", o1, o1.getClass(), o2, o2.getClass()));
        }
        int renderDiff = RENDERER.render(o1).compareTo(RENDERER.render(o2));
        if (renderDiff != 0) {
            return renderDiff;
        }
        Name firstModuleName = DescriptorUtils.getContainingModule(o1).getName();
        Name secondModuleName = DescriptorUtils.getContainingModule(o2).getName();
        return firstModuleName.compareTo(secondModuleName);
    }
}