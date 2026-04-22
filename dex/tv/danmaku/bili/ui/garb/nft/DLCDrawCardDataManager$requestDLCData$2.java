package tv.danmaku.bili.ui.garb.nft;

import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.BillDLCRespInfo;
import tv.danmaku.bili.ui.garb.api.DLCReporterHelper;
import tv.danmaku.bili.ui.garb.nft.CardDataState;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCDrawCardDataManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$requestDLCData$2", f = "DLCDrawCardDataManager.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DLCDrawCardDataManager$requestDLCData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CardDataState>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DLCDrawCardDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCDrawCardDataManager$requestDLCData$2(DLCDrawCardDataManager dLCDrawCardDataManager, Continuation<? super DLCDrawCardDataManager$requestDLCData$2> continuation) {
        super(2, continuation);
        this.this$0 = dLCDrawCardDataManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCDrawCardDataManager$requestDLCData$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CardDataState> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DLCCardDrawModel dLCCardDrawModel;
        DLCCardDrawModel dLCCardDrawModel2;
        DLCCardDrawModel dLCCardDrawModel3;
        DLCCardDrawModel dLCCardDrawModel4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final DLCDrawCardDataManager dLCDrawCardDataManager = this.this$0;
                this.L$0 = dLCDrawCardDataManager;
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation continuation = cancellableContinuationImpl;
                BiliNftApiManager biliNftApiManager = BiliNftApiManager.INSTANCE;
                dLCCardDrawModel = dLCDrawCardDataManager.drawCardItem;
                long actId = dLCCardDrawModel != null ? dLCCardDrawModel.getActId() : 0L;
                long mid = BiliAccounts.get(BiliContext.application()).mid();
                dLCCardDrawModel2 = dLCDrawCardDataManager.drawCardItem;
                long lotteryId = dLCCardDrawModel2 != null ? dLCCardDrawModel2.getLotteryId() : 0L;
                dLCCardDrawModel3 = dLCDrawCardDataManager.drawCardItem;
                int lotteryNum = dLCCardDrawModel3 != null ? dLCCardDrawModel3.getLotteryNum() : 0;
                dLCCardDrawModel4 = dLCDrawCardDataManager.drawCardItem;
                biliNftApiManager.loadDLCItem(actId, mid, lotteryId, lotteryNum, dLCCardDrawModel4 != null ? dLCCardDrawModel4.getBizInfo() : null, new BiliApiDataCallback<BillDLCRespInfo>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$requestDLCData$2$1$1
                    public void onError(Throwable t) {
                        BLog.w(DLCDrawCardDataManager.Companion.getTAG(), "draw card api failed " + (t != null ? t.getMessage() : null));
                        CancellableContinuation<CardDataState> cancellableContinuation = continuation;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation.resumeWith(Result.constructor-impl(new CardDataState.ApiFailed(t != null ? t.getMessage() : null)));
                    }

                    public void onDataSuccess(BillDLCRespInfo data) {
                        DLCCardDrawModel dLCCardDrawModel5;
                        DLCCardDrawModel dLCCardDrawModel6;
                        DLCCardDrawModel dLCCardDrawModel7;
                        DLCCardDrawModel dLCCardDrawModel8;
                        DLCCardDrawModel dLCCardDrawModel9;
                        DLCCardDrawModel dLCCardDrawModel10;
                        DLCCardDrawModel dLCCardDrawModel11;
                        DLCCardDrawModel dLCCardDrawModel12;
                        String fSource;
                        String fromId;
                        String fromWhere;
                        DLCCardDrawModel dLCCardDrawModel13;
                        DLCCardDrawModel dLCCardDrawModel14;
                        DLCCardDrawModel dLCCardDrawModel15;
                        DLCCardDrawModel dLCCardDrawModel16;
                        DLCCardDrawModel dLCCardDrawModel17;
                        DLCCardDrawModel dLCCardDrawModel18;
                        DLCCardDrawModel dLCCardDrawModel19;
                        DLCCardDrawModel dLCCardDrawModel20;
                        String fSource2;
                        String fromId2;
                        String fromWhere2;
                        if (data == null || data.getErrCode() != 0 || data.getItemList().isEmpty()) {
                            onError(new Exception(data != null ? data.getErrMessage() : null));
                            return;
                        }
                        if (dLCDrawCardDataManager.getFromResultView()) {
                            DLCReporterHelper dLCReporterHelper = DLCReporterHelper.INSTANCE;
                            dLCCardDrawModel13 = dLCDrawCardDataManager.drawCardItem;
                            long actId2 = dLCCardDrawModel13 != null ? dLCCardDrawModel13.getActId() : 0L;
                            dLCCardDrawModel14 = dLCDrawCardDataManager.drawCardItem;
                            long lotteryId2 = dLCCardDrawModel14 != null ? dLCCardDrawModel14.getLotteryId() : 0L;
                            dLCCardDrawModel15 = dLCDrawCardDataManager.drawCardItem;
                            int activityStatus = dLCCardDrawModel15 != null ? dLCCardDrawModel15.getActivityStatus() : 0;
                            dLCCardDrawModel16 = dLCDrawCardDataManager.drawCardItem;
                            int lotteryNum2 = dLCCardDrawModel16 != null ? dLCCardDrawModel16.getLotteryNum() : 0;
                            dLCCardDrawModel17 = dLCDrawCardDataManager.drawCardItem;
                            String str = (dLCCardDrawModel17 == null || (fromWhere2 = dLCCardDrawModel17.getFromWhere()) == null) ? "" : fromWhere2;
                            dLCCardDrawModel18 = dLCDrawCardDataManager.drawCardItem;
                            String str2 = (dLCCardDrawModel18 == null || (fromId2 = dLCCardDrawModel18.getFromId()) == null) ? "" : fromId2;
                            dLCCardDrawModel19 = dLCDrawCardDataManager.drawCardItem;
                            String str3 = (dLCCardDrawModel19 == null || (fSource2 = dLCCardDrawModel19.getFSource()) == null) ? "" : fSource2;
                            dLCCardDrawModel20 = dLCDrawCardDataManager.drawCardItem;
                            dLCReporterHelper.reportDrawCardResultShow(actId2, lotteryId2, activityStatus, lotteryNum2, str, str2, str3, dLCCardDrawModel20 != null ? dLCCardDrawModel20.getPageType() : 0);
                        } else {
                            DLCReporterHelper dLCReporterHelper2 = DLCReporterHelper.INSTANCE;
                            dLCCardDrawModel5 = dLCDrawCardDataManager.drawCardItem;
                            long actId3 = dLCCardDrawModel5 != null ? dLCCardDrawModel5.getActId() : 0L;
                            dLCCardDrawModel6 = dLCDrawCardDataManager.drawCardItem;
                            long lotteryId3 = dLCCardDrawModel6 != null ? dLCCardDrawModel6.getLotteryId() : 0L;
                            dLCCardDrawModel7 = dLCDrawCardDataManager.drawCardItem;
                            int activityStatus2 = dLCCardDrawModel7 != null ? dLCCardDrawModel7.getActivityStatus() : 0;
                            dLCCardDrawModel8 = dLCDrawCardDataManager.drawCardItem;
                            int lotteryNum3 = dLCCardDrawModel8 != null ? dLCCardDrawModel8.getLotteryNum() : 0;
                            dLCCardDrawModel9 = dLCDrawCardDataManager.drawCardItem;
                            String str4 = (dLCCardDrawModel9 == null || (fromWhere = dLCCardDrawModel9.getFromWhere()) == null) ? "" : fromWhere;
                            dLCCardDrawModel10 = dLCDrawCardDataManager.drawCardItem;
                            String str5 = (dLCCardDrawModel10 == null || (fromId = dLCCardDrawModel10.getFromId()) == null) ? "" : fromId;
                            dLCCardDrawModel11 = dLCDrawCardDataManager.drawCardItem;
                            String str6 = (dLCCardDrawModel11 == null || (fSource = dLCCardDrawModel11.getFSource()) == null) ? "" : fSource;
                            dLCCardDrawModel12 = dLCDrawCardDataManager.drawCardItem;
                            dLCReporterHelper2.reportDrawCardApiSuccess(actId3, lotteryId3, activityStatus2, lotteryNum3, str4, str5, str6, dLCCardDrawModel12 != null ? dLCCardDrawModel12.getPageType() : 0);
                        }
                        CancellableContinuation<CardDataState> cancellableContinuation = continuation;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation.resumeWith(Result.constructor-impl(new CardDataState.Success(data)));
                        BLog.i(DLCDrawCardDataManager.Companion.getTAG(), "drawCard api suc");
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            case 1:
                DLCDrawCardDataManager dLCDrawCardDataManager2 = (DLCDrawCardDataManager) this.L$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}