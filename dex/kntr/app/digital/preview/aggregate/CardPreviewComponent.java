package kntr.app.digital.preview.aggregate;

import androidx.lifecycle.Lifecycle;
import com.bilibili.ktor.KtorClientKt;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kntr.app.digital.preview.CardPreviewPageModel;
import kntr.app.digital.preview.PageScope;
import kntr.app.digital.preview.RouterParams;
import kntr.app.digital.preview.aggregate.CardPreviewComponent;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.digital.preview.card.video.DownloadCaptions;
import kntr.app.digital.preview.card.web.GetWebCardDescInfo;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.gift.RequestGiftInfo;
import kntr.app.digital.preview.lock.ToggleLockCard;
import kntr.app.digital.preview.report.PageReportParamsProvider;
import kntr.app.digital.preview.shop.ShopPreviewComponent;
import kntr.app.digital.preview.splashsetting.SplashSettingInfo;
import kntr.app.digital.preview.usage.Usage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.LocalOnFinishKt;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: CardPreviewComponent.kt */
@Component(dependencies = {}, modules = {Impl.class, RouterParamsBackedModule.class, PageReportParamsProvider.class})
@PageScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/aggregate/CardPreviewComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "pageModel", "Lkntr/app/digital/preview/CardPreviewPageModel;", "Factory", "Impl", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CardPreviewComponent {

    /* compiled from: CardPreviewComponent.kt */
    @Component.Factory
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/aggregate/CardPreviewComponent$Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "create", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "params", "Lkntr/app/digital/preview/RouterParams;", "toaster", "Lkntr/common/trio/toast/Toaster;", "router", "Lkntr/base/router/Router;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Factory {
        CardPreviewComponent create(@BindsInstance Lifecycle lifecycle, @BindsInstance RouterParams routerParams, @BindsInstance Toaster toaster, @BindsInstance Router router, @BindsInstance KomponentScope<? super Unit> komponentScope);
    }

    CardPreviewPageModel pageModel();

    /* compiled from: CardPreviewComponent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007¨\u0006\u001a"}, d2 = {"Lkntr/app/digital/preview/aggregate/CardPreviewComponent$Impl;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideHttpClient", "Lio/ktor/client/HttpClient;", "provideRequestGiftInfo", "Lkntr/app/digital/preview/gift/RequestGiftInfo;", "httpClient", "provideDownloadCaptions", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "provideSplashSettingInfo", "Lkntr/app/digital/preview/splashsetting/SplashSettingInfo;", "provideWebCardDescInfo", "Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;", "provideUsage", "Lkntr/app/digital/preview/usage/Usage;", "provideToggleLockCard", "Lkntr/app/digital/preview/lock/ToggleLockCard;", "provideGetCardList", "Lkntr/app/digital/preview/api/GetCardList;", "provideDismissRequest", "Lkntr/app/digital/preview/closing/DismissRequest;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Module(includes = {}, subcomponents = {ShopPreviewComponent.class})
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Impl {
        public static final int $stable = 0;
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        @Provides
        public final HttpClient provideHttpClient() {
            final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit provideHttpClient$lambda$0;
                    provideHttpClient$lambda$0 = CardPreviewComponent.Impl.provideHttpClient$lambda$0((JsonBuilder) obj);
                    return provideHttpClient$lambda$0;
                }
            }, 1, (Object) null);
            return KtorClientKt.getHttpClientFactory().create(new Function1() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit provideHttpClient$lambda$1;
                    provideHttpClient$lambda$1 = CardPreviewComponent.Impl.provideHttpClient$lambda$1(json, (HttpClientConfig) obj);
                    return provideHttpClient$lambda$1;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit provideHttpClient$lambda$0(JsonBuilder $this$Json) {
            Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
            $this$Json.setPrettyPrint(true);
            $this$Json.setLenient(true);
            $this$Json.setIgnoreUnknownKeys(true);
            $this$Json.setEncodeDefaults(true);
            $this$Json.setCoerceInputValues(true);
            $this$Json.setExplicitNulls(false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit provideHttpClient$lambda$1(final Json $json, HttpClientConfig $this$create) {
            Intrinsics.checkNotNullParameter($this$create, "$this$create");
            $this$create.install(ContentNegotiationKt.getContentNegotiation(), new Function1() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit provideHttpClient$lambda$1$0;
                    provideHttpClient$lambda$1$0 = CardPreviewComponent.Impl.provideHttpClient$lambda$1$0($json, (ContentNegotiationConfig) obj);
                    return provideHttpClient$lambda$1$0;
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit provideHttpClient$lambda$1$0(Json $json, ContentNegotiationConfig $this$install) {
            Intrinsics.checkNotNullParameter($this$install, "$this$install");
            JsonSupportKt.json$default((Configuration) $this$install, $json, (ContentType) null, 2, (Object) null);
            return Unit.INSTANCE;
        }

        @Provides
        public final RequestGiftInfo provideRequestGiftInfo(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideRequestGiftInfo$1(httpClient);
        }

        @Provides
        public final DownloadCaptions provideDownloadCaptions(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideDownloadCaptions$1(httpClient);
        }

        @Provides
        public final SplashSettingInfo provideSplashSettingInfo(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideSplashSettingInfo$1(httpClient);
        }

        @Provides
        public final GetWebCardDescInfo provideWebCardDescInfo(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideWebCardDescInfo$1(httpClient);
        }

        @Provides
        public final Usage provideUsage(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideUsage$1(httpClient);
        }

        @Provides
        public final ToggleLockCard provideToggleLockCard(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideToggleLockCard$1(httpClient);
        }

        @Provides
        public final GetCardList provideGetCardList(HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new CardPreviewComponent$Impl$provideGetCardList$1(httpClient);
        }

        @Provides
        public final DismissRequest provideDismissRequest(final KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return new DismissRequest() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$$ExternalSyntheticLambda3
                @Override // kntr.app.digital.preview.closing.DismissRequest
                public final void invoke() {
                    CardPreviewComponent.Impl.provideDismissRequest$lambda$0(komponentScope);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void provideDismissRequest$lambda$0(KomponentScope $komponentScope) {
            LocalOnFinishKt.getFinishHost((KomponentLocalAccessScope) $komponentScope).invoke();
        }
    }
}