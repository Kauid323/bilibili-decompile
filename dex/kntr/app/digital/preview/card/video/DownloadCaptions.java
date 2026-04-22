package kntr.app.digital.preview.card.video;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: DownloadCaptions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦B¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/card/video/DownloadCaptions;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lkntr/app/digital/preview/card/video/VideoCaptions;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DownloadCaptions {
    Object invoke(String str, Continuation<? super VideoCaptions> continuation);
}