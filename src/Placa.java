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
public class Placa {
    private String codigo;
    private String estado;
    
    public Placa(String codigo, String estado){
        boolean retorno = true;
        String aux = "";
        for (int i = 0; ((i < 3) && retorno); i++) {
            char x = codigo.charAt(i);
            if((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')){
                aux += x;
                retorno = true;
            }
            else
                retorno = false;
        }
        int index = 3;
        int tam = 7;
        if(codigo.charAt(3) == '-'){
            index = 4;
            tam = 8;
        }
        if(tam != codigo.length())
            retorno = false;
        for (int i = index; ((i < tam) && retorno ); i++) {
            if(Character.isDigit(codigo.charAt(i))){
                aux += codigo.charAt(i);
                retorno = true;
            }
            else
                retorno = false;
        }
        if(retorno)
            this.codigo = aux.toUpperCase();
        else
            this.codigo = null;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
