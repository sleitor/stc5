package com.company;

/**
 * Created by Троицкий Дмитрий on 06.04.2017.
 */
public class Consumer {

    private long kube, doub, sim;

    public void set (long kube, long doub, long sim) {

        if (kube > 0) this.kube = kube;
        if (doub > 0) this.doub = doub;
        if (sim > 0) this.sim = sim;
    }

    public void clear (){

        this.kube = this.doub = this.sim = 0;
    }

    public long sum () {

        return this.kube +  this.doub + this.sim;
    }



}
