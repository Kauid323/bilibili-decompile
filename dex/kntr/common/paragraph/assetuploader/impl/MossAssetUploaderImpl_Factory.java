package kntr.common.paragraph.assetuploader.impl;

import dagger.internal.Factory;
import io.ktor.client.HttpClient;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MossAssetUploaderImpl_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl;", "clientProvider", "Ljavax/inject/Provider;", "Lio/ktor/client/HttpClient;", "bucketProvider", "", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MossAssetUploaderImpl_Factory implements Factory<MossAssetUploaderImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<String> bucketProvider;
    private final Provider<HttpClient> clientProvider;

    public MossAssetUploaderImpl_Factory(Provider<HttpClient> provider, Provider<String> provider2) {
        Intrinsics.checkNotNullParameter(provider, "clientProvider");
        Intrinsics.checkNotNullParameter(provider2, "bucketProvider");
        this.clientProvider = provider;
        this.bucketProvider = provider2;
    }

    public MossAssetUploaderImpl get() {
        Companion companion = Companion;
        Object obj = this.clientProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.bucketProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((HttpClient) obj, (String) obj2);
    }

    /* compiled from: MossAssetUploaderImpl_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl_Factory;", "clientProvider", "Ljavax/inject/Provider;", "Lio/ktor/client/HttpClient;", "bucketProvider", "", "newInstance", "Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl;", "client", "bucket", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MossAssetUploaderImpl_Factory create(Provider<HttpClient> provider, Provider<String> provider2) {
            Intrinsics.checkNotNullParameter(provider, "clientProvider");
            Intrinsics.checkNotNullParameter(provider2, "bucketProvider");
            return new MossAssetUploaderImpl_Factory(provider, provider2);
        }

        @JvmStatic
        public final MossAssetUploaderImpl newInstance(HttpClient client, String bucket) {
            Intrinsics.checkNotNullParameter(client, "client");
            Intrinsics.checkNotNullParameter(bucket, "bucket");
            return new MossAssetUploaderImpl(client, bucket);
        }
    }

    @JvmStatic
    public static final MossAssetUploaderImpl_Factory create(Provider<HttpClient> provider, Provider<String> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final MossAssetUploaderImpl newInstance(HttpClient client, String bucket) {
        return Companion.newInstance(client, bucket);
    }
}