package kntr.app.game.steam;

import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.bilibili.biligame.kntr.common.api.BiligameHttpClientKt;
import com.bilibili.biligame.kntr.common.api.BiligameUrlBuilderKt;
import com.bilibili.biligame.kntr.common.bean.KBiligamePage;
import com.bilibili.ktor.KApiResponse;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
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
import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.game.bean.SteamDetailGameItem;
import kntr.app.game.bean.SteamDetailPageData;
import kntr.app.game.bean.SteamGameListSortType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SteamDetailVM.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u0012H\u0087@¢\u0006\u0002\u0010+J\u001e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\u0006\u00101\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u00102J\u0010\u00103\u001a\u0004\u0018\u00010\u0002H\u0087@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0014J\u0010\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0002H\u0016J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\fH\u0087@¢\u0006\u0002\u0010@J\u000e\u0010C\u001a\u00020>H\u0087@¢\u0006\u0002\u00104J$\u0010D\u001a\u00020>*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020F\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0EH\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010(R\u0014\u0010:\u001a\u00020#X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020#X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010<¨\u0006I"}, d2 = {"Lkntr/app/game/steam/SteamDetailVM;", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "Lkntr/app/game/bean/SteamDetailPageData;", "<init>", "()V", "mPage", RoomRecommendViewModel.EMPTY_CURSOR, "getMPage", "()I", "setMPage", "(I)V", "sortType", "Lkntr/app/game/bean/SteamGameListSortType;", "getSortType", "()Lkntr/app/game/bean/SteamGameListSortType;", "setSortType", "(Lkntr/app/game/bean/SteamGameListSortType;)V", "refreshSortType", RoomRecommendViewModel.EMPTY_CURSOR, "getRefreshSortType", "()Z", "setRefreshSortType", "(Z)V", "fisrtLoad", "getFisrtLoad", "setFisrtLoad", "refreshSteamFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "refreshSteam", "Lkotlinx/coroutines/flow/StateFlow;", "getRefreshSteam$annotations", "getRefreshSteam", "()Lkotlinx/coroutines/flow/StateFlow;", "toast", "Lkotlinx/coroutines/flow/MutableSharedFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent$annotations", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadData", "refresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestProfile", "force", "requestGameList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/bean/SteamDetailGameItem;", "page", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeData", "old", "new", "checkEmpty", "data", "dispatchSortTypeEventName", "getDispatchSortTypeEventName", "()Ljava/lang/String;", "dispatchSortType", RoomRecommendViewModel.EMPTY_CURSOR, "type", "(Lkntr/app/game/bean/SteamGameListSortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshSteamDataEventName", "getRefreshSteamDataEventName", "refreshSteamData", "customContentBlock", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/game/base/viewmodel/PageState$Content;", "Lkntr/app/game/base/viewmodel/PageState;", "Lkntr/app/game/base/viewmodel/event/PageEvent;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SteamDetailVM extends BaseViewModel<SteamDetailPageData> {
    public static final int $stable = 8;
    private boolean refreshSortType;
    private int mPage = 1;
    private SteamGameListSortType sortType = SteamGameListSortType.Last2Weeks;
    private boolean fisrtLoad = true;
    private MutableStateFlow<Boolean> refreshSteamFlow = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<Boolean> refreshSteam = FlowKt.asStateFlow(this.refreshSteamFlow);
    private final MutableSharedFlow<String> toast = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 4, (Object) null);
    private final SharedFlow<String> toastEvent = FlowKt.asSharedFlow(this.toast);
    private final String dispatchSortTypeEventName = "dispatchSortType";
    private final String refreshSteamDataEventName = "refreshSteamData";

    public static /* synthetic */ void getRefreshSteam$annotations() {
    }

    public static /* synthetic */ void getToastEvent$annotations() {
    }

    public final int getMPage() {
        return this.mPage;
    }

    public final void setMPage(int i) {
        this.mPage = i;
    }

    public final SteamGameListSortType getSortType() {
        return this.sortType;
    }

    public final void setSortType(SteamGameListSortType steamGameListSortType) {
        Intrinsics.checkNotNullParameter(steamGameListSortType, "<set-?>");
        this.sortType = steamGameListSortType;
    }

    public final boolean getRefreshSortType() {
        return this.refreshSortType;
    }

    public final void setRefreshSortType(boolean z) {
        this.refreshSortType = z;
    }

    public final boolean getFisrtLoad() {
        return this.fisrtLoad;
    }

    public final void setFisrtLoad(boolean z) {
        this.fisrtLoad = z;
    }

    public final StateFlow<Boolean> getRefreshSteam() {
        return this.refreshSteam;
    }

    public final SharedFlow<String> getToastEvent() {
        return this.toastEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(boolean refresh, Continuation<? super SteamDetailPageData> continuation) {
        SteamDetailVM$loadData$1 steamDetailVM$loadData$1;
        SteamDetailPageData data;
        Object requestProfile$default;
        Object requestGameList;
        SteamDetailPageData data2;
        List list;
        if (continuation instanceof SteamDetailVM$loadData$1) {
            steamDetailVM$loadData$1 = (SteamDetailVM$loadData$1) continuation;
            if ((steamDetailVM$loadData$1.label & Integer.MIN_VALUE) != 0) {
                steamDetailVM$loadData$1.label -= Integer.MIN_VALUE;
                Object $result = steamDetailVM$loadData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamDetailVM$loadData$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().d("SteamDetailVM", "loadData firstload:" + this.fisrtLoad + " refresh:" + refresh + " page : " + this.mPage);
                        if (refresh) {
                            this.mPage = 1;
                            this.fisrtLoad = true;
                        }
                        if (this.refreshSortType) {
                            this.refreshSortType = false;
                            this.mPage = 1;
                        }
                        if (this.fisrtLoad) {
                            steamDetailVM$loadData$1.Z$0 = refresh;
                            steamDetailVM$loadData$1.label = 1;
                            requestProfile$default = requestProfile$default(this, false, steamDetailVM$loadData$1, 1, null);
                            if (requestProfile$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            data = (SteamDetailPageData) requestProfile$default;
                            int i = this.mPage;
                            steamDetailVM$loadData$1.L$0 = data;
                            steamDetailVM$loadData$1.Z$0 = refresh;
                            steamDetailVM$loadData$1.label = 2;
                            requestGameList = requestGameList(i, steamDetailVM$loadData$1);
                            if (requestGameList == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            data2 = data;
                            list = (List) requestGameList;
                            if (list != null) {
                                this.mPage++;
                            }
                            data2.setList(list);
                            return data2;
                        }
                        data = new SteamDetailPageData();
                        int i2 = this.mPage;
                        steamDetailVM$loadData$1.L$0 = data;
                        steamDetailVM$loadData$1.Z$0 = refresh;
                        steamDetailVM$loadData$1.label = 2;
                        requestGameList = requestGameList(i2, steamDetailVM$loadData$1);
                        if (requestGameList == coroutine_suspended) {
                        }
                    case 1:
                        refresh = steamDetailVM$loadData$1.Z$0;
                        ResultKt.throwOnFailure($result);
                        requestProfile$default = $result;
                        data = (SteamDetailPageData) requestProfile$default;
                        int i22 = this.mPage;
                        steamDetailVM$loadData$1.L$0 = data;
                        steamDetailVM$loadData$1.Z$0 = refresh;
                        steamDetailVM$loadData$1.label = 2;
                        requestGameList = requestGameList(i22, steamDetailVM$loadData$1);
                        if (requestGameList == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        boolean refresh2 = steamDetailVM$loadData$1.Z$0;
                        data2 = (SteamDetailPageData) steamDetailVM$loadData$1.L$0;
                        ResultKt.throwOnFailure($result);
                        requestGameList = $result;
                        list = (List) requestGameList;
                        if (list != null) {
                        }
                        data2.setList(list);
                        return data2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamDetailVM$loadData$1 = new SteamDetailVM$loadData$1(this, continuation);
        Object $result2 = steamDetailVM$loadData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamDetailVM$loadData$1.label) {
        }
    }

    public static /* synthetic */ Object requestProfile$default(SteamDetailVM steamDetailVM, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return steamDetailVM.requestProfile(z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0186 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestProfile(boolean force, Continuation<? super SteamDetailPageData> continuation) {
        SteamDetailVM$requestProfile$1 steamDetailVM$requestProfile$1;
        Map params;
        boolean force2;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof SteamDetailVM$requestProfile$1) {
            steamDetailVM$requestProfile$1 = (SteamDetailVM$requestProfile$1) continuation;
            if ((steamDetailVM$requestProfile$1.label & Integer.MIN_VALUE) != 0) {
                steamDetailVM$requestProfile$1.label -= Integer.MIN_VALUE;
                Object $result = steamDetailVM$requestProfile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamDetailVM$requestProfile$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        params = force ? MapsKt.mapOf(TuplesKt.to("refresh", "1")) : null;
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl("api/game/steam/profile", params);
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        steamDetailVM$requestProfile$1.L$0 = SpillingKt.nullOutSpilledVariable(params);
                        steamDetailVM$requestProfile$1.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        steamDetailVM$requestProfile$1.L$2 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        steamDetailVM$requestProfile$1.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        steamDetailVM$requestProfile$1.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        steamDetailVM$requestProfile$1.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        steamDetailVM$requestProfile$1.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        steamDetailVM$requestProfile$1.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        steamDetailVM$requestProfile$1.Z$0 = force;
                        steamDetailVM$requestProfile$1.I$0 = 0;
                        steamDetailVM$requestProfile$1.I$1 = 0;
                        steamDetailVM$requestProfile$1.I$2 = 0;
                        steamDetailVM$requestProfile$1.I$3 = 0;
                        steamDetailVM$requestProfile$1.label = 1;
                        $result = httpStatement.execute(steamDetailVM$requestProfile$1);
                        coroutine_suspended = coroutine_suspended;
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        force2 = force;
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamDetailPageData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        steamDetailVM$requestProfile$1.L$0 = SpillingKt.nullOutSpilledVariable(params);
                        steamDetailVM$requestProfile$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        steamDetailVM$requestProfile$1.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        steamDetailVM$requestProfile$1.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        steamDetailVM$requestProfile$1.L$4 = null;
                        steamDetailVM$requestProfile$1.L$5 = null;
                        steamDetailVM$requestProfile$1.L$6 = null;
                        steamDetailVM$requestProfile$1.L$7 = null;
                        steamDetailVM$requestProfile$1.Z$0 = force2;
                        steamDetailVM$requestProfile$1.I$0 = 0;
                        steamDetailVM$requestProfile$1.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, steamDetailVM$requestProfile$1);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                SteamDetailPageData data = (SteamDetailPageData) success.getData();
                                return data;
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            } else {
                                if (success instanceof KApiResponse.ServiceUnavailable) {
                                    throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.bean.SteamDetailPageData>");
                    case 1:
                        int i = steamDetailVM$requestProfile$1.I$3;
                        int i2 = steamDetailVM$requestProfile$1.I$2;
                        int i3 = steamDetailVM$requestProfile$1.I$1;
                        int i4 = steamDetailVM$requestProfile$1.I$0;
                        boolean force3 = steamDetailVM$requestProfile$1.Z$0;
                        HttpClient httpClient = (HttpClient) steamDetailVM$requestProfile$1.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) steamDetailVM$requestProfile$1.L$6;
                        HttpClient httpClient2 = (HttpClient) steamDetailVM$requestProfile$1.L$5;
                        HttpClient httpClient3 = (HttpClient) steamDetailVM$requestProfile$1.L$4;
                        Url url3 = (Url) steamDetailVM$requestProfile$1.L$3;
                        HttpClient httpClient4 = (HttpClient) steamDetailVM$requestProfile$1.L$2;
                        Url url4 = (Url) steamDetailVM$requestProfile$1.L$1;
                        Map params2 = (Map) steamDetailVM$requestProfile$1.L$0;
                        ResultKt.throwOnFailure($result);
                        force2 = force3;
                        params = params2;
                        url = url4;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamDetailPageData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        steamDetailVM$requestProfile$1.L$0 = SpillingKt.nullOutSpilledVariable(params);
                        steamDetailVM$requestProfile$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        steamDetailVM$requestProfile$1.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamDetailVM$requestProfile$1.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamDetailVM$requestProfile$1.L$4 = null;
                        steamDetailVM$requestProfile$1.L$5 = null;
                        steamDetailVM$requestProfile$1.L$6 = null;
                        steamDetailVM$requestProfile$1.L$7 = null;
                        steamDetailVM$requestProfile$1.Z$0 = force2;
                        steamDetailVM$requestProfile$1.I$0 = 0;
                        steamDetailVM$requestProfile$1.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, steamDetailVM$requestProfile$1);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i5 = steamDetailVM$requestProfile$1.I$0;
                        boolean z = steamDetailVM$requestProfile$1.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) steamDetailVM$requestProfile$1.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) steamDetailVM$requestProfile$1.L$2;
                        Url url5 = (Url) steamDetailVM$requestProfile$1.L$1;
                        Map map = (Map) steamDetailVM$requestProfile$1.L$0;
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
        steamDetailVM$requestProfile$1 = new SteamDetailVM$requestProfile$1(this, continuation);
        Object $result2 = steamDetailVM$requestProfile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamDetailVM$requestProfile$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0310 A[Catch: Exception -> 0x035a, TRY_ENTER, TryCatch #2 {Exception -> 0x035a, blocks: (B:72:0x0310, B:74:0x0318, B:76:0x0327, B:78:0x032b, B:80:0x032f, B:81:0x033f, B:82:0x0340, B:83:0x0345, B:84:0x0346, B:85:0x0359, B:88:0x035c, B:89:0x0364), top: B:98:0x030e }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x035c A[Catch: Exception -> 0x035a, TryCatch #2 {Exception -> 0x035a, blocks: (B:72:0x0310, B:74:0x0318, B:76:0x0327, B:78:0x032b, B:80:0x032f, B:81:0x033f, B:82:0x0340, B:83:0x0345, B:84:0x0346, B:85:0x0359, B:88:0x035c, B:89:0x0364), top: B:98:0x030e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestGameList(int page, Continuation<? super List<SteamDetailGameItem>> continuation) {
        SteamDetailVM$requestGameList$1 steamDetailVM$requestGameList$1;
        SteamDetailVM$requestGameList$1 steamDetailVM$requestGameList$12;
        KType kType;
        int page2;
        Object execute;
        Object obj;
        Url url;
        KType kType2;
        boolean z;
        KType kType3;
        Object bodyNullable;
        if (continuation instanceof SteamDetailVM$requestGameList$1) {
            steamDetailVM$requestGameList$1 = (SteamDetailVM$requestGameList$1) continuation;
            if ((steamDetailVM$requestGameList$1.label & Integer.MIN_VALUE) != 0) {
                steamDetailVM$requestGameList$1.label -= Integer.MIN_VALUE;
                steamDetailVM$requestGameList$12 = steamDetailVM$requestGameList$1;
                Object $result = steamDetailVM$requestGameList$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamDetailVM$requestGameList$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("api/game/steam/games", (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Pair[] pairArr = new Pair[5];
                        pairArr[0] = TuplesKt.to("page_num", String.valueOf(page));
                        pairArr[1] = TuplesKt.to("page_size", "20");
                        pairArr[2] = TuplesKt.to("sort_type", String.valueOf(this.sortType.getType()));
                        pairArr[3] = TuplesKt.to("sort_order", this.sortType.getAsc() ? "1" : AdSearchSubCardType.CARD_TYPE_NONE);
                        pairArr[4] = TuplesKt.to("only_with_playtime", AdSearchSubCardType.CARD_TYPE_NONE);
                        Map params$iv = MapsKt.mapOf(pairArr);
                        HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url2);
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                        Parameters.Companion companion = Parameters.Companion;
                        boolean z2 = false;
                        ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        boolean z3 = false;
                        BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                        for (Map.Entry element$iv$iv : params$iv.entrySet()) {
                            String it$iv = (String) element$iv$iv.getValue();
                            if (it$iv != null) {
                                if (!(it$iv.length() > 0 ? true : z2)) {
                                    it$iv = null;
                                }
                                if (it$iv != null) {
                                    String value$iv = it$iv;
                                    z = z3;
                                    BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                    z3 = z;
                                    z2 = false;
                                }
                            }
                            z = z3;
                            z3 = z;
                            z2 = false;
                        }
                        Object body$iv$iv = HttpUrlEncodedKt.formUrlEncode($this$postFormUrlEncode_u24lambda_u240_u240$iv.build());
                        if (body$iv$iv == null) {
                            httpRequestBuilder.setBody(NullBody.INSTANCE);
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                            try {
                                kType2 = Reflection.typeOf(String.class);
                            } catch (Throwable th) {
                                kType2 = null;
                            }
                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                        } else if (body$iv$iv instanceof OutgoingContent) {
                            httpRequestBuilder.setBody(body$iv$iv);
                            httpRequestBuilder.setBodyType((TypeInfo) null);
                        } else {
                            httpRequestBuilder.setBody(body$iv$iv);
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                            try {
                                kType = Reflection.typeOf(String.class);
                            } catch (Throwable th2) {
                                kType = null;
                            }
                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                        }
                        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$postFormUrlEncode$iv);
                        steamDetailVM$requestGameList$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        steamDetailVM$requestGameList$12.L$1 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamDetailVM$requestGameList$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        steamDetailVM$requestGameList$12.L$3 = SpillingKt.nullOutSpilledVariable(params$iv);
                        steamDetailVM$requestGameList$12.L$4 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamDetailVM$requestGameList$12.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                        steamDetailVM$requestGameList$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamDetailVM$requestGameList$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        steamDetailVM$requestGameList$12.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        steamDetailVM$requestGameList$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        page2 = page;
                        steamDetailVM$requestGameList$12.I$0 = page2;
                        steamDetailVM$requestGameList$12.I$1 = 0;
                        steamDetailVM$requestGameList$12.I$2 = 0;
                        steamDetailVM$requestGameList$12.I$3 = 0;
                        steamDetailVM$requestGameList$12.I$4 = 0;
                        steamDetailVM$requestGameList$12.I$5 = 0;
                        steamDetailVM$requestGameList$12.label = 1;
                        execute = httpStatement.execute(steamDetailVM$requestGameList$12);
                        obj = coroutine_suspended;
                        if (execute == obj) {
                            return obj;
                        }
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        try {
                            HttpClientCall call = httpResponse.getCall();
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            try {
                                kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KBiligamePage.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamDetailGameItem.class)))));
                            } catch (Throwable th3) {
                                kType3 = null;
                            }
                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                            steamDetailVM$requestGameList$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            steamDetailVM$requestGameList$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                            steamDetailVM$requestGameList$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                            steamDetailVM$requestGameList$12.L$3 = null;
                            steamDetailVM$requestGameList$12.L$4 = null;
                            steamDetailVM$requestGameList$12.L$5 = null;
                            steamDetailVM$requestGameList$12.L$6 = null;
                            steamDetailVM$requestGameList$12.L$7 = null;
                            steamDetailVM$requestGameList$12.L$8 = null;
                            steamDetailVM$requestGameList$12.L$9 = null;
                            steamDetailVM$requestGameList$12.I$0 = page2;
                            steamDetailVM$requestGameList$12.I$1 = 0;
                            steamDetailVM$requestGameList$12.label = 2;
                            bodyNullable = call.bodyNullable(typeInfo, steamDetailVM$requestGameList$12);
                            if (bodyNullable != obj) {
                                return obj;
                            }
                            try {
                                if (bodyNullable == null) {
                                    KApiResponse.Success success = (KApiResponse) bodyNullable;
                                    if (success instanceof KApiResponse.Success) {
                                        KBiligamePage data = (KBiligamePage) success.getData();
                                        return data.getList();
                                    } else if (success instanceof KApiResponse.BusinessFailure) {
                                        throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                                    } else {
                                        if (success instanceof KApiResponse.ServiceUnavailable) {
                                            throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<com.bilibili.biligame.kntr.common.bean.KBiligamePage<kntr.app.game.bean.SteamDetailGameItem>>");
                            } catch (Exception e) {
                                e = e;
                                KLog_androidKt.getKLog().e("SteamDetailVM", "requestGameList reportExposure error", e);
                                return null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            KLog_androidKt.getKLog().e("SteamDetailVM", "requestGameList reportExposure error", e);
                            return null;
                        }
                    case 1:
                        int i = steamDetailVM$requestGameList$12.I$5;
                        int i2 = steamDetailVM$requestGameList$12.I$4;
                        int i3 = steamDetailVM$requestGameList$12.I$3;
                        int i4 = steamDetailVM$requestGameList$12.I$2;
                        int i5 = steamDetailVM$requestGameList$12.I$1;
                        int page3 = steamDetailVM$requestGameList$12.I$0;
                        HttpClient httpClient = (HttpClient) steamDetailVM$requestGameList$12.L$9;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) steamDetailVM$requestGameList$12.L$8;
                        HttpClient httpClient2 = (HttpClient) steamDetailVM$requestGameList$12.L$7;
                        HttpClient httpClient3 = (HttpClient) steamDetailVM$requestGameList$12.L$6;
                        Url url3 = (Url) steamDetailVM$requestGameList$12.L$5;
                        HttpClient httpClient4 = (HttpClient) steamDetailVM$requestGameList$12.L$4;
                        Map map = (Map) steamDetailVM$requestGameList$12.L$3;
                        Url url4 = (Url) steamDetailVM$requestGameList$12.L$2;
                        HttpClient httpClient5 = (HttpClient) steamDetailVM$requestGameList$12.L$1;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        obj = coroutine_suspended;
                        page2 = page3;
                        url = (Url) steamDetailVM$requestGameList$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(KBiligamePage.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SteamDetailGameItem.class)))));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        steamDetailVM$requestGameList$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        steamDetailVM$requestGameList$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamDetailVM$requestGameList$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        steamDetailVM$requestGameList$12.L$3 = null;
                        steamDetailVM$requestGameList$12.L$4 = null;
                        steamDetailVM$requestGameList$12.L$5 = null;
                        steamDetailVM$requestGameList$12.L$6 = null;
                        steamDetailVM$requestGameList$12.L$7 = null;
                        steamDetailVM$requestGameList$12.L$8 = null;
                        steamDetailVM$requestGameList$12.L$9 = null;
                        steamDetailVM$requestGameList$12.I$0 = page2;
                        steamDetailVM$requestGameList$12.I$1 = 0;
                        steamDetailVM$requestGameList$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, steamDetailVM$requestGameList$12);
                        if (bodyNullable != obj) {
                        }
                        break;
                    case 2:
                        int i6 = steamDetailVM$requestGameList$12.I$1;
                        int i7 = steamDetailVM$requestGameList$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) steamDetailVM$requestGameList$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) steamDetailVM$requestGameList$12.L$1;
                        Url url5 = (Url) steamDetailVM$requestGameList$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            if (bodyNullable == null) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            KLog_androidKt.getKLog().e("SteamDetailVM", "requestGameList reportExposure error", e);
                            return null;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamDetailVM$requestGameList$1 = new SteamDetailVM$requestGameList$1(this, continuation);
        steamDetailVM$requestGameList$12 = steamDetailVM$requestGameList$1;
        Object $result2 = steamDetailVM$requestGameList$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamDetailVM$requestGameList$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshInfo(Continuation<? super SteamDetailPageData> continuation) {
        SteamDetailVM$refreshInfo$1 steamDetailVM$refreshInfo$1;
        Exception e;
        SteamDetailPageData data;
        Object requestProfile;
        if (continuation instanceof SteamDetailVM$refreshInfo$1) {
            steamDetailVM$refreshInfo$1 = (SteamDetailVM$refreshInfo$1) continuation;
            if ((steamDetailVM$refreshInfo$1.label & Integer.MIN_VALUE) != 0) {
                steamDetailVM$refreshInfo$1.label -= Integer.MIN_VALUE;
                Object $result = steamDetailVM$refreshInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (steamDetailVM$refreshInfo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            steamDetailVM$refreshInfo$1.label = 1;
                            requestProfile = requestProfile(true, steamDetailVM$refreshInfo$1);
                            if (requestProfile == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            data = null;
                            SteamDetailPageData data2 = (SteamDetailPageData) requestProfile;
                            return data2;
                        } catch (Exception e2) {
                            e = e2;
                            data = null;
                            KLog_androidKt.getKLog().e("SteamDetailVM", "refreshInfo error", e);
                            return data;
                        }
                    case 1:
                        data = null;
                        try {
                            ResultKt.throwOnFailure($result);
                            requestProfile = $result;
                            SteamDetailPageData data22 = (SteamDetailPageData) requestProfile;
                            return data22;
                        } catch (Exception e3) {
                            e = e3;
                            KLog_androidKt.getKLog().e("SteamDetailVM", "refreshInfo error", e);
                            return data;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        steamDetailVM$refreshInfo$1 = new SteamDetailVM$refreshInfo$1(this, continuation);
        Object $result2 = steamDetailVM$refreshInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (steamDetailVM$refreshInfo$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public SteamDetailPageData mergeData(SteamDetailPageData old, SteamDetailPageData steamDetailPageData) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(steamDetailPageData, "new");
        List<SteamDetailGameItem> list = old.getList();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<SteamDetailGameItem> list2 = list;
        List<SteamDetailGameItem> list3 = steamDetailPageData.getList();
        if (list3 == null) {
            list3 = CollectionsKt.emptyList();
        }
        old.setList(CollectionsKt.plus(list2, list3));
        return old;
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(SteamDetailPageData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.fisrtLoad) {
            this.fisrtLoad = false;
            return false;
        }
        List<SteamDetailGameItem> list = data.getList();
        return list == null || list.isEmpty();
    }

    public final String getDispatchSortTypeEventName() {
        return this.dispatchSortTypeEventName;
    }

    public final Object dispatchSortType(SteamGameListSortType type, Continuation<? super Unit> continuation) {
        Object dispatch = dispatch((PageEvent) new PageEvent.Custom(this.dispatchSortTypeEventName, type), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public final String getRefreshSteamDataEventName() {
        return this.refreshSteamDataEventName;
    }

    public final Object refreshSteamData(Continuation<? super Unit> continuation) {
        Object dispatch = dispatch((PageEvent) new PageEvent.Custom(this.refreshSteamDataEventName, null, 2, null), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    protected void customContentBlock(InStateBuilderBlock<PageState.Content<SteamDetailPageData>, PageState, PageEvent> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new SteamDetailVM$customContentBlock$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(PageEvent.class), executionPolicy$iv, handler$iv);
    }
}