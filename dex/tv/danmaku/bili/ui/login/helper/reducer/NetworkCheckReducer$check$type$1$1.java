package tv.danmaku.bili.ui.login.helper.reducer;

import android.content.Context;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
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
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkCheckReducer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.helper.reducer.NetworkCheckReducer$check$type$1$1", f = "NetworkCheckReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NetworkCheckReducer$check$type$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends Boolean>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fromSpmid;
    final /* synthetic */ TInfoLogin.QuickBean $quick;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkCheckReducer$check$type$1$1(Context context, String str, TInfoLogin.QuickBean quickBean, Continuation<? super NetworkCheckReducer$check$type$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$fromSpmid = str;
        this.$quick = quickBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkCheckReducer$check$type$1$1(this.$context, this.$fromSpmid, this.$quick, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<String, Boolean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final String netType = LoginQuickManager.INSTANCE.getNetType(this.$context);
                OnePassLoginPathLinkManager onePassLoginPathLinkManager = OnePassLoginPathLinkManager.INSTANCE;
                String str = this.$fromSpmid;
                final Context context = this.$context;
                onePassLoginPathLinkManager.updateData(str, new Function1() { // from class: tv.danmaku.bili.ui.login.helper.reducer.NetworkCheckReducer$check$type$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        OnePassLoginPhoneData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = NetworkCheckReducer$check$type$1$1.invokeSuspend$lambda$0(netType, context, (OnePassLoginPhoneData) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
                Pair rep = LoginQuickManager.INSTANCE.isNetOkWhitType(netType, this.$quick);
                if (!((Boolean) rep.getSecond()).booleanValue()) {
                    OnePassLoginPathLinkManager onePassLoginPathLinkManager2 = OnePassLoginPathLinkManager.INSTANCE;
                    String str2 = this.$fromSpmid;
                    String str3 = (String) rep.getFirst();
                    onePassLoginPathLinkManager2.stopWithReason(str2, "network operator disallow to quick login -> " + (str3 != null ? OnePassLoginReportManagerKt.getNetworkOperatorNameFromType(str3) : null));
                }
                return rep;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnePassLoginPhoneData invokeSuspend$lambda$0(String $netType, Context $context, OnePassLoginPhoneData it) {
        return new OnePassLoginPhoneData($netType, PhoneUtils.getOriginSimOperator($context) != null, PhoneUtils.isPad($context));
    }
}