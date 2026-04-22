package kntr.app.ad.domain.report.internal.cache;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: IAdReportCache.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H¦@¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH¦@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H¦@¢\u0006\u0002\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/IAdReportCache;", "K", "V", RoomRecommendViewModel.EMPTY_CURSOR, "add", RoomRecommendViewModel.EMPTY_CURSOR, "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdReportCache<K, V> {
    Object add(K k, V v, Continuation<? super Unit> continuation);

    Object delete(K k, V v, Continuation<? super Unit> continuation);

    Object getAll(Continuation<? super Map<K, ? extends V>> continuation);
}