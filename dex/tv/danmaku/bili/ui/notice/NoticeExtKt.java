package tv.danmaku.bili.ui.notice;

import android.app.Application;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.mine.MenuItemTip;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: NoticeExt.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\n*\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002\u001a\u001f\u0010\u0010\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\r0\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\u0010\u0010\u0017\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\r0\u000f\u001a\f\u0010\u0018\u001a\u0004\u0018\u00010\u000b*\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u000b\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\r\u001a.\u0010\u001c\u001a\u0004\u0018\u00010\r*\b\u0012\u0004\u0012\u00020\r0\u000f2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0\u001eH\u0086\bø\u0001\u0000\u001a\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r*\b\u0012\u0004\u0012\u00020\r0\u000f\u001a\\\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\"\u0018\u00010!\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u00122!\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001b0\u001eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"NOTICE_CLOSED_PREFIX", "", "GAME_TIP_CLOSED_PREFIX", "GAME_TIPS_READ_GROUP_IDS", "GAME_TIPS_READ_GROUP_IDS_INDEX", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "closeAsNotice", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "close", "Lcom/bilibili/lib/homepage/mine/MenuItemTip;", "getGroupsIdsKey", "", "setCurrent", "index", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getTipsIfShown", "cacheService", "Ltv/danmaku/bili/ui/notice/NoticeCacheService;", "getLastMenuItemIndex", "findFirstNotice", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "isClosed", "", "findNext", "moveCursorPredicate", "Lkotlin/Function1;", "findValidOrNull", "findValidNext", "Lkotlin/Pair;", "T", "point", "predicate", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "t", "(Ljava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NoticeExtKt {
    private static final String GAME_TIPS_READ_GROUP_IDS = "game_tips_read_group_ids";
    private static final String GAME_TIPS_READ_GROUP_IDS_INDEX = "game_tips_read_group_ids_index";
    private static final String GAME_TIP_CLOSED_PREFIX = "game_tip_closed_";
    private static final String NOTICE_CLOSED_PREFIX = "notice_closed_";

    private static final Context getContext() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        return application;
    }

    public static final void closeAsNotice(MenuGroup.Item $this$closeAsNotice) {
        Intrinsics.checkNotNullParameter($this$closeAsNotice, "<this>");
        if ($this$closeAsNotice.commonOpItem != null) {
            MenuGroup.CommonOpItem commonOpItem = $this$closeAsNotice.commonOpItem;
            boolean z = false;
            if (commonOpItem != null && commonOpItem.linkType == 5) {
                z = true;
            }
            if (!z) {
                return;
            }
            BiliGlobalPreferenceHelper.getInstance(getContext()).setBoolean(NOTICE_CLOSED_PREFIX + $this$closeAsNotice.id, true);
        }
    }

    public static final void close(MenuItemTip $this$close) {
        Intrinsics.checkNotNullParameter($this$close, "<this>");
        BiliGlobalPreferenceHelper biliGlobalPreferenceHelper = BiliGlobalPreferenceHelper.getInstance(getContext());
        String id = $this$close.getId();
        if (id == null) {
            id = "";
        }
        biliGlobalPreferenceHelper.setBoolean(GAME_TIP_CLOSED_PREFIX + id, true);
    }

    private static final String getGroupsIdsKey(List<MenuItemTip> list) {
        return CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.notice.NoticeExtKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence groupsIdsKey$lambda$0;
                groupsIdsKey$lambda$0 = NoticeExtKt.getGroupsIdsKey$lambda$0((MenuItemTip) obj);
                return groupsIdsKey$lambda$0;
            }
        }, 31, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getGroupsIdsKey$lambda$0(MenuItemTip it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String id = it.getId();
        if (id == null) {
            id = "";
        }
        return id;
    }

    public static final void setCurrent(List<MenuItemTip> list, Integer index) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        BiliGlobalPreferenceHelper $this$setCurrent_u24lambda_u240 = BiliGlobalPreferenceHelper.getInstance(getContext());
        $this$setCurrent_u24lambda_u240.setString(GAME_TIPS_READ_GROUP_IDS, getGroupsIdsKey(list));
        $this$setCurrent_u24lambda_u240.setInteger(GAME_TIPS_READ_GROUP_IDS_INDEX, index != null ? index.intValue() : -1);
    }

    public static final List<MenuItemTip> getTipsIfShown(List<MenuItemTip> list, NoticeCacheService cacheService) {
        Iterable $this$any$iv;
        Intrinsics.checkNotNullParameter(cacheService, "cacheService");
        if (cacheService.isTipsHide()) {
            boolean z = false;
            if (list != null) {
                List<MenuItemTip> $this$any$iv2 = list;
                if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
                    Iterator<T> it = $this$any$iv2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            $this$any$iv = null;
                            break;
                        }
                        Object element$iv = it.next();
                        MenuItemTip it2 = (MenuItemTip) element$iv;
                        if (!cacheService.isShown(it2.getId())) {
                            $this$any$iv = 1;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                if ($this$any$iv == 1) {
                    z = true;
                }
            }
            if (!z) {
                return null;
            }
        }
        if (list != null) {
            List<MenuItemTip> $this$onEach$iv = list;
            for (Object element$iv2 : $this$onEach$iv) {
                MenuItemTip it3 = (MenuItemTip) element$iv2;
                cacheService.markAsShown(it3.getId());
            }
            List<MenuItemTip> list2 = $this$onEach$iv;
            cacheService.showTips();
            return list2;
        }
        return null;
    }

    public static final int getLastMenuItemIndex(List<MenuItemTip> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        String key = getGroupsIdsKey(list);
        BiliGlobalPreferenceHelper sp = BiliGlobalPreferenceHelper.getInstance(getContext());
        String lastGroup = sp.optString(GAME_TIPS_READ_GROUP_IDS, (String) null);
        if (Intrinsics.areEqual(lastGroup, key)) {
            return sp.optInteger(GAME_TIPS_READ_GROUP_IDS_INDEX, -1);
        }
        return -1;
    }

    public static final MenuGroup.Item findFirstNotice(MenuGroup $this$findFirstNotice) {
        Iterable iterable;
        Intrinsics.checkNotNullParameter($this$findFirstNotice, "<this>");
        Object obj = null;
        if ($this$findFirstNotice.moduleType == 3 && (iterable = $this$findFirstNotice.itemList) != null) {
            Iterable $this$firstOrNull$iv = iterable;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                MenuGroup.Item it2 = (MenuGroup.Item) element$iv;
                MenuGroup.CommonOpItem commonOpItem = it2.commonOpItem;
                Integer valueOf = commonOpItem != null ? Integer.valueOf(commonOpItem.linkType) : null;
                boolean z = false;
                if (valueOf != null && valueOf.intValue() == 5) {
                    Intrinsics.checkNotNull(it2);
                    if (isClosed(it2)) {
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                } else if ((valueOf != null && valueOf.intValue() == 0) || ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2))) {
                    z = true;
                    continue;
                }
                if (z) {
                    obj = element$iv;
                    break;
                }
            }
            return (MenuGroup.Item) obj;
        }
        return null;
    }

    public static final boolean isClosed(MenuGroup.Item $this$isClosed) {
        Intrinsics.checkNotNullParameter($this$isClosed, "<this>");
        return BiliGlobalPreferenceHelper.getInstance(getContext()).optBoolean(NOTICE_CLOSED_PREFIX + $this$isClosed.id, false);
    }

    public static final boolean isClosed(MenuItemTip $this$isClosed) {
        Intrinsics.checkNotNullParameter($this$isClosed, "<this>");
        BiliGlobalPreferenceHelper biliGlobalPreferenceHelper = BiliGlobalPreferenceHelper.getInstance(getContext());
        String id = $this$isClosed.getId();
        if (id == null) {
            id = "";
        }
        return biliGlobalPreferenceHelper.optBoolean(GAME_TIP_CLOSED_PREFIX + id, false);
    }

    public static /* synthetic */ MenuItemTip findNext$default(List $this$findNext_u24default, Function1 moveCursorPredicate, int i, Object obj) {
        Pair it;
        NoticeExtKt$findNext$1 moveCursorPredicate2 = (i & 1) != 0 ? new Function1<Integer, Boolean>() { // from class: tv.danmaku.bili.ui.notice.NoticeExtKt$findNext$1
            public final Boolean invoke(int it2) {
                return true;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }
        } : moveCursorPredicate;
        Intrinsics.checkNotNullParameter($this$findNext_u24default, "<this>");
        Intrinsics.checkNotNullParameter(moveCursorPredicate2, "moveCursorPredicate");
        int current = getLastMenuItemIndex($this$findNext_u24default);
        if ($this$findNext_u24default.size() == 0) {
            it = null;
        } else {
            List arrayList = $this$findNext_u24default instanceof RandomAccess ? $this$findNext_u24default : new ArrayList($this$findNext_u24default);
            int p$iv = RangesKt.coerceAtLeast(current, -1);
            int offset$iv = 1;
            int size = $this$findNext_u24default.size();
            if (1 <= size) {
                while (true) {
                    int index$iv = (p$iv + offset$iv) % $this$findNext_u24default.size();
                    Object node$iv = CollectionsKt.getOrNull(arrayList, index$iv);
                    if (node$iv != null) {
                        MenuItemTip it2 = (MenuItemTip) node$iv;
                        if (it2.checkValid() && !isClosed(it2)) {
                            it = TuplesKt.to(Integer.valueOf(index$iv), node$iv);
                            break;
                        }
                    }
                    if (offset$iv == size) {
                        break;
                    }
                    offset$iv++;
                }
            }
            it = null;
        }
        if (it != null) {
            if (((Boolean) moveCursorPredicate2.invoke(it.getFirst())).booleanValue()) {
                setCurrent($this$findNext_u24default, (Integer) it.getFirst());
            }
            return (MenuItemTip) it.getSecond();
        }
        return null;
    }

    public static final MenuItemTip findNext(List<MenuItemTip> list, Function1<? super Integer, Boolean> function1) {
        Pair pair;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "moveCursorPredicate");
        int current = getLastMenuItemIndex(list);
        if (list.size() == 0) {
            pair = null;
        } else {
            List<MenuItemTip> arrayList = list instanceof RandomAccess ? list : new ArrayList<>(list);
            int p$iv = RangesKt.coerceAtLeast(current, -1);
            int offset$iv = 1;
            int size = list.size();
            if (1 <= size) {
                while (true) {
                    int index$iv = (p$iv + offset$iv) % list.size();
                    Object node$iv = CollectionsKt.getOrNull(arrayList, index$iv);
                    if (node$iv != null) {
                        MenuItemTip it = (MenuItemTip) node$iv;
                        if (it.checkValid() && !isClosed(it)) {
                            pair = TuplesKt.to(Integer.valueOf(index$iv), node$iv);
                            break;
                        }
                    }
                    if (offset$iv == size) {
                        break;
                    }
                    offset$iv++;
                }
            }
            pair = null;
        }
        if (pair != null) {
            Pair it2 = pair;
            if (((Boolean) function1.invoke(it2.getFirst())).booleanValue()) {
                setCurrent(list, (Integer) it2.getFirst());
            }
            return (MenuItemTip) it2.getSecond();
        }
        return null;
    }

    public static final MenuItemTip findValidOrNull(List<MenuItemTip> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int current = getLastMenuItemIndex(list);
        MenuItemTip it = (MenuItemTip) CollectionsKt.getOrNull(list, current);
        if (it != null) {
            if (it.checkValid() && !isClosed(it)) {
                return it;
            }
        }
        return null;
    }

    public static final <T> Pair<Integer, T> findValidNext(List<? extends T> list, Integer point, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (list.size() == 0) {
            return null;
        }
        List<? extends T> arrayList = list instanceof RandomAccess ? list : new ArrayList<>(list);
        int p = RangesKt.coerceAtLeast(point != null ? point.intValue() : -1, -1);
        int offset = 1;
        int size = list.size();
        if (1 <= size) {
            while (true) {
                int index = (p + offset) % list.size();
                Object node = CollectionsKt.getOrNull(arrayList, index);
                if (node == null || !((Boolean) function1.invoke(node)).booleanValue()) {
                    if (offset == size) {
                        break;
                    }
                    offset++;
                } else {
                    return TuplesKt.to(Integer.valueOf(index), node);
                }
            }
        }
        return null;
    }
}