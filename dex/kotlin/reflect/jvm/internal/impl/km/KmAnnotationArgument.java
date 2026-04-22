package kotlin.reflect.jvm.internal.impl.km;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.collection.DoubleList$;
import java.util.List;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FilenameUtils;

/* compiled from: Annotations.kt */
public abstract class KmAnnotationArgument {
    public /* synthetic */ KmAnnotationArgument(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String toString();

    private KmAnnotationArgument() {
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class LiteralValue<T> extends KmAnnotationArgument {
        public /* synthetic */ LiteralValue(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract T getValue();

        private LiteralValue() {
            super(null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public final String toString() {
            return getClass().getSimpleName() + '(' + (this instanceof StringValue ? new StringBuilder().append('\"').append((Object) ((StringValue) this).getValue()).append('\"').toString() : getValue().toString()) + ')';
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ByteValue extends LiteralValue<Byte> {
        private final byte value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ByteValue) && this.value == ((ByteValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public ByteValue(byte value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Byte getValue() {
            return Byte.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class CharValue extends LiteralValue<Character> {
        private final char value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CharValue) && this.value == ((CharValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public CharValue(char value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Character getValue() {
            return Character.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ShortValue extends LiteralValue<Short> {
        private final short value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShortValue) && this.value == ((ShortValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public ShortValue(short value) {
            super(null);
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Short getValue() {
            return Short.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class IntValue extends LiteralValue<Integer> {
        private final int value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntValue) && this.value == ((IntValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public IntValue(int value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class LongValue extends LiteralValue<Long> {
        private final long value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LongValue) && this.value == ((LongValue) obj).value;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.value);
        }

        public LongValue(long value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Long getValue() {
            return Long.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class FloatValue extends LiteralValue<Float> {
        private final float value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FloatValue) && Float.compare(this.value, ((FloatValue) obj).value) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public FloatValue(float value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Float getValue() {
            return Float.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DoubleValue extends LiteralValue<Double> {
        private final double value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoubleValue) && Double.compare(this.value, ((DoubleValue) obj).value) == 0;
        }

        public int hashCode() {
            return DoubleList$.ExternalSyntheticBackport0.m(this.value);
        }

        public DoubleValue(double value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Double getValue() {
            return Double.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class BooleanValue extends LiteralValue<Boolean> {
        private final boolean value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BooleanValue) && this.value == ((BooleanValue) obj).value;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.value);
        }

        public BooleanValue(boolean value) {
            super(null);
            this.value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class UByteValue extends LiteralValue<UByte> {
        private final byte value;

        public /* synthetic */ UByteValue(byte b, DefaultConstructorMarker defaultConstructorMarker) {
            this(b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UByteValue) && this.value == ((UByteValue) obj).value;
        }

        public int hashCode() {
            return UByte.hashCode-impl(this.value);
        }

        private UByteValue(byte value) {
            super(null);
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UByte getValue() {
            return UByte.box-impl(m1164getValuew2LRezQ());
        }

        /* renamed from: getValue-w2LRezQ  reason: not valid java name */
        public byte m1164getValuew2LRezQ() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class UShortValue extends LiteralValue<UShort> {
        private final short value;

        public /* synthetic */ UShortValue(short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(s);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UShortValue) && this.value == ((UShortValue) obj).value;
        }

        public int hashCode() {
            return UShort.hashCode-impl(this.value);
        }

        private UShortValue(short value) {
            super(null);
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UShort getValue() {
            return UShort.box-impl(m1167getValueMh2AYeg());
        }

        /* renamed from: getValue-Mh2AYeg  reason: not valid java name */
        public short m1167getValueMh2AYeg() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class UIntValue extends LiteralValue<UInt> {
        private final int value;

        public /* synthetic */ UIntValue(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UIntValue) && this.value == ((UIntValue) obj).value;
        }

        public int hashCode() {
            return UInt.hashCode-impl(this.value);
        }

        private UIntValue(int value) {
            super(null);
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UInt getValue() {
            return UInt.box-impl(m1165getValuepVg5ArA());
        }

        /* renamed from: getValue-pVg5ArA  reason: not valid java name */
        public int m1165getValuepVg5ArA() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ULongValue extends LiteralValue<ULong> {
        private final long value;

        public /* synthetic */ ULongValue(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ULongValue) && this.value == ((ULongValue) obj).value;
        }

        public int hashCode() {
            return ULong.hashCode-impl(this.value);
        }

        private ULongValue(long value) {
            super(null);
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ ULong getValue() {
            return ULong.box-impl(m1166getValuesVKNKU());
        }

        /* renamed from: getValue-s-VKNKU  reason: not valid java name */
        public long m1166getValuesVKNKU() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class StringValue extends LiteralValue<String> {
        private final String value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StringValue) && Intrinsics.areEqual(this.value, ((StringValue) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringValue(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public String getValue() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class EnumValue extends KmAnnotationArgument {
        private final String enumClassName;
        private final String enumEntryName;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnumValue) {
                EnumValue enumValue = (EnumValue) obj;
                return Intrinsics.areEqual(this.enumClassName, enumValue.enumClassName) && Intrinsics.areEqual(this.enumEntryName, enumValue.enumEntryName);
            }
            return false;
        }

        public int hashCode() {
            return (this.enumClassName.hashCode() * 31) + this.enumEntryName.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumValue(String enumClassName, String enumEntryName) {
            super(null);
            Intrinsics.checkNotNullParameter(enumClassName, "enumClassName");
            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            this.enumClassName = enumClassName;
            this.enumEntryName = enumEntryName;
        }

        public final String getEnumClassName() {
            return this.enumClassName;
        }

        public final String getEnumEntryName() {
            return this.enumEntryName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public String toString() {
            return "EnumValue(" + this.enumClassName + FilenameUtils.EXTENSION_SEPARATOR + this.enumEntryName + ')';
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnnotationValue extends KmAnnotationArgument {
        private final KmAnnotation annotation;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AnnotationValue) && Intrinsics.areEqual(this.annotation, ((AnnotationValue) obj).annotation);
        }

        public int hashCode() {
            return this.annotation.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnnotationValue(KmAnnotation annotation) {
            super(null);
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            this.annotation = annotation;
        }

        public final KmAnnotation getAnnotation() {
            return this.annotation;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public String toString() {
            return "AnnotationValue(" + this.annotation + ')';
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ArrayValue extends KmAnnotationArgument {
        private final List<KmAnnotationArgument> elements;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ArrayValue) && Intrinsics.areEqual(this.elements, ((ArrayValue) obj).elements);
        }

        public int hashCode() {
            return this.elements.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ArrayValue(List<? extends KmAnnotationArgument> elements) {
            super(null);
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        public final List<KmAnnotationArgument> getElements() {
            return this.elements;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public String toString() {
            return "ArrayValue(" + this.elements + ')';
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class KClassValue extends KmAnnotationArgument {
        private final String className;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof KClassValue) && Intrinsics.areEqual(this.className, ((KClassValue) obj).className);
        }

        public int hashCode() {
            return this.className.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KClassValue(String className) {
            super(null);
            Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
        }

        public final String getClassName() {
            return this.className;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public String toString() {
            return "KClassValue(" + this.className + ')';
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ArrayKClassValue extends KmAnnotationArgument {
        private final int arrayDimensionCount;
        private final String className;
        private final String stringRepresentation;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ArrayKClassValue) {
                ArrayKClassValue arrayKClassValue = (ArrayKClassValue) obj;
                return Intrinsics.areEqual(this.className, arrayKClassValue.className) && this.arrayDimensionCount == arrayKClassValue.arrayDimensionCount;
            }
            return false;
        }

        public int hashCode() {
            return (this.className.hashCode() * 31) + this.arrayDimensionCount;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayKClassValue(String className, int arrayDimensionCount) {
            super(null);
            Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
            this.arrayDimensionCount = arrayDimensionCount;
            if (!(this.arrayDimensionCount > 0)) {
                throw new IllegalArgumentException("ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.".toString());
            }
            StringBuilder $this$stringRepresentation_u24lambda_u240 = new StringBuilder();
            $this$stringRepresentation_u24lambda_u240.append("ArrayKClassValue(");
            int i = this.arrayDimensionCount;
            for (int i2 = 0; i2 < i; i2++) {
                $this$stringRepresentation_u24lambda_u240.append("kotlin/Array<");
            }
            $this$stringRepresentation_u24lambda_u240.append(this.className);
            int i3 = this.arrayDimensionCount;
            for (int i4 = 0; i4 < i3; i4++) {
                $this$stringRepresentation_u24lambda_u240.append(">");
            }
            $this$stringRepresentation_u24lambda_u240.append(")");
            this.stringRepresentation = $this$stringRepresentation_u24lambda_u240.toString();
        }

        public final int getArrayDimensionCount() {
            return this.arrayDimensionCount;
        }

        public final String getClassName() {
            return this.className;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public String toString() {
            return this.stringRepresentation;
        }
    }
}