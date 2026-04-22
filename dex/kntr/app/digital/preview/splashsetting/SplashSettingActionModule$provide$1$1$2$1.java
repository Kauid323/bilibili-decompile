package kntr.app.digital.preview.splashsetting;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
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

/* compiled from: SplashSettingActionModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.splashsetting.SplashSettingActionModule$provide$1$1$2$1", f = "SplashSettingActionModule.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SplashSettingActionModule$provide$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardInfoJson;
    final /* synthetic */ Router $router;
    final /* synthetic */ DLCSplashSettingNoticeDialogService $splashSettingNoticeDialogService;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashSettingActionModule$provide$1$1$2$1(DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService, String str, Router router, Continuation<? super SplashSettingActionModule$provide$1$1$2$1> continuation) {
        super(2, continuation);
        this.$splashSettingNoticeDialogService = dLCSplashSettingNoticeDialogService;
        this.$cardInfoJson = str;
        this.$router = router;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashSettingActionModule$provide$1$1$2$1(this.$splashSettingNoticeDialogService, this.$cardInfoJson, this.$router, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService = this.$splashSettingNoticeDialogService;
                final String str = this.$cardInfoJson;
                final Router router = this.$router;
                this.label = 1;
                if (dLCSplashSettingNoticeDialogService.keepDialogShowing(new Function0<Unit>() { // from class: kntr.app.digital.preview.splashsetting.SplashSettingActionModule$provide$1$1$2$1.1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1019invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1019invoke() {
                        Uri it = UrisKt.toUri("bilibili://splash/brand-setting").buildUpon().appendQueryParameter("brandSplash", str).appendQueryParameter("autoOpenFloat", "1").build();
                        router.launch(it);
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}