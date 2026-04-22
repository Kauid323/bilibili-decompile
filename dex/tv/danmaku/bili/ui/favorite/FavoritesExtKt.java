package tv.danmaku.bili.ui.favorite;

import androidx.fragment.app.Fragment;
import com.bapis.bilibili.polymer.list.FavoriteTabItemOrBuilder;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorite.api.FavoriteTab;

/* compiled from: FavoritesExt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"parse", "", "Ltv/danmaku/bili/ui/favorite/api/FavoriteTab;", "Lcom/bapis/bilibili/polymer/list/FavoriteTabItemOrBuilder;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesExtKt {
    public static final List<FavoriteTab> parse(List<? extends FavoriteTabItemOrBuilder> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends FavoriteTabItemOrBuilder> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            FavoriteTabItemOrBuilder it = (FavoriteTabItemOrBuilder) element$iv$iv;
            boolean z = false;
            try {
                BLRouter bLRouter = BLRouter.INSTANCE;
                String uri = it.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
                Target target = RouteConstKt.findRoute(bLRouter, RouteRequestKt.toRouteRequest(uri));
                if (target != null && Fragment.class.isAssignableFrom(target.getClazz())) {
                    z = true;
                }
            } catch (Exception e) {
                BLog.e("FavouritesExt", "Fail to get route of " + it.getUri());
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv2.add(new FavoriteTab((FavoriteTabItemOrBuilder) item$iv$iv));
        }
        return CollectionsKt.toList((List) destination$iv$iv2);
    }
}