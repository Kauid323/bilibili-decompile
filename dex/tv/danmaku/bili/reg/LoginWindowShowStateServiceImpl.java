package tv.danmaku.bili.reg;

import com.bilibili.module.account.LoginWindowShowStateService;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LoginWindowShowStateServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/reg/LoginWindowShowStateServiceImpl;", "Lcom/bilibili/module/account/LoginWindowShowStateService;", "<init>", "()V", "isShowing", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginWindowShowStateServiceImpl implements LoginWindowShowStateService {
    public static final int $stable = 0;

    public boolean isShowing() {
        return LoginRegHelper.INSTANCE.getCountDownLatch() > 0;
    }
}