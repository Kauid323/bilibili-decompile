package kntr.common.paragraph.input;

import dagger.assisted.AssistedFactory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: RichTextStateMachine.kt */
@AssistedFactory
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/input/RichTextStateMachineFactory;", "", "create", "Lkntr/common/paragraph/input/RichTextStateMachine;", "init", "Lkntr/common/paragraph/input/RichTextContent;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface RichTextStateMachineFactory {
    RichTextStateMachine create(RichTextContent richTextContent);
}