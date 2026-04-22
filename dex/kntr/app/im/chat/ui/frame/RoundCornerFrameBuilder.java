package kntr.app.im.chat.ui.frame;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.bilibili.framework.exposure.core.transformer.ExposureAreaVisibilityTransformerKt;
import com.bilibili.framework.exposure.core.transformer.ExposureVisibleDurationTransformerKt;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.frame.rounded.RoundedCornerFrame;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: RoundCornerFrame.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/ui/frame/RoundCornerFrameBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "chatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "<init>", "(Lkntr/app/im/chat/ui/ChatActionHandler;Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;Lkntr/app/im/chat/ui/neuron/ChatReporter;)V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "msgFrame", "msgContent", "Lkntr/app/im/chat/core/model/EntityMessage;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame;Lkntr/app/im/chat/core/model/EntityMessage;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoundCornerFrameBuilder implements ChatMsgFrameBuilder<RoundedCornerFrame> {
    public static final int $stable = 0;
    private final ChatActionHandler actionHandler;
    private final ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider;
    private final ChatReporter reporter;

    @Inject
    public RoundCornerFrameBuilder(ChatActionHandler actionHandler, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, ChatReporter reporter) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(chatMsgModuleBuilderProvider, "chatMsgModuleBuilderProvider");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.actionHandler = actionHandler;
        this.chatMsgModuleBuilderProvider = chatMsgModuleBuilderProvider;
        this.reporter = reporter;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder
    public KClass<RoundedCornerFrame> getAcceptClass() {
        return Reflection.getOrCreateKotlinClass(RoundedCornerFrame.class);
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder
    public void Content(RoundedCornerFrame msgFrame, final EntityMessage msgContent, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        Intrinsics.checkNotNullParameter(msgContent, "msgContent");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        $composer.startReplaceGroup(-2111600117);
        ComposerKt.sourceInformation($composer, "C(Content)N(msgFrame,msgContent,modifier)90@3883L293,96@4208L249,81@3456L1076:RoundCornerFrame.kt#wmjton");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2111600117, $changed, -1, "kntr.app.im.chat.ui.frame.RoundCornerFrameBuilder.Content (RoundCornerFrame.kt:80)");
        }
        ChatActionHandler chatActionHandler = this.actionHandler;
        ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider = this.chatMsgModuleBuilderProvider;
        ComposerKt.sourceInformationMarkerStart($composer, -2023129968, "CC(remember):RoundCornerFrame.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameBuilder$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Flow Content$lambda$0$0;
                    Content$lambda$0$0 = RoundCornerFrameBuilder.Content$lambda$0$0((Flow) obj);
                    return Content$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Function1 function1 = (Function1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -2023119612, "CC(remember):RoundCornerFrame.kt#9igjgp");
        boolean invalid$iv = (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(this)) || ($changed & 3072) == 2048) | (((($changed & 112) ^ 48) > 32 && $composer.changed(msgContent)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameBuilder$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit Content$lambda$1$0;
                    Content$lambda$1$0 = RoundCornerFrameBuilder.Content$lambda$1$0(RoundCornerFrameBuilder.this, msgContent);
                    return Content$lambda$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        RoundCornerFrameKt.RoundCornerFrame(msgContent, msgFrame, chatActionHandler, chatMsgModuleBuilderProvider, ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(modifier, new ExposureEntry(function1, (Function0) it$iv2)), this.reporter, $composer, (($changed >> 3) & 14) | (($changed << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow Content$lambda$0$0(Flow v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Flow distinctUntilChanged = FlowKt.distinctUntilChanged(ExposureAreaVisibilityTransformerKt.noticeableWhenAreaPixelIsAtLeast(v, 1));
        Duration.Companion companion = Duration.Companion;
        return ExposureVisibleDurationTransformerKt.exposeIfNoticeableFor-HG0u8IE(distinctUntilChanged, DurationKt.toDuration(1, DurationUnit.SECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$0(RoundCornerFrameBuilder this$0, EntityMessage $msgContent) {
        this$0.reporter.reportMsgShow("msg", $msgContent.getTraceParams());
        return Unit.INSTANCE;
    }
}