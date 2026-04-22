package kntr.app.digital.preview.card.web;

import com.bilibili.ktor.KApiResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: GetWebCardDescInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦B¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/app/digital/preview/card/web/PropertyInfo;", "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GetWebCardDescInfo {
    Object invoke(long j2, String str, Continuation<? super KApiResponse<PropertyInfo>> continuation);
}