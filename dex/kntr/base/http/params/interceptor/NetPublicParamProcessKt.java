package kntr.base.http.params.interceptor;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.RequestBodyKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: NetPublicParamProcess.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"setBody", "", "Lio/ktor/client/request/HttpRequestBuilder;", "ody", "", "http-params-interceptor_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetPublicParamProcessKt {
    public static final void setBody(HttpRequestBuilder $this$setBody, Object ody) {
        Intrinsics.checkNotNullParameter($this$setBody, "<this>");
        if ($this$setBody.getBodyType() != null) {
            Object body = $this$setBody.getBody();
            TypeInfo bodyType = $this$setBody.getBodyType();
            Intrinsics.checkNotNull(bodyType);
            RequestBodyKt.setBody($this$setBody, body, bodyType);
            return;
        }
        Object body$iv = $this$setBody.getBody();
        KType kType = null;
        if (body$iv == null) {
            $this$setBody.setBody(NullBody.INSTANCE);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                kType = Reflection.typeOf(Object.class);
            } catch (Throwable th) {
            }
            $this$setBody.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
        } else if (body$iv instanceof OutgoingContent) {
            $this$setBody.setBody(body$iv);
            $this$setBody.setBodyType((TypeInfo) null);
        } else {
            $this$setBody.setBody(body$iv);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                kType = Reflection.typeOf(Object.class);
            } catch (Throwable th2) {
            }
            $this$setBody.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
        }
    }
}