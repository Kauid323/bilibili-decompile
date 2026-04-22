package tv.danmaku.bili.stepbystep.sms;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: StepByStepSmsLoginCompose.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u000b\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&\u0082\u0001\u0002\r\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;", "", "getTitlePadding", "Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "getPhoneInputPadding", "getPhoneConfirmButtonPadding", "getSwitchLoginPadding", "getAgreementLinePadding", "getVerifyInputPadding", "getVerifyExceptionMessagePadding", "getVerifyConfirmButtonPadding", "InFloat", "InFullscreen", "Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap$InFloat;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap$InFullscreen;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface StepByStepComposePaddingMap {
    PaddingValues.Absolute getAgreementLinePadding();

    PaddingValues.Absolute getPhoneConfirmButtonPadding();

    PaddingValues.Absolute getPhoneInputPadding();

    PaddingValues.Absolute getSwitchLoginPadding();

    PaddingValues.Absolute getTitlePadding();

    PaddingValues.Absolute getVerifyConfirmButtonPadding();

    PaddingValues.Absolute getVerifyExceptionMessagePadding();

    PaddingValues.Absolute getVerifyInputPadding();

    /* compiled from: StepByStepSmsLoginCompose.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap$InFloat;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;", "<init>", "()V", "getTitlePadding", "Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "getPhoneInputPadding", "getPhoneConfirmButtonPadding", "getSwitchLoginPadding", "getAgreementLinePadding", "getVerifyInputPadding", "getVerifyExceptionMessagePadding", "getVerifyConfirmButtonPadding", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InFloat implements StepByStepComposePaddingMap {
        public static final int $stable = 0;
        public static final InFloat INSTANCE = new InFloat();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InFloat) {
                InFloat inFloat = (InFloat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -98223582;
        }

        public String toString() {
            return "InFloat";
        }

        private InFloat() {
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getTitlePadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(16), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getPhoneInputPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(12), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getPhoneConfirmButtonPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(0), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getSwitchLoginPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(8), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getAgreementLinePadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(0), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getVerifyInputPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(12), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getVerifyExceptionMessagePadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(12), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getVerifyConfirmButtonPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(0), 5, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: StepByStepSmsLoginCompose.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap$InFullscreen;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepComposePaddingMap;", "<init>", "()V", "getTitlePadding", "Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "getPhoneInputPadding", "getPhoneConfirmButtonPadding", "getSwitchLoginPadding", "getAgreementLinePadding", "getVerifyInputPadding", "getVerifyExceptionMessagePadding", "getVerifyConfirmButtonPadding", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InFullscreen implements StepByStepComposePaddingMap {
        public static final int $stable = 0;
        public static final InFullscreen INSTANCE = new InFullscreen();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InFullscreen) {
                InFullscreen inFullscreen = (InFullscreen) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 279990197;
        }

        public String toString() {
            return "InFullscreen";
        }

        private InFullscreen() {
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getTitlePadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(24), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getPhoneInputPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(24), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getPhoneConfirmButtonPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(24), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getSwitchLoginPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(0), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getAgreementLinePadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(0), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getVerifyInputPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(12), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getVerifyExceptionMessagePadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(0), 0.0f, Dp.constructor-impl(12), 5, (DefaultConstructorMarker) null);
        }

        @Override // tv.danmaku.bili.stepbystep.sms.StepByStepComposePaddingMap
        public PaddingValues.Absolute getVerifyConfirmButtonPadding() {
            return new PaddingValues.Absolute(0.0f, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(0), 5, (DefaultConstructorMarker) null);
        }
    }
}