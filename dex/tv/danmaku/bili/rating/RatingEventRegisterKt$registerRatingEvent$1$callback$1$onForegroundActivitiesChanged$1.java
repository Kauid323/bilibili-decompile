package tv.danmaku.bili.rating;

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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: RatingEventRegister.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.rating.RatingEventRegisterKt$registerRatingEvent$1$callback$1$onForegroundActivitiesChanged$1", f = "RatingEventRegister.kt", i = {}, l = {BR.cardHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RatingEventRegisterKt$registerRatingEvent$1$callback$1$onForegroundActivitiesChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RawKV $blkv;
    final /* synthetic */ Function3<DirectRatingGuide, RatingThenGuide, String, Unit> $block;
    final /* synthetic */ Ref.IntRef $count;
    final /* synthetic */ long $likeCount;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RatingEventRegisterKt$registerRatingEvent$1$callback$1$onForegroundActivitiesChanged$1(Ref.IntRef intRef, long j, Function3<? super DirectRatingGuide, ? super RatingThenGuide, ? super String, Unit> function3, RawKV rawKV, Continuation<? super RatingEventRegisterKt$registerRatingEvent$1$callback$1$onForegroundActivitiesChanged$1> continuation) {
        super(2, continuation);
        this.$count = intRef;
        this.$likeCount = j;
        this.$block = function3;
        this.$blkv = rawKV;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RatingEventRegisterKt$registerRatingEvent$1$callback$1$onForegroundActivitiesChanged$1(this.$count, this.$likeCount, this.$block, this.$blkv, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.bapis.bilibili.app.home.v1.HomePopupRes] */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        com.bapis.bilibili.app.home.v1.RatingGuidePopup it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure((Object) $result);
                    HomePopupReq homePopupReq = HomePopupReq.newBuilder().setRgpp(RatingGuidePopupParams.newBuilder().setShowCount(this.$count.element).setLikeCount(this.$likeCount)).build();
                    HomeMoss homeMoss = new HomeMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNull(homePopupReq);
                    this.label = 1;
                    Object suspendHomePopup = HomeMossKtxKt.suspendHomePopup(homeMoss, homePopupReq, (Continuation) this);
                    if (suspendHomePopup == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result3 = suspendHomePopup;
                    break;
                case 1:
                    ResultKt.throwOnFailure((Object) $result);
                    $result2 = $result;
                    $result3 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            $result = (HomePopupRes) $result3;
            if ($result != 0 && (it = $result.getRatingGuide()) != null) {
                Function3<DirectRatingGuide, RatingThenGuide, String, Unit> function3 = this.$block;
                Ref.IntRef intRef = this.$count;
                RawKV rawKV = this.$blkv;
                RatingGuidePopup ratingGuide = new RatingGuidePopup(it);
                if (ratingGuide.getDirectRatingGuide() != null || ratingGuide.getRatingThenGuide() != null) {
                    function3.invoke(ratingGuide.getDirectRatingGuide(), ratingGuide.getRatingThenGuide(), String.valueOf(intRef.element));
                    intRef.element++;
                    if (rawKV != null) {
                        Boxing.boxBoolean(rawKV.putInt(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, intRef.element));
                    }
                    if (rawKV != null) {
                        Boxing.boxBoolean(rawKV.putLong(RatingEventRegisterKt.RATING_DIALOG_LAST_DISPLAY_TIME_KEY, System.currentTimeMillis()));
                    }
                    if (rawKV != null) {
                        Boxing.boxBoolean(rawKV.putLong(RatingEventRegisterKt.RATING_DIALOG_LIKE_COUNT_KEY, 0L));
                    }
                }
            }
        } catch (Exception e2) {
            Object obj = $result2;
            e = e2;
            $result = obj;
            BLog.i("suspendHomePopup", e.toString());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}