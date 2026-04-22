package tv.danmaku.bili.ui.main2;

import com.bilibili.lib.homepage.mine.IMineMenuItemRedirectService;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AccountMineInfoManagerHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/main2/AccountMineInfoManagerHelper;", "Lcom/bilibili/lib/homepage/mine/IMineMenuItemRedirectService;", "<init>", "()V", "createMineSolution", "Lcom/bilibili/lib/homepage/mine/IMinePageInfo;", "item", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("mine_page_manager")
public final class AccountMineInfoManagerHelper implements IMineMenuItemRedirectService {
    public static final int $stable = 0;

    public IMinePageInfo createMineSolution(MenuGroup.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        IMinePageInfo createMineSolution = AccountMineInfoManager.createMineSolution(item);
        Intrinsics.checkNotNullExpressionValue(createMineSolution, "createMineSolution(...)");
        return createMineSolution;
    }
}