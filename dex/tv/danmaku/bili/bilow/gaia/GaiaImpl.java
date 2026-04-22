package tv.danmaku.bili.bilow.gaia;

import com.bilibili.gripper.api.riskcontrol.GRiskControl;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.rpc.gaia.Gaia;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: GaiaImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001e\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/bilow/gaia/GaiaImpl;", "Lcom/bilibili/lib/rpc/gaia/Gaia;", "riskControl", "Lcom/bilibili/gripper/api/riskcontrol/GRiskControl;", "<init>", "(Lcom/bilibili/gripper/api/riskcontrol/GRiskControl;)V", "onGaiaReq", "", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "validTime", "", "onGaiaResp", "", "event", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "onGaiaVoucher", "voucher", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/lib/rpc/gaia/Gaia$OnGaiaTokenCallback;", AppConfig.HOST_TAG, "onGaiaParams", "params", "", "fullMethodName", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GaiaImpl implements Gaia {
    private final GRiskControl riskControl;

    public GaiaImpl(GRiskControl riskControl) {
        this.riskControl = riskControl;
    }

    public String onGaiaReq(String host, String path) {
        String token;
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        GRiskControl gRiskControl = this.riskControl;
        return (gRiskControl == null || (token = gRiskControl.getToken(validTime())) == null) ? "" : token;
    }

    private final int validTime() {
        Integer intOrNull;
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "risk.token_valid_time", (Object) null, 2, (Object) null);
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            return 2;
        }
        return intOrNull.intValue();
    }

    public void onGaiaResp(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onGaiaVoucher(String voucher, Gaia.OnGaiaTokenCallback callback, String tag) {
        Intrinsics.checkNotNullParameter(voucher, "voucher");
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
    }

    public void onGaiaParams(List<String> list, String fullMethodName) {
        Intrinsics.checkNotNullParameter(list, "params");
        Intrinsics.checkNotNullParameter(fullMethodName, "fullMethodName");
    }
}