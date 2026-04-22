package tv.danmaku.bili.services.videodownload.action;

import android.content.Context;
import android.content.Intent;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;
import com.bilibili.videodownloader.service.VideoDownloadService;
import java.util.ArrayList;
import java.util.Collections;

public final class VideoDownloadActionServiceHelper {
    public static void startByService(Context context, ServiceCustomizableAction... action) {
        try {
            ArrayList<ServiceCustomizableAction> list = new ArrayList<>();
            Collections.addAll(list, action);
            Intent intent = obtainIntent(context, "videodownload_customizable_action_by_service", true, list);
            context.startService(intent);
        } catch (Exception e) {
        }
    }

    public static void startByBroadcast(Context context, ServiceCustomizableAction... action) {
        ArrayList<ServiceCustomizableAction> list = new ArrayList<>();
        Collections.addAll(list, action);
        Intent intent = obtainIntent(context, "videodownload_customizable_action_by_broadcast", false, list);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    static Intent obtainIntent(Context context, String intentAction, boolean service, ArrayList<ServiceCustomizableAction> cusActions) {
        Intent intent = new Intent(intentAction);
        if (service) {
            intent.setClass(context, VideoDownloadService.class);
        }
        if (cusActions != null && cusActions.size() != 0) {
            intent.putExtra("videodownload_service_customizable_key", cusActions);
        }
        return intent;
    }
}