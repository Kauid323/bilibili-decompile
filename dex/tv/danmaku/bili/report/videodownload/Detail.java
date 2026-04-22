package tv.danmaku.bili.report.videodownload;

import com.alibaba.fastjson.annotation.JSONField;
import org.json.JSONException;
import org.json.JSONObject;

public class Detail {
    @JSONField(name = "time_deserialize")
    public int deserializeTime;
    @JSONField(name = "time_serialize")
    public int serializeTime;
    @JSONField(name = "total_count")
    public int totalCount;
    @JSONField(name = "time_transmit")
    public int transmitTime;

    @JSONField(deserialize = false, serialize = false)
    public int getTotalTime() {
        return this.transmitTime + this.deserializeTime + this.serializeTime;
    }

    public void clear() {
        this.totalCount = 0;
        this.transmitTime = 0;
        this.serializeTime = 0;
        this.deserializeTime = 0;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isValid() {
        return this.transmitTime > 0 || this.serializeTime > 0 || this.deserializeTime > 0;
    }

    public JSONObject toJsonObject() {
        JSONObject object = null;
        try {
            if (this.serializeTime > 0) {
                object = new JSONObject();
                object.put("time_serialize", this.serializeTime);
            }
            if (this.deserializeTime > 0) {
                if (object == null) {
                    object = new JSONObject();
                }
                object.put("time_deserialize", this.deserializeTime);
            }
            if (this.transmitTime > 0) {
                if (object == null) {
                    object = new JSONObject();
                }
                object.put("time_transmit", this.transmitTime);
            }
            if (this.totalCount > 0) {
                if (object == null) {
                    object = new JSONObject();
                }
                object.put("total_count", this.totalCount);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }
}