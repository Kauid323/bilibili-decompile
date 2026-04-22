package kntr.app.tribee.consume.viewmodel.service;

import com.bapis.bilibili.app.dynamic.common.KTribeeRefresh;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDynAllReq;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDynAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortType;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KCosmoInterfaceMoss;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KInvFeedBackType;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeByInviteCodeReq;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeByInviteCodeRsp;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeCandidatePoolReq;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KJoinTribeeCandidatePoolRsp;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KToggleTribeeReq;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KToggleTribeeRsp;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KTribeeInviteCodeNotificationsFeedbackReq;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KTribeeInviteCodeNotificationsFeedbackRsp;
import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KUpdateRecTribeeReq;
import com.bapis.bilibili.pagination.KPagination;
import com.bapis.bilibili.pagination.KPaginationReply;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kntr.base.moss.api.KCallOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TribeeHomeDataService.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006+"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/service/TribeeHomeDataService;", "", "homeId", "", "<init>", "(J)V", "tribeeSettings", "Lkntr/base/config/SharedPreferences;", "getTribeeSettings", "()Lkntr/base/config/SharedPreferences;", "tribeeSettings$delegate", "Lkotlin/Lazy;", "initialData", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDynAllResp;", "categoryId", "sortType", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;", "(JLcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNextList", "nexPageInfo", "Lcom/bapis/bilibili/pagination/KPaginationReply;", "(Lcom/bapis/bilibili/pagination/KPaginationReply;JLcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "join", "Lcom/bapis/bilibili/community/interfacess/cosmoconn/v1/KToggleTribeeRsp;", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinByInviteCode", "Lcom/bapis/bilibili/community/interfacess/cosmoconn/v1/KJoinTribeeByInviteCodeRsp;", "inviteCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinCandidatePool", "Lcom/bapis/bilibili/community/interfacess/cosmoconn/v1/KJoinTribeeCandidatePoolRsp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inviteCodeFeedback", "Lcom/bapis/bilibili/community/interfacess/cosmoconn/v1/KTribeeInviteCodeNotificationsFeedbackRsp;", "fromBubble", "inHomePage", "inMinePage", "(ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchRevisitSettings", "", "checked", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomeDataService {
    public static final int $stable = 8;
    private final long homeId;
    private final Lazy tribeeSettings$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService$$ExternalSyntheticLambda0
        public final Object invoke() {
            SharedPreferences tribeeSettings_delegate$lambda$0;
            tribeeSettings_delegate$lambda$0 = TribeeHomeDataService.tribeeSettings_delegate$lambda$0();
            return tribeeSettings_delegate$lambda$0;
        }
    });

    @Inject
    public TribeeHomeDataService(long homeId) {
        this.homeId = homeId;
    }

    private final SharedPreferences getTribeeSettings() {
        return (SharedPreferences) this.tribeeSettings$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences tribeeSettings_delegate$lambda$0() {
        return new SharedPreferences("tribee_settings", false, 2, null);
    }

    public static /* synthetic */ Object initialData$default(TribeeHomeDataService tribeeHomeDataService, long j, KTribeeSortType kTribeeSortType, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            kTribeeSortType = null;
        }
        return tribeeHomeDataService.initialData(j, kTribeeSortType, continuation);
    }

    public final Object initialData(long categoryId, KTribeeSortType sortType, Continuation<? super KTribeeDynAllResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeDynAll(new KTribeeDynAllReq(this.homeId, KTribeeRefresh.REFRESH_NEW.INSTANCE, new KPagination(20, (String) null, 2, (DefaultConstructorMarker) null), categoryId, sortType == null ? (KTribeeSortType) KTribeeSortType.TRIBEE_SORT_TYPE_DEFAULT.INSTANCE : sortType), continuation);
    }

    public static /* synthetic */ Object loadNextList$default(TribeeHomeDataService tribeeHomeDataService, KPaginationReply kPaginationReply, long j, KTribeeSortType kTribeeSortType, Continuation continuation, int i, Object obj) {
        KTribeeSortType kTribeeSortType2;
        if ((i & 4) == 0) {
            kTribeeSortType2 = kTribeeSortType;
        } else {
            kTribeeSortType2 = null;
        }
        return tribeeHomeDataService.loadNextList(kPaginationReply, j, kTribeeSortType2, continuation);
    }

    public final Object loadNextList(KPaginationReply nexPageInfo, long categoryId, KTribeeSortType sortType, Continuation<? super KTribeeDynAllResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).tribeeDynAll(new KTribeeDynAllReq(this.homeId, KTribeeRefresh.REFRESH_HISTORY.INSTANCE, new KPagination(20, nexPageInfo.getNext()), categoryId, sortType == null ? (KTribeeSortType) KTribeeSortType.TRIBEE_SORT_TYPE_DEFAULT.INSTANCE : sortType), continuation);
    }

    public final Object join(boolean join, Continuation<? super KToggleTribeeRsp> continuation) {
        return new KCosmoInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).toggleTribeeMembership(new KToggleTribeeReq(this.homeId, join ? 1 : 2), continuation);
    }

    public final Object joinByInviteCode(String inviteCode, Continuation<? super KJoinTribeeByInviteCodeRsp> continuation) {
        return new KCosmoInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).joinTribeeByInviteCode(new KJoinTribeeByInviteCodeReq(inviteCode, this.homeId), continuation);
    }

    public final Object joinCandidatePool(Continuation<? super KJoinTribeeCandidatePoolRsp> continuation) {
        return new KCosmoInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).joinTribeeCandidatePool(new KJoinTribeeCandidatePoolReq(this.homeId), continuation);
    }

    public final Object inviteCodeFeedback(boolean fromBubble, boolean inHomePage, boolean inMinePage, Continuation<? super KTribeeInviteCodeNotificationsFeedbackRsp> continuation) {
        KInvFeedBackType kInvFeedBackType;
        KCosmoInterfaceMoss kCosmoInterfaceMoss = new KCosmoInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
        if (fromBubble) {
            kInvFeedBackType = (KInvFeedBackType) KInvFeedBackType.HOME_PAGE_BUBBLE_SHOW.INSTANCE;
        } else if (inHomePage) {
            kInvFeedBackType = (KInvFeedBackType) KInvFeedBackType.HOME_PAGE_REDDOT_CLICK.INSTANCE;
        } else if (inMinePage) {
            kInvFeedBackType = (KInvFeedBackType) KInvFeedBackType.MY_PAGE_REDDOT_CLICK.INSTANCE;
        } else {
            kInvFeedBackType = KInvFeedBackType.INV_FEED_BACK_TYPE_INVALID.INSTANCE;
        }
        return kCosmoInterfaceMoss.tribeeInviteCodeNotificationsFeedback(new KTribeeInviteCodeNotificationsFeedbackReq(kInvFeedBackType), continuation);
    }

    public final Object switchRevisitSettings(boolean checked, Continuation<? super Unit> continuation) {
        Object updateRecTribee = new KCosmoInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).updateRecTribee(new KUpdateRecTribeeReq(this.homeId, !checked), continuation);
        return updateRecTribee == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateRecTribee : Unit.INSTANCE;
    }
}