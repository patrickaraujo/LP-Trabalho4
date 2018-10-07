/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indentificaplacatest;

/**
 *
 * @author arauj
 */
public class Estados {
    private String UF;
    private String de;
    private String ate;

    public Estados(String UF, String de, String ate){
        this.UF = UF;
        this.de = de;
        this.ate = ate;
    }

    public String getUF() {
        return UF;
    }

    public String getDe() {
        return de;
    }

    public String getAte() {
        return ate;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setAte(String ate) {
        this.ate = ate;
    }
    
    
}
