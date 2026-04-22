package tv.danmaku.bili.ui.favorites.model;

import android.app.Activity;
import com.bilibili.app.comm.supermenu.core.MenuItemImpl;
import com.bilibili.playset.R;
import com.bilibili.playset.api.FavoritesTranslateKt;
import com.bilibili.playset.api.MultitypeMedia;
import com.bilibili.playset.api.TranslateInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0003\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0003¨\u0006\u000b"}, d2 = {"getCustomMenuItems", "", "Lcom/bilibili/app/comm/supermenu/core/MenuItemImpl;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "toMultiTypeMedia", "Lcom/bilibili/playset/api/MultitypeMedia;", "getShareType", "", "getShareFrom", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesResponseKt {
    public static final List<MenuItemImpl> getCustomMenuItems(FavoritesMediasItem $this$getCustomMenuItems, Activity activity) {
        Intrinsics.checkNotNullParameter($this$getCustomMenuItems, "<this>");
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        List list = CollectionsKt.mutableListOf(new MenuItemImpl[]{new MenuItemImpl(activity, "delete_favorite", R.drawable.ic_star_fav_off_line, bili.resource.favorites.R.string.favorites_global_string_26)});
        TranslateInfo translateInfo = $this$getCustomMenuItems.getTranslateInfo();
        if ((translateInfo != null ? translateInfo.getTranslateText() : null) != null) {
            list.add(new MenuItemImpl(activity, "menu_translate", FavoritesTranslateKt.isTranslated($this$getCustomMenuItems) ? R.drawable.ic_fav_see_origin : R.drawable.ic_fav_translate, FavoritesTranslateKt.isTranslated($this$getCustomMenuItems) ? $this$getCustomMenuItems.getTranslateInfo().getOriginText() : $this$getCustomMenuItems.getTranslateInfo().getTranslateText()));
        }
        return list;
    }

    public static final MultitypeMedia toMultiTypeMedia(FavoritesMediasItem $this$toMultiTypeMedia) {
        int i;
        Intrinsics.checkNotNullParameter($this$toMultiTypeMedia, "<this>");
        MultitypeMedia it = new MultitypeMedia();
        switch ($this$toMultiTypeMedia.getOtype()) {
            case 12:
                i = 12;
                break;
            case 24:
                i = 24;
                break;
            case 42:
                i = 42;
                break;
            default:
                i = 2;
                break;
        }
        it.type = i;
        it.id = $this$toMultiTypeMedia.getOid();
        it.title = $this$toMultiTypeMedia.getTitle();
        com.bilibili.playset.api.Upper up = new com.bilibili.playset.api.Upper();
        Upper upper = $this$toMultiTypeMedia.getUpper();
        up.name = upper != null ? upper.getName() : null;
        it.upper = up;
        MultitypeMedia.OGV otherOgv = new MultitypeMedia.OGV();
        Ogv ogv = $this$toMultiTypeMedia.getOgv();
        otherOgv.seasonType = ogv != null ? (int) ogv.getTypeId() : 0;
        Ogv ogv2 = $this$toMultiTypeMedia.getOgv();
        otherOgv.typeName = ogv2 != null ? ogv2.getTypeName() : null;
        Ogv ogv3 = $this$toMultiTypeMedia.getOgv();
        otherOgv.seasonId = ogv3 != null ? ogv3.getSeasonId() : 0L;
        it.ogv = otherOgv;
        MultitypeMedia.UGC otherUgc = new MultitypeMedia.UGC();
        com.bilibili.playset.api.Ugc ugc = $this$toMultiTypeMedia.getUgc();
        otherUgc.cid = ugc != null ? ugc.getFirstCid() : 0L;
        it.ugc = otherUgc;
        String cover = $this$toMultiTypeMedia.getCover();
        if (cover == null) {
            cover = "";
        }
        it.cover = cover;
        return it;
    }

    public static final String getShareType(FavoritesMediasItem $this$getShareType) {
        Intrinsics.checkNotNullParameter($this$getShareType, "<this>");
        return $this$getShareType.getOgv() == null ? "ugc" : $this$getShareType.getOtype() == 42 ? "ogv_new" : ReportUtilKt.CONTENT_TYPE_OGV;
    }

    public static final String getShareFrom(FavoritesMediasItem $this$getShareFrom) {
        Intrinsics.checkNotNullParameter($this$getShareFrom, "<this>");
        return $this$getShareFrom.getOgv() == null ? "" : "ogv_video_my_favorite_option_more_share";
    }
}