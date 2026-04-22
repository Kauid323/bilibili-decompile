package kntr.app.digital.preview.report;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BusinessReportParamsProvider_ProvideCurrentCardItemFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/report/BusinessReportParamsProvider_ProvideCurrentCardItemFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "cardStateServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BusinessReportParamsProvider_ProvideCurrentCardItemFactory implements Factory<CardItem<?>> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BusinessReportParamsProvider_ProvideCurrentCardItemFactory(Provider<DigitalCardStateService> provider) {
        Intrinsics.checkNotNullParameter(provider, "cardStateServiceProvider");
        this.cardStateServiceProvider = provider;
    }

    public CardItem<?> get() {
        Companion companion = Companion;
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        return companion.provideCurrentCardItem(digitalCardStateService);
    }

    /* compiled from: BusinessReportParamsProvider_ProvideCurrentCardItemFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/report/BusinessReportParamsProvider_ProvideCurrentCardItemFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/report/BusinessReportParamsProvider_ProvideCurrentCardItemFactory;", "cardStateServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "provideCurrentCardItem", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "cardStateService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BusinessReportParamsProvider_ProvideCurrentCardItemFactory create(Provider<DigitalCardStateService> provider) {
            Intrinsics.checkNotNullParameter(provider, "cardStateServiceProvider");
            return new BusinessReportParamsProvider_ProvideCurrentCardItemFactory(provider);
        }

        @JvmStatic
        public final CardItem<?> provideCurrentCardItem(DigitalCardStateService cardStateService) {
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            return BusinessReportParamsProvider.INSTANCE.provideCurrentCardItem(cardStateService);
        }
    }

    @JvmStatic
    public static final BusinessReportParamsProvider_ProvideCurrentCardItemFactory create(Provider<DigitalCardStateService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final CardItem<?> provideCurrentCardItem(DigitalCardStateService cardStateService) {
        return Companion.provideCurrentCardItem(cardStateService);
    }
}