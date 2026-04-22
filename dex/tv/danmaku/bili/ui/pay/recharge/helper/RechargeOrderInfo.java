package tv.danmaku.bili.ui.pay.recharge.helper;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

@Deprecated
public class RechargeOrderInfo implements Serializable {
    @JSONField(name = "amount")
    public float amount;
    @JSONField(name = "from")
    public int from;
    @JSONField(name = "orderNo")
    public String orderNo;

    public RechargeOrderInfo() {
    }

    public RechargeOrderInfo(String orderNo, float amount, int from) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.from = from;
    }
}