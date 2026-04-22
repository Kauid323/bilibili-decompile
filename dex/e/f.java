package e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.SuperGroupObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tauth.Tencent;
import g.a;
import java.util.ArrayList;

public final class f {
    public long a;

    /* JADX WARN: Removed duplicated region for block: B:48:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Activity activity, WeiboMultiMessage weiboMultiMessage) {
        boolean z;
        if (activity == null) {
            return;
        }
        if (weiboMultiMessage != null) {
            ArrayList arrayList = new ArrayList();
            TextObject textObject = weiboMultiMessage.textObject;
            if (textObject != null) {
                arrayList.add(textObject);
            }
            ImageObject imageObject = weiboMultiMessage.imageObject;
            if (imageObject != null) {
                arrayList.add(imageObject);
            }
            MediaObject mediaObject = weiboMultiMessage.mediaObject;
            if (mediaObject != null) {
                arrayList.add(mediaObject);
            }
            MultiImageObject multiImageObject = weiboMultiMessage.multiImageObject;
            if (multiImageObject != null) {
                arrayList.add(multiImageObject);
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (videoSourceObject != null) {
                arrayList.add(videoSourceObject);
            }
            SuperGroupObject superGroupObject = weiboMultiMessage.superGroupObject;
            if (superGroupObject != null) {
                arrayList.add(superGroupObject);
            }
            if (weiboMultiMessage.superGroupObject != null) {
                a.C0022a a = g.a.a(activity);
                z = false;
                if (!(a != null && a.c >= 10791)) {
                    SuperGroupObject superGroupObject2 = weiboMultiMessage.superGroupObject;
                    if (!arrayList.isEmpty() && superGroupObject2 != null && arrayList.contains(superGroupObject2) && arrayList.size() == 1) {
                        Toast.makeText(activity, "微博版本过低，不支持超话分享", 0).show();
                        if (z) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt("_weibo_command_type", 1);
                        bundle.putString("_weibo_transaction", System.currentTimeMillis() + "");
                        bundle.putAll(weiboMultiMessage.writeToBundle(bundle));
                        Intent intent = new Intent(activity, ShareTransActivity.class);
                        intent.putExtra("start_flag", HardCoderJNI.FUNC_CHECK_PERMISSION);
                        intent.putExtras(bundle);
                        activity.startActivityForResult(intent, Tencent.REQUEST_LOGIN);
                        return;
                    }
                    weiboMultiMessage.superGroupObject = null;
                }
            }
        }
        z = true;
        if (z) {
        }
    }
}