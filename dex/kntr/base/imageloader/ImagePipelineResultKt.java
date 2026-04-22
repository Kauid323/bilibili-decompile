package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePipelineResult.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aN\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012#\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"onSuccess", "Lkntr/base/imageloader/ImagePipelineResult;", "T", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "onSuccess-Vez0gFg", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onFailure", "", "exception", "onFailure-Vez0gFg", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePipelineResultKt {
    /* renamed from: onSuccess-Vez0gFg  reason: not valid java name */
    public static final <T> Object m1478onSuccessVez0gFg(Object obj, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (ImagePipelineResult.m1474isSuccessimpl(obj)) {
            function1.invoke(obj);
        }
        return obj;
    }

    /* renamed from: onFailure-Vez0gFg  reason: not valid java name */
    public static final <T> Object m1477onFailureVez0gFg(Object obj, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (ImagePipelineResult.m1473isFailureimpl(obj)) {
            function1.invoke(ImagePipelineResult.m1469exceptionOrNullimpl(obj));
        }
        return obj;
    }
}