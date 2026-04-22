package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;

/* compiled from: modifierChecks.kt */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1<KotlinBuiltIns, KotlinType> type;

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String name, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = name;
        this.type = function1;
        this.description = "must return " + this.name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public /* bridge */ String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType _init_$lambda$0;
                    _init_$lambda$0 = ReturnsCheck.ReturnsBoolean._init_$lambda$0((KotlinBuiltIns) obj);
                    return _init_$lambda$0;
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType booleanType = kotlinBuiltIns.getBooleanType();
            Intrinsics.checkNotNullExpressionValue(booleanType, "getBooleanType(...)");
            return booleanType;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType _init_$lambda$0;
                    _init_$lambda$0 = ReturnsCheck.ReturnsInt._init_$lambda$0((KotlinBuiltIns) obj);
                    return _init_$lambda$0;
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType intType = kotlinBuiltIns.getIntType();
            Intrinsics.checkNotNullExpressionValue(intType, "getIntType(...)");
            return intType;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType _init_$lambda$0;
                    _init_$lambda$0 = ReturnsCheck.ReturnsUnit._init_$lambda$0((KotlinBuiltIns) obj);
                    return _init_$lambda$0;
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType unitType = kotlinBuiltIns.getUnitType();
            Intrinsics.checkNotNullExpressionValue(unitType, "getUnitType(...)");
            return unitType;
        }
    }
}