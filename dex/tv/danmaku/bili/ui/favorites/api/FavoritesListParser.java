package tv.danmaku.bili.ui.favorites.api;

import com.bilibili.lib.gson.GsonUtils;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabList;

/* compiled from: FavoritesParser.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/favorites/api/FavoritesListParser;", "Lcom/bilibili/okretro/converter/IParser;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabList;", "<init>", "()V", "convert", "value", "Lokhttp3/ResponseBody;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesListParser implements IParser<GeneralResponse<FavoritesTabList>> {
    public static final int $stable = 0;

    /* renamed from: convert */
    public GeneralResponse<FavoritesTabList> m1614convert(ResponseBody value) {
        ArrayList arrayList;
        Iterable mutableList;
        Intrinsics.checkNotNullParameter(value, "value");
        GeneralResponse $this$convert_u24lambda_u240 = new GeneralResponse();
        JsonObject jsonObject = (JsonObject) GsonUtils.parse(value.string(), JsonObject.class);
        FavoritesTabList list = (FavoritesTabList) GsonUtils.parse(jsonObject.get("data").toString(), FavoritesTabList.class);
        Intrinsics.checkNotNull(list);
        List<FavoritesMediasItem> list2 = list.getList();
        if (list2 == null || (mutableList = CollectionsKt.toMutableList(list2)) == null) {
            arrayList = null;
        } else {
            Iterable $this$filter$iv = mutableList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                FavoritesMediasItem it = (FavoritesMediasItem) element$iv$iv;
                if (FavoritesConstsKt.getSupportFavCardType().contains(Integer.valueOf(it.getOtype()))) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            arrayList = (List) destination$iv$iv;
        }
        $this$convert_u24lambda_u240.data = FavoritesTabList.copy$default(list, 0, false, false, arrayList, 0L, 0, 0, 119, null);
        return $this$convert_u24lambda_u240;
    }
}