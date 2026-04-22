package kntr.app.im.chat.ui;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.list.DefaultListModifierKt;
import kntr.common.trio.systemui.ScrollToTopKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ChatMessageList.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"ChatMessageList", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "Lkntr/app/im/chat/core/model/ChatPageData;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "frameBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/core/model/ChatPageData;Landroidx/compose/foundation/lazy/LazyListState;Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMessageListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMessageList$lambda$1(ChatPageData chatPageData, LazyListState lazyListState, ChatMsgFrameBuilderProvider chatMsgFrameBuilderProvider, PaddingValues paddingValues, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ChatMessageList(chatPageData, lazyListState, chatMsgFrameBuilderProvider, paddingValues, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ChatMessageList(final ChatPageData pageData, final LazyListState listState, final ChatMsgFrameBuilderProvider frameBuilderProvider, final PaddingValues contentPadding, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(frameBuilderProvider, "frameBuilderProvider");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Composer $composer2 = $composer.startRestartGroup(-756551216);
        ComposerKt.sourceInformation($composer2, "C(ChatMessageList)N(pageData,listState,frameBuilderProvider,contentPadding,modifier)26@946L28,27@992L43,32@1188L866,23@877L1177:ChatMessageList.kt#f7dpja");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(pageData) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(listState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(frameBuilderProvider) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-756551216, $dirty, -1, "kntr.app.im.chat.ui.ChatMessageList (ChatMessageList.kt:22)");
            }
            Modifier defaultVerticalScrollableEffects = DefaultListModifierKt.defaultVerticalScrollableEffects(ScrollToTopKt.preferScrollToTop(modifier3, (ScrollableState) listState, (Flow) null, $composer2, (($dirty >> 12) & 14) | ($dirty & 112), 2), (ScrollableState) listState, $composer2, $dirty & 112);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer2, -1196227950, "CC(remember):ChatMessageList.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.ChatMessageListKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit ChatMessageList$lambda$0$0;
                        ChatMessageList$lambda$0$0 = ChatMessageListKt.ChatMessageList$lambda$0$0(ChatPageData.this, frameBuilderProvider, (LazyListScope) obj);
                        return ChatMessageList$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(defaultVerticalScrollableEffects, listState, contentPadding, true, top, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, ($dirty & 112) | 27648 | (($dirty >> 3) & 896), 480);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.ChatMessageListKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatMessageList$lambda$1;
                    ChatMessageList$lambda$1 = ChatMessageListKt.ChatMessageList$lambda$1(ChatPageData.this, listState, frameBuilderProvider, contentPadding, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatMessageList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMessageList$lambda$0$0(ChatPageData $pageData, final ChatMsgFrameBuilderProvider $frameBuilderProvider, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        Iterable $this$forEach$iv = CollectionsKt.reversed($pageData.getMessageGroups());
        for (Object element$iv : $this$forEach$iv) {
            final MessageGroup group = (MessageGroup) element$iv;
            Iterable $this$forEach$iv2 = CollectionsKt.reversed(group.getMessages());
            for (Object element$iv2 : $this$forEach$iv2) {
                final EntityMessage message = (EntityMessage) element$iv2;
                LazyListScope.-CC.item$default($this$LazyColumn, message.getItemKey().toString(), (Object) null, ComposableLambdaKt.composableLambdaInstance(-483780045, true, new Function3() { // from class: kntr.app.im.chat.ui.ChatMessageListKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ChatMessageList$lambda$0$0$0$0$0;
                        ChatMessageList$lambda$0$0$0$0$0 = ChatMessageListKt.ChatMessageList$lambda$0$0$0$0$0(ChatMsgFrameBuilderProvider.this, message, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ChatMessageList$lambda$0$0$0$0$0;
                    }
                }), 2, (Object) null);
            }
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-724125658, true, new Function3() { // from class: kntr.app.im.chat.ui.ChatMessageListKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ChatMessageList$lambda$0$0$0$1;
                    ChatMessageList$lambda$0$0$0$1 = ChatMessageListKt.ChatMessageList$lambda$0$0$0$1(MessageGroup.this, $frameBuilderProvider, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatMessageList$lambda$0$0$0$1;
                }
            }), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMessageList$lambda$0$0$0$0$0(ChatMsgFrameBuilderProvider $frameBuilderProvider, EntityMessage $message, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C40@1493L141,43@1668L59:ChatMessageList.kt#f7dpja");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-483780045, $changed, -1, "kntr.app.im.chat.ui.ChatMessageList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatMessageList.kt:39)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1056153056, "CC(remember):ChatMessageList.kt#9igjgp");
            boolean invalid$iv = $composer.changed($frameBuilderProvider) | $composer.changed($message);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = $frameBuilderProvider.get(Reflection.getOrCreateKotlinClass($message.getMsgFrame().getClass()));
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ChatMsgFrameBuilder frameBuilder = (ChatMsgFrameBuilder) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ChatMsgFrameBuilder.ComposeDefaultImpls.Content$default($message.getMsgFrame(), $message, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), frameBuilder, $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMessageList$lambda$0$0$0$1(MessageGroup $group, ChatMsgFrameBuilderProvider $frameBuilderProvider, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C48@1875L149:ChatMessageList.kt#f7dpja");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-724125658, $changed, -1, "kntr.app.im.chat.ui.ChatMessageList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatMessageList.kt:48)");
            }
            ChatTimeLabelBuilder.ComposeDefaultImpls.ChatTimeLabel$default($group.getTimeDescription(), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $frameBuilderProvider.getTimeLabelBuilder(), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}