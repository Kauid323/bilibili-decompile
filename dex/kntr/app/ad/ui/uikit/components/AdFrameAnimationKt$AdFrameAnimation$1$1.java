package kntr.app.ad.ui.uikit.components;

import androidx.compose.runtime.MutableIntState;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.DrawableResource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdFrameAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.uikit.components.AdFrameAnimationKt$AdFrameAnimation$1$1", f = "AdFrameAnimation.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AdFrameAnimationKt$AdFrameAnimation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentFrame$delegate;
    final /* synthetic */ long $frameDuration;
    final /* synthetic */ List<DrawableResource> $frameImages;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFrameAnimationKt$AdFrameAnimation$1$1(long j2, List<DrawableResource> list, MutableIntState mutableIntState, Continuation<? super AdFrameAnimationKt$AdFrameAnimation$1$1> continuation) {
        super(2, continuation);
        this.$frameDuration = j2;
        this.$frameImages = list;
        this.$currentFrame$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdFrameAnimationKt$AdFrameAnimation$1$1(this.$frameDuration, this.$frameImages, this.$currentFrame$delegate, continuation);
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
            long r3 = r1.$frameDuration
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L2a
            return r0
        L2a:
            androidx.compose.runtime.MutableIntState r3 = r1.$currentFrame$delegate
            androidx.compose.runtime.MutableIntState r4 = r1.$currentFrame$delegate
            int r4 = kntr.app.ad.ui.uikit.components.AdFrameAnimationKt.access$AdFrameAnimation__jt2gSs$lambda$1(r4)
            int r4 = r4 + r2
            java.util.List<org.jetbrains.compose.resources.DrawableResource> r5 = r1.$frameImages
            int r5 = r5.size()
            int r4 = r4 % r5
            kntr.app.ad.ui.uikit.components.AdFrameAnimationKt.access$AdFrameAnimation__jt2gSs$lambda$2(r3, r4)
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.ui.uikit.components.AdFrameAnimationKt$AdFrameAnimation$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}