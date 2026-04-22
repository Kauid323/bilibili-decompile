package kntr.app.im.chat.sticker.service;

import java.util.List;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H¦@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H¦@¢\u0006\u0002\u0010\nJ&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/sticker/service/StickerManagerService;", RoomRecommendViewModel.EMPTY_CURSOR, "getAllStickerOfUser", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "deleteStickers", RoomRecommendViewModel.EMPTY_CURSOR, "stickers", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStickers", "Lkntr/common/photonic/Asset;", "saveSticker", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "resolution", "Lkntr/common/photonic/Resolution;", "saveSticker-0E7RQCE", "(Ljava/lang/String;Lkntr/common/photonic/Resolution;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface StickerManagerService {
    Object deleteStickers(List<StickerAsset> list, Continuation<? super Integer> continuation);

    Flow<List<StickerEntity>> getAllStickerOfUser();

    /* renamed from: saveSticker-0E7RQCE  reason: not valid java name */
    Object mo1691saveSticker0E7RQCE(String str, Resolution resolution, Continuation<? super Result<Unit>> continuation);

    Object saveStickers(List<? extends Asset> list, Continuation<? super Integer> continuation);
}