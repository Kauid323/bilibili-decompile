package kntr.common.photonic.permission;

import androidx.compose.runtime.MutableState;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.permission.PermissionState_androidKt$rememberMutableBPermissionState$1$1", f = "PermissionState.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PermissionState_androidKt$rememberMutableBPermissionState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableBPermissionState $mutableBPermissionState;
    final /* synthetic */ MutableState<Function1<Map<String, Boolean>, Unit>> $onPermissionResult$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionState_androidKt$rememberMutableBPermissionState$1$1(MutableBPermissionState mutableBPermissionState, MutableState<Function1<Map<String, Boolean>, Unit>> mutableState, Continuation<? super PermissionState_androidKt$rememberMutableBPermissionState$1$1> continuation) {
        super(2, continuation);
        this.$mutableBPermissionState = mutableBPermissionState;
        this.$onPermissionResult$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PermissionState_androidKt$rememberMutableBPermissionState$1$1(this.$mutableBPermissionState, this.$onPermissionResult$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableState<Function1<Map<String, Boolean>, Unit>> mutableState = this.$onPermissionResult$delegate;
                final MutableBPermissionState mutableBPermissionState = this.$mutableBPermissionState;
                mutableState.setValue(new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$rememberMutableBPermissionState$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PermissionState_androidKt$rememberMutableBPermissionState$1$1.invokeSuspend$lambda$0(MutableBPermissionState.this, (Map) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableBPermissionState $mutableBPermissionState, Map result) {
        Continuation<PermissionStatus> authorizationContinuation = $mutableBPermissionState.getAuthorizationContinuation();
        if (authorizationContinuation != null) {
            Result.Companion companion = Result.Companion;
            authorizationContinuation.resumeWith(Result.m2636constructorimpl($mutableBPermissionState.getCurrentStatus().getValue()));
        }
        Continuation<Unit> requestMoreAssetsContinuation = $mutableBPermissionState.getRequestMoreAssetsContinuation();
        if (requestMoreAssetsContinuation != null) {
            Result.Companion companion2 = Result.Companion;
            requestMoreAssetsContinuation.resumeWith(Result.m2636constructorimpl(Unit.INSTANCE));
        }
        $mutableBPermissionState.setAuthorizationContinuation(null);
        return Unit.INSTANCE;
    }
}