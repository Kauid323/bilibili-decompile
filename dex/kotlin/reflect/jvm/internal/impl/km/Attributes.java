package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: Attributes.kt */
public final class Attributes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Attributes.class, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1))};
    private static final BooleanFlagDelegate declaresDefaultValue$delegate;
    private static final BooleanFlagDelegate hasAnnotations$delegate;
    private static final BooleanFlagDelegate hasAnnotations$delegate$1;
    private static final BooleanFlagDelegate hasAnnotations$delegate$2;
    private static final BooleanFlagDelegate hasAnnotations$delegate$3;
    private static final BooleanFlagDelegate hasAnnotations$delegate$4;
    private static final BooleanFlagDelegate hasAnnotations$delegate$5;
    private static final BooleanFlagDelegate hasAnnotations$delegate$6;
    private static final BooleanFlagDelegate hasConstant$delegate;
    private static final BooleanFlagDelegate hasEnumEntries$delegate;
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate;
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate$1;
    private static final BooleanFlagDelegate isConst$delegate;
    private static final BooleanFlagDelegate isCrossinline$delegate;
    private static final BooleanFlagDelegate isData$delegate;
    private static final BooleanFlagDelegate isDefinitelyNonNull$delegate;
    private static final BooleanFlagDelegate isDelegated$delegate;
    private static final BooleanFlagDelegate isExpect$delegate;
    private static final BooleanFlagDelegate isExpect$delegate$1;
    private static final BooleanFlagDelegate isExpect$delegate$2;
    private static final BooleanFlagDelegate isExternal$delegate;
    private static final BooleanFlagDelegate isExternal$delegate$1;
    private static final BooleanFlagDelegate isExternal$delegate$2;
    private static final BooleanFlagDelegate isExternal$delegate$3;
    private static final BooleanFlagDelegate isFunInterface$delegate;
    private static final BooleanFlagDelegate isInfix$delegate;
    private static final BooleanFlagDelegate isInline$delegate;
    private static final BooleanFlagDelegate isInline$delegate$1;
    private static final BooleanFlagDelegate isInner$delegate;
    private static final BooleanFlagDelegate isLateinit$delegate;
    private static final BooleanFlagDelegate isNegated$delegate;
    private static final BooleanFlagDelegate isNoinline$delegate;
    private static final BooleanFlagDelegate isNotDefault$delegate;
    private static final BooleanFlagDelegate isNullCheckPredicate$delegate;
    private static final BooleanFlagDelegate isNullable$delegate;
    private static final BooleanFlagDelegate isOperator$delegate;
    private static final BooleanFlagDelegate isReified$delegate;
    private static final BooleanFlagDelegate isSecondary$delegate;
    private static final BooleanFlagDelegate isSuspend$delegate;
    private static final BooleanFlagDelegate isSuspend$delegate$1;
    private static final BooleanFlagDelegate isTailrec$delegate;
    private static final BooleanFlagDelegate isValue$delegate;
    private static final BooleanFlagDelegate isVar$delegate;
    private static final EnumFlagDelegate kind$delegate;
    private static final EnumFlagDelegate kind$delegate$1;
    private static final EnumFlagDelegate kind$delegate$2;
    private static final EnumFlagDelegate modality$delegate;
    private static final EnumFlagDelegate modality$delegate$1;
    private static final EnumFlagDelegate modality$delegate$2;
    private static final EnumFlagDelegate modality$delegate$3;
    private static final EnumFlagDelegate visibility$delegate;
    private static final EnumFlagDelegate visibility$delegate$1;
    private static final EnumFlagDelegate visibility$delegate$2;
    private static final EnumFlagDelegate visibility$delegate$3;
    private static final EnumFlagDelegate visibility$delegate$4;
    private static final EnumFlagDelegate visibility$delegate$5;

    public static final Modality getModality(KmClass $this$modality) {
        Intrinsics.checkNotNullParameter($this$modality, "<this>");
        return (Modality) modality$delegate.getValue($this$modality, $$delegatedProperties[7]);
    }

    public static final ClassKind getKind(KmClass $this$kind) {
        Intrinsics.checkNotNullParameter($this$kind, "<this>");
        return (ClassKind) kind$delegate.getValue($this$kind, $$delegatedProperties[9]);
    }

    public static final boolean isInner(KmClass $this$isInner) {
        Intrinsics.checkNotNullParameter($this$isInner, "<this>");
        return isInner$delegate.getValue($this$isInner, $$delegatedProperties[10]);
    }

    public static final boolean isData(KmClass $this$isData) {
        Intrinsics.checkNotNullParameter($this$isData, "<this>");
        return isData$delegate.getValue($this$isData, $$delegatedProperties[11]);
    }

    public static final boolean isValue(KmClass $this$isValue) {
        Intrinsics.checkNotNullParameter($this$isValue, "<this>");
        return isValue$delegate.getValue($this$isValue, $$delegatedProperties[14]);
    }

    public static final boolean isFunInterface(KmClass $this$isFunInterface) {
        Intrinsics.checkNotNullParameter($this$isFunInterface, "<this>");
        return isFunInterface$delegate.getValue($this$isFunInterface, $$delegatedProperties[15]);
    }

    public static final boolean isNullable(KmType $this$isNullable) {
        Intrinsics.checkNotNullParameter($this$isNullable, "<this>");
        return isNullable$delegate.getValue($this$isNullable, $$delegatedProperties[46]);
    }

    public static final boolean isReified(KmTypeParameter $this$isReified) {
        Intrinsics.checkNotNullParameter($this$isReified, "<this>");
        return isReified$delegate.getValue($this$isReified, $$delegatedProperties[49]);
    }

    static {
        Flags.BooleanFlagField HAS_ANNOTATIONS = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        hasAnnotations$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(HAS_ANNOTATIONS));
        Flags.BooleanFlagField HAS_ANNOTATIONS2 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS2, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$1 = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(HAS_ANNOTATIONS2));
        Flags.BooleanFlagField HAS_ANNOTATIONS3 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS3, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$2 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(HAS_ANNOTATIONS3));
        Flags.BooleanFlagField HAS_ANNOTATIONS4 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS4, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$3 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_ANNOTATIONS4));
        Flags.BooleanFlagField HAS_ANNOTATIONS5 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS5, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$4 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(HAS_ANNOTATIONS5));
        Flags.BooleanFlagField HAS_ANNOTATIONS6 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS6, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$5 = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(HAS_ANNOTATIONS6));
        Flags.BooleanFlagField HAS_ANNOTATIONS7 = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS7, "HAS_ANNOTATIONS");
        hasAnnotations$delegate$6 = FlagDelegatesImplKt.typeAliasBooleanFlag(new FlagImpl(HAS_ANNOTATIONS7));
        modality$delegate = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmClass) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmClass) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        visibility$delegate = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmClass) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmClass) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        Attributes$kind$2 attributes$kind$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmClass) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmClass) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        };
        Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND = Flags.CLASS_KIND;
        Intrinsics.checkNotNullExpressionValue(CLASS_KIND, "CLASS_KIND");
        EnumEntries<ClassKind> entries = ClassKind.getEntries();
        Iterable $this$map$iv = ClassKind.getEntries();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ClassKind it = (ClassKind) item$iv$iv;
            destination$iv$iv.add(it.getFlag$kotlin_metadata());
        }
        kind$delegate = new EnumFlagDelegate(attributes$kind$2, CLASS_KIND, entries, (List) destination$iv$iv);
        Flags.BooleanFlagField IS_INNER = Flags.IS_INNER;
        Intrinsics.checkNotNullExpressionValue(IS_INNER, "IS_INNER");
        isInner$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_INNER));
        Flags.BooleanFlagField IS_DATA = Flags.IS_DATA;
        Intrinsics.checkNotNullExpressionValue(IS_DATA, "IS_DATA");
        isData$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_DATA));
        Flags.BooleanFlagField IS_EXTERNAL_CLASS = Flags.IS_EXTERNAL_CLASS;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_CLASS, "IS_EXTERNAL_CLASS");
        isExternal$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_EXTERNAL_CLASS));
        Flags.BooleanFlagField IS_EXPECT_CLASS = Flags.IS_EXPECT_CLASS;
        Intrinsics.checkNotNullExpressionValue(IS_EXPECT_CLASS, "IS_EXPECT_CLASS");
        isExpect$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_EXPECT_CLASS));
        Flags.BooleanFlagField IS_VALUE_CLASS = Flags.IS_VALUE_CLASS;
        Intrinsics.checkNotNullExpressionValue(IS_VALUE_CLASS, "IS_VALUE_CLASS");
        isValue$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_VALUE_CLASS));
        Flags.BooleanFlagField IS_FUN_INTERFACE = Flags.IS_FUN_INTERFACE;
        Intrinsics.checkNotNullExpressionValue(IS_FUN_INTERFACE, "IS_FUN_INTERFACE");
        isFunInterface$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(IS_FUN_INTERFACE));
        Flags.BooleanFlagField HAS_ENUM_ENTRIES = Flags.HAS_ENUM_ENTRIES;
        Intrinsics.checkNotNullExpressionValue(HAS_ENUM_ENTRIES, "HAS_ENUM_ENTRIES");
        hasEnumEntries$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(HAS_ENUM_ENTRIES));
        visibility$delegate$1 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmConstructor) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmConstructor) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        Flags.BooleanFlagField IS_SECONDARY = Flags.IS_SECONDARY;
        Intrinsics.checkNotNullExpressionValue(IS_SECONDARY, "IS_SECONDARY");
        isSecondary$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(IS_SECONDARY));
        Flags.BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
        Intrinsics.checkNotNullExpressionValue(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES));
        kind$delegate$1 = FlagDelegatesImplKt.memberKindDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$7
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmFunction) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmFunction) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        visibility$delegate$2 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmFunction) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmFunction) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        modality$delegate$1 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmFunction) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmFunction) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        Flags.BooleanFlagField IS_OPERATOR = Flags.IS_OPERATOR;
        Intrinsics.checkNotNullExpressionValue(IS_OPERATOR, "IS_OPERATOR");
        isOperator$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_OPERATOR));
        Flags.BooleanFlagField IS_INFIX = Flags.IS_INFIX;
        Intrinsics.checkNotNullExpressionValue(IS_INFIX, "IS_INFIX");
        isInfix$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_INFIX));
        Flags.BooleanFlagField IS_INLINE = Flags.IS_INLINE;
        Intrinsics.checkNotNullExpressionValue(IS_INLINE, "IS_INLINE");
        isInline$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_INLINE));
        Flags.BooleanFlagField IS_TAILREC = Flags.IS_TAILREC;
        Intrinsics.checkNotNullExpressionValue(IS_TAILREC, "IS_TAILREC");
        isTailrec$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_TAILREC));
        Flags.BooleanFlagField IS_EXTERNAL_FUNCTION = Flags.IS_EXTERNAL_FUNCTION;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_FUNCTION, "IS_EXTERNAL_FUNCTION");
        isExternal$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_EXTERNAL_FUNCTION));
        Flags.BooleanFlagField IS_SUSPEND = Flags.IS_SUSPEND;
        Intrinsics.checkNotNullExpressionValue(IS_SUSPEND, "IS_SUSPEND");
        isSuspend$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_SUSPEND));
        Flags.BooleanFlagField IS_EXPECT_FUNCTION = Flags.IS_EXPECT_FUNCTION;
        Intrinsics.checkNotNullExpressionValue(IS_EXPECT_FUNCTION, "IS_EXPECT_FUNCTION");
        isExpect$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_EXPECT_FUNCTION));
        Flags.BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
        Intrinsics.checkNotNullExpressionValue(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        hasNonStableParameterNames$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES));
        visibility$delegate$3 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmProperty) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmProperty) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        modality$delegate$2 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmProperty) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmProperty) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        kind$delegate$2 = FlagDelegatesImplKt.memberKindDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$11
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmProperty) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmProperty) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        Flags.BooleanFlagField IS_VAR = Flags.IS_VAR;
        Intrinsics.checkNotNullExpressionValue(IS_VAR, "IS_VAR");
        isVar$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_VAR));
        Flags.BooleanFlagField IS_CONST = Flags.IS_CONST;
        Intrinsics.checkNotNullExpressionValue(IS_CONST, "IS_CONST");
        isConst$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_CONST));
        Flags.BooleanFlagField IS_LATEINIT = Flags.IS_LATEINIT;
        Intrinsics.checkNotNullExpressionValue(IS_LATEINIT, "IS_LATEINIT");
        isLateinit$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_LATEINIT));
        Flags.BooleanFlagField HAS_CONSTANT = Flags.HAS_CONSTANT;
        Intrinsics.checkNotNullExpressionValue(HAS_CONSTANT, "HAS_CONSTANT");
        hasConstant$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_CONSTANT));
        Flags.BooleanFlagField IS_EXTERNAL_PROPERTY = Flags.IS_EXTERNAL_PROPERTY;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_PROPERTY, "IS_EXTERNAL_PROPERTY");
        isExternal$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_EXTERNAL_PROPERTY));
        Flags.BooleanFlagField IS_DELEGATED = Flags.IS_DELEGATED;
        Intrinsics.checkNotNullExpressionValue(IS_DELEGATED, "IS_DELEGATED");
        isDelegated$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_DELEGATED));
        Flags.BooleanFlagField IS_EXPECT_PROPERTY = Flags.IS_EXPECT_PROPERTY;
        Intrinsics.checkNotNullExpressionValue(IS_EXPECT_PROPERTY, "IS_EXPECT_PROPERTY");
        isExpect$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(IS_EXPECT_PROPERTY));
        visibility$delegate$4 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$18
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmPropertyAccessorAttributes) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        modality$delegate$3 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmPropertyAccessorAttributes) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        Flags.BooleanFlagField IS_NOT_DEFAULT = Flags.IS_NOT_DEFAULT;
        Intrinsics.checkNotNullExpressionValue(IS_NOT_DEFAULT, "IS_NOT_DEFAULT");
        isNotDefault$delegate = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(IS_NOT_DEFAULT));
        Flags.BooleanFlagField IS_EXTERNAL_ACCESSOR = Flags.IS_EXTERNAL_ACCESSOR;
        Intrinsics.checkNotNullExpressionValue(IS_EXTERNAL_ACCESSOR, "IS_EXTERNAL_ACCESSOR");
        isExternal$delegate$3 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(IS_EXTERNAL_ACCESSOR));
        Flags.BooleanFlagField IS_INLINE_ACCESSOR = Flags.IS_INLINE_ACCESSOR;
        Intrinsics.checkNotNullExpressionValue(IS_INLINE_ACCESSOR, "IS_INLINE_ACCESSOR");
        isInline$delegate$1 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(IS_INLINE_ACCESSOR));
        isNullable$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(0, 1, 1));
        isSuspend$delegate$1 = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(Flags.SUSPEND_TYPE.offset + 1, Flags.SUSPEND_TYPE.bitWidth, 1));
        isDefinitelyNonNull$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(Flags.DEFINITELY_NOT_NULL_TYPE.offset + 1, Flags.DEFINITELY_NOT_NULL_TYPE.bitWidth, 1));
        isReified$delegate = new BooleanFlagDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isReified$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmTypeParameter) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmTypeParameter) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, new FlagImpl(0, 1, 1));
        visibility$delegate$5 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$22
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmTypeAlias) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmTypeAlias) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        });
        Flags.BooleanFlagField DECLARES_DEFAULT_VALUE = Flags.DECLARES_DEFAULT_VALUE;
        Intrinsics.checkNotNullExpressionValue(DECLARES_DEFAULT_VALUE, "DECLARES_DEFAULT_VALUE");
        declaresDefaultValue$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(DECLARES_DEFAULT_VALUE));
        Flags.BooleanFlagField IS_CROSSINLINE = Flags.IS_CROSSINLINE;
        Intrinsics.checkNotNullExpressionValue(IS_CROSSINLINE, "IS_CROSSINLINE");
        isCrossinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(IS_CROSSINLINE));
        Flags.BooleanFlagField IS_NOINLINE = Flags.IS_NOINLINE;
        Intrinsics.checkNotNullExpressionValue(IS_NOINLINE, "IS_NOINLINE");
        isNoinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(IS_NOINLINE));
        Flags.BooleanFlagField IS_NEGATED = Flags.IS_NEGATED;
        Intrinsics.checkNotNullExpressionValue(IS_NEGATED, "IS_NEGATED");
        isNegated$delegate = new BooleanFlagDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNegated$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmEffectExpression) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmEffectExpression) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, new FlagImpl(IS_NEGATED));
        Flags.BooleanFlagField IS_NULL_CHECK_PREDICATE = Flags.IS_NULL_CHECK_PREDICATE;
        Intrinsics.checkNotNullExpressionValue(IS_NULL_CHECK_PREDICATE, "IS_NULL_CHECK_PREDICATE");
        isNullCheckPredicate$delegate = new BooleanFlagDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNullCheckPredicate$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmEffectExpression) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmEffectExpression) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, new FlagImpl(IS_NULL_CHECK_PREDICATE));
    }
}