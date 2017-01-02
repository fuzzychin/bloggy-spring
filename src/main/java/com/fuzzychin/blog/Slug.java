package com.fuzzychin.blog;


import java.util.regex.Pattern;

public class Slug {

    private static final Pattern UNDESIREABLES = Pattern.compile("[_\\W\\s+]+");

    public String dasher(String str){
        return UNDESIREABLES.matcher(str).replaceAll("-");
    }

}
