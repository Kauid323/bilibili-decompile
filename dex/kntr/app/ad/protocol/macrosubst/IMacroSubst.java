package kntr.app.ad.protocol.macrosubst;

import kntr.app.ad.protocol.IMotion;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IMacroSubst.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/macrosubst/IMacroSubst;", RoomRecommendViewModel.EMPTY_CURSOR, "process", RoomRecommendViewModel.EMPTY_CURSOR, "url", "adInfo", "Lkntr/app/ad/protocol/report/IReportable;", "ts", "motion", "Lkntr/app/ad/protocol/IMotion;", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMacroSubst {
    String process(String str, IReportable iReportable, String str2, IMotion iMotion);

    /* compiled from: IMacroSubst.kt */
    /* renamed from: kntr.app.ad.protocol.macrosubst.IMacroSubst$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ String process$default(IMacroSubst iMacroSubst, String str, IReportable iReportable, String str2, IMotion iMotion, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    iMotion = null;
                }
                return iMacroSubst.process(str, iReportable, str2, iMotion);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: process");
        }
    }

    /* compiled from: IMacroSubst.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}