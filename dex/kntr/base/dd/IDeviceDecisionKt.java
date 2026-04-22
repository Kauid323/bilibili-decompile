package kntr.base.dd;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IDeviceDecision.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a.\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u001a*\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u001a2\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u001a<\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u0001H\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b¢\u0006\u0002\u0010\r\u001aB\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\f0\n\"\u0006\b\u0000\u0010\f\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u0001H\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"getString", "", "Lkntr/base/dd/IDeviceDecision;", "key", "defaultValue", "context", "Lkntr/base/dd/IDeviceDecision$Context;", "getBool", "", "stringFlow", "Lkotlinx/coroutines/flow/Flow;", "get", "T", "(Lkntr/base/dd/IDeviceDecision;Ljava/lang/String;Ljava/lang/Object;Lkntr/base/dd/IDeviceDecision$Context;)Ljava/lang/Object;", "asFlow", "(Lkntr/base/dd/IDeviceDecision;Ljava/lang/String;Ljava/lang/Object;Lkntr/base/dd/IDeviceDecision$Context;)Lkotlinx/coroutines/flow/Flow;", "api_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IDeviceDecisionKt {
    public static /* synthetic */ String getString$default(IDeviceDecision iDeviceDecision, String str, String str2, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            context = null;
        }
        return getString(iDeviceDecision, str, str2, context);
    }

    public static final String getString(IDeviceDecision $this$getString, String key, String defaultValue, IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter($this$getString, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return (String) $this$getString.get(key, StringSerializer.INSTANCE, defaultValue, context);
    }

    public static /* synthetic */ boolean getBool$default(IDeviceDecision iDeviceDecision, String str, boolean z, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            context = null;
        }
        return getBool(iDeviceDecision, str, z, context);
    }

    public static final boolean getBool(IDeviceDecision $this$getBool, String key, boolean defaultValue, IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter($this$getBool, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object defaultValue$iv = $this$getBool.get(key, BooleanSerializer.INSTANCE, Boolean.valueOf(defaultValue), context);
        Boolean bool = (Boolean) defaultValue$iv;
        return bool != null ? bool.booleanValue() : defaultValue;
    }

    public static /* synthetic */ Flow stringFlow$default(IDeviceDecision iDeviceDecision, String str, String str2, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 4) != 0) {
            context = null;
        }
        return stringFlow(iDeviceDecision, str, str2, context);
    }

    public static final Flow<String> stringFlow(IDeviceDecision $this$stringFlow, String key, String defaultValue, IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter($this$stringFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$stringFlow.asFlow(key, StringSerializer.INSTANCE, defaultValue, context);
    }

    public static /* synthetic */ Object get$default(IDeviceDecision $this$get_u24default, String key, Object defaultValue, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            defaultValue = null;
        }
        if ((i & 4) != 0) {
            context = null;
        }
        Intrinsics.checkNotNullParameter($this$get_u24default, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return $this$get_u24default.get(key, SerializersKt.serializer((KType) null), defaultValue, context);
    }

    public static final /* synthetic */ <T> T get(IDeviceDecision $this$get, String key, T t, IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return (T) $this$get.get(key, SerializersKt.serializer((KType) null), t, context);
    }

    public static /* synthetic */ Flow asFlow$default(IDeviceDecision $this$asFlow_u24default, String key, Object defaultValue, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            defaultValue = null;
        }
        if ((i & 4) != 0) {
            context = null;
        }
        Intrinsics.checkNotNullParameter($this$asFlow_u24default, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return $this$asFlow_u24default.asFlow(key, SerializersKt.serializer((KType) null), defaultValue, context);
    }

    public static final /* synthetic */ <T> Flow<T> asFlow(IDeviceDecision $this$asFlow, String key, T t, IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter($this$asFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return $this$asFlow.asFlow(key, SerializersKt.serializer((KType) null), t, context);
    }
}