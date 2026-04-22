package io.reactivex.rxjava3.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueueDrainSubscriber.java */
public class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();
}