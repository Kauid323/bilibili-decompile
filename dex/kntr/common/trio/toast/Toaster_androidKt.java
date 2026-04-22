package kntr.common.trio.toast;

import android.content.Context;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Toaster.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"provideToaster", "Lkntr/common/trio/toast/Toaster;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "androidDuration", "", "Lkntr/common/trio/toast/ToastDuration;", "getAndroidDuration", "(Lkntr/common/trio/toast/ToastDuration;)I", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Toaster_androidKt {

    /* compiled from: Toaster.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToastDuration.values().length];
            try {
                iArr[ToastDuration.Long.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToastDuration.Short.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ int access$getAndroidDuration(ToastDuration $receiver) {
        return getAndroidDuration($receiver);
    }

    public static final Toaster provideToaster(CompositionLocalAccessorScope $this$provideToaster) {
        Intrinsics.checkNotNullParameter($this$provideToaster, "<this>");
        Context context = (Context) $this$provideToaster.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext());
        return new AndroidToaster(context);
    }

    public static final int getAndroidDuration(ToastDuration $this$androidDuration) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$androidDuration.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}