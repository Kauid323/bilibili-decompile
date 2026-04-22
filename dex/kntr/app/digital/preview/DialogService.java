package kntr.app.digital.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: DialogService.kt */
@PageScope
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\u00072\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\b¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0010R\u001f\u0010\u0004\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/DialogService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "state", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/runtime/Composable;", "keepDialogShowing", "block", "Lkotlin/Function1;", "Lkntr/app/digital/preview/DialogScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DialogService {
    public static final int $stable = 0;
    private final SnapshotStateList<Function2<Composer, Integer, Unit>> state = SnapshotStateKt.mutableStateListOf();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(DialogService dialogService, int i, Composer composer, int i2) {
        dialogService.Content(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object keepDialogShowing(final Function3<? super DialogScope, ? super Composer, ? super Integer, Unit> function3, Continuation<? super Unit> continuation) {
        DialogService$keepDialogShowing$1 dialogService$keepDialogShowing$1;
        Throwable th;
        Function2 dialogContent;
        if (continuation instanceof DialogService$keepDialogShowing$1) {
            dialogService$keepDialogShowing$1 = (DialogService$keepDialogShowing$1) continuation;
            if ((dialogService$keepDialogShowing$1.label & Integer.MIN_VALUE) != 0) {
                dialogService$keepDialogShowing$1.label -= Integer.MIN_VALUE;
                Object $result = dialogService$keepDialogShowing$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dialogService$keepDialogShowing$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CompletableDeferred dismissRequest = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                        final DialogService$keepDialogShowing$scope$1 scope = new DialogService$keepDialogShowing$scope$1(dismissRequest);
                        Function2 dialogContent2 = ComposableLambdaKt.composableLambdaInstance(-1510352155, true, new Function2() { // from class: kntr.app.digital.preview.DialogService$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2) {
                                Unit keepDialogShowing$lambda$0;
                                keepDialogShowing$lambda$0 = DialogService.keepDialogShowing$lambda$0(function3, scope, (Composer) obj, ((Integer) obj2).intValue());
                                return keepDialogShowing$lambda$0;
                            }
                        });
                        try {
                            this.state.add(dialogContent2);
                            dialogService$keepDialogShowing$1.L$0 = SpillingKt.nullOutSpilledVariable(function3);
                            dialogService$keepDialogShowing$1.L$1 = SpillingKt.nullOutSpilledVariable(dismissRequest);
                            dialogService$keepDialogShowing$1.L$2 = SpillingKt.nullOutSpilledVariable(scope);
                            dialogService$keepDialogShowing$1.L$3 = dialogContent2;
                            dialogService$keepDialogShowing$1.label = 1;
                            if (dismissRequest.await(dialogService$keepDialogShowing$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dialogContent = dialogContent2;
                            this.state.remove(dialogContent);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            dialogContent = dialogContent2;
                            this.state.remove(dialogContent);
                            throw th;
                        }
                    case 1:
                        dialogContent = (Function2) dialogService$keepDialogShowing$1.L$3;
                        DialogService$keepDialogShowing$scope$1 dialogService$keepDialogShowing$scope$1 = (DialogService$keepDialogShowing$scope$1) dialogService$keepDialogShowing$1.L$2;
                        CompletableDeferred completableDeferred = (CompletableDeferred) dialogService$keepDialogShowing$1.L$1;
                        Function3 function32 = (Function3) dialogService$keepDialogShowing$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            this.state.remove(dialogContent);
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            this.state.remove(dialogContent);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dialogService$keepDialogShowing$1 = new DialogService$keepDialogShowing$1(this, continuation);
        Object $result2 = dialogService$keepDialogShowing$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dialogService$keepDialogShowing$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepDialogShowing$lambda$0(Function3 $block, DialogService$keepDialogShowing$scope$1 $scope, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C26@869L7:DialogService.kt#cowxjs");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1510352155, $changed, -1, "kntr.app.digital.preview.DialogService.keepDialogShowing.<anonymous> (DialogService.kt:26)");
            }
            $block.invoke($scope, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public final void Content(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1055983099);
        ComposerKt.sourceInformation($composer2, "C(Content):DialogService.kt#cowxjs");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(this) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1055983099, $dirty, -1, "kntr.app.digital.preview.DialogService.Content (DialogService.kt:37)");
            }
            Iterable $this$forEach$iv = this.state;
            for (Object element$iv : $this$forEach$iv) {
                Function2 it = (Function2) element$iv;
                $composer2.startMovableGroup(1487687959, it);
                ComposerKt.sourceInformation($composer2, "39@1180L4");
                it.invoke($composer2, 0);
                $composer2.endMovableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.DialogService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = DialogService.Content$lambda$1(DialogService.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }
}