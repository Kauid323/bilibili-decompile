package kntr.app.tribee.publish.ui.v2;

import android.app.Activity;
import android.view.Window;
import androidx.core.view.WindowCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishConfigWinidow.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1", f = "TribeePublishConfigWinidow.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $isNight;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1(Activity activity, boolean z, Continuation<? super TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$isNight = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1(this.$activity, this.$isNight, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WindowCompat.setDecorFitsSystemWindows(this.$activity.getWindow(), false);
                this.$activity.getWindow().setSoftInputMode(16);
                Window window = this.$activity.getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                TribeePublishConfigWinidow_androidKt.setSupportImmersiveStatusBar(window, this.$isNight);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}