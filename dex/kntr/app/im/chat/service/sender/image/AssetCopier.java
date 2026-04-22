package kntr.app.im.chat.service.sender.image;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: AssetCopier.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/service/sender/image/AssetCopier;", RoomRecommendViewModel.EMPTY_CURSOR, "copyToCache", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "asset", "Lkntr/common/photonic/Asset;", "(Lkntr/common/photonic/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCache", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AssetCopier {
    Object copyToCache(Asset asset, Continuation<? super LocalImageAsset> continuation);

    Object removeCache(LocalImageAsset localImageAsset, Continuation<? super Unit> continuation);
}