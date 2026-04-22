package kntr.app.game.gamebind;

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
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.gamebind.bean.ActionResult;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.RoleMenuItem;
import kntr.app.game.gamebind.bean.RoleMenuItemKt;
import kntr.app.game.gamebind.bean.RolesListData;
import kntr.app.game.gamebind.bean.SectionItem;
import kntr.app.game.gamebind.bean.UnbindRoleItem;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: RolesListViewModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010$J\u001e\u0010&\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010(J\u001e\u0010+\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\nH\u0087@¢\u0006\u0002\u00101R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel;", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "Lkntr/app/game/gamebind/bean/RolesListData;", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "mMenuMachine", "Lkntr/base/udf/StoreMachine;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", "getMMenuMachine$annotations", "()V", "menuState", "Lkotlinx/coroutines/flow/Flow;", "getMenuState$annotations", "getMenuState", "()Lkotlinx/coroutines/flow/Flow;", "toast", "Lkotlinx/coroutines/flow/MutableSharedFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent$annotations", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadData", "refresh", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmpty", "data", "loadMenuList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "roleId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RoleMenuItemKt.MENU_UNBIND, "pinOrUnpin", "isPin", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeVisible", "publicVisible", "switchRole", "sectionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "event", "(Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MenuState", "MenuEvent", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RolesListViewModel extends BaseViewModel<RolesListData> {
    private final StoreMachine<MenuState, MenuEvent> mMenuMachine;
    private final Flow<MenuState> menuState;
    private final long mid;
    private final MutableSharedFlow<String> toast;
    private final SharedFlow<String> toastEvent;

    private static /* synthetic */ void getMMenuMachine$annotations() {
    }

    public static /* synthetic */ void getMenuState$annotations() {
    }

    public static /* synthetic */ void getToastEvent$annotations() {
    }

    public RolesListViewModel(long mid) {
        this.mid = mid;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = MenuState.Initialize.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit mMenuMachine$lambda$0;
                mMenuMachine$lambda$0 = RolesListViewModel.mMenuMachine$lambda$0(RolesListViewModel.this, (FlowReduxStoreBuilder) obj);
                return mMenuMachine$lambda$0;
            }
        };
        this.mMenuMachine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.menuState = this.mMenuMachine.getState();
        this.toast = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 4, (Object) null);
        this.toastEvent = FlowKt.asSharedFlow(this.toast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mMenuMachine$lambda$0(final RolesListViewModel this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit mMenuMachine$lambda$0$0;
                mMenuMachine$lambda$0$0 = RolesListViewModel.mMenuMachine$lambda$0$0(RolesListViewModel.this, (InStateBuilderBlock) obj);
                return mMenuMachine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(MenuState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mMenuMachine$lambda$0$0(RolesListViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new RolesListViewModel$mMenuMachine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(MenuEvent.LoadMenuList.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new RolesListViewModel$mMenuMachine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(MenuEvent.MenuClick.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new RolesListViewModel$mMenuMachine$1$1$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(MenuEvent.HideMenuDialog.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new RolesListViewModel$mMenuMachine$1$1$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(MenuEvent.ServerSwitch.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new RolesListViewModel$mMenuMachine$1$1$5(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(MenuEvent.Unbind.class), executionPolicy$iv5, handler$iv5);
        return Unit.INSTANCE;
    }

    public final Flow<MenuState> getMenuState() {
        return this.menuState;
    }

    public final SharedFlow<String> getToastEvent() {
        return this.toastEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a8  */
    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadData(boolean refresh, Continuation<? super RolesListData> continuation) {
        RolesListViewModel$loadData$1 rolesListViewModel$loadData$1;
        RolesListViewModel$loadData$1 rolesListViewModel$loadData$12;
        boolean refresh2;
        Url url;
        Object execute;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof RolesListViewModel$loadData$1) {
            rolesListViewModel$loadData$1 = (RolesListViewModel$loadData$1) continuation;
            if ((rolesListViewModel$loadData$1.label & Integer.MIN_VALUE) != 0) {
                rolesListViewModel$loadData$1.label -= Integer.MIN_VALUE;
                rolesListViewModel$loadData$12 = rolesListViewModel$loadData$1;
                Object $result = rolesListViewModel$loadData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rolesListViewModel$loadData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl("/game/center/h5/role_bind/query_list", MapsKt.mapOf(TuplesKt.to("owner_mid", String.valueOf(this.mid))));
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        rolesListViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$loadData$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadData$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadData$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        rolesListViewModel$loadData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        refresh2 = refresh;
                        rolesListViewModel$loadData$12.Z$0 = refresh2;
                        rolesListViewModel$loadData$12.I$0 = 0;
                        rolesListViewModel$loadData$12.I$1 = 0;
                        rolesListViewModel$loadData$12.I$2 = 0;
                        rolesListViewModel$loadData$12.I$3 = 0;
                        url = url2;
                        rolesListViewModel$loadData$12.label = 1;
                        execute = httpStatement.execute(rolesListViewModel$loadData$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(RolesListData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        rolesListViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$loadData$12.L$3 = null;
                        rolesListViewModel$loadData$12.L$4 = null;
                        rolesListViewModel$loadData$12.L$5 = null;
                        rolesListViewModel$loadData$12.L$6 = null;
                        rolesListViewModel$loadData$12.Z$0 = refresh2;
                        rolesListViewModel$loadData$12.I$0 = 0;
                        rolesListViewModel$loadData$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, rolesListViewModel$loadData$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                return (RolesListData) success.getData();
                            }
                            if (success instanceof KApiResponse.BusinessFailure) {
                                throw new BiligameApiException(((KApiResponse.BusinessFailure) success).getCode(), ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable(((KApiResponse.ServiceUnavailable) success).getException().getMessage());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.RolesListData>");
                    case 1:
                        int $i$f$body = rolesListViewModel$loadData$12.I$3;
                        int i = rolesListViewModel$loadData$12.I$2;
                        int i2 = rolesListViewModel$loadData$12.I$1;
                        int i3 = rolesListViewModel$loadData$12.I$0;
                        boolean refresh3 = rolesListViewModel$loadData$12.Z$0;
                        HttpClient httpClient = (HttpClient) rolesListViewModel$loadData$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) rolesListViewModel$loadData$12.L$5;
                        HttpClient httpClient2 = (HttpClient) rolesListViewModel$loadData$12.L$4;
                        HttpClient httpClient3 = (HttpClient) rolesListViewModel$loadData$12.L$3;
                        Url url3 = (Url) rolesListViewModel$loadData$12.L$2;
                        HttpClient httpClient4 = (HttpClient) rolesListViewModel$loadData$12.L$1;
                        ResultKt.throwOnFailure($result);
                        url = (Url) rolesListViewModel$loadData$12.L$0;
                        execute = $result;
                        refresh2 = refresh3;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(RolesListData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        rolesListViewModel$loadData$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$loadData$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$loadData$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$loadData$12.L$3 = null;
                        rolesListViewModel$loadData$12.L$4 = null;
                        rolesListViewModel$loadData$12.L$5 = null;
                        rolesListViewModel$loadData$12.L$6 = null;
                        rolesListViewModel$loadData$12.Z$0 = refresh2;
                        rolesListViewModel$loadData$12.I$0 = 0;
                        rolesListViewModel$loadData$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, rolesListViewModel$loadData$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = rolesListViewModel$loadData$12.I$0;
                        boolean z = rolesListViewModel$loadData$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) rolesListViewModel$loadData$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) rolesListViewModel$loadData$12.L$1;
                        Url url4 = (Url) rolesListViewModel$loadData$12.L$0;
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
        rolesListViewModel$loadData$1 = new RolesListViewModel$loadData$1(this, continuation);
        rolesListViewModel$loadData$12 = rolesListViewModel$loadData$1;
        Object $result2 = rolesListViewModel$loadData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rolesListViewModel$loadData$12.label) {
        }
    }

    @Override // kntr.app.game.base.viewmodel.BaseViewModel
    public boolean checkEmpty(RolesListData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<RoleItem> roles = data.getRoles();
        if (roles == null || roles.isEmpty()) {
            List<UnbindRoleItem> gameList = data.getGameList();
            return gameList == null || gameList.isEmpty();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadMenuList(String roleId, Continuation<? super List<RoleMenuItem>> continuation) {
        RolesListViewModel$loadMenuList$1 rolesListViewModel$loadMenuList$1;
        RolesListViewModel$loadMenuList$1 rolesListViewModel$loadMenuList$12;
        String roleId2;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof RolesListViewModel$loadMenuList$1) {
            rolesListViewModel$loadMenuList$1 = (RolesListViewModel$loadMenuList$1) continuation;
            if ((rolesListViewModel$loadMenuList$1.label & Integer.MIN_VALUE) != 0) {
                rolesListViewModel$loadMenuList$1.label -= Integer.MIN_VALUE;
                rolesListViewModel$loadMenuList$12 = rolesListViewModel$loadMenuList$1;
                Object $result = rolesListViewModel$loadMenuList$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rolesListViewModel$loadMenuList$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        roleId2 = roleId;
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl("/game/center/h5/role_bind/query_menu", MapsKt.mapOf(TuplesKt.to("role_bind_id", roleId2)));
                        HttpClient $this$get_u24default$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        rolesListViewModel$loadMenuList$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId);
                        rolesListViewModel$loadMenuList$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$loadMenuList$12.L$2 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadMenuList$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$loadMenuList$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadMenuList$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadMenuList$12.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        rolesListViewModel$loadMenuList$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        rolesListViewModel$loadMenuList$12.I$0 = 0;
                        rolesListViewModel$loadMenuList$12.I$1 = 0;
                        rolesListViewModel$loadMenuList$12.I$2 = 0;
                        rolesListViewModel$loadMenuList$12.I$3 = 0;
                        rolesListViewModel$loadMenuList$12.label = 1;
                        execute = httpStatement.execute(rolesListViewModel$loadMenuList$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(RoleMenuItem.class)))));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        rolesListViewModel$loadMenuList$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$loadMenuList$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$loadMenuList$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$loadMenuList$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$loadMenuList$12.L$4 = null;
                        rolesListViewModel$loadMenuList$12.L$5 = null;
                        rolesListViewModel$loadMenuList$12.L$6 = null;
                        rolesListViewModel$loadMenuList$12.L$7 = null;
                        rolesListViewModel$loadMenuList$12.I$0 = 0;
                        rolesListViewModel$loadMenuList$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, rolesListViewModel$loadMenuList$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                List data = (List) success.getData();
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
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.collections.List<kntr.app.game.gamebind.bean.RoleMenuItem>>");
                    case 1:
                        int $i$f$body = rolesListViewModel$loadMenuList$12.I$3;
                        int i = rolesListViewModel$loadMenuList$12.I$2;
                        int i2 = rolesListViewModel$loadMenuList$12.I$1;
                        int i3 = rolesListViewModel$loadMenuList$12.I$0;
                        HttpClient httpClient = (HttpClient) rolesListViewModel$loadMenuList$12.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) rolesListViewModel$loadMenuList$12.L$6;
                        HttpClient httpClient2 = (HttpClient) rolesListViewModel$loadMenuList$12.L$5;
                        HttpClient httpClient3 = (HttpClient) rolesListViewModel$loadMenuList$12.L$4;
                        Url url3 = (Url) rolesListViewModel$loadMenuList$12.L$3;
                        HttpClient httpClient4 = (HttpClient) rolesListViewModel$loadMenuList$12.L$2;
                        url = (Url) rolesListViewModel$loadMenuList$12.L$1;
                        ResultKt.throwOnFailure($result);
                        roleId2 = (String) rolesListViewModel$loadMenuList$12.L$0;
                        execute = $result;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(RoleMenuItem.class)))));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        rolesListViewModel$loadMenuList$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$loadMenuList$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$loadMenuList$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$loadMenuList$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$loadMenuList$12.L$4 = null;
                        rolesListViewModel$loadMenuList$12.L$5 = null;
                        rolesListViewModel$loadMenuList$12.L$6 = null;
                        rolesListViewModel$loadMenuList$12.L$7 = null;
                        rolesListViewModel$loadMenuList$12.I$0 = 0;
                        rolesListViewModel$loadMenuList$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, rolesListViewModel$loadMenuList$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = rolesListViewModel$loadMenuList$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) rolesListViewModel$loadMenuList$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) rolesListViewModel$loadMenuList$12.L$2;
                        Url url4 = (Url) rolesListViewModel$loadMenuList$12.L$1;
                        String str = (String) rolesListViewModel$loadMenuList$12.L$0;
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
        rolesListViewModel$loadMenuList$1 = new RolesListViewModel$loadMenuList$1(this, continuation);
        rolesListViewModel$loadMenuList$12 = rolesListViewModel$loadMenuList$1;
        Object $result2 = rolesListViewModel$loadMenuList$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rolesListViewModel$loadMenuList$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object unbind(String roleId, Continuation<? super Boolean> continuation) {
        RolesListViewModel$unbind$1 rolesListViewModel$unbind$1;
        RolesListViewModel$unbind$1 rolesListViewModel$unbind$12;
        Object obj;
        KType kType;
        Object obj2;
        Url url;
        String roleId2;
        KType kType2;
        Parameters.Companion this_$iv$iv;
        KType kType3;
        Object bodyNullable;
        boolean z;
        if (continuation instanceof RolesListViewModel$unbind$1) {
            rolesListViewModel$unbind$1 = (RolesListViewModel$unbind$1) continuation;
            if ((rolesListViewModel$unbind$1.label & Integer.MIN_VALUE) != 0) {
                rolesListViewModel$unbind$1.label -= Integer.MIN_VALUE;
                rolesListViewModel$unbind$12 = rolesListViewModel$unbind$1;
                Object $result = rolesListViewModel$unbind$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rolesListViewModel$unbind$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("/game/center/h5/role_bind/unbind", (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Map params$iv = MapsKt.mapOf(TuplesKt.to("role_bind_id", roleId));
                        HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url2);
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                        Parameters.Companion this_$iv$iv2 = Parameters.Companion;
                        boolean z2 = false;
                        ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                        for (Map.Entry element$iv$iv : params$iv.entrySet()) {
                            String it$iv = (String) element$iv$iv.getValue();
                            if (it$iv != null) {
                                if (!(it$iv.length() > 0 ? true : z2)) {
                                    it$iv = null;
                                }
                                if (it$iv != null) {
                                    String value$iv = it$iv;
                                    this_$iv$iv = this_$iv$iv2;
                                    BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                    this_$iv$iv2 = this_$iv$iv;
                                    z2 = false;
                                }
                            }
                            this_$iv$iv = this_$iv$iv2;
                            this_$iv$iv2 = this_$iv$iv;
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
                        rolesListViewModel$unbind$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId);
                        rolesListViewModel$unbind$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$unbind$12.L$2 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$unbind$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$unbind$12.L$4 = SpillingKt.nullOutSpilledVariable(params$iv);
                        rolesListViewModel$unbind$12.L$5 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$unbind$12.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$unbind$12.L$7 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$unbind$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$unbind$12.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        rolesListViewModel$unbind$12.L$10 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$unbind$12.I$0 = 0;
                        rolesListViewModel$unbind$12.I$1 = 0;
                        rolesListViewModel$unbind$12.I$2 = 0;
                        rolesListViewModel$unbind$12.I$3 = 0;
                        rolesListViewModel$unbind$12.I$4 = 0;
                        rolesListViewModel$unbind$12.label = 1;
                        Object execute = httpStatement.execute(rolesListViewModel$unbind$12);
                        obj2 = obj;
                        if (execute == obj2) {
                            return obj2;
                        }
                        url = url2;
                        $result = execute;
                        roleId2 = roleId;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        rolesListViewModel$unbind$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$unbind$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$unbind$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$unbind$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$unbind$12.L$4 = null;
                        rolesListViewModel$unbind$12.L$5 = null;
                        rolesListViewModel$unbind$12.L$6 = null;
                        rolesListViewModel$unbind$12.L$7 = null;
                        rolesListViewModel$unbind$12.L$8 = null;
                        rolesListViewModel$unbind$12.L$9 = null;
                        rolesListViewModel$unbind$12.L$10 = null;
                        rolesListViewModel$unbind$12.I$0 = 0;
                        rolesListViewModel$unbind$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, rolesListViewModel$unbind$12);
                        if (bodyNullable != obj2) {
                            return obj2;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                ActionResult actionResult = (ActionResult) success.getData();
                                z = actionResult != null && actionResult.getSuccess();
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                z = false;
                            } else if (!(success instanceof KApiResponse.ServiceUnavailable)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                z = false;
                            }
                            return Boxing.boxBoolean(z);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.ActionResult?>");
                    case 1:
                        int $i$f$body = rolesListViewModel$unbind$12.I$4;
                        int i = rolesListViewModel$unbind$12.I$3;
                        int i2 = rolesListViewModel$unbind$12.I$2;
                        int i3 = rolesListViewModel$unbind$12.I$1;
                        int i4 = rolesListViewModel$unbind$12.I$0;
                        HttpClient httpClient = (HttpClient) rolesListViewModel$unbind$12.L$10;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) rolesListViewModel$unbind$12.L$9;
                        HttpClient httpClient2 = (HttpClient) rolesListViewModel$unbind$12.L$8;
                        HttpClient httpClient3 = (HttpClient) rolesListViewModel$unbind$12.L$7;
                        Url url3 = (Url) rolesListViewModel$unbind$12.L$6;
                        HttpClient httpClient4 = (HttpClient) rolesListViewModel$unbind$12.L$5;
                        Map map = (Map) rolesListViewModel$unbind$12.L$4;
                        Url url4 = (Url) rolesListViewModel$unbind$12.L$3;
                        HttpClient httpClient5 = (HttpClient) rolesListViewModel$unbind$12.L$2;
                        url = (Url) rolesListViewModel$unbind$12.L$1;
                        ResultKt.throwOnFailure($result);
                        roleId2 = (String) rolesListViewModel$unbind$12.L$0;
                        obj2 = coroutine_suspended;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        rolesListViewModel$unbind$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$unbind$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$unbind$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$unbind$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$unbind$12.L$4 = null;
                        rolesListViewModel$unbind$12.L$5 = null;
                        rolesListViewModel$unbind$12.L$6 = null;
                        rolesListViewModel$unbind$12.L$7 = null;
                        rolesListViewModel$unbind$12.L$8 = null;
                        rolesListViewModel$unbind$12.L$9 = null;
                        rolesListViewModel$unbind$12.L$10 = null;
                        rolesListViewModel$unbind$12.I$0 = 0;
                        rolesListViewModel$unbind$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, rolesListViewModel$unbind$12);
                        if (bodyNullable != obj2) {
                        }
                        break;
                    case 2:
                        int i5 = rolesListViewModel$unbind$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) rolesListViewModel$unbind$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) rolesListViewModel$unbind$12.L$2;
                        Url url5 = (Url) rolesListViewModel$unbind$12.L$1;
                        String str = (String) rolesListViewModel$unbind$12.L$0;
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
        rolesListViewModel$unbind$1 = new RolesListViewModel$unbind$1(this, continuation);
        rolesListViewModel$unbind$12 = rolesListViewModel$unbind$1;
        Object $result2 = rolesListViewModel$unbind$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rolesListViewModel$unbind$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0324  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pinOrUnpin(String roleId, boolean isPin, Continuation<? super Boolean> continuation) {
        RolesListViewModel$pinOrUnpin$1 rolesListViewModel$pinOrUnpin$1;
        RolesListViewModel$pinOrUnpin$1 rolesListViewModel$pinOrUnpin$12;
        int $i$f$typeOfOrNull;
        KType kType;
        Object obj;
        String path;
        Url url;
        String roleId2;
        boolean isPin2;
        KType kType2;
        Parameters.Companion this_$iv$iv;
        KType kType3;
        Object bodyNullable;
        boolean z;
        if (continuation instanceof RolesListViewModel$pinOrUnpin$1) {
            rolesListViewModel$pinOrUnpin$1 = (RolesListViewModel$pinOrUnpin$1) continuation;
            if ((rolesListViewModel$pinOrUnpin$1.label & Integer.MIN_VALUE) != 0) {
                rolesListViewModel$pinOrUnpin$1.label -= Integer.MIN_VALUE;
                rolesListViewModel$pinOrUnpin$12 = rolesListViewModel$pinOrUnpin$1;
                Object $result = rolesListViewModel$pinOrUnpin$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rolesListViewModel$pinOrUnpin$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String path2 = isPin ? "/game/center/h5/role_bind/pin" : "/game/center/h5/role_bind/unpin";
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default(path2, (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Map params$iv = MapsKt.mapOf(TuplesKt.to("role_bind_id", roleId));
                        HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url2);
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                        Parameters.Companion this_$iv$iv2 = Parameters.Companion;
                        boolean z2 = false;
                        ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                        for (Map.Entry element$iv$iv : params$iv.entrySet()) {
                            String it$iv = (String) element$iv$iv.getValue();
                            if (it$iv != null) {
                                if (!(it$iv.length() > 0 ? true : z2)) {
                                    it$iv = null;
                                }
                                if (it$iv != null) {
                                    String value$iv = it$iv;
                                    this_$iv$iv = this_$iv$iv2;
                                    BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                    this_$iv$iv2 = this_$iv$iv;
                                    z2 = false;
                                }
                            }
                            this_$iv$iv = this_$iv$iv2;
                            this_$iv$iv2 = this_$iv$iv;
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
                            $i$f$typeOfOrNull = 0;
                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                        } else {
                            $i$f$typeOfOrNull = 0;
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
                        rolesListViewModel$pinOrUnpin$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId);
                        rolesListViewModel$pinOrUnpin$12.L$1 = SpillingKt.nullOutSpilledVariable(path2);
                        rolesListViewModel$pinOrUnpin$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$pinOrUnpin$12.L$3 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$pinOrUnpin$12.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$pinOrUnpin$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                        rolesListViewModel$pinOrUnpin$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$pinOrUnpin$12.L$7 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$pinOrUnpin$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$pinOrUnpin$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$pinOrUnpin$12.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        rolesListViewModel$pinOrUnpin$12.L$11 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$pinOrUnpin$12.Z$0 = isPin;
                        rolesListViewModel$pinOrUnpin$12.I$0 = 0;
                        rolesListViewModel$pinOrUnpin$12.I$1 = 0;
                        int $i$f$post = $i$f$typeOfOrNull;
                        rolesListViewModel$pinOrUnpin$12.I$2 = $i$f$post;
                        rolesListViewModel$pinOrUnpin$12.I$3 = 0;
                        rolesListViewModel$pinOrUnpin$12.I$4 = 0;
                        rolesListViewModel$pinOrUnpin$12.label = 1;
                        Object execute = httpStatement.execute(rolesListViewModel$pinOrUnpin$12);
                        obj = coroutine_suspended;
                        if (execute == obj) {
                            return obj;
                        }
                        path = path2;
                        url = url2;
                        $result = execute;
                        roleId2 = roleId;
                        isPin2 = isPin;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        rolesListViewModel$pinOrUnpin$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$pinOrUnpin$12.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        rolesListViewModel$pinOrUnpin$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$pinOrUnpin$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$pinOrUnpin$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$pinOrUnpin$12.L$5 = null;
                        rolesListViewModel$pinOrUnpin$12.L$6 = null;
                        rolesListViewModel$pinOrUnpin$12.L$7 = null;
                        rolesListViewModel$pinOrUnpin$12.L$8 = null;
                        rolesListViewModel$pinOrUnpin$12.L$9 = null;
                        rolesListViewModel$pinOrUnpin$12.L$10 = null;
                        rolesListViewModel$pinOrUnpin$12.L$11 = null;
                        rolesListViewModel$pinOrUnpin$12.Z$0 = isPin2;
                        rolesListViewModel$pinOrUnpin$12.I$0 = 0;
                        rolesListViewModel$pinOrUnpin$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, rolesListViewModel$pinOrUnpin$12);
                        if (bodyNullable != obj) {
                            return obj;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                ActionResult actionResult = (ActionResult) success.getData();
                                z = actionResult != null && actionResult.getSuccess();
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                z = false;
                            } else if (!(success instanceof KApiResponse.ServiceUnavailable)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                z = false;
                            }
                            return Boxing.boxBoolean(z);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.ActionResult?>");
                    case 1:
                        int $i$f$body = rolesListViewModel$pinOrUnpin$12.I$4;
                        int i = rolesListViewModel$pinOrUnpin$12.I$3;
                        int i2 = rolesListViewModel$pinOrUnpin$12.I$2;
                        int i3 = rolesListViewModel$pinOrUnpin$12.I$1;
                        int i4 = rolesListViewModel$pinOrUnpin$12.I$0;
                        boolean isPin3 = rolesListViewModel$pinOrUnpin$12.Z$0;
                        HttpClient httpClient = (HttpClient) rolesListViewModel$pinOrUnpin$12.L$11;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) rolesListViewModel$pinOrUnpin$12.L$10;
                        HttpClient httpClient2 = (HttpClient) rolesListViewModel$pinOrUnpin$12.L$9;
                        HttpClient httpClient3 = (HttpClient) rolesListViewModel$pinOrUnpin$12.L$8;
                        Url url3 = (Url) rolesListViewModel$pinOrUnpin$12.L$7;
                        HttpClient httpClient4 = (HttpClient) rolesListViewModel$pinOrUnpin$12.L$6;
                        Map map = (Map) rolesListViewModel$pinOrUnpin$12.L$5;
                        Url url4 = (Url) rolesListViewModel$pinOrUnpin$12.L$4;
                        HttpClient httpClient5 = (HttpClient) rolesListViewModel$pinOrUnpin$12.L$3;
                        url = (Url) rolesListViewModel$pinOrUnpin$12.L$2;
                        path = (String) rolesListViewModel$pinOrUnpin$12.L$1;
                        ResultKt.throwOnFailure($result);
                        isPin2 = isPin3;
                        obj = coroutine_suspended;
                        roleId2 = (String) rolesListViewModel$pinOrUnpin$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        rolesListViewModel$pinOrUnpin$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$pinOrUnpin$12.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        rolesListViewModel$pinOrUnpin$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$pinOrUnpin$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$pinOrUnpin$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$pinOrUnpin$12.L$5 = null;
                        rolesListViewModel$pinOrUnpin$12.L$6 = null;
                        rolesListViewModel$pinOrUnpin$12.L$7 = null;
                        rolesListViewModel$pinOrUnpin$12.L$8 = null;
                        rolesListViewModel$pinOrUnpin$12.L$9 = null;
                        rolesListViewModel$pinOrUnpin$12.L$10 = null;
                        rolesListViewModel$pinOrUnpin$12.L$11 = null;
                        rolesListViewModel$pinOrUnpin$12.Z$0 = isPin2;
                        rolesListViewModel$pinOrUnpin$12.I$0 = 0;
                        rolesListViewModel$pinOrUnpin$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, rolesListViewModel$pinOrUnpin$12);
                        if (bodyNullable != obj) {
                        }
                        break;
                    case 2:
                        int i5 = rolesListViewModel$pinOrUnpin$12.I$0;
                        boolean z3 = rolesListViewModel$pinOrUnpin$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) rolesListViewModel$pinOrUnpin$12.L$4;
                        HttpResponse httpResponse4 = (HttpResponse) rolesListViewModel$pinOrUnpin$12.L$3;
                        Url url5 = (Url) rolesListViewModel$pinOrUnpin$12.L$2;
                        String str = (String) rolesListViewModel$pinOrUnpin$12.L$1;
                        String str2 = (String) rolesListViewModel$pinOrUnpin$12.L$0;
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
        rolesListViewModel$pinOrUnpin$1 = new RolesListViewModel$pinOrUnpin$1(this, continuation);
        rolesListViewModel$pinOrUnpin$12 = rolesListViewModel$pinOrUnpin$1;
        Object $result2 = rolesListViewModel$pinOrUnpin$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rolesListViewModel$pinOrUnpin$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0324  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object changeVisible(String roleId, boolean publicVisible, Continuation<? super Boolean> continuation) {
        RolesListViewModel$changeVisible$1 rolesListViewModel$changeVisible$1;
        RolesListViewModel$changeVisible$1 rolesListViewModel$changeVisible$12;
        int $i$f$typeOfOrNull;
        KType kType;
        Object obj;
        String path;
        Url url;
        String roleId2;
        boolean publicVisible2;
        KType kType2;
        Parameters.Companion this_$iv$iv;
        KType kType3;
        Object bodyNullable;
        boolean z;
        if (continuation instanceof RolesListViewModel$changeVisible$1) {
            rolesListViewModel$changeVisible$1 = (RolesListViewModel$changeVisible$1) continuation;
            if ((rolesListViewModel$changeVisible$1.label & Integer.MIN_VALUE) != 0) {
                rolesListViewModel$changeVisible$1.label -= Integer.MIN_VALUE;
                rolesListViewModel$changeVisible$12 = rolesListViewModel$changeVisible$1;
                Object $result = rolesListViewModel$changeVisible$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rolesListViewModel$changeVisible$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String path2 = publicVisible ? "/game/center/h5/role_bind/set_public_visible" : "/game/center/h5/role_bind/cancel_public_visible";
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default(path2, (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Map params$iv = MapsKt.mapOf(TuplesKt.to("role_bind_id", roleId));
                        HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url2);
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                        Parameters.Companion this_$iv$iv2 = Parameters.Companion;
                        boolean z2 = false;
                        ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                        for (Map.Entry element$iv$iv : params$iv.entrySet()) {
                            String it$iv = (String) element$iv$iv.getValue();
                            if (it$iv != null) {
                                if (!(it$iv.length() > 0 ? true : z2)) {
                                    it$iv = null;
                                }
                                if (it$iv != null) {
                                    String value$iv = it$iv;
                                    this_$iv$iv = this_$iv$iv2;
                                    BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                    this_$iv$iv2 = this_$iv$iv;
                                    z2 = false;
                                }
                            }
                            this_$iv$iv = this_$iv$iv2;
                            this_$iv$iv2 = this_$iv$iv;
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
                            $i$f$typeOfOrNull = 0;
                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                        } else {
                            $i$f$typeOfOrNull = 0;
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
                        rolesListViewModel$changeVisible$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId);
                        rolesListViewModel$changeVisible$12.L$1 = SpillingKt.nullOutSpilledVariable(path2);
                        rolesListViewModel$changeVisible$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$changeVisible$12.L$3 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$changeVisible$12.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$changeVisible$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                        rolesListViewModel$changeVisible$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$changeVisible$12.L$7 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$changeVisible$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$changeVisible$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$changeVisible$12.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        rolesListViewModel$changeVisible$12.L$11 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$changeVisible$12.Z$0 = publicVisible;
                        rolesListViewModel$changeVisible$12.I$0 = 0;
                        rolesListViewModel$changeVisible$12.I$1 = 0;
                        int $i$f$post = $i$f$typeOfOrNull;
                        rolesListViewModel$changeVisible$12.I$2 = $i$f$post;
                        rolesListViewModel$changeVisible$12.I$3 = 0;
                        rolesListViewModel$changeVisible$12.I$4 = 0;
                        rolesListViewModel$changeVisible$12.label = 1;
                        Object execute = httpStatement.execute(rolesListViewModel$changeVisible$12);
                        obj = coroutine_suspended;
                        if (execute == obj) {
                            return obj;
                        }
                        path = path2;
                        url = url2;
                        $result = execute;
                        roleId2 = roleId;
                        publicVisible2 = publicVisible;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        rolesListViewModel$changeVisible$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$changeVisible$12.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        rolesListViewModel$changeVisible$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$changeVisible$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$changeVisible$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$changeVisible$12.L$5 = null;
                        rolesListViewModel$changeVisible$12.L$6 = null;
                        rolesListViewModel$changeVisible$12.L$7 = null;
                        rolesListViewModel$changeVisible$12.L$8 = null;
                        rolesListViewModel$changeVisible$12.L$9 = null;
                        rolesListViewModel$changeVisible$12.L$10 = null;
                        rolesListViewModel$changeVisible$12.L$11 = null;
                        rolesListViewModel$changeVisible$12.Z$0 = publicVisible2;
                        rolesListViewModel$changeVisible$12.I$0 = 0;
                        rolesListViewModel$changeVisible$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, rolesListViewModel$changeVisible$12);
                        if (bodyNullable != obj) {
                            return obj;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                ActionResult actionResult = (ActionResult) success.getData();
                                z = actionResult != null && actionResult.getSuccess();
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                z = false;
                            } else if (!(success instanceof KApiResponse.ServiceUnavailable)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                z = false;
                            }
                            return Boxing.boxBoolean(z);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.ActionResult?>");
                    case 1:
                        int $i$f$body = rolesListViewModel$changeVisible$12.I$4;
                        int i = rolesListViewModel$changeVisible$12.I$3;
                        int i2 = rolesListViewModel$changeVisible$12.I$2;
                        int i3 = rolesListViewModel$changeVisible$12.I$1;
                        int i4 = rolesListViewModel$changeVisible$12.I$0;
                        boolean publicVisible3 = rolesListViewModel$changeVisible$12.Z$0;
                        HttpClient httpClient = (HttpClient) rolesListViewModel$changeVisible$12.L$11;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) rolesListViewModel$changeVisible$12.L$10;
                        HttpClient httpClient2 = (HttpClient) rolesListViewModel$changeVisible$12.L$9;
                        HttpClient httpClient3 = (HttpClient) rolesListViewModel$changeVisible$12.L$8;
                        Url url3 = (Url) rolesListViewModel$changeVisible$12.L$7;
                        HttpClient httpClient4 = (HttpClient) rolesListViewModel$changeVisible$12.L$6;
                        Map map = (Map) rolesListViewModel$changeVisible$12.L$5;
                        Url url4 = (Url) rolesListViewModel$changeVisible$12.L$4;
                        HttpClient httpClient5 = (HttpClient) rolesListViewModel$changeVisible$12.L$3;
                        url = (Url) rolesListViewModel$changeVisible$12.L$2;
                        path = (String) rolesListViewModel$changeVisible$12.L$1;
                        ResultKt.throwOnFailure($result);
                        publicVisible2 = publicVisible3;
                        obj = coroutine_suspended;
                        roleId2 = (String) rolesListViewModel$changeVisible$12.L$0;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        rolesListViewModel$changeVisible$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$changeVisible$12.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        rolesListViewModel$changeVisible$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$changeVisible$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$changeVisible$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$changeVisible$12.L$5 = null;
                        rolesListViewModel$changeVisible$12.L$6 = null;
                        rolesListViewModel$changeVisible$12.L$7 = null;
                        rolesListViewModel$changeVisible$12.L$8 = null;
                        rolesListViewModel$changeVisible$12.L$9 = null;
                        rolesListViewModel$changeVisible$12.L$10 = null;
                        rolesListViewModel$changeVisible$12.L$11 = null;
                        rolesListViewModel$changeVisible$12.Z$0 = publicVisible2;
                        rolesListViewModel$changeVisible$12.I$0 = 0;
                        rolesListViewModel$changeVisible$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, rolesListViewModel$changeVisible$12);
                        if (bodyNullable != obj) {
                        }
                        break;
                    case 2:
                        int i5 = rolesListViewModel$changeVisible$12.I$0;
                        boolean z3 = rolesListViewModel$changeVisible$12.Z$0;
                        HttpResponse httpResponse3 = (HttpResponse) rolesListViewModel$changeVisible$12.L$4;
                        HttpResponse httpResponse4 = (HttpResponse) rolesListViewModel$changeVisible$12.L$3;
                        Url url5 = (Url) rolesListViewModel$changeVisible$12.L$2;
                        String str = (String) rolesListViewModel$changeVisible$12.L$1;
                        String str2 = (String) rolesListViewModel$changeVisible$12.L$0;
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
        rolesListViewModel$changeVisible$1 = new RolesListViewModel$changeVisible$1(this, continuation);
        rolesListViewModel$changeVisible$12 = rolesListViewModel$changeVisible$1;
        Object $result2 = rolesListViewModel$changeVisible$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rolesListViewModel$changeVisible$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0315  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object switchRole(String roleId, String sectionId, Continuation<? super Boolean> continuation) {
        RolesListViewModel$switchRole$1 rolesListViewModel$switchRole$1;
        RolesListViewModel$switchRole$1 rolesListViewModel$switchRole$12;
        KType kType;
        Object execute;
        Object obj;
        Url url;
        String roleId2;
        String sectionId2;
        KType kType2;
        Parameters.Companion this_$iv$iv;
        KType kType3;
        Object bodyNullable;
        boolean z;
        if (continuation instanceof RolesListViewModel$switchRole$1) {
            rolesListViewModel$switchRole$1 = (RolesListViewModel$switchRole$1) continuation;
            if ((rolesListViewModel$switchRole$1.label & Integer.MIN_VALUE) != 0) {
                rolesListViewModel$switchRole$1.label -= Integer.MIN_VALUE;
                rolesListViewModel$switchRole$12 = rolesListViewModel$switchRole$1;
                Object $result = rolesListViewModel$switchRole$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rolesListViewModel$switchRole$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = BiligameUrlBuilderKt.buildGameUrl$default("/game/center/h5/role_bind/switch_role", (Map) null, 2, (Object) null);
                        HttpClient $this$postFormUrlEncode$iv = BiligameHttpClientKt.getBiligameHttpClient();
                        Map params$iv = MapsKt.mapOf(new Pair[]{TuplesKt.to("role_bind_id", roleId), TuplesKt.to("section_id", sectionId)});
                        HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url2);
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                        Parameters.Companion this_$iv$iv2 = Parameters.Companion;
                        boolean z2 = false;
                        ParametersBuilder $this$postFormUrlEncode_u24lambda_u240_u240$iv = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        BiligameHttpClientKt.addCommonParamsToBody($this$postFormUrlEncode_u24lambda_u240_u240$iv);
                        for (Map.Entry element$iv$iv : params$iv.entrySet()) {
                            String it$iv = (String) element$iv$iv.getValue();
                            if (it$iv != null) {
                                if (!(it$iv.length() > 0 ? true : z2)) {
                                    it$iv = null;
                                }
                                if (it$iv != null) {
                                    String value$iv = it$iv;
                                    this_$iv$iv = this_$iv$iv2;
                                    BiligameHttpClientKt.put($this$postFormUrlEncode_u24lambda_u240_u240$iv, (String) element$iv$iv.getKey(), value$iv);
                                    this_$iv$iv2 = this_$iv$iv;
                                    z2 = false;
                                }
                            }
                            this_$iv$iv = this_$iv$iv2;
                            this_$iv$iv2 = this_$iv$iv;
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
                        rolesListViewModel$switchRole$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId);
                        rolesListViewModel$switchRole$12.L$1 = SpillingKt.nullOutSpilledVariable(sectionId);
                        rolesListViewModel$switchRole$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$switchRole$12.L$3 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$switchRole$12.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$switchRole$12.L$5 = SpillingKt.nullOutSpilledVariable(params$iv);
                        rolesListViewModel$switchRole$12.L$6 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$switchRole$12.L$7 = SpillingKt.nullOutSpilledVariable(url2);
                        rolesListViewModel$switchRole$12.L$8 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$switchRole$12.L$9 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$switchRole$12.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        rolesListViewModel$switchRole$12.L$11 = SpillingKt.nullOutSpilledVariable($this$postFormUrlEncode$iv);
                        rolesListViewModel$switchRole$12.I$0 = 0;
                        rolesListViewModel$switchRole$12.I$1 = 0;
                        rolesListViewModel$switchRole$12.I$2 = 0;
                        rolesListViewModel$switchRole$12.I$3 = 0;
                        rolesListViewModel$switchRole$12.I$4 = 0;
                        rolesListViewModel$switchRole$12.label = 1;
                        execute = httpStatement.execute(rolesListViewModel$switchRole$12);
                        obj = coroutine_suspended;
                        if (execute == obj) {
                            return obj;
                        }
                        url = url2;
                        roleId2 = roleId;
                        sectionId2 = sectionId;
                        HttpResponse httpResponse = (HttpResponse) execute;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        } catch (Throwable th3) {
                            kType3 = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                        rolesListViewModel$switchRole$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$switchRole$12.L$1 = SpillingKt.nullOutSpilledVariable(sectionId2);
                        rolesListViewModel$switchRole$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$switchRole$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$switchRole$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        rolesListViewModel$switchRole$12.L$5 = null;
                        rolesListViewModel$switchRole$12.L$6 = null;
                        rolesListViewModel$switchRole$12.L$7 = null;
                        rolesListViewModel$switchRole$12.L$8 = null;
                        rolesListViewModel$switchRole$12.L$9 = null;
                        rolesListViewModel$switchRole$12.L$10 = null;
                        rolesListViewModel$switchRole$12.L$11 = null;
                        rolesListViewModel$switchRole$12.I$0 = 0;
                        rolesListViewModel$switchRole$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, rolesListViewModel$switchRole$12);
                        if (bodyNullable != obj) {
                            return obj;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                ActionResult actionResult = (ActionResult) success.getData();
                                z = actionResult != null && actionResult.getSuccess();
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                z = false;
                            } else if (!(success instanceof KApiResponse.ServiceUnavailable)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                z = false;
                            }
                            return Boxing.boxBoolean(z);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.game.gamebind.bean.ActionResult?>");
                    case 1:
                        int $i$f$body = rolesListViewModel$switchRole$12.I$4;
                        int i = rolesListViewModel$switchRole$12.I$3;
                        int i2 = rolesListViewModel$switchRole$12.I$2;
                        int i3 = rolesListViewModel$switchRole$12.I$1;
                        int i4 = rolesListViewModel$switchRole$12.I$0;
                        HttpClient httpClient = (HttpClient) rolesListViewModel$switchRole$12.L$11;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) rolesListViewModel$switchRole$12.L$10;
                        HttpClient httpClient2 = (HttpClient) rolesListViewModel$switchRole$12.L$9;
                        HttpClient httpClient3 = (HttpClient) rolesListViewModel$switchRole$12.L$8;
                        Url url3 = (Url) rolesListViewModel$switchRole$12.L$7;
                        HttpClient httpClient4 = (HttpClient) rolesListViewModel$switchRole$12.L$6;
                        Map map = (Map) rolesListViewModel$switchRole$12.L$5;
                        Url url4 = (Url) rolesListViewModel$switchRole$12.L$4;
                        HttpClient httpClient5 = (HttpClient) rolesListViewModel$switchRole$12.L$3;
                        url = (Url) rolesListViewModel$switchRole$12.L$2;
                        String sectionId3 = (String) rolesListViewModel$switchRole$12.L$1;
                        ResultKt.throwOnFailure($result);
                        roleId2 = (String) rolesListViewModel$switchRole$12.L$0;
                        obj = coroutine_suspended;
                        execute = $result;
                        sectionId2 = sectionId3;
                        HttpResponse httpResponse2 = (HttpResponse) execute;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(ActionResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        rolesListViewModel$switchRole$12.L$0 = SpillingKt.nullOutSpilledVariable(roleId2);
                        rolesListViewModel$switchRole$12.L$1 = SpillingKt.nullOutSpilledVariable(sectionId2);
                        rolesListViewModel$switchRole$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        rolesListViewModel$switchRole$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$switchRole$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        rolesListViewModel$switchRole$12.L$5 = null;
                        rolesListViewModel$switchRole$12.L$6 = null;
                        rolesListViewModel$switchRole$12.L$7 = null;
                        rolesListViewModel$switchRole$12.L$8 = null;
                        rolesListViewModel$switchRole$12.L$9 = null;
                        rolesListViewModel$switchRole$12.L$10 = null;
                        rolesListViewModel$switchRole$12.L$11 = null;
                        rolesListViewModel$switchRole$12.I$0 = 0;
                        rolesListViewModel$switchRole$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, rolesListViewModel$switchRole$12);
                        if (bodyNullable != obj) {
                        }
                        break;
                    case 2:
                        int i5 = rolesListViewModel$switchRole$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) rolesListViewModel$switchRole$12.L$4;
                        HttpResponse httpResponse4 = (HttpResponse) rolesListViewModel$switchRole$12.L$3;
                        Url url5 = (Url) rolesListViewModel$switchRole$12.L$2;
                        String str = (String) rolesListViewModel$switchRole$12.L$1;
                        String str2 = (String) rolesListViewModel$switchRole$12.L$0;
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
        rolesListViewModel$switchRole$1 = new RolesListViewModel$switchRole$1(this, continuation);
        rolesListViewModel$switchRole$12 = rolesListViewModel$switchRole$1;
        Object $result2 = rolesListViewModel$switchRole$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rolesListViewModel$switchRole$12.label) {
        }
    }

    public final Object dispatch(MenuEvent event, Continuation<? super Unit> continuation) {
        Object dispatch = this.mMenuMachine.dispatch(event, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    /* compiled from: RolesListViewModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Initialize", "ShowMenuDialog", "ShowRoleSwitchDialog", "UnbindDialog", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState$Initialize;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState$ShowMenuDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState$ShowRoleSwitchDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState$UnbindDialog;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class MenuState {
        public /* synthetic */ MenuState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuState$Initialize;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Initialize extends MenuState {
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Initialize) {
                    Initialize initialize = (Initialize) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1543315156;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private MenuState() {
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuState$ShowMenuDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "menuList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;Ljava/util/List;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "getMenuList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ShowMenuDialog extends MenuState {
            private final List<RoleMenuItem> menuList;
            private final RoleItem role;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ShowMenuDialog copy$default(ShowMenuDialog showMenuDialog, RoleItem roleItem, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = showMenuDialog.role;
                }
                if ((i & 2) != 0) {
                    list = showMenuDialog.menuList;
                }
                return showMenuDialog.copy(roleItem, list);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final List<RoleMenuItem> component2() {
                return this.menuList;
            }

            public final ShowMenuDialog copy(RoleItem roleItem, List<RoleMenuItem> list) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                Intrinsics.checkNotNullParameter(list, "menuList");
                return new ShowMenuDialog(roleItem, list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ShowMenuDialog) {
                    ShowMenuDialog showMenuDialog = (ShowMenuDialog) obj;
                    return Intrinsics.areEqual(this.role, showMenuDialog.role) && Intrinsics.areEqual(this.menuList, showMenuDialog.menuList);
                }
                return false;
            }

            public int hashCode() {
                return (this.role.hashCode() * 31) + this.menuList.hashCode();
            }

            public String toString() {
                RoleItem roleItem = this.role;
                return "ShowMenuDialog(role=" + roleItem + ", menuList=" + this.menuList + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowMenuDialog(RoleItem role, List<RoleMenuItem> list) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                Intrinsics.checkNotNullParameter(list, "menuList");
                this.role = role;
                this.menuList = list;
            }

            public final RoleItem getRole() {
                return this.role;
            }

            public final List<RoleMenuItem> getMenuList() {
                return this.menuList;
            }
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuState$ShowRoleSwitchDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "menuItem", "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;Lkntr/app/game/gamebind/bean/RoleMenuItem;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "getMenuItem", "()Lkntr/app/game/gamebind/bean/RoleMenuItem;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ShowRoleSwitchDialog extends MenuState {
            private final RoleMenuItem menuItem;
            private final RoleItem role;

            public static /* synthetic */ ShowRoleSwitchDialog copy$default(ShowRoleSwitchDialog showRoleSwitchDialog, RoleItem roleItem, RoleMenuItem roleMenuItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = showRoleSwitchDialog.role;
                }
                if ((i & 2) != 0) {
                    roleMenuItem = showRoleSwitchDialog.menuItem;
                }
                return showRoleSwitchDialog.copy(roleItem, roleMenuItem);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final RoleMenuItem component2() {
                return this.menuItem;
            }

            public final ShowRoleSwitchDialog copy(RoleItem roleItem, RoleMenuItem roleMenuItem) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                Intrinsics.checkNotNullParameter(roleMenuItem, "menuItem");
                return new ShowRoleSwitchDialog(roleItem, roleMenuItem);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ShowRoleSwitchDialog) {
                    ShowRoleSwitchDialog showRoleSwitchDialog = (ShowRoleSwitchDialog) obj;
                    return Intrinsics.areEqual(this.role, showRoleSwitchDialog.role) && Intrinsics.areEqual(this.menuItem, showRoleSwitchDialog.menuItem);
                }
                return false;
            }

            public int hashCode() {
                return (this.role.hashCode() * 31) + this.menuItem.hashCode();
            }

            public String toString() {
                RoleItem roleItem = this.role;
                return "ShowRoleSwitchDialog(role=" + roleItem + ", menuItem=" + this.menuItem + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowRoleSwitchDialog(RoleItem role, RoleMenuItem menuItem) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                Intrinsics.checkNotNullParameter(menuItem, "menuItem");
                this.role = role;
                this.menuItem = menuItem;
            }

            public final RoleItem getRole() {
                return this.role;
            }

            public final RoleMenuItem getMenuItem() {
                return this.menuItem;
            }
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuState$UnbindDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class UnbindDialog extends MenuState {
            private final RoleItem role;

            public static /* synthetic */ UnbindDialog copy$default(UnbindDialog unbindDialog, RoleItem roleItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = unbindDialog.role;
                }
                return unbindDialog.copy(roleItem);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final UnbindDialog copy(RoleItem roleItem) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                return new UnbindDialog(roleItem);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof UnbindDialog) && Intrinsics.areEqual(this.role, ((UnbindDialog) obj).role);
            }

            public int hashCode() {
                return this.role.hashCode();
            }

            public String toString() {
                return "UnbindDialog(role=" + this.role + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnbindDialog(RoleItem role) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                this.role = role;
            }

            public final RoleItem getRole() {
                return this.role;
            }
        }
    }

    /* compiled from: RolesListViewModel.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "LoadMenuList", "MenuClick", "HideMenuDialog", "ServerSwitch", "Unbind", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$HideMenuDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$LoadMenuList;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$MenuClick;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$ServerSwitch;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$Unbind;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class MenuEvent {
        public /* synthetic */ MenuEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$LoadMenuList;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadMenuList extends MenuEvent {
            private final RoleItem role;

            public static /* synthetic */ LoadMenuList copy$default(LoadMenuList loadMenuList, RoleItem roleItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = loadMenuList.role;
                }
                return loadMenuList.copy(roleItem);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final LoadMenuList copy(RoleItem roleItem) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                return new LoadMenuList(roleItem);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LoadMenuList) && Intrinsics.areEqual(this.role, ((LoadMenuList) obj).role);
            }

            public int hashCode() {
                return this.role.hashCode();
            }

            public String toString() {
                return "LoadMenuList(role=" + this.role + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadMenuList(RoleItem role) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                this.role = role;
            }

            public final RoleItem getRole() {
                return this.role;
            }
        }

        private MenuEvent() {
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$MenuClick;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "menuItem", "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;Lkntr/app/game/gamebind/bean/RoleMenuItem;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "getMenuItem", "()Lkntr/app/game/gamebind/bean/RoleMenuItem;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class MenuClick extends MenuEvent {
            private final RoleMenuItem menuItem;
            private final RoleItem role;

            public static /* synthetic */ MenuClick copy$default(MenuClick menuClick, RoleItem roleItem, RoleMenuItem roleMenuItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = menuClick.role;
                }
                if ((i & 2) != 0) {
                    roleMenuItem = menuClick.menuItem;
                }
                return menuClick.copy(roleItem, roleMenuItem);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final RoleMenuItem component2() {
                return this.menuItem;
            }

            public final MenuClick copy(RoleItem roleItem, RoleMenuItem roleMenuItem) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                Intrinsics.checkNotNullParameter(roleMenuItem, "menuItem");
                return new MenuClick(roleItem, roleMenuItem);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MenuClick) {
                    MenuClick menuClick = (MenuClick) obj;
                    return Intrinsics.areEqual(this.role, menuClick.role) && Intrinsics.areEqual(this.menuItem, menuClick.menuItem);
                }
                return false;
            }

            public int hashCode() {
                return (this.role.hashCode() * 31) + this.menuItem.hashCode();
            }

            public String toString() {
                RoleItem roleItem = this.role;
                return "MenuClick(role=" + roleItem + ", menuItem=" + this.menuItem + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MenuClick(RoleItem role, RoleMenuItem menuItem) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                Intrinsics.checkNotNullParameter(menuItem, "menuItem");
                this.role = role;
                this.menuItem = menuItem;
            }

            public final RoleItem getRole() {
                return this.role;
            }

            public final RoleMenuItem getMenuItem() {
                return this.menuItem;
            }
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$HideMenuDialog;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class HideMenuDialog extends MenuEvent {
            public static final HideMenuDialog INSTANCE = new HideMenuDialog();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HideMenuDialog) {
                    HideMenuDialog hideMenuDialog = (HideMenuDialog) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1002977924;
            }

            public String toString() {
                return "HideMenuDialog";
            }

            private HideMenuDialog() {
                super(null);
            }
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$ServerSwitch;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "section", "Lkntr/app/game/gamebind/bean/SectionItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;Lkntr/app/game/gamebind/bean/SectionItem;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "getSection", "()Lkntr/app/game/gamebind/bean/SectionItem;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ServerSwitch extends MenuEvent {
            private final RoleItem role;
            private final SectionItem section;

            public static /* synthetic */ ServerSwitch copy$default(ServerSwitch serverSwitch, RoleItem roleItem, SectionItem sectionItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = serverSwitch.role;
                }
                if ((i & 2) != 0) {
                    sectionItem = serverSwitch.section;
                }
                return serverSwitch.copy(roleItem, sectionItem);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final SectionItem component2() {
                return this.section;
            }

            public final ServerSwitch copy(RoleItem roleItem, SectionItem sectionItem) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                Intrinsics.checkNotNullParameter(sectionItem, "section");
                return new ServerSwitch(roleItem, sectionItem);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ServerSwitch) {
                    ServerSwitch serverSwitch = (ServerSwitch) obj;
                    return Intrinsics.areEqual(this.role, serverSwitch.role) && Intrinsics.areEqual(this.section, serverSwitch.section);
                }
                return false;
            }

            public int hashCode() {
                return (this.role.hashCode() * 31) + this.section.hashCode();
            }

            public String toString() {
                RoleItem roleItem = this.role;
                return "ServerSwitch(role=" + roleItem + ", section=" + this.section + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ServerSwitch(RoleItem role, SectionItem section) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                Intrinsics.checkNotNullParameter(section, "section");
                this.role = role;
                this.section = section;
            }

            public final RoleItem getRole() {
                return this.role;
            }

            public final SectionItem getSection() {
                return this.section;
            }
        }

        /* compiled from: RolesListViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$Unbind;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent;", "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "<init>", "(Lkntr/app/game/gamebind/bean/RoleItem;)V", "getRole", "()Lkntr/app/game/gamebind/bean/RoleItem;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Unbind extends MenuEvent {
            private final RoleItem role;

            public static /* synthetic */ Unbind copy$default(Unbind unbind, RoleItem roleItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    roleItem = unbind.role;
                }
                return unbind.copy(roleItem);
            }

            public final RoleItem component1() {
                return this.role;
            }

            public final Unbind copy(RoleItem roleItem) {
                Intrinsics.checkNotNullParameter(roleItem, "role");
                return new Unbind(roleItem);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Unbind) && Intrinsics.areEqual(this.role, ((Unbind) obj).role);
            }

            public int hashCode() {
                return this.role.hashCode();
            }

            public String toString() {
                return "Unbind(role=" + this.role + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Unbind(RoleItem role) {
                super(null);
                Intrinsics.checkNotNullParameter(role, "role");
                this.role = role;
            }

            public final RoleItem getRole() {
                return this.role;
            }
        }
    }
}