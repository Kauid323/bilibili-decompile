package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/core/action/OuroInsertCompositionTextAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "text", "", "textMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/coroutines/CompletableDeferred;)V", "getText", "()Ljava/lang/String;", "getTextMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroInsertCompositionTextAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final String text;
    private final OuroMarks<OuroTextMark> textMarks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroInsertCompositionTextAction copy$default(OuroInsertCompositionTextAction ouroInsertCompositionTextAction, String str, OuroMarks ouroMarks, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ouroInsertCompositionTextAction.text;
        }
        if ((i & 2) != 0) {
            ouroMarks = ouroInsertCompositionTextAction.textMarks;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroInsertCompositionTextAction.deferred;
        }
        return ouroInsertCompositionTextAction.copy(str, ouroMarks, completableDeferred);
    }

    public final String component1() {
        return this.text;
    }

    public final OuroMarks<OuroTextMark> component2() {
        return this.textMarks;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroInsertCompositionTextAction copy(String str, OuroMarks<OuroTextMark> ouroMarks, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroInsertCompositionTextAction(str, ouroMarks, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroInsertCompositionTextAction) {
            OuroInsertCompositionTextAction ouroInsertCompositionTextAction = (OuroInsertCompositionTextAction) obj;
            return Intrinsics.areEqual(this.text, ouroInsertCompositionTextAction.text) && Intrinsics.areEqual(this.textMarks, ouroInsertCompositionTextAction.textMarks) && Intrinsics.areEqual(this.deferred, ouroInsertCompositionTextAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.textMarks.hashCode()) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        String str = this.text;
        OuroMarks<OuroTextMark> ouroMarks = this.textMarks;
        return "OuroInsertCompositionTextAction(text=" + str + ", textMarks=" + ouroMarks + ", deferred=" + this.deferred + ")";
    }

    public OuroInsertCompositionTextAction(String text, OuroMarks<OuroTextMark> ouroMarks, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.text = text;
        this.textMarks = ouroMarks;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroInsertCompositionTextAction(String str, OuroMarks<OuroTextMark> ouroMarks, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final String getText() {
        return this.text;
    }

    public final OuroMarks<OuroTextMark> getTextMarks() {
        return this.textMarks;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}