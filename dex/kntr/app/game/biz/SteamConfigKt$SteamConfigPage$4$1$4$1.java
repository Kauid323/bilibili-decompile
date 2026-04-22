package kntr.app.game.biz;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamConfig.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "enabled"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.biz.SteamConfigKt$SteamConfigPage$4$1$4$1", f = "SteamConfig.kt", i = {0}, l = {269}, m = "invokeSuspend", n = {"enabled"}, s = {"Z$0"}, v = 1)
public final class SteamConfigKt$SteamConfigPage$4$1$4$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
    final /* synthetic */ SteamConfigViewModel $steamViewModel;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamConfigKt$SteamConfigPage$4$1$4$1(SteamConfigViewModel steamConfigViewModel, Continuation<? super SteamConfigKt$SteamConfigPage$4$1$4$1> continuation) {
        super(2, continuation);
        this.$steamViewModel = steamConfigViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> steamConfigKt$SteamConfigPage$4$1$4$1 = new SteamConfigKt$SteamConfigPage$4$1$4$1(this.$steamViewModel, continuation);
        steamConfigKt$SteamConfigPage$4$1$4$1.Z$0 = ((Boolean) obj).booleanValue();
        return steamConfigKt$SteamConfigPage$4$1$4$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Boolean> continuation) {
        return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean enabled = this.Z$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.Z$0 = enabled;
                this.label = 1;
                Object obj = this.$steamViewModel.toggleFriendCode(enabled, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}