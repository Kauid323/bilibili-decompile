package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.KClassesJvm;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ReflectionObjectRenderer.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006*\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\t\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u001c\u0010\r\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u0018\u0010\u000e\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u00102\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014J\u0012\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0012\u0010\u0018\u001a\u00020\u00102\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0017J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020!2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0002J\u0018\u0010$\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J:\u0010%\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010&\u001a\u00020 2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+H\u0002J&\u0010,\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002¨\u00061"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "<init>", "()V", "appendReceiverType", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/KParameter;", "appendReceivers", "", "callable", "Lkotlin/reflect/KCallable;", "appendContexts", "appendName", "name", "", "renderCallable", "renderProperty", "property", "Lkotlin/reflect/KProperty;", "renderFunction", "function", "Lkotlin/reflect/KFunction;", "renderLambda", "lambda", "renderParameter", "parameter", "renderType", "type", "Lkotlin/reflect/KType;", "getTypeClassFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqNameUnsafe;", "Lkotlin/reflect/jvm/internal/AbstractKType;", "klass", "Lkotlin/reflect/KClass;", "renderFunctionType", "renderSimpleType", "classFqName", "allArguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "renderTypeArgumentsAndNullability", "typeArguments", "renderFlexibleType", "lowerRendered", "upperRendered", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();

    /* compiled from: ReflectionObjectRenderer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            try {
                iArr[KParameter.Kind.INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KParameter.Kind.CONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[KParameter.Kind.VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final StringBuilder appendReceiverType(StringBuilder $this$appendReceiverType, KParameter receiver) {
        StringBuilder append = $this$appendReceiverType.append(renderType(receiver.getType())).append(".");
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    private final void appendReceivers(StringBuilder $this$appendReceivers, KCallable<?> kCallable) {
        Intrinsics.checkNotNull(kCallable, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KCallableImpl<*>");
        Iterable $this$filter$iv = ((KCallableImpl) kCallable).getReceiverParameters();
        Collection destination$iv$iv = new ArrayList();
        Iterator<T> it = $this$filter$iv.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            KParameter it2 = (KParameter) element$iv$iv;
            if (it2.getKind() != KParameter.Kind.INSTANCE && it2.getKind() != KParameter.Kind.EXTENSION_RECEIVER) {
                z = false;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List receivers = (List) destination$iv$iv;
        KParameter it3 = (KParameter) CollectionsKt.getOrNull(receivers, 0);
        if (it3 != null) {
            INSTANCE.appendReceiverType($this$appendReceivers, it3);
        }
        KParameter it4 = (KParameter) CollectionsKt.getOrNull(receivers, 1);
        if (it4 != null) {
            ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
            StringBuilder append = $this$appendReceivers.append("(");
            Intrinsics.checkNotNullExpressionValue(append, "append(...)");
            reflectionObjectRenderer.appendReceiverType(append, it4).append(")");
        }
    }

    private final void appendContexts(StringBuilder $this$appendContexts, KCallable<?> kCallable) {
        List parameters = KCallables.getContextParameters(kCallable);
        if (parameters.isEmpty()) {
            return;
        }
        CollectionsKt.joinTo(parameters, $this$appendContexts, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : "context(", (r14 & 8) != 0 ? "" : ") ", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence appendContexts$lambda$0;
                appendContexts$lambda$0 = ReflectionObjectRenderer.appendContexts$lambda$0((KParameter) obj);
                return appendContexts$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendContexts$lambda$0(KParameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        String name = parameter.getName();
        if (name == null) {
            name = "_";
        }
        return sb.append(name).append(": ").append(parameter.getType()).toString();
    }

    private final void appendName(StringBuilder $this$appendName, String name) {
        Name identifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        $this$appendName.append(RenderingUtilsKt.render(identifier));
    }

    private final String renderCallable(KCallable<?> kCallable) {
        if (kCallable instanceof KProperty) {
            return renderProperty((KProperty) kCallable);
        }
        if (kCallable instanceof KFunction) {
            return renderFunction((KFunction) kCallable);
        }
        throw new IllegalStateException(("Illegal callable: " + kCallable).toString());
    }

    public final String renderProperty(KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        StringBuilder $this$renderProperty_u24lambda_u240 = new StringBuilder();
        INSTANCE.appendContexts($this$renderProperty_u24lambda_u240, property);
        $this$renderProperty_u24lambda_u240.append(property instanceof KMutableProperty ? "var " : "val ");
        INSTANCE.appendReceivers($this$renderProperty_u24lambda_u240, property);
        INSTANCE.appendName($this$renderProperty_u24lambda_u240, property.getName());
        $this$renderProperty_u24lambda_u240.append(": ");
        $this$renderProperty_u24lambda_u240.append(INSTANCE.renderType(property.getReturnType()));
        return $this$renderProperty_u24lambda_u240.toString();
    }

    public final String renderFunction(KFunction<?> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        StringBuilder $this$renderFunction_u24lambda_u240 = new StringBuilder();
        INSTANCE.appendContexts($this$renderFunction_u24lambda_u240, function);
        $this$renderFunction_u24lambda_u240.append("fun ");
        INSTANCE.appendReceivers($this$renderFunction_u24lambda_u240, function);
        INSTANCE.appendName($this$renderFunction_u24lambda_u240, function.getName());
        CollectionsKt.joinTo(KCallables.getValueParameters(function), $this$renderFunction_u24lambda_u240, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) != 0 ? "" : ")", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence renderFunction$lambda$0$0;
                renderFunction$lambda$0$0 = ReflectionObjectRenderer.renderFunction$lambda$0$0((KParameter) obj);
                return renderFunction$lambda$0$0;
            }
        });
        $this$renderFunction_u24lambda_u240.append(": ");
        $this$renderFunction_u24lambda_u240.append(INSTANCE.renderType(function.getReturnType()));
        return $this$renderFunction_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderFunction$lambda$0$0(KParameter it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.renderType(it.getType());
    }

    public final String renderLambda(KFunction<?> lambda) {
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        StringBuilder $this$renderLambda_u24lambda_u240 = new StringBuilder();
        KParameter it = KCallables.getExtensionReceiverParameter(lambda);
        if (it != null) {
            $this$renderLambda_u24lambda_u240.append(INSTANCE.renderType(it.getType()));
            $this$renderLambda_u24lambda_u240.append(".");
        }
        CollectionsKt.joinTo(KCallables.getValueParameters(lambda), $this$renderLambda_u24lambda_u240, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) != 0 ? "" : ")", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence renderLambda$lambda$0$1;
                renderLambda$lambda$0$1 = ReflectionObjectRenderer.renderLambda$lambda$0$1((KParameter) obj);
                return renderLambda$lambda$0$1;
            }
        });
        $this$renderLambda_u24lambda_u240.append(" -> ");
        $this$renderLambda_u24lambda_u240.append(INSTANCE.renderType(lambda.getReturnType()));
        return $this$renderLambda_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderLambda$lambda$0$1(KParameter it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.renderType(it.getType());
    }

    public final String renderParameter(KParameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        StringBuilder $this$renderParameter_u24lambda_u240 = new StringBuilder();
        switch (WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()]) {
            case 1:
                $this$renderParameter_u24lambda_u240.append("instance parameter");
                break;
            case 2:
                $this$renderParameter_u24lambda_u240.append("context parameter " + parameter.getName());
                break;
            case 3:
                $this$renderParameter_u24lambda_u240.append("extension receiver parameter");
                break;
            case 4:
                $this$renderParameter_u24lambda_u240.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        $this$renderParameter_u24lambda_u240.append(" of ");
        $this$renderParameter_u24lambda_u240.append(INSTANCE.renderCallable(((KParameterImpl) parameter).getCallable()));
        return $this$renderParameter_u24lambda_u240.toString();
    }

    public final String renderType(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        AbstractKType lowerBound = ((AbstractKType) type).lowerBoundIfFlexible();
        AbstractKType upperBound = ((AbstractKType) type).upperBoundIfFlexible();
        if (lowerBound != null && upperBound != null) {
            return renderFlexibleType(renderType(lowerBound), renderType(upperBound));
        }
        StringBuilder $this$renderType_u24lambda_u240 = new StringBuilder();
        KType it = ((AbstractKType) type).getAbbreviation();
        if (it != null) {
            $this$renderType_u24lambda_u240.append(it);
            $this$renderType_u24lambda_u240.append(" /* = ");
        }
        KClassifier classifier = type.getClassifier();
        if (classifier instanceof KTypeParameter) {
            INSTANCE.appendName($this$renderType_u24lambda_u240, ((KTypeParameter) classifier).getName());
            if (type.isMarkedNullable()) {
                $this$renderType_u24lambda_u240.append("?");
            } else if (((AbstractKType) type).isDefinitelyNotNullType()) {
                $this$renderType_u24lambda_u240.append(" & Any");
            }
        } else if (classifier instanceof KClass) {
            FqNameUnsafe typeClassFqName = INSTANCE.getTypeClassFqName((AbstractKType) type, (KClass) classifier);
            if (typeClassFqName == null) {
                typeClassFqName = new FqNameUnsafe(KClassesJvm.getJvmName((KClass) classifier));
            }
            FqNameUnsafe fqName = typeClassFqName;
            if (FunctionTypesKt.isNumberedFunctionClassFqName(fqName) && !type.getArguments().contains(KTypeProjection.Companion.getSTAR())) {
                INSTANCE.renderFunctionType($this$renderType_u24lambda_u240, type);
            } else {
                INSTANCE.renderSimpleType($this$renderType_u24lambda_u240, (KClass) classifier, fqName, type.getArguments(), type.isMarkedNullable());
            }
        } else if (!(classifier instanceof KTypeAliasImpl)) {
            $this$renderType_u24lambda_u240.append("???");
        } else {
            CollectionsKt.joinTo(((KTypeAliasImpl) classifier).getFqName().pathSegments(), $this$renderType_u24lambda_u240, (r14 & 2) != 0 ? ", " : ".", (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? "" : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    CharSequence renderType$lambda$0$1;
                    renderType$lambda$0$1 = ReflectionObjectRenderer.renderType$lambda$0$1((Name) obj);
                    return renderType$lambda$0$1;
                }
            });
            INSTANCE.renderTypeArgumentsAndNullability($this$renderType_u24lambda_u240, type.getArguments(), type.isMarkedNullable());
        }
        if (((AbstractKType) type).getAbbreviation() != null) {
            $this$renderType_u24lambda_u240.append(" */");
        }
        return $this$renderType_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderType$lambda$0$1(Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return RenderingUtilsKt.render(it);
    }

    private final FqNameUnsafe getTypeClassFqName(AbstractKType type, KClass<?> kClass) {
        if (type.isNothingType()) {
            return StandardNames.FqNames.nothing;
        }
        String p0 = kClass.getQualifiedName();
        if (p0 != null) {
            FqNameUnsafe fqName = new FqNameUnsafe(p0);
            if (type.isMutableCollectionType()) {
                FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(fqName);
                if (readOnlyToMutable != null) {
                    return readOnlyToMutable.toUnsafe();
                }
                return null;
            }
            return fqName;
        }
        return null;
    }

    private final void renderFunctionType(StringBuilder $this$renderFunctionType, KType type) {
        if (type.isMarkedNullable()) {
            $this$renderFunctionType.append("(");
        }
        CollectionsKt.joinTo(CollectionsKt.dropLast(type.getArguments(), 1), $this$renderFunctionType, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : "(", (r14 & 8) != 0 ? "" : ") -> ", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        $this$renderFunctionType.append(CollectionsKt.last((List<? extends Object>) type.getArguments()));
        if (type.isMarkedNullable()) {
            $this$renderFunctionType.append(")?");
        }
    }

    private final void renderSimpleType(StringBuilder $this$renderSimpleType, KClass<?> kClass, FqNameUnsafe classFqName, List<KTypeProjection> list, boolean isMarkedNullable) {
        if (kClass.getTypeParameters().size() < list.size() && JvmClassMappingKt.getJavaClass((KClass) kClass).getDeclaringClass() != null) {
            Class<?> declaringClass = JvmClassMappingKt.getJavaClass((KClass) kClass).getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            renderSimpleType($this$renderSimpleType, JvmClassMappingKt.getKotlinClass(declaringClass), classFqName.parent(), CollectionsKt.drop(list, kClass.getTypeParameters().size()), false);
            $this$renderSimpleType.append(".");
            $this$renderSimpleType.append(RenderingUtilsKt.render(classFqName.shortName()));
        } else {
            $this$renderSimpleType.append(RenderingUtilsKt.render(classFqName));
        }
        renderTypeArgumentsAndNullability($this$renderSimpleType, CollectionsKt.take(list, kClass.getTypeParameters().size()), isMarkedNullable);
    }

    private final void renderTypeArgumentsAndNullability(StringBuilder $this$renderTypeArgumentsAndNullability, List<KTypeProjection> list, boolean isMarkedNullable) {
        if (!list.isEmpty()) {
            CollectionsKt.joinTo(list, $this$renderTypeArgumentsAndNullability, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : "<", (r14 & 8) != 0 ? "" : ">", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        }
        if (isMarkedNullable) {
            $this$renderTypeArgumentsAndNullability.append("?");
        }
    }

    private final String renderFlexibleType(final String lowerRendered, String upperRendered) {
        if (Intrinsics.areEqual(lowerRendered, StringsKt.replace$default(upperRendered, "?", "", false, 4, (Object) null))) {
            return StringsKt.replace$default(upperRendered, "?", "!", false, 4, (Object) null);
        }
        if (StringsKt.endsWith$default(upperRendered, "?", false, 2, (Object) null) && Intrinsics.areEqual(lowerRendered + '?', upperRendered)) {
            return lowerRendered + '!';
        }
        if (Intrinsics.areEqual('(' + lowerRendered + ")?", upperRendered)) {
            return '(' + lowerRendered + ")!";
        }
        String renderFlexibleMutabilityOrArrayElementVarianceType$default = RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$default(lowerRendered, upperRendered, new Function0(lowerRendered) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$4
            private final String arg$0;

            {
                this.arg$0 = lowerRendered;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String renderFlexibleType$lambda$0;
                renderFlexibleType$lambda$0 = ReflectionObjectRenderer.renderFlexibleType$lambda$0(this.arg$0);
                return renderFlexibleType$lambda$0;
            }
        }, new Function0(lowerRendered) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$5
            private final String arg$0;

            {
                this.arg$0 = lowerRendered;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String renderFlexibleType$lambda$1;
                renderFlexibleType$lambda$1 = ReflectionObjectRenderer.renderFlexibleType$lambda$1(this.arg$0);
                return renderFlexibleType$lambda$1;
            }
        }, null, 16, null);
        if (renderFlexibleMutabilityOrArrayElementVarianceType$default != null) {
            return renderFlexibleMutabilityOrArrayElementVarianceType$default;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$0(String $lowerRendered) {
        String it = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.asString() + FilenameUtils.EXTENSION_SEPARATOR;
        if (!StringsKt.startsWith$default($lowerRendered, it, false, 2, (Object) null)) {
            it = null;
        }
        return it == null ? "" : it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$1(String $lowerRendered) {
        String it = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.asString() + FilenameUtils.EXTENSION_SEPARATOR;
        if (!StringsKt.startsWith$default($lowerRendered, it, false, 2, (Object) null)) {
            it = null;
        }
        return it == null ? "" : it;
    }
}