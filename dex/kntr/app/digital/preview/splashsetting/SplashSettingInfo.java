package kntr.app.digital.preview.splashsetting;

import com.bilibili.ktor.KApiResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: SplashSettingInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bà\u0080\u0001\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H¦B¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/splashsetting/SplashSettingInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/app/digital/preview/splashsetting/DLCSplashCardInfo;", "actId", RoomRecommendViewModel.EMPTY_CURSOR, "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "screenWidth", "screenHeight", "(IJIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SplashSettingInfo {
    Object invoke(int i, long j2, int i2, int i3, Continuation<? super KApiResponse<DLCSplashCardInfo>> continuation);
}