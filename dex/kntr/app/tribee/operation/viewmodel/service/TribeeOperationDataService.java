package kntr.app.tribee.operation.viewmodel.service;

import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsReq;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsResp;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KCosmoInterfaceMoss;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KTribeeManageActionRsp;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KTribeeManageSendInviteCodeReq;
import javax.inject.Inject;
import kntr.app.tribee.operation.viewmodel.InviteeMid;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: TribeeOperationDataService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/service/TribeeOperationDataService;", "", "inviteeMid", "", "<init>", "(J)V", "initialPage", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp;", "tribeeId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submit", "Lcom/bapis/bilibili/community/interfacess/cosmoconn/v1/KTribeeManageActionRsp;", "sendType", "", "sendCount", "(JIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeOperationDataService {
    public static final int $stable = 0;
    private final long inviteeMid;

    @Inject
    public TribeeOperationDataService(@InviteeMid long inviteeMid) {
        this.inviteeMid = inviteeMid;
    }

    public final Object initialPage(long tribeeId, Continuation<? super KTribeeSendInviteCodeOptionsResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeSendInviteCodeOptions(new KTribeeSendInviteCodeOptionsReq(tribeeId, this.inviteeMid), continuation);
    }

    public final Object submit(long tribeeId, int sendType, long sendCount, Continuation<? super KTribeeManageActionRsp> continuation) {
        return new KCosmoInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeManageSendInviteCode(new KTribeeManageSendInviteCodeReq(tribeeId, RangesKt.coerceAtLeast(sendCount, 1L), this.inviteeMid, sendType), continuation);
    }
}