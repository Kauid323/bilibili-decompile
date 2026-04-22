package tv.danmaku.bili.ui.garb.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionImageColorHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper$getColorFromBitmap$2", f = "CollectionImageColorHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CollectionImageColorHelper$getColorFromBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ int $defaultColor;
    final /* synthetic */ Pair<Float, Float> $hsbConverter;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionImageColorHelper$getColorFromBitmap$2(int i, Bitmap bitmap, Pair<Float, Float> pair, Continuation<? super CollectionImageColorHelper$getColorFromBitmap$2> continuation) {
        super(2, continuation);
        this.$defaultColor = i;
        this.$bitmap = bitmap;
        this.$hsbConverter = pair;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionImageColorHelper$getColorFromBitmap$2(this.$defaultColor, this.$bitmap, this.$hsbConverter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        float[] resultColor;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                int color = this.$defaultColor;
                resultColor = CollectionImageColorHelper.INSTANCE.getHsbColorFromBitmap(this.$bitmap, true, new Rect(0, 0, this.$bitmap.getWidth(), this.$bitmap.getHeight()));
                if (resultColor != null) {
                    color = CollectionImageColorHelper.INSTANCE.hsbCovert(resultColor, this.$hsbConverter);
                }
                return Boxing.boxInt(color);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}