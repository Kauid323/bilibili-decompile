package kntr.watch.later.watchlater.api;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.watch.later.watchlater.data.WatchLaterAddToast;
import kntr.watch.later.watchlater.data.WatchLaterResponse;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WatchLaterApi.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a6\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a2\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u001b\u001a&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, d2 = {"HOST", "", "client", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getWatchLater", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/watch/later/watchlater/data/WatchLaterResponse;", "startKey", "asc", "", "sortField", "", "splitKey", "(Ljava/lang/String;ZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanWatchLater", "cleanType", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWatchLater", "resources", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToWatchLaterV2", "Lkntr/watch/later/watchlater/data/WatchLaterAddToast;", WatchLaterReporterKt.KEY_AVID, "from", "spmid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchAddToWatchLater", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterApiKt {
    private static final String HOST = "api.bilibili.com";

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClient getClient() {
        return KtorClientKt.getKtorHttpClient();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getWatchLater(String startKey, boolean asc, int sortField, String splitKey, Continuation<? super KApiResponse<WatchLaterResponse>> continuation) {
        WatchLaterApiKt$getWatchLater$1 watchLaterApiKt$getWatchLater$1;
        WatchLaterApiKt$getWatchLater$1 watchLaterApiKt$getWatchLater$12;
        String startKey2;
        int sortField2;
        Url url;
        Object obj;
        boolean asc2;
        String splitKey2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof WatchLaterApiKt$getWatchLater$1) {
            watchLaterApiKt$getWatchLater$1 = (WatchLaterApiKt$getWatchLater$1) continuation;
            if ((watchLaterApiKt$getWatchLater$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterApiKt$getWatchLater$1.label -= Integer.MIN_VALUE;
                watchLaterApiKt$getWatchLater$12 = watchLaterApiKt$getWatchLater$1;
                Object $result = watchLaterApiKt$getWatchLater$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (watchLaterApiKt$getWatchLater$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$getWatchLater_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$getWatchLater_u24lambda_u240, "/x/v2/history/toview/v2/list");
                        ParametersBuilder $this$getWatchLater_u24lambda_u240_u240 = $this$getWatchLater_u24lambda_u240.getParameters();
                        startKey2 = startKey;
                        $this$getWatchLater_u24lambda_u240_u240.append("start_key", startKey2);
                        $this$getWatchLater_u24lambda_u240_u240.append("asc", String.valueOf(asc));
                        $this$getWatchLater_u24lambda_u240_u240.append("sort_field", String.valueOf(sortField));
                        $this$getWatchLater_u24lambda_u240_u240.append("split_key", splitKey.toString());
                        Url url2 = $this$getWatchLater_u24lambda_u240.build();
                        watchLaterApiKt$getWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(startKey);
                        watchLaterApiKt$getWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(splitKey);
                        watchLaterApiKt$getWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        watchLaterApiKt$getWatchLater$12.Z$0 = asc;
                        sortField2 = sortField;
                        watchLaterApiKt$getWatchLater$12.I$0 = sortField2;
                        watchLaterApiKt$getWatchLater$12.label = 1;
                        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new WatchLaterApiKt$getWatchLater$httpResponse$1(url2, null), watchLaterApiKt$getWatchLater$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        obj = withContext;
                        asc2 = asc;
                        splitKey2 = splitKey;
                        HttpResponse httpResponse = (HttpResponse) obj;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            try {
                                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(WatchLaterResponse.class)));
                            } catch (Throwable th) {
                                kType = null;
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                watchLaterApiKt$getWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(startKey2);
                                watchLaterApiKt$getWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(splitKey2);
                                watchLaterApiKt$getWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                                watchLaterApiKt$getWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                watchLaterApiKt$getWatchLater$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                watchLaterApiKt$getWatchLater$12.Z$0 = asc2;
                                watchLaterApiKt$getWatchLater$12.I$0 = sortField2;
                                watchLaterApiKt$getWatchLater$12.I$1 = 0;
                                watchLaterApiKt$getWatchLater$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, watchLaterApiKt$getWatchLater$12);
                                if (bodyNullable == coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th2) {
                        }
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                        watchLaterApiKt$getWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(startKey2);
                        watchLaterApiKt$getWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(splitKey2);
                        watchLaterApiKt$getWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$getWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$getWatchLater$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$getWatchLater$12.Z$0 = asc2;
                        watchLaterApiKt$getWatchLater$12.I$0 = sortField2;
                        watchLaterApiKt$getWatchLater$12.I$1 = 0;
                        watchLaterApiKt$getWatchLater$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo2, watchLaterApiKt$getWatchLater$12);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse response = (KApiResponse) bodyNullable;
                            return response;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.watch.later.watchlater.data.WatchLaterResponse>");
                    case 1:
                        int $i$f$body = watchLaterApiKt$getWatchLater$12.I$0;
                        asc2 = watchLaterApiKt$getWatchLater$12.Z$0;
                        url = (Url) watchLaterApiKt$getWatchLater$12.L$2;
                        splitKey2 = (String) watchLaterApiKt$getWatchLater$12.L$1;
                        ResultKt.throwOnFailure($result);
                        startKey2 = (String) watchLaterApiKt$getWatchLater$12.L$0;
                        sortField2 = $i$f$body;
                        obj = $result;
                        HttpResponse httpResponse2 = (HttpResponse) obj;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(WatchLaterResponse.class)));
                        TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                        watchLaterApiKt$getWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(startKey2);
                        watchLaterApiKt$getWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(splitKey2);
                        watchLaterApiKt$getWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$getWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$getWatchLater$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$getWatchLater$12.Z$0 = asc2;
                        watchLaterApiKt$getWatchLater$12.I$0 = sortField2;
                        watchLaterApiKt$getWatchLater$12.I$1 = 0;
                        watchLaterApiKt$getWatchLater$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo22, watchLaterApiKt$getWatchLater$12);
                        if (bodyNullable == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = watchLaterApiKt$getWatchLater$12.I$1;
                        int i2 = watchLaterApiKt$getWatchLater$12.I$0;
                        boolean z = watchLaterApiKt$getWatchLater$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) watchLaterApiKt$getWatchLater$12.L$4;
                        HttpResponse httpResponse4 = (HttpResponse) watchLaterApiKt$getWatchLater$12.L$3;
                        Url url3 = (Url) watchLaterApiKt$getWatchLater$12.L$2;
                        String str = (String) watchLaterApiKt$getWatchLater$12.L$1;
                        String str2 = (String) watchLaterApiKt$getWatchLater$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        watchLaterApiKt$getWatchLater$1 = new WatchLaterApiKt$getWatchLater$1(continuation);
        watchLaterApiKt$getWatchLater$12 = watchLaterApiKt$getWatchLater$1;
        Object $result2 = watchLaterApiKt$getWatchLater$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterApiKt$getWatchLater$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object cleanWatchLater(int cleanType, Continuation<? super Boolean> continuation) {
        WatchLaterApiKt$cleanWatchLater$1 watchLaterApiKt$cleanWatchLater$1;
        Object withContext;
        Url url;
        int cleanType2;
        Object bodyNullable;
        if (continuation instanceof WatchLaterApiKt$cleanWatchLater$1) {
            watchLaterApiKt$cleanWatchLater$1 = (WatchLaterApiKt$cleanWatchLater$1) continuation;
            if ((watchLaterApiKt$cleanWatchLater$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterApiKt$cleanWatchLater$1.label -= Integer.MIN_VALUE;
                Object $result = watchLaterApiKt$cleanWatchLater$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                KType kType = null;
                switch (watchLaterApiKt$cleanWatchLater$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$cleanWatchLater_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$cleanWatchLater_u24lambda_u240, "/x/v2/history/toview/clear");
                        Url url2 = $this$cleanWatchLater_u24lambda_u240.build();
                        watchLaterApiKt$cleanWatchLater$1.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        watchLaterApiKt$cleanWatchLater$1.I$0 = cleanType;
                        watchLaterApiKt$cleanWatchLater$1.label = 1;
                        withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new WatchLaterApiKt$cleanWatchLater$httpResponse$1(url2, cleanType, null), watchLaterApiKt$cleanWatchLater$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        cleanType2 = cleanType;
                        HttpResponse httpResponse = (HttpResponse) withContext;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Response.class);
                        try {
                            kType = Reflection.typeOf(Response.class);
                        } catch (Throwable th) {
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        watchLaterApiKt$cleanWatchLater$1.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$cleanWatchLater$1.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$cleanWatchLater$1.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$cleanWatchLater$1.I$0 = cleanType2;
                        watchLaterApiKt$cleanWatchLater$1.I$1 = 0;
                        watchLaterApiKt$cleanWatchLater$1.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, watchLaterApiKt$cleanWatchLater$1);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            Response response = (Response) bodyNullable;
                            return Boxing.boxBoolean(response.getCode() == 0);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kntr.watch.later.watchlater.api.Response");
                    case 1:
                        int cleanType3 = watchLaterApiKt$cleanWatchLater$1.I$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        url = (Url) watchLaterApiKt$cleanWatchLater$1.L$0;
                        cleanType2 = cleanType3;
                        HttpResponse httpResponse2 = (HttpResponse) withContext;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Response.class);
                        kType = Reflection.typeOf(Response.class);
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        watchLaterApiKt$cleanWatchLater$1.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$cleanWatchLater$1.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$cleanWatchLater$1.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$cleanWatchLater$1.I$0 = cleanType2;
                        watchLaterApiKt$cleanWatchLater$1.I$1 = 0;
                        watchLaterApiKt$cleanWatchLater$1.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, watchLaterApiKt$cleanWatchLater$1);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = watchLaterApiKt$cleanWatchLater$1.I$1;
                        int i2 = watchLaterApiKt$cleanWatchLater$1.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) watchLaterApiKt$cleanWatchLater$1.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) watchLaterApiKt$cleanWatchLater$1.L$1;
                        Url url3 = (Url) watchLaterApiKt$cleanWatchLater$1.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        watchLaterApiKt$cleanWatchLater$1 = new WatchLaterApiKt$cleanWatchLater$1(continuation);
        Object $result2 = watchLaterApiKt$cleanWatchLater$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        KType kType2 = null;
        switch (watchLaterApiKt$cleanWatchLater$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deleteWatchLater(String resources, Continuation<? super Boolean> continuation) {
        WatchLaterApiKt$deleteWatchLater$1 watchLaterApiKt$deleteWatchLater$1;
        WatchLaterApiKt$deleteWatchLater$1 watchLaterApiKt$deleteWatchLater$12;
        Url url;
        Object obj;
        String resources2;
        Object bodyNullable;
        if (continuation instanceof WatchLaterApiKt$deleteWatchLater$1) {
            watchLaterApiKt$deleteWatchLater$1 = (WatchLaterApiKt$deleteWatchLater$1) continuation;
            if ((watchLaterApiKt$deleteWatchLater$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterApiKt$deleteWatchLater$1.label -= Integer.MIN_VALUE;
                watchLaterApiKt$deleteWatchLater$12 = watchLaterApiKt$deleteWatchLater$1;
                Object $result = watchLaterApiKt$deleteWatchLater$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                KType kType = null;
                switch (watchLaterApiKt$deleteWatchLater$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$deleteWatchLater_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$deleteWatchLater_u24lambda_u240, "/x/v2/history/toview/v2/dels");
                        Url url2 = $this$deleteWatchLater_u24lambda_u240.build();
                        watchLaterApiKt$deleteWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(resources);
                        watchLaterApiKt$deleteWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        watchLaterApiKt$deleteWatchLater$12.label = 1;
                        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new WatchLaterApiKt$deleteWatchLater$httpResponse$1(url2, resources, null), watchLaterApiKt$deleteWatchLater$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        obj = withContext;
                        resources2 = resources;
                        HttpResponse httpResponse = (HttpResponse) obj;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Response.class);
                        try {
                            kType = Reflection.typeOf(Response.class);
                        } catch (Throwable th) {
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        watchLaterApiKt$deleteWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        watchLaterApiKt$deleteWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$deleteWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$deleteWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$deleteWatchLater$12.I$0 = 0;
                        watchLaterApiKt$deleteWatchLater$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, watchLaterApiKt$deleteWatchLater$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            Response response = (Response) bodyNullable;
                            return Boxing.boxBoolean(response.getCode() == 1);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kntr.watch.later.watchlater.api.Response");
                    case 1:
                        resources2 = (String) watchLaterApiKt$deleteWatchLater$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) watchLaterApiKt$deleteWatchLater$12.L$1;
                        obj = $result;
                        HttpResponse httpResponse2 = (HttpResponse) obj;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Response.class);
                        kType = Reflection.typeOf(Response.class);
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        watchLaterApiKt$deleteWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        watchLaterApiKt$deleteWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$deleteWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$deleteWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$deleteWatchLater$12.I$0 = 0;
                        watchLaterApiKt$deleteWatchLater$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, watchLaterApiKt$deleteWatchLater$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = watchLaterApiKt$deleteWatchLater$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) watchLaterApiKt$deleteWatchLater$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) watchLaterApiKt$deleteWatchLater$12.L$2;
                        Url url3 = (Url) watchLaterApiKt$deleteWatchLater$12.L$1;
                        String str = (String) watchLaterApiKt$deleteWatchLater$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        watchLaterApiKt$deleteWatchLater$1 = new WatchLaterApiKt$deleteWatchLater$1(continuation);
        watchLaterApiKt$deleteWatchLater$12 = watchLaterApiKt$deleteWatchLater$1;
        Object $result2 = watchLaterApiKt$deleteWatchLater$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        KType kType2 = null;
        switch (watchLaterApiKt$deleteWatchLater$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0134 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object addToWatchLaterV2(String avid, String from, String spmid, Continuation<? super KApiResponse<WatchLaterAddToast>> continuation) {
        WatchLaterApiKt$addToWatchLaterV2$1 watchLaterApiKt$addToWatchLaterV2$1;
        WatchLaterApiKt$addToWatchLaterV2$1 watchLaterApiKt$addToWatchLaterV2$12;
        Url url;
        Object withContext;
        String avid2;
        String from2;
        String spmid2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof WatchLaterApiKt$addToWatchLaterV2$1) {
            watchLaterApiKt$addToWatchLaterV2$1 = (WatchLaterApiKt$addToWatchLaterV2$1) continuation;
            if ((watchLaterApiKt$addToWatchLaterV2$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterApiKt$addToWatchLaterV2$1.label -= Integer.MIN_VALUE;
                watchLaterApiKt$addToWatchLaterV2$12 = watchLaterApiKt$addToWatchLaterV2$1;
                Object $result = watchLaterApiKt$addToWatchLaterV2$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (watchLaterApiKt$addToWatchLaterV2$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$addToWatchLaterV2_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$addToWatchLaterV2_u24lambda_u240, "/x/v2/history/toview/add");
                        url = $this$addToWatchLaterV2_u24lambda_u240.build();
                        watchLaterApiKt$addToWatchLaterV2$12.L$0 = SpillingKt.nullOutSpilledVariable(avid);
                        watchLaterApiKt$addToWatchLaterV2$12.L$1 = SpillingKt.nullOutSpilledVariable(from);
                        watchLaterApiKt$addToWatchLaterV2$12.L$2 = SpillingKt.nullOutSpilledVariable(spmid);
                        watchLaterApiKt$addToWatchLaterV2$12.L$3 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$addToWatchLaterV2$12.label = 1;
                        withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new WatchLaterApiKt$addToWatchLaterV2$httpResponse$1(url, avid, from, spmid, null), watchLaterApiKt$addToWatchLaterV2$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        avid2 = avid;
                        from2 = from;
                        spmid2 = spmid;
                        HttpResponse httpResponse = (HttpResponse) withContext;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            try {
                                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(WatchLaterAddToast.class)));
                            } catch (Throwable th) {
                                kType = null;
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                watchLaterApiKt$addToWatchLaterV2$12.L$0 = SpillingKt.nullOutSpilledVariable(avid2);
                                watchLaterApiKt$addToWatchLaterV2$12.L$1 = SpillingKt.nullOutSpilledVariable(from2);
                                watchLaterApiKt$addToWatchLaterV2$12.L$2 = SpillingKt.nullOutSpilledVariable(spmid2);
                                watchLaterApiKt$addToWatchLaterV2$12.L$3 = SpillingKt.nullOutSpilledVariable(url);
                                watchLaterApiKt$addToWatchLaterV2$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                watchLaterApiKt$addToWatchLaterV2$12.L$5 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                watchLaterApiKt$addToWatchLaterV2$12.I$0 = 0;
                                watchLaterApiKt$addToWatchLaterV2$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, watchLaterApiKt$addToWatchLaterV2$12);
                                if (bodyNullable == coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th2) {
                        }
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                        watchLaterApiKt$addToWatchLaterV2$12.L$0 = SpillingKt.nullOutSpilledVariable(avid2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$1 = SpillingKt.nullOutSpilledVariable(from2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$2 = SpillingKt.nullOutSpilledVariable(spmid2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$3 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$addToWatchLaterV2$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$addToWatchLaterV2$12.L$5 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$addToWatchLaterV2$12.I$0 = 0;
                        watchLaterApiKt$addToWatchLaterV2$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo2, watchLaterApiKt$addToWatchLaterV2$12);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse response = (KApiResponse) bodyNullable;
                            return response;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.watch.later.watchlater.data.WatchLaterAddToast>");
                    case 1:
                        spmid2 = (String) watchLaterApiKt$addToWatchLaterV2$12.L$2;
                        from2 = (String) watchLaterApiKt$addToWatchLaterV2$12.L$1;
                        avid2 = (String) watchLaterApiKt$addToWatchLaterV2$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) watchLaterApiKt$addToWatchLaterV2$12.L$3;
                        withContext = $result;
                        HttpResponse httpResponse2 = (HttpResponse) withContext;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(WatchLaterAddToast.class)));
                        TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                        watchLaterApiKt$addToWatchLaterV2$12.L$0 = SpillingKt.nullOutSpilledVariable(avid2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$1 = SpillingKt.nullOutSpilledVariable(from2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$2 = SpillingKt.nullOutSpilledVariable(spmid2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$3 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$addToWatchLaterV2$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$addToWatchLaterV2$12.L$5 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$addToWatchLaterV2$12.I$0 = 0;
                        watchLaterApiKt$addToWatchLaterV2$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo22, watchLaterApiKt$addToWatchLaterV2$12);
                        if (bodyNullable == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = watchLaterApiKt$addToWatchLaterV2$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) watchLaterApiKt$addToWatchLaterV2$12.L$5;
                        HttpResponse httpResponse4 = (HttpResponse) watchLaterApiKt$addToWatchLaterV2$12.L$4;
                        Url url2 = (Url) watchLaterApiKt$addToWatchLaterV2$12.L$3;
                        String str = (String) watchLaterApiKt$addToWatchLaterV2$12.L$2;
                        String str2 = (String) watchLaterApiKt$addToWatchLaterV2$12.L$1;
                        String str3 = (String) watchLaterApiKt$addToWatchLaterV2$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        watchLaterApiKt$addToWatchLaterV2$1 = new WatchLaterApiKt$addToWatchLaterV2$1(continuation);
        watchLaterApiKt$addToWatchLaterV2$12 = watchLaterApiKt$addToWatchLaterV2$1;
        Object $result2 = watchLaterApiKt$addToWatchLaterV2$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterApiKt$addToWatchLaterV2$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0117 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object batchAddToWatchLater(String resources, String spmid, Continuation<? super KApiResponse<WatchLaterAddToast>> continuation) {
        WatchLaterApiKt$batchAddToWatchLater$1 watchLaterApiKt$batchAddToWatchLater$1;
        WatchLaterApiKt$batchAddToWatchLater$1 watchLaterApiKt$batchAddToWatchLater$12;
        String resources2;
        Url url;
        Object obj;
        String spmid2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof WatchLaterApiKt$batchAddToWatchLater$1) {
            watchLaterApiKt$batchAddToWatchLater$1 = (WatchLaterApiKt$batchAddToWatchLater$1) continuation;
            if ((watchLaterApiKt$batchAddToWatchLater$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterApiKt$batchAddToWatchLater$1.label -= Integer.MIN_VALUE;
                watchLaterApiKt$batchAddToWatchLater$12 = watchLaterApiKt$batchAddToWatchLater$1;
                Object $result = watchLaterApiKt$batchAddToWatchLater$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (watchLaterApiKt$batchAddToWatchLater$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$batchAddToWatchLater_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$batchAddToWatchLater_u24lambda_u240, "/x/v3/fav/toview/adds");
                        Url url2 = $this$batchAddToWatchLater_u24lambda_u240.build();
                        watchLaterApiKt$batchAddToWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(resources);
                        watchLaterApiKt$batchAddToWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(spmid);
                        watchLaterApiKt$batchAddToWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        watchLaterApiKt$batchAddToWatchLater$12.label = 1;
                        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new WatchLaterApiKt$batchAddToWatchLater$httpResponse$1(url2, resources, spmid, null), watchLaterApiKt$batchAddToWatchLater$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        resources2 = resources;
                        url = url2;
                        obj = withContext;
                        spmid2 = spmid;
                        HttpResponse httpResponse = (HttpResponse) obj;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(WatchLaterAddToast.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        watchLaterApiKt$batchAddToWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        watchLaterApiKt$batchAddToWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(spmid2);
                        watchLaterApiKt$batchAddToWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$batchAddToWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$batchAddToWatchLater$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        watchLaterApiKt$batchAddToWatchLater$12.I$0 = 0;
                        watchLaterApiKt$batchAddToWatchLater$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, watchLaterApiKt$batchAddToWatchLater$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse response = (KApiResponse) bodyNullable;
                            return response;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.watch.later.watchlater.data.WatchLaterAddToast>");
                    case 1:
                        spmid2 = (String) watchLaterApiKt$batchAddToWatchLater$12.L$1;
                        resources2 = (String) watchLaterApiKt$batchAddToWatchLater$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) watchLaterApiKt$batchAddToWatchLater$12.L$2;
                        obj = $result;
                        HttpResponse httpResponse2 = (HttpResponse) obj;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(WatchLaterAddToast.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        watchLaterApiKt$batchAddToWatchLater$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        watchLaterApiKt$batchAddToWatchLater$12.L$1 = SpillingKt.nullOutSpilledVariable(spmid2);
                        watchLaterApiKt$batchAddToWatchLater$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        watchLaterApiKt$batchAddToWatchLater$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$batchAddToWatchLater$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        watchLaterApiKt$batchAddToWatchLater$12.I$0 = 0;
                        watchLaterApiKt$batchAddToWatchLater$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, watchLaterApiKt$batchAddToWatchLater$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = watchLaterApiKt$batchAddToWatchLater$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) watchLaterApiKt$batchAddToWatchLater$12.L$4;
                        HttpResponse httpResponse4 = (HttpResponse) watchLaterApiKt$batchAddToWatchLater$12.L$3;
                        Url url3 = (Url) watchLaterApiKt$batchAddToWatchLater$12.L$2;
                        String str = (String) watchLaterApiKt$batchAddToWatchLater$12.L$1;
                        String str2 = (String) watchLaterApiKt$batchAddToWatchLater$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        watchLaterApiKt$batchAddToWatchLater$1 = new WatchLaterApiKt$batchAddToWatchLater$1(continuation);
        watchLaterApiKt$batchAddToWatchLater$12 = watchLaterApiKt$batchAddToWatchLater$1;
        Object $result2 = watchLaterApiKt$batchAddToWatchLater$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterApiKt$batchAddToWatchLater$12.label) {
        }
    }
}