package kntr.app.digital.preview.lock;

import com.bilibili.ktor.KApiResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.serialization.json.JsonObject;

/* compiled from: ToggleLockCard.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦B¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/lock/ToggleLockCard;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lcom/bilibili/ktor/KApiResponse;", RoomRecommendViewModel.EMPTY_CURSOR, "requestJson", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ToggleLockCard {
    Object invoke(JsonObject jsonObject, Continuation<? super KApiResponse<Unit>> continuation);
}