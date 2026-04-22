package kntr.app.im.chat.service;

import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageGroupingBySameMinuteServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/service/MessageGroupingBySameMinuteServiceImpl;", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "<init>", "()V", "isInSameGroup", RoomRecommendViewModel.EMPTY_CURSOR, "last", "Lkntr/app/im/chat/core/model/EntityMessage;", "next", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageGroupingBySameMinuteServiceImpl implements MessageGroupingService {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.core.service.MessageGroupingService
    public boolean isInSameGroup(EntityMessage last, EntityMessage next) {
        Intrinsics.checkNotNullParameter(last, "last");
        Intrinsics.checkNotNullParameter(next, "next");
        long j2 = 60;
        return next.getTimestamp().getEpochSeconds() / j2 == last.getTimestamp().getEpochSeconds() / j2;
    }
}