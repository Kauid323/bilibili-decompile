package kntr.app.deepsearch.ui;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearch.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchKt$DeepSearchPage$5$3$3$1$1$1 implements PointerInputEventHandler {
    final /* synthetic */ SoftwareKeyboardController $soft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchKt$DeepSearchPage$5$3$3$1$1$1(SoftwareKeyboardController softwareKeyboardController) {
        this.$soft = softwareKeyboardController;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1 deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1;
        Function2 function2;
        if (continuation instanceof DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1) {
            deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1 = (DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1) continuation;
            if ((deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label -= Integer.MIN_VALUE;
                Object $result = deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.L$0 = $this$pointerInput;
                        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1) null, (Function1) null, new AnonymousClass1(this.$soft, null), (Function1) null, deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1, 11, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final SoftwareKeyboardController softwareKeyboardController = this.$soft;
                        function2 = new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2) {
                                Unit invoke$lambda$0;
                                invoke$lambda$0 = DeepSearchKt$DeepSearchPage$5$3$3$1$1$1.invoke$lambda$0(softwareKeyboardController, (PointerInputChange) obj, (Offset) obj2);
                                return invoke$lambda$0;
                            }
                        };
                        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.L$0 = SpillingKt.nullOutSpilledVariable($this$pointerInput);
                        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label = 2;
                        if (DragGestureDetectorKt.detectDragGestures$default($this$pointerInput, (Function1) null, (Function0) null, (Function0) null, function2, deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1, 7, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $this$pointerInput = (PointerInputScope) deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.L$0;
                        ResultKt.throwOnFailure($result);
                        final SoftwareKeyboardController softwareKeyboardController2 = this.$soft;
                        function2 = new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2) {
                                Unit invoke$lambda$0;
                                invoke$lambda$0 = DeepSearchKt$DeepSearchPage$5$3$3$1$1$1.invoke$lambda$0(softwareKeyboardController2, (PointerInputChange) obj, (Offset) obj2);
                                return invoke$lambda$0;
                            }
                        };
                        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.L$0 = SpillingKt.nullOutSpilledVariable($this$pointerInput);
                        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label = 2;
                        if (DragGestureDetectorKt.detectDragGestures$default($this$pointerInput, (Function1) null, (Function0) null, (Function0) null, function2, deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1, 7, (Object) null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        PointerInputScope pointerInputScope = (PointerInputScope) deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1 = new DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1(this, continuation);
        Object $result2 = deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (deepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1.label) {
        }
    }

    /* compiled from: DeepSearch.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$1", f = "DeepSearch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ SoftwareKeyboardController $soft;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SoftwareKeyboardController softwareKeyboardController, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$soft = softwareKeyboardController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m677invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).unbox-impl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m677invoked4ec7I(PressGestureScope pressGestureScope, long j2, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(this.$soft, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SoftwareKeyboardController softwareKeyboardController = this.$soft;
                    if (softwareKeyboardController != null) {
                        softwareKeyboardController.hide();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(SoftwareKeyboardController $soft, PointerInputChange pointerInputChange, Offset offset) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        if ($soft != null) {
            $soft.hide();
        }
        return Unit.INSTANCE;
    }
}