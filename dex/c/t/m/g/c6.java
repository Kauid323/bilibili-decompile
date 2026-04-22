package c.t.m.g;

import android.telephony.CellInfo;
import java.util.List;

/* compiled from: TML */
public class c6 extends b6 {
    public List<CellInfo> f;

    public c6() {
        this.a = "CELL_TYPE_CELLINFOS";
    }

    @Override // c.t.m.g.b6
    public void c() {
        super.c();
        this.f = null;
    }

    public String toString() {
        return "TxSystemCellInfo{cellInfos=" + this.f + ", mCellType='" + this.a + "', mGetFromSystemTime=" + this.b + ", isFromListenChanged=" + this.f12c + ", mLastTxCellInfo=" + this.d + ", mTxCellInfoUpdateTime=" + this.e + '}';
    }
}