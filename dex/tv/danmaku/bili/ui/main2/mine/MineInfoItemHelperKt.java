package tv.danmaku.bili.ui.main2.mine;

import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.mine.MenuItemTip;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: MineInfoItemHelper.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u0004\u0018\u00010\u0003\u001a\u001e\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¨\u0006\u0004"}, d2 = {"setLocalDefault", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineInfoItemHelperKt {
    public static final List<MenuGroup> setLocalDefault(AccountMine $this$setLocalDefault) {
        if ($this$setLocalDefault != null) {
            Iterable iterable = $this$setLocalDefault.gameTips;
            if (iterable != null) {
                Iterable $this$forEach$iv = iterable;
                for (Object element$iv : $this$forEach$iv) {
                    MenuItemTip it = (MenuItemTip) element$iv;
                    if (it != null) {
                        it.setLocalDefault(true);
                    }
                }
            }
            return setLocalDefault((List<? extends MenuGroup>) $this$setLocalDefault.sectionListV2);
        }
        return null;
    }

    public static final List<MenuGroup> setLocalDefault(List<? extends MenuGroup> list) {
        Iterable iterable;
        MenuGroup.MineButton mineButton;
        if (list == null) {
            return null;
        }
        List<? extends MenuGroup> $this$onEach$iv = list;
        for (Object element$iv : $this$onEach$iv) {
            MenuGroup menuGroup = (MenuGroup) element$iv;
            if (menuGroup != null && (mineButton = menuGroup.button) != null) {
                mineButton.localDefault = true;
            }
            if (menuGroup != null && (iterable = menuGroup.itemList) != null) {
                Iterable $this$onEach$iv2 = iterable;
                for (Object element$iv2 : $this$onEach$iv2) {
                    MenuGroup.Item it = (MenuGroup.Item) element$iv2;
                    if (it != null) {
                        it.localDefault = true;
                    }
                }
                List list2 = (List) $this$onEach$iv2;
            }
        }
        return $this$onEach$iv;
    }
}