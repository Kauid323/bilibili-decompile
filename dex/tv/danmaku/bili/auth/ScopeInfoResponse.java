package tv.danmaku.bili.auth;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class ScopeInfoResponse {
    public Agreement agreement;
    @JSONField(name = "app")
    public AppInfo appInfo;
    public List<Scope> scopes;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Agreement {
        @JSONField(name = "is_select")
        public int isSelect;
        @JSONField(name = "match")
        public List<Match> list;
        public String str;
        @JSONField(name = "check_notify")
        public String toastNotify;

        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static class Match {
            public String name;
            public String url;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AppInfo {
        public String icon;
        public long id;
        public String name;
        public String url;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Scope {
        public String desc;
        @JSONField(name = "is_select")
        public int isSelected;
        public String scope;
        public String title;
    }
}