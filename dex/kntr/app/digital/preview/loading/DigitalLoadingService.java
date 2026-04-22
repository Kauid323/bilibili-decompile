package kntr.app.digital.preview.loading;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.DialogScope;
import kntr.app.digital.preview.DialogService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalLoadingService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/loading/DigitalLoadingService;", RoomRecommendViewModel.EMPTY_CURSOR, "dialogService", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Lkntr/app/digital/preview/DialogService;)V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "loadingDialogMessage", "getLoadingDialogMessage", "()Ljava/lang/String;", "setLoadingDialogMessage", "(Ljava/lang/String;)V", "loadingDialogMessage$delegate", "Landroidx/compose/runtime/MutableState;", "keepShowing", RoomRecommendViewModel.EMPTY_CURSOR, "msg", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalLoadingService {
    public static final int $stable = 0;
    private final DialogService dialogService;
    private final MutableState loadingDialogMessage$delegate;

    @Inject
    public DigitalLoadingService(DialogService dialogService) {
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        this.dialogService = dialogService;
        this.loadingDialogMessage$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final String getLoadingDialogMessage() {
        State $this$getValue$iv = this.loadingDialogMessage$delegate;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setLoadingDialogMessage(String str) {
        MutableState $this$setValue$iv = this.loadingDialogMessage$delegate;
        $this$setValue$iv.setValue(str);
    }

    public final Object keepShowing(final String msg, Continuation<? super Unit> continuation) {
        Object keepDialogShowing = this.dialogService.keepDialogShowing((Function3) ComposableLambdaKt.composableLambdaInstance(-888598500, true, new Function3() { // from class: kntr.app.digital.preview.loading.DigitalLoadingService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit keepShowing$lambda$0;
                keepShowing$lambda$0 = DigitalLoadingService.keepShowing$lambda$0(msg, (DialogScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return keepShowing$lambda$0;
            }
        }), continuation);
        return keepDialogShowing == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? keepDialogShowing : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepShowing$lambda$0(String $msg, DialogScope $this$keepDialogShowing, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$keepDialogShowing, "$this$keepDialogShowing");
        ComposerKt.sourceInformation($composer, "C19@606L43:DigitalLoadingService.kt#pbpmfu");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed($this$keepDialogShowing) : $composer.changedInstance($this$keepDialogShowing) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-888598500, $dirty, -1, "kntr.app.digital.preview.loading.DigitalLoadingService.keepShowing.<anonymous> (DigitalLoadingService.kt:19)");
            }
            DigitalLoadingDialogKt.DigitalLoadingDialog($msg, $this$keepDialogShowing.getOnDismissRequest(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}