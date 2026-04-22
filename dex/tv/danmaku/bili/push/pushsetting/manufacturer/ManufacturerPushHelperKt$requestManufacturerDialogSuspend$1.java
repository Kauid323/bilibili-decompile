package tv.danmaku.bili.push.pushsetting.manufacturer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManufacturerPushHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manufacturer.ManufacturerPushHelperKt", f = "ManufacturerPushHelper.kt", i = {0, 0, 0}, l = {BR.buttonText}, m = "requestManufacturerDialogSuspend", n = {"showFrom", FavoritesConstsKt.SPMID, "abMsg"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1(Continuation<? super ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ManufacturerPushHelperKt.requestManufacturerDialogSuspend(null, null, null, null, (Continuation) this);
    }
}