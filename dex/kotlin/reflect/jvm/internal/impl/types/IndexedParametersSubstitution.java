package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    public IndexedParametersSubstitution(TypeParameterDescriptor[] parameters, TypeProjection[] arguments, boolean approximateContravariantCapturedTypes) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.parameters = parameters;
        this.arguments = arguments;
        this.approximateContravariantCapturedTypes = approximateContravariantCapturedTypes;
        if (this.parameters.length <= this.arguments.length) {
            return;
        }
        throw new AssertionError("Number of arguments should not be less than number of parameters, but: parameters=" + this.parameters.length + ", args=" + this.arguments.length);
    }

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> parameters, List<? extends TypeProjection> argumentsList) {
        this(r5, (TypeProjection[]) $this$toTypedArray$iv.toArray(new TypeProjection[0]), false, 4, null);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(argumentsList, "argumentsList");
        List<? extends TypeParameterDescriptor> $this$toTypedArray$iv = parameters;
        TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) $this$toTypedArray$iv.toArray(new TypeParameterDescriptor[0]);
        List<? extends TypeProjection> $this$toTypedArray$iv2 = argumentsList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjection mo1176get(KotlinType key) {
        int index;
        Intrinsics.checkNotNullParameter(key, "key");
        ClassifierDescriptor mo1171getDeclarationDescriptor = key.getConstructor().mo1171getDeclarationDescriptor();
        TypeParameterDescriptor parameter = mo1171getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo1171getDeclarationDescriptor : null;
        if (parameter != null && (index = parameter.getIndex()) < this.parameters.length && Intrinsics.areEqual(this.parameters[index].getTypeConstructor(), parameter.getTypeConstructor())) {
            return this.arguments[index];
        }
        return null;
    }
}