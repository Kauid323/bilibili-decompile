package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;

/* compiled from: KCallableImpl.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0019*\u00020\u0007H\u0002J%\u0010=\u001a\u00028\u00002\u0016\u0010>\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010@0?\"\u0004\u0018\u00010@H\u0016¢\u0006\u0002\u0010AJ#\u0010B\u001a\u00028\u00002\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010@0CH\u0016¢\u0006\u0002\u0010DJ\u0015\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0?H\u0002¢\u0006\u0002\u0010GJ3\u0010H\u001a\u00028\u00002\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010@0C2\f\u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010JH\u0000¢\u0006\u0004\bK\u0010LJ\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020!H\u0002J#\u0010R\u001a\u00028\u00002\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010@0CH\u0002¢\u0006\u0002\u0010DJ\u0010\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020-H\u0002J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R(\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \u001b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR>\u0010\u001f\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020! \u001b*\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"0 j\b\u0012\u0004\u0012\u00020!`\"0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00198F¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR>\u0010%\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020! \u001b*\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"0 j\b\u0012\u0004\u0012\u00020!`\"0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020!0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001eR\u001c\u0010*\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010+0+0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \u001b*\n\u0012\u0004\u0012\u000201\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u001eR\u0016\u00105\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0016R\u0014\u0010:\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0016R\u0014\u0010;\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0016R\u0014\u0010<\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0016R,\u0010E\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010@ \u001b*\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010?0?0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00150NX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "<init>", "()V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "annotations", "getAnnotations", "()Ljava/util/List;", "_receiverParameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "Lkotlin/collections/ArrayList;", "receiverParameters", "getReceiverParameters", "_parameters", "computeContextParameters", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "parameters", "getParameters", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isOpen", "isAbstract", "isAnnotationConstructor", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "_absentArguments", "getAbsentArguments", "()[Ljava/lang/Object;", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parametersNeedMFVCFlattening", "Lkotlin/Lazy;", "getParameterTypeSize", "", "parameter", "callAnnotationConstructor", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _receiverParameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
    private final Lazy<Boolean> parametersNeedMFVCFlattening;

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$0
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List _annotations$lambda$0;
                _annotations$lambda$0 = KCallableImpl._annotations$lambda$0(this.arg$0);
                return _annotations$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft(...)");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$1
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ArrayList _receiverParameters$lambda$0;
                _receiverParameters$lambda$0 = KCallableImpl._receiverParameters$lambda$0(this.arg$0);
                return _receiverParameters$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft(...)");
        this._receiverParameters = lazySoft2;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft3 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$2
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ArrayList _parameters$lambda$0;
                _parameters$lambda$0 = KCallableImpl._parameters$lambda$0(this.arg$0);
                return _parameters$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft(...)");
        this._parameters = lazySoft3;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft4 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$3
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KTypeImpl _returnType$lambda$0;
                _returnType$lambda$0 = KCallableImpl._returnType$lambda$0(this.arg$0);
                return _returnType$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft(...)");
        this._returnType = lazySoft4;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft5 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$4
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List _typeParameters$lambda$0;
                _typeParameters$lambda$0 = KCallableImpl._typeParameters$lambda$0(this.arg$0);
                return _typeParameters$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft5, "lazySoft(...)");
        this._typeParameters = lazySoft5;
        ReflectProperties.LazySoftVal<Object[]> lazySoft6 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$5
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Object[] _absentArguments$lambda$0;
                _absentArguments$lambda$0 = KCallableImpl._absentArguments$lambda$0(this.arg$0);
                return _absentArguments$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft6, "lazySoft(...)");
        this._absentArguments = lazySoft6;
        this.parametersNeedMFVCFlattening = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$6
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                boolean parametersNeedMFVCFlattening$lambda$0;
                parametersNeedMFVCFlattening$lambda$0 = KCallableImpl.parametersNeedMFVCFlattening$lambda$0(this.arg$0);
                return Boolean.valueOf(parametersNeedMFVCFlattening$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _annotations$lambda$0(KCallableImpl this$0) {
        return UtilKt.computeAnnotations(this$0.getDescriptor());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList _receiverParameters$lambda$0(KCallableImpl this$0) {
        ArrayList result = new ArrayList();
        final ReceiverParameterDescriptor instanceReceiver = UtilKt.getInstanceReceiverParameter(this$0.getDescriptor());
        if (instanceReceiver != null) {
            result.add(new KParameterImpl(this$0, result.size(), KParameter.Kind.INSTANCE, new Function0(instanceReceiver) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$7
                private final ReceiverParameterDescriptor arg$0;

                {
                    this.arg$0 = instanceReceiver;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ParameterDescriptor _receiverParameters$lambda$0$0;
                    _receiverParameters$lambda$0$0 = KCallableImpl._receiverParameters$lambda$0$0(this.arg$0);
                    return _receiverParameters$lambda$0$0;
                }
            }));
        }
        final List contextParameters = this$0.computeContextParameters(this$0.getDescriptor());
        int size = contextParameters.size();
        for (final int i = 0; i < size; i++) {
            result.add(new KParameterImpl(this$0, result.size(), KParameter.Kind.CONTEXT, new Function0(contextParameters, i) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$8
                private final List arg$0;
                private final int arg$1;

                {
                    this.arg$0 = contextParameters;
                    this.arg$1 = i;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ParameterDescriptor _receiverParameters$lambda$0$1;
                    _receiverParameters$lambda$0$1 = KCallableImpl._receiverParameters$lambda$0$1(this.arg$0, this.arg$1);
                    return _receiverParameters$lambda$0$1;
                }
            }));
        }
        final ReceiverParameterDescriptor extensionReceiver = this$0.getDescriptor().getExtensionReceiverParameter();
        if (extensionReceiver != null) {
            result.add(new KParameterImpl(this$0, result.size(), KParameter.Kind.EXTENSION_RECEIVER, new Function0(extensionReceiver) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$9
                private final ReceiverParameterDescriptor arg$0;

                {
                    this.arg$0 = extensionReceiver;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ParameterDescriptor _receiverParameters$lambda$0$2;
                    _receiverParameters$lambda$0$2 = KCallableImpl._receiverParameters$lambda$0$2(this.arg$0);
                    return _receiverParameters$lambda$0$2;
                }
            }));
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _receiverParameters$lambda$0$0(ReceiverParameterDescriptor $instanceReceiver) {
        return $instanceReceiver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _receiverParameters$lambda$0$1(List $contextParameters, int $i) {
        return (ParameterDescriptor) $contextParameters.get($i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _receiverParameters$lambda$0$2(ReceiverParameterDescriptor $extensionReceiver) {
        return $extensionReceiver;
    }

    public final List<KParameter> getReceiverParameters() {
        ArrayList<KParameter> invoke = this._receiverParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList _parameters$lambda$0(KCallableImpl this$0) {
        final CallableMemberDescriptor descriptor = this$0.getDescriptor();
        ArrayList result = new ArrayList();
        if (!this$0.isBound()) {
            result.addAll(this$0.getReceiverParameters());
        }
        int size = descriptor.getValueParameters().size();
        for (final int i = 0; i < size; i++) {
            result.add(new KParameterImpl(this$0, result.size(), KParameter.Kind.VALUE, new Function0(descriptor, i) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$10
                private final CallableMemberDescriptor arg$0;
                private final int arg$1;

                {
                    this.arg$0 = descriptor;
                    this.arg$1 = i;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ParameterDescriptor _parameters$lambda$0$0;
                    _parameters$lambda$0$0 = KCallableImpl._parameters$lambda$0$0(this.arg$0, this.arg$1);
                    return _parameters$lambda$0$0;
                }
            }));
        }
        if (this$0.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor)) {
            ArrayList $this$sortBy$iv = result;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$lambda$0$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        KParameter it = (KParameter) t;
                        KParameter it2 = (KParameter) t2;
                        return ComparisonsKt.compareValues(it.getName(), it2.getName());
                    }
                });
            }
        }
        result.trimToSize();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _parameters$lambda$0$0(CallableMemberDescriptor $descriptor, int $i) {
        ValueParameterDescriptor valueParameterDescriptor = $descriptor.getValueParameters().get($i);
        Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "get(...)");
        return valueParameterDescriptor;
    }

    private final List<ValueParameterDescriptor> computeContextParameters(CallableMemberDescriptor $this$computeContextParameters) {
        Pair pair;
        CallableMemberDescriptor callableMemberDescriptor = $this$computeContextParameters;
        if (callableMemberDescriptor instanceof DeserializedSimpleFunctionDescriptor) {
            pair = TuplesKt.to(((DeserializedSimpleFunctionDescriptor) callableMemberDescriptor).getNameResolver(), ((DeserializedSimpleFunctionDescriptor) callableMemberDescriptor).getProto().getContextParameterList());
        } else if (callableMemberDescriptor instanceof DeserializedPropertyDescriptor) {
            pair = TuplesKt.to(((DeserializedPropertyDescriptor) callableMemberDescriptor).getNameResolver(), ((DeserializedPropertyDescriptor) callableMemberDescriptor).getProto().getContextParameterList());
        } else if (callableMemberDescriptor instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
            DeserializedPropertyDescriptor it = correspondingProperty instanceof DeserializedPropertyDescriptor ? (DeserializedPropertyDescriptor) correspondingProperty : null;
            pair = it != null ? TuplesKt.to(it.getNameResolver(), it.getProto().getContextParameterList()) : null;
        } else {
            pair = null;
        }
        if (pair != null) {
            NameResolver nameResolver = (NameResolver) pair.component1();
            List contextParameters = (List) pair.component2();
            Iterable contextReceiverParameters = $this$computeContextParameters.getContextReceiverParameters();
            Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
            Iterable $this$mapIndexed$iv = contextReceiverParameters;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ReceiverParameterDescriptor parameter = (ReceiverParameterDescriptor) item$iv$iv;
                Annotations annotations = parameter.getAnnotations();
                Name guessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(((ProtoBuf.ValueParameter) contextParameters.get(index$iv$iv)).getName()));
                Intrinsics.checkNotNullExpressionValue(guessByFirstCharacter, "guessByFirstCharacter(...)");
                KotlinType type = parameter.getType();
                List contextParameters2 = contextParameters;
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                SourceElement source = parameter.getSource();
                Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
                destination$iv$iv.add(new ValueParameterDescriptorImpl(callableMemberDescriptor, null, index$iv$iv, annotations, guessByFirstCharacter, type, false, false, false, null, source));
                callableMemberDescriptor = $this$computeContextParameters;
                index$iv$iv = index$iv$iv2;
                contextParameters = contextParameters2;
                nameResolver = nameResolver;
                $this$mapIndexed$iv = $this$mapIndexed$iv;
            }
            return (List) destination$iv$iv;
        }
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KTypeImpl _returnType$lambda$0(final KCallableImpl this$0) {
        KotlinType returnType = this$0.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(returnType);
        return new KTypeImpl(returnType, new Function0(this$0) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$11
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Type _returnType$lambda$0$0;
                _returnType$lambda$0$0 = KCallableImpl._returnType$lambda$0$0(this.arg$0);
                return _returnType$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type _returnType$lambda$0$0(KCallableImpl this$0) {
        Type extractContinuationArgument = this$0.extractContinuationArgument();
        return extractContinuationArgument == null ? this$0.getCaller().getReturnType() : extractContinuationArgument;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _typeParameters$lambda$0(KCallableImpl this$0) {
        Iterable typeParameters = this$0.getDescriptor().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        Iterable $this$map$iv = typeParameters;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TypeParameterDescriptor descriptor = (TypeParameterDescriptor) item$iv$iv;
            Intrinsics.checkNotNull(descriptor);
            destination$iv$iv.add(new KTypeParameterImpl(this$0, descriptor));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return (R) getCaller().call(args);
        } catch (IllegalAccessException e$iv) {
            throw new IllegalCallableAccessException(e$iv);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return isAnnotationConstructor() ? callAnnotationConstructor(args) : callDefaultMethod$kotlin_reflection(args, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] _absentArguments$lambda$0(KCallableImpl this$0) {
        int $i$f$count;
        List<KParameter> parameters = this$0.getParameters();
        int parameterSize = parameters.size() + (this$0.isSuspend() ? 1 : 0);
        if (((Boolean) this$0.parametersNeedMFVCFlattening.getValue()).booleanValue()) {
            $i$f$count = 0;
            for (KParameter it : parameters) {
                $i$f$count += it.getKind() == KParameter.Kind.VALUE ? this$0.getParameterTypeSize(it) : 0;
            }
        } else {
            List $this$count$iv = parameters;
            if (($this$count$iv instanceof Collection) && $this$count$iv.isEmpty()) {
                $i$f$count = 0;
            } else {
                int count$iv = 0;
                for (Object element$iv : $this$count$iv) {
                    KParameter it2 = (KParameter) element$iv;
                    KParameter it3 = it2.getKind() == KParameter.Kind.VALUE ? 1 : null;
                    if (it3 != null && (count$iv = count$iv + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                $i$f$count = count$iv;
            }
        }
        int flattenedParametersSize = $i$f$count;
        int maskSize = ((flattenedParametersSize + 32) - 1) / 32;
        Object[] arguments = new Object[parameterSize + maskSize + 1];
        List $this$forEach$iv = parameters;
        for (Object element$iv2 : $this$forEach$iv) {
            KParameter parameter = (KParameter) element$iv2;
            if (parameter.isOptional() && !UtilKt.isInlineClassType(parameter.getType())) {
                arguments[parameter.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(parameter.getType()));
            } else if (parameter.isVararg()) {
                arguments[parameter.getIndex()] = this$0.defaultEmptyArray(parameter.getType());
            }
        }
        for (int i = 0; i < maskSize; i++) {
            arguments[parameterSize + i] = 0;
        }
        return arguments;
    }

    private final Object[] getAbsentArguments() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> args, Continuation<?> continuation) {
        int i;
        Intrinsics.checkNotNullParameter(args, "args");
        List parameters = getParameters();
        int i2 = 1;
        if (!parameters.isEmpty()) {
            int parameterSize = (isSuspend() ? 1 : 0) + parameters.size();
            Object[] $this$callDefaultMethod_u24lambda_u241 = getAbsentArguments();
            if (isSuspend()) {
                $this$callDefaultMethod_u24lambda_u241[parameters.size()] = continuation;
            }
            boolean hasMfvcParameters = ((Boolean) this.parametersNeedMFVCFlattening.getValue()).booleanValue();
            boolean anyOptional = false;
            int valueParameterIndex = 0;
            for (KParameter parameter : parameters) {
                int parameterTypeSize = hasMfvcParameters ? getParameterTypeSize(parameter) : i2;
                if (args.containsKey(parameter)) {
                    $this$callDefaultMethod_u24lambda_u241[parameter.getIndex()] = args.get(parameter);
                    i = i2;
                    anyOptional = anyOptional;
                } else if (parameter.isOptional()) {
                    if (hasMfvcParameters) {
                        int i3 = valueParameterIndex + parameterTypeSize;
                        for (int valueSubParameterIndex = valueParameterIndex; valueSubParameterIndex < i3; valueSubParameterIndex++) {
                            int maskIndex = (valueSubParameterIndex / 32) + parameterSize;
                            Object obj = $this$callDefaultMethod_u24lambda_u241[maskIndex];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            $this$callDefaultMethod_u24lambda_u241[maskIndex] = Integer.valueOf(((Integer) obj).intValue() | (1 << (valueSubParameterIndex % 32)));
                        }
                        i = 1;
                    } else {
                        int maskIndex2 = (valueParameterIndex / 32) + parameterSize;
                        Object obj2 = $this$callDefaultMethod_u24lambda_u241[maskIndex2];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        i = 1;
                        $this$callDefaultMethod_u24lambda_u241[maskIndex2] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (valueParameterIndex % 32)));
                    }
                    anyOptional = true;
                } else {
                    i = i2;
                    anyOptional = anyOptional;
                    if (!parameter.isVararg()) {
                        throw new IllegalArgumentException("No argument provided for a required parameter: " + parameter);
                    }
                }
                if (parameter.getKind() != KParameter.Kind.VALUE) {
                    i2 = i;
                } else {
                    valueParameterIndex += parameterTypeSize;
                    i2 = i;
                }
            }
            if (!anyOptional) {
                try {
                    Caller<?> caller = getCaller();
                    Object[] copyOf = Arrays.copyOf($this$callDefaultMethod_u24lambda_u241, parameterSize);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    return (R) caller.call(copyOf);
                } catch (IllegalAccessException e$iv) {
                    throw new IllegalCallableAccessException(e$iv);
                }
            }
            Caller caller2 = getDefaultCaller();
            if (caller2 == null) {
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
            }
            try {
                return (R) caller2.call($this$callDefaultMethod_u24lambda_u241);
            } catch (IllegalAccessException e$iv2) {
                throw new IllegalCallableAccessException(e$iv2);
            }
        }
        try {
            return (R) getCaller().call(isSuspend() ? new Continuation[]{continuation} : new Continuation[0]);
        } catch (IllegalAccessException e$iv3) {
            throw new IllegalCallableAccessException(e$iv3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parametersNeedMFVCFlattening$lambda$0(KCallableImpl this$0) {
        Iterable $this$any$iv = this$0.getParameters();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            KParameter it = (KParameter) element$iv;
            if (UtilKt.getNeedsMultiFieldValueClassFlattening(it.getType())) {
                return true;
            }
        }
        return false;
    }

    private final int getParameterTypeSize(KParameter parameter) {
        if (((Boolean) this.parametersNeedMFVCFlattening.getValue()).booleanValue()) {
            if (UtilKt.getNeedsMultiFieldValueClassFlattening(parameter.getType())) {
                KType type = parameter.getType();
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                SimpleType type2 = TypeSubstitutionKt.asSimpleType(((KTypeImpl) type).getType());
                List<Method> mfvcUnboxMethods = ValueClassAwareCallerKt.getMfvcUnboxMethods(type2);
                Intrinsics.checkNotNull(mfvcUnboxMethods);
                return mfvcUnboxMethods.size();
            }
            return 1;
        }
        throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before".toString());
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> map) {
        Object defaultEmptyArray;
        Iterable $this$map$iv = getParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KParameter parameter = (KParameter) item$iv$iv;
            if (map.containsKey(parameter)) {
                defaultEmptyArray = map.get(parameter);
                if (defaultEmptyArray == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + parameter + ')');
                }
            } else if (parameter.isOptional()) {
                defaultEmptyArray = null;
            } else if (!parameter.isVararg()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + parameter);
            } else {
                defaultEmptyArray = defaultEmptyArray(parameter.getType());
            }
            destination$iv$iv.add(defaultEmptyArray);
        }
        Collection arguments = (List) destination$iv$iv;
        Caller caller = getDefaultCaller();
        if (caller == null) {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
        }
        try {
            Collection $this$toTypedArray$iv = arguments;
            return (R) caller.call($this$toTypedArray$iv.toArray(new Object[0]));
        } catch (IllegalAccessException e$iv) {
            throw new IllegalCallableAccessException(e$iv);
        }
    }

    private final Object defaultEmptyArray(KType type) {
        Class $this$defaultEmptyArray_u24lambda_u240 = JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(type));
        if ($this$defaultEmptyArray_u24lambda_u240.isArray()) {
            Object newInstance = Array.newInstance($this$defaultEmptyArray_u24lambda_u240.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "run(...)");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + $this$defaultEmptyArray_u24lambda_u240.getSimpleName() + ", because it is not an array type");
    }

    private final Type extractContinuationArgument() {
        Type[] lowerBounds;
        if (isSuspend()) {
            Object lastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) getCaller().getParameterTypes());
            ParameterizedType continuationType = lastOrNull instanceof ParameterizedType ? (ParameterizedType) lastOrNull : null;
            if (Intrinsics.areEqual(continuationType != null ? continuationType.getRawType() : null, Continuation.class)) {
                Type[] actualTypeArguments = continuationType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
                Object single = ArraysKt.single(actualTypeArguments);
                WildcardType wildcard = single instanceof WildcardType ? (WildcardType) single : null;
                if (wildcard == null || (lowerBounds = wildcard.getLowerBounds()) == null) {
                    return null;
                }
                return (Type) ArraysKt.first(lowerBounds);
            }
        }
        return null;
    }
}