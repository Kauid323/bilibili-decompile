package tv.danmaku.bili.ui.favorites.api;

import com.bilibili.lib.gson.GsonUtils;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FavoritesParser.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\b\u0012\u0004\u0012\u00020\u000e0\nH\u0002¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/api/FavoritesFolderParser;", "Lcom/bilibili/okretro/converter/IParser;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolder;", "<init>", "()V", "convert", "value", "Lokhttp3/ResponseBody;", "limitToThreeOrFill", "", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "appendAddHolder", "", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFolderParser implements IParser<GeneralResponse<FavoritesFolder>> {
    public static final int $stable = 0;

    /* renamed from: convert */
    public GeneralResponse<FavoritesFolder> m1612convert(ResponseBody value) {
        List<FavoritesFolderItem> list;
        Iterable mutableList;
        boolean z;
        List list2;
        FavoritesFolderItem copy;
        List limitToThreeOrFill;
        Intrinsics.checkNotNullParameter(value, "value");
        GeneralResponse $this$convert_u24lambda_u240 = new GeneralResponse();
        boolean z2 = false;
        JsonObject jsonObject = (JsonObject) GsonUtils.parse(value.string(), JsonObject.class);
        FavoritesFolder folder = (FavoritesFolder) GsonUtils.parse(jsonObject.get("data").toString(), FavoritesFolder.class);
        Intrinsics.checkNotNull(folder);
        List<FavoritesFolderItem> list3 = folder.getList();
        if (list3 == null || (mutableList = CollectionsKt.toMutableList(list3)) == null) {
            list = null;
        } else {
            Iterable $this$mapIndexed$iv = mutableList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FavoritesFolderItem item = (FavoritesFolderItem) item$iv$iv;
                List<FavoritesMediasItem> recentFav = item.getRecentFav();
                if (recentFav == null || (limitToThreeOrFill = limitToThreeOrFill(recentFav)) == null) {
                    List $this$convert_u24lambda_u240_u240_u240 = new ArrayList();
                    int i = 0;
                    while (i < 3) {
                        $this$convert_u24lambda_u240_u240_u240.add(new FavoritesMediasItem(null, null, 0, 0L, null, null, null, null, 0, 0, null, null, 0, null, null, 0, null, 0, 0, false, false, 0, false, false, false, null, 67108863, null));
                        i++;
                        z2 = z2;
                    }
                    z = z2;
                    Unit unit = Unit.INSTANCE;
                    list2 = $this$convert_u24lambda_u240_u240_u240;
                } else {
                    z = z2;
                    list2 = limitToThreeOrFill;
                }
                copy = item.copy((r30 & 1) != 0 ? item.fid : 0L, (r30 & 2) != 0 ? item.mid : 0L, (r30 & 4) != 0 ? item.type : 0, (r30 & 8) != 0 ? item.attr : 0, (r30 & 16) != 0 ? item.attrDesc : null, (r30 & 32) != 0 ? item.title : null, (r30 & 64) != 0 ? item.jumpLink : null, (r30 & BR.cover) != 0 ? item.mediaCount : 0, (r30 & BR.hallEnterHotText) != 0 ? item.recentFav : list2, (r30 & BR.roleType) != 0 ? item.isTop : false, (r30 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? item.cover : null, (r30 & 2048) != 0 ? item.showGuide : !FavoritesConstsKt.getHasShowGuideWindow() && index$iv$iv == 2);
                destination$iv$iv.add(copy);
                index$iv$iv = index$iv$iv2;
                z2 = z;
            }
            list = appendAddHolder((List) destination$iv$iv);
        }
        $this$convert_u24lambda_u240.data = FavoritesFolder.copy$default(folder, 0, list, 1, null);
        return $this$convert_u24lambda_u240;
    }

    private final List<FavoritesMediasItem> limitToThreeOrFill(List<FavoritesMediasItem> list) {
        if (list.size() < 3) {
            List $this$limitToThreeOrFill_u24lambda_u240 = CollectionsKt.toMutableList(list);
            int size = 3 - $this$limitToThreeOrFill_u24lambda_u240.size();
            for (int i = 0; i < size; i++) {
                $this$limitToThreeOrFill_u24lambda_u240.add(new FavoritesMediasItem(null, null, 0, 0L, null, null, null, null, 0, 0, null, null, 0, null, null, 0, null, 0, 0, false, false, 0, false, false, false, null, 67108863, null));
            }
            return $this$limitToThreeOrFill_u24lambda_u240;
        }
        return list.subList(0, 3);
    }

    private final List<FavoritesFolderItem> appendAddHolder(List<FavoritesFolderItem> list) {
        List $this$appendAddHolder_u24lambda_u240 = CollectionsKt.toMutableList(list);
        FavoritesFolderItem $this$appendAddHolder_u24lambda_u240_u240 = new FavoritesFolderItem(0L, 0L, 0, 0, null, null, null, 0, null, false, null, false, 4095, null);
        $this$appendAddHolder_u24lambda_u240_u240.viewType = 1;
        $this$appendAddHolder_u24lambda_u240.add($this$appendAddHolder_u24lambda_u240_u240);
        return $this$appendAddHolder_u24lambda_u240;
    }
}