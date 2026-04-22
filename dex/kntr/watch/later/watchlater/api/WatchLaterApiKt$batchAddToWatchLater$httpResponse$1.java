package kntr.watch.later.watchlater.api;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpUrlEncodedKt;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.WatchLaterApiKt$batchAddToWatchLater$httpResponse$1", f = "WatchLaterApi.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {212}, m = "invokeSuspend", n = {"$this$post$iv", "url$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
public final class WatchLaterApiKt$batchAddToWatchLater$httpResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ String $resources;
    final /* synthetic */ String $spmid;
    final /* synthetic */ Url $url;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterApiKt$batchAddToWatchLater$httpResponse$1(Url url, String str, String str2, Continuation<? super WatchLaterApiKt$batchAddToWatchLater$httpResponse$1> continuation) {
        super(2, continuation);
        this.$url = url;
        this.$resources = str;
        this.$spmid = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterApiKt$batchAddToWatchLater$httpResponse$1(this.$url, this.$resources, this.$spmid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HttpClient $this$post$iv;
        KType kType;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$post$iv = WatchLaterApiKt.getClient();
                Url url$iv = this.$url;
                String str = this.$resources;
                String str2 = this.$spmid;
                HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url$iv);
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                Parameters.Companion companion = Parameters.Companion;
                ParametersBuilder $this$invokeSuspend_u24lambda_u240_u240 = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                if (str == null) {
                    str = "";
                }
                $this$invokeSuspend_u24lambda_u240_u240.append("resources", str);
                $this$invokeSuspend_u24lambda_u240_u240.append("toview_version", "v2");
                $this$invokeSuspend_u24lambda_u240_u240.append("spmid", str2);
                Object body$iv = HttpUrlEncodedKt.formUrlEncode($this$invokeSuspend_u24lambda_u240_u240.build());
                if (body$iv == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    try {
                        kType = Reflection.typeOf(String.class);
                    } catch (Throwable th) {
                        kType = null;
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                } else if (body$iv instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(body$iv);
                    httpRequestBuilder.setBodyType((TypeInfo) null);
                } else {
                    KType kType2 = null;
                    httpRequestBuilder.setBody(body$iv);
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    try {
                        kType2 = Reflection.typeOf(String.class);
                    } catch (Throwable th2) {
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType2));
                }
                httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                this.L$1 = SpillingKt.nullOutSpilledVariable(url$iv);
                this.L$2 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                this.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                this.L$4 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                this.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                this.I$0 = 0;
                this.I$1 = 0;
                this.I$2 = 0;
                this.I$3 = 0;
                this.label = 1;
                Object execute = new HttpStatement(httpRequestBuilder, $this$post$iv).execute((Continuation) this);
                return execute == coroutine_suspended ? coroutine_suspended : execute;
            case 1:
                int i = this.I$3;
                int i2 = this.I$2;
                int i3 = this.I$1;
                int i4 = this.I$0;
                HttpClient httpClient = (HttpClient) this.L$5;
                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) this.L$4;
                HttpClient httpClient2 = (HttpClient) this.L$3;
                HttpClient httpClient3 = (HttpClient) this.L$2;
                Url url = (Url) this.L$1;
                HttpClient httpClient4 = (HttpClient) this.L$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}