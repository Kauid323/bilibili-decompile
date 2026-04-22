package tv.danmaku.bili.inner;

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
/* compiled from: InnerLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginStateMachine$getAccountInfo$2", f = "InnerLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginStateMachine$getAccountInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SimpleAccountItem>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ SimpleAccountItem $emptyAccount;
    final /* synthetic */ FastLoginInfo $fastLoginInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginStateMachine$getAccountInfo$2(FragmentActivity fragmentActivity, FastLoginInfo fastLoginInfo, SimpleAccountItem simpleAccountItem, Continuation<? super InnerLoginStateMachine$getAccountInfo$2> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$fastLoginInfo = fastLoginInfo;
        this.$emptyAccount = simpleAccountItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginStateMachine$getAccountInfo$2(this.$activity, this.$fastLoginInfo, this.$emptyAccount, continuation);
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
                    SimpleAccountItem simpleAccountItem = (SimpleAccountItem) CollectionsKt.firstOrNull(BiliAccounts.get(this.$activity).requestAccountInfo(Boxing.boxLong(this.$fastLoginInfo.getMid())).getInfos());
                    if (simpleAccountItem == null) {
                        return this.$emptyAccount;
                    }
                    return simpleAccountItem;
                } catch (Exception e) {
                    BLog.e(InnerLoginViewModelKt.TAG_INNER_LOGIN, "get fast account info has exception", e);
                    return this.$emptyAccount;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}