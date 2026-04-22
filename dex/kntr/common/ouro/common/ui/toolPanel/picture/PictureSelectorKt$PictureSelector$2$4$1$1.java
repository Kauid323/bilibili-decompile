package kntr.common.ouro.common.ui.toolPanel.picture;

import android.app.Activity;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.permission.PermissionSettingNavigator_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureSelector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$PictureSelector$2$4$1$1", f = "PictureSelector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureSelectorKt$PictureSelector$2$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $platformContext;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureSelectorKt$PictureSelector$2$4$1$1(Activity activity, Continuation<? super PictureSelectorKt$PictureSelector$2$4$1$1> continuation) {
        super(2, continuation);
        this.$platformContext = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureSelectorKt$PictureSelector$2$4$1$1(this.$platformContext, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PermissionSettingNavigator_androidKt.navigateToPermissionSettings(this.$platformContext);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}