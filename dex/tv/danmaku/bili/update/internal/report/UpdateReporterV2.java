package tv.danmaku.bili.update.internal.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class UpdateReporterV2 {
    private static final int ARG_LENGTH = 6;
    private static final String EVENT_ID_MYTH_UPDATE_CLICK = "myth_update_click";
    private static final String EVENT_ID_UPDATE_DIALOG_CLICK = "update_dialog_click";
    private static final String EVENT_ID_UPDATE_DIALOG_RESULT = "update_dialog_result";
    private static final String EVENT_ID_UPDATE_DIALOG_SHOW = "update_dialog_show";
    private static final String EVENT_ID_UPDATE_DOWNLOAD = "update_download";
    private static final String EVENT_TYPE_CLICK = "click";
    private static final String EVENT_TYPE_SHOW = "show";
    private static final String EVENT_TYPE_TIMES = "times";
    private static final String TABLE_GENERAL_EVENT = "000225";

    public static void reportDialogShow(String... args) {
        String[] values = concatenateGeneralEvent(EVENT_ID_UPDATE_DIALOG_SHOW, EVENT_TYPE_SHOW, args);
        RuntimeHelper.reportV2(false, "000225", values);
    }

    public static void reportUpdateDownload(String... args) {
        String[] values = concatenateGeneralEvent(EVENT_ID_UPDATE_DOWNLOAD, EVENT_TYPE_TIMES, args);
        RuntimeHelper.reportV2(false, "000225", values);
    }

    public static void reportManualUpdate() {
        String[] values = concatenateGeneralEvent(EVENT_ID_MYTH_UPDATE_CLICK, EVENT_TYPE_CLICK, "");
        RuntimeHelper.reportV2(false, "000225", values);
    }

    public static void reportDialogResult(String... args) {
        String[] values = concatenateGeneralEvent(EVENT_ID_UPDATE_DIALOG_RESULT, EVENT_TYPE_TIMES, args);
        RuntimeHelper.reportV2(false, "000225", values);
    }

    public static void reportDialogClick(String... args) {
        String[] values = concatenateGeneralEvent(EVENT_ID_UPDATE_DIALOG_CLICK, EVENT_TYPE_CLICK, args);
        RuntimeHelper.reportV2(false, "000225", values);
    }

    private static String[] concatenateGeneralEvent(String eventId, String eventType, String... args) {
        List<String> valueList = new ArrayList<>(Arrays.asList(args));
        int diff = 6 - valueList.size();
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                valueList.add("");
            }
        }
        int i2 = valueList.size();
        String[] values = new String[i2 + 2];
        values[0] = eventId;
        values[1] = eventType;
        System.arraycopy(valueList.toArray(new String[valueList.size()]), 0, values, 2, valueList.size());
        return values;
    }
}