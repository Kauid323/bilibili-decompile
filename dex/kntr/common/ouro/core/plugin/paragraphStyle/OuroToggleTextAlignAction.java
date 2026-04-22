package kntr.common.ouro.core.plugin.paragraphStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroTextAlignMark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroParagraphStyleAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAlignAction;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleAction;", "mark", "Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;)V", "getMark", "()Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAlignCenterAction;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAlignEndAction;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAlignJustifyAction;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAlignStartAction;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class OuroToggleTextAlignAction implements OuroParagraphStyleAction {
    private final OuroTextAlignMark mark;

    public /* synthetic */ OuroToggleTextAlignAction(OuroTextAlignMark ouroTextAlignMark, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroTextAlignMark);
    }

    private OuroToggleTextAlignAction(OuroTextAlignMark mark) {
        this.mark = mark;
    }

    public final OuroTextAlignMark getMark() {
        return this.mark;
    }
}