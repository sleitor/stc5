package com.company;

import java.io.File;
import java.net.URL;

/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
public class Resource {

    private String name;
    private File data;
    private URL urldata;

    public Resource (String name, File data ) {
        this.name = name;
        this.data = data;
    }

    public Resource (String name, URL urldata ) {
        this.name = name;
        this.urldata = urldata;

    }

    public String getName () {
        return name;
    }

    public URL getUrldata () {
        return urldata;
    }

    public File getData () {
        return data;
    }
}
