package kntr.app.digital.preview;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: DialogService.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kntr/app/digital/preview/DialogService$keepDialogShowing$scope$1", "Lkntr/app/digital/preview/DialogScope;", "onDismissRequest", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DialogService$keepDialogShowing$scope$1 implements DialogScope {
    final /* synthetic */ CompletableDeferred<Unit> $dismissRequest;

    @Override // kntr.app.digital.preview.DialogScope
    public Function0<Unit> getOnDismissRequest() {
        final CompletableDeferred<Unit> completableDeferred = this.$dismissRequest;
        return new Function0() { // from class: kntr.app.digital.preview.DialogService$keepDialogShowing$scope$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit _get_onDismissRequest_$lambda$0;
                _get_onDismissRequest_$lambda$0 = DialogService$keepDialogShowing$scope$1._get_onDismissRequest_$lambda$0(completableDeferred);
                return _get_onDismissRequest_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogService$keepDialogShowing$scope$1(CompletableDeferred<Unit> completableDeferred) {
        this.$dismissRequest = completableDeferred;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_onDismissRequest_$lambda$0(CompletableDeferred $dismissRequest) {
        $dismissRequest.complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}