package tv.danmaku.bili.report.misaka.api;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.bili.BuildConfig;

public class MisakaRule {
    public String host;
    @JSONField(name = "report_code")
    public int[] reportCode;

    public MisakaRule() {
    }

    public MisakaRule(String host, int[] reportCode) {
        this.host = host;
        this.reportCode = reportCode;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.host) || this.reportCode == null) ? false : true;
    }

    public boolean isHostMatched(String host) {
        if (BuildConfig.DEBUG && !isValid()) {
            return false;
        }
        return this.host.equals(host);
    }

    public boolean isRuleMatched(String host, int respcode) {
        if (isHostMatched(host)) {
            if (this.reportCode.length == 0) {
                return true;
            }
            for (int j = 0; j < this.reportCode.length; j++) {
                if (respcode == this.reportCode[j]) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{host = ").append(this.host).append(", code = ");
        if (this.reportCode == null) {
            stringBuilder.append("[]");
        } else {
            int iMax = this.reportCode.length - 1;
            if (iMax == -1) {
                stringBuilder.append("[]");
            } else {
                stringBuilder.append('[');
                int i = 0;
                while (true) {
                    stringBuilder.append(this.reportCode[i]);
                    if (i == iMax) {
                        break;
                    }
                    stringBuilder.append(", ");
                    i++;
                }
                stringBuilder.append(']');
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static List<MisakaRule> getDefaultRuleList() {
        List<MisakaRule> list = new ArrayList<>();
        list.add(new MisakaRule("app.bilibili.com", new int[]{-500, -502, -504}));
        list.add(new MisakaRule("api.bilibili.com", new int[]{-500, 11011}));
        list.add(new MisakaRule("space.bilibili.com", new int[0]));
        list.add(new MisakaRule("bangumi.bilibili.com", new int[]{-500, -501, -502, -504}));
        list.add(new MisakaRule("live.bilibili.com", new int[]{-500, -502, -504}));
        list.add(new MisakaRule("pay.bilibili.com", new int[]{-405, -500}));
        list.add(new MisakaRule("elec.bilibili.com", new int[]{-405, -500}));
        return list;
    }

    public static List<MisakaRule> checkListValid(List<MisakaRule> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        Iterator<MisakaRule> iter = list.iterator();
        while (iter.hasNext()) {
            if (!iter.next().isValid()) {
                iter.remove();
            }
        }
        return list;
    }
}