package kntr.base.imageloader;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImagePainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$4$1", f = "BiliImagePainter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {106, 111}, m = "invokeSuspend", n = {"frameCount", "it", "$i$a$-repeat-BiliImagePainterKt$rememberBiliImagePainter$4$1$1", "index", "frameCount", "it", "$i$a$-repeat-BiliImagePainterKt$rememberBiliImagePainter$4$1$1", "index", "start", "nextImageFrame"}, s = {"I$0", "I$3", "I$4", "I$5", "I$0", "I$3", "I$4", "I$5", "J$0", "J$1"}, v = 1)
public final class BiliImagePainterKt$rememberBiliImagePainter$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Image $image;
    final /* synthetic */ BiliImageOptions $options;
    final /* synthetic */ AnimatablePainter $painter;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliImagePainterKt$rememberBiliImagePainter$4$1(Image image, BiliImageOptions biliImageOptions, AnimatablePainter animatablePainter, Continuation<? super BiliImagePainterKt$rememberBiliImagePainter$4$1> continuation) {
        super(2, continuation);
        this.$image = image;
        this.$options = biliImageOptions;
        this.$painter = animatablePainter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliImagePainterKt$rememberBiliImagePainter$4$1(this.$image, this.$options, this.$painter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0117  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00ac -> B:15:0x00b4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00f4 -> B:20:0x00f7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int frameCount;
        AnimatablePainter animatablePainter;
        Image image;
        int it;
        Object obj;
        int i;
        BiliImagePainterKt$rememberBiliImagePainter$4$1 biliImagePainterKt$rememberBiliImagePainter$4$1;
        int i2;
        Object obj2;
        int frameCount2;
        AnimatablePainter animatablePainter2;
        Image image2;
        int it2;
        int frameCount3;
        int index;
        int it3;
        BiliImagePainterKt$rememberBiliImagePainter$4$1 biliImagePainterKt$rememberBiliImagePainter$4$12;
        long start;
        long nextImageFrame;
        int frameCount4;
        int i3;
        int i4;
        int it4;
        int i5;
        int index2;
        AnimatablePainter animatablePainter3;
        Image image3;
        Object withFrameNanos;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int frameCount5 = ((AnimateImage) this.$image).getFrameCount();
                int m1436getAnimateLoopCountv08qk = this.$options.m1436getAnimateLoopCountv08qk();
                frameCount = frameCount5;
                animatablePainter = this.$painter;
                image = this.$image;
                it = 0;
                obj = coroutine_suspended;
                i = m1436getAnimateLoopCountv08qk;
                biliImagePainterKt$rememberBiliImagePainter$4$1 = this;
                break;
            case 1:
                int index3 = this.I$5;
                i2 = this.I$4;
                int it5 = this.I$3;
                int i6 = this.I$2;
                int i7 = this.I$1;
                int frameCount6 = this.I$0;
                ResultKt.throwOnFailure($result);
                obj2 = $result;
                frameCount2 = index3;
                animatablePainter2 = (AnimatablePainter) this.L$0;
                obj = coroutine_suspended;
                image2 = (Image) this.L$1;
                it2 = frameCount6;
                frameCount3 = i7;
                index = i6;
                it3 = it5;
                biliImagePainterKt$rememberBiliImagePainter$4$12 = this;
                start = ((Number) obj2).longValue();
                nextImageFrame = 0;
                if (frameCount2 < it2) {
                    animatablePainter2.setFrameIndex(frameCount2);
                    nextImageFrame += Duration.getInWholeNanoseconds-impl(((AnimateImage) image2).mo1409getFrameDuration5sfh64U(frameCount2));
                    Image image4 = image2;
                    i4 = index;
                    index2 = frameCount2;
                    frameCount4 = it2;
                    it4 = it3;
                    int i8 = frameCount3;
                    i5 = i2;
                    animatablePainter3 = animatablePainter2;
                    i3 = i8;
                    Function1 function1 = new Function1() { // from class: kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$4$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            long invokeSuspend$lambda$0$1;
                            invokeSuspend$lambda$0$1 = BiliImagePainterKt$rememberBiliImagePainter$4$1.invokeSuspend$lambda$0$1(((Long) obj3).longValue());
                            return Long.valueOf(invokeSuspend$lambda$0$1);
                        }
                    };
                    biliImagePainterKt$rememberBiliImagePainter$4$12.L$0 = animatablePainter3;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.L$1 = image4;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.I$0 = frameCount4;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.I$1 = i3;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.I$2 = i4;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.I$3 = it4;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.I$4 = i5;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.I$5 = index2;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.J$0 = start;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.J$1 = nextImageFrame;
                    image3 = image4;
                    biliImagePainterKt$rememberBiliImagePainter$4$12.label = 2;
                    withFrameNanos = MonotonicFrameClockKt.withFrameNanos(function1, biliImagePainterKt$rememberBiliImagePainter$4$12);
                    if (withFrameNanos == obj) {
                        return obj;
                    }
                    if (((Number) withFrameNanos).longValue() - start < nextImageFrame) {
                        image4 = image3;
                        Function1 function12 = new Function1() { // from class: kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$4$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj3) {
                                long invokeSuspend$lambda$0$1;
                                invokeSuspend$lambda$0$1 = BiliImagePainterKt$rememberBiliImagePainter$4$1.invokeSuspend$lambda$0$1(((Long) obj3).longValue());
                                return Long.valueOf(invokeSuspend$lambda$0$1);
                            }
                        };
                        biliImagePainterKt$rememberBiliImagePainter$4$12.L$0 = animatablePainter3;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.L$1 = image4;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.I$0 = frameCount4;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.I$1 = i3;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.I$2 = i4;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.I$3 = it4;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.I$4 = i5;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.I$5 = index2;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.J$0 = start;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.J$1 = nextImageFrame;
                        image3 = image4;
                        biliImagePainterKt$rememberBiliImagePainter$4$12.label = 2;
                        withFrameNanos = MonotonicFrameClockKt.withFrameNanos(function12, biliImagePainterKt$rememberBiliImagePainter$4$12);
                        if (withFrameNanos == obj) {
                        }
                        if (((Number) withFrameNanos).longValue() - start < nextImageFrame) {
                        }
                    } else {
                        int i9 = index2 + 1;
                        it3 = it4;
                        index = i4;
                        it2 = frameCount4;
                        image2 = image3;
                        frameCount2 = i9;
                        int i10 = i3;
                        animatablePainter2 = animatablePainter3;
                        i2 = i5;
                        frameCount3 = i10;
                        if (frameCount2 < it2) {
                            it = index + 1;
                            biliImagePainterKt$rememberBiliImagePainter$4$1 = biliImagePainterKt$rememberBiliImagePainter$4$12;
                            i = frameCount3;
                            frameCount = it2;
                            image = image2;
                            animatablePainter = animatablePainter2;
                            break;
                        }
                    }
                }
            case 2:
                long nextImageFrame2 = this.J$1;
                long start2 = this.J$0;
                index2 = this.I$5;
                i5 = this.I$4;
                it4 = this.I$3;
                i4 = this.I$2;
                i3 = this.I$1;
                frameCount4 = this.I$0;
                ResultKt.throwOnFailure($result);
                nextImageFrame = nextImageFrame2;
                image3 = (Image) this.L$1;
                animatablePainter3 = (AnimatablePainter) this.L$0;
                obj = coroutine_suspended;
                start = start2;
                biliImagePainterKt$rememberBiliImagePainter$4$12 = this;
                withFrameNanos = $result;
                if (((Number) withFrameNanos).longValue() - start < nextImageFrame) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (it < i) {
            int it6 = it;
            frameCount2 = 0;
            Function1 function13 = new Function1() { // from class: kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$4$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3) {
                    long invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = BiliImagePainterKt$rememberBiliImagePainter$4$1.invokeSuspend$lambda$0$0(((Long) obj3).longValue());
                    return Long.valueOf(invokeSuspend$lambda$0$0);
                }
            };
            biliImagePainterKt$rememberBiliImagePainter$4$1.L$0 = animatablePainter;
            biliImagePainterKt$rememberBiliImagePainter$4$1.L$1 = image;
            biliImagePainterKt$rememberBiliImagePainter$4$1.I$0 = frameCount;
            biliImagePainterKt$rememberBiliImagePainter$4$1.I$1 = i;
            biliImagePainterKt$rememberBiliImagePainter$4$1.I$2 = it;
            biliImagePainterKt$rememberBiliImagePainter$4$1.I$3 = it6;
            biliImagePainterKt$rememberBiliImagePainter$4$1.I$4 = 0;
            biliImagePainterKt$rememberBiliImagePainter$4$1.I$5 = 0;
            biliImagePainterKt$rememberBiliImagePainter$4$1.label = 1;
            obj2 = MonotonicFrameClockKt.withFrameNanos(function13, biliImagePainterKt$rememberBiliImagePainter$4$1);
            if (obj2 == obj) {
                return obj;
            }
            biliImagePainterKt$rememberBiliImagePainter$4$12 = biliImagePainterKt$rememberBiliImagePainter$4$1;
            i2 = 0;
            animatablePainter2 = animatablePainter;
            image2 = image;
            it2 = frameCount;
            frameCount3 = i;
            index = it;
            it3 = it6;
            start = ((Number) obj2).longValue();
            nextImageFrame = 0;
            if (frameCount2 < it2) {
            }
        } else {
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invokeSuspend$lambda$0$0(long it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invokeSuspend$lambda$0$1(long it) {
        return it;
    }
}