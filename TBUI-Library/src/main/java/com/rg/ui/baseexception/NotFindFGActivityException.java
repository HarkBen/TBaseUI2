package com.rg.ui.baseexception;

/**
 * Created by Administrator on 2016/7/5.
 */
public class NotFindFGActivityException extends  Exception{

    public NotFindFGActivityException(){
        this("colorful- This Activity does not extends TBaseFragmentGroupActivity !!!!!!!!");
    }
    public NotFindFGActivityException(String error){
        super(error);
    }
}
