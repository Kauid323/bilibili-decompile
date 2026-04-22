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
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.account.model.UserInfo;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.watch.later.watchlater.edit.PlaySetPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* compiled from: FavoritesApi.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a&\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@¢\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0015"}, d2 = {"HOST", "", "client", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getCreatedPlaySetAll", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/watch/later/watchlater/edit/PlaySetPageData;", "pn", "", "ps", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchCopyResource", "", "resources", "targetMediaId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchMoveResource", "tarMediaId", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FavoritesApiKt {
    private static final String HOST = "api.bilibili.com";

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClient getClient() {
        return KtorClientKt.getKtorHttpClient();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0160 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getCreatedPlaySetAll(int pn, int ps, Continuation<? super KApiResponse<PlaySetPageData>> continuation) {
        FavoritesApiKt$getCreatedPlaySetAll$1 favoritesApiKt$getCreatedPlaySetAll$1;
        FavoritesApiKt$getCreatedPlaySetAll$1 favoritesApiKt$getCreatedPlaySetAll$12;
        int ps2;
        Url url;
        Object obj;
        int pn2;
        UserInfo userInfo;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof FavoritesApiKt$getCreatedPlaySetAll$1) {
            favoritesApiKt$getCreatedPlaySetAll$1 = (FavoritesApiKt$getCreatedPlaySetAll$1) continuation;
            if ((favoritesApiKt$getCreatedPlaySetAll$1.label & Integer.MIN_VALUE) != 0) {
                favoritesApiKt$getCreatedPlaySetAll$1.label -= Integer.MIN_VALUE;
                favoritesApiKt$getCreatedPlaySetAll$12 = favoritesApiKt$getCreatedPlaySetAll$1;
                Object $result = favoritesApiKt$getCreatedPlaySetAll$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesApiKt$getCreatedPlaySetAll$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$getCreatedPlaySetAll_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$getCreatedPlaySetAll_u24lambda_u240, "/x/v3/fav/folder/created/list-all");
                        ParametersBuilder $this$getCreatedPlaySetAll_u24lambda_u240_u240 = $this$getCreatedPlaySetAll_u24lambda_u240.getParameters();
                        Object value = KAccountStoreKt.getAccountHolder().getState().getValue();
                        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
                        Long mid = (logged == null || (userInfo = logged.getUserInfo()) == null) ? null : Boxing.boxLong(userInfo.getMid());
                        $this$getCreatedPlaySetAll_u24lambda_u240_u240.append("pn", String.valueOf(pn));
                        $this$getCreatedPlaySetAll_u24lambda_u240_u240.append("ps", String.valueOf(ps));
                        $this$getCreatedPlaySetAll_u24lambda_u240_u240.append("is_sapce", "0");
                        $this$getCreatedPlaySetAll_u24lambda_u240_u240.append("up_mid", String.valueOf(mid != null ? mid.longValue() : 0L));
                        Url url2 = $this$getCreatedPlaySetAll_u24lambda_u240.build();
                        favoritesApiKt$getCreatedPlaySetAll$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        favoritesApiKt$getCreatedPlaySetAll$12.I$0 = pn;
                        ps2 = ps;
                        favoritesApiKt$getCreatedPlaySetAll$12.I$1 = ps2;
                        favoritesApiKt$getCreatedPlaySetAll$12.label = 1;
                        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new FavoritesApiKt$getCreatedPlaySetAll$httpResponse$1(url2, null), favoritesApiKt$getCreatedPlaySetAll$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        obj = withContext;
                        pn2 = pn;
                        HttpResponse httpResponse = (HttpResponse) obj;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlaySetPageData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        favoritesApiKt$getCreatedPlaySetAll$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        favoritesApiKt$getCreatedPlaySetAll$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        favoritesApiKt$getCreatedPlaySetAll$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        favoritesApiKt$getCreatedPlaySetAll$12.I$0 = pn2;
                        favoritesApiKt$getCreatedPlaySetAll$12.I$1 = ps2;
                        favoritesApiKt$getCreatedPlaySetAll$12.I$2 = 0;
                        favoritesApiKt$getCreatedPlaySetAll$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, favoritesApiKt$getCreatedPlaySetAll$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse response = (KApiResponse) bodyNullable;
                            return response;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.watch.later.watchlater.edit.PlaySetPageData>");
                    case 1:
                        int $i$f$body = favoritesApiKt$getCreatedPlaySetAll$12.I$1;
                        pn2 = favoritesApiKt$getCreatedPlaySetAll$12.I$0;
                        ResultKt.throwOnFailure($result);
                        ps2 = $i$f$body;
                        obj = $result;
                        url = (Url) favoritesApiKt$getCreatedPlaySetAll$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) obj;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlaySetPageData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        favoritesApiKt$getCreatedPlaySetAll$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        favoritesApiKt$getCreatedPlaySetAll$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        favoritesApiKt$getCreatedPlaySetAll$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        favoritesApiKt$getCreatedPlaySetAll$12.I$0 = pn2;
                        favoritesApiKt$getCreatedPlaySetAll$12.I$1 = ps2;
                        favoritesApiKt$getCreatedPlaySetAll$12.I$2 = 0;
                        favoritesApiKt$getCreatedPlaySetAll$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, favoritesApiKt$getCreatedPlaySetAll$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = favoritesApiKt$getCreatedPlaySetAll$12.I$2;
                        int i2 = favoritesApiKt$getCreatedPlaySetAll$12.I$1;
                        int i3 = favoritesApiKt$getCreatedPlaySetAll$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) favoritesApiKt$getCreatedPlaySetAll$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) favoritesApiKt$getCreatedPlaySetAll$12.L$1;
                        Url url3 = (Url) favoritesApiKt$getCreatedPlaySetAll$12.L$0;
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
        favoritesApiKt$getCreatedPlaySetAll$1 = new FavoritesApiKt$getCreatedPlaySetAll$1(continuation);
        favoritesApiKt$getCreatedPlaySetAll$12 = favoritesApiKt$getCreatedPlaySetAll$1;
        Object $result2 = favoritesApiKt$getCreatedPlaySetAll$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesApiKt$getCreatedPlaySetAll$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0112 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object batchCopyResource(String resources, long targetMediaId, Continuation<? super KApiResponse<Unit>> continuation) {
        FavoritesApiKt$batchCopyResource$1 favoritesApiKt$batchCopyResource$1;
        FavoritesApiKt$batchCopyResource$1 favoritesApiKt$batchCopyResource$12;
        Object withContext;
        long targetMediaId2;
        Url url;
        String resources2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof FavoritesApiKt$batchCopyResource$1) {
            favoritesApiKt$batchCopyResource$1 = (FavoritesApiKt$batchCopyResource$1) continuation;
            if ((favoritesApiKt$batchCopyResource$1.label & Integer.MIN_VALUE) != 0) {
                favoritesApiKt$batchCopyResource$1.label -= Integer.MIN_VALUE;
                favoritesApiKt$batchCopyResource$12 = favoritesApiKt$batchCopyResource$1;
                Object $result = favoritesApiKt$batchCopyResource$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesApiKt$batchCopyResource$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$batchCopyResource_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$batchCopyResource_u24lambda_u240, "/x/v2/history/toview/copy");
                        Url url2 = $this$batchCopyResource_u24lambda_u240.build();
                        favoritesApiKt$batchCopyResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources);
                        favoritesApiKt$batchCopyResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        favoritesApiKt$batchCopyResource$12.J$0 = targetMediaId;
                        favoritesApiKt$batchCopyResource$12.label = 1;
                        withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new FavoritesApiKt$batchCopyResource$httpResponse$1(url2, resources, targetMediaId, null), favoritesApiKt$batchCopyResource$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        targetMediaId2 = targetMediaId;
                        url = url2;
                        resources2 = resources;
                        HttpResponse httpResponse = (HttpResponse) withContext;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            try {
                                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                            } catch (Throwable th) {
                                kType = null;
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                favoritesApiKt$batchCopyResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                                favoritesApiKt$batchCopyResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                                favoritesApiKt$batchCopyResource$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                favoritesApiKt$batchCopyResource$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                favoritesApiKt$batchCopyResource$12.J$0 = targetMediaId2;
                                favoritesApiKt$batchCopyResource$12.I$0 = 0;
                                favoritesApiKt$batchCopyResource$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, favoritesApiKt$batchCopyResource$12);
                                if (bodyNullable == coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th2) {
                        }
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                        favoritesApiKt$batchCopyResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        favoritesApiKt$batchCopyResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        favoritesApiKt$batchCopyResource$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        favoritesApiKt$batchCopyResource$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        favoritesApiKt$batchCopyResource$12.J$0 = targetMediaId2;
                        favoritesApiKt$batchCopyResource$12.I$0 = 0;
                        favoritesApiKt$batchCopyResource$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo2, favoritesApiKt$batchCopyResource$12);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse response = (KApiResponse) bodyNullable;
                            return response;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit>");
                    case 1:
                        targetMediaId2 = favoritesApiKt$batchCopyResource$12.J$0;
                        resources2 = (String) favoritesApiKt$batchCopyResource$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) favoritesApiKt$batchCopyResource$12.L$1;
                        withContext = $result;
                        HttpResponse httpResponse2 = (HttpResponse) withContext;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                        TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                        favoritesApiKt$batchCopyResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        favoritesApiKt$batchCopyResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        favoritesApiKt$batchCopyResource$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        favoritesApiKt$batchCopyResource$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        favoritesApiKt$batchCopyResource$12.J$0 = targetMediaId2;
                        favoritesApiKt$batchCopyResource$12.I$0 = 0;
                        favoritesApiKt$batchCopyResource$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo22, favoritesApiKt$batchCopyResource$12);
                        if (bodyNullable == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = favoritesApiKt$batchCopyResource$12.I$0;
                        long j = favoritesApiKt$batchCopyResource$12.J$0;
                        HttpResponse httpResponse3 = (HttpResponse) favoritesApiKt$batchCopyResource$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) favoritesApiKt$batchCopyResource$12.L$2;
                        Url url3 = (Url) favoritesApiKt$batchCopyResource$12.L$1;
                        String str = (String) favoritesApiKt$batchCopyResource$12.L$0;
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
        favoritesApiKt$batchCopyResource$1 = new FavoritesApiKt$batchCopyResource$1(continuation);
        favoritesApiKt$batchCopyResource$12 = favoritesApiKt$batchCopyResource$1;
        Object $result2 = favoritesApiKt$batchCopyResource$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesApiKt$batchCopyResource$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0112 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object batchMoveResource(String resources, long tarMediaId, Continuation<? super KApiResponse<Unit>> continuation) {
        FavoritesApiKt$batchMoveResource$1 favoritesApiKt$batchMoveResource$1;
        FavoritesApiKt$batchMoveResource$1 favoritesApiKt$batchMoveResource$12;
        Object withContext;
        long tarMediaId2;
        Url url;
        String resources2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof FavoritesApiKt$batchMoveResource$1) {
            favoritesApiKt$batchMoveResource$1 = (FavoritesApiKt$batchMoveResource$1) continuation;
            if ((favoritesApiKt$batchMoveResource$1.label & Integer.MIN_VALUE) != 0) {
                favoritesApiKt$batchMoveResource$1.label -= Integer.MIN_VALUE;
                favoritesApiKt$batchMoveResource$12 = favoritesApiKt$batchMoveResource$1;
                Object $result = favoritesApiKt$batchMoveResource$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (favoritesApiKt$batchMoveResource$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$batchMoveResource_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$batchMoveResource_u24lambda_u240, "/x/v2/history/toview/move");
                        Url url2 = $this$batchMoveResource_u24lambda_u240.build();
                        favoritesApiKt$batchMoveResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources);
                        favoritesApiKt$batchMoveResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        favoritesApiKt$batchMoveResource$12.J$0 = tarMediaId;
                        favoritesApiKt$batchMoveResource$12.label = 1;
                        withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new FavoritesApiKt$batchMoveResource$httpResponse$1(url2, tarMediaId, resources, null), favoritesApiKt$batchMoveResource$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tarMediaId2 = tarMediaId;
                        url = url2;
                        resources2 = resources;
                        HttpResponse httpResponse = (HttpResponse) withContext;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            try {
                                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                            } catch (Throwable th) {
                                kType = null;
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                favoritesApiKt$batchMoveResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                                favoritesApiKt$batchMoveResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                                favoritesApiKt$batchMoveResource$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                favoritesApiKt$batchMoveResource$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                favoritesApiKt$batchMoveResource$12.J$0 = tarMediaId2;
                                favoritesApiKt$batchMoveResource$12.I$0 = 0;
                                favoritesApiKt$batchMoveResource$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, favoritesApiKt$batchMoveResource$12);
                                if (bodyNullable == coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th2) {
                        }
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                        favoritesApiKt$batchMoveResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        favoritesApiKt$batchMoveResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        favoritesApiKt$batchMoveResource$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        favoritesApiKt$batchMoveResource$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        favoritesApiKt$batchMoveResource$12.J$0 = tarMediaId2;
                        favoritesApiKt$batchMoveResource$12.I$0 = 0;
                        favoritesApiKt$batchMoveResource$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo2, favoritesApiKt$batchMoveResource$12);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse response = (KApiResponse) bodyNullable;
                            return response;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit>");
                    case 1:
                        tarMediaId2 = favoritesApiKt$batchMoveResource$12.J$0;
                        resources2 = (String) favoritesApiKt$batchMoveResource$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) favoritesApiKt$batchMoveResource$12.L$1;
                        withContext = $result;
                        HttpResponse httpResponse2 = (HttpResponse) withContext;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                        TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                        favoritesApiKt$batchMoveResource$12.L$0 = SpillingKt.nullOutSpilledVariable(resources2);
                        favoritesApiKt$batchMoveResource$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        favoritesApiKt$batchMoveResource$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        favoritesApiKt$batchMoveResource$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        favoritesApiKt$batchMoveResource$12.J$0 = tarMediaId2;
                        favoritesApiKt$batchMoveResource$12.I$0 = 0;
                        favoritesApiKt$batchMoveResource$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo22, favoritesApiKt$batchMoveResource$12);
                        if (bodyNullable == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = favoritesApiKt$batchMoveResource$12.I$0;
                        long j = favoritesApiKt$batchMoveResource$12.J$0;
                        HttpResponse httpResponse3 = (HttpResponse) favoritesApiKt$batchMoveResource$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) favoritesApiKt$batchMoveResource$12.L$2;
                        Url url3 = (Url) favoritesApiKt$batchMoveResource$12.L$1;
                        String str = (String) favoritesApiKt$batchMoveResource$12.L$0;
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
        favoritesApiKt$batchMoveResource$1 = new FavoritesApiKt$batchMoveResource$1(continuation);
        favoritesApiKt$batchMoveResource$12 = favoritesApiKt$batchMoveResource$1;
        Object $result2 = favoritesApiKt$batchMoveResource$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (favoritesApiKt$batchMoveResource$12.label) {
        }
    }
}