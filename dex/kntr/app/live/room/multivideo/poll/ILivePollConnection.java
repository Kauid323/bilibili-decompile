package kntr.app.live.room.multivideo.poll;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: ILivePollConnection.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/app/live/room/multivideo/poll/ILivePollConnection;", "T", RoomRecommendViewModel.EMPTY_CURSOR, "start", RoomRecommendViewModel.EMPTY_CURSOR, "updateInterval", "interval", RoomRecommendViewModel.EMPTY_CURSOR, "subscribeMessageAsFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "subscribeMessageAsData", "onReceiveMsg", "Lkotlin/Function1;", "isActive", RoomRecommendViewModel.EMPTY_CURSOR, "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ILivePollConnection<T> {
    boolean isActive();

    void start();

    void subscribeMessageAsData(Function1<? super T, Unit> function1);

    SharedFlow<T> subscribeMessageAsFlow();

    void updateInterval(long j2);
}