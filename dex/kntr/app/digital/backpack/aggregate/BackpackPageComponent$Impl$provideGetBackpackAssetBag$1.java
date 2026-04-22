package kntr.app.digital.backpack.aggregate;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ogv.bpf.server.ApiExceptionKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackpackPageComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class BackpackPageComponent$Impl$provideGetBackpackAssetBag$1 implements GetBackpackAssetBag {
    final /* synthetic */ int $actId;
    final /* synthetic */ HttpClient $httpClient;
    final /* synthetic */ long $vmid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackpackPageComponent$Impl$provideGetBackpackAssetBag$1(HttpClient httpClient, int i, long j2) {
        this.$httpClient = httpClient;
        this.$actId = i;
        this.$vmid = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b9 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01c7, TryCatch #8 {CancellationException -> 0x01c7, Exception -> 0x01c5, blocks: (B:47:0x01b9, B:48:0x01bd, B:49:0x01c4, B:36:0x0161, B:43:0x0189), top: B:82:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bd A[Catch: Exception -> 0x01c5, CancellationException -> 0x01c7, TryCatch #8 {CancellationException -> 0x01c7, Exception -> 0x01c5, blocks: (B:47:0x01b9, B:48:0x01bd, B:49:0x01c4, B:36:0x0161, B:43:0x0189), top: B:82:0x0161 }] */
    @Override // kntr.app.digital.backpack.api.GetBackpackAssetBag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(final long lotteryId, Continuation<? super KApiResponse<BackpackAssetBagModel>> continuation) {
        BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1;
        BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12;
        int $i$f$handleApiException;
        int i;
        HttpStatement httpStatement;
        Object obj;
        long lotteryId2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1) {
            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 = (BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1) continuation;
            if ((backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1.label -= Integer.MIN_VALUE;
                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1;
                Object $result = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClient $this$get$iv = this.$httpClient;
                        final int i2 = this.$actId;
                        final long j2 = this.$vmid;
                        $i$f$handleApiException = 0;
                        i = 0;
                        try {
                            HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                            HttpRequestKt.url($this$get_u24lambda_u244$iv, "https://api.bilibili.com/x/vas/dlc_act/asset_bag_v2");
                            try {
                                $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj2, Object obj3) {
                                        Unit invoke$lambda$0$0$0;
                                        invoke$lambda$0$0$0 = BackpackPageComponent$Impl$provideGetBackpackAssetBag$1.invoke$lambda$0$0$0(i2, j2, lotteryId, (URLBuilder) obj2, (URLBuilder) obj3);
                                        return invoke$lambda$0$0$0;
                                    }
                                });
                                $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                                httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/dlc_act/asset_bag_v2");
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12);
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                obj = coroutine_suspended;
                                lotteryId2 = lotteryId;
                            } catch (CancellationException e$iv) {
                                throw e$iv;
                            } catch (Exception e) {
                                e$iv = e;
                            }
                            try {
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.J$0 = lotteryId2;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$0 = 0;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$1 = 0;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$2 = 0;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$3 = 0;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$4 = 0;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$5 = 0;
                                backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.label = 1;
                                Object execute = httpStatement.execute(backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12);
                                if (execute == obj) {
                                    return obj;
                                }
                                $result = execute;
                                try {
                                    HttpResponse $this$body$iv = (HttpResponse) $result;
                                    HttpClientCall call = $this$body$iv.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                    try {
                                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BackpackAssetBagModel.class)));
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12);
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$2 = null;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$3 = null;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$4 = null;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$5 = null;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$6 = null;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.J$0 = lotteryId2;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$0 = $i$f$handleApiException;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$1 = i;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$2 = 0;
                                    backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12);
                                    if (bodyNullable == obj) {
                                        return obj;
                                    }
                                    if (bodyNullable != null) {
                                        return (KApiResponse) bodyNullable;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.digital.backpack.api.BackpackAssetBagModel>");
                                } catch (CancellationException e$iv2) {
                                    throw e$iv2;
                                } catch (Exception e2) {
                                    e$iv = e2;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e$iv3) {
                                throw e$iv3;
                            } catch (Exception e3) {
                                e$iv = e3;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e$iv4) {
                            throw e$iv4;
                        } catch (Exception e4) {
                            e$iv = e4;
                        }
                    case 1:
                        int i3 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$5;
                        int i4 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$4;
                        int i5 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$3;
                        int i6 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$2;
                        int i7 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$1;
                        int $i$f$handleApiException2 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$0;
                        long lotteryId3 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.J$0;
                        HttpClient httpClient = (HttpClient) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$5;
                        HttpClient httpClient2 = (HttpClient) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$4;
                        HttpClient httpClient3 = (HttpClient) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$3;
                        BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$13 = (BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$2;
                        String str = (String) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$1;
                        HttpClient httpClient4 = (HttpClient) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            i = i7;
                            obj = coroutine_suspended;
                            $i$f$handleApiException = $i$f$handleApiException2;
                            lotteryId2 = lotteryId3;
                            HttpResponse $this$body$iv2 = (HttpResponse) $result;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BackpackAssetBagModel.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12);
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$2 = null;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$3 = null;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$4 = null;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$5 = null;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$6 = null;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.J$0 = lotteryId2;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$0 = $i$f$handleApiException;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$1 = i;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$2 = 0;
                            backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12);
                            if (bodyNullable == obj) {
                            }
                            if (bodyNullable != null) {
                            }
                        } catch (CancellationException e$iv5) {
                            throw e$iv5;
                        } catch (Exception e5) {
                            e$iv = e5;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i8 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$2;
                        int i9 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$1;
                        int i10 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.I$0;
                        long j3 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.J$0;
                        BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$14 = (BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$1;
                        HttpResponse httpResponse = (HttpResponse) backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            if (bodyNullable != null) {
                            }
                        } catch (CancellationException e$iv6) {
                            throw e$iv6;
                        } catch (Exception e6) {
                            e$iv = e6;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 = new BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1(this, continuation);
        backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1;
        Object $result2 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (backpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$0$0(int $actId, long $vmid, long $lotteryId, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$invoke_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$invoke_u24lambda_u240_u240_u240_u240.append("act_id", String.valueOf($actId));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("vmid", String.valueOf($vmid));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("lottery_id", String.valueOf($lotteryId));
        return Unit.INSTANCE;
    }
}