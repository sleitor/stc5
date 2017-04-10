package com.company;

import java.io.File;
import java.net.URL;

/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
class Resource {

    private String name;
    private File data;
    private URL urldata;

    Resource(String name, File data) {
        this.name = name;
        this.data = data;
    }

    Resource(String name, URL urldata) {
        this.name = name;
        this.urldata = urldata;

    }

    String getName() {
        return name;
    }

    URL getUrldata() {
        return urldata;
    }

    File getData() {
        return data;
    }
}
