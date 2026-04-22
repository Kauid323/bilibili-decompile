package e;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import g.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class e extends AsyncTask<WeiboMultiMessage, Void, d> {
    public WeakReference<Context> a;
    public c b;

    public e(Context context, a aVar) {
        this.a = new WeakReference<>(context);
        this.b = aVar;
    }

    @Override // android.os.AsyncTask
    public final d doInBackground(WeiboMultiMessage[] weiboMultiMessageArr) {
        WeiboMultiMessage weiboMultiMessage;
        String str;
        Uri uri;
        WeiboMultiMessage[] weiboMultiMessageArr2 = weiboMultiMessageArr;
        Context context = this.a.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr2[0]) == null) {
            return null;
        }
        a.C0022a a = g.a.a(context);
        if (a == null) {
            str = "";
        } else {
            str = a.a;
        }
        if (TextUtils.isEmpty(str)) {
            str = "com.sina.weibo";
        }
        d dVar = new d();
        try {
            if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                weiboMultiMessage.imageObject = null;
            }
            if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.imageObject != null || weiboMultiMessage.multiImageObject != null)) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    Uri uri2 = (Uri) it.next();
                    if (uri2 != null && g.b.c(context, uri2)) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            arrayList.add(uri2);
                            context.grantUriPermission(str, uri2, 1);
                        } else {
                            String a2 = b.a(context, uri2, 1);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(Uri.fromFile(new File(a2)));
                            } else {
                                throw new IllegalArgumentException("image's path is null");
                            }
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (videoSourceObject != null && (uri = videoSourceObject.videoPath) != null && g.b.d(context, uri)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    videoSourceObject2.videoPath = uri;
                    videoSourceObject2.during = g.b.a(g.b.b(context, uri));
                    context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
                } else {
                    String a3 = b.a(context, uri, 0);
                    g.c.a("WBShareTag", "prepare video resource and video'path is" + a3);
                    if (!TextUtils.isEmpty(a3)) {
                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(a3));
                        weiboMultiMessage.videoSourceObject.during = g.b.a(a3);
                    } else {
                        throw new IllegalArgumentException("video's path is null");
                    }
                }
            }
            dVar.b = weiboMultiMessage;
            dVar.a = true;
        } catch (Throwable th) {
            dVar.a = false;
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            dVar.c = message;
            g.c.b("WBShareTag", "prepare resource error is :" + message);
        }
        return dVar;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(d dVar) {
        d dVar2 = dVar;
        super.onPostExecute(dVar2);
        c cVar = this.b;
        if (cVar != null) {
            a aVar = (a) cVar;
            aVar.a.b.setVisibility(4);
            if (dVar2 == null) {
                aVar.a.a("Trans result is null.");
            } else if (dVar2.a) {
                aVar.a.a(dVar2.b);
            } else if (TextUtils.isEmpty(dVar2.c)) {
                aVar.a.a("Trans resource fail.");
            } else {
                aVar.a.a(dVar2.c);
            }
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        super.onPreExecute();
    }
}