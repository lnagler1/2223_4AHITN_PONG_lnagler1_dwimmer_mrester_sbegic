package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

public interface PublisherInterface<T> {
    public void addSubscriber(SubscriberInterface<T> sub);

    public void removeSubscriber(SubscriberInterface<T> sub);

    public void notifySubscriber(T what);
}
