package tv.danmaku.bili.primer;

import com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp;
import com.bapis.bilibili.app.coldstart.v1.KHttpJsonBizResp;
import com.google.protobuf.KAny;
import java.io.ByteArrayInputStream;
import kntr.base.primer.GPrimer;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.protobuf.ProtoBuf;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: PrimerInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/primer/PrimerInterceptor;", "Lokhttp3/Interceptor;", "primer", "Lkntr/base/primer/GPrimer;", "<init>", "(Lkntr/base/primer/GPrimer;)V", "getPrimer", "()Lkntr/base/primer/GPrimer;", "setPrimer", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PrimerInterceptor implements Interceptor {
    private GPrimer primer;

    public PrimerInterceptor(GPrimer primer) {
        Intrinsics.checkNotNullParameter(primer, "primer");
        this.primer = primer;
    }

    public final GPrimer getPrimer() {
        return this.primer;
    }

    public final void setPrimer(GPrimer gPrimer) {
        Intrinsics.checkNotNullParameter(gPrimer, "<set-?>");
        this.primer = gPrimer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x00d4, code lost:
        if (r3 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        Response proceed;
        Intrinsics.checkNotNullParameter(chain, "chain");
        String host = chain.request().url().host();
        String path = chain.request().url().encodedPath();
        GPrimer gPrimer = this.primer;
        Intrinsics.checkNotNull(host);
        Intrinsics.checkNotNull(path);
        if (gPrimer.isHit(host, path)) {
            KColdStartBizResp resp = (KColdStartBizResp) BuildersKt.runBlocking$default((CoroutineContext) null, new PrimerInterceptor$intercept$resp$1(this, host, path, null), 1, (Object) null);
            if (resp != null) {
                BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                KAny bizResp = resp.getBizResp();
                Intrinsics.checkNotNull(bizResp);
                byte[] bytes$iv = bizResp.getValue();
                SerializersModule serializersModule = $this$decodeFromByteArray$iv.getSerializersModule();
                KType typeOf = Reflection.typeOf(KHttpJsonBizResp.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                byte[] bodyHttpJsonBizResp = ((KHttpJsonBizResp) $this$decodeFromByteArray$iv.decodeFromByteArray(SerializersKt.serializer(serializersModule, typeOf), bytes$iv)).getData().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bodyHttpJsonBizResp, "getBytes(...)");
                KColdStartBizResp.KHttpStatus status = resp.getStatus();
                Intrinsics.checkNotNull(status, "null cannot be cast to non-null type com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp.KHttpStatus");
                KColdStartBizResp.KHttpStatus status2 = status;
                proceed = new Response.Builder().request(chain.request()).code(status2.getValue().getCode()).protocol(Protocol.HTTP_1_1).message(status2.getValue().getMessage()).body(ResponseBody.create(MediaType.get("application/json"), bodyHttpJsonBizResp.length, Okio.buffer(Okio.source(new ByteArrayInputStream(bodyHttpJsonBizResp))))).build();
            }
            proceed = chain.proceed(chain.request());
            Intrinsics.checkNotNull(proceed);
            return proceed;
        }
        Response proceed2 = chain.proceed(chain.request());
        Intrinsics.checkNotNull(proceed2);
        return proceed2;
    }
}