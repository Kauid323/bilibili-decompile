package kntr.app.cheese.space.aggregate;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bilibili.ogv.bpf.neuron.NeuronReport;
import com.bilibili.ogv.bpf.neuron.NeuronReportKt;
import com.bilibili.ogv.operation3.module.DataSourceScope;
import com.bilibili.ogv.operation3.module.HttpClientModule;
import com.bilibili.ogv.operation3.module.JsonModule;
import com.bilibili.ogv.operation3.module.PolarisActionId;
import com.bilibili.ogv.operation3.module.aggregate.ModuleTypes;
import com.bilibili.ogv.operation3.module.concept.ModuleSerializersModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import kntr.app.cheese.space.CreatePerLoadKomponent;
import kntr.app.cheese.space.PageScope;
import kntr.app.cheese.space.SpaceCheesePageModel;
import kntr.app.cheese.space.SpaceCheesePerLoadUiService;
import kntr.app.cheese.space.aggregate.SpaceCheesePageComponent;
import kntr.app.cheese.space.aggregate.SpaceCheesePagePerLoadComponent;
import kntr.app.cheese.space.api.BaseUrl;
import kntr.app.cheese.space.api.PageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.pv.PvTracker;
import kntr.common.pv.PvTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SpaceCheesePageComponent.kt */
@PageScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "pageModel", "Lkntr/app/cheese/space/SpaceCheesePageModel;", "Factory", "Impl", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Component(modules = {Impl.class, JsonModule.class, HttpClientModule.class, ModuleSerializersModule.class, ModuleTypes.class})
@DataSourceScope
public interface SpaceCheesePageComponent {

    /* compiled from: SpaceCheesePageComponent.kt */
    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent$Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "create", "Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Factory {
        SpaceCheesePageComponent create(@BindsInstance @UpId long j2);
    }

    SpaceCheesePageModel pageModel();

    /* compiled from: SpaceCheesePageComponent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent$Impl;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideCreatePerLoadKomponent", "Lkntr/app/cheese/space/CreatePerLoadKomponent;", "perLoadComponentFactory", "Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent$Factory;", "provideBaseUrl", RoomRecommendViewModel.EMPTY_CURSOR, "provideNeuronReport", "Lcom/bilibili/ogv/bpf/neuron/NeuronReport;", "provideCurrentPolarisActionId", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Module(subcomponents = {SpaceCheesePagePerLoadComponent.class})
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Impl {
        public static final int $stable = 0;
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        @Provides
        public final CreatePerLoadKomponent provideCreatePerLoadKomponent(final SpaceCheesePagePerLoadComponent.Factory perLoadComponentFactory) {
            Intrinsics.checkNotNullParameter(perLoadComponentFactory, "perLoadComponentFactory");
            return new CreatePerLoadKomponent() { // from class: kntr.app.cheese.space.aggregate.SpaceCheesePageComponent$Impl$$ExternalSyntheticLambda1
                @Override // kntr.app.cheese.space.CreatePerLoadKomponent
                public final Komponent invoke(PageData pageData) {
                    Komponent provideCreatePerLoadKomponent$lambda$0;
                    provideCreatePerLoadKomponent$lambda$0 = SpaceCheesePageComponent.Impl.provideCreatePerLoadKomponent$lambda$0(SpaceCheesePagePerLoadComponent.Factory.this, pageData);
                    return provideCreatePerLoadKomponent$lambda$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Komponent provideCreatePerLoadKomponent$lambda$0(final SpaceCheesePagePerLoadComponent.Factory $perLoadComponentFactory, final PageData pageData) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            return KomponentKt.Komponent(new Function1() { // from class: kntr.app.cheese.space.aggregate.SpaceCheesePageComponent$Impl$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    SetContentResult provideCreatePerLoadKomponent$lambda$0$0;
                    provideCreatePerLoadKomponent$lambda$0$0 = SpaceCheesePageComponent.Impl.provideCreatePerLoadKomponent$lambda$0$0(SpaceCheesePagePerLoadComponent.Factory.this, pageData, (KomponentScope) obj);
                    return provideCreatePerLoadKomponent$lambda$0$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SetContentResult provideCreatePerLoadKomponent$lambda$0$0(SpaceCheesePagePerLoadComponent.Factory $perLoadComponentFactory, PageData $pageData, final KomponentScope $this$Komponent) {
            Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
            SpaceCheesePagePerLoadComponent component = $perLoadComponentFactory.create($pageData, $this$Komponent);
            final SpaceCheesePerLoadUiService uiService = component.uiService();
            final Object state$iv$iv = Unit.INSTANCE;
            UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, uiService) { // from class: kntr.app.cheese.space.aggregate.SpaceCheesePageComponent$Impl$provideCreatePerLoadKomponent$lambda$0$0$$inlined$setContent$1
                final /* synthetic */ KomponentScope $this_setContent;
                final /* synthetic */ SpaceCheesePerLoadUiService $uiService$inlined;
                private final S state;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$this_setContent = $this$Komponent;
                    this.$uiService$inlined = uiService;
                    this.state = state$iv$iv;
                }

                public void invoke(Modifier modifier, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                    $composer.startReplaceGroup(1906618612);
                    ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                    }
                    $composer.startReplaceGroup(-1637364270);
                    ComposerKt.sourceInformation($composer, "CN(it)*54@1943L11:SpaceCheesePageComponent.kt#46qina");
                    this.$uiService$inlined.Content(modifier, $composer, $changed & 14 & 14, 0);
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
        @BaseUrl
        public final String provideBaseUrl() {
            return "https://api.bilibili.com";
        }

        @Provides
        public final NeuronReport provideNeuronReport() {
            return NeuronReportKt.getNeuronReport();
        }

        @Provides
        @PolarisActionId
        public final String provideCurrentPolarisActionId() {
            PvTracker pvTracker = PvTrackerKt.getPvTracker();
            if (pvTracker != null) {
                return pvTracker.currentPolarisActionId();
            }
            return null;
        }
    }
}