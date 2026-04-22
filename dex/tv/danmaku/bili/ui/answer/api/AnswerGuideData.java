package tv.danmaku.bili.ui.answer.api;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

public class AnswerGuideData {
    @JSONField(name = "activity_material")
    public ActivityMaterial activityMaterial;
    @JSONField(name = "activity_type")
    public int activityType;
    @JSONField(name = "button_b")
    public String buttonCancel;
    @JSONField(name = "button_a")
    public String buttonConfirm;
    @JSONField(name = "invite_code_text")
    public String buttonInviteCode;
    public String desc;
    public boolean forceNight;
    @JSONField(name = "rewards")
    public List<GuideReward> guideRewards;
    public String link;
    public String title;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ActivityMaterial {
        @JSONField(name = "button_1")
        public String button1;
        @JSONField(name = "button_2")
        public String button2;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        public String title;
        @JSONField(name = "url")
        public String url;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class GuideReward {
        public String image;
        public String text;
    }
}