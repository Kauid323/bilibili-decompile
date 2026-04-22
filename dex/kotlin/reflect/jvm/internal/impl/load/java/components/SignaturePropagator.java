package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = new SignaturePropagator() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.1
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            switch (i) {
                case 5:
                case 6:
                    objArr[2] = "reportSignatureErrors";
                    break;
                default:
                    objArr[2] = "resolvePropagatedSignature";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
        public PropagatedSignature resolvePropagatedSignature(JavaMethod method, ClassDescriptor owner, KotlinType returnType, KotlinType receiverType, List<ValueParameterDescriptor> valueParameters, List<TypeParameterDescriptor> typeParameters) {
            if (method == null) {
                $$$reportNull$$$0(0);
            }
            if (owner == null) {
                $$$reportNull$$$0(1);
            }
            if (returnType == null) {
                $$$reportNull$$$0(2);
            }
            if (valueParameters == null) {
                $$$reportNull$$$0(3);
            }
            if (typeParameters == null) {
                $$$reportNull$$$0(4);
            }
            return new PropagatedSignature(returnType, receiverType, valueParameters, typeParameters, Collections.emptyList(), false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
        public void reportSignatureErrors(CallableMemberDescriptor descriptor, List<String> signatureErrors) {
            if (descriptor == null) {
                $$$reportNull$$$0(5);
            }
            if (signatureErrors == null) {
                $$$reportNull$$$0(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }
    };

    void reportSignatureErrors(CallableMemberDescriptor callableMemberDescriptor, List<String> list);

    PropagatedSignature resolvePropagatedSignature(JavaMethod javaMethod, ClassDescriptor classDescriptor, KotlinType kotlinType, KotlinType kotlinType2, List<ValueParameterDescriptor> list, List<TypeParameterDescriptor> list2);

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class PropagatedSignature {
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<String> signatureErrors;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            switch (i) {
                case 4:
                    objArr[1] = "getReturnType";
                    break;
                case 5:
                    objArr[1] = "getValueParameters";
                    break;
                case 6:
                    objArr[1] = "getTypeParameters";
                    break;
                case 7:
                    objArr[1] = "getErrors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
            }
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public PropagatedSignature(KotlinType returnType, KotlinType receiverType, List<ValueParameterDescriptor> valueParameters, List<TypeParameterDescriptor> typeParameters, List<String> signatureErrors, boolean hasStableParameterNames) {
            if (returnType == null) {
                $$$reportNull$$$0(0);
            }
            if (valueParameters == null) {
                $$$reportNull$$$0(1);
            }
            if (typeParameters == null) {
                $$$reportNull$$$0(2);
            }
            if (signatureErrors == null) {
                $$$reportNull$$$0(3);
            }
            this.returnType = returnType;
            this.receiverType = receiverType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters;
            this.signatureErrors = signatureErrors;
            this.hasStableParameterNames = hasStableParameterNames;
        }

        public KotlinType getReturnType() {
            KotlinType kotlinType = this.returnType;
            if (kotlinType == null) {
                $$$reportNull$$$0(4);
            }
            return kotlinType;
        }

        public KotlinType getReceiverType() {
            return this.receiverType;
        }

        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> list = this.valueParameters;
            if (list == null) {
                $$$reportNull$$$0(5);
            }
            return list;
        }

        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> list = this.typeParameters;
            if (list == null) {
                $$$reportNull$$$0(6);
            }
            return list;
        }

        public boolean hasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public List<String> getErrors() {
            List<String> list = this.signatureErrors;
            if (list == null) {
                $$$reportNull$$$0(7);
            }
            return list;
        }
    }
}