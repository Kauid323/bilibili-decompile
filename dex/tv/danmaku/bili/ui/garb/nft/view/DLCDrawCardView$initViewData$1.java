package tv.danmaku.bili.ui.garb.nft.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.CardDataState;
import tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCDrawCardView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$initViewData$1", f = "DLCDrawCardView.kt", i = {}, l = {BR.eventHandle}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DLCDrawCardView$initViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DLCDrawCardView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCDrawCardView$initViewData$1(DLCDrawCardView dLCDrawCardView, Continuation<? super DLCDrawCardView$initViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = dLCDrawCardView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCDrawCardView$initViewData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c A[Catch: Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:17:0x003e, B:21:0x0049, B:23:0x006c, B:24:0x0073, B:26:0x0077, B:27:0x008a, B:29:0x008e, B:30:0x009c, B:32:0x00a0, B:34:0x00b8, B:36:0x00c2, B:38:0x00e1, B:43:0x00ec, B:45:0x00f4, B:50:0x00fe, B:51:0x0104, B:52:0x010a, B:54:0x010e, B:55:0x0114), top: B:62:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[Catch: Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:17:0x003e, B:21:0x0049, B:23:0x006c, B:24:0x0073, B:26:0x0077, B:27:0x008a, B:29:0x008e, B:30:0x009c, B:32:0x00a0, B:34:0x00b8, B:36:0x00c2, B:38:0x00e1, B:43:0x00ec, B:45:0x00f4, B:50:0x00fe, B:51:0x0104, B:52:0x010a, B:54:0x010e, B:55:0x0114), top: B:62:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String str;
        DLCDrawCardDataManager dLCDrawCardDataManager;
        DLCCardDrawModel dLCCardDrawModel;
        Object $result2;
        String str2;
        String str3;
        List dlcItems;
        DLCCardDrawModel dLCCardDrawModel2;
        DLCCardDrawModel dLCCardDrawModel3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    dLCDrawCardDataManager = this.this$0.viewData;
                    if (dLCDrawCardDataManager != null) {
                        dLCCardDrawModel = this.this$0.drawCardModel;
                        Intrinsics.checkNotNull(dLCCardDrawModel);
                        this.label = 1;
                        Object requestData = dLCDrawCardDataManager.requestData(dLCCardDrawModel, (Continuation) this);
                        if (requestData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = requestData;
                        try {
                            $result = (CardDataState) $result;
                            str2 = DLCDrawCardView.TAG;
                            BLog.i(str2, "cardDataState:" + $result);
                            if (Intrinsics.areEqual($result, CardDataState.Loading.INSTANCE)) {
                                this.this$0.showLoadingView();
                            } else if ($result instanceof CardDataState.ResFailed) {
                                this.this$0.respInfo = ((CardDataState.ResFailed) $result).getDlcRespInfo();
                                this.this$0.showResDownFailed();
                            } else if ($result instanceof CardDataState.ApiFailed) {
                                this.this$0.showApiFailedView(((CardDataState.ApiFailed) $result).getMsg());
                            } else if ($result instanceof CardDataState.Success) {
                                this.this$0.respInfo = ((CardDataState.Success) $result).getDlcRespInfo();
                                str3 = DLCDrawCardView.TAG;
                                dlcItems = this.this$0.getDlcItems();
                                BLog.i(str3, "cardSize: " + (dlcItems != null ? Boxing.boxInt(dlcItems.size()) : null));
                                dLCCardDrawModel2 = this.this$0.drawCardModel;
                                boolean z = false;
                                if (!(dLCCardDrawModel2 != null && dLCCardDrawModel2.getScreenType() == 0)) {
                                    dLCCardDrawModel3 = this.this$0.drawCardModel;
                                    if (dLCCardDrawModel3 != null && dLCCardDrawModel3.getHasDrawCardAnimation() == 1) {
                                        z = true;
                                    }
                                    if (!z) {
                                        this.this$0.startHalfScreenFlow();
                                    }
                                }
                                this.this$0.startFullScreenFlow();
                            } else if ($result instanceof CardDataState.Timeout) {
                                DLCDrawCardView.showApiFailedView$default(this.this$0, null, 1, null);
                            } else {
                                DLCDrawCardView.showApiFailedView$default(this.this$0, null, 1, null);
                            }
                        } catch (Exception e) {
                            Object obj = $result2;
                            e = e;
                            $result = obj;
                            str = DLCDrawCardView.TAG;
                            BLog.i(str, "initViewData error " + e.getMessage());
                            DLCDrawCardView.showApiFailedView$default(this.this$0, null, 1, null);
                            return Unit.INSTANCE;
                        }
                    } else {
                        $result = null;
                        str2 = DLCDrawCardView.TAG;
                        BLog.i(str2, "cardDataState:" + $result);
                        if (Intrinsics.areEqual($result, CardDataState.Loading.INSTANCE)) {
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    $result = (CardDataState) $result;
                    str2 = DLCDrawCardView.TAG;
                    BLog.i(str2, "cardDataState:" + $result);
                    if (Intrinsics.areEqual($result, CardDataState.Loading.INSTANCE)) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e2) {
            e = e2;
        }
        return Unit.INSTANCE;
    }
}