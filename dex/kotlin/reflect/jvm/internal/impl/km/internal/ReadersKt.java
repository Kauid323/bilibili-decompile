package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmConstantValue;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmContract;
import kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.km.KmEffect;
import kotlin.reflect.jvm.internal.impl.km.KmEffectExpression;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersion;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;

/* compiled from: Readers.kt */
public final class ReadersKt {

    /* compiled from: Readers.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ProtoBuf.TypeParameter.Variance.values().length];
            try {
                iArr[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf.VersionRequirement.VersionKind.values().length];
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DeprecationLevel.values().length];
            try {
                iArr4[DeprecationLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr4[DeprecationLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr4[DeprecationLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ProtoBuf.Effect.EffectType.values().length];
            try {
                iArr5[ProtoBuf.Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr5[ProtoBuf.Effect.EffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr5[ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError e16) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ProtoBuf.Effect.InvocationKind.values().length];
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError e19) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[ProtoBuf.Expression.ConstantValue.values().length];
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError e22) {
            }
            $EnumSwitchMapping$6 = iArr7;
        }
    }

    public static /* synthetic */ KmClass toKmClass$default(ProtoBuf.Class r0, NameResolver nameResolver, boolean z, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toKmClass(r0, nameResolver, z, list);
    }

    public static final KmClass toKmClass(ProtoBuf.Class $this$toKmClass, NameResolver strings, boolean ignoreUnknownVersionRequirements, List<? extends Object> contextExtensions) {
        Intrinsics.checkNotNullParameter($this$toKmClass, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        KmClass v = new KmClass();
        ProtoBuf.TypeTable typeTable = $this$toKmClass.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = $this$toKmClass.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        ReadContext readContext = new ReadContext(strings, typeTable2, companion.create(versionRequirementTable), ignoreUnknownVersionRequirements, null, contextExtensions, 16, null);
        List<ProtoBuf.TypeParameter> typeParameterList = $this$toKmClass.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext c = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        v.setFlags$kotlin_metadata($this$toKmClass.getFlags());
        v.setName(c.className$kotlin_metadata($this$toKmClass.getFqName()));
        Iterable typeParameterList2 = $this$toKmClass.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        Iterable $this$mapTo$iv = typeParameterList2;
        Collection destination$iv = v.getTypeParameters();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter it = (ProtoBuf.TypeParameter) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmTypeParameter(it, c));
        }
        Iterable $this$mapTo$iv2 = ProtoTypeTableUtilKt.supertypes($this$toKmClass, c.getTypes());
        Collection destination$iv2 = v.getSupertypes();
        for (Object item$iv2 : $this$mapTo$iv2) {
            destination$iv2.add(toKmType((ProtoBuf.Type) item$iv2, c));
        }
        Iterable $this$mapTo$iv3 = $this$toKmClass.getConstructorList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv3, "getConstructorList(...)");
        Collection destination$iv3 = v.getConstructors();
        for (Object item$iv3 : $this$mapTo$iv3) {
            ProtoBuf.Constructor it2 = (ProtoBuf.Constructor) item$iv3;
            Intrinsics.checkNotNull(it2);
            destination$iv3.add(toKmConstructor(it2, c));
        }
        List<ProtoBuf.Function> functionList = $this$toKmClass.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
        List<ProtoBuf.Property> propertyList = $this$toKmClass.getPropertyList();
        Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
        List<ProtoBuf.TypeAlias> typeAliasList = $this$toKmClass.getTypeAliasList();
        Intrinsics.checkNotNullExpressionValue(typeAliasList, "getTypeAliasList(...)");
        visitDeclarations(v, functionList, propertyList, typeAliasList, c);
        if ($this$toKmClass.hasCompanionObjectName()) {
            v.setCompanionObject(c.get($this$toKmClass.getCompanionObjectName()));
        }
        Iterable nestedClassNameList = $this$toKmClass.getNestedClassNameList();
        Intrinsics.checkNotNullExpressionValue(nestedClassNameList, "getNestedClassNameList(...)");
        Iterable $this$mapTo$iv4 = nestedClassNameList;
        Collection destination$iv4 = v.getNestedClasses();
        for (Object item$iv4 : $this$mapTo$iv4) {
            Integer it3 = (Integer) item$iv4;
            Intrinsics.checkNotNull(it3);
            destination$iv4.add(c.get(it3.intValue()));
        }
        Iterator<ProtoBuf.EnumEntry> it4 = $this$toKmClass.getEnumEntryList().iterator();
        while (true) {
            if (it4.hasNext()) {
                ProtoBuf.EnumEntry enumEntry = it4.next();
                if (!enumEntry.hasName()) {
                    throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
                }
                v.getEnumEntries().add(c.get(enumEntry.getName()));
                List<KmEnumEntry> kmEnumEntries = v.getKmEnumEntries();
                Intrinsics.checkNotNull(enumEntry);
                kmEnumEntries.add(toKmEnumEntry(enumEntry, c));
            } else {
                Iterable sealedSubclassFqNameList = $this$toKmClass.getSealedSubclassFqNameList();
                Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "getSealedSubclassFqNameList(...)");
                Iterable $this$mapTo$iv5 = sealedSubclassFqNameList;
                Collection destination$iv5 = v.getSealedSubclasses();
                for (Object item$iv5 : $this$mapTo$iv5) {
                    Integer it5 = (Integer) item$iv5;
                    Intrinsics.checkNotNull(it5);
                    destination$iv5.add(c.className$kotlin_metadata(it5.intValue()));
                }
                if ($this$toKmClass.hasInlineClassUnderlyingPropertyName()) {
                    v.setInlineClassUnderlyingPropertyName(c.get($this$toKmClass.getInlineClassUnderlyingPropertyName()));
                }
                ProtoBuf.Type loadInlineClassUnderlyingType = loadInlineClassUnderlyingType($this$toKmClass, c);
                v.setInlineClassUnderlyingType(loadInlineClassUnderlyingType != null ? toKmType(loadInlineClassUnderlyingType, c) : null);
                Iterable $this$mapTo$iv6 = ProtoTypeTableUtilKt.contextReceiverTypes($this$toKmClass, c.getTypes());
                Collection destination$iv6 = v.getContextReceiverTypes();
                for (Object item$iv6 : $this$mapTo$iv6) {
                    destination$iv6.add(toKmType((ProtoBuf.Type) item$iv6, c));
                }
                Iterable $this$mapTo$iv7 = $this$toKmClass.getVersionRequirementList();
                Intrinsics.checkNotNullExpressionValue($this$mapTo$iv7, "getVersionRequirementList(...)");
                Collection destination$iv7 = v.getVersionRequirements();
                for (Object item$iv7 : $this$mapTo$iv7) {
                    Integer it6 = (Integer) item$iv7;
                    Intrinsics.checkNotNull(it6);
                    destination$iv7.add(readVersionRequirement(it6.intValue(), c));
                }
                Iterable $this$mapTo$iv8 = c.getExtensions$kotlin_metadata();
                Iterable $this$forEach$iv = $this$mapTo$iv8;
                for (Object element$iv : $this$forEach$iv) {
                    ((MetadataExtensions) element$iv).readClassExtensions(v, $this$toKmClass, c);
                }
                return v;
            }
        }
    }

    private static final KmEnumEntry toKmEnumEntry(ProtoBuf.EnumEntry $this$toKmEnumEntry, ReadContext c) {
        KmEnumEntry v = new KmEnumEntry(c.get($this$toKmEnumEntry.getName()));
        Iterable $this$forEach$iv = c.getExtensions$kotlin_metadata();
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions) element$iv;
            it.readEnumEntryExtensions(v, $this$toKmEnumEntry, c);
        }
        return v;
    }

    private static final ProtoBuf.Type loadInlineClassUnderlyingType(ProtoBuf.Class $this$loadInlineClassUnderlyingType, ReadContext c) {
        ProtoBuf.Type type = ProtoTypeTableUtilKt.inlineClassUnderlyingType($this$loadInlineClassUnderlyingType, c.getTypes());
        if (type != null) {
            return type;
        }
        if ($this$loadInlineClassUnderlyingType.hasInlineClassUnderlyingPropertyName()) {
            Iterable propertyList = $this$loadInlineClassUnderlyingType.getPropertyList();
            Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
            Iterable $this$singleOrNull$iv = propertyList;
            Object single$iv = null;
            boolean found$iv = false;
            Iterator<T> it = $this$singleOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    ProtoBuf.Property it2 = (ProtoBuf.Property) element$iv;
                    Intrinsics.checkNotNull(it2);
                    if (ProtoTypeTableUtilKt.receiverType(it2, c.getTypes()) == null && Intrinsics.areEqual(c.get(it2.getName()), c.get($this$loadInlineClassUnderlyingType.getInlineClassUnderlyingPropertyName()))) {
                        if (found$iv) {
                            single$iv = null;
                            break;
                        }
                        single$iv = element$iv;
                        found$iv = true;
                    }
                } else if (!found$iv) {
                    single$iv = null;
                }
            }
            ProtoBuf.Property property = (ProtoBuf.Property) single$iv;
            if (property != null) {
                return ProtoTypeTableUtilKt.returnType(property, c.getTypes());
            }
            return null;
        }
        return null;
    }

    private static final void visitDeclarations(KmDeclarationContainer $this$visitDeclarations, List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3, ReadContext c) {
        List<ProtoBuf.Function> $this$mapTo$iv = list;
        Collection destination$iv = $this$visitDeclarations.getFunctions();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Function it = (ProtoBuf.Function) item$iv;
            destination$iv.add(toKmFunction(it, c));
        }
        List<ProtoBuf.Property> $this$mapTo$iv2 = list2;
        Collection destination$iv2 = $this$visitDeclarations.getProperties();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.Property it2 = (ProtoBuf.Property) item$iv2;
            destination$iv2.add(toKmProperty(it2, c));
        }
        List<ProtoBuf.TypeAlias> $this$mapTo$iv3 = list3;
        Collection destination$iv3 = $this$visitDeclarations.getTypeAliases();
        for (Object item$iv3 : $this$mapTo$iv3) {
            ProtoBuf.TypeAlias it3 = (ProtoBuf.TypeAlias) item$iv3;
            destination$iv3.add(toKmTypeAlias(it3, c));
        }
    }

    private static final KmConstructor toKmConstructor(ProtoBuf.Constructor $this$toKmConstructor, ReadContext c) {
        KmConstructor v = new KmConstructor($this$toKmConstructor.getFlags());
        Iterable $this$mapTo$iv = $this$toKmConstructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv, "getValueParameterList(...)");
        Collection destination$iv = v.getValueParameters();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.ValueParameter it = (ProtoBuf.ValueParameter) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmValueParameter(it, c));
        }
        Iterable $this$mapTo$iv2 = $this$toKmConstructor.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv2, "getVersionRequirementList(...)");
        Collection destination$iv2 = v.getVersionRequirements();
        for (Object item$iv2 : $this$mapTo$iv2) {
            Integer it2 = (Integer) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(readVersionRequirement(it2.intValue(), c));
        }
        Iterable $this$forEach$iv = c.getExtensions$kotlin_metadata();
        for (Object element$iv : $this$forEach$iv) {
            ((MetadataExtensions) element$iv).readConstructorExtensions(v, $this$toKmConstructor, c);
        }
        return v;
    }

    private static final KmFunction toKmFunction(ProtoBuf.Function $this$toKmFunction, ReadContext outer) {
        KmFunction v = new KmFunction($this$toKmFunction.getFlags(), outer.get($this$toKmFunction.getName()));
        List<ProtoBuf.TypeParameter> typeParameterList = $this$toKmFunction.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext c = outer.withTypeParameters$kotlin_metadata(typeParameterList);
        Iterable typeParameterList2 = $this$toKmFunction.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        Iterable $this$mapTo$iv = typeParameterList2;
        Collection destination$iv = v.getTypeParameters();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter it = (ProtoBuf.TypeParameter) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmTypeParameter(it, c));
        }
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType($this$toKmFunction, c.getTypes());
        v.setReceiverParameterType(receiverType != null ? toKmType(receiverType, c) : null);
        Iterable contextParameterList = $this$toKmFunction.getContextParameterList();
        Intrinsics.checkNotNullExpressionValue(contextParameterList, "getContextParameterList(...)");
        Iterable $this$mapTo$iv2 = contextParameterList;
        Collection destination$iv2 = v.getContextParameters();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.ValueParameter it2 = (ProtoBuf.ValueParameter) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(toKmValueParameter(it2, c));
        }
        if ($this$toKmFunction.getContextParameterList().isEmpty()) {
            List<ProtoBuf.Type> contextReceiverTypeList = $this$toKmFunction.getContextReceiverTypeList();
            Intrinsics.checkNotNullExpressionValue(contextReceiverTypeList, "getContextReceiverTypeList(...)");
            if (!contextReceiverTypeList.isEmpty()) {
                Iterable $this$mapTo$iv3 = ProtoTypeTableUtilKt.contextReceiverTypes($this$toKmFunction, c.getTypes());
                Collection destination$iv3 = v.getContextParameters();
                for (Object item$iv3 : $this$mapTo$iv3) {
                    destination$iv3.add(legacyCtxReceiverToParameter(toKmType((ProtoBuf.Type) item$iv3, c)));
                }
            }
        }
        Iterable $this$mapTo$iv4 = $this$toKmFunction.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv4, "getValueParameterList(...)");
        Collection destination$iv4 = v.getValueParameters();
        for (Object item$iv4 : $this$mapTo$iv4) {
            ProtoBuf.ValueParameter it3 = (ProtoBuf.ValueParameter) item$iv4;
            Intrinsics.checkNotNull(it3);
            destination$iv4.add(toKmValueParameter(it3, c));
        }
        v.setReturnType(toKmType(ProtoTypeTableUtilKt.returnType($this$toKmFunction, c.getTypes()), c));
        if ($this$toKmFunction.hasContract()) {
            ProtoBuf.Contract contract = $this$toKmFunction.getContract();
            Intrinsics.checkNotNullExpressionValue(contract, "getContract(...)");
            v.setContract(toKmContract(contract, c));
        }
        Iterable versionRequirementList = $this$toKmFunction.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        Iterable $this$mapTo$iv5 = versionRequirementList;
        Collection destination$iv5 = v.getVersionRequirements();
        for (Object item$iv5 : $this$mapTo$iv5) {
            Integer it4 = (Integer) item$iv5;
            Intrinsics.checkNotNull(it4);
            destination$iv5.add(readVersionRequirement(it4.intValue(), c));
        }
        Iterable $this$mapTo$iv6 = c.getExtensions$kotlin_metadata();
        Iterable $this$forEach$iv = $this$mapTo$iv6;
        for (Object element$iv : $this$forEach$iv) {
            ((MetadataExtensions) element$iv).readFunctionExtensions(v, $this$toKmFunction, c);
        }
        return v;
    }

    public static final KmProperty toKmProperty(ProtoBuf.Property $this$toKmProperty, ReadContext outer) {
        Intrinsics.checkNotNullParameter($this$toKmProperty, "<this>");
        Intrinsics.checkNotNullParameter(outer, "outer");
        KmProperty v = new KmProperty($this$toKmProperty.getFlags(), outer.get($this$toKmProperty.getName()), getPropertyGetterFlags($this$toKmProperty), getPropertySetterFlags($this$toKmProperty));
        List<ProtoBuf.TypeParameter> typeParameterList = $this$toKmProperty.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext c = outer.withTypeParameters$kotlin_metadata(typeParameterList);
        Iterable typeParameterList2 = $this$toKmProperty.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        Iterable $this$mapTo$iv = typeParameterList2;
        Collection destination$iv = v.getTypeParameters();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter it = (ProtoBuf.TypeParameter) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmTypeParameter(it, c));
        }
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType($this$toKmProperty, c.getTypes());
        v.setReceiverParameterType(receiverType != null ? toKmType(receiverType, c) : null);
        Iterable contextParameterList = $this$toKmProperty.getContextParameterList();
        Intrinsics.checkNotNullExpressionValue(contextParameterList, "getContextParameterList(...)");
        Iterable $this$mapTo$iv2 = contextParameterList;
        Collection destination$iv2 = v.getContextParameters();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.ValueParameter it2 = (ProtoBuf.ValueParameter) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(toKmValueParameter(it2, c));
        }
        if ($this$toKmProperty.getContextParameterList().isEmpty()) {
            List<ProtoBuf.Type> contextReceiverTypeList = $this$toKmProperty.getContextReceiverTypeList();
            Intrinsics.checkNotNullExpressionValue(contextReceiverTypeList, "getContextReceiverTypeList(...)");
            if (!contextReceiverTypeList.isEmpty()) {
                Iterable $this$mapTo$iv3 = ProtoTypeTableUtilKt.contextReceiverTypes($this$toKmProperty, c.getTypes());
                Collection destination$iv3 = v.getContextParameters();
                for (Object item$iv3 : $this$mapTo$iv3) {
                    destination$iv3.add(legacyCtxReceiverToParameter(toKmType((ProtoBuf.Type) item$iv3, c)));
                }
            }
        }
        if ($this$toKmProperty.hasSetterValueParameter()) {
            ProtoBuf.ValueParameter setterValueParameter = $this$toKmProperty.getSetterValueParameter();
            Intrinsics.checkNotNullExpressionValue(setterValueParameter, "getSetterValueParameter(...)");
            v.setSetterParameter(toKmValueParameter(setterValueParameter, c));
        }
        v.setReturnType(toKmType(ProtoTypeTableUtilKt.returnType($this$toKmProperty, c.getTypes()), c));
        Iterable versionRequirementList = $this$toKmProperty.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        Iterable $this$mapTo$iv4 = versionRequirementList;
        Collection destination$iv4 = v.getVersionRequirements();
        for (Object item$iv4 : $this$mapTo$iv4) {
            Integer it3 = (Integer) item$iv4;
            Intrinsics.checkNotNull(it3);
            destination$iv4.add(readVersionRequirement(it3.intValue(), c));
        }
        Iterable $this$mapTo$iv5 = c.getExtensions$kotlin_metadata();
        Iterable $this$forEach$iv = $this$mapTo$iv5;
        for (Object element$iv : $this$forEach$iv) {
            ((MetadataExtensions) element$iv).readPropertyExtensions(v, $this$toKmProperty, c);
        }
        return v;
    }

    private static final KmValueParameter legacyCtxReceiverToParameter(KmType kmType) {
        KmValueParameter v = new KmValueParameter(0, "_");
        v.setType(kmType);
        return v;
    }

    private static final KmTypeAlias toKmTypeAlias(ProtoBuf.TypeAlias $this$toKmTypeAlias, ReadContext outer) {
        KmTypeAlias v = new KmTypeAlias($this$toKmTypeAlias.getFlags(), outer.get($this$toKmTypeAlias.getName()));
        List<ProtoBuf.TypeParameter> typeParameterList = $this$toKmTypeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext c = outer.withTypeParameters$kotlin_metadata(typeParameterList);
        Iterable typeParameterList2 = $this$toKmTypeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        Iterable $this$mapTo$iv = typeParameterList2;
        Collection destination$iv = v.getTypeParameters();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter it = (ProtoBuf.TypeParameter) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmTypeParameter(it, c));
        }
        v.setUnderlyingType(toKmType(ProtoTypeTableUtilKt.underlyingType($this$toKmTypeAlias, c.getTypes()), c));
        v.setExpandedType(toKmType(ProtoTypeTableUtilKt.expandedType($this$toKmTypeAlias, c.getTypes()), c));
        Iterable annotationList = $this$toKmTypeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        Iterable $this$mapTo$iv2 = annotationList;
        Collection destination$iv2 = v.getAnnotations();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.Annotation it2 = (ProtoBuf.Annotation) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(ReadUtilsKt.readAnnotation(it2, c.getStrings()));
        }
        Iterable $this$mapTo$iv3 = $this$toKmTypeAlias.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv3, "getVersionRequirementList(...)");
        Collection destination$iv3 = v.getVersionRequirements();
        for (Object item$iv3 : $this$mapTo$iv3) {
            Integer it3 = (Integer) item$iv3;
            Intrinsics.checkNotNull(it3);
            destination$iv3.add(readVersionRequirement(it3.intValue(), c));
        }
        Iterable $this$mapTo$iv4 = c.getExtensions$kotlin_metadata();
        Iterable $this$forEach$iv = $this$mapTo$iv4;
        for (Object element$iv : $this$forEach$iv) {
            ((MetadataExtensions) element$iv).readTypeAliasExtensions(v, $this$toKmTypeAlias, c);
        }
        return v;
    }

    private static final KmValueParameter toKmValueParameter(ProtoBuf.ValueParameter $this$toKmValueParameter, ReadContext c) {
        KmValueParameter v = new KmValueParameter($this$toKmValueParameter.getFlags(), c.get($this$toKmValueParameter.getName()));
        v.setType(toKmType(ProtoTypeTableUtilKt.type($this$toKmValueParameter, c.getTypes()), c));
        ProtoBuf.Type varargElementType = ProtoTypeTableUtilKt.varargElementType($this$toKmValueParameter, c.getTypes());
        v.setVarargElementType(varargElementType != null ? toKmType(varargElementType, c) : null);
        if ($this$toKmValueParameter.hasAnnotationParameterDefaultValue()) {
            ProtoBuf.Annotation.Argument.Value annotationParameterDefaultValue = $this$toKmValueParameter.getAnnotationParameterDefaultValue();
            Intrinsics.checkNotNullExpressionValue(annotationParameterDefaultValue, "getAnnotationParameterDefaultValue(...)");
            v.setAnnotationParameterDefaultValue(ReadUtilsKt.readAnnotationArgument(annotationParameterDefaultValue, c.getStrings()));
        }
        Iterable $this$forEach$iv = c.getExtensions$kotlin_metadata();
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions) element$iv;
            it.readValueParameterExtensions(v, $this$toKmValueParameter, c);
        }
        return v;
    }

    private static final KmTypeParameter toKmTypeParameter(ProtoBuf.TypeParameter $this$toKmTypeParameter, ReadContext c) {
        KmVariance variance;
        ProtoBuf.TypeParameter.Variance variance2 = $this$toKmTypeParameter.getVariance();
        if (variance2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        switch (WhenMappings.$EnumSwitchMapping$0[variance2.ordinal()]) {
            case 1:
                variance = KmVariance.IN;
                break;
            case 2:
                variance = KmVariance.OUT;
                break;
            case 3:
                variance = KmVariance.INVARIANT;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        KmTypeParameter ktp = new KmTypeParameter(getTypeParameterFlags($this$toKmTypeParameter), c.get($this$toKmTypeParameter.getName()), $this$toKmTypeParameter.getId(), variance);
        Iterable $this$mapTo$iv = ProtoTypeTableUtilKt.upperBounds($this$toKmTypeParameter, c.getTypes());
        Collection destination$iv = ktp.getUpperBounds();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Type it = (ProtoBuf.Type) item$iv;
            destination$iv.add(toKmType(it, c));
        }
        Iterable $this$mapTo$iv2 = c.getExtensions$kotlin_metadata();
        Iterable $this$forEach$iv = $this$mapTo$iv2;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions) element$iv;
            it2.readTypeParameterExtensions(ktp, $this$toKmTypeParameter, c);
        }
        return ktp;
    }

    private static final KmType toKmType(ProtoBuf.Type $this$toKmType, ReadContext c) {
        KmClassifier.TypeParameter typeParameter;
        KmType it;
        KmVariance variance;
        KmType v = new KmType(getTypeFlags($this$toKmType));
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = null;
        kmFlexibleTypeUpperBound = null;
        if ($this$toKmType.hasClassName()) {
            typeParameter = new KmClassifier.Class(c.className$kotlin_metadata($this$toKmType.getClassName()));
        } else if ($this$toKmType.hasTypeAliasName()) {
            typeParameter = new KmClassifier.TypeAlias(c.className$kotlin_metadata($this$toKmType.getTypeAliasName()));
        } else if ($this$toKmType.hasTypeParameter()) {
            typeParameter = new KmClassifier.TypeParameter($this$toKmType.getTypeParameter());
        } else if ($this$toKmType.hasTypeParameterName()) {
            Integer typeParameterId$kotlin_metadata = c.getTypeParameterId$kotlin_metadata($this$toKmType.getTypeParameterName());
            if (typeParameterId$kotlin_metadata == null) {
                throw new InconsistentKotlinMetadataException("No type parameter id for " + c.get($this$toKmType.getTypeParameterName()), null, 2, null);
            }
            int id = typeParameterId$kotlin_metadata.intValue();
            typeParameter = new KmClassifier.TypeParameter(id);
        } else {
            throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
        }
        v.setClassifier(typeParameter);
        for (ProtoBuf.Type.Argument argument : $this$toKmType.getArgumentList()) {
            ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            if (projection == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$1[projection.ordinal()]) {
                case 1:
                    variance = KmVariance.IN;
                    break;
                case 2:
                    variance = KmVariance.OUT;
                    break;
                case 3:
                    variance = KmVariance.INVARIANT;
                    break;
                case 4:
                    variance = null;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (variance != null) {
                Intrinsics.checkNotNull(argument);
                ProtoBuf.Type argumentType = ProtoTypeTableUtilKt.type(argument, c.getTypes());
                if (argumentType == null) {
                    throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                v.getArguments().add(new KmTypeProjection(variance, toKmType(argumentType, c)));
            } else {
                v.getArguments().add(KmTypeProjection.STAR);
            }
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType($this$toKmType, c.getTypes());
        v.setAbbreviatedType(abbreviatedType != null ? toKmType(abbreviatedType, c) : null);
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType($this$toKmType, c.getTypes());
        v.setOuterType(outerType != null ? toKmType(outerType, c) : null);
        ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound($this$toKmType, c.getTypes());
        if (flexibleUpperBound != null && (it = toKmType(flexibleUpperBound, c)) != null) {
            kmFlexibleTypeUpperBound = new KmFlexibleTypeUpperBound(it, $this$toKmType.hasFlexibleTypeCapabilitiesId() ? c.get($this$toKmType.getFlexibleTypeCapabilitiesId()) : null);
        }
        v.setFlexibleTypeUpperBound(kmFlexibleTypeUpperBound);
        Iterable $this$forEach$iv = c.getExtensions$kotlin_metadata();
        for (Object element$iv : $this$forEach$iv) {
            ((MetadataExtensions) element$iv).readTypeExtensions(v, $this$toKmType, c);
        }
        return v;
    }

    private static final KmVersionRequirement readVersionRequirement(int id, ReadContext c) {
        KmVersionRequirementVersionKind kind;
        KmVersionRequirementLevel level;
        VersionRequirement.Version version;
        KmVersionRequirement v = new KmVersionRequirement();
        VersionRequirement message = VersionRequirement.Companion.create(id, c.getStrings(), c.getVersionRequirements$kotlin_metadata());
        if (message == null && !c.getIgnoreUnknownVersionRequirements$kotlin_metadata()) {
            throw new InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
        }
        ProtoBuf.VersionRequirement.VersionKind kind2 = message != null ? message.getKind() : null;
        switch (kind2 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[kind2.ordinal()]) {
            case -1:
                kind = KmVersionRequirementVersionKind.UNKNOWN;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                kind = KmVersionRequirementVersionKind.LANGUAGE_VERSION;
                break;
            case 2:
                kind = KmVersionRequirementVersionKind.COMPILER_VERSION;
                break;
            case 3:
                kind = KmVersionRequirementVersionKind.API_VERSION;
                break;
        }
        DeprecationLevel level2 = message != null ? message.getLevel() : null;
        switch (level2 != null ? WhenMappings.$EnumSwitchMapping$3[level2.ordinal()] : -1) {
            case -1:
            case 3:
                level = KmVersionRequirementLevel.HIDDEN;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                level = KmVersionRequirementLevel.WARNING;
                break;
            case 2:
                level = KmVersionRequirementLevel.ERROR;
                break;
        }
        v.setKind(kind);
        v.setLevel(level);
        v.setErrorCode(message != null ? message.getErrorCode() : null);
        v.setMessage(message != null ? message.getMessage() : null);
        if (message == null || (version = message.getVersion()) == null) {
            version = VersionRequirement.Version.INFINITY;
        }
        int major = version.component1();
        int minor = version.component2();
        int patch2 = version.component3();
        v.setVersion(new KmVersion(major, minor, patch2));
        return v;
    }

    private static final KmContract toKmContract(ProtoBuf.Contract $this$toKmContract, ReadContext c) {
        KmEffectType effectType;
        KmEffectInvocationKind effectKind;
        KmContract v = new KmContract();
        for (ProtoBuf.Effect effect : $this$toKmContract.getEffectList()) {
            if (effect.hasEffectType()) {
                ProtoBuf.Effect.EffectType effectType2 = effect.getEffectType();
                if (effectType2 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$4[effectType2.ordinal()]) {
                    case 1:
                        effectType = KmEffectType.RETURNS_CONSTANT;
                        break;
                    case 2:
                        effectType = KmEffectType.CALLS;
                        break;
                    case 3:
                        effectType = KmEffectType.RETURNS_NOT_NULL;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                if (effect.hasKind()) {
                    ProtoBuf.Effect.InvocationKind kind = effect.getKind();
                    if (kind == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    switch (WhenMappings.$EnumSwitchMapping$5[kind.ordinal()]) {
                        case 1:
                            effectKind = KmEffectInvocationKind.AT_MOST_ONCE;
                            break;
                        case 2:
                            effectKind = KmEffectInvocationKind.EXACTLY_ONCE;
                            break;
                        case 3:
                            effectKind = KmEffectInvocationKind.AT_LEAST_ONCE;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    effectKind = null;
                }
                List<KmEffect> effects = v.getEffects();
                Intrinsics.checkNotNull(effect);
                effects.add(toKmEffect(effect, effectType, effectKind, c));
            }
        }
        return v;
    }

    private static final KmEffect toKmEffect(ProtoBuf.Effect $this$toKmEffect, KmEffectType type, KmEffectInvocationKind kind, ReadContext c) {
        KmEffect v = new KmEffect(type, kind);
        Iterable effectConstructorArgumentList = $this$toKmEffect.getEffectConstructorArgumentList();
        Intrinsics.checkNotNullExpressionValue(effectConstructorArgumentList, "getEffectConstructorArgumentList(...)");
        Iterable $this$mapTo$iv = effectConstructorArgumentList;
        Collection destination$iv = v.getConstructorArguments();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Expression it = (ProtoBuf.Expression) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmEffectExpression(it, c));
        }
        if ($this$toKmEffect.hasConclusionOfConditionalEffect()) {
            ProtoBuf.Expression conclusionOfConditionalEffect = $this$toKmEffect.getConclusionOfConditionalEffect();
            Intrinsics.checkNotNullExpressionValue(conclusionOfConditionalEffect, "getConclusionOfConditionalEffect(...)");
            v.setConclusion(toKmEffectExpression(conclusionOfConditionalEffect, c));
        }
        return v;
    }

    private static final KmEffectExpression toKmEffectExpression(ProtoBuf.Expression $this$toKmEffectExpression, ReadContext c) {
        Boolean bool;
        KmEffectExpression v = new KmEffectExpression();
        v.setFlags$kotlin_metadata($this$toKmEffectExpression.getFlags());
        v.setParameterIndex($this$toKmEffectExpression.hasValueParameterReference() ? Integer.valueOf($this$toKmEffectExpression.getValueParameterReference()) : null);
        if ($this$toKmEffectExpression.hasConstantValue()) {
            ProtoBuf.Expression.ConstantValue constantValue = $this$toKmEffectExpression.getConstantValue();
            if (constantValue == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$6[constantValue.ordinal()]) {
                case 1:
                    bool = true;
                    break;
                case 2:
                    bool = false;
                    break;
                case 3:
                    bool = null;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            v.setConstantValue(new KmConstantValue(bool));
        }
        ProtoBuf.Type isInstanceType = ProtoTypeTableUtilKt.isInstanceType($this$toKmEffectExpression, c.getTypes());
        v.setInstanceType(isInstanceType != null ? toKmType(isInstanceType, c) : null);
        Iterable $this$mapTo$iv = $this$toKmEffectExpression.getAndArgumentList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv, "getAndArgumentList(...)");
        Collection destination$iv = v.getAndArguments();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Expression it = (ProtoBuf.Expression) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(toKmEffectExpression(it, c));
        }
        Iterable $this$mapTo$iv2 = $this$toKmEffectExpression.getOrArgumentList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv2, "getOrArgumentList(...)");
        Collection destination$iv2 = v.getOrArguments();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.Expression it2 = (ProtoBuf.Expression) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(toKmEffectExpression(it2, c));
        }
        return v;
    }

    private static final int getTypeFlags(ProtoBuf.Type $this$typeFlags) {
        return ($this$typeFlags.getNullable() ? 1 : 0) + ($this$typeFlags.getFlags() << 1);
    }

    private static final int getTypeParameterFlags(ProtoBuf.TypeParameter $this$typeParameterFlags) {
        return $this$typeParameterFlags.getReified() ? 1 : 0;
    }

    public static final int getPropertyGetterFlags(ProtoBuf.Property $this$getPropertyGetterFlags) {
        Intrinsics.checkNotNullParameter($this$getPropertyGetterFlags, "<this>");
        return $this$getPropertyGetterFlags.hasGetterFlags() ? $this$getPropertyGetterFlags.getGetterFlags() : getDefaultPropertyAccessorFlags($this$getPropertyGetterFlags.getFlags());
    }

    public static final int getPropertySetterFlags(ProtoBuf.Property $this$getPropertySetterFlags) {
        Intrinsics.checkNotNullParameter($this$getPropertySetterFlags, "<this>");
        return $this$getPropertySetterFlags.hasSetterFlags() ? $this$getPropertySetterFlags.getSetterFlags() : getDefaultPropertyAccessorFlags($this$getPropertySetterFlags.getFlags());
    }

    public static final int getDefaultPropertyAccessorFlags(int flags) {
        Boolean bool = Flags.HAS_ANNOTATIONS.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return Flags.getAccessorFlags(bool.booleanValue(), Flags.VISIBILITY.get(flags), Flags.MODALITY.get(flags), false, false, false);
    }
}