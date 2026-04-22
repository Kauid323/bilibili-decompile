package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableFloatState;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiniVideoFloatingComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1", f = "MiniVideoFloatingComponent.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $progress$delegate;
    final /* synthetic */ SimplePlayer $videoPlayer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1(SimplePlayer simplePlayer, MutableFloatState mutableFloatState, Continuation<? super MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1> continuation) {
        super(2, continuation);
        this.$videoPlayer = simplePlayer;
        this.$progress$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1(this.$videoPlayer, this.$progress$delegate, continuation);
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0034 -> B:28:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            switch(r1) {
                case 0: goto L16;
                case 1: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L11:
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r10
            goto L37
        L16:
            kotlin.ResultKt.throwOnFailure(r11)
            com.bilibili.framework.simpleplayer.SimplePlayer r1 = r10.$videoPlayer
            com.bilibili.framework.simpleplayer.SimplePlayerState r1 = r1.getState()
            com.bilibili.framework.simpleplayer.SimplePlayerState r2 = com.bilibili.framework.simpleplayer.SimplePlayerState.READY
            if (r1 == r2) goto L26
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L26:
            r1 = r10
        L27:
            r2 = r1
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 1
            r1.label = r3
            r3 = 33
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r3, r2)
            if (r2 != r0) goto L37
            return r0
        L37:
            com.bilibili.framework.simpleplayer.SimplePlayer r2 = r1.$videoPlayer     // Catch: java.lang.Exception -> L3f
            long r2 = r2.getCurrentProgress-UwyO8pc()     // Catch: java.lang.Exception -> L3f
            goto L47
        L3f:
            r2 = move-exception
            kotlin.time.Duration$Companion r3 = kotlin.time.Duration.Companion
            long r3 = r3.getZERO-UwyO8pc()
            r2 = r3
        L47:
            com.bilibili.framework.simpleplayer.SimplePlayer r4 = r1.$videoPlayer     // Catch: java.lang.Exception -> L51
            long r4 = r4.getDuration-UwyO8pc()     // Catch: java.lang.Exception -> L51
            goto L59
        L51:
            r4 = move-exception
            kotlin.time.Duration$Companion r5 = kotlin.time.Duration.Companion
            long r5 = r5.getZERO-UwyO8pc()
            r4 = r5
        L59:
            boolean r6 = kotlin.time.Duration.isPositive-impl(r4)
            if (r6 == 0) goto L27
            double r6 = kotlin.time.Duration.div-LRDsOJo(r2, r4)
            float r6 = (float) r6
            androidx.compose.runtime.MutableFloatState r7 = r1.$progress$delegate
            r8 = 0
            r9 = 1065353216(0x3f800000, float:1.0)
            float r8 = kotlin.ranges.RangesKt.coerceIn(r6, r8, r9)
            kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt.access$MiniVideoPlayerComponent$lambda$1$4$2(r7, r8)
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}