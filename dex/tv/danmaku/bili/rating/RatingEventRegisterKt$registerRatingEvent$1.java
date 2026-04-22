package tv.danmaku.bili.rating;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.playerbizcommon.message.VideoLikeMessage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RatingEventRegister.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.rating.RatingEventRegisterKt$registerRatingEvent$1", f = "RatingEventRegister.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RatingEventRegisterKt$registerRatingEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RawKV $blkv;
    final /* synthetic */ Function3<DirectRatingGuide, RatingThenGuide, String, Unit> $block;
    final /* synthetic */ int $cd;
    final /* synthetic */ Observer<VideoLikeMessage> $observer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RatingEventRegisterKt$registerRatingEvent$1(RawKV rawKV, int i, Function3<? super DirectRatingGuide, ? super RatingThenGuide, ? super String, Unit> function3, Observer<VideoLikeMessage> observer, Continuation<? super RatingEventRegisterKt$registerRatingEvent$1> continuation) {
        super(2, continuation);
        this.$blkv = rawKV;
        this.$cd = i;
        this.$block = function3;
        this.$observer = observer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ratingEventRegisterKt$registerRatingEvent$1 = new RatingEventRegisterKt$registerRatingEvent$1(this.$blkv, this.$cd, this.$block, this.$observer, continuation);
        ratingEventRegisterKt$registerRatingEvent$1.L$0 = obj;
        return ratingEventRegisterKt$registerRatingEvent$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                final RawKV rawKV = this.$blkv;
                final int i = this.$cd;
                final Function3<DirectRatingGuide, RatingThenGuide, String, Unit> function3 = this.$block;
                CoroutineScope $this$awaitCancel$iv = new BiliContext.ActivityStateCallback() { // from class: tv.danmaku.bili.rating.RatingEventRegisterKt$registerRatingEvent$1$callback$1
                    /* JADX WARN: Removed duplicated region for block: B:10:0x001a A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
                        boolean backToHomePage;
                        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
                        if (lastForegroundCount == 2 && currentForegroundCount == 1) {
                            backToHomePage = true;
                            if (backToHomePage) {
                                return;
                            }
                            Ref.IntRef count = new Ref.IntRef();
                            RawKV rawKV2 = rawKV;
                            count.element = rawKV2 != null ? ((Number) rawKV2.get(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, 1)).intValue() : 1;
                            if (count.element > 3) {
                                return;
                            }
                            boolean ratingDisplayCD = RatingEventRegisterKt.isRatingDisplayCD(rawKV, i);
                            if (!ratingDisplayCD) {
                                RawKV rawKV3 = rawKV;
                                long likeCount = rawKV3 != null ? ((Number) rawKV3.get(RatingEventRegisterKt.RATING_DIALOG_LIKE_COUNT_KEY, 0L)).longValue() : 0L;
                                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new RatingEventRegisterKt$registerRatingEvent$1$callback$1$onForegroundActivitiesChanged$1(count, likeCount, function3, rawKV, null), 3, (Object) null);
                                return;
                            }
                            return;
                        }
                        backToHomePage = false;
                        if (backToHomePage) {
                        }
                    }
                };
                BiliContext.registerActivityStateCallback((BiliContext.ActivityStateCallback) $this$awaitCancel$iv);
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new RatingEventRegisterKt$registerRatingEvent$1$invokeSuspend$$inlined$awaitCancel$1(null, $this$awaitCancel$iv, this.$observer), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}