package kntr.app.im.chat.db.di;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.db.ChatDatabaseBuilder;
import kntr.app.im.chat.db.ChatDatabaseConfigurationSet;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "databaseBuilderProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "configurerProvider", "Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory implements Factory<ChatDatabaseProvider> {
    public static final Companion Companion = new Companion(null);
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<ChatDatabaseConfigurationSet> configurerProvider;
    private final Provider<ChatDatabaseBuilder> databaseBuilderProvider;

    public ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory(Provider<ChatDatabaseBuilder> provider, Provider<ChatDatabaseConfigurationSet> provider2, Provider<KAccountStore> provider3) {
        Intrinsics.checkNotNullParameter(provider, "databaseBuilderProvider");
        Intrinsics.checkNotNullParameter(provider2, "configurerProvider");
        Intrinsics.checkNotNullParameter(provider3, "accountStoreProvider");
        this.databaseBuilderProvider = provider;
        this.configurerProvider = provider2;
        this.accountStoreProvider = provider3;
    }

    public ChatDatabaseProvider get() {
        Companion companion = Companion;
        ChatDatabaseBuilder chatDatabaseBuilder = this.databaseBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatDatabaseBuilder, "get(...)");
        ChatDatabaseConfigurationSet chatDatabaseConfigurationSet = this.configurerProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatDatabaseConfigurationSet, "get(...)");
        KAccountStore kAccountStore = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(kAccountStore, "get(...)");
        return companion.provideConfiguredDatabase(chatDatabaseBuilder, chatDatabaseConfigurationSet, kAccountStore);
    }

    /* compiled from: ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/db/di/ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory;", "databaseBuilderProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "configurerProvider", "Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "provideConfiguredDatabase", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "databaseBuilder", "configurer", "accountStore", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory create(Provider<ChatDatabaseBuilder> provider, Provider<ChatDatabaseConfigurationSet> provider2, Provider<KAccountStore> provider3) {
            Intrinsics.checkNotNullParameter(provider, "databaseBuilderProvider");
            Intrinsics.checkNotNullParameter(provider2, "configurerProvider");
            Intrinsics.checkNotNullParameter(provider3, "accountStoreProvider");
            return new ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ChatDatabaseProvider provideConfiguredDatabase(ChatDatabaseBuilder databaseBuilder, ChatDatabaseConfigurationSet configurer, KAccountStore accountStore) {
            Intrinsics.checkNotNullParameter(databaseBuilder, "databaseBuilder");
            Intrinsics.checkNotNullParameter(configurer, "configurer");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            return ChatDatabaseConfigModule.INSTANCE.provideConfiguredDatabase(databaseBuilder, configurer, accountStore);
        }
    }

    @JvmStatic
    public static final ChatDatabaseConfigModule_ProvideConfiguredDatabaseFactory create(Provider<ChatDatabaseBuilder> provider, Provider<ChatDatabaseConfigurationSet> provider2, Provider<KAccountStore> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ChatDatabaseProvider provideConfiguredDatabase(ChatDatabaseBuilder databaseBuilder, ChatDatabaseConfigurationSet configurer, KAccountStore accountStore) {
        return Companion.provideConfiguredDatabase(databaseBuilder, configurer, accountStore);
    }
}