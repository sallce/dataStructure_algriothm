package com.dataStructure_algriothm.systemDesign;

public class Singleton {
    //private constructor avoid creating instance
    private Singleton(){}

    //the single instance which would be used
    //volatile keyword keeps instruction order for creating instance
    private volatile static Singleton instance = null;

    //factory function, returning the static instance
    public Singleton getInstance(){
        if(instance == null){ //check if need to create instance

            // lock the whole class
            synchronized (this) {
                if(instance == null){//double check instance is null
                    instance = new Singleton();
                }
            }

        }

        return instance;
    }

}
