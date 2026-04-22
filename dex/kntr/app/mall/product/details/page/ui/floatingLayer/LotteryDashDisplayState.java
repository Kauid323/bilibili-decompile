package kntr.app.mall.product.details.page.ui.floatingLayer;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LotteryDashFloatingLayer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lkntr/app/mall/product/details/page/ui/floatingLayer/LotteryDashDisplayState;", "", "preHighlightedText", "", "mainHighlightedText", "afterHighlightedText", "buttonText", "subText", "countDownText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPreHighlightedText", "()Ljava/lang/String;", "getMainHighlightedText", "getAfterHighlightedText", "getButtonText", "getSubText", "getCountDownText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LotteryDashDisplayState {
    public static final int $stable = 0;
    private final String afterHighlightedText;
    private final String buttonText;
    private final String countDownText;
    private final String mainHighlightedText;
    private final String preHighlightedText;
    private final String subText;

    public LotteryDashDisplayState() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LotteryDashDisplayState copy$default(LotteryDashDisplayState lotteryDashDisplayState, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lotteryDashDisplayState.preHighlightedText;
        }
        if ((i & 2) != 0) {
            str2 = lotteryDashDisplayState.mainHighlightedText;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = lotteryDashDisplayState.afterHighlightedText;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = lotteryDashDisplayState.buttonText;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = lotteryDashDisplayState.subText;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = lotteryDashDisplayState.countDownText;
        }
        return lotteryDashDisplayState.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.preHighlightedText;
    }

    public final String component2() {
        return this.mainHighlightedText;
    }

    public final String component3() {
        return this.afterHighlightedText;
    }

    public final String component4() {
        return this.buttonText;
    }

    public final String component5() {
        return this.subText;
    }

    public final String component6() {
        return this.countDownText;
    }

    public final LotteryDashDisplayState copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "preHighlightedText");
        Intrinsics.checkNotNullParameter(str2, "mainHighlightedText");
        Intrinsics.checkNotNullParameter(str3, "afterHighlightedText");
        Intrinsics.checkNotNullParameter(str4, "buttonText");
        Intrinsics.checkNotNullParameter(str5, "subText");
        Intrinsics.checkNotNullParameter(str6, "countDownText");
        return new LotteryDashDisplayState(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LotteryDashDisplayState) {
            LotteryDashDisplayState lotteryDashDisplayState = (LotteryDashDisplayState) obj;
            return Intrinsics.areEqual(this.preHighlightedText, lotteryDashDisplayState.preHighlightedText) && Intrinsics.areEqual(this.mainHighlightedText, lotteryDashDisplayState.mainHighlightedText) && Intrinsics.areEqual(this.afterHighlightedText, lotteryDashDisplayState.afterHighlightedText) && Intrinsics.areEqual(this.buttonText, lotteryDashDisplayState.buttonText) && Intrinsics.areEqual(this.subText, lotteryDashDisplayState.subText) && Intrinsics.areEqual(this.countDownText, lotteryDashDisplayState.countDownText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.preHighlightedText.hashCode() * 31) + this.mainHighlightedText.hashCode()) * 31) + this.afterHighlightedText.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.subText.hashCode()) * 31) + this.countDownText.hashCode();
    }

    public String toString() {
        String str = this.preHighlightedText;
        String str2 = this.mainHighlightedText;
        String str3 = this.afterHighlightedText;
        String str4 = this.buttonText;
        String str5 = this.subText;
        return "LotteryDashDisplayState(preHighlightedText=" + str + ", mainHighlightedText=" + str2 + ", afterHighlightedText=" + str3 + ", buttonText=" + str4 + ", subText=" + str5 + ", countDownText=" + this.countDownText + ")";
    }

    public LotteryDashDisplayState(String preHighlightedText, String mainHighlightedText, String afterHighlightedText, String buttonText, String subText, String countDownText) {
        Intrinsics.checkNotNullParameter(preHighlightedText, "preHighlightedText");
        Intrinsics.checkNotNullParameter(mainHighlightedText, "mainHighlightedText");
        Intrinsics.checkNotNullParameter(afterHighlightedText, "afterHighlightedText");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(subText, "subText");
        Intrinsics.checkNotNullParameter(countDownText, "countDownText");
        this.preHighlightedText = preHighlightedText;
        this.mainHighlightedText = mainHighlightedText;
        this.afterHighlightedText = afterHighlightedText;
        this.buttonText = buttonText;
        this.subText = subText;
        this.countDownText = countDownText;
    }

    public /* synthetic */ LotteryDashDisplayState(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }

    public final String getPreHighlightedText() {
        return this.preHighlightedText;
    }

    public final String getMainHighlightedText() {
        return this.mainHighlightedText;
    }

    public final String getAfterHighlightedText() {
        return this.afterHighlightedText;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getCountDownText() {
        return this.countDownText;
    }
}