package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: ClassicBuiltinSpecialProperties.kt */
public final class ClassicBuiltinSpecialProperties {
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor $this$getBuiltinSpecialPropertyGetterName) {
        Name name;
        Intrinsics.checkNotNullParameter($this$getBuiltinSpecialPropertyGetterName, "<this>");
        if (!KotlinBuiltIns.isBuiltIn($this$getBuiltinSpecialPropertyGetterName)) {
            throw new AssertionError("This method is defined only for builtin members, but " + $this$getBuiltinSpecialPropertyGetterName + " found");
        }
        CallableMemberDescriptor descriptor = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor($this$getBuiltinSpecialPropertyGetterName), false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean builtinSpecialPropertyGetterName$lambda$1;
                builtinSpecialPropertyGetterName$lambda$1 = ClassicBuiltinSpecialProperties.getBuiltinSpecialPropertyGetterName$lambda$1((CallableMemberDescriptor) obj);
                return Boolean.valueOf(builtinSpecialPropertyGetterName$lambda$1);
            }
        }, 1, null);
        if (descriptor == null || (name = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(descriptor))) == null) {
            return null;
        }
        return name.asString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getBuiltinSpecialPropertyGetterName$lambda$1(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.hasBuiltinSpecialPropertyFqName(it);
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
        }
        return false;
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor $this$hasBuiltinSpecialPropertyFqNameImpl) {
        if (CollectionsKt.contains(BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull($this$hasBuiltinSpecialPropertyFqNameImpl)) && $this$hasBuiltinSpecialPropertyFqNameImpl.getValueParameters().isEmpty()) {
            return true;
        }
        if (KotlinBuiltIns.isBuiltIn($this$hasBuiltinSpecialPropertyFqNameImpl)) {
            Iterable overriddenDescriptors = $this$hasBuiltinSpecialPropertyFqNameImpl.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            Iterable $this$any$iv = overriddenDescriptors;
            if (((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                CallableMemberDescriptor it = (CallableMemberDescriptor) element$iv;
                ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties = INSTANCE;
                Intrinsics.checkNotNull(it);
                if (classicBuiltinSpecialProperties.hasBuiltinSpecialPropertyFqName(it)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}