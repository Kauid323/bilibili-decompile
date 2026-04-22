package kntr.app.im.chat.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.di.module.common.MessageGroupByMinuteModule;
import kntr.app.im.chat.di.module.common.MsgFrameModuleSet;
import kntr.app.im.chat.di.module.common.MsgModuleTransformerSet;
import kntr.app.im.chat.di.module.personal.PersonalCharDraftModule;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.im.chat.di.module.personal.PersonalChatInfoModule;
import kntr.app.im.chat.di.module.personal.PersonalConversationModule;
import kntr.app.im.chat.di.module.personal.PersonalSendModule;
import kntr.app.im.chat.di.module.personal.PersonalSessionIdModule;
import kntr.app.im.chat.di.module.personal.PersonalSessionSettingModule;
import kntr.app.im.chat.stateMachine.PersonalChatStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: PersonalChatComponent.kt */
@Subcomponent(modules = {CommonChatModule.class, PersonalConversationModule.class, PersonalSessionIdModule.class, PersonalSessionSettingModule.class, MsgFrameModuleSet.class, MsgModuleTransformerSet.class, PersonalChatInfoModule.class, PersonalCharDraftModule.class, PersonalSendModule.class, MessageGroupByMinuteModule.class})
@ChatScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/PersonalChatComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "privateChatStateMachine", "Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine;", "Builder", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PersonalChatComponent {

    /* compiled from: PersonalChatComponent.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/PersonalChatComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, "bindSessionId", ReportBuildInParam.ID, "Lkntr/app/im/chat/di/module/personal/PersonalChat;", ReportBuildInParam.BUILD, "Lkntr/app/im/chat/di/PersonalChatComponent;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        Builder bindSessionId(@BindsInstance PersonalChat personalChat);

        PersonalChatComponent build();
    }

    PersonalChatStateMachine privateChatStateMachine();
}