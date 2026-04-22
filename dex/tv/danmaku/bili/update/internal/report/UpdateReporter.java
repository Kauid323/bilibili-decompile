package tv.danmaku.bili.update.internal.report;

import tv.danmaku.bili.update.utils.RuntimeHelper;

public class UpdateReporter {
    private static final String EVENT_ID_UPDATE = "app_update";
    private static final String EVENT_ID_UPDATE_SILENT = "app_update_silence";
    private static final String EVENT_TYPE = "show";
    public static final String TABLE_GENERAL_EVENT = "000225";
    public static final String UPDATE_DIALOG_ACCEPT = "2";
    public static final String UPDATE_DIALOG_SHOW = "1";
    public static final String UPDATE_DOWNLOAD_SUCCESS = "3";
    public static final String UPDATE_FAILED = "-1";
    public static final String UPDATE_SILENT_DOWNLOAD_FAILED = "-1";
    public static final String UPDATE_SILENT_DOWNLOAD_NEW = "1";
    public static final String UPDATE_SILENT_DOWNLOAD_SUCCESS = "2";
    public static final String UPDATE_SUCCESS = "4";

    public static void reportUpdate(String... args) {
        String[] values = concatenateGeneralEvent(EVENT_ID_UPDATE, EVENT_TYPE, args);
        RuntimeHelper.reportV2(false, "000225", values);
    }

    public static void reportUpdateSilent(String... args) {
        String[] values = concatenateGeneralEvent(EVENT_ID_UPDATE_SILENT, EVENT_TYPE, args);
        RuntimeHelper.reportV2(false, "000225", values);
    }

    public static void reportError(boolean silent, int code, String msg) {
        if (silent) {
            reportUpdateSilent("-1", msg, String.valueOf(code));
        } else {
            reportUpdate("-1", msg, String.valueOf(code));
        }
    }

    private static String[] concatenateGeneralEvent(String eventId, String eventType, String... args) {
        String[] values = new String[args.length + 2];
        values[0] = eventId;
        values[1] = eventType;
        System.arraycopy(args, 0, values, 2, args.length);
        return values;
    }
}