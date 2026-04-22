package tv.danmaku.bili.fullscreen.exp;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.pegasus.LoginBlockPegasusService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;

/* compiled from: FullscreenLoginExp.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/fullscreen/exp/LoginBlockPegasusSrv;", "Lcom/bilibili/pegasus/LoginBlockPegasusService;", "<init>", "()V", "processLogin", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginBlockPegasusSrv implements LoginBlockPegasusService {
    public static final int $stable = 0;

    public Object processLogin(Context context, Continuation<? super Unit> continuation) {
        LoginExpType loginGroup = FullscreenLoginExp.INSTANCE.checkLoginExpType();
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "LoginGroup check before pegasus : " + loginGroup);
        if (BiliAccounts.get(context).isLogin() || loginGroup == LoginExpType.CONTROL) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Already logged in or in control, return");
            return Unit.INSTANCE;
        }
        Object launchLogin = FullscreenLoginExpKt.launchLogin(context, loginGroup, continuation);
        return launchLogin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? launchLogin : Unit.INSTANCE;
    }
}