package kntr.app.ad.domain.report;

import kntr.app.ad.domain.report.vendor.fee.FeeReportFeature;
import kntr.app.ad.domain.report.vendor.fee.FeeReporter;
import kntr.app.ad.domain.report.vendor.mma.MMAReportFeature;
import kntr.app.ad.domain.report.vendor.mma.MMAReporter;
import kntr.app.ad.domain.report.vendor.ui.UIReportFeature;
import kntr.app.ad.domain.report.vendor.ui.UIReporter;
import kntr.app.ad.protocol.report.IReportFee;
import kntr.app.ad.protocol.report.IReportMMA;
import kntr.app.ad.protocol.report.IReportUI;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AdReportHub.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkntr/app/ad/domain/report/AdReportHub;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Companion", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdReportHub {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<FeeReporter> fee$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.report.AdReportHub$$ExternalSyntheticLambda0
        public final Object invoke() {
            FeeReporter fee_delegate$lambda$0;
            fee_delegate$lambda$0 = AdReportHub.fee_delegate$lambda$0();
            return fee_delegate$lambda$0;
        }
    });
    private static final Lazy<UIReporter> ui$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.report.AdReportHub$$ExternalSyntheticLambda1
        public final Object invoke() {
            UIReporter ui_delegate$lambda$0;
            ui_delegate$lambda$0 = AdReportHub.ui_delegate$lambda$0();
            return ui_delegate$lambda$0;
        }
    });
    private static final Lazy<MMAReporter> mma$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.report.AdReportHub$$ExternalSyntheticLambda2
        public final Object invoke() {
            MMAReporter mma_delegate$lambda$0;
            mma_delegate$lambda$0 = AdReportHub.mma_delegate$lambda$0();
            return mma_delegate$lambda$0;
        }
    });

    /* compiled from: AdReportHub.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/domain/report/AdReportHub$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "fee", "Lkntr/app/ad/protocol/report/IReportFee;", "getFee", "()Lkntr/app/ad/protocol/report/IReportFee;", "fee$delegate", "Lkotlin/Lazy;", "ui", "Lkntr/app/ad/protocol/report/IReportUI;", "getUi", "()Lkntr/app/ad/protocol/report/IReportUI;", "ui$delegate", "mma", "Lkntr/app/ad/protocol/report/IReportMMA;", "getMma", "()Lkntr/app/ad/protocol/report/IReportMMA;", "mma$delegate", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IReportFee getFee() {
            return (IReportFee) AdReportHub.fee$delegate.getValue();
        }

        public final IReportUI getUi() {
            return (IReportUI) AdReportHub.ui$delegate.getValue();
        }

        public final IReportMMA getMma() {
            return (IReportMMA) AdReportHub.mma$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeeReporter fee_delegate$lambda$0() {
        return new FeeReporter(FeeReportFeature.INSTANCE.getUploader(), FeeReportFeature.INSTANCE.getStorageManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UIReporter ui_delegate$lambda$0() {
        return new UIReporter(UIReportFeature.INSTANCE.getUploader(), UIReportFeature.INSTANCE.getStorageManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMAReporter mma_delegate$lambda$0() {
        return new MMAReporter(MMAReportFeature.INSTANCE.getUploader(), MMAReportFeature.INSTANCE.getStorageManager());
    }
}