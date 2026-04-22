package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageTime.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/ui/widget/ChatTimeLabelBuilderImpl;", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "<init>", "()V", "ChatTimeLabel", RoomRecommendViewModel.EMPTY_CURSOR, "timeDescription", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatTimeLabelBuilderImpl implements ChatTimeLabelBuilder {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder
    public void ChatTimeLabel(String timeDescription, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(timeDescription, "timeDescription");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        $composer.startReplaceGroup(938300927);
        ComposerKt.sourceInformation($composer, "C(ChatTimeLabel)N(timeDescription,modifier)30@1029L102:MessageTime.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(938300927, $changed, -1, "kntr.app.im.chat.ui.widget.ChatTimeLabelBuilderImpl.ChatTimeLabel (MessageTime.kt:29)");
        }
        MessageTimeKt.MessageTime(timeDescription, modifier, $composer, ($changed & 14) | ($changed & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }
}