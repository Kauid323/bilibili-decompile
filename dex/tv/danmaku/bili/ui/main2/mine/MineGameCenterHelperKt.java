package tv.danmaku.bili.ui.main2.mine;

import com.bilibili.biligame.GameCenterService;
import com.bilibili.biligame.bean.GameCenterEntrance;
import com.bilibili.biligame.external.GameCenterEntryService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: MineGameCenterHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0010\u0010\b\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0000\u001a\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"checkValidOf", "", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "item", "toDesc", "", "Lcom/bilibili/biligame/bean/GameCenterEntrance;", "toDescG", "transformToGameCenterEntrance", "transformFromGameCenterEntrance", "notifyWeakClick", "", "url", "GAME_CENTER_ENTRANCE_TYPE_DOWNLOAD_MANAGER", "", "GAME_CENTER_ENTRANCE_TYPE_GAME_UPDATE", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGameCenterHelperKt {
    public static final int GAME_CENTER_ENTRANCE_TYPE_DOWNLOAD_MANAGER = 4;
    public static final int GAME_CENTER_ENTRANCE_TYPE_GAME_UPDATE = 3;

    public static final /* synthetic */ boolean access$checkValidOf(List $receiver, MenuGroup.Item item) {
        return checkValidOf($receiver, item);
    }

    public static final boolean checkValidOf(List<? extends MenuGroup.Item> list, MenuGroup.Item item) {
        Object element$iv;
        MenuGroup.Item it;
        if (list != null) {
            List<? extends MenuGroup.Item> $this$firstOrNull$iv = list;
            Iterator<T> it2 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    element$iv = it2.next();
                    if (((MenuGroup.Item) element$iv).id == item.id) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            MenuGroup.Item it3 = (MenuGroup.Item) element$iv;
            if (it3 == null) {
                return false;
            }
            if (Intrinsics.areEqual(item.tempIcon, it3.icon)) {
                item.tempIcon = null;
            }
            item.icon = it3.icon;
            return true;
        }
        return false;
    }

    public static final String toDesc(MenuGroup.Item $this$toDesc) {
        Intrinsics.checkNotNullParameter($this$toDesc, "<this>");
        long j = $this$toDesc.id;
        String str = $this$toDesc.title;
        int i = $this$toDesc.redDot;
        return "{id=" + j + ", title=" + str + ", red_dot=" + i + ", red_dot_num=" + $this$toDesc.localRedDot + "}";
    }

    public static final String toDesc(GameCenterEntrance $this$toDesc) {
        Intrinsics.checkNotNullParameter($this$toDesc, "<this>");
        long id = $this$toDesc.getId();
        String title = $this$toDesc.getTitle();
        return "{id=" + id + ", title=" + title + ", red_dot=" + $this$toDesc.getRed_dot() + "}";
    }

    public static final String toDesc(List<? extends MenuGroup.Item> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelperKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence desc$lambda$0;
                desc$lambda$0 = MineGameCenterHelperKt.toDesc$lambda$0((MenuGroup.Item) obj);
                return desc$lambda$0;
            }
        }, 31, (Object) null);
    }

    public static final CharSequence toDesc$lambda$0(MenuGroup.Item it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return toDesc(it);
    }

    public static final String toDescG(List<GameCenterEntrance> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelperKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence descG$lambda$0;
                descG$lambda$0 = MineGameCenterHelperKt.toDescG$lambda$0((GameCenterEntrance) obj);
                return descG$lambda$0;
            }
        }, 31, (Object) null);
    }

    public static final CharSequence toDescG$lambda$0(GameCenterEntrance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return toDesc(it);
    }

    public static final GameCenterEntrance transformToGameCenterEntrance(MenuGroup.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        GameCenterEntrance $this$transformToGameCenterEntrance_u24lambda_u240 = new GameCenterEntrance();
        $this$transformToGameCenterEntrance_u24lambda_u240.setId(item.id);
        $this$transformToGameCenterEntrance_u24lambda_u240.setRed_dot(item.localRedDot);
        $this$transformToGameCenterEntrance_u24lambda_u240.setTitle(item.title);
        $this$transformToGameCenterEntrance_u24lambda_u240.setUrl(item.uri);
        return $this$transformToGameCenterEntrance_u24lambda_u240;
    }

    public static final MenuGroup.Item transformFromGameCenterEntrance(GameCenterEntrance item) {
        Intrinsics.checkNotNullParameter(item, "item");
        MenuGroup.Item $this$transformFromGameCenterEntrance_u24lambda_u240 = new MenuGroup.Item();
        $this$transformFromGameCenterEntrance_u24lambda_u240.id = item.getId();
        $this$transformFromGameCenterEntrance_u24lambda_u240.tempIcon = item.getIcon();
        $this$transformFromGameCenterEntrance_u24lambda_u240.localRedDot = item.getRed_dot();
        $this$transformFromGameCenterEntrance_u24lambda_u240.title = item.getTitle();
        $this$transformFromGameCenterEntrance_u24lambda_u240.uri = item.getUrl();
        $this$transformFromGameCenterEntrance_u24lambda_u240.dismissRedDotOnClicked = item.getType() != 4;
        $this$transformFromGameCenterEntrance_u24lambda_u240.localDefault = item.getDefault();
        return $this$transformFromGameCenterEntrance_u24lambda_u240;
    }

    public static final void notifyWeakClick(String url) {
        GameCenterEntryService gameCenterEntryService;
        GameCenterService gameCenterService = (GameCenterService) BLRouter.INSTANCE.get(GameCenterService.class, AppConfig.HOST_GAME_CENTER);
        if (gameCenterService != null && (gameCenterEntryService = gameCenterService.getGameCenterEntryService((List) null)) != null) {
            gameCenterEntryService.gameCenterWeakEntryClick(url);
        }
    }
}