package tv.danmaku.ijk.media.player.services;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IAbrParamsInterface;

public class AbrParamsInterfaceClient extends IAbrParamsInterface.Stub {
    private static final String TAG = "AbrParamsInterfaceClient";

    private native int _getAbrParamInt(int i);

    private native void _setAbrParamsBundle(Bundle bundle);

    private native void _updateExperimentalGroup(HashMap<String, Integer> hashMap);

    private native void _updateOnlineConfigPair(String str, String str2);

    @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
    public void updateOnlineConfigBundle(Bundle configBundle) throws RemoteException {
        if (configBundle == null) {
            return;
        }
        for (String configKey : configBundle.keySet()) {
            String configStr = configBundle.getString(configKey);
            if (configStr != null) {
                _updateOnlineConfigPair(configKey, configStr);
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
    public void updateExperimentalGroup(Bundle expBundle) throws RemoteException {
        if (expBundle == null) {
            return;
        }
        HashMap<String, Integer> expHashMap = new HashMap<>(expBundle.size());
        for (String expKey : expBundle.keySet()) {
            expHashMap.put(expKey, Integer.valueOf(expBundle.getBoolean(expKey) ? 1 : 0));
        }
        _updateExperimentalGroup(expHashMap);
    }

    @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
    public void updateDynamicAbrParams(Bundle params) throws RemoteException {
        if (params == null) {
            return;
        }
        _setAbrParamsBundle(params);
    }

    @Override // tv.danmaku.ijk.media.player.IAbrParamsInterface
    public int getAbrParamInt(int type) throws RemoteException {
        return _getAbrParamInt(type);
    }
}