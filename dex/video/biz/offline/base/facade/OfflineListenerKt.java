package video.biz.offline.base.facade;

import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.OfflineUserInfo;

/* compiled from: OfflineListener.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"addNetworkListener", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addAccountListener", "updateVipState", "state", "Lkntr/base/account/AccountState;", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineListenerKt {
    public static final /* synthetic */ Object access$addAccountListener(Continuation $completion) {
        return addAccountListener($completion);
    }

    public static final /* synthetic */ Object access$addNetworkListener(Continuation $completion) {
        return addNetworkListener($completion);
    }

    public static final Object addNetworkListener(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new OfflineListenerKt$addNetworkListener$2(null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static final Object addAccountListener(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new OfflineListenerKt$addAccountListener$2(null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static final void updateVipState(AccountState state) {
        OfflineUserInfo offlineUserInfo;
        Config.Companion companion = Config.Companion;
        if (state instanceof AccountState.Idle) {
            offlineUserInfo = null;
        } else if (!(state instanceof AccountState.Logged)) {
            throw new NoWhenBranchMatchedException();
        } else {
            offlineUserInfo = new OfflineUserInfo(((AccountState.Logged) state).getUserInfo().getMid(), ((AccountState.Logged) state).getUserInfo().getVip().getStatus() == 1, ((AccountState.Logged) state).getUserInfo().getVip().getEndTimestamp());
        }
        companion.setUserInfo(offlineUserInfo);
    }
}