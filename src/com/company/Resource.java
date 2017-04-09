package com.company;

import java.io.File;
/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
public class Resource {

    private String name;
    private File data;

    public Resource (String name, File data ) {
        this.name = name;
        this.data = data;

    }

    public String getName () {
        return name;
    }

    public File getData () {
        return data;
    }
}
