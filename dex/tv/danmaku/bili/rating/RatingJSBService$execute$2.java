package tv.danmaku.bili.rating;

import android.content.Context;
import com.bapis.bilibili.app.home.v1.HomeMoss;
import com.bapis.bilibili.app.home.v1.HomeMossKtxKt;
import com.bapis.bilibili.app.home.v1.HomePopupReq;
import com.bapis.bilibili.app.home.v1.HomePopupRes;
import com.bapis.bilibili.app.home.v1.RatingGuidePopupParams;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.lib.moss.api.CallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: RatingJSB.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.rating.RatingJSBService$execute$2", f = "RatingJSB.kt", i = {}, l = {BR.buttonText, BR.calenderVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RatingJSBService$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RawKV $blkv;
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.IntRef $count;
    final /* synthetic */ int $lastCount;
    final /* synthetic */ long $likeCount;
    final /* synthetic */ int $specialPage;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RatingJSBService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingJSBService$execute$2(int i, int i2, long j, RatingJSBService ratingJSBService, Context context, Ref.IntRef intRef, RawKV rawKV, Continuation<? super RatingJSBService$execute$2> continuation) {
        super(2, continuation);
        this.$lastCount = i;
        this.$specialPage = i2;
        this.$likeCount = j;
        this.this$0 = ratingJSBService;
        this.$context = context;
        this.$count = intRef;
        this.$blkv = rawKV;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RatingJSBService$execute$2(this.$lastCount, this.$specialPage, this.$likeCount, this.this$0, this.$context, this.$count, this.$blkv, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[Catch: Exception -> 0x0025, TryCatch #1 {Exception -> 0x0025, blocks: (B:7:0x001b, B:30:0x00b8, B:32:0x00bf, B:34:0x00cd, B:36:0x00dd, B:8:0x0020, B:13:0x0051), top: B:47:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd A[Catch: Exception -> 0x0025, TryCatch #1 {Exception -> 0x0025, blocks: (B:7:0x001b, B:30:0x00b8, B:32:0x00bf, B:34:0x00cd, B:36:0x00dd, B:8:0x0020, B:13:0x0051), top: B:47:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd A[Catch: Exception -> 0x0025, TRY_LEAVE, TryCatch #1 {Exception -> 0x0025, blocks: (B:7:0x001b, B:30:0x00b8, B:32:0x00bf, B:34:0x00cd, B:36:0x00dd, B:8:0x0020, B:13:0x0051), top: B:47:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        HomePopupRes homePopupRes;
        com.bapis.bilibili.app.home.v1.RatingGuidePopup it;
        Ref.IntRef intRef;
        RawKV rawKV;
        RatingGuidePopup ratingGuide;
        Object showGuide;
        Ref.IntRef intRef2;
        RawKV rawKV2;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            e = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HomePopupReq homePopupReq = HomePopupReq.newBuilder().setRgpp(RatingGuidePopupParams.newBuilder().setShowCount(this.$lastCount).setSpecialPage(this.$specialPage).setLikeCount(this.$likeCount)).build();
                HomeMoss homeMoss = new HomeMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNull(homePopupReq);
                this.label = 1;
                Object suspendHomePopup = HomeMossKtxKt.suspendHomePopup(homeMoss, homePopupReq, (Continuation) this);
                if (suspendHomePopup == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = suspendHomePopup;
                try {
                    homePopupRes = (HomePopupRes) $result;
                    if (homePopupRes != null && (it = homePopupRes.getRatingGuide()) != null) {
                        RatingJSBService ratingJSBService = this.this$0;
                        Context context = this.$context;
                        intRef = this.$count;
                        int i = this.$specialPage;
                        rawKV = this.$blkv;
                        ratingGuide = new RatingGuidePopup(it);
                        if (ratingGuide.getDirectRatingGuide() == null || ratingGuide.getRatingThenGuide() != null) {
                            DirectRatingGuide directRatingGuide = ratingGuide.getDirectRatingGuide();
                            RatingThenGuide ratingThenGuide = ratingGuide.getRatingThenGuide();
                            String valueOf = String.valueOf(intRef.element);
                            this.L$0 = intRef;
                            this.L$1 = rawKV;
                            this.label = 2;
                            showGuide = ratingJSBService.showGuide(context, directRatingGuide, ratingThenGuide, valueOf, i, this);
                            if (showGuide != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = $result2;
                            intRef2 = intRef;
                            rawKV2 = rawKV;
                            z = false;
                            intRef2.element++;
                            if (rawKV2 != null) {
                                Boxing.boxBoolean(rawKV2.putInt(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, intRef2.element));
                            }
                            if (rawKV2 != null) {
                                Boxing.boxBoolean(rawKV2.putLong(RatingEventRegisterKt.RATING_DIALOG_LAST_DISPLAY_TIME_KEY, System.currentTimeMillis()));
                            }
                            if (rawKV2 != null) {
                                Boxing.boxBoolean(rawKV2.putLong(RatingEventRegisterKt.RATING_DIALOG_LIKE_COUNT_KEY, 0L));
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    $result = $result2;
                    BLog.i("suspendHomePopup", e.toString());
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                homePopupRes = (HomePopupRes) $result;
                if (homePopupRes != null) {
                    RatingJSBService ratingJSBService2 = this.this$0;
                    Context context2 = this.$context;
                    intRef = this.$count;
                    int i2 = this.$specialPage;
                    rawKV = this.$blkv;
                    ratingGuide = new RatingGuidePopup(it);
                    if (ratingGuide.getDirectRatingGuide() == null) {
                        break;
                    }
                    DirectRatingGuide directRatingGuide2 = ratingGuide.getDirectRatingGuide();
                    RatingThenGuide ratingThenGuide2 = ratingGuide.getRatingThenGuide();
                    String valueOf2 = String.valueOf(intRef.element);
                    this.L$0 = intRef;
                    this.L$1 = rawKV;
                    this.label = 2;
                    showGuide = ratingJSBService2.showGuide(context2, directRatingGuide2, ratingThenGuide2, valueOf2, i2, this);
                    if (showGuide != coroutine_suspended) {
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                z = false;
                rawKV2 = (RawKV) this.L$1;
                intRef2 = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure($result);
                intRef2.element++;
                if (rawKV2 != null) {
                }
                if (rawKV2 != null) {
                }
                if (rawKV2 != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}