package kntr.app.digital.preview.aggregate;

import dagger.internal.Factory;
import io.ktor.client.HttpClient;
import javax.inject.Provider;
import kntr.app.digital.preview.aggregate.CardPreviewComponent;
import kntr.app.digital.preview.card.video.DownloadCaptions;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/aggregate/CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "httpClientProvider", "Ljavax/inject/Provider;", "Lio/ktor/client/HttpClient;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory implements Factory<DownloadCaptions> {
    private final Provider<HttpClient> httpClientProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory(Provider<HttpClient> provider) {
        Intrinsics.checkNotNullParameter(provider, "httpClientProvider");
        this.httpClientProvider = provider;
    }

    public DownloadCaptions get() {
        Companion companion = Companion;
        HttpClient httpClient = this.httpClientProvider.get();
        Intrinsics.checkNotNullExpressionValue(httpClient, "get(...)");
        return companion.provideDownloadCaptions(httpClient);
    }

    /* compiled from: CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/aggregate/CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory;", "httpClientProvider", "Ljavax/inject/Provider;", "Lio/ktor/client/HttpClient;", "provideDownloadCaptions", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "httpClient", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory create(Provider<HttpClient> provider) {
            Intrinsics.checkNotNullParameter(provider, "httpClientProvider");
            return new CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory(provider);
        }

        @JvmStatic
        public final DownloadCaptions provideDownloadCaptions(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return CardPreviewComponent.Impl.INSTANCE.provideDownloadCaptions(httpClient);
        }
    }

    @JvmStatic
    public static final CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory create(Provider<HttpClient> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final DownloadCaptions provideDownloadCaptions(HttpClient httpClient) {
        return Companion.provideDownloadCaptions(httpClient);
    }
}