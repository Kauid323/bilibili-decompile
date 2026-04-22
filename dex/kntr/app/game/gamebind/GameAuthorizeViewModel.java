package kntr.app.game.gamebind;

import androidx.lifecycle.ViewModel;
import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.bilibili.biligame.kntr.common.api.BiligameHttpClientKt;
import com.bilibili.biligame.kntr.common.api.BiligameUrlBuilderKt;
import com.bilibili.ktor.KApiResponse;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
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
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.gamebind.AuthorizeAction;
import kntr.app.game.gamebind.AuthorizeEvent;
import kntr.app.game.gamebind.bean.AuthorizeInfo;
import kntr.app.game.gamebind.bean.AuthorizeParams;
import kntr.app.game.gamebind.bean.BindResult;
import kntr.app.game.gamebind.bean.TokenlinkData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010\u001dJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020&H\u0082@¢\u0006\u0002\u0010\u001dJ\u000e\u0010'\u001a\u00020!H\u0082@¢\u0006\u0002\u0010\u001dJ\u001c\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010)H\u0002J\b\u0010-\u001a\u00020)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u0013¨\u0006."}, d2 = {"Lkntr/app/game/gamebind/GameAuthorizeViewModel;", "Landroidx/lifecycle/ViewModel;", "authorizeParams", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "<init>", "(Lkntr/app/game/gamebind/bean/AuthorizeParams;)V", ReportBuildInParam.MACHINE, "Lkntr/base/udf/StoreMachine;", "Lkntr/app/game/base/viewmodel/PageState;", "Lkntr/app/game/gamebind/AuthorizeEvent;", "getMachine$annotations", "()V", "actionMachine", "Lkntr/app/game/gamebind/AuthorizeAction;", "getActionMachine$annotations", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "action", "getAction$annotations", "getAction", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "event", "(Lkntr/app/game/gamebind/AuthorizeEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startLoad", "Lkntr/app/game/gamebind/bean/AuthorizeInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "realBind", "Lkntr/app/game/gamebind/bean/BindResult;", "authorize", RoomRecommendViewModel.EMPTY_CURSOR, "isAll", "authorizeInfo", "(ZLkntr/app/game/gamebind/bean/AuthorizeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTokenLink", "Lkntr/app/game/gamebind/bean/TokenlinkData;", "checkBind", "mapCodeToMessage", RoomRecommendViewModel.EMPTY_CURSOR, "code", RoomRecommendViewModel.EMPTY_CURSOR, "message", "bindSuccessToast", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameAuthorizeViewModel extends ViewModel {
    private final Flow<AuthorizeAction> action;
    private final StoreMachine<AuthorizeAction, AuthorizeEvent> actionMachine;
    private final AuthorizeParams authorizeParams;
    private final StoreMachine<PageState, AuthorizeEvent> machine;
    private final Flow<PageState> state;

    public static /* synthetic */ void getAction$annotations() {
    }

    private static /* synthetic */ void getActionMachine$annotations() {
    }

    private static /* synthetic */ void getMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public GameAuthorizeViewModel(AuthorizeParams authorizeParams) {
        PageState.Loading initialState$iv;
        Intrinsics.checkNotNullParameter(authorizeParams, "authorizeParams");
        this.authorizeParams = authorizeParams;
        StoreMachine.Companion companion = StoreMachine.Companion;
        if (this.authorizeParams.getAuthStatus() == 0 || this.authorizeParams.getOnlyAuth()) {
            initialState$iv = PageState.Loading.INSTANCE;
        } else {
            initialState$iv = PageState.Initialize.INSTANCE;
        }
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = GameAuthorizeViewModel.machine$lambda$0(GameAuthorizeViewModel.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        StoreMachine.Companion companion2 = StoreMachine.Companion;
        Object initialState$iv2 = AuthorizeAction.Nothing.INSTANCE;
        Function1 specBlock$iv2 = new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit actionMachine$lambda$0;
                actionMachine$lambda$0 = GameAuthorizeViewModel.actionMachine$lambda$0(GameAuthorizeViewModel.this, (FlowReduxStoreBuilder) obj);
                return actionMachine$lambda$0;
            }
        };
        this.actionMachine = new StoreMachine<>(initialState$iv2, specBlock$iv2);
        this.state = this.machine.getState();
        this.action = this.actionMachine.getState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final GameAuthorizeViewModel this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = GameAuthorizeViewModel.machine$lambda$0$0(GameAuthorizeViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(PageState.Loading.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(GameAuthorizeViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new GameAuthorizeViewModel$machine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit actionMachine$lambda$0(final GameAuthorizeViewModel this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit actionMachine$lambda$0$0;
                actionMachine$lambda$0$0 = GameAuthorizeViewModel.actionMachine$lambda$0$0(GameAuthorizeViewModel.this, (InStateBuilderBlock) obj);
                return actionMachine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(AuthorizeAction.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit actionMachine$lambda$0$0(GameAuthorizeViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new GameAuthorizeViewModel$actionMachine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AuthorizeEvent.Bind.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new GameAuthorizeViewModel$actionMachine$1$1$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(AuthorizeEvent.Close.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new GameAuthorizeViewModel$actionMachine$1$1$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(AuthorizeEvent.CheckBind.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new GameAuthorizeViewModel$actionMachine$1$1$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(AuthorizeEvent.NotifyNoRoleInfo.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new GameAuthorizeViewModel$actionMachine$1$1$5(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(AuthorizeEvent.Bound.class), executionPolicy$iv5, handler$iv5);
        return Unit.INSTANCE;
    }

    public final Flow<PageState> getState() {
        return this.state;
    }

    public final Flow<AuthorizeAction> getAction() {
        return this.action;
    }

    public final Object dispatch(AuthorizeEvent event, Continuation<? super Unit> continuation) {
        Object dispatch = this.actionMachine.dispatch(event, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startLoad(Continuation<? super AuthorizeInfo> continuation) {
        GameAuthorizeViewModel$startLoad$1 gameAuthorizeViewModel$startLoad$1;
        GameAuthorizeViewModel$startLoad$1 gameAuthorizeViewModel$startLoad$12;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof GameAuthorizeViewModel$startLoad$1) {
            gameAuthorizeViewModel$startLoad$1 = (GameAuthorizeViewModel$startLoad$1) continuation;
            if ((gameAuthorizeViewModel$startLoad$1.label & Integer.MIN_VALUE) != 0) {
                gameAuthorizeViewModel$startLoad$1.label -= Integer.MIN_VALUE;
                gameAuthorizeViewModel$startLoad$12 = gameAuthorizeViewModel$startLoad$1;
                Object $result = gameAuthorizeViewModel$startLoad$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameAuthorizeViewModel$startLoad$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl("/game/center/h5/role_bind/check_bind_and_query_agreement", MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", this.authorizeParams.getGameBaseId()), TuplesKt.to("distributor_channel_id", String.valueOf(this.authorizeParams.getDistributorChannelId()))}));
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        gameAuthorizeViewModel$startLoad$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$startLoad$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$startLoad$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$startLoad$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$startLoad$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$startLoad$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        gameAuthorizeViewModel$startLoad$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$startLoad$12.I$0 = 0;
                        gameAuthorizeViewModel$startLoad$12.I$1 = 0;
                        gameAuthorizeViewModel$startLoad$12.I$2 = 0;
                        gameAuthorizeViewModel$startLoad$12.I$3 = 0;
                        gameAuthorizeViewModel$startLoad$12.label = 1;
                        execute = httpStatement.execute(gameAuthorizeViewModel$startLoad$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(AuthorizeInfo.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        gameAuthorizeViewModel$startLoad$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$startLoad$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$startLoad$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$startLoad$12.L$3 = null;
                        gameAuthorizeViewModel$startLoad$12.L$4 = null;
                        gameAuthorizeViewModel$startLoad$12.L$5 = null;
                        gameAuthorizeViewModel$startLoad$12.L$6 = null;
                        gameAuthorizeViewModel$startLoad$12.I$0 = 0;
                        gameAuthorizeViewModel$startLoad$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, gameAuthorizeViewModel$startLoad$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (AuthorizeInfo) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.AuthorizeInfo>");
                    case 1:
                        int $i$f$body = gameAuthorizeViewModel$startLoad$12.I$3;
                        int i = gameAuthorizeViewModel$startLoad$12.I$2;
                        int i2 = gameAuthorizeViewModel$startLoad$12.I$1;
                        int i3 = gameAuthorizeViewModel$startLoad$12.I$0;
                        HttpClient httpClient = (HttpClient) gameAuthorizeViewModel$startLoad$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) gameAuthorizeViewModel$startLoad$12.L$5;
                        HttpClient httpClient2 = (HttpClient) gameAuthorizeViewModel$startLoad$12.L$4;
                        HttpClient httpClient3 = (HttpClient) gameAuthorizeViewModel$startLoad$12.L$3;
                        Url url3 = (Url) gameAuthorizeViewModel$startLoad$12.L$2;
                        HttpClient httpClient4 = (HttpClient) gameAuthorizeViewModel$startLoad$12.L$1;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        url = (Url) gameAuthorizeViewModel$startLoad$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(AuthorizeInfo.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        gameAuthorizeViewModel$startLoad$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$startLoad$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$startLoad$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$startLoad$12.L$3 = null;
                        gameAuthorizeViewModel$startLoad$12.L$4 = null;
                        gameAuthorizeViewModel$startLoad$12.L$5 = null;
                        gameAuthorizeViewModel$startLoad$12.L$6 = null;
                        gameAuthorizeViewModel$startLoad$12.I$0 = 0;
                        gameAuthorizeViewModel$startLoad$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, gameAuthorizeViewModel$startLoad$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = gameAuthorizeViewModel$startLoad$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) gameAuthorizeViewModel$startLoad$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) gameAuthorizeViewModel$startLoad$12.L$1;
                        Url url4 = (Url) gameAuthorizeViewModel$startLoad$12.L$0;
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
        gameAuthorizeViewModel$startLoad$1 = new GameAuthorizeViewModel$startLoad$1(this, continuation);
        gameAuthorizeViewModel$startLoad$12 = gameAuthorizeViewModel$startLoad$1;
        Object $result2 = gameAuthorizeViewModel$startLoad$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameAuthorizeViewModel$startLoad$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0300  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object realBind(Continuation<? super BindResult> continuation) {
        GameAuthorizeViewModel$realBind$1 gameAuthorizeViewModel$realBind$1;
        GameAuthorizeViewModel$realBind$1 gameAuthorizeViewModel$realBind$12;
        KType kType;
        Object execute;
        Object obj;
        Url url;
        KType kType2;
        boolean z;
        KType kType3;
        Object bodyNullable;
        if (continuation instanceof GameAuthorizeViewModel$realBind$1) {
            gameAuthorizeViewModel$realBind$1 = (GameAuthorizeViewModel$realBind$1) continuation;
            if ((gameAuthorizeViewModel$realBind$1.label & Integer.MIN_VALUE) != 0) {
                gameAuthorizeViewModel$realBind$1.label -= Integer.MIN_VALUE;
                gameAuthorizeViewModel$realBind$12 = gameAuthorizeViewModel$realBind$1;
                Object $result = gameAuthorizeViewModel$realBind$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameAuthorizeViewModel$realBind$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("/game/center/h5/role_bind/bind", (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Map params$iv = MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", this.authorizeParams.getGameBaseId()), TuplesKt.to("distributor_channel_id", String.valueOf(this.authorizeParams.getDistributorChannelId()))});
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
                        gameAuthorizeViewModel$realBind$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$realBind$12.L$1 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$realBind$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$realBind$12.L$3 = SpillingKt.nullOutSpilledVariable(params$iv);
                        gameAuthorizeViewModel$realBind$12.L$4 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$realBind$12.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$realBind$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$realBind$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$realBind$12.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        gameAuthorizeViewModel$realBind$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$realBind$12.I$0 = 0;
                        gameAuthorizeViewModel$realBind$12.I$1 = 0;
                        gameAuthorizeViewModel$realBind$12.I$2 = 0;
                        gameAuthorizeViewModel$realBind$12.I$3 = 0;
                        gameAuthorizeViewModel$realBind$12.I$4 = 0;
                        gameAuthorizeViewModel$realBind$12.label = 1;
                        execute = httpStatement.execute(gameAuthorizeViewModel$realBind$12);
                        obj = coroutine_suspended;
                        if (execute == obj) {
                            return obj;
                        }
                        url = url2;
                        HttpResponse $this$body$iv = (HttpResponse) execute;
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BindResult.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        gameAuthorizeViewModel$realBind$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$realBind$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        gameAuthorizeViewModel$realBind$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        gameAuthorizeViewModel$realBind$12.L$3 = null;
                        gameAuthorizeViewModel$realBind$12.L$4 = null;
                        gameAuthorizeViewModel$realBind$12.L$5 = null;
                        gameAuthorizeViewModel$realBind$12.L$6 = null;
                        gameAuthorizeViewModel$realBind$12.L$7 = null;
                        gameAuthorizeViewModel$realBind$12.L$8 = null;
                        gameAuthorizeViewModel$realBind$12.L$9 = null;
                        gameAuthorizeViewModel$realBind$12.I$0 = 0;
                        gameAuthorizeViewModel$realBind$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, gameAuthorizeViewModel$realBind$12);
                        if (bodyNullable != obj) {
                            return obj;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (BindResult) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.BindResult>");
                    case 1:
                        int $i$f$body = gameAuthorizeViewModel$realBind$12.I$4;
                        int i = gameAuthorizeViewModel$realBind$12.I$3;
                        int i2 = gameAuthorizeViewModel$realBind$12.I$2;
                        int i3 = gameAuthorizeViewModel$realBind$12.I$1;
                        int i4 = gameAuthorizeViewModel$realBind$12.I$0;
                        HttpClient httpClient = (HttpClient) gameAuthorizeViewModel$realBind$12.L$9;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) gameAuthorizeViewModel$realBind$12.L$8;
                        HttpClient httpClient2 = (HttpClient) gameAuthorizeViewModel$realBind$12.L$7;
                        HttpClient httpClient3 = (HttpClient) gameAuthorizeViewModel$realBind$12.L$6;
                        Url url3 = (Url) gameAuthorizeViewModel$realBind$12.L$5;
                        HttpClient httpClient4 = (HttpClient) gameAuthorizeViewModel$realBind$12.L$4;
                        Map map = (Map) gameAuthorizeViewModel$realBind$12.L$3;
                        Url url4 = (Url) gameAuthorizeViewModel$realBind$12.L$2;
                        HttpClient httpClient5 = (HttpClient) gameAuthorizeViewModel$realBind$12.L$1;
                        ResultKt.throwOnFailure($result);
                        url = (Url) gameAuthorizeViewModel$realBind$12.L$0;
                        obj = coroutine_suspended;
                        execute = $result;
                        HttpResponse $this$body$iv2 = (HttpResponse) execute;
                        HttpClientCall call2 = $this$body$iv2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(BindResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        gameAuthorizeViewModel$realBind$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$realBind$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        gameAuthorizeViewModel$realBind$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        gameAuthorizeViewModel$realBind$12.L$3 = null;
                        gameAuthorizeViewModel$realBind$12.L$4 = null;
                        gameAuthorizeViewModel$realBind$12.L$5 = null;
                        gameAuthorizeViewModel$realBind$12.L$6 = null;
                        gameAuthorizeViewModel$realBind$12.L$7 = null;
                        gameAuthorizeViewModel$realBind$12.L$8 = null;
                        gameAuthorizeViewModel$realBind$12.L$9 = null;
                        gameAuthorizeViewModel$realBind$12.I$0 = 0;
                        gameAuthorizeViewModel$realBind$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, gameAuthorizeViewModel$realBind$12);
                        if (bodyNullable != obj) {
                        }
                        break;
                    case 2:
                        int i5 = gameAuthorizeViewModel$realBind$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) gameAuthorizeViewModel$realBind$12.L$2;
                        HttpResponse httpResponse2 = (HttpResponse) gameAuthorizeViewModel$realBind$12.L$1;
                        Url url5 = (Url) gameAuthorizeViewModel$realBind$12.L$0;
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
        gameAuthorizeViewModel$realBind$1 = new GameAuthorizeViewModel$realBind$1(this, continuation);
        gameAuthorizeViewModel$realBind$12 = gameAuthorizeViewModel$realBind$1;
        Object $result2 = gameAuthorizeViewModel$realBind$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameAuthorizeViewModel$realBind$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0323 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x036b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object authorize(boolean isAll, AuthorizeInfo authorizeInfo, Continuation<? super Boolean> continuation) {
        GameAuthorizeViewModel$authorize$1 gameAuthorizeViewModel$authorize$1;
        GameAuthorizeViewModel$authorize$1 gameAuthorizeViewModel$authorize$12;
        Object obj;
        KType kType;
        Object obj2;
        Url url;
        AuthorizeInfo authorizeInfo2;
        boolean isAll2;
        KType kType2;
        boolean z;
        KType kType3;
        Object bodyNullable;
        if (continuation instanceof GameAuthorizeViewModel$authorize$1) {
            gameAuthorizeViewModel$authorize$1 = (GameAuthorizeViewModel$authorize$1) continuation;
            if ((gameAuthorizeViewModel$authorize$1.label & Integer.MIN_VALUE) != 0) {
                gameAuthorizeViewModel$authorize$1.label -= Integer.MIN_VALUE;
                gameAuthorizeViewModel$authorize$12 = gameAuthorizeViewModel$authorize$1;
                Object $result = gameAuthorizeViewModel$authorize$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameAuthorizeViewModel$authorize$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("/game/center/h5/user/authorization/edit", (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Pair[] pairArr = new Pair[6];
                        pairArr[0] = TuplesKt.to("scene", String.valueOf(authorizeInfo.getScene()));
                        pairArr[1] = TuplesKt.to("game_base_id", this.authorizeParams.getGameBaseId());
                        pairArr[2] = TuplesKt.to("auth_type", isAll ? "1" : AdSearchSubCardType.CARD_TYPE_2);
                        pairArr[3] = TuplesKt.to(AdAlarmExtraKey.STATUS, "1");
                        pairArr[4] = TuplesKt.to("distributor_channel_id", String.valueOf(authorizeInfo.getDistributorChannelId()));
                        pairArr[5] = TuplesKt.to("agreement_version_id", String.valueOf(authorizeInfo.getVersionId()));
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
                            obj = coroutine_suspended;
                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                        } else {
                            obj = coroutine_suspended;
                            if (body$iv$iv instanceof OutgoingContent) {
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
                        }
                        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$authorize$12.L$0 = SpillingKt.nullOutSpilledVariable(authorizeInfo);
                        gameAuthorizeViewModel$authorize$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$authorize$12.L$2 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$authorize$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$authorize$12.L$4 = SpillingKt.nullOutSpilledVariable(params$iv);
                        gameAuthorizeViewModel$authorize$12.L$5 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$authorize$12.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$authorize$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$authorize$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$authorize$12.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        gameAuthorizeViewModel$authorize$12.L$10 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        gameAuthorizeViewModel$authorize$12.Z$0 = isAll;
                        gameAuthorizeViewModel$authorize$12.I$0 = 0;
                        gameAuthorizeViewModel$authorize$12.I$1 = 0;
                        gameAuthorizeViewModel$authorize$12.I$2 = 0;
                        gameAuthorizeViewModel$authorize$12.I$3 = 0;
                        gameAuthorizeViewModel$authorize$12.I$4 = 0;
                        gameAuthorizeViewModel$authorize$12.label = 1;
                        Object execute = httpStatement.execute(gameAuthorizeViewModel$authorize$12);
                        obj2 = obj;
                        if (execute == obj2) {
                            return obj2;
                        }
                        url = url2;
                        authorizeInfo2 = authorizeInfo;
                        $result = execute;
                        isAll2 = isAll;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(String.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        gameAuthorizeViewModel$authorize$12.L$0 = SpillingKt.nullOutSpilledVariable(authorizeInfo2);
                        gameAuthorizeViewModel$authorize$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$authorize$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$authorize$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$authorize$12.L$4 = null;
                        gameAuthorizeViewModel$authorize$12.L$5 = null;
                        gameAuthorizeViewModel$authorize$12.L$6 = null;
                        gameAuthorizeViewModel$authorize$12.L$7 = null;
                        gameAuthorizeViewModel$authorize$12.L$8 = null;
                        gameAuthorizeViewModel$authorize$12.L$9 = null;
                        gameAuthorizeViewModel$authorize$12.L$10 = null;
                        gameAuthorizeViewModel$authorize$12.Z$0 = isAll2;
                        gameAuthorizeViewModel$authorize$12.I$0 = 0;
                        gameAuthorizeViewModel$authorize$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, gameAuthorizeViewModel$authorize$12);
                        if (bodyNullable != obj2) {
                            return obj2;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.ServiceUnavailable serviceUnavailable = (KApiResponse) bodyNullable;
                            if (serviceUnavailable instanceof KApiResponse.Success) {
                                return Boxing.boxBoolean(true);
                            }
                            if (serviceUnavailable instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) serviceUnavailable).getCode(), ((KApiResponse.BusinessFailure) serviceUnavailable).getMessage());
                            }
                            if (serviceUnavailable instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(serviceUnavailable.getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.String?>");
                    case 1:
                        int $i$f$body = gameAuthorizeViewModel$authorize$12.I$4;
                        int i = gameAuthorizeViewModel$authorize$12.I$3;
                        int i2 = gameAuthorizeViewModel$authorize$12.I$2;
                        int i3 = gameAuthorizeViewModel$authorize$12.I$1;
                        int i4 = gameAuthorizeViewModel$authorize$12.I$0;
                        boolean isAll3 = gameAuthorizeViewModel$authorize$12.Z$0;
                        HttpClient httpClient = (HttpClient) gameAuthorizeViewModel$authorize$12.L$10;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) gameAuthorizeViewModel$authorize$12.L$9;
                        HttpClient httpClient2 = (HttpClient) gameAuthorizeViewModel$authorize$12.L$8;
                        HttpClient httpClient3 = (HttpClient) gameAuthorizeViewModel$authorize$12.L$7;
                        Url url3 = (Url) gameAuthorizeViewModel$authorize$12.L$6;
                        HttpClient httpClient4 = (HttpClient) gameAuthorizeViewModel$authorize$12.L$5;
                        Map map = (Map) gameAuthorizeViewModel$authorize$12.L$4;
                        Url url4 = (Url) gameAuthorizeViewModel$authorize$12.L$3;
                        HttpClient httpClient5 = (HttpClient) gameAuthorizeViewModel$authorize$12.L$2;
                        url = (Url) gameAuthorizeViewModel$authorize$12.L$1;
                        ResultKt.throwOnFailure($result);
                        authorizeInfo2 = (AuthorizeInfo) gameAuthorizeViewModel$authorize$12.L$0;
                        isAll2 = isAll3;
                        obj2 = coroutine_suspended;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(String.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        gameAuthorizeViewModel$authorize$12.L$0 = SpillingKt.nullOutSpilledVariable(authorizeInfo2);
                        gameAuthorizeViewModel$authorize$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$authorize$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$authorize$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$authorize$12.L$4 = null;
                        gameAuthorizeViewModel$authorize$12.L$5 = null;
                        gameAuthorizeViewModel$authorize$12.L$6 = null;
                        gameAuthorizeViewModel$authorize$12.L$7 = null;
                        gameAuthorizeViewModel$authorize$12.L$8 = null;
                        gameAuthorizeViewModel$authorize$12.L$9 = null;
                        gameAuthorizeViewModel$authorize$12.L$10 = null;
                        gameAuthorizeViewModel$authorize$12.Z$0 = isAll2;
                        gameAuthorizeViewModel$authorize$12.I$0 = 0;
                        gameAuthorizeViewModel$authorize$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, gameAuthorizeViewModel$authorize$12);
                        if (bodyNullable != obj2) {
                        }
                        break;
                    case 2:
                        int i5 = gameAuthorizeViewModel$authorize$12.I$0;
                        boolean z4 = gameAuthorizeViewModel$authorize$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) gameAuthorizeViewModel$authorize$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) gameAuthorizeViewModel$authorize$12.L$2;
                        Url url5 = (Url) gameAuthorizeViewModel$authorize$12.L$1;
                        AuthorizeInfo authorizeInfo3 = (AuthorizeInfo) gameAuthorizeViewModel$authorize$12.L$0;
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
        gameAuthorizeViewModel$authorize$1 = new GameAuthorizeViewModel$authorize$1(this, continuation);
        gameAuthorizeViewModel$authorize$12 = gameAuthorizeViewModel$authorize$1;
        Object $result2 = gameAuthorizeViewModel$authorize$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameAuthorizeViewModel$authorize$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getTokenLink(Continuation<? super TokenlinkData> continuation) {
        GameAuthorizeViewModel$getTokenLink$1 gameAuthorizeViewModel$getTokenLink$1;
        GameAuthorizeViewModel$getTokenLink$1 gameAuthorizeViewModel$getTokenLink$12;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof GameAuthorizeViewModel$getTokenLink$1) {
            gameAuthorizeViewModel$getTokenLink$1 = (GameAuthorizeViewModel$getTokenLink$1) continuation;
            if ((gameAuthorizeViewModel$getTokenLink$1.label & Integer.MIN_VALUE) != 0) {
                gameAuthorizeViewModel$getTokenLink$1.label -= Integer.MIN_VALUE;
                gameAuthorizeViewModel$getTokenLink$12 = gameAuthorizeViewModel$getTokenLink$1;
                Object $result = gameAuthorizeViewModel$getTokenLink$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameAuthorizeViewModel$getTokenLink$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl("/game/center/h5/role_bind/query_pre_info", MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", this.authorizeParams.getGameBaseId()), TuplesKt.to("distributor_channel_id", String.valueOf(this.authorizeParams.getDistributorChannelId())), TuplesKt.to("current_page", "bilibili://game_center/role_bind_auth")}));
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        gameAuthorizeViewModel$getTokenLink$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$getTokenLink$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$getTokenLink$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$getTokenLink$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$getTokenLink$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$getTokenLink$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        gameAuthorizeViewModel$getTokenLink$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$getTokenLink$12.I$0 = 0;
                        gameAuthorizeViewModel$getTokenLink$12.I$1 = 0;
                        gameAuthorizeViewModel$getTokenLink$12.I$2 = 0;
                        gameAuthorizeViewModel$getTokenLink$12.I$3 = 0;
                        gameAuthorizeViewModel$getTokenLink$12.label = 1;
                        execute = httpStatement.execute(gameAuthorizeViewModel$getTokenLink$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TokenlinkData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        gameAuthorizeViewModel$getTokenLink$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$getTokenLink$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$getTokenLink$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$getTokenLink$12.L$3 = null;
                        gameAuthorizeViewModel$getTokenLink$12.L$4 = null;
                        gameAuthorizeViewModel$getTokenLink$12.L$5 = null;
                        gameAuthorizeViewModel$getTokenLink$12.L$6 = null;
                        gameAuthorizeViewModel$getTokenLink$12.I$0 = 0;
                        gameAuthorizeViewModel$getTokenLink$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, gameAuthorizeViewModel$getTokenLink$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (TokenlinkData) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.TokenlinkData>");
                    case 1:
                        int $i$f$body = gameAuthorizeViewModel$getTokenLink$12.I$3;
                        int i = gameAuthorizeViewModel$getTokenLink$12.I$2;
                        int i2 = gameAuthorizeViewModel$getTokenLink$12.I$1;
                        int i3 = gameAuthorizeViewModel$getTokenLink$12.I$0;
                        HttpClient httpClient = (HttpClient) gameAuthorizeViewModel$getTokenLink$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) gameAuthorizeViewModel$getTokenLink$12.L$5;
                        HttpClient httpClient2 = (HttpClient) gameAuthorizeViewModel$getTokenLink$12.L$4;
                        HttpClient httpClient3 = (HttpClient) gameAuthorizeViewModel$getTokenLink$12.L$3;
                        Url url3 = (Url) gameAuthorizeViewModel$getTokenLink$12.L$2;
                        HttpClient httpClient4 = (HttpClient) gameAuthorizeViewModel$getTokenLink$12.L$1;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        url = (Url) gameAuthorizeViewModel$getTokenLink$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TokenlinkData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        gameAuthorizeViewModel$getTokenLink$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$getTokenLink$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$getTokenLink$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$getTokenLink$12.L$3 = null;
                        gameAuthorizeViewModel$getTokenLink$12.L$4 = null;
                        gameAuthorizeViewModel$getTokenLink$12.L$5 = null;
                        gameAuthorizeViewModel$getTokenLink$12.L$6 = null;
                        gameAuthorizeViewModel$getTokenLink$12.I$0 = 0;
                        gameAuthorizeViewModel$getTokenLink$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, gameAuthorizeViewModel$getTokenLink$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = gameAuthorizeViewModel$getTokenLink$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) gameAuthorizeViewModel$getTokenLink$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) gameAuthorizeViewModel$getTokenLink$12.L$1;
                        Url url4 = (Url) gameAuthorizeViewModel$getTokenLink$12.L$0;
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
        gameAuthorizeViewModel$getTokenLink$1 = new GameAuthorizeViewModel$getTokenLink$1(this, continuation);
        gameAuthorizeViewModel$getTokenLink$12 = gameAuthorizeViewModel$getTokenLink$1;
        Object $result2 = gameAuthorizeViewModel$getTokenLink$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameAuthorizeViewModel$getTokenLink$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkBind(Continuation<? super Boolean> continuation) {
        GameAuthorizeViewModel$checkBind$1 gameAuthorizeViewModel$checkBind$1;
        GameAuthorizeViewModel$checkBind$1 gameAuthorizeViewModel$checkBind$12;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        boolean z;
        if (continuation instanceof GameAuthorizeViewModel$checkBind$1) {
            gameAuthorizeViewModel$checkBind$1 = (GameAuthorizeViewModel$checkBind$1) continuation;
            if ((gameAuthorizeViewModel$checkBind$1.label & Integer.MIN_VALUE) != 0) {
                gameAuthorizeViewModel$checkBind$1.label -= Integer.MIN_VALUE;
                gameAuthorizeViewModel$checkBind$12 = gameAuthorizeViewModel$checkBind$1;
                Object $result = gameAuthorizeViewModel$checkBind$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameAuthorizeViewModel$checkBind$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl("/game/center/h5/role_bind/check_bind", MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", this.authorizeParams.getGameBaseId()), TuplesKt.to("distributor_channel_id", String.valueOf(this.authorizeParams.getDistributorChannelId()))}));
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder $this$get_u24lambda_u240$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom($this$get_u24lambda_u240$iv.getUrl(), url2);
                        $this$get_u24lambda_u240$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u240$iv, $this$get_u24default$iv);
                        gameAuthorizeViewModel$checkBind$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$checkBind$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$checkBind$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        gameAuthorizeViewModel$checkBind$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$checkBind$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$checkBind$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u240$iv);
                        gameAuthorizeViewModel$checkBind$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        gameAuthorizeViewModel$checkBind$12.I$0 = 0;
                        gameAuthorizeViewModel$checkBind$12.I$1 = 0;
                        gameAuthorizeViewModel$checkBind$12.I$2 = 0;
                        gameAuthorizeViewModel$checkBind$12.I$3 = 0;
                        gameAuthorizeViewModel$checkBind$12.label = 1;
                        execute = httpStatement.execute(gameAuthorizeViewModel$checkBind$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TokenlinkData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        gameAuthorizeViewModel$checkBind$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$checkBind$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$checkBind$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        gameAuthorizeViewModel$checkBind$12.L$3 = null;
                        gameAuthorizeViewModel$checkBind$12.L$4 = null;
                        gameAuthorizeViewModel$checkBind$12.L$5 = null;
                        gameAuthorizeViewModel$checkBind$12.L$6 = null;
                        gameAuthorizeViewModel$checkBind$12.I$0 = 0;
                        gameAuthorizeViewModel$checkBind$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, gameAuthorizeViewModel$checkBind$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                z = ((TokenlinkData) success.getData()).getBind();
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                z = false;
                            } else if (!(success instanceof KApiResponse.ServiceUnavailable)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                z = false;
                            }
                            return Boxing.boxBoolean(z);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.TokenlinkData>");
                    case 1:
                        int $i$f$body = gameAuthorizeViewModel$checkBind$12.I$3;
                        int i = gameAuthorizeViewModel$checkBind$12.I$2;
                        int i2 = gameAuthorizeViewModel$checkBind$12.I$1;
                        int i3 = gameAuthorizeViewModel$checkBind$12.I$0;
                        HttpClient httpClient = (HttpClient) gameAuthorizeViewModel$checkBind$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) gameAuthorizeViewModel$checkBind$12.L$5;
                        HttpClient httpClient2 = (HttpClient) gameAuthorizeViewModel$checkBind$12.L$4;
                        HttpClient httpClient3 = (HttpClient) gameAuthorizeViewModel$checkBind$12.L$3;
                        Url url3 = (Url) gameAuthorizeViewModel$checkBind$12.L$2;
                        HttpClient httpClient4 = (HttpClient) gameAuthorizeViewModel$checkBind$12.L$1;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        url = (Url) gameAuthorizeViewModel$checkBind$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TokenlinkData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        gameAuthorizeViewModel$checkBind$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        gameAuthorizeViewModel$checkBind$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$checkBind$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        gameAuthorizeViewModel$checkBind$12.L$3 = null;
                        gameAuthorizeViewModel$checkBind$12.L$4 = null;
                        gameAuthorizeViewModel$checkBind$12.L$5 = null;
                        gameAuthorizeViewModel$checkBind$12.L$6 = null;
                        gameAuthorizeViewModel$checkBind$12.I$0 = 0;
                        gameAuthorizeViewModel$checkBind$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, gameAuthorizeViewModel$checkBind$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = gameAuthorizeViewModel$checkBind$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) gameAuthorizeViewModel$checkBind$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) gameAuthorizeViewModel$checkBind$12.L$1;
                        Url url4 = (Url) gameAuthorizeViewModel$checkBind$12.L$0;
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
        gameAuthorizeViewModel$checkBind$1 = new GameAuthorizeViewModel$checkBind$1(this, continuation);
        gameAuthorizeViewModel$checkBind$12 = gameAuthorizeViewModel$checkBind$1;
        Object $result2 = gameAuthorizeViewModel$checkBind$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameAuthorizeViewModel$checkBind$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String mapCodeToMessage$default(GameAuthorizeViewModel gameAuthorizeViewModel, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return gameAuthorizeViewModel.mapCodeToMessage(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String mapCodeToMessage(int code, String message) {
        switch (code) {
            case -8009:
            case -8004:
                return "暂未匹配到信息哦~";
            default:
                if (message != null) {
                    String str = !StringsKt.isBlank(message) ? message : null;
                    if (str != null) {
                        return str;
                    }
                }
                return "服务器开小差了，请重试";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String bindSuccessToast() {
        if (this.authorizeParams.getFromRoleList()) {
            return "绑定成功";
        }
        return "绑定成功，可至 我的-游戏角色中管理";
    }
}