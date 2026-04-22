package tv.danmaku.bili.report.biz.httpdns;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.Applications;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.httpdns.DNSRecord;
import com.bilibili.lib.httpdns.HttpDNSApiQualityReporter;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.httpdns.AppHttpDnsProvider;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

public class HttpDnsReporter implements HttpDNSApiQualityReporter {
    public static HttpDnsReporter newInstance() {
        return new HttpDnsReporter();
    }

    public void onEvent(HttpDNSApiQualityReporter.Event event) {
        if (((Boolean) ConfigManager.ab().get("http_dns_reporter", false)).booleanValue()) {
            reportHttpDns(event);
        }
        MisakaApmHttpDnsKt.report(event);
    }

    private void reportHttpDns(final HttpDNSApiQualityReporter.Event event) {
        HandlerThreads.getHandler(2).post(new Runnable() { // from class: tv.danmaku.bili.report.biz.httpdns.HttpDnsReporter.1
            @Override // java.lang.Runnable
            public void run() {
                String body = HttpDnsReporter.this.body(event);
                BLog.d("HttpDNSReporter", body);
                Request request = new Request.Builder().url("http://116.62.182.15/http_dns").post(RequestBody.create(MediaType.parse("text/json"), body)).build();
                Closeable closeable = null;
                try {
                    try {
                        closeable = OkHttpClientWrapper.get().newBuilder().eventListener(EventListener.NONE).build().newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } finally {
                    IOUtils.closeQuietly((Closeable) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String body(HttpDNSApiQualityReporter.Event event) {
        JSONObject root = new JSONObject();
        String provider = null;
        Context ctx = Applications.getCurrent();
        root.put("client_version", ctx == null ? "" : Foundation.instance().getApps().getVersionName());
        root.put("client_os", "android");
        root.put("http_code", Integer.valueOf(event.httpCode));
        String errorMsg = getThrowableString(event.throwable);
        if (!TextUtils.isEmpty(errorMsg)) {
            root.put("error_message", errorMsg);
        }
        root.put("cost_time", Long.valueOf(event.timeCost));
        root.put("http_dns_ip", event.httpDnsIp);
        List<JSONObject> dnsJson = new ArrayList<>();
        List<DNSRecord> records = event.records;
        for (DNSRecord record : records) {
            provider = record.provider;
            JSONObject recordJson = new JSONObject();
            recordJson.put(ReportEvent.Tag.HOST, record.host);
            if (record.ips != null) {
                recordJson.put("ips", record.ips);
            }
            recordJson.put("ttl", Integer.valueOf(record.ttl));
            recordJson.put("origin_ttl", Integer.valueOf(record.originTtl));
            dnsJson.add(recordJson);
        }
        root.put(AppHttpDnsProvider.EXTRA_KEY_DNS, dnsJson);
        root.put("http_dns_provider", provider);
        return root.toJSONString();
    }

    private String getThrowableString(Throwable t) {
        StringBuilder builder = new StringBuilder();
        if (t != null) {
            builder.append(t.toString()).append(", ").append(t.getMessage());
        }
        return builder.toString();
    }

    private String getStackTrace(Throwable t) {
        if (t == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}