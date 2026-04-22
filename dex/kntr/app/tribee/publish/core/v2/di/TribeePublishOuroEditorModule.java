package kntr.app.tribee.publish.core.v2.di;

import dagger.Module;
import dagger.Provides;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.service.CommonAtMentionServiceImpl;
import kntr.common.ouro.common.service.LinkParseServiceImpl;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.di.OuroAssetUploader;
import kntr.common.ouro.core.di.OuroComponent;
import kntr.common.ouro.core.di.OuroLinkParser;
import kntr.common.ouro.core.di.preset.OuroComplexEditorPluginModule;
import kntr.common.ouro.core.plugin.atMention.AtMentionService;
import kntr.common.ouro.core.plugin.pasteboard.LinkParseService;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.di.AssetUploaderComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishOuroEditorModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule;", "", "<init>", "()V", "provideOuroComponent", "Lkntr/common/ouro/core/di/OuroComponent;", "ouroComponentFactory", "Lkntr/common/ouro/core/di/OuroComponent$Factory;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "initialState", "Lkntr/common/ouro/core/OuroState;", "provideOuroAssetUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "assetUploaderComponentBuilder", "Lkntr/common/paragraph/assetuploader/di/AssetUploaderComponent$Builder;", "scope", "provideOuroStore", "Lkntr/common/ouro/core/OuroStore;", "ouroComponent", "provideAtMentionService", "Lkntr/common/ouro/core/plugin/atMention/AtMentionService;", "provideLinkParseService", "Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {OuroComplexEditorPluginModule.class}, subcomponents = {AssetUploaderComponent.class, OuroComponent.class})
public final class TribeePublishOuroEditorModule {
    public static final TribeePublishOuroEditorModule INSTANCE = new TribeePublishOuroEditorModule();

    private TribeePublishOuroEditorModule() {
    }

    @Provides
    @TribeePublishScope
    public final OuroComponent provideOuroComponent(OuroComponent.Factory ouroComponentFactory, @TribeePublishCoroutineScope CoroutineScope coroutineScope, @TribeeOuroInitialState OuroState initialState) {
        Intrinsics.checkNotNullParameter(ouroComponentFactory, "ouroComponentFactory");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        return ouroComponentFactory.build(coroutineScope, initialState);
    }

    @Provides
    @TribeePublishScope
    @OuroAssetUploader
    public final AssetUploader provideOuroAssetUploader(AssetUploaderComponent.Builder assetUploaderComponentBuilder, @TribeePublishCoroutineScope CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(assetUploaderComponentBuilder, "assetUploaderComponentBuilder");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return assetUploaderComponentBuilder.build(scope, "new_dyn").uploader();
    }

    @Provides
    @TribeePublishScope
    @TribeePublishOuroStore
    public final OuroStore provideOuroStore(OuroComponent ouroComponent) {
        Intrinsics.checkNotNullParameter(ouroComponent, "ouroComponent");
        return ouroComponent.viewModel();
    }

    @Provides
    public final AtMentionService provideAtMentionService() {
        return new CommonAtMentionServiceImpl();
    }

    @Provides
    @OuroLinkParser
    public final LinkParseService provideLinkParseService() {
        return new LinkParseServiceImpl();
    }
}