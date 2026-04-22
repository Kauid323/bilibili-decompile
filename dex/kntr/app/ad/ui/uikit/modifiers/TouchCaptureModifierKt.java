package kntr.app.ad.ui.uikit.modifiers;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: TouchCaptureModifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a\u001e\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¨\u0006\n"}, d2 = {"touchCapture", "Landroidx/compose/ui/Modifier;", "coordinateSystem", "Lkntr/app/ad/ui/uikit/modifiers/CoordinateSystem;", "onTouchCapture", "Lkotlin/Function1;", "Lkntr/app/ad/ui/uikit/modifiers/TouchCapture;", RoomRecommendViewModel.EMPTY_CURSOR, "touchCaptureRelative", "touchCaptureAbsolute", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TouchCaptureModifierKt {
    public static /* synthetic */ Modifier touchCapture$default(Modifier modifier, CoordinateSystem coordinateSystem, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coordinateSystem = CoordinateSystem.RELATIVE;
        }
        return touchCapture(modifier, coordinateSystem, function1);
    }

    public static final Modifier touchCapture(Modifier $this$touchCapture, final CoordinateSystem coordinateSystem, final Function1<? super TouchCapture, Unit> function1) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$touchCapture, "<this>");
        Intrinsics.checkNotNullParameter(coordinateSystem, "coordinateSystem");
        Intrinsics.checkNotNullParameter(function1, "onTouchCapture");
        final Ref.LongRef screenOffset = new Ref.LongRef();
        screenOffset.element = IntOffset.Companion.getZero-nOcc-ac();
        final Ref.LongRef currentSize = new Ref.LongRef();
        currentSize.element = IntSize.Companion.getZero-YbymL2g();
        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged($this$touchCapture, new Function1() { // from class: kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit unit;
                unit = TouchCaptureModifierKt.touchCapture$lambda$0(currentSize, (IntSize) obj);
                return unit;
            }
        });
        if (coordinateSystem == CoordinateSystem.ABSOLUTE) {
            modifier = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new Function1() { // from class: kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit unit;
                    unit = TouchCaptureModifierKt.touchCapture$lambda$1(screenOffset, (LayoutCoordinates) obj);
                    return unit;
                }
            });
        } else {
            modifier = Modifier.Companion;
        }
        return SuspendingPointerInputFilterKt.pointerInput(onSizeChanged.then(modifier), coordinateSystem, new PointerInputEventHandler() { // from class: kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt$touchCapture$3

            /* compiled from: TouchCaptureModifier.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt$touchCapture$3$1", f = "TouchCaptureModifier.kt", i = {0, 1, 1, 1, 1, 1}, l = {72, 88}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "downEvent", "upEvent", "downX", "downY"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
            /* renamed from: kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt$touchCapture$3$1  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoordinateSystem $coordinateSystem;
                final /* synthetic */ Ref.LongRef $currentSize;
                final /* synthetic */ Function1<TouchCapture, Unit> $onTouchCapture;
                final /* synthetic */ Ref.LongRef $screenOffset;
                int I$0;
                int I$1;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* compiled from: TouchCaptureModifier.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt$touchCapture$3$1$WhenMappings */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[CoordinateSystem.values().length];
                        try {
                            iArr[CoordinateSystem.RELATIVE.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[CoordinateSystem.ABSOLUTE.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(CoordinateSystem coordinateSystem, Ref.LongRef longRef, Ref.LongRef longRef2, Function1<? super TouchCapture, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$coordinateSystem = coordinateSystem;
                    this.$screenOffset = longRef;
                    this.$currentSize = longRef2;
                    this.$onTouchCapture = function1;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$coordinateSystem, this.$screenOffset, this.$currentSize, this.$onTouchCapture, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x005f A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x00c1  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0133 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0134  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x014a  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0244  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0134 -> B:23:0x0137). Please submit an issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object $result) {
                    AnonymousClass1 anonymousClass1;
                    Object obj;
                    AwaitPointerEventScope $this$awaitPointerEventScope;
                    Object $result2;
                    Object obj2;
                    int downY;
                    Object awaitPointerEvent;
                    PointerInputChange downEvent;
                    AnonymousClass1 anonymousClass12;
                    int downX;
                    PointerInputChange downEvent2;
                    Pair pair;
                    PointerInputChange upEvent;
                    Object $result3;
                    AwaitPointerEventScope $this$awaitPointerEventScope2;
                    Object obj3;
                    Pair pair2;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    char c = ' ';
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            obj = coroutine_suspended;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                            $result2 = $result;
                            anonymousClass1.L$0 = $this$awaitPointerEventScope;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.label = 1;
                            obj2 = TapGestureDetectorKt.awaitFirstDown$default($this$awaitPointerEventScope, false, PointerEventPass.Initial, (Continuation) anonymousClass1, 1, (Object) null);
                            if (obj2 == obj) {
                                return obj;
                            }
                            PointerInputChange downEvent3 = (PointerInputChange) obj2;
                            switch (WhenMappings.$EnumSwitchMapping$0[anonymousClass1.$coordinateSystem.ordinal()]) {
                                case 1:
                                    downEvent2 = downEvent3;
                                    int bits$iv$iv$iv = (int) (downEvent2.getPosition-F1C5BW0() >> 32);
                                    Integer boxInt = Boxing.boxInt((int) Float.intBitsToFloat(bits$iv$iv$iv));
                                    int bits$iv$iv$iv2 = (int) (downEvent2.getPosition-F1C5BW0() & 4294967295L);
                                    pair = TuplesKt.to(boxInt, Boxing.boxInt((int) Float.intBitsToFloat(bits$iv$iv$iv2)));
                                    break;
                                case 2:
                                    int bits$iv$iv$iv3 = (int) (downEvent3.getPosition-F1C5BW0() >> c);
                                    Integer boxInt2 = Boxing.boxInt((int) (IntOffset.getX-impl(anonymousClass1.$screenOffset.element) + Float.intBitsToFloat(bits$iv$iv$iv3)));
                                    downEvent2 = downEvent3;
                                    int bits$iv$iv$iv4 = (int) (downEvent3.getPosition-F1C5BW0() & 4294967295L);
                                    pair = TuplesKt.to(boxInt2, Boxing.boxInt((int) (IntOffset.getY-impl(anonymousClass1.$screenOffset.element) + Float.intBitsToFloat(bits$iv$iv$iv4))));
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                            int downX2 = ((Number) pair.component1()).intValue();
                            downY = ((Number) pair.component2()).intValue();
                            PointerInputChange downEvent4 = downEvent2;
                            int downX3 = downX2;
                            PointerInputChange upEvent2 = null;
                            anonymousClass1.L$0 = $this$awaitPointerEventScope;
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(downEvent4);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(upEvent2);
                            anonymousClass1.I$0 = downX3;
                            anonymousClass1.I$1 = downY;
                            anonymousClass1.label = 2;
                            awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) anonymousClass1);
                            if (awaitPointerEvent != obj) {
                                return obj;
                            }
                            downEvent = downEvent4;
                            anonymousClass12 = anonymousClass1;
                            downX = downX3;
                            PointerEvent event = (PointerEvent) awaitPointerEvent;
                            upEvent = (PointerInputChange) CollectionsKt.first(event.getChanges());
                            if (upEvent.getPressed()) {
                                switch (WhenMappings.$EnumSwitchMapping$0[anonymousClass12.$coordinateSystem.ordinal()]) {
                                    case 1:
                                        $result3 = $result2;
                                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                                        obj3 = obj;
                                        int bits$iv$iv$iv5 = (int) (upEvent.getPosition-F1C5BW0() >> 32);
                                        Integer boxInt3 = Boxing.boxInt((int) Float.intBitsToFloat(bits$iv$iv$iv5));
                                        int bits$iv$iv$iv6 = (int) (upEvent.getPosition-F1C5BW0() & 4294967295L);
                                        pair2 = TuplesKt.to(boxInt3, Boxing.boxInt((int) Float.intBitsToFloat(bits$iv$iv$iv6)));
                                        break;
                                    case 2:
                                        $result3 = $result2;
                                        int bits$iv$iv$iv7 = (int) (upEvent.getPosition-F1C5BW0() >> 32);
                                        Integer boxInt4 = Boxing.boxInt((int) (IntOffset.getX-impl(anonymousClass12.$screenOffset.element) + Float.intBitsToFloat(bits$iv$iv$iv7)));
                                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                                        obj3 = obj;
                                        int bits$iv$iv$iv8 = (int) (upEvent.getPosition-F1C5BW0() & 4294967295L);
                                        pair2 = TuplesKt.to(boxInt4, Boxing.boxInt((int) (IntOffset.getY-impl(anonymousClass12.$screenOffset.element) + Float.intBitsToFloat(bits$iv$iv$iv8))));
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                                int upX = ((Number) pair2.component1()).intValue();
                                int upY = ((Number) pair2.component2()).intValue();
                                TouchCapture touchCapture = new TouchCapture((int) (anonymousClass12.$currentSize.element >> 32), (int) (anonymousClass12.$currentSize.element & 4294967295L), downX, downY, upX, upY);
                                anonymousClass12.$onTouchCapture.invoke(touchCapture);
                                $result2 = $result3;
                                anonymousClass1 = anonymousClass12;
                                c = ' ';
                                $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                                obj = obj3;
                                anonymousClass1.L$0 = $this$awaitPointerEventScope;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.label = 1;
                                obj2 = TapGestureDetectorKt.awaitFirstDown$default($this$awaitPointerEventScope, false, PointerEventPass.Initial, (Continuation) anonymousClass1, 1, (Object) null);
                                if (obj2 == obj) {
                                }
                                PointerInputChange downEvent32 = (PointerInputChange) obj2;
                                switch (WhenMappings.$EnumSwitchMapping$0[anonymousClass1.$coordinateSystem.ordinal()]) {
                                }
                                int downX22 = ((Number) pair.component1()).intValue();
                                downY = ((Number) pair.component2()).intValue();
                                PointerInputChange downEvent42 = downEvent2;
                                int downX32 = downX22;
                                PointerInputChange upEvent22 = null;
                                anonymousClass1.L$0 = $this$awaitPointerEventScope;
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(downEvent42);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(upEvent22);
                                anonymousClass1.I$0 = downX32;
                                anonymousClass1.I$1 = downY;
                                anonymousClass1.label = 2;
                                awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) anonymousClass1);
                                if (awaitPointerEvent != obj) {
                                }
                            } else {
                                downX32 = downX;
                                downEvent42 = downEvent;
                                anonymousClass1 = anonymousClass12;
                                upEvent22 = upEvent;
                                anonymousClass1.L$0 = $this$awaitPointerEventScope;
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(downEvent42);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(upEvent22);
                                anonymousClass1.I$0 = downX32;
                                anonymousClass1.I$1 = downY;
                                anonymousClass1.label = 2;
                                awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) anonymousClass1);
                                if (awaitPointerEvent != obj) {
                                }
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            obj2 = $result;
                            anonymousClass1 = this;
                            obj = coroutine_suspended;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                            $result2 = obj2;
                            PointerInputChange downEvent322 = (PointerInputChange) obj2;
                            switch (WhenMappings.$EnumSwitchMapping$0[anonymousClass1.$coordinateSystem.ordinal()]) {
                            }
                            int downX222 = ((Number) pair.component1()).intValue();
                            downY = ((Number) pair.component2()).intValue();
                            PointerInputChange downEvent422 = downEvent2;
                            int downX322 = downX222;
                            PointerInputChange upEvent222 = null;
                            anonymousClass1.L$0 = $this$awaitPointerEventScope;
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(downEvent422);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(upEvent222);
                            anonymousClass1.I$0 = downX322;
                            anonymousClass1.I$1 = downY;
                            anonymousClass1.label = 2;
                            awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) anonymousClass1);
                            if (awaitPointerEvent != obj) {
                            }
                            break;
                        case 2:
                            int downY2 = this.I$1;
                            int downX4 = this.I$0;
                            PointerInputChange pointerInputChange = (PointerInputChange) this.L$2;
                            ResultKt.throwOnFailure($result);
                            awaitPointerEvent = $result;
                            anonymousClass12 = this;
                            downY = downY2;
                            downX = downX4;
                            downEvent = (PointerInputChange) this.L$1;
                            obj = coroutine_suspended;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                            $result2 = awaitPointerEvent;
                            PointerEvent event2 = (PointerEvent) awaitPointerEvent;
                            upEvent = (PointerInputChange) CollectionsKt.first(event2.getChanges());
                            if (upEvent.getPressed()) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                Object awaitPointerEventScope = $this$pointerInput.awaitPointerEventScope(new AnonymousClass1(CoordinateSystem.this, screenOffset, currentSize, function1, null), continuation);
                return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchCapture$lambda$0(Ref.LongRef $currentSize, IntSize size) {
        $currentSize.element = size.unbox-impl();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchCapture$lambda$1(Ref.LongRef $screenOffset, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        long position = LayoutCoordinatesKt.positionOnScreen(coordinates);
        int bits$iv$iv$iv = (int) (position >> 32);
        int x$iv = (int) Float.intBitsToFloat(bits$iv$iv$iv);
        int bits$iv$iv$iv2 = (int) (position & 4294967295L);
        int y$iv = (int) Float.intBitsToFloat(bits$iv$iv$iv2);
        $screenOffset.element = IntOffset.constructor-impl((x$iv << 32) | (4294967295L & y$iv));
        return Unit.INSTANCE;
    }

    public static final Modifier touchCaptureRelative(Modifier $this$touchCaptureRelative, Function1<? super TouchCapture, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$touchCaptureRelative, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onTouchCapture");
        return touchCapture($this$touchCaptureRelative, CoordinateSystem.RELATIVE, function1);
    }

    public static final Modifier touchCaptureAbsolute(Modifier $this$touchCaptureAbsolute, Function1<? super TouchCapture, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$touchCaptureAbsolute, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onTouchCapture");
        return touchCapture($this$touchCaptureAbsolute, CoordinateSystem.ABSOLUTE, function1);
    }
}