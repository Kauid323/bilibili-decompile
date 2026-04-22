package kntr.app.digital.preview.report;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.RouterParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageReportParamsProvider_ProvideFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/report/PageReportParamsProvider_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "routerParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/RouterParams;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PageReportParamsProvider_ProvideFactory implements Factory<FillCommonReportParams> {
    private final Provider<RouterParams> routerParamsProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public PageReportParamsProvider_ProvideFactory(Provider<RouterParams> provider) {
        Intrinsics.checkNotNullParameter(provider, "routerParamsProvider");
        this.routerParamsProvider = provider;
    }

    public FillCommonReportParams get() {
        Companion companion = Companion;
        RouterParams routerParams = this.routerParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(routerParams, "get(...)");
        return companion.provide(routerParams);
    }

    /* compiled from: PageReportParamsProvider_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/report/PageReportParamsProvider_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/report/PageReportParamsProvider_ProvideFactory;", "routerParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/RouterParams;", "provide", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "routerParams", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PageReportParamsProvider_ProvideFactory create(Provider<RouterParams> provider) {
            Intrinsics.checkNotNullParameter(provider, "routerParamsProvider");
            return new PageReportParamsProvider_ProvideFactory(provider);
        }

        @JvmStatic
        public final FillCommonReportParams provide(RouterParams routerParams) {
            Intrinsics.checkNotNullParameter(routerParams, "routerParams");
            return PageReportParamsProvider.INSTANCE.provide(routerParams);
        }
    }

    @JvmStatic
    public static final PageReportParamsProvider_ProvideFactory create(Provider<RouterParams> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final FillCommonReportParams provide(RouterParams routerParams) {
        return Companion.provide(routerParams);
    }
}