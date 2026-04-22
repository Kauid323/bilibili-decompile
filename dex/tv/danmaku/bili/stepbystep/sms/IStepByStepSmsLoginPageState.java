package tv.danmaku.bili.stepbystep.sms;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: StepByStepSmsLoginPageState.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010&\u001a\u00020\u0000H&J\u0019\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u001bH&¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\u0082\u0001\u0004,-./ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "", "phoneInputState", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "getPhoneInputState", "()Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "loggedIn", "", "getLoggedIn", "()Z", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "pageOffsetTarget", "", "getPageOffsetTarget", "()F", "counting", "Lkotlin/time/Duration;", "getCounting-UwyO8pc", "()J", "captchaStatus", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "getCaptchaStatus", "()Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "next", "countDown", "diff", "countDown-LRDsOJo", "(J)Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "onFocusChanged", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginIdlePage;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPageTransitionState;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IStepByStepSmsLoginPageState {
    /* renamed from: countDown-LRDsOJo  reason: not valid java name */
    IStepByStepSmsLoginPageState mo1507countDownLRDsOJo(long j);

    LoginCaptchaInfo getCaptchaDisplay();

    SmsCaptchaStatus getCaptchaStatus();

    /* renamed from: getCounting-UwyO8pc  reason: not valid java name */
    long mo1508getCountingUwyO8pc();

    EulaDisplayInfo getEulaDisplay();

    FocusState getFocusState();

    boolean getLoggedIn();

    float getPageOffsetTarget();

    StepByStepSmsLoginPhoneInputState getPhoneInputState();

    ToastInfo getToastInfo();

    IStepByStepSmsLoginPageState next();

    IStepByStepSmsLoginPageState onFocusChanged(FocusState focusState);

    /* compiled from: StepByStepSmsLoginPageState.kt */
    /* renamed from: tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        /* renamed from: countDown-LRDsOJo$default  reason: not valid java name */
        public static /* synthetic */ IStepByStepSmsLoginPageState m1509countDownLRDsOJo$default(IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    Duration.Companion companion = Duration.Companion;
                    j = DurationKt.toDuration(1, DurationUnit.SECONDS);
                }
                return iStepByStepSmsLoginPageState.mo1507countDownLRDsOJo(j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countDown-LRDsOJo");
        }
    }
}