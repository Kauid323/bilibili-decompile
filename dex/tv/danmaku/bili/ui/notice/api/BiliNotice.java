package tv.danmaku.bili.ui.notice.api;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.okretro.BaseResponse;
import tv.danmaku.bili.ui.notice.CommonNoticeBar;

public class BiliNotice extends BaseResponse {
    public Data data;
    public boolean isCancel;
    public String ver;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Data {
        public String content;
        @JSONField(name = "end_time")
        public long endTime;
        public long id;
        @JSONField(name = "start_time")
        public long startTime;
        public String title;
        public String uri;

        public boolean isValid(Context context) {
            long timeInSecond = System.currentTimeMillis() / 1000;
            return (context == null || TextUtils.isEmpty(this.content) || timeInSecond <= this.startTime || timeInSecond >= this.endTime || BiliGlobalPreferenceHelper.getInstance(context).optLongOrInteger(CommonNoticeBar.KEY_ID, -1L) == this.id) ? false : true;
        }
    }
}