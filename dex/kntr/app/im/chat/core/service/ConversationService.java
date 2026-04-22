package kntr.app.im.chat.core.service;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ConversationService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H¦@¢\u0006\u0004\b\t\u0010\u0006J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/ConversationService;", RoomRecommendViewModel.EMPTY_CURSOR, "blockUser", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "blockUser-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "followUser", RoomRecommendViewModel.EMPTY_CURSOR, "followUser-IoAF18A", "disallowPush", "disallowPush-IoAF18A", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationService {
    /* renamed from: blockUser-IoAF18A  reason: not valid java name */
    Object mo1354blockUserIoAF18A(Continuation<? super Result<String>> continuation);

    /* renamed from: disallowPush-IoAF18A  reason: not valid java name */
    Object mo1355disallowPushIoAF18A(Continuation<? super Result<String>> continuation);

    /* renamed from: followUser-IoAF18A  reason: not valid java name */
    Object mo1356followUserIoAF18A(Continuation<? super Result<Unit>> continuation);
}