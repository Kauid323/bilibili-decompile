package kntr.app.im.chat.ui.builder;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatTimeLabelBuilder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", RoomRecommendViewModel.EMPTY_CURSOR, "ChatTimeLabel", RoomRecommendViewModel.EMPTY_CURSOR, "timeDescription", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatTimeLabelBuilder {
    void ChatTimeLabel(String str, Modifier modifier, Composer composer, int i);

    /* compiled from: ChatTimeLabelBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ComposeDefaultImpls {
        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ChatTimeLabel_default$lambda$0(String str, Modifier modifier, ChatTimeLabelBuilder chatTimeLabelBuilder, int i, int i2, Composer composer, int i3) {
            ChatTimeLabel$default(str, modifier, chatTimeLabelBuilder, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            return Unit.INSTANCE;
        }

        public static final void ChatTimeLabel$default(final String timeDescription, Modifier modifier, final ChatTimeLabelBuilder $this$, Composer $composer, final int $changed, final int i) {
            Intrinsics.checkNotNullParameter(timeDescription, "timeDescription");
            Intrinsics.checkNotNullParameter($this$, "$this$");
            Composer $composer2 = $composer.startRestartGroup(462044467);
            ComposerKt.sourceInformation($composer2, "C(ChatTimeLabel$default)N(timeDescription,modifier):ChatTimeLabelBuilder.kt#fhhntl");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer2.changed(timeDescription) ? 4 : 2;
            }
            int i2 = i & 2;
            if (i2 != 0) {
                $dirty |= 48;
            } else if (($changed & 48) == 0) {
                $dirty |= $composer2.changed(modifier) ? 32 : 16;
            }
            if (($changed & 384) == 0) {
                $dirty |= ($changed & 512) == 0 ? $composer2.changed($this$) : $composer2.changedInstance($this$) ? 256 : 128;
            }
            if ($composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                if (i2 != 0) {
                    modifier = (Modifier) Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(462044467, $dirty, -1, "kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder.ComposeDefaultImpls.ChatTimeLabel$default (ChatTimeLabelBuilder.kt:-1)");
                }
                $this$.ChatTimeLabel(timeDescription, modifier, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
            }
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier2 = modifier;
                endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder$ComposeDefaultImpls$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ChatTimeLabel_default$lambda$0;
                        ChatTimeLabel_default$lambda$0 = ChatTimeLabelBuilder.ComposeDefaultImpls.ChatTimeLabel_default$lambda$0(timeDescription, modifier2, $this$, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return ChatTimeLabel_default$lambda$0;
                    }
                });
            }
        }
    }
}