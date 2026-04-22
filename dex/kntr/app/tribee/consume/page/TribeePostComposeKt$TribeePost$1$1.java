package kntr.app.tribee.consume.page;

import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortType;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePostCompose.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeePostComposeKt$TribeePost$1$1", f = "TribeePostCompose.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePostComposeKt$TribeePost$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KTribeeCategory $category;
    final /* synthetic */ String $fromSpmid;
    final /* synthetic */ KTribeeDyn $post;
    final /* synthetic */ long $selectedCategoryId;
    final /* synthetic */ KTribeeSortType $sortType;
    final /* synthetic */ String $tribeeId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePostComposeKt$TribeePost$1$1(long j, KTribeeCategory kTribeeCategory, String str, KTribeeDyn kTribeeDyn, String str2, KTribeeSortType kTribeeSortType, Continuation<? super TribeePostComposeKt$TribeePost$1$1> continuation) {
        super(2, continuation);
        this.$selectedCategoryId = j;
        this.$category = kTribeeCategory;
        this.$tribeeId = str;
        this.$post = kTribeeDyn;
        this.$fromSpmid = str2;
        this.$sortType = kTribeeSortType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePostComposeKt$TribeePost$1$1(this.$selectedCategoryId, this.$category, this.$tribeeId, this.$post, this.$fromSpmid, this.$sortType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$selectedCategoryId == this.$category.getId()) {
                    TrackerKt.reportExposurePost(this.$tribeeId, String.valueOf(this.$post.getDynId()), this.$category.getId(), this.$category.getName(), this.$fromSpmid, String.valueOf(this.$sortType.getValue()));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}