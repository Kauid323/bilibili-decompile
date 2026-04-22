package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.ad.domain.adextra.handler.DefaultHandler;
import kntr.app.ad.protocol.adextra.IAdExtraQuery;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* compiled from: AbsHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/AbsHandler;", "Q", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "<init>", "()V", "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "(Lkntr/app/ad/protocol/adextra/IAdExtraQuery;)Ljava/lang/String;", "buildExtra", "Lkotlinx/serialization/json/JsonObject;", "(Lkntr/app/ad/protocol/adextra/IAdExtraQuery;)Lkotlinx/serialization/json/JsonObject;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AbsHandler<Q extends IAdExtraQuery> implements IAdExtraQueryHandler<Q> {
    public abstract JsonObject buildExtra(Q q);

    @Override // kntr.app.ad.domain.adextra.handler.IAdExtraQueryHandler
    public final String handle(Q q) {
        JsonObject $this$toJsonObject_u24lambda_u240$iv;
        Object $this$encodeToString_u24lambda_u240$iv;
        Intrinsics.checkNotNullParameter(q, "query");
        Object $this$toJsonObject$iv = new DefaultHandler.Response();
        try {
            Result.Companion companion = Result.Companion;
            Json $this$encodeToJsonElement$iv$iv = JsonExtKt.getAdJson();
            $this$encodeToJsonElement$iv$iv.getSerializersModule();
            $this$toJsonObject_u24lambda_u240$iv = Result.constructor-impl(JsonElementKt.getJsonObject($this$encodeToJsonElement$iv$iv.encodeToJsonElement(DefaultHandler.Response.Companion.serializer(), $this$toJsonObject$iv)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            $this$toJsonObject_u24lambda_u240$iv = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it$iv = Result.exceptionOrNull-impl($this$toJsonObject_u24lambda_u240$iv);
        if (it$iv != null) {
            Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
        }
        JsonObject jsonObject = new JsonObject(MapsKt.emptyMap());
        if (Result.isFailure-impl($this$toJsonObject_u24lambda_u240$iv)) {
            $this$toJsonObject_u24lambda_u240$iv = jsonObject;
        }
        Object $this$encodeToString$iv = MapsKt.plus((JsonObject) $this$toJsonObject_u24lambda_u240$iv, buildExtra(q));
        try {
            Result.Companion companion3 = Result.Companion;
            StringFormat $this$encodeToString$iv$iv = JsonExtKt.getAdJson();
            $this$encodeToString$iv$iv.getSerializersModule();
            $this$encodeToString_u24lambda_u240$iv = Result.constructor-impl($this$encodeToString$iv$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonElement.Companion.serializer()), $this$encodeToString$iv));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            $this$encodeToString_u24lambda_u240$iv = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Throwable it$iv2 = Result.exceptionOrNull-impl($this$encodeToString_u24lambda_u240$iv);
        if (it$iv2 != null) {
            Logger_androidKt.getAdLog().e("JsonExt", it$iv2.toString());
        }
        if (Result.isFailure-impl($this$encodeToString_u24lambda_u240$iv)) {
            $this$encodeToString_u24lambda_u240$iv = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return (String) $this$encodeToString_u24lambda_u240$iv;
    }
}