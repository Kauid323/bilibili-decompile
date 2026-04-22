package kotlin.reflect.jvm.internal.impl.resolve;

import com.bilibili.infra.base.aop.OverridingUtilSLHook;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.codec.binary.BaseNCodec;
import org.java_websocket.WebSocketImpl;
import org.webrtc.H265Utils;

public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = __Ghost$Insertion$com_bilibili_infra_base_aop_OverridingUtilSLHook_toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.1
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "b";
                    break;
                default:
                    objArr[0] = "a";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
        public boolean equals(TypeConstructor a, TypeConstructor b) {
            if (a == null) {
                $$$reportNull$$$0(0);
            }
            if (b == null) {
                $$$reportNull$$$0(1);
            }
            return a.equals(b);
        }
    };
    public static final OverridingUtil DEFAULT = new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 11:
            case additional_type_content_opus_VALUE:
            case 16:
            case 21:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 82:
            case 88:
            case 89:
            case H265Utils.kLevel3 /* 90 */:
            case H265Utils.kLevel3_1 /* 93 */:
            case 96:
            case 101:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 11:
            case additional_type_content_opus_VALUE:
            case 16:
            case 21:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 82:
            case 88:
            case 89:
            case H265Utils.kLevel3 /* 90 */:
            case H265Utils.kLevel3_1 /* 93 */:
            case 96:
            case 101:
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
                objArr[0] = "kotlinTypePreparator";
                break;
            case 2:
                objArr[0] = "customSubtype";
                break;
            case 3:
            case 6:
            default:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 4:
                objArr[0] = "equalityAxioms";
                break;
            case 5:
                objArr[0] = "axioms";
                break;
            case 8:
            case 9:
                objArr[0] = "candidateSet";
                break;
            case 10:
                objArr[0] = "transformFirst";
                break;
            case 11:
            case additional_type_content_opus_VALUE:
            case 16:
            case 21:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 82:
            case 88:
            case 89:
            case H265Utils.kLevel3 /* 90 */:
            case H265Utils.kLevel3_1 /* 93 */:
            case 96:
            case 101:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case additional_type_content_video_VALUE:
                objArr[0] = "f";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "g";
                break;
            case 15:
            case 17:
                objArr[0] = "descriptor";
                break;
            case 18:
                objArr[0] = "result";
                break;
            case 19:
            case 22:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 20:
            case 23:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
                objArr[0] = "firstParameters";
                break;
            case 41:
                objArr[0] = "secondParameters";
                break;
            case 44:
                objArr[0] = "typeInSuper";
                break;
            case 45:
                objArr[0] = "typeInSub";
                break;
            case 46:
            case 49:
            case 75:
                objArr[0] = "typeCheckerState";
                break;
            case 47:
                objArr[0] = "superTypeParameter";
                break;
            case 48:
                objArr[0] = "subTypeParameter";
                break;
            case 50:
                objArr[0] = "name";
                break;
            case 51:
                objArr[0] = "membersFromSupertypes";
                break;
            case 52:
                objArr[0] = "membersFromCurrent";
                break;
            case 53:
            case 59:
            case 62:
            case 84:
            case 87:
            case 94:
                objArr[0] = "current";
                break;
            case 54:
            case 60:
            case 64:
            case 85:
            case 104:
                objArr[0] = "strategy";
                break;
            case 55:
                objArr[0] = "overriding";
                break;
            case 56:
                objArr[0] = "fromSuper";
                break;
            case 57:
                objArr[0] = "fromCurrent";
                break;
            case 58:
                objArr[0] = "descriptorsFromSuper";
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case H265Utils.kLevel2_1 /* 63 */:
                objArr[0] = "notOverridden";
                break;
            case 65:
            case 67:
            case 71:
                objArr[0] = "a";
                break;
            case 66:
            case 68:
            case 73:
                objArr[0] = "b";
                break;
            case 69:
                objArr[0] = "candidate";
                break;
            case 70:
            case 86:
            case 91:
            case 107:
                objArr[0] = "descriptors";
                break;
            case 72:
                objArr[0] = "aReturnType";
                break;
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
                objArr[0] = "bReturnType";
                break;
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 83:
                objArr[0] = "overridables";
                break;
            case 77:
            case 99:
                objArr[0] = "descriptorByHandle";
                break;
            case 92:
                objArr[0] = "classModality";
                break;
            case 95:
                objArr[0] = "toFilter";
                break;
            case 97:
            case 102:
                objArr[0] = "overrider";
                break;
            case 98:
            case 103:
                objArr[0] = "extractFrom";
                break;
            case 100:
                objArr[0] = "onConflict";
                break;
            case 105:
            case 106:
                objArr[0] = "memberDescriptor";
                break;
        }
        switch (i) {
            case 11:
            case additional_type_content_opus_VALUE:
                objArr[1] = "filterOverrides";
                break;
            case 16:
                objArr[1] = "getOverriddenDeclarations";
                break;
            case 21:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
                objArr[1] = "isOverridableBy";
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                objArr[1] = "isOverridableByWithoutExternalConditions";
                break;
            case 42:
            case 43:
                objArr[1] = "createTypeCheckerState";
                break;
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 82:
                objArr[1] = "selectMostSpecificMember";
                break;
            case 88:
            case 89:
            case H265Utils.kLevel3 /* 90 */:
                objArr[1] = "determineModalityForFakeOverride";
                break;
            case H265Utils.kLevel3_1 /* 93 */:
                objArr[1] = "getMinimalModality";
                break;
            case 96:
                objArr[1] = "filterVisibleFakeOverrides";
                break;
            case 101:
                objArr[1] = "extractMembersOverridableInBothWays";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                objArr[2] = "createWithTypePreparatorAndCustomSubtype";
                break;
            case 3:
            case 4:
                objArr[2] = "create";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "<init>";
                break;
            case 8:
                objArr[2] = "filterOutOverridden";
                break;
            case 9:
            case 10:
                objArr[2] = "filterOverrides";
                break;
            case 11:
            case additional_type_content_opus_VALUE:
            case 16:
            case 21:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 82:
            case 88:
            case 89:
            case H265Utils.kLevel3 /* 90 */:
            case H265Utils.kLevel3_1 /* 93 */:
            case 96:
            case 101:
                break;
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
                objArr[2] = "overrides";
                break;
            case 15:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 17:
            case 18:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 19:
            case 20:
            case 22:
            case 23:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeCheckerState";
                break;
            case 44:
            case 45:
            case 46:
                objArr[2] = "areTypesEquivalent";
                break;
            case 47:
            case 48:
            case 49:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 55:
            case 56:
                objArr[2] = "isVisibleForOverride";
                break;
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 62:
            case H265Utils.kLevel2_1 /* 63 */:
            case 64:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 65:
            case 66:
                objArr[2] = "isMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 71:
            case 72:
            case 73:
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
            case 75:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
            case 77:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 83:
            case 84:
            case 85:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 86:
            case 87:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 91:
            case 92:
                objArr[2] = "getMinimalModality";
                break;
            case 94:
            case 95:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
            case 102:
            case 103:
            case 104:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 105:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 106:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 107:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithTypeRefiner";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 11:
            case additional_type_content_opus_VALUE:
            case 16:
            case 21:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 82:
            case 88:
            case 89:
            case H265Utils.kLevel3 /* 90 */:
            case H265Utils.kLevel3_1 /* 93 */:
            case 96:
            case 101:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private static List __Ghost$Insertion$com_bilibili_infra_base_aop_OverridingUtilSLHook_toList(Iterable iterable) {
        if (iterable instanceof ServiceLoader) {
            ServiceLoader serviceLoader = (ServiceLoader) iterable;
            List result = new ArrayList();
            try {
                result.add(Class.forName("kotlin.reflect.jvm.internal.impl.load.java.FieldOverridabilityCondition", true, OverridingUtilSLHook.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                result.add(Class.forName("kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition", true, OverridingUtilSLHook.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                result.add(Class.forName("kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition", true, OverridingUtilSLHook.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                return result;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return CollectionsKt.toList(iterable);
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(0);
        }
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    public static OverridingUtil create(KotlinTypeRefiner kotlinTypeRefiner, KotlinTypeChecker.TypeConstructorEquality equalityAxioms) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(3);
        }
        if (equalityAxioms == null) {
            $$$reportNull$$$0(4);
        }
        return new OverridingUtil(equalityAxioms, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality axioms, KotlinTypeRefiner kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator, Function2<KotlinType, KotlinType, Boolean> customSubtype) {
        if (axioms == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        if (kotlinTypePreparator == null) {
            $$$reportNull$$$0(7);
        }
        this.equalityAxioms = axioms;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.customSubtype = customSubtype;
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> candidateSet) {
        if (candidateSet == null) {
            $$$reportNull$$$0(8);
        }
        boolean allowDescriptorCopies = !candidateSet.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(candidateSet.iterator().next()));
        return filterOverrides(candidateSet, allowDescriptorCopies, null, new Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.2
            /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;>; */
            @Override // kotlin.jvm.functions.Function2
            public Pair invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
                return new Pair(callableDescriptor, callableDescriptor2);
            }
        });
    }

    public static <D> Set<D> filterOverrides(Set<D> candidateSet, boolean allowDescriptorCopies, Function0<?> cancellationCallback, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> transformFirst) {
        if (candidateSet == null) {
            $$$reportNull$$$0(9);
        }
        if (transformFirst == null) {
            $$$reportNull$$$0(10);
        }
        if (candidateSet.size() <= 1) {
            if (candidateSet == null) {
                $$$reportNull$$$0(11);
            }
            return candidateSet;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : candidateSet) {
            if (cancellationCallback != null) {
                cancellationCallback.invoke();
            }
            Iterator<D> iterator = linkedHashSet.iterator();
            while (true) {
                if (iterator.hasNext()) {
                    Pair<CallableDescriptor, CallableDescriptor> meAndOther = transformFirst.invoke(obj, (Object) iterator.next());
                    CallableDescriptor me2 = (CallableDescriptor) meAndOther.component1();
                    CallableDescriptor other = (CallableDescriptor) meAndOther.component2();
                    if (overrides(me2, other, allowDescriptorCopies, true)) {
                        iterator.remove();
                    } else if (overrides(other, me2, allowDescriptorCopies, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        if (linkedHashSet.isEmpty()) {
            throw new AssertionError("All candidates filtered out from " + candidateSet);
        }
        return linkedHashSet;
    }

    public static <D extends CallableDescriptor> boolean overrides(D f, D g, boolean allowDeclarationCopies, boolean distinguishExpectsAndNonExpects) {
        if (f == null) {
            $$$reportNull$$$0(13);
        }
        if (g == null) {
            $$$reportNull$$$0(14);
        }
        if (f.equals(g) || !DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(f.getOriginal(), g.getOriginal(), allowDeclarationCopies, distinguishExpectsAndNonExpects)) {
            CallableDescriptor originalG = g.getOriginal();
            for (CallableDescriptor callableDescriptor : DescriptorUtils.getAllOverriddenDescriptors(f)) {
                if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(originalG, callableDescriptor, allowDeclarationCopies, distinguishExpectsAndNonExpects)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(15);
        }
        Set<CallableMemberDescriptor> result = new LinkedHashSet<>();
        collectOverriddenDeclarations(descriptor, result);
        return result;
    }

    private static void collectOverriddenDeclarations(CallableMemberDescriptor descriptor, Set<CallableMemberDescriptor> result) {
        if (descriptor == null) {
            $$$reportNull$$$0(17);
        }
        if (result == null) {
            $$$reportNull$$$0(18);
        }
        if (descriptor.getKind().isReal()) {
            result.add(descriptor);
        } else if (descriptor.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + descriptor);
        } else {
            for (CallableMemberDescriptor overridden : descriptor.getOverriddenDescriptors()) {
                collectOverriddenDeclarations(overridden, result);
            }
        }
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor) {
        if (superDescriptor == null) {
            $$$reportNull$$$0(19);
        }
        if (subDescriptor == null) {
            $$$reportNull$$$0(20);
        }
        OverrideCompatibilityInfo isOverridableBy = isOverridableBy(superDescriptor, subDescriptor, subClassDescriptor, false);
        if (isOverridableBy == null) {
            $$$reportNull$$$0(21);
        }
        return isOverridableBy;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor, boolean checkReturnType) {
        if (superDescriptor == null) {
            $$$reportNull$$$0(22);
        }
        if (subDescriptor == null) {
            $$$reportNull$$$0(23);
        }
        OverrideCompatibilityInfo basicResult = isOverridableByWithoutExternalConditions(superDescriptor, subDescriptor, checkReturnType);
        boolean wasSuccess = basicResult.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalCondition : EXTERNAL_CONDITIONS) {
            if (externalCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!wasSuccess || externalCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                ExternalOverridabilityCondition.Result result = externalCondition.isOverridable(superDescriptor, subDescriptor, subClassDescriptor);
                switch (result) {
                    case OVERRIDABLE:
                        wasSuccess = true;
                        continue;
                    case INCOMPATIBLE:
                        OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("External condition");
                        if (incompatible == null) {
                            $$$reportNull$$$0(24);
                        }
                        return incompatible;
                }
            }
        }
        if (!wasSuccess) {
            if (basicResult == null) {
                $$$reportNull$$$0(25);
            }
            return basicResult;
        }
        for (ExternalOverridabilityCondition externalCondition2 : EXTERNAL_CONDITIONS) {
            if (externalCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                ExternalOverridabilityCondition.Result result2 = externalCondition2.isOverridable(superDescriptor, subDescriptor, subClassDescriptor);
                switch (result2) {
                    case OVERRIDABLE:
                        throw new IllegalStateException("Contract violation in " + externalCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                    case INCOMPATIBLE:
                        OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("External condition");
                        if (incompatible2 == null) {
                            $$$reportNull$$$0(26);
                        }
                        return incompatible2;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(27);
        }
        return success;
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, boolean checkReturnType) {
        if (superDescriptor == null) {
            $$$reportNull$$$0(28);
        }
        if (subDescriptor == null) {
            $$$reportNull$$$0(29);
        }
        OverrideCompatibilityInfo basicOverridability = getBasicOverridabilityProblem(superDescriptor, subDescriptor);
        if (basicOverridability != null) {
            if (basicOverridability == null) {
                $$$reportNull$$$0(30);
            }
            return basicOverridability;
        }
        List<KotlinType> superValueParameters = compiledValueParameters(superDescriptor);
        List<KotlinType> subValueParameters = compiledValueParameters(subDescriptor);
        List<TypeParameterDescriptor> superTypeParameters = superDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> subTypeParameters = subDescriptor.getTypeParameters();
        if (superTypeParameters.size() != subTypeParameters.size()) {
            for (int i = 0; i < superValueParameters.size(); i++) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(superValueParameters.get(i), subValueParameters.get(i))) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                    if (incompatible == null) {
                        $$$reportNull$$$0(31);
                    }
                    return incompatible;
                }
            }
            OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (conflict == null) {
                $$$reportNull$$$0(32);
            }
            return conflict;
        }
        TypeCheckerState typeCheckerState = createTypeCheckerState(superTypeParameters, subTypeParameters);
        for (int i2 = 0; i2 < superTypeParameters.size(); i2++) {
            if (!areTypeParametersEquivalent(superTypeParameters.get(i2), subTypeParameters.get(i2), typeCheckerState)) {
                OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
                if (incompatible2 == null) {
                    $$$reportNull$$$0(33);
                }
                return incompatible2;
            }
        }
        for (int i3 = 0; i3 < superValueParameters.size(); i3++) {
            if (!areTypesEquivalent(superValueParameters.get(i3), subValueParameters.get(i3), typeCheckerState)) {
                OverrideCompatibilityInfo incompatible3 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
                if (incompatible3 == null) {
                    $$$reportNull$$$0(34);
                }
                return incompatible3;
            }
        }
        if ((superDescriptor instanceof FunctionDescriptor) && (subDescriptor instanceof FunctionDescriptor) && ((FunctionDescriptor) superDescriptor).isSuspend() != ((FunctionDescriptor) subDescriptor).isSuspend()) {
            OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (conflict2 == null) {
                $$$reportNull$$$0(35);
            }
            return conflict2;
        }
        if (checkReturnType) {
            KotlinType superReturnType = superDescriptor.getReturnType();
            KotlinType subReturnType = subDescriptor.getReturnType();
            if (superReturnType != null && subReturnType != null) {
                boolean bothErrors = KotlinTypeKt.isError(subReturnType) && KotlinTypeKt.isError(superReturnType);
                if (!bothErrors && !AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, subReturnType.unwrap(), superReturnType.unwrap())) {
                    OverrideCompatibilityInfo conflict3 = OverrideCompatibilityInfo.conflict("Return type mismatch");
                    if (conflict3 == null) {
                        $$$reportNull$$$0(36);
                    }
                    return conflict3;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(37);
        }
        return success;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor) {
        if (superDescriptor == null) {
            $$$reportNull$$$0(38);
        }
        if (subDescriptor == null) {
            $$$reportNull$$$0(39);
        }
        if (((superDescriptor instanceof FunctionDescriptor) && !(subDescriptor instanceof FunctionDescriptor)) || ((superDescriptor instanceof PropertyDescriptor) && !(subDescriptor instanceof PropertyDescriptor))) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!(superDescriptor instanceof FunctionDescriptor) && !(superDescriptor instanceof PropertyDescriptor)) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + superDescriptor);
        }
        if (!superDescriptor.getName().equals(subDescriptor.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        }
        OverrideCompatibilityInfo receiverAndParameterResult = checkReceiverAndParameterCount(superDescriptor, subDescriptor);
        if (receiverAndParameterResult != null) {
            return receiverAndParameterResult;
        }
        return null;
    }

    private TypeCheckerState createTypeCheckerState(List<TypeParameterDescriptor> firstParameters, List<TypeParameterDescriptor> secondParameters) {
        if (firstParameters == null) {
            $$$reportNull$$$0(40);
        }
        if (secondParameters == null) {
            $$$reportNull$$$0(41);
        }
        if (firstParameters.size() != secondParameters.size()) {
            throw new AssertionError("Should be the same number of type parameters: " + firstParameters + " vs " + secondParameters);
        }
        if (firstParameters.isEmpty()) {
            TypeCheckerState newTypeCheckerState = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true, false);
            if (newTypeCheckerState == null) {
                $$$reportNull$$$0(42);
            }
            return newTypeCheckerState;
        }
        Map<TypeConstructor, TypeConstructor> matchingTypeConstructors = new HashMap<>();
        for (int i = 0; i < firstParameters.size(); i++) {
            matchingTypeConstructors.put(firstParameters.get(i).getTypeConstructor(), secondParameters.get(i).getTypeConstructor());
        }
        TypeCheckerState newTypeCheckerState2 = new OverridingUtilTypeSystemContext(matchingTypeConstructors, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true, false);
        if (newTypeCheckerState2 == null) {
            $$$reportNull$$$0(43);
        }
        return newTypeCheckerState2;
    }

    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor) {
        if ((superDescriptor.getExtensionReceiverParameter() == null) != (subDescriptor.getExtensionReceiverParameter() == null)) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (superDescriptor.getValueParameters().size() != subDescriptor.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private static boolean areTypesEquivalent(KotlinType typeInSuper, KotlinType typeInSub, TypeCheckerState typeCheckerState) {
        if (typeInSuper == null) {
            $$$reportNull$$$0(44);
        }
        if (typeInSub == null) {
            $$$reportNull$$$0(45);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(46);
        }
        boolean bothErrors = KotlinTypeKt.isError(typeInSuper) && KotlinTypeKt.isError(typeInSub);
        if (bothErrors) {
            return true;
        }
        return AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, typeInSuper.unwrap(), typeInSub.unwrap());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        r5.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean areTypeParametersEquivalent(TypeParameterDescriptor superTypeParameter, TypeParameterDescriptor subTypeParameter, TypeCheckerState typeCheckerState) {
        if (superTypeParameter == null) {
            $$$reportNull$$$0(47);
        }
        if (subTypeParameter == null) {
            $$$reportNull$$$0(48);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(49);
        }
        List<KotlinType> superBounds = superTypeParameter.getUpperBounds();
        List<KotlinType> subBounds = new ArrayList<>(subTypeParameter.getUpperBounds());
        if (superBounds.size() != subBounds.size()) {
            return false;
        }
        for (KotlinType superBound : superBounds) {
            ListIterator<KotlinType> it = subBounds.listIterator();
            while (it.hasNext()) {
                KotlinType subBound = it.next();
                if (areTypesEquivalent(superBound, subBound, typeCheckerState)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor receiverParameter = callableDescriptor.getExtensionReceiverParameter();
        List<KotlinType> parameters = new ArrayList<>();
        if (receiverParameter != null) {
            parameters.add(receiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            parameters.add(valueParameterDescriptor.getType());
        }
        return parameters;
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> membersFromSupertypes, Collection<? extends CallableMemberDescriptor> membersFromCurrent, ClassDescriptor current, OverridingStrategy strategy) {
        if (name == null) {
            $$$reportNull$$$0(50);
        }
        if (membersFromSupertypes == null) {
            $$$reportNull$$$0(51);
        }
        if (membersFromCurrent == null) {
            $$$reportNull$$$0(52);
        }
        if (current == null) {
            $$$reportNull$$$0(53);
        }
        if (strategy == null) {
            $$$reportNull$$$0(54);
        }
        Collection<CallableMemberDescriptor> notOverridden = new LinkedHashSet<>(membersFromSupertypes);
        for (CallableMemberDescriptor fromCurrent : membersFromCurrent) {
            Collection<CallableMemberDescriptor> bound = extractAndBindOverridesForMember(fromCurrent, membersFromSupertypes, current, strategy);
            notOverridden.removeAll(bound);
        }
        createAndBindFakeOverrides(current, notOverridden, strategy);
    }

    public static boolean isVisibleForOverride(MemberDescriptor overriding, MemberDescriptor fromSuper, boolean useSpecialRulesForPrivateSealedConstructors) {
        if (overriding == null) {
            $$$reportNull$$$0(55);
        }
        if (fromSuper == null) {
            $$$reportNull$$$0(56);
        }
        return !DescriptorVisibilities.isPrivate(fromSuper.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(fromSuper, overriding, useSpecialRulesForPrivateSealedConstructors);
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor fromCurrent, Collection<? extends CallableMemberDescriptor> descriptorsFromSuper, ClassDescriptor current, OverridingStrategy strategy) {
        if (fromCurrent == null) {
            $$$reportNull$$$0(57);
        }
        if (descriptorsFromSuper == null) {
            $$$reportNull$$$0(58);
        }
        if (current == null) {
            $$$reportNull$$$0(59);
        }
        if (strategy == null) {
            $$$reportNull$$$0(60);
        }
        Collection<CallableMemberDescriptor> bound = new ArrayList<>(descriptorsFromSuper.size());
        Collection<CallableMemberDescriptor> overridden = SmartSet.create();
        for (CallableMemberDescriptor fromSupertype : descriptorsFromSuper) {
            OverrideCompatibilityInfo.Result result = isOverridableBy(fromSupertype, fromCurrent, current).getResult();
            boolean isVisibleForOverride = isVisibleForOverride(fromCurrent, fromSupertype, false);
            switch (result) {
                case OVERRIDABLE:
                    if (isVisibleForOverride) {
                        overridden.add(fromSupertype);
                    }
                    bound.add(fromSupertype);
                    break;
                case CONFLICT:
                    if (isVisibleForOverride) {
                        strategy.overrideConflict(fromSupertype, fromCurrent);
                    }
                    bound.add(fromSupertype);
                    break;
            }
        }
        strategy.setOverriddenDescriptors(fromCurrent, overridden);
        return bound;
    }

    private static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> notOverridden) {
        if (notOverridden == null) {
            $$$reportNull$$$0(61);
        }
        if (notOverridden.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = notOverridden.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(notOverridden, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.3
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor descriptor) {
                return Boolean.valueOf(descriptor.getContainingDeclaration() == DeclarationDescriptor.this);
            }
        });
    }

    private static void createAndBindFakeOverrides(ClassDescriptor current, Collection<CallableMemberDescriptor> notOverridden, OverridingStrategy strategy) {
        if (current == null) {
            $$$reportNull$$$0(62);
        }
        if (notOverridden == null) {
            $$$reportNull$$$0(63);
        }
        if (strategy == null) {
            $$$reportNull$$$0(64);
        }
        if (allHasSameContainingDeclaration(notOverridden)) {
            for (CallableMemberDescriptor descriptor : notOverridden) {
                createAndBindFakeOverride(Collections.singleton(descriptor), current, strategy);
            }
            return;
        }
        Queue<CallableMemberDescriptor> fromSuperQueue = new LinkedList<>(notOverridden);
        while (!fromSuperQueue.isEmpty()) {
            CallableMemberDescriptor notOverriddenFromSuper = VisibilityUtilKt.findMemberWithMaxVisibility(fromSuperQueue);
            Collection<CallableMemberDescriptor> overridables = extractMembersOverridableInBothWays(notOverriddenFromSuper, fromSuperQueue, strategy);
            createAndBindFakeOverride(overridables, current, strategy);
        }
    }

    public static boolean isMoreSpecific(CallableDescriptor a, CallableDescriptor b) {
        if (a == null) {
            $$$reportNull$$$0(65);
        }
        if (b == null) {
            $$$reportNull$$$0(66);
        }
        KotlinType aReturnType = a.getReturnType();
        KotlinType bReturnType = b.getReturnType();
        if (aReturnType == null) {
            throw new AssertionError("Return type of " + a + " is null");
        }
        if (bReturnType == null) {
            throw new AssertionError("Return type of " + b + " is null");
        }
        if (isVisibilityMoreSpecific(a, b)) {
            TypeCheckerState checkerState = DEFAULT.createTypeCheckerState(a.getTypeParameters(), b.getTypeParameters());
            if (a instanceof FunctionDescriptor) {
                if (!(b instanceof FunctionDescriptor)) {
                    throw new AssertionError("b is " + b.getClass());
                }
                return isReturnTypeMoreSpecific(a, aReturnType, b, bReturnType, checkerState);
            } else if (a instanceof PropertyDescriptor) {
                if (!(b instanceof PropertyDescriptor)) {
                    throw new AssertionError("b is " + b.getClass());
                }
                PropertyDescriptor pa = (PropertyDescriptor) a;
                PropertyDescriptor pb = (PropertyDescriptor) b;
                if (isAccessorMoreSpecific(pa.getSetter(), pb.getSetter())) {
                    if (pa.isVar() && pb.isVar()) {
                        return AbstractTypeChecker.INSTANCE.equalTypes(checkerState, aReturnType.unwrap(), bReturnType.unwrap());
                    }
                    return (pa.isVar() || !pb.isVar()) && isReturnTypeMoreSpecific(a, aReturnType, b, bReturnType, checkerState);
                }
                return false;
            } else {
                throw new IllegalArgumentException("Unexpected callable: " + a.getClass());
            }
        }
        return false;
    }

    private static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility a, DeclarationDescriptorWithVisibility b) {
        if (a == null) {
            $$$reportNull$$$0(67);
        }
        if (b == null) {
            $$$reportNull$$$0(68);
        }
        Integer result = DescriptorVisibilities.compare(a.getVisibility(), b.getVisibility());
        return result == null || result.intValue() >= 0;
    }

    private static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor a, PropertyAccessorDescriptor b) {
        if (a == null || b == null) {
            return true;
        }
        return isVisibilityMoreSpecific(a, b);
    }

    private static boolean isMoreSpecificThenAllOf(CallableDescriptor candidate, Collection<CallableDescriptor> descriptors) {
        if (candidate == null) {
            $$$reportNull$$$0(69);
        }
        if (descriptors == null) {
            $$$reportNull$$$0(70);
        }
        for (CallableDescriptor descriptor : descriptors) {
            if (!isMoreSpecific(candidate, descriptor)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(CallableDescriptor a, KotlinType aReturnType, CallableDescriptor b, KotlinType bReturnType, TypeCheckerState typeCheckerState) {
        if (a == null) {
            $$$reportNull$$$0(71);
        }
        if (aReturnType == null) {
            $$$reportNull$$$0(72);
        }
        if (b == null) {
            $$$reportNull$$$0(73);
        }
        if (bReturnType == null) {
            $$$reportNull$$$0(74);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(75);
        }
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, aReturnType.unwrap(), bReturnType.unwrap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <H> H selectMostSpecificMember(Collection<H> overridables, Function1<H, CallableDescriptor> descriptorByHandle) {
        if (overridables == null) {
            $$$reportNull$$$0(76);
        }
        if (descriptorByHandle == 0) {
            $$$reportNull$$$0(77);
        }
        if (overridables.isEmpty()) {
            throw new AssertionError("Should have at least one overridable descriptor");
        }
        if (overridables.size() == 1) {
            H h = (H) CollectionsKt.first(overridables);
            if (h == null) {
                $$$reportNull$$$0(78);
            }
            return h;
        }
        Collection<H> candidates = new ArrayList<>(2);
        List<CallableDescriptor> callableMemberDescriptors = CollectionsKt.map(overridables, descriptorByHandle);
        H transitivelyMostSpecific = (H) CollectionsKt.first(overridables);
        CallableDescriptor transitivelyMostSpecificDescriptor = (CallableDescriptor) descriptorByHandle.invoke(transitivelyMostSpecific);
        for (H overridable : overridables) {
            CallableDescriptor descriptor = (CallableDescriptor) descriptorByHandle.invoke(overridable);
            if (isMoreSpecificThenAllOf(descriptor, callableMemberDescriptors)) {
                candidates.add(overridable);
            }
            if (isMoreSpecific(descriptor, transitivelyMostSpecificDescriptor) && !isMoreSpecific(transitivelyMostSpecificDescriptor, descriptor)) {
                transitivelyMostSpecific = overridable;
            }
        }
        if (candidates.isEmpty()) {
            if (transitivelyMostSpecific == null) {
                $$$reportNull$$$0(79);
            }
            return transitivelyMostSpecific;
        } else if (candidates.size() == 1) {
            H h2 = (H) CollectionsKt.first(candidates);
            if (h2 == null) {
                $$$reportNull$$$0(80);
            }
            return h2;
        } else {
            H firstNonFlexible = null;
            Iterator<H> it = candidates.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                H candidate = it.next();
                if (!FlexibleTypesKt.isFlexible(((CallableDescriptor) descriptorByHandle.invoke(candidate)).getReturnType())) {
                    firstNonFlexible = candidate;
                    break;
                }
            }
            if (firstNonFlexible != null) {
                if (firstNonFlexible == null) {
                    $$$reportNull$$$0(81);
                }
                return firstNonFlexible;
            }
            H h3 = (H) CollectionsKt.first(candidates);
            if (h3 == null) {
                $$$reportNull$$$0(82);
            }
            return h3;
        }
    }

    private static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> overridables, ClassDescriptor current, OverridingStrategy strategy) {
        if (overridables == null) {
            $$$reportNull$$$0(83);
        }
        if (current == null) {
            $$$reportNull$$$0(84);
        }
        if (strategy == null) {
            $$$reportNull$$$0(85);
        }
        Collection<CallableMemberDescriptor> visibleOverridables = filterVisibleFakeOverrides(current, overridables);
        boolean allInvisible = visibleOverridables.isEmpty();
        Collection<CallableMemberDescriptor> effectiveOverridden = allInvisible ? overridables : visibleOverridables;
        Modality modality = determineModalityForFakeOverride(effectiveOverridden, current);
        DescriptorVisibility visibility = allInvisible ? DescriptorVisibilities.INVISIBLE_FAKE : DescriptorVisibilities.INHERITED;
        CallableMemberDescriptor mostSpecific = (CallableMemberDescriptor) selectMostSpecificMember(effectiveOverridden, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.4
            @Override // kotlin.jvm.functions.Function1
            public CallableMemberDescriptor invoke(CallableMemberDescriptor descriptor) {
                return descriptor;
            }
        });
        CallableMemberDescriptor fakeOverride = mostSpecific.copy(current, modality, visibility, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        strategy.setOverriddenDescriptors(fakeOverride, effectiveOverridden);
        if (fakeOverride.getOverriddenDescriptors().isEmpty()) {
            throw new AssertionError("Overridden descriptors should be set for " + CallableMemberDescriptor.Kind.FAKE_OVERRIDE);
        }
        strategy.addFakeOverride(fakeOverride);
    }

    private static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> descriptors, ClassDescriptor current) {
        if (descriptors == null) {
            $$$reportNull$$$0(86);
        }
        if (current == null) {
            $$$reportNull$$$0(87);
        }
        boolean hasOpen = false;
        boolean hasAbstract = false;
        for (CallableMemberDescriptor descriptor : descriptors) {
            switch (descriptor.getModality()) {
                case FINAL:
                    Modality modality = Modality.FINAL;
                    if (modality == null) {
                        $$$reportNull$$$0(88);
                    }
                    return modality;
                case SEALED:
                    throw new IllegalStateException("Member cannot have SEALED modality: " + descriptor);
                case OPEN:
                    hasOpen = true;
                    break;
                case ABSTRACT:
                    hasAbstract = true;
                    break;
            }
        }
        boolean transformAbstractToClassModality = (!current.isExpect() || current.getModality() == Modality.ABSTRACT || current.getModality() == Modality.SEALED) ? false : true;
        if (hasOpen && !hasAbstract) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                $$$reportNull$$$0(89);
            }
            return modality2;
        } else if (!hasOpen && hasAbstract) {
            Modality modality3 = transformAbstractToClassModality ? current.getModality() : Modality.ABSTRACT;
            if (modality3 == null) {
                $$$reportNull$$$0(90);
            }
            return modality3;
        } else {
            Set<CallableMemberDescriptor> allOverriddenDeclarations = new HashSet<>();
            for (CallableMemberDescriptor descriptor2 : descriptors) {
                allOverriddenDeclarations.addAll(getOverriddenDeclarations(descriptor2));
            }
            return getMinimalModality(filterOutOverridden(allOverriddenDeclarations), transformAbstractToClassModality, current.getModality());
        }
    }

    private static Modality getMinimalModality(Collection<CallableMemberDescriptor> descriptors, boolean transformAbstractToClassModality, Modality classModality) {
        if (descriptors == null) {
            $$$reportNull$$$0(91);
        }
        if (classModality == null) {
            $$$reportNull$$$0(92);
        }
        Modality result = Modality.ABSTRACT;
        for (CallableMemberDescriptor descriptor : descriptors) {
            Modality effectiveModality = (transformAbstractToClassModality && descriptor.getModality() == Modality.ABSTRACT) ? classModality : descriptor.getModality();
            if (effectiveModality.compareTo(result) < 0) {
                result = effectiveModality;
            }
        }
        if (result == null) {
            $$$reportNull$$$0(93);
        }
        return result;
    }

    public static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor current, Collection<CallableMemberDescriptor> toFilter) {
        if (current == null) {
            $$$reportNull$$$0(94);
        }
        if (toFilter == null) {
            $$$reportNull$$$0(95);
        }
        List filter = CollectionsKt.filter(toFilter, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.5
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor descriptor) {
                boolean z = false;
                if (!DescriptorVisibilities.isPrivate(descriptor.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(descriptor, ClassDescriptor.this, false)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
        if (filter == null) {
            $$$reportNull$$$0(96);
        }
        return filter;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H overrider, Collection<H> extractFrom, Function1<H, CallableDescriptor> descriptorByHandle, Function1<H, Unit> onConflict) {
        if (overrider == null) {
            $$$reportNull$$$0(97);
        }
        if (extractFrom == null) {
            $$$reportNull$$$0(98);
        }
        if (descriptorByHandle == null) {
            $$$reportNull$$$0(99);
        }
        if (onConflict == null) {
            $$$reportNull$$$0(100);
        }
        Collection<H> overridable = new ArrayList<>();
        overridable.add(overrider);
        CallableDescriptor overriderDescriptor = descriptorByHandle.invoke(overrider);
        Iterator<H> iterator = extractFrom.iterator();
        while (iterator.hasNext()) {
            H candidate = iterator.next();
            CallableDescriptor candidateDescriptor = descriptorByHandle.invoke(candidate);
            if (overrider == candidate) {
                iterator.remove();
            } else {
                OverrideCompatibilityInfo.Result finalResult = getBothWaysOverridability(overriderDescriptor, candidateDescriptor);
                if (finalResult == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    overridable.add(candidate);
                    iterator.remove();
                } else if (finalResult == OverrideCompatibilityInfo.Result.CONFLICT) {
                    onConflict.invoke(candidate);
                    iterator.remove();
                }
            }
        }
        return overridable;
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor overriderDescriptor, CallableDescriptor candidateDescriptor) {
        OverrideCompatibilityInfo.Result result1 = DEFAULT.isOverridableBy(candidateDescriptor, overriderDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = DEFAULT.isOverridableBy(overriderDescriptor, candidateDescriptor, null).getResult();
        return (result1 == OverrideCompatibilityInfo.Result.OVERRIDABLE && result2 == OverrideCompatibilityInfo.Result.OVERRIDABLE) ? OverrideCompatibilityInfo.Result.OVERRIDABLE : (result1 == OverrideCompatibilityInfo.Result.CONFLICT || result2 == OverrideCompatibilityInfo.Result.CONFLICT) ? OverrideCompatibilityInfo.Result.CONFLICT : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor overrider, Queue<CallableMemberDescriptor> extractFrom, final OverridingStrategy strategy) {
        if (overrider == null) {
            $$$reportNull$$$0(102);
        }
        if (extractFrom == null) {
            $$$reportNull$$$0(103);
        }
        if (strategy == null) {
            $$$reportNull$$$0(104);
        }
        return extractMembersOverridableInBothWays(overrider, extractFrom, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.6
            @Override // kotlin.jvm.functions.Function1
            public CallableDescriptor invoke(CallableMemberDescriptor descriptor) {
                return descriptor;
            }
        }, new Function1<CallableMemberDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.7
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CallableMemberDescriptor descriptor) {
                OverridingStrategy.this.inheritanceConflict(overrider, descriptor);
                return Unit.INSTANCE;
            }
        });
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor memberDescriptor, Function1<CallableMemberDescriptor, Unit> cannotInferVisibility) {
        DescriptorVisibility visibilityToInherit;
        if (memberDescriptor == null) {
            $$$reportNull$$$0(105);
        }
        for (CallableMemberDescriptor descriptor : memberDescriptor.getOverriddenDescriptors()) {
            if (descriptor.getVisibility() == DescriptorVisibilities.INHERITED) {
                resolveUnknownVisibilityForMember(descriptor, cannotInferVisibility);
            }
        }
        if (memberDescriptor.getVisibility() != DescriptorVisibilities.INHERITED) {
            return;
        }
        DescriptorVisibility maxVisibility = computeVisibilityToInherit(memberDescriptor);
        if (maxVisibility == null) {
            if (cannotInferVisibility != null) {
                cannotInferVisibility.invoke(memberDescriptor);
            }
            visibilityToInherit = DescriptorVisibilities.PUBLIC;
        } else {
            visibilityToInherit = maxVisibility;
        }
        if (memberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl) memberDescriptor).setVisibility(visibilityToInherit);
            for (PropertyAccessorDescriptor accessor : ((PropertyDescriptor) memberDescriptor).getAccessors()) {
                resolveUnknownVisibilityForMember(accessor, maxVisibility == null ? null : cannotInferVisibility);
            }
        } else if (memberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) memberDescriptor).setVisibility(visibilityToInherit);
        } else if (!(memberDescriptor instanceof PropertyAccessorDescriptorImpl)) {
            throw new AssertionError();
        } else {
            PropertyAccessorDescriptorImpl propertyAccessorDescriptor = (PropertyAccessorDescriptorImpl) memberDescriptor;
            propertyAccessorDescriptor.setVisibility(visibilityToInherit);
            if (visibilityToInherit != propertyAccessorDescriptor.getCorrespondingProperty().getVisibility()) {
                propertyAccessorDescriptor.setDefault(false);
            }
        }
    }

    private static DescriptorVisibility computeVisibilityToInherit(CallableMemberDescriptor memberDescriptor) {
        if (memberDescriptor == null) {
            $$$reportNull$$$0(106);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = memberDescriptor.getOverriddenDescriptors();
        DescriptorVisibility maxVisibility = findMaxVisibility(overriddenDescriptors);
        if (maxVisibility == null) {
            return null;
        }
        if (memberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor overridden : overriddenDescriptors) {
                if (overridden.getModality() != Modality.ABSTRACT && !overridden.getVisibility().equals(maxVisibility)) {
                    return null;
                }
            }
            return maxVisibility;
        }
        return maxVisibility.normalize();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DescriptorVisibility findMaxVisibility(Collection<? extends CallableMemberDescriptor> descriptors) {
        if (descriptors == null) {
            $$$reportNull$$$0(107);
        }
        if (descriptors.isEmpty()) {
            return DescriptorVisibilities.DEFAULT_VISIBILITY;
        }
        DescriptorVisibility maxVisibility = null;
        for (CallableMemberDescriptor descriptor : descriptors) {
            DescriptorVisibility visibility = descriptor.getVisibility();
            if (visibility == DescriptorVisibilities.INHERITED) {
                throw new AssertionError("Visibility should have been computed for " + descriptor);
            }
            if (maxVisibility == null) {
                maxVisibility = visibility;
            } else {
                Integer compareResult = DescriptorVisibilities.compare(visibility, maxVisibility);
                if (compareResult == null) {
                    maxVisibility = null;
                } else if (compareResult.intValue() > 0) {
                    maxVisibility = visibility;
                }
            }
        }
        if (maxVisibility == null) {
            return null;
        }
        for (CallableMemberDescriptor descriptor2 : descriptors) {
            Integer compareResult2 = DescriptorVisibilities.compare(maxVisibility, descriptor2.getVisibility());
            if (compareResult2 == null || compareResult2.intValue() < 0) {
                return null;
            }
            while (r2.hasNext()) {
            }
        }
        return maxVisibility;
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final String debugMessage;
        private final Result overridable;

        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                default:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = 3;
                    break;
                default:
                    i2 = 2;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                case 2:
                case 4:
                    objArr[0] = "debugMessage";
                    break;
                case 3:
                    objArr[0] = "success";
                    break;
                default:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            switch (i) {
                case 1:
                    objArr[2] = "incompatible";
                    break;
                case 2:
                    objArr[2] = "conflict";
                    break;
                case 3:
                case 4:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    throw new IllegalArgumentException(format);
                default:
                    throw new IllegalStateException(format);
            }
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                $$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        public static OverrideCompatibilityInfo incompatible(String debugMessage) {
            if (debugMessage == null) {
                $$$reportNull$$$0(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, debugMessage);
        }

        public static OverrideCompatibilityInfo conflict(String debugMessage) {
            if (debugMessage == null) {
                $$$reportNull$$$0(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, debugMessage);
        }

        public OverrideCompatibilityInfo(Result success, String debugMessage) {
            if (success == null) {
                $$$reportNull$$$0(3);
            }
            if (debugMessage == null) {
                $$$reportNull$$$0(4);
            }
            this.overridable = success;
            this.debugMessage = debugMessage;
        }

        public Result getResult() {
            Result result = this.overridable;
            if (result == null) {
                $$$reportNull$$$0(5);
            }
            return result;
        }

        public String toString() {
            return this.overridable + ": " + this.debugMessage;
        }
    }
}