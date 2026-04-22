package kntr.app.im.chat.db.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kntr.app.im.chat.db.ChatDatabaseBuilder;
import kntr.app.im.chat.db.ChatDatabaseConfigurationSet;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.ChatDatabaseProviderImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDatabaseConfigModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseConfigModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideConfiguredDatabase", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "databaseBuilder", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "configurer", "Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", "accountStore", "Lkntr/base/account/KAccountStore;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {ChatDatabaseBuilderModule.class}, subcomponents = {})
public final class ChatDatabaseConfigModule {
    public static final ChatDatabaseConfigModule INSTANCE = new ChatDatabaseConfigModule();

    private ChatDatabaseConfigModule() {
    }

    @Provides
    @Singleton
    public final ChatDatabaseProvider provideConfiguredDatabase(ChatDatabaseBuilder databaseBuilder, ChatDatabaseConfigurationSet configurer, KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(databaseBuilder, "databaseBuilder");
        Intrinsics.checkNotNullParameter(configurer, "configurer");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        return new ChatDatabaseProviderImpl(accountStore, databaseBuilder, configurer);
    }
}