package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumSerializer;

/* compiled from: MonthSerializers.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"createEnumSerializer", "Lkotlinx/serialization/KSerializer;", "E", "", "serialName", "", "values", "", "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MonthSerializersKt {
    public static final <E extends Enum<E>> KSerializer<E> createEnumSerializer(String serialName, E[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        return new EnumSerializer(serialName, values);
    }
}