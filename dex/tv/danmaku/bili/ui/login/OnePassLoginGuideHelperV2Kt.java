package tv.danmaku.bili.ui.login;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;

/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ONE_PASS_LOGIN_RULE_B", "", "loadAccount", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "Landroidx/fragment/app/FragmentActivity;", "fastLoginInfo", "Lcom/bilibili/lib/accounts/FastLoginInfo;", "(Landroidx/fragment/app/FragmentActivity;Lcom/bilibili/lib/accounts/FastLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginGuideHelperV2Kt {
    private static final int ONE_PASS_LOGIN_RULE_B = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadAccount(FragmentActivity $this$loadAccount, FastLoginInfo fastLoginInfo, Continuation<? super SimpleAccountItem> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new OnePassLoginGuideHelperV2Kt$loadAccount$2(fastLoginInfo, $this$loadAccount, null), continuation);
    }
}