package kntr.base.primer;

import com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp;
import com.bapis.bilibili.app.coldstart.v1.KHttpJsonBizResp;
import com.google.protobuf.KAny;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.Body;
import kntr.base.net.GInterceptor;
import kntr.base.net.HttpStatus;
import kntr.base.net.PHASE;
import kntr.base.net.Request;
import kntr.base.net.Response;
import kntr.base.net.ResponseCallBack;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: PrimerInterceptor.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"providePrimer", "Lkntr/base/net/GInterceptor;", "primer", "Lkntr/base/primer/GPrimer;", "toResponse", "Lkntr/base/net/Response;", "request", "Lkntr/base/net/Request;", "status", "Lcom/bapis/bilibili/app/coldstart/v1/KColdStartBizResp$KHttpStatus;", "bodyHttpJsonBizResp", "", "primer_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PrimerInterceptorKt {
    public static final GInterceptor providePrimer(final GPrimer primer) {
        Intrinsics.checkNotNullParameter(primer, "primer");
        return new GInterceptor() { // from class: kntr.base.primer.PrimerInterceptorKt$providePrimer$interceptor$1
            @Override // kntr.base.net.GInterceptor
            public String getName() {
                return "primer";
            }

            @Override // kntr.base.net.GInterceptor
            public PHASE getPhase() {
                return PHASE.COMM;
            }

            @Override // kntr.base.net.GInterceptor
            public void intercept(GInterceptor.Chain chain, ResponseCallBack pre) {
                Response response;
                Intrinsics.checkNotNullParameter(chain, "chain");
                Intrinsics.checkNotNullParameter(pre, "pre");
                Request request = chain.getRequest();
                String host = chain.getRequest().getHost();
                String path = chain.getRequest().getPath();
                if (GPrimer.this.isHit(host, path)) {
                    KColdStartBizResp resp = (KColdStartBizResp) BuildersKt.runBlocking$default((CoroutineContext) null, new PrimerInterceptorKt$providePrimer$interceptor$1$intercept$resp$1(GPrimer.this, host, path, null), 1, (Object) null);
                    if (resp != null) {
                        BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                        KAny bizResp = resp.getBizResp();
                        Intrinsics.checkNotNull(bizResp);
                        byte[] bytes$iv = bizResp.getValue();
                        $this$decodeFromByteArray$iv.getSerializersModule();
                        byte[] bodyHttpJsonBizResp = StringsKt.encodeToByteArray(((KHttpJsonBizResp) $this$decodeFromByteArray$iv.decodeFromByteArray(KHttpJsonBizResp.Companion.serializer(), bytes$iv)).getData());
                        KColdStartBizResp.KHttpStatus status = resp.getStatus();
                        Intrinsics.checkNotNull(status, "null cannot be cast to non-null type com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp.KHttpStatus");
                        KColdStartBizResp.KHttpStatus status2 = status;
                        response = PrimerInterceptorKt.toResponse(request, status2, bodyHttpJsonBizResp);
                        pre.onResponse(response);
                        return;
                    }
                    chain.proceed(request, pre);
                    return;
                }
                chain.proceed(request, pre);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response toResponse(final Request request, final KColdStartBizResp.KHttpStatus status, final byte[] bodyHttpJsonBizResp) {
        return new Response() { // from class: kntr.base.primer.PrimerInterceptorKt$toResponse$1
            private final Map<String, List<String>> headers = MapsKt.mapOf(TuplesKt.to("Content-Type", CollectionsKt.listOf("application/json; charset=utf-8")));

            @Override // kntr.base.net.Response
            public String getHost() {
                return Request.this.getHost();
            }

            @Override // kntr.base.net.Response
            public String getPath() {
                return Request.this.getPath();
            }

            @Override // kntr.base.net.Response
            public Request getRequest() {
                return Request.this;
            }

            @Override // kntr.base.net.Response
            public HttpStatus getHttpStatus() {
                return new HttpStatus(status.getValue().getCode(), status.getValue().getMessage());
            }

            @Override // kntr.base.net.Response
            public Body getBody() {
                final byte[] bArr = bodyHttpJsonBizResp;
                return new Body() { // from class: kntr.base.primer.PrimerInterceptorKt$toResponse$1$body$1
                    @Override // kntr.base.net.Body
                    public String getContentType() {
                        return "application/json";
                    }

                    @Override // kntr.base.net.Body
                    public long getContentLength() {
                        return bArr.length;
                    }

                    @Override // kntr.base.net.Body
                    public Source content() {
                        Source buffer = new Buffer();
                        Sink.-CC.write$default((Sink) buffer, bArr, 0, 0, 6, (Object) null);
                        return buffer;
                    }
                };
            }

            @Override // kntr.base.net.Response
            public String header(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                List<String> list = this.headers.get(name);
                if (list != null) {
                    return (String) CollectionsKt.firstOrNull(list);
                }
                return null;
            }

            @Override // kntr.base.net.Response
            public Map<String, List<String>> headers() {
                return this.headers;
            }

            @Override // kntr.base.net.Response
            public Object source() {
                return this;
            }
        };
    }
}