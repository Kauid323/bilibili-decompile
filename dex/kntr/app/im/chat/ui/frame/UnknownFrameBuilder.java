package kntr.app.im.chat.ui.frame;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.UnknownFrame;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: UnknownFrame.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/ui/frame/UnknownFrameBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/UnknownFrame;", "<init>", "()V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "msgFrame", "msgContent", "Lkntr/app/im/chat/core/model/EntityMessage;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/core/model/UnknownFrame;Lkntr/app/im/chat/core/model/EntityMessage;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnknownFrameBuilder implements ChatMsgFrameBuilder<UnknownFrame> {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder
    public KClass<UnknownFrame> getAcceptClass() {
        return Reflection.getOrCreateKotlinClass(UnknownFrame.class);
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder
    public void Content(UnknownFrame msgFrame, EntityMessage msgContent, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        Intrinsics.checkNotNullParameter(msgContent, "msgContent");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        $composer.startReplaceGroup(-191243437);
        ComposerKt.sourceInformation($composer, "C(Content)N(msgFrame,msgContent,modifier)49@1777L40:UnknownFrame.kt#wmjton");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-191243437, $changed, -1, "kntr.app.im.chat.ui.frame.UnknownFrameBuilder.Content (UnknownFrame.kt:48)");
        }
        UnknownFrameKt.UnknownFrameContent(modifier, $composer, ($changed >> 6) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }
}