package kntr.common.photonic.aphro.ui;

import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: MediaSelectFloat.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"kntr/common/photonic/aphro/ui/MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1 implements NestedScrollConnection {
    final /* synthetic */ AnchoredDraggableState<CollapseStatus> $draggableState;
    final /* synthetic */ MutableState<Boolean> $floatDrag$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1(AnchoredDraggableState<CollapseStatus> anchoredDraggableState, MutableState<Boolean> mutableState) {
        this.$draggableState = anchoredDraggableState;
        this.$floatDrag$delegate = mutableState;
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2246onPostScrollDzOQY0M(long j, long j2, int i) {
        boolean MediaSelectFloat_ZUYZQmM$lambda$2;
        boolean MediaSelectFloat_ZUYZQmM$lambda$22;
        int bits$iv$iv$iv = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(bits$iv$iv$iv) == 0.0f) {
            MediaSelectFloat_ZUYZQmM$lambda$22 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$2(this.$floatDrag$delegate);
            if (!MediaSelectFloat_ZUYZQmM$lambda$22) {
                int bits$iv$iv$iv2 = (int) (j2 & 4294967295L);
                if (Float.intBitsToFloat(bits$iv$iv$iv2) > 0.0f) {
                    MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$3(this.$floatDrag$delegate, true);
                    int bits$iv$iv$iv3 = (int) (j2 & 4294967295L);
                    this.$draggableState.dispatchRawDelta(Float.intBitsToFloat(bits$iv$iv$iv3));
                    int bits$iv$iv$iv4 = (int) (j2 & 4294967295L);
                    float y$iv = Float.intBitsToFloat(bits$iv$iv$iv4);
                    long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                    long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                    return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                }
                return NestedScrollConnection.-CC.$default$onPostScroll-DzOQY0M(this, j, j2, i);
            }
        }
        MediaSelectFloat_ZUYZQmM$lambda$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$2(this.$floatDrag$delegate);
        if (!MediaSelectFloat_ZUYZQmM$lambda$2) {
            return NestedScrollConnection.-CC.$default$onPostScroll-DzOQY0M(this, j, j2, i);
        }
        int bits$iv$iv$iv5 = (int) (j2 & 4294967295L);
        this.$draggableState.dispatchRawDelta(Float.intBitsToFloat(bits$iv$iv$iv5));
        int bits$iv$iv$iv6 = (int) (j2 & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv6);
        long v1$iv$iv2 = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        return Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m2247onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1 mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1;
        boolean MediaSelectFloat_ZUYZQmM$lambda$2;
        if (continuation instanceof MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1) {
            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1 = (MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1) continuation;
            if ((mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.label -= Integer.MIN_VALUE;
                Object $result = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MediaSelectFloat_ZUYZQmM$lambda$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$2(this.$floatDrag$delegate);
                        if (MediaSelectFloat_ZUYZQmM$lambda$2) {
                            AnchoredDraggableState<CollapseStatus> anchoredDraggableState = this.$draggableState;
                            float f = Velocity.getY-impl(j);
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.J$0 = j;
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.label = 1;
                            if (anchoredDraggableState.settle(f, mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.J$0 = j;
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.label = 2;
                            Object obj = NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j, mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj;
                        }
                        break;
                    case 1:
                        j = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        long j2 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Velocity.box-impl(j);
            }
        }
        mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1 = new MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1(this, continuation);
        Object $result2 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPreFling$1.label) {
        }
        return Velocity.box-impl(j);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2248onPreScrollOzD1aCk(long j, int i) {
        boolean MediaSelectFloat_ZUYZQmM$lambda$2;
        MediaSelectFloat_ZUYZQmM$lambda$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$2(this.$floatDrag$delegate);
        if (!MediaSelectFloat_ZUYZQmM$lambda$2) {
            return NestedScrollConnection.-CC.$default$onPreScroll-OzD1aCk(this, j, i);
        }
        int bits$iv$iv$iv = (int) (4294967295L & j);
        this.$draggableState.dispatchRawDelta(Float.intBitsToFloat(bits$iv$iv$iv));
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m2245onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1 mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1;
        boolean MediaSelectFloat_ZUYZQmM$lambda$2;
        boolean MediaSelectFloat_ZUYZQmM$lambda$22;
        if (continuation instanceof MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1) {
            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1 = (MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1) continuation;
            if ((mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label -= Integer.MIN_VALUE;
                Object $result = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (Velocity.getY-impl(j) == 0.0f) {
                            MediaSelectFloat_ZUYZQmM$lambda$22 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$2(this.$floatDrag$delegate);
                            if (!MediaSelectFloat_ZUYZQmM$lambda$22) {
                                if (Velocity.getY-impl(j2) <= 0.0f) {
                                    mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0 = j;
                                    mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1 = j2;
                                    mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label = 2;
                                    Object obj = NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j, j2, mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1);
                                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                                }
                                MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$3(this.$floatDrag$delegate, true);
                                AnchoredDraggableState<CollapseStatus> anchoredDraggableState = this.$draggableState;
                                float f = Velocity.getY-impl(j2);
                                mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0 = j;
                                mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1 = j2;
                                mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label = 1;
                                if (anchoredDraggableState.settle(f, mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Velocity.box-impl(j2);
                            }
                        }
                        MediaSelectFloat_ZUYZQmM$lambda$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$2(this.$floatDrag$delegate);
                        if (!MediaSelectFloat_ZUYZQmM$lambda$2) {
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0 = j;
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1 = j2;
                            mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label = 4;
                            Object obj2 = NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j, j2, mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1);
                            return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
                        }
                        AnchoredDraggableState<CollapseStatus> anchoredDraggableState2 = this.$draggableState;
                        float f2 = Velocity.getY-impl(j2);
                        mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0 = j;
                        mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1 = j2;
                        mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label = 3;
                        if (anchoredDraggableState2.settle(f2, mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Velocity.box-impl(j2);
                    case 1:
                        j2 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1;
                        long j3 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        return Velocity.box-impl(j2);
                    case 2:
                        long j4 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1;
                        long j5 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 3:
                        j2 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1;
                        long j6 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        return Velocity.box-impl(j2);
                    case 4:
                        long j7 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$1;
                        long j8 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1 = new MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1(this, continuation);
        Object $result2 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1.label) {
        }
    }
}