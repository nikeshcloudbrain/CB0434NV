package com.creditscoreinfo.report.check.model;


public class AdData {



    public String id;
    public String name;
    public String icon;
    public String url;

    public AdData(String id, String name, String icon, String url){
        this.id=id;
        this.name=name;
        this.icon=icon;
        this.url=url;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getIcon(){
        return icon;
    }

    public String getUrl(){
        return url;
    }



}


