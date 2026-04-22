package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: protoTypeTableUtil.kt */
public final class ProtoTypeTableUtilKt {
    public static final List<ProtoBuf.Type> supertypes(ProtoBuf.Class $this$supertypes, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$supertypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> supertypeList = $this$supertypes.getSupertypeList();
        List<ProtoBuf.Type> p0 = supertypeList;
        if (p0.isEmpty()) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            Iterable supertypeIdList = $this$supertypes.getSupertypeIdList();
            Intrinsics.checkNotNullExpressionValue(supertypeIdList, "getSupertypeIdList(...)");
            Iterable $this$map$iv = supertypeIdList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Integer it = (Integer) item$iv$iv;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(typeTable.get(it.intValue()));
            }
            return (List) destination$iv$iv;
        }
        return supertypeList;
    }

    public static final ProtoBuf.Type inlineClassUnderlyingType(ProtoBuf.Class $this$inlineClassUnderlyingType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$inlineClassUnderlyingType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$inlineClassUnderlyingType.hasInlineClassUnderlyingType()) {
            return $this$inlineClassUnderlyingType.getInlineClassUnderlyingType();
        }
        if ($this$inlineClassUnderlyingType.hasInlineClassUnderlyingTypeId()) {
            return typeTable.get($this$inlineClassUnderlyingType.getInlineClassUnderlyingTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type type(ProtoBuf.Type.Argument $this$type, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$type.hasType()) {
            return $this$type.getType();
        }
        if ($this$type.hasTypeId()) {
            return typeTable.get($this$type.getTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type flexibleUpperBound(ProtoBuf.Type $this$flexibleUpperBound, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$flexibleUpperBound, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$flexibleUpperBound.hasFlexibleUpperBound()) {
            return $this$flexibleUpperBound.getFlexibleUpperBound();
        }
        if ($this$flexibleUpperBound.hasFlexibleUpperBoundId()) {
            return typeTable.get($this$flexibleUpperBound.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final List<ProtoBuf.Type> upperBounds(ProtoBuf.TypeParameter $this$upperBounds, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$upperBounds, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> upperBoundList = $this$upperBounds.getUpperBoundList();
        List<ProtoBuf.Type> p0 = upperBoundList;
        if (p0.isEmpty()) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            Iterable upperBoundIdList = $this$upperBounds.getUpperBoundIdList();
            Intrinsics.checkNotNullExpressionValue(upperBoundIdList, "getUpperBoundIdList(...)");
            Iterable $this$map$iv = upperBoundIdList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Integer it = (Integer) item$iv$iv;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(typeTable.get(it.intValue()));
            }
            return (List) destination$iv$iv;
        }
        return upperBoundList;
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Function $this$returnType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$returnType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (!$this$returnType.hasReturnType()) {
            if ($this$returnType.hasReturnTypeId()) {
                return typeTable.get($this$returnType.getReturnTypeId());
            }
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
        ProtoBuf.Type returnType = $this$returnType.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return returnType;
    }

    public static final boolean hasReceiver(ProtoBuf.Function $this$hasReceiver) {
        Intrinsics.checkNotNullParameter($this$hasReceiver, "<this>");
        return $this$hasReceiver.hasReceiverType() || $this$hasReceiver.hasReceiverTypeId();
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Function $this$receiverType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$receiverType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$receiverType.hasReceiverType()) {
            return $this$receiverType.getReceiverType();
        }
        if ($this$receiverType.hasReceiverTypeId()) {
            return typeTable.get($this$receiverType.getReceiverTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Property $this$returnType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$returnType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (!$this$returnType.hasReturnType()) {
            if ($this$returnType.hasReturnTypeId()) {
                return typeTable.get($this$returnType.getReturnTypeId());
            }
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
        ProtoBuf.Type returnType = $this$returnType.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return returnType;
    }

    public static final boolean hasReceiver(ProtoBuf.Property $this$hasReceiver) {
        Intrinsics.checkNotNullParameter($this$hasReceiver, "<this>");
        return $this$hasReceiver.hasReceiverType() || $this$hasReceiver.hasReceiverTypeId();
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Property $this$receiverType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$receiverType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$receiverType.hasReceiverType()) {
            return $this$receiverType.getReceiverType();
        }
        if ($this$receiverType.hasReceiverTypeId()) {
            return typeTable.get($this$receiverType.getReceiverTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type type(ProtoBuf.ValueParameter $this$type, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (!$this$type.hasType()) {
            if ($this$type.hasTypeId()) {
                return typeTable.get($this$type.getTypeId());
            }
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
        ProtoBuf.Type type = $this$type.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    public static final ProtoBuf.Type varargElementType(ProtoBuf.ValueParameter $this$varargElementType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$varargElementType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$varargElementType.hasVarargElementType()) {
            return $this$varargElementType.getVarargElementType();
        }
        if ($this$varargElementType.hasVarargElementTypeId()) {
            return typeTable.get($this$varargElementType.getVarargElementTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type outerType(ProtoBuf.Type $this$outerType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$outerType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$outerType.hasOuterType()) {
            return $this$outerType.getOuterType();
        }
        if ($this$outerType.hasOuterTypeId()) {
            return typeTable.get($this$outerType.getOuterTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type abbreviatedType(ProtoBuf.Type $this$abbreviatedType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$abbreviatedType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$abbreviatedType.hasAbbreviatedType()) {
            return $this$abbreviatedType.getAbbreviatedType();
        }
        if ($this$abbreviatedType.hasAbbreviatedTypeId()) {
            return typeTable.get($this$abbreviatedType.getAbbreviatedTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type underlyingType(ProtoBuf.TypeAlias $this$underlyingType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$underlyingType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (!$this$underlyingType.hasUnderlyingType()) {
            if ($this$underlyingType.hasUnderlyingTypeId()) {
                return typeTable.get($this$underlyingType.getUnderlyingTypeId());
            }
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
        ProtoBuf.Type underlyingType = $this$underlyingType.getUnderlyingType();
        Intrinsics.checkNotNullExpressionValue(underlyingType, "getUnderlyingType(...)");
        return underlyingType;
    }

    public static final ProtoBuf.Type expandedType(ProtoBuf.TypeAlias $this$expandedType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$expandedType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (!$this$expandedType.hasExpandedType()) {
            if ($this$expandedType.hasExpandedTypeId()) {
                return typeTable.get($this$expandedType.getExpandedTypeId());
            }
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
        ProtoBuf.Type expandedType = $this$expandedType.getExpandedType();
        Intrinsics.checkNotNullExpressionValue(expandedType, "getExpandedType(...)");
        return expandedType;
    }

    public static final ProtoBuf.Type isInstanceType(ProtoBuf.Expression $this$isInstanceType, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$isInstanceType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$isInstanceType.hasIsInstanceType()) {
            return $this$isInstanceType.getIsInstanceType();
        }
        if ($this$isInstanceType.hasIsInstanceTypeId()) {
            return typeTable.get($this$isInstanceType.getIsInstanceTypeId());
        }
        return null;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Class $this$contextReceiverTypes, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$contextReceiverTypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> contextReceiverTypeList = $this$contextReceiverTypes.getContextReceiverTypeList();
        List<ProtoBuf.Type> p0 = contextReceiverTypeList;
        if (p0.isEmpty()) {
            contextReceiverTypeList = null;
        }
        if (contextReceiverTypeList == null) {
            Iterable contextReceiverTypeIdList = $this$contextReceiverTypes.getContextReceiverTypeIdList();
            Intrinsics.checkNotNullExpressionValue(contextReceiverTypeIdList, "getContextReceiverTypeIdList(...)");
            Iterable $this$map$iv = contextReceiverTypeIdList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Integer it = (Integer) item$iv$iv;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(typeTable.get(it.intValue()));
            }
            return (List) destination$iv$iv;
        }
        return contextReceiverTypeList;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Function $this$contextReceiverTypes, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$contextReceiverTypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> contextReceiverTypeList = $this$contextReceiverTypes.getContextReceiverTypeList();
        List<ProtoBuf.Type> p0 = contextReceiverTypeList;
        if (p0.isEmpty()) {
            contextReceiverTypeList = null;
        }
        if (contextReceiverTypeList == null) {
            Iterable contextReceiverTypeIdList = $this$contextReceiverTypes.getContextReceiverTypeIdList();
            Intrinsics.checkNotNullExpressionValue(contextReceiverTypeIdList, "getContextReceiverTypeIdList(...)");
            Iterable $this$map$iv = contextReceiverTypeIdList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Integer it = (Integer) item$iv$iv;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(typeTable.get(it.intValue()));
            }
            return (List) destination$iv$iv;
        }
        return contextReceiverTypeList;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Property $this$contextReceiverTypes, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$contextReceiverTypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> contextReceiverTypeList = $this$contextReceiverTypes.getContextReceiverTypeList();
        List<ProtoBuf.Type> p0 = contextReceiverTypeList;
        if (p0.isEmpty()) {
            contextReceiverTypeList = null;
        }
        if (contextReceiverTypeList == null) {
            Iterable contextReceiverTypeIdList = $this$contextReceiverTypes.getContextReceiverTypeIdList();
            Intrinsics.checkNotNullExpressionValue(contextReceiverTypeIdList, "getContextReceiverTypeIdList(...)");
            Iterable $this$map$iv = contextReceiverTypeIdList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Integer it = (Integer) item$iv$iv;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(typeTable.get(it.intValue()));
            }
            return (List) destination$iv$iv;
        }
        return contextReceiverTypeList;
    }
}