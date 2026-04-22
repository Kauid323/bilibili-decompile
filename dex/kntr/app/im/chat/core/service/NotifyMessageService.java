package kntr.app.im.chat.core.service;

import com.bapis.bilibili.app.im.v1.KNotifyCosmoThreeDotItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: NotifyMessageService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/NotifyMessageService;", RoomRecommendViewModel.EMPTY_CURSOR, "notifyMessageOp", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "opItem", "Lcom/bapis/bilibili/app/im/v1/KNotifyCosmoThreeDotItem;", "notifyMessageOp-gIAlu-s", "(Lcom/bapis/bilibili/app/im/v1/KNotifyCosmoThreeDotItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotifyMessageService {
    /* renamed from: notifyMessageOp-gIAlu-s  reason: not valid java name */
    Object mo1363notifyMessageOpgIAlus(KNotifyCosmoThreeDotItem kNotifyCosmoThreeDotItem, Continuation<? super Result<String>> continuation);
}