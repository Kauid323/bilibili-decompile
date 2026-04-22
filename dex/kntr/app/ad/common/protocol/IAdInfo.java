package kntr.app.ad.common.protocol;

import kntr.app.ad.protocol.report.IReportable;
import kotlin.Metadata;

/* compiled from: IAdInfo.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/ad/common/protocol/IAdInfo;", "Lkntr/app/ad/protocol/report/IReportable;", "extra", "Lkntr/app/ad/common/protocol/IExtraInfo;", "getExtra", "()Lkntr/app/ad/common/protocol/IExtraInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdInfo extends IReportable {
    IExtraInfo getExtra();
}