package kntr.base.dd.impl.internal.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkntr/base/dd/impl/internal/common/Utils;", "", "<init>", "()V", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Utils {
    public static final Companion Companion = new Companion(null);
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.dd.impl.internal.common.Utils$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = Utils.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);

    /* compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086\b¢\u0006\u0002\u0010\fJ.\u0010\r\u001a\u0004\u0018\u00010\u000b\"\u0006\b\u0000\u0010\t\u0018\u00012\b\u0010\u000e\u001a\u0004\u0018\u0001H\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/base/dd/impl/internal/common/Utils$Companion;", "", "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "decodeFromString", "T", "string", "", "(Ljava/lang/String;)Ljava/lang/Object;", "encodeToString", "value", "(Ljava/lang/Object;Lkotlinx/serialization/json/Json;)Ljava/lang/String;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Json getJson() {
            return Utils.json;
        }

        public final /* synthetic */ <T> T decodeFromString(String string) {
            if (string == null) {
                return null;
            }
            try {
                Json json = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                SerializersModule serializersModule = json.getSerializersModule();
                Intrinsics.reifiedOperationMarker(6, "T?");
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                return (T) json.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), string);
            } catch (Exception e) {
                DDConst dDConst = DDConst.INSTANCE;
                String message = e.getMessage();
                if (message == null) {
                    message = "undefined";
                }
                DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
                return null;
            }
        }

        public static /* synthetic */ String encodeToString$default(Companion $this, Object value, Json json, int i, Object obj) {
            StringFormat stringFormat;
            if ((i & 2) != 0) {
                json = null;
            }
            if (value == null) {
                return null;
            }
            if (json == null) {
                try {
                    stringFormat = (Json) Json.Default;
                } catch (Exception e) {
                    DDConst dDConst = DDConst.INSTANCE;
                    String message = e.getMessage();
                    if (message == null) {
                        message = "undefined";
                    }
                    DDConst.logE$default(dDConst, "encodeToString error ," + message, null, 2, null);
                    return null;
                }
            } else {
                stringFormat = json;
            }
            StringFormat $this$encodeToString$iv = stringFormat;
            SerializersModule serializersModule = $this$encodeToString$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            return $this$encodeToString$iv.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), value);
        }

        public final /* synthetic */ <T> String encodeToString(T t, Json json) {
            StringFormat stringFormat;
            if (t == null) {
                return null;
            }
            if (json == null) {
                try {
                    stringFormat = (Json) Json.Default;
                } catch (Exception e) {
                    DDConst dDConst = DDConst.INSTANCE;
                    String message = e.getMessage();
                    if (message == null) {
                        message = "undefined";
                    }
                    DDConst.logE$default(dDConst, "encodeToString error ," + message, null, 2, null);
                    return null;
                }
            } else {
                stringFormat = json;
            }
            StringFormat $this$encodeToString$iv = stringFormat;
            SerializersModule serializersModule = $this$encodeToString$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            return $this$encodeToString$iv.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }
}