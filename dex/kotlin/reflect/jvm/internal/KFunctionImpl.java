package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;

/* compiled from: KFunctionImpl.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B7\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0013J\u0012\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00102\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0002J.\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000305042\n\u0010,\u001a\u0006\u0012\u0002\b\u0003052\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0017H\u0002J\u0013\u0010@\u001a\u00020\u00172\b\u0010A\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u0012\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R!\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b&\u0010\"R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u00107\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0018R\u0014\u0010=\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0018R\u0014\u0010>\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0018R\u0014\u0010?\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0018¨\u0006D"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getName", "()Ljava/lang/String;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getFunctionWithDefaultParametersForValueClassOverride", "getBoundReceiver", "()Ljava/lang/Object;", "useBoxedBoundReceiver", "member", "Ljava/lang/reflect/Method;", "createStaticMethodCaller", "isCallByToValueClassMangledMethod", "createJvmStaticInObjectCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createInstanceMethodCaller", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "isDefault", "arity", "", "getArity", "()I", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KFunctionImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};
    private final Lazy caller$delegate;
    private final KDeclarationContainerImpl container;
    private final Lazy defaultCaller$delegate;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final Object rawBoundReceiver;
    private final String signature;

    private KFunctionImpl(KDeclarationContainerImpl container, final String name, String signature, FunctionDescriptor descriptorInitialValue, Object rawBoundReceiver) {
        this.container = container;
        this.signature = signature;
        this.rawBoundReceiver = rawBoundReceiver;
        this.descriptor$delegate = ReflectProperties.lazySoft(descriptorInitialValue, new Function0(this, name) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$0
            private final KFunctionImpl arg$0;
            private final String arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = name;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                FunctionDescriptor descriptor_delegate$lambda$0;
                descriptor_delegate$lambda$0 = KFunctionImpl.descriptor_delegate$lambda$0(this.arg$0, this.arg$1);
                return descriptor_delegate$lambda$0;
            }
        });
        this.caller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$1
            private final KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Caller caller_delegate$lambda$0;
                caller_delegate$lambda$0 = KFunctionImpl.caller_delegate$lambda$0(this.arg$0);
                return caller_delegate$lambda$0;
            }
        });
        this.defaultCaller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$2
            private final KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Caller defaultCaller_delegate$lambda$0;
                defaultCaller_delegate$lambda$0 = KFunctionImpl.defaultCaller_delegate$lambda$0(this.arg$0);
                return defaultCaller_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, r5);
        Object obj2;
        if ((i & 16) == 0) {
            obj2 = obj;
        } else {
            obj2 = CallableReference.NO_RECEIVER;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ Object invoke() {
        return default$invoke();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ Object invoke(Object p1) {
        return default$invoke(p1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ Object invoke(Object p1, Object p2) {
        return default$invoke(p1, p2);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3) {
        return default$invoke(p1, p2, p3);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        return default$invoke(p1, p2, p3, p4);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        return default$invoke(p1, p2, p3, p4, p5);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return default$invoke(p1, p2, p3, p4, p5, p6);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // kotlin.jvm.functions.Function8
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override // kotlin.jvm.functions.Function9
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override // kotlin.jvm.functions.Function11
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    @Override // kotlin.jvm.functions.Function12
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    @Override // kotlin.jvm.functions.Function13
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13);
    }

    @Override // kotlin.jvm.functions.Function14
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }

    @Override // kotlin.jvm.functions.Function15
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
    }

    @Override // kotlin.jvm.functions.Function16
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
    }

    @Override // kotlin.jvm.functions.Function17
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17);
    }

    @Override // kotlin.jvm.functions.Function18
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18);
    }

    @Override // kotlin.jvm.functions.Function19
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19);
    }

    @Override // kotlin.jvm.functions.Function20
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
    }

    @Override // kotlin.jvm.functions.Function21
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
    }

    @Override // kotlin.jvm.functions.Function22
    public /* bridge */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21, Object p22) {
        return default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    public Object default$invoke() {
        return call(new Object[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(KDeclarationContainerImpl container, String name, String signature, Object boundReceiver) {
        this(container, name, signature, null, boundReceiver);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
    }

    public Object default$invoke(Object p1) {
        return call(p1);
    }

    public Object default$invoke(Object p1, Object p2) {
        return call(p1, p2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KFunctionImpl(KDeclarationContainerImpl container, FunctionDescriptor descriptor) {
        this(container, r3, RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString(), descriptor, null, 16, null);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String asString = descriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
    }

    public Object default$invoke(Object p1, Object p2, Object p3) {
        return call(p1, p2, p3);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4) {
        return call(p1, p2, p3, p4);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        return call(p1, p2, p3, p4, p5);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return call(p1, p2, p3, p4, p5, p6);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return call(p1, p2, p3, p4, p5, p6, p7);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        T value = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FunctionDescriptor) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FunctionDescriptor descriptor_delegate$lambda$0(KFunctionImpl this$0, String $name) {
        return this$0.getContainer().findFunctionDescriptor($name, this$0.signature);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return (Caller) this.caller$delegate.getValue();
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Caller caller_delegate$lambda$0(KFunctionImpl this$0) {
        Member member;
        CallerImpl.Method createStaticMethodCaller;
        JvmFunctionSignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this$0.getDescriptor());
        if (jvmSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this$0.isAnnotationConstructor()) {
                Class<?> jClass = this$0.getContainer().getJClass();
                Iterable $this$map$iv = this$0.getParameters();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String name = ((KParameter) item$iv$iv).getName();
                    Intrinsics.checkNotNull(name);
                    destination$iv$iv.add(name);
                }
                return new AnnotationConstructorCaller(jClass, (List) destination$iv$iv, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            member = this$0.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) jvmSignature).getConstructorDesc());
        } else if (jvmSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor it = this$0.getDescriptor();
            DeclarationDescriptor containingDeclaration = it.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (it instanceof ConstructorDescriptor) && ((ConstructorDescriptor) it).isPrimary()) {
                FunctionDescriptor descriptor = this$0.getDescriptor();
                KDeclarationContainerImpl container = this$0.getContainer();
                String methodDesc = ((JvmFunctionSignature.KotlinFunction) jvmSignature).getMethodDesc();
                List<ValueParameterDescriptor> valueParameters = this$0.getDescriptor().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                return new ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller(descriptor, container, methodDesc, valueParameters);
            }
            member = this$0.getContainer().findMethodBySignature(((JvmFunctionSignature.KotlinFunction) jvmSignature).getMethodName(), ((JvmFunctionSignature.KotlinFunction) jvmSignature).getMethodDesc());
        } else if (jvmSignature instanceof JvmFunctionSignature.JavaMethod) {
            Member method = ((JvmFunctionSignature.JavaMethod) jvmSignature).getMethod();
            Intrinsics.checkNotNull(method, "null cannot be cast to non-null type java.lang.reflect.Member");
            member = method;
        } else if (!(jvmSignature instanceof JvmFunctionSignature.JavaConstructor)) {
            if (!(jvmSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor)) {
                throw new NoWhenBranchMatchedException();
            }
            List methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmSignature).getMethods();
            Class<?> jClass2 = this$0.getContainer().getJClass();
            List $this$map$iv2 = methods;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                destination$iv$iv2.add(((Method) item$iv$iv2).getName());
            }
            return new AnnotationConstructorCaller(jClass2, (List) destination$iv$iv2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
        } else {
            Member constructor = ((JvmFunctionSignature.JavaConstructor) jvmSignature).getConstructor();
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
            member = constructor;
        }
        Member member2 = member;
        if (member2 instanceof Constructor) {
            createStaticMethodCaller = this$0.createConstructorCaller((Constructor) member2, this$0.getDescriptor(), false);
        } else if (member2 instanceof Method) {
            if (!Modifier.isStatic(((Method) member2).getModifiers())) {
                createStaticMethodCaller = this$0.createInstanceMethodCaller((Method) member2);
            } else if (this$0.getDescriptor().getAnnotations().mo1162findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                createStaticMethodCaller = this$0.createJvmStaticInObjectCaller((Method) member2);
            } else {
                createStaticMethodCaller = this$0.createStaticMethodCaller((Method) member2, false);
            }
        } else {
            throw new KotlinReflectionInternalError("Could not compute caller for function: " + this$0.getDescriptor() + " (member = " + member2 + ')');
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(createStaticMethodCaller, this$0.getDescriptor(), false, 2, null);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
    }

    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21, Object p22) {
        return call(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.reflect.Member, java.lang.Object] */
    public static final Caller defaultCaller_delegate$lambda$0(KFunctionImpl this$0) {
        Member member;
        CallerImpl.Method method;
        ?? mo1159getMember;
        JvmFunctionSignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this$0.getDescriptor());
        if (jvmSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor it = this$0.getDescriptor();
            DeclarationDescriptor containingDeclaration = it.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (it instanceof ConstructorDescriptor) && ((ConstructorDescriptor) it).isPrimary()) {
                throw new KotlinReflectionInternalError(this$0.getDescriptor().getContainingDeclaration() + " cannot have default arguments");
            }
            FunctionDescriptor defaultImplsFunction = this$0.getFunctionWithDefaultParametersForValueClassOverride(this$0.getDescriptor());
            if (defaultImplsFunction != null) {
                JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(defaultImplsFunction);
                Intrinsics.checkNotNull(mapSignature, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction");
                JvmFunctionSignature.KotlinFunction replacingJvmSignature = (JvmFunctionSignature.KotlinFunction) mapSignature;
                member = this$0.getContainer().findDefaultMethod(replacingJvmSignature.getMethodName(), replacingJvmSignature.getMethodDesc(), true);
            } else {
                KDeclarationContainerImpl container = this$0.getContainer();
                String methodName = ((JvmFunctionSignature.KotlinFunction) jvmSignature).getMethodName();
                String methodDesc = ((JvmFunctionSignature.KotlinFunction) jvmSignature).getMethodDesc();
                Intrinsics.checkNotNull(this$0.getCaller().mo1159getMember());
                member = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(mo1159getMember.getModifiers()));
            }
        } else if (jvmSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this$0.isAnnotationConstructor()) {
                Class<?> jClass = this$0.getContainer().getJClass();
                Iterable $this$map$iv = this$0.getParameters();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    KParameter it2 = (KParameter) item$iv$iv;
                    String name = it2.getName();
                    Intrinsics.checkNotNull(name);
                    destination$iv$iv.add(name);
                }
                return new AnnotationConstructorCaller(jClass, (List) destination$iv$iv, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            member = this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) jvmSignature).getConstructorDesc());
        } else if (jvmSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmSignature).getMethods();
            Class<?> jClass2 = this$0.getContainer().getJClass();
            List $this$map$iv2 = methods;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                Method it3 = (Method) item$iv$iv2;
                destination$iv$iv2.add(it3.getName());
            }
            return new AnnotationConstructorCaller(jClass2, (List) destination$iv$iv2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
        } else {
            member = null;
        }
        Member member2 = member;
        if (member2 instanceof Constructor) {
            method = this$0.createConstructorCaller((Constructor) member2, this$0.getDescriptor(), true);
        } else if (member2 instanceof Method) {
            if (this$0.getDescriptor().getAnnotations().mo1162findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                DeclarationDescriptor containingDeclaration2 = this$0.getDescriptor().getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor) containingDeclaration2).isCompanionObject()) {
                    method = this$0.createJvmStaticInObjectCaller((Method) member2);
                }
            }
            method = this$0.createStaticMethodCaller((Method) member2, this$0.getCaller().isBoundInstanceCallWithValueClasses());
        } else {
            method = null;
        }
        if (method != null) {
            return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(method, this$0.getDescriptor(), true);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.reflect.Member, java.lang.Object] */
    private final FunctionDescriptor getFunctionWithDefaultParametersForValueClassOverride(FunctionDescriptor descriptor) {
        Iterable $this$none$iv;
        Object element$iv;
        Iterable $this$any$iv;
        Iterable valueParameters = descriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable $this$none$iv2 = valueParameters;
        if (!($this$none$iv2 instanceof Collection) || !((Collection) $this$none$iv2).isEmpty()) {
            Iterator<T> it = $this$none$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv2 = it.next();
                    ValueParameterDescriptor it2 = (ValueParameterDescriptor) element$iv2;
                    if (it2.declaresDefaultValue()) {
                        $this$none$iv = null;
                        break;
                    }
                } else {
                    $this$none$iv = 1;
                    break;
                }
            }
        } else {
            $this$none$iv = 1;
        }
        if ($this$none$iv != null) {
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
                ?? mo1159getMember = getCaller().mo1159getMember();
                Intrinsics.checkNotNull(mo1159getMember);
                if (Modifier.isStatic(mo1159getMember.getModifiers())) {
                    Sequence $this$firstOrNull$iv = DescriptorUtilsKt.overriddenTreeAsSequence(descriptor, false);
                    Iterator<CallableMemberDescriptor> it3 = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            element$iv = it3.next();
                            CallableMemberDescriptor function = (CallableMemberDescriptor) element$iv;
                            Iterable valueParameters2 = function.getValueParameters();
                            Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                            Iterable $this$any$iv2 = valueParameters2;
                            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                                Iterator<T> it4 = $this$any$iv2.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        Object element$iv3 = it4.next();
                                        ValueParameterDescriptor it5 = (ValueParameterDescriptor) element$iv3;
                                        if (it5.declaresDefaultValue()) {
                                            $this$any$iv = 1;
                                            continue;
                                            break;
                                        }
                                    } else {
                                        $this$any$iv = null;
                                        continue;
                                        break;
                                    }
                                }
                            } else {
                                $this$any$iv = null;
                                continue;
                            }
                            if ($this$any$iv != null) {
                                break;
                            }
                        } else {
                            element$iv = null;
                            break;
                        }
                    }
                    if (element$iv instanceof FunctionDescriptor) {
                        return (FunctionDescriptor) element$iv;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    private final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    private final boolean useBoxedBoundReceiver(Method member) {
        KotlinType type;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDescriptor().getDispatchReceiverParameter();
        if ((dispatchReceiverParameter == null || (type = dispatchReceiverParameter.getType()) == null || !InlineClassesUtilsKt.isInlineClassType(type)) ? false : true) {
            Class<?>[] parameterTypes = member.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            Class cls = (Class) ArraysKt.firstOrNull(parameterTypes);
            if (cls != null && cls.isInterface()) {
                return true;
            }
        }
        return false;
    }

    private final Caller<?> createStaticMethodCaller(Method member, boolean isCallByToValueClassMangledMethod) {
        if (isBound()) {
            return new CallerImpl.Method.BoundStatic(member, isCallByToValueClassMangledMethod, useBoxedBoundReceiver(member) ? this.rawBoundReceiver : getBoundReceiver());
        }
        return new CallerImpl.Method.Static(member);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(member) : new CallerImpl.Method.JvmStaticInObject(member);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundInstance(member, getBoundReceiver()) : new CallerImpl.Method.Instance(member);
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> constructor, FunctionDescriptor descriptor, boolean isDefault) {
        if (!isDefault && InlineClassManglingRulesKt.shouldHideConstructorDueToValueClassTypeValueParameters(descriptor)) {
            if (isBound()) {
                return new CallerImpl.AccessorForHiddenBoundConstructor(constructor, getBoundReceiver());
            }
            return new CallerImpl.AccessorForHiddenConstructor(constructor);
        } else if (isBound()) {
            return new CallerImpl.BoundConstructor(constructor, getBoundReceiver());
        } else {
            return new CallerImpl.Constructor(constructor);
        }
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public boolean equals(Object other) {
        KFunctionImpl that = UtilKt.asKFunctionImpl(other);
        return that != null && Intrinsics.areEqual(getContainer(), that.getContainer()) && Intrinsics.areEqual(getName(), that.getName()) && Intrinsics.areEqual(this.signature, that.signature) && Intrinsics.areEqual(this.rawBoundReceiver, that.rawBoundReceiver);
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(this);
    }
}