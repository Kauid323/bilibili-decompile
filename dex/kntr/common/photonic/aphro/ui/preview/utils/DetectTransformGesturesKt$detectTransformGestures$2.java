package kntr.common.photonic.aphro.ui.preview.utils;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TransformGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DetectTransformGestures.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.utils.DetectTransformGesturesKt$detectTransformGestures$2", f = "DetectTransformGestures.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {32, 34}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"}, v = 1)
public final class DetectTransformGesturesKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function5<Integer, Offset, Offset, Float, Float, Boolean> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DetectTransformGesturesKt$detectTransformGestures$2(boolean z, Function5<? super Integer, ? super Offset, ? super Offset, ? super Float, ? super Float, Boolean> function5, Continuation<? super DetectTransformGesturesKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function5;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> detectTransformGesturesKt$detectTransformGestures$2 = new DetectTransformGesturesKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        detectTransformGesturesKt$detectTransformGestures$2.L$0 = obj;
        return detectTransformGesturesKt$detectTransformGestures$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x023b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a9 -> B:17:0x00b8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        float rotation;
        float zoom;
        long pan;
        int i;
        float touchSlop;
        int i2;
        DetectTransformGesturesKt$detectTransformGestures$2 detectTransformGesturesKt$detectTransformGestures$2;
        float rotation2;
        Object obj;
        float zoom2;
        long pan2;
        int i3;
        float touchSlop2;
        int i4;
        AwaitPointerEventScope $this$awaitEachGesture;
        Object $result2;
        Object awaitPointerEvent$default;
        AwaitPointerEventScope $this$awaitEachGesture2;
        int i5;
        float touchSlop3;
        int i6;
        Object obj2;
        float rotation3;
        int index$iv$iv;
        boolean canceled;
        AwaitPointerEventScope $this$awaitEachGesture3;
        int $i$f$fastAny;
        int i7;
        int i8;
        int i9;
        Iterable $this$count$iv;
        boolean lockedToPanZoom;
        int count$iv;
        int size;
        int $i$f$fastForEach;
        int i10;
        AwaitPointerEventScope $this$awaitEachGesture4 = (AwaitPointerEventScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = 1;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                rotation = 0.0f;
                long pan3 = Offset.Companion.getZero-F1C5BW0();
                float touchSlop4 = $this$awaitEachGesture4.getViewConfiguration().getTouchSlop();
                this.L$0 = $this$awaitEachGesture4;
                this.F$0 = 0.0f;
                this.F$1 = 1.0f;
                this.J$0 = pan3;
                this.I$0 = 0;
                this.F$2 = touchSlop4;
                this.I$1 = 0;
                this.label = 1;
                if (TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture4, false, (PointerEventPass) null, (Continuation) this, 2, (Object) null) != coroutine_suspended) {
                    zoom = 1.0f;
                    pan = pan3;
                    i = 0;
                    touchSlop = touchSlop4;
                    i2 = 0;
                    detectTransformGesturesKt$detectTransformGestures$2 = this;
                    rotation2 = rotation;
                    obj = coroutine_suspended;
                    zoom2 = zoom;
                    pan2 = pan;
                    i3 = i;
                    touchSlop2 = touchSlop;
                    i4 = i2;
                    $this$awaitEachGesture = $this$awaitEachGesture4;
                    $result2 = $result;
                    detectTransformGesturesKt$detectTransformGestures$2.L$0 = $this$awaitEachGesture;
                    detectTransformGesturesKt$detectTransformGestures$2.F$0 = rotation2;
                    detectTransformGesturesKt$detectTransformGestures$2.F$1 = zoom2;
                    detectTransformGesturesKt$detectTransformGestures$2.J$0 = pan2;
                    detectTransformGesturesKt$detectTransformGestures$2.I$0 = i3;
                    detectTransformGesturesKt$detectTransformGestures$2.F$2 = touchSlop2;
                    detectTransformGesturesKt$detectTransformGestures$2.I$1 = i4;
                    detectTransformGesturesKt$detectTransformGestures$2.label = 2;
                    awaitPointerEvent$default = AwaitPointerEventScope.-CC.awaitPointerEvent$default($this$awaitEachGesture, (PointerEventPass) null, (Continuation) detectTransformGesturesKt$detectTransformGestures$2, i11, (Object) null);
                    if (awaitPointerEvent$default != obj) {
                        int i12 = i4;
                        $this$awaitEachGesture2 = $this$awaitEachGesture;
                        i5 = i12;
                        int i13 = i3;
                        touchSlop3 = touchSlop2;
                        i6 = i13;
                        float f = rotation2;
                        obj2 = obj;
                        rotation3 = f;
                        break;
                    } else {
                        return obj;
                    }
                } else {
                    return coroutine_suspended;
                }
            case 1:
                i2 = this.I$1;
                touchSlop = this.F$2;
                i = this.I$0;
                pan = this.J$0;
                zoom = this.F$1;
                rotation = this.F$0;
                ResultKt.throwOnFailure($result);
                detectTransformGesturesKt$detectTransformGestures$2 = this;
                rotation2 = rotation;
                obj = coroutine_suspended;
                zoom2 = zoom;
                pan2 = pan;
                i3 = i;
                touchSlop2 = touchSlop;
                i4 = i2;
                $this$awaitEachGesture = $this$awaitEachGesture4;
                $result2 = $result;
                detectTransformGesturesKt$detectTransformGestures$2.L$0 = $this$awaitEachGesture;
                detectTransformGesturesKt$detectTransformGestures$2.F$0 = rotation2;
                detectTransformGesturesKt$detectTransformGestures$2.F$1 = zoom2;
                detectTransformGesturesKt$detectTransformGestures$2.J$0 = pan2;
                detectTransformGesturesKt$detectTransformGestures$2.I$0 = i3;
                detectTransformGesturesKt$detectTransformGestures$2.F$2 = touchSlop2;
                detectTransformGesturesKt$detectTransformGestures$2.I$1 = i4;
                detectTransformGesturesKt$detectTransformGestures$2.label = 2;
                awaitPointerEvent$default = AwaitPointerEventScope.-CC.awaitPointerEvent$default($this$awaitEachGesture, (PointerEventPass) null, (Continuation) detectTransformGesturesKt$detectTransformGestures$2, i11, (Object) null);
                if (awaitPointerEvent$default != obj) {
                }
                break;
            case 2:
                i5 = this.I$1;
                float touchSlop5 = this.F$2;
                i6 = this.I$0;
                long pan4 = this.J$0;
                float zoom3 = this.F$1;
                rotation3 = this.F$0;
                ResultKt.throwOnFailure($result);
                awaitPointerEvent$default = $result;
                detectTransformGesturesKt$detectTransformGestures$2 = this;
                obj2 = coroutine_suspended;
                zoom2 = zoom3;
                pan2 = pan4;
                touchSlop3 = touchSlop5;
                $this$awaitEachGesture2 = $this$awaitEachGesture4;
                $result2 = awaitPointerEvent$default;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PointerEvent event = (PointerEvent) awaitPointerEvent$default;
        List $this$fastAny$iv = event.getChanges();
        int size2 = $this$fastAny$iv.size();
        Object $result3 = $result2;
        int index$iv$iv2 = 0;
        while (true) {
            index$iv$iv = i5;
            if (index$iv$iv2 < size2) {
                Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv2);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.isConsumed()) {
                    canceled = true;
                } else {
                    index$iv$iv2++;
                    i5 = index$iv$iv;
                }
            } else {
                canceled = false;
            }
        }
        if (canceled) {
            $this$awaitEachGesture3 = $this$awaitEachGesture2;
            i4 = index$iv$iv;
        } else {
            float zoomChange = TransformGestureDetectorKt.calculateZoom(event);
            float rotationChange = TransformGestureDetectorKt.calculateRotation(event);
            long panChange = TransformGestureDetectorKt.calculatePan(event);
            if (i6 == 0) {
                zoom2 *= zoomChange;
                rotation3 += rotationChange;
                pan2 = Offset.plus-MK-Hz9U(pan2, panChange);
                float centroidSize = TransformGestureDetectorKt.calculateCentroidSize(event, false);
                $this$awaitEachGesture3 = $this$awaitEachGesture2;
                float zoomMotion = Math.abs(1 - zoom2) * centroidSize;
                float rotationMotion = Math.abs(((3.1415927f * rotation3) * centroidSize) / 180.0f);
                float panMotion = Offset.getDistance-impl(pan2);
                if (zoomMotion > touchSlop3 || rotationMotion > touchSlop3 || panMotion > touchSlop3) {
                    i6 = 1;
                    i10 = (!detectTransformGesturesKt$detectTransformGestures$2.$panZoomLock || rotationMotion >= touchSlop3) ? 0 : 1;
                } else {
                    i10 = index$iv$iv;
                }
                int i14 = i10;
                List $this$fastForEach$iv = event.getChanges();
                int size3 = $this$fastForEach$iv.size();
                int i15 = i6;
                for (int index$iv = 0; index$iv < size3; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    PointerInputChange it2 = (PointerInputChange) item$iv;
                    if (PointerEventKt.positionChanged(it2)) {
                        it2.consume();
                    }
                }
                i7 = i14;
                i6 = i15;
            } else {
                $this$awaitEachGesture3 = $this$awaitEachGesture2;
                i7 = index$iv$iv;
            }
            if (i6 != 0) {
                long centroid = TransformGestureDetectorKt.calculateCentroid(event, false);
                float effectiveRotation = i7 != 0 ? 0.0f : rotationChange;
                if (effectiveRotation == 0.0f) {
                    if (zoomChange == 1.0f) {
                        i9 = i6;
                        if (Offset.equals-impl0(panChange, Offset.Companion.getZero-F1C5BW0())) {
                            i8 = i7;
                        }
                        Function5<Integer, Offset, Offset, Float, Float, Boolean> function5 = detectTransformGesturesKt$detectTransformGestures$2.$onGesture;
                        $this$count$iv = event.getChanges();
                        i8 = i7;
                        lockedToPanZoom = $this$count$iv instanceof Collection;
                        if (lockedToPanZoom || !((Collection) $this$count$iv).isEmpty()) {
                            count$iv = 0;
                            for (Object element$iv : $this$count$iv) {
                                PointerInputChange it3 = (PointerInputChange) element$iv;
                                if (it3.getPressed() && (count$iv = count$iv + 1) < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                        } else {
                            count$iv = 0;
                        }
                        boolean shouldConsume = ((Boolean) function5.invoke(Boxing.boxInt(count$iv), Offset.box-impl(centroid), Offset.box-impl(panChange), Boxing.boxFloat(zoomChange), Boxing.boxFloat(effectiveRotation))).booleanValue();
                        List $this$fastForEach$iv2 = event.getChanges();
                        size = $this$fastForEach$iv2.size();
                        for ($i$f$fastForEach = 0; $i$f$fastForEach < size; $i$f$fastForEach++) {
                            Object item$iv2 = $this$fastForEach$iv2.get($i$f$fastForEach);
                            PointerInputChange it4 = (PointerInputChange) item$iv2;
                            if (PointerEventKt.positionChanged(it4) && shouldConsume) {
                                it4.consume();
                            }
                        }
                    }
                }
                i9 = i6;
                Function5<Integer, Offset, Offset, Float, Float, Boolean> function52 = detectTransformGesturesKt$detectTransformGestures$2.$onGesture;
                $this$count$iv = event.getChanges();
                i8 = i7;
                lockedToPanZoom = $this$count$iv instanceof Collection;
                if (lockedToPanZoom) {
                }
                count$iv = 0;
                while (r24.hasNext()) {
                }
                boolean shouldConsume2 = ((Boolean) function52.invoke(Boxing.boxInt(count$iv), Offset.box-impl(centroid), Offset.box-impl(panChange), Boxing.boxFloat(zoomChange), Boxing.boxFloat(effectiveRotation))).booleanValue();
                List $this$fastForEach$iv22 = event.getChanges();
                size = $this$fastForEach$iv22.size();
                while ($i$f$fastForEach < size) {
                }
            } else {
                i8 = i7;
                i9 = i6;
            }
            i6 = i9;
            i4 = i8;
        }
        if (!canceled) {
            List $this$fastAny$iv2 = event.getChanges();
            int index$iv$iv3 = 0;
            int size4 = $this$fastAny$iv2.size();
            while (true) {
                if (index$iv$iv3 < size4) {
                    Object item$iv$iv2 = $this$fastAny$iv2.get(index$iv$iv3);
                    PointerInputChange it5 = (PointerInputChange) item$iv$iv2;
                    if (it5.getPressed()) {
                        $i$f$fastAny = 1;
                    } else {
                        index$iv$iv3++;
                    }
                } else {
                    $i$f$fastAny = 0;
                }
            }
            if ($i$f$fastAny != 0) {
                $result2 = $result3;
                $this$awaitEachGesture = $this$awaitEachGesture3;
                i11 = 1;
                float f2 = touchSlop3;
                i3 = i6;
                touchSlop2 = f2;
                Object obj3 = obj2;
                rotation2 = rotation3;
                obj = obj3;
                detectTransformGesturesKt$detectTransformGestures$2.L$0 = $this$awaitEachGesture;
                detectTransformGesturesKt$detectTransformGestures$2.F$0 = rotation2;
                detectTransformGesturesKt$detectTransformGestures$2.F$1 = zoom2;
                detectTransformGesturesKt$detectTransformGestures$2.J$0 = pan2;
                detectTransformGesturesKt$detectTransformGestures$2.I$0 = i3;
                detectTransformGesturesKt$detectTransformGestures$2.F$2 = touchSlop2;
                detectTransformGesturesKt$detectTransformGestures$2.I$1 = i4;
                detectTransformGesturesKt$detectTransformGestures$2.label = 2;
                awaitPointerEvent$default = AwaitPointerEventScope.-CC.awaitPointerEvent$default($this$awaitEachGesture, (PointerEventPass) null, (Continuation) detectTransformGesturesKt$detectTransformGestures$2, i11, (Object) null);
                if (awaitPointerEvent$default != obj) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}