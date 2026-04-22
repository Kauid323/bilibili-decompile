package kntr.app.im.chat.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.di.module.assistant.Assistant;
import kntr.app.im.chat.di.module.assistant.AssistantChatInfoModule;
import kntr.app.im.chat.di.module.assistant.AssistantFetchModule;
import kntr.app.im.chat.di.module.assistant.AssistantNotifyModule;
import kntr.app.im.chat.di.module.assistant.AssistantSessionIdModule;
import kntr.app.im.chat.di.module.common.MessageGroupByMinuteModule;
import kntr.app.im.chat.di.module.common.MsgFrameModuleSet;
import kntr.app.im.chat.di.module.common.MsgModuleTransformerSet;
import kntr.app.im.chat.stateMachine.AssistantChatStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: AssistantChatComponent.kt */
@Subcomponent(modules = {CommonChatModule.class, AssistantSessionIdModule.class, AssistantNotifyModule.class, MsgFrameModuleSet.class, MsgModuleTransformerSet.class, AssistantChatInfoModule.class, MessageGroupByMinuteModule.class, AssistantFetchModule.class})
@ChatScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/AssistantChatComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "assistantChatStateMachine", "Lkntr/app/im/chat/stateMachine/AssistantChatStateMachine;", "Builder", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AssistantChatComponent {

    /* compiled from: AssistantChatComponent.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/AssistantChatComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, "bindSessionId", ReportBuildInParam.ID, "Lkntr/app/im/chat/di/module/assistant/Assistant;", ReportBuildInParam.BUILD, "Lkntr/app/im/chat/di/AssistantChatComponent;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        Builder bindSessionId(@BindsInstance Assistant assistant);

        AssistantChatComponent build();
    }

    AssistantChatStateMachine assistantChatStateMachine();
}