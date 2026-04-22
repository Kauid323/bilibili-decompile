package kntr.common.ouro.core.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroBoxContainerMark;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kotlin.Metadata;

/* compiled from: OuroLayoutUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\"\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DividerDefaultPaddingMark", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding;", "DividerDefaultSizeMark", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$FillWidth;", "DividerDefaultMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroBoxContainerMark;", "getDividerDefaultMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "UnrecognizedCardDefaultPaddingMark", "UnrecognizedCardDefaultSizeMark", "UnrecognizedCardDefaultMarks", "getUnrecognizedCardDefaultMarks", "DEFAULT_BACKGROUND_HEIGHT_DP", "", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroLayoutUtilsKt {
    public static final float DEFAULT_BACKGROUND_HEIGHT_DP = 12.0f;
    private static final OuroDrawableMark.Padding DividerDefaultPaddingMark = new OuroDrawableMark.Padding(4.0f, 12.0f);
    private static final OuroDrawableMark.Size.FillWidth DividerDefaultSizeMark = new OuroDrawableMark.Size.FillWidth((DividerDefaultPaddingMark.getTop() + 1.0f) + DividerDefaultPaddingMark.getBottom());
    private static final OuroMarks<OuroBoxContainerMark> DividerDefaultMarks = new OuroMarks<>(DividerDefaultPaddingMark, DividerDefaultSizeMark);
    private static final OuroDrawableMark.Padding UnrecognizedCardDefaultPaddingMark = new OuroDrawableMark.Padding(4.0f, 12.0f);
    private static final OuroDrawableMark.Size.FillWidth UnrecognizedCardDefaultSizeMark = new OuroDrawableMark.Size.FillWidth((UnrecognizedCardDefaultPaddingMark.getTop() + 60.0f) + UnrecognizedCardDefaultPaddingMark.getBottom());
    private static final OuroMarks<OuroBoxContainerMark> UnrecognizedCardDefaultMarks = new OuroMarks<>(UnrecognizedCardDefaultPaddingMark, UnrecognizedCardDefaultSizeMark);

    public static final OuroMarks<OuroBoxContainerMark> getDividerDefaultMarks() {
        return DividerDefaultMarks;
    }

    public static final OuroMarks<OuroBoxContainerMark> getUnrecognizedCardDefaultMarks() {
        return UnrecognizedCardDefaultMarks;
    }
}