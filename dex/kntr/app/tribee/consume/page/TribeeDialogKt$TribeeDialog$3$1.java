package kntr.app.tribee.consume.page;

import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeDialogKt$TribeeDialog$3$1", f = "TribeeDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeDialogKt$TribeeDialog$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KToastDialog $dialog;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeDialogKt$TribeeDialog$3$1(KToastDialog kToastDialog, Continuation<? super TribeeDialogKt$TribeeDialog$3$1> continuation) {
        super(2, continuation);
        this.$dialog = kToastDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeDialogKt$TribeeDialog$3$1(this.$dialog, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KToastDialog.KToastDialogType type = this.$dialog.getType();
                if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.EXIT.INSTANCE)) {
                    TrackerKt.reportExposureExitDialog();
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.PUBLISH_JOIN.INSTANCE)) {
                    TrackerKt.reportExposureJoinDialog();
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.PUBLISH_ABNORMAL.INSTANCE)) {
                    TrackerKt.reportExposurePermissionDialog();
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.INVITE_CODE_SUCCESS.INSTANCE)) {
                    TrackerKt.inviteCodeResultDialogExposure("success");
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.INVITE_CODE_EXPIRE.INSTANCE)) {
                    TrackerKt.inviteCodeResultDialogExposure("invalid");
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.INVITE_CODE_NO_NEED.INSTANCE)) {
                    TrackerKt.inviteCodeResultDialogExposure("has_joined");
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.GAME_STATS_NO_TRIBEE.INSTANCE)) {
                    SteamTrackerKt.steamPagePopupExposure("not_join");
                } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.STEAM_ACCOUNT_RELEASE.INSTANCE)) {
                    SteamTrackerKt.steamPagePopupExposure("unbound");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}