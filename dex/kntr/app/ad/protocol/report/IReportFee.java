package kntr.app.ad.protocol.report;

import kntr.app.ad.domain.report.internal.ReportBuildInEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IReportFee.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH&JE\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH&JE\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH&JE\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH&JE\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH&JM\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH'¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/report/IReportFee;", RoomRecommendViewModel.EMPTY_CURSOR, "exposed", RoomRecommendViewModel.EMPTY_CURSOR, "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "isUnique", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueKey", RoomRecommendViewModel.EMPTY_CURSOR, "extraHandler", "Lkotlin/Function1;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "Lkotlin/ExtensionFunctionType;", "strictExposed", "click", "buttonClick", ReportBuildInEvent.CLOSE, "event", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportFee {
    void buttonClick(IReportable iReportable, boolean z, String str, Function1<? super IReportExtraHandler, Unit> function1);

    void click(IReportable iReportable, boolean z, String str, Function1<? super IReportExtraHandler, Unit> function1);

    void close(IReportable iReportable, boolean z, String str, Function1<? super IReportExtraHandler, Unit> function1);

    void event(String str, IReportable iReportable, boolean z, String str2, Function1<? super IReportExtraHandler, Unit> function1);

    void exposed(IReportable iReportable, boolean z, String str, Function1<? super IReportExtraHandler, Unit> function1);

    void strictExposed(IReportable iReportable, boolean z, String str, Function1<? super IReportExtraHandler, Unit> function1);

    /* compiled from: IReportFee.kt */
    /* renamed from: kntr.app.ad.protocol.report.IReportFee$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void exposed$default(IReportFee iReportFee, IReportable iReportable, boolean z, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposed");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                str = "show";
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            iReportFee.exposed(iReportable, z, str, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void strictExposed$default(IReportFee iReportFee, IReportable iReportable, boolean z, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: strictExposed");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                str = ReportBuildInEvent.STRICT_SHOW;
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            iReportFee.strictExposed(iReportable, z, str, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void click$default(IReportFee iReportFee, IReportable iReportable, boolean z, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: click");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str = "click";
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            iReportFee.click(iReportable, z, str, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void buttonClick$default(IReportFee iReportFee, IReportable iReportable, boolean z, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buttonClick");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str = ReportBuildInEvent.BUTTON_CLICK;
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            iReportFee.buttonClick(iReportable, z, str, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void close$default(IReportFee iReportFee, IReportable iReportable, boolean z, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str = ReportBuildInEvent.CLOSE;
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            iReportFee.close(iReportable, z, str, function1);
        }

        public static /* synthetic */ void event$default(IReportFee iReportFee, String str, IReportable iReportable, boolean z, String str2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: event");
            }
            iReportFee.event(str, iReportable, (i & 4) != 0 ? false : z, (i & 8) != 0 ? str : str2, (i & 16) != 0 ? null : function1);
        }
    }

    /* compiled from: IReportFee.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}