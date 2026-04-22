package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.ClassNameKt;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable;

/* compiled from: WriteUtils.kt */
public final class WriteUtilsKt {
    public static final ProtoBuf.Annotation.Builder writeAnnotation(KmAnnotation $this$writeAnnotation, StringTable strings) {
        Intrinsics.checkNotNullParameter($this$writeAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ProtoBuf.Annotation.Builder $this$writeAnnotation_u24lambda_u240 = ProtoBuf.Annotation.newBuilder();
        $this$writeAnnotation_u24lambda_u240.setId(getClassNameIndex(strings, $this$writeAnnotation.getClassName()));
        for (Map.Entry<String, KmAnnotationArgument> entry : $this$writeAnnotation.getArguments().entrySet()) {
            String name = entry.getKey();
            KmAnnotationArgument argument = entry.getValue();
            ProtoBuf.Annotation.Argument.Builder $this$writeAnnotation_u24lambda_u240_u240 = ProtoBuf.Annotation.Argument.newBuilder();
            $this$writeAnnotation_u24lambda_u240_u240.setNameId(strings.getStringIndex(name));
            $this$writeAnnotation_u24lambda_u240_u240.setValue(writeAnnotationArgument(argument, strings).build());
            $this$writeAnnotation_u24lambda_u240.addArgument($this$writeAnnotation_u24lambda_u240_u240);
        }
        Intrinsics.checkNotNullExpressionValue($this$writeAnnotation_u24lambda_u240, "apply(...)");
        return $this$writeAnnotation_u24lambda_u240;
    }

    public static final ProtoBuf.Annotation.Argument.Value.Builder writeAnnotationArgument(KmAnnotationArgument $this$writeAnnotationArgument, StringTable strings) {
        Intrinsics.checkNotNullParameter($this$writeAnnotationArgument, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ProtoBuf.Annotation.Argument.Value.Builder $this$writeAnnotationArgument_u24lambda_u240 = ProtoBuf.Annotation.Argument.Value.newBuilder();
        if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.ByteValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.ByteValue) $this$writeAnnotationArgument).getValue().byteValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.CharValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.CHAR);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.CharValue) $this$writeAnnotationArgument).getValue().charValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.ShortValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.ShortValue) $this$writeAnnotationArgument).getValue().shortValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.IntValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.IntValue) $this$writeAnnotationArgument).getValue().intValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.LongValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.LongValue) $this$writeAnnotationArgument).getValue().longValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.FloatValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.FLOAT);
            $this$writeAnnotationArgument_u24lambda_u240.setFloatValue(((KmAnnotationArgument.FloatValue) $this$writeAnnotationArgument).getValue().floatValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.DoubleValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.DOUBLE);
            $this$writeAnnotationArgument_u24lambda_u240.setDoubleValue(((KmAnnotationArgument.DoubleValue) $this$writeAnnotationArgument).getValue().doubleValue());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.BooleanValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.BooleanValue) $this$writeAnnotationArgument).getValue().booleanValue() ? 1L : 0L);
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.UByteValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.UByteValue) $this$writeAnnotationArgument).m1164getValuew2LRezQ() & 255);
            $this$writeAnnotationArgument_u24lambda_u240.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.UShortValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.UShortValue) $this$writeAnnotationArgument).m1167getValueMh2AYeg() & 65535);
            $this$writeAnnotationArgument_u24lambda_u240.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.UIntValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.UIntValue) $this$writeAnnotationArgument).m1165getValuepVg5ArA() & 4294967295L);
            $this$writeAnnotationArgument_u24lambda_u240.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.ULongValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            $this$writeAnnotationArgument_u24lambda_u240.setIntValue(((KmAnnotationArgument.ULongValue) $this$writeAnnotationArgument).m1166getValuesVKNKU());
            $this$writeAnnotationArgument_u24lambda_u240.setFlags(Flags.IS_UNSIGNED.toFlags((Boolean) true));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.StringValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.STRING);
            $this$writeAnnotationArgument_u24lambda_u240.setStringValue(strings.getStringIndex(((KmAnnotationArgument.StringValue) $this$writeAnnotationArgument).getValue()));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.KClassValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            $this$writeAnnotationArgument_u24lambda_u240.setClassId(getClassNameIndex(strings, ((KmAnnotationArgument.KClassValue) $this$writeAnnotationArgument).getClassName()));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.ArrayKClassValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            $this$writeAnnotationArgument_u24lambda_u240.setClassId(getClassNameIndex(strings, ((KmAnnotationArgument.ArrayKClassValue) $this$writeAnnotationArgument).getClassName()));
            $this$writeAnnotationArgument_u24lambda_u240.setArrayDimensionCount(((KmAnnotationArgument.ArrayKClassValue) $this$writeAnnotationArgument).getArrayDimensionCount());
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.EnumValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.ENUM);
            $this$writeAnnotationArgument_u24lambda_u240.setClassId(getClassNameIndex(strings, ((KmAnnotationArgument.EnumValue) $this$writeAnnotationArgument).getEnumClassName()));
            $this$writeAnnotationArgument_u24lambda_u240.setEnumValueId(strings.getStringIndex(((KmAnnotationArgument.EnumValue) $this$writeAnnotationArgument).getEnumEntryName()));
        } else if ($this$writeAnnotationArgument instanceof KmAnnotationArgument.AnnotationValue) {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION);
            $this$writeAnnotationArgument_u24lambda_u240.setAnnotation(writeAnnotation(((KmAnnotationArgument.AnnotationValue) $this$writeAnnotationArgument).getAnnotation(), strings).build());
        } else if (!($this$writeAnnotationArgument instanceof KmAnnotationArgument.ArrayValue)) {
            throw new NoWhenBranchMatchedException();
        } else {
            $this$writeAnnotationArgument_u24lambda_u240.setType(ProtoBuf.Annotation.Argument.Value.Type.ARRAY);
            for (KmAnnotationArgument element : ((KmAnnotationArgument.ArrayValue) $this$writeAnnotationArgument).getElements()) {
                $this$writeAnnotationArgument_u24lambda_u240.addArrayElement(writeAnnotationArgument(element, strings));
            }
        }
        Intrinsics.checkNotNullExpressionValue($this$writeAnnotationArgument_u24lambda_u240, "apply(...)");
        return $this$writeAnnotationArgument_u24lambda_u240;
    }

    public static final int getClassNameIndex(StringTable $this$getClassNameIndex, String name) {
        Intrinsics.checkNotNullParameter($this$getClassNameIndex, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (ClassNameKt.isLocalClassName(name)) {
            String substring = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return $this$getClassNameIndex.getQualifiedClassNameIndex(substring, true);
        }
        return $this$getClassNameIndex.getQualifiedClassNameIndex(name, false);
    }
}