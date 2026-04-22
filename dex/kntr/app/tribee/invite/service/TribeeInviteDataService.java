package kntr.app.tribee.invite.service;

import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeAllReq;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TribeeInviteDataService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/app/tribee/invite/service/TribeeInviteDataService;", "", "fromTribeeId", "", "<init>", "(J)V", "initialData", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteDataService {
    public static final int $stable = 0;
    private final long fromTribeeId;

    @Inject
    public TribeeInviteDataService(long fromTribeeId) {
        this.fromTribeeId = fromTribeeId;
    }

    public final Object initialData(Continuation<? super KTribeeInviteCodeAllResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeInviteCodeAll(new KTribeeInviteCodeAllReq(this.fromTribeeId), continuation);
    }
}