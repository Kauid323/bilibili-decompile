package kntr.app.digital.preview.report;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BusinessReportParamsProvider_ProvideFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0019\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/report/BusinessReportParamsProvider_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "currentCardItemProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BusinessReportParamsProvider_ProvideFactory implements Factory<FillCommonReportParams> {
    private final Provider<CardItem<?>> currentCardItemProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BusinessReportParamsProvider_ProvideFactory(Provider<CardItem<?>> provider) {
        Intrinsics.checkNotNullParameter(provider, "currentCardItemProvider");
        this.currentCardItemProvider = provider;
    }

    public FillCommonReportParams get() {
        return Companion.provide(this.currentCardItemProvider);
    }

    /* compiled from: BusinessReportParamsProvider_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0007J\u001a\u0010\t\u001a\u00020\n2\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/preview/report/BusinessReportParamsProvider_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/report/BusinessReportParamsProvider_ProvideFactory;", "currentCardItemProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "provide", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BusinessReportParamsProvider_ProvideFactory create(Provider<CardItem<?>> provider) {
            Intrinsics.checkNotNullParameter(provider, "currentCardItemProvider");
            return new BusinessReportParamsProvider_ProvideFactory(provider);
        }

        @JvmStatic
        public final FillCommonReportParams provide(Provider<CardItem<?>> provider) {
            Intrinsics.checkNotNullParameter(provider, "currentCardItemProvider");
            return BusinessReportParamsProvider.INSTANCE.provide(provider);
        }
    }

    @JvmStatic
    public static final BusinessReportParamsProvider_ProvideFactory create(Provider<CardItem<?>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final FillCommonReportParams provide(Provider<CardItem<?>> provider) {
        return Companion.provide(provider);
    }
}