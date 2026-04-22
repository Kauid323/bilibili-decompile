package tv.danmaku.bili.ui.favorites.api;

import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabList;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabs;
import tv.danmaku.bili.ui.favorites.model.FollowResponse;

/* compiled from: FavoritesApiManager.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a6\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013\u001a6\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0016\u001a&\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00072\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u001a\u001a\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0007H\u0086@¢\u0006\u0002\u0010\"\u001a*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010&\u001a&\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*\u001a.\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020%H\u0086@¢\u0006\u0002\u0010-\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"favoritesApiService", "Ltv/danmaku/bili/ui/favorites/api/FavoritesApiService;", "getFavoritesApiService", "()Ltv/danmaku/bili/ui/favorites/api/FavoritesApiService;", "favoritesApiService$delegate", "Lkotlin/Lazy;", "getFavoritesTabs", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabs;", "tabId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PAGE_TYPE_SCORE", "getFollowList", "Ltv/danmaku/bili/ui/favorites/model/FollowResponse;", "startOid", "", "startOType", "startScore", "(IJIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoritesList", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabList;", "(JIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderFullInfo", "playlistId", "pageIndex", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanRedDot", "Lcom/bilibili/okretro/GeneralResponse;", "Lcom/bilibili/okretro/BaseResponse;", "cleanInvalid", "fid", "getFolderList", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolder;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavorites", "resources", "", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTopFolder", "addTop", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportLastWatchedEvent", "action", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesApiManagerKt {
    public static final int PAGE_TYPE_SCORE = 1;
    private static final Lazy favoritesApiService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            FavoritesApiService favoritesApiService_delegate$lambda$0;
            favoritesApiService_delegate$lambda$0 = FavoritesApiManagerKt.favoritesApiService_delegate$lambda$0();
            return favoritesApiService_delegate$lambda$0;
        }
    });

    public static final FavoritesApiService getFavoritesApiService() {
        return (FavoritesApiService) favoritesApiService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavoritesApiService favoritesApiService_delegate$lambda$0() {
        return (FavoritesApiService) ServiceGenerator.createService(FavoritesApiService.class);
    }

    public static final Object getFavoritesTabs(int tabId, Continuation<? super Resource<FavoritesTabs>> continuation) {
        BiliCall parser = getFavoritesApiService().getFavoritesTabs(tabId).setParser(new FavoritesTabParser());
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return BiliCallExtKt.getResult(parser, continuation);
    }

    public static final Object getFollowList(int tabId, long startOid, int startOType, int startScore, Continuation<? super Resource<FollowResponse>> continuation) {
        BiliCall parser = getFavoritesApiService().getFollowList(tabId, startOid, startOType, startScore, 1).setParser(new FavoritesFollowParser());
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return BiliCallExtKt.getResult(parser, continuation);
    }

    public static final Object getFavoritesList(long startOid, int startOType, int tabId, int startScore, Continuation<? super Resource<FavoritesTabList>> continuation) {
        BiliCall parser = getFavoritesApiService().getFavoritesList(startOid, startOType, tabId, startScore, 1).setParser(new FavoritesListParser());
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return BiliCallExtKt.getResult(parser, continuation);
    }

    public static final Object getFolderFullInfo(long playlistId, int pageIndex, Continuation<? super Resource<FavoritesTabList>> continuation) {
        BiliCall parser = getFavoritesApiService().getFolderFullInfo(playlistId, pageIndex).setParser(new FavoritesListParser());
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return BiliCallExtKt.getResult(parser, continuation);
    }

    public static final Object cleanRedDot(int tabId, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getFavoritesApiService().cleanRedDot(tabId), continuation);
    }

    public static final Object cleanInvalid(int fid, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getFavoritesApiService().cleanInvalid(fid), continuation);
    }

    public static final Object getFolderList(Continuation<? super Resource<FavoritesFolder>> continuation) {
        BiliCall parser = getFavoritesApiService().getFavoritesFolderList().setParser(new FavoritesFolderParser());
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return BiliCallExtKt.getResult(parser, continuation);
    }

    public static /* synthetic */ Object deleteFavorites$default(String str, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return deleteFavorites(str, l, continuation);
    }

    public static final Object deleteFavorites(String resources, Long fid, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getFavoritesApiService().deleteFavorites(resources, fid), continuation);
    }

    public static final Object addTopFolder(long fid, boolean addTop, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getFavoritesApiService().addTopFolder(fid, addTop), continuation);
    }

    public static final Object reportLastWatchedEvent(int tabId, String resources, String action, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getFavoritesApiService().lastWatched(tabId, resources, action), continuation);
    }
}