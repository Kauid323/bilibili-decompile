package tv.danmaku.bili.ui.theme.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.okretro.BaseResponse;
import java.util.ArrayList;

public class BiliSkinList extends BaseResponse implements Cloneable {
    @JSONField(name = "data")
    public ArrayList<BiliSkin> mList;
    @JSONField(name = "ts")
    public long mTs;

    public Object clone() {
        BiliSkinList clone = new BiliSkinList();
        if (this.mList != null) {
            clone.mList = new ArrayList<>(this.mList);
        }
        clone.mTs = this.mTs;
        clone.code = this.code;
        return clone;
    }

    public String toString() {
        return "BiliSkinList{mList=" + this.mList + ", mTs=" + this.mTs + '}';
    }
}