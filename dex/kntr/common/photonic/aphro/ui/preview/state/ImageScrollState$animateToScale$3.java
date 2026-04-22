package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageScrollState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3", f = "ImageScrollState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImageScrollState$animateToScale$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ float $clampedScale;
    final /* synthetic */ float $newScrollX;
    final /* synthetic */ float $newScrollY;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImageScrollState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageScrollState$animateToScale$3(ImageScrollState imageScrollState, float f, float f2, float f3, Continuation<? super ImageScrollState$animateToScale$3> continuation) {
        super(2, continuation);
        this.this$0 = imageScrollState;
        this.$clampedScale = f;
        this.$newScrollX = f2;
        this.$newScrollY = f3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> imageScrollState$animateToScale$3 = new ImageScrollState$animateToScale$3(this.this$0, this.$clampedScale, this.$newScrollX, this.$newScrollY, continuation);
        imageScrollState$animateToScale$3.L$0 = obj;
        return imageScrollState$animateToScale$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageScrollState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3$1", f = "ImageScrollState.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $clampedScale;
        int label;
        final /* synthetic */ ImageScrollState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImageScrollState imageScrollState, float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = imageScrollState;
            this.$clampedScale = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$clampedScale, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Animatable animatable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    animatable = this.this$0._scale;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, Boxing.boxFloat(this.$clampedScale), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, this.$clampedScale, null), 3, (Object) null);
                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.this$0, this.$newScrollX, null), 3, (Object) null);
                return BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(this.this$0, this.$newScrollY, null), 3, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageScrollState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3$2", f = "ImageScrollState.kt", i = {0}, l = {153}, m = "invokeSuspend", n = {"maxX"}, s = {"I$0"}, v = 1)
    /* renamed from: kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $newScrollX;
        int I$0;
        int label;
        final /* synthetic */ ImageScrollState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageScrollState imageScrollState, float f, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = imageScrollState;
            this.$newScrollX = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$newScrollX, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    int maxX = this.this$0.getMaxScrollX();
                    this.I$0 = maxX;
                    this.label = 1;
                    if (this.this$0.getHorizontalScrollState().animateScrollTo(RangesKt.coerceAtMost((int) this.$newScrollX, maxX), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageScrollState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3$3", f = "ImageScrollState.kt", i = {0}, l = {157}, m = "invokeSuspend", n = {"maxY"}, s = {"I$0"}, v = 1)
    /* renamed from: kntr.common.photonic.aphro.ui.preview.state.ImageScrollState$animateToScale$3$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $newScrollY;
        int I$0;
        int label;
        final /* synthetic */ ImageScrollState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ImageScrollState imageScrollState, float f, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = imageScrollState;
            this.$newScrollY = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$newScrollY, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    int maxY = this.this$0.getMaxScrollY();
                    this.I$0 = maxY;
                    this.label = 1;
                    if (this.this$0.getVerticalScrollState().animateScrollTo(RangesKt.coerceAtMost((int) this.$newScrollY, maxY), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}