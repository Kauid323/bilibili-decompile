package kntr.common.ouro.core.plugin.paragraphStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroParagraphStyleAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleParagraphTypeAction;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleAction;", "type", "Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "<init>", "(Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;)V", "getType", "()Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleH1Action;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleH2Action;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleH3Action;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAction;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class OuroToggleParagraphTypeAction implements OuroParagraphStyleAction {
    private final ParagraphType type;

    public /* synthetic */ OuroToggleParagraphTypeAction(ParagraphType paragraphType, DefaultConstructorMarker defaultConstructorMarker) {
        this(paragraphType);
    }

    private OuroToggleParagraphTypeAction(ParagraphType type) {
        this.type = type;
    }

    public final ParagraphType getType() {
        return this.type;
    }
}