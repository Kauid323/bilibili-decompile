package tv.danmaku.bili.ui.userfeedback;

import com.alibaba.fastjson.annotation.JSONField;

public class UserFeedbackTag {
    @JSONField(name = "id")
    public String id;
    @JSONField(name = "name")
    public String name;

    public UserFeedbackTag() {
    }

    public UserFeedbackTag(String id, String name) {
        this.id = id;
        this.name = name;
    }
}