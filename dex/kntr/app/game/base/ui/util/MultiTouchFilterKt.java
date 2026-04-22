package kntr.app.game.base.ui.util;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;

/* compiled from: MultiTouchFilter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"singleTouchOnly", "Landroidx/compose/ui/Modifier;", "throttleWindowMs", RoomRecommendViewModel.EMPTY_CURSOR, "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MultiTouchFilterKt {
    public static /* synthetic */ Modifier singleTouchOnly$default(Modifier modifier, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = 400;
        }
        return singleTouchOnly(modifier, j2);
    }

    public static final Modifier singleTouchOnly(Modifier $this$singleTouchOnly, final long throttleWindowMs) {
        Intrinsics.checkNotNullParameter($this$singleTouchOnly, "<this>");
        return SuspendingPointerInputFilterKt.pointerInput($this$singleTouchOnly, Long.valueOf(throttleWindowMs), new PointerInputEventHandler() { // from class: kntr.app.game.base.ui.util.MultiTouchFilterKt$singleTouchOnly$1
            public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                TimeSource.Monotonic timeSource = TimeSource.Monotonic.INSTANCE;
                Ref.LongRef lastEventMark = new Ref.LongRef();
                long j2 = timeSource.markNow-z9LOYto();
                Duration.Companion companion = Duration.Companion;
                lastEventMark.element = TimeSource.Monotonic.ValueTimeMark.minus-LRDsOJo(j2, DurationKt.toDuration(throttleWindowMs, DurationUnit.MILLISECONDS));
                Ref.ObjectRef allowedPointerId = new Ref.ObjectRef();
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$pointerInput, new AnonymousClass1(timeSource, lastEventMark, throttleWindowMs, allowedPointerId, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }

            /* compiled from: MultiTouchFilter.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "kntr.app.game.base.ui.util.MultiTouchFilterKt$singleTouchOnly$1$1", f = "MultiTouchFilter.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {37, 46, 55}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "currentMark", "timeSinceLastEvent", "$this$awaitEachGesture", "firstDown", "currentMark", "timeSinceLastEvent"}, s = {"L$0", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1"}, v = 1)
            /* renamed from: kntr.app.game.base.ui.util.MultiTouchFilterKt$singleTouchOnly$1$1  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.ObjectRef<Long> $allowedPointerId;
                final /* synthetic */ Ref.LongRef $lastEventMark;
                final /* synthetic */ long $throttleWindowMs;
                final /* synthetic */ TimeSource.Monotonic $timeSource;
                long J$0;
                long J$1;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(TimeSource.Monotonic monotonic, Ref.LongRef longRef, long j2, Ref.ObjectRef<Long> objectRef, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$timeSource = monotonic;
                    this.$lastEventMark = longRef;
                    this.$throttleWindowMs = j2;
                    this.$allowedPointerId = objectRef;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$timeSource, this.$lastEventMark, this.$throttleWindowMs, this.$allowedPointerId, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
                    */
                /* JADX WARN: Removed duplicated region for block: B:39:0x012e A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x013b  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x017c  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x0191  */
                /* JADX WARN: Removed duplicated region for block: B:66:0x01a6  */
                /* JADX WARN: Removed duplicated region for block: B:76:0x01a3 A[SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a3 -> B:18:0x00a6). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x012c -> B:40:0x012f). Please submit an issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r28) {
                    /*
                        Method dump skipped, instructions count: 442
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.base.ui.util.MultiTouchFilterKt$singleTouchOnly$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        });
    }
}