package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
    protected Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory;
    private final boolean isVar;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
                objArr[0] = "compileTimeInitializerFactory";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        switch (i) {
            case 4:
                objArr[2] = "setCompileTimeInitializerFactory";
                break;
            case 5:
                objArr[2] = "setCompileTimeInitializer";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor containingDeclaration, Annotations annotations, Name name, KotlinType outType, boolean isVar, SourceElement source) {
        super(containingDeclaration, annotations, name, outType, source);
        if (containingDeclaration == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (source == null) {
            $$$reportNull$$$0(3);
        }
        this.isVar = isVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.isVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* renamed from: getCompileTimeInitializer */
    public ConstantValue<?> mo1163getCompileTimeInitializer() {
        if (this.compileTimeInitializer != null) {
            return this.compileTimeInitializer.invoke();
        }
        return null;
    }

    public void setCompileTimeInitializerFactory(Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory) {
        if (compileTimeInitializerFactory == null) {
            $$$reportNull$$$0(4);
        }
        if (isVar()) {
            throw new AssertionError("Constant value for variable initializer should be recorded only for final variables: " + getName());
        }
        setCompileTimeInitializer(null, compileTimeInitializerFactory);
    }

    public void setCompileTimeInitializer(NullableLazyValue<ConstantValue<?>> compileTimeInitializer, Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory) {
        if (compileTimeInitializerFactory == null) {
            $$$reportNull$$$0(5);
        }
        if (isVar()) {
            throw new AssertionError("Constant value for variable initializer should be recorded only for final variables: " + getName());
        }
        this.compileTimeInitializerFactory = compileTimeInitializerFactory;
        this.compileTimeInitializer = compileTimeInitializer != null ? compileTimeInitializer : compileTimeInitializerFactory.invoke();
    }
}