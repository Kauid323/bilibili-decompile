package kntr.app.im.chat.sticker.service;

import dagger.internal.Factory;
import io.ktor.client.HttpClient;
import javax.inject.Provider;
import kntr.app.im.chat.sticker.db.StickerDatabase;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickerManagerServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/sticker/service/StickerManagerServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/sticker/service/StickerManagerServiceImpl;", "stickerDatabaseProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "clientProvider", "Lio/ktor/client/HttpClient;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerServiceImpl_Factory implements Factory<StickerManagerServiceImpl> {
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<HttpClient> clientProvider;
    private final Provider<StickerDatabase> stickerDatabaseProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public StickerManagerServiceImpl_Factory(Provider<StickerDatabase> provider, Provider<HttpClient> provider2, Provider<KAccountStore> provider3) {
        Intrinsics.checkNotNullParameter(provider, "stickerDatabaseProvider");
        Intrinsics.checkNotNullParameter(provider2, "clientProvider");
        Intrinsics.checkNotNullParameter(provider3, "accountStoreProvider");
        this.stickerDatabaseProvider = provider;
        this.clientProvider = provider2;
        this.accountStoreProvider = provider3;
    }

    public StickerManagerServiceImpl get() {
        Companion companion = Companion;
        StickerDatabase stickerDatabase = this.stickerDatabaseProvider.get();
        Intrinsics.checkNotNullExpressionValue(stickerDatabase, "get(...)");
        HttpClient httpClient = this.clientProvider.get();
        Intrinsics.checkNotNullExpressionValue(httpClient, "get(...)");
        KAccountStore kAccountStore = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(kAccountStore, "get(...)");
        return companion.newInstance(stickerDatabase, httpClient, kAccountStore);
    }

    /* compiled from: StickerManagerServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/sticker/service/StickerManagerServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/sticker/service/StickerManagerServiceImpl_Factory;", "stickerDatabaseProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "clientProvider", "Lio/ktor/client/HttpClient;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "newInstance", "Lkntr/app/im/chat/sticker/service/StickerManagerServiceImpl;", "stickerDatabase", "client", "accountStore", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StickerManagerServiceImpl_Factory create(Provider<StickerDatabase> provider, Provider<HttpClient> provider2, Provider<KAccountStore> provider3) {
            Intrinsics.checkNotNullParameter(provider, "stickerDatabaseProvider");
            Intrinsics.checkNotNullParameter(provider2, "clientProvider");
            Intrinsics.checkNotNullParameter(provider3, "accountStoreProvider");
            return new StickerManagerServiceImpl_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final StickerManagerServiceImpl newInstance(StickerDatabase stickerDatabase, HttpClient client, KAccountStore accountStore) {
            Intrinsics.checkNotNullParameter(stickerDatabase, "stickerDatabase");
            Intrinsics.checkNotNullParameter(client, "client");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            return new StickerManagerServiceImpl(stickerDatabase, client, accountStore);
        }
    }

    @JvmStatic
    public static final StickerManagerServiceImpl_Factory create(Provider<StickerDatabase> provider, Provider<HttpClient> provider2, Provider<KAccountStore> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final StickerManagerServiceImpl newInstance(StickerDatabase stickerDatabase, HttpClient client, KAccountStore accountStore) {
        return Companion.newInstance(stickerDatabase, client, accountStore);
    }
}