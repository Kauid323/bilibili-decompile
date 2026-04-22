package tv.danmaku.bili.quick.network;

import android.content.Context;
import bili.resource.account.R;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.quick.network.NetworkDialogResult;
import tv.danmaku.bili.report.LoginReportHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkPermissionDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.quick.network.NetworkPermissionDialog$getPhoneInfo$1", f = "NetworkPermissionDialog.kt", i = {0, 0}, l = {BR.hasRating}, m = "invokeSuspend", n = {"fromSpmid", "getPhoneInfoSuc"}, s = {"L$0", "I$0"}, v = 1)
public final class NetworkPermissionDialog$getPhoneInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ NetworkPermissionDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkPermissionDialog$getPhoneInfo$1(NetworkPermissionDialog networkPermissionDialog, Context context, Continuation<? super NetworkPermissionDialog$getPhoneInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = networkPermissionDialog;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkPermissionDialog$getPhoneInfo$1(this.this$0, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String fromSpmid;
        int i;
        TInfoLogin info;
        Object $result2;
        Integer code;
        LoginQuickManager.PhoneInfoBean phoneInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
                i = 0;
                info = this.this$0.mInfo;
                if (info != null) {
                    final String netType = LoginQuickManager.INSTANCE.getNetType(this.$context);
                    OnePassLoginPathLinkManager onePassLoginPathLinkManager = OnePassLoginPathLinkManager.INSTANCE;
                    final Context context = this.$context;
                    onePassLoginPathLinkManager.updateData(fromSpmid, new Function1() { // from class: tv.danmaku.bili.quick.network.NetworkPermissionDialog$getPhoneInfo$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            OnePassLoginPhoneData invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = NetworkPermissionDialog$getPhoneInfo$1.invokeSuspend$lambda$0(netType, context, (OnePassLoginPhoneData) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid, OnePassLoginPhaseType.CheckConditions.INSTANCE);
                    LoginQuickManager loginQuickManager = LoginQuickManager.INSTANCE;
                    TInfoLogin.QuickBean quickBean = info.login.quick;
                    Intrinsics.checkNotNullExpressionValue(quickBean, "quick");
                    if (loginQuickManager.isNetOk(netType, quickBean)) {
                        this.L$0 = fromSpmid;
                        this.I$0 = 0;
                        this.label = 1;
                        Object suspendGetPhoneInfo = LoginQuickManager.INSTANCE.suspendGetPhoneInfo(this.$context, QuickLoginTag.MAIN, (Continuation) this);
                        if (suspendGetPhoneInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = suspendGetPhoneInfo;
                        Pair pair = (Pair) $result;
                        code = (Integer) pair.component1();
                        phoneInfo = (LoginQuickManager.PhoneInfoBean) pair.component2();
                        if (code == null || code.intValue() != 1 || phoneInfo == null) {
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "get phone info with error : " + (phoneInfo == null ? phoneInfo.getMsg() : null));
                            break;
                        } else {
                            i = 1;
                            OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                            break;
                        }
                    } else {
                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OPERATOR_DISALLOW);
                        break;
                    }
                }
                break;
            case 1:
                int i2 = this.I$0;
                fromSpmid = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                i = i2;
                $result2 = $result;
                Pair pair2 = (Pair) $result;
                code = (Integer) pair2.component1();
                phoneInfo = (LoginQuickManager.PhoneInfoBean) pair2.component2();
                if (code == null) {
                    i = 1;
                    OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                    break;
                }
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "get phone info with error : " + (phoneInfo == null ? phoneInfo.getMsg() : null));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (i == 0) {
            ToastHelper.showToastShort(this.this$0.getActivity(), R.string.account_global_string_35);
        }
        this.this$0.mDialogResult = new NetworkDialogResult.HasOpenNetwork(i != 0);
        this.this$0.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnePassLoginPhoneData invokeSuspend$lambda$0(String $netType, Context $context, OnePassLoginPhoneData it) {
        return new OnePassLoginPhoneData($netType, PhoneUtils.getOriginSimOperator($context) != null, PhoneUtils.isPad($context));
    }
}