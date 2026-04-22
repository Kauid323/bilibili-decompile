package im.setting;

import im.setting.model.SettingPageType;
import im.setting.service.SettingReportService;
import kntr.common.pv.PvEventTrigger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSettingPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.IMSettingPageKt$SettingPage$1$1", f = "IMSettingPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSettingPageKt$SettingPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingPageType $pageType;
    final /* synthetic */ PvEventTrigger $pvTrigger;
    final /* synthetic */ SettingReportService $reportService;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSettingPageKt$SettingPage$1$1(SettingPageType settingPageType, PvEventTrigger pvEventTrigger, SettingReportService settingReportService, Continuation<? super IMSettingPageKt$SettingPage$1$1> continuation) {
        super(2, continuation);
        this.$pageType = settingPageType;
        this.$pvTrigger = pvEventTrigger;
        this.$reportService = settingReportService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSettingPageKt$SettingPage$1$1(this.$pageType, this.$pvTrigger, this.$reportService, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$pageType instanceof SettingPageType.IMSetting) {
                    this.$pvTrigger.updateExtra(MapsKt.plus(MapsKt.mapOf(TuplesKt.to("module", ((SettingPageType.IMSetting) this.$pageType).getType().getName())), this.$reportService.getReportParam()));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}