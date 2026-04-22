package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.pager.PagerState;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: Banner.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.BannerKt$Banner$1$1", f = "Banner.kt", i = {1}, l = {39, 41}, m = "invokeSuspend", n = {"nextPage"}, s = {"I$0"}, v = 1)
final class BannerKt$Banner$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $autoScrollInterval;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ List<String> $texts;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerKt$Banner$1$1(long j, PagerState pagerState, List<String> list, Continuation<? super BannerKt$Banner$1$1> continuation) {
        super(2, continuation);
        this.$autoScrollInterval = j;
        this.$pagerState = pagerState;
        this.$texts = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BannerKt$Banner$1$1(this.$autoScrollInterval, this.$pagerState, this.$texts, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0055 -> B:16:0x0058). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        BannerKt$Banner$1$1 bannerKt$Banner$1$1;
        int nextPage;
        BannerKt$Banner$1$1 bannerKt$Banner$1$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                bannerKt$Banner$1$1 = this;
                bannerKt$Banner$1$1.label = 1;
                if (DelayKt.delay(bannerKt$Banner$1$1.$autoScrollInterval, (Continuation) bannerKt$Banner$1$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nextPage = (bannerKt$Banner$1$1.$pagerState.getCurrentPage() + 1) % bannerKt$Banner$1$1.$texts.size();
                bannerKt$Banner$1$1.I$0 = nextPage;
                bannerKt$Banner$1$1.label = 2;
                if (PagerState.animateScrollToPage$default(bannerKt$Banner$1$1.$pagerState, nextPage, 0.0f, (AnimationSpec) null, (Continuation) bannerKt$Banner$1$1, 6, (Object) null) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                bannerKt$Banner$1$12 = bannerKt$Banner$1$1;
                bannerKt$Banner$1$1 = bannerKt$Banner$1$12;
                bannerKt$Banner$1$1.label = 1;
                if (DelayKt.delay(bannerKt$Banner$1$1.$autoScrollInterval, (Continuation) bannerKt$Banner$1$1) == coroutine_suspended) {
                }
                nextPage = (bannerKt$Banner$1$1.$pagerState.getCurrentPage() + 1) % bannerKt$Banner$1$1.$texts.size();
                bannerKt$Banner$1$1.I$0 = nextPage;
                bannerKt$Banner$1$1.label = 2;
                if (PagerState.animateScrollToPage$default(bannerKt$Banner$1$1.$pagerState, nextPage, 0.0f, (AnimationSpec) null, (Continuation) bannerKt$Banner$1$1, 6, (Object) null) != coroutine_suspended) {
                }
            case 1:
                ResultKt.throwOnFailure($result);
                bannerKt$Banner$1$1 = this;
                nextPage = (bannerKt$Banner$1$1.$pagerState.getCurrentPage() + 1) % bannerKt$Banner$1$1.$texts.size();
                bannerKt$Banner$1$1.I$0 = nextPage;
                bannerKt$Banner$1$1.label = 2;
                if (PagerState.animateScrollToPage$default(bannerKt$Banner$1$1.$pagerState, nextPage, 0.0f, (AnimationSpec) null, (Continuation) bannerKt$Banner$1$1, 6, (Object) null) != coroutine_suspended) {
                }
                break;
            case 2:
                int i = this.I$0;
                ResultKt.throwOnFailure($result);
                bannerKt$Banner$1$12 = this;
                bannerKt$Banner$1$1 = bannerKt$Banner$1$12;
                bannerKt$Banner$1$1.label = 1;
                if (DelayKt.delay(bannerKt$Banner$1$1.$autoScrollInterval, (Continuation) bannerKt$Banner$1$1) == coroutine_suspended) {
                }
                nextPage = (bannerKt$Banner$1$1.$pagerState.getCurrentPage() + 1) % bannerKt$Banner$1$1.$texts.size();
                bannerKt$Banner$1$1.I$0 = nextPage;
                bannerKt$Banner$1$1.label = 2;
                if (PagerState.animateScrollToPage$default(bannerKt$Banner$1$1.$pagerState, nextPage, 0.0f, (AnimationSpec) null, (Continuation) bannerKt$Banner$1$1, 6, (Object) null) != coroutine_suspended) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}