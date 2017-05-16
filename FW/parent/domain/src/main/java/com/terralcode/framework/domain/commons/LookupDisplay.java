/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.commons;

/**
 *
 * @author jmsuarez
 */
public class LookupDisplay {
    
    protected long id = -1;
    protected String desc = "EMPTY";
    

    public LookupDisplay(){
        this.id = -1;
        this.desc = "EMPTY";
    }
    public LookupDisplay(long id, String desc){
        this.id = id;
        this.desc = desc;
    }
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public long getId() {
        return id;
    }
    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Get the value of desc
     *
     * @return the value of desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * Set the value of desc
     *
     * @param desc new value of desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
