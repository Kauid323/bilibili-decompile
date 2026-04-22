package kntr.common.ouro.core.action;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013BO\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0015\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0016J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003Je\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lkntr/common/ouro/core/action/OuroInsertAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "text", "", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "compositionRange", "textMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "paragraphMarks", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "replaceComposition", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/OuroTextRange;Lkntr/common/ouro/core/model/OuroTextRange;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/model/mark/OuroMarks;ZLkotlinx/coroutines/CompletableDeferred;)V", "insert", "", "(Ljava/lang/String;Lkntr/common/ouro/core/model/OuroTextRange;Lkntr/common/ouro/core/model/OuroTextRange;Ljava/util/List;Ljava/util/List;Z)V", "getText", "()Ljava/lang/String;", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getCompositionRange", "getTextMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getParagraphMarks", "getReplaceComposition", "()Z", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroInsertAction implements OuroEditAction, OuroSyncAction {
    private final OuroTextRange compositionRange;
    private final CompletableDeferred<OuroState> deferred;
    private final OuroMarks<OuroParagraphMark> paragraphMarks;
    private final OuroTextRange range;
    private final boolean replaceComposition;
    private final String text;
    private final OuroMarks<OuroTextMark> textMarks;

    public static /* synthetic */ OuroInsertAction copy$default(OuroInsertAction ouroInsertAction, String str, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, OuroMarks ouroMarks, OuroMarks ouroMarks2, boolean z, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ouroInsertAction.text;
        }
        if ((i & 2) != 0) {
            ouroTextRange = ouroInsertAction.range;
        }
        OuroTextRange ouroTextRange3 = ouroTextRange;
        if ((i & 4) != 0) {
            ouroTextRange2 = ouroInsertAction.compositionRange;
        }
        OuroTextRange ouroTextRange4 = ouroTextRange2;
        OuroMarks<OuroTextMark> ouroMarks3 = ouroMarks;
        if ((i & 8) != 0) {
            ouroMarks3 = ouroInsertAction.textMarks;
        }
        OuroMarks ouroMarks4 = ouroMarks3;
        OuroMarks<OuroParagraphMark> ouroMarks5 = ouroMarks2;
        if ((i & 16) != 0) {
            ouroMarks5 = ouroInsertAction.paragraphMarks;
        }
        OuroMarks ouroMarks6 = ouroMarks5;
        if ((i & 32) != 0) {
            z = ouroInsertAction.replaceComposition;
        }
        boolean z2 = z;
        CompletableDeferred<OuroState> completableDeferred2 = completableDeferred;
        if ((i & 64) != 0) {
            completableDeferred2 = ouroInsertAction.deferred;
        }
        return ouroInsertAction.copy(str, ouroTextRange3, ouroTextRange4, ouroMarks4, ouroMarks6, z2, completableDeferred2);
    }

    public final String component1() {
        return this.text;
    }

    public final OuroTextRange component2() {
        return this.range;
    }

    public final OuroTextRange component3() {
        return this.compositionRange;
    }

    public final OuroMarks<OuroTextMark> component4() {
        return this.textMarks;
    }

    public final OuroMarks<OuroParagraphMark> component5() {
        return this.paragraphMarks;
    }

    public final boolean component6() {
        return this.replaceComposition;
    }

    public final CompletableDeferred<OuroState> component7() {
        return this.deferred;
    }

    public final OuroInsertAction copy(String str, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroParagraphMark> ouroMarks2, boolean z, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "paragraphMarks");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroInsertAction(str, ouroTextRange, ouroTextRange2, ouroMarks, ouroMarks2, z, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroInsertAction) {
            OuroInsertAction ouroInsertAction = (OuroInsertAction) obj;
            return Intrinsics.areEqual(this.text, ouroInsertAction.text) && Intrinsics.areEqual(this.range, ouroInsertAction.range) && Intrinsics.areEqual(this.compositionRange, ouroInsertAction.compositionRange) && Intrinsics.areEqual(this.textMarks, ouroInsertAction.textMarks) && Intrinsics.areEqual(this.paragraphMarks, ouroInsertAction.paragraphMarks) && this.replaceComposition == ouroInsertAction.replaceComposition && Intrinsics.areEqual(this.deferred, ouroInsertAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.text.hashCode() * 31) + (this.range == null ? 0 : this.range.hashCode())) * 31) + (this.compositionRange != null ? this.compositionRange.hashCode() : 0)) * 31) + this.textMarks.hashCode()) * 31) + this.paragraphMarks.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.replaceComposition)) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        String str = this.text;
        OuroTextRange ouroTextRange = this.range;
        OuroTextRange ouroTextRange2 = this.compositionRange;
        OuroMarks<OuroTextMark> ouroMarks = this.textMarks;
        OuroMarks<OuroParagraphMark> ouroMarks2 = this.paragraphMarks;
        boolean z = this.replaceComposition;
        return "OuroInsertAction(text=" + str + ", range=" + ouroTextRange + ", compositionRange=" + ouroTextRange2 + ", textMarks=" + ouroMarks + ", paragraphMarks=" + ouroMarks2 + ", replaceComposition=" + z + ", deferred=" + this.deferred + ")";
    }

    public OuroInsertAction(String text, OuroTextRange range, OuroTextRange compositionRange, OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroParagraphMark> ouroMarks2, boolean replaceComposition, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "paragraphMarks");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.text = text;
        this.range = range;
        this.compositionRange = compositionRange;
        this.textMarks = ouroMarks;
        this.paragraphMarks = ouroMarks2;
        this.replaceComposition = replaceComposition;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroInsertAction(String str, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, OuroMarks ouroMarks, OuroMarks ouroMarks2, boolean z, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : ouroTextRange, (i & 4) != 0 ? null : ouroTextRange2, (i & 8) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks, (i & 16) != 0 ? OuroMarks.Empty.INSTANCE.getParagraphMarks() : ouroMarks2, (i & 32) != 0 ? false : z, (i & 64) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final String getText() {
        return this.text;
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    public final OuroTextRange getCompositionRange() {
        return this.compositionRange;
    }

    public final OuroMarks<OuroTextMark> getTextMarks() {
        return this.textMarks;
    }

    public final OuroMarks<OuroParagraphMark> getParagraphMarks() {
        return this.paragraphMarks;
    }

    public final boolean getReplaceComposition() {
        return this.replaceComposition;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }

    public /* synthetic */ OuroInsertAction(String str, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, List list, List list2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, ouroTextRange, (i & 4) != 0 ? null : ouroTextRange2, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt.emptyList() : list2, (i & 32) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroInsertAction(String insert, OuroTextRange range, OuroTextRange compositionRange, List<? extends OuroTextMark> list, List<? extends OuroParagraphMark> list2, boolean replaceComposition) {
        this(insert, range, compositionRange, new OuroMarks(CollectionsKt.toList(list)), new OuroMarks(CollectionsKt.toList(list2)), replaceComposition, null, 64, null);
        Intrinsics.checkNotNullParameter(insert, "insert");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(list, "textMarks");
        Intrinsics.checkNotNullParameter(list2, "paragraphMarks");
    }
}