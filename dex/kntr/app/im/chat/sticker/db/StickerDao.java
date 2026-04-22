package kntr.app.im.chat.sticker.db;

import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: StickerDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDao;", RoomRecommendViewModel.EMPTY_CURSOR, "add", RoomRecommendViewModel.EMPTY_CURSOR, "sticker", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "(Lkntr/app/im/chat/sticker/entity/StickerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "findWithFile", "fileName", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllStickerOfUser", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface StickerDao {
    Object add(StickerEntity stickerEntity, Continuation<? super Unit> continuation);

    Object findWithFile(String str, long j2, Continuation<? super StickerEntity> continuation);

    Flow<List<StickerEntity>> getAllStickerOfUser(long j2);

    Object remove(StickerEntity stickerEntity, Continuation<? super Unit> continuation);
}