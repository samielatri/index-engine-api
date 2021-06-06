package com.dant.service;

public interface MemorySystem {

    Runtime runtime = Runtime.getRuntime();

    default long getMaxMemory() {
        return runtime.maxMemory();
    }

    default long getUsedMemory() {
        return getMaxMemory() - getFreeMemory();
    }

    default long getTotalMemory() {
        return runtime.totalMemory();
    }

    default long getFreeMemory() {
        return runtime.freeMemory();
    }

}