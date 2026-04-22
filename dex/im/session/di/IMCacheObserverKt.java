package im.session.di;

import com.bilibili.lib.gripper.api.PreTrigger;
import im.session.service.IMSessionDataCacheService;
import kntr.base.account.KAccountStore;
import kntr.common.restricted.IRestrictedMode;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: IMCacheObserver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"establishCacheObserver", "", "account", "Lkntr/base/account/KAccountStore;", "cacheService", "Lim/session/service/IMSessionDataCacheService;", "restrictedMode", "Lkntr/common/restricted/IRestrictedMode;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMCacheObserverKt {
    @PreTrigger(trigger = "OnPrivacyAllowed")
    public static final void establishCacheObserver(KAccountStore account, IMSessionDataCacheService cacheService, IRestrictedMode restrictedMode) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(cacheService, "cacheService");
        Intrinsics.checkNotNullParameter(restrictedMode, "restrictedMode");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new IMCacheObserverKt$establishCacheObserver$1(account, restrictedMode, cacheService, null), 3, (Object) null);
    }
}