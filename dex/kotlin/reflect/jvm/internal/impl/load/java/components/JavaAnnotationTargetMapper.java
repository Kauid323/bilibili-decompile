package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaAnnotationTargetMapper {
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists = MapsKt.mapOf(TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
    private static final Map<String, KotlinRetention> retentionNameList = MapsKt.mapOf(TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE));

    private JavaAnnotationTargetMapper() {
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String argumentName) {
        EnumSet<KotlinTarget> enumSet = targetNameLists.get(argumentName);
        return enumSet != null ? enumSet : SetsKt.emptySet();
    }

    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(List<? extends JavaAnnotationArgument> arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        List<? extends JavaAnnotationArgument> $this$filterIsInstance$iv = arguments;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof JavaEnumValueAnnotationArgument) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<JavaEnumValueAnnotationArgument> $this$flatMap$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (JavaEnumValueAnnotationArgument it : $this$flatMap$iv) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = INSTANCE;
            Name entryName = it.getEntryName();
            Iterable list$iv$iv = javaAnnotationTargetMapper.mapJavaTargetArgumentByName(entryName != null ? entryName.asString() : null);
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
        }
        Iterable $this$map$iv = (List) destination$iv$iv2;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KotlinTarget kotlinTarget = (KotlinTarget) item$iv$iv;
            ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.annotationTarget);
            Name identifier = Name.identifier(kotlinTarget.name());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            destination$iv$iv3.add(new EnumValue(classId, identifier));
        }
        List kotlinTargets = (List) destination$iv$iv3;
        return new ArrayValue(kotlinTargets, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                KotlinType mapJavaTargetArguments$lambda$2;
                mapJavaTargetArguments$lambda$2 = JavaAnnotationTargetMapper.mapJavaTargetArguments$lambda$2((ModuleDescriptor) obj);
                return mapJavaTargetArguments$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType mapJavaTargetArguments$lambda$2(ModuleDescriptor module) {
        KotlinType type;
        Intrinsics.checkNotNullParameter(module, "module");
        ValueParameterDescriptor parameterDescriptor = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), module.getBuiltIns().getBuiltInClassByFqName(StandardNames.FqNames.target));
        return (parameterDescriptor == null || (type = parameterDescriptor.getType()) == null) ? ErrorUtils.createErrorType(ErrorTypeKind.UNMAPPED_ANNOTATION_TARGET_TYPE, new String[0]) : type;
    }

    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationArgument element) {
        EnumValue enumValue = null;
        JavaEnumValueAnnotationArgument it = element instanceof JavaEnumValueAnnotationArgument ? (JavaEnumValueAnnotationArgument) element : null;
        if (it != null) {
            Map<String, KotlinRetention> map = retentionNameList;
            Name entryName = it.getEntryName();
            KotlinRetention retention = map.get(entryName != null ? entryName.asString() : null);
            if (retention != null) {
                ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.annotationRetention);
                Name identifier = Name.identifier(retention.name());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
                enumValue = new EnumValue(classId, identifier);
            }
        }
        return enumValue;
    }
}