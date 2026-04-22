package kntr.app.tribee.publish.draft;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;

/* compiled from: TribeeDraftServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/draft/TribeeDraftServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/draft/TribeeDraftServiceImpl;", "accountStoreProvider", "Ljavax/inject/Provider;", "Lkntr/base/account/KAccountStore;", "baseDirProvider", "Lkotlinx/io/files/Path;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDraftServiceImpl_Factory implements Factory<TribeeDraftServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<Path> baseDirProvider;

    public TribeeDraftServiceImpl_Factory(Provider<KAccountStore> provider, Provider<Path> provider2) {
        Intrinsics.checkNotNullParameter(provider, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider2, "baseDirProvider");
        this.accountStoreProvider = provider;
        this.baseDirProvider = provider2;
    }

    public TribeeDraftServiceImpl get() {
        Companion companion = Companion;
        Object obj = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.baseDirProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((KAccountStore) obj, (Path) obj2);
    }

    /* compiled from: TribeeDraftServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/publish/draft/TribeeDraftServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/draft/TribeeDraftServiceImpl_Factory;", "accountStoreProvider", "Ljavax/inject/Provider;", "Lkntr/base/account/KAccountStore;", "baseDirProvider", "Lkotlinx/io/files/Path;", "newInstance", "Lkntr/app/tribee/publish/draft/TribeeDraftServiceImpl;", "accountStore", "baseDir", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeDraftServiceImpl_Factory create(Provider<KAccountStore> provider, Provider<Path> provider2) {
            Intrinsics.checkNotNullParameter(provider, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider2, "baseDirProvider");
            return new TribeeDraftServiceImpl_Factory(provider, provider2);
        }

        @JvmStatic
        public final TribeeDraftServiceImpl newInstance(KAccountStore accountStore, Path baseDir) {
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            Intrinsics.checkNotNullParameter(baseDir, "baseDir");
            return new TribeeDraftServiceImpl(accountStore, baseDir);
        }
    }

    @JvmStatic
    public static final TribeeDraftServiceImpl_Factory create(Provider<KAccountStore> provider, Provider<Path> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final TribeeDraftServiceImpl newInstance(KAccountStore accountStore, Path baseDir) {
        return Companion.newInstance(accountStore, baseDir);
    }
}