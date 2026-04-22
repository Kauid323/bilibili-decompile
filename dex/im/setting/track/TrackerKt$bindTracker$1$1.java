package im.setting.track;

import com.tencent.tauth.AuthActivity;
import im.setting.IMSettingAction;
import im.setting.IMSettingState;
import im.setting.service.SettingReportService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", AuthActivity.ACTION_KEY, "Lim/setting/IMSettingAction;", "<unused var>", "Lim/setting/IMSettingState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.track.TrackerKt$bindTracker$1$1", f = "Tracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TrackerKt$bindTracker$1$1 extends SuspendLambda implements Function3<IMSettingAction, IMSettingState, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingReportService $reportService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackerKt$bindTracker$1$1(SettingReportService settingReportService, Continuation<? super TrackerKt$bindTracker$1$1> continuation) {
        super(3, continuation);
        this.$reportService = settingReportService;
    }

    public final Object invoke(IMSettingAction iMSettingAction, IMSettingState iMSettingState, Continuation<? super Unit> continuation) {
        TrackerKt$bindTracker$1$1 trackerKt$bindTracker$1$1 = new TrackerKt$bindTracker$1$1(this.$reportService, continuation);
        trackerKt$bindTracker$1$1.L$0 = iMSettingAction;
        return trackerKt$bindTracker$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSettingAction action = (IMSettingAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TrackerKt.reportClick(action, this.$reportService.getReportParam());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}