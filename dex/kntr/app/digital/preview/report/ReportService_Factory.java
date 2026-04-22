package kntr.app.digital.preview.report;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportService_Factory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/preview/report/ReportService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/report/ReportService;", "fillCommonReportParamsSetProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/report/FillCommonReportParams;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportService_Factory implements Factory<ReportService> {
    private final Provider<Set<FillCommonReportParams>> fillCommonReportParamsSetProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ReportService_Factory(Provider<Set<FillCommonReportParams>> provider) {
        Intrinsics.checkNotNullParameter(provider, "fillCommonReportParamsSetProvider");
        this.fillCommonReportParamsSetProvider = provider;
    }

    public ReportService get() {
        Companion companion = Companion;
        Set<FillCommonReportParams> set = this.fillCommonReportParamsSetProvider.get();
        Intrinsics.checkNotNullExpressionValue(set, "get(...)");
        return companion.newInstance(set);
    }

    /* compiled from: ReportService_Factory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/report/ReportService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/report/ReportService_Factory;", "fillCommonReportParamsSetProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/report/FillCommonReportParams;", "newInstance", "Lkntr/app/digital/preview/report/ReportService;", "fillCommonReportParamsSet", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReportService_Factory create(Provider<Set<FillCommonReportParams>> provider) {
            Intrinsics.checkNotNullParameter(provider, "fillCommonReportParamsSetProvider");
            return new ReportService_Factory(provider);
        }

        @JvmStatic
        public final ReportService newInstance(Set<? extends FillCommonReportParams> set) {
            Intrinsics.checkNotNullParameter(set, "fillCommonReportParamsSet");
            return new ReportService(set);
        }
    }

    @JvmStatic
    public static final ReportService_Factory create(Provider<Set<FillCommonReportParams>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ReportService newInstance(Set<? extends FillCommonReportParams> set) {
        return Companion.newInstance(set);
    }
}