package kntr.app.ad.domain.report.internal.cache;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: IAdReportCache.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H¦@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0001H¦@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/IAdReportLocalStorageCache;", "K", "V", RoomRecommendViewModel.EMPTY_CURSOR, "saveOrUpdateToLocalStorage", RoomRecommendViewModel.EMPTY_CURSOR, "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocalStorage", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", RoomRecommendViewModel.EMPTY_CURSOR, "isFromStartUp", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdReportLocalStorageCache<K, V> {
    Object deleteLocalStorage(V v, Continuation<? super Unit> continuation);

    Object load(boolean z, Continuation<? super List<? extends V>> continuation);

    Object saveOrUpdateToLocalStorage(K k, V v, Continuation<? super Unit> continuation);
}