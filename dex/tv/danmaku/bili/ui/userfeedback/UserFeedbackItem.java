package tv.danmaku.bili.ui.userfeedback;

import com.alibaba.fastjson.annotation.JSONField;

public class UserFeedbackItem {
    public String content;
    public long ctime;
    public boolean guide;
    @JSONField(name = "img_url")
    public String imgUrl;
    @JSONField(name = "log_url")
    public String logUrl;
    @JSONField(name = "reply_id")
    public String replyId;
    public int type;
}