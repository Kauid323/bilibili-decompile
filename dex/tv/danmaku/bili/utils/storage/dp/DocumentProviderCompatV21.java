package tv.danmaku.bili.utils.storage.dp;

import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper;

/* JADX INFO: Access modifiers changed from: package-private */
public class DocumentProviderCompatV21 extends DocumentProviderCompatHelper.BaseDocumentProviderCompat {
    @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.BaseDocumentProviderCompat
    boolean isAuthorizedPermissionCurrentMounted(StorageManager manager, String secondaryUuid) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        if (sMethodGetVolumeList == null) {
            sMethodGetVolumeList = StorageManager.class.getMethod("getVolumeList", new Class[0]);
        }
        sMethodGetVolumeList.setAccessible(true);
        Object[] volumes = (Object[]) sMethodGetVolumeList.invoke(manager, new Object[0]);
        if (volumes != null && volumes.length > 1) {
            if (sMethodGetVolumeUUid == null) {
                Class volumeClz = Class.forName("android.os.storage.StorageVolume");
                sMethodGetVolumeUUid = volumeClz.getMethod("getUuid", new Class[0]);
            }
            for (Object volume : volumes) {
                String uuid = (String) sMethodGetVolumeUUid.invoke(volume, new Object[0]);
                if (!TextUtils.isEmpty(uuid) && uuid.equals(secondaryUuid)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.BaseDocumentProviderCompat
    int getChildPathIndex(String filePath, StorageManager manager, String secondaryUuid) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if (sMethodGetVolumeList == null) {
            sMethodGetVolumeList = StorageManager.class.getMethod("getVolumeList", new Class[0]);
        }
        sMethodGetVolumeList.setAccessible(true);
        Object[] volumes = (Object[]) sMethodGetVolumeList.invoke(manager, new Object[0]);
        if (volumes != null && volumes.length > 1) {
            if (sMethodGetVolumePath == null) {
                Class volumeClz = Class.forName("android.os.storage.StorageVolume");
                sMethodGetVolumePath = volumeClz.getMethod("getPath", new Class[0]);
                sMethodGetVolumeUUid = volumeClz.getMethod("getUuid", new Class[0]);
            }
            for (Object volume : volumes) {
                String uuid = (String) sMethodGetVolumeUUid.invoke(volume, new Object[0]);
                if (!TextUtils.isEmpty(uuid) && uuid.equals(secondaryUuid)) {
                    String path = (String) sMethodGetVolumePath.invoke(volume, new Object[0]);
                    if (filePath.startsWith(path)) {
                        return path.length();
                    }
                }
            }
            return -1;
        }
        return -1;
    }
}