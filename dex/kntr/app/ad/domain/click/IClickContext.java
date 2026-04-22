package kntr.app.ad.domain.click;

import java.util.List;
import kntr.app.ad.domain.click.internal.ActionFeeEvent;
import kntr.app.ad.domain.click.internal.ActionUiEvent;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IClickContext.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\b\tH&J-\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\b\tH&J\u001a\u0010\f\u001a\u00020\u00032\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/click/IClickContext;", RoomRecommendViewModel.EMPTY_CURSOR, "reportFee", RoomRecommendViewModel.EMPTY_CURSOR, "event", "Lkntr/app/ad/domain/click/internal/ActionFeeEvent;", "extraHandler", "Lkotlin/Function1;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "Lkotlin/ExtensionFunctionType;", "reportUi", "Lkntr/app/ad/domain/click/internal/ActionUiEvent;", "reportMMA", "urls", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IClickContext {
    void reportFee(ActionFeeEvent actionFeeEvent, Function1<? super IReportExtraHandler, Unit> function1);

    void reportMMA(List<String> list);

    void reportUi(ActionUiEvent actionUiEvent, Function1<? super IReportExtraHandler, Unit> function1);

    /* compiled from: IClickContext.kt */
    /* renamed from: kntr.app.ad.domain.click.IClickContext$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportFee$default(IClickContext iClickContext, ActionFeeEvent actionFeeEvent, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFee");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            iClickContext.reportFee(actionFeeEvent, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportUi$default(IClickContext iClickContext, ActionUiEvent actionUiEvent, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportUi");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            iClickContext.reportUi(actionUiEvent, function1);
        }
    }

    /* compiled from: IClickContext.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}