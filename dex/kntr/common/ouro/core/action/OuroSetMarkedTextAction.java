package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lkntr/common/ouro/core/action/OuroSetMarkedTextAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "text", "", "textMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "paragraphMarks", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/coroutines/CompletableDeferred;)V", "getText", "()Ljava/lang/String;", "getTextMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getParagraphMarks", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroSetMarkedTextAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final OuroMarks<OuroParagraphMark> paragraphMarks;
    private final String text;
    private final OuroMarks<OuroTextMark> textMarks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroSetMarkedTextAction copy$default(OuroSetMarkedTextAction ouroSetMarkedTextAction, String str, OuroMarks ouroMarks, OuroMarks ouroMarks2, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ouroSetMarkedTextAction.text;
        }
        if ((i & 2) != 0) {
            ouroMarks = ouroSetMarkedTextAction.textMarks;
        }
        if ((i & 4) != 0) {
            ouroMarks2 = ouroSetMarkedTextAction.paragraphMarks;
        }
        if ((i & 8) != 0) {
            completableDeferred = ouroSetMarkedTextAction.deferred;
        }
        return ouroSetMarkedTextAction.copy(str, ouroMarks, ouroMarks2, completableDeferred);
    }

    public final String component1() {
        return this.text;
    }

    public final OuroMarks<OuroTextMark> component2() {
        return this.textMarks;
    }

    public final OuroMarks<OuroParagraphMark> component3() {
        return this.paragraphMarks;
    }

    public final CompletableDeferred<OuroState> component4() {
        return this.deferred;
    }

    public final OuroSetMarkedTextAction copy(String str, OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroParagraphMark> ouroMarks2, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "paragraphMarks");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroSetMarkedTextAction(str, ouroMarks, ouroMarks2, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroSetMarkedTextAction) {
            OuroSetMarkedTextAction ouroSetMarkedTextAction = (OuroSetMarkedTextAction) obj;
            return Intrinsics.areEqual(this.text, ouroSetMarkedTextAction.text) && Intrinsics.areEqual(this.textMarks, ouroSetMarkedTextAction.textMarks) && Intrinsics.areEqual(this.paragraphMarks, ouroSetMarkedTextAction.paragraphMarks) && Intrinsics.areEqual(this.deferred, ouroSetMarkedTextAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.textMarks.hashCode()) * 31) + this.paragraphMarks.hashCode()) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        String str = this.text;
        OuroMarks<OuroTextMark> ouroMarks = this.textMarks;
        OuroMarks<OuroParagraphMark> ouroMarks2 = this.paragraphMarks;
        return "OuroSetMarkedTextAction(text=" + str + ", textMarks=" + ouroMarks + ", paragraphMarks=" + ouroMarks2 + ", deferred=" + this.deferred + ")";
    }

    public OuroSetMarkedTextAction(String text, OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroParagraphMark> ouroMarks2, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "paragraphMarks");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.text = text;
        this.textMarks = ouroMarks;
        this.paragraphMarks = ouroMarks2;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroSetMarkedTextAction(String str, OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroParagraphMark> ouroMarks2, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks, (i & 4) != 0 ? OuroMarks.Empty.INSTANCE.getParagraphMarks() : ouroMarks2, (i & 8) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final String getText() {
        return this.text;
    }

    public final OuroMarks<OuroTextMark> getTextMarks() {
        return this.textMarks;
    }

    public final OuroMarks<OuroParagraphMark> getParagraphMarks() {
        return this.paragraphMarks;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}