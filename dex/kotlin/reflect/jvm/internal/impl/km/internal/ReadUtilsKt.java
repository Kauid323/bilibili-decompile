package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ReadUtils.kt */
public final class ReadUtilsKt {

    /* compiled from: ReadUtils.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final KmAnnotation readAnnotation(ProtoBuf.Annotation $this$readAnnotation, NameResolver strings) {
        Intrinsics.checkNotNullParameter($this$readAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        String className = getClassName(strings, $this$readAnnotation.getId());
        Iterable argumentList = $this$readAnnotation.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "getArgumentList(...)");
        Iterable $this$mapNotNull$iv = argumentList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            ProtoBuf.Annotation.Argument argument = (ProtoBuf.Annotation.Argument) element$iv$iv$iv;
            ProtoBuf.Annotation.Argument.Value value = argument.getValue();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            KmAnnotationArgument value2 = readAnnotationArgument(value, strings);
            Pair pair = value2 != null ? TuplesKt.to(strings.getString(argument.getNameId()), value2) : null;
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        return new KmAnnotation(className, MapsKt.toMap((List) destination$iv$iv));
    }

    public static final KmAnnotationArgument readAnnotationArgument(ProtoBuf.Annotation.Argument.Value $this$readAnnotationArgument, NameResolver strings) {
        Intrinsics.checkNotNullParameter($this$readAnnotationArgument, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        if (Flags.IS_UNSIGNED.get($this$readAnnotationArgument.getFlags()).booleanValue()) {
            ProtoBuf.Annotation.Argument.Value.Type type = $this$readAnnotationArgument.getType();
            switch (type != null ? WhenMappings.$EnumSwitchMapping$0[type.ordinal()] : -1) {
                case 1:
                    return new KmAnnotationArgument.UByteValue(UByte.constructor-impl((byte) $this$readAnnotationArgument.getIntValue()), null);
                case 2:
                    return new KmAnnotationArgument.UShortValue(UShort.constructor-impl((short) $this$readAnnotationArgument.getIntValue()), null);
                case 3:
                    return new KmAnnotationArgument.UIntValue(UInt.constructor-impl((int) $this$readAnnotationArgument.getIntValue()), null);
                case 4:
                    return new KmAnnotationArgument.ULongValue(ULong.constructor-impl($this$readAnnotationArgument.getIntValue()), null);
                default:
                    throw new IllegalStateException(("Cannot read value of unsigned type: " + $this$readAnnotationArgument.getType()).toString());
            }
        }
        ProtoBuf.Annotation.Argument.Value.Type type2 = $this$readAnnotationArgument.getType();
        switch (type2 != null ? WhenMappings.$EnumSwitchMapping$0[type2.ordinal()] : -1) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return new KmAnnotationArgument.ByteValue((byte) $this$readAnnotationArgument.getIntValue());
            case 2:
                return new KmAnnotationArgument.ShortValue((short) $this$readAnnotationArgument.getIntValue());
            case 3:
                return new KmAnnotationArgument.IntValue((int) $this$readAnnotationArgument.getIntValue());
            case 4:
                return new KmAnnotationArgument.LongValue($this$readAnnotationArgument.getIntValue());
            case 5:
                return new KmAnnotationArgument.CharValue((char) $this$readAnnotationArgument.getIntValue());
            case 6:
                return new KmAnnotationArgument.FloatValue($this$readAnnotationArgument.getFloatValue());
            case 7:
                return new KmAnnotationArgument.DoubleValue($this$readAnnotationArgument.getDoubleValue());
            case 8:
                return new KmAnnotationArgument.BooleanValue($this$readAnnotationArgument.getIntValue() != 0);
            case 9:
                return new KmAnnotationArgument.StringValue(strings.getString($this$readAnnotationArgument.getStringValue()));
            case 10:
                String className = getClassName(strings, $this$readAnnotationArgument.getClassId());
                return $this$readAnnotationArgument.getArrayDimensionCount() == 0 ? new KmAnnotationArgument.KClassValue(className) : new KmAnnotationArgument.ArrayKClassValue(className, $this$readAnnotationArgument.getArrayDimensionCount());
            case 11:
                return new KmAnnotationArgument.EnumValue(getClassName(strings, $this$readAnnotationArgument.getClassId()), strings.getString($this$readAnnotationArgument.getEnumValueId()));
            case additional_type_content_opus_VALUE:
                ProtoBuf.Annotation annotation = $this$readAnnotationArgument.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "getAnnotation(...)");
                return new KmAnnotationArgument.AnnotationValue(readAnnotation(annotation, strings));
            case additional_type_content_video_VALUE:
                Iterable arrayElementList = $this$readAnnotationArgument.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(arrayElementList, "getArrayElementList(...)");
                Iterable $this$mapNotNull$iv = arrayElementList;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    ProtoBuf.Annotation.Argument.Value it = (ProtoBuf.Annotation.Argument.Value) element$iv$iv$iv;
                    Intrinsics.checkNotNull(it);
                    KmAnnotationArgument readAnnotationArgument = readAnnotationArgument(it, strings);
                    if (readAnnotationArgument != null) {
                        destination$iv$iv.add(readAnnotationArgument);
                    }
                }
                return new KmAnnotationArgument.ArrayValue((List) destination$iv$iv);
        }
    }

    public static final String getClassName(NameResolver $this$getClassName, int index) {
        Intrinsics.checkNotNullParameter($this$getClassName, "<this>");
        String name = $this$getClassName.getQualifiedClassName(index);
        return $this$getClassName.isLocalClassName(index) ? FilenameUtils.EXTENSION_SEPARATOR + name : name;
    }
}