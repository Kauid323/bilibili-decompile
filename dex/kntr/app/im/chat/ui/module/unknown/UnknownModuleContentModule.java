package kntr.app.im.chat.ui.module.unknown;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultUnknownModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/ui/module/unknown/UnknownModuleContentModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideUnknownModuleBuilder", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class UnknownModuleContentModule {
    public static final int $stable = 0;
    public static final UnknownModuleContentModule INSTANCE = new UnknownModuleContentModule();

    private UnknownModuleContentModule() {
    }

    @Provides
    @IntoMap
    @StringKey("UnknownModule")
    public final ChatMsgModuleBuilder<MsgModule> provideUnknownModuleBuilder(ChatActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        return new UnknownModuleBuilder(actionHandler);
    }
}