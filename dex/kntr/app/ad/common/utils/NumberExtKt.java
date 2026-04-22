package kntr.app.ad.common.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: NumberExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u0004\u0018\u0001H\u0001H\u0086\b¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"orZero", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/Number;)Ljava/lang/Number;", "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NumberExtKt {
    public static final /* synthetic */ <T extends Number> T orZero(T t) {
        Byte b;
        if (t != null) {
            return t;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Number.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            Double valueOf = Double.valueOf(0.0d);
            Intrinsics.reifiedOperationMarker(1, "T");
            b = valueOf;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            Float valueOf2 = Float.valueOf(0.0f);
            Intrinsics.reifiedOperationMarker(1, "T");
            b = valueOf2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            b = (Number) 0L;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            b = (Number) 0;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            b = (T) ((Number) (char) 0);
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            Intrinsics.reifiedOperationMarker(1, "T");
            b = (Number) (short) 0;
        } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            throw new RuntimeException("not primitive number type");
        } else {
            Intrinsics.reifiedOperationMarker(1, "T");
            b = (Number) (byte) 0;
        }
        T t2 = b;
        return b;
    }
}