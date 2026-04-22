package kntr.app.ad.domain.click.internal;

import kntr.app.ad.domain.click.ClickArg;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickRequest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006#"}, d2 = {"Lkntr/app/ad/domain/click/internal/ClickRequest;", RoomRecommendViewModel.EMPTY_CURSOR, "arg", "Lkntr/app/ad/domain/click/ClickArg;", "<init>", "(Lkntr/app/ad/domain/click/ClickArg;)V", "getArg", "()Lkntr/app/ad/domain/click/ClickArg;", "downgrade", "getDowngrade", "()Lkntr/app/ad/domain/click/internal/ClickRequest;", "setDowngrade", "(Lkntr/app/ad/domain/click/internal/ClickRequest;)V", "onStart", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "getOnStart$click_debug", "()Lkotlin/jvm/functions/Function0;", "setOnStart$click_debug", "(Lkotlin/jvm/functions/Function0;)V", "onAnswered", "getOnAnswered$click_debug", "setOnAnswered$click_debug", "onLost", "getOnLost$click_debug", "setOnLost$click_debug", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickRequest {
    private final ClickArg arg;
    private ClickRequest downgrade;
    private Function0<Unit> onAnswered;
    private Function0<Unit> onLost;
    private Function0<Unit> onStart;

    public static /* synthetic */ ClickRequest copy$default(ClickRequest clickRequest, ClickArg clickArg, int i, Object obj) {
        if ((i & 1) != 0) {
            clickArg = clickRequest.arg;
        }
        return clickRequest.copy(clickArg);
    }

    public final ClickArg component1() {
        return this.arg;
    }

    public final ClickRequest copy(ClickArg clickArg) {
        Intrinsics.checkNotNullParameter(clickArg, "arg");
        return new ClickRequest(clickArg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClickRequest) && Intrinsics.areEqual(this.arg, ((ClickRequest) obj).arg);
    }

    public int hashCode() {
        return this.arg.hashCode();
    }

    public String toString() {
        return "ClickRequest(arg=" + this.arg + ")";
    }

    public ClickRequest(ClickArg arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        this.arg = arg;
    }

    public final ClickArg getArg() {
        return this.arg;
    }

    public final ClickRequest getDowngrade() {
        return this.downgrade;
    }

    public final void setDowngrade(ClickRequest clickRequest) {
        this.downgrade = clickRequest;
    }

    public final Function0<Unit> getOnStart$click_debug() {
        return this.onStart;
    }

    public final void setOnStart$click_debug(Function0<Unit> function0) {
        this.onStart = function0;
    }

    public final Function0<Unit> getOnAnswered$click_debug() {
        return this.onAnswered;
    }

    public final void setOnAnswered$click_debug(Function0<Unit> function0) {
        this.onAnswered = function0;
    }

    public final Function0<Unit> getOnLost$click_debug() {
        return this.onLost;
    }

    public final void setOnLost$click_debug(Function0<Unit> function0) {
        this.onLost = function0;
    }
}