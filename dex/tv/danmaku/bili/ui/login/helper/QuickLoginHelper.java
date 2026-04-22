package tv.danmaku.bili.ui.login.helper;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.ui.IDrawerHost;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.quick.network.NetworkDialogResult;
import tv.danmaku.bili.quick.network.NetworkPermissionDialog;
import tv.danmaku.bili.quick.network.NetworkPermissionDialogKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2;
import tv.danmaku.bili.ui.login.helper.reducer.ExperimentCheckReducer;
import tv.danmaku.bili.ui.login.helper.reducer.LoginTypeCheckerReducer;
import tv.danmaku.bili.ui.login.helper.reducer.LoginWayInjectReducer;
import tv.danmaku.bili.ui.login.helper.reducer.NetworkCheckReducer;
import tv.danmaku.bili.ui.login.helper.reducer.PhoneInfoCheckReducer;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/QuickLoginHelper;", "", "reducers", "", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "Ltv/danmaku/bili/ui/login/helper/Reducers;", "<init>", "(Ljava/util/List;)V", "flow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "doCheck", "", "fromSpmId", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goLogin", "", "fromSpmid", "priority", "", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class QuickLoginHelper {
    public static final int $stable = 8;
    private final MutableStateFlow<AutoLoginData> flow;
    private final List<QuickLoginCheckReducer> reducers;

    public QuickLoginHelper() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuickLoginHelper(List<? extends QuickLoginCheckReducer> list) {
        Intrinsics.checkNotNullParameter(list, "reducers");
        this.reducers = list;
        this.flow = StateFlowKt.MutableStateFlow(new AutoLoginData(null, null, null, null, false, 31, null));
    }

    public /* synthetic */ QuickLoginHelper(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? QuickLoginHelperKt.defaultReducerMap() : list);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0166 -> B:34:0x0171). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0187 -> B:42:0x018f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doCheck(String fromSpmId, Context context, Continuation<? super Unit> continuation) {
        QuickLoginHelper$doCheck$1 quickLoginHelper$doCheck$1;
        QuickLoginHelper quickLoginHelper;
        int size;
        String fromSpmId2;
        Context context2;
        Ref.ObjectRef phase;
        Function1 getPhaseTypeByReducer;
        AutoLoginData data;
        QuickLoginCheckReducer reduce;
        int index;
        int index2;
        QuickLoginHelper quickLoginHelper2;
        Object obj;
        Object $result;
        Ref.ObjectRef phase2;
        String fromSpmId3;
        AutoLoginCheckResult result;
        Function1 getPhaseTypeByReducer2;
        Context context3;
        AutoLoginCheckResult result2;
        int index3;
        boolean skip;
        boolean goOn;
        if (continuation instanceof QuickLoginHelper$doCheck$1) {
            quickLoginHelper$doCheck$1 = (QuickLoginHelper$doCheck$1) continuation;
            if ((quickLoginHelper$doCheck$1.label & Integer.MIN_VALUE) != 0) {
                quickLoginHelper$doCheck$1.label -= Integer.MIN_VALUE;
                Object $result2 = quickLoginHelper$doCheck$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                switch (quickLoginHelper$doCheck$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        quickLoginHelper = this;
                        Ref.ObjectRef phase3 = new Ref.ObjectRef();
                        Function1 getPhaseTypeByReducer3 = new Function1() { // from class: tv.danmaku.bili.ui.login.helper.QuickLoginHelper$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                OnePassLoginPhaseType doCheck$lambda$0;
                                doCheck$lambda$0 = QuickLoginHelper.doCheck$lambda$0((QuickLoginCheckReducer) obj2);
                                return doCheck$lambda$0;
                            }
                        };
                        Context context4 = context;
                        String fromSpmId4 = fromSpmId;
                        int index4 = 0;
                        size = quickLoginHelper.reducers.size();
                        Ref.ObjectRef phase4 = phase3;
                        Function1 getPhaseTypeByReducer4 = getPhaseTypeByReducer3;
                        if (index4 < size) {
                            AutoLoginData data2 = (AutoLoginData) quickLoginHelper.flow.getValue();
                            QuickLoginCheckReducer reduce2 = quickLoginHelper.reducers.get(index4);
                            quickLoginHelper$doCheck$1.L$0 = fromSpmId4;
                            quickLoginHelper$doCheck$1.L$1 = context4;
                            quickLoginHelper$doCheck$1.L$2 = phase4;
                            quickLoginHelper$doCheck$1.L$3 = getPhaseTypeByReducer4;
                            quickLoginHelper$doCheck$1.L$4 = data2;
                            quickLoginHelper$doCheck$1.L$5 = reduce2;
                            quickLoginHelper$doCheck$1.I$0 = index4;
                            quickLoginHelper$doCheck$1.I$1 = size;
                            quickLoginHelper$doCheck$1.label = i;
                            Object mo1802beforeCheck5klyPk = reduce2.mo1802beforeCheck5klyPk(context4, fromSpmId4, data2, quickLoginHelper$doCheck$1);
                            if (mo1802beforeCheck5klyPk == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = mo1802beforeCheck5klyPk;
                            fromSpmId2 = fromSpmId4;
                            context2 = context4;
                            phase = phase4;
                            getPhaseTypeByReducer = getPhaseTypeByReducer4;
                            data = data2;
                            reduce = reduce2;
                            index = index4;
                            index2 = size;
                            quickLoginHelper2 = quickLoginHelper;
                            obj = obj2;
                            skip = ((Skip) $result2).m1812unboximpl();
                            if (skip) {
                                OnePassLoginPhaseType it = (OnePassLoginPhaseType) getPhaseTypeByReducer.invoke(reduce);
                                if (!Intrinsics.areEqual(it, phase.element)) {
                                    phase.element = it;
                                    OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmId2, it);
                                }
                                quickLoginHelper$doCheck$1.L$0 = fromSpmId2;
                                quickLoginHelper$doCheck$1.L$1 = context2;
                                quickLoginHelper$doCheck$1.L$2 = phase;
                                quickLoginHelper$doCheck$1.L$3 = getPhaseTypeByReducer;
                                quickLoginHelper$doCheck$1.L$4 = reduce;
                                quickLoginHelper$doCheck$1.L$5 = null;
                                quickLoginHelper$doCheck$1.I$0 = index;
                                quickLoginHelper$doCheck$1.I$1 = index2;
                                quickLoginHelper$doCheck$1.label = 2;
                                $result2 = reduce.check(context2, fromSpmId2, data, quickLoginHelper$doCheck$1);
                                if ($result2 == obj) {
                                    return obj;
                                }
                                phase2 = phase;
                                fromSpmId3 = fromSpmId2;
                                result = (AutoLoginCheckResult) $result2;
                                quickLoginHelper2.flow.setValue(result.getData());
                                quickLoginHelper$doCheck$1.L$0 = fromSpmId3;
                                quickLoginHelper$doCheck$1.L$1 = context2;
                                quickLoginHelper$doCheck$1.L$2 = phase2;
                                quickLoginHelper$doCheck$1.L$3 = getPhaseTypeByReducer;
                                quickLoginHelper$doCheck$1.L$4 = result;
                                quickLoginHelper$doCheck$1.I$0 = index;
                                quickLoginHelper$doCheck$1.I$1 = index2;
                                quickLoginHelper$doCheck$1.label = 3;
                                if (reduce.afterCheck(fromSpmId3, result, quickLoginHelper$doCheck$1) != obj) {
                                    return obj;
                                }
                                getPhaseTypeByReducer2 = getPhaseTypeByReducer;
                                context3 = context2;
                                int i2 = index;
                                result2 = result;
                                $result2 = $result;
                                $result3 = obj;
                                quickLoginHelper = quickLoginHelper2;
                                size = index2;
                                index3 = i2;
                                goOn = result2.getGoOn();
                                if (!goOn) {
                                    index = index3;
                                    fromSpmId4 = fromSpmId3;
                                    context4 = context3;
                                    phase4 = phase2;
                                    getPhaseTypeByReducer4 = getPhaseTypeByReducer2;
                                    i = 1;
                                    index4 = index + 1;
                                    if (index4 < size) {
                                    }
                                } else if (goOn) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                $result2 = $result;
                                $result3 = obj;
                                quickLoginHelper = quickLoginHelper2;
                                size = index2;
                                getPhaseTypeByReducer4 = getPhaseTypeByReducer;
                                phase4 = phase;
                                context4 = context2;
                                fromSpmId4 = fromSpmId2;
                                i = 1;
                                index4 = index + 1;
                                if (index4 < size) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        int i3 = quickLoginHelper$doCheck$1.I$1;
                        int index5 = quickLoginHelper$doCheck$1.I$0;
                        QuickLoginCheckReducer reduce3 = (QuickLoginCheckReducer) quickLoginHelper$doCheck$1.L$5;
                        AutoLoginData data3 = (AutoLoginData) quickLoginHelper$doCheck$1.L$4;
                        Function1 getPhaseTypeByReducer5 = (Function1) quickLoginHelper$doCheck$1.L$3;
                        Ref.ObjectRef phase5 = (Ref.ObjectRef) quickLoginHelper$doCheck$1.L$2;
                        Context context5 = (Context) quickLoginHelper$doCheck$1.L$1;
                        String fromSpmId5 = (String) quickLoginHelper$doCheck$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        fromSpmId2 = fromSpmId5;
                        context2 = context5;
                        phase = phase5;
                        getPhaseTypeByReducer = getPhaseTypeByReducer5;
                        data = data3;
                        reduce = reduce3;
                        index = index5;
                        index2 = i3;
                        quickLoginHelper2 = this;
                        obj = $result3;
                        $result = $result2;
                        skip = ((Skip) $result2).m1812unboximpl();
                        if (skip) {
                        }
                        break;
                    case 2:
                        int i4 = quickLoginHelper$doCheck$1.I$1;
                        int index6 = quickLoginHelper$doCheck$1.I$0;
                        QuickLoginCheckReducer reduce4 = (QuickLoginCheckReducer) quickLoginHelper$doCheck$1.L$4;
                        Function1 getPhaseTypeByReducer6 = (Function1) quickLoginHelper$doCheck$1.L$3;
                        phase2 = (Ref.ObjectRef) quickLoginHelper$doCheck$1.L$2;
                        Context context6 = (Context) quickLoginHelper$doCheck$1.L$1;
                        fromSpmId3 = (String) quickLoginHelper$doCheck$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        context2 = context6;
                        getPhaseTypeByReducer = getPhaseTypeByReducer6;
                        reduce = reduce4;
                        index = index6;
                        index2 = i4;
                        quickLoginHelper2 = this;
                        obj = $result3;
                        $result = $result2;
                        result = (AutoLoginCheckResult) $result2;
                        quickLoginHelper2.flow.setValue(result.getData());
                        quickLoginHelper$doCheck$1.L$0 = fromSpmId3;
                        quickLoginHelper$doCheck$1.L$1 = context2;
                        quickLoginHelper$doCheck$1.L$2 = phase2;
                        quickLoginHelper$doCheck$1.L$3 = getPhaseTypeByReducer;
                        quickLoginHelper$doCheck$1.L$4 = result;
                        quickLoginHelper$doCheck$1.I$0 = index;
                        quickLoginHelper$doCheck$1.I$1 = index2;
                        quickLoginHelper$doCheck$1.label = 3;
                        if (reduce.afterCheck(fromSpmId3, result, quickLoginHelper$doCheck$1) != obj) {
                        }
                        break;
                    case 3:
                        quickLoginHelper = this;
                        size = quickLoginHelper$doCheck$1.I$1;
                        index3 = quickLoginHelper$doCheck$1.I$0;
                        result2 = (AutoLoginCheckResult) quickLoginHelper$doCheck$1.L$4;
                        getPhaseTypeByReducer2 = (Function1) quickLoginHelper$doCheck$1.L$3;
                        phase2 = (Ref.ObjectRef) quickLoginHelper$doCheck$1.L$2;
                        context3 = (Context) quickLoginHelper$doCheck$1.L$1;
                        fromSpmId3 = (String) quickLoginHelper$doCheck$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        goOn = result2.getGoOn();
                        if (!goOn) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        quickLoginHelper$doCheck$1 = new QuickLoginHelper$doCheck$1(this, continuation);
        Object $result22 = quickLoginHelper$doCheck$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = 1;
        switch (quickLoginHelper$doCheck$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnePassLoginPhaseType doCheck$lambda$0(QuickLoginCheckReducer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof LoginTypeCheckerReducer) || (it instanceof ExperimentCheckReducer) || (it instanceof LoginWayInjectReducer)) {
            return OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE;
        }
        if ((it instanceof NetworkCheckReducer) || (it instanceof PhoneInfoCheckReducer)) {
            return OnePassLoginPhaseType.CheckConditions.INSTANCE;
        }
        return OnePassLoginPhaseType.Unknown.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object goLogin(Context context, String fromSpmid, int i, Continuation<? super Boolean> continuation) {
        QuickLoginHelper$goLogin$1 quickLoginHelper$goLogin$1;
        AutoLoginData data;
        boolean z;
        FragmentManager fm;
        Object suspendShow;
        Context context2;
        boolean z2;
        TInfoLogin.AB ab;
        NetworkDialogResult networkRes;
        if (continuation instanceof QuickLoginHelper$goLogin$1) {
            quickLoginHelper$goLogin$1 = (QuickLoginHelper$goLogin$1) continuation;
            if ((quickLoginHelper$goLogin$1.label & Integer.MIN_VALUE) != 0) {
                quickLoginHelper$goLogin$1.label -= Integer.MIN_VALUE;
                Object $result = quickLoginHelper$goLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z3 = true;
                switch (quickLoginHelper$goLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        data = (AutoLoginData) this.flow.getValue();
                        z = false;
                        if (BiliAccounts.get(context).isLogin()) {
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_ALREADY_LOGIN);
                            return Boxing.boxBoolean(false);
                        }
                        LoginWay $this$goLogin_u24lambda_u240 = data.getLoginWay();
                        if ($this$goLogin_u24lambda_u240 != null) {
                            LoginReportHelper.INSTANCE.setFromSpmid(fromSpmid);
                            if ($this$goLogin_u24lambda_u240.getQuick()) {
                                if (UtilKt.findActivityOrNull(context) instanceof IDrawerHost) {
                                    OnePassLoginGuideHelperV2.Companion companion = OnePassLoginGuideHelperV2.Companion;
                                    boolean z4 = $this$goLogin_u24lambda_u240.getValue() != 2;
                                    long onePassLoginGuideSkipTime = OnlineParamsHelper.getOnePassLoginGuideSkipTime();
                                    boolean z5 = $this$goLogin_u24lambda_u240.getValue() == 3;
                                    Pair<String, Boolean> netTypePair = data.getNetTypePair();
                                    if (netTypePair == null) {
                                        netTypePair = TuplesKt.to((Object) null, Boxing.boxBoolean(false));
                                    }
                                    companion.routeToLoginQuick$core_apinkDebug(context, z4, z5, onePassLoginGuideSkipTime, -1, netTypePair, false, (r35 & BR.cover) != 0 ? false : false, (r35 & BR.hallEnterHotText) != 0 ? 2050 : i, (r35 & BR.roleType) != 0 ? "login_guide" : null, (r35 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? false : false, (r35 & 2048) != 0 ? false : false, (r35 & 4096) != 0 ? null : null, (r35 & 8192) != 0 ? "enter_homepage" : fromSpmid);
                                } else {
                                    BLRouter.routeTo(RouteRequestKt.toRouteRequest(RouteUtilKt.LOGIN_QUICK_ROUTE), context);
                                }
                            } else if ($this$goLogin_u24lambda_u240.getSms()) {
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "the login way is not a quick way : " + data.getLoginWay());
                                if (data.getGetPhoneInfoError()) {
                                    TInfoLogin loginInfo = data.getLoginInfo();
                                    if (((loginInfo == null || (ab = loginInfo.ab) == null || !ab.isLoginPopupNonNet()) ? false : true) && RouteUtilKt.hasCardAndOnlyWifi(context)) {
                                        FragmentActivity findFragmentActivityOrNull = ContextUtilKt.findFragmentActivityOrNull(context);
                                        if (findFragmentActivityOrNull == null || (fm = findFragmentActivityOrNull.getSupportFragmentManager()) == null) {
                                            return Boxing.boxBoolean(false);
                                        }
                                        NetworkPermissionDialog newInstance = NetworkPermissionDialog.Companion.newInstance(data.getLoginInfo());
                                        quickLoginHelper$goLogin$1.L$0 = context;
                                        quickLoginHelper$goLogin$1.L$1 = data;
                                        quickLoginHelper$goLogin$1.label = 1;
                                        suspendShow = newInstance.suspendShow(fm, null, quickLoginHelper$goLogin$1);
                                        if (suspendShow == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        context2 = context;
                                        z2 = false;
                                        networkRes = (NetworkDialogResult) suspendShow;
                                        if (!Intrinsics.areEqual(networkRes, NetworkDialogResult.Default.INSTANCE)) {
                                            if (Intrinsics.areEqual(networkRes, NetworkDialogResult.OtherWays.INSTANCE)) {
                                                RouteUtilKt.showSmsLoginDialog$default(context2, null, null, null, false, 28, null);
                                            } else if (!(networkRes instanceof NetworkDialogResult.HasOpenNetwork)) {
                                                throw new NoWhenBranchMatchedException();
                                            } else {
                                                Boxing.boxBoolean(NetworkPermissionDialogKt.retryQuickLogin(context2, data.getLoginInfo(), ((NetworkDialogResult.HasOpenNetwork) networkRes).getGetPhoneInfoSuc()));
                                            }
                                        }
                                    }
                                }
                                if (UtilKt.findActivityOrNull(context) instanceof IDrawerHost) {
                                    Boxing.boxBoolean(OnePassLoginGuideHelperV2.Companion.routeToSmsLoginDialogIfEnable$core_apinkDebug(context, data.getLoginInfo(), -1, false, true, true, i, fromSpmid));
                                } else {
                                    RouteUtilKt.showSmsLoginDialog$default(context, null, null, null, false, 28, null);
                                }
                            } else {
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "the login way is not a quick way : " + data.getLoginWay());
                                z3 = false;
                            }
                            z = z3;
                            return Boxing.boxBoolean(z);
                        }
                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "the login way is not a quick way : " + data.getLoginWay());
                        return Boxing.boxBoolean(z);
                    case 1:
                        z2 = false;
                        data = (AutoLoginData) quickLoginHelper$goLogin$1.L$1;
                        ResultKt.throwOnFailure($result);
                        context2 = (Context) quickLoginHelper$goLogin$1.L$0;
                        suspendShow = $result;
                        networkRes = (NetworkDialogResult) suspendShow;
                        if (!Intrinsics.areEqual(networkRes, NetworkDialogResult.Default.INSTANCE)) {
                        }
                        z = z3;
                        return Boxing.boxBoolean(z);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        quickLoginHelper$goLogin$1 = new QuickLoginHelper$goLogin$1(this, continuation);
        Object $result2 = quickLoginHelper$goLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z32 = true;
        switch (quickLoginHelper$goLogin$1.label) {
        }
    }
}