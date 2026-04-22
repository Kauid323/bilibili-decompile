package kntr.app.appwidget.guide.service;

import com.bapis.bilibili.app.show.mixture.v1.KWidgetGuideReply;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;

/* compiled from: AppWidgetGuideService.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", RoomRecommendViewModel.EMPTY_CURSOR, "getWidgetGuide", "Lcom/bapis/bilibili/app/show/mixture/v1/KWidgetGuideReply;", "spmid", "type", RoomRecommendViewModel.EMPTY_CURSOR, "upperMid", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.AID, "(Ljava/lang/String;IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", RoomRecommendViewModel.EMPTY_CURSOR, "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppWidgetGuideServiceKt {
    private static final String TAG = "AppWidgetGuideService";

    public static /* synthetic */ Object getWidgetGuide$default(String str, int i, long j2, long j3, Continuation continuation, int i2, Object obj) {
        long j4;
        long j5;
        if ((i2 & 4) == 0) {
            j4 = j2;
        } else {
            j4 = 0;
        }
        if ((i2 & 8) == 0) {
            j5 = j3;
        } else {
            j5 = 0;
        }
        return getWidgetGuide(str, i, j4, j5, continuation);
    }

    public static final Object getWidgetGuide(String spmid, int type, long upperMid, long aid, Continuation<? super KWidgetGuideReply> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new AppWidgetGuideServiceKt$getWidgetGuide$2(spmid, type, upperMid, aid, null), continuation);
    }

    public static final boolean show(KWidgetGuideReply $this$show) {
        return $this$show != null && $this$show.getCode() == 200;
    }
}