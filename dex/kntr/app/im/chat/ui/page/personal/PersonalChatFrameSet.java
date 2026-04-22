package kntr.app.im.chat.ui.page.personal;

import dagger.Module;
import kntr.app.im.chat.ui.frame.ChatBubbleFrameModule;
import kntr.app.im.chat.ui.frame.PushEmptyFrameModule;
import kntr.app.im.chat.ui.frame.RoundCornerFrameModule;
import kntr.app.im.chat.ui.frame.SystemHintFrameModule;
import kntr.app.im.chat.ui.frame.UnknownFrameUIModule;
import kntr.app.im.chat.ui.page.CommonMsgFrameSet;
import kntr.app.im.chat.ui.widget.DefaultChatTimeLabelBuilderModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: PersonalChatFrameSet.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/ui/page/personal/PersonalChatFrameSet;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {CommonMsgFrameSet.class, ChatBubbleFrameModule.class, PushEmptyFrameModule.class, RoundCornerFrameModule.class, SystemHintFrameModule.class, DefaultChatTimeLabelBuilderModule.class, UnknownFrameUIModule.class}, subcomponents = {})
public final class PersonalChatFrameSet {
    public static final int $stable = 0;
    public static final PersonalChatFrameSet INSTANCE = new PersonalChatFrameSet();

    private PersonalChatFrameSet() {
    }
}