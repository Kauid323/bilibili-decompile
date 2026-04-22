package tv.danmaku.bili.safe;

import android.content.Context;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.AccessToken;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliSafeHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/safe/BiliSafeHelper;", "", "<init>", "()V", "setPassWord", "", "passWord", "", "context", "Landroid/content/Context;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliSafeHelper {
    public static final int $stable = 0;
    public static final BiliSafeHelper INSTANCE = new BiliSafeHelper();

    private BiliSafeHelper() {
    }

    @JvmStatic
    public static final void setPassWord(String passWord, Context context) throws AccountException {
        Intrinsics.checkNotNullParameter(context, "context");
        AccessToken accessToken = BiliAccounts.get(context).loadAccessToken();
        if (accessToken != null) {
            String str = accessToken.mAccessKey;
            Intrinsics.checkNotNull(passWord);
            BiliSafeApi.setPwd(str, passWord);
        }
    }
}