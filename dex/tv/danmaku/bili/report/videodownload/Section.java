package tv.danmaku.bili.report.videodownload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;

public class Section {
    public static final int TYPE_CLIENT_DOWNLOAD_ADD = 6;
    public static final int TYPE_CLIENT_DOWNLOAD_DELETE = 7;
    public static final int TYPE_CLIENT_DOWNLOAD_RESUME = 9;
    public static final int TYPE_CLIENT_DOWNLOAD_STOP = 8;
    public static final int TYPE_CLIENT_QUERY_DOWNLOAD_ALL_LIST = 5;
    public static final int TYPE_CLIENT_QUERY_DOWNLOAD_AV_LIST = 3;
    public static final int TYPE_CLIENT_QUERY_DOWNLOAD_SEASON_LIST = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_SERVER_NOTIFY_DOWNLOAD_ITEM = 2;
    public static final int TYPE_SERVER_SCAN_ALL_DOWNLOAD_LIST = 1;
    private static int[] sSectionTrigger = {FlowControlConfig.RETRY_MAX_TIMES, 2, 900, 100, 25, 10, 50, 20, 10, 10};
    private static String[] sSectionName = {"none", "server_scan_list", "server_notify_item", "client_query_av_list", "client_query_season_list", "client_query_all_list", "client_add", "client_delete", "client_stop", "client_resume"};

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface SectionType {
    }

    public static int getSectionTypeSize() {
        return sSectionName.length;
    }

    public static String getSectionName(int sectionType) {
        return sSectionName[sectionType];
    }

    public static int getSectionTriggerCount(int sectionType) {
        return sSectionTrigger[sectionType];
    }
}