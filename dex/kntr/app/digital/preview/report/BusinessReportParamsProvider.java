package kntr.app.digital.preview.report;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Qualifier;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BusinessReportParamsProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\b\u0001\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/report/BusinessReportParamsProvider;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideCurrentCardItem", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "provide", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "currentCardItemProvider", "Ljavax/inject/Provider;", "CurrentCardItem", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class BusinessReportParamsProvider {
    public static final int $stable = 0;
    public static final BusinessReportParamsProvider INSTANCE = new BusinessReportParamsProvider();

    /* compiled from: BusinessReportParamsProvider.kt */
    @Qualifier
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkntr/app/digital/preview/report/BusinessReportParamsProvider$CurrentCardItem;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public @interface CurrentCardItem {
    }

    private BusinessReportParamsProvider() {
    }

    @Provides
    @CurrentCardItem
    public final CardItem<?> provideCurrentCardItem(DigitalCardStateService cardStateService) {
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        return cardStateService.getCurrentCardItem();
    }

    @Provides
    @IntoSet
    public final FillCommonReportParams provide(@CurrentCardItem final Provider<CardItem<?>> provider) {
        Intrinsics.checkNotNullParameter(provider, "currentCardItemProvider");
        return new FillCommonReportParams() { // from class: kntr.app.digital.preview.report.BusinessReportParamsProvider$$ExternalSyntheticLambda0
            @Override // kntr.app.digital.preview.report.FillCommonReportParams
            public final void invoke(Map map) {
                BusinessReportParamsProvider.provide$lambda$0(Provider.this, map);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provide$lambda$0(Provider $currentCardItemProvider, Map $this$FillCommonReportParams) {
        Intrinsics.checkNotNullParameter($this$FillCommonReportParams, "$this$FillCommonReportParams");
        $this$FillCommonReportParams.putAll(((CardItem) $currentCardItemProvider.get()).getBasic().getReportParams());
    }
}