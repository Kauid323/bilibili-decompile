package tv.danmaku.bili.stepbystep.sms;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.time.Duration;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: StepByStepSmsLoginPageState.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020\u0001H\u0016J\u0017\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001dH\u0016¢\u0006\u0004\b(\u0010)J\u0012\u0010.\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0013\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010*\u001a\u0004\u0018\u00010+X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginIdlePage;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "<init>", "()V", "phoneInputState", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "getPhoneInputState", "()Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "loggedIn", "", "getLoggedIn", "()Z", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "pageOffsetTarget", "", "getPageOffsetTarget", "()F", "counting", "Lkotlin/time/Duration;", "getCounting-UwyO8pc", "()J", "J", "captchaStatus", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "getCaptchaStatus", "()Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "next", "countDown", "diff", "countDown-LRDsOJo", "(J)Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "onFocusChanged", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginIdlePage implements IStepByStepSmsLoginPageState {
    private static final LoginCaptchaInfo captchaDisplay = null;
    private static final SmsCaptchaStatus captchaStatus = null;
    private static final EulaDisplayInfo eulaDisplay = null;
    private static final FocusState focusState = null;
    private static final boolean loggedIn = false;
    private static final float pageOffsetTarget = 0.0f;
    public static final StepByStepSmsLoginIdlePage INSTANCE = new StepByStepSmsLoginIdlePage();
    private static final StepByStepSmsLoginPhoneInputState phoneInputState = new StepByStepSmsLoginPhoneInputState(null, null, null, false, 15, null);
    private static final ToastInfo toastInfo = new ToastInfo(null, 0, 3, null);
    private static final long counting = Duration.Companion.getZERO-UwyO8pc();
    public static final int $stable = 8;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StepByStepSmsLoginIdlePage) {
            StepByStepSmsLoginIdlePage stepByStepSmsLoginIdlePage = (StepByStepSmsLoginIdlePage) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 1448623735;
    }

    public String toString() {
        return "StepByStepSmsLoginIdlePage";
    }

    private StepByStepSmsLoginIdlePage() {
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public StepByStepSmsLoginPhoneInputState getPhoneInputState() {
        return phoneInputState;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public boolean getLoggedIn() {
        return loggedIn;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public LoginCaptchaInfo getCaptchaDisplay() {
        return captchaDisplay;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public ToastInfo getToastInfo() {
        return toastInfo;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public EulaDisplayInfo getEulaDisplay() {
        return eulaDisplay;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public float getPageOffsetTarget() {
        return pageOffsetTarget;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: getCounting-UwyO8pc */
    public long mo1508getCountingUwyO8pc() {
        return counting;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public SmsCaptchaStatus getCaptchaStatus() {
        return captchaStatus;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState next() {
        return new StepByStepSmsLoginPhonePage(new StepByStepSmsLoginPhoneInputState(null, null, null, false, 15, null), null, false, null, null, 0.0f, 0L, null, null, BR.half, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: countDown-LRDsOJo */
    public IStepByStepSmsLoginPageState mo1507countDownLRDsOJo(long j) {
        return this;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public FocusState getFocusState() {
        return focusState;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState onFocusChanged(FocusState focusState2) {
        return this;
    }
}