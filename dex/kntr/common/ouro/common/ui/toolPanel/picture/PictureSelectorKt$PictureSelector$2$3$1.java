package kntr.common.ouro.common.ui.toolPanel.picture;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.PermissionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureSelector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$PictureSelector$2$3$1", f = "PictureSelector.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureSelectorKt$PictureSelector$2$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $onPicturePermissionGrant;
    final /* synthetic */ BPermissionState $permissionState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureSelectorKt$PictureSelector$2$3$1(BPermissionState bPermissionState, State<? extends Function0<Unit>> state, Continuation<? super PictureSelectorKt$PictureSelector$2$3$1> continuation) {
        super(2, continuation);
        this.$permissionState = bPermissionState;
        this.$onPicturePermissionGrant = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureSelectorKt$PictureSelector$2$3$1(this.$permissionState, this.$onPicturePermissionGrant, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestAuthorization;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                requestAuthorization = this.$permissionState.requestAuthorization((Continuation) this);
                if (requestAuthorization == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                requestAuthorization = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PermissionStatus permissionStatus = (PermissionStatus) requestAuthorization;
        if (permissionStatus.isGranted()) {
            ((Function0) this.$onPicturePermissionGrant.getValue()).invoke();
        }
        return Unit.INSTANCE;
    }
}