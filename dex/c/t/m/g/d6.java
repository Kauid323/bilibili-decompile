package c.t.m.g;

import android.telephony.CellLocation;
import android.telephony.SignalStrength;

/* compiled from: TML */
public class d6 extends b6 {
    public CellLocation f;
    public SignalStrength g;

    public d6() {
        this.a = "CELL_TYPE_CELLLOCATION";
    }

    @Override // c.t.m.g.b6
    public void c() {
        super.c();
        this.f = null;
        this.g = null;
    }

    public String toString() {
        return "TxSystemCellLocation{cellLocation=" + this.f + ", strength=" + this.g + ", mCellType='" + this.a + "', mGetFromSystemTime=" + this.b + ", isFromListenChanged=" + this.f12c + ", mLastTxCellInfo=" + this.d + ", mTxCellInfoUpdateTime=" + this.e + '}';
    }
}