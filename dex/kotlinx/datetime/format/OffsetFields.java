package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.internal.format.Accessor;
import kotlinx.datetime.internal.format.FieldSign;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/OffsetFields;", "", "()V", "minutesOfHour", "Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "getMinutesOfHour", "()Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "secondsOfMinute", "getSecondsOfMinute", "sign", "kotlinx/datetime/format/OffsetFields$sign$1", "Lkotlinx/datetime/format/OffsetFields$sign$1;", "totalHoursAbs", "getTotalHoursAbs", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OffsetFields {
    public static final OffsetFields INSTANCE = new OffsetFields();
    private static final OffsetFields$sign$1 sign = new FieldSign<UtcOffsetFieldContainer>() { // from class: kotlinx.datetime.format.OffsetFields$sign$1
        private final PropertyAccessor<UtcOffsetFieldContainer, Boolean> isNegative = new PropertyAccessor<>(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$sign$1$isNegative$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return ((UtcOffsetFieldContainer) receiver0).isNegative();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object receiver0, Object value) {
                ((UtcOffsetFieldContainer) receiver0).setNegative((Boolean) value);
            }
        });

        @Override // kotlinx.datetime.internal.format.FieldSign
        public Accessor<UtcOffsetFieldContainer, Boolean> isNegative() {
            return this.isNegative;
        }

        @Override // kotlinx.datetime.internal.format.FieldSign
        public boolean isZero(UtcOffsetFieldContainer obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Integer totalHoursAbs2 = obj.getTotalHoursAbs();
            if ((totalHoursAbs2 != null ? totalHoursAbs2.intValue() : 0) == 0) {
                Integer minutesOfHour2 = obj.getMinutesOfHour();
                if ((minutesOfHour2 != null ? minutesOfHour2.intValue() : 0) == 0) {
                    Integer secondsOfMinute2 = obj.getSecondsOfMinute();
                    return (secondsOfMinute2 != null ? secondsOfMinute2.intValue() : 0) == 0;
                }
                return false;
            }
            return false;
        }
    };
    private static final UnsignedFieldSpec<UtcOffsetFieldContainer> totalHoursAbs = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$totalHoursAbs$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object receiver0) {
            return ((UtcOffsetFieldContainer) receiver0).getTotalHoursAbs();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object receiver0, Object value) {
            ((UtcOffsetFieldContainer) receiver0).setTotalHoursAbs((Integer) value);
        }
    }), 0, 18, null, 0, sign, 8, null);
    private static final UnsignedFieldSpec<UtcOffsetFieldContainer> minutesOfHour = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$minutesOfHour$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object receiver0) {
            return ((UtcOffsetFieldContainer) receiver0).getMinutesOfHour();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object receiver0, Object value) {
            ((UtcOffsetFieldContainer) receiver0).setMinutesOfHour((Integer) value);
        }
    }), 0, 59, null, 0, sign, 8, null);
    private static final UnsignedFieldSpec<UtcOffsetFieldContainer> secondsOfMinute = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$secondsOfMinute$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object receiver0) {
            return ((UtcOffsetFieldContainer) receiver0).getSecondsOfMinute();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object receiver0, Object value) {
            ((UtcOffsetFieldContainer) receiver0).setSecondsOfMinute((Integer) value);
        }
    }), 0, 59, null, 0, sign, 8, null);

    private OffsetFields() {
    }

    public final UnsignedFieldSpec<UtcOffsetFieldContainer> getTotalHoursAbs() {
        return totalHoursAbs;
    }

    public final UnsignedFieldSpec<UtcOffsetFieldContainer> getMinutesOfHour() {
        return minutesOfHour;
    }

    public final UnsignedFieldSpec<UtcOffsetFieldContainer> getSecondsOfMinute() {
        return secondsOfMinute;
    }
}