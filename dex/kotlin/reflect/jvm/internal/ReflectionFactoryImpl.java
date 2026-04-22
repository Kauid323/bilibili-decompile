package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectLambdaKt;

public class ReflectionFactoryImpl extends ReflectionFactory {
    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class javaClass) {
        return new KClassImpl(javaClass);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class javaClass, String internalName) {
        return new KClassImpl(javaClass);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class javaClass, String moduleName) {
        return CachesKt.getOrCreateKotlinPackage(javaClass);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class javaClass) {
        return CachesKt.getOrCreateKotlinClass(javaClass);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class javaClass, String internalName) {
        return CachesKt.getOrCreateKotlinClass(javaClass);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(FunctionBase lambda) {
        KFunctionImpl impl;
        KFunction kFunction = ReflectLambdaKt.reflect(lambda);
        if (kFunction != null && (impl = UtilKt.asKFunctionImpl(kFunction)) != null) {
            return ReflectionObjectRenderer.INSTANCE.renderLambda(impl);
        }
        return super.renderLambdaToString(lambda);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KFunction function(FunctionReference f) {
        return new KFunctionImpl(getOwner(f), f.getName(), f.getSignature(), f.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty0 property0(PropertyReference0 p) {
        return new KProperty0Impl(getOwner(p), p.getName(), p.getSignature(), p.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 p) {
        return new KMutableProperty0Impl(getOwner(p), p.getName(), p.getSignature(), p.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty1 property1(PropertyReference1 p) {
        return new KProperty1Impl(getOwner(p), p.getName(), p.getSignature(), p.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 p) {
        return new KMutableProperty1Impl(getOwner(p), p.getName(), p.getSignature(), p.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty2 property2(PropertyReference2 p) {
        return new KProperty2Impl(getOwner(p), p.getName(), p.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 p) {
        return new KMutableProperty2Impl(getOwner(p), p.getName(), p.getSignature());
    }

    private static KDeclarationContainerImpl getOwner(CallableReference reference) {
        KDeclarationContainer owner = reference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.INSTANCE;
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType typeOf(KClassifier klass, List<KTypeProjection> arguments, boolean isMarkedNullable) {
        if (klass instanceof ClassBasedDeclarationContainer) {
            return CachesKt.getOrCreateKType(((ClassBasedDeclarationContainer) klass).getJClass(), arguments, isMarkedNullable);
        }
        return KClassifiers.createType(klass, arguments, isMarkedNullable, Collections.emptyList());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KTypeParameter typeParameter(Object container, String name, KVariance variance, boolean isReified) {
        List<KTypeParameter> typeParameters;
        if (container instanceof KClass) {
            typeParameters = ((KClass) container).getTypeParameters();
        } else if (container instanceof KCallable) {
            typeParameters = ((KCallable) container).getTypeParameters();
        } else {
            throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + container);
        }
        for (KTypeParameter typeParameter : typeParameters) {
            if (typeParameter.getName().equals(name)) {
                return typeParameter;
            }
        }
        throw new IllegalArgumentException("Type parameter " + name + " is not found in container: " + container);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public void setUpperBounds(KTypeParameter typeParameter, List<KType> bounds) {
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType platformType(KType lowerBound, KType upperBound) {
        return TypeOfImplKt.createPlatformKType(lowerBound, upperBound);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType mutableCollectionType(KType type) {
        return TypeOfImplKt.createMutableCollectionKType(type);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType nothingType(KType type) {
        return TypeOfImplKt.createNothingType(type);
    }

    public static void clearCaches() {
        CachesKt.clearCaches();
        ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
    }
}