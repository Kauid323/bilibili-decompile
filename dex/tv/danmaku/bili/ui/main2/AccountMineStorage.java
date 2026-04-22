package tv.danmaku.bili.ui.main2;

import android.content.Context;
import android.text.TextUtils;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bilibili.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* JADX INFO: Access modifiers changed from: package-private */
public class AccountMineStorage {
    private static final String FILE_NAME = "account_mine.data";

    AccountMineStorage() {
    }

    public static void saveAsync(final Context context, final AccountMine mine) {
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.ui.main2.AccountMineStorage.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                AccountMineStorage.delete(context);
                AccountMineStorage.save(context, mine);
                return null;
            }
        });
    }

    public static void save(Context context, AccountMine mine) {
        if (mine == null) {
            return;
        }
        FileOutputStream stream = null;
        try {
            try {
                stream = context.openFileOutput(FILE_NAME, 0);
                String jsonStr = JSON.toJSONString(mine);
                IOUtils.write(jsonStr, stream);
            } finally {
                IOUtils.closeQuietly(stream);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static AccountMine read(Context context) {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            if (file.isDirectory()) {
                file.delete();
                return null;
            }
            String jsonStr = null;
            FileInputStream stream = null;
            try {
                try {
                    stream = new FileInputStream(file);
                    jsonStr = IOUtils.toString(stream);
                } catch (IOException e) {
                    BLog.e(e.getMessage(), e);
                }
                if (TextUtils.isEmpty(jsonStr)) {
                    return null;
                }
                try {
                    AccountMine mineInfo = (AccountMine) JSON.parseObject(jsonStr, AccountMine.class);
                    return mineInfo;
                } catch (JSONException e2) {
                    BLog.e(e2.getMessage(), (Throwable) e2);
                    return null;
                }
            } finally {
                IOUtils.closeQuietly(stream);
            }
        }
        return null;
    }

    public static void deleteAsync(final Context context) {
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.ui.main2.AccountMineStorage.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                AccountMineStorage.delete(context);
                return null;
            }
        });
    }

    public static void delete(Context context) {
        context.deleteFile(FILE_NAME);
    }
}