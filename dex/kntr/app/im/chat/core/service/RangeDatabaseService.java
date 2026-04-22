package kntr.app.im.chat.core.service;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.ranges.LongRange;

/* compiled from: DatabaseServices.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH¦@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/RangeDatabaseService;", RoomRecommendViewModel.EMPTY_CURSOR, "mergeAll", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "range", "(Lkotlin/ranges/LongRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPrevious", "base", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAll", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RangeDatabaseService {
    Object add(LongRange longRange, Continuation<? super Unit> continuation);

    Object mergeAll(Continuation<? super List<LongRange>> continuation);

    Object queryAll(Continuation<? super List<LongRange>> continuation);

    Object queryPrevious(Long l, Continuation<? super LongRange> continuation);
}