package kntr.app.tribee.repost.service;

import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsReq;
import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import com.bapis.bilibili.dynamic.common.KCreateResp;
import com.bapis.bilibili.dynamic.common.KLbsLoc;
import com.bapis.bilibili.dynamic.common.KMetaDataCtrl;
import com.bapis.bilibili.dynamic.common.KUserCreateMeta;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KFeedMoss;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KReprintOpusToTribeeReq;
import javax.inject.Inject;
import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TribeeRepostDataService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\tJB\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/repost/service/TribeeRepostDataService;", "", "originDynamicId", "", "<init>", "(J)V", "initialData", "Lcom/bapis/bilibili/app/dynamic/v2/KRepostOpus2TribeeOptionsResp;", "defaultTribeeId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repost", "Lcom/bapis/bilibili/dynamic/common/KCreateResp;", "tribeeId", "partitionId", "repostMainText", "", "repostTitleText", "enableRepostToFollowing", "", "enableRepostWithSource", "(JJLjava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeRepostDataService {
    public static final int $stable = 0;
    private final long originDynamicId;

    @Inject
    public TribeeRepostDataService(long originDynamicId) {
        this.originDynamicId = originDynamicId;
    }

    public final Object initialData(long defaultTribeeId, Continuation<? super KRepostOpus2TribeeOptionsResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).repostOpus2TribeeOptions(new KRepostOpus2TribeeOptionsReq(defaultTribeeId, this.originDynamicId), continuation);
    }

    public static /* synthetic */ Object repost$default(TribeeRepostDataService tribeeRepostDataService, long j, long j2, String str, String str2, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        String str3;
        String str4;
        if ((i & 4) == 0) {
            str3 = str;
        } else {
            str3 = "";
        }
        if ((i & 8) == 0) {
            str4 = str2;
        } else {
            str4 = "";
        }
        return tribeeRepostDataService.repost(j, j2, str3, str4, z, z2, continuation);
    }

    public final Object repost(long tribeeId, long partitionId, String repostMainText, String repostTitleText, boolean enableRepostToFollowing, boolean enableRepostWithSource, Continuation<? super KCreateResp> continuation) {
        return new KFeedMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).reprintOpusToTribee(new KReprintOpusToTribeeReq(new KUserCreateMeta(new KMetaDataCtrl((String) null, (String) null, (String) null, (String) null, (String) null, TribeeRepostTrackKt.TRIBEE_REPOST_PAGE_SPMID, "create.reprint.tribee", (String) null, 0, 0, (String) null, 0, (String) null, 8095, (DefaultConstructorMarker) null), (KLbsLoc) null, 0, 6, (DefaultConstructorMarker) null), this.originDynamicId, tribeeId, partitionId, enableRepostToFollowing, enableRepostWithSource, repostMainText, repostTitleText), continuation);
    }
}