package kntr.watch.later.watchlater.data;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkntr/watch/later/watchlater/data/FavEditState;", "", "opType", "", "resources", "", "onDismissRequest", "Lkotlin/Function0;", "", "onOperateSuccess", "<init>", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOpType", "()I", "getResources", "()Ljava/lang/String;", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "getOnOperateSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FavEditState {
    public static final int $stable = 0;
    private final Function0<Unit> onDismissRequest;
    private final Function0<Unit> onOperateSuccess;
    private final int opType;
    private final String resources;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavEditState copy$default(FavEditState favEditState, int i, String str, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = favEditState.opType;
        }
        if ((i2 & 2) != 0) {
            str = favEditState.resources;
        }
        if ((i2 & 4) != 0) {
            function0 = favEditState.onDismissRequest;
        }
        if ((i2 & 8) != 0) {
            function02 = favEditState.onOperateSuccess;
        }
        return favEditState.copy(i, str, function0, function02);
    }

    public final int component1() {
        return this.opType;
    }

    public final String component2() {
        return this.resources;
    }

    public final Function0<Unit> component3() {
        return this.onDismissRequest;
    }

    public final Function0<Unit> component4() {
        return this.onOperateSuccess;
    }

    public final FavEditState copy(int i, String str, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "resources");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function02, "onOperateSuccess");
        return new FavEditState(i, str, function0, function02);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavEditState) {
            FavEditState favEditState = (FavEditState) obj;
            return this.opType == favEditState.opType && Intrinsics.areEqual(this.resources, favEditState.resources) && Intrinsics.areEqual(this.onDismissRequest, favEditState.onDismissRequest) && Intrinsics.areEqual(this.onOperateSuccess, favEditState.onOperateSuccess);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.opType * 31) + this.resources.hashCode()) * 31) + this.onDismissRequest.hashCode()) * 31) + this.onOperateSuccess.hashCode();
    }

    public String toString() {
        int i = this.opType;
        String str = this.resources;
        Function0<Unit> function0 = this.onDismissRequest;
        return "FavEditState(opType=" + i + ", resources=" + str + ", onDismissRequest=" + function0 + ", onOperateSuccess=" + this.onOperateSuccess + ")";
    }

    public FavEditState(int opType, String resources, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function02, "onOperateSuccess");
        this.opType = opType;
        this.resources = resources;
        this.onDismissRequest = function0;
        this.onOperateSuccess = function02;
    }

    public /* synthetic */ FavEditState(int i, String str, Function0 function0, Function0 function02, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, function0, (i2 & 8) != 0 ? new Function0() { // from class: kntr.watch.later.watchlater.data.FavEditState$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function02);
    }

    public final int getOpType() {
        return this.opType;
    }

    public final String getResources() {
        return this.resources;
    }

    public final Function0<Unit> getOnDismissRequest() {
        return this.onDismissRequest;
    }

    public final Function0<Unit> getOnOperateSuccess() {
        return this.onOperateSuccess;
    }
}