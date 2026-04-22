package tv.danmaku.bili.report.pv.spm;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.android.log.BLog;

final class PageModResourceResolver {
    private static final String CONFIG = "appSpmIdConf";
    private static final String POOL_NAME = "bigdata";
    private static final String RESOURCE_NAME = "androidSpmId";
    private static final String TAG = "PVM-PageModResourceResolver";
    private Context mContext;

    PageModResourceResolver(Context context) {
        this.mContext = context;
    }

    List<PositionModel> loadPositionModels() {
        List<ModelBean> models;
        ModResource resource = ModResourceClient.getInstance().get(this.mContext, POOL_NAME, RESOURCE_NAME);
        if (!resource.isAvailable()) {
            BLog.d(TAG, "ModResource is not available");
            return null;
        }
        File configFile = resource.retrieveFile(CONFIG);
        if (configFile == null || !configFile.exists() || !configFile.isFile()) {
            BLog.d(TAG, "The mod resource config file is unavailable.");
            return null;
        }
        String configStr = readConfigFromFile(configFile);
        if (TextUtils.isEmpty(configStr) || (models = JSONArray.parseArray(configStr, ModelBean.class)) == null || models.size() <= 0) {
            return null;
        }
        return convertConfigs(models);
    }

    private String readConfigFromFile(File configFile) {
        String configStr = null;
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            try {
                try {
                    fr = new FileReader(configFile);
                    reader = new BufferedReader(fr);
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    configStr = sb.toString();
                    fr.close();
                    reader.close();
                } catch (Throwable th) {
                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw th;
                        }
                    }
                    if (reader != null) {
                        reader.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                BLog.efmt(TAG, "read config file failed.", new Object[0]);
                if (fr != null) {
                    fr.close();
                }
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return configStr;
    }

    private List<PositionModel> convertConfigs(List<ModelBean> configList) {
        List<PositionModel> result = new ArrayList<>();
        for (ModelBean item : configList) {
            if (!checkValid(item)) {
                BLog.e(TAG, "invalid config item exist !!!");
            } else {
                result.add(PositionModel.createFromJson(item));
            }
        }
        return result;
    }

    private boolean checkValid(ModelBean data) {
        return (TextUtils.isEmpty(data.mSpmId) || TextUtils.isEmpty(data.mPattern)) ? false : true;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ModelBean {
        @JSONField(name = "android_url_pattern")
        public String mPattern;
        @JSONField(name = "spm_id")
        public String mSpmId;

        public String toString() {
            return "ModelBean{mSpmId='" + this.mSpmId + "', mPattern='" + this.mPattern + "'}";
        }
    }
}