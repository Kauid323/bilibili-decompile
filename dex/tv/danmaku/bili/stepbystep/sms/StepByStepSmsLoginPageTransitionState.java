package tv.danmaku.bili.stepbystep.sms;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: StepByStepSmsLoginPageState.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010-\u001a\u00020\u0001H\u0016J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020&H\u0016¢\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\t\u00103\u001a\u00020\u0001HÆ\u0003J\t\u00104\u001a\u00020\u0001HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u00108\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006?"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPageTransitionState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "currentPage", "targetPage", "pageOffsetTarget", "", "focusState", "Landroidx/compose/ui/focus/FocusState;", "<init>", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;FLandroidx/compose/ui/focus/FocusState;)V", "getCurrentPage", "()Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "getTargetPage", "getPageOffsetTarget", "()F", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "phoneInputState", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "getPhoneInputState", "()Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhoneInputState;", "loggedIn", "", "getLoggedIn", "()Z", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "counting", "Lkotlin/time/Duration;", "getCounting-UwyO8pc", "()J", "captchaStatus", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "getCaptchaStatus", "()Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "next", "countDown", "diff", "countDown-LRDsOJo", "(J)Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "onFocusChanged", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginPageTransitionState implements IStepByStepSmsLoginPageState {
    public static final int $stable = 8;
    private final IStepByStepSmsLoginPageState currentPage;
    private final FocusState focusState;
    private final float pageOffsetTarget;
    private final IStepByStepSmsLoginPageState targetPage;

    public static /* synthetic */ StepByStepSmsLoginPageTransitionState copy$default(StepByStepSmsLoginPageTransitionState stepByStepSmsLoginPageTransitionState, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState2, float f, FocusState focusState, int i, Object obj) {
        if ((i & 1) != 0) {
            iStepByStepSmsLoginPageState = stepByStepSmsLoginPageTransitionState.currentPage;
        }
        if ((i & 2) != 0) {
            iStepByStepSmsLoginPageState2 = stepByStepSmsLoginPageTransitionState.targetPage;
        }
        if ((i & 4) != 0) {
            f = stepByStepSmsLoginPageTransitionState.pageOffsetTarget;
        }
        if ((i & 8) != 0) {
            focusState = stepByStepSmsLoginPageTransitionState.focusState;
        }
        return stepByStepSmsLoginPageTransitionState.copy(iStepByStepSmsLoginPageState, iStepByStepSmsLoginPageState2, f, focusState);
    }

    public final IStepByStepSmsLoginPageState component1() {
        return this.currentPage;
    }

    public final IStepByStepSmsLoginPageState component2() {
        return this.targetPage;
    }

    public final float component3() {
        return this.pageOffsetTarget;
    }

    public final FocusState component4() {
        return this.focusState;
    }

    public final StepByStepSmsLoginPageTransitionState copy(IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState2, float f, FocusState focusState) {
        Intrinsics.checkNotNullParameter(iStepByStepSmsLoginPageState, "currentPage");
        Intrinsics.checkNotNullParameter(iStepByStepSmsLoginPageState2, "targetPage");
        return new StepByStepSmsLoginPageTransitionState(iStepByStepSmsLoginPageState, iStepByStepSmsLoginPageState2, f, focusState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StepByStepSmsLoginPageTransitionState) {
            StepByStepSmsLoginPageTransitionState stepByStepSmsLoginPageTransitionState = (StepByStepSmsLoginPageTransitionState) obj;
            return Intrinsics.areEqual(this.currentPage, stepByStepSmsLoginPageTransitionState.currentPage) && Intrinsics.areEqual(this.targetPage, stepByStepSmsLoginPageTransitionState.targetPage) && Float.compare(this.pageOffsetTarget, stepByStepSmsLoginPageTransitionState.pageOffsetTarget) == 0 && Intrinsics.areEqual(this.focusState, stepByStepSmsLoginPageTransitionState.focusState);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.currentPage.hashCode() * 31) + this.targetPage.hashCode()) * 31) + Float.floatToIntBits(this.pageOffsetTarget)) * 31) + (this.focusState == null ? 0 : this.focusState.hashCode());
    }

    public String toString() {
        IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState = this.currentPage;
        IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState2 = this.targetPage;
        float f = this.pageOffsetTarget;
        return "StepByStepSmsLoginPageTransitionState(currentPage=" + iStepByStepSmsLoginPageState + ", targetPage=" + iStepByStepSmsLoginPageState2 + ", pageOffsetTarget=" + f + ", focusState=" + this.focusState + ")";
    }

    public StepByStepSmsLoginPageTransitionState(IStepByStepSmsLoginPageState currentPage, IStepByStepSmsLoginPageState targetPage, float pageOffsetTarget, FocusState focusState) {
        Intrinsics.checkNotNullParameter(currentPage, "currentPage");
        Intrinsics.checkNotNullParameter(targetPage, "targetPage");
        this.currentPage = currentPage;
        this.targetPage = targetPage;
        this.pageOffsetTarget = pageOffsetTarget;
        this.focusState = focusState;
    }

    public /* synthetic */ StepByStepSmsLoginPageTransitionState(IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState, IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState2, float f, FocusState focusState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iStepByStepSmsLoginPageState, iStepByStepSmsLoginPageState2, f, (i & 8) != 0 ? null : focusState);
    }

    public final IStepByStepSmsLoginPageState getCurrentPage() {
        return this.currentPage;
    }

    public final IStepByStepSmsLoginPageState getTargetPage() {
        return this.targetPage;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public float getPageOffsetTarget() {
        return this.pageOffsetTarget;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public FocusState getFocusState() {
        return this.focusState;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public StepByStepSmsLoginPhoneInputState getPhoneInputState() {
        return this.currentPage.getPhoneInputState();
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public boolean getLoggedIn() {
        return this.currentPage.getLoggedIn();
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.currentPage.getCaptchaDisplay();
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public ToastInfo getToastInfo() {
        return new ToastInfo(null, 0L, 3, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public EulaDisplayInfo getEulaDisplay() {
        EulaDisplayInfo eulaDisplay = this.currentPage.getEulaDisplay();
        if (eulaDisplay != null) {
            return EulaDisplayInfo.copy$default(eulaDisplay, null, false, false, null, null, 29, null);
        }
        return null;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: getCounting-UwyO8pc */
    public long mo1508getCountingUwyO8pc() {
        return this.currentPage.mo1508getCountingUwyO8pc();
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public SmsCaptchaStatus getCaptchaStatus() {
        return this.currentPage.getCaptchaStatus();
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState next() {
        return this.targetPage;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    /* renamed from: countDown-LRDsOJo */
    public IStepByStepSmsLoginPageState mo1507countDownLRDsOJo(long j) {
        return copy$default(this, this.currentPage.mo1507countDownLRDsOJo(j), this.targetPage.mo1507countDownLRDsOJo(j), 0.0f, null, 12, null);
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginPageState
    public IStepByStepSmsLoginPageState onFocusChanged(FocusState focusState) {
        return copy$default(this, null, null, 0.0f, focusState, 7, null);
    }
}