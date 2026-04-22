package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.runtime.MutableIntState;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.TopContainerKt$VerticalCarouselComponent$4$1", f = "TopContainer.kt", i = {1}, l = {910, 914}, m = "invokeSuspend", n = {"nextIndex"}, s = {"I$0"}, v = 1)
public final class TopContainerKt$VerticalCarouselComponent$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $animDurationMs;
    final /* synthetic */ MutableIntState $displayIndex$delegate;
    final /* synthetic */ List<BasicInfoFloor.SalePoint> $displayList;
    final /* synthetic */ long $intervalMs;
    final /* synthetic */ MutableIntState $settledIndex$delegate;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopContainerKt$VerticalCarouselComponent$4$1(List<BasicInfoFloor.SalePoint> list, long j, int i, MutableIntState mutableIntState, MutableIntState mutableIntState2, Continuation<? super TopContainerKt$VerticalCarouselComponent$4$1> continuation) {
        super(2, continuation);
        this.$displayList = list;
        this.$intervalMs = j;
        this.$animDurationMs = i;
        this.$settledIndex$delegate = mutableIntState;
        this.$displayIndex$delegate = mutableIntState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TopContainerKt$VerticalCarouselComponent$4$1(this.$displayList, this.$intervalMs, this.$animDurationMs, this.$settledIndex$delegate, this.$displayIndex$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0081 -> B:19:0x0084). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            switch(r1) {
                case 0: goto L1f;
                case 1: goto L1a;
                case 2: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L12:
            int r1 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            r3 = r1
            r1 = r8
            goto L84
        L1a:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r8
            goto L5f
        L1f:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.runtime.MutableIntState r1 = r8.$settledIndex$delegate
            androidx.compose.runtime.MutableIntState r3 = r8.$settledIndex$delegate
            int r3 = kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$5(r3)
            java.util.List<kntr.app.mall.product.details.page.api.model.BasicInfoFloor$SalePoint> r4 = r8.$displayList
            int r4 = r4.size()
            int r3 = r3 % r4
            r4 = 0
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast(r3, r4)
            kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$6(r1, r3)
            androidx.compose.runtime.MutableIntState r1 = r8.$displayIndex$delegate
            androidx.compose.runtime.MutableIntState r3 = r8.$settledIndex$delegate
            int r3 = kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$5(r3)
            kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$9(r1, r3)
            java.util.List<kntr.app.mall.product.details.page.api.model.BasicInfoFloor$SalePoint> r1 = r8.$displayList
            int r1 = r1.size()
            if (r1 > r2) goto L4f
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L4f:
            r1 = r8
        L50:
            long r3 = r1.$intervalMs
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L5f
            return r0
        L5f:
            androidx.compose.runtime.MutableIntState r3 = r1.$displayIndex$delegate
            int r3 = kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$8(r3)
            int r3 = r3 + r2
            java.util.List<kntr.app.mall.product.details.page.api.model.BasicInfoFloor$SalePoint> r4 = r1.$displayList
            int r4 = r4.size()
            int r3 = r3 % r4
            androidx.compose.runtime.MutableIntState r4 = r1.$displayIndex$delegate
            kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$9(r4, r3)
            int r4 = r1.$animDurationMs
            long r4 = (long) r4
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.I$0 = r3
            r7 = 2
            r1.label = r7
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r6)
            if (r4 != r0) goto L84
            return r0
        L84:
            androidx.compose.runtime.MutableIntState r4 = r1.$settledIndex$delegate
            kntr.app.mall.product.details.page.ui.container.TopContainerKt.access$VerticalCarouselComponent$lambda$6(r4, r3)
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.container.TopContainerKt$VerticalCarouselComponent$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}