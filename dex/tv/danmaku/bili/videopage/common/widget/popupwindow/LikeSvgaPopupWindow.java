package tv.danmaku.bili.videopage.common.widget.popupwindow;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import tv.danmaku.bili.videopage.common.helper.UniversalHelper;
import tv.danmaku.ijk.media.player.BuildConfig;

public class LikeSvgaPopupWindow extends PopupWindow {
    private Context context;
    private SVGAImageView svgaImageView;

    public LikeSvgaPopupWindow(Context context) {
        super(context);
        this.context = context;
        this.svgaImageView = new SVGAImageView(context);
        this.svgaImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setContentView(this.svgaImageView);
        setWidth(UniversalHelper.dp2px(context, 96.0f));
        setHeight(UniversalHelper.dp2px(context, 96.0f));
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        setFocusable(false);
    }

    public void show(View anchor, URL url) {
        if (url == null) {
            return;
        }
        new SVGAParser(this.context).parse(url, new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeSvgaPopupWindow.1
            public void onCacheExist() {
            }

            public void onError() {
            }

            public void onComplete(SVGAVideoEntity videoItem) {
                LikeSvgaPopupWindow.this.svgaImageView.setLoops(1);
                LikeSvgaPopupWindow.this.svgaImageView.setVideoItem(videoItem, ConfigManager.isHitFF("svga.canvas.drawer.repair.beila.like.bug"));
                LikeSvgaPopupWindow.this.svgaImageView.setCallback(new SVGACallback() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeSvgaPopupWindow.1.1
                    public void onPause() {
                    }

                    public void onFinished() {
                        LikeSvgaPopupWindow.this.dismiss();
                    }

                    public void onRepeat() {
                    }

                    public void onStep(int frame, double percentage) {
                    }

                    public void onPreStart() {
                    }
                });
                LikeSvgaPopupWindow.this.svgaImageView.stepToFrame(0, true);
            }
        });
        show(anchor);
    }

    public void show(View anchor, File svgaFile) throws FileNotFoundException {
        if (svgaFile == null) {
            return;
        }
        final FileInputStream inputStream = new FileInputStream(svgaFile);
        new SVGAParser(this.context).parse(inputStream, svgaFile.getName(), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeSvgaPopupWindow.2
            public void onCacheExist() {
            }

            public void onError() {
                IOUtils.closeQuietly(inputStream);
            }

            public void onComplete(SVGAVideoEntity videoItem) {
                IOUtils.closeQuietly(inputStream);
                LikeSvgaPopupWindow.this.svgaImageView.setLoops(1);
                LikeSvgaPopupWindow.this.svgaImageView.setVideoItem(videoItem);
                LikeSvgaPopupWindow.this.svgaImageView.setCallback(new SVGACallback() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeSvgaPopupWindow.2.1
                    public void onPause() {
                    }

                    public void onFinished() {
                        LikeSvgaPopupWindow.this.dismiss();
                    }

                    public void onRepeat() {
                    }

                    public void onStep(int frame, double percentage) {
                    }

                    public void onPreStart() {
                    }
                });
                LikeSvgaPopupWindow.this.svgaImageView.stepToFrame(0, true);
            }
        });
        show(anchor);
    }

    private void show(View anchor) {
        int[] location = new int[2];
        getLocation(anchor, location);
        int size = UniversalHelper.dp2px(this.context, 96.0f);
        showAtLocation(anchor, 8388659, location[0] + ((anchor.getWidth() - size) / 2), location[1] - size);
    }

    private void getLocation(View anchor, int[] location) {
        anchor.getLocationOnScreen(location);
        Rect rect = new Rect();
        boolean localVisibleRect = anchor.getGlobalVisibleRect(rect);
        if (localVisibleRect && !rect.isEmpty() && rect.top < location[1]) {
            location[1] = rect.top;
        }
    }

    public static File getSvgaFileFromMod(Context context, int likes) {
        String svgaName;
        File file;
        if (likes <= 99) {
            return null;
        }
        if (likes <= 999) {
            svgaName = "video_detail_like_animation_v2_1.svga";
        } else {
            svgaName = "video_detail_like_animation_v2_2.svga";
        }
        ModResource resource = ModResourceClient.getInstance().get(context, BuildConfig.IJKPLAYER_VERSION, "video_detail_like_animation");
        if (resource.isAvailable() && (file = resource.retrieveFile(svgaName)) != null && file.exists()) {
            return file;
        }
        return null;
    }
}