package tv.danmaku.bili.ui.login;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2Kt$loadAccount$2", f = "OnePassLoginGuideHelperV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OnePassLoginGuideHelperV2Kt$loadAccount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SimpleAccountItem>, Object> {
    final /* synthetic */ FastLoginInfo $fastLoginInfo;
    final /* synthetic */ FragmentActivity $this_loadAccount;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginGuideHelperV2Kt$loadAccount$2(FastLoginInfo fastLoginInfo, FragmentActivity fragmentActivity, Continuation<? super OnePassLoginGuideHelperV2Kt$loadAccount$2> continuation) {
        super(2, continuation);
        this.$fastLoginInfo = fastLoginInfo;
        this.$this_loadAccount = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnePassLoginGuideHelperV2Kt$loadAccount$2(this.$fastLoginInfo, this.$this_loadAccount, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SimpleAccountItem> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    FastLoginInfo it = this.$fastLoginInfo;
                    if (it == null) {
                        return null;
                    }
                    return (SimpleAccountItem) CollectionsKt.firstOrNull(BiliAccounts.get(this.$this_loadAccount).requestAccountInfo(Boxing.boxLong(it.getMid())).getInfos());
                } catch (Exception e) {
                    BLog.e(OnePassLoginGuideHelperV2.TAG, "requestAccountInfo failed", e);
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}