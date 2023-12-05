package com.example.base_module;

import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

public final class ServiceManager {
    private static final ConcurrentHashMap<String, Object> sServices = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ServiceCreator<?>> sServiceCreators = new ConcurrentHashMap<>();

    private ServiceManager() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getService(@NonNull Class<T> iCls) {
        return getService(iCls.getName());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getService(@NonNull String name) {
        T service = (T) sServices.get(name);
        if (service == null) {
            synchronized (sServices) {
                service = (T) sServices.get(name);
                if (service == null) {
                    ServiceCreator<T> creator = (ServiceCreator) sServiceCreators.get(name);
                    if (creator != null) {
                        service = creator.create();
                        sServices.put(name, service);
                        sServiceCreators.remove(name);
                    }
                }
            }
        }
        return service;
    }

    public static <T> void registerService(@NonNull Class<T> iCls, @NonNull T obj) {
        registerService(iCls.getName(), obj);
    }

    public static <T> void registerService(@NonNull String name, @NonNull T obj) {
        sServices.put(name, obj);
    }

    public static <T> void registerService(@NonNull Class<T> iCls, @NonNull ServiceCreator<T> creator) {
        registerService(iCls.getName(), creator);
    }

    public static <T> void registerService(@NonNull String name, @NonNull ServiceCreator<T> creator) {
        sServiceCreators.put(name, creator);
    }

    public static <T> void unregisterService(@NonNull Class<T> iCls) {
        unregisterService(iCls.getName());
    }

    public static <T> void unregisterService(@NonNull String name) {
        sServices.remove(name);
        sServiceCreators.remove(name);
    }

    public static void clearAll(){
        sServices.clear();
        sServiceCreators.clear();
    }
}
