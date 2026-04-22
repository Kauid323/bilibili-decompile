package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: ErasedOverridabilityCondition.kt */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* compiled from: ErasedOverridabilityCondition.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            try {
                iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor) {
        Sequence $this$any$iv;
        CallableDescriptor erasedSuper;
        KotlinType it;
        Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof JavaMethodDescriptor) {
            List<TypeParameterDescriptor> typeParameters = ((JavaMethodDescriptor) subDescriptor).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            if (typeParameters.isEmpty()) {
                OverridingUtil.OverrideCompatibilityInfo basicOverridabilityProblem = OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor);
                OverridingUtil.OverrideCompatibilityInfo.Result basicOverridability = basicOverridabilityProblem != null ? basicOverridabilityProblem.getResult() : null;
                if (basicOverridability != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<ValueParameterDescriptor> valueParameters = ((JavaMethodDescriptor) subDescriptor).getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                Sequence map = SequencesKt.map(CollectionsKt.asSequence(valueParameters), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition$$Lambda$0
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        KotlinType type;
                        type = ((ValueParameterDescriptor) obj).getType();
                        return type;
                    }
                });
                KotlinType returnType = ((JavaMethodDescriptor) subDescriptor).getReturnType();
                Intrinsics.checkNotNull(returnType);
                Sequence plus = SequencesKt.plus(map, returnType);
                ReceiverParameterDescriptor extensionReceiverParameter = ((JavaMethodDescriptor) subDescriptor).getExtensionReceiverParameter();
                Sequence signatureTypes = SequencesKt.plus(plus, (Iterable) CollectionsKt.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null));
                Iterator it2 = signatureTypes.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        KotlinType it3 = (KotlinType) element$iv;
                        if (it3.getArguments().isEmpty() || (it3.unwrap() instanceof RawTypeImpl)) {
                            it = null;
                            continue;
                        } else {
                            it = 1;
                            continue;
                        }
                        if (it != null) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
                if ($this$any$iv == null && (erasedSuper = superDescriptor.substitute(new RawSubstitution(null, 1, null).buildSubstitutor())) != null) {
                    if (erasedSuper instanceof SimpleFunctionDescriptor) {
                        List<TypeParameterDescriptor> typeParameters2 = ((SimpleFunctionDescriptor) erasedSuper).getTypeParameters();
                        Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
                        if (!typeParameters2.isEmpty()) {
                            CallableDescriptor erasedSuper2 = ((SimpleFunctionDescriptor) erasedSuper).newCopyBuilder().setTypeParameters(CollectionsKt.emptyList()).build();
                            Intrinsics.checkNotNull(erasedSuper2);
                            erasedSuper = erasedSuper2;
                        }
                    }
                    OverridingUtil.OverrideCompatibilityInfo.Result overridabilityResult = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).getResult();
                    Intrinsics.checkNotNullExpressionValue(overridabilityResult, "getResult(...)");
                    return WhenMappings.$EnumSwitchMapping$0[overridabilityResult.ordinal()] == 1 ? ExternalOverridabilityCondition.Result.OVERRIDABLE : ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }
}