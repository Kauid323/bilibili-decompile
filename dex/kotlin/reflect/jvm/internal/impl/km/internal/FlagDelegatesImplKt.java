package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.MemberKind;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: FlagDelegatesImpl.kt */
public final class FlagDelegatesImplKt {
    public static final <Node> EnumFlagDelegate<Node, Visibility> visibilityDelegate(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY, "VISIBILITY");
        EnumEntries<Visibility> entries = Visibility.getEntries();
        Iterable $this$map$iv = Visibility.getEntries();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Visibility it = (Visibility) item$iv$iv;
            destination$iv$iv.add(it.getFlag$kotlin_metadata());
        }
        return new EnumFlagDelegate<>(flags, VISIBILITY, entries, (List) destination$iv$iv);
    }

    public static final <Node> EnumFlagDelegate<Node, Modality> modalityDelegate(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.Modality> MODALITY = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(MODALITY, "MODALITY");
        EnumEntries<Modality> entries = Modality.getEntries();
        Iterable $this$map$iv = Modality.getEntries();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Modality it = (Modality) item$iv$iv;
            destination$iv$iv.add(it.getFlag$kotlin_metadata());
        }
        return new EnumFlagDelegate<>(flags, MODALITY, entries, (List) destination$iv$iv);
    }

    public static final <Node> EnumFlagDelegate<Node, MemberKind> memberKindDelegate(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND = Flags.MEMBER_KIND;
        Intrinsics.checkNotNullExpressionValue(MEMBER_KIND, "MEMBER_KIND");
        EnumEntries<MemberKind> entries = MemberKind.getEntries();
        Iterable $this$map$iv = MemberKind.getEntries();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MemberKind it = (MemberKind) item$iv$iv;
            destination$iv$iv.add(it.getFlag$kotlin_metadata());
        }
        return new EnumFlagDelegate<>(flags, MEMBER_KIND, entries, (List) destination$iv$iv);
    }

    public static final BooleanFlagDelegate<KmClass> classBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$classBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmClass) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmClass) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmFunction> functionBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$functionBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmFunction) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmFunction) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmConstructor> constructorBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$constructorBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmConstructor) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmConstructor) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmProperty> propertyBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$propertyBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmProperty) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmProperty) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmPropertyAccessorAttributes> propertyAccessorBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$propertyAccessorBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmPropertyAccessorAttributes) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmValueParameter> valueParameterBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$valueParameterBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmValueParameter) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmValueParameter) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmTypeAlias> typeAliasBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$typeAliasBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmTypeAlias) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmTypeAlias) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmType> typeBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt$typeBooleanFlag$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return Integer.valueOf(((KmType) receiver0).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((KmType) receiver0).setFlags$kotlin_metadata(((Number) value).intValue());
            }
        }, flag);
    }
}