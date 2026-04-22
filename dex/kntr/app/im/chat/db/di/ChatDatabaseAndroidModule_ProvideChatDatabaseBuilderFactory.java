package kntr.app.im.chat.db.di;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.db.ChatDatabaseBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;

/* compiled from: ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "applicationProvider", "Ljavax/inject/Provider;", "Landroid/app/Application;", "pathProvider", "Lkotlinx/io/files/Path;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory implements Factory<ChatDatabaseBuilder> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Application> applicationProvider;
    private final Provider<Path> pathProvider;

    public ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory(Provider<Application> provider, Provider<Path> provider2) {
        Intrinsics.checkNotNullParameter(provider, "applicationProvider");
        Intrinsics.checkNotNullParameter(provider2, "pathProvider");
        this.applicationProvider = provider;
        this.pathProvider = provider2;
    }

    public ChatDatabaseBuilder get() {
        Companion companion = Companion;
        Application application = this.applicationProvider.get();
        Intrinsics.checkNotNullExpressionValue(application, "get(...)");
        Path path = this.pathProvider.get();
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return companion.provideChatDatabaseBuilder(application, path);
    }

    /* compiled from: ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/db/di/ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory;", "applicationProvider", "Ljavax/inject/Provider;", "Landroid/app/Application;", "pathProvider", "Lkotlinx/io/files/Path;", "provideChatDatabaseBuilder", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "application", "path", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory create(Provider<Application> provider, Provider<Path> provider2) {
            Intrinsics.checkNotNullParameter(provider, "applicationProvider");
            Intrinsics.checkNotNullParameter(provider2, "pathProvider");
            return new ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory(provider, provider2);
        }

        @JvmStatic
        public final ChatDatabaseBuilder provideChatDatabaseBuilder(Application application, Path path) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(path, "path");
            return ChatDatabaseAndroidModule.INSTANCE.provideChatDatabaseBuilder(application, path);
        }
    }

    @JvmStatic
    public static final ChatDatabaseAndroidModule_ProvideChatDatabaseBuilderFactory create(Provider<Application> provider, Provider<Path> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final ChatDatabaseBuilder provideChatDatabaseBuilder(Application application, Path path) {
        return Companion.provideChatDatabaseBuilder(application, path);
    }
}