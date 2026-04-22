package tv.danmaku.bili.utils.storage.dp;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
public class DocumentProviderCompatV24 extends DocumentProviderCompatV21 {
    @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatV21, tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.BaseDocumentProviderCompat
    boolean isAuthorizedPermissionCurrentMounted(StorageManager manager, String secondaryUuid) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<StorageVolume> volumes = manager.getStorageVolumes();
        if (volumes.size() > 1) {
            for (StorageVolume volume : volumes) {
                if (!volume.isPrimary()) {
                    String uuid = volume.getUuid();
                    if (!TextUtils.isEmpty(uuid) && uuid.equals(secondaryUuid)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatV21, tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.BaseDocumentProviderCompat
    int getChildPathIndex(String filePath, StorageManager manager, String secondaryUuid) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<StorageVolume> volumes = manager.getStorageVolumes();
        if (volumes.size() > 1) {
            for (StorageVolume volume : volumes) {
                if (!volume.isPrimary()) {
                    String uuid = volume.getUuid();
                    if (!TextUtils.isEmpty(uuid) && uuid.equals(secondaryUuid)) {
                        if (sMethodGetVolumePath == null) {
                            sMethodGetVolumePath = StorageVolume.class.getMethod("getPath", new Class[0]);
                        }
                        String path = (String) sMethodGetVolumePath.invoke(volume, new Object[0]);
                        if (filePath.startsWith(path)) {
                            return path.length();
                        }
                    }
                }
            }
            return -1;
        }
        return -1;
    }
}