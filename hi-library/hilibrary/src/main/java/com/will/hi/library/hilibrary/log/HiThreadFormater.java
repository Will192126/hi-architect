package com.will.hi.library.hilibrary.log;

public class HiThreadFormater implements HiLogFormater<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}
