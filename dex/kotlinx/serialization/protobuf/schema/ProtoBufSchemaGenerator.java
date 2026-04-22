package kotlinx.serialization.protobuf.schema;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.protobuf.ProtoIntegerType;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;
import kotlinx.serialization.protobuf.ProtoType;
import kotlinx.serialization.protobuf.internal.HelpersKt;
import kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ProtoBufSchemaGenerator.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u001b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002FGB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"H\u0002J \u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0016H\u0002J(\u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0016H\u0002J8\u0010*\u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160-H\u0007J2\u0010*\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160-H\u0007J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0002J \u00101\u001a\u00020 *\u00020\u00162\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001603H\u0002J\u001a\u00104\u001a\u00020 *\u00020\u00162\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001605H\u0002J(\u00106\u001a\u00020 *\u000607j\u0002`82\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010;\u001a\u00020 *\u000607j\u0002`82\u0006\u0010<\u001a\u00020\u0006H\u0002J&\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\"*\u000607j\u0002`82\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0002J&\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060\"*\u000607j\u0002`82\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0002J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\"*\u000607j\u0002`82\u0006\u0010$\u001a\u00020\u0006H\u0002J&\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060\"*\u000607j\u0002`82\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0002J<\u0010A\u001a\u00020 *\u000607j\u0002`82\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"2\b\u0010+\u001a\u0004\u0018\u00010\u00162\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160-H\u0002J\u001c\u0010B\u001a\u00020\u0016*\u00020\t2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\"H\u0002J\u001c\u0010E\u001a\u00020\u0016*\u00020\t2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\nR\u0018\u0010\u000b\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0018\u0010\u000e\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0018\u0010\u0010\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0018\u0010\u0012\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0018\u0010\u0013\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0018\u0010\u0014\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0018\u0010\u0015\u001a\u00020\u0016*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u001a*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u0016*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006H"}, d2 = {"Lkotlinx/serialization/protobuf/schema/ProtoBufSchemaGenerator;", "", "()V", "IDENTIFIER_REGEX", "Lkotlin/text/Regex;", "SyntheticPolymorphicType", "Lkotlinx/serialization/protobuf/schema/ProtoBufSchemaGenerator$TypeDefinition;", "isOpenPolymorphic", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isProtobufCollection", "isProtobufEnum", "isProtobufMap", "isProtobufMessage", "isProtobufMessageOrEnum", "isProtobufNamedType", "isProtobufRepeated", "isProtobufScalar", "isSealedPolymorphic", "isValidMapKey", "messageOrEnumName", "", "getMessageOrEnumName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/String;", "notNull", "Lkotlinx/serialization/protobuf/schema/ProtoBufSchemaGenerator$NotNullSerialDescriptor;", "getNotNull", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/protobuf/schema/ProtoBufSchemaGenerator$NotNullSerialDescriptor;", "protobufEnumElementName", "getProtobufEnumElementName", "checkDoubles", "", "descriptors", "", "createLegacyMapType", "messageType", "index", "", "description", "createNestedCollectionType", "elementDescriptor", "generateSchemaText", "packageName", "options", "", "rootDescriptor", "removeLineBreaks", "text", "checkIsValidFullIdentifier", "messageSupplier", "Lkotlin/Function1;", "checkIsValidIdentifier", "Lkotlin/Function0;", "generateCollectionAbsenceComment", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "messageDescriptor", "collectionDescriptor", "generateEnum", "enumType", "generateListType", "generateMapType", "generateMessage", "generateNamedType", "generateProto2SchemaText", "protobufTypeName", "annotations", "", "scalarTypeName", "NotNullSerialDescriptor", "TypeDefinition", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ProtoBufSchemaGenerator {
    public static final ProtoBufSchemaGenerator INSTANCE = new ProtoBufSchemaGenerator();
    private static final TypeDefinition SyntheticPolymorphicType = new TypeDefinition(SerialDescriptorsKt.buildClassSerialDescriptor("KotlinxSerializationPolymorphic", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$SyntheticPolymorphicType$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "type", SerialDescriptorsKt.PrimitiveSerialDescriptor("typeDescriptor", PrimitiveKind.STRING.INSTANCE), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor("valueDescriptor", StructureKind.LIST.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$SyntheticPolymorphicType$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    invoke2(classSerialDescriptorBuilder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                    Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                    ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "0", BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
                }
            }), null, false, 12, null);
        }
    }), true, "polymorphic types", null, null, 24, null);
    private static final Regex IDENTIFIER_REGEX = new Regex("[A-Za-z][A-Za-z0-9_]*");

    /* compiled from: ProtoBufSchemaGenerator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoIntegerType.values().length];
            try {
                iArr[ProtoIntegerType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ProtoIntegerType.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ProtoIntegerType.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ProtoBufSchemaGenerator() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String generateSchemaText$default(ProtoBufSchemaGenerator protoBufSchemaGenerator, SerialDescriptor serialDescriptor, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return protoBufSchemaGenerator.generateSchemaText(serialDescriptor, str, map);
    }

    @ExperimentalSerializationApi
    public final String generateSchemaText(SerialDescriptor rootDescriptor, String packageName, Map<String, String> options) {
        Intrinsics.checkNotNullParameter(rootDescriptor, "rootDescriptor");
        Intrinsics.checkNotNullParameter(options, "options");
        return generateSchemaText(CollectionsKt.listOf(rootDescriptor), packageName, options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String generateSchemaText$default(ProtoBufSchemaGenerator protoBufSchemaGenerator, List list, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return protoBufSchemaGenerator.generateSchemaText(list, str, map);
    }

    @ExperimentalSerializationApi
    public final String generateSchemaText(List<? extends SerialDescriptor> descriptors, String packageName, Map<String, String> options) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        Intrinsics.checkNotNullParameter(options, "options");
        if (packageName != null) {
            INSTANCE.checkIsValidFullIdentifier(packageName, new Function1<String, String>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$generateSchemaText$1$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "Incorrect protobuf package name '" + it + '\'';
                }
            });
        }
        checkDoubles(descriptors);
        StringBuilder builder = new StringBuilder();
        generateProto2SchemaText(builder, descriptors, packageName, options);
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "builder.toString()");
        return sb;
    }

    private final void checkDoubles(List<? extends SerialDescriptor> list) {
        Set rootTypesNames = new LinkedHashSet();
        List duplicates = new ArrayList();
        List<? extends SerialDescriptor> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(INSTANCE.getMessageOrEnumName((SerialDescriptor) item$iv$iv));
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            if (!rootTypesNames.add(it)) {
                duplicates.add(it);
            }
        }
        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException("Serial names of the following types are duplicated: " + duplicates);
        }
    }

    private final void generateProto2SchemaText(StringBuilder $this$generateProto2SchemaText, List<? extends SerialDescriptor> list, String packageName, Map<String, String> map) {
        StringBuilder append = $this$generateProto2SchemaText.append("syntax = \"proto2\";");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
        if (packageName != null) {
            StringBuilder append3 = $this$generateProto2SchemaText.append("package ").append(packageName);
            Intrinsics.checkNotNullExpressionValue(append3, "append(\"package \").append(it)");
            StringBuilder append4 = append3.append(';');
            Intrinsics.checkNotNullExpressionValue(append4, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append('\\n')");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String optionName = entry.getKey();
            String optionValue = entry.getValue();
            String safeOptionName = removeLineBreaks(optionName);
            String safeOptionValue = removeLineBreaks(optionValue);
            checkIsValidFullIdentifier(safeOptionName, new Function1<String, String>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$generateProto2SchemaText$2
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "Invalid option name '" + it + '\'';
                }
            });
            StringBuilder append5 = $this$generateProto2SchemaText.append("option ").append(safeOptionName).append(" = \"").append(safeOptionValue);
            Intrinsics.checkNotNullExpressionValue(append5, "append(\"option \").append…).append(safeOptionValue)");
            StringBuilder append6 = append5.append("\";");
            Intrinsics.checkNotNullExpressionValue(append6, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append('\\n')");
        }
        Set generatedTypes = new LinkedHashSet();
        ArrayDeque queue = new ArrayDeque();
        List<? extends SerialDescriptor> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SerialDescriptor it = (SerialDescriptor) item$iv$iv;
            destination$iv$iv.add(new TypeDefinition(it, false, null, null, null, 30, null));
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            TypeDefinition it2 = (TypeDefinition) element$iv;
            queue.add(it2);
        }
        while (!queue.isEmpty()) {
            TypeDefinition type = (TypeDefinition) queue.removeFirst();
            SerialDescriptor descriptor = type.getDescriptor();
            String name = getMessageOrEnumName(descriptor);
            if (generatedTypes.add(name)) {
                Intrinsics.checkNotNullExpressionValue($this$generateProto2SchemaText.append('\n'), "append('\\n')");
                if (isProtobufMessage(descriptor)) {
                    queue.addAll(generateMessage($this$generateProto2SchemaText, type));
                } else if (!isProtobufEnum(descriptor)) {
                    throw new IllegalStateException("Unrecognized custom type with serial name '" + descriptor.getSerialName() + "' and kind '" + descriptor.getKind() + '\'');
                } else {
                    generateEnum($this$generateProto2SchemaText, type);
                }
            }
        }
    }

    private final List<TypeDefinition> generateMessage(StringBuilder $this$generateMessage, TypeDefinition messageType) {
        final String messageName;
        List<TypeDefinition> generateMapType;
        char c;
        ProtoBufSchemaGenerator protoBufSchemaGenerator = this;
        TypeDefinition typeDefinition = messageType;
        final SerialDescriptor messageDescriptor = messageType.getDescriptor();
        if (messageType.isSynthetic()) {
            StringBuilder append = $this$generateMessage.append("// This message was generated to support ").append(messageType.getAbility());
            Intrinsics.checkNotNullExpressionValue(append, "append(\"// This message …pend(messageType.ability)");
            StringBuilder append2 = append.append(" and does not present in Kotlin.");
            Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
            messageName = messageDescriptor.getSerialName();
            if (messageType.getContainingMessageName() != null) {
                StringBuilder append3 = $this$generateMessage.append("// Containing message '").append(messageType.getContainingMessageName()).append("', field '").append(messageType.getFieldName());
                Intrinsics.checkNotNullExpressionValue(append3, "append(\"// Containing me…nd(messageType.fieldName)");
                StringBuilder append4 = append3.append('\'');
                Intrinsics.checkNotNullExpressionValue(append4, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append('\\n')");
            }
        } else {
            messageName = protoBufSchemaGenerator.getMessageOrEnumName(messageDescriptor);
            protoBufSchemaGenerator.checkIsValidIdentifier(messageName, new Function0<String>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$generateMessage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Invalid name for the message in protobuf schema '" + messageName + "'. Serial name of the class '" + messageDescriptor.getSerialName() + '\'';
                }
            });
            String safeSerialName = protoBufSchemaGenerator.removeLineBreaks(messageDescriptor.getSerialName());
            if (!Intrinsics.areEqual(safeSerialName, messageName)) {
                StringBuilder append5 = $this$generateMessage.append("// serial name '").append(safeSerialName);
                Intrinsics.checkNotNullExpressionValue(append5, "append(\"// serial name '\").append(safeSerialName)");
                StringBuilder append6 = append5.append('\'');
                Intrinsics.checkNotNullExpressionValue(append6, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append('\\n')");
            }
        }
        StringBuilder append7 = $this$generateMessage.append("message ").append(messageName);
        Intrinsics.checkNotNullExpressionValue(append7, "append(\"message \").append(messageName)");
        StringBuilder append8 = append7.append(" {");
        Intrinsics.checkNotNullExpressionValue(append8, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append8.append('\n'), "append('\\n')");
        Set usedNumbers = new LinkedHashSet();
        List nestedTypes = new ArrayList();
        int index = 0;
        int elementsCount = messageDescriptor.getElementsCount();
        while (index < elementsCount) {
            final String fieldName = messageDescriptor.getElementName(index);
            protoBufSchemaGenerator.checkIsValidIdentifier(fieldName, new Function0<String>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$generateMessage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Invalid name of the field '" + fieldName + "' in message '" + messageName + "' for class with serial name '" + messageDescriptor.getSerialName() + '\'';
                }
            });
            SerialDescriptor fieldDescriptor = messageDescriptor.getElementDescriptor(index);
            boolean isList = protoBufSchemaGenerator.isProtobufRepeated(fieldDescriptor);
            List list = nestedTypes;
            if (protoBufSchemaGenerator.isProtobufNamedType(fieldDescriptor)) {
                generateMapType = protoBufSchemaGenerator.generateNamedType($this$generateMessage, typeDefinition, index);
            } else if (isList) {
                generateMapType = protoBufSchemaGenerator.generateListType($this$generateMessage, typeDefinition, index);
            } else if (!protoBufSchemaGenerator.isProtobufMap(fieldDescriptor)) {
                throw new IllegalStateException("Unprocessed message field type with serial name '" + fieldDescriptor.getSerialName() + "' and kind '" + fieldDescriptor.getKind() + '\'');
            } else {
                generateMapType = protoBufSchemaGenerator.generateMapType($this$generateMessage, typeDefinition, index);
            }
            CollectionsKt.addAll(list, generateMapType);
            Iterable annotations = messageDescriptor.getElementAnnotations(index);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : annotations) {
                if (element$iv$iv instanceof ProtoNumber) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            ProtoNumber protoNumber = (ProtoNumber) CollectionsKt.singleOrNull((List<? extends Object>) destination$iv$iv);
            int number = protoNumber != null ? protoNumber.number() : index + 1;
            if (!usedNumbers.add(Integer.valueOf(number))) {
                throw new IllegalArgumentException("Field number " + number + " is repeated in the class with serial name " + messageDescriptor.getSerialName());
            }
            $this$generateMessage.append(' ').append(fieldName).append(" = ").append(number);
            Iterable $this$filterIsInstance$iv = annotations;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                Iterable $this$filterIsInstance$iv2 = $this$filterIsInstance$iv;
                String messageName2 = messageName;
                if (element$iv$iv2 instanceof ProtoPacked) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
                $this$filterIsInstance$iv = $this$filterIsInstance$iv2;
                messageName = messageName2;
            }
            String messageName3 = messageName;
            boolean isPackRequested = CollectionsKt.singleOrNull((List<? extends Object>) ((List) destination$iv$iv2)) != null;
            if (!isPackRequested) {
                c = '\n';
            } else if (!isList) {
                c = '\n';
            } else if (HelpersKt.isPackable(fieldDescriptor.getElementDescriptor(0))) {
                StringBuilder append9 = $this$generateMessage.append(" [packed=true];");
                Intrinsics.checkNotNullExpressionValue(append9, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append9.append('\n'), "append('\\n')");
                index++;
                protoBufSchemaGenerator = this;
                typeDefinition = messageType;
                messageName = messageName3;
            } else {
                c = '\n';
            }
            StringBuilder append10 = $this$generateMessage.append(';');
            Intrinsics.checkNotNullExpressionValue(append10, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append10.append(c), "append('\\n')");
            index++;
            protoBufSchemaGenerator = this;
            typeDefinition = messageType;
            messageName = messageName3;
        }
        StringBuilder append11 = $this$generateMessage.append(AbstractJsonLexerKt.END_OBJ);
        Intrinsics.checkNotNullExpressionValue(append11, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append11.append('\n'), "append('\\n')");
        return nestedTypes;
    }

    private final List<TypeDefinition> generateNamedType(StringBuilder $this$generateNamedType, TypeDefinition messageType, int index) {
        boolean z;
        char c;
        List nestedTypes;
        String typeName;
        SerialDescriptor messageDescriptor = messageType.getDescriptor();
        SerialDescriptor fieldDescriptor = messageDescriptor.getElementDescriptor(index);
        char c2 = '\n';
        if (isSealedPolymorphic(messageDescriptor) && index == 1) {
            StringBuilder append = $this$generateNamedType.append("  // decoded as message with one of these types:");
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            Iterable $this$map$iv = SerialDescriptorKt.getElementDescriptors(fieldDescriptor);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                SerialDescriptor it = (SerialDescriptor) item$iv$iv;
                destination$iv$iv.add(new TypeDefinition(it, false, null, null, null, 30, null));
            }
            Iterable nestedTypes2 = CollectionsKt.toList((List) destination$iv$iv);
            Iterable $this$forEachIndexed$iv = nestedTypes2;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TypeDefinition childType = (TypeDefinition) item$iv;
                Iterable nestedTypes3 = nestedTypes2;
                StringBuilder append2 = $this$generateNamedType.append("  //   message ").append(INSTANCE.getMessageOrEnumName(childType.getDescriptor())).append(", serial name '").append(INSTANCE.removeLineBreaks(childType.getDescriptor().getSerialName()));
                Intrinsics.checkNotNullExpressionValue(append2, "append(\"  //   message \"…e.descriptor.serialName))");
                StringBuilder append3 = append2.append('\'');
                Intrinsics.checkNotNullExpressionValue(append3, "append(value)");
                c2 = '\n';
                Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append('\\n')");
                index$iv = index$iv2;
                nestedTypes2 = nestedTypes3;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv;
            }
            nestedTypes = nestedTypes2;
            typeName = scalarTypeName$default(this, fieldDescriptor, null, 1, null);
            z = true;
            c = c2;
        } else if (isProtobufScalar(fieldDescriptor)) {
            List nestedTypes4 = CollectionsKt.emptyList();
            nestedTypes = nestedTypes4;
            typeName = scalarTypeName(fieldDescriptor, messageDescriptor.getElementAnnotations(index));
            z = true;
            c = '\n';
        } else if (isOpenPolymorphic(fieldDescriptor)) {
            List nestedTypes5 = CollectionsKt.listOf(SyntheticPolymorphicType);
            nestedTypes = nestedTypes5;
            typeName = SyntheticPolymorphicType.getDescriptor().getSerialName();
            z = true;
            c = '\n';
        } else {
            z = true;
            c = '\n';
            List nestedTypes6 = CollectionsKt.listOf(new TypeDefinition(fieldDescriptor, false, null, null, null, 30, null));
            nestedTypes = nestedTypes6;
            typeName = getMessageOrEnumName(fieldDescriptor);
        }
        if (messageDescriptor.isElementOptional(index)) {
            StringBuilder append4 = $this$generateNamedType.append("  // WARNING: a default value decoded when value is missing");
            Intrinsics.checkNotNullExpressionValue(append4, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append4.append(c), "append('\\n')");
        }
        boolean optional = (fieldDescriptor.isNullable() || messageDescriptor.isElementOptional(index)) ? z : false;
        $this$generateNamedType.append("  ").append(optional ? "optional " : "required ").append(typeName);
        return nestedTypes;
    }

    private final List<TypeDefinition> generateMapType(StringBuilder $this$generateMapType, TypeDefinition messageType, int index) {
        SerialDescriptor messageDescriptor = messageType.getDescriptor();
        SerialDescriptor mapDescriptor = messageDescriptor.getElementDescriptor(index);
        SerialDescriptor originalMapValueDescriptor = mapDescriptor.getElementDescriptor(1);
        TypeDefinition valueType = isProtobufCollection(originalMapValueDescriptor) ? createNestedCollectionType(messageType, index, originalMapValueDescriptor, "nested collection in map value") : new TypeDefinition(originalMapValueDescriptor, false, null, null, null, 30, null);
        SerialDescriptor valueDescriptor = valueType.getDescriptor();
        if (originalMapValueDescriptor.isNullable()) {
            StringBuilder append = $this$generateMapType.append("  // WARNING: nullable map values can not be represented in protobuf");
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        }
        generateCollectionAbsenceComment($this$generateMapType, messageDescriptor, mapDescriptor, index);
        String keyTypeName = scalarTypeName(mapDescriptor.getElementDescriptor(0), mapDescriptor.getElementAnnotations(0));
        String valueTypeName = protobufTypeName(valueDescriptor, mapDescriptor.getElementAnnotations(1));
        $this$generateMapType.append("  map<").append(keyTypeName).append(", ").append(valueTypeName).append(">");
        if (isProtobufMessageOrEnum(valueDescriptor)) {
            return CollectionsKt.listOf(valueType);
        }
        return CollectionsKt.emptyList();
    }

    private final List<TypeDefinition> generateListType(StringBuilder $this$generateListType, TypeDefinition messageType, int index) {
        TypeDefinition elementType;
        SerialDescriptor messageDescriptor = messageType.getDescriptor();
        SerialDescriptor collectionDescriptor = messageDescriptor.getElementDescriptor(index);
        SerialDescriptor originalElementDescriptor = collectionDescriptor.getElementDescriptor(0);
        if (Intrinsics.areEqual(collectionDescriptor.getKind(), StructureKind.LIST.INSTANCE)) {
            if (isProtobufCollection(originalElementDescriptor)) {
                elementType = createNestedCollectionType(messageType, index, originalElementDescriptor, "nested collection in list");
            } else {
                elementType = new TypeDefinition(originalElementDescriptor, false, null, null, null, 30, null);
            }
        } else {
            elementType = createLegacyMapType(messageType, index, "legacy map");
        }
        SerialDescriptor elementDescriptor = elementType.getDescriptor();
        if (elementDescriptor.isNullable()) {
            StringBuilder append = $this$generateListType.append("  // WARNING: nullable elements of collections can not be represented in protobuf");
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        }
        generateCollectionAbsenceComment($this$generateListType, messageDescriptor, collectionDescriptor, index);
        String typeName = protobufTypeName(elementDescriptor, messageDescriptor.getElementAnnotations(index));
        $this$generateListType.append("  repeated ").append(typeName);
        if (isProtobufMessageOrEnum(elementDescriptor)) {
            return CollectionsKt.listOf(elementType);
        }
        return CollectionsKt.emptyList();
    }

    private final void generateEnum(StringBuilder $this$generateEnum, TypeDefinition enumType) {
        final SerialDescriptor enumDescriptor = enumType.getDescriptor();
        final String enumName = getMessageOrEnumName(enumDescriptor);
        checkIsValidIdentifier(enumName, new Function0<String>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$generateEnum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Invalid name for the enum in protobuf schema '" + enumName + "'. Serial name of the enum class '" + enumDescriptor.getSerialName() + '\'';
            }
        });
        String safeSerialName = removeLineBreaks(enumDescriptor.getSerialName());
        if (!Intrinsics.areEqual(safeSerialName, enumName)) {
            StringBuilder append = $this$generateEnum.append("// serial name '").append(safeSerialName);
            Intrinsics.checkNotNullExpressionValue(append, "append(\"// serial name '\").append(safeSerialName)");
            StringBuilder append2 = append.append('\'');
            Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
        }
        StringBuilder append3 = $this$generateEnum.append("enum ").append(enumName);
        Intrinsics.checkNotNullExpressionValue(append3, "append(\"enum \").append(enumName)");
        StringBuilder append4 = append3.append(" {");
        Intrinsics.checkNotNullExpressionValue(append4, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append('\\n')");
        Set usedNumbers = new LinkedHashSet();
        Set duplicatedNumbers = new LinkedHashSet();
        Iterable $this$forEachIndexed$iv = SerialDescriptorKt.getElementDescriptors(enumDescriptor);
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SerialDescriptor element = (SerialDescriptor) item$iv;
            final String elementName = INSTANCE.getProtobufEnumElementName(element);
            String enumName2 = enumName;
            String safeSerialName2 = safeSerialName;
            INSTANCE.checkIsValidIdentifier(elementName, new Function0<String>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$generateEnum$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The enum element name '" + elementName + "' is invalid in the protobuf schema. Serial name of the enum class '" + enumDescriptor.getSerialName() + '\'';
                }
            });
            Iterable annotations = enumDescriptor.getElementAnnotations(index$iv);
            Iterable $this$filterIsInstance$iv = annotations;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                Iterable $this$filterIsInstance$iv2 = $this$filterIsInstance$iv;
                SerialDescriptor element2 = element;
                if (element$iv$iv instanceof ProtoNumber) {
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filterIsInstance$iv = $this$filterIsInstance$iv2;
                element = element2;
            }
            ProtoNumber protoNumber = (ProtoNumber) CollectionsKt.singleOrNull((List<? extends Object>) destination$iv$iv);
            int number = protoNumber != null ? protoNumber.number() : index$iv;
            if (!usedNumbers.add(Integer.valueOf(number))) {
                duplicatedNumbers.add(Integer.valueOf(number));
            }
            StringBuilder append5 = $this$generateEnum.append("  ").append(elementName).append(" = ").append(number);
            Intrinsics.checkNotNullExpressionValue(append5, "append(\"  \").append(elem…end(\" = \").append(number)");
            StringBuilder append6 = append5.append(';');
            Intrinsics.checkNotNullExpressionValue(append6, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append('\\n')");
            index$iv = index$iv2;
            enumName = enumName2;
            safeSerialName = safeSerialName2;
        }
        if (!duplicatedNumbers.isEmpty()) {
            throw new IllegalArgumentException("The class with serial name " + enumDescriptor.getSerialName() + " has duplicate elements with numbers " + duplicatedNumbers);
        }
        StringBuilder append7 = $this$generateEnum.append(AbstractJsonLexerKt.END_OBJ);
        Intrinsics.checkNotNullExpressionValue(append7, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append7.append('\n'), "append('\\n')");
    }

    private final boolean isOpenPolymorphic(SerialDescriptor $this$isOpenPolymorphic) {
        return Intrinsics.areEqual($this$isOpenPolymorphic.getKind(), PolymorphicKind.OPEN.INSTANCE);
    }

    private final boolean isSealedPolymorphic(SerialDescriptor $this$isSealedPolymorphic) {
        return Intrinsics.areEqual($this$isSealedPolymorphic.getKind(), PolymorphicKind.SEALED.INSTANCE);
    }

    private final boolean isProtobufNamedType(SerialDescriptor $this$isProtobufNamedType) {
        return isProtobufMessageOrEnum($this$isProtobufNamedType) || isProtobufScalar($this$isProtobufNamedType);
    }

    private final boolean isProtobufScalar(SerialDescriptor $this$isProtobufScalar) {
        return ($this$isProtobufScalar.getKind() instanceof PrimitiveKind) || (($this$isProtobufScalar.getKind() instanceof StructureKind.LIST) && $this$isProtobufScalar.getElementDescriptor(0).getKind() == PrimitiveKind.BYTE.INSTANCE) || Intrinsics.areEqual($this$isProtobufScalar.getKind(), SerialKind.CONTEXTUAL.INSTANCE);
    }

    private final boolean isProtobufMessageOrEnum(SerialDescriptor $this$isProtobufMessageOrEnum) {
        return isProtobufMessage($this$isProtobufMessageOrEnum) || isProtobufEnum($this$isProtobufMessageOrEnum);
    }

    private final boolean isProtobufMessage(SerialDescriptor $this$isProtobufMessage) {
        return Intrinsics.areEqual($this$isProtobufMessage.getKind(), StructureKind.CLASS.INSTANCE) || Intrinsics.areEqual($this$isProtobufMessage.getKind(), StructureKind.OBJECT.INSTANCE) || Intrinsics.areEqual($this$isProtobufMessage.getKind(), PolymorphicKind.SEALED.INSTANCE) || Intrinsics.areEqual($this$isProtobufMessage.getKind(), PolymorphicKind.OPEN.INSTANCE);
    }

    private final boolean isProtobufCollection(SerialDescriptor $this$isProtobufCollection) {
        return isProtobufRepeated($this$isProtobufCollection) || isProtobufMap($this$isProtobufCollection);
    }

    private final boolean isProtobufRepeated(SerialDescriptor $this$isProtobufRepeated) {
        return (Intrinsics.areEqual($this$isProtobufRepeated.getKind(), StructureKind.LIST.INSTANCE) && !Intrinsics.areEqual($this$isProtobufRepeated.getElementDescriptor(0).getKind(), PrimitiveKind.BYTE.INSTANCE)) || (Intrinsics.areEqual($this$isProtobufRepeated.getKind(), StructureKind.MAP.INSTANCE) && !isValidMapKey($this$isProtobufRepeated.getElementDescriptor(0)));
    }

    private final boolean isProtobufMap(SerialDescriptor $this$isProtobufMap) {
        return Intrinsics.areEqual($this$isProtobufMap.getKind(), StructureKind.MAP.INSTANCE) && isValidMapKey($this$isProtobufMap.getElementDescriptor(0));
    }

    private final boolean isProtobufEnum(SerialDescriptor $this$isProtobufEnum) {
        return Intrinsics.areEqual($this$isProtobufEnum.getKind(), SerialKind.ENUM.INSTANCE);
    }

    private final boolean isValidMapKey(SerialDescriptor $this$isValidMapKey) {
        return Intrinsics.areEqual($this$isValidMapKey.getKind(), PrimitiveKind.INT.INSTANCE) || Intrinsics.areEqual($this$isValidMapKey.getKind(), PrimitiveKind.LONG.INSTANCE) || Intrinsics.areEqual($this$isValidMapKey.getKind(), PrimitiveKind.BOOLEAN.INSTANCE) || Intrinsics.areEqual($this$isValidMapKey.getKind(), PrimitiveKind.STRING.INSTANCE);
    }

    private final String getMessageOrEnumName(SerialDescriptor $this$messageOrEnumName) {
        return StringsKt.removeSuffix(StringsKt.substringAfterLast($this$messageOrEnumName.getSerialName(), (char) FilenameUtils.EXTENSION_SEPARATOR, $this$messageOrEnumName.getSerialName()), (CharSequence) "?");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String protobufTypeName$default(ProtoBufSchemaGenerator protoBufSchemaGenerator, SerialDescriptor serialDescriptor, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return protoBufSchemaGenerator.protobufTypeName(serialDescriptor, list);
    }

    private final String protobufTypeName(SerialDescriptor $this$protobufTypeName, List<? extends Annotation> list) {
        if (isProtobufScalar($this$protobufTypeName)) {
            return scalarTypeName($this$protobufTypeName, list);
        }
        return getMessageOrEnumName($this$protobufTypeName);
    }

    private final String getProtobufEnumElementName(SerialDescriptor $this$protobufEnumElementName) {
        return StringsKt.substringAfterLast($this$protobufEnumElementName.getSerialName(), (char) FilenameUtils.EXTENSION_SEPARATOR, $this$protobufEnumElementName.getSerialName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String scalarTypeName$default(ProtoBufSchemaGenerator protoBufSchemaGenerator, SerialDescriptor serialDescriptor, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return protoBufSchemaGenerator.scalarTypeName(serialDescriptor, list);
    }

    private final String scalarTypeName(SerialDescriptor $this$scalarTypeName, List<? extends Annotation> list) {
        ProtoIntegerType integerType;
        List<? extends Annotation> $this$filterIsInstance$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof ProtoType) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        ProtoType protoType = (ProtoType) CollectionsKt.firstOrNull((List<? extends Object>) destination$iv$iv);
        if (protoType == null || (integerType = protoType.type()) == null) {
            integerType = ProtoIntegerType.DEFAULT;
        }
        if (Intrinsics.areEqual($this$scalarTypeName.getKind(), SerialKind.CONTEXTUAL.INSTANCE)) {
            return "bytes";
        }
        if (($this$scalarTypeName.getKind() instanceof StructureKind.LIST) && Intrinsics.areEqual($this$scalarTypeName.getElementDescriptor(0).getKind(), PrimitiveKind.BYTE.INSTANCE)) {
            return "bytes";
        }
        SerialKind kind = $this$scalarTypeName.getKind();
        Intrinsics.checkNotNull(kind, "null cannot be cast to non-null type kotlinx.serialization.descriptors.PrimitiveKind");
        PrimitiveKind primitiveKind = (PrimitiveKind) kind;
        if (Intrinsics.areEqual(primitiveKind, PrimitiveKind.BOOLEAN.INSTANCE)) {
            return "bool";
        }
        if (Intrinsics.areEqual(primitiveKind, PrimitiveKind.BYTE.INSTANCE) ? true : Intrinsics.areEqual(primitiveKind, PrimitiveKind.CHAR.INSTANCE) ? true : Intrinsics.areEqual(primitiveKind, PrimitiveKind.SHORT.INSTANCE) ? true : Intrinsics.areEqual(primitiveKind, PrimitiveKind.INT.INSTANCE)) {
            switch (WhenMappings.$EnumSwitchMapping$0[integerType.ordinal()]) {
                case 1:
                    return "int32";
                case 2:
                    return "sint32";
                case 3:
                    return "fixed32";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (Intrinsics.areEqual(primitiveKind, PrimitiveKind.LONG.INSTANCE)) {
            switch (WhenMappings.$EnumSwitchMapping$0[integerType.ordinal()]) {
                case 1:
                    return "int64";
                case 2:
                    return "sint64";
                case 3:
                    return "fixed64";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (Intrinsics.areEqual(primitiveKind, PrimitiveKind.FLOAT.INSTANCE)) {
            return "float";
        } else {
            if (Intrinsics.areEqual(primitiveKind, PrimitiveKind.DOUBLE.INSTANCE)) {
                return "double";
            }
            if (Intrinsics.areEqual(primitiveKind, PrimitiveKind.STRING.INSTANCE)) {
                return "string";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProtoBufSchemaGenerator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/protobuf/schema/ProtoBufSchemaGenerator$TypeDefinition;", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "isSynthetic", "", "ability", "", "containingMessageName", "fieldName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAbility", "()Ljava/lang/String;", "getContainingMessageName", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getFieldName", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class TypeDefinition {
        private final String ability;
        private final String containingMessageName;
        private final SerialDescriptor descriptor;
        private final String fieldName;
        private final boolean isSynthetic;

        public static /* synthetic */ TypeDefinition copy$default(TypeDefinition typeDefinition, SerialDescriptor serialDescriptor, boolean z, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                serialDescriptor = typeDefinition.descriptor;
            }
            if ((i & 2) != 0) {
                z = typeDefinition.isSynthetic;
            }
            boolean z2 = z;
            if ((i & 4) != 0) {
                str = typeDefinition.ability;
            }
            String str4 = str;
            if ((i & 8) != 0) {
                str2 = typeDefinition.containingMessageName;
            }
            String str5 = str2;
            if ((i & 16) != 0) {
                str3 = typeDefinition.fieldName;
            }
            return typeDefinition.copy(serialDescriptor, z2, str4, str5, str3);
        }

        public final SerialDescriptor component1() {
            return this.descriptor;
        }

        public final boolean component2() {
            return this.isSynthetic;
        }

        public final String component3() {
            return this.ability;
        }

        public final String component4() {
            return this.containingMessageName;
        }

        public final String component5() {
            return this.fieldName;
        }

        public final TypeDefinition copy(SerialDescriptor descriptor, boolean z, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return new TypeDefinition(descriptor, z, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TypeDefinition) {
                TypeDefinition typeDefinition = (TypeDefinition) obj;
                return Intrinsics.areEqual(this.descriptor, typeDefinition.descriptor) && this.isSynthetic == typeDefinition.isSynthetic && Intrinsics.areEqual(this.ability, typeDefinition.ability) && Intrinsics.areEqual(this.containingMessageName, typeDefinition.containingMessageName) && Intrinsics.areEqual(this.fieldName, typeDefinition.fieldName);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.descriptor.hashCode() * 31;
            boolean z = this.isSynthetic;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((((((hashCode + i) * 31) + (this.ability == null ? 0 : this.ability.hashCode())) * 31) + (this.containingMessageName == null ? 0 : this.containingMessageName.hashCode())) * 31) + (this.fieldName != null ? this.fieldName.hashCode() : 0);
        }

        public String toString() {
            return "TypeDefinition(descriptor=" + this.descriptor + ", isSynthetic=" + this.isSynthetic + ", ability=" + this.ability + ", containingMessageName=" + this.containingMessageName + ", fieldName=" + this.fieldName + ')';
        }

        public TypeDefinition(SerialDescriptor descriptor, boolean isSynthetic, String ability, String containingMessageName, String fieldName) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            this.descriptor = descriptor;
            this.isSynthetic = isSynthetic;
            this.ability = ability;
            this.containingMessageName = containingMessageName;
            this.fieldName = fieldName;
        }

        public /* synthetic */ TypeDefinition(SerialDescriptor serialDescriptor, boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(serialDescriptor, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
        }

        public final SerialDescriptor getDescriptor() {
            return this.descriptor;
        }

        public final boolean isSynthetic() {
            return this.isSynthetic;
        }

        public final String getAbility() {
            return this.ability;
        }

        public final String getContainingMessageName() {
            return this.containingMessageName;
        }

        public final String getFieldName() {
            return this.fieldName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProtoBufSchemaGenerator.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001c\u001a\u00020\nH\u0097\u0001J\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\nH\u0097\u0001J\u0011\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0018H\u0097\u0001J\u0011\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\nH\u0097\u0001J\u0011\u0010!\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\nH\u0097\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lkotlinx/serialization/protobuf/schema/ProtoBufSchemaGenerator$NotNullSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getOriginal", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class NotNullSerialDescriptor implements SerialDescriptor {
        private final boolean isNullable;
        private final SerialDescriptor original;

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> getAnnotations() {
            return this.original.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @ExperimentalSerializationApi
        public List<Annotation> getElementAnnotations(int i) {
            return this.original.getElementAnnotations(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @ExperimentalSerializationApi
        public SerialDescriptor getElementDescriptor(int i) {
            return this.original.getElementDescriptor(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @ExperimentalSerializationApi
        public int getElementIndex(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.original.getElementIndex(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @ExperimentalSerializationApi
        public String getElementName(int i) {
            return this.original.getElementName(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int getElementsCount() {
            return this.original.getElementsCount();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialKind getKind() {
            return this.original.getKind();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String getSerialName() {
            return this.original.getSerialName();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        @ExperimentalSerializationApi
        public boolean isElementOptional(int i) {
            return this.original.isElementOptional(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.original.isInline();
        }

        public NotNullSerialDescriptor(SerialDescriptor original) {
            Intrinsics.checkNotNullParameter(original, "original");
            this.original = original;
        }

        public final SerialDescriptor getOriginal() {
            return this.original;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isNullable() {
            return this.isNullable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotNullSerialDescriptor getNotNull(SerialDescriptor $this$notNull) {
        return new NotNullSerialDescriptor($this$notNull);
    }

    private final void generateCollectionAbsenceComment(StringBuilder $this$generateCollectionAbsenceComment, SerialDescriptor messageDescriptor, SerialDescriptor collectionDescriptor, int index) {
        if (!collectionDescriptor.isNullable() && messageDescriptor.isElementOptional(index)) {
            StringBuilder append = $this$generateCollectionAbsenceComment.append("  // WARNING: a default value decoded when value is missing");
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        } else if (collectionDescriptor.isNullable() && !messageDescriptor.isElementOptional(index)) {
            StringBuilder append2 = $this$generateCollectionAbsenceComment.append("  // WARNING: an empty collection decoded when a value is missing");
            Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
        } else if (collectionDescriptor.isNullable() && messageDescriptor.isElementOptional(index)) {
            StringBuilder append3 = $this$generateCollectionAbsenceComment.append("  // WARNING: a default value decoded when value is missing");
            Intrinsics.checkNotNullExpressionValue(append3, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append('\\n')");
        }
    }

    private final TypeDefinition createLegacyMapType(TypeDefinition messageType, int index, String description) {
        SerialDescriptor messageDescriptor = messageType.getDescriptor();
        final SerialDescriptor fieldDescriptor = messageDescriptor.getElementDescriptor(index);
        String fieldName = messageDescriptor.getElementName(index);
        String messageName = getMessageOrEnumName(messageDescriptor);
        String wrapperName = messageName + '_' + fieldName;
        SerialDescriptor wrapperDescriptor = SerialDescriptorsKt.buildClassSerialDescriptor(wrapperName, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$createLegacyMapType$wrapperDescriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                invoke2(classSerialDescriptorBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                ProtoBufSchemaGenerator.NotNullSerialDescriptor notNull;
                ProtoBufSchemaGenerator.NotNullSerialDescriptor notNull2;
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                notNull = ProtoBufSchemaGenerator.INSTANCE.getNotNull(SerialDescriptor.this.getElementDescriptor(0));
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "key", notNull, null, false, 12, null);
                notNull2 = ProtoBufSchemaGenerator.INSTANCE.getNotNull(SerialDescriptor.this.getElementDescriptor(1));
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "value", notNull2, null, false, 12, null);
            }
        });
        String containingMessageName = messageType.getContainingMessageName();
        String str = containingMessageName == null ? messageName : containingMessageName;
        String fieldName2 = messageType.getFieldName();
        return new TypeDefinition(wrapperDescriptor, true, description, str, fieldName2 == null ? fieldName : fieldName2);
    }

    private final TypeDefinition createNestedCollectionType(TypeDefinition messageType, int index, final SerialDescriptor elementDescriptor, String description) {
        SerialDescriptor messageDescriptor = messageType.getDescriptor();
        String fieldName = messageDescriptor.getElementName(index);
        String messageName = getMessageOrEnumName(messageDescriptor);
        String wrapperName = messageName + '_' + fieldName;
        SerialDescriptor wrapperDescriptor = SerialDescriptorsKt.buildClassSerialDescriptor(wrapperName, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.protobuf.schema.ProtoBufSchemaGenerator$createNestedCollectionType$wrapperDescriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                invoke2(classSerialDescriptorBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                ProtoBufSchemaGenerator.NotNullSerialDescriptor notNull;
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                notNull = ProtoBufSchemaGenerator.INSTANCE.getNotNull(SerialDescriptor.this);
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "value", notNull, null, false, 12, null);
            }
        });
        String containingMessageName = messageType.getContainingMessageName();
        String str = containingMessageName == null ? messageName : containingMessageName;
        String fieldName2 = messageType.getFieldName();
        return new TypeDefinition(wrapperDescriptor, true, description, str, fieldName2 == null ? fieldName : fieldName2);
    }

    private final String removeLineBreaks(String text) {
        return StringsKt.replace$default(StringsKt.replace$default(text, '\n', ' ', false, 4, (Object) null), '\r', ' ', false, 4, (Object) null);
    }

    private final void checkIsValidFullIdentifier(String $this$checkIsValidFullIdentifier, Function1<? super String, String> function1) {
        boolean z = true;
        Iterable $this$any$iv = StringsKt.split$default((CharSequence) $this$checkIsValidFullIdentifier, new char[]{FilenameUtils.EXTENSION_SEPARATOR}, false, 0, 6, (Object) null);
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    String it2 = (String) element$iv;
                    if (!IDENTIFIER_REGEX.matches(it2)) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            throw new IllegalArgumentException(function1.invoke($this$checkIsValidFullIdentifier));
        }
    }

    private final void checkIsValidIdentifier(String $this$checkIsValidIdentifier, Function0<String> function0) {
        if (!IDENTIFIER_REGEX.matches($this$checkIsValidIdentifier)) {
            throw new IllegalArgumentException(function0.invoke());
        }
    }
}