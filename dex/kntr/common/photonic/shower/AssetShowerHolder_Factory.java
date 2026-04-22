package kntr.common.photonic.shower;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetShowerHolder_Factory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/photonic/shower/AssetShowerHolder_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/photonic/shower/AssetShowerHolder;", "showerSetProvider", "Ljavax/inject/Provider;", "", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetShowerHolder_Factory implements Factory<AssetShowerHolder> {
    private final Provider<Set<AssetShower<? extends Asset>>> showerSetProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AssetShowerHolder_Factory(Provider<Set<AssetShower<? extends Asset>>> provider) {
        Intrinsics.checkNotNullParameter(provider, "showerSetProvider");
        this.showerSetProvider = provider;
    }

    public AssetShowerHolder get() {
        Companion companion = Companion;
        Object obj = this.showerSetProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((Set) obj);
    }

    /* compiled from: AssetShowerHolder_Factory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b0\u0007H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\bH\u0007¨\u0006\u000e"}, d2 = {"Lkntr/common/photonic/shower/AssetShowerHolder_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/photonic/shower/AssetShowerHolder_Factory;", "showerSetProvider", "Ljavax/inject/Provider;", "", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "newInstance", "Lkntr/common/photonic/shower/AssetShowerHolder;", "showerSet", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssetShowerHolder_Factory create(Provider<Set<AssetShower<? extends Asset>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "showerSetProvider");
            return new AssetShowerHolder_Factory(provider);
        }

        @JvmStatic
        public final AssetShowerHolder newInstance(Set<? extends AssetShower<? extends Asset>> set) {
            Intrinsics.checkNotNullParameter(set, "showerSet");
            return new AssetShowerHolder(set);
        }
    }

    @JvmStatic
    public static final AssetShowerHolder_Factory create(Provider<Set<AssetShower<? extends Asset>>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final AssetShowerHolder newInstance(Set<? extends AssetShower<? extends Asset>> set) {
        return Companion.newInstance(set);
    }
}