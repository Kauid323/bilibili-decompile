package kntr.app.im.chat.ui.page.personal;

import androidx.compose.ui.unit.Density;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.di.ChatMsgModuleScope;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.upgrade.UpgradeAnswerDialogDisplayer;
import kntr.app.im.chat.ui.utils.ChatPageController;
import kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: PersonalChatPageComponent.kt */
@Subcomponent(modules = {PersonalChatModuleSet.class, PersonalChatFrameSet.class})
@ChatMsgModuleScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/page/personal/PersonalChatPageComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "chatMsgFrameBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "upgradeAnswerDialogDisplayer", "Lkntr/app/im/chat/ui/upgrade/UpgradeAnswerDialogDisplayer;", "Builder", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PersonalChatPageComponent {

    /* compiled from: PersonalChatPageComponent.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/page/personal/PersonalChatPageComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, "bindDensity", "density", "Landroidx/compose/ui/unit/Density;", "bindActionHandler", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "bindPageController", "controller", "Lkntr/app/im/chat/ui/utils/ChatPageController;", "bindReporter", "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "bindPictureLifecycleHandle", "pictureLifecycleHandle", "Lkntr/app/im/chat/ui/utils/PictureLifecycleKeyHandle;", ReportBuildInParam.BUILD, "Lkntr/app/im/chat/ui/page/personal/PersonalChatPageComponent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        Builder bindActionHandler(@BindsInstance ChatActionHandler chatActionHandler);

        Builder bindDensity(@BindsInstance Density density);

        Builder bindPageController(@BindsInstance ChatPageController chatPageController);

        Builder bindPictureLifecycleHandle(@BindsInstance PictureLifecycleKeyHandle pictureLifecycleKeyHandle);

        Builder bindReporter(@BindsInstance ChatReporter chatReporter);

        PersonalChatPageComponent build();
    }

    ChatMsgFrameBuilderProvider chatMsgFrameBuilderProvider();

    UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer();
}