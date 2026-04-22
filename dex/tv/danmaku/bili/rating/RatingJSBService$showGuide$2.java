package tv.danmaku.bili.rating;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.MapByteBuffer;
import com.bilibili.lib.blkv.RawKV;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;

/* compiled from: RatingJSB.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.rating.RatingJSBService$showGuide$2", f = "RatingJSB.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RatingJSBService$showGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $count;
    final /* synthetic */ DirectRatingGuide $directRatingGuide;
    final /* synthetic */ RatingThenGuide $ratingThenGuide;
    final /* synthetic */ int $specialPage;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingJSBService$showGuide$2(DirectRatingGuide directRatingGuide, Context context, String str, int i, RatingThenGuide ratingThenGuide, Continuation<? super RatingJSBService$showGuide$2> continuation) {
        super(2, continuation);
        this.$directRatingGuide = directRatingGuide;
        this.$context = context;
        this.$count = str;
        this.$specialPage = i;
        this.$ratingThenGuide = ratingThenGuide;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RatingJSBService$showGuide$2(this.$directRatingGuide, this.$context, this.$count, this.$specialPage, this.$ratingThenGuide, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$directRatingGuide != null) {
                    BLog.i("RatingGuide", "显示直接引导弹窗directRatingGuide  " + this.$directRatingGuide);
                    Context context = this.$context;
                    DirectRatingGuide directRatingGuide = this.$directRatingGuide;
                    String str = this.$count;
                    int i = this.$specialPage;
                    final Context context2 = this.$context;
                    RatingDialogDirectGuide dialog = new RatingDialogDirectGuide(context, directRatingGuide, str, i, new Function0() { // from class: tv.danmaku.bili.rating.RatingJSBService$showGuide$2$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = RatingJSBService$showGuide$2.invokeSuspend$lambda$0(context2);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    dialog.show();
                }
                if (this.$ratingThenGuide != null) {
                    BLog.i("RatingGuide", "显示打分弹窗ratingThenGuide  " + this.$ratingThenGuide);
                    Map extra = new HashMap(3);
                    extra.put("appear_times", this.$count);
                    extra.put("type", "1");
                    extra.put("special_page", String.valueOf(this.$specialPage));
                    Neurons.reportExposure$default(false, "main.score-popup.0.0.show", extra, (List) null, 8, (Object) null);
                    Context context3 = this.$context;
                    RatingThenGuide ratingThenGuide = this.$ratingThenGuide;
                    String str2 = this.$count;
                    int i2 = this.$specialPage;
                    final Context context4 = this.$context;
                    RatingDialogRating dialog2 = new RatingDialogRating(context3, ratingThenGuide, str2, i2, new Function0() { // from class: tv.danmaku.bili.rating.RatingJSBService$showGuide$2$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = RatingJSBService$showGuide$2.invokeSuspend$lambda$1(context4);
                            return invokeSuspend$lambda$1;
                        }
                    });
                    dialog2.show();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Context $context) {
        RawKV kvs;
        AbsMarket market = MarketHelper.INSTANCE.getSystemMarket();
        MarketHelper.INSTANCE.launchAppDetail($context, BuildConfig.LIBRARY_PACKAGE_NAME, market, new Function1() { // from class: tv.danmaku.bili.rating.RatingJSBService$showGuide$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = RatingJSBService$showGuide$2.invokeSuspend$lambda$0$0((Intent) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
        Application application = BiliContext.application();
        if (application != null && (kvs = BLKV.getKvs(application, RatingEventRegisterKt.RATING_DIALOG_COUNT_FILE_NAME, false, MapByteBuffer.Companion.getPAGE_SIZE())) != null) {
            kvs.putInt(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, 5);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(Intent $this$launchAppDetail) {
        $this$launchAppDetail.setFlags(268435456);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Context $context) {
        RawKV kvs;
        AbsMarket market = MarketHelper.INSTANCE.getSystemMarket();
        MarketHelper.INSTANCE.launchAppDetail($context, BuildConfig.LIBRARY_PACKAGE_NAME, market, new Function1() { // from class: tv.danmaku.bili.rating.RatingJSBService$showGuide$2$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = RatingJSBService$showGuide$2.invokeSuspend$lambda$1$0((Intent) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
        Application application = BiliContext.application();
        if (application != null && (kvs = BLKV.getKvs(application, RatingEventRegisterKt.RATING_DIALOG_COUNT_FILE_NAME, false, MapByteBuffer.Companion.getPAGE_SIZE())) != null) {
            kvs.putInt(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, 5);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Intent $this$launchAppDetail) {
        $this$launchAppDetail.setFlags(268435456);
        return Unit.INSTANCE;
    }
}