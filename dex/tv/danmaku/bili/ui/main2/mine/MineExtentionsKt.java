package tv.danmaku.bili.ui.main2.mine;

import android.content.Context;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.mine.MenuItemTip;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: MineExtentions.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\f\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u0001\u001a\f\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\u0002\u001a\f\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u0002\u001a \u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u001a \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"getBadgeNum", "Lcom/bilibili/lib/badge/Badge;", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "context", "Landroid/content/Context;", "max", "", "getNumber", "isShowMngResource", "", "isShowLocalIcon", "makeLocalPropertiesSameWith", "", "", "Lcom/bilibili/lib/homepage/mine/MenuItemTip;", "others", "shouldShowRedDotForNew", ReportEvent.EVENT_TYPE_SHOW, "id", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineExtentionsKt {
    public static /* synthetic */ Badge getBadgeNum$default(MenuGroup.Item item, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return getBadgeNum(item, context, i);
    }

    public static final Badge getBadgeNum(MenuGroup.Item $this$getBadgeNum, Context context, int max) {
        MenuGroup.RedDotSecond redDotSecond;
        Intrinsics.checkNotNullParameter(context, "context");
        if ($this$getBadgeNum == null) {
            return null;
        }
        if ($this$getBadgeNum.redDotSecond != null) {
            MenuGroup.RedDotSecond redDotSecond2 = $this$getBadgeNum.redDotSecond;
            Integer valueOf = redDotSecond2 != null ? Integer.valueOf(redDotSecond2.dotType) : null;
            int i = MenuGroup.RedDotSecond.DotType.RedDot.value;
            if (valueOf != null && valueOf.intValue() == i) {
                return Badge.obtainMole();
            }
            int i2 = MenuGroup.RedDotSecond.DotType.Number.value;
            if (valueOf == null || valueOf.intValue() != i2 || (redDotSecond = $this$getBadgeNum.redDotSecond) == null) {
                return null;
            }
            int it = redDotSecond.count;
            return Badge.obtainNumber(it, max);
        } else if (shouldShowRedDotForNew(context, $this$getBadgeNum.redDotRorNew, String.valueOf($this$getBadgeNum.id))) {
            return Badge.obtainNumber(1, max);
        } else {
            if ($this$getBadgeNum.redDot == 1 && $this$getBadgeNum.localRedDot <= 0) {
                return Badge.obtainNumber(1, max);
            }
            if ($this$getBadgeNum.localRedDot <= 0) {
                return null;
            }
            return Badge.obtainNumber($this$getBadgeNum.localRedDot, max);
        }
    }

    public static final int getNumber(Badge $this$getNumber) {
        if ($this$getNumber != null) {
            return $this$getNumber.msgCount;
        }
        return 0;
    }

    public static final boolean isShowMngResource(MenuGroup.Item $this$isShowMngResource) {
        return $this$isShowMngResource != null && $this$isShowMngResource.itemMngResource != null && StringUtil.isNotBlank($this$isShowMngResource.itemMngResource.icon) && MngResourceManager.isShowMngResource($this$isShowMngResource.itemMngResource);
    }

    public static final boolean isShowLocalIcon(MenuGroup.Item $this$isShowLocalIcon) {
        return $this$isShowLocalIcon != null && StringUtil.isNotBlank($this$isShowLocalIcon.tempIcon);
    }

    public static final void makeLocalPropertiesSameWith(List<MenuItemTip> list, List<MenuItemTip> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (Intrinsics.areEqual(list, list2)) {
            List<MenuItemTip> $this$onEachIndexed$iv = list;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$onEachIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                MenuItemTip tip = (MenuItemTip) item$iv$iv;
                MenuItemTip other = (MenuItemTip) CollectionsKt.getOrNull(list2, index$iv$iv);
                if (other != null) {
                    tip.setClicked(other.getClicked());
                    tip.setExposed(other.getExposed());
                }
                index$iv$iv = index$iv$iv2;
            }
        }
    }

    private static final boolean shouldShowRedDotForNew(Context context, boolean show, String id) {
        if (!show) {
            MinePrefHelper.INSTANCE.removeShowForUpdate(context, id);
            return false;
        } else if (!MinePrefHelper.INSTANCE.isFirstStart(context) || MinePrefHelper.INSTANCE.isClickedForNew(context, id)) {
            return !MinePrefHelper.INSTANCE.isFirstStart(context) && MinePrefHelper.INSTANCE.isShowForUpdate(context, id);
        } else {
            return true;
        }
    }
}