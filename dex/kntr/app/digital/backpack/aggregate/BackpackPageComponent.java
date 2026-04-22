package kntr.app.digital.backpack.aggregate;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
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
import java.util.Map;
import kntr.app.digital.backpack.BackpackPageModel;
import kntr.app.digital.backpack.CreateBackpackKomponent;
import kntr.app.digital.backpack.ReportParams;
import kntr.app.digital.backpack.aggregate.BackpackBusinessComponent;
import kntr.app.digital.backpack.aggregate.BackpackPageComponent;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.digital.backpack.di.ActivityId;
import kntr.app.digital.backpack.di.From;
import kntr.app.digital.backpack.di.FromSource;
import kntr.app.digital.backpack.di.PageScope;
import kntr.app.digital.backpack.di.VMid;
import kntr.app.digital.backpack.dismiss.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.LocalOnFinishKt;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: BackpackPageComponent.kt */
@Component(dependencies = {}, modules = {Impl.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "pageModel", "Lkntr/app/digital/backpack/BackpackPageModel;", "Factory", "Impl", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@PageScope
public interface BackpackPageComponent {

    /* compiled from: BackpackPageComponent.kt */
    @Component.Factory
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001Jj\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent$Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "create", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent;", "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "router", "Lkntr/base/router/Router;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "from", "fromSource", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Factory {
        BackpackPageComponent create(@BindsInstance @ActivityId int i, @BindsInstance @VMid long j2, @BindsInstance Lifecycle lifecycle, @BindsInstance Router router, @BindsInstance @ReportParams Map<String, String> map, @BindsInstance @From String str, @BindsInstance @FromSource String str2, @BindsInstance KomponentScope<? super Unit> komponentScope);
    }

    BackpackPageModel pageModel();

    /* compiled from: BackpackPageComponent.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent$Impl;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideCreatePreviewKomponent", "Lkntr/app/digital/backpack/CreateBackpackKomponent;", "shopPreviewComponentFactory", "Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent$Factory;", "provideHttpClient", "Lio/ktor/client/HttpClient;", "provideGetBackpackAssetBag", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "httpClient", "actId", RoomRecommendViewModel.EMPTY_CURSOR, "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "provideDismissRequest", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Module(includes = {}, subcomponents = {BackpackBusinessComponent.class})
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Impl {
        public static final int $stable = 0;
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        @Provides
        public final CreateBackpackKomponent provideCreatePreviewKomponent(final BackpackBusinessComponent.Factory shopPreviewComponentFactory) {
            Intrinsics.checkNotNullParameter(shopPreviewComponentFactory, "shopPreviewComponentFactory");
            return new CreateBackpackKomponent() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$$ExternalSyntheticLambda4
                @Override // kntr.app.digital.backpack.CreateBackpackKomponent
                public final Komponent invoke(BackpackAssetBagModel backpackAssetBagModel) {
                    Komponent provideCreatePreviewKomponent$lambda$0;
                    provideCreatePreviewKomponent$lambda$0 = BackpackPageComponent.Impl.provideCreatePreviewKomponent$lambda$0(BackpackBusinessComponent.Factory.this, backpackAssetBagModel);
                    return provideCreatePreviewKomponent$lambda$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Komponent provideCreatePreviewKomponent$lambda$0(final BackpackBusinessComponent.Factory $shopPreviewComponentFactory, final BackpackAssetBagModel assetBagModel) {
            Intrinsics.checkNotNullParameter(assetBagModel, "assetBagModel");
            return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    SetContentResult provideCreatePreviewKomponent$lambda$0$0;
                    provideCreatePreviewKomponent$lambda$0$0 = BackpackPageComponent.Impl.provideCreatePreviewKomponent$lambda$0$0(BackpackBusinessComponent.Factory.this, assetBagModel, (KomponentScope) obj);
                    return provideCreatePreviewKomponent$lambda$0$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SetContentResult provideCreatePreviewKomponent$lambda$0$0(BackpackBusinessComponent.Factory $shopPreviewComponentFactory, BackpackAssetBagModel $assetBagModel, final KomponentScope $this$Komponent) {
            Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
            BackpackBusinessComponent component = $shopPreviewComponentFactory.create($assetBagModel, $this$Komponent.getCoroutineScope());
            final UiComposableLike child = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, component.getPageService().komponent(), (Function1) null, 2, (Object) null);
            final Object state$iv$iv = Unit.INSTANCE;
            UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, child) { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$provideCreatePreviewKomponent$lambda$0$0$$inlined$setContent$1
                final /* synthetic */ UiComposableLike $child$inlined;
                final /* synthetic */ KomponentScope $this_setContent;
                private final S state;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$this_setContent = $this$Komponent;
                    this.$child$inlined = child;
                    this.state = state$iv$iv;
                }

                public void invoke(Modifier modifier, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                    $composer.startReplaceGroup(1906618612);
                    ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                    }
                    $composer.startReplaceGroup(-1643097317);
                    ComposerKt.sourceInformation($composer, "CN(it)*76@2782L9:BackpackPageComponent.kt#gfrewv");
                    this.$child$inlined.invoke(modifier, $composer, $changed & 14 & 14);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceGroup();
                }

                public Object getContentType() {
                    return Reflection.getOrCreateKotlinClass(getClass());
                }

                public Object getKey() {
                    return this.$this_setContent.getKey();
                }

                public S getState() {
                    return this.state;
                }

                public HostConfiguration getPreferredHostConfiguration() {
                    return this.$this_setContent.getPreferredHostConfiguration();
                }
            };
            return $this$Komponent.__setContent(content$iv$iv$iv);
        }

        @Provides
        public final HttpClient provideHttpClient() {
            final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit provideHttpClient$lambda$0;
                    provideHttpClient$lambda$0 = BackpackPageComponent.Impl.provideHttpClient$lambda$0((JsonBuilder) obj);
                    return provideHttpClient$lambda$0;
                }
            }, 1, (Object) null);
            return KtorClientKt.getHttpClientFactory().create(new Function1() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit provideHttpClient$lambda$1;
                    provideHttpClient$lambda$1 = BackpackPageComponent.Impl.provideHttpClient$lambda$1(json, (HttpClientConfig) obj);
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
            $this$create.install(ContentNegotiationKt.getContentNegotiation(), new Function1() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit provideHttpClient$lambda$1$0;
                    provideHttpClient$lambda$1$0 = BackpackPageComponent.Impl.provideHttpClient$lambda$1$0($json, (ContentNegotiationConfig) obj);
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
        public final GetBackpackAssetBag provideGetBackpackAssetBag(HttpClient httpClient, @ActivityId int actId, @VMid long vmid) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return new BackpackPageComponent$Impl$provideGetBackpackAssetBag$1(httpClient, actId, vmid);
        }

        @Provides
        public final DismissRequest provideDismissRequest(final KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return new DismissRequest() { // from class: kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$$ExternalSyntheticLambda3
                @Override // kntr.app.digital.backpack.dismiss.DismissRequest
                public final void invoke() {
                    BackpackPageComponent.Impl.provideDismissRequest$lambda$0(komponentScope);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void provideDismissRequest$lambda$0(KomponentScope $komponentScope) {
            LocalOnFinishKt.getFinishHost((KomponentLocalAccessScope) $komponentScope).invoke();
        }
    }
}