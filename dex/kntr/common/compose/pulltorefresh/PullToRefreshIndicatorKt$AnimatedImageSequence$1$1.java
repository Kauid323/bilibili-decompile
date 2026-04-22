package kntr.common.compose.pulltorefresh;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.graphics.ImageBitmap;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PullToRefreshIndicator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt$AnimatedImageSequence$1$1", f = "PullToRefreshIndicator.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PullToRefreshIndicatorKt$AnimatedImageSequence$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentFrameIndex$delegate;
    final /* synthetic */ long $frameDurationMs;
    final /* synthetic */ List<ImageBitmap> $imageBitmaps;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshIndicatorKt$AnimatedImageSequence$1$1(long j, List<? extends ImageBitmap> list, MutableIntState mutableIntState, Continuation<? super PullToRefreshIndicatorKt$AnimatedImageSequence$1$1> continuation) {
        super(2, continuation);
        this.$frameDurationMs = j;
        this.$imageBitmaps = list;
        this.$currentFrameIndex$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullToRefreshIndicatorKt$AnimatedImageSequence$1$1(this.$frameDurationMs, this.$imageBitmaps, this.$currentFrameIndex$delegate, continuation);
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0027 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            switch(r1) {
                case 0: goto L17;
                case 1: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L12:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r6
            goto L2a
        L17:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r6
        L1b:
            long r3 = r1.$frameDurationMs
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L2a
            return r0
        L2a:
            androidx.compose.runtime.MutableIntState r3 = r1.$currentFrameIndex$delegate
            androidx.compose.runtime.MutableIntState r4 = r1.$currentFrameIndex$delegate
            int r4 = kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt.access$AnimatedImageSequence$lambda$2(r4)
            int r4 = r4 + r2
            java.util.List<androidx.compose.ui.graphics.ImageBitmap> r5 = r1.$imageBitmaps
            int r5 = r5.size()
            int r4 = r4 % r5
            kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt.access$AnimatedImageSequence$lambda$3(r3, r4)
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt$AnimatedImageSequence$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}