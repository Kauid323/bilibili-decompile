package kntr.app.tribee.invite.page;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareResult;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Res;
import srcs.app.tribee.consume.generated.resources.String0_commonMainKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInviteShare.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.invite.page.TribeeInviteShareKt$TribeeInviteShare$1$1$2$1", f = "TribeeInviteShare.kt", i = {}, l = {89, 93}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeInviteShareKt$TribeeInviteShare$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShareResult $result;
    final /* synthetic */ Toaster $toaster;
    Object L$0;
    int label;

    /* compiled from: TribeeInviteShare.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShareResult.values().length];
            try {
                iArr[ShareResult.Failure.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ShareResult.Cancel.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInviteShareKt$TribeeInviteShare$1$1$2$1(ShareResult shareResult, Toaster toaster, Continuation<? super TribeeInviteShareKt$TribeeInviteShare$1$1$2$1> continuation) {
        super(2, continuation);
        this.$result = shareResult;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInviteShareKt$TribeeInviteShare$1$1$2$1(this.$result, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object string;
        Toaster toaster;
        Object string2;
        Toaster toaster2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                switch (WhenMappings.$EnumSwitchMapping$0[this.$result.ordinal()]) {
                    case 1:
                        Toaster toaster3 = this.$toaster;
                        this.L$0 = toaster3;
                        this.label = 1;
                        string = StringResourcesKt.getString(String0_commonMainKt.getTribee_share_failed(Res.string.INSTANCE), (Continuation) this);
                        if (string == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        toaster = toaster3;
                        Toaster.CC.showToast$default(toaster, (String) string, null, 2, null);
                        break;
                    case 2:
                        Toaster toaster4 = this.$toaster;
                        this.L$0 = toaster4;
                        this.label = 2;
                        string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_share_cancel(Res.string.INSTANCE), (Continuation) this);
                        if (string2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        toaster2 = toaster4;
                        Toaster.CC.showToast$default(toaster2, (String) string2, null, 2, null);
                        break;
                }
            case 1:
                toaster = (Toaster) this.L$0;
                ResultKt.throwOnFailure($result);
                string = $result;
                Toaster.CC.showToast$default(toaster, (String) string, null, 2, null);
                break;
            case 2:
                toaster2 = (Toaster) this.L$0;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                Toaster.CC.showToast$default(toaster2, (String) string2, null, 2, null);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}