package kntr.app.digital.preview.usage;

import com.bilibili.ktor.KApiResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: Usage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH¦B¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/usage/Usage;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/app/digital/preview/usage/UsageMenu;", "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Usage {
    Object invoke(int i, long j2, long j3, Continuation<? super KApiResponse<UsageMenu>> continuation);
}