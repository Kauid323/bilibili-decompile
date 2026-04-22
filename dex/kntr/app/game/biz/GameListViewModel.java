package kntr.app.game.biz;

import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.bilibili.biligame.kntr.common.api.BiligameHttpClientKt;
import com.bilibili.biligame.kntr.common.api.BiligameUrlBuilderKt;
import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.bean.KBiligamePage;
import com.bilibili.ktor.KApiResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.game.base.viewmodel.BaseListViewModel;
import kntr.app.game.downloader.KntrGameDownloadManager;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: DownloaderTest.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkntr/app/game/biz/GameListViewModel;", "Lkntr/app/game/base/viewmodel/BaseListViewModel;", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "type", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "loadPage", RoomRecommendViewModel.EMPTY_CURSOR, "page", RoomRecommendViewModel.EMPTY_CURSOR, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", RoomRecommendViewModel.EMPTY_CURSOR, "data", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameListViewModel extends BaseListViewModel<KBiligame> {
    public static final int $stable = BaseListViewModel.$stable;
    private final String type;

    public GameListViewModel(String type) {
        this.type = type;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0206  */
    @Override // kntr.app.game.base.viewmodel.BaseListViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadPage(int page, Continuation<? super List<? extends KBiligame>> continuation) {
        GameListViewModel$loadPage$1 gameListViewModel$loadPage$1;
        GameListViewModel$loadPage$1 gameListViewModel$loadPage$12;
        int page2;
        String api;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof GameListViewModel$loadPage$1) {
            gameListViewModel$loadPage$1 = (GameListViewModel$loadPage$1) continuation;
            if ((gameListViewModel$loadPage$1.label & Integer.MIN_VALUE) != 0) {
                gameListViewModel$loadPage$1.label -= Integer.MIN_VALUE;
                gameListViewModel$loadPage$12 = gameListViewModel$loadPage$1;
                Object $result = gameListViewModel$loadPage$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameListViewModel$loadPage$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String api2 = Intrinsics.areEqual(this.type, "1") ? "/game/center/h5/top_charts/top_order" : "/game/center/h5/top_charts/hottest";
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl(api2, MapsKt.mapOf(new Pair[]{TuplesKt.to("page_num", String.valueOf(page)), TuplesKt.to("page_size", "20")}));
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        gameListViewModel$loadPage$12.L$0 = SpillingKt.nullOutSpilledVariable(api2);
                        gameListViewModel$loadPage$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        gameListViewModel$loadPage$12.L$2 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameListViewModel$loadPage$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        gameListViewModel$loadPage$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameListViewModel$loadPage$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameListViewModel$loadPage$12.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        gameListViewModel$loadPage$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        page2 = page;
                        gameListViewModel$loadPage$12.I$0 = page2;
                        gameListViewModel$loadPage$12.I$1 = 0;
                        gameListViewModel$loadPage$12.I$2 = 0;
                        gameListViewModel$loadPage$12.I$3 = 0;
                        gameListViewModel$loadPage$12.I$4 = 0;
                        api = api2;
                        gameListViewModel$loadPage$12.label = 1;
                        execute = httpStatement.execute(gameListViewModel$loadPage$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KBiligamePage.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KBiligame.class)))));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        gameListViewModel$loadPage$12.L$0 = SpillingKt.nullOutSpilledVariable(api);
                        gameListViewModel$loadPage$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        gameListViewModel$loadPage$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameListViewModel$loadPage$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameListViewModel$loadPage$12.L$4 = null;
                        gameListViewModel$loadPage$12.L$5 = null;
                        gameListViewModel$loadPage$12.L$6 = null;
                        gameListViewModel$loadPage$12.L$7 = null;
                        gameListViewModel$loadPage$12.I$0 = page2;
                        gameListViewModel$loadPage$12.I$1 = 0;
                        gameListViewModel$loadPage$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, gameListViewModel$loadPage$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                List $this$loadPage_u24lambda_u240 = ((KBiligamePage) success.getData()).getList();
                                if ($this$loadPage_u24lambda_u240 != null) {
                                    KntrGameDownloadManager.INSTANCE.registerDownloadStatus($this$loadPage_u24lambda_u240);
                                    return $this$loadPage_u24lambda_u240;
                                }
                                return CollectionsKt.emptyList();
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            } else {
                                if (success instanceof KApiResponse.ServiceUnavailable) {
                                    throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<com.bilibili.biligame.kntr.common.bean.KBiligamePage<com.bilibili.biligame.kntr.common.bean.KBiligame>>");
                    case 1:
                        int $i$f$body = gameListViewModel$loadPage$12.I$4;
                        int i = gameListViewModel$loadPage$12.I$3;
                        int i2 = gameListViewModel$loadPage$12.I$2;
                        int i3 = gameListViewModel$loadPage$12.I$1;
                        int page3 = gameListViewModel$loadPage$12.I$0;
                        HttpClient httpClient = (HttpClient) gameListViewModel$loadPage$12.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) gameListViewModel$loadPage$12.L$6;
                        HttpClient httpClient2 = (HttpClient) gameListViewModel$loadPage$12.L$5;
                        HttpClient httpClient3 = (HttpClient) gameListViewModel$loadPage$12.L$4;
                        Url url3 = (Url) gameListViewModel$loadPage$12.L$3;
                        HttpClient httpClient4 = (HttpClient) gameListViewModel$loadPage$12.L$2;
                        Url url4 = (Url) gameListViewModel$loadPage$12.L$1;
                        String api3 = (String) gameListViewModel$loadPage$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = url4;
                        api = api3;
                        execute = $result;
                        page2 = page3;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KBiligamePage.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KBiligame.class)))));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        gameListViewModel$loadPage$12.L$0 = SpillingKt.nullOutSpilledVariable(api);
                        gameListViewModel$loadPage$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        gameListViewModel$loadPage$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameListViewModel$loadPage$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameListViewModel$loadPage$12.L$4 = null;
                        gameListViewModel$loadPage$12.L$5 = null;
                        gameListViewModel$loadPage$12.L$6 = null;
                        gameListViewModel$loadPage$12.L$7 = null;
                        gameListViewModel$loadPage$12.I$0 = page2;
                        gameListViewModel$loadPage$12.I$1 = 0;
                        gameListViewModel$loadPage$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, gameListViewModel$loadPage$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = gameListViewModel$loadPage$12.I$1;
                        int i5 = gameListViewModel$loadPage$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) gameListViewModel$loadPage$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) gameListViewModel$loadPage$12.L$2;
                        Url url5 = (Url) gameListViewModel$loadPage$12.L$1;
                        String str = (String) gameListViewModel$loadPage$12.L$0;
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
        gameListViewModel$loadPage$1 = new GameListViewModel$loadPage$1(this, continuation);
        gameListViewModel$loadPage$12 = gameListViewModel$loadPage$1;
        Object $result2 = gameListViewModel$loadPage$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameListViewModel$loadPage$12.label) {
        }
    }

    @Override // kntr.app.game.base.viewmodel.BaseListViewModel, kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(List<? extends KBiligame> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        return list.isEmpty();
    }
}