package tv.danmaku.bili.reg;

import android.content.Context;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.reg.ILoginReg;

/* compiled from: ILoginReg.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/reg/OnceLoginReg;", "Ltv/danmaku/bili/reg/ILoginReg;", "<init>", "()V", "changeRegCheckValue", "", "status", "", "selectedReg", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnceLoginReg implements ILoginReg {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.reg.ILoginReg
    public /* synthetic */ boolean showReg(Context context) {
        return ILoginReg.CC.$default$showReg(this, context);
    }

    @Override // tv.danmaku.bili.reg.ILoginReg
    public void changeRegCheckValue(boolean status) {
        BLog.d("ILoginReg", "changeRegCheckValue = " + status);
        LoginRegHelper.INSTANCE.setRegCheckStatus(status);
    }

    @Override // tv.danmaku.bili.reg.ILoginReg
    public boolean selectedReg() {
        int countDownLatch = LoginRegHelper.INSTANCE.getCountDownLatch();
        BLog.d("ILoginReg", "LoginRegHelper.countDownLatch  = " + countDownLatch + " and LoginRegHelper.regCheckStatus = " + LoginRegHelper.INSTANCE.getRegCheckStatus());
        if (LoginRegHelper.INSTANCE.getCountDownLatch() < 1 || !LoginRegHelper.INSTANCE.getRegCheckStatus()) {
            if (LoginRegHelper.INSTANCE.getCountDownLatch() < 1) {
                LoginRegHelper.INSTANCE.setRegCheckStatus(false);
                return false;
            }
            return false;
        }
        return true;
    }
}